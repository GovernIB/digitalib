package es.caib.digitalib.back.controller.webdb;

import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.GroupByItem;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.web.validation.ValidationWebUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import es.caib.digitalib.back.form.webdb.*;
import es.caib.digitalib.back.form.webdb.UsuariAplicacioForm;

import es.caib.digitalib.back.validator.webdb.UsuariAplicacioWebValidator;

import es.caib.digitalib.jpa.UsuariAplicacioJPA;
import es.caib.digitalib.model.entity.UsuariAplicacio;
import es.caib.digitalib.model.fields.*;

/**
 * Controller per gestionar un UsuariAplicacio
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/usuariAplicacio")
@SessionAttributes(types = { UsuariAplicacioForm.class, UsuariAplicacioFilterForm.class })
public class UsuariAplicacioController
    extends es.caib.digitalib.back.controller.DigitalIBBaseController<UsuariAplicacio, java.lang.Long> implements UsuariAplicacioFields {

  @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariAplicacioLocal usuariAplicacioEjb;

  @Autowired
  private UsuariAplicacioWebValidator usuariAplicacioWebValidator;

  @Autowired
  protected UsuariAplicacioRefList usuariAplicacioRefList;

  /**
   * Llistat de totes UsuariAplicacio
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    UsuariAplicacioFilterForm ff;
    ff = (UsuariAplicacioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar UsuariAplicacio de forma paginada
   */
  @RequestMapping(value = "/list/{pagina}", method = RequestMethod.GET)
  public ModelAndView llistatPaginat(HttpServletRequest request,
    HttpServletResponse response, @PathVariable Integer pagina)
      throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileList());
    llistat(mav, request, getUsuariAplicacioFilterForm(pagina, mav, request));
    return mav;
  }

  public UsuariAplicacioFilterForm getUsuariAplicacioFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    UsuariAplicacioFilterForm usuariAplicacioFilterForm;
    usuariAplicacioFilterForm = (UsuariAplicacioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(usuariAplicacioFilterForm == null) {
      usuariAplicacioFilterForm = new UsuariAplicacioFilterForm();
      usuariAplicacioFilterForm.setContexte(getContextWeb());
      usuariAplicacioFilterForm.setEntityNameCode(getEntityNameCode());
      usuariAplicacioFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      usuariAplicacioFilterForm.setNou(true);
    } else {
      usuariAplicacioFilterForm.setNou(false);
    }
    usuariAplicacioFilterForm.setPage(pagina == null ? 1 : pagina);
    return usuariAplicacioFilterForm;
  }

  /**
   * Segona i següent peticions per llistar UsuariAplicacio de forma paginada
   * 
   * @param request
   * @param pagina
   * @param filterForm
   * @return
   * @throws I18NException
   */
  @RequestMapping(value = "/list/{pagina}", method = RequestMethod.POST)
  public ModelAndView llistatPaginat(HttpServletRequest request,
      HttpServletResponse response,@PathVariable Integer pagina,
      @ModelAttribute UsuariAplicacioFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getUsuariAplicacioFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de UsuariAplicacio de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<UsuariAplicacio> llistat(ModelAndView mav, HttpServletRequest request,
     UsuariAplicacioFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<UsuariAplicacio> usuariAplicacio = processarLlistat(usuariAplicacioEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("usuariAplicacioItems", usuariAplicacio);

    mav.addObject("usuariAplicacioFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, usuariAplicacio, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, usuariAplicacio);

    return usuariAplicacio;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(UsuariAplicacioFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<UsuariAplicacio> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, ACTIU);


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, ROLESCAN);


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, ROLECOAU);


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, ROLECUST);


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    UsuariAplicacioFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<UsuariAplicacio> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_USUARIAPLICACIO_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou UsuariAplicacio
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearUsuariAplicacioGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    UsuariAplicacioForm usuariAplicacioForm = getUsuariAplicacioForm(null, false, request, mav);
    mav.addObject("usuariAplicacioForm" ,usuariAplicacioForm);
    fillReferencesForForm(usuariAplicacioForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public UsuariAplicacioForm getUsuariAplicacioForm(UsuariAplicacioJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    UsuariAplicacioForm usuariAplicacioForm;
    if(_jpa == null) {
      usuariAplicacioForm = new UsuariAplicacioForm(new UsuariAplicacioJPA(), true);
    } else {
      usuariAplicacioForm = new UsuariAplicacioForm(_jpa, false);
      usuariAplicacioForm.setView(__isView);
    }
    usuariAplicacioForm.setContexte(getContextWeb());
    usuariAplicacioForm.setEntityNameCode(getEntityNameCode());
    usuariAplicacioForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return usuariAplicacioForm;
  }

  public void fillReferencesForForm(UsuariAplicacioForm usuariAplicacioForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou UsuariAplicacio
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearUsuariAplicacioPost(@ModelAttribute UsuariAplicacioForm usuariAplicacioForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    UsuariAplicacioJPA usuariAplicacio = usuariAplicacioForm.getUsuariAplicacio();

    try {
      preValidate(request, usuariAplicacioForm, result);
      getWebValidator().validate(usuariAplicacioForm, result);
      postValidate(request,usuariAplicacioForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        usuariAplicacio = create(request, usuariAplicacio);
        createMessageSuccess(request, "success.creation", usuariAplicacio.getUsuariAplicacioID());
        usuariAplicacioForm.setUsuariAplicacio(usuariAplicacio);
        return getRedirectWhenCreated(request, usuariAplicacioForm);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.creation", null, __e);
      log.error(msg, __e);
      return getTileForm();
    }
  }

  @RequestMapping(value = "/view/{usuariAplicacioID}", method = RequestMethod.GET)
  public ModelAndView veureUsuariAplicacioGet(@PathVariable("usuariAplicacioID") java.lang.Long usuariAplicacioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewUsuariAplicacioGet(usuariAplicacioID,
        request, response, true);
  }


  protected ModelAndView editAndViewUsuariAplicacioGet(@PathVariable("usuariAplicacioID") java.lang.Long usuariAplicacioID,
      HttpServletRequest request,
      HttpServletResponse response, boolean __isView) throws I18NException {
    if((!__isView) && !isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    } else {
      if(__isView && !isActiveFormView()) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return null;
      }
    }
    UsuariAplicacioJPA usuariAplicacio = findByPrimaryKey(request, usuariAplicacioID);

    if (usuariAplicacio == null) {
      createMessageWarning(request, "error.notfound", usuariAplicacioID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, usuariAplicacioID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      UsuariAplicacioForm usuariAplicacioForm = getUsuariAplicacioForm(usuariAplicacio, __isView, request, mav);
      usuariAplicacioForm.setView(__isView);
      if(__isView) {
        usuariAplicacioForm.setAllFieldsReadOnly(ALL_USUARIAPLICACIO_FIELDS);
        usuariAplicacioForm.setSaveButtonVisible(false);
        usuariAplicacioForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(usuariAplicacioForm, request, mav);
      mav.addObject("usuariAplicacioForm", usuariAplicacioForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un UsuariAplicacio existent
   */
  @RequestMapping(value = "/{usuariAplicacioID}/edit", method = RequestMethod.GET)
  public ModelAndView editarUsuariAplicacioGet(@PathVariable("usuariAplicacioID") java.lang.Long usuariAplicacioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewUsuariAplicacioGet(usuariAplicacioID,
        request, response, false);
  }



  /**
   * Editar un UsuariAplicacio existent
   */
  @RequestMapping(value = "/{usuariAplicacioID}/edit", method = RequestMethod.POST)
  public String editarUsuariAplicacioPost(@ModelAttribute @Valid UsuariAplicacioForm usuariAplicacioForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    UsuariAplicacioJPA usuariAplicacio = usuariAplicacioForm.getUsuariAplicacio();

    try {
      preValidate(request, usuariAplicacioForm, result);
      getWebValidator().validate(usuariAplicacio, result);
      postValidate(request, usuariAplicacioForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        usuariAplicacio = update(request, usuariAplicacio);
        createMessageSuccess(request, "success.modification", usuariAplicacio.getUsuariAplicacioID());
        status.setComplete();
        return getRedirectWhenModified(request, usuariAplicacioForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          usuariAplicacio.getUsuariAplicacioID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, usuariAplicacioForm, __e);
    }

  }


  /**
   * Eliminar un UsuariAplicacio existent
   */
  @RequestMapping(value = "/{usuariAplicacioID}/delete")
  public String eliminarUsuariAplicacio(@PathVariable("usuariAplicacioID") java.lang.Long usuariAplicacioID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      UsuariAplicacio usuariAplicacio = findByPrimaryKey(request, usuariAplicacioID);
      if (usuariAplicacio == null) {
        String __msg =createMessageError(request, "error.notfound", usuariAplicacioID);
        return getRedirectWhenDelete(request, usuariAplicacioID, new Exception(__msg));
      } else {
        delete(request, usuariAplicacio);
        createMessageSuccess(request, "success.deleted", usuariAplicacioID);
        return getRedirectWhenDelete(request, usuariAplicacioID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", usuariAplicacioID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, usuariAplicacioID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute UsuariAplicacioFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarUsuariAplicacio(stringToPK(seleccionats[i]), request, response);
    }
  }
  if (redirect == null) {
    redirect = getRedirectWhenDelete(request, null,null);
  }

  return redirect;
}



public java.lang.Long stringToPK(String value) {
  return new java.lang.Long(value);
}

  @Override
  public String[] getArgumentsMissatge(Object __usuariAplicacioID, Throwable e) {
    java.lang.Long usuariAplicacioID = (java.lang.Long)__usuariAplicacioID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (usuariAplicacioID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(usuariAplicacioID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "usuariAplicacio.usuariAplicacio";
  }

  public String getEntityNameCodePlural() {
    return "usuariAplicacio.usuariAplicacio.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("usuariAplicacio.usuariAplicacioID");
  }

  @InitBinder("usuariAplicacioFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("usuariAplicacioForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());

    initDisallowedFields(binder, "usuariAplicacio.usuariAplicacioID");
  }

  public UsuariAplicacioWebValidator getWebValidator() {
    return usuariAplicacioWebValidator;
  }


  public void setWebValidator(UsuariAplicacioWebValidator __val) {
    if (__val != null) {
      this.usuariAplicacioWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de UsuariAplicacio
   */
  @RequestMapping(value = "/{usuariAplicacioID}/cancel")
  public String cancelUsuariAplicacio(@PathVariable("usuariAplicacioID") java.lang.Long usuariAplicacioID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, usuariAplicacioID);
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

  // Mètodes a sobreescriure 

  public boolean isActiveList() {
    return true;
  }


  public boolean isActiveFormNew() {
    return true;
  }


  public boolean isActiveFormEdit() {
    return true;
  }


  public boolean isActiveDelete() {
    return true;
  }


  public boolean isActiveFormView() {
    return isActiveFormEdit();
  }


  public void preValidate(HttpServletRequest request,UsuariAplicacioForm usuariAplicacioForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,UsuariAplicacioForm usuariAplicacioForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, UsuariAplicacioFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, UsuariAplicacioFilterForm filterForm,  List<UsuariAplicacio> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, UsuariAplicacioForm usuariAplicacioForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, UsuariAplicacioForm usuariAplicacioForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long usuariAplicacioID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long usuariAplicacioID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "usuariAplicacioFormWebDB";
  }

  public String getTileList() {
    return "usuariAplicacioListWebDB";
  }

  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public String getSessionAttributeFilterForm() {
    return "UsuariAplicacioWebDB_FilterForm";
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public UsuariAplicacioJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long usuariAplicacioID) throws I18NException {
    return (UsuariAplicacioJPA) usuariAplicacioEjb.findByPrimaryKey(usuariAplicacioID);
  }


  public UsuariAplicacioJPA create(HttpServletRequest request, UsuariAplicacioJPA usuariAplicacio)
    throws Exception,I18NException, I18NValidationException {
    return (UsuariAplicacioJPA) usuariAplicacioEjb.create(usuariAplicacio);
  }


  public UsuariAplicacioJPA update(HttpServletRequest request, UsuariAplicacioJPA usuariAplicacio)
    throws Exception,I18NException, I18NValidationException {
    return (UsuariAplicacioJPA) usuariAplicacioEjb.update(usuariAplicacio);
  }


  public void delete(HttpServletRequest request, UsuariAplicacio usuariAplicacio) throws Exception,I18NException {
    usuariAplicacioEjb.delete(usuariAplicacio);
  }

} // Final de Classe

