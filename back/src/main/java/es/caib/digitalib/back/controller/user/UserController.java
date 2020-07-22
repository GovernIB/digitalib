package es.caib.digitalib.back.controller.user;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.jpa.AvisJPA;
import es.caib.digitalib.jpa.ConfiguracioGrupJPA;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.logic.ConfiguracioGrupLogicaLocal;
import es.caib.digitalib.model.entity.Avis;
import es.caib.digitalib.model.fields.AvisFields;
import es.caib.digitalib.utils.Constants;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {
  
  protected final Logger log = Logger.getLogger(getClass());
  
  
  @EJB(mappedName = ConfiguracioGrupLogicaLocal.JNDI_NAME)
  protected ConfiguracioGrupLogicaLocal configuracioGrupLogicaEjb;
  
  
  @EJB(mappedName = es.caib.digitalib.ejb.AvisLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.AvisLocal avisEjb;

  @RequestMapping(value = "/llistatperfilsdisponibles")
  public ModelAndView llistatPerfilsDisponibles(HttpSession session, HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    UsuariPersonaJPA up = LoginInfo.getInstance().getUsuariPersona();
    ConfiguracioGrupJPA conf;
    if (up.getConfiguracioGrupID() == null) {
      conf = null;
    } else {
      try {
        conf = configuracioGrupLogicaEjb.findByPrimaryKeyFull(up.getConfiguracioGrupID());
      } catch (I18NException e) {
        // XYZ ZZZ
        conf = null;
        e.printStackTrace();
      } catch (NullPointerException e) {
        conf = null;
        e.printStackTrace();
      }
    }

    if (conf == null) {

      HtmlUtils
          .saveMessageError(
              request,
              I18NUtils.tradueix("scanwebget.usuari.nogrup"));

    } else if (conf.getPerfilCopiaAutenticaID() == null
        && conf.getPerfilNomesEscaneigID() == null && conf.getPerfilCustodiaID() == null
        && conf.getPerfilCopiaAutentica2ID() == null
        && conf.getPerfilNomesEscaneig2ID() == null && conf.getPerfilCustodia2ID() == null) {

      HtmlUtils
          .saveMessageError(
              request,
              I18NUtils.tradueix("usercontroller.grup.perfilscan.no"));

    } else {
      
//      log.info("XYZ ZZZ ");
//      log.info("XYZ ZZZ conf.getPerfilNomesEscaneigID() != null " + (conf.getPerfilNomesEscaneigID() != null));
//      log.info("XYZ ZZZ LoginInfo.hasRole(Constants.ROLE_SCAN) " + (LoginInfo.hasRole(Constants.ROLE_SCAN)));
//      log.info("XYZ ZZZ ====================");
//      log.info("XYZ ZZZ conf.getPerfilCopiaAutenticaID() != null " + (conf.getPerfilCopiaAutenticaID() != null));
//      log.info("XYZ ZZZ LoginInfo.hasRole(Constants.ROLE_COAU) " + (LoginInfo.hasRole(Constants.ROLE_COAU)));
//      log.info("XYZ ZZZ ====================");
//      log.info("XYZ ZZZ conf.getPerfilCustodiaID() != null " + (conf.getPerfilCustodiaID() != null));
//      log.info("XYZ ZZZ LoginInfo.hasRole(Constants.ROLE_CUST) " + (LoginInfo.hasRole(Constants.ROLE_CUST)));
//      log.info("XYZ ZZZ ");
      
      
      
      
      if (((conf.getPerfilNomesEscaneigID() != null || conf.getPerfilNomesEscaneig2ID() != null) && LoginInfo.hasRole(Constants.ROLE_SCAN))
          || ((conf.getPerfilCopiaAutenticaID() != null || conf.getPerfilCopiaAutentica2ID() != null ) && LoginInfo.hasRole(Constants.ROLE_COAU))
          || ((conf.getPerfilCustodiaID() != null || conf.getPerfilCustodia2ID() != null) && LoginInfo.hasRole(Constants.ROLE_CUST))) {
        // OK
      } else {
            HtmlUtils
              .saveMessageError(
                  request,
                  I18NUtils.tradueix("usercontroller.perfilscan.permisos.no"));
      }
    }

    ModelAndView mav = new ModelAndView("llistatperfilsdisponibles");
    
    
    {
      List<Avis> avisos;
      final Timestamp now = new Timestamp(System.currentTimeMillis());
      Where w0 = Where.AND(AvisFields.DATAINICI.isNull(),AvisFields.DATAFI.isNull());
      Where w1 = Where.AND(AvisFields.DATAINICI.isNull(),AvisFields.DATAFI.greaterThan(now));
      Where w2 = Where.AND(AvisFields.DATAINICI.lessThan(now),AvisFields.DATAFI.isNull());
      Where w3 = Where.AND(AvisFields.DATAINICI.lessThan(now),AvisFields.DATAFI.greaterThan(now));

      
      Where w = Where.OR(w0,w1,w2,w3);
      
      if (conf != null) {
        
        
        w = Where.AND(w, Where.OR(AvisFields.CONFIGGRUPID.equal(conf.getConfiguracioGrupID()), AvisFields.CONFIGGRUPID.isNull()));
        
      }
      try {
        avisos = avisEjb.select(w);
        
        
        for (Avis avis : avisos) {
          
          // XYZ ZZZ 
          String msg = ((AvisJPA)avis).getDescripcio().getTraduccio(LocaleContextHolder.getLocale().getLanguage()).getValor();
          

          
          switch(avis.getTipus()) {
            
            
            case 2:
              HtmlUtils.saveMessageInfo(request, I18NUtils.tradueix("avis.tipus.2") + ": " + msg );
            break;
            
            case 1:
              HtmlUtils.saveMessageWarning(request, I18NUtils.tradueix("avis.tipus.1") + ": " + msg );
            break;

            case 0:
            default:
              HtmlUtils.saveMessageError(request, I18NUtils.tradueix("avis.tipus.0") + ": " + msg);
            
            
          }
          
          if (avis.isBloquejar()) {
            conf = null;
          }

        }
        
        
        
        
      } catch (I18NException e) {
        // XYZ ZZZ
        conf = null;
        e.printStackTrace();
        avisos = null;
      } 
    }
    
    
    if (conf != null) {
      mav.addObject("configuracioGrup", conf);
      
    }
    
    // mav.addObject("optionNumber", "OPCIÓ USER -1-");
    return mav;

  }

}
