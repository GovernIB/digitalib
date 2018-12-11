
package es.caib.digitalib.model.bean;

import es.caib.digitalib.model.entity.ConfiguracioFirma;


public class ConfiguracioFirmaBean implements ConfiguracioFirma {



private static final long serialVersionUID = -1258385108L;

	long configuracioFirmaID;// PK
	int usPoliticaDeFirma;
	java.lang.String policyIdentifier;
	java.lang.String policyIdentifierHash;
	java.lang.String policyIdentifierHashAlgorithm;
	java.lang.String policyUrlDocument;
	int tipusOperacioFirma;
	int tipusFirmaID;
	java.lang.Integer algorismeDeFirmaID;
	boolean modeDeFirma;
	int politicaTaulaFirmes;
	int posicioTaulaFirmesID;
	java.lang.Long firmatPerFormatID;
	java.lang.Long motiuDelegacioID;
	java.lang.String propietatsTaulaFirmes;
	boolean incloureSegellDeTemps;
	java.lang.Long pluginSegellatID;


  /** Constructor Buit */
  public ConfiguracioFirmaBean() {
  }

  /** Constructor amb tots els camps  */
  public ConfiguracioFirmaBean(long configuracioFirmaID , int usPoliticaDeFirma , java.lang.String policyIdentifier , java.lang.String policyIdentifierHash , java.lang.String policyIdentifierHashAlgorithm , java.lang.String policyUrlDocument , int tipusOperacioFirma , int tipusFirmaID , java.lang.Integer algorismeDeFirmaID , boolean modeDeFirma , int politicaTaulaFirmes , int posicioTaulaFirmesID , java.lang.Long firmatPerFormatID , java.lang.Long motiuDelegacioID , java.lang.String propietatsTaulaFirmes , boolean incloureSegellDeTemps , java.lang.Long pluginSegellatID) {
    this.configuracioFirmaID=configuracioFirmaID;
    this.usPoliticaDeFirma=usPoliticaDeFirma;
    this.policyIdentifier=policyIdentifier;
    this.policyIdentifierHash=policyIdentifierHash;
    this.policyIdentifierHashAlgorithm=policyIdentifierHashAlgorithm;
    this.policyUrlDocument=policyUrlDocument;
    this.tipusOperacioFirma=tipusOperacioFirma;
    this.tipusFirmaID=tipusFirmaID;
    this.algorismeDeFirmaID=algorismeDeFirmaID;
    this.modeDeFirma=modeDeFirma;
    this.politicaTaulaFirmes=politicaTaulaFirmes;
    this.posicioTaulaFirmesID=posicioTaulaFirmesID;
    this.firmatPerFormatID=firmatPerFormatID;
    this.motiuDelegacioID=motiuDelegacioID;
    this.propietatsTaulaFirmes=propietatsTaulaFirmes;
    this.incloureSegellDeTemps=incloureSegellDeTemps;
    this.pluginSegellatID=pluginSegellatID;
}
  /** Constructor sense valors autoincrementals */
  public ConfiguracioFirmaBean(int usPoliticaDeFirma , java.lang.String policyIdentifier , java.lang.String policyIdentifierHash , java.lang.String policyIdentifierHashAlgorithm , java.lang.String policyUrlDocument , int tipusOperacioFirma , int tipusFirmaID , java.lang.Integer algorismeDeFirmaID , boolean modeDeFirma , int politicaTaulaFirmes , int posicioTaulaFirmesID , java.lang.Long firmatPerFormatID , java.lang.Long motiuDelegacioID , java.lang.String propietatsTaulaFirmes , boolean incloureSegellDeTemps , java.lang.Long pluginSegellatID) {
    this.usPoliticaDeFirma=usPoliticaDeFirma;
    this.policyIdentifier=policyIdentifier;
    this.policyIdentifierHash=policyIdentifierHash;
    this.policyIdentifierHashAlgorithm=policyIdentifierHashAlgorithm;
    this.policyUrlDocument=policyUrlDocument;
    this.tipusOperacioFirma=tipusOperacioFirma;
    this.tipusFirmaID=tipusFirmaID;
    this.algorismeDeFirmaID=algorismeDeFirmaID;
    this.modeDeFirma=modeDeFirma;
    this.politicaTaulaFirmes=politicaTaulaFirmes;
    this.posicioTaulaFirmesID=posicioTaulaFirmesID;
    this.firmatPerFormatID=firmatPerFormatID;
    this.motiuDelegacioID=motiuDelegacioID;
    this.propietatsTaulaFirmes=propietatsTaulaFirmes;
    this.incloureSegellDeTemps=incloureSegellDeTemps;
    this.pluginSegellatID=pluginSegellatID;
}
  /** Constructor dels valors Not Null */
  public ConfiguracioFirmaBean(long configuracioFirmaID , int usPoliticaDeFirma , int tipusOperacioFirma , int tipusFirmaID , java.lang.Integer algorismeDeFirmaID , boolean modeDeFirma , int politicaTaulaFirmes , int posicioTaulaFirmesID) {
    this.configuracioFirmaID=configuracioFirmaID;
    this.usPoliticaDeFirma=usPoliticaDeFirma;
    this.tipusOperacioFirma=tipusOperacioFirma;
    this.tipusFirmaID=tipusFirmaID;
    this.algorismeDeFirmaID=algorismeDeFirmaID;
    this.modeDeFirma=modeDeFirma;
    this.politicaTaulaFirmes=politicaTaulaFirmes;
    this.posicioTaulaFirmesID=posicioTaulaFirmesID;
}
  public ConfiguracioFirmaBean(ConfiguracioFirma __bean) {
    this.setConfiguracioFirmaID(__bean.getConfiguracioFirmaID());
    this.setUsPoliticaDeFirma(__bean.getUsPoliticaDeFirma());
    this.setPolicyIdentifier(__bean.getPolicyIdentifier());
    this.setPolicyIdentifierHash(__bean.getPolicyIdentifierHash());
    this.setPolicyIdentifierHashAlgorithm(__bean.getPolicyIdentifierHashAlgorithm());
    this.setPolicyUrlDocument(__bean.getPolicyUrlDocument());
    this.setTipusOperacioFirma(__bean.getTipusOperacioFirma());
    this.setTipusFirmaID(__bean.getTipusFirmaID());
    this.setAlgorismeDeFirmaID(__bean.getAlgorismeDeFirmaID());
    this.setModeDeFirma(__bean.isModeDeFirma());
    this.setPoliticaTaulaFirmes(__bean.getPoliticaTaulaFirmes());
    this.setPosicioTaulaFirmesID(__bean.getPosicioTaulaFirmesID());
    this.setFirmatPerFormatID(__bean.getFirmatPerFormatID());
    this.setMotiuDelegacioID(__bean.getMotiuDelegacioID());
    this.setPropietatsTaulaFirmes(__bean.getPropietatsTaulaFirmes());
    this.setIncloureSegellDeTemps(__bean.isIncloureSegellDeTemps());
    this.setPluginSegellatID(__bean.getPluginSegellatID());
	}

