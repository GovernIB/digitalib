package es.caib.digitalib.model.entity;

public interface UsuariAplicacio extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getUsuariAplicacioID();
	public void setUsuariAplicacioID(long _usuariAplicacioID_);

	public java.lang.String getUsername();
	public void setUsername(java.lang.String _username_);

	public java.lang.String getContrasenya();
	public void setContrasenya(java.lang.String _contrasenya_);

	public java.lang.String getEmailadmin();
	public void setEmailadmin(java.lang.String _emailadmin_);

	public java.lang.String getDescripcio();
	public void setDescripcio(java.lang.String _descripcio_);

	public boolean isActiu();
	public void setActiu(boolean _actiu_);



  // ======================================

}
