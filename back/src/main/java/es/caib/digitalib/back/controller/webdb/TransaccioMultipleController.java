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
import es.caib.digitalib.back.form.webdb.TransaccioMultipleForm;

import es.caib.digitalib.back.validator.webdb.TransaccioMultipleWebValidator;

import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.jpa.FitxerJPA;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import es.caib.digitalib.jpa.TransaccioMultipleJPA;
import es.caib.digitalib.model.entity.TransaccioMultiple;
import es.caib.digitalib.model.fields.*;

/**
 * Controller per gestionar un TransaccioMultiple
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/transaccioMultiple")
@SessionAttributes(types = { TransaccioMultipleForm.class, TransaccioMultipleFilterForm.class })
public class TransaccioMultipleController
    extends es.caib.digitalib.back.controller.DigitalIBFilesBaseController<TransaccioMultiple, java.lang.Long, TransaccioMultipleForm> implements TransaccioMultipleFields {

  @EJB(mappedName = es.caib.digitalib.ejb.TransaccioMultipleLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.TransaccioMultipleLocal transaccioMultipleEjb;

  @Autowired
  private TransaccioMultipleWebValidator transaccioMultipleWebValidator;

  @Autowired
  protected TransaccioMultipleRefList transaccioMultipleRefList;

  /**
   * Llistat de totes TransaccioMultiple
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    TransaccioMultipleFilterForm ff;
    ff = (TransaccioMultipleFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar TransaccioMultiple de forma paginada
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
    llistat(mav, request, getTransaccioMultipleFilterForm(pagina, mav, request));
    return mav;
  }

  public TransaccioMultipleFilterForm getTransaccioMultipleFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    TransaccioMultipleFilterForm transaccioMultipleFilterForm;
    transaccioMultipleFilterForm = (TransaccioMultipleFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(transaccioMultipleFilterForm == null) {
      transaccioMultipleFilterForm = new TransaccioMultipleFilterForm();
      transaccioMultipleFilterForm.setContexte(getContextWeb());
      transaccioMultipleFilterForm.setEntityNameCode(getEntityNameCode());
      transaccioMultipleFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      transaccioMultipleFilterForm.setNou(true);
    } else {
      transaccioMultipleFilterForm.setNou(false);
    }
    transaccioMultipleFilterForm.setPage(pagina == null ? 1 : pagina);
    return transaccioMultipleFilterForm;
  }

  /**
   * Segona i següent peticions per llistar TransaccioMultiple de forma paginada
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
      @ModelAttribute TransaccioMultipleFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getTransaccioMultipleFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de TransaccioMultiple de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<TransaccioMultiple> llistat(ModelAndView mav, HttpServletRequest request,
     TransaccioMultipleFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<TransaccioMultiple> transaccioMultiple = processarLlistat(transaccioMultipleEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("transaccioMultipleItems", transaccioMultiple);

    mav.addObject("transaccioMultipleFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, transaccioMultiple, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, transaccioMultiple);

    return transaccioMultiple;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(TransaccioMultipleFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<TransaccioMultiple> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    TransaccioMultipleFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<TransaccioMultiple> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_TRANSACCIOMULTIPLE_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou TransaccioMultiple
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearTransaccioMultipleGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    TransaccioMultipleForm transaccioMultipleForm = getTransaccioMultipleForm(null, false, request, mav);
    mav.addObject("transaccioMultipleForm" ,transaccioMultipleForm);
    fillReferencesForForm(transaccioMultipleForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public TransaccioMultipleForm getTransaccioMultipleForm(TransaccioMultipleJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    TransaccioMultipleForm transaccioMultipleForm;
    if(_jpa == null) {
      transaccioMultipleForm = new TransaccioMultipleForm(new TransaccioMultipleJPA(), true);
    } else {
      transaccioMultipleForm = new TransaccioMultipleForm(_jpa, false);
      transaccioMultipleForm.setView(__isView);
    }
    transaccioMultipleForm.setContexte(getContextWeb());
    transaccioMultipleForm.setEntityNameCode(getEntityNameCode());
    transaccioMultipleForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return transaccioMultipleForm;
  }

  public void fillReferencesForForm(TransaccioMultipleForm transaccioMultipleForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou TransaccioMultiple
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearTransaccioMultiplePost(@ModelAttribute TransaccioMultipleForm transaccioMultipleForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    TransaccioMultipleJPA transaccioMultiple = transaccioMultipleForm.getTransaccioMultiple();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE

    try {
      this.setFilesFormToEntity(afm, transaccioMultiple, transaccioMultipleForm); // FILE
      preValidate(request, transaccioMultipleForm, result);
      getWebValidator().validate(transaccioMultipleForm, result);
      postValidate(request,transaccioMultipleForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        transaccioMultiple = create(request, transaccioMultiple);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.creation", transaccioMultiple.getTransmultipleid());
        transaccioMultipleForm.setTransaccioMultiple(transaccioMultiple);
        return getRedirectWhenCreated(request, transaccioMultipleForm);
      }
    } catch (Throwable __e) {
      afm.processErrorFilesWithoutThrowException(); // FILE
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.creation", null, __e);
      log.error(msg, __e);
      return getTileForm();
    }
  }

  @RequestMapping(value = "/view/{transmultipleid}", method = RequestMethod.GET)
  public ModelAndView veureTransaccioMultipleGet(@PathVariable("transmultipleid") java.lang.Long transmultipleid,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewTransaccioMultipleGet(transmultipleid,
        request, response, true);
  }


  protected ModelAndView editAndViewTransaccioMultipleGet(@PathVariable("transmultipleid") java.lang.Long transmultipleid,
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
    TransaccioMultipleJPA transaccioMultiple = findByPrimaryKey(request, transmultipleid);

    if (transaccioMultiple == null) {
      createMessageWarning(request, "error.notfound", transmultipleid);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, transmultipleid), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      TransaccioMultipleForm transaccioMultipleForm = getTransaccioMultipleForm(transaccioMultiple, __isView, request, mav);
      transaccioMultipleForm.setView(__isView);
      if(__isView) {
        transaccioMultipleForm.setAllFieldsReadOnly(ALL_TRANSACCIOMULTIPLE_FIELDS);
        transaccioMultipleForm.setSaveButtonVisible(false);
        transaccioMultipleForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(transaccioMultipleForm, request, mav);
      mav.addObject("transaccioMultipleForm", transaccioMultipleForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un TransaccioMultiple existent
   */
  @RequestMapping(value = "/{transmultipleid}/edit", method = RequestMethod.GET)
  public ModelAndView editarTransaccioMultipleGet(@PathVariable("transmultipleid") java.lang.Long transmultipleid,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewTransaccioMultipleGet(transmultipleid,
        request, response, false);
  }



  /**
   * Editar un TransaccioMultiple existent
   */
  @RequestMapping(value = "/{transmultipleid}/edit", method = RequestMethod.POST)
  public String editarTransaccioMultiplePost(@ModelAttribute @Valid TransaccioMultipleForm transaccioMultipleForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    TransaccioMultipleJPA transaccioMultiple = transaccioMultipleForm.getTransaccioMultiple();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE
    try {
      this.setFilesFormToEntity(afm, transaccioMultiple, transaccioMultipleForm); // FILE
      preValidate(request, transaccioMultipleForm, result);
      getWebValidator().validate(transaccioMultiple, result);
      postValidate(request, transaccioMultipleForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        transaccioMultiple = update(request, transaccioMultiple);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.modification", transaccioMultiple.getTransmultipleid());
        status.setComplete();
        return getRedirectWhenModified(request, transaccioMultipleForm, null);
      }
    } catch (Throwable __e) {
      afm.processErrorFilesWithoutThrowException(); // FILE
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          transaccioMultiple.getTransmultipleid(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, transaccioMultipleForm, __e);
    }

  }


  /**
   * Eliminar un TransaccioMultiple existent
   */
  @RequestMapping(value = "/{transmultipleid}/delete")
  public String eliminarTransaccioMultiple(@PathVariable("transmultipleid") java.lang.Long transmultipleid,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      TransaccioMultiple transaccioMultiple = transaccioMultipleEjb.findByPrimaryKey(transmultipleid);
      if (transaccioMultiple == null) {
        String __msg =createMessageError(request, "error.notfound", transmultipleid);
        return getRedirectWhenDelete(request, transmultipleid, new Exception(__msg));
      } else {
        delete(request, transaccioMultiple);
        createMessageSuccess(request, "success.deleted", transmultipleid);
        return getRedirectWhenDelete(request, transmultipleid,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", transmultipleid, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, transmultipleid, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute TransaccioMultipleFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarTransaccioMultiple(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __transmultipleid, Throwable e) {
    java.lang.Long transmultipleid = (java.lang.Long)__transmultipleid;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (transmultipleid == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(transmultipleid),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "transaccioMultiple.transaccioMultiple";
  }

  public String getEntityNameCodePlural() {
    return "transaccioMultiple.transaccioMultiple.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("transaccioMultiple.transmultipleid");
  }

  @InitBinder("transaccioMultipleFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("transaccioMultipleForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


  }

  public TransaccioMultipleWebValidator getWebValidator() {
    return transaccioMultipleWebValidator;
  }


  public void setWebValidator(TransaccioMultipleWebValidator __val) {
    if (__val != null) {
      this.transaccioMultipleWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de TransaccioMultiple
   */
  @RequestMapping(value = "/{transmultipleid}/cancel")
  public String cancelTransaccioMultiple(@PathVariable("transmultipleid") java.lang.Long transmultipleid,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, transmultipleid);
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

  // FILE
  @Override
  public void setFilesFormToEntity(FilesFormManager<Fitxer> afm, TransaccioMultiple transaccioMultiple,
      TransaccioMultipleForm form) throws I18NException {

    FitxerJPA f;
    f = (FitxerJPA)afm.preProcessFile(form.getFitxerEscanejatID(), form.isFitxerEscanejatIDDelete(),
        form.isNou()? null : transaccioMultiple.getFitxerEscanejat());
    ((TransaccioMultipleJPA)transaccioMultiple).setFitxerEscanejat(f);
    if (f != null) { 
      transaccioMultiple.setFitxerEscanejatID(f.getFitxerID());
    } else {
      transaccioMultiple.setFitxerEscanejatID(null);
    }


  }

  // FILE
  @Override
  public void deleteFiles(TransaccioMultiple transaccioMultiple) {
    deleteFile(transaccioMultiple.getFitxerEscanejatID());
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


  public void preValidate(HttpServletRequest request,TransaccioMultipleForm transaccioMultipleForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,TransaccioMultipleForm transaccioMultipleForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, TransaccioMultipleFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, TransaccioMultipleFilterForm filterForm,  List<TransaccioMultiple> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, TransaccioMultipleForm transaccioMultipleForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, TransaccioMultipleForm transaccioMultipleForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long transmultipleid, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long transmultipleid) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "transaccioMultipleFormWebDB";
  }

  public String getTileList() {
    return "transaccioMultipleListWebDB";
  }

  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public String getSessionAttributeFilterForm() {
    return "TransaccioMultipleWebDB_FilterForm";
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public TransaccioMultipleJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long transmultipleid) throws I18NException {
    return (TransaccioMultipleJPA) transaccioMultipleEjb.findByPrimaryKey(transmultipleid);
  }


  public TransaccioMultipleJPA create(HttpServletRequest request, TransaccioMultipleJPA transaccioMultiple)
    throws Exception,I18NException, I18NValidationException {
    return (TransaccioMultipleJPA) transaccioMultipleEjb.create(transaccioMultiple);
  }


  public TransaccioMultipleJPA update(HttpServletRequest request, TransaccioMultipleJPA transaccioMultiple)
    throws Exception,I18NException, I18NValidationException {
    return (TransaccioMultipleJPA) transaccioMultipleEjb.update(transaccioMultiple);
  }


  public void delete(HttpServletRequest request, TransaccioMultiple transaccioMultiple) throws Exception,I18NException {
    transaccioMultipleEjb.delete(transaccioMultiple);
  }

} // Final de Classe

