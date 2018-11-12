
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.PerfilFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class PerfilFilterForm extends DigitalIBBaseFilterForm implements PerfilFields {

  private java.lang.Long perfilIDDesde;

  public java.lang.Long getPerfilIDDesde() {
    return this.perfilIDDesde;
  }

  public void setPerfilIDDesde(java.lang.Long perfilIDDesde) {
    this.perfilIDDesde = perfilIDDesde;
  }


  private java.lang.Long perfilIDFins;

  public java.lang.Long getPerfilIDFins() {
    return this.perfilIDFins;
  }

  public void setPerfilIDFins(java.lang.Long perfilIDFins) {
    this.perfilIDFins = perfilIDFins;
  }


  private java.lang.String codi;

  public java.lang.String getCodi() {
    return this.codi;
  }

  public void setCodi(java.lang.String codi) {
    this.codi = codi;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String descripcio;

  public java.lang.String getDescripcio() {
    return this.descripcio;
  }

  public void setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
  }


  private java.lang.Long pluginScanWebIDDesde;

  public java.lang.Long getPluginScanWebIDDesde() {
    return this.pluginScanWebIDDesde;
  }

  public void setPluginScanWebIDDesde(java.lang.Long pluginScanWebIDDesde) {
    this.pluginScanWebIDDesde = pluginScanWebIDDesde;
  }


  private java.lang.Long pluginScanWebIDFins;

  public java.lang.Long getPluginScanWebIDFins() {
    return this.pluginScanWebIDFins;
  }

  public void setPluginScanWebIDFins(java.lang.Long pluginScanWebIDFins) {
    this.pluginScanWebIDFins = pluginScanWebIDFins;
  }


  private java.lang.Long pluginFirmaServidorIDDesde;

  public java.lang.Long getPluginFirmaServidorIDDesde() {
    return this.pluginFirmaServidorIDDesde;
  }

  public void setPluginFirmaServidorIDDesde(java.lang.Long pluginFirmaServidorIDDesde) {
    this.pluginFirmaServidorIDDesde = pluginFirmaServidorIDDesde;
  }


  private java.lang.Long pluginFirmaServidorIDFins;

  public java.lang.Long getPluginFirmaServidorIDFins() {
    return this.pluginFirmaServidorIDFins;
  }

  public void setPluginFirmaServidorIDFins(java.lang.Long pluginFirmaServidorIDFins) {
    this.pluginFirmaServidorIDFins = pluginFirmaServidorIDFins;
  }


  private java.lang.Long pluginArxiuIDDesde;

  public java.lang.Long getPluginArxiuIDDesde() {
    return this.pluginArxiuIDDesde;
  }

  public void setPluginArxiuIDDesde(java.lang.Long pluginArxiuIDDesde) {
    this.pluginArxiuIDDesde = pluginArxiuIDDesde;
  }


  private java.lang.Long pluginArxiuIDFins;

  public java.lang.Long getPluginArxiuIDFins() {
    return this.pluginArxiuIDFins;
  }

  public void setPluginArxiuIDFins(java.lang.Long pluginArxiuIDFins) {
    this.pluginArxiuIDFins = pluginArxiuIDFins;
  }


  private java.lang.Long pluginDocCustodyIDDesde;

  public java.lang.Long getPluginDocCustodyIDDesde() {
    return this.pluginDocCustodyIDDesde;
  }

  public void setPluginDocCustodyIDDesde(java.lang.Long pluginDocCustodyIDDesde) {
    this.pluginDocCustodyIDDesde = pluginDocCustodyIDDesde;
  }


  private java.lang.Long pluginDocCustodyIDFins;

  public java.lang.Long getPluginDocCustodyIDFins() {
    return this.pluginDocCustodyIDFins;
  }

  public void setPluginDocCustodyIDFins(java.lang.Long pluginDocCustodyIDFins) {
    this.pluginDocCustodyIDFins = pluginDocCustodyIDFins;
  }


  public PerfilFilterForm() {
  }
  
  public PerfilFilterForm(PerfilFilterForm __toClone) {
    super(__toClone);
    this.perfilIDDesde = __toClone.perfilIDDesde;
    this.perfilIDFins = __toClone.perfilIDFins;
    this.codi = __toClone.codi;
    this.nom = __toClone.nom;
    this.descripcio = __toClone.descripcio;
    this.pluginScanWebIDDesde = __toClone.pluginScanWebIDDesde;
    this.pluginScanWebIDFins = __toClone.pluginScanWebIDFins;
    this.pluginFirmaServidorIDDesde = __toClone.pluginFirmaServidorIDDesde;
    this.pluginFirmaServidorIDFins = __toClone.pluginFirmaServidorIDFins;
    this.pluginArxiuIDDesde = __toClone.pluginArxiuIDDesde;
    this.pluginArxiuIDFins = __toClone.pluginArxiuIDFins;
    this.pluginDocCustodyIDDesde = __toClone.pluginDocCustodyIDDesde;
    this.pluginDocCustodyIDFins = __toClone.pluginDocCustodyIDFins;
    this.mapOfPluginForPluginScanWebID = __toClone.mapOfPluginForPluginScanWebID;
    this.mapOfPluginForPluginFirmaServidorID = __toClone.mapOfPluginForPluginFirmaServidorID;
    this.mapOfPluginForPluginArxiuID = __toClone.mapOfPluginForPluginArxiuID;
    this.mapOfPluginForPluginDocCustodyID = __toClone.mapOfPluginForPluginDocCustodyID;
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
  private Map<String, String> mapOfPluginForPluginScanWebID;

  public Map<String, String> getMapOfPluginForPluginScanWebID() {
    return this.mapOfPluginForPluginScanWebID;
  }

  public void setMapOfPluginForPluginScanWebID(Map<String, String> mapOfPluginForPluginScanWebID) {
    this.mapOfPluginForPluginScanWebID = mapOfPluginForPluginScanWebID;
  }



  private Map<String, String> mapOfPluginForPluginFirmaServidorID;

  public Map<String, String> getMapOfPluginForPluginFirmaServidorID() {
    return this.mapOfPluginForPluginFirmaServidorID;
  }

  public void setMapOfPluginForPluginFirmaServidorID(Map<String, String> mapOfPluginForPluginFirmaServidorID) {
    this.mapOfPluginForPluginFirmaServidorID = mapOfPluginForPluginFirmaServidorID;
  }



  private Map<String, String> mapOfPluginForPluginArxiuID;

  public Map<String, String> getMapOfPluginForPluginArxiuID() {
    return this.mapOfPluginForPluginArxiuID;
  }

  public void setMapOfPluginForPluginArxiuID(Map<String, String> mapOfPluginForPluginArxiuID) {
    this.mapOfPluginForPluginArxiuID = mapOfPluginForPluginArxiuID;
  }



  private Map<String, String> mapOfPluginForPluginDocCustodyID;

  public Map<String, String> getMapOfPluginForPluginDocCustodyID() {
    return this.mapOfPluginForPluginDocCustodyID;
  }

  public void setMapOfPluginForPluginDocCustodyID(Map<String, String> mapOfPluginForPluginDocCustodyID) {
    this.mapOfPluginForPluginDocCustodyID = mapOfPluginForPluginDocCustodyID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
