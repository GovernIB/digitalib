
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.PluginFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class PluginFilterForm extends DigitalIBBaseFilterForm implements PluginFields {

  private java.lang.Long pluginIDDesde;

  public java.lang.Long getPluginIDDesde() {
    return this.pluginIDDesde;
  }

  public void setPluginIDDesde(java.lang.Long pluginIDDesde) {
    this.pluginIDDesde = pluginIDDesde;
  }


  private java.lang.Long pluginIDFins;

  public java.lang.Long getPluginIDFins() {
    return this.pluginIDFins;
  }

  public void setPluginIDFins(java.lang.Long pluginIDFins) {
    this.pluginIDFins = pluginIDFins;
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


  private java.lang.String classe;

  public java.lang.String getClasse() {
    return this.classe;
  }

  public void setClasse(java.lang.String classe) {
    this.classe = classe;
  }


  private java.lang.String properties;

  public java.lang.String getProperties() {
    return this.properties;
  }

  public void setProperties(java.lang.String properties) {
    this.properties = properties;
  }


  private java.lang.Integer tipusDesde;

  public java.lang.Integer getTipusDesde() {
    return this.tipusDesde;
  }

  public void setTipusDesde(java.lang.Integer tipusDesde) {
    this.tipusDesde = tipusDesde;
  }


  private java.lang.Integer tipusFins;

  public java.lang.Integer getTipusFins() {
    return this.tipusFins;
  }

  public void setTipusFins(java.lang.Integer tipusFins) {
    this.tipusFins = tipusFins;
  }


  private java.lang.Integer ordreDesde;

  public java.lang.Integer getOrdreDesde() {
    return this.ordreDesde;
  }

  public void setOrdreDesde(java.lang.Integer ordreDesde) {
    this.ordreDesde = ordreDesde;
  }


  private java.lang.Integer ordreFins;

  public java.lang.Integer getOrdreFins() {
    return this.ordreFins;
  }

  public void setOrdreFins(java.lang.Integer ordreFins) {
    this.ordreFins = ordreFins;
  }


  public PluginFilterForm() {
  }
  
  public PluginFilterForm(PluginFilterForm __toClone) {
    super(__toClone);
    this.pluginIDDesde = __toClone.pluginIDDesde;
    this.pluginIDFins = __toClone.pluginIDFins;
    this.codi = __toClone.codi;
    this.nom = __toClone.nom;
    this.descripcio = __toClone.descripcio;
    this.classe = __toClone.classe;
    this.properties = __toClone.properties;
    this.tipusDesde = __toClone.tipusDesde;
    this.tipusFins = __toClone.tipusFins;
    this.ordreDesde = __toClone.ordreDesde;
    this.ordreFins = __toClone.ordreFins;
    this.mapOfValuesForTipus = __toClone.mapOfValuesForTipus;
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
  private Map<String, String> mapOfValuesForTipus;

  public Map<String, String> getMapOfValuesForTipus() {
    return this.mapOfValuesForTipus;
  }

  public void setMapOfValuesForTipus(Map<String, String> mapOfValuesForTipus) {
    this.mapOfValuesForTipus = mapOfValuesForTipus;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
