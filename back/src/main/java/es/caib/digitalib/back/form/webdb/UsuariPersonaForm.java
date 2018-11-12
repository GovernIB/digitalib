package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.UsuariPersonaJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class UsuariPersonaForm extends DigitalIBBaseForm {
  
  private UsuariPersonaJPA usuariPersona;
  
  public UsuariPersonaForm() {
  }
  
  public UsuariPersonaForm(UsuariPersonaForm __toClone) {
    super(__toClone);
      this.usuariPersona = __toClone.usuariPersona;
    this.listOfIdiomaForIdiomaID = __toClone.listOfIdiomaForIdiomaID;
    this.listOfConfiguracioGrupForConfiguraciogrupid = __toClone.listOfConfiguracioGrupForConfiguraciogrupid;
  }
  
  public UsuariPersonaForm(UsuariPersonaJPA usuariPersona, boolean nou) {
    super(nou);
    this.usuariPersona = usuariPersona;
  }
  
  public UsuariPersonaJPA getUsuariPersona() {
    return usuariPersona;
  }
  public void setUsuariPersona(UsuariPersonaJPA usuariPersona) {
    this.usuariPersona = usuariPersona;
  }
  
  
  private List<StringKeyValue> listOfIdiomaForIdiomaID;

  public List<StringKeyValue> getListOfIdiomaForIdiomaID() {
    return this.listOfIdiomaForIdiomaID;
  }

  public void setListOfIdiomaForIdiomaID(List<StringKeyValue> listOfIdiomaForIdiomaID) {
    this.listOfIdiomaForIdiomaID = listOfIdiomaForIdiomaID;
  }



  private List<StringKeyValue> listOfConfiguracioGrupForConfiguraciogrupid;

  public List<StringKeyValue> getListOfConfiguracioGrupForConfiguraciogrupid() {
    return this.listOfConfiguracioGrupForConfiguraciogrupid;
  }

  public void setListOfConfiguracioGrupForConfiguraciogrupid(List<StringKeyValue> listOfConfiguracioGrupForConfiguraciogrupid) {
    this.listOfConfiguracioGrupForConfiguraciogrupid = listOfConfiguracioGrupForConfiguraciogrupid;
  }



  
} // Final de Classe 
