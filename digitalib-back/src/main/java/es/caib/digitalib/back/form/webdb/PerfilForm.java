package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.persistence.PerfilJPA;

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
    this.listOfTraduccioForNomID = __toClone.listOfTraduccioForNomID;
    this.listOfTraduccioForDescripcioID = __toClone.listOfTraduccioForDescripcioID;
    this.listOfValuesForScanFormatFitxer = __toClone.listOfValuesForScanFormatFitxer;
    this.listOfValuesForScanMinimaResolucio = __toClone.listOfValuesForScanMinimaResolucio;
    this.listOfValuesForScanPixelType = __toClone.listOfValuesForScanPixelType;
    this.listOfPluginForPluginScanWebID = __toClone.listOfPluginForPluginScanWebID;
    this.listOfPluginForPluginScanWeb2ID = __toClone.listOfPluginForPluginScanWeb2ID;
    this.listOfValuesForTipusFirma = __toClone.listOfValuesForTipusFirma;
    this.listOfApiSimpleForApiSimpleID = __toClone.listOfApiSimpleForApiSimpleID;
    this.listOfConfiguracioFirmaForConfiguracioFirmaID = __toClone.listOfConfiguracioFirmaForConfiguracioFirmaID;
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
  
  java.util.List<es.caib.digitalib.model.entity.Idioma> idiomesTraduccio = null;

  public java.util.List<es.caib.digitalib.model.entity.Idioma> getIdiomesTraduccio() {
    return idiomesTraduccio;
  }

  public void setIdiomesTraduccio(java.util.List<es.caib.digitalib.model.entity.Idioma> idiomesTraduccio) {
    this.idiomesTraduccio = idiomesTraduccio;
  }
  
  private List<StringKeyValue> listOfTraduccioForNomID;

  public List<StringKeyValue> getListOfTraduccioForNomID() {
    return this.listOfTraduccioForNomID;
  }

  public void setListOfTraduccioForNomID(List<StringKeyValue> listOfTraduccioForNomID) {
    this.listOfTraduccioForNomID = listOfTraduccioForNomID;
  }



  private List<StringKeyValue> listOfTraduccioForDescripcioID;

  public List<StringKeyValue> getListOfTraduccioForDescripcioID() {
    return this.listOfTraduccioForDescripcioID;
  }

  public void setListOfTraduccioForDescripcioID(List<StringKeyValue> listOfTraduccioForDescripcioID) {
    this.listOfTraduccioForDescripcioID = listOfTraduccioForDescripcioID;
  }



  private List<StringKeyValue> listOfValuesForScanFormatFitxer;

  public List<StringKeyValue> getListOfValuesForScanFormatFitxer() {
    return this.listOfValuesForScanFormatFitxer;
  }

  public void setListOfValuesForScanFormatFitxer(List<StringKeyValue> listOfValuesForScanFormatFitxer) {
    this.listOfValuesForScanFormatFitxer = listOfValuesForScanFormatFitxer;
  }



  private List<StringKeyValue> listOfValuesForScanMinimaResolucio;

  public List<StringKeyValue> getListOfValuesForScanMinimaResolucio() {
    return this.listOfValuesForScanMinimaResolucio;
  }

  public void setListOfValuesForScanMinimaResolucio(List<StringKeyValue> listOfValuesForScanMinimaResolucio) {
    this.listOfValuesForScanMinimaResolucio = listOfValuesForScanMinimaResolucio;
  }



  private List<StringKeyValue> listOfValuesForScanPixelType;

  public List<StringKeyValue> getListOfValuesForScanPixelType() {
    return this.listOfValuesForScanPixelType;
  }

  public void setListOfValuesForScanPixelType(List<StringKeyValue> listOfValuesForScanPixelType) {
    this.listOfValuesForScanPixelType = listOfValuesForScanPixelType;
  }



  private List<StringKeyValue> listOfPluginForPluginScanWebID;

  public List<StringKeyValue> getListOfPluginForPluginScanWebID() {
    return this.listOfPluginForPluginScanWebID;
  }

  public void setListOfPluginForPluginScanWebID(List<StringKeyValue> listOfPluginForPluginScanWebID) {
    this.listOfPluginForPluginScanWebID = listOfPluginForPluginScanWebID;
  }



  private List<StringKeyValue> listOfPluginForPluginScanWeb2ID;

  public List<StringKeyValue> getListOfPluginForPluginScanWeb2ID() {
    return this.listOfPluginForPluginScanWeb2ID;
  }

  public void setListOfPluginForPluginScanWeb2ID(List<StringKeyValue> listOfPluginForPluginScanWeb2ID) {
    this.listOfPluginForPluginScanWeb2ID = listOfPluginForPluginScanWeb2ID;
  }



  private List<StringKeyValue> listOfValuesForTipusFirma;

  public List<StringKeyValue> getListOfValuesForTipusFirma() {
    return this.listOfValuesForTipusFirma;
  }

  public void setListOfValuesForTipusFirma(List<StringKeyValue> listOfValuesForTipusFirma) {
    this.listOfValuesForTipusFirma = listOfValuesForTipusFirma;
  }



  private List<StringKeyValue> listOfApiSimpleForApiSimpleID;

  public List<StringKeyValue> getListOfApiSimpleForApiSimpleID() {
    return this.listOfApiSimpleForApiSimpleID;
  }

  public void setListOfApiSimpleForApiSimpleID(List<StringKeyValue> listOfApiSimpleForApiSimpleID) {
    this.listOfApiSimpleForApiSimpleID = listOfApiSimpleForApiSimpleID;
  }



  private List<StringKeyValue> listOfConfiguracioFirmaForConfiguracioFirmaID;

  public List<StringKeyValue> getListOfConfiguracioFirmaForConfiguracioFirmaID() {
    return this.listOfConfiguracioFirmaForConfiguracioFirmaID;
  }

  public void setListOfConfiguracioFirmaForConfiguracioFirmaID(List<StringKeyValue> listOfConfiguracioFirmaForConfiguracioFirmaID) {
    this.listOfConfiguracioFirmaForConfiguracioFirmaID = listOfConfiguracioFirmaForConfiguracioFirmaID;
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
