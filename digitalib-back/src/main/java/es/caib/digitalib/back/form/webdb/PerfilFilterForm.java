
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.PerfilFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class PerfilFilterForm extends DigitalIBBaseFilterForm implements PerfilFields {

  private java.lang.Long perfilIDDesde;

  public java.lang.Long getPerfilIDDesde() {
    return this.perfilIDDesde;
  }

  public void setPerfilIDDesde(java.lang.Long perfilIDDesde) {
    this.perfilIDDesde = perfilIDDesde;
  }


  private java.lang.Long perfilIDFins;

  public java.lang.Long getPerfilIDFins() {
    return this.perfilIDFins;
  }

  public void setPerfilIDFins(java.lang.Long perfilIDFins) {
    this.perfilIDFins = perfilIDFins;
  }


  private java.lang.String codi;

  public java.lang.String getCodi() {
    return this.codi;
  }

  public void setCodi(java.lang.String codi) {
    this.codi = codi;
  }


  private java.lang.Long nomIDDesde;

  public java.lang.Long getNomIDDesde() {
    return this.nomIDDesde;
  }

  public void setNomIDDesde(java.lang.Long nomIDDesde) {
    this.nomIDDesde = nomIDDesde;
  }


  private java.lang.Long nomIDFins;

  public java.lang.Long getNomIDFins() {
    return this.nomIDFins;
  }

  public void setNomIDFins(java.lang.Long nomIDFins) {
    this.nomIDFins = nomIDFins;
  }


  private java.lang.Long descripcioIDDesde;

  public java.lang.Long getDescripcioIDDesde() {
    return this.descripcioIDDesde;
  }

  public void setDescripcioIDDesde(java.lang.Long descripcioIDDesde) {
    this.descripcioIDDesde = descripcioIDDesde;
  }


  private java.lang.Long descripcioIDFins;

  public java.lang.Long getDescripcioIDFins() {
    return this.descripcioIDFins;
  }

  public void setDescripcioIDFins(java.lang.Long descripcioIDFins) {
    this.descripcioIDFins = descripcioIDFins;
  }


  private java.lang.String urlBase;

  public java.lang.String getUrlBase() {
    return this.urlBase;
  }

  public void setUrlBase(java.lang.String urlBase) {
    this.urlBase = urlBase;
  }


  private java.util.List<java.lang.Integer> scanFormatFitxerSelect;

  public java.util.List<java.lang.Integer> getScanFormatFitxerSelect() {
    return this.scanFormatFitxerSelect;
  }

  public void setScanFormatFitxerSelect(java.util.List<java.lang.Integer> scanFormatFitxerSelect) {
    this.scanFormatFitxerSelect = scanFormatFitxerSelect;
  }


  private java.util.List<java.lang.Integer> scanMinimaResolucioSelect;

  public java.util.List<java.lang.Integer> getScanMinimaResolucioSelect() {
    return this.scanMinimaResolucioSelect;
  }

  public void setScanMinimaResolucioSelect(java.util.List<java.lang.Integer> scanMinimaResolucioSelect) {
    this.scanMinimaResolucioSelect = scanMinimaResolucioSelect;
  }


  private java.util.List<java.lang.Integer> scanPixelTypeSelect;

  public java.util.List<java.lang.Integer> getScanPixelTypeSelect() {
    return this.scanPixelTypeSelect;
  }

  public void setScanPixelTypeSelect(java.util.List<java.lang.Integer> scanPixelTypeSelect) {
    this.scanPixelTypeSelect = scanPixelTypeSelect;
  }


  private java.lang.Long pluginScanWebIDDesde;

  public java.lang.Long getPluginScanWebIDDesde() {
    return this.pluginScanWebIDDesde;
  }

  public void setPluginScanWebIDDesde(java.lang.Long pluginScanWebIDDesde) {
    this.pluginScanWebIDDesde = pluginScanWebIDDesde;
  }


  private java.lang.Long pluginScanWebIDFins;

  public java.lang.Long getPluginScanWebIDFins() {
    return this.pluginScanWebIDFins;
  }

  public void setPluginScanWebIDFins(java.lang.Long pluginScanWebIDFins) {
    this.pluginScanWebIDFins = pluginScanWebIDFins;
  }


  private java.lang.Long pluginScanWeb2IDDesde;

  public java.lang.Long getPluginScanWeb2IDDesde() {
    return this.pluginScanWeb2IDDesde;
  }

  public void setPluginScanWeb2IDDesde(java.lang.Long pluginScanWeb2IDDesde) {
    this.pluginScanWeb2IDDesde = pluginScanWeb2IDDesde;
  }


  private java.lang.Long pluginScanWeb2IDFins;

  public java.lang.Long getPluginScanWeb2IDFins() {
    return this.pluginScanWeb2IDFins;
  }

  public void setPluginScanWeb2IDFins(java.lang.Long pluginScanWeb2IDFins) {
    this.pluginScanWeb2IDFins = pluginScanWeb2IDFins;
  }


  private java.util.List<java.lang.Integer> tipusFirmaSelect;

  public java.util.List<java.lang.Integer> getTipusFirmaSelect() {
    return this.tipusFirmaSelect;
  }

  public void setTipusFirmaSelect(java.util.List<java.lang.Integer> tipusFirmaSelect) {
    this.tipusFirmaSelect = tipusFirmaSelect;
  }


  private java.lang.Long apiSimpleIDDesde;

  public java.lang.Long getApiSimpleIDDesde() {
    return this.apiSimpleIDDesde;
  }

  public void setApiSimpleIDDesde(java.lang.Long apiSimpleIDDesde) {
    this.apiSimpleIDDesde = apiSimpleIDDesde;
  }


  private java.lang.Long apiSimpleIDFins;

  public java.lang.Long getApiSimpleIDFins() {
    return this.apiSimpleIDFins;
  }

  public void setApiSimpleIDFins(java.lang.Long apiSimpleIDFins) {
    this.apiSimpleIDFins = apiSimpleIDFins;
  }


  private java.lang.Long configuracioFirmaIDDesde;

  public java.lang.Long getConfiguracioFirmaIDDesde() {
    return this.configuracioFirmaIDDesde;
  }

  public void setConfiguracioFirmaIDDesde(java.lang.Long configuracioFirmaIDDesde) {
    this.configuracioFirmaIDDesde = configuracioFirmaIDDesde;
  }


  private java.lang.Long configuracioFirmaIDFins;

  public java.lang.Long getConfiguracioFirmaIDFins() {
    return this.configuracioFirmaIDFins;
  }

  public void setConfiguracioFirmaIDFins(java.lang.Long configuracioFirmaIDFins) {
    this.configuracioFirmaIDFins = configuracioFirmaIDFins;
  }


  private java.util.List<java.lang.Integer> tipusCustodiaSelect;

  public java.util.List<java.lang.Integer> getTipusCustodiaSelect() {
    return this.tipusCustodiaSelect;
  }

  public void setTipusCustodiaSelect(java.util.List<java.lang.Integer> tipusCustodiaSelect) {
    this.tipusCustodiaSelect = tipusCustodiaSelect;
  }


  private java.lang.Long pluginArxiuIDDesde;

  public java.lang.Long getPluginArxiuIDDesde() {
    return this.pluginArxiuIDDesde;
  }

  public void setPluginArxiuIDDesde(java.lang.Long pluginArxiuIDDesde) {
    this.pluginArxiuIDDesde = pluginArxiuIDDesde;
  }


  private java.lang.Long pluginArxiuIDFins;

  public java.lang.Long getPluginArxiuIDFins() {
    return this.pluginArxiuIDFins;
  }

  public void setPluginArxiuIDFins(java.lang.Long pluginArxiuIDFins) {
    this.pluginArxiuIDFins = pluginArxiuIDFins;
  }


  private java.lang.Long pluginDocCustodyIDDesde;

  public java.lang.Long getPluginDocCustodyIDDesde() {
    return this.pluginDocCustodyIDDesde;
  }

  public void setPluginDocCustodyIDDesde(java.lang.Long pluginDocCustodyIDDesde) {
    this.pluginDocCustodyIDDesde = pluginDocCustodyIDDesde;
  }


  private java.lang.Long pluginDocCustodyIDFins;

  public java.lang.Long getPluginDocCustodyIDFins() {
    return this.pluginDocCustodyIDFins;
  }

  public void setPluginDocCustodyIDFins(java.lang.Long pluginDocCustodyIDFins) {
    this.pluginDocCustodyIDFins = pluginDocCustodyIDFins;
  }


  private java.util.List<java.lang.Integer> usPerfilSelect;

  public java.util.List<java.lang.Integer> getUsPerfilSelect() {
    return this.usPerfilSelect;
  }

  public void setUsPerfilSelect(java.util.List<java.lang.Integer> usPerfilSelect) {
    this.usPerfilSelect = usPerfilSelect;
  }


  public PerfilFilterForm() {
  }
  
  public PerfilFilterForm(PerfilFilterForm __toClone) {
    super(__toClone);
    this.perfilIDDesde = __toClone.perfilIDDesde;
    this.perfilIDFins = __toClone.perfilIDFins;
    this.codi = __toClone.codi;
    this.nomIDDesde = __toClone.nomIDDesde;
    this.nomIDFins = __toClone.nomIDFins;
    this.descripcioIDDesde = __toClone.descripcioIDDesde;
    this.descripcioIDFins = __toClone.descripcioIDFins;
    this.urlBase = __toClone.urlBase;
    this.scanFormatFitxerSelect = __toClone.scanFormatFitxerSelect;
    this.scanMinimaResolucioSelect = __toClone.scanMinimaResolucioSelect;
    this.scanPixelTypeSelect = __toClone.scanPixelTypeSelect;
    this.pluginScanWebIDDesde = __toClone.pluginScanWebIDDesde;
    this.pluginScanWebIDFins = __toClone.pluginScanWebIDFins;
    this.pluginScanWeb2IDDesde = __toClone.pluginScanWeb2IDDesde;
    this.pluginScanWeb2IDFins = __toClone.pluginScanWeb2IDFins;
    this.tipusFirmaSelect = __toClone.tipusFirmaSelect;
    this.apiSimpleIDDesde = __toClone.apiSimpleIDDesde;
    this.apiSimpleIDFins = __toClone.apiSimpleIDFins;
    this.configuracioFirmaIDDesde = __toClone.configuracioFirmaIDDesde;
    this.configuracioFirmaIDFins = __toClone.configuracioFirmaIDFins;
    this.tipusCustodiaSelect = __toClone.tipusCustodiaSelect;
    this.pluginArxiuIDDesde = __toClone.pluginArxiuIDDesde;
    this.pluginArxiuIDFins = __toClone.pluginArxiuIDFins;
    this.pluginDocCustodyIDDesde = __toClone.pluginDocCustodyIDDesde;
    this.pluginDocCustodyIDFins = __toClone.pluginDocCustodyIDFins;
    this.usPerfilSelect = __toClone.usPerfilSelect;
    this.mapOfTraduccioForNomID = __toClone.mapOfTraduccioForNomID;
    this.mapOfTraduccioForDescripcioID = __toClone.mapOfTraduccioForDescripcioID;
    this.mapOfValuesForScanFormatFitxer = __toClone.mapOfValuesForScanFormatFitxer;
    this.mapOfValuesForScanMinimaResolucio = __toClone.mapOfValuesForScanMinimaResolucio;
    this.mapOfValuesForScanPixelType = __toClone.mapOfValuesForScanPixelType;
    this.mapOfPluginForPluginScanWebID = __toClone.mapOfPluginForPluginScanWebID;
    this.mapOfPluginForPluginScanWeb2ID = __toClone.mapOfPluginForPluginScanWeb2ID;
    this.mapOfValuesForTipusFirma = __toClone.mapOfValuesForTipusFirma;
    this.mapOfApiSimpleForApiSimpleID = __toClone.mapOfApiSimpleForApiSimpleID;
    this.mapOfConfiguracioFirmaForConfiguracioFirmaID = __toClone.mapOfConfiguracioFirmaForConfiguracioFirmaID;
    this.mapOfValuesForTipusCustodia = __toClone.mapOfValuesForTipusCustodia;
    this.mapOfPluginForPluginArxiuID = __toClone.mapOfPluginForPluginArxiuID;
    this.mapOfPluginForPluginDocCustodyID = __toClone.mapOfPluginForPluginDocCustodyID;
    this.mapOfValuesForUsPerfil = __toClone.mapOfValuesForUsPerfil;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { USPERFIL }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { SCANFORMATFITXER ,PLUGINSCANWEBID ,TIPUSFIRMA ,TIPUSCUSTODIA ,PLUGINARXIUID ,PLUGINDOCCUSTODYID }));
  }


  protected OrderBy[] defaultOrderBy = null;


  public OrderBy[] getDefaultOrderBy() {
    return this.defaultOrderBy;
  }

  public void setDefaultOrderBy(OrderBy[] defOrderBy) {
    this.defaultOrderBy = defOrderBy;
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

   // -----------------------
   // Maps de referencies.
   // -----------------------
  private Map<String, String> mapOfTraduccioForNomID;

  public Map<String, String> getMapOfTraduccioForNomID() {
    return this.mapOfTraduccioForNomID;
  }

  public void setMapOfTraduccioForNomID(Map<String, String> mapOfTraduccioForNomID) {
    this.mapOfTraduccioForNomID = mapOfTraduccioForNomID;
  }



  private Map<String, String> mapOfTraduccioForDescripcioID;

  public Map<String, String> getMapOfTraduccioForDescripcioID() {
    return this.mapOfTraduccioForDescripcioID;
  }

  public void setMapOfTraduccioForDescripcioID(Map<String, String> mapOfTraduccioForDescripcioID) {
    this.mapOfTraduccioForDescripcioID = mapOfTraduccioForDescripcioID;
  }



  private Map<String, String> mapOfValuesForScanFormatFitxer;

  public Map<String, String> getMapOfValuesForScanFormatFitxer() {
    return this.mapOfValuesForScanFormatFitxer;
  }

  public void setMapOfValuesForScanFormatFitxer(Map<String, String> mapOfValuesForScanFormatFitxer) {
    this.mapOfValuesForScanFormatFitxer = mapOfValuesForScanFormatFitxer;
  }



  private Map<String, String> mapOfValuesForScanMinimaResolucio;

  public Map<String, String> getMapOfValuesForScanMinimaResolucio() {
    return this.mapOfValuesForScanMinimaResolucio;
  }

  public void setMapOfValuesForScanMinimaResolucio(Map<String, String> mapOfValuesForScanMinimaResolucio) {
    this.mapOfValuesForScanMinimaResolucio = mapOfValuesForScanMinimaResolucio;
  }



  private Map<String, String> mapOfValuesForScanPixelType;

  public Map<String, String> getMapOfValuesForScanPixelType() {
    return this.mapOfValuesForScanPixelType;
  }

  public void setMapOfValuesForScanPixelType(Map<String, String> mapOfValuesForScanPixelType) {
    this.mapOfValuesForScanPixelType = mapOfValuesForScanPixelType;
  }



  private Map<String, String> mapOfPluginForPluginScanWebID;

  public Map<String, String> getMapOfPluginForPluginScanWebID() {
    return this.mapOfPluginForPluginScanWebID;
  }

  public void setMapOfPluginForPluginScanWebID(Map<String, String> mapOfPluginForPluginScanWebID) {
    this.mapOfPluginForPluginScanWebID = mapOfPluginForPluginScanWebID;
  }



  private Map<String, String> mapOfPluginForPluginScanWeb2ID;

  public Map<String, String> getMapOfPluginForPluginScanWeb2ID() {
    return this.mapOfPluginForPluginScanWeb2ID;
  }

  public void setMapOfPluginForPluginScanWeb2ID(Map<String, String> mapOfPluginForPluginScanWeb2ID) {
    this.mapOfPluginForPluginScanWeb2ID = mapOfPluginForPluginScanWeb2ID;
  }



  private Map<String, String> mapOfValuesForTipusFirma;

  public Map<String, String> getMapOfValuesForTipusFirma() {
    return this.mapOfValuesForTipusFirma;
  }

  public void setMapOfValuesForTipusFirma(Map<String, String> mapOfValuesForTipusFirma) {
    this.mapOfValuesForTipusFirma = mapOfValuesForTipusFirma;
  }



  private Map<String, String> mapOfApiSimpleForApiSimpleID;

  public Map<String, String> getMapOfApiSimpleForApiSimpleID() {
    return this.mapOfApiSimpleForApiSimpleID;
  }

  public void setMapOfApiSimpleForApiSimpleID(Map<String, String> mapOfApiSimpleForApiSimpleID) {
    this.mapOfApiSimpleForApiSimpleID = mapOfApiSimpleForApiSimpleID;
  }



  private Map<String, String> mapOfConfiguracioFirmaForConfiguracioFirmaID;

  public Map<String, String> getMapOfConfiguracioFirmaForConfiguracioFirmaID() {
    return this.mapOfConfiguracioFirmaForConfiguracioFirmaID;
  }

  public void setMapOfConfiguracioFirmaForConfiguracioFirmaID(Map<String, String> mapOfConfiguracioFirmaForConfiguracioFirmaID) {
    this.mapOfConfiguracioFirmaForConfiguracioFirmaID = mapOfConfiguracioFirmaForConfiguracioFirmaID;
  }



  private Map<String, String> mapOfValuesForTipusCustodia;

  public Map<String, String> getMapOfValuesForTipusCustodia() {
    return this.mapOfValuesForTipusCustodia;
  }

  public void setMapOfValuesForTipusCustodia(Map<String, String> mapOfValuesForTipusCustodia) {
    this.mapOfValuesForTipusCustodia = mapOfValuesForTipusCustodia;
  }



  private Map<String, String> mapOfPluginForPluginArxiuID;

  public Map<String, String> getMapOfPluginForPluginArxiuID() {
    return this.mapOfPluginForPluginArxiuID;
  }

  public void setMapOfPluginForPluginArxiuID(Map<String, String> mapOfPluginForPluginArxiuID) {
    this.mapOfPluginForPluginArxiuID = mapOfPluginForPluginArxiuID;
  }



  private Map<String, String> mapOfPluginForPluginDocCustodyID;

  public Map<String, String> getMapOfPluginForPluginDocCustodyID() {
    return this.mapOfPluginForPluginDocCustodyID;
  }

  public void setMapOfPluginForPluginDocCustodyID(Map<String, String> mapOfPluginForPluginDocCustodyID) {
    this.mapOfPluginForPluginDocCustodyID = mapOfPluginForPluginDocCustodyID;
  }



  private Map<String, String> mapOfValuesForUsPerfil;

  public Map<String, String> getMapOfValuesForUsPerfil() {
    return this.mapOfValuesForUsPerfil;
  }

  public void setMapOfValuesForUsPerfil(Map<String, String> mapOfValuesForUsPerfil) {
    this.mapOfValuesForUsPerfil = mapOfValuesForUsPerfil;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
