package es.caib.digitalib.model.entity;

public interface PluginCridada extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getPluginCridadaID();
	public void setPluginCridadaID(long _pluginCridadaID_);

	public java.sql.Timestamp getData();
	public void setData(java.sql.Timestamp _data_);

	public java.lang.String getMetodePlugin();
	public void setMetodePlugin(java.lang.String _metodePlugin_);

	public int getTipusResultat();
	public void setTipusResultat(int _tipusResultat_);

	public java.lang.Long getTempsExecucio();
	public void setTempsExecucio(java.lang.Long _tempsExecucio_);

	public long getPluginID();
	public void setPluginID(long _pluginID_);

	public java.lang.Long getUsuariPersonaId();
	public void setUsuariPersonaId(java.lang.Long _usuariPersonaId_);

	public java.lang.Long getUsuariAplicacioId();
	public void setUsuariAplicacioId(java.lang.Long _usuariAplicacioId_);

	public java.lang.String getParametresText();
	public void setParametresText(java.lang.String _parametresText_);

	public java.lang.Long getParametresFitxerID();
	public void setParametresFitxerID(java.lang.Long _parametresFitxerID_);

	public java.lang.String getRetornText();
	public void setRetornText(java.lang.String _retornText_);

	public java.lang.Long getRetornFitxerID();
	public void setRetornFitxerID(java.lang.Long _retornFitxerID_);

  // Fitxer
  public <F extends Fitxer> F getParametresFitxer();
  // Fitxer
  public <F extends Fitxer> F getRetornFitxer();


  // ======================================

}
