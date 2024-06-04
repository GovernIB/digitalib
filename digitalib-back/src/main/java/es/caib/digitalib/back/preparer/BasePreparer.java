package es.caib.digitalib.back.preparer;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.security.RunAs;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;

import es.caib.digitalib.ejb.IdiomaService;
import es.caib.digitalib.ejb.InfoCustodyService;
import es.caib.digitalib.ejb.TransaccioService;
import es.caib.digitalib.model.entity.Idioma;
import es.caib.digitalib.model.fields.IdiomaFields;
import es.caib.digitalib.model.fields.InfoCustodyFields;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.TransaccioQueryPath;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.commons.utils.Constants;

/**
 * @author anadal
 *
 */
@RunAs(Constants.DIB_USER)
@Component
@Controller
public class BasePreparer implements ViewPreparer, Constants, InfoCustodyFields {

    protected final Logger log = Logger.getLogger(getClass());

    protected static IdiomaService idiomaService;

    //@EJB(mappedName = es.caib.digitalib.ejb.TransaccioService.JNDI_NAME)
    protected static es.caib.digitalib.ejb.TransaccioService transaccioEjb;

    //@EJB(mappedName = es.caib.digitalib.ejb.InfoCustodyService.JNDI_NAME)
    protected static es.caib.digitalib.ejb.InfoCustodyService infoCustodyEjb;

    @Override
    public void execute(Request tilesRequest, AttributeContext attributeContext) throws PreparerException {

        Map<String, Object> request = tilesRequest.getContext("request");

        // Informació de Login
        LoginInfo loginInfo = null;
        try {
            loginInfo = LoginInfo.getInstance();
            // Posa dins la sessió la informació de Login
            request.put("loginInfo", loginInfo);
        } catch (Exception e) {
            // Anònim
        }

        // URL
        // TODO ficarho dins cache (veure Capperpare.java)
        HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        {

            request.put("urlActual", httpRequest.getServletPath());

            // Compatibilitat IE8
            String userAgent = httpRequest.getHeader("User-Agent");
            if (userAgent != null) {
                int index = userAgent.toUpperCase().indexOf("MSIE");
                if (index != -1) {
                    try {
                        String ieversion = userAgent.substring(index + 4, userAgent.indexOf(";", index + 4));
                        if (Float.parseFloat(ieversion) < 9.0f) {
                            request.put("IE8", true);
                        }
                    } catch (Throwable e) {
                        log.debug(e);
                    }
                }
            }
        }

        // Language
        Locale loc = LocaleContextHolder.getLocale();
        request.put("lang", loc.toString()); // LANG i si es necessari el country
        request.put("onlylang", loc.getLanguage()); // només el LANG

        // Pipella
        request.put("pipella", attributeContext.getAttribute("pipella"));

        // TODO GENAPP
        // Warning for each ROLE

        // Idiomes
        try {
            if (idiomaService == null) {
                idiomaService = (IdiomaService) new InitialContext().lookup(IdiomaService.JNDI_NAME);
            }

            List<Idioma> idiomes = idiomaService.select(IdiomaFields.SUPORTAT.equal(true));
            httpRequest.getSession().setAttribute("idiomes", idiomes);

        } catch (Throwable e) {
            log.error("Preparer:: Error agafant idiomes de la base de dades: " + e.getMessage(), e);
        }

        if (attributeContext.getAttribute("menu") != null) {
            request.put("menu_tile", attributeContext.getAttribute("menu").toString());
        }

        // attributeContext.putAttribute("menu", new
        // Attribute("/WEB-INF/jsp/moduls/menu_inici.jsp"));

        request.put("contingut_tile", attributeContext.getAttribute("contingut").toString());

        // Posa dins la sessió la informació de Login    
        request.put("loginInfo", loginInfo);

        // TODO GENAPP
        // Warning for each ROLE 

        // Avisos
        Map<String, Long> avisos = new HashMap<String, Long>();
        //avisos.put(rol, <<Number of warnings>>);
        request.put("avisos", avisos);

        // Mostrar o ocultar Menus de transaccions
        if (LoginInfo.hasRole(ROLE_USER)) {

            try {
                if (transaccioEjb == null) {
                    transaccioEjb = (TransaccioService) new InitialContext().lookup(TransaccioService.JNDI_NAME);
                }

                Long usuariPersonaID = LoginInfo.getInstance().getUsuariPersona().getUsuariPersonaID();

                final int[] perfils = new int[] { Constants.PERFIL_US_NOMES_ESCANEIG_INFO,
                        Constants.PERFIL_US_COPIA_AUTENTICA_INFO, Constants.PERFIL_US_CUSTODIA_INFO };

                TransaccioQueryPath tqp = new TransaccioQueryPath();

                for (int tipusPerfil : perfils) {

                    try {
                        Where w = Where.AND(TransaccioFields.USUARIPERSONAID.equal(usuariPersonaID),
                                tqp.PERFIL().USPERFIL().equal(tipusPerfil));
                       
                        Long count = transaccioEjb.count(w);

                        request.put("transaccionsuser_" + tipusPerfil, count);

                    } catch (I18NException e) {
                        log.error("Error calculant el numero de transaccions: " + I18NUtils.getMessage(e), e);
                    }
                }
            } catch (Throwable e) {
                log.error("Preparer:: Error instanciant transaccioEjb: " + e.getMessage(), e);
            }

        }

        // Mostrar Transaccions amb Expedient No Tancats
        if (LoginInfo.hasRole(ROLE_ADMIN)) {
            try {
                if (infoCustodyEjb == null) {
                    infoCustodyEjb = (InfoCustodyService) new InitialContext().lookup(InfoCustodyService.JNDI_NAME);
                }

                Long count = infoCustodyEjb.count(
                        Where.AND(ARXIUDOCUMENTID.isNotNull(), ARXIUEXPEDIENTID.isNotNull(), CUSTODYID.isNotNull()));
                if (count != null && count != 0) {
                    request.put("adminwarning", count);
                }

            } catch (I18NException e) {
                log.error("Error calculant Transaccions amb Expedient No Tancats" + I18NUtils.getMessage(e), e);
            } catch (Throwable e) {
                log.error("Preparer:: Error instanciant infoCustodyEjb: " + e.getMessage(), e);
            }

        }

    }

}
