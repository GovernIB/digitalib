package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.persistence.MetadadaJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class MetadadaForm extends DigitalIBBaseForm {
  
  private MetadadaJPA metadada;
  
  public MetadadaForm() {
  }
  
  public MetadadaForm(MetadadaForm __toClone) {
    super(__toClone);
      this.metadada = __toClone.metadada;
    this.listOfTransaccioForTransaccioID = __toClone.listOfTransaccioForTransaccioID;
  }
  
  public MetadadaForm(MetadadaJPA metadada, boolean nou) {
    super(nou);
    this.metadada = metadada;
  }
  
  public MetadadaJPA getMetadada() {
    return metadada;
  }
  public void setMetadada(MetadadaJPA metadada) {
    this.metadada = metadada;
  }
  
  
  private List<StringKeyValue> listOfTransaccioForTransaccioID;

  public List<StringKeyValue> getListOfTransaccioForTransaccioID() {
    return this.listOfTransaccioForTransaccioID;
  }

  public void setListOfTransaccioForTransaccioID(List<StringKeyValue> listOfTransaccioForTransaccioID) {
    this.listOfTransaccioForTransaccioID = listOfTransaccioForTransaccioID;
  }



  
} // Final de Classe 
