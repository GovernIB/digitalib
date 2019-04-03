package es.caib.digitalib.back.controller.scanwebsimple.v1;


import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.pluginsib.core.utils.Base64;
import org.jboss.web.tomcat.security.login.WebAuthentication;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.ejb.UsuariAplicacioLocal;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.model.entity.UsuariAplicacio;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;


/**
 * 
 * @author anadal
 *
 */
public class RestUtils {

  protected final Logger log = Logger.getLogger(getClass());
  
  protected final ThreadLocal<UsuariAplicacioJPA> usuariAplicacioCache = new ThreadLocal<UsuariAplicacioJPA>();
  
  
  public HttpHeaders addAccessControllAllowOrigin() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", "*");
    return headers;
  }
  
  
  protected String autenticate(HttpServletRequest request, String locale, UsuariAplicacioLocal usuariAplicacioEjb) {

    try {
      String authHeader = request.getHeader(javax.ws.rs.core.HttpHeaders.AUTHORIZATION);
      if (authHeader == null || authHeader.trim().length() == 0) {
        final String msg = I18NUtils.tradueix("autenticacio.capsalera.no");
        log.warn(" XYZ ZZZ autenticate:: " + msg);
        return msg;
      }
      StringTokenizer st = new StringTokenizer(authHeader);
      if (!st.hasMoreTokens()) {
        final String msg = I18NUtils.tradueix("autenticacio.capsalera.buida");
        log.warn(" XYZ ZZZ autenticate:: " + msg);
        return msg;
      }
      String basic = st.nextToken();

      if (!basic.equalsIgnoreCase("Basic")) {
        final String msg = I18NUtils.tradueix("autenticacio.tipus.notsuportat", basic);
        log.warn(" XYZ ZZZ autenticate:: " + msg);
        return msg;
      }

      String credentials = new String(Base64.decode(st.nextToken()));
      log.info("XYZ ZZZ autenticate::Credentials: " + credentials);
      int p = credentials.indexOf(":");
      if (p == -1) {
        final String msg = I18NUtils.tradueix("autenticacio.credencials.format.incorrecte", credentials);
        log.warn(" XYZ ZZZ autenticate:: " + msg);
        return msg;
      }
      String username = credentials.substring(0, p).trim();
      String password = credentials.substring(p + 1).trim();

      log.info("XYZ ZZZ autenticate::username: |" + username + "|");
      //log.info("XYZ ZZZ autenticate::password: |" + password + "|");
      log.info("XYZ ZZZ autenticate:: PRE AUTENTICATE " + request.getUserPrincipal());
      
      boolean autenticat;
      //if (Configuracio.isCAIB()) 
      {
        // En entorns CAIB l'autenticació està en BBDD Seycon 
        WebAuthentication pwl = new WebAuthentication();
        autenticat = pwl.login(username, password);
      }
      /*
      else {
        // En entorns CAIB l'autenticació està en BBDD PortaFI, en la taula d'UsuarisAplicació 
        
      }
      */
      log.info("XYZ ZZZ autenticate:: POST AUTENTICATE " + request.getUserPrincipal());
      
      if (!autenticat) {
        final String msg = I18NUtils.tradueix("autenticacio.credencials.incorrecte");
        log.error(" XYZ ZZZ autenticate:: " + msg);
        return msg;
      }

        log.info(" XYZ ZZZ autenticate::  LOGIN OK OK  OK  OK  OK OK ");
        
       
        
        List<UsuariAplicacio> usuariAplicacioList;
        try {
          usuariAplicacioList = usuariAplicacioEjb.select(UsuariAplicacioFields.USERNAME.equal(username));
        } catch (I18NException e) {
          // XYZ ZZZ Idioma ????
          String msg = I18NUtils.tradueix("autenticacio.error.consulta.usuariapp", username) 
              + I18NLogicUtils.getMessage(e, new Locale(locale));
          log.error(msg,e);

          return msg;
        }
        
        
        if (usuariAplicacioList == null || usuariAplicacioList.size() == 0) {
          final String msg = I18NUtils.tradueix("autenticacio.usuari.noalta", username);
          log.error(" XYZ ZZZ autenticate:: " + msg);
          return msg;
        }
        
        UsuariAplicacio usuariAplicacio = usuariAplicacioList.get(0);
        
        if (!usuariAplicacio.isActiu()) {
          return I18NUtils.tradueix("autenticacio.usuari.noactiu", usuariAplicacio.getUsername());
        }
       
        Set<GrantedAuthority> seyconAuthorities = new HashSet<GrantedAuthority>();
        User user = new User(username, password, seyconAuthorities);
        
        
        // create a new authentication token for usuariAplicacio
        LoginInfo loginInfo = new LoginInfo(user, (UsuariAplicacioJPA)usuariAplicacio, seyconAuthorities);

        // and set the authentication of the current Session context
        SecurityContextHolder.getContext().setAuthentication(loginInfo.generateToken());
        
        log.info("Inicialitzada Informació de UsuariAPLicacio dins de LoginInfo");
        
        usuariAplicacioCache.set((UsuariAplicacioJPA)usuariAplicacio);
        
        
        return null; // OK

    

    } catch (Exception e) {

      final String msg = I18NUtils.tradueix("autenticacio.error.desconegut.rest") + e.getMessage();
      log.error(" XYZ ZZZ autenticate:: " + msg, e);
      return msg;
    }

   

  }
}
