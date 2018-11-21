package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.PerfilJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class PerfilForm extends DigitalIBBaseForm {
  
  private PerfilJPA perfil;
  
  public PerfilForm() {
  }
  
  public PerfilForm(PerfilForm __toClone) {
    super(__toClone);
      this.perfil = __toClone.perfil;
    this.listOfPluginForPluginScanWebID = __toClone.listOfPluginForPluginScanWebID;
    this.listOfValuesForTipusFirma = __toClone.listOfValuesForTipusFirma;
    this.listOfPluginForPluginFirmaServidorID = __toClone.listOfPluginForPluginFirmaServidorID;
    this.listOfApiSimpleForApiSimpleID = __toClone.listOfApiSimpleForApiSimpleID;
    this.listOfValuesForTipusCustodia = __toClone.listOfValuesForTipusCustodia;
    this.listOfPluginForPluginArxiuID = __toClone.listOfPluginForPluginArxiuID;
    this.listOfPluginForPluginDocCustodyID = __toClone.listOfPluginForPluginDocCustodyID;
    this.listOfValuesForUsPerfil = __toClone.listOfValuesForUsPerfil;
  }
  
  public PerfilForm(PerfilJPA perfil, boolean nou) {
    super(nou);
    this.perfil = perfil;
  }
  
  public PerfilJPA getPerfil() {
    return perfil;
  }
  public void setPerfil(PerfilJPA perfil) {
    this.perfil = perfil;
  }
  
  
  private List<StringKeyValue> listOfPluginForPluginScanWebID;

  public List<StringKeyValue> getListOfPluginForPluginScanWebID() {
    return this.listOfPluginForPluginScanWebID;
  }

  public void setListOfPluginForPluginScanWebID(List<StringKeyValue> listOfPluginForPluginScanWebID) {
    this.listOfPluginForPluginScanWebID = listOfPluginForPluginScanWebID;
  }



  private List<StringKeyValue> listOfValuesForTipusFirma;

  public List<StringKeyValue> getListOfValuesForTipusFirma() {
    return this.listOfValuesForTipusFirma;
  }

  public void setListOfValuesForTipusFirma(List<StringKeyValue> listOfValuesForTipusFirma) {
    this.listOfValuesForTipusFirma = listOfValuesForTipusFirma;
  }



  private List<StringKeyValue> listOfPluginForPluginFirmaServidorID;

  public List<StringKeyValue> getListOfPluginForPluginFirmaServidorID() {
    return this.listOfPluginForPluginFirmaServidorID;
  }

  public void setListOfPluginForPluginFirmaServidorID(List<StringKeyValue> listOfPluginForPluginFirmaServidorID) {
    this.listOfPluginForPluginFirmaServidorID = listOfPluginForPluginFirmaServidorID;
  }



  private List<StringKeyValue> listOfApiSimpleForApiSimpleID;

  public List<StringKeyValue> getListOfApiSimpleForApiSimpleID() {
    return this.listOfApiSimpleForApiSimpleID;
  }

  public void setListOfApiSimpleForApiSimpleID(List<StringKeyValue> listOfApiSimpleForApiSimpleID) {
    this.listOfApiSimpleForApiSimpleID = listOfApiSimpleForApiSimpleID;
  }



  private List<StringKeyValue> listOfValuesForTipusCustodia;

  public List<StringKeyValue> getListOfValuesForTipusCustodia() {
    return this.listOfValuesForTipusCustodia;
  }

  public void setListOfValuesForTipusCustodia(List<StringKeyValue> listOfValuesForTipusCustodia) {
    this.listOfValuesForTipusCustodia = listOfValuesForTipusCustodia;
  }



  private List<StringKeyValue> listOfPluginForPluginArxiuID;

  public List<StringKeyValue> getListOfPluginForPluginArxiuID() {
    return this.listOfPluginForPluginArxiuID;
  }

  public void setListOfPluginForPluginArxiuID(List<StringKeyValue> listOfPluginForPluginArxiuID) {
    this.listOfPluginForPluginArxiuID = listOfPluginForPluginArxiuID;
  }



  private List<StringKeyValue> listOfPluginForPluginDocCustodyID;

  public List<StringKeyValue> getListOfPluginForPluginDocCustodyID() {
    return this.listOfPluginForPluginDocCustodyID;
  }

  public void setListOfPluginForPluginDocCustodyID(List<StringKeyValue> listOfPluginForPluginDocCustodyID) {
    this.listOfPluginForPluginDocCustodyID = listOfPluginForPluginDocCustodyID;
  }



  private List<StringKeyValue> listOfValuesForUsPerfil;

  public List<StringKeyValue> getListOfValuesForUsPerfil() {
    return this.listOfValuesForUsPerfil;
  }

  public void setListOfValuesForUsPerfil(List<StringKeyValue> listOfValuesForUsPerfil) {
    this.listOfValuesForUsPerfil = listOfValuesForUsPerfil;
  }



  
} // Final de Classe 
