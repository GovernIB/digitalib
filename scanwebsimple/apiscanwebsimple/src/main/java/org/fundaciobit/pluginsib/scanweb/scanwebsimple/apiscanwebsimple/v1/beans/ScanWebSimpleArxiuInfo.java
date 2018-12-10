package org.fundaciobit.pluginsib.scanweb.scanwebsimple.apiscanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author anadal
 *
 */
@XmlRootElement
public class ScanWebSimpleArxiuInfo {

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	protected String expedientID;

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	protected String documentID;

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	protected String arxiuFileURL;

	/** eEMGDE.Firma.FormatoFirma.ValorCSV (eEMGDE17.3) */
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	protected String arxiuFileCSV;

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	protected String arxiuFileCSVValidationWeb;

	/**
	 * eEMGDE.DefinicionGeneracionCSV (eEMGDE17.4):
	 */
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	protected String arxiuFileCSVGenerationDefinition;

	public ScanWebSimpleArxiuInfo() {
		super();
	}

	public ScanWebSimpleArxiuInfo(String expedientID, String documentID,
			String arxiuFileURL, String arxiuFileCSV,
			String arxiuFileCSVValidationWeb,
			String arxiuFileCSVGenerationDefinition) {
		super();
		this.expedientID = expedientID;
		this.documentID = documentID;
		this.arxiuFileURL = arxiuFileURL;
		this.arxiuFileCSV = arxiuFileCSV;
		this.arxiuFileCSVValidationWeb = arxiuFileCSVValidationWeb;
		this.arxiuFileCSVGenerationDefinition = arxiuFileCSVGenerationDefinition;
	}

	public String getExpedientID() {
		return expedientID;
	}

	public void setExpedientID(String expedientID) {
		this.expedientID = expedientID;
	}

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public String getArxiuFileURL() {
		return arxiuFileURL;
	}

	public void setArxiuFileURL(String arxiuFileURL) {
		this.arxiuFileURL = arxiuFileURL;
	}

	public String getArxiuFileCSV() {
		return arxiuFileCSV;
	}

	public void setArxiuFileCSV(String arxiuFileCSV) {
		this.arxiuFileCSV = arxiuFileCSV;
	}

	public String getArxiuFileCSVValidationWeb() {
		return arxiuFileCSVValidationWeb;
	}

	public void setArxiuFileCSVValidationWeb(String arxiuFileCSVValidationWeb) {
		this.arxiuFileCSVValidationWeb = arxiuFileCSVValidationWeb;
	}

	public String getArxiuFileCSVGenerationDefinition() {
		return arxiuFileCSVGenerationDefinition;
	}

	public void setArxiuFileCSVGenerationDefinition(
			String arxiuFileCSVGenerationDefinition) {
		this.arxiuFileCSVGenerationDefinition = arxiuFileCSVGenerationDefinition;
	}

}
