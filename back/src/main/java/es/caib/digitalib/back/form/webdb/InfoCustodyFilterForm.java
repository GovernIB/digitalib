
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.InfoCustodyFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class InfoCustodyFilterForm extends DigitalIBBaseFilterForm implements InfoCustodyFields {

  private java.lang.Long infoCustodyIDDesde;

  public java.lang.Long getInfoCustodyIDDesde() {
    return this.infoCustodyIDDesde;
  }

  public void setInfoCustodyIDDesde(java.lang.Long infoCustodyIDDesde) {
    this.infoCustodyIDDesde = infoCustodyIDDesde;
  }


  private java.lang.Long infoCustodyIDFins;

  public java.lang.Long getInfoCustodyIDFins() {
    return this.infoCustodyIDFins;
  }

  public void setInfoCustodyIDFins(java.lang.Long infoCustodyIDFins) {
    this.infoCustodyIDFins = infoCustodyIDFins;
  }


  private java.lang.String custodyId;

  public java.lang.String getCustodyId() {
    return this.custodyId;
  }

  public void setCustodyId(java.lang.String custodyId) {
    this.custodyId = custodyId;
  }


  private java.lang.String arxiuExpedientId;

  public java.lang.String getArxiuExpedientId() {
    return this.arxiuExpedientId;
  }

  public void setArxiuExpedientId(java.lang.String arxiuExpedientId) {
    this.arxiuExpedientId = arxiuExpedientId;
  }


  private java.lang.String arxiuDocumentId;

  public java.lang.String getArxiuDocumentId() {
    return this.arxiuDocumentId;
  }

  public void setArxiuDocumentId(java.lang.String arxiuDocumentId) {
    this.arxiuDocumentId = arxiuDocumentId;
  }


  private java.lang.String fileUrl;

  public java.lang.String getFileUrl() {
    return this.fileUrl;
  }

  public void setFileUrl(java.lang.String fileUrl) {
    this.fileUrl = fileUrl;
  }


  private java.lang.String csv;

  public java.lang.String getCsv() {
    return this.csv;
  }

  public void setCsv(java.lang.String csv) {
    this.csv = csv;
  }


  private java.lang.String csvValidationWeb;

  public java.lang.String getCsvValidationWeb() {
    return this.csvValidationWeb;
  }

  public void setCsvValidationWeb(java.lang.String csvValidationWeb) {
    this.csvValidationWeb = csvValidationWeb;
  }


  private java.lang.String csvGenerationDefinition;

  public java.lang.String getCsvGenerationDefinition() {
    return this.csvGenerationDefinition;
  }

  public void setCsvGenerationDefinition(java.lang.String csvGenerationDefinition) {
    this.csvGenerationDefinition = csvGenerationDefinition;
  }


  public InfoCustodyFilterForm() {
  }
  
  public InfoCustodyFilterForm(InfoCustodyFilterForm __toClone) {
    super(__toClone);
    this.infoCustodyIDDesde = __toClone.infoCustodyIDDesde;
    this.infoCustodyIDFins = __toClone.infoCustodyIDFins;
    this.custodyId = __toClone.custodyId;
    this.arxiuExpedientId = __toClone.arxiuExpedientId;
    this.arxiuDocumentId = __toClone.arxiuDocumentId;
    this.fileUrl = __toClone.fileUrl;
    this.csv = __toClone.csv;
    this.csvValidationWeb = __toClone.csvValidationWeb;
    this.csvGenerationDefinition = __toClone.csvGenerationDefinition;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { CUSTODYID ,ARXIUEXPEDIENTID ,ARXIUDOCUMENTID }));
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

   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
