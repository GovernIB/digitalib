
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.UsuariPersona;


public class UsuariPersonaBean implements UsuariPersona {



	long usuariPersonaID;// PK
	java.lang.String username;
	java.lang.String nom;
	java.lang.String llinatges;
	java.lang.String email;
	java.lang.String nif;
	java.lang.String idiomaID;
	java.lang.Long configuracioGrupID;
	java.lang.String unitatDir3;
	boolean roleScan;
	boolean roleCoAu;
	boolean roleCust;


  /** Constructor Buit */
  public UsuariPersonaBean() {
  }

  /** Constructor amb tots els camps  */
  public UsuariPersonaBean(long usuariPersonaID , java.lang.String username , java.lang.String nom , java.lang.String llinatges , java.lang.String email , java.lang.String nif , java.lang.String idiomaID , java.lang.Long configuracioGrupID , java.lang.String unitatDir3 , boolean roleScan , boolean roleCoAu , boolean roleCust) {
    this.usuariPersonaID=usuariPersonaID;
    this.username=username;
    this.nom=nom;
    this.llinatges=llinatges;
    this.email=email;
    this.nif=nif;
    this.idiomaID=idiomaID;
    this.configuracioGrupID=configuracioGrupID;
    this.unitatDir3=unitatDir3;
    this.roleScan=roleScan;
    this.roleCoAu=roleCoAu;
    this.roleCust=roleCust;
}
  /** Constructor sense valors autoincrementals */
  public UsuariPersonaBean(java.lang.String username , java.lang.String nom , java.lang.String llinatges , java.lang.String email , java.lang.String nif , java.lang.String idiomaID , java.lang.Long configuracioGrupID , java.lang.String unitatDir3 , boolean roleScan , boolean roleCoAu , boolean roleCust) {
    this.username=username;
    this.nom=nom;
    this.llinatges=llinatges;
    this.email=email;
    this.nif=nif;
    this.idiomaID=idiomaID;
    this.configuracioGrupID=configuracioGrupID;
    this.unitatDir3=unitatDir3;
    this.roleScan=roleScan;
    this.roleCoAu=roleCoAu;
    this.roleCust=roleCust;
}
  /** Constructor dels valors Not Null */
  public UsuariPersonaBean(long usuariPersonaID , java.lang.String username , java.lang.String nom , java.lang.String llinatges , java.lang.String email , java.lang.String nif , java.lang.String idiomaID , boolean roleScan , boolean roleCoAu , boolean roleCust) {
    this.usuariPersonaID=usuariPersonaID;
    this.username=username;
    this.nom=nom;
    this.llinatges=llinatges;
    this.email=email;
    this.nif=nif;
    this.idiomaID=idiomaID;
    this.roleScan=roleScan;
    this.roleCoAu=roleCoAu;
    this.roleCust=roleCust;
}
  public UsuariPersonaBean(UsuariPersona __bean) {
    this.setUsuariPersonaID(__bean.getUsuariPersonaID());
    this.setUsername(__bean.getUsername());
    this.setNom(__bean.getNom());
    this.setLlinatges(__bean.getLlinatges());
    this.setEmail(__bean.getEmail());
    this.setNif(__bean.getNif());
    this.setIdiomaID(__bean.getIdiomaID());
    this.setConfiguracioGrupID(__bean.getConfiguracioGrupID());
    this.setUnitatDir3(__bean.getUnitatDir3());
    this.setRoleScan(__bean.isRoleScan());
    this.setRoleCoAu(__bean.isRoleCoAu());
    this.setRoleCust(__bean.isRoleCust());
	}

	public long getUsuariPersonaID() {
		return(usuariPersonaID);
	};
	public void setUsuariPersonaID(long _usuariPersonaID_) {
		this.usuariPersonaID = _usuariPersonaID_;
	};

	public java.lang.String getUsername() {
		return(username);
	};
	public void setUsername(java.lang.String _username_) {
		this.username = _username_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getLlinatges() {
		return(llinatges);
	};
	public void setLlinatges(java.lang.String _llinatges_) {
		this.llinatges = _llinatges_;
	};

	public java.lang.String getEmail() {
		return(email);
	};
	public void setEmail(java.lang.String _email_) {
		this.email = _email_;
	};

	public java.lang.String getNif() {
		return(nif);
	};
	public void setNif(java.lang.String _nif_) {
		this.nif = _nif_;
	};

	public java.lang.String getIdiomaID() {
		return(idiomaID);
	};
	public void setIdiomaID(java.lang.String _idiomaID_) {
		this.idiomaID = _idiomaID_;
	};

	public java.lang.Long getConfiguracioGrupID() {
		return(configuracioGrupID);
	};
	public void setConfiguracioGrupID(java.lang.Long _configuracioGrupID_) {
		this.configuracioGrupID = _configuracioGrupID_;
	};

	public java.lang.String getUnitatDir3() {
		return(unitatDir3);
	};
	public void setUnitatDir3(java.lang.String _unitatDir3_) {
		this.unitatDir3 = _unitatDir3_;
	};

	public boolean isRoleScan() {
		return(roleScan);
	};
	public void setRoleScan(boolean _roleScan_) {
		this.roleScan = _roleScan_;
	};

	public boolean isRoleCoAu() {
		return(roleCoAu);
	};
	public void setRoleCoAu(boolean _roleCoAu_) {
		this.roleCoAu = _roleCoAu_;
	};

	public boolean isRoleCust() {
		return(roleCust);
	};
	public void setRoleCust(boolean _roleCust_) {
		this.roleCust = _roleCust_;
	};



  // ======================================

  public static UsuariPersonaBean toBean(UsuariPersona __bean) {
    if (__bean == null) { return null;}
    UsuariPersonaBean __tmp = new UsuariPersonaBean();
    __tmp.setUsuariPersonaID(__bean.getUsuariPersonaID());
    __tmp.setUsername(__bean.getUsername());
    __tmp.setNom(__bean.getNom());
    __tmp.setLlinatges(__bean.getLlinatges());
    __tmp.setEmail(__bean.getEmail());
    __tmp.setNif(__bean.getNif());
    __tmp.setIdiomaID(__bean.getIdiomaID());
    __tmp.setConfiguracioGrupID(__bean.getConfiguracioGrupID());
    __tmp.setUnitatDir3(__bean.getUnitatDir3());
    __tmp.setRoleScan(__bean.isRoleScan());
    __tmp.setRoleCoAu(__bean.isRoleCoAu());
    __tmp.setRoleCust(__bean.isRoleCust());
		return __tmp;
	}



}