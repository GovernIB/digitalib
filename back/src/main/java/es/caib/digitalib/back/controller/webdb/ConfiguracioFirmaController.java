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
import es.caib.digitalib.back.form.webdb.ConfiguracioFirmaForm;

import es.caib.digitalib.back.validator.webdb.ConfiguracioFirmaWebValidator;

import es.caib.digitalib.jpa.ConfiguracioFirmaJPA;
import es.caib.digitalib.model.entity.ConfiguracioFirma;
import es.caib.digitalib.model.fields.*;

/**
 * Controller per gestionar un ConfiguracioFirma
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/configuracioFirma")
@SessionAttributes(types = { ConfiguracioFirmaForm.class, ConfiguracioFirmaFilterForm.class })
public class ConfiguracioFirmaController
    extends es.caib.digitalib.back.controller.DigitalIBBaseController<ConfiguracioFirma, java.lang.Long> implements ConfiguracioFirmaFields {

  @EJB(mappedName = es.caib.digitalib.ejb.IdiomaLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.IdiomaLocal idiomaEjb;

  @EJB(mappedName = es.caib.digitalib.ejb.ConfiguracioFirmaLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.ConfiguracioFirmaLocal configuracioFirmaEjb;

  @Autowired
  private ConfiguracioFirmaWebValidator configuracioFirmaWebValidator;

  @Autowired
  protected ConfiguracioFirmaRefList configuracioFirmaRefList;

  // References 
  @Autowired
  protected PluginRefList pluginRefList;

  // References 
  @Autowired
  protected TraduccioRefList traduccioRefList;

  /**
   * Llistat de totes ConfiguracioFirma
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    ConfiguracioFirmaFilterForm ff;
    ff = (ConfiguracioFirmaFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar ConfiguracioFirma de forma paginada
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
    llistat(mav, request, getConfiguracioFirmaFilterForm(pagina, mav, request));
    return mav;
  }

  public ConfiguracioFirmaFilterForm getConfiguracioFirmaFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    ConfiguracioFirmaFilterForm configuracioFirmaFilterForm;
    configuracioFirmaFilterForm = (ConfiguracioFirmaFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(configuracioFirmaFilterForm == null) {
      configuracioFirmaFilterForm = new ConfiguracioFirmaFilterForm();
      configuracioFirmaFilterForm.setContexte(getContextWeb());
      configuracioFirmaFilterForm.setEntityNameCode(getEntityNameCode());
      configuracioFirmaFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      configuracioFirmaFilterForm.setNou(true);
    } else {
      configuracioFirmaFilterForm.setNou(false);
    }
    configuracioFirmaFilterForm.setPage(pagina == null ? 1 : pagina);
    return configuracioFirmaFilterForm;
  }

  /**
   * Segona i següent peticions per llistar ConfiguracioFirma de forma paginada
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
      @ModelAttribute ConfiguracioFirmaFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getConfiguracioFirmaFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de ConfiguracioFirma de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<ConfiguracioFirma> llistat(ModelAndView mav, HttpServletRequest request,
     ConfiguracioFirmaFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<ConfiguracioFirma> configuracioFirma = processarLlistat(configuracioFirmaEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("configuracioFirmaItems", configuracioFirma);

    mav.addObject("configuracioFirmaFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, configuracioFirma, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, configuracioFirma);

    return configuracioFirma;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(ConfiguracioFirmaFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<ConfiguracioFirma> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field pluginFirmaServidorID
    {
      _listSKV = getReferenceListForPluginFirmaServidorID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPluginForPluginFirmaServidorID(_tmp);
      if (filterForm.getGroupByFields().contains(PLUGINFIRMASERVIDORID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PLUGINFIRMASERVIDORID, false);
      };
    }


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, INCLOURESEGELLDETEMPS);

    // Field pluginSegellatID
    {
      _listSKV = getReferenceListForPluginSegellatID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPluginForPluginSegellatID(_tmp);
      if (filterForm.getGroupByFields().contains(PLUGINSEGELLATID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PLUGINSEGELLATID, false);
      };
    }

    // Field tipusOperacioFirma
    {
      _listSKV = getReferenceListForTipusOperacioFirma(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForTipusOperacioFirma(_tmp);
      if (filterForm.getGroupByFields().contains(TIPUSOPERACIOFIRMA)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, TIPUSOPERACIOFIRMA, false);
      };
    }

    // Field tipusFirmaID
    {
      _listSKV = getReferenceListForTipusFirmaID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForTipusFirmaID(_tmp);
      if (filterForm.getGroupByFields().contains(TIPUSFIRMAID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, TIPUSFIRMAID, false);
      };
    }

    // Field algorismeDeFirmaID
    {
      _listSKV = getReferenceListForAlgorismeDeFirmaID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForAlgorismeDeFirmaID(_tmp);
      if (filterForm.getGroupByFields().contains(ALGORISMEDEFIRMAID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ALGORISMEDEFIRMAID, false);
      };
    }


      fillValuesToGroupByItemsBoolean("modefirma", groupByItemsMap, MODEDEFIRMA);

    // Field usPoliticaDeFirma
    {
      _listSKV = getReferenceListForUsPoliticaDeFirma(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForUsPoliticaDeFirma(_tmp);
      if (filterForm.getGroupByFields().contains(USPOLITICADEFIRMA)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, USPOLITICADEFIRMA, false);
      };
    }

    // Field posicioTaulaFirmesID
    {
      _listSKV = getReferenceListForPosicioTaulaFirmesID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForPosicioTaulaFirmesID(_tmp);
      if (filterForm.getGroupByFields().contains(POSICIOTAULAFIRMESID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, POSICIOTAULAFIRMESID, false);
      };
    }

    // Field firmatPerFormatID
    {
      _listSKV = getReferenceListForFirmatPerFormatID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfTraduccioForFirmatPerFormatID(_tmp);
      if (filterForm.getGroupByFields().contains(FIRMATPERFORMATID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, FIRMATPERFORMATID, false);
      };
    }

    // Field motiuDelegacioID
    {
      _listSKV = getReferenceListForMotiuDelegacioID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfTraduccioForMotiuDelegacioID(_tmp);
      if (filterForm.getGroupByFields().contains(MOTIUDELEGACIOID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, MOTIUDELEGACIOID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    ConfiguracioFirmaFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<ConfiguracioFirma> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_CONFIGURACIOFIRMA_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(PLUGINFIRMASERVIDORID, filterForm.getMapOfPluginForPluginFirmaServidorID());
    __mapping.put(PLUGINSEGELLATID, filterForm.getMapOfPluginForPluginSegellatID());
    __mapping.put(TIPUSOPERACIOFIRMA, filterForm.getMapOfValuesForTipusOperacioFirma());
    __mapping.put(TIPUSFIRMAID, filterForm.getMapOfValuesForTipusFirmaID());
    __mapping.put(ALGORISMEDEFIRMAID, filterForm.getMapOfValuesForAlgorismeDeFirmaID());
    __mapping.put(USPOLITICADEFIRMA, filterForm.getMapOfValuesForUsPoliticaDeFirma());
    __mapping.put(POSICIOTAULAFIRMESID, filterForm.getMapOfValuesForPosicioTaulaFirmesID());
    __mapping.put(FIRMATPERFORMATID, filterForm.getMapOfTraduccioForFirmatPerFormatID());
    __mapping.put(MOTIUDELEGACIOID, filterForm.getMapOfTraduccioForMotiuDelegacioID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou ConfiguracioFirma
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearConfiguracioFirmaGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    ConfiguracioFirmaForm configuracioFirmaForm = getConfiguracioFirmaForm(null, false, request, mav);
    
    if (configuracioFirmaForm.getConfiguracioFirma().getFirmatPerFormat() == null){
      es.caib.digitalib.jpa.TraduccioJPA trad = new es.caib.digitalib.jpa.TraduccioJPA();
      for (es.caib.digitalib.model.entity.Idioma idioma : configuracioFirmaForm.getIdiomesTraduccio()) {
        trad.addTraduccio(idioma.getIdiomaID(), new es.caib.digitalib.jpa.TraduccioMapJPA());
      }
      configuracioFirmaForm.getConfiguracioFirma().setFirmatPerFormat(trad);
    }

    
    if (configuracioFirmaForm.getConfiguracioFirma().getMotiuDelegacio() == null){
      es.caib.digitalib.jpa.TraduccioJPA trad = new es.caib.digitalib.jpa.TraduccioJPA();
      for (es.caib.digitalib.model.entity.Idioma idioma : configuracioFirmaForm.getIdiomesTraduccio()) {
        trad.addTraduccio(idioma.getIdiomaID(), new es.caib.digitalib.jpa.TraduccioMapJPA());
      }
      configuracioFirmaForm.getConfiguracioFirma().setMotiuDelegacio(trad);
    }

    mav.addObject("configuracioFirmaForm" ,configuracioFirmaForm);
    fillReferencesForForm(configuracioFirmaForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public ConfiguracioFirmaForm getConfiguracioFirmaForm(ConfiguracioFirmaJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    ConfiguracioFirmaForm configuracioFirmaForm;
    if(_jpa == null) {
      configuracioFirmaForm = new ConfiguracioFirmaForm(new ConfiguracioFirmaJPA(), true);
    } else {
      configuracioFirmaForm = new ConfiguracioFirmaForm(_jpa, false);
      configuracioFirmaForm.setView(__isView);
    }
    configuracioFirmaForm.setContexte(getContextWeb());
    configuracioFirmaForm.setEntityNameCode(getEntityNameCode());
    configuracioFirmaForm.setEntityNameCodePlural(getEntityNameCodePlural());
    configuracioFirmaForm.setIdiomesTraduccio(getIdiomesSuportats());
    return configuracioFirmaForm;
  }

  public void fillReferencesForForm(ConfiguracioFirmaForm configuracioFirmaForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (configuracioFirmaForm.getListOfPluginForPluginFirmaServidorID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPluginFirmaServidorID(request, mav, configuracioFirmaForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      configuracioFirmaForm.setListOfPluginForPluginFirmaServidorID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (configuracioFirmaForm.getListOfPluginForPluginSegellatID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPluginSegellatID(request, mav, configuracioFirmaForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      configuracioFirmaForm.setListOfPluginForPluginSegellatID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (configuracioFirmaForm.getListOfValuesForTipusOperacioFirma() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForTipusOperacioFirma(request, mav, configuracioFirmaForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      configuracioFirmaForm.setListOfValuesForTipusOperacioFirma(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (configuracioFirmaForm.getListOfValuesForTipusFirmaID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForTipusFirmaID(request, mav, configuracioFirmaForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      configuracioFirmaForm.setListOfValuesForTipusFirmaID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (configuracioFirmaForm.getListOfValuesForAlgorismeDeFirmaID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForAlgorismeDeFirmaID(request, mav, configuracioFirmaForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      configuracioFirmaForm.setListOfValuesForAlgorismeDeFirmaID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (configuracioFirmaForm.getListOfValuesForUsPoliticaDeFirma() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForUsPoliticaDeFirma(request, mav, configuracioFirmaForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      configuracioFirmaForm.setListOfValuesForUsPoliticaDeFirma(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (configuracioFirmaForm.getListOfValuesForPosicioTaulaFirmesID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPosicioTaulaFirmesID(request, mav, configuracioFirmaForm, null);

 if (!_listSKV.isEmpty())    {
      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
    }
      configuracioFirmaForm.setListOfValuesForPosicioTaulaFirmesID(_listSKV);
    }
    
  }


  public List<es.caib.digitalib.model.entity.Idioma> getIdiomesSuportats() throws I18NException {
    List<es.caib.digitalib.model.entity.Idioma> idiomes = idiomaEjb.select(es.caib.digitalib.model.fields.IdiomaFields.SUPORTAT.equal(true));
    return idiomes;
  }


  /**
   * Guardar un nou ConfiguracioFirma
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearConfiguracioFirmaPost(@ModelAttribute ConfiguracioFirmaForm configuracioFirmaForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ConfiguracioFirmaJPA configuracioFirma = configuracioFirmaForm.getConfiguracioFirma();

    try {
      preValidate(request, configuracioFirmaForm, result);
      getWebValidator().validate(configuracioFirmaForm, result);
      postValidate(request,configuracioFirmaForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        configuracioFirma = create(request, configuracioFirma);
        createMessageSuccess(request, "success.creation", configuracioFirma.getConfiguracioFirmaID());
        configuracioFirmaForm.setConfiguracioFirma(configuracioFirma);
        return getRedirectWhenCreated(request, configuracioFirmaForm);
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

  @RequestMapping(value = "/view/{configuracioFirmaID}", method = RequestMethod.GET)
  public ModelAndView veureConfiguracioFirmaGet(@PathVariable("configuracioFirmaID") java.lang.Long configuracioFirmaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewConfiguracioFirmaGet(configuracioFirmaID,
        request, response, true);
  }


  protected ModelAndView editAndViewConfiguracioFirmaGet(@PathVariable("configuracioFirmaID") java.lang.Long configuracioFirmaID,
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
    ConfiguracioFirmaJPA configuracioFirma = findByPrimaryKey(request, configuracioFirmaID);

    if (configuracioFirma == null) {
      createMessageWarning(request, "error.notfound", configuracioFirmaID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, configuracioFirmaID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      ConfiguracioFirmaForm configuracioFirmaForm = getConfiguracioFirmaForm(configuracioFirma, __isView, request, mav);
      configuracioFirmaForm.setView(__isView);
      if(__isView) {
        configuracioFirmaForm.setAllFieldsReadOnly(ALL_CONFIGURACIOFIRMA_FIELDS);
        configuracioFirmaForm.setSaveButtonVisible(false);
        configuracioFirmaForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(configuracioFirmaForm, request, mav);
      mav.addObject("configuracioFirmaForm", configuracioFirmaForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un ConfiguracioFirma existent
   */
  @RequestMapping(value = "/{configuracioFirmaID}/edit", method = RequestMethod.GET)
  public ModelAndView editarConfiguracioFirmaGet(@PathVariable("configuracioFirmaID") java.lang.Long configuracioFirmaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewConfiguracioFirmaGet(configuracioFirmaID,
        request, response, false);
  }



  /**
   * Editar un ConfiguracioFirma existent
   */
  @RequestMapping(value = "/{configuracioFirmaID}/edit", method = RequestMethod.POST)
  public String editarConfiguracioFirmaPost(@ModelAttribute @Valid ConfiguracioFirmaForm configuracioFirmaForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ConfiguracioFirmaJPA configuracioFirma = configuracioFirmaForm.getConfiguracioFirma();

    try {
      preValidate(request, configuracioFirmaForm, result);
      getWebValidator().validate(configuracioFirma, result);
      postValidate(request, configuracioFirmaForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        configuracioFirma = update(request, configuracioFirma);
        createMessageSuccess(request, "success.modification", configuracioFirma.getConfiguracioFirmaID());
        status.setComplete();
        return getRedirectWhenModified(request, configuracioFirmaForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          configuracioFirma.getConfiguracioFirmaID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, configuracioFirmaForm, __e);
    }

  }


  /**
   * Eliminar un ConfiguracioFirma existent
   */
  @RequestMapping(value = "/{configuracioFirmaID}/delete")
  public String eliminarConfiguracioFirma(@PathVariable("configuracioFirmaID") java.lang.Long configuracioFirmaID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      ConfiguracioFirma configuracioFirma = configuracioFirmaEjb.findByPrimaryKey(configuracioFirmaID);
      if (configuracioFirma == null) {
        String __msg =createMessageError(request, "error.notfound", configuracioFirmaID);
        return getRedirectWhenDelete(request, configuracioFirmaID, new Exception(__msg));
      } else {
        delete(request, configuracioFirma);
        createMessageSuccess(request, "success.deleted", configuracioFirmaID);
        return getRedirectWhenDelete(request, configuracioFirmaID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", configuracioFirmaID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, configuracioFirmaID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute ConfiguracioFirmaFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarConfiguracioFirma(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __configuracioFirmaID, Throwable e) {
    java.lang.Long configuracioFirmaID = (java.lang.Long)__configuracioFirmaID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (configuracioFirmaID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(configuracioFirmaID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "configuracioFirma.configuracioFirma";
  }

  public String getEntityNameCodePlural() {
    return "configuracioFirma.configuracioFirma.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("configuracioFirma.configuracioFirmaID");
  }

  @InitBinder("configuracioFirmaFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("configuracioFirmaForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());

    binder.setDisallowedFields("configuracioFirmaID");

  }

  public ConfiguracioFirmaWebValidator getWebValidator() {
    return configuracioFirmaWebValidator;
  }


  public void setWebValidator(ConfiguracioFirmaWebValidator __val) {
    if (__val != null) {
      this.configuracioFirmaWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de ConfiguracioFirma
   */
  @RequestMapping(value = "/{configuracioFirmaID}/cancel")
  public String cancelConfiguracioFirma(@PathVariable("configuracioFirmaID") java.lang.Long configuracioFirmaID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, configuracioFirmaID);
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


  public List<StringKeyValue> getReferenceListForPluginFirmaServidorID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaForm configuracioFirmaForm, Where where)  throws I18NException {
    if (configuracioFirmaForm.isHiddenField(PLUGINFIRMASERVIDORID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _where = null;
    if (configuracioFirmaForm.isReadOnlyField(PLUGINFIRMASERVIDORID)) {
      _where = PluginFields.PLUGINID.equal(configuracioFirmaForm.getConfiguracioFirma().getPluginFirmaServidorID());
    }
    return getReferenceListForPluginFirmaServidorID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPluginFirmaServidorID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaFilterForm configuracioFirmaFilterForm,
       List<ConfiguracioFirma> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioFirmaFilterForm.isHiddenField(PLUGINFIRMASERVIDORID)
      && !configuracioFirmaFilterForm.isGroupByField(PLUGINFIRMASERVIDORID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PLUGINFIRMASERVIDORID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ConfiguracioFirma _item : list) {
        _pkList.add(_item.getPluginFirmaServidorID());
        }
        _w = PluginFields.PLUGINID.in(_pkList);
      }
    return getReferenceListForPluginFirmaServidorID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPluginFirmaServidorID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return pluginRefList.getReferenceList(PluginFields.PLUGINID, where );
  }


  public List<StringKeyValue> getReferenceListForPluginSegellatID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaForm configuracioFirmaForm, Where where)  throws I18NException {
    if (configuracioFirmaForm.isHiddenField(PLUGINSEGELLATID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _where = null;
    if (configuracioFirmaForm.isReadOnlyField(PLUGINSEGELLATID)) {
      _where = PluginFields.PLUGINID.equal(configuracioFirmaForm.getConfiguracioFirma().getPluginSegellatID());
    }
    return getReferenceListForPluginSegellatID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPluginSegellatID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaFilterForm configuracioFirmaFilterForm,
       List<ConfiguracioFirma> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioFirmaFilterForm.isHiddenField(PLUGINSEGELLATID)
      && !configuracioFirmaFilterForm.isGroupByField(PLUGINSEGELLATID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PLUGINSEGELLATID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ConfiguracioFirma _item : list) {
        if(_item.getPluginSegellatID() == null) { continue; };
        _pkList.add(_item.getPluginSegellatID());
        }
        _w = PluginFields.PLUGINID.in(_pkList);
      }
    return getReferenceListForPluginSegellatID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPluginSegellatID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return pluginRefList.getReferenceList(PluginFields.PLUGINID, where );
  }


  public List<StringKeyValue> getReferenceListForTipusOperacioFirma(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaForm configuracioFirmaForm, Where where)  throws I18NException {
    if (configuracioFirmaForm.isHiddenField(TIPUSOPERACIOFIRMA)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForTipusOperacioFirma(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForTipusOperacioFirma(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaFilterForm configuracioFirmaFilterForm,
       List<ConfiguracioFirma> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioFirmaFilterForm.isHiddenField(TIPUSOPERACIOFIRMA)
      && !configuracioFirmaFilterForm.isGroupByField(TIPUSOPERACIOFIRMA)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForTipusOperacioFirma(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForTipusOperacioFirma(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForTipusFirmaID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaForm configuracioFirmaForm, Where where)  throws I18NException {
    if (configuracioFirmaForm.isHiddenField(TIPUSFIRMAID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForTipusFirmaID(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForTipusFirmaID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaFilterForm configuracioFirmaFilterForm,
       List<ConfiguracioFirma> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioFirmaFilterForm.isHiddenField(TIPUSFIRMAID)
      && !configuracioFirmaFilterForm.isGroupByField(TIPUSFIRMAID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForTipusFirmaID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForTipusFirmaID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    __tmp.add(new StringKeyValue("3" , "3"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForAlgorismeDeFirmaID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaForm configuracioFirmaForm, Where where)  throws I18NException {
    if (configuracioFirmaForm.isHiddenField(ALGORISMEDEFIRMAID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForAlgorismeDeFirmaID(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForAlgorismeDeFirmaID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaFilterForm configuracioFirmaFilterForm,
       List<ConfiguracioFirma> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioFirmaFilterForm.isHiddenField(ALGORISMEDEFIRMAID)
      && !configuracioFirmaFilterForm.isGroupByField(ALGORISMEDEFIRMAID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForAlgorismeDeFirmaID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForAlgorismeDeFirmaID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    __tmp.add(new StringKeyValue("3" , "3"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForUsPoliticaDeFirma(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaForm configuracioFirmaForm, Where where)  throws I18NException {
    if (configuracioFirmaForm.isHiddenField(USPOLITICADEFIRMA)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForUsPoliticaDeFirma(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForUsPoliticaDeFirma(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaFilterForm configuracioFirmaFilterForm,
       List<ConfiguracioFirma> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioFirmaFilterForm.isHiddenField(USPOLITICADEFIRMA)
      && !configuracioFirmaFilterForm.isGroupByField(USPOLITICADEFIRMA)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForUsPoliticaDeFirma(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForUsPoliticaDeFirma(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("-1" , "-1"));
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForPosicioTaulaFirmesID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaForm configuracioFirmaForm, Where where)  throws I18NException {
    if (configuracioFirmaForm.isHiddenField(POSICIOTAULAFIRMESID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    return getReferenceListForPosicioTaulaFirmesID(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForPosicioTaulaFirmesID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaFilterForm configuracioFirmaFilterForm,
       List<ConfiguracioFirma> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioFirmaFilterForm.isHiddenField(POSICIOTAULAFIRMESID)
      && !configuracioFirmaFilterForm.isGroupByField(POSICIOTAULAFIRMESID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    return getReferenceListForPosicioTaulaFirmesID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPosicioTaulaFirmesID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("-1" , "-1"));
    return __tmp;
  }

  public List<StringKeyValue> getReferenceListForFirmatPerFormatID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaFilterForm configuracioFirmaFilterForm,
       List<ConfiguracioFirma> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioFirmaFilterForm.isHiddenField(FIRMATPERFORMATID)
      && !configuracioFirmaFilterForm.isGroupByField(FIRMATPERFORMATID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(FIRMATPERFORMATID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ConfiguracioFirma _item : list) {
        if(_item.getFirmatPerFormatID() == null) { continue; };
        _pkList.add(_item.getFirmatPerFormatID());
        }
        _w = TraduccioFields.TRADUCCIOID.in(_pkList);
      }
    return getReferenceListForFirmatPerFormatID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForFirmatPerFormatID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return traduccioRefList.getReferenceList(TraduccioFields.TRADUCCIOID, where );
  }

  public List<StringKeyValue> getReferenceListForMotiuDelegacioID(HttpServletRequest request,
       ModelAndView mav, ConfiguracioFirmaFilterForm configuracioFirmaFilterForm,
       List<ConfiguracioFirma> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (configuracioFirmaFilterForm.isHiddenField(MOTIUDELEGACIOID)
      && !configuracioFirmaFilterForm.isGroupByField(MOTIUDELEGACIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(MOTIUDELEGACIOID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ConfiguracioFirma _item : list) {
        if(_item.getMotiuDelegacioID() == null) { continue; };
        _pkList.add(_item.getMotiuDelegacioID());
        }
        _w = TraduccioFields.TRADUCCIOID.in(_pkList);
      }
    return getReferenceListForMotiuDelegacioID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForMotiuDelegacioID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return traduccioRefList.getReferenceList(TraduccioFields.TRADUCCIOID, where );
  }


  public void preValidate(HttpServletRequest request,ConfiguracioFirmaForm configuracioFirmaForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,ConfiguracioFirmaForm configuracioFirmaForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, ConfiguracioFirmaFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, ConfiguracioFirmaFilterForm filterForm,  List<ConfiguracioFirma> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, ConfiguracioFirmaForm configuracioFirmaForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, ConfiguracioFirmaForm configuracioFirmaForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long configuracioFirmaID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long configuracioFirmaID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "configuracioFirmaFormWebDB";
  }

  public String getTileList() {
    return "configuracioFirmaListWebDB";
  }

  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public String getSessionAttributeFilterForm() {
    return "ConfiguracioFirmaWebDB_FilterForm";
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public ConfiguracioFirmaJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long configuracioFirmaID) throws I18NException {
    return (ConfiguracioFirmaJPA) configuracioFirmaEjb.findByPrimaryKey(configuracioFirmaID);
  }


  public ConfiguracioFirmaJPA create(HttpServletRequest request, ConfiguracioFirmaJPA configuracioFirma)
    throws Exception,I18NException, I18NValidationException {
    return (ConfiguracioFirmaJPA) configuracioFirmaEjb.create(configuracioFirma);
  }


  public ConfiguracioFirmaJPA update(HttpServletRequest request, ConfiguracioFirmaJPA configuracioFirma)
    throws Exception,I18NException, I18NValidationException {
    return (ConfiguracioFirmaJPA) configuracioFirmaEjb.update(configuracioFirma);
  }


  public void delete(HttpServletRequest request, ConfiguracioFirma configuracioFirma) throws Exception,I18NException {
    configuracioFirmaEjb.delete(configuracioFirma);
  }

} // Final de Classe

