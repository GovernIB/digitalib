package es.caib.digitalib.back.utils;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

import es.caib.digitalib.back.security.LoginInfo;

/**
 * 
 * @author anadal
 *
 */
public class DigitalIBSessionLocaleResolver extends SessionLocaleResolver {

    protected final Logger log = Logger.getLogger(getClass());

    @Override
    protected Locale determineDefaultLocale(HttpServletRequest request) {
        try {

            String pathInfo = request.getRequestURI();
            
            
            //request.getRequestURI() => /digitalib/common/rest/apimassivescanwebsimple/v1/getTransactionID
            //request.getRequestURL() => http://127.0.0.1:8080/digitalib/common/rest/apimassivescanwebsimple/v1/getTransactionID


            if (pathInfo.startsWith(request.getContextPath() + "/public")) {
                log.info("\n\n"
                        + "DigitalIBSessionLocaleResolver::determineDefaultLocale() => PUBLIC no feim res."
                        + "\n\n");
                return super.determineDefaultLocale(request);
            }

            String idioma;
            try {
                // Posar l'idioma de l'usuari
                idioma = LoginInfo.getInstance().getUsuariPersona().getIdiomaID();
                log.info(
                        "\n\n" + "DigitalIBSessionLocaleResolver::determineDefaultLocale() => "
                                + idioma + "\n\n");
            } catch (Exception e) {
                log.warn("\n\n"
                        + "DigitalIBSessionLocaleResolver::ERROR INTENTANT OBTENIR IDIONA DE USUARI LOGUEJAT() => "
                        + e.getMessage() + "\n\n");
                idioma = es.caib.digitalib.utils.Configuracio.getDefaultLanguage();
            }

            log.info("\n\n" + "DigitalIBSessionLocaleResolver::determineDefaultLocale() => "
                    + idioma + "\n\n");
            Locale loc = new Locale(idioma);
            LocaleContextHolder.setLocale(loc);
            try {
                this.setLocale(request, null, loc);
            } catch (Exception e) {
                WebUtils.setSessionAttribute(request, LOCALE_SESSION_ATTRIBUTE_NAME, loc);
            }
            return loc;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return super.determineDefaultLocale(request);
        }

    }

}
