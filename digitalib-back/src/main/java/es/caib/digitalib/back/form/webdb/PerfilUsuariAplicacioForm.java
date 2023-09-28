package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.persistence.PerfilUsuariAplicacioJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class PerfilUsuariAplicacioForm extends DigitalIBBaseForm {
  
  private PerfilUsuariAplicacioJPA perfilUsuariAplicacio;
  
  public PerfilUsuariAplicacioForm() {
  }
  
  public PerfilUsuariAplicacioForm(PerfilUsuariAplicacioForm __toClone) {
    super(__toClone);
      this.perfilUsuariAplicacio = __toClone.perfilUsuariAplicacio;
    this.listOfPerfilForPerfilID = __toClone.listOfPerfilForPerfilID;
    this.listOfUsuariAplicacioForUsuariAplicacioID = __toClone.listOfUsuariAplicacioForUsuariAplicacioID;
  }
  
  public PerfilUsuariAplicacioForm(PerfilUsuariAplicacioJPA perfilUsuariAplicacio, boolean nou) {
    super(nou);
    this.perfilUsuariAplicacio = perfilUsuariAplicacio;
  }
  
  public PerfilUsuariAplicacioJPA getPerfilUsuariAplicacio() {
    return perfilUsuariAplicacio;
  }
  public void setPerfilUsuariAplicacio(PerfilUsuariAplicacioJPA perfilUsuariAplicacio) {
    this.perfilUsuariAplicacio = perfilUsuariAplicacio;
  }
  
  
  private List<StringKeyValue> listOfPerfilForPerfilID;

  public List<StringKeyValue> getListOfPerfilForPerfilID() {
    return this.listOfPerfilForPerfilID;
  }

  public void setListOfPerfilForPerfilID(List<StringKeyValue> listOfPerfilForPerfilID) {
    this.listOfPerfilForPerfilID = listOfPerfilForPerfilID;
  }



  private List<StringKeyValue> listOfUsuariAplicacioForUsuariAplicacioID;

  public List<StringKeyValue> getListOfUsuariAplicacioForUsuariAplicacioID() {
    return this.listOfUsuariAplicacioForUsuariAplicacioID;
  }

  public void setListOfUsuariAplicacioForUsuariAplicacioID(List<StringKeyValue> listOfUsuariAplicacioForUsuariAplicacioID) {
    this.listOfUsuariAplicacioForUsuariAplicacioID = listOfUsuariAplicacioForUsuariAplicacioID;
  }



  
} // Final de Classe 
