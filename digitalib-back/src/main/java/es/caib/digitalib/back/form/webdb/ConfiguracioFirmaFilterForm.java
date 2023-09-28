
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.ConfiguracioFirmaFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class ConfiguracioFirmaFilterForm extends DigitalIBBaseFilterForm implements ConfiguracioFirmaFields {

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


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
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


  private java.lang.Long pluginSegellatIDDesde;

  public java.lang.Long getPluginSegellatIDDesde() {
    return this.pluginSegellatIDDesde;
  }

  public void setPluginSegellatIDDesde(java.lang.Long pluginSegellatIDDesde) {
    this.pluginSegellatIDDesde = pluginSegellatIDDesde;
  }


  private java.lang.Long pluginSegellatIDFins;

  public java.lang.Long getPluginSegellatIDFins() {
    return this.pluginSegellatIDFins;
  }

  public void setPluginSegellatIDFins(java.lang.Long pluginSegellatIDFins) {
    this.pluginSegellatIDFins = pluginSegellatIDFins;
  }


  private java.util.List<java.lang.Integer> tipusOperacioFirmaSelect;

  public java.util.List<java.lang.Integer> getTipusOperacioFirmaSelect() {
    return this.tipusOperacioFirmaSelect;
  }

  public void setTipusOperacioFirmaSelect(java.util.List<java.lang.Integer> tipusOperacioFirmaSelect) {
    this.tipusOperacioFirmaSelect = tipusOperacioFirmaSelect;
  }


  private java.util.List<java.lang.Integer> tipusFirmaIDSelect;

  public java.util.List<java.lang.Integer> getTipusFirmaIDSelect() {
    return this.tipusFirmaIDSelect;
  }

  public void setTipusFirmaIDSelect(java.util.List<java.lang.Integer> tipusFirmaIDSelect) {
    this.tipusFirmaIDSelect = tipusFirmaIDSelect;
  }


  private java.util.List<java.lang.Integer> algorismeDeFirmaIDSelect;

  public java.util.List<java.lang.Integer> getAlgorismeDeFirmaIDSelect() {
    return this.algorismeDeFirmaIDSelect;
  }

  public void setAlgorismeDeFirmaIDSelect(java.util.List<java.lang.Integer> algorismeDeFirmaIDSelect) {
    this.algorismeDeFirmaIDSelect = algorismeDeFirmaIDSelect;
  }


  private java.util.List<java.lang.Integer> usPoliticaDeFirmaSelect;

  public java.util.List<java.lang.Integer> getUsPoliticaDeFirmaSelect() {
    return this.usPoliticaDeFirmaSelect;
  }

  public void setUsPoliticaDeFirmaSelect(java.util.List<java.lang.Integer> usPoliticaDeFirmaSelect) {
    this.usPoliticaDeFirmaSelect = usPoliticaDeFirmaSelect;
  }


  private java.lang.String policyIdentifier;

  public java.lang.String getPolicyIdentifier() {
    return this.policyIdentifier;
  }

  public void setPolicyIdentifier(java.lang.String policyIdentifier) {
    this.policyIdentifier = policyIdentifier;
  }


  private java.lang.String policyIdentifierHash;

  public java.lang.String getPolicyIdentifierHash() {
    return this.policyIdentifierHash;
  }

  public void setPolicyIdentifierHash(java.lang.String policyIdentifierHash) {
    this.policyIdentifierHash = policyIdentifierHash;
  }


  private java.lang.String policyIdentifierHashAlgorithm;

  public java.lang.String getPolicyIdentifierHashAlgorithm() {
    return this.policyIdentifierHashAlgorithm;
  }

  public void setPolicyIdentifierHashAlgorithm(java.lang.String policyIdentifierHashAlgorithm) {
    this.policyIdentifierHashAlgorithm = policyIdentifierHashAlgorithm;
  }


  private java.lang.String policyUrlDocument;

  public java.lang.String getPolicyUrlDocument() {
    return this.policyUrlDocument;
  }

  public void setPolicyUrlDocument(java.lang.String policyUrlDocument) {
    this.policyUrlDocument = policyUrlDocument;
  }


  private java.util.List<java.lang.Integer> posicioTaulaFirmesIDSelect;

  public java.util.List<java.lang.Integer> getPosicioTaulaFirmesIDSelect() {
    return this.posicioTaulaFirmesIDSelect;
  }

  public void setPosicioTaulaFirmesIDSelect(java.util.List<java.lang.Integer> posicioTaulaFirmesIDSelect) {
    this.posicioTaulaFirmesIDSelect = posicioTaulaFirmesIDSelect;
  }


  private java.lang.Long firmatPerFormatIDDesde;

  public java.lang.Long getFirmatPerFormatIDDesde() {
    return this.firmatPerFormatIDDesde;
  }

  public void setFirmatPerFormatIDDesde(java.lang.Long firmatPerFormatIDDesde) {
    this.firmatPerFormatIDDesde = firmatPerFormatIDDesde;
  }


  private java.lang.Long firmatPerFormatIDFins;

  public java.lang.Long getFirmatPerFormatIDFins() {
    return this.firmatPerFormatIDFins;
  }

  public void setFirmatPerFormatIDFins(java.lang.Long firmatPerFormatIDFins) {
    this.firmatPerFormatIDFins = firmatPerFormatIDFins;
  }


  private java.lang.Long motiuDelegacioIDDesde;

  public java.lang.Long getMotiuDelegacioIDDesde() {
    return this.motiuDelegacioIDDesde;
  }

  public void setMotiuDelegacioIDDesde(java.lang.Long motiuDelegacioIDDesde) {
    this.motiuDelegacioIDDesde = motiuDelegacioIDDesde;
  }


  private java.lang.Long motiuDelegacioIDFins;

  public java.lang.Long getMotiuDelegacioIDFins() {
    return this.motiuDelegacioIDFins;
  }

  public void setMotiuDelegacioIDFins(java.lang.Long motiuDelegacioIDFins) {
    this.motiuDelegacioIDFins = motiuDelegacioIDFins;
  }


  private java.lang.String propietatsTaulaFirmes;

  public java.lang.String getPropietatsTaulaFirmes() {
    return this.propietatsTaulaFirmes;
  }

  public void setPropietatsTaulaFirmes(java.lang.String propietatsTaulaFirmes) {
    this.propietatsTaulaFirmes = propietatsTaulaFirmes;
  }


  public ConfiguracioFirmaFilterForm() {
  }
  
  public ConfiguracioFirmaFilterForm(ConfiguracioFirmaFilterForm __toClone) {
    super(__toClone);
    this.configuracioFirmaIDDesde = __toClone.configuracioFirmaIDDesde;
    this.configuracioFirmaIDFins = __toClone.configuracioFirmaIDFins;
    this.nom = __toClone.nom;
    this.pluginFirmaServidorIDDesde = __toClone.pluginFirmaServidorIDDesde;
    this.pluginFirmaServidorIDFins = __toClone.pluginFirmaServidorIDFins;
    this.pluginSegellatIDDesde = __toClone.pluginSegellatIDDesde;
    this.pluginSegellatIDFins = __toClone.pluginSegellatIDFins;
    this.tipusOperacioFirmaSelect = __toClone.tipusOperacioFirmaSelect;
    this.tipusFirmaIDSelect = __toClone.tipusFirmaIDSelect;
    this.algorismeDeFirmaIDSelect = __toClone.algorismeDeFirmaIDSelect;
    this.usPoliticaDeFirmaSelect = __toClone.usPoliticaDeFirmaSelect;
    this.policyIdentifier = __toClone.policyIdentifier;
    this.policyIdentifierHash = __toClone.policyIdentifierHash;
    this.policyIdentifierHashAlgorithm = __toClone.policyIdentifierHashAlgorithm;
    this.policyUrlDocument = __toClone.policyUrlDocument;
    this.posicioTaulaFirmesIDSelect = __toClone.posicioTaulaFirmesIDSelect;
    this.firmatPerFormatIDDesde = __toClone.firmatPerFormatIDDesde;
    this.firmatPerFormatIDFins = __toClone.firmatPerFormatIDFins;
    this.motiuDelegacioIDDesde = __toClone.motiuDelegacioIDDesde;
    this.motiuDelegacioIDFins = __toClone.motiuDelegacioIDFins;
    this.propietatsTaulaFirmes = __toClone.propietatsTaulaFirmes;
    this.mapOfPluginForPluginFirmaServidorID = __toClone.mapOfPluginForPluginFirmaServidorID;
    this.mapOfPluginForPluginSegellatID = __toClone.mapOfPluginForPluginSegellatID;
    this.mapOfValuesForTipusOperacioFirma = __toClone.mapOfValuesForTipusOperacioFirma;
    this.mapOfValuesForTipusFirmaID = __toClone.mapOfValuesForTipusFirmaID;
    this.mapOfValuesForAlgorismeDeFirmaID = __toClone.mapOfValuesForAlgorismeDeFirmaID;
    this.mapOfValuesForUsPoliticaDeFirma = __toClone.mapOfValuesForUsPoliticaDeFirma;
    this.mapOfValuesForPosicioTaulaFirmesID = __toClone.mapOfValuesForPosicioTaulaFirmesID;
    this.mapOfTraduccioForFirmatPerFormatID = __toClone.mapOfTraduccioForFirmatPerFormatID;
    this.mapOfTraduccioForMotiuDelegacioID = __toClone.mapOfTraduccioForMotiuDelegacioID;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { NOM }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { INCLOURESEGELLDETEMPS ,TIPUSFIRMAID }));
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
  private Map<String, String> mapOfPluginForPluginFirmaServidorID;

  public Map<String, String> getMapOfPluginForPluginFirmaServidorID() {
    return this.mapOfPluginForPluginFirmaServidorID;
  }

  public void setMapOfPluginForPluginFirmaServidorID(Map<String, String> mapOfPluginForPluginFirmaServidorID) {
    this.mapOfPluginForPluginFirmaServidorID = mapOfPluginForPluginFirmaServidorID;
  }



  private Map<String, String> mapOfPluginForPluginSegellatID;

  public Map<String, String> getMapOfPluginForPluginSegellatID() {
    return this.mapOfPluginForPluginSegellatID;
  }

  public void setMapOfPluginForPluginSegellatID(Map<String, String> mapOfPluginForPluginSegellatID) {
    this.mapOfPluginForPluginSegellatID = mapOfPluginForPluginSegellatID;
  }



  private Map<String, String> mapOfValuesForTipusOperacioFirma;

  public Map<String, String> getMapOfValuesForTipusOperacioFirma() {
    return this.mapOfValuesForTipusOperacioFirma;
  }

  public void setMapOfValuesForTipusOperacioFirma(Map<String, String> mapOfValuesForTipusOperacioFirma) {
    this.mapOfValuesForTipusOperacioFirma = mapOfValuesForTipusOperacioFirma;
  }



  private Map<String, String> mapOfValuesForTipusFirmaID;

  public Map<String, String> getMapOfValuesForTipusFirmaID() {
    return this.mapOfValuesForTipusFirmaID;
  }

  public void setMapOfValuesForTipusFirmaID(Map<String, String> mapOfValuesForTipusFirmaID) {
    this.mapOfValuesForTipusFirmaID = mapOfValuesForTipusFirmaID;
  }



  private Map<String, String> mapOfValuesForAlgorismeDeFirmaID;

  public Map<String, String> getMapOfValuesForAlgorismeDeFirmaID() {
    return this.mapOfValuesForAlgorismeDeFirmaID;
  }

  public void setMapOfValuesForAlgorismeDeFirmaID(Map<String, String> mapOfValuesForAlgorismeDeFirmaID) {
    this.mapOfValuesForAlgorismeDeFirmaID = mapOfValuesForAlgorismeDeFirmaID;
  }



  private Map<String, String> mapOfValuesForUsPoliticaDeFirma;

  public Map<String, String> getMapOfValuesForUsPoliticaDeFirma() {
    return this.mapOfValuesForUsPoliticaDeFirma;
  }

  public void setMapOfValuesForUsPoliticaDeFirma(Map<String, String> mapOfValuesForUsPoliticaDeFirma) {
    this.mapOfValuesForUsPoliticaDeFirma = mapOfValuesForUsPoliticaDeFirma;
  }



  private Map<String, String> mapOfValuesForPosicioTaulaFirmesID;

  public Map<String, String> getMapOfValuesForPosicioTaulaFirmesID() {
    return this.mapOfValuesForPosicioTaulaFirmesID;
  }

  public void setMapOfValuesForPosicioTaulaFirmesID(Map<String, String> mapOfValuesForPosicioTaulaFirmesID) {
    this.mapOfValuesForPosicioTaulaFirmesID = mapOfValuesForPosicioTaulaFirmesID;
  }



  private Map<String, String> mapOfTraduccioForFirmatPerFormatID;

  public Map<String, String> getMapOfTraduccioForFirmatPerFormatID() {
    return this.mapOfTraduccioForFirmatPerFormatID;
  }

  public void setMapOfTraduccioForFirmatPerFormatID(Map<String, String> mapOfTraduccioForFirmatPerFormatID) {
    this.mapOfTraduccioForFirmatPerFormatID = mapOfTraduccioForFirmatPerFormatID;
  }



  private Map<String, String> mapOfTraduccioForMotiuDelegacioID;

  public Map<String, String> getMapOfTraduccioForMotiuDelegacioID() {
    return this.mapOfTraduccioForMotiuDelegacioID;
  }

  public void setMapOfTraduccioForMotiuDelegacioID(Map<String, String> mapOfTraduccioForMotiuDelegacioID) {
    this.mapOfTraduccioForMotiuDelegacioID = mapOfTraduccioForMotiuDelegacioID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
