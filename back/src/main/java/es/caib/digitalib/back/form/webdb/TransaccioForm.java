package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.TransaccioJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class TransaccioForm extends DigitalIBBaseForm {
  
  private TransaccioJPA transaccio;
  
  
  private CommonsMultipartFile fitxerEscanejatID;
  private boolean fitxerEscanejatIDDelete;
  
  
  private CommonsMultipartFile fitxerSignaturaID;
  private boolean fitxerSignaturaIDDelete;
  
  public TransaccioForm() {
  }
  
  public TransaccioForm(TransaccioForm __toClone) {
    super(__toClone);
      this.transaccio = __toClone.transaccio;
    this.listOfValuesForEstatCodi = __toClone.listOfValuesForEstatCodi;
    this.listOfValuesForInfoScanPixelType = __toClone.listOfValuesForInfoScanPixelType;
    this.listOfValuesForView = __toClone.listOfValuesForView;
    this.listOfValuesForSignParamLanguageDoc = __toClone.listOfValuesForSignParamLanguageDoc;
    this.listOfValuesForArxiuReqParamDocEstatElabora = __toClone.listOfValuesForArxiuReqParamDocEstatElabora;
    this.listOfValuesForArxiuReqParamDocumentTipus = __toClone.listOfValuesForArxiuReqParamDocumentTipus;
    this.listOfValuesForArxiuReqParamOrigen = __toClone.listOfValuesForArxiuReqParamOrigen;
    this.listOfPerfilForPerfilID = __toClone.listOfPerfilForPerfilID;
    this.listOfInfoSignaturaForInfoSignaturaID = __toClone.listOfInfoSignaturaForInfoSignaturaID;
    this.listOfInfoCustodyForInfoCustodyID = __toClone.listOfInfoCustodyForInfoCustodyID;
    this.listOfTransaccioMultipleForTransaccioMultipleID = __toClone.listOfTransaccioMultipleForTransaccioMultipleID;
  }
  
  public TransaccioForm(TransaccioJPA transaccio, boolean nou) {
    super(nou);
    this.transaccio = transaccio;
  }
  
  public TransaccioJPA getTransaccio() {
    return transaccio;
  }
  public void setTransaccio(TransaccioJPA transaccio) {
    this.transaccio = transaccio;
  }
  
  
  public CommonsMultipartFile getFitxerEscanejatID() {
    return fitxerEscanejatID;
  }
  
   public void setFitxerEscanejatID(CommonsMultipartFile fitxerEscanejatID) {
    this.fitxerEscanejatID = fitxerEscanejatID;
  }
  public boolean isFitxerEscanejatIDDelete() {
    return fitxerEscanejatIDDelete;
  }
  
  public void setFitxerEscanejatIDDelete(boolean fitxerEscanejatIDDelete) {
    this.fitxerEscanejatIDDelete = fitxerEscanejatIDDelete;
   }
  public CommonsMultipartFile getFitxerSignaturaID() {
    return fitxerSignaturaID;
  }
  
   public void setFitxerSignaturaID(CommonsMultipartFile fitxerSignaturaID) {
    this.fitxerSignaturaID = fitxerSignaturaID;
  }
  public boolean isFitxerSignaturaIDDelete() {
    return fitxerSignaturaIDDelete;
  }
  
  public void setFitxerSignaturaIDDelete(boolean fitxerSignaturaIDDelete) {
    this.fitxerSignaturaIDDelete = fitxerSignaturaIDDelete;
   }
  private List<StringKeyValue> listOfValuesForEstatCodi;

  public List<StringKeyValue> getListOfValuesForEstatCodi() {
    return this.listOfValuesForEstatCodi;
  }

  public void setListOfValuesForEstatCodi(List<StringKeyValue> listOfValuesForEstatCodi) {
    this.listOfValuesForEstatCodi = listOfValuesForEstatCodi;
  }



  private List<StringKeyValue> listOfValuesForInfoScanPixelType;

  public List<StringKeyValue> getListOfValuesForInfoScanPixelType() {
    return this.listOfValuesForInfoScanPixelType;
  }

  public void setListOfValuesForInfoScanPixelType(List<StringKeyValue> listOfValuesForInfoScanPixelType) {
    this.listOfValuesForInfoScanPixelType = listOfValuesForInfoScanPixelType;
  }



  private List<StringKeyValue> listOfValuesForView;

  public List<StringKeyValue> getListOfValuesForView() {
    return this.listOfValuesForView;
  }

  public void setListOfValuesForView(List<StringKeyValue> listOfValuesForView) {
    this.listOfValuesForView = listOfValuesForView;
  }



  private List<StringKeyValue> listOfValuesForSignParamLanguageDoc;

  public List<StringKeyValue> getListOfValuesForSignParamLanguageDoc() {
    return this.listOfValuesForSignParamLanguageDoc;
  }

  public void setListOfValuesForSignParamLanguageDoc(List<StringKeyValue> listOfValuesForSignParamLanguageDoc) {
    this.listOfValuesForSignParamLanguageDoc = listOfValuesForSignParamLanguageDoc;
  }



  private List<StringKeyValue> listOfValuesForArxiuReqParamDocEstatElabora;

  public List<StringKeyValue> getListOfValuesForArxiuReqParamDocEstatElabora() {
    return this.listOfValuesForArxiuReqParamDocEstatElabora;
  }

  public void setListOfValuesForArxiuReqParamDocEstatElabora(List<StringKeyValue> listOfValuesForArxiuReqParamDocEstatElabora) {
    this.listOfValuesForArxiuReqParamDocEstatElabora = listOfValuesForArxiuReqParamDocEstatElabora;
  }



  private List<StringKeyValue> listOfValuesForArxiuReqParamDocumentTipus;

  public List<StringKeyValue> getListOfValuesForArxiuReqParamDocumentTipus() {
    return this.listOfValuesForArxiuReqParamDocumentTipus;
  }

  public void setListOfValuesForArxiuReqParamDocumentTipus(List<StringKeyValue> listOfValuesForArxiuReqParamDocumentTipus) {
    this.listOfValuesForArxiuReqParamDocumentTipus = listOfValuesForArxiuReqParamDocumentTipus;
  }



  private List<StringKeyValue> listOfValuesForArxiuReqParamOrigen;

  public List<StringKeyValue> getListOfValuesForArxiuReqParamOrigen() {
    return this.listOfValuesForArxiuReqParamOrigen;
  }

  public void setListOfValuesForArxiuReqParamOrigen(List<StringKeyValue> listOfValuesForArxiuReqParamOrigen) {
    this.listOfValuesForArxiuReqParamOrigen = listOfValuesForArxiuReqParamOrigen;
  }



  private List<StringKeyValue> listOfPerfilForPerfilID;

  public List<StringKeyValue> getListOfPerfilForPerfilID() {
    return this.listOfPerfilForPerfilID;
  }

  public void setListOfPerfilForPerfilID(List<StringKeyValue> listOfPerfilForPerfilID) {
    this.listOfPerfilForPerfilID = listOfPerfilForPerfilID;
  }



  private List<StringKeyValue> listOfInfoSignaturaForInfoSignaturaID;

  public List<StringKeyValue> getListOfInfoSignaturaForInfoSignaturaID() {
    return this.listOfInfoSignaturaForInfoSignaturaID;
  }

  public void setListOfInfoSignaturaForInfoSignaturaID(List<StringKeyValue> listOfInfoSignaturaForInfoSignaturaID) {
    this.listOfInfoSignaturaForInfoSignaturaID = listOfInfoSignaturaForInfoSignaturaID;
  }



  private List<StringKeyValue> listOfInfoCustodyForInfoCustodyID;

  public List<StringKeyValue> getListOfInfoCustodyForInfoCustodyID() {
    return this.listOfInfoCustodyForInfoCustodyID;
  }

  public void setListOfInfoCustodyForInfoCustodyID(List<StringKeyValue> listOfInfoCustodyForInfoCustodyID) {
    this.listOfInfoCustodyForInfoCustodyID = listOfInfoCustodyForInfoCustodyID;
  }



  private List<StringKeyValue> listOfTransaccioMultipleForTransaccioMultipleID;

  public List<StringKeyValue> getListOfTransaccioMultipleForTransaccioMultipleID() {
    return this.listOfTransaccioMultipleForTransaccioMultipleID;
  }

  public void setListOfTransaccioMultipleForTransaccioMultipleID(List<StringKeyValue> listOfTransaccioMultipleForTransaccioMultipleID) {
    this.listOfTransaccioMultipleForTransaccioMultipleID = listOfTransaccioMultipleForTransaccioMultipleID;
  }



  
} // Final de Classe 
