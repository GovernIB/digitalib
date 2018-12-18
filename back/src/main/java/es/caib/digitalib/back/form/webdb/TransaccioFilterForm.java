
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


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
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


  private java.lang.String ip;

  public java.lang.String getIp() {
    return this.ip;
  }

  public void setIp(java.lang.String ip) {
    this.ip = ip;
  }


  private java.lang.String returnUrl;

  public java.lang.String getReturnUrl() {
    return this.returnUrl;
  }

  public void setReturnUrl(java.lang.String returnUrl) {
    this.returnUrl = returnUrl;
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


  private java.lang.String hashEscaneig;

  public java.lang.String getHashEscaneig() {
    return this.hashEscaneig;
  }

  public void setHashEscaneig(java.lang.String hashEscaneig) {
    this.hashEscaneig = hashEscaneig;
  }


  private java.lang.String hashFirma;

  public java.lang.String getHashFirma() {
    return this.hashFirma;
  }

  public void setHashFirma(java.lang.String hashFirma) {
    this.hashFirma = hashFirma;
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


  private java.lang.String languageUI;

  public java.lang.String getLanguageUI() {
    return this.languageUI;
  }

  public void setLanguageUI(java.lang.String languageUI) {
    this.languageUI = languageUI;
  }


  private java.lang.String funcionariUsername;

  public java.lang.String getFuncionariUsername() {
    return this.funcionariUsername;
  }

  public void setFuncionariUsername(java.lang.String funcionariUsername) {
    this.funcionariUsername = funcionariUsername;
  }


  private java.lang.String signParamFuncionariNom;

  public java.lang.String getSignParamFuncionariNom() {
    return this.signParamFuncionariNom;
  }

  public void setSignParamFuncionariNom(java.lang.String signParamFuncionariNom) {
    this.signParamFuncionariNom = signParamFuncionariNom;
  }


  private java.lang.String signParamFuncionariNif;

  public java.lang.String getSignParamFuncionariNif() {
    return this.signParamFuncionariNif;
  }

  public void setSignParamFuncionariNif(java.lang.String signParamFuncionariNif) {
    this.signParamFuncionariNif = signParamFuncionariNif;
  }


  private java.lang.String signParamLanguageDoc;

  public java.lang.String getSignParamLanguageDoc() {
    return this.signParamLanguageDoc;
  }

  public void setSignParamLanguageDoc(java.lang.String signParamLanguageDoc) {
    this.signParamLanguageDoc = signParamLanguageDoc;
  }


  private java.lang.String arxiuReqParamDocEstatElabora;

  public java.lang.String getArxiuReqParamDocEstatElabora() {
    return this.arxiuReqParamDocEstatElabora;
  }

  public void setArxiuReqParamDocEstatElabora(java.lang.String arxiuReqParamDocEstatElabora) {
    this.arxiuReqParamDocEstatElabora = arxiuReqParamDocEstatElabora;
  }


  private java.lang.String arxiuReqParamDocumentTipus;

  public java.lang.String getArxiuReqParamDocumentTipus() {
    return this.arxiuReqParamDocumentTipus;
  }

  public void setArxiuReqParamDocumentTipus(java.lang.String arxiuReqParamDocumentTipus) {
    this.arxiuReqParamDocumentTipus = arxiuReqParamDocumentTipus;
  }


  private java.lang.Integer arxiuReqParamOrigenDesde;

  public java.lang.Integer getArxiuReqParamOrigenDesde() {
    return this.arxiuReqParamOrigenDesde;
  }

  public void setArxiuReqParamOrigenDesde(java.lang.Integer arxiuReqParamOrigenDesde) {
    this.arxiuReqParamOrigenDesde = arxiuReqParamOrigenDesde;
  }


  private java.lang.Integer arxiuReqParamOrigenFins;

  public java.lang.Integer getArxiuReqParamOrigenFins() {
    return this.arxiuReqParamOrigenFins;
  }

  public void setArxiuReqParamOrigenFins(java.lang.Integer arxiuReqParamOrigenFins) {
    this.arxiuReqParamOrigenFins = arxiuReqParamOrigenFins;
  }


  private java.lang.String arxiuReqParamInteressats;

  public java.lang.String getArxiuReqParamInteressats() {
    return this.arxiuReqParamInteressats;
  }

  public void setArxiuReqParamInteressats(java.lang.String arxiuReqParamInteressats) {
    this.arxiuReqParamInteressats = arxiuReqParamInteressats;
  }


  private java.lang.String arxiuReqParamCiutadaNif;

  public java.lang.String getArxiuReqParamCiutadaNif() {
    return this.arxiuReqParamCiutadaNif;
  }

  public void setArxiuReqParamCiutadaNif(java.lang.String arxiuReqParamCiutadaNif) {
    this.arxiuReqParamCiutadaNif = arxiuReqParamCiutadaNif;
  }


  private java.lang.String arxiuReqParamCiutadaNom;

  public java.lang.String getArxiuReqParamCiutadaNom() {
    return this.arxiuReqParamCiutadaNom;
  }

  public void setArxiuReqParamCiutadaNom(java.lang.String arxiuReqParamCiutadaNom) {
    this.arxiuReqParamCiutadaNom = arxiuReqParamCiutadaNom;
  }


  private java.lang.String arxiuOptParamProcedimentCodi;

  public java.lang.String getArxiuOptParamProcedimentCodi() {
    return this.arxiuOptParamProcedimentCodi;
  }

  public void setArxiuOptParamProcedimentCodi(java.lang.String arxiuOptParamProcedimentCodi) {
    this.arxiuOptParamProcedimentCodi = arxiuOptParamProcedimentCodi;
  }


  private java.lang.String arxiuOptParamProcedimentNom;

  public java.lang.String getArxiuOptParamProcedimentNom() {
    return this.arxiuOptParamProcedimentNom;
  }

  public void setArxiuOptParamProcedimentNom(java.lang.String arxiuOptParamProcedimentNom) {
    this.arxiuOptParamProcedimentNom = arxiuOptParamProcedimentNom;
  }


  private java.lang.String arxiuOptParamOrgans;

  public java.lang.String getArxiuOptParamOrgans() {
    return this.arxiuOptParamOrgans;
  }

  public void setArxiuOptParamOrgans(java.lang.String arxiuOptParamOrgans) {
    this.arxiuOptParamOrgans = arxiuOptParamOrgans;
  }


  private java.lang.String arxiuOptParamSerieDocumental;

  public java.lang.String getArxiuOptParamSerieDocumental() {
    return this.arxiuOptParamSerieDocumental;
  }

  public void setArxiuOptParamSerieDocumental(java.lang.String arxiuOptParamSerieDocumental) {
    this.arxiuOptParamSerieDocumental = arxiuOptParamSerieDocumental;
  }


  private java.lang.String arxiuOptParamCustodyOrExpedientId;

  public java.lang.String getArxiuOptParamCustodyOrExpedientId() {
    return this.arxiuOptParamCustodyOrExpedientId;
  }

  public void setArxiuOptParamCustodyOrExpedientId(java.lang.String arxiuOptParamCustodyOrExpedientId) {
    this.arxiuOptParamCustodyOrExpedientId = arxiuOptParamCustodyOrExpedientId;
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


  public TransaccioFilterForm() {
  }
  
  public TransaccioFilterForm(TransaccioFilterForm __toClone) {
    super(__toClone);
    this.transaccioIDDesde = __toClone.transaccioIDDesde;
    this.transaccioIDFins = __toClone.transaccioIDFins;
    this.nom = __toClone.nom;
    this.transactionWebId = __toClone.transactionWebId;
    this.dataIniciDesde = __toClone.dataIniciDesde;
    this.dataIniciFins = __toClone.dataIniciFins;
    this.dataFiDesde = __toClone.dataFiDesde;
    this.dataFiFins = __toClone.dataFiFins;
    this.usuariAplicacioIdDesde = __toClone.usuariAplicacioIdDesde;
    this.usuariAplicacioIdFins = __toClone.usuariAplicacioIdFins;
    this.usuariPersonaIdDesde = __toClone.usuariPersonaIdDesde;
    this.usuariPersonaIdFins = __toClone.usuariPersonaIdFins;
    this.ip = __toClone.ip;
    this.returnUrl = __toClone.returnUrl;
    this.estatCodiDesde = __toClone.estatCodiDesde;
    this.estatCodiFins = __toClone.estatCodiFins;
    this.estatMissatge = __toClone.estatMissatge;
    this.estatExcepcio = __toClone.estatExcepcio;
    this.hashEscaneig = __toClone.hashEscaneig;
    this.hashFirma = __toClone.hashFirma;
    this.infoScanPixelTypeDesde = __toClone.infoScanPixelTypeDesde;
    this.infoScanPixelTypeFins = __toClone.infoScanPixelTypeFins;
    this.infoScanResolucioPppDesde = __toClone.infoScanResolucioPppDesde;
    this.infoScanResolucioPppFins = __toClone.infoScanResolucioPppFins;
    this.viewDesde = __toClone.viewDesde;
    this.viewFins = __toClone.viewFins;
    this.languageUI = __toClone.languageUI;
    this.funcionariUsername = __toClone.funcionariUsername;
    this.signParamFuncionariNom = __toClone.signParamFuncionariNom;
    this.signParamFuncionariNif = __toClone.signParamFuncionariNif;
    this.signParamLanguageDoc = __toClone.signParamLanguageDoc;
    this.arxiuReqParamDocEstatElabora = __toClone.arxiuReqParamDocEstatElabora;
    this.arxiuReqParamDocumentTipus = __toClone.arxiuReqParamDocumentTipus;
    this.arxiuReqParamOrigenDesde = __toClone.arxiuReqParamOrigenDesde;
    this.arxiuReqParamOrigenFins = __toClone.arxiuReqParamOrigenFins;
    this.arxiuReqParamInteressats = __toClone.arxiuReqParamInteressats;
    this.arxiuReqParamCiutadaNif = __toClone.arxiuReqParamCiutadaNif;
    this.arxiuReqParamCiutadaNom = __toClone.arxiuReqParamCiutadaNom;
    this.arxiuOptParamProcedimentCodi = __toClone.arxiuOptParamProcedimentCodi;
    this.arxiuOptParamProcedimentNom = __toClone.arxiuOptParamProcedimentNom;
    this.arxiuOptParamOrgans = __toClone.arxiuOptParamOrgans;
    this.arxiuOptParamSerieDocumental = __toClone.arxiuOptParamSerieDocumental;
    this.arxiuOptParamCustodyOrExpedientId = __toClone.arxiuOptParamCustodyOrExpedientId;
    this.perfilIDDesde = __toClone.perfilIDDesde;
    this.perfilIDFins = __toClone.perfilIDFins;
    this.infoSignaturaIDDesde = __toClone.infoSignaturaIDDesde;
    this.infoSignaturaIDFins = __toClone.infoSignaturaIDFins;
    this.infoCustodyIDDesde = __toClone.infoCustodyIDDesde;
    this.infoCustodyIDFins = __toClone.infoCustodyIDFins;
    this.mapOfValuesForEstatCodi = __toClone.mapOfValuesForEstatCodi;
    this.mapOfValuesForView = __toClone.mapOfValuesForView;
    this.mapOfValuesForSignParamLanguageDoc = __toClone.mapOfValuesForSignParamLanguageDoc;
    this.mapOfValuesForArxiuReqParamDocEstatElabora = __toClone.mapOfValuesForArxiuReqParamDocEstatElabora;
    this.mapOfValuesForArxiuReqParamDocumentTipus = __toClone.mapOfValuesForArxiuReqParamDocumentTipus;
    this.mapOfValuesForArxiuReqParamOrigen = __toClone.mapOfValuesForArxiuReqParamOrigen;
    this.mapOfPerfilForPerfilID = __toClone.mapOfPerfilForPerfilID;
    this.mapOfInfoSignaturaForInfoSignaturaID = __toClone.mapOfInfoSignaturaForInfoSignaturaID;
    this.mapOfInfoCustodyForInfoCustodyID = __toClone.mapOfInfoCustodyForInfoCustodyID;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { TRANSACCIOID ,NOM ,TRANSACTIONWEBID ,RETURNURL ,ESTATMISSATGE }));
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



  private Map<String, String> mapOfValuesForView;

  public Map<String, String> getMapOfValuesForView() {
    return this.mapOfValuesForView;
  }

  public void setMapOfValuesForView(Map<String, String> mapOfValuesForView) {
    this.mapOfValuesForView = mapOfValuesForView;
  }



  private Map<String, String> mapOfValuesForSignParamLanguageDoc;

  public Map<String, String> getMapOfValuesForSignParamLanguageDoc() {
    return this.mapOfValuesForSignParamLanguageDoc;
  }

  public void setMapOfValuesForSignParamLanguageDoc(Map<String, String> mapOfValuesForSignParamLanguageDoc) {
    this.mapOfValuesForSignParamLanguageDoc = mapOfValuesForSignParamLanguageDoc;
  }



  private Map<String, String> mapOfValuesForArxiuReqParamDocEstatElabora;

  public Map<String, String> getMapOfValuesForArxiuReqParamDocEstatElabora() {
    return this.mapOfValuesForArxiuReqParamDocEstatElabora;
  }

  public void setMapOfValuesForArxiuReqParamDocEstatElabora(Map<String, String> mapOfValuesForArxiuReqParamDocEstatElabora) {
    this.mapOfValuesForArxiuReqParamDocEstatElabora = mapOfValuesForArxiuReqParamDocEstatElabora;
  }



  private Map<String, String> mapOfValuesForArxiuReqParamDocumentTipus;

  public Map<String, String> getMapOfValuesForArxiuReqParamDocumentTipus() {
    return this.mapOfValuesForArxiuReqParamDocumentTipus;
  }

  public void setMapOfValuesForArxiuReqParamDocumentTipus(Map<String, String> mapOfValuesForArxiuReqParamDocumentTipus) {
    this.mapOfValuesForArxiuReqParamDocumentTipus = mapOfValuesForArxiuReqParamDocumentTipus;
  }



  private Map<String, String> mapOfValuesForArxiuReqParamOrigen;

  public Map<String, String> getMapOfValuesForArxiuReqParamOrigen() {
    return this.mapOfValuesForArxiuReqParamOrigen;
  }

  public void setMapOfValuesForArxiuReqParamOrigen(Map<String, String> mapOfValuesForArxiuReqParamOrigen) {
    this.mapOfValuesForArxiuReqParamOrigen = mapOfValuesForArxiuReqParamOrigen;
  }



  private Map<String, String> mapOfPerfilForPerfilID;

  public Map<String, String> getMapOfPerfilForPerfilID() {
    return this.mapOfPerfilForPerfilID;
  }

  public void setMapOfPerfilForPerfilID(Map<String, String> mapOfPerfilForPerfilID) {
    this.mapOfPerfilForPerfilID = mapOfPerfilForPerfilID;
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




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
