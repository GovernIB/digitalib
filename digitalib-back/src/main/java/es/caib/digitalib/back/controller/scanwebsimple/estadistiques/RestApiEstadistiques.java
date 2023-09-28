package es.caib.digitalib.back.controller.scanwebsimple.estadistiques;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections.map.HashedMap;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.OrderType;
import org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.utils.Utils;
import org.fundaciobit.pluginsib.core.utils.ISO8601;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.digitalib.back.controller.scanwebsimple.RestApiScanWebUtils;
import es.caib.digitalib.ejb.UsuariPersonaService;
import es.caib.digitalib.logic.TransaccioLogicaService;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.model.fields.UsuariPersonaQueryPath;
import es.caib.digitalib.commons.utils.Constants;

/**
 * 
 * @author anadal (u80067)
 *
 */
@RunAs(Constants.DIB_USER)
@Controller
@RequestMapping(value = RestApiEstadistiques.CONTEXT)
public class RestApiEstadistiques extends RestApiScanWebUtils
        implements ApiEstadistiques, TransaccioFields {

    public static final String CONTEXT = "/public/rest/estadistiques/v1";

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    @EJB(mappedName = UsuariPersonaService.JNDI_NAME)
    protected es.caib.digitalib.ejb.UsuariPersonaService usuariPersonaEjb;
    
    
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");

    
    @RequestMapping(value = {"", "/" }, method = RequestMethod.GET)
    public ModelAndView help0() {
        return new ModelAndView(new RedirectView(CONTEXT + "/help", true));
    }
    
    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public ModelAndView help() {
        return new ModelAndView("ajudaestadistiques_public");
    }
    
    
    /**
     * BUG: @QueryPâram ha de tenir el mateix nom el paràmetre i el valor del @QueryPâram
     */
    @RequestMapping(value = "/consulta", method = RequestMethod.GET)
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> consultaRest(@QueryParam("startdate") String startdate,
            @QueryParam("enddate") String enddate, final @QueryParam("appname") String appname,
            final @QueryParam("usrname") String usrname, @QueryParam("estat") String estat) {

        try {
            // String startDateStr = request.getParameter("startdate");
            // String endDateStr = request.getParameter("enddate");
            // final String appname = request.getParameter("appname");
            // final String estatStr = request.getParameter("estat");

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

            RestCaller<EstadistiquesRest> restCaller = new RestCaller<EstadistiquesRest>() {
                @Override
                public EstadistiquesRest cridadaReal() throws Exception {
                    return consulta(startDate, endDate, appname, usrname, status);
                }
            };

            return restCaller.cridada();

        } catch (Throwable th) {
            String msg = th.getMessage();
            log.error(msg, th);
            return generateServerError(msg, th);
        }

    }

    protected Date convertToDate(String dateStr) throws ParseException {

        if (dateStr == null || dateStr.trim().length() == 0) {
            return null;
        }

        return SDF.parse(dateStr);

    }

    // @Override
    public EstadistiquesRest consulta(Date startDate, Date endDate, String appName,
            String usrName, Integer estat) throws Exception {

        try {

            List<Transaccio> transaccions;

            Where usr;
            if (appName == null) {
                usr = null; // XYZ ZZZ ZZZ USUARIAPLICACIOID.isNotNull();
            } else {
                Long usrID = usuariPersonaEjb.executeQueryOne(
                        UsuariPersonaFields.USUARIPERSONAID,
                        UsuariPersonaFields.USERNAME.equal(usrName));

                if (usrID == null) {
                    throw new Exception(
                            "No hi ha cap usuari persona amb nom ]" + appName + "[");
                }

                usr = USUARIPERSONAID.equal(usrID);
            }

            Where app;
            if (appName == null) {
                app = null; // XYZ ZZZ ZZZ USUARIAPLICACIOID.isNotNull();
            } else {
                Long appID = usuariAplicacioEjb.executeQueryOne(
                        UsuariAplicacioFields.USUARIAPLICACIOID,
                        UsuariAplicacioFields.USERNAME.equal(appName));

                if (appID == null) {
                    throw new Exception(
                            "No hi ha cap usuari aplicació amb nom ]" + appName + "[");
                }

                app = USUARIAPLICACIOID.equal(appID);
            }

            if (app != null && usr != null) {
                throw new Exception("No pot elegir appname i usrname a la vegada.");
            }

            {
                Where sd = null;
                if (startDate != null) {
                    sd = TransaccioFields.DATAINICI
                            .greaterThanOrEqual(new Timestamp(startDate.getTime()));
                }
                Where ed = null;
                if (endDate != null) {
                    ed = TransaccioFields.DATAINICI
                            .lessThanOrEqual(new Timestamp(endDate.getTime()));
                }

                Where status = null;
                if (estat != null) {
                    status = ESTATCODI.equal(estat);
                }

                Where where = Where.AND(sd, ed, app, usr, status);

                log.info("Where: " + where.toSQL());

                final OrderBy orderBy = new OrderBy(DATAINICI, OrderType.DESC);

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

                transaccions = transaccioLogicaEjb.select(where, orderBy);
            }

            List<TransaccioRest> resultat = new ArrayList<TransaccioRest>();

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
                        smkv1 = new SelectMultipleStringKeyValue(
                                UsuariAplicacioFields.USUARIAPLICACIOID.select,
                                UsuariAplicacioFields.USERNAME.select);
                        aplicacionsKV = usuariAplicacioEjb.executeQuery(smkv1);

                        aplicacions = Utils.listToMap(aplicacionsKV);
                    }
                    {
                        List<StringKeyValue> usuarisPersonaKV;
                        SelectMultipleStringKeyValue smkv2;
                        smkv2 = new SelectMultipleStringKeyValue(
                                UsuariPersonaFields.USUARIPERSONAID.select,
                                UsuariPersonaFields.USERNAME.select);
                        usuarisPersonaKV = usuariPersonaEjb.executeQuery(smkv2);

                        usuaris = Utils.listToMap(usuarisPersonaKV);
                    }

                } else {
                    u = usrName;
                    a = appName;
                }
                
                final Map<Long, String> configuracioGrupMapByUsrName = new HashedMap();

                for (Transaccio transaccio : transaccions) {

                    long transaccioID = transaccio.getTransaccioID();
                    String funcionariUsername = transaccio.getFuncionariUsername();

                    String fitxerNom = null;
                    long fitxerMidaBytes = -1;
                    if (transaccio.getFitxerEscanejat() != null) {

                        fitxerNom = transaccio.getFitxerEscanejat().getNom();
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
                       String cgn = configuracioGrupMapByUsrName.get(u);
                       if (cgn == null) {
                           UsuariPersonaQueryPath upqp = new UsuariPersonaQueryPath();
                           cgn = usuariPersonaEjb.executeQueryOne(upqp.CONFIGURACIOGRUP().NOM(), UsuariPersonaFields.USERNAME.equal(u));
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

                    resultat.add(new TransaccioRest(transaccioID, transaccioMultipleID, funcionariUsername, a, u,
                            fitxerMidaBytes, color, resolucio, midaPaper,
                            dataCapturaISO, e,  codiDir3, configuracioGrupNom, idiomaDocument,
                    duplex, missatgeError, origen, tipusDocumental));

                }
            }

            return new EstadistiquesRest(resultat);

        } catch (I18NException e) {
            throw new Exception(I18NLogicUtils.getMessage(e, new Locale("ca")));
        }

    }

    

   

}
