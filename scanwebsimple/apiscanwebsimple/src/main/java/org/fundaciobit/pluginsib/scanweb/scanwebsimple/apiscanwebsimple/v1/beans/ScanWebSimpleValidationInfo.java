package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
public class ScanWebSimpleValidationInfo {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected Boolean checkAdministrationIDOfSigner;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected Boolean checkDocumentModifications;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected Boolean checkValidationSignature;

  public ScanWebSimpleValidationInfo() {
    super();
  }

  public ScanWebSimpleValidationInfo(Boolean checkAdministrationIDOfSigner,
      Boolean checkDocumentModifications, Boolean checkValidationSignature) {
    super();
    this.checkAdministrationIDOfSigner = checkAdministrationIDOfSigner;
    this.checkDocumentModifications = checkDocumentModifications;
    this.checkValidationSignature = checkValidationSignature;
  }

  public Boolean getCheckAdministrationIDOfSigner() {
    return checkAdministrationIDOfSigner;
  }

  public void setCheckAdministrationIDOfSigner(Boolean checkAdministrationIDOfSigner) {
    this.checkAdministrationIDOfSigner = checkAdministrationIDOfSigner;
  }

  public Boolean getCheckDocumentModifications() {
    return checkDocumentModifications;
  }

  public void setCheckDocumentModifications(Boolean checkDocumentModifications) {
    this.checkDocumentModifications = checkDocumentModifications;
  }

  public Boolean getCheckValidationSignature() {
    return checkValidationSignature;
  }

  public void setCheckValidationSignature(Boolean checkValidationSignature) {
    this.checkValidationSignature = checkValidationSignature;
  }

}
