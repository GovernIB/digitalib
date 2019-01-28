package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.ConfiguracioFirmaJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class ConfiguracioFirmaForm extends DigitalIBBaseForm {
  
  private ConfiguracioFirmaJPA configuracioFirma;
  
  public ConfiguracioFirmaForm() {
  }
  
  public ConfiguracioFirmaForm(ConfiguracioFirmaForm __toClone) {
    super(__toClone);
      this.configuracioFirma = __toClone.configuracioFirma;
    this.listOfPluginForPluginFirmaServidorID = __toClone.listOfPluginForPluginFirmaServidorID;
    this.listOfPluginForPluginSegellatID = __toClone.listOfPluginForPluginSegellatID;
    this.listOfValuesForTipusOperacioFirma = __toClone.listOfValuesForTipusOperacioFirma;
    this.listOfValuesForTipusFirmaID = __toClone.listOfValuesForTipusFirmaID;
    this.listOfValuesForAlgorismeDeFirmaID = __toClone.listOfValuesForAlgorismeDeFirmaID;
    this.listOfValuesForUsPoliticaDeFirma = __toClone.listOfValuesForUsPoliticaDeFirma;
    this.listOfValuesForPosicioTaulaFirmesID = __toClone.listOfValuesForPosicioTaulaFirmesID;
    this.listOfTraduccioForFirmatPerFormatID = __toClone.listOfTraduccioForFirmatPerFormatID;
    this.listOfTraduccioForMotiuDelegacioID = __toClone.listOfTraduccioForMotiuDelegacioID;
  }
  
  public ConfiguracioFirmaForm(ConfiguracioFirmaJPA configuracioFirma, boolean nou) {
    super(nou);
    this.configuracioFirma = configuracioFirma;
  }
  
  public ConfiguracioFirmaJPA getConfiguracioFirma() {
    return configuracioFirma;
  }
  public void setConfiguracioFirma(ConfiguracioFirmaJPA configuracioFirma) {
    this.configuracioFirma = configuracioFirma;
  }
  
  java.util.List<es.caib.digitalib.model.entity.Idioma> idiomesTraduccio = null;

  public java.util.List<es.caib.digitalib.model.entity.Idioma> getIdiomesTraduccio() {
    return idiomesTraduccio;
  }

  public void setIdiomesTraduccio(java.util.List<es.caib.digitalib.model.entity.Idioma> idiomesTraduccio) {
    this.idiomesTraduccio = idiomesTraduccio;
  }
  
  private List<StringKeyValue> listOfPluginForPluginFirmaServidorID;

  public List<StringKeyValue> getListOfPluginForPluginFirmaServidorID() {
    return this.listOfPluginForPluginFirmaServidorID;
  }

  public void setListOfPluginForPluginFirmaServidorID(List<StringKeyValue> listOfPluginForPluginFirmaServidorID) {
    this.listOfPluginForPluginFirmaServidorID = listOfPluginForPluginFirmaServidorID;
  }



  private List<StringKeyValue> listOfPluginForPluginSegellatID;

  public List<StringKeyValue> getListOfPluginForPluginSegellatID() {
    return this.listOfPluginForPluginSegellatID;
  }

  public void setListOfPluginForPluginSegellatID(List<StringKeyValue> listOfPluginForPluginSegellatID) {
    this.listOfPluginForPluginSegellatID = listOfPluginForPluginSegellatID;
  }



  private List<StringKeyValue> listOfValuesForTipusOperacioFirma;

  public List<StringKeyValue> getListOfValuesForTipusOperacioFirma() {
    return this.listOfValuesForTipusOperacioFirma;
  }

  public void setListOfValuesForTipusOperacioFirma(List<StringKeyValue> listOfValuesForTipusOperacioFirma) {
    this.listOfValuesForTipusOperacioFirma = listOfValuesForTipusOperacioFirma;
  }



  private List<StringKeyValue> listOfValuesForTipusFirmaID;

  public List<StringKeyValue> getListOfValuesForTipusFirmaID() {
    return this.listOfValuesForTipusFirmaID;
  }

  public void setListOfValuesForTipusFirmaID(List<StringKeyValue> listOfValuesForTipusFirmaID) {
    this.listOfValuesForTipusFirmaID = listOfValuesForTipusFirmaID;
  }



  private List<StringKeyValue> listOfValuesForAlgorismeDeFirmaID;

  public List<StringKeyValue> getListOfValuesForAlgorismeDeFirmaID() {
    return this.listOfValuesForAlgorismeDeFirmaID;
  }

  public void setListOfValuesForAlgorismeDeFirmaID(List<StringKeyValue> listOfValuesForAlgorismeDeFirmaID) {
    this.listOfValuesForAlgorismeDeFirmaID = listOfValuesForAlgorismeDeFirmaID;
  }



  private List<StringKeyValue> listOfValuesForUsPoliticaDeFirma;

  public List<StringKeyValue> getListOfValuesForUsPoliticaDeFirma() {
    return this.listOfValuesForUsPoliticaDeFirma;
  }

  public void setListOfValuesForUsPoliticaDeFirma(List<StringKeyValue> listOfValuesForUsPoliticaDeFirma) {
    this.listOfValuesForUsPoliticaDeFirma = listOfValuesForUsPoliticaDeFirma;
  }



  private List<StringKeyValue> listOfValuesForPosicioTaulaFirmesID;

  public List<StringKeyValue> getListOfValuesForPosicioTaulaFirmesID() {
    return this.listOfValuesForPosicioTaulaFirmesID;
  }

  public void setListOfValuesForPosicioTaulaFirmesID(List<StringKeyValue> listOfValuesForPosicioTaulaFirmesID) {
    this.listOfValuesForPosicioTaulaFirmesID = listOfValuesForPosicioTaulaFirmesID;
  }



  private List<StringKeyValue> listOfTraduccioForFirmatPerFormatID;

  public List<StringKeyValue> getListOfTraduccioForFirmatPerFormatID() {
    return this.listOfTraduccioForFirmatPerFormatID;
  }

  public void setListOfTraduccioForFirmatPerFormatID(List<StringKeyValue> listOfTraduccioForFirmatPerFormatID) {
    this.listOfTraduccioForFirmatPerFormatID = listOfTraduccioForFirmatPerFormatID;
  }



  private List<StringKeyValue> listOfTraduccioForMotiuDelegacioID;

  public List<StringKeyValue> getListOfTraduccioForMotiuDelegacioID() {
    return this.listOfTraduccioForMotiuDelegacioID;
  }

  public void setListOfTraduccioForMotiuDelegacioID(List<StringKeyValue> listOfTraduccioForMotiuDelegacioID) {
    this.listOfTraduccioForMotiuDelegacioID = listOfTraduccioForMotiuDelegacioID;
  }



  
} // Final de Classe 
