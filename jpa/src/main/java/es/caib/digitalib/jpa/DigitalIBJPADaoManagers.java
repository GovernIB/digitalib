package es.caib.digitalib.jpa;

import es.caib.digitalib.model.*;
import es.caib.digitalib.model.dao.*;
import javax.persistence.EntityManager;

public final class DigitalIBJPADaoManagers implements IDigitalIBDaoManagers{

   private final ApiSimpleJPAManager dib_apisimple;
   private final AuditoriaJPAManager dib_auditoria;
   private final ConfiguracioFirmaJPAManager dib_configuraciofirma;
   private final ConfiguracioGrupJPAManager dib_configuraciogrup;
   private final EstadisticaJPAManager dib_estadistica;
   private final FitxerJPAManager dib_fitxer;
   private final IdiomaJPAManager dib_idioma;
   private final InfoCustodyJPAManager dib_infocustody;
   private final InfoSignaturaJPAManager dib_infosignatura;
   private final MetadadaJPAManager dib_metadada;
   private final PerfilJPAManager dib_perfil;
   private final PerfilUsuariAplicacioJPAManager dib_perfilusrapp;
   private final PluginJPAManager dib_plugin;
   private final PluginCridadaJPAManager dib_plugincridada;
   private final TraduccioJPAManager dib_traduccio;
   private final TransaccioJPAManager dib_transaccio;
   private final UsuariAplicacioJPAManager dib_usuariaplicacio;
   private final UsuariPersonaJPAManager dib_usuaripersona;

  public  DigitalIBJPADaoManagers(EntityManager __em) {
    this.dib_apisimple = new ApiSimpleJPAManager(__em);
    this.dib_auditoria = new AuditoriaJPAManager(__em);
    this.dib_configuraciofirma = new ConfiguracioFirmaJPAManager(__em);
    this.dib_configuraciogrup = new ConfiguracioGrupJPAManager(__em);
    this.dib_estadistica = new EstadisticaJPAManager(__em);
    this.dib_fitxer = new FitxerJPAManager(__em);
    this.dib_idioma = new IdiomaJPAManager(__em);
    this.dib_infocustody = new InfoCustodyJPAManager(__em);
    this.dib_infosignatura = new InfoSignaturaJPAManager(__em);
    this.dib_metadada = new MetadadaJPAManager(__em);
    this.dib_perfil = new PerfilJPAManager(__em);
    this.dib_perfilusrapp = new PerfilUsuariAplicacioJPAManager(__em);
    this.dib_plugin = new PluginJPAManager(__em);
    this.dib_plugincridada = new PluginCridadaJPAManager(__em);
    this.dib_traduccio = new TraduccioJPAManager(__em);
    this.dib_transaccio = new TransaccioJPAManager(__em);
    this.dib_usuariaplicacio = new UsuariAplicacioJPAManager(__em);
    this.dib_usuaripersona = new UsuariPersonaJPAManager(__em);
  }

	public IApiSimpleManager getApiSimpleManager() {
	  return this.dib_apisimple;
	};

	public IAuditoriaManager getAuditoriaManager() {
	  return this.dib_auditoria;
	};

	public IConfiguracioFirmaManager getConfiguracioFirmaManager() {
	  return this.dib_configuraciofirma;
	};

	public IConfiguracioGrupManager getConfiguracioGrupManager() {
	  return this.dib_configuraciogrup;
	};

	public IEstadisticaManager getEstadisticaManager() {
	  return this.dib_estadistica;
	};

	public IFitxerManager getFitxerManager() {
	  return this.dib_fitxer;
	};

	public IIdiomaManager getIdiomaManager() {
	  return this.dib_idioma;
	};

	public IInfoCustodyManager getInfoCustodyManager() {
	  return this.dib_infocustody;
	};

	public IInfoSignaturaManager getInfoSignaturaManager() {
	  return this.dib_infosignatura;
	};

	public IMetadadaManager getMetadadaManager() {
	  return this.dib_metadada;
	};

	public IPerfilManager getPerfilManager() {
	  return this.dib_perfil;
	};

	public IPerfilUsuariAplicacioManager getPerfilUsuariAplicacioManager() {
	  return this.dib_perfilusrapp;
	};

	public IPluginManager getPluginManager() {
	  return this.dib_plugin;
	};

	public IPluginCridadaManager getPluginCridadaManager() {
	  return this.dib_plugincridada;
	};

	public ITraduccioManager getTraduccioManager() {
	  return this.dib_traduccio;
	};

	public ITransaccioManager getTransaccioManager() {
	  return this.dib_transaccio;
	};

	public IUsuariAplicacioManager getUsuariAplicacioManager() {
	  return this.dib_usuariaplicacio;
	};

	public IUsuariPersonaManager getUsuariPersonaManager() {
	  return this.dib_usuaripersona;
	};


}