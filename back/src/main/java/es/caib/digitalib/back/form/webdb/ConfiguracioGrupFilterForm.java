
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.ConfiguracioGrupFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class ConfiguracioGrupFilterForm extends DigitalIBBaseFilterForm implements ConfiguracioGrupFields {

  private java.lang.Long configuracioGrupIDDesde;

  public java.lang.Long getConfiguracioGrupIDDesde() {
    return this.configuracioGrupIDDesde;
  }

  public void setConfiguracioGrupIDDesde(java.lang.Long configuracioGrupIDDesde) {
    this.configuracioGrupIDDesde = configuracioGrupIDDesde;
  }


  private java.lang.Long configuracioGrupIDFins;

  public java.lang.Long getConfiguracioGrupIDFins() {
    return this.configuracioGrupIDFins;
  }

  public void setConfiguracioGrupIDFins(java.lang.Long configuracioGrupIDFins) {
    this.configuracioGrupIDFins = configuracioGrupIDFins;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String suportWeb;

  public java.lang.String getSuportWeb() {
    return this.suportWeb;
  }

  public void setSuportWeb(java.lang.String suportWeb) {
    this.suportWeb = suportWeb;
  }


  private java.lang.String suportEmail;

  public java.lang.String getSuportEmail() {
    return this.suportEmail;
  }

  public void setSuportEmail(java.lang.String suportEmail) {
    this.suportEmail = suportEmail;
  }


  private java.lang.String suportTelefon;

  public java.lang.String getSuportTelefon() {
    return this.suportTelefon;
  }

  public void setSuportTelefon(java.lang.String suportTelefon) {
    this.suportTelefon = suportTelefon;
  }


  public ConfiguracioGrupFilterForm() {
  }
  
  public ConfiguracioGrupFilterForm(ConfiguracioGrupFilterForm __toClone) {
    super(__toClone);
    this.configuracioGrupIDDesde = __toClone.configuracioGrupIDDesde;
    this.configuracioGrupIDFins = __toClone.configuracioGrupIDFins;
    this.nom = __toClone.nom;
    this.suportWeb = __toClone.suportWeb;
    this.suportEmail = __toClone.suportEmail;
    this.suportTelefon = __toClone.suportTelefon;
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
