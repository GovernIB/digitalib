package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.persistence.ConfiguracioGrupJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class ConfiguracioGrupForm extends DigitalIBBaseForm {
  
  private ConfiguracioGrupJPA configuracioGrup;
  
  
  private CommonsMultipartFile logoHeaderID;
  private boolean logoHeaderIDDelete;
  
  
  private CommonsMultipartFile logoFooterID;
  private boolean logoFooterIDDelete;
  
  public ConfiguracioGrupForm() {
  }
  
  public ConfiguracioGrupForm(ConfiguracioGrupForm __toClone) {
    super(__toClone);
      this.configuracioGrup = __toClone.configuracioGrup;
    this.listOfPerfilForPerfilNomesEscaneigID = __toClone.listOfPerfilForPerfilNomesEscaneigID;
    this.listOfPerfilForPerfilNomesEscaneig2ID = __toClone.listOfPerfilForPerfilNomesEscaneig2ID;
    this.listOfPerfilForPerfilCopiaAutenticaID = __toClone.listOfPerfilForPerfilCopiaAutenticaID;
    this.listOfPerfilForPerfilCopiaAutentica2ID = __toClone.listOfPerfilForPerfilCopiaAutentica2ID;
    this.listOfPerfilForPerfilCustodiaID = __toClone.listOfPerfilForPerfilCustodiaID;
    this.listOfPerfilForPerfilCustodia2ID = __toClone.listOfPerfilForPerfilCustodia2ID;
  }
  
  public ConfiguracioGrupForm(ConfiguracioGrupJPA configuracioGrup, boolean nou) {
    super(nou);
    this.configuracioGrup = configuracioGrup;
  }
  
  public ConfiguracioGrupJPA getConfiguracioGrup() {
    return configuracioGrup;
  }
  public void setConfiguracioGrup(ConfiguracioGrupJPA configuracioGrup) {
    this.configuracioGrup = configuracioGrup;
  }
  
  
  public CommonsMultipartFile getLogoHeaderID() {
    return logoHeaderID;
  }
  
   public void setLogoHeaderID(CommonsMultipartFile logoHeaderID) {
    this.logoHeaderID = logoHeaderID;
  }
  public boolean isLogoHeaderIDDelete() {
    return logoHeaderIDDelete;
  }
  
  public void setLogoHeaderIDDelete(boolean logoHeaderIDDelete) {
    this.logoHeaderIDDelete = logoHeaderIDDelete;
   }
  public CommonsMultipartFile getLogoFooterID() {
    return logoFooterID;
  }
  
   public void setLogoFooterID(CommonsMultipartFile logoFooterID) {
    this.logoFooterID = logoFooterID;
  }
  public boolean isLogoFooterIDDelete() {
    return logoFooterIDDelete;
  }
  
  public void setLogoFooterIDDelete(boolean logoFooterIDDelete) {
    this.logoFooterIDDelete = logoFooterIDDelete;
   }
  private List<StringKeyValue> listOfPerfilForPerfilNomesEscaneigID;

  public List<StringKeyValue> getListOfPerfilForPerfilNomesEscaneigID() {
    return this.listOfPerfilForPerfilNomesEscaneigID;
  }

  public void setListOfPerfilForPerfilNomesEscaneigID(List<StringKeyValue> listOfPerfilForPerfilNomesEscaneigID) {
    this.listOfPerfilForPerfilNomesEscaneigID = listOfPerfilForPerfilNomesEscaneigID;
  }



  private List<StringKeyValue> listOfPerfilForPerfilNomesEscaneig2ID;

  public List<StringKeyValue> getListOfPerfilForPerfilNomesEscaneig2ID() {
    return this.listOfPerfilForPerfilNomesEscaneig2ID;
  }

  public void setListOfPerfilForPerfilNomesEscaneig2ID(List<StringKeyValue> listOfPerfilForPerfilNomesEscaneig2ID) {
    this.listOfPerfilForPerfilNomesEscaneig2ID = listOfPerfilForPerfilNomesEscaneig2ID;
  }



  private List<StringKeyValue> listOfPerfilForPerfilCopiaAutenticaID;

  public List<StringKeyValue> getListOfPerfilForPerfilCopiaAutenticaID() {
    return this.listOfPerfilForPerfilCopiaAutenticaID;
  }

  public void setListOfPerfilForPerfilCopiaAutenticaID(List<StringKeyValue> listOfPerfilForPerfilCopiaAutenticaID) {
    this.listOfPerfilForPerfilCopiaAutenticaID = listOfPerfilForPerfilCopiaAutenticaID;
  }



  private List<StringKeyValue> listOfPerfilForPerfilCopiaAutentica2ID;

  public List<StringKeyValue> getListOfPerfilForPerfilCopiaAutentica2ID() {
    return this.listOfPerfilForPerfilCopiaAutentica2ID;
  }

  public void setListOfPerfilForPerfilCopiaAutentica2ID(List<StringKeyValue> listOfPerfilForPerfilCopiaAutentica2ID) {
    this.listOfPerfilForPerfilCopiaAutentica2ID = listOfPerfilForPerfilCopiaAutentica2ID;
  }



  private List<StringKeyValue> listOfPerfilForPerfilCustodiaID;

  public List<StringKeyValue> getListOfPerfilForPerfilCustodiaID() {
    return this.listOfPerfilForPerfilCustodiaID;
  }

  public void setListOfPerfilForPerfilCustodiaID(List<StringKeyValue> listOfPerfilForPerfilCustodiaID) {
    this.listOfPerfilForPerfilCustodiaID = listOfPerfilForPerfilCustodiaID;
  }



  private List<StringKeyValue> listOfPerfilForPerfilCustodia2ID;

  public List<StringKeyValue> getListOfPerfilForPerfilCustodia2ID() {
    return this.listOfPerfilForPerfilCustodia2ID;
  }

  public void setListOfPerfilForPerfilCustodia2ID(List<StringKeyValue> listOfPerfilForPerfilCustodia2ID) {
    this.listOfPerfilForPerfilCustodia2ID = listOfPerfilForPerfilCustodia2ID;
  }



  
} // Final de Classe 
