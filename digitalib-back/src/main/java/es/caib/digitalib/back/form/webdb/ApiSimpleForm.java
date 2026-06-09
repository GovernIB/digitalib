package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
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
    this.listOfValuesForTipus = __toClone.listOfValuesForTipus;
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
  
  
  private List<StringKeyValue> listOfValuesForTipus;

  public List<StringKeyValue> getListOfValuesForTipus() {
    return this.listOfValuesForTipus;
  }

  public void setListOfValuesForTipus(List<StringKeyValue> listOfValuesForTipus) {
    this.listOfValuesForTipus = listOfValuesForTipus;
  }



  
} // Final de Classe 