	public long getConfiguracioFirmaID() {
		return(configuracioFirmaID);
	};
	public void setConfiguracioFirmaID(long _configuracioFirmaID_) {
		this.configuracioFirmaID = _configuracioFirmaID_;
	};

	public int getUsPoliticaDeFirma() {
		return(usPoliticaDeFirma);
	};
	public void setUsPoliticaDeFirma(int _usPoliticaDeFirma_) {
		this.usPoliticaDeFirma = _usPoliticaDeFirma_;
	};

	public java.lang.String getPolicyIdentifier() {
		return(policyIdentifier);
	};
	public void setPolicyIdentifier(java.lang.String _policyIdentifier_) {
		this.policyIdentifier = _policyIdentifier_;
	};

	public java.lang.String getPolicyIdentifierHash() {
		return(policyIdentifierHash);
	};
	public void setPolicyIdentifierHash(java.lang.String _policyIdentifierHash_) {
		this.policyIdentifierHash = _policyIdentifierHash_;
	};

	public java.lang.String getPolicyIdentifierHashAlgorithm() {
		return(policyIdentifierHashAlgorithm);
	};
	public void setPolicyIdentifierHashAlgorithm(java.lang.String _policyIdentifierHashAlgorithm_) {
		this.policyIdentifierHashAlgorithm = _policyIdentifierHashAlgorithm_;
	};

	public java.lang.String getPolicyUrlDocument() {
		return(policyUrlDocument);
	};
	public void setPolicyUrlDocument(java.lang.String _policyUrlDocument_) {
		this.policyUrlDocument = _policyUrlDocument_;
	};

	public int getTipusOperacioFirma() {
		return(tipusOperacioFirma);
	};
	public void setTipusOperacioFirma(int _tipusOperacioFirma_) {
		this.tipusOperacioFirma = _tipusOperacioFirma_;
	};

