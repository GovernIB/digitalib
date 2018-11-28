
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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


  private java.lang.String transactionWebId;

  public java.lang.String getTransactionWebId() {
    return this.transactionWebId;
  }

  public void setTransactionWebId(java.lang.String transactionWebId) {
    this.transactionWebId = transactionWebId;
  }


  private java.sql.Timestamp dataIniciDesde;

  public java.sql.Timestamp getDataIniciDesde() {
    return this.dataIniciDesde;
  }

  public void setDataIniciDesde(java.sql.Timestamp dataIniciDesde) {
    this.dataIniciDesde = dataIniciDesde;
  }


  private java.sql.Timestamp dataIniciFins;

  public java.sql.Timestamp getDataIniciFins() {
    return this.dataIniciFins;
  }

  public void setDataIniciFins(java.sql.Timestamp dataIniciFins) {
    this.dataIniciFins = dataIniciFins;
  }


  private java.sql.Timestamp dataFiDesde;

  public java.sql.Timestamp getDataFiDesde() {
    return this.dataFiDesde;
  }

  public void setDataFiDesde(java.sql.Timestamp dataFiDesde) {
    this.dataFiDesde = dataFiDesde;
  }


  private java.sql.Timestamp dataFiFins;

  public java.sql.Timestamp getDataFiFins() {
    return this.dataFiFins;
  }

  public void setDataFiFins(java.sql.Timestamp dataFiFins) {
    this.dataFiFins = dataFiFins;
  }


  private java.lang.Long usuariAplicacioIdDesde;

  public java.lang.Long getUsuariAplicacioIdDesde() {
    return this.usuariAplicacioIdDesde;
  }

  public void setUsuariAplicacioIdDesde(java.lang.Long usuariAplicacioIdDesde) {
    this.usuariAplicacioIdDesde = usuariAplicacioIdDesde;
  }


  private java.lang.Long usuariAplicacioIdFins;

  public java.lang.Long getUsuariAplicacioIdFins() {
    return this.usuariAplicacioIdFins;
  }

  public void setUsuariAplicacioIdFins(java.lang.Long usuariAplicacioIdFins) {
    this.usuariAplicacioIdFins = usuariAplicacioIdFins;
  }


  private java.lang.Long usuariPersonaIdDesde;

  public java.lang.Long getUsuariPersonaIdDesde() {
    return this.usuariPersonaIdDesde;
  }

  public void setUsuariPersonaIdDesde(java.lang.Long usuariPersonaIdDesde) {
    this.usuariPersonaIdDesde = usuariPersonaIdDesde;
  }


  private java.lang.Long usuariPersonaIdFins;

  public java.lang.Long getUsuariPersonaIdFins() {
    return this.usuariPersonaIdFins;
  }

  public void setUsuariPersonaIdFins(java.lang.Long usuariPersonaIdFins) {
    this.usuariPersonaIdFins = usuariPersonaIdFins;
  }


  private java.lang.Integer estatCodiDesde;

  public java.lang.Integer getEstatCodiDesde() {
    return this.estatCodiDesde;
  }

  public void setEstatCodiDesde(java.lang.Integer estatCodiDesde) {
    this.estatCodiDesde = estatCodiDesde;
  }


  private java.lang.Integer estatCodiFins;

  public java.lang.Integer getEstatCodiFins() {
    return this.estatCodiFins;
  }

  public void setEstatCodiFins(java.lang.Integer estatCodiFins) {
    this.estatCodiFins = estatCodiFins;
  }


  private java.lang.String estatMissatge;

  public java.lang.String getEstatMissatge() {
    return this.estatMissatge;
  }

  public void setEstatMissatge(java.lang.String estatMissatge) {
    this.estatMissatge = estatMissatge;
  }


  private java.lang.String estatExcepcio;

  public java.lang.String getEstatExcepcio() {
    return this.estatExcepcio;
  }

  public void setEstatExcepcio(java.lang.String estatExcepcio) {
    this.estatExcepcio = estatExcepcio;
  }


  private java.lang.Integer infoScanPixelTypeDesde;

  public java.lang.Integer getInfoScanPixelTypeDesde() {
    return this.infoScanPixelTypeDesde;
  }

  public void setInfoScanPixelTypeDesde(java.lang.Integer infoScanPixelTypeDesde) {
    this.infoScanPixelTypeDesde = infoScanPixelTypeDesde;
  }


  private java.lang.Integer infoScanPixelTypeFins;

  public java.lang.Integer getInfoScanPixelTypeFins() {
    return this.infoScanPixelTypeFins;
  }

  public void setInfoScanPixelTypeFins(java.lang.Integer infoScanPixelTypeFins) {
    this.infoScanPixelTypeFins = infoScanPixelTypeFins;
  }


  private java.lang.Integer infoScanResolucioPppDesde;

  public java.lang.Integer getInfoScanResolucioPppDesde() {
    return this.infoScanResolucioPppDesde;
  }

  public void setInfoScanResolucioPppDesde(java.lang.Integer infoScanResolucioPppDesde) {
    this.infoScanResolucioPppDesde = infoScanResolucioPppDesde;
  }


  private java.lang.Integer infoScanResolucioPppFins;

  public java.lang.Integer getInfoScanResolucioPppFins() {
    return this.infoScanResolucioPppFins;
  }

  public void setInfoScanResolucioPppFins(java.lang.Integer infoScanResolucioPppFins) {
    this.infoScanResolucioPppFins = infoScanResolucioPppFins;
  }


  private java.lang.Long infoSignaturaIDDesde;

  public java.lang.Long getInfoSignaturaIDDesde() {
    return this.infoSignaturaIDDesde;
  }

  public void setInfoSignaturaIDDesde(java.lang.Long infoSignaturaIDDesde) {
    this.infoSignaturaIDDesde = infoSignaturaIDDesde;
  }


  private java.lang.Long infoSignaturaIDFins;

  public java.lang.Long getInfoSignaturaIDFins() {
    return this.infoSignaturaIDFins;
  }

  public void setInfoSignaturaIDFins(java.lang.Long infoSignaturaIDFins) {
    this.infoSignaturaIDFins = infoSignaturaIDFins;
  }


  private java.lang.Long infoCustodyIDDesde;

  public java.lang.Long getInfoCustodyIDDesde() {
    return this.infoCustodyIDDesde;
  }

  public void setInfoCustodyIDDesde(java.lang.Long infoCustodyIDDesde) {
    this.infoCustodyIDDesde = infoCustodyIDDesde;
  }


  private java.lang.Long infoCustodyIDFins;

  public java.lang.Long getInfoCustodyIDFins() {
    return this.infoCustodyIDFins;
  }

  public void setInfoCustodyIDFins(java.lang.Long infoCustodyIDFins) {
    this.infoCustodyIDFins = infoCustodyIDFins;
  }


  private java.lang.String languageUI;

  public java.lang.String getLanguageUI() {
    return this.languageUI;
  }

  public void setLanguageUI(java.lang.String languageUI) {
    this.languageUI = languageUI;
  }


  private java.lang.String languageDoc;

  public java.lang.String getLanguageDoc() {
    return this.languageDoc;
  }

  public void setLanguageDoc(java.lang.String languageDoc) {
    this.languageDoc = languageDoc;
  }


  private java.lang.String ciutadaNif;

  public java.lang.String getCiutadaNif() {
    return this.ciutadaNif;
  }

  public void setCiutadaNif(java.lang.String ciutadaNif) {
    this.ciutadaNif = ciutadaNif;
  }


  private java.lang.String ciutadaNom;

  public java.lang.String getCiutadaNom() {
    return this.ciutadaNom;
  }

  public void setCiutadaNom(java.lang.String ciutadaNom) {
    this.ciutadaNom = ciutadaNom;
  }


  private java.lang.String funcionariUsername;

  public java.lang.String getFuncionariUsername() {
    return this.funcionariUsername;
  }

  public void setFuncionariUsername(java.lang.String funcionariUsername) {
    this.funcionariUsername = funcionariUsername;
  }


  private java.lang.String funcionariNom;

  public java.lang.String getFuncionariNom() {
    return this.funcionariNom;
  }

  public void setFuncionariNom(java.lang.String funcionariNom) {
    this.funcionariNom = funcionariNom;
  }


  private java.lang.String expedient;

  public java.lang.String getExpedient() {
    return this.expedient;
  }

  public void setExpedient(java.lang.String expedient) {
    this.expedient = expedient;
  }


  private java.lang.String usernameRequest;

  public java.lang.String getUsernameRequest() {
    return this.usernameRequest;
  }

  public void setUsernameRequest(java.lang.String usernameRequest) {
    this.usernameRequest = usernameRequest;
  }


  private java.lang.String returnUrl;

  public java.lang.String getReturnUrl() {
    return this.returnUrl;
  }

  public void setReturnUrl(java.lang.String returnUrl) {
    this.returnUrl = returnUrl;
  }


  private java.lang.Integer viewDesde;

  public java.lang.Integer getViewDesde() {
    return this.viewDesde;
  }

  public void setViewDesde(java.lang.Integer viewDesde) {
    this.viewDesde = viewDesde;
  }


  private java.lang.Integer viewFins;

  public java.lang.Integer getViewFins() {
    return this.viewFins;
  }

  public void setViewFins(java.lang.Integer viewFins) {
    this.viewFins = viewFins;
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


  public TransaccioFilterForm() {
  }
  
  public TransaccioFilterForm(TransaccioFilterForm __toClone) {
    super(__toClone);
    this.transaccioIDDesde = __toClone.transaccioIDDesde;
    this.transaccioIDFins = __toClone.transaccioIDFins;
    this.transactionWebId = __toClone.transactionWebId;
    this.dataIniciDesde = __toClone.dataIniciDesde;
    this.dataIniciFins = __toClone.dataIniciFins;
    this.dataFiDesde = __toClone.dataFiDesde;
    this.dataFiFins = __toClone.dataFiFins;
    this.usuariAplicacioIdDesde = __toClone.usuariAplicacioIdDesde;
    this.usuariAplicacioIdFins = __toClone.usuariAplicacioIdFins;
    this.usuariPersonaIdDesde = __toClone.usuariPersonaIdDesde;
    this.usuariPersonaIdFins = __toClone.usuariPersonaIdFins;
    this.estatCodiDesde = __toClone.estatCodiDesde;
    this.estatCodiFins = __toClone.estatCodiFins;
    this.estatMissatge = __toClone.estatMissatge;
    this.estatExcepcio = __toClone.estatExcepcio;
    this.infoScanPixelTypeDesde = __toClone.infoScanPixelTypeDesde;
    this.infoScanPixelTypeFins = __toClone.infoScanPixelTypeFins;
    this.infoScanResolucioPppDesde = __toClone.infoScanResolucioPppDesde;
    this.infoScanResolucioPppFins = __toClone.infoScanResolucioPppFins;
    this.infoSignaturaIDDesde = __toClone.infoSignaturaIDDesde;
    this.infoSignaturaIDFins = __toClone.infoSignaturaIDFins;
    this.infoCustodyIDDesde = __toClone.infoCustodyIDDesde;
    this.infoCustodyIDFins = __toClone.infoCustodyIDFins;
    this.languageUI = __toClone.languageUI;
    this.languageDoc = __toClone.languageDoc;
    this.ciutadaNif = __toClone.ciutadaNif;
    this.ciutadaNom = __toClone.ciutadaNom;
    this.funcionariUsername = __toClone.funcionariUsername;
    this.funcionariNom = __toClone.funcionariNom;
    this.expedient = __toClone.expedient;
    this.usernameRequest = __toClone.usernameRequest;
    this.returnUrl = __toClone.returnUrl;
    this.viewDesde = __toClone.viewDesde;
    this.viewFins = __toClone.viewFins;
    this.perfilIDDesde = __toClone.perfilIDDesde;
    this.perfilIDFins = __toClone.perfilIDFins;
    this.mapOfValuesForEstatCodi = __toClone.mapOfValuesForEstatCodi;
    this.mapOfInfoSignaturaForInfoSignaturaID = __toClone.mapOfInfoSignaturaForInfoSignaturaID;
    this.mapOfInfoCustodyForInfoCustodyID = __toClone.mapOfInfoCustodyForInfoCustodyID;
    this.mapOfValuesForView = __toClone.mapOfValuesForView;
    this.mapOfPerfilForPerfilID = __toClone.mapOfPerfilForPerfilID;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { TRANSACTIONWEBID ,ESTATMISSATGE ,USERNAMEREQUEST ,RETURNURL }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { DATAINICI ,DATAFI ,USUARIAPLICACIOID ,USUARIPERSONAID ,ESTATCODI ,FUNCIONARIUSERNAME }));
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
  private Map<String, String> mapOfValuesForEstatCodi;

  public Map<String, String> getMapOfValuesForEstatCodi() {
    return this.mapOfValuesForEstatCodi;
  }

  public void setMapOfValuesForEstatCodi(Map<String, String> mapOfValuesForEstatCodi) {
    this.mapOfValuesForEstatCodi = mapOfValuesForEstatCodi;
  }



  private Map<String, String> mapOfInfoSignaturaForInfoSignaturaID;

  public Map<String, String> getMapOfInfoSignaturaForInfoSignaturaID() {
    return this.mapOfInfoSignaturaForInfoSignaturaID;
  }

  public void setMapOfInfoSignaturaForInfoSignaturaID(Map<String, String> mapOfInfoSignaturaForInfoSignaturaID) {
    this.mapOfInfoSignaturaForInfoSignaturaID = mapOfInfoSignaturaForInfoSignaturaID;
  }



  private Map<String, String> mapOfInfoCustodyForInfoCustodyID;

  public Map<String, String> getMapOfInfoCustodyForInfoCustodyID() {
    return this.mapOfInfoCustodyForInfoCustodyID;
  }

  public void setMapOfInfoCustodyForInfoCustodyID(Map<String, String> mapOfInfoCustodyForInfoCustodyID) {
    this.mapOfInfoCustodyForInfoCustodyID = mapOfInfoCustodyForInfoCustodyID;
  }



  private Map<String, String> mapOfValuesForView;

  public Map<String, String> getMapOfValuesForView() {
    return this.mapOfValuesForView;
  }

  public void setMapOfValuesForView(Map<String, String> mapOfValuesForView) {
    this.mapOfValuesForView = mapOfValuesForView;
  }



  private Map<String, String> mapOfPerfilForPerfilID;

  public Map<String, String> getMapOfPerfilForPerfilID() {
    return this.mapOfPerfilForPerfilID;
  }

  public void setMapOfPerfilForPerfilID(Map<String, String> mapOfPerfilForPerfilID) {
    this.mapOfPerfilForPerfilID = mapOfPerfilForPerfilID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
