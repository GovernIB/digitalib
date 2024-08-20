package es.caib.digitalib.back.controller.admin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.AuditoriaController;
import es.caib.digitalib.back.form.webdb.AuditoriaFilterForm;
import es.caib.digitalib.back.form.webdb.AuditoriaForm;
import es.caib.digitalib.persistence.AuditoriaJPA;
import es.caib.digitalib.model.entity.Auditoria;
import es.caib.digitalib.model.fields.AuditoriaFields;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal(u80067)
 *
 */
public abstract class AbstractAuditoriaAdminController extends AuditoriaController {
  

  public static final String FILTER_BY_TRANSACCIO_ID = "FILTER_BY_TRANSACCIO_ID";


  @EJB(mappedName = es.caib.digitalib.ejb.TransaccioService.JNDI_NAME)
  protected es.caib.digitalib.ejb.TransaccioService transaccioEjb;
  
  @EJB(mappedName = es.caib.digitalib.ejb.UsuariPersonaService.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariPersonaService usuariPersonaEjb;
  
  @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioService.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariAplicacioService usuariAplicacioEjb;
  
  public abstract boolean isAplicacio();
  
  public abstract boolean isFilterByTransaccio();

  @Override
  public String getTileForm() {
    return "auditoriaFormAdmin";
  }

  @Override
  public String getTileList() {
    return "auditoriaListAdmin";
  }

  @Override
  public String getSessionAttributeFilterForm() {
    return "Auditoria_" + (isAplicacio() ? "app" : "person") +  "_"  
       + (isFilterByTransaccio()?"filtered":"nonfiltered")+ "_FilterForm";
  }

  @Override
  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    Where w = ISAPP.equal(isAplicacio());

    if (isFilterByTransaccio()) {
      return Where.AND(w,
          AuditoriaFields.TRANSACCIOID.equal((Long)request.getSession().getAttribute(FILTER_BY_TRANSACCIO_ID)));
    } else {
      return w;
    }
  }
  
  
  @Override
  public AuditoriaForm getAuditoriaForm(AuditoriaJPA _jpa,
      boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
   AuditoriaForm auditoriaForm = super.getAuditoriaForm(_jpa, __isView, request, mav);
   
   auditoriaForm.addHiddenField(AUDITORIAID);
   auditoriaForm.addHiddenField(ISAPP);

   Auditoria auditoria = auditoriaForm.getAuditoria();
   
   Long c = transaccioEjb.count(TransaccioFields.TRANSACCIOID.equal(auditoria.getTransaccioId()));

   if (c == null || c == 0) {
     HtmlUtils.saveMessageInfo(request, I18NUtils.tradueix("auditoria.transaccio.esborrada"));
   } else {
     String baseUrl;
     if (auditoriaForm.getAuditoria().isIsApp()) {
       baseUrl = "/admin/transaccioaplicacio/view/";
     } else {
       baseUrl = "/admin/transacciopersona/view/";
     }

     auditoriaForm.addAdditionalButton(new AdditionalButton(
         IconUtils.getWhite(IconUtils.ICON_INFO), // IconUtils.getWhite(IconUtils.ICON_INFO),
         "auditoria.veuretransaccio",
         baseUrl +auditoria.getTransaccioId() , AdditionalButtonStyle.INFO));
   }

   if (auditoria.getUsernameAplicacio() != null) {
     Long uaID = usuariAplicacioEjb.executeQueryOne(UsuariAplicacioFields.USUARIAPLICACIOID,
         UsuariAplicacioFields.USERNAME.equal(auditoria.getUsernameAplicacio()));
     if (uaID == null) {
       HtmlUtils.saveMessageInfo(request, I18NUtils.tradueix("auditoria.usuari.aplicacio.esborrat"));
     } else {
       auditoriaForm.addAdditionalButton(new AdditionalButton(
               IconUtils.getWhite(IconUtils.ICON_INFO), // IconUtils.getWhite(IconUtils.ICON_INFO)
               UsuariAplicacioFields._TABLE_TRANSLATION,
           "/admin/usuariAplicacio/view/" + uaID , AdditionalButtonStyle.INFO));
     }
   }
   
   
   if (auditoria.getUsernamePersona() != null) {
     Long uaID = usuariPersonaEjb.executeQueryOne(UsuariPersonaFields.USUARIPERSONAID,
         UsuariPersonaFields.USERNAME.equal(auditoria.getUsernamePersona()));
     if (uaID == null) {
       HtmlUtils.saveMessageInfo(request, I18NUtils.tradueix("auditoria.usuari.persona.esborrat"));
     } else {
       auditoriaForm.addAdditionalButton(new AdditionalButton(
               IconUtils.getWhite(IconUtils.ICON_INFO), // IconUtils.getWhite(IconUtils.ICON_INFO),
               UsuariPersonaFields._TABLE_TRANSLATION,
           "/admin/usuariPersona/view/" + uaID  , AdditionalButtonStyle.INFO));
     }
   }

   return auditoriaForm;
  }
  
  
  
