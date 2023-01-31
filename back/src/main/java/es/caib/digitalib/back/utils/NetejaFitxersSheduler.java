package es.caib.digitalib.back.utils;

import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.utils.Constants;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Locale;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;

/**
 * 
 * @author anadal (u80067)
 * Per funcionar requereix afegir al /digitalib-back/src/main/webapp/WEB-INF/digitalibback-servlet.xml 
 * la següent entrada <task:annotation-driven/> conjuntament amb els beans
 *        xmlns:task="http://www.springframework.org/schema/task"
 *        xsi:schemaLocation=" ... http://www.springframework.org/schema/task/spring-task.xsd">
 *
 */
@Service
@RunAs(Constants.DIB_ADMIN)
public class NetejaFitxersSheduler {

    protected final Logger log = Logger.getLogger(getClass());

    @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
    protected TransaccioLogicaLocal transaccioLogicaEjb;

    @Scheduled(cron = "0 */10 4 * * *") // Cada dia cada 10 minuts entre les 04:00h i les 4:59h 
    //@Scheduled(cron = "0 * * ? * *") // Cada minut
    public void netejarFitxersAplicacio() {

        try {
            transaccioLogicaEjb.netejaDeFitxersNocturnAplicacio();
        } catch (I18NException e) {
            String msg = I18NLogicUtils.getMessage(e, new Locale("ca"));
            log.error("Error cridant a netejarFitxers Aplicacio: " + msg, e);
        } catch(Throwable th) {
            log.error("Error cridant a netejarFitxers Aplicacio: " + th.getMessage(), th);
        }

    }
    
    
    @Scheduled(cron = "0 */10 5 * * *") // Cada dia cada 10 minuts entre les 05:00h i les 5:59h 
    //@Scheduled(cron = "0 * * ? * *") // Cada minut
    public void netejarFitxersPersona() {

        try {
            transaccioLogicaEjb.netejaDeFitxersNocturnPersona();
        } catch (I18NException e) {
            String msg = I18NLogicUtils.getMessage(e, new Locale("ca"));
            log.error("Error cridant a netejarFitxers Persona: " + msg, e);
        }  catch(Throwable th) {
            log.error("Error cridant a netejarFitxers Persona: " + th.getMessage(), th);
        }

    }
}