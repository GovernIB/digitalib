package es.caib.digitalib.back.form.webdb;

import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.persistence.ApiSimpleJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class ApiSimpleForm extends DigitalIBBaseForm {
  
  private ApiSimpleJPA apiSimple;
  
  public ApiSimpleForm() {
  }
  
  public ApiSimpleForm(ApiSimpleForm __toClone) {
    super(__toClone);
      this.apiSimple = __toClone.apiSimple;
  }
  
  public ApiSimpleForm(ApiSimpleJPA apiSimple, boolean nou) {
    super(nou);
    this.apiSimple = apiSimple;
  }
  
  public ApiSimpleJPA getApiSimple() {
    return apiSimple;
  }
  public void setApiSimple(ApiSimpleJPA apiSimple) {
    this.apiSimple = apiSimple;
  }
  
  
  
} // Final de Classe 
