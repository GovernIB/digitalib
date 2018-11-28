package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ScanWebSimpleFile {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected java.lang.String nom;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected java.lang.String mime;
  
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  protected byte[] data;

  /** Constructor Buit */
  public ScanWebSimpleFile() {
  }

  /** Constructor amb tots els camps */
  public ScanWebSimpleFile(java.lang.String nom, java.lang.String mime, byte[] data) {
    this.nom = nom;
    this.mime = mime;
    this.data = data;
  }

  public java.lang.String getNom() {
    return (nom);
  };

  public void setNom(java.lang.String _nom_) {
    this.nom = _nom_;
  };

  public java.lang.String getMime() {
    return (mime);
  };

  public void setMime(java.lang.String _mime_) {
    this.mime = _mime_;
  };

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

}
