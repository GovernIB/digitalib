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
import es.caib.digitalib.ejb.UsuariPersonaLocal;
import es.caib.digitalib.logic.TransaccioLogicaLocal;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import es.caib.digitalib.utils.Constants;

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

    @EJB(mappedName = TransaccioLogicaLocal.JNDI_NAME)
    protected TransaccioLogicaLocal transaccioLogicaEjb;

    @EJB(mappedName = UsuariPersonaLocal.JNDI_NAME)
    protected es.caib.digitalib.ejb.UsuariPersonaLocal usuariPersonaEjb;

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");

    
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView help0() {
        return new ModelAndView(new RedirectView(CONTEXT + "/", true));
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
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

            List<TransaccioRest> resultat = new ArrayList<RestApiEstadistiques.TransaccioRest>();

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
                        aplicacionsKV = usuariAplicacioEjb.executeQuery(smkv1, null);

                        aplicacions = Utils.listToMap(aplicacionsKV);
                    }
                    {
                        List<StringKeyValue> usuarisPersonaKV;
                        SelectMultipleStringKeyValue smkv2;
                        smkv2 = new SelectMultipleStringKeyValue(
                                UsuariPersonaFields.USUARIPERSONAID.select,
                                UsuariPersonaFields.USERNAME.select);
                        usuarisPersonaKV = usuariPersonaEjb.executeQuery(smkv2, null);

                        usuaris = Utils.listToMap(usuarisPersonaKV);
                    }

                } else {
                    u = usrName;
                    a = appName;
                }

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

                    resultat.add(new TransaccioRest(transaccioID, funcionariUsername, a, u,
                            fitxerNom, fitxerMidaBytes, color, resolucio, midaPaper,
                            dataCapturaISO, e));

                }
            }

            return new EstadistiquesRest(resultat);

        } catch (I18NException e) {
            throw new Exception(I18NLogicUtils.getMessage(e, new Locale("ca")));
        }

    }

    public class EstadistiquesRest {

        public EstadistiquesRest(List<TransaccioRest> resultat) {
            super();
            this.resultat = resultat;
        }

        public EstadistiquesRest() {
            super();
            // TODO Auto-generated constructor stub
        }

        protected List<TransaccioRest> resultat;

        public List<TransaccioRest> getResultat() {
            return resultat;
        }

        public void setResultat(List<TransaccioRest> resultat) {
            this.resultat = resultat;
        }

    }

    /**
     * 
     * @author anadal (u80067)
     *
     */
    public class TransaccioRest {
        protected long transaccioID;
        protected String funcionariUsername;
        protected String appname;
        protected String usrname;
        protected String fitxerNom;
        protected long fitxerMidaBytes;
        protected String color; // 1,'B/N',8,'Gris',32,'Color'
        protected Integer resolucio; // infoscanresolucioppp
        protected String midaPaper;
        protected String dataCapturaISO8601;
        protected String estat;

        public TransaccioRest() {
            super();
        }

        public TransaccioRest(long transaccioID, String funcionariUsername, String appname,
                String usrname, String fitxerNom, long fitxerMidaBytes, String color,
                Integer resolucio, String midaPaper, String dataCapturaISO8601, String estat) {
            super();
            this.transaccioID = transaccioID;
            this.funcionariUsername = funcionariUsername;
            this.appname = appname;
            this.usrname = usrname;
            this.fitxerNom = fitxerNom;
            this.fitxerMidaBytes = fitxerMidaBytes;
            this.color = color;
            this.resolucio = resolucio;
            this.midaPaper = midaPaper;
            this.dataCapturaISO8601 = dataCapturaISO8601;
            this.estat = estat;
        }

        public long getTransaccioID() {
            return transaccioID;
        }

        public void setTransaccioID(long transaccioID) {
            this.transaccioID = transaccioID;
        }

        public String getFuncionariUsername() {
            return funcionariUsername;
        }

        public void setFuncionariUsername(String funcionariUsername) {
            this.funcionariUsername = funcionariUsername;
        }

        public String getFitxerNom() {
            return fitxerNom;
        }

        public void setFitxerNom(String fitxerNom) {
            this.fitxerNom = fitxerNom;
        }

        public String getUsrname() {
            return usrname;
        }

        public void setUsrname(String usrname) {
            this.usrname = usrname;
        }

        public String getEstat() {
            return estat;
        }

        public void setEstat(String estat) {
            this.estat = estat;
        }

        public String getAppname() {
            return appname;
        }

        public void setAppname(String appname) {
            this.appname = appname;
        }

        public long getFitxerMidaBytes() {
            return fitxerMidaBytes;
        }

        public void setFitxerMidaBytes(long fitxerMidaBytes) {
            this.fitxerMidaBytes = fitxerMidaBytes;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getResolucio() {
            return resolucio;
        }

        public void setResolucio(Integer resolucio) {
            this.resolucio = resolucio;
        }

        public String getMidaPaper() {
            return midaPaper;
        }

        public void setMidaPaper(String midaPaper) {
            this.midaPaper = midaPaper;
        }

        public String getDataCapturaISO8601() {
            return dataCapturaISO8601;
        }

        public void setDataCapturaISO8601(String dataCapturaISO8601) {
            this.dataCapturaISO8601 = dataCapturaISO8601;
        }

    }

}
