
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.EstadisticaFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class EstadisticaFilterForm extends DigitalIBBaseFilterForm implements EstadisticaFields {

  private java.lang.Long estadisticaIDDesde;

  public java.lang.Long getEstadisticaIDDesde() {
    return this.estadisticaIDDesde;
  }

  public void setEstadisticaIDDesde(java.lang.Long estadisticaIDDesde) {
    this.estadisticaIDDesde = estadisticaIDDesde;
  }


  private java.lang.Long estadisticaIDFins;

  public java.lang.Long getEstadisticaIDFins() {
    return this.estadisticaIDFins;
  }

  public void setEstadisticaIDFins(java.lang.Long estadisticaIDFins) {
    this.estadisticaIDFins = estadisticaIDFins;
  }


  private java.util.List<java.lang.Integer> tipusSelect;

  public java.util.List<java.lang.Integer> getTipusSelect() {
    return this.tipusSelect;
  }

  public void setTipusSelect(java.util.List<java.lang.Integer> tipusSelect) {
    this.tipusSelect = tipusSelect;
  }


  private java.sql.Timestamp dataDesde;

  public java.sql.Timestamp getDataDesde() {
    return this.dataDesde;
  }

  public void setDataDesde(java.sql.Timestamp dataDesde) {
    this.dataDesde = dataDesde;
  }


  private java.sql.Timestamp dataFins;

  public java.sql.Timestamp getDataFins() {
    return this.dataFins;
  }

  public void setDataFins(java.sql.Timestamp dataFins) {
    this.dataFins = dataFins;
  }


  private java.lang.Double valorDesde;

  public java.lang.Double getValorDesde() {
    return this.valorDesde;
  }

  public void setValorDesde(java.lang.Double valorDesde) {
    this.valorDesde = valorDesde;
  }


  private java.lang.Double valorFins;

  public java.lang.Double getValorFins() {
    return this.valorFins;
  }

  public void setValorFins(java.lang.Double valorFins) {
    this.valorFins = valorFins;
  }


  private java.lang.String parametres;

  public java.lang.String getParametres() {
    return this.parametres;
  }

  public void setParametres(java.lang.String parametres) {
    this.parametres = parametres;
  }


  private java.lang.Long usuariAplicacioIDDesde;

  public java.lang.Long getUsuariAplicacioIDDesde() {
    return this.usuariAplicacioIDDesde;
  }

  public void setUsuariAplicacioIDDesde(java.lang.Long usuariAplicacioIDDesde) {
    this.usuariAplicacioIDDesde = usuariAplicacioIDDesde;
  }


  private java.lang.Long usuariAplicacioIDFins;

  public java.lang.Long getUsuariAplicacioIDFins() {
    return this.usuariAplicacioIDFins;
  }

  public void setUsuariAplicacioIDFins(java.lang.Long usuariAplicacioIDFins) {
    this.usuariAplicacioIDFins = usuariAplicacioIDFins;
  }


  private java.lang.Long usuariPersonaIDDesde;

  public java.lang.Long getUsuariPersonaIDDesde() {
    return this.usuariPersonaIDDesde;
  }

  public void setUsuariPersonaIDDesde(java.lang.Long usuariPersonaIDDesde) {
    this.usuariPersonaIDDesde = usuariPersonaIDDesde;
  }


  private java.lang.Long usuariPersonaIDFins;

  public java.lang.Long getUsuariPersonaIDFins() {
    return this.usuariPersonaIDFins;
  }

  public void setUsuariPersonaIDFins(java.lang.Long usuariPersonaIDFins) {
    this.usuariPersonaIDFins = usuariPersonaIDFins;
  }


  public EstadisticaFilterForm() {
  }
  
  public EstadisticaFilterForm(EstadisticaFilterForm __toClone) {
    super(__toClone);
    this.estadisticaIDDesde = __toClone.estadisticaIDDesde;
    this.estadisticaIDFins = __toClone.estadisticaIDFins;
    this.tipusSelect = __toClone.tipusSelect;
    this.dataDesde = __toClone.dataDesde;
    this.dataFins = __toClone.dataFins;
    this.valorDesde = __toClone.valorDesde;
    this.valorFins = __toClone.valorFins;
    this.parametres = __toClone.parametres;
    this.usuariAplicacioIDDesde = __toClone.usuariAplicacioIDDesde;
    this.usuariAplicacioIDFins = __toClone.usuariAplicacioIDFins;
    this.usuariPersonaIDDesde = __toClone.usuariPersonaIDDesde;
    this.usuariPersonaIDFins = __toClone.usuariPersonaIDFins;
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
