package es.caib.digitalib.back.security;

import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.persistence.UsuariAplicacioJPA;
import es.caib.digitalib.persistence.UsuariPersonaJPA;

/**
 * Informació disponible durant el cicle de vida de l'aplicació en la Sessio HTTP. Veure
 * BasePreparer
 * 
 * @author anadal
 * 
 */
public class LoginInfo {

  final User springSecurityUser;

  Set<String> roles;

  Set<GrantedAuthority> grantedAuthorities;

  final String username;

  final UsuariAplicacioJPA usuariAplicacio;

  final UsuariPersonaJPA usuariPersona;

  boolean needConfigUser;

  /**
   * @param usuari
   * @param entitatActual
   * @param roles
   */
  public LoginInfo(User springSecurityUser, UsuariPersonaJPA usuariPersona,
      Set<GrantedAuthority> grantedAuthorities, boolean needConfigUser) {
    this.springSecurityUser = springSecurityUser;
    this.usuariPersona = usuariPersona;
    this.grantedAuthorities = grantedAuthorities;
    this.needConfigUser = needConfigUser;
    username = springSecurityUser.getUsername();

    // Només per usuari Aplicacio
    this.usuariAplicacio = null;
  }

  /**
   * Login per usuari aplicacio
   * 
   * @param springSecurityUser
   * @param usuariAplicacio
   * @param entitat
   * @param roles
   */
  public LoginInfo(User springSecurityUser, UsuariAplicacioJPA usuariAplicacio,
      Set<GrantedAuthority> roles) {
    this.springSecurityUser = springSecurityUser;

    this.grantedAuthorities = roles;
    username = springSecurityUser.getUsername();

    this.usuariAplicacio = usuariAplicacio;

    // Només per usuari-entitat
    this.usuariPersona = null;
    this.needConfigUser = false;

  }
  
  
  public String getLanguage() {
     if  (this.usuariPersona == null) {
         return Configuracio.getDefaultLanguage();
     } else {
         return this.usuariPersona.getIdiomaID();
     }
  }

  public UsuariPersonaJPA getUsuariPersona() {
    return usuariPersona;
  }

  public Set<GrantedAuthority> getRoles() {
    return this.grantedAuthorities;
  }

  public static boolean hasRole(String role) {
    Set<GrantedAuthority> rols = LoginInfo.getInstance().getRoles();

    for (GrantedAuthority grantedAuthority : rols) {
      if (grantedAuthority.getAuthority().equals(role)) {
        return true;
      }
    }
    return false;
  }

  public UsuariAplicacioJPA getUsuariAplicacio() {
    return usuariAplicacio;
  }

  public boolean getNeedConfigUser() {
    return needConfigUser;
  }

  public void setNeedConfigUser(boolean needConfigUser) {
    this.needConfigUser = needConfigUser;
  }

  public User getSpringSecurityUser() {
    return springSecurityUser;
  }

  public Set<GrantedAuthority> getGrantedAuthorities() {
    return grantedAuthorities;
  }

  public String getUsername() {
    return username;
  }

  public UsernamePasswordAuthenticationToken generateToken() {
    UsernamePasswordAuthenticationToken authToken;
    Set<GrantedAuthority> roles = getRoles();
    /*
     * Set<GrantedAuthority> roles; if (this.entitatIDActual == null) { roles = new
     * HashSet<GrantedAuthority>(); roles.add(new
     * SimpleGrantedAuthority(Constants.ROLE_ADMIN)); } else { roles = getRoles(); }
     */
    authToken = new UsernamePasswordAuthenticationToken(this.springSecurityUser, "", roles);
    authToken.setDetails(this);
    return authToken;
  }

  public static LoginInfo getInstance() throws LoginException {
    Object obj;
    try {
      obj = SecurityContextHolder.getContext().getAuthentication().getDetails();
    } catch (Exception e) {
      // TODO traduccio
      throw new LoginException("Error intentant obtenir informació de Login.", e);
    }

    if (obj == null) {
      // TODO traduccio
      throw new LoginException("La informació de Login és buida");
    }

    if (obj instanceof LoginInfo) {
      return (LoginInfo) obj;
    } else {
      // TODO traduccio
      throw new LoginException("La informació de Login no és del tipus esperat."
          + " Hauria de ser de tipus " + LoginInfo.class.getName() + " i és del tipus "
          + obj.getClass().getName());
    }
  }
}
