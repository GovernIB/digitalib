package es.caib.digitalib.back.controller.webdb;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.utils.Utils;
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
import es.caib.digitalib.back.form.webdb.PerfilUsuariAplicacioForm;

import es.caib.digitalib.back.validator.webdb.PerfilUsuariAplicacioWebValidator;

import es.caib.digitalib.jpa.PerfilUsuariAplicacioJPA;
import es.caib.digitalib.model.entity.PerfilUsuariAplicacio;
import es.caib.digitalib.model.fields.*;

/**
 * Controller per gestionar un PerfilUsuariAplicacio
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/perfilUsuariAplicacio")
@SessionAttributes(types = { PerfilUsuariAplicacioForm.class, PerfilUsuariAplicacioFilterForm.class })
public class PerfilUsuariAplicacioController
    extends es.caib.digitalib.back.controller.DigitalIBBaseController<PerfilUsuariAplicacio, java.lang.Long> implements PerfilUsuariAplicacioFields {

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilUsuariAplicacioLocal perfilUsuariAplicacioEjb;

  @Autowired
  private PerfilUsuariAplicacioWebValidator perfilUsuariAplicacioWebValidator;

  @Autowired
  protected PerfilUsuariAplicacioRefList perfilUsuariAplicacioRefList;

  // References 
  @Autowired
  protected PerfilRefList perfilRefList;

  // References 
  @Autowired
  protected UsuariAplicacioRefList usuariAplicacioRefList;

  /**
   * Llistat de totes PerfilUsuariAplicacio
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    PerfilUsuariAplicacioFilterForm ff;
    ff = (PerfilUsuariAplicacioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar PerfilUsuariAplicacio de forma paginada
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
    llistat(mav, request, getPerfilUsuariAplicacioFilterForm(pagina, mav, request));
    return mav;
  }

  public PerfilUsuariAplicacioFilterForm getPerfilUsuariAplicacioFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    PerfilUsuariAplicacioFilterForm perfilUsuariAplicacioFilterForm;
    perfilUsuariAplicacioFilterForm = (PerfilUsuariAplicacioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(perfilUsuariAplicacioFilterForm == null) {
      perfilUsuariAplicacioFilterForm = new PerfilUsuariAplicacioFilterForm();
      perfilUsuariAplicacioFilterForm.setContexte(getContextWeb());
      perfilUsuariAplicacioFilterForm.setEntityNameCode(getEntityNameCode());
      perfilUsuariAplicacioFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      perfilUsuariAplicacioFilterForm.setNou(true);
    } else {
      perfilUsuariAplicacioFilterForm.setNou(false);
    }
    perfilUsuariAplicacioFilterForm.setPage(pagina == null ? 1 : pagina);
    return perfilUsuariAplicacioFilterForm;
  }

  /**
   * Segona i següent peticions per llistar PerfilUsuariAplicacio de forma paginada
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
      @ModelAttribute PerfilUsuariAplicacioFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getPerfilUsuariAplicacioFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de PerfilUsuariAplicacio de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<PerfilUsuariAplicacio> llistat(ModelAndView mav, HttpServletRequest request,
     PerfilUsuariAplicacioFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<PerfilUsuariAplicacio> perfilUsuariAplicacio = processarLlistat(perfilUsuariAplicacioEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("perfilUsuariAplicacioItems", perfilUsuariAplicacio);

    mav.addObject("perfilUsuariAplicacioFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, perfilUsuariAplicacio, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, perfilUsuariAplicacio);

    return perfilUsuariAplicacio;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(PerfilUsuariAplicacioFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<PerfilUsuariAplicacio> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field perfilID
    {
      _listSKV = getReferenceListForPerfilID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPerfilForPerfilID(_tmp);
      if (filterForm.getGroupByFields().contains(PERFILID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PERFILID, false);
      };
    }

    // Field usuariAplicacioID
    {
      _listSKV = getReferenceListForUsuariAplicacioID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfUsuariAplicacioForUsuariAplicacioID(_tmp);
      if (filterForm.getGroupByFields().contains(USUARIAPLICACIOID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, USUARIAPLICACIOID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    PerfilUsuariAplicacioFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<PerfilUsuariAplicacio> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_PERFILUSUARIAPLICACIO_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(PERFILID, filterForm.getMapOfPerfilForPerfilID());
    __mapping.put(USUARIAPLICACIOID, filterForm.getMapOfUsuariAplicacioForUsuariAplicacioID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou PerfilUsuariAplicacio
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearPerfilUsuariAplicacioGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    PerfilUsuariAplicacioForm perfilUsuariAplicacioForm = getPerfilUsuariAplicacioForm(null, false, request, mav);
    mav.addObject("perfilUsuariAplicacioForm" ,perfilUsuariAplicacioForm);
    fillReferencesForForm(perfilUsuariAplicacioForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public PerfilUsuariAplicacioForm getPerfilUsuariAplicacioForm(PerfilUsuariAplicacioJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    PerfilUsuariAplicacioForm perfilUsuariAplicacioForm;
    if(_jpa == null) {
      perfilUsuariAplicacioForm = new PerfilUsuariAplicacioForm(new PerfilUsuariAplicacioJPA(), true);
    } else {
      perfilUsuariAplicacioForm = new PerfilUsuariAplicacioForm(_jpa, false);
      perfilUsuariAplicacioForm.setView(__isView);
    }
    perfilUsuariAplicacioForm.setContexte(getContextWeb());
    perfilUsuariAplicacioForm.setEntityNameCode(getEntityNameCode());
    perfilUsuariAplicacioForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return perfilUsuariAplicacioForm;
  }

  public void fillReferencesForForm(PerfilUsuariAplicacioForm perfilUsuariAplicacioForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (perfilUsuariAplicacioForm.getListOfPerfilForPerfilID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPerfilID(request, mav, perfilUsuariAplicacioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      perfilUsuariAplicacioForm.setListOfPerfilForPerfilID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilUsuariAplicacioForm.getListOfUsuariAplicacioForUsuariAplicacioID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForUsuariAplicacioID(request, mav, perfilUsuariAplicacioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      perfilUsuariAplicacioForm.setListOfUsuariAplicacioForUsuariAplicacioID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou PerfilUsuariAplicacio
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearPerfilUsuariAplicacioPost(@ModelAttribute PerfilUsuariAplicacioForm perfilUsuariAplicacioForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    PerfilUsuariAplicacioJPA perfilUsuariAplicacio = perfilUsuariAplicacioForm.getPerfilUsuariAplicacio();

    try {
      preValidate(request, perfilUsuariAplicacioForm, result);
      getWebValidator().validate(perfilUsuariAplicacioForm, result);
      postValidate(request,perfilUsuariAplicacioForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        perfilUsuariAplicacio = create(request, perfilUsuariAplicacio);
        createMessageSuccess(request, "success.creation", perfilUsuariAplicacio.getPerfilUsrAppID());
        perfilUsuariAplicacioForm.setPerfilUsuariAplicacio(perfilUsuariAplicacio);
        return getRedirectWhenCreated(request, perfilUsuariAplicacioForm);
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

  @RequestMapping(value = "/view/{perfilUsrAppID}", method = RequestMethod.GET)
  public ModelAndView veurePerfilUsuariAplicacioGet(@PathVariable("perfilUsrAppID") java.lang.Long perfilUsrAppID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewPerfilUsuariAplicacioGet(perfilUsrAppID,
        request, response, true);
  }


  protected ModelAndView editAndViewPerfilUsuariAplicacioGet(@PathVariable("perfilUsrAppID") java.lang.Long perfilUsrAppID,
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
    PerfilUsuariAplicacioJPA perfilUsuariAplicacio = findByPrimaryKey(request, perfilUsrAppID);

    if (perfilUsuariAplicacio == null) {
      createMessageWarning(request, "error.notfound", perfilUsrAppID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, perfilUsrAppID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      PerfilUsuariAplicacioForm perfilUsuariAplicacioForm = getPerfilUsuariAplicacioForm(perfilUsuariAplicacio, __isView, request, mav);
      perfilUsuariAplicacioForm.setView(__isView);
      if(__isView) {
        perfilUsuariAplicacioForm.setAllFieldsReadOnly(ALL_PERFILUSUARIAPLICACIO_FIELDS);
        perfilUsuariAplicacioForm.setSaveButtonVisible(false);
        perfilUsuariAplicacioForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(perfilUsuariAplicacioForm, request, mav);
      mav.addObject("perfilUsuariAplicacioForm", perfilUsuariAplicacioForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un PerfilUsuariAplicacio existent
   */
  @RequestMapping(value = "/{perfilUsrAppID}/edit", method = RequestMethod.GET)
  public ModelAndView editarPerfilUsuariAplicacioGet(@PathVariable("perfilUsrAppID") java.lang.Long perfilUsrAppID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewPerfilUsuariAplicacioGet(perfilUsrAppID,
        request, response, false);
  }



  /**
   * Editar un PerfilUsuariAplicacio existent
   */
  @RequestMapping(value = "/{perfilUsrAppID}/edit", method = RequestMethod.POST)
  public String editarPerfilUsuariAplicacioPost(@ModelAttribute @Valid PerfilUsuariAplicacioForm perfilUsuariAplicacioForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    PerfilUsuariAplicacioJPA perfilUsuariAplicacio = perfilUsuariAplicacioForm.getPerfilUsuariAplicacio();

    try {
      preValidate(request, perfilUsuariAplicacioForm, result);
      getWebValidator().validate(perfilUsuariAplicacio, result);
      postValidate(request, perfilUsuariAplicacioForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        perfilUsuariAplicacio = update(request, perfilUsuariAplicacio);
        createMessageSuccess(request, "success.modification", perfilUsuariAplicacio.getPerfilUsrAppID());
        status.setComplete();
        return getRedirectWhenModified(request, perfilUsuariAplicacioForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          perfilUsuariAplicacio.getPerfilUsrAppID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, perfilUsuariAplicacioForm, __e);
    }

  }


  /**
   * Eliminar un PerfilUsuariAplicacio existent
   */
  @RequestMapping(value = "/{perfilUsrAppID}/delete")
  public String eliminarPerfilUsuariAplicacio(@PathVariable("perfilUsrAppID") java.lang.Long perfilUsrAppID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      PerfilUsuariAplicacio perfilUsuariAplicacio = perfilUsuariAplicacioEjb.findByPrimaryKey(perfilUsrAppID);
      if (perfilUsuariAplicacio == null) {
        String __msg =createMessageError(request, "error.notfound", perfilUsrAppID);
        return getRedirectWhenDelete(request, perfilUsrAppID, new Exception(__msg));
      } else {
        delete(request, perfilUsuariAplicacio);
        createMessageSuccess(request, "success.deleted", perfilUsrAppID);
        return getRedirectWhenDelete(request, perfilUsrAppID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", perfilUsrAppID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, perfilUsrAppID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute PerfilUsuariAplicacioFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarPerfilUsuariAplicacio(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __perfilUsrAppID, Throwable e) {
    java.lang.Long perfilUsrAppID = (java.lang.Long)__perfilUsrAppID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (perfilUsrAppID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(perfilUsrAppID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "perfilUsuariAplicacio.perfilUsuariAplicacio";
  }

  public String getEntityNameCodePlural() {
    return "perfilUsuariAplicacio.perfilUsuariAplicacio.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("perfilUsuariAplicacio.perfilUsrAppID");
  }

  @InitBinder("perfilUsuariAplicacioFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("perfilUsuariAplicacioForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());

    binder.setDisallowedFields("perfilUsrAppID");

  }

  public PerfilUsuariAplicacioWebValidator getWebValidator() {
    return perfilUsuariAplicacioWebValidator;
  }


  public void setWebValidator(PerfilUsuariAplicacioWebValidator __val) {
    if (__val != null) {
      this.perfilUsuariAplicacioWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de PerfilUsuariAplicacio
   */
  @RequestMapping(value = "/{perfilUsrAppID}/cancel")
  public String cancelPerfilUsuariAplicacio(@PathVariable("perfilUsrAppID") java.lang.Long perfilUsrAppID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, perfilUsrAppID);
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


  public List<StringKeyValue> getReferenceListForPerfilID(HttpServletRequest request,
       ModelAndView mav, PerfilUsuariAplicacioForm perfilUsuariAplicacioForm, Where where)  throws I18NException {
    if (perfilUsuariAplicacioForm.isHiddenField(PERFILID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _where = null;
    if (perfilUsuariAplicacioForm.isReadOnlyField(PERFILID)) {
      _where = PerfilFields.PERFILID.equal(perfilUsuariAplicacioForm.getPerfilUsuariAplicacio().getPerfilID());
    }
    return getReferenceListForPerfilID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPerfilID(HttpServletRequest request,
       ModelAndView mav, PerfilUsuariAplicacioFilterForm perfilUsuariAplicacioFilterForm,
       List<PerfilUsuariAplicacio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilUsuariAplicacioFilterForm.isHiddenField(PERFILID)
      && !perfilUsuariAplicacioFilterForm.isGroupByField(PERFILID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PERFILID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (PerfilUsuariAplicacio _item : list) {
        _pkList.add(_item.getPerfilID());
        }
        _w = PerfilFields.PERFILID.in(_pkList);
      }
    return getReferenceListForPerfilID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPerfilID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return perfilRefList.getReferenceList(PerfilFields.PERFILID, where );
  }


  public List<StringKeyValue> getReferenceListForUsuariAplicacioID(HttpServletRequest request,
       ModelAndView mav, PerfilUsuariAplicacioForm perfilUsuariAplicacioForm, Where where)  throws I18NException {
    if (perfilUsuariAplicacioForm.isHiddenField(USUARIAPLICACIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _where = null;
    if (perfilUsuariAplicacioForm.isReadOnlyField(USUARIAPLICACIOID)) {
      _where = UsuariAplicacioFields.USUARIAPLICACIOID.equal(perfilUsuariAplicacioForm.getPerfilUsuariAplicacio().getUsuariAplicacioID());
    }
    return getReferenceListForUsuariAplicacioID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForUsuariAplicacioID(HttpServletRequest request,
       ModelAndView mav, PerfilUsuariAplicacioFilterForm perfilUsuariAplicacioFilterForm,
       List<PerfilUsuariAplicacio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilUsuariAplicacioFilterForm.isHiddenField(USUARIAPLICACIOID)
      && !perfilUsuariAplicacioFilterForm.isGroupByField(USUARIAPLICACIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(USUARIAPLICACIOID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (PerfilUsuariAplicacio _item : list) {
        _pkList.add(_item.getUsuariAplicacioID());
        }
        _w = UsuariAplicacioFields.USUARIAPLICACIOID.in(_pkList);
      }
    return getReferenceListForUsuariAplicacioID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForUsuariAplicacioID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return usuariAplicacioRefList.getReferenceList(UsuariAplicacioFields.USUARIAPLICACIOID, where );
  }


  public void preValidate(HttpServletRequest request,PerfilUsuariAplicacioForm perfilUsuariAplicacioForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,PerfilUsuariAplicacioForm perfilUsuariAplicacioForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, PerfilUsuariAplicacioFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, PerfilUsuariAplicacioFilterForm filterForm,  List<PerfilUsuariAplicacio> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, PerfilUsuariAplicacioForm perfilUsuariAplicacioForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, PerfilUsuariAplicacioForm perfilUsuariAplicacioForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long perfilUsrAppID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long perfilUsrAppID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "perfilUsuariAplicacioFormWebDB";
  }

  public String getTileList() {
    return "perfilUsuariAplicacioListWebDB";
  }

  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public String getSessionAttributeFilterForm() {
    return "PerfilUsuariAplicacioWebDB_FilterForm";
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public PerfilUsuariAplicacioJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long perfilUsrAppID) throws I18NException {
    return (PerfilUsuariAplicacioJPA) perfilUsuariAplicacioEjb.findByPrimaryKey(perfilUsrAppID);
  }


  public PerfilUsuariAplicacioJPA create(HttpServletRequest request, PerfilUsuariAplicacioJPA perfilUsuariAplicacio)
    throws Exception,I18NException, I18NValidationException {
    return (PerfilUsuariAplicacioJPA) perfilUsuariAplicacioEjb.create(perfilUsuariAplicacio);
  }


  public PerfilUsuariAplicacioJPA update(HttpServletRequest request, PerfilUsuariAplicacioJPA perfilUsuariAplicacio)
    throws Exception,I18NException, I18NValidationException {
    return (PerfilUsuariAplicacioJPA) perfilUsuariAplicacioEjb.update(perfilUsuariAplicacio);
  }


  public void delete(HttpServletRequest request, PerfilUsuariAplicacio perfilUsuariAplicacio) throws Exception,I18NException {
    perfilUsuariAplicacioEjb.delete(perfilUsuariAplicacio);
  }

} // Final de Classe

