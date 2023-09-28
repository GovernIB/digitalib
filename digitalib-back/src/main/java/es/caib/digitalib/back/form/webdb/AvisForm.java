package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.persistence.AvisJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class AvisForm extends DigitalIBBaseForm {
  
  private AvisJPA avis;
  
  public AvisForm() {
  }
  
  public AvisForm(AvisForm __toClone) {
    super(__toClone);
      this.avis = __toClone.avis;
    this.listOfTraduccioForDescripcioID = __toClone.listOfTraduccioForDescripcioID;
    this.listOfValuesForTipus = __toClone.listOfValuesForTipus;
    this.listOfConfiguracioGrupForConfigGrupID = __toClone.listOfConfiguracioGrupForConfigGrupID;
  }
  
  public AvisForm(AvisJPA avis, boolean nou) {
    super(nou);
    this.avis = avis;
  }
  
  public AvisJPA getAvis() {
    return avis;
  }
  public void setAvis(AvisJPA avis) {
    this.avis = avis;
  }
  
  java.util.List<es.caib.digitalib.model.entity.Idioma> idiomesTraduccio = null;

  public java.util.List<es.caib.digitalib.model.entity.Idioma> getIdiomesTraduccio() {
    return idiomesTraduccio;
  }

  public void setIdiomesTraduccio(java.util.List<es.caib.digitalib.model.entity.Idioma> idiomesTraduccio) {
    this.idiomesTraduccio = idiomesTraduccio;
  }
  
  private List<StringKeyValue> listOfTraduccioForDescripcioID;

  public List<StringKeyValue> getListOfTraduccioForDescripcioID() {
    return this.listOfTraduccioForDescripcioID;
  }

  public void setListOfTraduccioForDescripcioID(List<StringKeyValue> listOfTraduccioForDescripcioID) {
    this.listOfTraduccioForDescripcioID = listOfTraduccioForDescripcioID;
  }



  private List<StringKeyValue> listOfValuesForTipus;

  public List<StringKeyValue> getListOfValuesForTipus() {
    return this.listOfValuesForTipus;
  }

  public void setListOfValuesForTipus(List<StringKeyValue> listOfValuesForTipus) {
    this.listOfValuesForTipus = listOfValuesForTipus;
  }



  private List<StringKeyValue> listOfConfiguracioGrupForConfigGrupID;

  public List<StringKeyValue> getListOfConfiguracioGrupForConfigGrupID() {
    return this.listOfConfiguracioGrupForConfigGrupID;
  }

  public void setListOfConfiguracioGrupForConfigGrupID(List<StringKeyValue> listOfConfiguracioGrupForConfigGrupID) {
    this.listOfConfiguracioGrupForConfigGrupID = listOfConfiguracioGrupForConfigGrupID;
  }



  
} // Final de Classe 
