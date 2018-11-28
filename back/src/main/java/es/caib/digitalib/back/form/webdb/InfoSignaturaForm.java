package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.InfoSignaturaJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class InfoSignaturaForm extends DigitalIBBaseForm {
  
  private InfoSignaturaJPA infoSignatura;
  
  public InfoSignaturaForm() {
  }
  
  public InfoSignaturaForm(InfoSignaturaForm __toClone) {
    super(__toClone);
      this.infoSignatura = __toClone.infoSignatura;
    this.listOfValuesForSignOperation = __toClone.listOfValuesForSignOperation;
    this.listOfValuesForSignMode = __toClone.listOfValuesForSignMode;
    this.listOfValuesForSignaturesTableLocation = __toClone.listOfValuesForSignaturesTableLocation;
  }
  
  public InfoSignaturaForm(InfoSignaturaJPA infoSignatura, boolean nou) {
    super(nou);
    this.infoSignatura = infoSignatura;
  }
  
  public InfoSignaturaJPA getInfoSignatura() {
    return infoSignatura;
  }
  public void setInfoSignatura(InfoSignaturaJPA infoSignatura) {
    this.infoSignatura = infoSignatura;
  }
  
  
  private List<StringKeyValue> listOfValuesForSignOperation;

  public List<StringKeyValue> getListOfValuesForSignOperation() {
    return this.listOfValuesForSignOperation;
  }

  public void setListOfValuesForSignOperation(List<StringKeyValue> listOfValuesForSignOperation) {
    this.listOfValuesForSignOperation = listOfValuesForSignOperation;
  }



  private List<StringKeyValue> listOfValuesForSignMode;

  public List<StringKeyValue> getListOfValuesForSignMode() {
    return this.listOfValuesForSignMode;
  }

  public void setListOfValuesForSignMode(List<StringKeyValue> listOfValuesForSignMode) {
    this.listOfValuesForSignMode = listOfValuesForSignMode;
  }



  private List<StringKeyValue> listOfValuesForSignaturesTableLocation;

  public List<StringKeyValue> getListOfValuesForSignaturesTableLocation() {
    return this.listOfValuesForSignaturesTableLocation;
  }

  public void setListOfValuesForSignaturesTableLocation(List<StringKeyValue> listOfValuesForSignaturesTableLocation) {
    this.listOfValuesForSignaturesTableLocation = listOfValuesForSignaturesTableLocation;
  }



  
} // Final de Classe 
