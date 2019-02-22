package org.fundaciobit.apisib.apiscanwebsimple.v1.beans;

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


  protected String languageDoc;


  protected String funcionariNom;


  protected String funcionariNif;

  public ScanWebSimpleSignatureParameters() {
    super();
  }

  public ScanWebSimpleSignatureParameters(String languageDoc, String funcionariNom,
      String funcionariNif) {
    super();
    this.languageDoc = languageDoc;
    this.funcionariNom = funcionariNom;
    this.funcionariNif = funcionariNif;
  }

  public String getLanguageDoc() {
    return languageDoc;
  }

  public void setLanguageDoc(String languageDoc) {
    this.languageDoc = languageDoc;
  }

  public String getFuncionariNom() {
    return funcionariNom;
  }

  public void setFuncionariNom(String funcionariNom) {
    this.funcionariNom = funcionariNom;
  }

  public String getFuncionariNif() {
    return funcionariNif;
  }

  public void setFuncionariNif(String funcionariNif) {
    this.funcionariNif = funcionariNif;
  }

}