	public int getTipusFirmaID() {
		return(tipusFirmaID);
	};
	public void setTipusFirmaID(int _tipusFirmaID_) {
		this.tipusFirmaID = _tipusFirmaID_;
	};

	public java.lang.Integer getAlgorismeDeFirmaID() {
		return(algorismeDeFirmaID);
	};
	public void setAlgorismeDeFirmaID(java.lang.Integer _algorismeDeFirmaID_) {
		this.algorismeDeFirmaID = _algorismeDeFirmaID_;
	};

	public boolean isModeDeFirma() {
		return(modeDeFirma);
	};
	public void setModeDeFirma(boolean _modeDeFirma_) {
		this.modeDeFirma = _modeDeFirma_;
	};

	public int getPoliticaTaulaFirmes() {
		return(politicaTaulaFirmes);
	};
	public void setPoliticaTaulaFirmes(int _politicaTaulaFirmes_) {
		this.politicaTaulaFirmes = _politicaTaulaFirmes_;
	};

	public int getPosicioTaulaFirmesID() {
		return(posicioTaulaFirmesID);
	};
	public void setPosicioTaulaFirmesID(int _posicioTaulaFirmesID_) {
		this.posicioTaulaFirmesID = _posicioTaulaFirmesID_;
	};

	public java.lang.Long getFirmatPerFormatID() {
		return(firmatPerFormatID);
	};
	public void setFirmatPerFormatID(java.lang.Long _firmatPerFormatID_) {
		this.firmatPerFormatID = _firmatPerFormatID_;
	};

	public java.lang.Long getMotiuDelegacioID() {
		return(motiuDelegacioID);
	};
	public void setMotiuDelegacioID(java.lang.Long _motiuDelegacioID_) {
		this.motiuDelegacioID = _motiuDelegacioID_;
	};

	public java.lang.String getPropietatsTaulaFirmes() {
		return(propietatsTaulaFirmes);
	};
	public void setPropietatsTaulaFirmes(java.lang.String _propietatsTaulaFirmes_) {
		this.propietatsTaulaFirmes = _propietatsTaulaFirmes_;
	};

	public boolean isIncloureSegellDeTemps() {
		return(incloureSegellDeTemps);
	};
	public void setIncloureSegellDeTemps(boolean _incloureSegellDeTemps_) {
		this.incloureSegellDeTemps = _incloureSegellDeTemps_;
	};

	public java.lang.Long getPluginSegellatID() {
		return(pluginSegellatID);
	};
	public void setPluginSegellatID(java.lang.Long _pluginSegellatID_) {
		this.pluginSegellatID = _pluginSegellatID_;
	};



  // ======================================

  public static ConfiguracioFirmaBean toBean(ConfiguracioFirma __bean) {
    if (__bean == null) { return null;}
    ConfiguracioFirmaBean __tmp = new ConfiguracioFirmaBean();
    __tmp.setConfiguracioFirmaID(__bean.getConfiguracioFirmaID());
    __tmp.setUsPoliticaDeFirma(__bean.getUsPoliticaDeFirma());
    __tmp.setPolicyIdentifier(__bean.getPolicyIdentifier());
    __tmp.setPolicyIdentifierHash(__bean.getPolicyIdentifierHash());
    __tmp.setPolicyIdentifierHashAlgorithm(__bean.getPolicyIdentifierHashAlgorithm());
    __tmp.setPolicyUrlDocument(__bean.getPolicyUrlDocument());
    __tmp.setTipusOperacioFirma(__bean.getTipusOperacioFirma());
    __tmp.setTipusFirmaID(__bean.getTipusFirmaID());
    __tmp.setAlgorismeDeFirmaID(__bean.getAlgorismeDeFirmaID());
    __tmp.setModeDeFirma(__bean.isModeDeFirma());
    __tmp.setPoliticaTaulaFirmes(__bean.getPoliticaTaulaFirmes());
    __tmp.setPosicioTaulaFirmesID(__bean.getPosicioTaulaFirmesID());
    __tmp.setFirmatPerFormatID(__bean.getFirmatPerFormatID());
    __tmp.setMotiuDelegacioID(__bean.getMotiuDelegacioID());
    __tmp.setPropietatsTaulaFirmes(__bean.getPropietatsTaulaFirmes());
    __tmp.setIncloureSegellDeTemps(__bean.isIncloureSegellDeTemps());
    __tmp.setPluginSegellatID(__bean.getPluginSegellatID());
		return __tmp;
	}



}
