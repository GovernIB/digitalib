package es.caib.digitalib.jpa;

import es.caib.digitalib.model.*;
import es.caib.digitalib.model.dao.*;
import javax.persistence.EntityManager;

public final class DigitalIBJPADaoManagers implements IDigitalIBDaoManagers{

   private final ConfiguracioGrupJPAManager dib_configuraciogrup;
   private final EstadisticaJPAManager dib_estadistica;
   private final FitxerJPAManager dib_fitxer;
   private final IdiomaJPAManager dib_idioma;
   private final PerfilJPAManager dib_perfil;
   private final PerfilUsuariAplicacioJPAManager dib_perfilusrapp;
   private final PluginJPAManager dib_plugin;
   private final PluginCridadaJPAManager dib_plugincridada;
   private final TraduccioJPAManager dib_traduccio;
   private final TransaccioJPAManager dib_transaccio;
   private final UsuariAplicacioJPAManager dib_usuariaplicacio;
   private final UsuariPersonaJPAManager dib_usuaripersona;

  public  DigitalIBJPADaoManagers(EntityManager __em) {
    this.dib_configuraciogrup = new ConfiguracioGrupJPAManager(__em);
    this.dib_estadistica = new EstadisticaJPAManager(__em);
    this.dib_fitxer = new FitxerJPAManager(__em);
    this.dib_idioma = new IdiomaJPAManager(__em);
    this.dib_perfil = new PerfilJPAManager(__em);
    this.dib_perfilusrapp = new PerfilUsuariAplicacioJPAManager(__em);
    this.dib_plugin = new PluginJPAManager(__em);
    this.dib_plugincridada = new PluginCridadaJPAManager(__em);
    this.dib_traduccio = new TraduccioJPAManager(__em);
    this.dib_transaccio = new TransaccioJPAManager(__em);
    this.dib_usuariaplicacio = new UsuariAplicacioJPAManager(__em);
    this.dib_usuaripersona = new UsuariPersonaJPAManager(__em);
  }

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