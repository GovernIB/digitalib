package es.caib.digitalib.api.interna.all.dadesobertes.transaccions;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.OrderType;
import org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.utils.Utils;
import org.fundaciobit.pluginsib.utils.rest.GenAppEntityConverter;
import org.fundaciobit.pluginsib.utils.rest.GenAppRangeOfDates;
import org.fundaciobit.pluginsib.utils.rest.GenAppRestUtils;
import org.fundaciobit.pluginsib.utils.rest.RestException;
import org.fundaciobit.pluginsib.utils.rest.RestExceptionInfo;
import org.fundaciobit.pluginsib.utils.rest.RestUtils;

import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.ejb.UsuariPersonaService;
import es.caib.digitalib.logic.TransaccioLogicaService;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.model.fields.UsuariPersonaQueryPath;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;

/**
 * Servei d'Estadistiques de Transaccions JSON d'accés Públic
 *
 * @author anadal
 *
 */
@Path(TransaccionsService.PATH)
@OpenAPIDefinition(
        tags = @Tag(
                name = TransaccionsService.TAG_NAME,
                description = "Servei de informació d'estadístiques de Transaccions d'Accés Públic"))
public class TransaccionsService extends RestUtils {

    protected static Logger log = Logger.getLogger(TransaccionsService.class);

    public static final int DEFAULT_ITEMS_PER_PAGE = 50;

    public static final String PATH = "/public/dadesobertes/transaccions";

