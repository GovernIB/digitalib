
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.InfoCustody;


public class InfoCustodyBean implements InfoCustody {



private static final long serialVersionUID = -158606413L;

	long infoCustodyID;// PK
	java.lang.String custodyFileId;
	java.lang.String arxiuExpedientId;
	java.lang.String arxiuDocumentId;
	java.lang.String fileUrl;
	java.lang.String csv;
	java.lang.String csvValidationWeb;
	java.lang.String csvGenerationDefinition;


  /** Constructor Buit */
  public InfoCustodyBean() {
  }

  /** Constructor amb tots els camps  */
  public InfoCustodyBean(long infoCustodyID , java.lang.String custodyFileId , java.lang.String arxiuExpedientId , java.lang.String arxiuDocumentId , java.lang.String fileUrl , java.lang.String csv , java.lang.String csvValidationWeb , java.lang.String csvGenerationDefinition) {
    this.infoCustodyID=infoCustodyID;
    this.custodyFileId=custodyFileId;
    this.arxiuExpedientId=arxiuExpedientId;
    this.arxiuDocumentId=arxiuDocumentId;
    this.fileUrl=fileUrl;
    this.csv=csv;
    this.csvValidationWeb=csvValidationWeb;
    this.csvGenerationDefinition=csvGenerationDefinition;
}
  /** Constructor sense valors autoincrementals */
  public InfoCustodyBean(java.lang.String custodyFileId , java.lang.String arxiuExpedientId , java.lang.String arxiuDocumentId , java.lang.String fileUrl , java.lang.String csv , java.lang.String csvValidationWeb , java.lang.String csvGenerationDefinition) {
    this.custodyFileId=custodyFileId;
    this.arxiuExpedientId=arxiuExpedientId;
    this.arxiuDocumentId=arxiuDocumentId;
    this.fileUrl=fileUrl;
    this.csv=csv;
    this.csvValidationWeb=csvValidationWeb;
    this.csvGenerationDefinition=csvGenerationDefinition;
}
  /** Constructor dels valors Not Null */
  public InfoCustodyBean(long infoCustodyID) {
    this.infoCustodyID=infoCustodyID;
}
  public InfoCustodyBean(InfoCustody __bean) {
    this.setInfoCustodyID(__bean.getInfoCustodyID());
    this.setCustodyFileId(__bean.getCustodyFileId());
    this.setArxiuExpedientId(__bean.getArxiuExpedientId());
    this.setArxiuDocumentId(__bean.getArxiuDocumentId());
    this.setFileUrl(__bean.getFileUrl());
    this.setCsv(__bean.getCsv());
    this.setCsvValidationWeb(__bean.getCsvValidationWeb());
    this.setCsvGenerationDefinition(__bean.getCsvGenerationDefinition());
	}

	public long getInfoCustodyID() {
		return(infoCustodyID);
	};
	public void setInfoCustodyID(long _infoCustodyID_) {
		this.infoCustodyID = _infoCustodyID_;
	};

	public java.lang.String getCustodyFileId() {
		return(custodyFileId);
	};
	public void setCustodyFileId(java.lang.String _custodyFileId_) {
		this.custodyFileId = _custodyFileId_;
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

	public java.lang.String getFileUrl() {
		return(fileUrl);
	};
	public void setFileUrl(java.lang.String _fileUrl_) {
		this.fileUrl = _fileUrl_;
	};

	public java.lang.String getCsv() {
		return(csv);
	};
	public void setCsv(java.lang.String _csv_) {
		this.csv = _csv_;
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



  // ======================================

  public static InfoCustodyBean toBean(InfoCustody __bean) {
    if (__bean == null) { return null;}
    InfoCustodyBean __tmp = new InfoCustodyBean();
    __tmp.setInfoCustodyID(__bean.getInfoCustodyID());
    __tmp.setCustodyFileId(__bean.getCustodyFileId());
    __tmp.setArxiuExpedientId(__bean.getArxiuExpedientId());
    __tmp.setArxiuDocumentId(__bean.getArxiuDocumentId());
    __tmp.setFileUrl(__bean.getFileUrl());
    __tmp.setCsv(__bean.getCsv());
    __tmp.setCsvValidationWeb(__bean.getCsvValidationWeb());
    __tmp.setCsvGenerationDefinition(__bean.getCsvGenerationDefinition());
		return __tmp;
	}



}
