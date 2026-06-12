package es.caib.digitalib.api.interna.secure.comanda.v1;

import java.net.URL;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.fundaciobit.genapp.common.i18n.I18NCommonUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.pluginsib.utils.rest.RestUtils;
import org.jboss.logging.Logger;

import es.caib.comanda.model.server.monitoring.AppInfo;
import es.caib.comanda.model.server.monitoring.ContextInfo;
import es.caib.comanda.model.server.monitoring.EstatSalut;
import es.caib.comanda.model.server.monitoring.EstatSalutEnum;
import es.caib.comanda.model.server.monitoring.IntegracioInfo;
import es.caib.comanda.model.server.monitoring.IntegracioSalut;
import es.caib.comanda.model.server.monitoring.MissatgeSalut;
import es.caib.comanda.model.server.monitoring.SalutInfo;
import es.caib.comanda.model.server.monitoring.SubsistemaInfo;
import es.caib.comanda.model.server.monitoring.SubsistemaSalut;
import es.caib.comanda.ms.salut.helper.IntegracioApp;
import es.caib.comanda.ms.salut.helper.MonitorHelper;
import es.caib.comanda.ms.salut.helper.SalutHelper;
import es.caib.comanda.ms.salut.helper.SalutHelper.BuildInfo;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.commons.utils.Version;
import es.caib.digitalib.ejb.PluginService;
import es.caib.digitalib.logic.TransaccioLogicaService;
import es.caib.digitalib.model.fields.TransaccioFields;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

/**
 * 
 * @author anadal (u80067)
 * 10 jun 2026 14:09:22
 */
@Path("/secure/")
@SecurityScheme(type = SecuritySchemeType.HTTP, name = ComandaServerUtils.SECURITY_NAME, scheme = "basic")
public class ComandaSalutService extends RestUtils implements es.caib.comanda.api.server.monitoring.ComandaAppSalutApi {

    protected Logger log = Logger.getLogger(ComandaSalutService.class);

    protected static final String SECURITY_NAME = "BasicAuth";

    protected static IntegracioApp[] INTEGRACIONS_EVIDENCIESIB = { IntegracioApp.VFI, IntegracioApp.USR };

    protected static final Map<String, String> subsistemaNameById = new HashMap<>();

    protected static final Map<String, Where> subsistemaTipusOkById = new HashMap<>();

    protected static final Map<String, Where> subsistemaTipusErrorById = new HashMap<>();

    public static final String SUBSISTEMA_TRANSACCIONS_DIGITALIB = "DIB_DIGITALIB";

    {
        subsistemaNameById.put(SUBSISTEMA_TRANSACCIONS_DIGITALIB, "Transaccions DigitalIB");

        subsistemaTipusOkById.put(SUBSISTEMA_TRANSACCIONS_DIGITALIB, TransaccioFields.ESTATCODI
                .in(List.of(Constants.TRANSACCIO_ESTAT_CODI_OK, Constants.TRANSACCIO_ESTAT_CODI_CANCELAT)));

        subsistemaTipusErrorById.put(SUBSISTEMA_TRANSACCIONS_DIGITALIB, TransaccioFields.ESTATCODI
                .in(List.of(Constants.TRANSACCIO_ESTAT_CODI_EXPIRAT, Constants.TRANSACCIO_ESTAT_CODI_ERROR)));

    }