    public static final String TAG_NAME = "Transaccions";

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    @EJB(mappedName = UsuariPersonaService.JNDI_NAME)
    protected es.caib.digitalib.ejb.UsuariPersonaService usuariPersonaEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioService.JNDI_NAME)
    protected es.caib.digitalib.ejb.UsuariAplicacioService usuariAplicacioEjb;

    @Path("/consulta")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            tags = TAG_NAME,
            operationId = "consulta",
            summary = "Retorna estadístiques de les transaccions a DigitalIB")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operació realitzada correctament",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = LlistatDeTransaccionsPaginada.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Paràmetres incorrectes",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class))),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error no controlat",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class))) })
    public LlistatDeTransaccionsPaginada consultaTransaccions(
            @Parameter(
                    name = "startdate",
                    description = "Data d'inici de la consulta. Opcional. Format yyyy-mm-dd (ISO 8601)",
                    required = false,
                    example = "2023-07-24",
                    in = ParameterIn.QUERY,
                    schema = @Schema(
                            implementation = String.class,
                            pattern = DATE_PATTERN_ISO8601_ONLYDATE)) @QueryParam("startdate") String startdate,

            @Parameter(
                    name = "enddate",
                    description = "Data final de la consulta. Opcional. Format yyyy-mm-dd (ISO 8601)",
                    required = false,
                    example = "2024-12-31",
                    in = ParameterIn.QUERY,
                    schema = @Schema(
                            implementation = String.class,
                            pattern = DATE_PATTERN_ISO8601_ONLYDATE)) @QueryParam("enddate") String enddate,

            @Parameter(
                    name = "appname",
                    description = "Username de l'app. Opcional. Només es pot elegir appname o usrname a la vegada",
                    required = false,
                    in = ParameterIn.QUERY,
                    schema = @Schema(implementation = String.class)) @QueryParam("appname") String appname,

            @Parameter(
                    name = "usrname",
                    description = "Username de la persona. Opcional. Només es pot elegir appname o usrname a la vegada",
                    required = false,
                    in = ParameterIn.QUERY,
                    schema = @Schema(implementation = String.class)) @QueryParam("usrname") String usrname,

            @Parameter(
                    name = "estat",
                    description = "Estat en que es troba la transacció.  Opcional. Valors possibles són: \"EXPIRAT\",\"CANCELAT\",\"ERROR\",\"ID\",\"ENPROGRES\",\"OK\"",
                    required = false,
                    in = ParameterIn.QUERY,
                    schema = @Schema(
                            implementation = String.class,
                            pattern = "^(EXPIRAT|CANCELAT|ERROR|ID|ENPROGRES|OK)$")) @QueryParam("estat") String estat,

            @Parameter(
                    name = "page",
                    description = "Numero de pàgina quan el llistat és paginat. Per defecte 1.",
                    required = false,
                    in = ParameterIn.QUERY,
                    schema = @Schema(implementation = Integer.class)) @QueryParam("page") Integer page,

            @Parameter(
                    name = "page-size",
                    description = "Número d'elements a retornar per pàgina. Per defecte " + DEFAULT_ITEMS_PER_PAGE,
                    required = false,
                    in = ParameterIn.QUERY,
                    schema = @Schema(implementation = Integer.class)) @QueryParam("page-size") Integer pageSize,
            @Parameter(
                    name = "language",
                    description = "Idioma en que retornar les dades. Opcional.",
                    required = false,
                    in = ParameterIn.QUERY,
                    schema = @Schema(implementation = String.class)) @QueryParam("language") String language,

            @Parameter(hidden = true) @Context HttpServletRequest request) throws RestException {

        language = checkLanguage(language);

        try {

            if (page == null) {
                page = 1;
            }

            if (pageSize == null) {
                pageSize = DEFAULT_ITEMS_PER_PAGE;
            }

            StringBuilder nextQuery = new StringBuilder(
                    (Configuracio.getBackUrl().replace(Constants.DIGITALIB_APP_NAME + "back", "")
                            + request.getContextPath()).replace("//", "/") + PATH + "/consulta?" + "page=" + (page + 1)
                            + "&page-size=" + pageSize);

            // Convertir Dates a tipus Date, check de dates i check de rang
            GenAppRangeOfDates grod;
            grod = GenAppRestUtils.checkRangeOfOnlyDates(startdate, "startdate", enddate, "enddate",
                    TransaccioFields.DATAINICI, language);

            // Check Status
            final Integer status;
            if (estat == null) {
                status = null;
            } else {
                if (estat.equalsIgnoreCase("EXPIRAT")) {
                    status = Constants.TRANSACCIO_ESTAT_CODI_EXPIRAT;
                } else if (estat.equalsIgnoreCase("CANCELAT")) {
                    status = Constants.TRANSACCIO_ESTAT_CODI_CANCELAT;
                } else if (estat.equalsIgnoreCase("ERROR")) {
                    status = Constants.TRANSACCIO_ESTAT_CODI_ERROR;
                } else if (estat.equalsIgnoreCase("ID")) {
                    status = Constants.TRANSACCIO_ESTAT_CODI_ID;
                } else if (estat.equalsIgnoreCase("ENPROGRES")) {
                    status = Constants.TRANSACCIO_ESTAT_CODI_ENPROGRES;
                } else if (estat.equalsIgnoreCase("OK")) {
                    status = Constants.TRANSACCIO_ESTAT_CODI_OK;
                } else {
                    status = null;
                }
            }

            Where wUsr;
            if (usrname == null) {
                wUsr = null;
            } else {
                Long usrID = usuariPersonaEjb.executeQueryOne(UsuariPersonaFields.USUARIPERSONAID,
                        UsuariPersonaFields.USERNAME.equal(usrname));

                if (usrID == null) {
                    String msg;
                    if ("es".equalsIgnoreCase(language)) {
                        msg = "No hay ningún usuario persona con nombre ]" + usrname + "[";
                    } else {
                        msg = "No hi ha cap usuari persona amb nom ]" + usrname + "[";
                    }
                    throw new RestException(msg, Status.BAD_REQUEST);
                }

                wUsr = UsuariPersonaFields.USUARIPERSONAID.equal(usrID);
                nextQuery.append("&usrname=" + usrname);
            }

            Where wApp;
            if (appname == null) {
                wApp = null; // XYZ ZZZ ZZZ USUARIAPLICACIOID.isNotNull();
            } else {
                Long appID = usuariAplicacioEjb.executeQueryOne(UsuariAplicacioFields.USUARIAPLICACIOID,
                        UsuariAplicacioFields.USERNAME.equal(appname));

                if (appID == null) {
                    String msg;
                    if ("es".equalsIgnoreCase(language)) {
                        msg = "No hay ningún usuario aplicación con nombre ]" + appname + "[";
                    } else {
                        msg = "No hi ha cap usuari aplicació amb nom ]" + appname + "[";
                    }
                    throw new RestException(msg, Status.BAD_REQUEST);
                }

                wApp = UsuariAplicacioFields.USUARIAPLICACIOID.equal(appID);
                nextQuery.append("&appname=" + appname);
            }

            if (wApp != null && wUsr != null) {
                // TODO XYZ ZZZ Traduir
                String msg;
                if ("es".equalsIgnoreCase(language)) {
                    msg = "No puede elegir appname y usrname a la vez.";
                } else {
                    msg = "No pot elegir appname i usrname a la vegada.";
                }
                throw new RestException(msg, Status.BAD_REQUEST);
            }

            // Check status

            Where wStatus = null;
            if (estat != null) {
                wStatus = TransaccioFields.ESTATCODI.equal(status);
                nextQuery.append("&estat=" + estat);
            }

            Where where = Where.AND(grod.getWhere(), wApp, wUsr, wStatus);

            log.info("Where: " + ((where == null) ? "--NULL--" : where.toSQL()));

            final OrderBy orderBy = new OrderBy(TransaccioFields.DATAINICI, OrderType.DESC);

            final boolean searchUsrApp = (wApp == null && wUsr == null);

            TransaccioToTransaccioConverter converter = new TransaccioToTransaccioConverter(language, searchUsrApp,
                    usrname, appname);

            final String name;
            if ("es".equals(language)) {
                name = "Lista de escaneos realizados utilizando DigitalIB";
            } else {
                name = "Llista d'escanejos realitzats emprant DigitalIB";
            }

            LlistatDeTransaccionsPaginada paginacio = GenAppRestUtils.createRestPagination(
                    LlistatDeTransaccionsPaginada.class, this.transaccioLogicaEjb, (int) page, (int) pageSize, where,
                    orderBy, converter, name, nextQuery);

            return paginacio;

        } catch (RestException re) {
            throw re;
        } catch (Throwable th) {

            String msg;
            if (th instanceof I18NException) {
                I18NException ie = (I18NException) th;
                msg = I18NLogicUtils.getMessage(ie, new Locale(language));
            } else {
                msg = th.getMessage();
            }

            if ("es".equalsIgnoreCase(language)) {
                msg = "Error en la consulta d'estadístiques: " + msg;
            } else {
                msg = "Error en la consulta de estadísticas: " + msg;
            }

            log.error(msg, th);

            throw new RestException(msg, th);
        }
    }

    /**
     * 
     * @author anadal
     *
     */
    public class TransaccioToTransaccioConverter implements GenAppEntityConverter<Transaccio, TransaccioInfo> {

        protected final String language;

        protected final boolean searchUsrApp;

        protected Map<String, String> usuaris = null;
        protected Map<String, String> aplicacions = null;

        final Map<String, String> configuracioGrupMapByUsrName = new HashMap<String, String>();

        protected String u = null;
        protected String a = null;

        public TransaccioToTransaccioConverter(String language, final boolean searchUsrApp, String usrName,
                String appName) throws I18NException {
            this.language = language;
            this.searchUsrApp = searchUsrApp;

            if (searchUsrApp) {
                {
                    List<StringKeyValue> aplicacionsKV;
                    SelectMultipleStringKeyValue smkv1;
                    smkv1 = new SelectMultipleStringKeyValue(UsuariAplicacioFields.USUARIAPLICACIOID.select,
                            UsuariAplicacioFields.USERNAME.select);
                    aplicacionsKV = usuariAplicacioEjb.executeQuery(smkv1);

                    aplicacions = Utils.listToMap(aplicacionsKV);
                }
                {
                    List<StringKeyValue> usuarisPersonaKV;
                    SelectMultipleStringKeyValue smkv2;
                    smkv2 = new SelectMultipleStringKeyValue(UsuariPersonaFields.USUARIPERSONAID.select,
                            UsuariPersonaFields.USERNAME.select);
                    usuarisPersonaKV = usuariPersonaEjb.executeQuery(smkv2);

                    usuaris = Utils.listToMap(usuarisPersonaKV);
                }

            } else {
                u = usrName;
                a = appName;
            }

        }

        @Override
        public TransaccioInfo convert(Transaccio transaccio) throws RestException {

            long transaccioID = transaccio.getTransaccioID();
            String funcionariUsername = transaccio.getFuncionariUsername();

            //String fitxerNom = null;
            long fitxerMidaBytes = -1;
            if (transaccio.getFitxerEscanejat() != null) {
                //fitxerNom = transaccio.getFitxerEscanejat().getNom();
                fitxerMidaBytes = transaccio.getFitxerEscanejat().getTamany();
            }

            String color = null;
            {
                Integer pixel = transaccio.getInfoScanPixelType();

                if (pixel != null) {

                    if (pixel < 8) {
                        color = "B/N";
                    } else if (pixel < 32) {
                        color = "Gris";
                    } else {
                        color = "Color";
                    }
                }
            }

            Integer resolucio = transaccio.getInfoScanResolucioPpp();
            String midaPaper = transaccio.getInfoScanPaperSize();
            Timestamp dataCaptura = transaccio.getInfoScanDataCaptura();
            if (dataCaptura == null) {
                dataCaptura = new Timestamp(transaccio.getDataInici().getTime());
            }

            if (searchUsrApp) {
                a = aplicacions.get(String.valueOf(transaccio.getUsuariAplicacioId()));
                u = usuaris.get(String.valueOf(transaccio.getUsuariPersonaId()));
            }

            String e;

            int status = transaccio.getEstatCodi(); // TODO

            switch (status) {
                case Constants.TRANSACCIO_ESTAT_CODI_EXPIRAT:
                    e = "EXPIRAT";
                break;

                case Constants.TRANSACCIO_ESTAT_CODI_CANCELAT:
                    e = "CANCELAT";
                break;

                case Constants.TRANSACCIO_ESTAT_CODI_ERROR:
                    e = "ERROR";
                break;

                case Constants.TRANSACCIO_ESTAT_CODI_ID:
                    e = "ID";
                break;

                case Constants.TRANSACCIO_ESTAT_CODI_ENPROGRES:
                    e = "ENPROGRES";
                break;

                case Constants.TRANSACCIO_ESTAT_CODI_OK:
                    e = "OK";
                break;

                default:
                    e = null;

            }

            final Long transaccioMultipleID = transaccio.getTransaccioMultipleID();
            final String codiDir3 = transaccio.getSignParamFuncionariDir3();

            final String configuracioGrupNom;
            if (u == null) {
                configuracioGrupNom = null;
            } else {
                // 
                String cgn = configuracioGrupMapByUsrName.get(u);
                if (cgn == null) {
                    UsuariPersonaQueryPath upqp = new UsuariPersonaQueryPath();
                    try {
                        cgn = usuariPersonaEjb.executeQueryOne(upqp.CONFIGURACIOGRUP().NOM(),
                                UsuariPersonaFields.USERNAME.equal(u));
                    } catch (I18NException th) {
                        String msg;
                        I18NException ie = (I18NException) th;
                        msg = I18NLogicUtils.getMessage(ie, new Locale(language));

                        if ("es".equalsIgnoreCase(language)) {
                            msg = "Error cercant la configuració de grup per l'usuari [" + u + "] :" + msg;
                        } else {
                            msg = "Error buscando la configuración de grupo para el usuario[" + u + "]: " + msg;
                        }

                        log.error(msg, th);

                        throw new RestException(msg, th);
                    }

                    configuracioGrupMapByUsrName.put(u, cgn);

                }
                configuracioGrupNom = cgn;
            }

            final String idiomaDocument = transaccio.getInfoScanLanguageDoc();
            final Boolean duplex = transaccio.getInfoScanDuplex();
            final String missatgeError = transaccio.getEstatMissatge();

            final Integer origenInt = transaccio.getArxiuReqParamOrigen();

            final String origen;
            if (origenInt == null) {
                origen = null;
            } else if (origenInt == Constants.ORIGEN_CIUTADA) {
                origen = "es".equals(language) ? "Ciudadano" : "Ciutadà";
            } else if (origenInt == Constants.ORIGEN_ADMINISTRACIO) {
                origen = "es".equals(language) ? "Administración" : "Administració";
            } else {
                log.error("Origen Desconegut " + origenInt + " per transaccióamb ID  " + transaccioID);
                origen = null;
            }

            final String tipusDocumental = transaccio.getInfoScanDocumentTipus();

            return new TransaccioInfo(transaccioID, transaccioMultipleID, funcionariUsername, a, u, fitxerMidaBytes,
                    color, resolucio, midaPaper, dataCaptura, e, codiDir3, configuracioGrupNom, idiomaDocument, duplex,
                    missatgeError, origen, tipusDocumental);

        }

    }

}
