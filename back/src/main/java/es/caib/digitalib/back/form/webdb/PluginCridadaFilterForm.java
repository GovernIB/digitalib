
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


  private java.lang.String metodeplugin;

  public java.lang.String getMetodeplugin() {
    return this.metodeplugin;
  }

  public void setMetodeplugin(java.lang.String metodeplugin) {
    this.metodeplugin = metodeplugin;
  }


  private java.lang.Integer tipusresultatDesde;

  public java.lang.Integer getTipusresultatDesde() {
    return this.tipusresultatDesde;
  }

  public void setTipusresultatDesde(java.lang.Integer tipusresultatDesde) {
    this.tipusresultatDesde = tipusresultatDesde;
  }


  private java.lang.Integer tipusresultatFins;

  public java.lang.Integer getTipusresultatFins() {
    return this.tipusresultatFins;
  }

  public void setTipusresultatFins(java.lang.Integer tipusresultatFins) {
    this.tipusresultatFins = tipusresultatFins;
  }


  private java.lang.Long tempsexecucioDesde;

  public java.lang.Long getTempsexecucioDesde() {
    return this.tempsexecucioDesde;
  }

  public void setTempsexecucioDesde(java.lang.Long tempsexecucioDesde) {
    this.tempsexecucioDesde = tempsexecucioDesde;
  }


  private java.lang.Long tempsexecucioFins;

  public java.lang.Long getTempsexecucioFins() {
    return this.tempsexecucioFins;
  }

  public void setTempsexecucioFins(java.lang.Long tempsexecucioFins) {
    this.tempsexecucioFins = tempsexecucioFins;
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


  private java.lang.Long usuaripersonaidDesde;

  public java.lang.Long getUsuaripersonaidDesde() {
    return this.usuaripersonaidDesde;
  }

  public void setUsuaripersonaidDesde(java.lang.Long usuaripersonaidDesde) {
    this.usuaripersonaidDesde = usuaripersonaidDesde;
  }


  private java.lang.Long usuaripersonaidFins;

  public java.lang.Long getUsuaripersonaidFins() {
    return this.usuaripersonaidFins;
  }

  public void setUsuaripersonaidFins(java.lang.Long usuaripersonaidFins) {
    this.usuaripersonaidFins = usuaripersonaidFins;
  }


  private java.lang.Long usuariaplicacioidDesde;

  public java.lang.Long getUsuariaplicacioidDesde() {
    return this.usuariaplicacioidDesde;
  }

  public void setUsuariaplicacioidDesde(java.lang.Long usuariaplicacioidDesde) {
    this.usuariaplicacioidDesde = usuariaplicacioidDesde;
  }


  private java.lang.Long usuariaplicacioidFins;

  public java.lang.Long getUsuariaplicacioidFins() {
    return this.usuariaplicacioidFins;
  }

  public void setUsuariaplicacioidFins(java.lang.Long usuariaplicacioidFins) {
    this.usuariaplicacioidFins = usuariaplicacioidFins;
  }


  private java.lang.String parametrestext;

  public java.lang.String getParametrestext() {
    return this.parametrestext;
  }

  public void setParametrestext(java.lang.String parametrestext) {
    this.parametrestext = parametrestext;
  }


  private java.lang.String retorntext;

  public java.lang.String getRetorntext() {
    return this.retorntext;
  }

  public void setRetorntext(java.lang.String retorntext) {
    this.retorntext = retorntext;
  }


  public PluginCridadaFilterForm() {
  }
  
  public PluginCridadaFilterForm(PluginCridadaFilterForm __toClone) {
    super(__toClone);
    this.pluginCridadaIDDesde = __toClone.pluginCridadaIDDesde;
    this.pluginCridadaIDFins = __toClone.pluginCridadaIDFins;
    this.dataDesde = __toClone.dataDesde;
    this.dataFins = __toClone.dataFins;
    this.metodeplugin = __toClone.metodeplugin;
    this.tipusresultatDesde = __toClone.tipusresultatDesde;
    this.tipusresultatFins = __toClone.tipusresultatFins;
    this.tempsexecucioDesde = __toClone.tempsexecucioDesde;
    this.tempsexecucioFins = __toClone.tempsexecucioFins;
    this.pluginIDDesde = __toClone.pluginIDDesde;
    this.pluginIDFins = __toClone.pluginIDFins;
    this.usuaripersonaidDesde = __toClone.usuaripersonaidDesde;
    this.usuaripersonaidFins = __toClone.usuaripersonaidFins;
    this.usuariaplicacioidDesde = __toClone.usuariaplicacioidDesde;
    this.usuariaplicacioidFins = __toClone.usuariaplicacioidFins;
    this.parametrestext = __toClone.parametrestext;
    this.retorntext = __toClone.retorntext;
    this.mapOfPluginForPluginID = __toClone.mapOfPluginForPluginID;
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




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