  @Override
  public AuditoriaFilterForm getAuditoriaFilterForm(Integer pagina, ModelAndView mav,
      HttpServletRequest request) throws I18NException {
      AuditoriaFilterForm auditoriaFilterForm = super.getAuditoriaFilterForm(pagina, mav, request);
      
      if (auditoriaFilterForm.isNou()) {

        Set<Field<?>> hiddenFields = new HashSet<Field<?>>(Arrays.asList(AuditoriaFields.ALL_AUDITORIA_FIELDS));

        hiddenFields.remove(DATA);
        hiddenFields.remove(TIPUS);
        hiddenFields.remove(MISSATGE);
        if (isAplicacio()) {
          hiddenFields.remove(USERNAMEAPLICACIO);
        }
        hiddenFields.remove(USERNAMEPERSONA);
        hiddenFields.remove(TRANSACCIOID);

        auditoriaFilterForm.setHiddenFields(hiddenFields);

        auditoriaFilterForm.addAdditionalButtonForEachItem(new AdditionalButton(
                IconUtils.getWhite(IconUtils.ICON_INFO), // IconUtils.getWhite(IconUtils.ICON_INFO),
                 "genapp.viewtitle",
            getContextWeb()  + "/view/{0}" , AdditionalButtonStyle.INFO));
        
        auditoriaFilterForm.setDeleteButtonVisible(false);
        auditoriaFilterForm.setAddButtonVisible(false);
        auditoriaFilterForm.setEditButtonVisible(false);
        auditoriaFilterForm.setDeleteSelectedButtonVisible(false);
        auditoriaFilterForm.setVisibleMultipleSelection(false);
        
        auditoriaFilterForm.setOrderBy(AuditoriaFields.DATA.javaName);
        if (isFilterByTransaccio()) {
          auditoriaFilterForm.setOrderAsc(true);
        } else {
          auditoriaFilterForm.setOrderAsc(false);
        }
        
      }
      
      if (isFilterByTransaccio()) {
         auditoriaFilterForm.setTitleCode("auditoria.title.list");
         auditoriaFilterForm.setTitleParam(String.valueOf(request.getSession().getAttribute(FILTER_BY_TRANSACCIO_ID)));
      }
      
      
      return auditoriaFilterForm;
  }
  
  
  @Override
  public boolean isActiveList() {
    return true;
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
  
  @Override
  public List<StringKeyValue> getReferenceListForTipus(HttpServletRequest request,
      ModelAndView mav, Where where)  throws I18NException {
   List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
   __tmp.add(new StringKeyValue(String.valueOf(Constants.AUDIT_TYPE_ANY_ACTION_OVER_TRANSACTION) , I18NUtils.tradueix("auditoria.tipus."+Constants.AUDIT_TYPE_ANY_ACTION_OVER_TRANSACTION)));
   __tmp.add(new StringKeyValue(String.valueOf(Constants.AUDIT_TYPE_CREATE_TRANSACTION), I18NUtils.tradueix("auditoria.tipus."+Constants.AUDIT_TYPE_CREATE_TRANSACTION)));
   __tmp.add(new StringKeyValue(String.valueOf(Constants.AUDIT_TYPE_FINISH_INSERT_DATA), I18NUtils.tradueix("auditoria.tipus."+Constants.AUDIT_TYPE_FINISH_INSERT_DATA)));
   __tmp.add(new StringKeyValue(String.valueOf(Constants.AUDIT_TYPE_FINISH_SCAN), I18NUtils.tradueix("auditoria.tipus."+Constants.AUDIT_TYPE_FINISH_SCAN)));
   
   __tmp.add(new StringKeyValue(String.valueOf(Constants.AUDIT_TYPE_SIGN_INFO), I18NUtils.tradueix("auditoria.tipus."+Constants.AUDIT_TYPE_SIGN_INFO)));
   __tmp.add(new StringKeyValue(String.valueOf(Constants.AUDIT_TYPE_CUSTODY_INFO), I18NUtils.tradueix("auditoria.tipus."+Constants.AUDIT_TYPE_CUSTODY_INFO)));
   __tmp.add(new StringKeyValue(String.valueOf(Constants.AUDIT_TYPE_END_TRANSACITION), I18NUtils.tradueix("auditoria.tipus."+Constants.AUDIT_TYPE_END_TRANSACITION)));

   __tmp.add(new StringKeyValue(String.valueOf(Constants.AUDIT_TYPE_CANCEL_USER), I18NUtils.tradueix("auditoria.tipus."+Constants.AUDIT_TYPE_CANCEL_USER)));

   __tmp.add(new StringKeyValue(String.valueOf(Constants.AUDIT_TYPE_DELETE_TRANSACTION), I18NUtils.tradueix("auditoria.tipus."+Constants.AUDIT_TYPE_DELETE_TRANSACTION)));

   return __tmp;
 }
  
  
  
  
  @RequestMapping(value = "/t/{transaccioID}")
  public String filtrarPerTransaccio(@PathVariable("transaccioID") java.lang.Long transaccioID,
      HttpServletRequest request,HttpServletResponse response) {
    
    if (!isFilterByTransaccio()) {
      log.error("S'ha cridat al mètode filtrarPerTransaccio però aquest Controller no serveix per filtrar");
    }

    request.getSession().setAttribute(FILTER_BY_TRANSACCIO_ID, transaccioID);
    
    return "redirect:" + getContextWeb() + "/list";

  }
  

}
