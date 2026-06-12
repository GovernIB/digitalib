package es.caib.digitalib.api.interna.secure.comanda.v1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/**
 * ParamConverterProvider per a OffsetDateTime, que permet convertir entre String i OffsetDateTime en els paràmetres de les peticions REST.
 * 
 * Evita el següent error de JBoss:
 * 08:20:42,552 ERROR [org.jboss.as.controller.management-operation] (DeploymentScanner-threads - 1) WFLYCTL0013: Operaci¾n ("full-replace-deployment")
 *  fall¾ - direcci¾n: ([]) - descripci¾n de la falla: {"WFLYCTL0080: Servicios fallidos" =>
 *   {"jboss.deployment.subunit.\"evidenciesib.ear\".\"evidenciesib-api-externa.war\".undertow-deployment" =>
 *    "java.lang.RuntimeException: RESTEASY003875: Unable to find a constructor that takes a String param or a valueOf()
 *     or fromString() method for javax.ws.rs.QueryParam(\"dataPeriode\") on public 
 *     es.caib.comanda.model.server.monitoring.SalutInfo es.caib.evidenciesib.api.externa.secure.comanda.v1.ComandaSalutService.salut
 *     (java.time.OffsetDateTime,java.time.OffsetDateTime) for basetype: java.time.OffsetDateTime
 *      Caused by: java.lang.RuntimeException: RESTEASY003875: Unable to find a constructor that takes a String param
 *       or a valueOf() or fromString() method for javax.ws.rs.QueryParam(\"dataPeriode\") on public
 *        es.caib.comanda.model.server.monitoring.SalutInfo es.caib.evidenciesib.api.externa.secure.comanda.v1.
 *        ComandaSalutService.salut(java.time.OffsetDateTime,java.time.OffsetDateTime) for basetype: java.time.OffsetDateTime"}}
 * 
 * @author anadal (u80067)
 * 24 mar 2026 8:33:27
 */
@Provider
public class OffsetDateTimeParamConverterProvider implements ParamConverterProvider {

    private static final OffsetDateTimeParamConverter CONVERTER = new OffsetDateTimeParamConverter();

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (OffsetDateTime.class.equals(rawType)) {
            ParamConverter<T> pc = (ParamConverter<T>) CONVERTER;
            return pc;
        }
        return null;
    }

    protected static class OffsetDateTimeParamConverter implements ParamConverter<OffsetDateTime> {

        @Override
        public OffsetDateTime fromString(String value) {
            if (value == null || value.isEmpty()) {
                return null;
            }
            return OffsetDateTime.parse(value);
        }

        @Override
        public String toString(OffsetDateTime value) {
            return value == null ? null : value.toString();
        }
    }
}
