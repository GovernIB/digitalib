package es.caib.digitalib.model.entity;

public interface Perfil extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getPerfilID();
	public void setPerfilID(long _perfilID_);

	public java.lang.String getCodi();
	public void setCodi(java.lang.String _codi_);

	public java.lang.String getNom();
	public void setNom(java.lang.String _nom_);

	public java.lang.String getDescripcio();
	public void setDescripcio(java.lang.String _descripcio_);

	public long getPluginScanWebID();
	public void setPluginScanWebID(long _pluginScanWebID_);

	public java.lang.Long getPluginFirmaServidorID();
	public void setPluginFirmaServidorID(java.lang.Long _pluginFirmaServidorID_);

	public java.lang.Long getPluginArxiuID();
	public void setPluginArxiuID(java.lang.Long _pluginArxiuID_);

	public java.lang.Long getPluginDocCustodyID();
	public void setPluginDocCustodyID(java.lang.Long _pluginDocCustodyID_);



  // ======================================

}
