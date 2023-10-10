package es.caib.digitalib.logic.utils;

import org.apache.log4j.Logger;
import org.fundaciobit.pluginsib.userinformation.IUserInformationPlugin;
import org.fundaciobit.pluginsib.core.utils.PluginsManager;
import org.fundaciobit.genapp.common.i18n.I18NArgumentCode;
import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal
 * 
 */
public class DigitalIBPluginsManager implements Constants {

    protected static Logger log = Logger.getLogger(DigitalIBPluginsManager.class);

    public static final String LOGIN_PLUGIN_KEY = DIGITALIB_PROPERTY_BASE + "userinformationplugin";

    public static IUserInformationPlugin loginPlugin = null;

    public static IUserInformationPlugin getUserInformationPluginInstance() throws I18NException {
        if (loginPlugin == null) {
            final String propertyPlugin = LOGIN_PLUGIN_KEY;
            Object pluginInstance = PluginsManager.instancePluginByProperty(propertyPlugin,
                    Constants.DIGITALIB_PROPERTY_BASE, Configuracio.getSystemAndFileProperties());
            if (pluginInstance == null) {
                // XYZ ZZZ Cercar traduccions a PortaFIB
                throw new I18NException("plugin.donotinstantiateplugin", new I18NArgumentCode("plugin.userinfo"));
            }
            loginPlugin = (IUserInformationPlugin) pluginInstance;
        }
        return loginPlugin;
    }

}
