
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.TransaccioFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class TransaccioFilterForm extends DigitalIBBaseFilterForm implements TransaccioFields {

  private java.lang.Long transaccioIDDesde;

  public java.lang.Long getTransaccioIDDesde() {
    return this.transaccioIDDesde;
  }

  public void setTransaccioIDDesde(java.lang.Long transaccioIDDesde) {
    this.transaccioIDDesde = transaccioIDDesde;
  }


  private java.lang.Long transaccioIDFins;

  public java.lang.Long getTransaccioIDFins() {
    return this.transaccioIDFins;
  }

  public void setTransaccioIDFins(java.lang.Long transaccioIDFins) {
    this.transaccioIDFins = transaccioIDFins;
  }


  private java.sql.Timestamp datainiciDesde;

  public java.sql.Timestamp getDatainiciDesde() {
    return this.datainiciDesde;
  }

  public void setDatainiciDesde(java.sql.Timestamp datainiciDesde) {
    this.datainiciDesde = datainiciDesde;
  }


  private java.sql.Timestamp datainiciFins;

  public java.sql.Timestamp getDatainiciFins() {
    return this.datainiciFins;
  }

  public void setDatainiciFins(java.sql.Timestamp datainiciFins) {
    this.datainiciFins = datainiciFins;
  }


  private java.sql.Timestamp datafiDesde;

  public java.sql.Timestamp getDatafiDesde() {
    return this.datafiDesde;
  }

  public void setDatafiDesde(java.sql.Timestamp datafiDesde) {
    this.datafiDesde = datafiDesde;
  }


  private java.sql.Timestamp datafiFins;

  public java.sql.Timestamp getDatafiFins() {
    return this.datafiFins;
  }

  public void setDatafiFins(java.sql.Timestamp datafiFins) {
    this.datafiFins = datafiFins;
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


  public TransaccioFilterForm() {
  }
  
  public TransaccioFilterForm(TransaccioFilterForm __toClone) {
    super(__toClone);
    this.transaccioIDDesde = __toClone.transaccioIDDesde;
    this.transaccioIDFins = __toClone.transaccioIDFins;
    this.datainiciDesde = __toClone.datainiciDesde;
    this.datainiciFins = __toClone.datainiciFins;
    this.datafiDesde = __toClone.datafiDesde;
    this.datafiFins = __toClone.datafiFins;
    this.usuariaplicacioidDesde = __toClone.usuariaplicacioidDesde;
    this.usuariaplicacioidFins = __toClone.usuariaplicacioidFins;
    this.usuaripersonaidDesde = __toClone.usuaripersonaidDesde;
    this.usuaripersonaidFins = __toClone.usuaripersonaidFins;
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

   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
