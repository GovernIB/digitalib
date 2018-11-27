
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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


  private java.lang.Long perfilNomesEscaneigIDDesde;

  public java.lang.Long getPerfilNomesEscaneigIDDesde() {
    return this.perfilNomesEscaneigIDDesde;
  }

  public void setPerfilNomesEscaneigIDDesde(java.lang.Long perfilNomesEscaneigIDDesde) {
    this.perfilNomesEscaneigIDDesde = perfilNomesEscaneigIDDesde;
  }


  private java.lang.Long perfilNomesEscaneigIDFins;

  public java.lang.Long getPerfilNomesEscaneigIDFins() {
    return this.perfilNomesEscaneigIDFins;
  }

  public void setPerfilNomesEscaneigIDFins(java.lang.Long perfilNomesEscaneigIDFins) {
    this.perfilNomesEscaneigIDFins = perfilNomesEscaneigIDFins;
  }


  private java.lang.Long perfilCopiaAutenticaIDDesde;

  public java.lang.Long getPerfilCopiaAutenticaIDDesde() {
    return this.perfilCopiaAutenticaIDDesde;
  }

  public void setPerfilCopiaAutenticaIDDesde(java.lang.Long perfilCopiaAutenticaIDDesde) {
    this.perfilCopiaAutenticaIDDesde = perfilCopiaAutenticaIDDesde;
  }


  private java.lang.Long perfilCopiaAutenticaIDFins;

  public java.lang.Long getPerfilCopiaAutenticaIDFins() {
    return this.perfilCopiaAutenticaIDFins;
  }

  public void setPerfilCopiaAutenticaIDFins(java.lang.Long perfilCopiaAutenticaIDFins) {
    this.perfilCopiaAutenticaIDFins = perfilCopiaAutenticaIDFins;
  }


  private java.lang.Long perfilCustodiaIDDesde;

  public java.lang.Long getPerfilCustodiaIDDesde() {
    return this.perfilCustodiaIDDesde;
  }

  public void setPerfilCustodiaIDDesde(java.lang.Long perfilCustodiaIDDesde) {
    this.perfilCustodiaIDDesde = perfilCustodiaIDDesde;
  }


  private java.lang.Long perfilCustodiaIDFins;

  public java.lang.Long getPerfilCustodiaIDFins() {
    return this.perfilCustodiaIDFins;
  }

  public void setPerfilCustodiaIDFins(java.lang.Long perfilCustodiaIDFins) {
    this.perfilCustodiaIDFins = perfilCustodiaIDFins;
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
    this.perfilNomesEscaneigIDDesde = __toClone.perfilNomesEscaneigIDDesde;
    this.perfilNomesEscaneigIDFins = __toClone.perfilNomesEscaneigIDFins;
    this.perfilCopiaAutenticaIDDesde = __toClone.perfilCopiaAutenticaIDDesde;
    this.perfilCopiaAutenticaIDFins = __toClone.perfilCopiaAutenticaIDFins;
    this.perfilCustodiaIDDesde = __toClone.perfilCustodiaIDDesde;
    this.perfilCustodiaIDFins = __toClone.perfilCustodiaIDFins;
    this.mapOfPerfilForPerfilNomesEscaneigID = __toClone.mapOfPerfilForPerfilNomesEscaneigID;
    this.mapOfPerfilForPerfilCopiaAutenticaID = __toClone.mapOfPerfilForPerfilCopiaAutenticaID;
    this.mapOfPerfilForPerfilCustodiaID = __toClone.mapOfPerfilForPerfilCustodiaID;
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
  private Map<String, String> mapOfPerfilForPerfilNomesEscaneigID;

  public Map<String, String> getMapOfPerfilForPerfilNomesEscaneigID() {
    return this.mapOfPerfilForPerfilNomesEscaneigID;
  }

  public void setMapOfPerfilForPerfilNomesEscaneigID(Map<String, String> mapOfPerfilForPerfilNomesEscaneigID) {
    this.mapOfPerfilForPerfilNomesEscaneigID = mapOfPerfilForPerfilNomesEscaneigID;
  }



  private Map<String, String> mapOfPerfilForPerfilCopiaAutenticaID;

  public Map<String, String> getMapOfPerfilForPerfilCopiaAutenticaID() {
    return this.mapOfPerfilForPerfilCopiaAutenticaID;
  }

  public void setMapOfPerfilForPerfilCopiaAutenticaID(Map<String, String> mapOfPerfilForPerfilCopiaAutenticaID) {
    this.mapOfPerfilForPerfilCopiaAutenticaID = mapOfPerfilForPerfilCopiaAutenticaID;
  }



  private Map<String, String> mapOfPerfilForPerfilCustodiaID;

  public Map<String, String> getMapOfPerfilForPerfilCustodiaID() {
    return this.mapOfPerfilForPerfilCustodiaID;
  }

  public void setMapOfPerfilForPerfilCustodiaID(Map<String, String> mapOfPerfilForPerfilCustodiaID) {
    this.mapOfPerfilForPerfilCustodiaID = mapOfPerfilForPerfilCustodiaID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
