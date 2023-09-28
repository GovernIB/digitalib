
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.InfoCustody;


public class InfoCustodyBean implements InfoCustody {



	long infoCustodyID;// PK
	java.lang.String custodyId;
	java.lang.String arxiuExpedientId;
	java.lang.String arxiuDocumentId;
	java.lang.String csv;
	java.lang.String originalFileUrl;
	java.lang.String csvValidationWeb;
	java.lang.String csvGenerationDefinition;
	java.lang.String printableFileUrl;
	java.lang.String eniFileUrl;
	java.lang.String validationFileUrl;


  /** Constructor Buit */
  public InfoCustodyBean() {
  }

  /** Constructor amb tots els camps  */
  public InfoCustodyBean(long infoCustodyID , java.lang.String custodyId , java.lang.String arxiuExpedientId , java.lang.String arxiuDocumentId , java.lang.String csv , java.lang.String originalFileUrl , java.lang.String csvValidationWeb , java.lang.String csvGenerationDefinition , java.lang.String printableFileUrl , java.lang.String eniFileUrl , java.lang.String validationFileUrl) {
    this.infoCustodyID=infoCustodyID;
    this.custodyId=custodyId;
    this.arxiuExpedientId=arxiuExpedientId;
    this.arxiuDocumentId=arxiuDocumentId;
    this.csv=csv;
    this.originalFileUrl=originalFileUrl;
    this.csvValidationWeb=csvValidationWeb;
    this.csvGenerationDefinition=csvGenerationDefinition;
    this.printableFileUrl=printableFileUrl;
    this.eniFileUrl=eniFileUrl;
    this.validationFileUrl=validationFileUrl;
}
  /** Constructor sense valors autoincrementals */
  public InfoCustodyBean(java.lang.String custodyId , java.lang.String arxiuExpedientId , java.lang.String arxiuDocumentId , java.lang.String csv , java.lang.String originalFileUrl , java.lang.String csvValidationWeb , java.lang.String csvGenerationDefinition , java.lang.String printableFileUrl , java.lang.String eniFileUrl , java.lang.String validationFileUrl) {
    this.custodyId=custodyId;
    this.arxiuExpedientId=arxiuExpedientId;
    this.arxiuDocumentId=arxiuDocumentId;
    this.csv=csv;
    this.originalFileUrl=originalFileUrl;
    this.csvValidationWeb=csvValidationWeb;
    this.csvGenerationDefinition=csvGenerationDefinition;
    this.printableFileUrl=printableFileUrl;
    this.eniFileUrl=eniFileUrl;
    this.validationFileUrl=validationFileUrl;
}
  /** Constructor dels valors Not Null */
  public InfoCustodyBean(long infoCustodyID) {
    this.infoCustodyID=infoCustodyID;
}
  public InfoCustodyBean(InfoCustody __bean) {
    this.setInfoCustodyID(__bean.getInfoCustodyID());
    this.setCustodyId(__bean.getCustodyId());
    this.setArxiuExpedientId(__bean.getArxiuExpedientId());
    this.setArxiuDocumentId(__bean.getArxiuDocumentId());
    this.setCsv(__bean.getCsv());
    this.setOriginalFileUrl(__bean.getOriginalFileUrl());
    this.setCsvValidationWeb(__bean.getCsvValidationWeb());
    this.setCsvGenerationDefinition(__bean.getCsvGenerationDefinition());
    this.setPrintableFileUrl(__bean.getPrintableFileUrl());
    this.setEniFileUrl(__bean.getEniFileUrl());
    this.setValidationFileUrl(__bean.getValidationFileUrl());
	}

	public long getInfoCustodyID() {
		return(infoCustodyID);
	};
	public void setInfoCustodyID(long _infoCustodyID_) {
		this.infoCustodyID = _infoCustodyID_;
	};

	public java.lang.String getCustodyId() {
		return(custodyId);
	};
	public void setCustodyId(java.lang.String _custodyId_) {
		this.custodyId = _custodyId_;
	};

	public java.lang.String getArxiuExpedientId() {
		return(arxiuExpedientId);
	};
	public void setArxiuExpedientId(java.lang.String _arxiuExpedientId_) {
		this.arxiuExpedientId = _arxiuExpedientId_;
	};

	public java.lang.String getArxiuDocumentId() {
		return(arxiuDocumentId);
	};
	public void setArxiuDocumentId(java.lang.String _arxiuDocumentId_) {
		this.arxiuDocumentId = _arxiuDocumentId_;
	};

	public java.lang.String getCsv() {
		return(csv);
	};
	public void setCsv(java.lang.String _csv_) {
		this.csv = _csv_;
	};

	public java.lang.String getOriginalFileUrl() {
		return(originalFileUrl);
	};
	public void setOriginalFileUrl(java.lang.String _originalFileUrl_) {
		this.originalFileUrl = _originalFileUrl_;
	};

	public java.lang.String getCsvValidationWeb() {
		return(csvValidationWeb);
	};
	public void setCsvValidationWeb(java.lang.String _csvValidationWeb_) {
		this.csvValidationWeb = _csvValidationWeb_;
	};

	public java.lang.String getCsvGenerationDefinition() {
		return(csvGenerationDefinition);
	};
	public void setCsvGenerationDefinition(java.lang.String _csvGenerationDefinition_) {
		this.csvGenerationDefinition = _csvGenerationDefinition_;
	};

	public java.lang.String getPrintableFileUrl() {
		return(printableFileUrl);
	};
	public void setPrintableFileUrl(java.lang.String _printableFileUrl_) {
		this.printableFileUrl = _printableFileUrl_;
	};

	public java.lang.String getEniFileUrl() {
		return(eniFileUrl);
	};
	public void setEniFileUrl(java.lang.String _eniFileUrl_) {
		this.eniFileUrl = _eniFileUrl_;
	};

	public java.lang.String getValidationFileUrl() {
		return(validationFileUrl);
	};
	public void setValidationFileUrl(java.lang.String _validationFileUrl_) {
		this.validationFileUrl = _validationFileUrl_;
	};



  // ======================================

  public static InfoCustodyBean toBean(InfoCustody __bean) {
    if (__bean == null) { return null;}
    InfoCustodyBean __tmp = new InfoCustodyBean();
    __tmp.setInfoCustodyID(__bean.getInfoCustodyID());
    __tmp.setCustodyId(__bean.getCustodyId());
    __tmp.setArxiuExpedientId(__bean.getArxiuExpedientId());
    __tmp.setArxiuDocumentId(__bean.getArxiuDocumentId());
    __tmp.setCsv(__bean.getCsv());
    __tmp.setOriginalFileUrl(__bean.getOriginalFileUrl());
    __tmp.setCsvValidationWeb(__bean.getCsvValidationWeb());
    __tmp.setCsvGenerationDefinition(__bean.getCsvGenerationDefinition());
    __tmp.setPrintableFileUrl(__bean.getPrintableFileUrl());
    __tmp.setEniFileUrl(__bean.getEniFileUrl());
    __tmp.setValidationFileUrl(__bean.getValidationFileUrl());
		return __tmp;
	}



}
