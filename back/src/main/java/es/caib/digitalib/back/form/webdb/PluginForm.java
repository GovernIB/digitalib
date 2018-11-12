package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.PluginJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class PluginForm extends DigitalIBBaseForm {
  
  private PluginJPA plugin;
  
  public PluginForm() {
  }
  
  public PluginForm(PluginForm __toClone) {
    super(__toClone);
      this.plugin = __toClone.plugin;
    this.listOfValuesForTipus = __toClone.listOfValuesForTipus;
  }
  
  public PluginForm(PluginJPA plugin, boolean nou) {
    super(nou);
    this.plugin = plugin;
  }
  
  public PluginJPA getPlugin() {
    return plugin;
  }
  public void setPlugin(PluginJPA plugin) {
    this.plugin = plugin;
  }
  
  
  private List<StringKeyValue> listOfValuesForTipus;

  public List<StringKeyValue> getListOfValuesForTipus() {
    return this.listOfValuesForTipus;
  }

  public void setListOfValuesForTipus(List<StringKeyValue> listOfValuesForTipus) {
    this.listOfValuesForTipus = listOfValuesForTipus;
  }



  
} // Final de Classe 
