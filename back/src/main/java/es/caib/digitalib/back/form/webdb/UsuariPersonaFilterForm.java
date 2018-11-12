
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.UsuariPersonaFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class UsuariPersonaFilterForm extends DigitalIBBaseFilterForm implements UsuariPersonaFields {

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


  private java.lang.String username;

  public java.lang.String getUsername() {
    return this.username;
  }

  public void setUsername(java.lang.String username) {
    this.username = username;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String llinatges;

  public java.lang.String getLlinatges() {
    return this.llinatges;
  }

  public void setLlinatges(java.lang.String llinatges) {
    this.llinatges = llinatges;
  }


  private java.lang.String email;

  public java.lang.String getEmail() {
    return this.email;
  }

  public void setEmail(java.lang.String email) {
    this.email = email;
  }


  private java.lang.String nif;

  public java.lang.String getNif() {
    return this.nif;
  }

  public void setNif(java.lang.String nif) {
    this.nif = nif;
  }


  private java.lang.String idiomaID;

  public java.lang.String getIdiomaID() {
    return this.idiomaID;
  }

  public void setIdiomaID(java.lang.String idiomaID) {
    this.idiomaID = idiomaID;
  }


  private java.lang.Long configuraciogrupidDesde;

  public java.lang.Long getConfiguraciogrupidDesde() {
    return this.configuraciogrupidDesde;
  }

  public void setConfiguraciogrupidDesde(java.lang.Long configuraciogrupidDesde) {
    this.configuraciogrupidDesde = configuraciogrupidDesde;
  }


  private java.lang.Long configuraciogrupidFins;

  public java.lang.Long getConfiguraciogrupidFins() {
    return this.configuraciogrupidFins;
  }

  public void setConfiguraciogrupidFins(java.lang.Long configuraciogrupidFins) {
    this.configuraciogrupidFins = configuraciogrupidFins;
  }


  public UsuariPersonaFilterForm() {
  }
  
  public UsuariPersonaFilterForm(UsuariPersonaFilterForm __toClone) {
    super(__toClone);
    this.usuariPersonaIDDesde = __toClone.usuariPersonaIDDesde;
    this.usuariPersonaIDFins = __toClone.usuariPersonaIDFins;
    this.username = __toClone.username;
    this.nom = __toClone.nom;
    this.llinatges = __toClone.llinatges;
    this.email = __toClone.email;
    this.nif = __toClone.nif;
    this.idiomaID = __toClone.idiomaID;
    this.configuraciogrupidDesde = __toClone.configuraciogrupidDesde;
    this.configuraciogrupidFins = __toClone.configuraciogrupidFins;
    this.mapOfIdiomaForIdiomaID = __toClone.mapOfIdiomaForIdiomaID;
    this.mapOfConfiguracioGrupForConfiguraciogrupid = __toClone.mapOfConfiguracioGrupForConfiguraciogrupid;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { NOM ,EMAIL }));
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
  private Map<String, String> mapOfIdiomaForIdiomaID;

  public Map<String, String> getMapOfIdiomaForIdiomaID() {
    return this.mapOfIdiomaForIdiomaID;
  }

  public void setMapOfIdiomaForIdiomaID(Map<String, String> mapOfIdiomaForIdiomaID) {
    this.mapOfIdiomaForIdiomaID = mapOfIdiomaForIdiomaID;
  }



  private Map<String, String> mapOfConfiguracioGrupForConfiguraciogrupid;

  public Map<String, String> getMapOfConfiguracioGrupForConfiguraciogrupid() {
    return this.mapOfConfiguracioGrupForConfiguraciogrupid;
  }

  public void setMapOfConfiguracioGrupForConfiguraciogrupid(Map<String, String> mapOfConfiguracioGrupForConfiguraciogrupid) {
    this.mapOfConfiguracioGrupForConfiguraciogrupid = mapOfConfiguracioGrupForConfiguraciogrupid;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
