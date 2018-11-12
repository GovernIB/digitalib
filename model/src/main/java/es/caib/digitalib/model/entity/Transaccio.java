package es.caib.digitalib.model.entity;

public interface Transaccio extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getTransaccioID();
	public void setTransaccioID(long _transaccioID_);

	public java.sql.Timestamp getDatainici();
	public void setDatainici(java.sql.Timestamp _datainici_);

	public java.sql.Timestamp getDatafi();
	public void setDatafi(java.sql.Timestamp _datafi_);

	public java.lang.Long getUsuariaplicacioid();
	public void setUsuariaplicacioid(java.lang.Long _usuariaplicacioid_);

	public java.lang.Long getUsuaripersonaid();
	public void setUsuaripersonaid(java.lang.Long _usuaripersonaid_);



  // ======================================

}
