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
import es.caib.digitalib.back.form.webdb.UsuariPersonaForm;

import es.caib.digitalib.back.validator.webdb.UsuariPersonaWebValidator;

import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.model.entity.UsuariPersona;
import es.caib.digitalib.model.fields.*;

/**
 * Controller per gestionar un UsuariPersona
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/usuariPersona")
@SessionAttributes(types = { UsuariPersonaForm.class, UsuariPersonaFilterForm.class })
public class UsuariPersonaController
    extends es.caib.digitalib.back.controller.DigitalIBBaseController<UsuariPersona, java.lang.Long> implements UsuariPersonaFields {

  @EJB(mappedName = es.caib.digitalib.ejb.UsuariPersonaLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.UsuariPersonaLocal usuariPersonaEjb;

  @Autowired
  private UsuariPersonaWebValidator usuariPersonaWebValidator;

  @Autowired
  protected UsuariPersonaRefList usuariPersonaRefList;

  // References 
  @Autowired
  protected IdiomaRefList idiomaRefList;

  // References 
  @Autowired
  protected ConfiguracioGrupRefList configuracioGrupRefList;

  /**
   * Llistat de totes UsuariPersona
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    UsuariPersonaFilterForm ff;
    ff = (UsuariPersonaFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar UsuariPersona de forma paginada
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
    llistat(mav, request, getUsuariPersonaFilterForm(pagina, mav, request));
    return mav;
  }

  public UsuariPersonaFilterForm getUsuariPersonaFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    UsuariPersonaFilterForm usuariPersonaFilterForm;
    usuariPersonaFilterForm = (UsuariPersonaFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(usuariPersonaFilterForm == null) {
      usuariPersonaFilterForm = new UsuariPersonaFilterForm();
      usuariPersonaFilterForm.setContexte(getContextWeb());
      usuariPersonaFilterForm.setEntityNameCode(getEntityNameCode());
      usuariPersonaFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      usuariPersonaFilterForm.setNou(true);
    } else {
      usuariPersonaFilterForm.setNou(false);
    }
    usuariPersonaFilterForm.setPage(pagina == null ? 1 : pagina);
    return usuariPersonaFilterForm;
  }

  /**
   * Segona i següent peticions per llistar UsuariPersona de forma paginada
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
      @ModelAttribute UsuariPersonaFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getUsuariPersonaFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de UsuariPersona de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<UsuariPersona> llistat(ModelAndView mav, HttpServletRequest request,
     UsuariPersonaFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<UsuariPersona> usuariPersona = processarLlistat(usuariPersonaEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("usuariPersonaItems", usuariPersona);

    mav.addObject("usuariPersonaFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, usuariPersona, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, usuariPersona);

    return usuariPersona;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(UsuariPersonaFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<UsuariPersona> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field idiomaID
    {
      _listSKV = getReferenceListForIdiomaID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfIdiomaForIdiomaID(_tmp);
      if (filterForm.getGroupByFields().contains(IDIOMAID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, IDIOMAID, false);
      };
    }

    // Field configuracioGrupID
    {
      _listSKV = getReferenceListForConfiguracioGrupID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfConfiguracioGrupForConfiguracioGrupID(_tmp);
      if (filterForm.getGroupByFields().contains(CONFIGURACIOGRUPID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, CONFIGURACIOGRUPID, false);
      };
    }


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, ROLESCAN);


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, ROLECOAU);


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, ROLECUST);


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    UsuariPersonaFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<UsuariPersona> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_USUARIPERSONA_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(IDIOMAID, filterForm.getMapOfIdiomaForIdiomaID());
    __mapping.put(CONFIGURACIOGRUPID, filterForm.getMapOfConfiguracioGrupForConfiguracioGrupID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou UsuariPersona
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearUsuariPersonaGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    UsuariPersonaForm usuariPersonaForm = getUsuariPersonaForm(null, false, request, mav);
    mav.addObject("usuariPersonaForm" ,usuariPersonaForm);
    fillReferencesForForm(usuariPersonaForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public UsuariPersonaForm getUsuariPersonaForm(UsuariPersonaJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    UsuariPersonaForm usuariPersonaForm;
    if(_jpa == null) {
      usuariPersonaForm = new UsuariPersonaForm(new UsuariPersonaJPA(), true);
    } else {
      usuariPersonaForm = new UsuariPersonaForm(_jpa, false);
      usuariPersonaForm.setView(__isView);
    }
    usuariPersonaForm.setContexte(getContextWeb());
    usuariPersonaForm.setEntityNameCode(getEntityNameCode());
    usuariPersonaForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return usuariPersonaForm;
  }

  public void fillReferencesForForm(UsuariPersonaForm usuariPersonaForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (usuariPersonaForm.getListOfIdiomaForIdiomaID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForIdiomaID(request, mav, usuariPersonaForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      usuariPersonaForm.setListOfIdiomaForIdiomaID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (usuariPersonaForm.getListOfConfiguracioGrupForConfiguracioGrupID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForConfiguracioGrupID(request, mav, usuariPersonaForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      usuariPersonaForm.setListOfConfiguracioGrupForConfiguracioGrupID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou UsuariPersona
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearUsuariPersonaPost(@ModelAttribute UsuariPersonaForm usuariPersonaForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    UsuariPersonaJPA usuariPersona = usuariPersonaForm.getUsuariPersona();

    try {
      preValidate(request, usuariPersonaForm, result);
      getWebValidator().validate(usuariPersonaForm, result);
      postValidate(request,usuariPersonaForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        usuariPersona = create(request, usuariPersona);
        createMessageSuccess(request, "success.creation", usuariPersona.getUsuariPersonaID());
        usuariPersonaForm.setUsuariPersona(usuariPersona);
        return getRedirectWhenCreated(request, usuariPersonaForm);
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

  @RequestMapping(value = "/view/{usuariPersonaID}", method = RequestMethod.GET)
  public ModelAndView veureUsuariPersonaGet(@PathVariable("usuariPersonaID") java.lang.Long usuariPersonaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewUsuariPersonaGet(usuariPersonaID,
        request, response, true);
  }


  protected ModelAndView editAndViewUsuariPersonaGet(@PathVariable("usuariPersonaID") java.lang.Long usuariPersonaID,
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
    UsuariPersonaJPA usuariPersona = findByPrimaryKey(request, usuariPersonaID);

    if (usuariPersona == null) {
      createMessageWarning(request, "error.notfound", usuariPersonaID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, usuariPersonaID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      UsuariPersonaForm usuariPersonaForm = getUsuariPersonaForm(usuariPersona, __isView, request, mav);
      usuariPersonaForm.setView(__isView);
      if(__isView) {
        usuariPersonaForm.setAllFieldsReadOnly(ALL_USUARIPERSONA_FIELDS);
        usuariPersonaForm.setSaveButtonVisible(false);
        usuariPersonaForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(usuariPersonaForm, request, mav);
      mav.addObject("usuariPersonaForm", usuariPersonaForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un UsuariPersona existent
   */
  @RequestMapping(value = "/{usuariPersonaID}/edit", method = RequestMethod.GET)
  public ModelAndView editarUsuariPersonaGet(@PathVariable("usuariPersonaID") java.lang.Long usuariPersonaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewUsuariPersonaGet(usuariPersonaID,
        request, response, false);
  }



  /**
   * Editar un UsuariPersona existent
   */
  @RequestMapping(value = "/{usuariPersonaID}/edit", method = RequestMethod.POST)
  public String editarUsuariPersonaPost(@ModelAttribute @Valid UsuariPersonaForm usuariPersonaForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    UsuariPersonaJPA usuariPersona = usuariPersonaForm.getUsuariPersona();

    try {
      preValidate(request, usuariPersonaForm, result);
      getWebValidator().validate(usuariPersona, result);
      postValidate(request, usuariPersonaForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        usuariPersona = update(request, usuariPersona);
        createMessageSuccess(request, "success.modification", usuariPersona.getUsuariPersonaID());
        status.setComplete();
        return getRedirectWhenModified(request, usuariPersonaForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          usuariPersona.getUsuariPersonaID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, usuariPersonaForm, __e);
    }

  }


  /**
   * Eliminar un UsuariPersona existent
   */
  @RequestMapping(value = "/{usuariPersonaID}/delete")
  public String eliminarUsuariPersona(@PathVariable("usuariPersonaID") java.lang.Long usuariPersonaID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      UsuariPersona usuariPersona = usuariPersonaEjb.findByPrimaryKey(usuariPersonaID);
      if (usuariPersona == null) {
        String __msg =createMessageError(request, "error.notfound", usuariPersonaID);
        return getRedirectWhenDelete(request, usuariPersonaID, new Exception(__msg));
      } else {
        delete(request, usuariPersona);
        createMessageSuccess(request, "success.deleted", usuariPersonaID);
        return getRedirectWhenDelete(request, usuariPersonaID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", usuariPersonaID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, usuariPersonaID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute UsuariPersonaFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarUsuariPersona(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __usuariPersonaID, Throwable e) {
    java.lang.Long usuariPersonaID = (java.lang.Long)__usuariPersonaID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (usuariPersonaID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(usuariPersonaID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "usuariPersona.usuariPersona";
  }

  public String getEntityNameCodePlural() {
    return "usuariPersona.usuariPersona.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("usuariPersona.usuariPersonaID");
  }

  @InitBinder("usuariPersonaFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("usuariPersonaForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());

    binder.setDisallowedFields("usuariPersonaID");

  }

  public UsuariPersonaWebValidator getWebValidator() {
    return usuariPersonaWebValidator;
  }


  public void setWebValidator(UsuariPersonaWebValidator __val) {
    if (__val != null) {
      this.usuariPersonaWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de UsuariPersona
   */
  @RequestMapping(value = "/{usuariPersonaID}/cancel")
  public String cancelUsuariPersona(@PathVariable("usuariPersonaID") java.lang.Long usuariPersonaID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, usuariPersonaID);
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


  public List<StringKeyValue> getReferenceListForIdiomaID(HttpServletRequest request,
       ModelAndView mav, UsuariPersonaForm usuariPersonaForm, Where where)  throws I18NException {
    if (usuariPersonaForm.isHiddenField(IDIOMAID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _where = null;
    if (usuariPersonaForm.isReadOnlyField(IDIOMAID)) {
      _where = IdiomaFields.IDIOMAID.equal(usuariPersonaForm.getUsuariPersona().getIdiomaID());
    }
    return getReferenceListForIdiomaID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForIdiomaID(HttpServletRequest request,
       ModelAndView mav, UsuariPersonaFilterForm usuariPersonaFilterForm,
       List<UsuariPersona> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (usuariPersonaFilterForm.isHiddenField(IDIOMAID)
      && !usuariPersonaFilterForm.isGroupByField(IDIOMAID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(IDIOMAID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.String> _pkList = new java.util.HashSet<java.lang.String>();
      for (UsuariPersona _item : list) {
        _pkList.add(_item.getIdiomaID());
        }
        _w = IdiomaFields.IDIOMAID.in(_pkList);
      }
    return getReferenceListForIdiomaID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForIdiomaID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return idiomaRefList.getReferenceList(IdiomaFields.IDIOMAID, where );
  }


  public List<StringKeyValue> getReferenceListForConfiguracioGrupID(HttpServletRequest request,
       ModelAndView mav, UsuariPersonaForm usuariPersonaForm, Where where)  throws I18NException {
    if (usuariPersonaForm.isHiddenField(CONFIGURACIOGRUPID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _where = null;
    if (usuariPersonaForm.isReadOnlyField(CONFIGURACIOGRUPID)) {
      _where = ConfiguracioGrupFields.CONFIGURACIOGRUPID.equal(usuariPersonaForm.getUsuariPersona().getConfiguracioGrupID());
    }
    return getReferenceListForConfiguracioGrupID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForConfiguracioGrupID(HttpServletRequest request,
       ModelAndView mav, UsuariPersonaFilterForm usuariPersonaFilterForm,
       List<UsuariPersona> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (usuariPersonaFilterForm.isHiddenField(CONFIGURACIOGRUPID)
      && !usuariPersonaFilterForm.isGroupByField(CONFIGURACIOGRUPID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(CONFIGURACIOGRUPID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (UsuariPersona _item : list) {
        if(_item.getConfiguracioGrupID() == null) { continue; };
        _pkList.add(_item.getConfiguracioGrupID());
        }
        _w = ConfiguracioGrupFields.CONFIGURACIOGRUPID.in(_pkList);
      }
    return getReferenceListForConfiguracioGrupID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForConfiguracioGrupID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return configuracioGrupRefList.getReferenceList(ConfiguracioGrupFields.CONFIGURACIOGRUPID, where );
  }


  public void preValidate(HttpServletRequest request,UsuariPersonaForm usuariPersonaForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,UsuariPersonaForm usuariPersonaForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, UsuariPersonaFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, UsuariPersonaFilterForm filterForm,  List<UsuariPersona> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, UsuariPersonaForm usuariPersonaForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, UsuariPersonaForm usuariPersonaForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long usuariPersonaID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long usuariPersonaID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "usuariPersonaFormWebDB";
  }

  public String getTileList() {
    return "usuariPersonaListWebDB";
  }

  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public String getSessionAttributeFilterForm() {
    return "UsuariPersonaWebDB_FilterForm";
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public UsuariPersonaJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long usuariPersonaID) throws I18NException {
    return (UsuariPersonaJPA) usuariPersonaEjb.findByPrimaryKey(usuariPersonaID);
  }


  public UsuariPersonaJPA create(HttpServletRequest request, UsuariPersonaJPA usuariPersona)
    throws Exception,I18NException, I18NValidationException {
    return (UsuariPersonaJPA) usuariPersonaEjb.create(usuariPersona);
  }


  public UsuariPersonaJPA update(HttpServletRequest request, UsuariPersonaJPA usuariPersona)
    throws Exception,I18NException, I18NValidationException {
    return (UsuariPersonaJPA) usuariPersonaEjb.update(usuariPersona);
  }


  public void delete(HttpServletRequest request, UsuariPersona usuariPersona) throws Exception,I18NException {
    usuariPersonaEjb.delete(usuariPersona);
  }

} // Final de Classe
