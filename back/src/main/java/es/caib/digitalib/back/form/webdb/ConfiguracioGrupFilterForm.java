
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


  private java.lang.String adreza;

  public java.lang.String getAdreza() {
    return this.adreza;
  }

  public void setAdreza(java.lang.String adreza) {
    this.adreza = adreza;
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


  private java.lang.Long perfilNomesEscaneig2IDDesde;

  public java.lang.Long getPerfilNomesEscaneig2IDDesde() {
    return this.perfilNomesEscaneig2IDDesde;
  }

  public void setPerfilNomesEscaneig2IDDesde(java.lang.Long perfilNomesEscaneig2IDDesde) {
    this.perfilNomesEscaneig2IDDesde = perfilNomesEscaneig2IDDesde;
  }


  private java.lang.Long perfilNomesEscaneig2IDFins;

  public java.lang.Long getPerfilNomesEscaneig2IDFins() {
    return this.perfilNomesEscaneig2IDFins;
  }

  public void setPerfilNomesEscaneig2IDFins(java.lang.Long perfilNomesEscaneig2IDFins) {
    this.perfilNomesEscaneig2IDFins = perfilNomesEscaneig2IDFins;
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


  private java.lang.Long perfilCopiaAutentica2IDDesde;

  public java.lang.Long getPerfilCopiaAutentica2IDDesde() {
    return this.perfilCopiaAutentica2IDDesde;
  }

  public void setPerfilCopiaAutentica2IDDesde(java.lang.Long perfilCopiaAutentica2IDDesde) {
    this.perfilCopiaAutentica2IDDesde = perfilCopiaAutentica2IDDesde;
  }


  private java.lang.Long perfilCopiaAutentica2IDFins;

  public java.lang.Long getPerfilCopiaAutentica2IDFins() {
    return this.perfilCopiaAutentica2IDFins;
  }

  public void setPerfilCopiaAutentica2IDFins(java.lang.Long perfilCopiaAutentica2IDFins) {
    this.perfilCopiaAutentica2IDFins = perfilCopiaAutentica2IDFins;
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


  private java.lang.Long perfilCustodia2IDDesde;

  public java.lang.Long getPerfilCustodia2IDDesde() {
    return this.perfilCustodia2IDDesde;
  }

  public void setPerfilCustodia2IDDesde(java.lang.Long perfilCustodia2IDDesde) {
    this.perfilCustodia2IDDesde = perfilCustodia2IDDesde;
  }


  private java.lang.Long perfilCustodia2IDFins;

  public java.lang.Long getPerfilCustodia2IDFins() {
    return this.perfilCustodia2IDFins;
  }

  public void setPerfilCustodia2IDFins(java.lang.Long perfilCustodia2IDFins) {
    this.perfilCustodia2IDFins = perfilCustodia2IDFins;
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
    this.adreza = __toClone.adreza;
    this.perfilNomesEscaneigIDDesde = __toClone.perfilNomesEscaneigIDDesde;
    this.perfilNomesEscaneigIDFins = __toClone.perfilNomesEscaneigIDFins;
    this.perfilNomesEscaneig2IDDesde = __toClone.perfilNomesEscaneig2IDDesde;
    this.perfilNomesEscaneig2IDFins = __toClone.perfilNomesEscaneig2IDFins;
    this.perfilCopiaAutenticaIDDesde = __toClone.perfilCopiaAutenticaIDDesde;
    this.perfilCopiaAutenticaIDFins = __toClone.perfilCopiaAutenticaIDFins;
    this.perfilCopiaAutentica2IDDesde = __toClone.perfilCopiaAutentica2IDDesde;
    this.perfilCopiaAutentica2IDFins = __toClone.perfilCopiaAutentica2IDFins;
    this.perfilCustodiaIDDesde = __toClone.perfilCustodiaIDDesde;
    this.perfilCustodiaIDFins = __toClone.perfilCustodiaIDFins;
    this.perfilCustodia2IDDesde = __toClone.perfilCustodia2IDDesde;
    this.perfilCustodia2IDFins = __toClone.perfilCustodia2IDFins;
    this.mapOfPerfilForPerfilNomesEscaneigID = __toClone.mapOfPerfilForPerfilNomesEscaneigID;
    this.mapOfPerfilForPerfilNomesEscaneig2ID = __toClone.mapOfPerfilForPerfilNomesEscaneig2ID;
    this.mapOfPerfilForPerfilCopiaAutenticaID = __toClone.mapOfPerfilForPerfilCopiaAutenticaID;
    this.mapOfPerfilForPerfilCopiaAutentica2ID = __toClone.mapOfPerfilForPerfilCopiaAutentica2ID;
    this.mapOfPerfilForPerfilCustodiaID = __toClone.mapOfPerfilForPerfilCustodiaID;
    this.mapOfPerfilForPerfilCustodia2ID = __toClone.mapOfPerfilForPerfilCustodia2ID;
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



  private Map<String, String> mapOfPerfilForPerfilNomesEscaneig2ID;

  public Map<String, String> getMapOfPerfilForPerfilNomesEscaneig2ID() {
    return this.mapOfPerfilForPerfilNomesEscaneig2ID;
  }

  public void setMapOfPerfilForPerfilNomesEscaneig2ID(Map<String, String> mapOfPerfilForPerfilNomesEscaneig2ID) {
    this.mapOfPerfilForPerfilNomesEscaneig2ID = mapOfPerfilForPerfilNomesEscaneig2ID;
  }



  private Map<String, String> mapOfPerfilForPerfilCopiaAutenticaID;

  public Map<String, String> getMapOfPerfilForPerfilCopiaAutenticaID() {
    return this.mapOfPerfilForPerfilCopiaAutenticaID;
  }

  public void setMapOfPerfilForPerfilCopiaAutenticaID(Map<String, String> mapOfPerfilForPerfilCopiaAutenticaID) {
    this.mapOfPerfilForPerfilCopiaAutenticaID = mapOfPerfilForPerfilCopiaAutenticaID;
  }



  private Map<String, String> mapOfPerfilForPerfilCopiaAutentica2ID;

  public Map<String, String> getMapOfPerfilForPerfilCopiaAutentica2ID() {
    return this.mapOfPerfilForPerfilCopiaAutentica2ID;
  }

  public void setMapOfPerfilForPerfilCopiaAutentica2ID(Map<String, String> mapOfPerfilForPerfilCopiaAutentica2ID) {
    this.mapOfPerfilForPerfilCopiaAutentica2ID = mapOfPerfilForPerfilCopiaAutentica2ID;
  }



  private Map<String, String> mapOfPerfilForPerfilCustodiaID;

  public Map<String, String> getMapOfPerfilForPerfilCustodiaID() {
    return this.mapOfPerfilForPerfilCustodiaID;
  }

  public void setMapOfPerfilForPerfilCustodiaID(Map<String, String> mapOfPerfilForPerfilCustodiaID) {
    this.mapOfPerfilForPerfilCustodiaID = mapOfPerfilForPerfilCustodiaID;
  }



  private Map<String, String> mapOfPerfilForPerfilCustodia2ID;

  public Map<String, String> getMapOfPerfilForPerfilCustodia2ID() {
    return this.mapOfPerfilForPerfilCustodia2ID;
  }

  public void setMapOfPerfilForPerfilCustodia2ID(Map<String, String> mapOfPerfilForPerfilCustodia2ID) {
    this.mapOfPerfilForPerfilCustodia2ID = mapOfPerfilForPerfilCustodia2ID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
