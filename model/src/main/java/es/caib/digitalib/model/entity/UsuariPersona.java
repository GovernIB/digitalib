package es.caib.digitalib.model.entity;

public interface UsuariPersona extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getUsuariPersonaID();
	public void setUsuariPersonaID(long _usuariPersonaID_);

	public java.lang.String getUsername();
	public void setUsername(java.lang.String _username_);

	public java.lang.String getNom();
	public void setNom(java.lang.String _nom_);

	public java.lang.String getLlinatges();
	public void setLlinatges(java.lang.String _llinatges_);

	public java.lang.String getEmail();
	public void setEmail(java.lang.String _email_);

	public java.lang.String getNif();
	public void setNif(java.lang.String _nif_);

	public java.lang.String getIdiomaID();
	public void setIdiomaID(java.lang.String _idiomaID_);

	public java.lang.Long getConfiguracioGrupID();
	public void setConfiguracioGrupID(java.lang.Long _configuracioGrupID_);

	public java.lang.String getUnitatDir3();
	public void setUnitatDir3(java.lang.String _unitatDir3_);

	public boolean isRoleScan();
	public void setRoleScan(boolean _roleScan_);

	public boolean isRoleCoAu();
	public void setRoleCoAu(boolean _roleCoAu_);

	public boolean isRoleCust();
	public void setRoleCust(boolean _roleCust_);



  // ======================================

}
