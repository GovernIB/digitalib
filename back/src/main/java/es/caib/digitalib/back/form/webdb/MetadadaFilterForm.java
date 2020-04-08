
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.MetadadaFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class MetadadaFilterForm extends DigitalIBBaseFilterForm implements MetadadaFields {

  private java.lang.Long metadadaidDesde;

  public java.lang.Long getMetadadaidDesde() {
    return this.metadadaidDesde;
  }

  public void setMetadadaidDesde(java.lang.Long metadadaidDesde) {
    this.metadadaidDesde = metadadaidDesde;
  }


  private java.lang.Long metadadaidFins;

  public java.lang.Long getMetadadaidFins() {
    return this.metadadaidFins;
  }

  public void setMetadadaidFins(java.lang.Long metadadaidFins) {
    this.metadadaidFins = metadadaidFins;
  }


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


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String valor;

  public java.lang.String getValor() {
    return this.valor;
  }

  public void setValor(java.lang.String valor) {
    this.valor = valor;
  }


  public MetadadaFilterForm() {
  }
  
  public MetadadaFilterForm(MetadadaFilterForm __toClone) {
    super(__toClone);
    this.metadadaidDesde = __toClone.metadadaidDesde;
    this.metadadaidFins = __toClone.metadadaidFins;
    this.transaccioIDDesde = __toClone.transaccioIDDesde;
    this.transaccioIDFins = __toClone.transaccioIDFins;
    this.nom = __toClone.nom;
    this.valor = __toClone.valor;
    this.mapOfTransaccioForTransaccioID = __toClone.mapOfTransaccioForTransaccioID;
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


  protected OrderBy[] defaultOrderBy = new OrderBy[] {new OrderBy(NOM )};


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
  private Map<String, String> mapOfTransaccioForTransaccioID;

  public Map<String, String> getMapOfTransaccioForTransaccioID() {
    return this.mapOfTransaccioForTransaccioID;
  }

  public void setMapOfTransaccioForTransaccioID(Map<String, String> mapOfTransaccioForTransaccioID) {
    this.mapOfTransaccioForTransaccioID = mapOfTransaccioForTransaccioID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
