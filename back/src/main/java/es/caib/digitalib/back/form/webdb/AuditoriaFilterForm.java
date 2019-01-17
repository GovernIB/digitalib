
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.AuditoriaFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class AuditoriaFilterForm extends DigitalIBBaseFilterForm implements AuditoriaFields {

  private java.lang.Long auditoriaIDDesde;

  public java.lang.Long getAuditoriaIDDesde() {
    return this.auditoriaIDDesde;
  }

  public void setAuditoriaIDDesde(java.lang.Long auditoriaIDDesde) {
    this.auditoriaIDDesde = auditoriaIDDesde;
  }


  private java.lang.Long auditoriaIDFins;

  public java.lang.Long getAuditoriaIDFins() {
    return this.auditoriaIDFins;
  }

  public void setAuditoriaIDFins(java.lang.Long auditoriaIDFins) {
    this.auditoriaIDFins = auditoriaIDFins;
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


  private java.lang.Long transaccioIdDesde;

  public java.lang.Long getTransaccioIdDesde() {
    return this.transaccioIdDesde;
  }

  public void setTransaccioIdDesde(java.lang.Long transaccioIdDesde) {
    this.transaccioIdDesde = transaccioIdDesde;
  }


  private java.lang.Long transaccioIdFins;

  public java.lang.Long getTransaccioIdFins() {
    return this.transaccioIdFins;
  }

  public void setTransaccioIdFins(java.lang.Long transaccioIdFins) {
    this.transaccioIdFins = transaccioIdFins;
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


  private java.lang.String missatge;

  public java.lang.String getMissatge() {
    return this.missatge;
  }

  public void setMissatge(java.lang.String missatge) {
    this.missatge = missatge;
  }


  private java.lang.String additionalInfo;

  public java.lang.String getAdditionalInfo() {
    return this.additionalInfo;
  }

  public void setAdditionalInfo(java.lang.String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }


  private java.lang.String usernameAplicacio;

  public java.lang.String getUsernameAplicacio() {
    return this.usernameAplicacio;
  }

  public void setUsernameAplicacio(java.lang.String usernameAplicacio) {
    this.usernameAplicacio = usernameAplicacio;
  }


  private java.lang.String usernamePersona;

  public java.lang.String getUsernamePersona() {
    return this.usernamePersona;
  }

  public void setUsernamePersona(java.lang.String usernamePersona) {
    this.usernamePersona = usernamePersona;
  }


  public AuditoriaFilterForm() {
  }
  
  public AuditoriaFilterForm(AuditoriaFilterForm __toClone) {
    super(__toClone);
    this.auditoriaIDDesde = __toClone.auditoriaIDDesde;
    this.auditoriaIDFins = __toClone.auditoriaIDFins;
    this.dataDesde = __toClone.dataDesde;
    this.dataFins = __toClone.dataFins;
    this.transaccioIdDesde = __toClone.transaccioIdDesde;
    this.transaccioIdFins = __toClone.transaccioIdFins;
    this.tipusDesde = __toClone.tipusDesde;
    this.tipusFins = __toClone.tipusFins;
    this.missatge = __toClone.missatge;
    this.additionalInfo = __toClone.additionalInfo;
    this.usernameAplicacio = __toClone.usernameAplicacio;
    this.usernamePersona = __toClone.usernamePersona;
    this.mapOfValuesForTipus = __toClone.mapOfValuesForTipus;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { TRANSACCIOID ,MISSATGE ,ADDITIONALINFO ,USERNAMEAPLICACIO ,USERNAMEPERSONA }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { DATA ,TIPUS }));
  }


  protected OrderBy[] defaultOrderBy = new OrderBy[] {new OrderBy(DATA, org.fundaciobit.genapp.common.query.OrderType.DESC )};


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
