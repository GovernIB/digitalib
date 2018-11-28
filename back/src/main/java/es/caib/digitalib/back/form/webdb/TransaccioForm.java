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
    this.listOfInfoSignaturaForInfoSignaturaID = __toClone.listOfInfoSignaturaForInfoSignaturaID;
    this.listOfInfoCustodyForInfoCustodyID = __toClone.listOfInfoCustodyForInfoCustodyID;
    this.listOfValuesForView = __toClone.listOfValuesForView;
    this.listOfPerfilForPerfilID = __toClone.listOfPerfilForPerfilID;
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



  private List<StringKeyValue> listOfValuesForView;

  public List<StringKeyValue> getListOfValuesForView() {
    return this.listOfValuesForView;
  }

  public void setListOfValuesForView(List<StringKeyValue> listOfValuesForView) {
    this.listOfValuesForView = listOfValuesForView;
  }



  private List<StringKeyValue> listOfPerfilForPerfilID;

  public List<StringKeyValue> getListOfPerfilForPerfilID() {
    return this.listOfPerfilForPerfilID;
  }

  public void setListOfPerfilForPerfilID(List<StringKeyValue> listOfPerfilForPerfilID) {
    this.listOfPerfilForPerfilID = listOfPerfilForPerfilID;
  }



  
} // Final de Classe 
