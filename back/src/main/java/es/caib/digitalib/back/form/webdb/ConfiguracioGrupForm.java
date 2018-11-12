package es.caib.digitalib.back.form.webdb;

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
  
} // Final de Classe 
