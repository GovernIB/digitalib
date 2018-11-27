package es.caib.digitalib.back.controller.user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.TransaccioController;
import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.back.security.LoginInfo;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/user/transaccio")
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class TransaccioUserController extends TransaccioController {
  
  @EJB(mappedName = es.caib.digitalib.ejb.UsuariPersonaLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariPersonaLocal usuariPersonaEjb;

  @Override
  public String getTileForm() {
    return "transaccioFormUser";
  }

  @Override
  public String getTileList() {
    return "transaccioListUser";
  }


  @Override
  public String getSessionAttributeFilterForm() {
    return "TransaccioUser_FilterForm";
  }


  @Override
  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    // XYZ ZZZ Aixo s'ha de fer collint LoginINfo
    
    Long usuariPersonaID = usuariPersonaEjb.executeQueryOne(UsuariPersonaFields.USUARIPERSONAID, UsuariPersonaFields.USERNAME.equal(LoginInfo.getInstance().getUsername()));
    
    return TransaccioFields.USUARIPERSONAID.equal(usuariPersonaID);
    
    // XYZ ZZZ ABSTRATC PER TIPUS D?ESCANEIG
    
  }

  
  @Override
  public TransaccioFilterForm getTransaccioFilterForm(Integer pagina, ModelAndView mav,
      HttpServletRequest request) throws I18NException {
      TransaccioFilterForm transaccioFilterForm = super.getTransaccioFilterForm(pagina, mav, request);
      
      
      if (transaccioFilterForm.isNou()) {

        Set<Field<?>> hiddenFields = new HashSet<Field<?>>(Arrays.asList(TransaccioFields.ALL_TRANSACCIO_FIELDS));
        
        hiddenFields.remove(TransaccioFields.TRANSACTIONWEBID);
        hiddenFields.remove(TransaccioFields.DATAINICI);
        hiddenFields.remove(TransaccioFields.DATAFI);
        hiddenFields.remove(TransaccioFields.ESTATCODI);
        hiddenFields.remove(TransaccioFields.ESTATMISSATGE);
        
        hiddenFields.remove(TransaccioFields.FITXERESCANEJATID);
        hiddenFields.remove(TransaccioFields.FITXERSIGNATURAID);
        
        
        transaccioFilterForm.setHiddenFields(hiddenFields);
        
        transaccioFilterForm.setOrderBy(TransaccioFields.DATAFI.fullName);
        transaccioFilterForm.setOrderAsc(false);
        
      }
      
      return transaccioFilterForm;
  }
  
  
  @Override
  public boolean isActiveFormNew() {
    return false;
  }

  @Override
  public boolean isActiveFormEdit() {
    return false;
  }

  @Override
  public boolean isActiveDelete() {
    return false;
  }

  @Override
  public boolean isActiveFormView() {
    return true;
  }
  
  
  // XYZ ZZZ 
  
}
