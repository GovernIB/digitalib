package es.caib.digitalib.back.form;

import org.fundaciobit.genapp.common.web.form.BaseForm;

/**
 * 
 * @author anadal
 *
 */
public abstract class DigitalIBBaseForm extends BaseForm {

  public DigitalIBBaseForm() {
  }
  
  public DigitalIBBaseForm(boolean nou) {
    super(nou);
  }
  
  public DigitalIBBaseForm(DigitalIBBaseForm __toClone) {
    super(__toClone);
  }
  
}
