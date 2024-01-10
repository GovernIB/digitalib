package es.caib.digitalib.api.interna.all.dadesobertes.transaccions;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.OrderType;
import org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.utils.Utils;
import org.fundaciobit.pluginsib.core.utils.ISO8601;
import org.fundaciobit.pluginsib.utils.rest.GenAppPaginationUtils;
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
 * Servei d'Estadistiquesde Transaccions JSON d'accés Públic
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

    public static final String DATE_PATTERN_DD_MM_YYYY = "^(?:(?:31(-)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(-)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(-)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(-)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");

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
                                    schema = @Schema(implementation = Transaccions.class))),
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
    public Transaccions consultaTransaccions(
            @Parameter(
                    name = "startdate",
                    description = "Data d'inici de la consulta. Opcional. Format dd-mm-yyyy",
                    required = false,
                    example = "24-07-2023",
                    in = ParameterIn.QUERY,
                    schema = @Schema(
                            implementation = String.class,
                            pattern = DATE_PATTERN_DD_MM_YYYY)) @QueryParam("startdate") String startdate,

            @Parameter(
                    name = "enddate",
                    description = "Data final de la consulta. Opcional. Format dd-mm-yyyy",
                    required = false,
                    example = "31-12-2024",
                    in = ParameterIn.QUERY,
                    schema = @Schema(
                            implementation = String.class,
                            pattern = DATE_PATTERN_DD_MM_YYYY)) @QueryParam("enddate") String enddate,

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

            @Parameter(hidden = true) @Context HttpServletRequest request) throws RestException {

        final String language = "ca";

        try {

            if (page == null) {
                page = 1;
            }

            if (pageSize == null) {
                pageSize = DEFAULT_ITEMS_PER_PAGE;
            }

            log.info("page => " + page);
            log.info("page-size => " + pageSize);

            /*
            
            log.info("startDate => " + startdate);
            log.info("endDate => " + enddate);
            log.info("appname => " + appname);
            log.info("estat => " + estat);
            
            
            
            Map<String, String[]> params = request.getParameterMap();
            log.info("============== " + params.size() + " ================ ");
            
            for (Entry<String, String[]> entry : params.entrySet()) {
                log.info(entry.getKey() + " => " + Arrays.toString(entry.getValue()));
            }
            log.info("============================== ");
            */

            final Date startDate = convertToDate(startdate);
            log.info("startDate DATE => " + startDate);

            final Date endDate = convertToDate(enddate);

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

            return consulta(startDate, endDate, appname, usrname, status, page, pageSize, request);

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

            log.error("Error en la consulta d'estadistiques: " + msg, th);

            throw new RestException(msg, th);
        }
    }

    protected Date convertToDate(String dateStr) throws ParseException {
        if (dateStr == null || dateStr.trim().length() == 0) {
            return null;
        }
        return SDF.parse(dateStr);
    }

    protected Transaccions consulta(Date startDate, Date endDate, String appName, String usrName, Integer estat,
            int page, int pageSize, HttpServletRequest request) throws I18NException {
        
        
        StringBuilder nextQuery = new StringBuilder("page=" + (page + 1) + "&page-size=" + pageSize);

        List<Transaccio> transaccions;

        Where usr;
        if (usrName == null) {
            usr = null; // XYZ ZZZ ZZZ USUARIAPLICACIOID.isNotNull();
        } else {
            Long usrID = usuariPersonaEjb.executeQueryOne(UsuariPersonaFields.USUARIPERSONAID,
                    UsuariPersonaFields.USERNAME.equal(usrName));

            if (usrID == null) {
                throw new RestException("No hi ha cap usuari persona amb nom ]" + appName + "[", 404);
            }

            usr = UsuariPersonaFields.USUARIPERSONAID.equal(usrID);
            nextQuery.append("&usrname=" + usrName);
        }

        Where app;
        if (appName == null) {
            app = null; // XYZ ZZZ ZZZ USUARIAPLICACIOID.isNotNull();
        } else {
            Long appID = usuariAplicacioEjb.executeQueryOne(UsuariAplicacioFields.USUARIAPLICACIOID,
                    UsuariAplicacioFields.USERNAME.equal(appName));

            if (appID == null) {
                throw new RestException("No hi ha cap usuari aplicació amb nom ]" + appName + "[", 404);
            }

            app = UsuariAplicacioFields.USUARIAPLICACIOID.equal(appID);
            nextQuery.append("&appname=" + appName);
        }

        if (app != null && usr != null) {
            throw new RestException("No pot elegir appname i usrname a la vegada.", 404);
        }

        TransaccioPaginacio paginacio;
        {
            Where sd = null;
            if (startDate != null) {
                sd = TransaccioFields.DATAINICI.greaterThanOrEqual(new Timestamp(startDate.getTime()));
                nextQuery.append("&startdate=" + SDF.format(startDate));
            }
            Where ed = null;
            if (endDate != null) {
                ed = TransaccioFields.DATAINICI.lessThanOrEqual(new Timestamp(endDate.getTime()));
                nextQuery.append("&enddate=" + SDF.format(endDate));
            }

            Where status = null;
            if (estat != null) {
                status = TransaccioFields.ESTATCODI.equal(estat);
                nextQuery.append("&estat=" + estat);
            }

            Where where = Where.AND(sd, ed, app, usr, status);

            log.info("Where: " + ((where == null) ? "--NULL--" : where.toSQL()));

            final OrderBy orderBy = new OrderBy(TransaccioFields.DATAINICI, OrderType.DESC);

            /*
             * 
             * select t.transaccioid, t.funcionariusername, u.username, f.nom, f.tamany as
             * "Mida (bytes)", DECODE(t.infoscanpixeltype, 1,'B/N',8,'Gris',32,'Color') as
             * "Color?", t.infoscanresolucioppp as "Resolució", t.infoscanpapersize,
             * t.infoscandatacaptura from dib_transaccio t, dib_fitxer f,
             * dib_usuariaplicacio u where t.fitxersignaturaid = f.fitxerid and
             * u.usuariaplicacioid = t.usuariaplicacioid and t.usuariaplicacioid = XXXX
             * order by t.infoscandatacaptura DESC
             * 
             * 
             */

            //transaccions = transaccioLogicaEjb.select(where, orderBy);

            paginacio = GenAppPaginationUtils.createRestPagination(TransaccioPaginacio.class, this.transaccioLogicaEjb, (int) page,
                    (int) pageSize, where, orderBy);

            transaccions = paginacio.getData();
        }

        List<TransaccioInfo> resultat = new ArrayList<TransaccioInfo>();

        if (transaccions != null && transaccions.size() != 0) {

            final boolean searchUsrApp = (app == null && usr == null);

            Map<String, String> usuaris = null;
            Map<String, String> aplicacions = null;
            String u = null;
            String a = null;

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

            final Map<String, String> configuracioGrupMapByUsrName = new HashMap<String, String>();

            for (Transaccio transaccio : transaccions) {

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

                String dataCapturaISO = ISO8601.dateToISO8601(dataCaptura);

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
                        cgn = usuariPersonaEjb.executeQueryOne(upqp.CONFIGURACIOGRUP().NOM(),
                                UsuariPersonaFields.USERNAME.equal(u));

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
                    origen = "Ciutadà";
                } else if (origenInt == Constants.ORIGEN_ADMINISTRACIO) {
                    origen = "Administració";
                } else {
                    log.error("Origen Desconegut " + origenInt + " per transaccióamb ID  " + transaccioID);
                    origen = null;
                }

                final String tipusDocumental = transaccio.getInfoScanDocumentTipus();

                resultat.add(new TransaccioInfo(transaccioID, transaccioMultipleID, funcionariUsername, a, u,
                        fitxerMidaBytes, color, resolucio, midaPaper, dataCapturaISO, e, codiDir3, configuracioGrupNom,
                        idiomaDocument, duplex, missatgeError, origen, tipusDocumental));

            }
        }

        String nextUrl = null;
        if (paginacio.getTotalpages() != page) {
            nextUrl = (Configuracio.getBackUrl().replace(Constants.DIGITALIB_APP_NAME + "back",
                    "") + request.getContextPath() + PATH + "/consulta?" + nextQuery.toString()).replace("//", "/");
        }
        final String dateDownload = SDF.format(new Date());

        return new Transaccions(resultat, paginacio.getPage(), paginacio.getPagesize(), paginacio.getTotalpages(),
                paginacio.getTotalcount(), nextUrl, dateDownload);

    }

    /**
     * 
     * @param <D>
     * @param <P>
     * @param classe
     * @param ejb
     * @param page
     * @param pagesize
     * @param w
     * @param orderBy
     * @return
     * @throws I18NException 
     */
    /*
    protected static <D extends IGenAppEntity, P extends AbstractPagination<D>> P createRestPagination(Class<P> classe,
            ITableManager<D, Long> ejb, int page, int pagesize, Where w, OrderBy orderBy) throws I18NException {

        final int firstResult = (page - 1) * pagesize;
        final int maxResults = pagesize;
        final List<D> llistat = ejb.select(w, null, firstResult, maxResults, orderBy);

        long countTotal = ejb.count(w);

        // PAGINACIO
        final int pageSizeOutput = pagesize;
        final int pageOutput = page;
        final int totalPages = (int) (countTotal / pagesize) + ((countTotal % pagesize == 0) ? 0 : 1);

        P paginacio;
        try {
            paginacio = classe.getConstructor().newInstance();
        } catch (Throwable e) {
            String msg = "Error instanciant un objecte de la classe " + classe + ": " + e.getMessage();
            log.error(msg, e);
            throw new I18NException("genapp.comodi", msg);
        }
        paginacio.setPagesize(pageSizeOutput);
        paginacio.setPage(pageOutput);
        paginacio.setTotalpages(totalPages);
        paginacio.setTotalcount((int) countTotal);
        paginacio.setData(llistat);
        return paginacio;
    }
*/
}
