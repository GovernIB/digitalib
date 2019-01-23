
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.PluginCridadaFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class PluginCridadaFilterForm extends DigitalIBBaseFilterForm implements PluginCridadaFields {

  private java.lang.Long pluginCridadaIDDesde;

  public java.lang.Long getPluginCridadaIDDesde() {
    return this.pluginCridadaIDDesde;
  }

  public void setPluginCridadaIDDesde(java.lang.Long pluginCridadaIDDesde) {
    this.pluginCridadaIDDesde = pluginCridadaIDDesde;
  }


  private java.lang.Long pluginCridadaIDFins;

  public java.lang.Long getPluginCridadaIDFins() {
    return this.pluginCridadaIDFins;
  }

  public void setPluginCridadaIDFins(java.lang.Long pluginCridadaIDFins) {
    this.pluginCridadaIDFins = pluginCridadaIDFins;
  }


  private java.sql.Timestamp dataDesde;

  public java.sql.Timestamp getDataDesde() {
    return this.dataDesde;
  }

  public void setDataDesde(java.sql.Timestamp dataDesde) {
    this.dataDesde = dataDesde;
  }


  private java.sql.Timestamp dataFins;

  public java.sql.Timestamp getDataFins() {
    return this.dataFins;
  }

  public void setDataFins(java.sql.Timestamp dataFins) {
    this.dataFins = dataFins;
  }


  private java.lang.Long pluginIDDesde;

  public java.lang.Long getPluginIDDesde() {
    return this.pluginIDDesde;
  }

  public void setPluginIDDesde(java.lang.Long pluginIDDesde) {
    this.pluginIDDesde = pluginIDDesde;
  }


  private java.lang.Long pluginIDFins;

  public java.lang.Long getPluginIDFins() {
    return this.pluginIDFins;
  }

  public void setPluginIDFins(java.lang.Long pluginIDFins) {
    this.pluginIDFins = pluginIDFins;
  }


  private java.lang.String metodePlugin;

  public java.lang.String getMetodePlugin() {
    return this.metodePlugin;
  }

  public void setMetodePlugin(java.lang.String metodePlugin) {
    this.metodePlugin = metodePlugin;
  }


  private java.lang.Integer tipusResultatDesde;

  public java.lang.Integer getTipusResultatDesde() {
    return this.tipusResultatDesde;
  }

  public void setTipusResultatDesde(java.lang.Integer tipusResultatDesde) {
    this.tipusResultatDesde = tipusResultatDesde;
  }


  private java.lang.Integer tipusResultatFins;

  public java.lang.Integer getTipusResultatFins() {
    return this.tipusResultatFins;
  }

  public void setTipusResultatFins(java.lang.Integer tipusResultatFins) {
    this.tipusResultatFins = tipusResultatFins;
  }


  private java.lang.Long tempsExecucioDesde;

  public java.lang.Long getTempsExecucioDesde() {
    return this.tempsExecucioDesde;
  }

  public void setTempsExecucioDesde(java.lang.Long tempsExecucioDesde) {
    this.tempsExecucioDesde = tempsExecucioDesde;
  }


  private java.lang.Long tempsExecucioFins;

  public java.lang.Long getTempsExecucioFins() {
    return this.tempsExecucioFins;
  }

  public void setTempsExecucioFins(java.lang.Long tempsExecucioFins) {
    this.tempsExecucioFins = tempsExecucioFins;
  }


  private java.lang.Long usuariPersonaIdDesde;

  public java.lang.Long getUsuariPersonaIdDesde() {
    return this.usuariPersonaIdDesde;
  }

  public void setUsuariPersonaIdDesde(java.lang.Long usuariPersonaIdDesde) {
    this.usuariPersonaIdDesde = usuariPersonaIdDesde;
  }


  private java.lang.Long usuariPersonaIdFins;

  public java.lang.Long getUsuariPersonaIdFins() {
    return this.usuariPersonaIdFins;
  }

  public void setUsuariPersonaIdFins(java.lang.Long usuariPersonaIdFins) {
    this.usuariPersonaIdFins = usuariPersonaIdFins;
  }


  private java.lang.Long usuariAplicacioIdDesde;

  public java.lang.Long getUsuariAplicacioIdDesde() {
    return this.usuariAplicacioIdDesde;
  }

  public void setUsuariAplicacioIdDesde(java.lang.Long usuariAplicacioIdDesde) {
    this.usuariAplicacioIdDesde = usuariAplicacioIdDesde;
  }


  private java.lang.Long usuariAplicacioIdFins;

  public java.lang.Long getUsuariAplicacioIdFins() {
    return this.usuariAplicacioIdFins;
  }

  public void setUsuariAplicacioIdFins(java.lang.Long usuariAplicacioIdFins) {
    this.usuariAplicacioIdFins = usuariAplicacioIdFins;
  }


  private java.lang.String parametresText;

  public java.lang.String getParametresText() {
    return this.parametresText;
  }

  public void setParametresText(java.lang.String parametresText) {
    this.parametresText = parametresText;
  }


  private java.lang.String retornText;

  public java.lang.String getRetornText() {
    return this.retornText;
  }

  public void setRetornText(java.lang.String retornText) {
    this.retornText = retornText;
  }


  public PluginCridadaFilterForm() {
  }
  
  public PluginCridadaFilterForm(PluginCridadaFilterForm __toClone) {
    super(__toClone);
    this.pluginCridadaIDDesde = __toClone.pluginCridadaIDDesde;
    this.pluginCridadaIDFins = __toClone.pluginCridadaIDFins;
    this.dataDesde = __toClone.dataDesde;
    this.dataFins = __toClone.dataFins;
    this.pluginIDDesde = __toClone.pluginIDDesde;
    this.pluginIDFins = __toClone.pluginIDFins;
    this.metodePlugin = __toClone.metodePlugin;
    this.tipusResultatDesde = __toClone.tipusResultatDesde;
    this.tipusResultatFins = __toClone.tipusResultatFins;
    this.tempsExecucioDesde = __toClone.tempsExecucioDesde;
    this.tempsExecucioFins = __toClone.tempsExecucioFins;
    this.usuariPersonaIdDesde = __toClone.usuariPersonaIdDesde;
    this.usuariPersonaIdFins = __toClone.usuariPersonaIdFins;
    this.usuariAplicacioIdDesde = __toClone.usuariAplicacioIdDesde;
    this.usuariAplicacioIdFins = __toClone.usuariAplicacioIdFins;
    this.parametresText = __toClone.parametresText;
    this.retornText = __toClone.retornText;
    this.mapOfPluginForPluginID = __toClone.mapOfPluginForPluginID;
    this.mapOfValuesForTipusResultat = __toClone.mapOfValuesForTipusResultat;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }


  protected OrderBy[] defaultOrderBy = null;


  public OrderBy[] getDefaultOrderBy() {
    return this.defaultOrderBy;
  }

  public void setDefaultOrderBy(OrderBy[] defOrderBy) {
    this.defaultOrderBy = defOrderBy;
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

   // -----------------------
   // Maps de referencies.
   // -----------------------
  private Map<String, String> mapOfPluginForPluginID;

  public Map<String, String> getMapOfPluginForPluginID() {
    return this.mapOfPluginForPluginID;
  }

  public void setMapOfPluginForPluginID(Map<String, String> mapOfPluginForPluginID) {
    this.mapOfPluginForPluginID = mapOfPluginForPluginID;
  }



  private Map<String, String> mapOfValuesForTipusResultat;

  public Map<String, String> getMapOfValuesForTipusResultat() {
    return this.mapOfValuesForTipusResultat;
  }

  public void setMapOfValuesForTipusResultat(Map<String, String> mapOfValuesForTipusResultat) {
    this.mapOfValuesForTipusResultat = mapOfValuesForTipusResultat;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
