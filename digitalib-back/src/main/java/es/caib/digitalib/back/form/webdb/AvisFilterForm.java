
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.AvisFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class AvisFilterForm extends DigitalIBBaseFilterForm implements AvisFields {

  private java.lang.Long avisIDDesde;

  public java.lang.Long getAvisIDDesde() {
    return this.avisIDDesde;
  }

  public void setAvisIDDesde(java.lang.Long avisIDDesde) {
    this.avisIDDesde = avisIDDesde;
  }


  private java.lang.Long avisIDFins;

  public java.lang.Long getAvisIDFins() {
    return this.avisIDFins;
  }

  public void setAvisIDFins(java.lang.Long avisIDFins) {
    this.avisIDFins = avisIDFins;
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


  private java.util.List<java.lang.Integer> tipusSelect;

  public java.util.List<java.lang.Integer> getTipusSelect() {
    return this.tipusSelect;
  }

  public void setTipusSelect(java.util.List<java.lang.Integer> tipusSelect) {
    this.tipusSelect = tipusSelect;
  }


  private java.sql.Timestamp dataIniciDesde;

  public java.sql.Timestamp getDataIniciDesde() {
    return this.dataIniciDesde;
  }

  public void setDataIniciDesde(java.sql.Timestamp dataIniciDesde) {
    this.dataIniciDesde = dataIniciDesde;
  }


  private java.sql.Timestamp dataIniciFins;

  public java.sql.Timestamp getDataIniciFins() {
    return this.dataIniciFins;
  }

  public void setDataIniciFins(java.sql.Timestamp dataIniciFins) {
    this.dataIniciFins = dataIniciFins;
  }


  private java.sql.Timestamp dataFiDesde;

  public java.sql.Timestamp getDataFiDesde() {
    return this.dataFiDesde;
  }

  public void setDataFiDesde(java.sql.Timestamp dataFiDesde) {
    this.dataFiDesde = dataFiDesde;
  }


  private java.sql.Timestamp dataFiFins;

  public java.sql.Timestamp getDataFiFins() {
    return this.dataFiFins;
  }

  public void setDataFiFins(java.sql.Timestamp dataFiFins) {
    this.dataFiFins = dataFiFins;
  }


  private java.lang.Long configGrupIDDesde;

  public java.lang.Long getConfigGrupIDDesde() {
    return this.configGrupIDDesde;
  }

  public void setConfigGrupIDDesde(java.lang.Long configGrupIDDesde) {
    this.configGrupIDDesde = configGrupIDDesde;
  }


  private java.lang.Long configGrupIDFins;

  public java.lang.Long getConfigGrupIDFins() {
    return this.configGrupIDFins;
  }

  public void setConfigGrupIDFins(java.lang.Long configGrupIDFins) {
    this.configGrupIDFins = configGrupIDFins;
  }


  public AvisFilterForm() {
  }
  
  public AvisFilterForm(AvisFilterForm __toClone) {
    super(__toClone);
    this.avisIDDesde = __toClone.avisIDDesde;
    this.avisIDFins = __toClone.avisIDFins;
    this.descripcioIDDesde = __toClone.descripcioIDDesde;
    this.descripcioIDFins = __toClone.descripcioIDFins;
    this.tipusSelect = __toClone.tipusSelect;
    this.dataIniciDesde = __toClone.dataIniciDesde;
    this.dataIniciFins = __toClone.dataIniciFins;
    this.dataFiDesde = __toClone.dataFiDesde;
    this.dataFiFins = __toClone.dataFiFins;
    this.configGrupIDDesde = __toClone.configGrupIDDesde;
    this.configGrupIDFins = __toClone.configGrupIDFins;
    this.mapOfTraduccioForDescripcioID = __toClone.mapOfTraduccioForDescripcioID;
    this.mapOfValuesForTipus = __toClone.mapOfValuesForTipus;
    this.mapOfConfiguracioGrupForConfigGrupID = __toClone.mapOfConfiguracioGrupForConfigGrupID;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
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
  private Map<String, String> mapOfTraduccioForDescripcioID;

  public Map<String, String> getMapOfTraduccioForDescripcioID() {
    return this.mapOfTraduccioForDescripcioID;
  }

  public void setMapOfTraduccioForDescripcioID(Map<String, String> mapOfTraduccioForDescripcioID) {
    this.mapOfTraduccioForDescripcioID = mapOfTraduccioForDescripcioID;
  }



  private Map<String, String> mapOfValuesForTipus;

  public Map<String, String> getMapOfValuesForTipus() {
    return this.mapOfValuesForTipus;
  }

  public void setMapOfValuesForTipus(Map<String, String> mapOfValuesForTipus) {
    this.mapOfValuesForTipus = mapOfValuesForTipus;
  }



  private Map<String, String> mapOfConfiguracioGrupForConfigGrupID;

  public Map<String, String> getMapOfConfiguracioGrupForConfigGrupID() {
    return this.mapOfConfiguracioGrupForConfigGrupID;
  }

  public void setMapOfConfiguracioGrupForConfigGrupID(Map<String, String> mapOfConfiguracioGrupForConfigGrupID) {
    this.mapOfConfiguracioGrupForConfigGrupID = mapOfConfiguracioGrupForConfigGrupID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
