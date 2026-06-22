package es.caib.digitalib.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.query.selectcolumn.Select2Columns;
import org.fundaciobit.genapp.common.query.selectcolumn.Select2Values;
import org.fundaciobit.pluginsib.core.v3.IPluginIB;

import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.ejb.PluginEJB;
import es.caib.digitalib.model.entity.Plugin;
import es.caib.digitalib.model.fields.ConfiguracioFirmaFields;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.PluginCridadaFields;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "PluginLogicaEJB")
public class PluginLogicaEJB extends PluginEJB implements PluginLogicaService {

    @EJB(mappedName = PerfilLogicaService.JNDI_NAME)
    protected PerfilLogicaService perfilLogicaEjb;

    @EJB(mappedName = CridadaPluginLogicaService.JNDI_NAME)
    protected CridadaPluginLogicaService cridadaPluginLogicaEjb;

    @EJB(mappedName = ConfiguracioFirmaLogicaService.JNDI_NAME)
    protected ConfiguracioFirmaLogicaService configuraFirmaLogicaEjb;

    private static Map<Long, IPluginIB> pluginsCache = new HashMap<Long, IPluginIB>();

    @Override
    public Plugin update(Plugin instance) throws I18NException {
        if (instance != null) {
            synchronized (pluginsCache) {
                pluginsCache.remove(instance.getPluginID());
            }
        }
        return super.update(instance);
    }

    @Override
    public void delete(Plugin instance) {
        if (instance != null) {
            synchronized (pluginsCache) {
                pluginsCache.remove(instance.getPluginID());
            }
        }
        super.delete(instance);
    }

    @Override
    public void deleteAndCheckPerfils(Plugin plugin, int tipusPlugin) throws I18NException {

        switch (tipusPlugin) {
            case Constants.TIPUS_PLUGIN_ARXIU:

                // XYZ DEBUG
                this.delete(plugin);

            break;
            case Constants.TIPUS_PLUGIN_DOCUMENT_CUSTODY:

                // 1 Vaidar que no hi hagi Perfils que usen aquest plugin de custòdia. Si n'hi ha, llençar una excepció.
                Select2Columns<Long, String> select2Columns = new Select2Columns<Long, String>(
                        PerfilFields.PLUGINDOCCUSTODYID.select, PerfilFields.CODI.select);

                List<Select2Values<Long, String>> list = perfilLogicaEjb.executeQuery(select2Columns,
                        Where.AND(PerfilFields.PLUGINDOCCUSTODYID.equal(plugin.getPluginID()),
                                PerfilFields.USPERFIL.equal(Constants.PERFIL_US_CUSTODIA)));

                if (list.size() > 0) {

                    StringBuffer perfils = new StringBuffer();

                    perfils.append("Els següents perfils fan ús del plugin de custòdia"
                            + " (primer ha d'eliminar o modificar aquests perfils): ");

                    for (Select2Values<Long, String> item : list) {
                        perfils.append(item.getValue2()).append("(ID: ").append(item.getValue1()).append("), ");
                    }

                    throw new I18NException("genapp.comodi", perfils.toString());

                }

                // 2 Posam null a tots els perfils de INFO que fan ús d'aquest plugin de custòdia
                perfilLogicaEjb.update(PerfilFields.PLUGINDOCCUSTODYID, null,
                        PerfilFields.PLUGINDOCCUSTODYID.equal(plugin.getPluginID()));

                // 3 Esborram les cridades a aquest plugin de custòdia de la taula  cridades a PLugin
                cridadaPluginLogicaEjb.delete(PluginCridadaFields.PLUGINID.equal(plugin.getPluginID()));

                // 4 Esborram el plugin de custòdia

                this.delete(plugin);

            break;
            case Constants.TIPUS_PLUGIN_FIRMA_EN_SERVIDOR:

                // 1.- No hi ha d'haver Configuracions de Firma associades a aquest plugin de firma en servidor. Si n'hi ha, llençar una excepció.

                List<String> noms = configuraFirmaLogicaEjb.executeQuery(ConfiguracioFirmaFields.NOM,
                        Where.AND(ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID.equal(plugin.getPluginID())));

                if (noms.size() > 0) {

                    throw new I18NException("genapp.comodi",
                            "El PLugin de Firma en servidor que vols esborrar està definit en les següents Configuracions de Firma: "
                                    + noms.toString()
                                    + ". Primer has d'eliminar o modificar aquestes Configuracions de Firma.");

                }

                // 2.- Esborram les cridades a aquest plugin de custòdia de la taula de cridades a PLugin
                cridadaPluginLogicaEjb.delete(PluginCridadaFields.PLUGINID.equal(plugin.getPluginID()));

                
                // 3.- Esborram el plugin de firma en servidor
                this.delete(plugin);

            break;

            case Constants.TIPUS_PLUGIN_SEGELLDETEMPS:
                // XYZ DEBUG
                /*
                Where w4 = ConfiguracioFirmaFields.PLUGINSEGELLATID.equal(plugin.getPluginID());
                List<String> infoCodiNom4 = configuracioFirmaEjb.executeQuery(ConfiguracioFirmaFields.NOM, w4);
                if (infoCodiNom4.size() > 0) {
                String codiNom = infoCodiNom4.get(0);
                throw new I18NException("error.desactivarplugin.2", codi
                */
                this.delete(plugin);

            break;
            case Constants.TIPUS_PLUGIN_SCANWEB:

                // XYZ DEBUG
                this.delete(plugin);

            break;
        }

    }

    @Override
    public boolean clearCache(Long pluginID) {
        synchronized (pluginsCache) {
            Object obj = pluginsCache.remove(pluginID);
            return obj != null;
        }
    }

    @Override
    public void clearCache() {
        synchronized (pluginsCache) {
            pluginsCache.clear();
        }
    }

    public void addPluginToCache(Long pluginID, IPluginIB pluginInstance) {
        synchronized (pluginsCache) {
            pluginsCache.put(pluginID, pluginInstance);
        }
    }

    public IPluginIB getPluginFromCache(Long pluginID) {
        synchronized (pluginsCache) {
            return pluginsCache.get(pluginID);
        }
    }

}
