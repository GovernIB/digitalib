package es.caib.digitalib.logic.utils;

import java.util.Locale;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.jboss.logging.Logger;

import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.logic.TransaccioLogicaService;

/**
 * 
 * @author anadal
 * 27 nov 2024 9:23:06
 */
@RunAs(Constants.DIB_ADMIN)
@Singleton
public class CleanOldFilesScheduler {

    public Logger log = Logger.getLogger(CleanOldFilesScheduler.class);

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    //@Schedule(minute = "*/3", hour = "*", persistent = false) // Cada 3 minuts
    @Schedule(minute = "*/10", hour = "4", persistent = false) // Cada dia cada 10 minuts entre les 04:00h i les 4:59h 
    public void netejarFitxersAplicacio() {
        log.info(" ============   Netejar fitxers Aplicacio =============");
        try {
            transaccioLogicaEjb.netejaDeFitxersNocturnAplicacio();
        } catch (I18NException e) {
            String msg = I18NLogicUtils.getMessage(e, new Locale("ca"));
            log.error("Error cridant a netejarFitxers Aplicacio: " + msg, e);
        } catch (Throwable th) {
            log.error("Error cridant a netejarFitxers Aplicacio: " + th.getMessage(), th);
        }
    }

    //@Schedule(minute = "*/3", hour = "*", persistent = false) // Cada 3 minuts
    @Schedule(minute = "*/10", hour = "5", persistent = false) // Cada dia cada 10 minuts entre les 05:00h i les 5:59h
    public void netejarFitxersPersona() {
        log.info(" ============   Netejar fitxers Persona =============");
        try {
            transaccioLogicaEjb.netejaDeFitxersNocturnPersona();
        } catch (I18NException e) {
            String msg = I18NLogicUtils.getMessage(e, new Locale("ca"));
            log.error("Error cridant a netejarFitxers Persona: " + msg, e);
        } catch (Throwable th) {
            log.error("Error cridant a netejarFitxers Persona: " + th.getMessage(), th);
        }
    }

    @Schedule(minute = "*/10", hour = "6", persistent = false) // Cada dia cada 10 minuts entre les 05:00h i les 5:59h 
    public void netejarTransaccionsCaducades() {
        log.info(" Entra a neteja de transaccions caducades");
        try {
            transaccioLogicaEjb.expiraTransaccionsCaducades();
        } catch (I18NException e) {
            String msg = I18NLogicUtils.getMessage(e, new Locale("ca"));
            log.error("Error controlat cridant a expiraTransaccionsCaducades: " + msg, e);
        } catch (Throwable th) {
            log.error("Error desconegut cridant a expiraTransaccionsCaducades: " + th.getMessage(), th);
        }
    }

}
