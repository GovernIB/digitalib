
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


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String descripcio;

  public java.lang.String getDescripcio() {
    return this.descripcio;
  }

  public void setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
  }


  private java.lang.String urlBase;

  public java.lang.String getUrlBase() {
    return this.urlBase;
  }

  public void setUrlBase(java.lang.String urlBase) {
    this.urlBase = urlBase;
  }


  private java.lang.Integer scanFormatFitxerDesde;

  public java.lang.Integer getScanFormatFitxerDesde() {
    return this.scanFormatFitxerDesde;
  }

  public void setScanFormatFitxerDesde(java.lang.Integer scanFormatFitxerDesde) {
    this.scanFormatFitxerDesde = scanFormatFitxerDesde;
  }


  private java.lang.Integer scanFormatFitxerFins;

  public java.lang.Integer getScanFormatFitxerFins() {
    return this.scanFormatFitxerFins;
  }

  public void setScanFormatFitxerFins(java.lang.Integer scanFormatFitxerFins) {
    this.scanFormatFitxerFins = scanFormatFitxerFins;
  }


  private java.lang.Integer scanMinimaResolucioDesde;

  public java.lang.Integer getScanMinimaResolucioDesde() {
    return this.scanMinimaResolucioDesde;
  }

  public void setScanMinimaResolucioDesde(java.lang.Integer scanMinimaResolucioDesde) {
    this.scanMinimaResolucioDesde = scanMinimaResolucioDesde;
  }


  private java.lang.Integer scanMinimaResolucioFins;

  public java.lang.Integer getScanMinimaResolucioFins() {
    return this.scanMinimaResolucioFins;
  }

  public void setScanMinimaResolucioFins(java.lang.Integer scanMinimaResolucioFins) {
    this.scanMinimaResolucioFins = scanMinimaResolucioFins;
  }


  private java.lang.Integer scanPixelTypeDesde;

  public java.lang.Integer getScanPixelTypeDesde() {
    return this.scanPixelTypeDesde;
  }

  public void setScanPixelTypeDesde(java.lang.Integer scanPixelTypeDesde) {
    this.scanPixelTypeDesde = scanPixelTypeDesde;
  }


  private java.lang.Integer scanPixelTypeFins;

  public java.lang.Integer getScanPixelTypeFins() {
    return this.scanPixelTypeFins;
  }

  public void setScanPixelTypeFins(java.lang.Integer scanPixelTypeFins) {
    this.scanPixelTypeFins = scanPixelTypeFins;
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


  private java.lang.Integer tipusFirmaDesde;

  public java.lang.Integer getTipusFirmaDesde() {
    return this.tipusFirmaDesde;
  }

  public void setTipusFirmaDesde(java.lang.Integer tipusFirmaDesde) {
    this.tipusFirmaDesde = tipusFirmaDesde;
  }


  private java.lang.Integer tipusFirmaFins;

  public java.lang.Integer getTipusFirmaFins() {
    return this.tipusFirmaFins;
  }

  public void setTipusFirmaFins(java.lang.Integer tipusFirmaFins) {
    this.tipusFirmaFins = tipusFirmaFins;
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


  private java.lang.Long pluginFirmaServidorIDDesde;

  public java.lang.Long getPluginFirmaServidorIDDesde() {
    return this.pluginFirmaServidorIDDesde;
  }

  public void setPluginFirmaServidorIDDesde(java.lang.Long pluginFirmaServidorIDDesde) {
    this.pluginFirmaServidorIDDesde = pluginFirmaServidorIDDesde;
  }


  private java.lang.Long pluginFirmaServidorIDFins;

  public java.lang.Long getPluginFirmaServidorIDFins() {
    return this.pluginFirmaServidorIDFins;
  }

  public void setPluginFirmaServidorIDFins(java.lang.Long pluginFirmaServidorIDFins) {
    this.pluginFirmaServidorIDFins = pluginFirmaServidorIDFins;
  }


  private java.lang.Integer tipusCustodiaDesde;

  public java.lang.Integer getTipusCustodiaDesde() {
    return this.tipusCustodiaDesde;
  }

  public void setTipusCustodiaDesde(java.lang.Integer tipusCustodiaDesde) {
    this.tipusCustodiaDesde = tipusCustodiaDesde;
  }


  private java.lang.Integer tipusCustodiaFins;

  public java.lang.Integer getTipusCustodiaFins() {
    return this.tipusCustodiaFins;
  }

  public void setTipusCustodiaFins(java.lang.Integer tipusCustodiaFins) {
    this.tipusCustodiaFins = tipusCustodiaFins;
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


  private java.lang.Integer usPerfilDesde;

  public java.lang.Integer getUsPerfilDesde() {
    return this.usPerfilDesde;
  }

  public void setUsPerfilDesde(java.lang.Integer usPerfilDesde) {
    this.usPerfilDesde = usPerfilDesde;
  }


  private java.lang.Integer usPerfilFins;

  public java.lang.Integer getUsPerfilFins() {
    return this.usPerfilFins;
  }

  public void setUsPerfilFins(java.lang.Integer usPerfilFins) {
    this.usPerfilFins = usPerfilFins;
  }


  public PerfilFilterForm() {
  }
  
  public PerfilFilterForm(PerfilFilterForm __toClone) {
    super(__toClone);
    this.perfilIDDesde = __toClone.perfilIDDesde;
    this.perfilIDFins = __toClone.perfilIDFins;
    this.codi = __toClone.codi;
    this.nom = __toClone.nom;
    this.descripcio = __toClone.descripcio;
    this.urlBase = __toClone.urlBase;
    this.scanFormatFitxerDesde = __toClone.scanFormatFitxerDesde;
    this.scanFormatFitxerFins = __toClone.scanFormatFitxerFins;
    this.scanMinimaResolucioDesde = __toClone.scanMinimaResolucioDesde;
    this.scanMinimaResolucioFins = __toClone.scanMinimaResolucioFins;
    this.scanPixelTypeDesde = __toClone.scanPixelTypeDesde;
    this.scanPixelTypeFins = __toClone.scanPixelTypeFins;
    this.pluginScanWebIDDesde = __toClone.pluginScanWebIDDesde;
    this.pluginScanWebIDFins = __toClone.pluginScanWebIDFins;
    this.pluginScanWeb2IDDesde = __toClone.pluginScanWeb2IDDesde;
    this.pluginScanWeb2IDFins = __toClone.pluginScanWeb2IDFins;
    this.tipusFirmaDesde = __toClone.tipusFirmaDesde;
    this.tipusFirmaFins = __toClone.tipusFirmaFins;
    this.apiSimpleIDDesde = __toClone.apiSimpleIDDesde;
    this.apiSimpleIDFins = __toClone.apiSimpleIDFins;
    this.pluginFirmaServidorIDDesde = __toClone.pluginFirmaServidorIDDesde;
    this.pluginFirmaServidorIDFins = __toClone.pluginFirmaServidorIDFins;
    this.tipusCustodiaDesde = __toClone.tipusCustodiaDesde;
    this.tipusCustodiaFins = __toClone.tipusCustodiaFins;
    this.pluginArxiuIDDesde = __toClone.pluginArxiuIDDesde;
    this.pluginArxiuIDFins = __toClone.pluginArxiuIDFins;
    this.pluginDocCustodyIDDesde = __toClone.pluginDocCustodyIDDesde;
    this.pluginDocCustodyIDFins = __toClone.pluginDocCustodyIDFins;
    this.usPerfilDesde = __toClone.usPerfilDesde;
    this.usPerfilFins = __toClone.usPerfilFins;
    this.mapOfValuesForScanFormatFitxer = __toClone.mapOfValuesForScanFormatFitxer;
    this.mapOfValuesForScanMinimaResolucio = __toClone.mapOfValuesForScanMinimaResolucio;
    this.mapOfValuesForScanPixelType = __toClone.mapOfValuesForScanPixelType;
    this.mapOfPluginForPluginScanWebID = __toClone.mapOfPluginForPluginScanWebID;
    this.mapOfPluginForPluginScanWeb2ID = __toClone.mapOfPluginForPluginScanWeb2ID;
    this.mapOfValuesForTipusFirma = __toClone.mapOfValuesForTipusFirma;
    this.mapOfApiSimpleForApiSimpleID = __toClone.mapOfApiSimpleForApiSimpleID;
    this.mapOfPluginForPluginFirmaServidorID = __toClone.mapOfPluginForPluginFirmaServidorID;
    this.mapOfValuesForTipusCustodia = __toClone.mapOfValuesForTipusCustodia;
    this.mapOfPluginForPluginArxiuID = __toClone.mapOfPluginForPluginArxiuID;
    this.mapOfPluginForPluginDocCustodyID = __toClone.mapOfPluginForPluginDocCustodyID;
    this.mapOfValuesForUsPerfil = __toClone.mapOfValuesForUsPerfil;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { NOM }));
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



  private Map<String, String> mapOfPluginForPluginFirmaServidorID;

  public Map<String, String> getMapOfPluginForPluginFirmaServidorID() {
    return this.mapOfPluginForPluginFirmaServidorID;
  }

  public void setMapOfPluginForPluginFirmaServidorID(Map<String, String> mapOfPluginForPluginFirmaServidorID) {
    this.mapOfPluginForPluginFirmaServidorID = mapOfPluginForPluginFirmaServidorID;
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
