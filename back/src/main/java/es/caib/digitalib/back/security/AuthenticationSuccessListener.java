package es.caib.digitalib.back.security;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;

import org.apache.log4j.Logger;

import es.caib.digitalib.back.security.LoginInfo;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author anadal
 * 
 */
@Component
public class AuthenticationSuccessListener implements
    ApplicationListener<InteractiveAuthenticationSuccessEvent> {

  protected final Logger log = Logger.getLogger(getClass());
   

  @Override
  public synchronized void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {

    SecurityContext sc = SecurityContextHolder.getContext();
    Authentication au = sc.getAuthentication();

    if (au == null) {
      // TODO traduccio
      throw new LoginException("NO PUC ACCEDIR A LA INFORMACIO de AUTENTICACIO");
    }

    User user = (User) au.getPrincipal();
    
    String name = user.getUsername();
    log.info(" =================================================================");
    log.info(" ============ Login Usuari: " + name);

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

    // TODO GenApp Afegir el codi oportu despres del login

    LoginInfo loginInfo;
    
    
    // XYZ ZZZ ZZZ  FALTA !!!!
    UsuariPersonaJPA usrPersona = null;
    // XYZ ZZZ ZZZ  FALTA !!!!
    boolean needConfigUser = false;
    
    // create a new authentication token
    loginInfo = new LoginInfo(user, usrPersona, new HashSet<GrantedAuthority>(seyconAuthorities), needConfigUser);

    // and set the authentication of the current Session context
    SecurityContextHolder.getContext().setAuthentication(loginInfo.generateToken());
    
    
    log.info(">>>>>> Final del Process d'autenticació.");
    log.info(" =================================================================");

  }
  
  
  
  public static final Comparator<GrantedAuthority> GRANTEDAUTHORITYCOMPARATOR = new Comparator<GrantedAuthority>() {
    @Override
    public int compare(GrantedAuthority o1, GrantedAuthority o2) {
      return -o1.getAuthority().compareTo(o2.getAuthority());
    }
  };
  
}
