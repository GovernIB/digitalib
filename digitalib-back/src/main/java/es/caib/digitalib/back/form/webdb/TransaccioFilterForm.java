
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


  private java.lang.Long transaccioMultipleIDDesde;

  public java.lang.Long getTransaccioMultipleIDDesde() {
    return this.transaccioMultipleIDDesde;
  }

  public void setTransaccioMultipleIDDesde(java.lang.Long transaccioMultipleIDDesde) {
    this.transaccioMultipleIDDesde = transaccioMultipleIDDesde;
  }


  private java.lang.Long transaccioMultipleIDFins;

  public java.lang.Long getTransaccioMultipleIDFins() {
    return this.transaccioMultipleIDFins;
  }

  public void setTransaccioMultipleIDFins(java.lang.Long transaccioMultipleIDFins) {
    this.transaccioMultipleIDFins = transaccioMultipleIDFins;
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


  private java.util.List<java.lang.Long> usuariAplicacioIdSelect;

  public java.util.List<java.lang.Long> getUsuariAplicacioIdSelect() {
    return this.usuariAplicacioIdSelect;
  }

  public void setUsuariAplicacioIdSelect(java.util.List<java.lang.Long> usuariAplicacioIdSelect) {
    this.usuariAplicacioIdSelect = usuariAplicacioIdSelect;
  }


  private java.util.List<java.lang.Long> usuariPersonaIdSelect;

  public java.util.List<java.lang.Long> getUsuariPersonaIdSelect() {
    return this.usuariPersonaIdSelect;
  }

  public void setUsuariPersonaIdSelect(java.util.List<java.lang.Long> usuariPersonaIdSelect) {
    this.usuariPersonaIdSelect = usuariPersonaIdSelect;
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


  private java.util.List<java.lang.Integer> estatCodiSelect;

  public java.util.List<java.lang.Integer> getEstatCodiSelect() {
    return this.estatCodiSelect;
  }

  public void setEstatCodiSelect(java.util.List<java.lang.Integer> estatCodiSelect) {
    this.estatCodiSelect = estatCodiSelect;
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


  private java.lang.String infoScanPaperSize;

  public java.lang.String getInfoScanPaperSize() {
    return this.infoScanPaperSize;
  }

  public void setInfoScanPaperSize(java.lang.String infoScanPaperSize) {
    this.infoScanPaperSize = infoScanPaperSize;
  }


  private java.util.List<java.lang.Integer> infoScanPixelTypeSelect;

  public java.util.List<java.lang.Integer> getInfoScanPixelTypeSelect() {
    return this.infoScanPixelTypeSelect;
  }

  public void setInfoScanPixelTypeSelect(java.util.List<java.lang.Integer> infoScanPixelTypeSelect) {
    this.infoScanPixelTypeSelect = infoScanPixelTypeSelect;
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


  private java.sql.Timestamp infoScanDataCapturaDesde;

  public java.sql.Timestamp getInfoScanDataCapturaDesde() {
    return this.infoScanDataCapturaDesde;
  }

  public void setInfoScanDataCapturaDesde(java.sql.Timestamp infoScanDataCapturaDesde) {
    this.infoScanDataCapturaDesde = infoScanDataCapturaDesde;
  }


  private java.sql.Timestamp infoScanDataCapturaFins;

  public java.sql.Timestamp getInfoScanDataCapturaFins() {
    return this.infoScanDataCapturaFins;
  }

  public void setInfoScanDataCapturaFins(java.sql.Timestamp infoScanDataCapturaFins) {
    this.infoScanDataCapturaFins = infoScanDataCapturaFins;
  }


  private java.lang.String infoScanLanguageDoc;

  public java.lang.String getInfoScanLanguageDoc() {
    return this.infoScanLanguageDoc;
  }

  public void setInfoScanLanguageDoc(java.lang.String infoScanLanguageDoc) {
    this.infoScanLanguageDoc = infoScanLanguageDoc;
  }


  private java.lang.String infoScanDocumentTipus;

  public java.lang.String getInfoScanDocumentTipus() {
    return this.infoScanDocumentTipus;
  }

  public void setInfoScanDocumentTipus(java.lang.String infoScanDocumentTipus) {
    this.infoScanDocumentTipus = infoScanDocumentTipus;
  }


  private java.util.List<java.lang.Integer> viewSelect;

  public java.util.List<java.lang.Integer> getViewSelect() {
    return this.viewSelect;
  }

  public void setViewSelect(java.util.List<java.lang.Integer> viewSelect) {
    this.viewSelect = viewSelect;
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


  private java.lang.String signParamFuncionariDir3;

  public java.lang.String getSignParamFuncionariDir3() {
    return this.signParamFuncionariDir3;
  }

  public void setSignParamFuncionariDir3(java.lang.String signParamFuncionariDir3) {
    this.signParamFuncionariDir3 = signParamFuncionariDir3;
  }


  private java.lang.String arxiuReqParamDocEstatElabora;

  public java.lang.String getArxiuReqParamDocEstatElabora() {
    return this.arxiuReqParamDocEstatElabora;
  }

  public void setArxiuReqParamDocEstatElabora(java.lang.String arxiuReqParamDocEstatElabora) {
    this.arxiuReqParamDocEstatElabora = arxiuReqParamDocEstatElabora;
  }


  private java.util.List<java.lang.Integer> arxiuReqParamOrigenSelect;

  public java.util.List<java.lang.Integer> getArxiuReqParamOrigenSelect() {
    return this.arxiuReqParamOrigenSelect;
  }

  public void setArxiuReqParamOrigenSelect(java.util.List<java.lang.Integer> arxiuReqParamOrigenSelect) {
    this.arxiuReqParamOrigenSelect = arxiuReqParamOrigenSelect;
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


  private java.lang.String arxiuReqParamOrgans;

  public java.lang.String getArxiuReqParamOrgans() {
    return this.arxiuReqParamOrgans;
  }

  public void setArxiuReqParamOrgans(java.lang.String arxiuReqParamOrgans) {
    this.arxiuReqParamOrgans = arxiuReqParamOrgans;
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
    this.transaccioMultipleIDDesde = __toClone.transaccioMultipleIDDesde;
    this.transaccioMultipleIDFins = __toClone.transaccioMultipleIDFins;
    this.nom = __toClone.nom;
    this.transactionWebId = __toClone.transactionWebId;
    this.dataIniciDesde = __toClone.dataIniciDesde;
    this.dataIniciFins = __toClone.dataIniciFins;
    this.dataFiDesde = __toClone.dataFiDesde;
    this.dataFiFins = __toClone.dataFiFins;
    this.usuariAplicacioIdSelect = __toClone.usuariAplicacioIdSelect;
    this.usuariPersonaIdSelect = __toClone.usuariPersonaIdSelect;
    this.ip = __toClone.ip;
    this.returnUrl = __toClone.returnUrl;
    this.estatCodiSelect = __toClone.estatCodiSelect;
    this.estatMissatge = __toClone.estatMissatge;
    this.estatExcepcio = __toClone.estatExcepcio;
    this.hashEscaneig = __toClone.hashEscaneig;
    this.hashFirma = __toClone.hashFirma;
    this.infoScanPaperSize = __toClone.infoScanPaperSize;
    this.infoScanPixelTypeSelect = __toClone.infoScanPixelTypeSelect;
    this.infoScanResolucioPppDesde = __toClone.infoScanResolucioPppDesde;
    this.infoScanResolucioPppFins = __toClone.infoScanResolucioPppFins;
    this.infoScanDataCapturaDesde = __toClone.infoScanDataCapturaDesde;
    this.infoScanDataCapturaFins = __toClone.infoScanDataCapturaFins;
    this.infoScanLanguageDoc = __toClone.infoScanLanguageDoc;
    this.infoScanDocumentTipus = __toClone.infoScanDocumentTipus;
    this.viewSelect = __toClone.viewSelect;
    this.languageUI = __toClone.languageUI;
    this.funcionariUsername = __toClone.funcionariUsername;
    this.signParamFuncionariNom = __toClone.signParamFuncionariNom;
    this.signParamFuncionariNif = __toClone.signParamFuncionariNif;
    this.signParamFuncionariDir3 = __toClone.signParamFuncionariDir3;
    this.arxiuReqParamDocEstatElabora = __toClone.arxiuReqParamDocEstatElabora;
    this.arxiuReqParamOrigenSelect = __toClone.arxiuReqParamOrigenSelect;
    this.arxiuReqParamInteressats = __toClone.arxiuReqParamInteressats;
    this.arxiuReqParamCiutadaNif = __toClone.arxiuReqParamCiutadaNif;
    this.arxiuReqParamCiutadaNom = __toClone.arxiuReqParamCiutadaNom;
    this.arxiuReqParamOrgans = __toClone.arxiuReqParamOrgans;
    this.arxiuOptParamProcedimentCodi = __toClone.arxiuOptParamProcedimentCodi;
    this.arxiuOptParamProcedimentNom = __toClone.arxiuOptParamProcedimentNom;
    this.arxiuOptParamSerieDocumental = __toClone.arxiuOptParamSerieDocumental;
    this.arxiuOptParamCustodyOrExpedientId = __toClone.arxiuOptParamCustodyOrExpedientId;
    this.perfilIDDesde = __toClone.perfilIDDesde;
    this.perfilIDFins = __toClone.perfilIDFins;
    this.infoSignaturaIDDesde = __toClone.infoSignaturaIDDesde;
    this.infoSignaturaIDFins = __toClone.infoSignaturaIDFins;
    this.infoCustodyIDDesde = __toClone.infoCustodyIDDesde;
    this.infoCustodyIDFins = __toClone.infoCustodyIDFins;
    this.mapOfTransaccioMultipleForTransaccioMultipleID = __toClone.mapOfTransaccioMultipleForTransaccioMultipleID;
    this.mapOfValuesForUsuariAplicacioId = __toClone.mapOfValuesForUsuariAplicacioId;
    this.mapOfValuesForUsuariPersonaId = __toClone.mapOfValuesForUsuariPersonaId;
    this.mapOfValuesForEstatCodi = __toClone.mapOfValuesForEstatCodi;
    this.mapOfValuesForInfoScanPixelType = __toClone.mapOfValuesForInfoScanPixelType;
    this.mapOfValuesForInfoScanLanguageDoc = __toClone.mapOfValuesForInfoScanLanguageDoc;
    this.mapOfValuesForInfoScanDocumentTipus = __toClone.mapOfValuesForInfoScanDocumentTipus;
    this.mapOfValuesForView = __toClone.mapOfValuesForView;
    this.mapOfValuesForArxiuReqParamDocEstatElabora = __toClone.mapOfValuesForArxiuReqParamDocEstatElabora;
    this.mapOfValuesForArxiuReqParamOrigen = __toClone.mapOfValuesForArxiuReqParamOrigen;
    this.mapOfPerfilForPerfilID = __toClone.mapOfPerfilForPerfilID;
    this.mapOfInfoSignaturaForInfoSignaturaID = __toClone.mapOfInfoSignaturaForInfoSignaturaID;
    this.mapOfInfoCustodyForInfoCustodyID = __toClone.mapOfInfoCustodyForInfoCustodyID;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { TRANSACCIOID ,TRANSACCIOMULTIPLEID ,NOM ,TRANSACTIONWEBID ,RETURNURL ,ESTATMISSATGE }));
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
  private Map<String, String> mapOfTransaccioMultipleForTransaccioMultipleID;

  public Map<String, String> getMapOfTransaccioMultipleForTransaccioMultipleID() {
    return this.mapOfTransaccioMultipleForTransaccioMultipleID;
  }

  public void setMapOfTransaccioMultipleForTransaccioMultipleID(Map<String, String> mapOfTransaccioMultipleForTransaccioMultipleID) {
    this.mapOfTransaccioMultipleForTransaccioMultipleID = mapOfTransaccioMultipleForTransaccioMultipleID;
  }



  private Map<String, String> mapOfValuesForUsuariAplicacioId;

  public Map<String, String> getMapOfValuesForUsuariAplicacioId() {
    return this.mapOfValuesForUsuariAplicacioId;
  }

  public void setMapOfValuesForUsuariAplicacioId(Map<String, String> mapOfValuesForUsuariAplicacioId) {
    this.mapOfValuesForUsuariAplicacioId = mapOfValuesForUsuariAplicacioId;
  }



  private Map<String, String> mapOfValuesForUsuariPersonaId;

  public Map<String, String> getMapOfValuesForUsuariPersonaId() {
    return this.mapOfValuesForUsuariPersonaId;
  }

  public void setMapOfValuesForUsuariPersonaId(Map<String, String> mapOfValuesForUsuariPersonaId) {
    this.mapOfValuesForUsuariPersonaId = mapOfValuesForUsuariPersonaId;
  }



  private Map<String, String> mapOfValuesForEstatCodi;

  public Map<String, String> getMapOfValuesForEstatCodi() {
    return this.mapOfValuesForEstatCodi;
  }

  public void setMapOfValuesForEstatCodi(Map<String, String> mapOfValuesForEstatCodi) {
    this.mapOfValuesForEstatCodi = mapOfValuesForEstatCodi;
  }



  private Map<String, String> mapOfValuesForInfoScanPixelType;

  public Map<String, String> getMapOfValuesForInfoScanPixelType() {
    return this.mapOfValuesForInfoScanPixelType;
  }

  public void setMapOfValuesForInfoScanPixelType(Map<String, String> mapOfValuesForInfoScanPixelType) {
    this.mapOfValuesForInfoScanPixelType = mapOfValuesForInfoScanPixelType;
  }



  private Map<String, String> mapOfValuesForInfoScanLanguageDoc;

  public Map<String, String> getMapOfValuesForInfoScanLanguageDoc() {
    return this.mapOfValuesForInfoScanLanguageDoc;
  }

  public void setMapOfValuesForInfoScanLanguageDoc(Map<String, String> mapOfValuesForInfoScanLanguageDoc) {
    this.mapOfValuesForInfoScanLanguageDoc = mapOfValuesForInfoScanLanguageDoc;
  }



  private Map<String, String> mapOfValuesForInfoScanDocumentTipus;

  public Map<String, String> getMapOfValuesForInfoScanDocumentTipus() {
    return this.mapOfValuesForInfoScanDocumentTipus;
  }

  public void setMapOfValuesForInfoScanDocumentTipus(Map<String, String> mapOfValuesForInfoScanDocumentTipus) {
    this.mapOfValuesForInfoScanDocumentTipus = mapOfValuesForInfoScanDocumentTipus;
  }



  private Map<String, String> mapOfValuesForView;

  public Map<String, String> getMapOfValuesForView() {
    return this.mapOfValuesForView;
  }

  public void setMapOfValuesForView(Map<String, String> mapOfValuesForView) {
    this.mapOfValuesForView = mapOfValuesForView;
  }



  private Map<String, String> mapOfValuesForArxiuReqParamDocEstatElabora;

  public Map<String, String> getMapOfValuesForArxiuReqParamDocEstatElabora() {
    return this.mapOfValuesForArxiuReqParamDocEstatElabora;
  }

  public void setMapOfValuesForArxiuReqParamDocEstatElabora(Map<String, String> mapOfValuesForArxiuReqParamDocEstatElabora) {
    this.mapOfValuesForArxiuReqParamDocEstatElabora = mapOfValuesForArxiuReqParamDocEstatElabora;
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
