package es.caib.digitalib.model.entity;

public interface Auditoria extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getAuditoriaID();
	public void setAuditoriaID(long _auditoriaID_);

	public java.sql.Timestamp getData();
	public void setData(java.sql.Timestamp _data_);

	public long getTransaccioId();
	public void setTransaccioId(long _transaccioId_);

	public int getTipus();
	public void setTipus(int _tipus_);

	public java.lang.String getMissatge();
	public void setMissatge(java.lang.String _missatge_);

	public java.lang.String getAdditionalInfo();
	public void setAdditionalInfo(java.lang.String _additionalInfo_);

	public boolean isIsApp();
	public void setIsApp(boolean _isApp_);

	public java.lang.String getUsernameAplicacio();
	public void setUsernameAplicacio(java.lang.String _usernameAplicacio_);

	public java.lang.String getUsernamePersona();
	public void setUsernamePersona(java.lang.String _usernamePersona_);



  // ======================================

}
