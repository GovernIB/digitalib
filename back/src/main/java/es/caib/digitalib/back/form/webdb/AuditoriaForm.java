package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.AuditoriaJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class AuditoriaForm extends DigitalIBBaseForm {
  
  private AuditoriaJPA auditoria;
  
  public AuditoriaForm() {
  }
  
  public AuditoriaForm(AuditoriaForm __toClone) {
    super(__toClone);
      this.auditoria = __toClone.auditoria;
    this.listOfValuesForTipus = __toClone.listOfValuesForTipus;
  }
  
  public AuditoriaForm(AuditoriaJPA auditoria, boolean nou) {
    super(nou);
    this.auditoria = auditoria;
  }
  
  public AuditoriaJPA getAuditoria() {
    return auditoria;
  }
  public void setAuditoria(AuditoriaJPA auditoria) {
    this.auditoria = auditoria;
  }
  
  
  private List<StringKeyValue> listOfValuesForTipus;

  public List<StringKeyValue> getListOfValuesForTipus() {
    return this.listOfValuesForTipus;
  }

  public void setListOfValuesForTipus(List<StringKeyValue> listOfValuesForTipus) {
    this.listOfValuesForTipus = listOfValuesForTipus;
  }



  
} // Final de Classe 