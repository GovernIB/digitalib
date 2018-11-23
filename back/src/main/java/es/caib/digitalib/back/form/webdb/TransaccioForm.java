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
    this.listOfInfoSignaturaForInfosignaturaid = __toClone.listOfInfoSignaturaForInfosignaturaid;
    this.listOfInfoCustodyForInfocustodyid = __toClone.listOfInfoCustodyForInfocustodyid;
    this.listOfPerfilForPerfilid = __toClone.listOfPerfilForPerfilid;
    this.listOfValuesForView = __toClone.listOfValuesForView;
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
  private List<StringKeyValue> listOfInfoSignaturaForInfosignaturaid;

  public List<StringKeyValue> getListOfInfoSignaturaForInfosignaturaid() {
    return this.listOfInfoSignaturaForInfosignaturaid;
  }

  public void setListOfInfoSignaturaForInfosignaturaid(List<StringKeyValue> listOfInfoSignaturaForInfosignaturaid) {
    this.listOfInfoSignaturaForInfosignaturaid = listOfInfoSignaturaForInfosignaturaid;
  }



  private List<StringKeyValue> listOfInfoCustodyForInfocustodyid;

  public List<StringKeyValue> getListOfInfoCustodyForInfocustodyid() {
    return this.listOfInfoCustodyForInfocustodyid;
  }

  public void setListOfInfoCustodyForInfocustodyid(List<StringKeyValue> listOfInfoCustodyForInfocustodyid) {
    this.listOfInfoCustodyForInfocustodyid = listOfInfoCustodyForInfocustodyid;
  }



  private List<StringKeyValue> listOfPerfilForPerfilid;

  public List<StringKeyValue> getListOfPerfilForPerfilid() {
    return this.listOfPerfilForPerfilid;
  }

  public void setListOfPerfilForPerfilid(List<StringKeyValue> listOfPerfilForPerfilid) {
    this.listOfPerfilForPerfilid = listOfPerfilForPerfilid;
  }



  private List<StringKeyValue> listOfValuesForView;

  public List<StringKeyValue> getListOfValuesForView() {
    return this.listOfValuesForView;
  }

  public void setListOfValuesForView(List<StringKeyValue> listOfValuesForView) {
    this.listOfValuesForView = listOfValuesForView;
  }



  
} // Final de Classe 
