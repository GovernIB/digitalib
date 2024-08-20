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
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleKeyValue;
import es.caib.digitalib.api.interna.client.apimassivescanwebsimple.v1.model.MassiveScanWebSimpleValidationInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * MassiveScanWebSimpleSignedFileInfo
 */
@JsonPropertyOrder({
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_SIGN_OPERATION,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_SIGN_TYPE,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_SIGN_ALGORITHM,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_SIGN_MODE,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_SIGNATURES_TABLE_LOCATION,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_TIME_STAMP_INCLUDED,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_POLICY_INCLUDED,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_ENI_TIPO_FIRMA,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_ENI_PERFIL_FIRMA,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_ENI_ROL_FIRMA,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_ENI_SIGNER_NAME,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_ENI_SIGNER_ADMINISTRATION_ID,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_ENI_SIGN_LEVEL,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_VALIDATION_INFO,
  MassiveScanWebSimpleSignedFileInfo.JSON_PROPERTY_ADDITION_INFORMATION
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MassiveScanWebSimpleSignedFileInfo {
  public static final String JSON_PROPERTY_SIGN_OPERATION = "signOperation";
  private Integer signOperation;

  public static final String JSON_PROPERTY_SIGN_TYPE = "signType";
  private String signType;

  public static final String JSON_PROPERTY_SIGN_ALGORITHM = "signAlgorithm";
  private String signAlgorithm;

  public static final String JSON_PROPERTY_SIGN_MODE = "signMode";
  private Integer signMode;

  public static final String JSON_PROPERTY_SIGNATURES_TABLE_LOCATION = "signaturesTableLocation";
  private Integer signaturesTableLocation;

  public static final String JSON_PROPERTY_TIME_STAMP_INCLUDED = "timeStampIncluded";
  private Boolean timeStampIncluded;

  public static final String JSON_PROPERTY_POLICY_INCLUDED = "policyIncluded";
  private Boolean policyIncluded;

  public static final String JSON_PROPERTY_ENI_TIPO_FIRMA = "eniTipoFirma";
  private String eniTipoFirma;

  public static final String JSON_PROPERTY_ENI_PERFIL_FIRMA = "eniPerfilFirma";
  private String eniPerfilFirma;

  public static final String JSON_PROPERTY_ENI_ROL_FIRMA = "eniRolFirma";
  private String eniRolFirma;

  public static final String JSON_PROPERTY_ENI_SIGNER_NAME = "eniSignerName";
  private String eniSignerName;

  public static final String JSON_PROPERTY_ENI_SIGNER_ADMINISTRATION_ID = "eniSignerAdministrationId";
  private String eniSignerAdministrationId;

  public static final String JSON_PROPERTY_ENI_SIGN_LEVEL = "eniSignLevel";
  private String eniSignLevel;

  public static final String JSON_PROPERTY_VALIDATION_INFO = "validationInfo";
  private MassiveScanWebSimpleValidationInfo validationInfo;

  public static final String JSON_PROPERTY_ADDITION_INFORMATION = "additionInformation";
  private List<MassiveScanWebSimpleKeyValue> additionInformation;

  public MassiveScanWebSimpleSignedFileInfo() {
  }

  public MassiveScanWebSimpleSignedFileInfo signOperation(Integer signOperation) {
    
    this.signOperation = signOperation;
    return this;
  }

   /**
   * Get signOperation
   * @return signOperation
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIGN_OPERATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getSignOperation() {
    return signOperation;
  }


  @JsonProperty(JSON_PROPERTY_SIGN_OPERATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSignOperation(Integer signOperation) {
    this.signOperation = signOperation;
  }


  public MassiveScanWebSimpleSignedFileInfo signType(String signType) {
    
    this.signType = signType;
    return this;
  }

   /**
   * Get signType
   * @return signType
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIGN_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSignType() {
    return signType;
  }


  @JsonProperty(JSON_PROPERTY_SIGN_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSignType(String signType) {
    this.signType = signType;
  }


  public MassiveScanWebSimpleSignedFileInfo signAlgorithm(String signAlgorithm) {
    
    this.signAlgorithm = signAlgorithm;
    return this;
  }

   /**
   * Get signAlgorithm
   * @return signAlgorithm
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIGN_ALGORITHM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSignAlgorithm() {
    return signAlgorithm;
  }


  @JsonProperty(JSON_PROPERTY_SIGN_ALGORITHM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSignAlgorithm(String signAlgorithm) {
    this.signAlgorithm = signAlgorithm;
  }


  public MassiveScanWebSimpleSignedFileInfo signMode(Integer signMode) {
    
    this.signMode = signMode;
    return this;
  }

   /**
   * Get signMode
   * @return signMode
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIGN_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getSignMode() {
    return signMode;
  }


  @JsonProperty(JSON_PROPERTY_SIGN_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSignMode(Integer signMode) {
    this.signMode = signMode;
  }


  public MassiveScanWebSimpleSignedFileInfo signaturesTableLocation(Integer signaturesTableLocation) {
    
    this.signaturesTableLocation = signaturesTableLocation;
    return this;
  }

   /**
   * Get signaturesTableLocation
   * @return signaturesTableLocation
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIGNATURES_TABLE_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getSignaturesTableLocation() {
    return signaturesTableLocation;
  }


  @JsonProperty(JSON_PROPERTY_SIGNATURES_TABLE_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSignaturesTableLocation(Integer signaturesTableLocation) {
    this.signaturesTableLocation = signaturesTableLocation;
  }


  public MassiveScanWebSimpleSignedFileInfo timeStampIncluded(Boolean timeStampIncluded) {
    
    this.timeStampIncluded = timeStampIncluded;
    return this;
  }

   /**
   * Get timeStampIncluded
   * @return timeStampIncluded
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TIME_STAMP_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isTimeStampIncluded() {
    return timeStampIncluded;
  }


  @JsonProperty(JSON_PROPERTY_TIME_STAMP_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimeStampIncluded(Boolean timeStampIncluded) {
    this.timeStampIncluded = timeStampIncluded;
  }


  public MassiveScanWebSimpleSignedFileInfo policyIncluded(Boolean policyIncluded) {
    
    this.policyIncluded = policyIncluded;
    return this;
  }

   /**
   * Get policyIncluded
   * @return policyIncluded
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_POLICY_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isPolicyIncluded() {
    return policyIncluded;
  }


  @JsonProperty(JSON_PROPERTY_POLICY_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPolicyIncluded(Boolean policyIncluded) {
    this.policyIncluded = policyIncluded;
  }


  public MassiveScanWebSimpleSignedFileInfo eniTipoFirma(String eniTipoFirma) {
    
    this.eniTipoFirma = eniTipoFirma;
    return this;
  }

   /**
   * Get eniTipoFirma
   * @return eniTipoFirma
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENI_TIPO_FIRMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEniTipoFirma() {
    return eniTipoFirma;
  }


  @JsonProperty(JSON_PROPERTY_ENI_TIPO_FIRMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEniTipoFirma(String eniTipoFirma) {
    this.eniTipoFirma = eniTipoFirma;
  }


  public MassiveScanWebSimpleSignedFileInfo eniPerfilFirma(String eniPerfilFirma) {
    
    this.eniPerfilFirma = eniPerfilFirma;
    return this;
  }

   /**
   * Get eniPerfilFirma
   * @return eniPerfilFirma
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENI_PERFIL_FIRMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEniPerfilFirma() {
    return eniPerfilFirma;
  }


  @JsonProperty(JSON_PROPERTY_ENI_PERFIL_FIRMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEniPerfilFirma(String eniPerfilFirma) {
    this.eniPerfilFirma = eniPerfilFirma;
  }


  public MassiveScanWebSimpleSignedFileInfo eniRolFirma(String eniRolFirma) {
    
    this.eniRolFirma = eniRolFirma;
    return this;
  }

   /**
   * Get eniRolFirma
   * @return eniRolFirma
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENI_ROL_FIRMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEniRolFirma() {
    return eniRolFirma;
  }


  @JsonProperty(JSON_PROPERTY_ENI_ROL_FIRMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEniRolFirma(String eniRolFirma) {
    this.eniRolFirma = eniRolFirma;
  }


  public MassiveScanWebSimpleSignedFileInfo eniSignerName(String eniSignerName) {
    
    this.eniSignerName = eniSignerName;
    return this;
  }

   /**
   * Get eniSignerName
   * @return eniSignerName
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENI_SIGNER_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEniSignerName() {
    return eniSignerName;
  }


  @JsonProperty(JSON_PROPERTY_ENI_SIGNER_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEniSignerName(String eniSignerName) {
    this.eniSignerName = eniSignerName;
  }


  public MassiveScanWebSimpleSignedFileInfo eniSignerAdministrationId(String eniSignerAdministrationId) {
    
    this.eniSignerAdministrationId = eniSignerAdministrationId;
    return this;
  }

   /**
   * Get eniSignerAdministrationId
   * @return eniSignerAdministrationId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENI_SIGNER_ADMINISTRATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEniSignerAdministrationId() {
    return eniSignerAdministrationId;
  }


  @JsonProperty(JSON_PROPERTY_ENI_SIGNER_ADMINISTRATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEniSignerAdministrationId(String eniSignerAdministrationId) {
    this.eniSignerAdministrationId = eniSignerAdministrationId;
  }


  public MassiveScanWebSimpleSignedFileInfo eniSignLevel(String eniSignLevel) {
    
    this.eniSignLevel = eniSignLevel;
    return this;
  }

   /**
   * Get eniSignLevel
   * @return eniSignLevel
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENI_SIGN_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEniSignLevel() {
    return eniSignLevel;
  }


  @JsonProperty(JSON_PROPERTY_ENI_SIGN_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEniSignLevel(String eniSignLevel) {
    this.eniSignLevel = eniSignLevel;
  }


  public MassiveScanWebSimpleSignedFileInfo validationInfo(MassiveScanWebSimpleValidationInfo validationInfo) {
    
    this.validationInfo = validationInfo;
    return this;
  }

   /**
   * Get validationInfo
   * @return validationInfo
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VALIDATION_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MassiveScanWebSimpleValidationInfo getValidationInfo() {
    return validationInfo;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATION_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValidationInfo(MassiveScanWebSimpleValidationInfo validationInfo) {
    this.validationInfo = validationInfo;
  }


  public MassiveScanWebSimpleSignedFileInfo additionInformation(List<MassiveScanWebSimpleKeyValue> additionInformation) {
    
    this.additionInformation = additionInformation;
    return this;
  }

  public MassiveScanWebSimpleSignedFileInfo addAdditionInformationItem(MassiveScanWebSimpleKeyValue additionInformationItem) {
    if (this.additionInformation == null) {
      this.additionInformation = new ArrayList<>();
    }
    this.additionInformation.add(additionInformationItem);
    return this;
  }

   /**
   * Get additionInformation
   * @return additionInformation
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDITION_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<MassiveScanWebSimpleKeyValue> getAdditionInformation() {
    return additionInformation;
  }


  @JsonProperty(JSON_PROPERTY_ADDITION_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdditionInformation(List<MassiveScanWebSimpleKeyValue> additionInformation) {
    this.additionInformation = additionInformation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MassiveScanWebSimpleSignedFileInfo massiveScanWebSimpleSignedFileInfo = (MassiveScanWebSimpleSignedFileInfo) o;
    return Objects.equals(this.signOperation, massiveScanWebSimpleSignedFileInfo.signOperation) &&
        Objects.equals(this.signType, massiveScanWebSimpleSignedFileInfo.signType) &&
        Objects.equals(this.signAlgorithm, massiveScanWebSimpleSignedFileInfo.signAlgorithm) &&
        Objects.equals(this.signMode, massiveScanWebSimpleSignedFileInfo.signMode) &&
        Objects.equals(this.signaturesTableLocation, massiveScanWebSimpleSignedFileInfo.signaturesTableLocation) &&
        Objects.equals(this.timeStampIncluded, massiveScanWebSimpleSignedFileInfo.timeStampIncluded) &&
        Objects.equals(this.policyIncluded, massiveScanWebSimpleSignedFileInfo.policyIncluded) &&
        Objects.equals(this.eniTipoFirma, massiveScanWebSimpleSignedFileInfo.eniTipoFirma) &&
        Objects.equals(this.eniPerfilFirma, massiveScanWebSimpleSignedFileInfo.eniPerfilFirma) &&
        Objects.equals(this.eniRolFirma, massiveScanWebSimpleSignedFileInfo.eniRolFirma) &&
        Objects.equals(this.eniSignerName, massiveScanWebSimpleSignedFileInfo.eniSignerName) &&
        Objects.equals(this.eniSignerAdministrationId, massiveScanWebSimpleSignedFileInfo.eniSignerAdministrationId) &&
        Objects.equals(this.eniSignLevel, massiveScanWebSimpleSignedFileInfo.eniSignLevel) &&
        Objects.equals(this.validationInfo, massiveScanWebSimpleSignedFileInfo.validationInfo) &&
        Objects.equals(this.additionInformation, massiveScanWebSimpleSignedFileInfo.additionInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signOperation, signType, signAlgorithm, signMode, signaturesTableLocation, timeStampIncluded, policyIncluded, eniTipoFirma, eniPerfilFirma, eniRolFirma, eniSignerName, eniSignerAdministrationId, eniSignLevel, validationInfo, additionInformation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MassiveScanWebSimpleSignedFileInfo {\n");
    sb.append("    signOperation: ").append(toIndentedString(signOperation)).append("\n");
    sb.append("    signType: ").append(toIndentedString(signType)).append("\n");
    sb.append("    signAlgorithm: ").append(toIndentedString(signAlgorithm)).append("\n");
    sb.append("    signMode: ").append(toIndentedString(signMode)).append("\n");
    sb.append("    signaturesTableLocation: ").append(toIndentedString(signaturesTableLocation)).append("\n");
    sb.append("    timeStampIncluded: ").append(toIndentedString(timeStampIncluded)).append("\n");
    sb.append("    policyIncluded: ").append(toIndentedString(policyIncluded)).append("\n");
    sb.append("    eniTipoFirma: ").append(toIndentedString(eniTipoFirma)).append("\n");
    sb.append("    eniPerfilFirma: ").append(toIndentedString(eniPerfilFirma)).append("\n");
    sb.append("    eniRolFirma: ").append(toIndentedString(eniRolFirma)).append("\n");
    sb.append("    eniSignerName: ").append(toIndentedString(eniSignerName)).append("\n");
    sb.append("    eniSignerAdministrationId: ").append(toIndentedString(eniSignerAdministrationId)).append("\n");
    sb.append("    eniSignLevel: ").append(toIndentedString(eniSignLevel)).append("\n");
    sb.append("    validationInfo: ").append(toIndentedString(validationInfo)).append("\n");
    sb.append("    additionInformation: ").append(toIndentedString(additionInformation)).append("\n");
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
