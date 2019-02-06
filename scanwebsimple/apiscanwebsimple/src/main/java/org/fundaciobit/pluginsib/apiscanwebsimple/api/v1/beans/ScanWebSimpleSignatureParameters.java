package org.fundaciobit.pluginsib.apiscanwebsimple.api.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal(u80067)
 *
 */
@XmlRootElement
public class ScanWebSimpleSignatureParameters {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String languageDoc;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected String funcionariNom;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
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
