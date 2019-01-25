package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.PluginCridadaJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class PluginCridadaForm extends DigitalIBBaseForm {
  
  private PluginCridadaJPA pluginCridada;
  
  
  private CommonsMultipartFile parametresFitxerID;
  private boolean parametresFitxerIDDelete;
  
  
  private CommonsMultipartFile retornFitxerID;
  private boolean retornFitxerIDDelete;
  
  public PluginCridadaForm() {
  }
  
  public PluginCridadaForm(PluginCridadaForm __toClone) {
    super(__toClone);
      this.pluginCridada = __toClone.pluginCridada;
    this.listOfPluginForPluginID = __toClone.listOfPluginForPluginID;
    this.listOfValuesForTipusResultat = __toClone.listOfValuesForTipusResultat;
  }
  
  public PluginCridadaForm(PluginCridadaJPA pluginCridada, boolean nou) {
    super(nou);
    this.pluginCridada = pluginCridada;
  }
  
  public PluginCridadaJPA getPluginCridada() {
    return pluginCridada;
  }
  public void setPluginCridada(PluginCridadaJPA pluginCridada) {
    this.pluginCridada = pluginCridada;
  }
  
  
  public CommonsMultipartFile getParametresFitxerID() {
    return parametresFitxerID;
  }
  
   public void setParametresFitxerID(CommonsMultipartFile parametresFitxerID) {
    this.parametresFitxerID = parametresFitxerID;
  }
  public boolean isParametresFitxerIDDelete() {
    return parametresFitxerIDDelete;
  }
  
  public void setParametresFitxerIDDelete(boolean parametresFitxerIDDelete) {
    this.parametresFitxerIDDelete = parametresFitxerIDDelete;
   }
  public CommonsMultipartFile getRetornFitxerID() {
    return retornFitxerID;
  }
  
   public void setRetornFitxerID(CommonsMultipartFile retornFitxerID) {
    this.retornFitxerID = retornFitxerID;
  }
  public boolean isRetornFitxerIDDelete() {
    return retornFitxerIDDelete;
  }
  
  public void setRetornFitxerIDDelete(boolean retornFitxerIDDelete) {
    this.retornFitxerIDDelete = retornFitxerIDDelete;
   }
  private List<StringKeyValue> listOfPluginForPluginID;

  public List<StringKeyValue> getListOfPluginForPluginID() {
    return this.listOfPluginForPluginID;
  }

  public void setListOfPluginForPluginID(List<StringKeyValue> listOfPluginForPluginID) {
    this.listOfPluginForPluginID = listOfPluginForPluginID;
  }



  private List<StringKeyValue> listOfValuesForTipusResultat;

  public List<StringKeyValue> getListOfValuesForTipusResultat() {
    return this.listOfValuesForTipusResultat;
  }

  public void setListOfValuesForTipusResultat(List<StringKeyValue> listOfValuesForTipusResultat) {
    this.listOfValuesForTipusResultat = listOfValuesForTipusResultat;
  }



  
} // Final de Classe 
