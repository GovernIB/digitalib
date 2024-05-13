/*
 * API REST INTERNA de DigitalIB - ApiMassiveScanWebSimple
 * Conjunt de Serveis REST de DigitalIB per la realització remota d'escanejos
 *
 * The version of the OpenAPI document: 1.0-SNAPSHOT
 * Contact: otae@fundaciobit.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * MassiveScanWebSimpleFile
 */
@JsonPropertyOrder({
  MassiveScanWebSimpleFile.JSON_PROPERTY_NOM,
  MassiveScanWebSimpleFile.JSON_PROPERTY_MIME,
  MassiveScanWebSimpleFile.JSON_PROPERTY_DATA
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MassiveScanWebSimpleFile {
  public static final String JSON_PROPERTY_NOM = "nom";
  private String nom;

  public static final String JSON_PROPERTY_MIME = "mime";
  private String mime;

  public static final String JSON_PROPERTY_DATA = "data";
  private byte[] data;

  public MassiveScanWebSimpleFile() {
  }

  public MassiveScanWebSimpleFile nom(String nom) {
    
    this.nom = nom;
    return this;
  }

   /**
   * Get nom
   * @return nom
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNom() {
    return nom;
  }


  @JsonProperty(JSON_PROPERTY_NOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNom(String nom) {
    this.nom = nom;
  }


  public MassiveScanWebSimpleFile mime(String mime) {
    
    this.mime = mime;
    return this;
  }

   /**
   * Get mime
   * @return mime
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMime() {
    return mime;
  }


  @JsonProperty(JSON_PROPERTY_MIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMime(String mime) {
    this.mime = mime;
  }


  public MassiveScanWebSimpleFile data(byte[] data) {
    
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public byte[] getData() {
    return data;
  }


  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setData(byte[] data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MassiveScanWebSimpleFile massiveScanWebSimpleFile = (MassiveScanWebSimpleFile) o;
    return Objects.equals(this.nom, massiveScanWebSimpleFile.nom) &&
        Objects.equals(this.mime, massiveScanWebSimpleFile.mime) &&
        Arrays.equals(this.data, massiveScanWebSimpleFile.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nom, mime, Arrays.hashCode(data));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MassiveScanWebSimpleFile {\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    mime: ").append(toIndentedString(mime)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

