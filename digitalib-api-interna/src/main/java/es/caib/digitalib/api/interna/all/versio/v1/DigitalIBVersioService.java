package es.caib.digitalib.api.interna.all.versio.v1;

import java.util.Locale;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.utils.rest.RestException;
import org.fundaciobit.pluginsib.utils.rest.RestExceptionInfo;
import org.fundaciobit.pluginsib.utils.rest.RestUtils;

import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Version;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;

/**
 *  Servei JSON d'accés Públic que retorna informació de la versió
 */
@Path("/public/versio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@OpenAPIDefinition(
        tags = @Tag(
                name = DigitalIBVersioService.TAG_NAME,
                description = "Servei JSON d'accés Públic que retorna informació de la versió"),
        info = @Info(
                title = "API REST INTERNA de DigitalIB - Versió",
                description = "Conjunt de Serveis REST de DigitalIB per consultar la Versióde l'Aplicació.",
                version = "1.0-SNAPSHOT",
                license = @License(
                        name = "European Union Public Licence (EUPL v1.2)",
                        url = "https://joinup.ec.europa.eu/sites/default/files/custom-page/attachment/eupl_v1.2_es.pdf"),
                contact = @Contact(
                        name = "Departament de Govern Digital a la Fundació Bit",
                        email = "otae@fundaciobit.org",
                        url = "https://governdigital.fundaciobit.org")),

        externalDocs = @ExternalDocumentation(
                description = "Api Rest Interna (GovernIB Github)",
                url = "https://github.com/GovernIB/digitalib/tree/digitalib-2.0/digitalib-api-interna-versio-v1")
        
        )
public class DigitalIBVersioService {

    protected static Logger log = Logger.getLogger(DigitalIBVersioService.class);

    public static final String TAG_NAME = "Versio";

    @Path("/versio")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(tags = TAG_NAME, operationId = "versio", summary = "Versio de l'Aplicació", method = "get")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Versió de l'Aplicació DigitalIB",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = Versio.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Paràmetres incorrectes",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON)),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error no controlat en el servidor",
                            content = { @Content(
                                    mediaType = RestUtils.MIME_APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }) })
    public Versio versio(@Parameter(
            description = "Codi de l'idioma",
            required = false,
            example = "ca",
            schema = @Schema(implementation = String.class)) @QueryParam("language") String language) {

        try {
            language = RestUtils.checkLanguage(language);

            Versio v = new Versio();
            v.setVersio(new Version().getVersion());
            v.setCaib(Configuracio.isCAIB());
            v.setLanguage(language);

            return v;

        } catch (Throwable th) {
            return processException("Cridada api rest 'versio'", language, th);
        }
    }

    protected <T> T processException(final String methodName, String language, Throwable th) throws RestException {
        RestException oae;
        String msg;
        if (th instanceof RestException) {
            oae = (RestException) th;
            msg = th.getMessage();
        } else {
            if (th instanceof I18NException) {
                msg = I18NLogicUtils.getMessage((I18NException) th, new Locale(language));
            } else {
                msg = th.getMessage();
            }
            oae = new RestException(msg, th, Status.INTERNAL_SERVER_ERROR);
        }

        log.error("Error en " + methodName + ": " + msg, th);
        throw oae;
    }

}
