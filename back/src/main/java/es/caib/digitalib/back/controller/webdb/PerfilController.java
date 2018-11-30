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
import es.caib.digitalib.back.form.webdb.PerfilForm;

import es.caib.digitalib.back.validator.webdb.PerfilWebValidator;

import es.caib.digitalib.jpa.PerfilJPA;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.fields.*;

/**
 * Controller per gestionar un Perfil
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/perfil")
@SessionAttributes(types = { PerfilForm.class, PerfilFilterForm.class })
public class PerfilController
    extends es.caib.digitalib.back.controller.DigitalIBBaseController<Perfil, java.lang.Long> implements PerfilFields {

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

  @Autowired
  private PerfilWebValidator perfilWebValidator;

  @Autowired
  protected PerfilRefList perfilRefList;

  // References 
  @Autowired
  protected PluginRefList pluginRefList;

  // References 
  @Autowired
  protected ApiSimpleRefList apiSimpleRefList;

  /**
   * Llistat de totes Perfil
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    PerfilFilterForm ff;
    ff = (PerfilFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Perfil de forma paginada
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
    llistat(mav, request, getPerfilFilterForm(pagina, mav, request));
    return mav;
  }

  public PerfilFilterForm getPerfilFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    PerfilFilterForm perfilFilterForm;
    perfilFilterForm = (PerfilFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(perfilFilterForm == null) {
      perfilFilterForm = new PerfilFilterForm();
      perfilFilterForm.setContexte(getContextWeb());
      perfilFilterForm.setEntityNameCode(getEntityNameCode());
      perfilFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      perfilFilterForm.setNou(true);
    } else {
      perfilFilterForm.setNou(false);
    }
    perfilFilterForm.setPage(pagina == null ? 1 : pagina);
    return perfilFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Perfil de forma paginada
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
      @ModelAttribute PerfilFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getPerfilFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Perfil de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Perfil> llistat(ModelAndView mav, HttpServletRequest request,
     PerfilFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Perfil> perfil = processarLlistat(perfilEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("perfilItems", perfil);

    mav.addObject("perfilFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, perfil, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, perfil);

    return perfil;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(PerfilFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Perfil> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field scanFormatFitxer
    {
      _listSKV = getReferenceListForScanFormatFitxer(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForScanFormatFitxer(_tmp);
      if (filterForm.getGroupByFields().contains(SCANFORMATFITXER)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, SCANFORMATFITXER, false);
      };
    }

    // Field scanMinimaResolucio
    {
      _listSKV = getReferenceListForScanMinimaResolucio(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForScanMinimaResolucio(_tmp);
      if (filterForm.getGroupByFields().contains(SCANMINIMARESOLUCIO)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, SCANMINIMARESOLUCIO, false);
      };
    }

    // Field scanPixelType
    {
      _listSKV = getReferenceListForScanPixelType(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForScanPixelType(_tmp);
      if (filterForm.getGroupByFields().contains(SCANPIXELTYPE)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, SCANPIXELTYPE, false);
      };
    }

    // Field pluginScanWebID
    {
      _listSKV = getReferenceListForPluginScanWebID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPluginForPluginScanWebID(_tmp);
      if (filterForm.getGroupByFields().contains(PLUGINSCANWEBID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PLUGINSCANWEBID, false);
      };
    }

    // Field pluginScanWeb2ID
    {
      _listSKV = getReferenceListForPluginScanWeb2ID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPluginForPluginScanWeb2ID(_tmp);
      if (filterForm.getGroupByFields().contains(PLUGINSCANWEB2ID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PLUGINSCANWEB2ID, false);
      };
    }

    // Field tipusFirma
    {
      _listSKV = getReferenceListForTipusFirma(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForTipusFirma(_tmp);
      if (filterForm.getGroupByFields().contains(TIPUSFIRMA)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, TIPUSFIRMA, false);
      };
    }

    // Field apiSimpleID
    {
      _listSKV = getReferenceListForApiSimpleID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfApiSimpleForApiSimpleID(_tmp);
      if (filterForm.getGroupByFields().contains(APISIMPLEID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, APISIMPLEID, false);
      };
    }

    // Field pluginFirmaServidorID
    {
      _listSKV = getReferenceListForPluginFirmaServidorID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPluginForPluginFirmaServidorID(_tmp);
      if (filterForm.getGroupByFields().contains(PLUGINFIRMASERVIDORID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PLUGINFIRMASERVIDORID, false);
      };
    }

    // Field tipusCustodia
    {
      _listSKV = getReferenceListForTipusCustodia(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForTipusCustodia(_tmp);
      if (filterForm.getGroupByFields().contains(TIPUSCUSTODIA)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, TIPUSCUSTODIA, false);
      };
    }

    // Field pluginArxiuID
    {
      _listSKV = getReferenceListForPluginArxiuID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPluginForPluginArxiuID(_tmp);
      if (filterForm.getGroupByFields().contains(PLUGINARXIUID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PLUGINARXIUID, false);
      };
    }

    // Field pluginDocCustodyID
    {
      _listSKV = getReferenceListForPluginDocCustodyID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfPluginForPluginDocCustodyID(_tmp);
      if (filterForm.getGroupByFields().contains(PLUGINDOCCUSTODYID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PLUGINDOCCUSTODYID, false);
      };
    }

    // Field usPerfil
    {
      _listSKV = getReferenceListForUsPerfil(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForUsPerfil(_tmp);
      if (filterForm.getGroupByFields().contains(USPERFIL)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, USPERFIL, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    PerfilFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Perfil> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_PERFIL_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(SCANFORMATFITXER, filterForm.getMapOfValuesForScanFormatFitxer());
    __mapping.put(SCANMINIMARESOLUCIO, filterForm.getMapOfValuesForScanMinimaResolucio());
    __mapping.put(SCANPIXELTYPE, filterForm.getMapOfValuesForScanPixelType());
    __mapping.put(PLUGINSCANWEBID, filterForm.getMapOfPluginForPluginScanWebID());
    __mapping.put(PLUGINSCANWEB2ID, filterForm.getMapOfPluginForPluginScanWeb2ID());
    __mapping.put(TIPUSFIRMA, filterForm.getMapOfValuesForTipusFirma());
    __mapping.put(APISIMPLEID, filterForm.getMapOfApiSimpleForApiSimpleID());
    __mapping.put(PLUGINFIRMASERVIDORID, filterForm.getMapOfPluginForPluginFirmaServidorID());
    __mapping.put(TIPUSCUSTODIA, filterForm.getMapOfValuesForTipusCustodia());
    __mapping.put(PLUGINARXIUID, filterForm.getMapOfPluginForPluginArxiuID());
    __mapping.put(PLUGINDOCCUSTODYID, filterForm.getMapOfPluginForPluginDocCustodyID());
    __mapping.put(USPERFIL, filterForm.getMapOfValuesForUsPerfil());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Perfil
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearPerfilGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    PerfilForm perfilForm = getPerfilForm(null, false, request, mav);
    mav.addObject("perfilForm" ,perfilForm);
    fillReferencesForForm(perfilForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public PerfilForm getPerfilForm(PerfilJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    PerfilForm perfilForm;
    if(_jpa == null) {
      perfilForm = new PerfilForm(new PerfilJPA(), true);
    } else {
      perfilForm = new PerfilForm(_jpa, false);
      perfilForm.setView(__isView);
    }
    perfilForm.setContexte(getContextWeb());
    perfilForm.setEntityNameCode(getEntityNameCode());
    perfilForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return perfilForm;
  }

  public void fillReferencesForForm(PerfilForm perfilForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfValuesForScanFormatFitxer() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForScanFormatFitxer(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfValuesForScanFormatFitxer(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfValuesForScanMinimaResolucio() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForScanMinimaResolucio(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfValuesForScanMinimaResolucio(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfValuesForScanPixelType() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForScanPixelType(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfValuesForScanPixelType(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfPluginForPluginScanWebID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPluginScanWebID(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfPluginForPluginScanWebID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfPluginForPluginScanWeb2ID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPluginScanWeb2ID(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfPluginForPluginScanWeb2ID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfValuesForTipusFirma() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForTipusFirma(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfValuesForTipusFirma(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfApiSimpleForApiSimpleID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForApiSimpleID(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfApiSimpleForApiSimpleID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfPluginForPluginFirmaServidorID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPluginFirmaServidorID(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfPluginForPluginFirmaServidorID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfValuesForTipusCustodia() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForTipusCustodia(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfValuesForTipusCustodia(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfPluginForPluginArxiuID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPluginArxiuID(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfPluginForPluginArxiuID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfPluginForPluginDocCustodyID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForPluginDocCustodyID(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfPluginForPluginDocCustodyID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (perfilForm.getListOfValuesForUsPerfil() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForUsPerfil(request, mav, perfilForm, null);

      java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      perfilForm.setListOfValuesForUsPerfil(_listSKV);
    }
    
  }

  /**
   * Guardar un nou Perfil
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearPerfilPost(@ModelAttribute PerfilForm perfilForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    PerfilJPA perfil = perfilForm.getPerfil();

    try {
      preValidate(request, perfilForm, result);
      getWebValidator().validate(perfilForm, result);
      postValidate(request,perfilForm, result);

      if (result.hasErrors()) {
        return getTileForm();
      } else {
        perfil = create(request, perfil);
        createMessageSuccess(request, "success.creation", perfil.getPerfilID());
        perfilForm.setPerfil(perfil);
        return getRedirectWhenCreated(request, perfilForm);
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

  @RequestMapping(value = "/view/{perfilID}", method = RequestMethod.GET)
  public ModelAndView veurePerfilGet(@PathVariable("perfilID") java.lang.Long perfilID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewPerfilGet(perfilID,
        request, response, true);
  }


  protected ModelAndView editAndViewPerfilGet(@PathVariable("perfilID") java.lang.Long perfilID,
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
    PerfilJPA perfil = findByPrimaryKey(request, perfilID);

    if (perfil == null) {
      createMessageWarning(request, "error.notfound", perfilID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, perfilID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      PerfilForm perfilForm = getPerfilForm(perfil, __isView, request, mav);
      perfilForm.setView(__isView);
      if(__isView) {
        perfilForm.setAllFieldsReadOnly(ALL_PERFIL_FIELDS);
        perfilForm.setSaveButtonVisible(false);
        perfilForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(perfilForm, request, mav);
      mav.addObject("perfilForm", perfilForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Perfil existent
   */
  @RequestMapping(value = "/{perfilID}/edit", method = RequestMethod.GET)
  public ModelAndView editarPerfilGet(@PathVariable("perfilID") java.lang.Long perfilID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewPerfilGet(perfilID,
        request, response, false);
  }



  /**
   * Editar un Perfil existent
   */
  @RequestMapping(value = "/{perfilID}/edit", method = RequestMethod.POST)
  public String editarPerfilPost(@ModelAttribute @Valid PerfilForm perfilForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    PerfilJPA perfil = perfilForm.getPerfil();

    try {
      preValidate(request, perfilForm, result);
      getWebValidator().validate(perfil, result);
      postValidate(request, perfilForm, result);

      if (result.hasErrors()) {
        return getTileForm();
      } else {
        perfil = update(request, perfil);
        createMessageSuccess(request, "success.modification", perfil.getPerfilID());
        status.setComplete();
        return getRedirectWhenModified(request, perfilForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          perfil.getPerfilID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, perfilForm, __e);
    }

  }


  /**
   * Eliminar un Perfil existent
   */
  @RequestMapping(value = "/{perfilID}/delete")
  public String eliminarPerfil(@PathVariable("perfilID") java.lang.Long perfilID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Perfil perfil = perfilEjb.findByPrimaryKey(perfilID);
      if (perfil == null) {
        String __msg =createMessageError(request, "error.notfound", perfilID);
        return getRedirectWhenDelete(request, perfilID, new Exception(__msg));
      } else {
        delete(request, perfil);
        createMessageSuccess(request, "success.deleted", perfilID);
        return getRedirectWhenDelete(request, perfilID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", perfilID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, perfilID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute PerfilFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarPerfil(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __perfilID, Throwable e) {
    java.lang.Long perfilID = (java.lang.Long)__perfilID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (perfilID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(perfilID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "perfil.perfil";
  }

  public String getEntityNameCodePlural() {
    return "perfil.perfil.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("perfil.perfilID");
  }

  @InitBinder("perfilFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("perfilForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());

    binder.setDisallowedFields("perfilID");

  }

  public PerfilWebValidator getWebValidator() {
    return perfilWebValidator;
  }


  public void setWebValidator(PerfilWebValidator __val) {
    if (__val != null) {
      this.perfilWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Perfil
   */
  @RequestMapping(value = "/{perfilID}/cancel")
  public String cancelPerfil(@PathVariable("perfilID") java.lang.Long perfilID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, perfilID);
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


  public List<StringKeyValue> getReferenceListForScanFormatFitxer(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(SCANFORMATFITXER)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForScanFormatFitxer(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForScanFormatFitxer(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(SCANFORMATFITXER)
      && !perfilFilterForm.isGroupByField(SCANFORMATFITXER)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForScanFormatFitxer(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForScanFormatFitxer(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    __tmp.add(new StringKeyValue("3" , "3"));
    __tmp.add(new StringKeyValue("4" , "4"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForScanMinimaResolucio(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(SCANMINIMARESOLUCIO)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForScanMinimaResolucio(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForScanMinimaResolucio(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(SCANMINIMARESOLUCIO)
      && !perfilFilterForm.isGroupByField(SCANMINIMARESOLUCIO)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForScanMinimaResolucio(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForScanMinimaResolucio(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("100" , "100"));
    __tmp.add(new StringKeyValue("150" , "150"));
    __tmp.add(new StringKeyValue("200" , "200"));
    __tmp.add(new StringKeyValue("300" , "300"));
    __tmp.add(new StringKeyValue("400" , "400"));
    __tmp.add(new StringKeyValue("600" , "600"));
    __tmp.add(new StringKeyValue("1200" , "1200"));
    __tmp.add(new StringKeyValue("2400" , "2400"));
    __tmp.add(new StringKeyValue("4800" , "4800"));
    __tmp.add(new StringKeyValue("9600" , "9600"));
    __tmp.add(new StringKeyValue("19200" , "19200"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForScanPixelType(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(SCANPIXELTYPE)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForScanPixelType(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForScanPixelType(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(SCANPIXELTYPE)
      && !perfilFilterForm.isGroupByField(SCANPIXELTYPE)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForScanPixelType(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForScanPixelType(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    __tmp.add(new StringKeyValue("3" , "3"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForPluginScanWebID(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(PLUGINSCANWEBID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (perfilForm.isReadOnlyField(PLUGINSCANWEBID)) {
      _where = PluginFields.PLUGINID.equal(perfilForm.getPerfil().getPluginScanWebID());
    }
    return getReferenceListForPluginScanWebID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPluginScanWebID(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(PLUGINSCANWEBID)
      && !perfilFilterForm.isGroupByField(PLUGINSCANWEBID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PLUGINSCANWEBID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Perfil _item : list) {
        _pkList.add(_item.getPluginScanWebID());
        }
        _w = PluginFields.PLUGINID.in(_pkList);
      }
    return getReferenceListForPluginScanWebID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPluginScanWebID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return pluginRefList.getReferenceList(PluginFields.PLUGINID, where );
  }


  public List<StringKeyValue> getReferenceListForPluginScanWeb2ID(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(PLUGINSCANWEB2ID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (perfilForm.isReadOnlyField(PLUGINSCANWEB2ID)) {
      _where = PluginFields.PLUGINID.equal(perfilForm.getPerfil().getPluginScanWeb2ID());
    }
    return getReferenceListForPluginScanWeb2ID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPluginScanWeb2ID(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(PLUGINSCANWEB2ID)
      && !perfilFilterForm.isGroupByField(PLUGINSCANWEB2ID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PLUGINSCANWEB2ID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Perfil _item : list) {
        if(_item.getPluginScanWeb2ID() == null) { continue; };
        _pkList.add(_item.getPluginScanWeb2ID());
        }
        _w = PluginFields.PLUGINID.in(_pkList);
      }
    return getReferenceListForPluginScanWeb2ID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPluginScanWeb2ID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return pluginRefList.getReferenceList(PluginFields.PLUGINID, where );
  }


  public List<StringKeyValue> getReferenceListForTipusFirma(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(TIPUSFIRMA)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForTipusFirma(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForTipusFirma(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(TIPUSFIRMA)
      && !perfilFilterForm.isGroupByField(TIPUSFIRMA)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForTipusFirma(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForTipusFirma(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForApiSimpleID(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(APISIMPLEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (perfilForm.isReadOnlyField(APISIMPLEID)) {
      _where = ApiSimpleFields.APISIMPLEID.equal(perfilForm.getPerfil().getApiSimpleID());
    }
    return getReferenceListForApiSimpleID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForApiSimpleID(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(APISIMPLEID)
      && !perfilFilterForm.isGroupByField(APISIMPLEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(APISIMPLEID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Perfil _item : list) {
        if(_item.getApiSimpleID() == null) { continue; };
        _pkList.add(_item.getApiSimpleID());
        }
        _w = ApiSimpleFields.APISIMPLEID.in(_pkList);
      }
    return getReferenceListForApiSimpleID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForApiSimpleID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return apiSimpleRefList.getReferenceList(ApiSimpleFields.APISIMPLEID, where );
  }


  public List<StringKeyValue> getReferenceListForPluginFirmaServidorID(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(PLUGINFIRMASERVIDORID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (perfilForm.isReadOnlyField(PLUGINFIRMASERVIDORID)) {
      _where = PluginFields.PLUGINID.equal(perfilForm.getPerfil().getPluginFirmaServidorID());
    }
    return getReferenceListForPluginFirmaServidorID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPluginFirmaServidorID(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(PLUGINFIRMASERVIDORID)
      && !perfilFilterForm.isGroupByField(PLUGINFIRMASERVIDORID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PLUGINFIRMASERVIDORID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Perfil _item : list) {
        if(_item.getPluginFirmaServidorID() == null) { continue; };
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


  public List<StringKeyValue> getReferenceListForTipusCustodia(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(TIPUSCUSTODIA)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForTipusCustodia(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForTipusCustodia(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(TIPUSCUSTODIA)
      && !perfilFilterForm.isGroupByField(TIPUSCUSTODIA)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForTipusCustodia(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForTipusCustodia(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("0" , "0"));
    __tmp.add(new StringKeyValue("1" , "1"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForPluginArxiuID(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(PLUGINARXIUID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (perfilForm.isReadOnlyField(PLUGINARXIUID)) {
      _where = PluginFields.PLUGINID.equal(perfilForm.getPerfil().getPluginArxiuID());
    }
    return getReferenceListForPluginArxiuID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPluginArxiuID(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(PLUGINARXIUID)
      && !perfilFilterForm.isGroupByField(PLUGINARXIUID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PLUGINARXIUID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Perfil _item : list) {
        if(_item.getPluginArxiuID() == null) { continue; };
        _pkList.add(_item.getPluginArxiuID());
        }
        _w = PluginFields.PLUGINID.in(_pkList);
      }
    return getReferenceListForPluginArxiuID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPluginArxiuID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return pluginRefList.getReferenceList(PluginFields.PLUGINID, where );
  }


  public List<StringKeyValue> getReferenceListForPluginDocCustodyID(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(PLUGINDOCCUSTODYID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (perfilForm.isReadOnlyField(PLUGINDOCCUSTODYID)) {
      _where = PluginFields.PLUGINID.equal(perfilForm.getPerfil().getPluginDocCustodyID());
    }
    return getReferenceListForPluginDocCustodyID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForPluginDocCustodyID(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(PLUGINDOCCUSTODYID)
      && !perfilFilterForm.isGroupByField(PLUGINDOCCUSTODYID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PLUGINDOCCUSTODYID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Perfil _item : list) {
        if(_item.getPluginDocCustodyID() == null) { continue; };
        _pkList.add(_item.getPluginDocCustodyID());
        }
        _w = PluginFields.PLUGINID.in(_pkList);
      }
    return getReferenceListForPluginDocCustodyID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForPluginDocCustodyID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return pluginRefList.getReferenceList(PluginFields.PLUGINID, where );
  }


  public List<StringKeyValue> getReferenceListForUsPerfil(HttpServletRequest request,
       ModelAndView mav, PerfilForm perfilForm, Where where)  throws I18NException {
    if (perfilForm.isHiddenField(USPERFIL)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForUsPerfil(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForUsPerfil(HttpServletRequest request,
       ModelAndView mav, PerfilFilterForm perfilFilterForm,
       List<Perfil> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (perfilFilterForm.isHiddenField(USPERFIL)
      && !perfilFilterForm.isGroupByField(USPERFIL)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForUsPerfil(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForUsPerfil(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    __tmp.add(new StringKeyValue("3" , "3"));
    __tmp.add(new StringKeyValue("-1" , "-1"));
    __tmp.add(new StringKeyValue("-2" , "-2"));
    __tmp.add(new StringKeyValue("-3" , "-3"));
    return __tmp;
  }


  public void preValidate(HttpServletRequest request,PerfilForm perfilForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,PerfilForm perfilForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, PerfilFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, PerfilFilterForm filterForm,  List<Perfil> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, PerfilForm perfilForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, PerfilForm perfilForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long perfilID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long perfilID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "perfilFormWebDB";
  }

  public String getTileList() {
    return "perfilListWebDB";
  }

  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public String getSessionAttributeFilterForm() {
    return "PerfilWebDB_FilterForm";
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public PerfilJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long perfilID) throws I18NException {
    return (PerfilJPA) perfilEjb.findByPrimaryKey(perfilID);
  }


  public PerfilJPA create(HttpServletRequest request, PerfilJPA perfil)
    throws Exception,I18NException, I18NValidationException {
    return (PerfilJPA) perfilEjb.create(perfil);
  }


  public PerfilJPA update(HttpServletRequest request, PerfilJPA perfil)
    throws Exception,I18NException, I18NValidationException {
    return (PerfilJPA) perfilEjb.update(perfil);
  }


  public void delete(HttpServletRequest request, Perfil perfil) throws Exception,I18NException {
    perfilEjb.delete(perfil);
  }

} // Final de Classe

