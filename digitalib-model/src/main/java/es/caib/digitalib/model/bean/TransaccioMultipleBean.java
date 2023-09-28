
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.TransaccioMultiple;


public class TransaccioMultipleBean implements TransaccioMultiple {



	long transmultipleid;// PK
	java.lang.String descripcio;
	java.lang.Long fitxerEscanejatID;


  /** Constructor Buit */
  public TransaccioMultipleBean() {
  }

  /** Constructor amb tots els camps  */
  public TransaccioMultipleBean(long transmultipleid , java.lang.String descripcio , java.lang.Long fitxerEscanejatID) {
    this.transmultipleid=transmultipleid;
    this.descripcio=descripcio;
    this.fitxerEscanejatID=fitxerEscanejatID;
}
  /** Constructor dels valors Not Null */
  public TransaccioMultipleBean(long transmultipleid , java.lang.String descripcio) {
    this.transmultipleid=transmultipleid;
    this.descripcio=descripcio;
}
  public TransaccioMultipleBean(TransaccioMultiple __bean) {
    this.setTransmultipleid(__bean.getTransmultipleid());
    this.setDescripcio(__bean.getDescripcio());
    this.setFitxerEscanejatID(__bean.getFitxerEscanejatID());
    // Fitxer
    this.setFitxerEscanejat(FitxerBean.toBean(__bean.getFitxerEscanejat()));
	}

	public long getTransmultipleid() {
		return(transmultipleid);
	};
	public void setTransmultipleid(long _transmultipleid_) {
		this.transmultipleid = _transmultipleid_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public java.lang.Long getFitxerEscanejatID() {
		return(fitxerEscanejatID);
	};
	public void setFitxerEscanejatID(java.lang.Long _fitxerEscanejatID_) {
		this.fitxerEscanejatID = _fitxerEscanejatID_;
	};



  // ======================================

  public static TransaccioMultipleBean toBean(TransaccioMultiple __bean) {
    if (__bean == null) { return null;}
    TransaccioMultipleBean __tmp = new TransaccioMultipleBean();
    __tmp.setTransmultipleid(__bean.getTransmultipleid());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setFitxerEscanejatID(__bean.getFitxerEscanejatID());
    // Fitxer
    __tmp.setFitxerEscanejat(FitxerBean.toBean(__bean.getFitxerEscanejat()));
		return __tmp;
	}

  protected FitxerBean fitxerEscanejat;
  public FitxerBean getFitxerEscanejat() {
    return fitxerEscanejat;
  }
  public void setFitxerEscanejat(FitxerBean __field) {
    this. fitxerEscanejat = __field;
  }


}
