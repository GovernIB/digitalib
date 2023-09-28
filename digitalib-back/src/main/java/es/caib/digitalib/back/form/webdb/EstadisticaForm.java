package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.persistence.EstadisticaJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class EstadisticaForm extends DigitalIBBaseForm {
  
  private EstadisticaJPA estadistica;
  
  public EstadisticaForm() {
  }
  
  public EstadisticaForm(EstadisticaForm __toClone) {
    super(__toClone);
      this.estadistica = __toClone.estadistica;
    this.listOfValuesForTipus = __toClone.listOfValuesForTipus;
  }
  
  public EstadisticaForm(EstadisticaJPA estadistica, boolean nou) {
    super(nou);
    this.estadistica = estadistica;
  }
  
  public EstadisticaJPA getEstadistica() {
    return estadistica;
  }
  public void setEstadistica(EstadisticaJPA estadistica) {
    this.estadistica = estadistica;
  }
  
  
  private List<StringKeyValue> listOfValuesForTipus;

  public List<StringKeyValue> getListOfValuesForTipus() {
    return this.listOfValuesForTipus;
  }

  public void setListOfValuesForTipus(List<StringKeyValue> listOfValuesForTipus) {
    this.listOfValuesForTipus = listOfValuesForTipus;
  }



  
} // Final de Classe 
