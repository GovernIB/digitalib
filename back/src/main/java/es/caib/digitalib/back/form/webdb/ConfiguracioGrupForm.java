package es.caib.digitalib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.ConfiguracioGrupJPA;

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
    this.listOfPerfilForPerfilCopiaAutenticaID = __toClone.listOfPerfilForPerfilCopiaAutenticaID;
    this.listOfPerfilForPerfilCustodiaID = __toClone.listOfPerfilForPerfilCustodiaID;
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



  private List<StringKeyValue> listOfPerfilForPerfilCopiaAutenticaID;

  public List<StringKeyValue> getListOfPerfilForPerfilCopiaAutenticaID() {
    return this.listOfPerfilForPerfilCopiaAutenticaID;
  }

  public void setListOfPerfilForPerfilCopiaAutenticaID(List<StringKeyValue> listOfPerfilForPerfilCopiaAutenticaID) {
    this.listOfPerfilForPerfilCopiaAutenticaID = listOfPerfilForPerfilCopiaAutenticaID;
  }



  private List<StringKeyValue> listOfPerfilForPerfilCustodiaID;

  public List<StringKeyValue> getListOfPerfilForPerfilCustodiaID() {
    return this.listOfPerfilForPerfilCustodiaID;
  }

  public void setListOfPerfilForPerfilCustodiaID(List<StringKeyValue> listOfPerfilForPerfilCustodiaID) {
    this.listOfPerfilForPerfilCustodiaID = listOfPerfilForPerfilCustodiaID;
  }



  
} // Final de Classe 
