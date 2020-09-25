package es.caib.digitalib.model;

import es.caib.digitalib.model.dao.*;

public interface IDigitalIBDaoManagers {
	public IApiSimpleManager getApiSimpleManager();
	public IAuditoriaManager getAuditoriaManager();
	public IAvisManager getAvisManager();
	public IConfiguracioFirmaManager getConfiguracioFirmaManager();
	public IConfiguracioGrupManager getConfiguracioGrupManager();
	public IEstadisticaManager getEstadisticaManager();
	public IFitxerManager getFitxerManager();
	public IIdiomaManager getIdiomaManager();
	public IInfoCustodyManager getInfoCustodyManager();
	public IInfoSignaturaManager getInfoSignaturaManager();
	public IMetadadaManager getMetadadaManager();
	public IPerfilManager getPerfilManager();
	public IPerfilUsuariAplicacioManager getPerfilUsuariAplicacioManager();
	public IPluginManager getPluginManager();
	public IPluginCridadaManager getPluginCridadaManager();
	public ITraduccioManager getTraduccioManager();
	public ITransaccioManager getTransaccioManager();
	public ITransaccioMultipleManager getTransaccioMultipleManager();
	public IUsuariAplicacioManager getUsuariAplicacioManager();
	public IUsuariPersonaManager getUsuariPersonaManager();

}