    @EJB(mappedName = PluginService.JNDI_NAME)
    protected PluginService pluginLogicaEjb;

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    /**
     * Obtenir informació de l&#39;aplicació
     *
     * Retorna dades bàsiques de l&#39;aplicació (codi, nom, versió, data de build, etc.) i contextos exposats.
     *
     */
    @GET
    @Path("/salut/v1/info")
    @Produces({ "application/json" })
    @ApiOperation(value = "Obtenir informació de l'aplicació", tags = { "COMANDA → APP / Salut" })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = AppInfo.class) })
    @SecurityRequirement(name = SECURITY_NAME)
    @RolesAllowed({ Constants.DIB_WS })
    @Override
    public AppInfo salutInfo() {

        AppInfo a = new AppInfo();

        Version version = new Version();
        {

            BuildInfo infoTmp = SalutHelper.getBuildInfo();

            a.setJdkVersion(version.getJdkVersion());
            a.setRevisio(version.getScmRevision());

            // NO funciona 
            //a.revisio(infoTmp.getCommitId());            
            //a.jdkVersion(infoTmp.getBuildJDK());

            a.setData(infoTmp.getBuildDate());

        }

        String urlBase = Configuracio.getBackUrl().replaceAll("/digitalibback", "");

        a.codi("DIB");
        a.nom("DigitalIB");

        {

            List<ContextInfo> contexts = new ArrayList<>();
            {
                ContextInfo back = new ContextInfo();

                back.setApi(null);
                back.setCodi("DIB_BACK");
                // TODO Falta Manual
                /*
                Manual manual = new Manual();
                manual.setNom("Manual_de_Usuari_de_DigitalIB");
                manual.setPath(
                        "https://github.com/GovernIB/digitalib/raw/refs/heads/digitalib-3.0/doc/Manual_de_Usuari_de_DigitalIB.odt");
                back.setManuals(List.of(manual));
                */
                back.setNom("DigitalIB Backoffice/Frontoffice");
                back.setPath(urlBase + "/digitalibback");

                contexts.add(back);
            }

            {
                ContextInfo apiinterna = new ContextInfo();
                apiinterna.setApi(urlBase + "/digitalibapi/interna");
                apiinterna.setCodi("DIB_API_INTERNA");

                // TODO Falta Manual
                /*
                Manual manual = new Manual();
                manual.setNom("Manual_de_Migració_de_APIsIB_a_Api_Interna");
                manual.setPath(
                        "https://github.com/GovernIB/digitalib/raw/refs/heads/digitalib-3.0/doc/Manual_de_Migraci%C3%B3_de_APIsIB_a_Api_Interna.odt");
                apiinterna.setManuals(List.of(manual));
                */

                apiinterna.setNom("DigitalIB API Swagger");
                apiinterna.setPath(urlBase + "/digitalibapi/interna");

                contexts.add(apiinterna);
            }

            // Afegir contexts
            a.setContexts(contexts);

        }

        {
            List<IntegracioInfo> list = new ArrayList<>();

            for (IntegracioApp ia : INTEGRACIONS_EVIDENCIESIB) {
                IntegracioInfo i1 = new IntegracioInfo();
                i1.setCodi(ia.name());
                i1.setNom(ia.getNom());
                list.add(i1);
            }

            a.setIntegracions(list);

        }

        {
            List<SubsistemaInfo> subsistemes = new java.util.ArrayList<>();
            for (Map.Entry<String, String> entry : subsistemaNameById.entrySet()) {
                SubsistemaInfo ss = new SubsistemaInfo();
                ss.setCodi(entry.getKey());
                ss.setNom(entry.getValue());
                subsistemes.add(ss);
            }
            a.setSubsistemes(subsistemes);
        }

        a.versio(version.getVersion());

        a.setVersioJboss(getJBossVersion());

        return a;

    }

    /**
     * Obtenir informació de l&#39;estat de salut de l&#39;aplicació
     *
     * Retorna l&#39;estat de salut funcional i integracions, amb metadades de versió.
     *
     */
    @GET
    @Path("/salut/v1")
    @Produces({ "application/json" })
    @ApiOperation(value = "Obtenir informació de l'estat de salut de l'aplicació", tags = { "COMANDA → APP / Salut" })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = SalutInfo.class) })
    //    @RolesAllowed({ Constants.EVI_WS })
    //    @SecurityRequirement(name = SECURITY_NAME)
    @Override
    public SalutInfo salut(@QueryParam("dataPeriode") @ApiParam(
            value = "Data mínima de la que es demana informació per període",
            example = "2025-12-31T23:59:59Z")
    java.time.OffsetDateTime dataPeriode,
            @QueryParam("dataTotal") @ApiParam(
                    value = "Data mínima de la que demana informació per totals",
                    example = "2025-01-01T00:00:00Z")
            java.time.OffsetDateTime dataTotal) {
        SalutInfo sInfo = new SalutInfo();
        sInfo.setCodi("DIB");
        sInfo.setData(getDateTime());

        {
            EstatSalut estatBaseDeDades = new EstatSalut();

            long start = System.currentTimeMillis();
            try {
                final Where where = null;
                final Integer firstResult = 1;
                final Integer maxResults = 1;
                pluginLogicaEjb.select(where, firstResult, maxResults);
                estatBaseDeDades.setEstat(EstatSalutEnum.UP);
            } catch (Exception e) {
                estatBaseDeDades.setEstat(EstatSalutEnum.ERROR);
                e.printStackTrace();
            }

            long end = System.currentTimeMillis();

            estatBaseDeDades.setLatencia((int) (end - start));

            sInfo.setEstatBaseDeDades(estatBaseDeDades);
        }

        {
            EstatSalut estatGlobal = new EstatSalut();

            long start = System.currentTimeMillis();
            try {
                String url = Configuracio.getBackUrl();

                // Fer una petició a l'endpoint de info per comprovar que respon correctament
                // emprant URL
                URL urlObj = new URL(url);
                urlObj.openStream().close();

                estatGlobal.setEstat(EstatSalutEnum.UP);
            } catch (Exception e) {
                log.error("Error comprovant l'estat global de l'aplicació: " + e.getMessage(), e);

                estatGlobal.setEstat(EstatSalutEnum.ERROR);
            }
            long end = System.currentTimeMillis();

            estatGlobal.setLatencia((int) (end - start));
            sInfo.setEstatGlobal(estatGlobal);

            sInfo.setInformacioSistema(MonitorHelper.getInfoSistema());
        }

        {
            List<IntegracioSalut> integracions = new java.util.ArrayList<>();

            for (IntegracioApp integracioApp : INTEGRACIONS_EVIDENCIESIB) {

                IntegracioSalut integracio = new IntegracioSalut();
                integracio.setCodi(integracioApp.name());
                integracio.setEstat(EstatSalutEnum.UP);
                // TODO calcular latència
                integracio.setLatencia(null);

                /*
                
                Timestamp avui = new Timestamp(System.currentTimeMillis());
                
                Calendar cal = Calendar.getInstance();
                
                cal.add(Calendar.MONTH, -1);
                
                Timestamp faunmes;
                if (dataPeriode != null) {
                faunmes = new Timestamp(dataPeriode.toInstant().toEpochMilli());
                } else {
                
                faunmes = new Timestamp(cal.getTimeInMillis());
                }
                
                cal.add(Calendar.MONTH, -11);
                
                Timestamp faunany;
                
                if (dataTotal != null) {
                faunany = new Timestamp(dataTotal.toInstant().toEpochMilli());
                } else {
                faunany = new Timestamp(cal.getTimeInMillis());
                }
                
                // Cercar peticions d'aquesta integració 
                IntegracioPeticions peticions = new IntegracioPeticions();
                peticions.setEndpoint("/secure/asyncsignatureonweb/v1/");
                peticions.setPeticionsErrorUltimPeriode(
                    calculPeticions(ConstantsV2.TIPUSESTATPETICIODEFIRMA_REBUTJAT, faunmes, avui));
                peticions.setPeticionsOkUltimPeriode(
                    calculPeticions(ConstantsV2.TIPUSESTATPETICIODEFIRMA_FIRMAT, faunmes, avui));
                peticions.setPeticionsPerEntorn(null); // TODO calcular map
                peticions.setTempsMigUltimPeriode(-1);
                peticions.setTotalError(calculPeticions(ConstantsV2.TIPUSESTATPETICIODEFIRMA_REBUTJAT, faunany, avui));
                peticions.setTotalOk(calculPeticions(ConstantsV2.TIPUSESTATPETICIODEFIRMA_FIRMAT, faunany, avui));
                peticions.setTotalTempsMig(-1);
                integracio.setPeticions(peticions);
                */

                integracions.add(integracio);

            }

            sInfo.setIntegracions(integracions);
        }

        {

            List<MissatgeSalut> missatges = new ArrayList<MissatgeSalut>();

            /*
            
            Timestamp faDosDies = new Timestamp(System.currentTimeMillis() - 2L * 24 * 3600 * 1000);
            
            // Peticions caducades
            try {
                Long count = peticioDeFirmaEjb.count(Where.AND(
                        PeticioDeFirmaFields.DATACADUCITAT.lessThan(new Timestamp(System.currentTimeMillis())),
                        PeticioDeFirmaFields.TIPUSESTATPETICIODEFIRMAID
                                .equal(ConstantsV2.TIPUSESTATPETICIODEFIRMA_ENPROCES)));
            
                if (count != null && count > 0) {
                    MissatgeSalut ms = new MissatgeSalut();
                    ms.setNivell(SalutNivell.ERROR);
                    ms.setData(getDateTime());
                    ms.setMissatge("Hi ha " + count + " peticions de firma caducades.");
                    missatges.add(ms);
                }
            
            } catch (I18NException e) {
            
                String msg = "Error consultant les peticions de firma caducades: "
                        + I18NCommonUtils.getMessage(e, new Locale(Configuracio.getDefaultLanguage()));
            
                log.error(msg, e);
            
                MissatgeSalut ms = new MissatgeSalut();
                ms.setNivell(SalutNivell.ERROR);
                ms.setData(getDateTime());
                ms.setMissatge(msg);
                missatges.add(ms);
            }
            
            // Calcular CallBacks pendents 
            try {
                Long count = notificacioLogicaEjb.count(Where.AND(NotificacioWSFields.DATACREACIO.lessThan(faDosDies),
                        NotificacioWSFields.BLOQUEJADA.equal(false)));
            
                if (count != null && count > 0) {
                    MissatgeSalut ms = new MissatgeSalut();
                    ms.setNivell(SalutNivell.ERROR);
                    ms.setData(getDateTime());
                    ms.setMissatge("Hi ha " + count + " notificacions ws (Callback) pendents de més de 2 dies");
                    missatges.add(ms);
                }
            
            } catch (I18NException e) {
            
                String msg = "Error consultant les notificacions ws (Callback) pendents: "
                        + I18NCommonUtils.getMessage(e, new Locale(Configuracio.getDefaultLanguage()));
            
                log.error(msg, e);
            
                MissatgeSalut ms = new MissatgeSalut();
                ms.setNivell(SalutNivell.ERROR);
                ms.setData(getDateTime());
                ms.setMissatge(msg);
                missatges.add(ms);
            }
            
            // Missatges agrupats pendents des de fa més de 2 dies
            try {
                Long count = correuAgrupatLogicaEjb.count(CorreuAgrupatFields.DATACREACIO.lessThan(faDosDies));
                if (count != null && count > 0) {
                    MissatgeSalut ms = new MissatgeSalut();
                    ms.setNivell(SalutNivell.ERROR);
                    ms.setData(getDateTime());
                    ms.setMissatge("Hi ha " + count + " missatges agrupats pendents de més de 2 dies");
                    missatges.add(ms);
                }
            } catch (I18NException e) {
            
                String msg = "Error consultant el missatges agrupats pendents de més de 2 dies: "
                        + I18NCommonUtils.getMessage(e, new Locale(Configuracio.getDefaultLanguage()));
            
                log.error(msg, e);
            
                MissatgeSalut ms = new MissatgeSalut();
                ms.setNivell(SalutNivell.ERROR);
                ms.setData(getDateTime());
                ms.setMissatge(msg);
                missatges.add(ms);
            }
            */

            sInfo.setMissatges(missatges);
        }

        {

            List<SubsistemaSalut> subsistemesList = new java.util.ArrayList<>();

            for (Map.Entry<String, String> entry : subsistemaNameById.entrySet()) {

                String codiSubsistema = entry.getKey();

                SubsistemaSalut subSystemApiFirmaAsinc = new SubsistemaSalut();
                subSystemApiFirmaAsinc.setCodi(codiSubsistema);
                subSystemApiFirmaAsinc.setEstat(EstatSalutEnum.UP);
                // TODO calcular latència
                subSystemApiFirmaAsinc.setLatencia(null);

                Timestamp avui = new Timestamp(System.currentTimeMillis());

                Calendar cal = Calendar.getInstance();

                cal.add(Calendar.MONTH, -1);

                Timestamp faunmes;
                if (dataPeriode != null) {
                    faunmes = new Timestamp(dataPeriode.toInstant().toEpochMilli());
                } else {

                    faunmes = new Timestamp(cal.getTimeInMillis());
                }

                cal.add(Calendar.MONTH, -11);

                Timestamp faunany;

                if (dataTotal != null) {
                    faunany = new Timestamp(dataTotal.toInstant().toEpochMilli());
                } else {
                    faunany = new Timestamp(cal.getTimeInMillis());
                }

                // Cercar peticions per aquest subsistemes 

                subSystemApiFirmaAsinc.setPeticionsErrorUltimPeriode(
                        calculPeticions(faunmes, avui, subsistemaTipusErrorById.get(codiSubsistema)));
                subSystemApiFirmaAsinc.setPeticionsOkUltimPeriode(
                        calculPeticions(faunmes, avui, subsistemaTipusOkById.get(codiSubsistema)));
                subSystemApiFirmaAsinc.setTempsMigUltimPeriode(-1);
                subSystemApiFirmaAsinc
                        .setTotalError(calculPeticions(faunany, avui, subsistemaTipusErrorById.get(codiSubsistema)));
                subSystemApiFirmaAsinc
                        .setTotalOk(calculPeticions(faunany, avui, subsistemaTipusOkById.get(codiSubsistema)));
                subSystemApiFirmaAsinc.setTotalTempsMig(-1);

                subsistemesList.add(subSystemApiFirmaAsinc);

            }

            sInfo.setSubsistemes(subsistemesList);
        }

        sInfo.setVersio(new Version().getVersion());

        return sInfo;
    }

    protected long calculPeticions(Timestamp from, Timestamp to, Where whereTipus) {
        long totalOK;

        Where w2 = TransaccioFields.DATAINICI.between(from, to);

        Where w = Where.AND(w2, whereTipus);
        try {
            totalOK = transaccioLogicaEjb.count(w);
        } catch (I18NException e) {
            log.error("Error calculant consultes: "
                    + I18NCommonUtils.getMessage(e, new Locale(Configuracio.getDefaultLanguage())));
            totalOK = -1;
        }
        return totalOK;
    }

    protected OffsetDateTime getDateTime() {
        return OffsetDateTime.now();
    }

    public static String jbossVersionCache = null;

    public String getJBossVersion() {

        if (jbossVersionCache == null) {
            String jbossVersion = null;
            try {
                ObjectName rootNameObjectName = new ObjectName("jboss.as:management-root=server");
                for (MBeanServer server : MBeanServerFactory.findMBeanServer(null)) {
                    if (server.isRegistered(rootNameObjectName)) {
                        jbossVersion = (String) server.getAttribute(rootNameObjectName, "product-version");
                        break;
                    }
                }

                if (jbossVersion == null) {
                    log.warn("JBOSS VERSION: No s'ha trobat el camp 'product-version'");
                }

            } catch (Exception e) {
                log.error("JBOSS VERSION: error no controlat " + e.getMessage(), e);
            }

            log.info("JBOSS VERSION: " + jbossVersion);
            if (jbossVersion != null) {
                jbossVersionCache = jbossVersion;
            }
        }

        return jbossVersionCache;

    }

}
