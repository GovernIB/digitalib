
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.ApiSimpleFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class ApiSimpleFilterForm extends DigitalIBBaseFilterForm implements ApiSimpleFields {

  private java.lang.Long apiSimpleIDDesde;

  public java.lang.Long getApiSimpleIDDesde() {
    return this.apiSimpleIDDesde;
  }

  public void setApiSimpleIDDesde(java.lang.Long apiSimpleIDDesde) {
    this.apiSimpleIDDesde = apiSimpleIDDesde;
  }


  private java.lang.Long apiSimpleIDFins;

  public java.lang.Long getApiSimpleIDFins() {
    return this.apiSimpleIDFins;
  }

  public void setApiSimpleIDFins(java.lang.Long apiSimpleIDFins) {
    this.apiSimpleIDFins = apiSimpleIDFins;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String url;

  public java.lang.String getUrl() {
    return this.url;
  }

  public void setUrl(java.lang.String url) {
    this.url = url;
  }


  private java.lang.String username;

  public java.lang.String getUsername() {
    return this.username;
  }

  public void setUsername(java.lang.String username) {
    this.username = username;
  }


  private java.lang.String contrasenya;

  public java.lang.String getContrasenya() {
    return this.contrasenya;
  }

  public void setContrasenya(java.lang.String contrasenya) {
    this.contrasenya = contrasenya;
  }


  private java.lang.String perfil;

  public java.lang.String getPerfil() {
    return this.perfil;
  }

  public void setPerfil(java.lang.String perfil) {
    this.perfil = perfil;
  }


  private java.lang.String configDeFirma;

  public java.lang.String getConfigDeFirma() {
    return this.configDeFirma;
  }

  public void setConfigDeFirma(java.lang.String configDeFirma) {
    this.configDeFirma = configDeFirma;
  }


  public ApiSimpleFilterForm() {
  }
  
  public ApiSimpleFilterForm(ApiSimpleFilterForm __toClone) {
    super(__toClone);
    this.apiSimpleIDDesde = __toClone.apiSimpleIDDesde;
    this.apiSimpleIDFins = __toClone.apiSimpleIDFins;
    this.nom = __toClone.nom;
    this.url = __toClone.url;
    this.username = __toClone.username;
    this.contrasenya = __toClone.contrasenya;
    this.perfil = __toClone.perfil;
    this.configDeFirma = __toClone.configDeFirma;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { NOM }));
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
