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
import es.caib.digitalib.back.form.webdb.TransaccioForm;

import es.caib.digitalib.back.validator.webdb.TransaccioWebValidator;

import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.jpa.FitxerJPA;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.*;

/**
 * Controller per gestionar un Transaccio
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/transaccio")
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class TransaccioController
    extends es.caib.digitalib.back.controller.DigitalIBFilesBaseController<Transaccio, java.lang.Long, TransaccioForm> implements TransaccioFields {

  @EJB(mappedName = es.caib.digitalib.ejb.TransaccioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.TransaccioLocal transaccioEjb;

  @Autowired
  private TransaccioWebValidator transaccioWebValidator;

  @Autowired
  protected TransaccioRefList transaccioRefList;

  // References 
  @Autowired
  protected PerfilRefList perfilRefList;

  // References 
  @Autowired
  protected InfoSignaturaRefList infoSignaturaRefList;

  // References 
  @Autowired
  protected InfoCustodyRefList infoCustodyRefList;

  /**
   * Llistat de totes Transaccio
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    TransaccioFilterForm ff;
    ff = (TransaccioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Transaccio de forma paginada
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
    llistat(mav, request, getTransaccioFilterForm(pagina, mav, request));
    return mav;
  }

  public TransaccioFilterForm getTransaccioFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    TransaccioFilterForm transaccioFilterForm;
    transaccioFilterForm = (TransaccioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(transaccioFilterForm == null) {
      transaccioFilterForm = new TransaccioFilterForm();
      transaccioFilterForm.setContexte(getContextWeb());
      transaccioFilterForm.setEntityNameCode(getEntityNameCode());
      transaccioFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      transaccioFilterForm.setNou(true);
    } else {
      transaccioFilterForm.setNou(false);
    }
    transaccioFilterForm.setPage(pagina == null ? 1 : pagina);
    return transaccioFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Transaccio de forma paginada
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
      @ModelAttribute TransaccioFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getTransaccioFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Transaccio de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Transaccio> llistat(ModelAndView mav, HttpServletRequest request,
     TransaccioFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Transaccio> transaccio = processarLlistat(transaccioEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("transaccioItems", transaccio);

    mav.addObject("transaccioFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, transaccio, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, transaccio);

    return transaccio;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(TransaccioFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Transaccio> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field estatCodi
    {
      _listSKV = getReferenceListForEstatCodi(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForEstatCodi(_tmp);
      if (filterForm.getGroupByFields().contains(ESTATCODI)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ESTATCODI, false);
      };
    }

    // Field infoScanPixelType
    {
      _listSKV = getReferenceListForInfoScanPixelType(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForInfoScanPixelType(_tmp);
      if (filterForm.getGroupByFields().contains(INFOSCANPIXELTYPE)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, INFOSCANPIXELTYPE, false);
      };
    }


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, INFOSCANOCR);

    // Field view
    {
      _listSKV = getReferenceListForView(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForView(_tmp);
      if (filterForm.getGroupByFields().contains(VIEW)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, VIEW, false);
      };
    }

    // Field signParamLanguageDoc
    {
      _listSKV = getReferenceListForSignParamLanguageDoc(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForSignParamLanguageDoc(_tmp);
      if (filterForm.getGroupByFields().contains(SIGNPARAMLANGUAGEDOC)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, SIGNPARAMLANGUAGEDOC, false);
      };
    }

    // Field arxiuReqParamDocEstatElabora
    {
      _listSKV = getReferenceListForArxiuReqParamDocEstatElabora(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForArxiuReqParamDocEstatElabora(_tmp);
      if (filterForm.getGroupByFields().contains(ARXIUREQPARAMDOCESTATELABORA)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ARXIUREQPARAMDOCESTATELABORA, false);
      };
    }

    // Field arxiuReqParamDocumentTipus
    {
      _listSKV = getReferenceListForArxiuReqParamDocumentTipus(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForArxiuReqParamDocumentTipus(_tmp);
      if (filterForm.getGroupByFields().contains(ARXIUREQPARAMDOCUMENTTIPUS)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ARXIUREQPARAMDOCUMENTTIPUS, false);
      };
    }

    // Field arxiuReqParamOrigen
    {
      _listSKV = getReferenceListForArxiuReqParamOrigen(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForArxiuReqParamOrigen(_tmp);
      if (filterForm.getGroupByFields().contains(ARXIUREQPARAMORIGEN)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ARXIUREQPARAMORIGEN, false);
      };
    }

    // Field perfilID
    {
      _listSKV = getReferenceListForPerfilID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPerfilForPerfilID(_tmp);
      if (filterForm.getGroupByFields().contains(PERFILID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PERFILID, false);
      };
    }

    // Field infoSignaturaID
    {
      _listSKV = getReferenceListForInfoSignaturaID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfInfoSignaturaForInfoSignaturaID(_tmp);
      if (filterForm.getGroupByFields().contains(INFOSIGNATURAID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, INFOSIGNATURAID, false);
      };
    }

    // Field infoCustodyID
    {
      _listSKV = getReferenceListForInfoCustodyID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfInfoCustodyForInfoCustodyID(_tmp);
      if (filterForm.getGroupByFields().contains(INFOCUSTODYID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, INFOCUSTODYID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    TransaccioFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Transaccio> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_TRANSACCIO_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(ESTATCODI, filterForm.getMapOfValuesForEstatCodi());
    __mapping.put(INFOSCANPIXELTYPE, filterForm.getMapOfValuesForInfoScanPixelType());
    __mapping.put(VIEW, filterForm.getMapOfValuesForView());
    __mapping.put(SIGNPARAMLANGUAGEDOC, filterForm.getMapOfValuesForSignParamLanguageDoc());
    __mapping.put(ARXIUREQPARAMDOCESTATELABORA, filterForm.getMapOfValuesForArxiuReqParamDocEstatElabora());
    __mapping.put(ARXIUREQPARAMDOCUMENTTIPUS, filterForm.getMapOfValuesForArxiuReqParamDocumentTipus());
    __mapping.put(ARXIUREQPARAMORIGEN, filterForm.getMapOfValuesForArxiuReqParamOrigen());
    __mapping.put(PERFILID, filterForm.getMapOfPerfilForPerfilID());
    __mapping.put(INFOSIGNATURAID, filterForm.getMapOfInfoSignaturaForInfoSignaturaID());
    __mapping.put(INFOCUSTODYID, filterForm.getMapOfInfoCustodyForInfoCustodyID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Transaccio
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearTransaccioGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    TransaccioForm transaccioForm = getTransaccioForm(null, false, request, mav);
    mav.addObject("transaccioForm" ,transaccioForm);
    fillReferencesForForm(transaccioForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public TransaccioForm getTransaccioForm(TransaccioJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    TransaccioForm transaccioForm;
    if(_jpa == null) {
      transaccioForm = new TransaccioForm(new TransaccioJPA(), true);
    } else {
      transaccioForm = new TransaccioForm(_jpa, false);
      transaccioForm.setView(__isView);
    }
    transaccioForm.setContexte(getContextWeb());
    transaccioForm.setEntityNameCode(getEntityNameCode());
    transaccioForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return transaccioForm;
  }

  public void fillReferencesForForm(TransaccioForm transaccioForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (transaccioForm.getListOfValuesForEstatCodi() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForEstatCodi(request, mav, transaccioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      transaccioForm.setListOfValuesForEstatCodi(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (transaccioForm.getListOfValuesForInfoScanPixelType() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForInfoScanPixelType(request, mav, transaccioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      transaccioForm.setListOfValuesForInfoScanPixelType(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (transaccioForm.getListOfValuesForView() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForView(request, mav, transaccioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      transaccioForm.setListOfValuesForView(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (transaccioForm.getListOfValuesForSignParamLanguageDoc() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForSignParamLanguageDoc(request, mav, transaccioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      transaccioForm.setListOfValuesForSignParamLanguageDoc(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (transaccioForm.getListOfValuesForArxiuReqParamDocEstatElabora() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForArxiuReqParamDocEstatElabora(request, mav, transaccioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      transaccioForm.setListOfValuesForArxiuReqParamDocEstatElabora(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (transaccioForm.getListOfValuesForArxiuReqParamDocumentTipus() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForArxiuReqParamDocumentTipus(request, mav, transaccioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      transaccioForm.setListOfValuesForArxiuReqParamDocumentTipus(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (transaccioForm.getListOfValuesForArxiuReqParamOrigen() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForArxiuReqParamOrigen(request, mav, transaccioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      transaccioForm.setListOfValuesForArxiuReqParamOrigen(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (transaccioForm.getListOfPerfilForPerfilID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPerfilID(request, mav, transaccioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      transaccioForm.setListOfPerfilForPerfilID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (transaccioForm.getListOfInfoSignaturaForInfoSignaturaID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForInfoSignaturaID(request, mav, transaccioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      transaccioForm.setListOfInfoSignaturaForInfoSignaturaID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (transaccioForm.getListOfInfoCustodyForInfoCustodyID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForInfoCustodyID(request, mav, transaccioForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      transaccioForm.setListOfInfoCustodyForInfoCustodyID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou Transaccio
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearTransaccioPost(@ModelAttribute TransaccioForm transaccioForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    TransaccioJPA transaccio = transaccioForm.getTransaccio();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE

    try {
      this.setFilesFormToEntity(afm, transaccio, transaccioForm); // FILE
      preValidate(request, transaccioForm, result);
      getWebValidator().validate(transaccioForm, result);
      postValidate(request,transaccioForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        transaccio = create(request, transaccio);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.creation", transaccio.getTransaccioID());
        transaccioForm.setTransaccio(transaccio);
        return getRedirectWhenCreated(request, transaccioForm);
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

  @RequestMapping(value = "/view/{transaccioID}", method = RequestMethod.GET)
  public ModelAndView veureTransaccioGet(@PathVariable("transaccioID") java.lang.Long transaccioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewTransaccioGet(transaccioID,
        request, response, true);
  }


  protected ModelAndView editAndViewTransaccioGet(@PathVariable("transaccioID") java.lang.Long transaccioID,
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
    TransaccioJPA transaccio = findByPrimaryKey(request, transaccioID);

    if (transaccio == null) {
      createMessageWarning(request, "error.notfound", transaccioID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, transaccioID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      TransaccioForm transaccioForm = getTransaccioForm(transaccio, __isView, request, mav);
      transaccioForm.setView(__isView);
      if(__isView) {
        transaccioForm.setAllFieldsReadOnly(ALL_TRANSACCIO_FIELDS);
        transaccioForm.setSaveButtonVisible(false);
        transaccioForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(transaccioForm, request, mav);
      mav.addObject("transaccioForm", transaccioForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Transaccio existent
   */
  @RequestMapping(value = "/{transaccioID}/edit", method = RequestMethod.GET)
  public ModelAndView editarTransaccioGet(@PathVariable("transaccioID") java.lang.Long transaccioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewTransaccioGet(transaccioID,
        request, response, false);
  }



  /**
   * Editar un Transaccio existent
   */
  @RequestMapping(value = "/{transaccioID}/edit", method = RequestMethod.POST)
  public String editarTransaccioPost(@ModelAttribute @Valid TransaccioForm transaccioForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    TransaccioJPA transaccio = transaccioForm.getTransaccio();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE
    try {
      this.setFilesFormToEntity(afm, transaccio, transaccioForm); // FILE
      preValidate(request, transaccioForm, result);
      getWebValidator().validate(transaccio, result);
      postValidate(request, transaccioForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        transaccio = update(request, transaccio);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.modification", transaccio.getTransaccioID());
        status.setComplete();
        return getRedirectWhenModified(request, transaccioForm, null);
      }
    } catch (Throwable __e) {
      afm.processErrorFilesWithoutThrowException(); // FILE
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          transaccio.getTransaccioID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, transaccioForm, __e);
    }

  }


  /**
   * Eliminar un Transaccio existent
   */
  @RequestMapping(value = "/{transaccioID}/delete")
  public String eliminarTransaccio(@PathVariable("transaccioID") java.lang.Long transaccioID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Transaccio transaccio = transaccioEjb.findByPrimaryKey(transaccioID);
      if (transaccio == null) {
        String __msg =createMessageError(request, "error.notfound", transaccioID);
        return getRedirectWhenDelete(request, transaccioID, new Exception(__msg));
      } else {
        delete(request, transaccio);
        createMessageSuccess(request, "success.deleted", transaccioID);
        return getRedirectWhenDelete(request, transaccioID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", transaccioID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, transaccioID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute TransaccioFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarTransaccio(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __transaccioID, Throwable e) {
    java.lang.Long transaccioID = (java.lang.Long)__transaccioID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (transaccioID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(transaccioID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "transaccio.transaccio";
  }

  public String getEntityNameCodePlural() {
    return "transaccio.transaccio.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("transaccio.transaccioID");
  }

  @InitBinder("transaccioFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("transaccioForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());

    binder.setDisallowedFields("transaccioID");

  }

  public TransaccioWebValidator getWebValidator() {
    return transaccioWebValidator;
  }


  public void setWebValidator(TransaccioWebValidator __val) {
    if (__val != null) {
      this.transaccioWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Transaccio
   */
  @RequestMapping(value = "/{transaccioID}/cancel")
  public String cancelTransaccio(@PathVariable("transaccioID") java.lang.Long transaccioID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, transaccioID);
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

  // FILE
  @Override
  public void setFilesFormToEntity(FilesFormManager<Fitxer> afm, Transaccio transaccio,
      TransaccioForm form) throws I18NException {

    FitxerJPA f;
    f = (FitxerJPA)afm.preProcessFile(form.getFitxerEscanejatID(), form.isFitxerEscanejatIDDelete(),
        form.isNou()? null : transaccio.getFitxerEscanejat());
    ((TransaccioJPA)transaccio).setFitxerEscanejat(f);
    if (f != null) { 
      transaccio.setFitxerEscanejatID(f.getFitxerID());
    } else {
      transaccio.setFitxerEscanejatID(null);
    }


    f = (FitxerJPA)afm.preProcessFile(form.getFitxerSignaturaID(), form.isFitxerSignaturaIDDelete(),
        form.isNou()? null : transaccio.getFitxerSignatura());
    ((TransaccioJPA)transaccio).setFitxerSignatura(f);
    if (f != null) { 
      transaccio.setFitxerSignaturaID(f.getFitxerID());
    } else {
      transaccio.setFitxerSignaturaID(null);
    }


  }

  // FILE
  @Override
  public void deleteFiles(Transaccio transaccio) {
    deleteFile(transaccio.getFitxerEscanejatID());
    deleteFile(transaccio.getFitxerSignaturaID());
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


  public List<StringKeyValue> getReferenceListForEstatCodi(HttpServletRequest request,
       ModelAndView mav, TransaccioForm transaccioForm, Where where)  throws I18NException {
    if (transaccioForm.isHiddenField(ESTATCODI)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForEstatCodi(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForEstatCodi(HttpServletRequest request,
       ModelAndView mav, TransaccioFilterForm transaccioFilterForm,
       List<Transaccio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (transaccioFilterForm.isHiddenField(ESTATCODI)
      && !transaccioFilterForm.isGroupByField(ESTATCODI)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForEstatCodi(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForEstatCodi(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("-3" , "-3"));
    __tmp.add(new StringKeyValue("-2" , "-2"));
    __tmp.add(new StringKeyValue("-1" , "-1"));
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForInfoScanPixelType(HttpServletRequest request,
       ModelAndView mav, TransaccioForm transaccioForm, Where where)  throws I18NException {
    if (transaccioForm.isHiddenField(INFOSCANPIXELTYPE)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForInfoScanPixelType(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForInfoScanPixelType(HttpServletRequest request,
       ModelAndView mav, TransaccioFilterForm transaccioFilterForm,
       List<Transaccio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (transaccioFilterForm.isHiddenField(INFOSCANPIXELTYPE)
      && !transaccioFilterForm.isGroupByField(INFOSCANPIXELTYPE)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForInfoScanPixelType(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForInfoScanPixelType(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("8" , "8"));
    __tmp.add(new StringKeyValue("32" , "32"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForView(HttpServletRequest request,
       ModelAndView mav, TransaccioForm transaccioForm, Where where)  throws I18NException {
    if (transaccioForm.isHiddenField(VIEW)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForView(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForView(HttpServletRequest request,
       ModelAndView mav, TransaccioFilterForm transaccioFilterForm,
       List<Transaccio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (transaccioFilterForm.isHiddenField(VIEW)
      && !transaccioFilterForm.isGroupByField(VIEW)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForView(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForView(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForSignParamLanguageDoc(HttpServletRequest request,
       ModelAndView mav, TransaccioForm transaccioForm, Where where)  throws I18NException {
    if (transaccioForm.isHiddenField(SIGNPARAMLANGUAGEDOC)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForSignParamLanguageDoc(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForSignParamLanguageDoc(HttpServletRequest request,
       ModelAndView mav, TransaccioFilterForm transaccioFilterForm,
       List<Transaccio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (transaccioFilterForm.isHiddenField(SIGNPARAMLANGUAGEDOC)
      && !transaccioFilterForm.isGroupByField(SIGNPARAMLANGUAGEDOC)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForSignParamLanguageDoc(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForSignParamLanguageDoc(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("ca" , "ca"));
    __tmp.add(new StringKeyValue("es" , "es"));
    __tmp.add(new StringKeyValue("en" , "en"));
    __tmp.add(new StringKeyValue("de" , "de"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForArxiuReqParamDocEstatElabora(HttpServletRequest request,
       ModelAndView mav, TransaccioForm transaccioForm, Where where)  throws I18NException {
    if (transaccioForm.isHiddenField(ARXIUREQPARAMDOCESTATELABORA)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForArxiuReqParamDocEstatElabora(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForArxiuReqParamDocEstatElabora(HttpServletRequest request,
       ModelAndView mav, TransaccioFilterForm transaccioFilterForm,
       List<Transaccio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (transaccioFilterForm.isHiddenField(ARXIUREQPARAMDOCESTATELABORA)
      && !transaccioFilterForm.isGroupByField(ARXIUREQPARAMDOCESTATELABORA)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForArxiuReqParamDocEstatElabora(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForArxiuReqParamDocEstatElabora(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("EE01" , "EE01"));
    __tmp.add(new StringKeyValue("EE02" , "EE02"));
    __tmp.add(new StringKeyValue("EE03" , "EE03"));
    __tmp.add(new StringKeyValue("EE04" , "EE04"));
    __tmp.add(new StringKeyValue("EE99" , "EE99"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForArxiuReqParamDocumentTipus(HttpServletRequest request,
       ModelAndView mav, TransaccioForm transaccioForm, Where where)  throws I18NException {
    if (transaccioForm.isHiddenField(ARXIUREQPARAMDOCUMENTTIPUS)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForArxiuReqParamDocumentTipus(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForArxiuReqParamDocumentTipus(HttpServletRequest request,
       ModelAndView mav, TransaccioFilterForm transaccioFilterForm,
       List<Transaccio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (transaccioFilterForm.isHiddenField(ARXIUREQPARAMDOCUMENTTIPUS)
      && !transaccioFilterForm.isGroupByField(ARXIUREQPARAMDOCUMENTTIPUS)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForArxiuReqParamDocumentTipus(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForArxiuReqParamDocumentTipus(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("TD01" , "TD01"));
    __tmp.add(new StringKeyValue("TD02" , "TD02"));
    __tmp.add(new StringKeyValue("TD03" , "TD03"));
    __tmp.add(new StringKeyValue("TD04" , "TD04"));
    __tmp.add(new StringKeyValue("TD05" , "TD05"));
    __tmp.add(new StringKeyValue("TD06" , "TD06"));
    __tmp.add(new StringKeyValue("TD07" , "TD07"));
    __tmp.add(new StringKeyValue("TD08" , "TD08"));
    __tmp.add(new StringKeyValue("TD09" , "TD09"));
    __tmp.add(new StringKeyValue("TD10" , "TD10"));
    __tmp.add(new StringKeyValue("TD11" , "TD11"));
    __tmp.add(new StringKeyValue("TD12" , "TD12"));
    __tmp.add(new StringKeyValue("TD13" , "TD13"));
    __tmp.add(new StringKeyValue("TD14" , "TD14"));
    __tmp.add(new StringKeyValue("TD15" , "TD15"));
    __tmp.add(new StringKeyValue("TD16" , "TD16"));
    __tmp.add(new StringKeyValue("TD17" , "TD17"));
    __tmp.add(new StringKeyValue("TD18" , "TD18"));
    __tmp.add(new StringKeyValue("TD19" , "TD19"));
    __tmp.add(new StringKeyValue("TD20" , "TD20"));
    __tmp.add(new StringKeyValue("TD99" , "TD99"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForArxiuReqParamOrigen(HttpServletRequest request,
       ModelAndView mav, TransaccioForm transaccioForm, Where where)  throws I18NException {
    if (transaccioForm.isHiddenField(ARXIUREQPARAMORIGEN)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForArxiuReqParamOrigen(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForArxiuReqParamOrigen(HttpServletRequest request,
       ModelAndView mav, TransaccioFilterForm transaccioFilterForm,
       List<Transaccio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (transaccioFilterForm.isHiddenField(ARXIUREQPARAMORIGEN)
      && !transaccioFilterForm.isGroupByField(ARXIUREQPARAMORIGEN)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForArxiuReqParamOrigen(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForArxiuReqParamOrigen(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForPerfilID(HttpServletRequest request,
       ModelAndView mav, TransaccioForm transaccioForm, Where where)  throws I18NException {
    if (transaccioForm.isHiddenField(PERFILID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _where = null;
    if (transaccioForm.isReadOnlyField(PERFILID)) {
      _where = PerfilFields.PERFILID.equal(transaccioForm.getTransaccio().getPerfilID());
    }
    return getReferenceListForPerfilID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPerfilID(HttpServletRequest request,
       ModelAndView mav, TransaccioFilterForm transaccioFilterForm,
       List<Transaccio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (transaccioFilterForm.isHiddenField(PERFILID)
      && !transaccioFilterForm.isGroupByField(PERFILID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PERFILID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Transaccio _item : list) {
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


  public List<StringKeyValue> getReferenceListForInfoSignaturaID(HttpServletRequest request,
       ModelAndView mav, TransaccioForm transaccioForm, Where where)  throws I18NException {
    if (transaccioForm.isHiddenField(INFOSIGNATURAID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _where = null;
    if (transaccioForm.isReadOnlyField(INFOSIGNATURAID)) {
      _where = InfoSignaturaFields.INFOSIGNATURAID.equal(transaccioForm.getTransaccio().getInfoSignaturaID());
    }
    return getReferenceListForInfoSignaturaID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForInfoSignaturaID(HttpServletRequest request,
       ModelAndView mav, TransaccioFilterForm transaccioFilterForm,
       List<Transaccio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (transaccioFilterForm.isHiddenField(INFOSIGNATURAID)
      && !transaccioFilterForm.isGroupByField(INFOSIGNATURAID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(INFOSIGNATURAID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Transaccio _item : list) {
        if(_item.getInfoSignaturaID() == null) { continue; };
        _pkList.add(_item.getInfoSignaturaID());
        }
        _w = InfoSignaturaFields.INFOSIGNATURAID.in(_pkList);
      }
    return getReferenceListForInfoSignaturaID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForInfoSignaturaID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return infoSignaturaRefList.getReferenceList(InfoSignaturaFields.INFOSIGNATURAID, where );
  }


  public List<StringKeyValue> getReferenceListForInfoCustodyID(HttpServletRequest request,
       ModelAndView mav, TransaccioForm transaccioForm, Where where)  throws I18NException {
    if (transaccioForm.isHiddenField(INFOCUSTODYID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _where = null;
    if (transaccioForm.isReadOnlyField(INFOCUSTODYID)) {
      _where = InfoCustodyFields.INFOCUSTODYID.equal(transaccioForm.getTransaccio().getInfoCustodyID());
    }
    return getReferenceListForInfoCustodyID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForInfoCustodyID(HttpServletRequest request,
       ModelAndView mav, TransaccioFilterForm transaccioFilterForm,
       List<Transaccio> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (transaccioFilterForm.isHiddenField(INFOCUSTODYID)
      && !transaccioFilterForm.isGroupByField(INFOCUSTODYID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(INFOCUSTODYID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Transaccio _item : list) {
        if(_item.getInfoCustodyID() == null) { continue; };
        _pkList.add(_item.getInfoCustodyID());
        }
        _w = InfoCustodyFields.INFOCUSTODYID.in(_pkList);
      }
    return getReferenceListForInfoCustodyID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForInfoCustodyID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return infoCustodyRefList.getReferenceList(InfoCustodyFields.INFOCUSTODYID, where );
  }


  public void preValidate(HttpServletRequest request,TransaccioForm transaccioForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,TransaccioForm transaccioForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, TransaccioFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, TransaccioFilterForm filterForm,  List<Transaccio> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, TransaccioForm transaccioForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, TransaccioForm transaccioForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long transaccioID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long transaccioID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "transaccioFormWebDB";
  }

  public String getTileList() {
    return "transaccioListWebDB";
  }

  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public String getSessionAttributeFilterForm() {
    return "TransaccioWebDB_FilterForm";
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public TransaccioJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long transaccioID) throws I18NException {
    return (TransaccioJPA) transaccioEjb.findByPrimaryKey(transaccioID);
  }


  public TransaccioJPA create(HttpServletRequest request, TransaccioJPA transaccio)
    throws Exception,I18NException, I18NValidationException {
    return (TransaccioJPA) transaccioEjb.create(transaccio);
  }


  public TransaccioJPA update(HttpServletRequest request, TransaccioJPA transaccio)
    throws Exception,I18NException, I18NValidationException {
    return (TransaccioJPA) transaccioEjb.update(transaccio);
  }


  public void delete(HttpServletRequest request, Transaccio transaccio) throws Exception,I18NException {
    transaccioEjb.delete(transaccio);
  }

} // Final de Classe

