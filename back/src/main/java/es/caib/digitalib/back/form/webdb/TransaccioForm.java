package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.TransaccioJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class TransaccioForm extends DigitalIBBaseForm {
  
  private TransaccioJPA transaccio;
  
  public TransaccioForm() {
  }
  
  public TransaccioForm(TransaccioForm __toClone) {
    super(__toClone);
      this.transaccio = __toClone.transaccio;
    this.listOfInfoSignaturaForInfosignaturaid = __toClone.listOfInfoSignaturaForInfosignaturaid;
    this.listOfInfoCustodyForInfocustodyid = __toClone.listOfInfoCustodyForInfocustodyid;
    this.listOfPerfilForPerfilid = __toClone.listOfPerfilForPerfilid;
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



  
} // Final de Classe 
