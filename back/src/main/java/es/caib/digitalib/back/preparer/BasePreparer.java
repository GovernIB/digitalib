package es.caib.digitalib.back.preparer;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparerSupport;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.model.fields.InfoCustodyFields;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.TransaccioQueryPath;
import es.caib.digitalib.utils.Configuracio;
import es.caib.digitalib.utils.Constants;



/**
 * @author anadal
 *
 */
@RunAs("DIB_USER")
@Component
public class BasePreparer extends ViewPreparerSupport implements Constants, InfoCustodyFields {
  

  protected final Logger log = Logger.getLogger(getClass());
  
  @EJB(mappedName = es.caib.digitalib.ejb.TransaccioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.TransaccioLocal transaccioEjb;
  
  @EJB(mappedName = es.caib.digitalib.ejb.InfoCustodyLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.InfoCustodyLocal infoCustodyEjb;

  
	@Override
	public void execute(TilesRequestContext tilesContext, 
	    AttributeContext attributeContext) throws PreparerException {

	  Map<String, Object> request = tilesContext.getRequestScope();
	  
    // Informació de Login
    LoginInfo loginInfo = LoginInfo.getInstance();
    // Posa dins la sessió la informació de Login    
    request.put("loginInfo", loginInfo);

	  
	  
   	// URL 
	  // TODO ficarho dins cache (veure Capperpare.java)
	  Object[] requestObjects = tilesContext.getRequestObjects();
	  if (requestObjects[0] instanceof HttpServletRequest) {
	    HttpServletRequest httpRequest = (HttpServletRequest) requestObjects[0];

	    
	    request.put("urlActual", httpRequest.getServletPath());

      // Compatibilitat IE8
	    String userAgent = httpRequest.getHeader("User-Agent");
	    if (userAgent != null) {
	      int index = userAgent.toUpperCase().indexOf("MSIE");
	      if (index != -1) {
	        try {
	           String ieversion = userAgent.substring(index + 4,userAgent.indexOf(";", index + 4));
	           if (Float.parseFloat(ieversion) < 9.0f) {
	             request.put("IE8", true);
	           }
	        } catch(Throwable e) {
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
    
    // Avisos
    Map<String,Long> avisos = new HashMap<String, Long>(); 
    //avisos.put(rol, <<Number of warnings>>);
    request.put("avisos", avisos); 

    
    // Mostrar o ocultar Menus de transaccions
    if (LoginInfo.hasRole(ROLE_USER)) {
      
      Long usuariPersonaID  = LoginInfo.getInstance().getUsuariPersona().getUsuariPersonaID();
      
      final int[] perfils = new int[] {Constants.PERFIL_US_NOMES_ESCANEIG_INFO, 
          Constants.PERFIL_US_COPIA_AUTENTICA_INFO, 
          Constants.PERFIL_US_CUSTODIA_INFO};
      
      
      TransaccioQueryPath tqp = new TransaccioQueryPath();
      

      for (int tipusPerfil : perfils) {

        try {
          Where w = Where.AND(
              TransaccioFields.USUARIPERSONAID.equal(usuariPersonaID),
              tqp.PERFIL().USPERFIL().equal(tipusPerfil));
          if (Configuracio.isCAIB()) {
            w = Where.AND(TransaccioFields.ESTATCODI.equal(Constants.TRANSACCIO_ESTAT_CODI_OK), w);
          }
          Long count = transaccioEjb.count(w);
          
          request.put("transaccionsuser_" + tipusPerfil, count);
          
        } catch (I18NException e) {
          log.error("Error calculant el numero de transaccions: " + I18NUtils.getMessage(e), e);
        }
      }

      
    }
    
    // Mostrar Transaccions amb Expedient No Tancats
    if (LoginInfo.hasRole(ROLE_ADMIN)) {
        
        try {
            Long count = infoCustodyEjb.count(Where.AND(ARXIUDOCUMENTID.isNotNull(), ARXIUEXPEDIENTID.isNotNull(),
                    CUSTODYID.isNotNull()));
            if (count != null && count != 0) {
              request.put("adminwarning", count);
            }
            
        } catch (I18NException e) {
            log.error("Error calculant Transaccions amb Expedient No Tancats" + I18NUtils.getMessage(e), e);
        }
        
    }
    

    
    if (attributeContext.getAttribute("menu") != null) {
      request.put("menu_tile", attributeContext.getAttribute("menu").toString());
    }
    request.put("contingut_tile", attributeContext.getAttribute("contingut").toString());


    
	}

}
