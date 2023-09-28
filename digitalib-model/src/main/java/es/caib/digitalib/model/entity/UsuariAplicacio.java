package es.caib.digitalib.model.entity;

public interface UsuariAplicacio extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getUsuariAplicacioID();
	public void setUsuariAplicacioID(long _usuariAplicacioID_);

	public java.lang.String getUsername();
	public void setUsername(java.lang.String _username_);

	public java.lang.String getContrasenya();
	public void setContrasenya(java.lang.String _contrasenya_);

	public java.lang.String getEmailAdmin();
	public void setEmailAdmin(java.lang.String _emailAdmin_);

	public java.lang.String getDescripcio();
	public void setDescripcio(java.lang.String _descripcio_);

	public boolean isActiu();
	public void setActiu(boolean _actiu_);

	public boolean isRoleScan();
	public void setRoleScan(boolean _roleScan_);

	public boolean isRoleCoAu();
	public void setRoleCoAu(boolean _roleCoAu_);

	public boolean isRoleCust();
	public void setRoleCust(boolean _roleCust_);



  // ======================================

}
