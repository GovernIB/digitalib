package es.caib.digitalib.model.entity;

public interface PluginCridada extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getPluginCridadaID();
	public void setPluginCridadaID(long _pluginCridadaID_);

	public java.sql.Timestamp getData();
	public void setData(java.sql.Timestamp _data_);

	public java.lang.String getMetodeplugin();
	public void setMetodeplugin(java.lang.String _metodeplugin_);

	public int getTipusresultat();
	public void setTipusresultat(int _tipusresultat_);

	public java.lang.Long getTempsexecucio();
	public void setTempsexecucio(java.lang.Long _tempsexecucio_);

	public long getPluginID();
	public void setPluginID(long _pluginID_);

	public java.lang.Long getUsuaripersonaid();
	public void setUsuaripersonaid(java.lang.Long _usuaripersonaid_);

	public java.lang.Long getUsuariaplicacioid();
	public void setUsuariaplicacioid(java.lang.Long _usuariaplicacioid_);

	public java.lang.String getParametrestext();
	public void setParametrestext(java.lang.String _parametrestext_);

	public java.lang.Long getParametresFitxerID();
	public void setParametresFitxerID(java.lang.Long _parametresFitxerID_);

	public java.lang.String getRetorntext();
	public void setRetorntext(java.lang.String _retorntext_);

	public java.lang.Long getRetornFitxerID();
	public void setRetornFitxerID(java.lang.Long _retornFitxerID_);

  // Fitxer
  public <F extends Fitxer> F getParametresFitxer();
  // Fitxer
  public <F extends Fitxer> F getRetornFitxer();


  // ======================================

}
