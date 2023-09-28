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

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import es.caib.digitalib.back.form.webdb.*;
import es.caib.digitalib.back.form.webdb.ApiSimpleForm;

import es.caib.digitalib.back.validator.webdb.ApiSimpleWebValidator;

import es.caib.digitalib.persistence.ApiSimpleJPA;
import es.caib.digitalib.model.entity.ApiSimple;
import es.caib.digitalib.model.fields.*;

/**
 * Controller per gestionar un ApiSimple
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/apiSimple")
@SessionAttributes(types = { ApiSimpleForm.class, ApiSimpleFilterForm.class })
public class ApiSimpleController
    extends es.caib.digitalib.back.controller.DigitalIBBaseController<ApiSimple, java.lang.Long> implements ApiSimpleFields {

  @EJB(mappedName = es.caib.digitalib.ejb.ApiSimpleService.JNDI_NAME)
  protected es.caib.digitalib.ejb.ApiSimpleService apiSimpleEjb;

  @Autowired
  private ApiSimpleWebValidator apiSimpleWebValidator;

  @Autowired
  protected ApiSimpleRefList apiSimpleRefList;

  /**
   * Llistat de totes ApiSimple
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    ApiSimpleFilterForm ff;
    ff = (ApiSimpleFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar ApiSimple de forma paginada
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
    llistat(mav, request, getApiSimpleFilterForm(pagina, mav, request));
    return mav;
  }

  public ApiSimpleFilterForm getApiSimpleFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    ApiSimpleFilterForm apiSimpleFilterForm;
    apiSimpleFilterForm = (ApiSimpleFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(apiSimpleFilterForm == null) {
      apiSimpleFilterForm = new ApiSimpleFilterForm();
      apiSimpleFilterForm.setContexte(getContextWeb());
      apiSimpleFilterForm.setEntityNameCode(getEntityNameCode());
      apiSimpleFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      apiSimpleFilterForm.setNou(true);
    } else {
      apiSimpleFilterForm.setNou(false);
    }
    apiSimpleFilterForm.setPage(pagina == null ? 1 : pagina);
    return apiSimpleFilterForm;
  }

  /**
   * Segona i següent peticions per llistar ApiSimple de forma paginada
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
      @ModelAttribute ApiSimpleFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getApiSimpleFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de ApiSimple de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<ApiSimple> llistat(ModelAndView mav, HttpServletRequest request,
     ApiSimpleFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<ApiSimple> apiSimple = processarLlistat(apiSimpleEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("apiSimpleItems", apiSimple);

    mav.addObject("apiSimpleFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, apiSimple, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, apiSimple);

    return apiSimple;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(ApiSimpleFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<ApiSimple> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    ApiSimpleFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<ApiSimple> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_APISIMPLE_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou ApiSimple
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearApiSimpleGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    ApiSimpleForm apiSimpleForm = getApiSimpleForm(null, false, request, mav);
    mav.addObject("apiSimpleForm" ,apiSimpleForm);
    fillReferencesForForm(apiSimpleForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public ApiSimpleForm getApiSimpleForm(ApiSimpleJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    ApiSimpleForm apiSimpleForm;
    if(_jpa == null) {
      apiSimpleForm = new ApiSimpleForm(new ApiSimpleJPA(), true);
    } else {
      apiSimpleForm = new ApiSimpleForm(_jpa, false);
      apiSimpleForm.setView(__isView);
    }
    apiSimpleForm.setContexte(getContextWeb());
    apiSimpleForm.setEntityNameCode(getEntityNameCode());
    apiSimpleForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return apiSimpleForm;
  }

  public void fillReferencesForForm(ApiSimpleForm apiSimpleForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou ApiSimple
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearApiSimplePost(@ModelAttribute ApiSimpleForm apiSimpleForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ApiSimpleJPA apiSimple = apiSimpleForm.getApiSimple();

    try {
      preValidate(request, apiSimpleForm, result);
      getWebValidator().validate(apiSimpleForm, result);
      postValidate(request,apiSimpleForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        apiSimple = create(request, apiSimple);
        createMessageSuccess(request, "success.creation", apiSimple.getApiSimpleID());
        apiSimpleForm.setApiSimple(apiSimple);
        return getRedirectWhenCreated(request, apiSimpleForm);
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

  @RequestMapping(value = "/view/{apiSimpleID}", method = RequestMethod.GET)
  public ModelAndView veureApiSimpleGet(@PathVariable("apiSimpleID") java.lang.Long apiSimpleID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewApiSimpleGet(apiSimpleID,
        request, response, true);
  }


  protected ModelAndView editAndViewApiSimpleGet(@PathVariable("apiSimpleID") java.lang.Long apiSimpleID,
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
    ApiSimpleJPA apiSimple = findByPrimaryKey(request, apiSimpleID);

    if (apiSimple == null) {
      createMessageWarning(request, "error.notfound", apiSimpleID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, apiSimpleID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      ApiSimpleForm apiSimpleForm = getApiSimpleForm(apiSimple, __isView, request, mav);
      apiSimpleForm.setView(__isView);
      if(__isView) {
        apiSimpleForm.setAllFieldsReadOnly(ALL_APISIMPLE_FIELDS);
        apiSimpleForm.setSaveButtonVisible(false);
        apiSimpleForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(apiSimpleForm, request, mav);
      mav.addObject("apiSimpleForm", apiSimpleForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un ApiSimple existent
   */
  @RequestMapping(value = "/{apiSimpleID}/edit", method = RequestMethod.GET)
  public ModelAndView editarApiSimpleGet(@PathVariable("apiSimpleID") java.lang.Long apiSimpleID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewApiSimpleGet(apiSimpleID,
        request, response, false);
  }



  /**
   * Editar un ApiSimple existent
   */
  @RequestMapping(value = "/{apiSimpleID}/edit", method = RequestMethod.POST)
  public String editarApiSimplePost(@ModelAttribute ApiSimpleForm apiSimpleForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ApiSimpleJPA apiSimple = apiSimpleForm.getApiSimple();

    try {
      preValidate(request, apiSimpleForm, result);
      getWebValidator().validate(apiSimpleForm, result);
      postValidate(request, apiSimpleForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        apiSimple = update(request, apiSimple);
        createMessageSuccess(request, "success.modification", apiSimple.getApiSimpleID());
        status.setComplete();
        return getRedirectWhenModified(request, apiSimpleForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          apiSimple.getApiSimpleID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, apiSimpleForm, __e);
    }

  }


  /**
   * Eliminar un ApiSimple existent
   */
  @RequestMapping(value = "/{apiSimpleID}/delete")
  public String eliminarApiSimple(@PathVariable("apiSimpleID") java.lang.Long apiSimpleID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      ApiSimple apiSimple = this.findByPrimaryKey(request, apiSimpleID);
      if (apiSimple == null) {
        String __msg = createMessageError(request, "error.notfound", apiSimpleID);
        return getRedirectWhenDelete(request, apiSimpleID, new Exception(__msg));
      } else {
        delete(request, apiSimple);
        createMessageSuccess(request, "success.deleted", apiSimpleID);
        return getRedirectWhenDelete(request, apiSimpleID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", apiSimpleID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, apiSimpleID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute ApiSimpleFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarApiSimple(stringToPK(seleccionats[i]), request, response);
    }
  }
  if (redirect == null) {
    redirect = getRedirectWhenDelete(request, null,null);
  }

  return redirect;
}



public java.lang.Long stringToPK(String value) {
  return java.lang.Long.parseLong(value, 10);
}

  @Override
  public String[] getArgumentsMissatge(Object __apiSimpleID, Throwable e) {
    java.lang.Long apiSimpleID = (java.lang.Long)__apiSimpleID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (apiSimpleID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(apiSimpleID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "apiSimple.apiSimple";
  }

  public String getEntityNameCodePlural() {
    return "apiSimple.apiSimple.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("apiSimple.apiSimpleID");
  }

  @InitBinder("apiSimpleFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("apiSimpleForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "apiSimple.apiSimpleID");
  }

  public ApiSimpleWebValidator getWebValidator() {
    return apiSimpleWebValidator;
  }


  public void setWebValidator(ApiSimpleWebValidator __val) {
    if (__val != null) {
      this.apiSimpleWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de ApiSimple
   */
  @RequestMapping(value = "/{apiSimpleID}/cancel")
  public String cancelApiSimple(@PathVariable("apiSimpleID") java.lang.Long apiSimpleID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, apiSimpleID);
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


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,ApiSimpleForm apiSimpleForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,ApiSimpleForm apiSimpleForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, ApiSimpleFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, ApiSimpleFilterForm filterForm,  List<ApiSimple> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, ApiSimpleForm apiSimpleForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, ApiSimpleForm apiSimpleForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long apiSimpleID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long apiSimpleID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "apiSimpleFormWebDB";
  }

  public String getTileList() {
    return "apiSimpleListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "ApiSimple_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public ApiSimpleJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long apiSimpleID) throws I18NException {
    return (ApiSimpleJPA) apiSimpleEjb.findByPrimaryKey(apiSimpleID);
  }


  public ApiSimpleJPA create(HttpServletRequest request, ApiSimpleJPA apiSimple)
    throws I18NException, I18NValidationException {
    return (ApiSimpleJPA) apiSimpleEjb.create(apiSimple);
  }


  public ApiSimpleJPA update(HttpServletRequest request, ApiSimpleJPA apiSimple)
    throws I18NException, I18NValidationException {
    return (ApiSimpleJPA) apiSimpleEjb.update(apiSimple);
  }


  public void delete(HttpServletRequest request, ApiSimple apiSimple) throws I18NException {
    apiSimpleEjb.delete(apiSimple);
  }

} // Final de Classe

