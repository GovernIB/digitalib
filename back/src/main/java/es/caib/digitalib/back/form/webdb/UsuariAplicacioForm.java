package es.caib.digitalib.back.form.webdb;

import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.UsuariAplicacioJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class UsuariAplicacioForm extends DigitalIBBaseForm {
  
  private UsuariAplicacioJPA usuariAplicacio;
  
  public UsuariAplicacioForm() {
  }
  
  public UsuariAplicacioForm(UsuariAplicacioForm __toClone) {
    super(__toClone);
      this.usuariAplicacio = __toClone.usuariAplicacio;
  }
  
  public UsuariAplicacioForm(UsuariAplicacioJPA usuariAplicacio, boolean nou) {
    super(nou);
    this.usuariAplicacio = usuariAplicacio;
  }
  
  public UsuariAplicacioJPA getUsuariAplicacio() {
    return usuariAplicacio;
  }
  public void setUsuariAplicacio(UsuariAplicacioJPA usuariAplicacio) {
    this.usuariAplicacio = usuariAplicacio;
  }
  
  
  
} // Final de Classe 
