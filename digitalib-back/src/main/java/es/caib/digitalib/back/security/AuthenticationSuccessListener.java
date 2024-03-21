package es.caib.digitalib.back.security;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NArgumentString;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.pluginsib.userinformation.IUserInformationPlugin;
import org.fundaciobit.pluginsib.userinformation.UserInfo;
import org.fundaciobit.pluginsib.utils.templateengine.TemplateEngine;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import es.caib.digitalib.persistence.UsuariPersonaJPA;
import es.caib.digitalib.logic.UsuariPersonaLogicaService;
import es.caib.digitalib.logic.utils.DigitalIBPluginsManager;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal
 * 
 */
@Component
public class AuthenticationSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    protected final Logger log = Logger.getLogger(getClass());

    @Override
    public synchronized void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {

        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication au = sc.getAuthentication();

        if (au == null) {
            // TODO traduccio
            throw new LoginException("NO PUC ACCEDIR A LA INFORMACIO de AUTENTICACIO");
        }

        final boolean isDebug = log.isDebugEnabled();

        User user = (User) au.getPrincipal();

        String username = user.getUsername();
        log.info(" =================================================================");
        log.info(" ============ Login Usuari: " + username);

        // Cercam si té el ROLE_USER o ROLE_ADMIN
        Collection<GrantedAuthority> seyconAuthorities = user.getAuthorities();
        boolean containsRoleUser = false;
        boolean containsRoleAdmin = false;
        for (GrantedAuthority grantedAuthority : seyconAuthorities) {
            String rol = grantedAuthority.getAuthority();
            log.info("Rol SEYCON : " + rol);
            if (Constants.ROLE_USER.equals(rol)) {
                containsRoleUser = true;
            }
            if (Constants.ROLE_ADMIN.equals(rol)) {
                containsRoleAdmin = true;
            }
        }

        UsuariPersonaJPA usuariPersona;
        try {
            UsuariPersonaLogicaService usuariPersonaEjb = null;
            usuariPersonaEjb = getUsuariPersonaEJB();

            usuariPersona = usuariPersonaEjb.findByUsernameFull(username);

        } catch (Throwable e) {
            // TODO traduccio
            throw new LoginException("No puc accedir al gestor d´obtenció de" + " informació de usuari per " + username
                    + ": " + e.getMessage(), e);
        }

        boolean necesitaConfigurar = false;

        // Si és CAIB, sense rol no feim res 
        boolean potEntrar = true;
        if (Configuracio.isCAIB()) {
            if (!containsRoleUser && !containsRoleAdmin) {
                potEntrar = false;
            }
        }
        if (usuariPersona == null && potEntrar) {
            // Revisar si és un Administrador que entra per primera vegada
            // if (isDebug) {
            // log.debug("Configuracio.getDefaultEntity() = ]" +
            // PropietatGlobalUtil.getDefaultEntity() + "[");
            // }
            // if (containsRoleAdmin) { // || Configuracio.isCAIB() ||
            // PropietatGlobalUtil.getDefaultEntity() != null) {
            try {
                IUserInformationPlugin plugin = DigitalIBPluginsManager.getUserInformationPluginInstance();
                UserInfo info = plugin.getUserInfoByUserName(username);
                if (info != null) {
                    usuariPersona = new UsuariPersonaJPA();
                    usuariPersona.setEmail(info.getEmail() == null ? Configuracio.getAppEmail() : info.getEmail());
                    usuariPersona.setIdiomaID(Configuracio.getDefaultLanguage());
                    final String nom, llinatges;
                    {
                        String nomTmp = info.getName() == null ? username : info.getName();

                        String llinatgesTmp = (info.getSurname1() == null ? "" : info.getSurname1())
                                + (info.getSurname2() == null ? "" : (" " + info.getSurname2()));
                        llinatgesTmp = llinatgesTmp.trim();

                        if (llinatgesTmp.length() == 0) {
                            // Miram si podem xapar el nom
                            int pos = nomTmp.indexOf(' ');
                            if (pos == -1) {
                                nom = nomTmp;
                                llinatges = username;
                            } else {
                                nom = nomTmp.substring(0, pos);
                                llinatges = nomTmp.substring(pos).trim();
                            }
                        } else {
                            nom = nomTmp;
                            llinatges = llinatgesTmp;
                        }
                    }
                    usuariPersona.setNom(nom);
                    usuariPersona.setLlinatges(llinatges);

                    usuariPersona.setUsername(username);
                    usuariPersona.setNif(info.getAdministrationID().toUpperCase());

                    Map<String, Object> parameters = new HashMap<String, Object>();

                    parameters.put("userinfo", info);

                    String grupPerDefecte = Configuracio.getConfiguracioGrupPerDefecteEL();

                    log.info("getConfiguracioGrupPerDefecteEL(): ]" + grupPerDefecte + "[");

                    boolean adjustRolesToConfgrup = false;

                    if (grupPerDefecte != null && !grupPerDefecte.isEmpty()) {

                        String confIDStr = TemplateEngine.processExpressionLanguage(grupPerDefecte, parameters);

                        log.info("PLANTILLA VALOR: ]" + confIDStr + "[");

                        try {
                            Long confID = Long.parseLong(confIDStr);
                            usuariPersona.setConfiguracioGrupID(confID);
                            // Fa check si la configuracioGrup amb ID confID existeix i 
                            // sincronitza roles d'usuari amb perfils de configuraciogrup
                            adjustRolesToConfgrup = true;

                        } catch (NumberFormatException nfe) {
                        }

                    }

                    necesitaConfigurar = true;

                    usuariPersona = getUsuariPersonaEJB().createFull(usuariPersona, adjustRolesToConfgrup);

                    if (isDebug) {
                        log.debug("necesitaConfigurarUsuari = " + necesitaConfigurar);
                    }

                }

            } catch (Throwable e) {
                usuariPersona = null;
                String msg;
                if (e instanceof I18NException) {
                    msg = I18NUtils.getMessage((I18NException) e);
                } else if (e instanceof I18NValidationException) {
                    msg = I18NUtils.getMessage((I18NValidationException) e);
                } else {
                    msg = e.getMessage();
                }

                log.error("Error llegint informació del plugin de Login: " + msg, e);
                return;
            }
            // }

            /*
             * if (usuariPersona == null) {
             * 
             * // ======================================================= // Revisar si és un
             * Usuari-Aplicació que ataca via REST //
             * =======================================================
             * 
             * HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.
             * currentRequestAttributes()). getRequest();
             * 
             * // TODO Mirar Classe
             * es.caib.portafib.back.controller.apifirmawebsimple.v1.RestApiFirmaWebSimpleV1Controller
             * // CONTEXT = /common/rest/apifirmawebsimple/v1 => ServletPath String servletPath =
             * request.getServletPath(); boolean found = false;
             * 
             * for (String baseServletPath : allowedApplicationContexts) { if
             * (servletPath.startsWith(baseServletPath)) { log.info("TROBADA BASE AUTORITZADA " +
             * baseServletPath + " per RUTA " + servletPath); found = true; break; } }
             * 
             * if (!found) {
             * 
             * log.info(" +++++++++++++++++ SERVLET REQUEST INFO ++++++++++++++++++++++\n");
             * log.info(" ++++ Scheme: " + request.getScheme() + "\n"); log.info(" ++++ ServerName: "
             * + request.getServerName() + "\n"); log.info(" ++++ ServerPort: " +
             * request.getServerPort() + "\n"); log.info(" ++++ PathInfo: " + request.getPathInfo() +
             * "\n"); log.info(" ++++ PathTrans: " + request.getPathTranslated() + "\n");
             * log.info(" ++++ ContextPath: " + request.getContextPath() + "\n");
             * log.info(" ++++ ServletPath: " + request.getServletPath() + "\n");
             * log.info(" ++++ getRequestURI: " + request.getRequestURI() + "\n");
             * log.info(" ++++ getRequestURL: " + request.getRequestURL() + "\n");
             * log.info(" ++++ getQueryString: " + request.getQueryString() + "\n");
             * log.info(" ++++ javax.servlet.forward.request_uri: " + (String)
             * request.getAttribute("javax.servlet.forward.request_uri") + "\n");
             * log.info(" ===============================================================");
             * 
             * 
             * // XYZ ZZZ Traduir throw new
             * LoginException("Esta intentant accedir a una zona no permesa amb un usuari aplicació"
             * ); }
             * 
             * 
             * 
             * UsuariAplicacioLogicaService usuariAplicacioEjb = null; try { usuariAplicacioEjb =
             * EjbManager.getUsuariAplicacioLogicaEJB(); } catch (Throwable e) { // TODO traduccio
             * throw new LoginException("No puc accedir al gestor d´obtenció de" +
             * " informació de usuari-aplicacio per " + name + ": " + e.getMessage(), e); }
             * 
             * 
             * UsuariAplicacioJPA usuariAplicacio = usuariAplicacioEjb.findByPrimaryKeyFull(name); if
             * (usuariAplicacio == null) { throw new LoginException("L'usuari " + name +
             * " està autenticat però no s'ha donat d'alta en el PortaFIB "); }
             * 
             * 
             * EntitatJPA entitat = usuariAplicacio.getEntitat(); // Check deshabilitada if
             * (!entitat.isActiva()) { throw new LoginException("L'entitat " + entitat.getNom() +
             * " a la que està associat l'usuari-aplicacio " + name + " esta deshabilitada."); }
             * 
             * // create a new authentication token for usuariAplicacio LoginInfo loginInfo = new
             * LoginInfo(user, usuariAplicacio, entitat, seyconAuthorities);
             * 
             * // and set the authentication of the current Session context
             * SecurityContextHolder.getContext().setAuthentication(loginInfo.generateToken());
             * 
             * log.info("Inicialitzada Informació de UsuariAPLicacio dins de LoginInfo");
             * 
             * return;
             * 
             * }
             */

        }

        /*
         * if (!containsRoleUser && usuariEntitats.size() != 0) { // L'usuari " + name + " està
         * assignat a una o varies // entitats però no té el rol PFI_USER"; I18NTranslation
         * translation = new I18NTranslation("error.sensepfiuser", username); log.error("");
         * log.error(I18NUtils.tradueix(translation)); log.error("Authenntication Info:\n" + au);
         * log.error("");
         * 
         * // Com enviar-ho a la PAGINA WEB BasePreparer.loginErrorMessage.put(username,
         * translation);
         * 
         * usuariEntitats = new HashSet<UsuariEntitatJPA>(); }
         */

        // Seleccionam l'entitat per defecte i verificam que les entitats disponibles siguin
        // correctes

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();

        roles.addAll(seyconAuthorities);

        // Cercam Rols Virtuals ROLE_USER de DigitalIB
        if (containsRoleUser) {

            if (usuariPersona.isRoleScan()) {
                roles.add(new SimpleGrantedAuthority(Constants.ROLE_SCAN));
            }

            if (usuariPersona.isRoleCoAu()) {
                roles.add(new SimpleGrantedAuthority(Constants.ROLE_COAU));
            }

            if (usuariPersona.isRoleCust()) {
                roles.add(new SimpleGrantedAuthority(Constants.ROLE_CUST));
            }

            /*
             * if ()
             * 
             * isRoleCust
             * 
             * boolean usuariAplicacioPerPerticionsIsNull = (entitat.getUsuariAplicacioID() == null);
             * for (RoleUsuariEntitat roleUsuariEntitat : rolesEntitat) { String roleName =
             * roleUsuariEntitat.getRoleID(); if (usuariAplicacioPerPerticionsIsNull &&
             * ConstantsV2.ROLE_SOLI.equals(roleName) ) { log.warn("No afegim el role " + roleName +
             * " ja que aquesta entitat no té definit " +
             * " usuariAplicacio per les peticions de firma dels usuaris."); } else if
             * (ConstantsV2.ROLE_ADMIN.equals(roleName)) { // TODO enviar un correu a l'administrador
             * del sistema log.warn("Error de seguretat: L'usuari " + username +
             * " té el role virtual " + ConstantsV2.ROLE_ADMIN +
             * " però aquest rol s'ha d'obtenir dels rols de JBOSS." +
             * " Eliminar aquest rol de la BBDD !!!!!", new Exception() ); } else { if (isDebug) {
             * log.debug("Afegint role portafib " + roleName); } rolesPortaFIB.add(new
             * SimpleGrantedAuthority(roleName)); } } rolesPerEntitat.put(entitatID, rolesPortaFIB);
             */
        } else {
            log.debug("No te el role seycon DIB_USER");
        }

        /*
         * LoginInfo loginInfo; // create a new authentication token loginInfo = new
         * LoginInfo(user, usuariPersona, entitatIDActual, entitats, rolesPerEntitat,
         * usuariEntitatPerEntitatID, necesitaConfigurar);
         * 
         * // and set the authentication of the current Session context
         * SecurityContextHolder.getContext().setAuthentication(loginInfo.generateToken());
         * 
         * if (isDebug) { log.debug(">>>>>> Final del Process d'autenticació."); }
         * log.debug(" =================================================================");
         */

        // create a new authentication token
        LoginInfo loginInfo;
        loginInfo = new LoginInfo(user, usuariPersona, roles, necesitaConfigurar);

        // and set the authentication of the current Session context
        SecurityContextHolder.getContext().setAuthentication(loginInfo.generateToken());

        /*
         * // TODO GenApp Afegir el codi oportu despres del login
         * 
         * LoginInfo loginInfo;
         * 
         * 
         * // XYZ ZZZ ZZZ FALTA !!!! UsuariPersonaJPA usrPersona = null; // XYZ ZZZ ZZZ FALTA !!!!
         * boolean needConfigUser = false;
         * 
         * // create a new authentication token loginInfo = new LoginInfo(user, usrPersona, new
         * HashSet<GrantedAuthority>(seyconAuthorities), needConfigUser);
         * 
         * // and set the authentication of the current Session context
         * SecurityContextHolder.getContext().setAuthentication(loginInfo.generateToken());
         * 
         * 
         * log.info(">>>>>> Final del Process d'autenticació.");
         * log.info(" =================================================================");
         */

    }

    protected static UsuariPersonaLogicaService usuariPersonaLogicaEjb;

    public static UsuariPersonaLogicaService getUsuariPersonaEJB() throws I18NException {

        if (usuariPersonaLogicaEjb == null) {
            try {
                usuariPersonaLogicaEjb = (UsuariPersonaLogicaService) new InitialContext()
                        .lookup(UsuariPersonaLogicaService.JNDI_NAME);
            } catch (Throwable e) {

                throw new I18NException(e, "error.unknown", new I18NArgumentString(
                        "No puc instanciar " + "UsuariPersonaLogicaLocal" + ": " + e.getMessage()));
            }
        }
        return usuariPersonaLogicaEjb;
    }

    public static final Comparator<GrantedAuthority> GRANTEDAUTHORITYCOMPARATOR = new Comparator<GrantedAuthority>() {
        @Override
        public int compare(GrantedAuthority o1, GrantedAuthority o2) {
            return -o1.getAuthority().compareTo(o2.getAuthority());
        }
    };

}
