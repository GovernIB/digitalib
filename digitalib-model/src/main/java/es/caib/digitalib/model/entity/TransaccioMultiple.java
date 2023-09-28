package es.caib.digitalib.model.entity;

public interface TransaccioMultiple extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getTransmultipleid();
	public void setTransmultipleid(long _transmultipleid_);

	public java.lang.String getDescripcio();
	public void setDescripcio(java.lang.String _descripcio_);

	public java.lang.Long getFitxerEscanejatID();
	public void setFitxerEscanejatID(java.lang.Long _fitxerEscanejatID_);

  // Fitxer
  public <F extends Fitxer> F getFitxerEscanejat();


  // ======================================

}
