package es.caib.digitalib.back.form.webdb;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import es.caib.digitalib.back.form.DigitalIBBaseForm;
import es.caib.digitalib.jpa.TransaccioMultipleJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class TransaccioMultipleForm extends DigitalIBBaseForm {
  
  private TransaccioMultipleJPA transaccioMultiple;
  
  
  private CommonsMultipartFile fitxerEscanejatID;
  private boolean fitxerEscanejatIDDelete;
  
  public TransaccioMultipleForm() {
  }
  
  public TransaccioMultipleForm(TransaccioMultipleForm __toClone) {
    super(__toClone);
      this.transaccioMultiple = __toClone.transaccioMultiple;
  }
  
  public TransaccioMultipleForm(TransaccioMultipleJPA transaccioMultiple, boolean nou) {
    super(nou);
    this.transaccioMultiple = transaccioMultiple;
  }
  
  public TransaccioMultipleJPA getTransaccioMultiple() {
    return transaccioMultiple;
  }
  public void setTransaccioMultiple(TransaccioMultipleJPA transaccioMultiple) {
    this.transaccioMultiple = transaccioMultiple;
  }
  
  
  public CommonsMultipartFile getFitxerEscanejatID() {
    return fitxerEscanejatID;
  }
  
   public void setFitxerEscanejatID(CommonsMultipartFile fitxerEscanejatID) {
    this.fitxerEscanejatID = fitxerEscanejatID;
  }
  public boolean isFitxerEscanejatIDDelete() {
    return fitxerEscanejatIDDelete;
  }
  
  public void setFitxerEscanejatIDDelete(boolean fitxerEscanejatIDDelete) {
    this.fitxerEscanejatIDDelete = fitxerEscanejatIDDelete;
   }
  
} // Final de Classe 
