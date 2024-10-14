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

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import es.caib.digitalib.back.form.webdb.*;
import es.caib.digitalib.back.form.webdb.ConfiguracioGrupForm;

import es.caib.digitalib.back.validator.webdb.ConfiguracioGrupWebValidator;

import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.persistence.FitxerJPA;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import es.caib.digitalib.persistence.ConfiguracioGrupJPA;
import es.caib.digitalib.model.entity.ConfiguracioGrup;
import es.caib.digitalib.model.fields.*;

/**
 * Controller per gestionar un ConfiguracioGrup
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/configuracioGrup")
@SessionAttributes(types = { ConfiguracioGrupForm.class, ConfiguracioGrupFilterForm.class })
public class ConfiguracioGrupController
    extends es.caib.digitalib.back.controller.DigitalIBFilesBaseController<ConfiguracioGrup, java.lang.Long, ConfiguracioGrupForm> implements ConfiguracioGrupFields {

  @EJB(mappedName = es.caib.digitalib.ejb.ConfiguracioGrupService.JNDI_NAME)
  protected es.caib.digitalib.ejb.ConfiguracioGrupService configuracioGrupEjb;

  @Autowired
  private ConfiguracioGrupWebValidator configuracioGrupWebValidator;

  @Autowired
  protected ConfiguracioGrupRefList configuracioGrupRefList;

  // References 
  @Autowired
  protected PerfilRefList perfilRefList;

  /**
   * Llistat de totes ConfiguracioGrup
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    ConfiguracioGrupFilterForm ff;
    ff = (ConfiguracioGrupFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar ConfiguracioGrup de forma paginada
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
    llistat(mav, request, getConfiguracioGrupFilterForm(pagina, mav, request));
    return mav;
  }

  public ConfiguracioGrupFilterForm getConfiguracioGrupFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    ConfiguracioGrupFilterForm configuracioGrupFilterForm;
    configuracioGrupFilterForm = (ConfiguracioGrupFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(configuracioGrupFilterForm == null) {
      configuracioGrupFilterForm = new ConfiguracioGrupFilterForm();
      configuracioGrupFilterForm.setContexte(getContextWeb());
      configuracioGrupFilterForm.setEntityNameCode(getEntityNameCode());
      configuracioGrupFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      configuracioGrupFilterForm.setNou(true);
    } else {
      configuracioGrupFilterForm.setNou(false);
    }
    configuracioGrupFilterForm.setPage(pagina == null ? 1 : pagina);
    return configuracioGrupFilterForm;
  }

  /**
   * Segona i següent peticions per llistar ConfiguracioGrup de forma paginada
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
      @ModelAttribute ConfiguracioGrupFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getConfiguracioGrupFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de ConfiguracioGrup de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<ConfiguracioGrup> llistat(ModelAndView mav, HttpServletRequest request,
     ConfiguracioGrupFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<ConfiguracioGrup> configuracioGrup = processarLlistat(configuracioGrupEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("configuracioGrupItems", configuracioGrup);

    mav.addObject("configuracioGrupFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, configuracioGrup, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, configuracioGrup);

    return configuracioGrup;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(ConfiguracioGrupFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<ConfiguracioGrup> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field perfilNomesEscaneigID
    {
      _listSKV = getReferenceListForPerfilNomesEscaneigID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPerfilForPerfilNomesEscaneigID(_tmp);
      if (filterForm.getGroupByFields().contains(PERFILNOMESESCANEIGID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PERFILNOMESESCANEIGID, false);
      };
    }

    // Field perfilNomesEscaneig2ID
    {
      _listSKV = getReferenceListForPerfilNomesEscaneig2ID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPerfilForPerfilNomesEscaneig2ID(_tmp);
      if (filterForm.getGroupByFields().contains(PERFILNOMESESCANEIG2ID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PERFILNOMESESCANEIG2ID, false);
      };
    }

    // Field perfilCopiaAutenticaID
    {
      _listSKV = getReferenceListForPerfilCopiaAutenticaID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPerfilForPerfilCopiaAutenticaID(_tmp);
      if (filterForm.getGroupByFields().contains(PERFILCOPIAAUTENTICAID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PERFILCOPIAAUTENTICAID, false);
      };
    }

    // Field perfilCopiaAutentica2ID
    {
      _listSKV = getReferenceListForPerfilCopiaAutentica2ID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPerfilForPerfilCopiaAutentica2ID(_tmp);
      if (filterForm.getGroupByFields().contains(PERFILCOPIAAUTENTICA2ID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PERFILCOPIAAUTENTICA2ID, false);
      };
    }

    // Field perfilCustodiaID
    {
      _listSKV = getReferenceListForPerfilCustodiaID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPerfilForPerfilCustodiaID(_tmp);
      if (filterForm.getGroupByFields().contains(PERFILCUSTODIAID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PERFILCUSTODIAID, false);
      };
    }

    // Field perfilCustodia2ID
    {
      _listSKV = getReferenceListForPerfilCustodia2ID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPerfilForPerfilCustodia2ID(_tmp);
      if (filterForm.getGroupByFields().contains(PERFILCUSTODIA2ID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PERFILCUSTODIA2ID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    ConfiguracioGrupFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<ConfiguracioGrup> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_CONFIGURACIOGRUP_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(PERFILNOMESESCANEIGID, filterForm.getMapOfPerfilForPerfilNomesEscaneigID());
    __mapping.put(PERFILNOMESESCANEIG2ID, filterForm.getMapOfPerfilForPerfilNomesEscaneig2ID());
    __mapping.put(PERFILCOPIAAUTENTICAID, filterForm.getMapOfPerfilForPerfilCopiaAutenticaID());
    __mapping.put(PERFILCOPIAAUTENTICA2ID, filterForm.getMapOfPerfilForPerfilCopiaAutentica2ID());
    __mapping.put(PERFILCUSTODIAID, filterForm.getMapOfPerfilForPerfilCustodiaID());
    __mapping.put(PERFILCUSTODIA2ID, filterForm.getMapOfPerfilForPerfilCustodia2ID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou ConfiguracioGrup
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearConfiguracioGrupGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    ConfiguracioGrupForm configuracioGrupForm = getConfiguracioGrupForm(null, false, request, mav);
    mav.addObject("configuracioGrupForm" ,configuracioGrupForm);
    fillReferencesForForm(configuracioGrupForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public ConfiguracioGrupForm getConfiguracioGrupForm(ConfiguracioGrupJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    ConfiguracioGrupForm configuracioGrupForm;
    if(_jpa == null) {
      configuracioGrupForm = new ConfiguracioGrupForm(new ConfiguracioGrupJPA(), true);
    } else {
      configuracioGrupForm = new ConfiguracioGrupForm(_jpa, false);
      configuracioGrupForm.setView(__isView);
    }
    configuracioGrupForm.setContexte(getContextWeb());
    configuracioGrupForm.setEntityNameCode(getEntityNameCode());
    configuracioGrupForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return configuracioGrupForm;
  }

  public void fillReferencesForForm(ConfiguracioGrupForm configuracioGrupForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (configuracioGrupForm.getListOfPerfilForPerfilNomesEscaneigID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPerfilNomesEscaneigID(request, mav, configuracioGrupForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      configuracioGrupForm.setListOfPerfilForPerfilNomesEscaneigID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (configuracioGrupForm.getListOfPerfilForPerfilNomesEscaneig2ID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPerfilNomesEscaneig2ID(request, mav, configuracioGrupForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      configuracioGrupForm.setListOfPerfilForPerfilNomesEscaneig2ID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (configuracioGrupForm.getListOfPerfilForPerfilCopiaAutenticaID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPerfilCopiaAutenticaID(request, mav, configuracioGrupForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      configuracioGrupForm.setListOfPerfilForPerfilCopiaAutenticaID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (configuracioGrupForm.getListOfPerfilForPerfilCopiaAutentica2ID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPerfilCopiaAutentica2ID(request, mav, configuracioGrupForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      configuracioGrupForm.setListOfPerfilForPerfilCopiaAutentica2ID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (configuracioGrupForm.getListOfPerfilForPerfilCustodiaID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPerfilCustodiaID(request, mav, configuracioGrupForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      configuracioGrupForm.setListOfPerfilForPerfilCustodiaID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (configuracioGrupForm.getListOfPerfilForPerfilCustodia2ID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPerfilCustodia2ID(request, mav, configuracioGrupForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      configuracioGrupForm.setListOfPerfilForPerfilCustodia2ID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou ConfiguracioGrup
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearConfiguracioGrupPost(@ModelAttribute ConfiguracioGrupForm configuracioGrupForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ConfiguracioGrupJPA configuracioGrup = configuracioGrupForm.getConfiguracioGrup();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE

    try {
      this.setFilesFormToEntity(afm, configuracioGrup, configuracioGrupForm); // FILE
      preValidate(request, configuracioGrupForm, result);
      getWebValidator().validate(configuracioGrupForm, result);
      postValidate(request,configuracioGrupForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        configuracioGrup = create(request, configuracioGrup);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.creation", configuracioGrup.getConfiguracioGrupID());
        configuracioGrupForm.setConfiguracioGrup(configuracioGrup);
        return getRedirectWhenCreated(request, configuracioGrupForm);
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

  @RequestMapping(value = "/view/{configuracioGrupID}", method = RequestMethod.GET)
  public ModelAndView veureConfiguracioGrupGet(@PathVariable("configuracioGrupID") java.lang.Long configuracioGrupID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewConfiguracioGrupGet(configuracioGrupID,
        request, response, true);
  }


  protected ModelAndView editAndViewConfiguracioGrupGet(@PathVariable("configuracioGrupID") java.lang.Long configuracioGrupID,
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
    ConfiguracioGrupJPA configuracioGrup = findByPrimaryKey(request, configuracioGrupID);

    if (configuracioGrup == null) {
      createMessageWarning(request, "error.notfound", configuracioGrupID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, configuracioGrupID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      ConfiguracioGrupForm configuracioGrupForm = getConfiguracioGrupForm(configuracioGrup, __isView, request, mav);
      configuracioGrupForm.setView(__isView);
      if(__isView) {
        configuracioGrupForm.setAllFieldsReadOnly(ALL_CONFIGURACIOGRUP_FIELDS);
        configuracioGrupForm.setSaveButtonVisible(false);
        configuracioGrupForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(configuracioGrupForm, request, mav);
      mav.addObject("configuracioGrupForm", configuracioGrupForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un ConfiguracioGrup existent
   */
  @RequestMapping(value = "/{configuracioGrupID}/edit", method = RequestMethod.GET)
  public ModelAndView editarConfiguracioGrupGet(@PathVariable("configuracioGrupID") java.lang.Long configuracioGrupID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewConfiguracioGrupGet(configuracioGrupID,
        request, response, false);
  }



  /**
   * Editar un ConfiguracioGrup existent
   */
  @RequestMapping(value = "/{configuracioGrupID}/edit", method = RequestMethod.POST)
  public String editarConfiguracioGrupPost(@ModelAttribute ConfiguracioGrupForm configuracioGrupForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ConfiguracioGrupJPA configuracioGrup = configuracioGrupForm.getConfiguracioGrup();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE
    try {
      this.setFilesFormToEntity(afm, configuracioGrup, configuracioGrupForm); // FILE
      preValidate(request, configuracioGrupForm, result);
      getWebValidator().validate(configuracioGrupForm, result);
      postValidate(request, configuracioGrupForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        configuracioGrup = update(request, configuracioGrup);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.modification", configuracioGrup.getConfiguracioGrupID());
        status.setComplete();
        return getRedirectWhenModified(request, configuracioGrupForm, null);
      }
    } catch (Throwable __e) {
      afm.processErrorFilesWithoutThrowException(); // FILE
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          configuracioGrup.getConfiguracioGrupID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, configuracioGrupForm, __e);
    }

  }


  /**
   * Eliminar un ConfiguracioGrup existent
   */
  @RequestMapping(value = "/{configuracioGrupID}/delete")
  public String eliminarConfiguracioGrup(@PathVariable("configuracioGrupID") java.lang.Long configuracioGrupID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      ConfiguracioGrup configuracioGrup = this.findByPrimaryKey(request, configuracioGrupID);
      if (configuracioGrup == null) {
        String __msg = createMessageError(request, "error.notfound", configuracioGrupID);
        return getRedirectWhenDelete(request, configuracioGrupID, new Exception(__msg));
      } else {
        delete(request, configuracioGrup);
        createMessageSuccess(request, "success.deleted", configuracioGrupID);
        return getRedirectWhenDelete(request, configuracioGrupID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", configuracioGrupID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, configuracioGrupID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute ConfiguracioGrupFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarConfiguracioGrup(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __configuracioGrupID, Throwable e) {
    java.lang.Long configuracioGrupID = (java.lang.Long)__configuracioGrupID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (configuracioGrupID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(configuracioGrupID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "configuracioGrup.configuracioGrup";
  }

  public String getEntityNameCodePlural() {
    return "configuracioGrup.configuracioGrup.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("configuracioGrup.configuracioGrupID");
  }

  @InitBinder("configuracioGrupFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("configuracioGrupForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "configuracioGrup.configuracioGrupID");
  }

  public ConfiguracioGrupWebValidator getWebValidator() {
    return configuracioGrupWebValidator;
  }


  public void setWebValidator(ConfiguracioGrupWebValidator __val) {
    if (__val != null) {
      this.configuracioGrupWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de ConfiguracioGrup
   */
  @RequestMapping(value = "/{configuracioGrupID}/cancel")
  public String cancelConfiguracioGrup(@PathVariable("configuracioGrupID") java.lang.Long configuracioGrupID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, configuracioGrupID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de ConfiguracioGrup
   */
  @RequestMapping(value = "/cancel")
  public String cancelConfiguracioGrup(HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, null);
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

  // FILE
  @Override
  public void setFilesFormToEntity(FilesFormManager<Fitxer> afm, ConfiguracioGrup configuracioGrup,
      ConfiguracioGrupForm form) throws I18NException {

    FitxerJPA f;
    f = (FitxerJPA)afm.preProcessFile(form.getLogoHeaderID(), form.isLogoHeaderIDDelete(),
        form.isNou()? null : configuracioGrup.getLogoHeader());
    ((ConfiguracioGrupJPA)configuracioGrup).setLogoHeader(f);
    if (f != null) { 
      configuracioGrup.setLogoHeaderID(f.getFitxerID());
    } else {
      configuracioGrup.setLogoHeaderID(0);
    }

    f = (FitxerJPA)afm.preProcessFile(form.getLogoFooterID(), form.isLogoFooterIDDelete(),
        form.isNou()? null : configuracioGrup.getLogoFooter());
    ((ConfiguracioGrupJPA)configuracioGrup).setLogoFooter(f);
    if (f != null) { 
      configuracioGrup.setLogoFooterID(f.getFitxerID());
    } else {
      configuracioGrup.setLogoFooterID(0);
    }

  }

  // FILE
  @Override
  public void deleteFiles(ConfiguracioGrup configuracioGrup) {
    deleteFile(configuracioGrup.getLogoHeaderID());
    deleteFile(configuracioGrup.getLogoFooterID());
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


  public List<StringKeyValue> getReferenceListForPerfilNomesEscaneigID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupForm configuracioGrupForm, Where where)  throws I18NException {
    if (configuracioGrupForm.isHiddenField(PERFILNOMESESCANEIGID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (configuracioGrupForm.isReadOnlyField(PERFILNOMESESCANEIGID)) {
      _where = PerfilFields.PERFILID.equal(configuracioGrupForm.getConfiguracioGrup().getPerfilNomesEscaneigID());
    }
    return getReferenceListForPerfilNomesEscaneigID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPerfilNomesEscaneigID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupFilterForm configuracioGrupFilterForm,
       List<ConfiguracioGrup> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioGrupFilterForm.isHiddenField(PERFILNOMESESCANEIGID)
       && !configuracioGrupFilterForm.isGroupByField(PERFILNOMESESCANEIGID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PERFILNOMESESCANEIGID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ConfiguracioGrup _item : list) {
        if(_item.getPerfilNomesEscaneigID() == null) { continue; };
        _pkList.add(_item.getPerfilNomesEscaneigID());
        }
        _w = PerfilFields.PERFILID.in(_pkList);
      }
    return getReferenceListForPerfilNomesEscaneigID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPerfilNomesEscaneigID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return perfilRefList.getReferenceList(PerfilFields.PERFILID, where );
  }


  public List<StringKeyValue> getReferenceListForPerfilNomesEscaneig2ID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupForm configuracioGrupForm, Where where)  throws I18NException {
    if (configuracioGrupForm.isHiddenField(PERFILNOMESESCANEIG2ID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (configuracioGrupForm.isReadOnlyField(PERFILNOMESESCANEIG2ID)) {
      _where = PerfilFields.PERFILID.equal(configuracioGrupForm.getConfiguracioGrup().getPerfilNomesEscaneig2ID());
    }
    return getReferenceListForPerfilNomesEscaneig2ID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPerfilNomesEscaneig2ID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupFilterForm configuracioGrupFilterForm,
       List<ConfiguracioGrup> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioGrupFilterForm.isHiddenField(PERFILNOMESESCANEIG2ID)
       && !configuracioGrupFilterForm.isGroupByField(PERFILNOMESESCANEIG2ID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PERFILNOMESESCANEIG2ID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ConfiguracioGrup _item : list) {
        if(_item.getPerfilNomesEscaneig2ID() == null) { continue; };
        _pkList.add(_item.getPerfilNomesEscaneig2ID());
        }
        _w = PerfilFields.PERFILID.in(_pkList);
      }
    return getReferenceListForPerfilNomesEscaneig2ID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPerfilNomesEscaneig2ID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return perfilRefList.getReferenceList(PerfilFields.PERFILID, where );
  }


  public List<StringKeyValue> getReferenceListForPerfilCopiaAutenticaID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupForm configuracioGrupForm, Where where)  throws I18NException {
    if (configuracioGrupForm.isHiddenField(PERFILCOPIAAUTENTICAID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (configuracioGrupForm.isReadOnlyField(PERFILCOPIAAUTENTICAID)) {
      _where = PerfilFields.PERFILID.equal(configuracioGrupForm.getConfiguracioGrup().getPerfilCopiaAutenticaID());
    }
    return getReferenceListForPerfilCopiaAutenticaID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPerfilCopiaAutenticaID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupFilterForm configuracioGrupFilterForm,
       List<ConfiguracioGrup> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioGrupFilterForm.isHiddenField(PERFILCOPIAAUTENTICAID)
       && !configuracioGrupFilterForm.isGroupByField(PERFILCOPIAAUTENTICAID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PERFILCOPIAAUTENTICAID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ConfiguracioGrup _item : list) {
        if(_item.getPerfilCopiaAutenticaID() == null) { continue; };
        _pkList.add(_item.getPerfilCopiaAutenticaID());
        }
        _w = PerfilFields.PERFILID.in(_pkList);
      }
    return getReferenceListForPerfilCopiaAutenticaID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPerfilCopiaAutenticaID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return perfilRefList.getReferenceList(PerfilFields.PERFILID, where );
  }


  public List<StringKeyValue> getReferenceListForPerfilCopiaAutentica2ID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupForm configuracioGrupForm, Where where)  throws I18NException {
    if (configuracioGrupForm.isHiddenField(PERFILCOPIAAUTENTICA2ID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (configuracioGrupForm.isReadOnlyField(PERFILCOPIAAUTENTICA2ID)) {
      _where = PerfilFields.PERFILID.equal(configuracioGrupForm.getConfiguracioGrup().getPerfilCopiaAutentica2ID());
    }
    return getReferenceListForPerfilCopiaAutentica2ID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPerfilCopiaAutentica2ID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupFilterForm configuracioGrupFilterForm,
       List<ConfiguracioGrup> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioGrupFilterForm.isHiddenField(PERFILCOPIAAUTENTICA2ID)
       && !configuracioGrupFilterForm.isGroupByField(PERFILCOPIAAUTENTICA2ID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PERFILCOPIAAUTENTICA2ID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ConfiguracioGrup _item : list) {
        if(_item.getPerfilCopiaAutentica2ID() == null) { continue; };
        _pkList.add(_item.getPerfilCopiaAutentica2ID());
        }
        _w = PerfilFields.PERFILID.in(_pkList);
      }
    return getReferenceListForPerfilCopiaAutentica2ID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPerfilCopiaAutentica2ID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return perfilRefList.getReferenceList(PerfilFields.PERFILID, where );
  }


  public List<StringKeyValue> getReferenceListForPerfilCustodiaID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupForm configuracioGrupForm, Where where)  throws I18NException {
    if (configuracioGrupForm.isHiddenField(PERFILCUSTODIAID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (configuracioGrupForm.isReadOnlyField(PERFILCUSTODIAID)) {
      _where = PerfilFields.PERFILID.equal(configuracioGrupForm.getConfiguracioGrup().getPerfilCustodiaID());
    }
    return getReferenceListForPerfilCustodiaID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPerfilCustodiaID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupFilterForm configuracioGrupFilterForm,
       List<ConfiguracioGrup> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioGrupFilterForm.isHiddenField(PERFILCUSTODIAID)
       && !configuracioGrupFilterForm.isGroupByField(PERFILCUSTODIAID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PERFILCUSTODIAID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ConfiguracioGrup _item : list) {
        if(_item.getPerfilCustodiaID() == null) { continue; };
        _pkList.add(_item.getPerfilCustodiaID());
        }
        _w = PerfilFields.PERFILID.in(_pkList);
      }
    return getReferenceListForPerfilCustodiaID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPerfilCustodiaID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return perfilRefList.getReferenceList(PerfilFields.PERFILID, where );
  }


  public List<StringKeyValue> getReferenceListForPerfilCustodia2ID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupForm configuracioGrupForm, Where where)  throws I18NException {
    if (configuracioGrupForm.isHiddenField(PERFILCUSTODIA2ID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (configuracioGrupForm.isReadOnlyField(PERFILCUSTODIA2ID)) {
      _where = PerfilFields.PERFILID.equal(configuracioGrupForm.getConfiguracioGrup().getPerfilCustodia2ID());
    }
    return getReferenceListForPerfilCustodia2ID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPerfilCustodia2ID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioGrupFilterForm configuracioGrupFilterForm,
       List<ConfiguracioGrup> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioGrupFilterForm.isHiddenField(PERFILCUSTODIA2ID)
       && !configuracioGrupFilterForm.isGroupByField(PERFILCUSTODIA2ID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PERFILCUSTODIA2ID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ConfiguracioGrup _item : list) {
        if(_item.getPerfilCustodia2ID() == null) { continue; };
        _pkList.add(_item.getPerfilCustodia2ID());
        }
        _w = PerfilFields.PERFILID.in(_pkList);
      }
    return getReferenceListForPerfilCustodia2ID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPerfilCustodia2ID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return perfilRefList.getReferenceList(PerfilFields.PERFILID, where );
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,ConfiguracioGrupForm configuracioGrupForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,ConfiguracioGrupForm configuracioGrupForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, ConfiguracioGrupFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, ConfiguracioGrupFilterForm filterForm,  List<ConfiguracioGrup> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, ConfiguracioGrupForm configuracioGrupForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, ConfiguracioGrupForm configuracioGrupForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long configuracioGrupID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long configuracioGrupID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "configuracioGrupFormWebDB";
  }

  public String getTileList() {
    return "configuracioGrupListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "ConfiguracioGrup_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public ConfiguracioGrupJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long configuracioGrupID) throws I18NException {
    return (ConfiguracioGrupJPA) configuracioGrupEjb.findByPrimaryKey(configuracioGrupID);
  }


  public ConfiguracioGrupJPA create(HttpServletRequest request, ConfiguracioGrupJPA configuracioGrup)
    throws I18NException, I18NValidationException {
    return (ConfiguracioGrupJPA) configuracioGrupEjb.create(configuracioGrup);
  }


  public ConfiguracioGrupJPA update(HttpServletRequest request, ConfiguracioGrupJPA configuracioGrup)
    throws I18NException, I18NValidationException {
    return (ConfiguracioGrupJPA) configuracioGrupEjb.update(configuracioGrup);
  }


  public void delete(HttpServletRequest request, ConfiguracioGrup configuracioGrup) throws I18NException {
    configuracioGrupEjb.delete(configuracioGrup);
  }

} // Final de Classe

