package es.caib.digitalib.model.entity;

public interface Estadistica extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getEstadisticaID();
	public void setEstadisticaID(long _estadisticaID_);

	public int getTipus();
	public void setTipus(int _tipus_);

	public java.sql.Timestamp getData();
	public void setData(java.sql.Timestamp _data_);

	public double getValor();
	public void setValor(double _valor_);

	public java.lang.String getParametres();
	public void setParametres(java.lang.String _parametres_);

	public java.lang.Long getUsuariAplicacioID();
	public void setUsuariAplicacioID(java.lang.Long _usuariAplicacioID_);

	public java.lang.Long getUsuariPersonaID();
	public void setUsuariPersonaID(java.lang.Long _usuariPersonaID_);



  // ======================================

}
