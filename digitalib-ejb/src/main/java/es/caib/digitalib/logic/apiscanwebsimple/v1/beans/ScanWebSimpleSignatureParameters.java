package es.caib.digitalib.logic.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author anadal(u80067)
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanWebSimpleSignatureParameters {

  protected String documentLanguage;

  protected String functionaryFullName = null;

  protected String functionaryAdministrationID = null;

  public ScanWebSimpleSignatureParameters() {
    super();
  }

  public ScanWebSimpleSignatureParameters(String documentLanguage, String functionaryFullName,
      String functionaryAdministrationID) {
    super();
    this.documentLanguage = documentLanguage;
    this.functionaryFullName = functionaryFullName;
    this.functionaryAdministrationID = functionaryAdministrationID;
  }

  public String getDocumentLanguage() {
    return documentLanguage;
  }

  public void setDocumentLanguage(String documentLanguage) {
    this.documentLanguage = documentLanguage;
  }

  public String getFunctionaryFullName() {
    return functionaryFullName;
  }

  public void setFunctionaryFullName(String functionaryFullName) {
    this.functionaryFullName = functionaryFullName;
  }

  public String getFunctionaryAdministrationID() {
    return functionaryAdministrationID;
  }

  public void setFunctionaryAdministrationID(String functionaryAdministrationID) {
    this.functionaryAdministrationID = functionaryAdministrationID;
  }

}
