package es.caib.digitalib.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;

import es.caib.digitalib.ejb.ConfiguracioFirmaEJB;
import es.caib.digitalib.model.entity.ConfiguracioFirma;
import es.caib.digitalib.model.fields.PerfilFields;

/**
 * 
 * @author anadal (u80067)
 * 22 jun 2026 9:58:39
 */
@Stateless(name = "ConfiguracioFirmaLogicaEJB")
public class ConfiguracioFirmaLogicaEJB extends ConfiguracioFirmaEJB implements ConfiguracioFirmaLogicaService {

    @EJB(mappedName = PerfilLogicaService.JNDI_NAME)
    protected PerfilLogicaService perfilLogicaService;

    @Override
    public void deleteWithChecks(ConfiguracioFirma configuracioFirma) throws I18NException {

        // 1 .- Verificam que no hi hagi perfils bons associats a aquesta "Configuracio de Fima" 
        List<String> codisPerfil = perfilLogicaService.executeQuery(PerfilFields.CODI,
                Where.AND(PerfilFields.CONFIGURACIOFIRMAID.equal(configuracioFirma.getConfiguracioFirmaID()),
                        PerfilFields.USPERFIL.greaterThan(0))

        );

        if (codisPerfil != null && !codisPerfil.isEmpty()) {

            StringBuffer perfilsToDelete = new StringBuffer(
                    "Per esborrar aquesta configuració de firma caldria esborrar o modificar el tipus de firma dels perfils amb el codis: ");
            for (String codiPerfil : codisPerfil) {
                perfilsToDelete.append(codiPerfil).append(", ");
            }

            throw new I18NException("genapp.comodi", perfilsToDelete.toString());

        }

        // 2.- Eliminam dels perfils "de transacció" la referència a aquesta "Configuració de Firma"
        perfilLogicaService.update(PerfilFields.CONFIGURACIOFIRMAID, null,
                Where.AND(PerfilFields.CONFIGURACIOFIRMAID.equal(configuracioFirma.getConfiguracioFirmaID()),
                        PerfilFields.USPERFIL.lessThan(0)));

        // 3.- Esborrar la configuració de firma
        this.delete(configuracioFirma.getConfiguracioFirmaID());

    }

}