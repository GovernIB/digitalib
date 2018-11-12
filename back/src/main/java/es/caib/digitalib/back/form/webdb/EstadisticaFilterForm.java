
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


  private java.lang.Long usuariaplicacioidDesde;

  public java.lang.Long getUsuariaplicacioidDesde() {
    return this.usuariaplicacioidDesde;
  }

  public void setUsuariaplicacioidDesde(java.lang.Long usuariaplicacioidDesde) {
    this.usuariaplicacioidDesde = usuariaplicacioidDesde;
  }


  private java.lang.Long usuariaplicacioidFins;

  public java.lang.Long getUsuariaplicacioidFins() {
    return this.usuariaplicacioidFins;
  }

  public void setUsuariaplicacioidFins(java.lang.Long usuariaplicacioidFins) {
    this.usuariaplicacioidFins = usuariaplicacioidFins;
  }


  private java.lang.Long usuaripersonaidDesde;

  public java.lang.Long getUsuaripersonaidDesde() {
    return this.usuaripersonaidDesde;
  }

  public void setUsuaripersonaidDesde(java.lang.Long usuaripersonaidDesde) {
    this.usuaripersonaidDesde = usuaripersonaidDesde;
  }


  private java.lang.Long usuaripersonaidFins;

  public java.lang.Long getUsuaripersonaidFins() {
    return this.usuaripersonaidFins;
  }

  public void setUsuaripersonaidFins(java.lang.Long usuaripersonaidFins) {
    this.usuaripersonaidFins = usuaripersonaidFins;
  }


  public EstadisticaFilterForm() {
  }
  
  public EstadisticaFilterForm(EstadisticaFilterForm __toClone) {
    super(__toClone);
    this.estadisticaIDDesde = __toClone.estadisticaIDDesde;
    this.estadisticaIDFins = __toClone.estadisticaIDFins;
    this.tipusDesde = __toClone.tipusDesde;
    this.tipusFins = __toClone.tipusFins;
    this.dataDesde = __toClone.dataDesde;
    this.dataFins = __toClone.dataFins;
    this.valorDesde = __toClone.valorDesde;
    this.valorFins = __toClone.valorFins;
    this.parametres = __toClone.parametres;
    this.usuariaplicacioidDesde = __toClone.usuariaplicacioidDesde;
    this.usuariaplicacioidFins = __toClone.usuariaplicacioidFins;
    this.usuaripersonaidDesde = __toClone.usuaripersonaidDesde;
    this.usuaripersonaidFins = __toClone.usuaripersonaidFins;
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
