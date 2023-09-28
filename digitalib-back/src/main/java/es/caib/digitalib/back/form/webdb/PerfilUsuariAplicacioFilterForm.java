
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class PerfilUsuariAplicacioFilterForm extends DigitalIBBaseFilterForm implements PerfilUsuariAplicacioFields {

  private java.lang.Long perfilUsrAppIDDesde;

  public java.lang.Long getPerfilUsrAppIDDesde() {
    return this.perfilUsrAppIDDesde;
  }

  public void setPerfilUsrAppIDDesde(java.lang.Long perfilUsrAppIDDesde) {
    this.perfilUsrAppIDDesde = perfilUsrAppIDDesde;
  }


  private java.lang.Long perfilUsrAppIDFins;

  public java.lang.Long getPerfilUsrAppIDFins() {
    return this.perfilUsrAppIDFins;
  }

  public void setPerfilUsrAppIDFins(java.lang.Long perfilUsrAppIDFins) {
    this.perfilUsrAppIDFins = perfilUsrAppIDFins;
  }


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


  public PerfilUsuariAplicacioFilterForm() {
  }
  
  public PerfilUsuariAplicacioFilterForm(PerfilUsuariAplicacioFilterForm __toClone) {
    super(__toClone);
    this.perfilUsrAppIDDesde = __toClone.perfilUsrAppIDDesde;
    this.perfilUsrAppIDFins = __toClone.perfilUsrAppIDFins;
    this.perfilIDDesde = __toClone.perfilIDDesde;
    this.perfilIDFins = __toClone.perfilIDFins;
    this.usuariAplicacioIDDesde = __toClone.usuariAplicacioIDDesde;
    this.usuariAplicacioIDFins = __toClone.usuariAplicacioIDFins;
    this.mapOfPerfilForPerfilID = __toClone.mapOfPerfilForPerfilID;
    this.mapOfUsuariAplicacioForUsuariAplicacioID = __toClone.mapOfUsuariAplicacioForUsuariAplicacioID;
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
  private Map<String, String> mapOfPerfilForPerfilID;

  public Map<String, String> getMapOfPerfilForPerfilID() {
    return this.mapOfPerfilForPerfilID;
  }

  public void setMapOfPerfilForPerfilID(Map<String, String> mapOfPerfilForPerfilID) {
    this.mapOfPerfilForPerfilID = mapOfPerfilForPerfilID;
  }



  private Map<String, String> mapOfUsuariAplicacioForUsuariAplicacioID;

  public Map<String, String> getMapOfUsuariAplicacioForUsuariAplicacioID() {
    return this.mapOfUsuariAplicacioForUsuariAplicacioID;
  }

  public void setMapOfUsuariAplicacioForUsuariAplicacioID(Map<String, String> mapOfUsuariAplicacioForUsuariAplicacioID) {
    this.mapOfUsuariAplicacioForUsuariAplicacioID = mapOfUsuariAplicacioForUsuariAplicacioID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
