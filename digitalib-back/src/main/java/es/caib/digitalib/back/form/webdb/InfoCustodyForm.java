package es.caib.digitalib.back.form.webdb;

import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.persistence.InfoCustodyJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class InfoCustodyForm extends DigitalIBBaseForm {
  
  private InfoCustodyJPA infoCustody;
  
  public InfoCustodyForm() {
  }
  
  public InfoCustodyForm(InfoCustodyForm __toClone) {
    super(__toClone);
      this.infoCustody = __toClone.infoCustody;
  }
  
  public InfoCustodyForm(InfoCustodyJPA infoCustody, boolean nou) {
    super(nou);
    this.infoCustody = infoCustody;
  }
  
  public InfoCustodyJPA getInfoCustody() {
    return infoCustody;
  }
  public void setInfoCustody(InfoCustodyJPA infoCustody) {
    this.infoCustody = infoCustody;
  }
  
  
  
} // Final de Classe 
