package es.caib.digitalib.api.externa.secure.apimassivescanwebsimple;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuInfo;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuOptionalParameters;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleArxiuRequiredParameters;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleAvailableProfile;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleAvailableProfiles;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleCustodyInfo;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleFile;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleGetTransactionIdRequest;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleKeyValue;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleProfileRequest;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleScannedFileInfo;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSignedFileInfo;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStartTransactionRequest;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleStatus;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubTransactionsOfTransaction;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubtransactionResult;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleSubtransactionResultRequest;
import es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans.MassiveScanWebSimpleValidationInfo;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NCommonUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.SubQuery;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.plugins.signature.api.FileInfoSignature;
import org.fundaciobit.pluginsib.core.utils.MetadataConstants;
import org.fundaciobit.pluginsib.utils.rest.RestException;
import org.fundaciobit.pluginsib.utils.rest.RestExceptionInfo;
import org.fundaciobit.pluginsib.utils.rest.RestUtils;

import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.logic.AuditoriaLogicaService;
import es.caib.digitalib.logic.TransaccioLogicaService;
import es.caib.digitalib.logic.utils.I18NLogicUtils;
import es.caib.digitalib.logic.utils.ScanWebUtils;
import es.caib.digitalib.model.bean.AuditoriaBean;
import es.caib.digitalib.model.entity.Auditoria;
import es.caib.digitalib.model.entity.Metadada;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.entity.PerfilUsuariAplicacio;
import es.caib.digitalib.model.entity.UsuariAplicacio;
import es.caib.digitalib.model.fields.MetadadaFields;
import es.caib.digitalib.model.fields.PerfilFields;
import es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;
import es.caib.digitalib.persistence.InfoCustodyJPA;
import es.caib.digitalib.persistence.InfoSignaturaJPA;
import es.caib.digitalib.persistence.PerfilJPA;
import es.caib.digitalib.persistence.TransaccioJPA;
import es.caib.digitalib.persistence.UsuariAplicacioJPA;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;

/**
 *
 * @author anadal
 *
 */
@Path("/secure/apimassivescanwebsimple/v1")
@OpenAPIDefinition(
        tags = { @Tag(name = ApiMassiveScanWebSimpleV1Service.TAG, description = "ApiMassiveScanWebSimple"), })
@SecurityScheme(type = SecuritySchemeType.HTTP, name = ApiMassiveScanWebSimpleV1Service.SEC, scheme = "basic")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApiMassiveScanWebSimpleV1Service {

    protected static final String TAG = "ApiMassiveScanWebSimple";

    protected static final String SEC = "BasicAuth";

    protected static final Logger log = Logger.getLogger(ApiMassiveScanWebSimpleV1Service.class);

    @EJB(mappedName = es.caib.digitalib.ejb.PerfilService.JNDI_NAME)
    protected es.caib.digitalib.ejb.PerfilService perfilEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.PerfilUsuariAplicacioService.JNDI_NAME)
    protected es.caib.digitalib.ejb.PerfilUsuariAplicacioService perfilUsuariAplicacioEjb;

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    @EJB(mappedName = AuditoriaLogicaService.JNDI_NAME)
    protected AuditoriaLogicaService auditoriaLogicaEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioService.JNDI_NAME)
    protected es.caib.digitalib.ejb.UsuariAplicacioService usuariAplicacioEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.MetadadaService.JNDI_NAME)
    protected es.caib.digitalib.ejb.MetadadaService metadadaEjb;

    public static long lastCheckExpiredTransaccions = 0;

    /**
     * Fer neteja de transaccions Obsoletes
     */
    protected synchronized void cleanExpiredTransactions() throws I18NException {

        final long now = System.currentTimeMillis();

        if (lastCheckExpiredTransaccions + 5000 > now) {
            return; // Esperam un poc entre
        }

        Timestamp expired = new Timestamp(now - Configuracio.getTransactionExpirationTimeInMs());

        Where where = Where.AND(TransaccioFields.DATAFI.isNull(), TransaccioFields.DATAINICI.lessThan(expired));

        List<Long> caducades = transaccioLogicaEjb.executeQuery(TransaccioFields.TRANSACCIOID, where);

        for (Long tid : caducades) {
            try {

                TransaccioJPA trans = transaccioLogicaEjb.findByPrimaryKey(tid);
                trans.setEstatCodi(MassiveScanWebSimpleStatus.STATUS_EXPIRED);
                trans.setDataFi(new Timestamp(now));

                log.warn("Marcant transaccio com caducada: " + trans.getTransactionWebId());
                transaccioLogicaEjb.update(trans);

            } catch (Exception e) {
                log.error("Error desconegut" + " netejant transaccions expirades de l'ApiMassiveScanWebSimple: "
                        + e.getMessage(), e);
            }
        }
    }

    protected void auditCreateTransaction(UsuariAplicacioJPA usuariAplicacio, TransaccioJPA transaction,
            String language) throws I18NException {
        final boolean isApp = true;
        final String ip = transaction.getIp();
        final String remoteUsernamePerson = transaction.getFuncionariUsername();

        final String additionalInfo = "IP: " + ip + "\n" + "Aplicacio: " + usuariAplicacio.getUsername() + "\n"
                + "Remote Usuari Persona: " + remoteUsernamePerson + "\n" + "TransacctionWebID: "
                + transaction.getTransactionWebId() + "\n" + "Tipus Transacció: " + I18NLogicUtils.tradueix(
                        new Locale(language), "transaccio.tipus." + Math.abs(transaction.getPerfil().getUsPerfil()));

        Auditoria audit = new AuditoriaBean(new Timestamp(System.currentTimeMillis()), transaction.getTransaccioID(),
                Constants.AUDIT_TYPE_CREATE_TRANSACTION,
                I18NLogicUtils.tradueix(new Locale(language), "transaccio.aplicacio.crear",
                        String.valueOf(transaction.getTransaccioID())),
                additionalInfo, isApp, usuariAplicacio.getUsername(), remoteUsernamePerson);

        auditoriaLogicaEjb.create(audit);
    }

    protected UsuariAplicacioJPA commonChecks(HttpServletRequest request, String languageUI) throws I18NException {

        String usernameApp = request.getRemoteUser();

        List<UsuariAplicacio> usuariAplicacioList;
        try {
            usuariAplicacioList = usuariAplicacioEjb.select(UsuariAplicacioFields.USERNAME.equal(usernameApp));
        } catch (I18NException e) {
            // XYZ ZZZ Idioma ????
            throw new I18NException("autenticacio.error.consulta.usuariapp", usernameApp);
        }

        if (usuariAplicacioList == null || usuariAplicacioList.size() == 0) {
            throw new I18NException("autenticacio.usuari.noalta", usernameApp);
        }

        UsuariAplicacio usuariAplicacio = usuariAplicacioList.get(0);

        if (!usuariAplicacio.isActiu()) {
            throw new I18NException("autenticacio.usuari.noactiu", usuariAplicacio.getUsername());
        }

        return (UsuariAplicacioJPA) usuariAplicacio;

    }

    @Path("/getSeparatorPage")
    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SEC)
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "getSeparatorPage",
            summary = "Retorna el PDF que s'ha de ficar entre els diferents documents a escanejar",
            tags = { TAG },
            requestBody = @RequestBody(
                    description = "Idioma. Valors permesos 'es' o 'ca'",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(name = "language", required = true, implementation = String.class))))
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operació realitzada correctament",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = MassiveScanWebSimpleFile.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Paràmetres incorrectes",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }),
                    @ApiResponse(
                            responseCode = "401",
                            description = "No Autenticat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "403",
                            description = "No Autoritzat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error no controlat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }),
                    @ApiResponse(
                            responseCode = "510",
                            description = "Només s'utilitza per crear fitxer de constants...",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = MassiveScanWebSimpleConstants.class)) }) })
    public MassiveScanWebSimpleFile getSeparatorPage(@RequestBody String language,
            @Parameter(hidden = true) @Context HttpServletRequest request) throws RestException {

        final String methodName = "getSeparatorPage";

        try {
            language = RestUtils.checkLanguage(language);

            UsuariAplicacio ua = commonChecks(request, language);

            log.info(" Entra a  " + methodName + "...[" + ua.getUsername() + "]");

            MassiveScanWebSimpleFile msf = transaccioLogicaEjb.getSeparator();
            
            

            return msf;

        } catch (Throwable th) {

            return processException(methodName, language, th);
        }

    }

    

    @Path("/getAvailableProfiles")
    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SEC)
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "getAvailableProfiles",
            summary = "Retorna els Perfils Disponibles per aquest usuari aplicacio",
            tags = { TAG },
            requestBody = @RequestBody(
                    description = "Idioma. Valors permesos 'es' o 'ca'",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(name = "language", required = true, implementation = String.class))))
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operació realitzada correctament",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = MassiveScanWebSimpleAvailableProfiles.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Paràmetres incorrectes",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }),
                    @ApiResponse(
                            responseCode = "401",
                            description = "No Autenticat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "403",
                            description = "No Autoritzat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error no controlat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }) })
    public MassiveScanWebSimpleAvailableProfiles getAvailableProfiles(@RequestBody String language,

            @Parameter(hidden = true) @Context HttpServletRequest request) throws RestException {

        final String methodName = "getAvailableProfiles";

        log.debug(" Entra a " + methodName + " ...");

        try {
            language = RestUtils.checkLanguage(language);

            UsuariAplicacio ua = commonChecks(request, language);

            Long usuariAplicacioID = ua.getUsuariAplicacioID();

            log.info("getAvailableProfiles::usuariAplicacioID = " + usuariAplicacioID);

            SubQuery<PerfilUsuariAplicacio, Long> subquery = perfilUsuariAplicacioEjb.getSubQuery(
                    PerfilUsuariAplicacioFields.PERFILID,
                    PerfilUsuariAplicacioFields.USUARIAPLICACIOID.equal(usuariAplicacioID));

            List<Perfil> perfils = perfilEjb.select(PerfilFields.PERFILID.in(subquery));

            MassiveScanWebSimpleAvailableProfiles fsap = new MassiveScanWebSimpleAvailableProfiles();

            if (perfils != null && perfils.size() != 0) {

                List<MassiveScanWebSimpleAvailableProfile> list = new ArrayList<MassiveScanWebSimpleAvailableProfile>();

                for (Perfil p : perfils) {

                    PerfilJPA perfil = (PerfilJPA) p;
                    MassiveScanWebSimpleAvailableProfile ap = new MassiveScanWebSimpleAvailableProfile(perfil.getCodi(),
                            perfil.getNom().getTraduccio(language).getValor(),
                            perfil.getDescripcio().getTraduccio(language).getValor(), perfil.getUsPerfil());
                    list.add(ap);
                }

                fsap.setAvailableProfiles(list);

            }

            return fsap;

        } catch (Throwable th) {

            return processException(methodName, language, th);
        }

    }

    @Path("/getProfile")
    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SEC)
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "getProfile",
            summary = "Retorna el PDF que s'ha de ficar entre els diferents documents a escanejar",
            tags = { TAG },
            requestBody = @RequestBody(
                    description = "Idioma. Valors permesos 'es' o 'ca'",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    name = "language",
                                    required = true,
                                    implementation = MassiveScanWebSimpleProfileRequest.class))))
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operació realitzada correctament",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = MassiveScanWebSimpleAvailableProfile.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Paràmetres incorrectes",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }),
                    @ApiResponse(
                            responseCode = "401",
                            description = "No Autenticat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "403",
                            description = "No Autoritzat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error no controlat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }) })
    public MassiveScanWebSimpleAvailableProfile getProfile(
            @RequestBody MassiveScanWebSimpleProfileRequest profileRequest,
            @Parameter(hidden = true) @Context HttpServletRequest request) throws RestException {

        final String methodName = "getProfile";
        log.info(" Entra a " + methodName + " ...");
        String language = profileRequest != null ? profileRequest.getLocale() : null;

        try {

            language = RestUtils.checkLanguage(language);

            // Checks usuari aplicacio
            UsuariAplicacio ua = commonChecks(request, language);

            Long usuariAplicacioID = ua.getUsuariAplicacioID();

            log.info("getProfile::usuariAplicacioID = " + usuariAplicacioID);

            SubQuery<PerfilUsuariAplicacio, Long> subquery = perfilUsuariAplicacioEjb.getSubQuery(
                    PerfilUsuariAplicacioFields.PERFILID,
                    PerfilUsuariAplicacioFields.USUARIAPLICACIOID.equal(usuariAplicacioID));

            List<Perfil> perfils = perfilEjb.select(Where.AND(PerfilFields.CODI.equal(profileRequest.getProfileCode()),
                    PerfilFields.PERFILID.in(subquery)));

            MassiveScanWebSimpleAvailableProfile fsap = null;

            if (perfils != null && perfils.size() != 0) {

                String locale = profileRequest.getLocale();

                PerfilJPA perfil = (PerfilJPA) perfils.get(0);
                fsap = new MassiveScanWebSimpleAvailableProfile(perfil.getCodi(),
                        perfil.getNom().getTraduccio(locale).getValor(),
                        perfil.getDescripcio().getTraduccio(locale).getValor(), perfil.getUsPerfil());

            }

            return fsap;

        } catch (Throwable th) {

            return processException(methodName, language, th);
        }

    }

    @Path("/getTransactionID")
    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SEC)
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "getTransactionID",
            summary = "Retorna una transacció a partir de l'identificador",
            tags = { TAG })
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operació realitzada correctament",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Paràmetres incorrectes",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }),
                    @ApiResponse(
                            responseCode = "401",
                            description = "No Autenticat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "403",
                            description = "No Autoritzat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error no controlat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }) })
    public String getTransactionID(@RequestBody(
            description = "Dades de la petició",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(
                            name = "requestTransaction",
                            required = true,

                            implementation = MassiveScanWebSimpleGetTransactionIdRequest.class))) MassiveScanWebSimpleGetTransactionIdRequest requestTransaction,
            @Parameter(hidden = true) @Context HttpServletRequest request) throws RestException {

        final String methodName = "getTransactionID";
        log.info(" Entra a  " + methodName + "...");

        String language = requestTransaction != null ? requestTransaction.getLanguageUI() : "ca";
        Locale locale = new Locale(language);

        try {

            // Checks usuari aplicacio
            UsuariAplicacioJPA ua = commonChecks(request, language);

            // Check de requestTransactionID
            if (requestTransaction == null) {
                throw new Exception(I18NLogicUtils.tradueix(locale, "error.entrada.parametre.null"));
            }

            // Valida Idioma UI
            {
                String lang = requestTransaction.getLanguageUI();
                if (lang == null || lang.trim().length() == 0) {
                    throw new Exception(I18NLogicUtils.tradueix(locale, "error.language.notnull"));
                }
                language = RestUtils.checkLanguage(language);
                language = lang;
                locale = new Locale(language);
            }

            // Valida NOm de la Transacció
            String transactionName = requestTransaction.getTransactionName();
            if (transactionName == null || transactionName.trim().length() == 0) {
                throw new Exception(I18NLogicUtils.tradueix(locale, "error.transactionname.notnull"));
            }

            // XYZ ZZZ ZZZ Valida Idioma DOC

            // Valida Perfil
            String scanWebProfile = requestTransaction.getScanWebProfile();
            if (scanWebProfile == null || scanWebProfile.trim().length() == 0) {
                throw new Exception(I18NLogicUtils.tradueix(locale, "error.scanwebprofile.notnull"));
            }

            // Fer neteja de transaccions Obsoletes !!!!
            try {
                cleanExpiredTransactions();
            } catch (I18NException e2) {
                String msg = I18NLogicUtils.tradueix(locale, "error.neteja.traduccions.caducades")
                        + I18NLogicUtils.getMessage(e2, locale);

                log.error(msg, e2);

                throw new Exception(msg, e2);
            }

            // XYZ ZZZ Millorar TODO

            // Valida VISTA
            int view = requestTransaction.getView();

            if (view == MassiveScanWebSimpleGetTransactionIdRequest.VIEW_FULLSCREEN
                    || view == MassiveScanWebSimpleGetTransactionIdRequest.VIEW_IFRAME) {
                // OK
            } else {
                String msg = I18NLogicUtils.tradueix(locale, "error.transaccio.desconegut.idvista",
                        String.valueOf(view));
                throw new Exception(msg);
            }

            String ip = request.getHeader("X-FORWARDED-FOR");
            if (ip == null || "".equals(ip)) {
                ip = request.getRemoteAddr();
            }

            // Crea Transacció
            try {
                TransaccioJPA transaccio = transaccioLogicaEjb.crearTransaccio(requestTransaction, ua, null, null, null,
                        ip);

                auditCreateTransaction(ua, transaccio, language);

                return transaccio.getTransactionWebId();
            } catch (I18NException e) {
                String msg = I18NLogicUtils.tradueix(locale, "error.transaccio.crear")
                        + I18NLogicUtils.getMessage(e, locale);
                throw new Exception(msg);
            }

        } catch (Throwable th) {

            return processException(methodName, language, th);
        }

    }

    @Path("/startTransaction")
    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SEC)
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(operationId = "startTransaction", summary = "Posa en marxa una transacció", tags = { TAG })
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operació realitzada correctament",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Paràmetres incorrectes",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }),
                    @ApiResponse(
                            responseCode = "401",
                            description = "No Autenticat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "403",
                            description = "No Autoritzat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error no controlat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }) })
    public String startTransaction(@RequestBody(
            description = "Dades necessàries per posa en marxa una transacció",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(
                            name = "startTransactionRequest",
                            required = true,
                            implementation = MassiveScanWebSimpleStartTransactionRequest.class))) MassiveScanWebSimpleStartTransactionRequest startTransactionRequest,
            @Parameter(hidden = true) @Context HttpServletRequest request) throws RestException {

        final String methodName = "startTransaction";

        log.info(" Entra a  " + methodName + "...");

        String languageUI = "ca";
        Locale locale = new Locale(languageUI);

        try {
            cleanExpiredTransactions();
        } catch (I18NException e2) {
            String msg = I18NLogicUtils.tradueix(locale, "error.transaccio.neteja.caducats")
                    + I18NLogicUtils.getMessage(e2, locale);
            throw new RestException(msg, e2);
        }
        // TODO XYZ ZZZ CHECKS DE LOGIN

        // CHECKS DE variable
        final String transactionWebID = startTransactionRequest.getTransactionID();

        log.info(" XYZ ZZZ startTransaction::transactionWebID => |" + transactionWebID + "|");

        try {

            // Checks usuari aplicacio
            commonChecks(request, languageUI);

            // XYZ ZZZ TREURE A METODE ????
            TransaccioJPA transaccio = null;
            {

                transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
                if (transaccio == null) {
                    String msg = I18NLogicUtils.tradueix(locale, "transaccio.noexisteix", transactionWebID);
                    throw new Exception(msg);
                }

                if (transaccio.getEstatCodi() < 0) {
                    String msg = I18NLogicUtils.tradueix(locale, "transaccio.estat.novalid",
                            String.valueOf(transactionWebID), String.valueOf(transaccio.getEstatCodi()));
                    throw new Exception(msg);
                }

            }

            transaccio.setReturnUrl(startTransactionRequest.getReturnUrl());

            // CRIDAR A START TRANSACION
            // Cercar plugin d'escaneig

            Perfil p = transaccio.getPerfil();

            String urlBase = p.getUrlBase();
            if (urlBase == null) {
                urlBase = Configuracio.getBackUrl();
            }

            // URL on Iniciar el proces de firma
            // XYZ ZZZ TODO Això ho ha de collir de la propietat URL
            // XYZ ZZZ TODO Configurar que si getAppUrl val null llavors llanci excepció
            final String redirectUrl = urlBase + Constants.SCANWEB_PROCESS_CONTROLLER_PUBLIC_CONTEXTPATH + "/start/"
                    + transaccio.getTransactionWebId();
            if (log.isDebugEnabled()) {
                log.debug("Inici de TRANSACCIO SCANWEB = " + redirectUrl);
            }

            transaccio.setEstatCodi(MassiveScanWebSimpleStatus.STATUS_IN_PROGRESS);
            transaccioLogicaEjb.update(transaccio);

            return redirectUrl;

        } catch (Throwable th) {

            return processException(methodName, languageUI, th);
        }

    }

    @Path("/getMassiveTransactionStatus")
    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SEC)
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "getMassiveTransactionStatus",
            summary = "Retorna l'estat d'una transacció massiva",
            tags = { TAG },
            requestBody = @RequestBody(
                    description = "Id de la transacció WEB",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    name = "transactionWebID",
                                    required = true,
                                    implementation = String.class))))
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operació realitzada correctament",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = MassiveScanWebSimpleStatus.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Paràmetres incorrectes",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }),
                    @ApiResponse(
                            responseCode = "401",
                            description = "No Autenticat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "403",
                            description = "No Autoritzat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error no controlat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }) })
    public MassiveScanWebSimpleStatus getMassiveTransactionStatus(@RequestBody String transactionWebID,
            @Parameter(hidden = true) @Context HttpServletRequest request) throws RestException {

        final String methodName = "getMassiveTransactionStatus";

        log.info(" Entra a  " + methodName + "...");

        String language = "ca";

        try {

            // Checks usuari aplicacio
            commonChecks(request, language);

            try {
                TransaccioJPA transaccio;

                transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);
                if (transaccio == null) {
                    String msg = I18NCommonUtils.tradueix(new Locale(language), "transaccio.noexisteix",
                            transactionWebID);
                    throw new Exception(msg);
                }

                language = transaccio.getLanguageUI();

                MassiveScanWebSimpleStatus status = new MassiveScanWebSimpleStatus();
                status.setStatus(transaccio.getEstatCodi());
                status.setErrorMessage(transaccio.getEstatMissatge());
                status.setErrorStackTrace(transaccio.getEstatExcepcio());

                return status;

            } catch (I18NException e) {
                log.error(e);
                throw new I18NException("error.transaccio.crear");
            }

        } catch (Throwable th) {

            return processException(methodName, language, th);
        }

    }

    @Path("/getSubTransactionResult")
    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SEC)
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "getSubTransactionResult",
            summary = "Retorna els resultats d'una subtransacció.",
            tags = { TAG },
            requestBody = @RequestBody(
                    description = "Idioma. Valors permesos 'es' o 'ca'",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    name = "resultRequest",
                                    required = true,
                                    implementation = MassiveScanWebSimpleSubtransactionResultRequest.class))))
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operació realitzada correctament",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = MassiveScanWebSimpleSubtransactionResult.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Paràmetres incorrectes",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }),
                    @ApiResponse(
                            responseCode = "401",
                            description = "No Autenticat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "403",
                            description = "No Autoritzat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error no controlat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }) })
    public MassiveScanWebSimpleSubtransactionResult getSubTransactionResult(
            @RequestBody MassiveScanWebSimpleSubtransactionResultRequest resultRequest,
            @Parameter(hidden = true) @Context HttpServletRequest request) throws RestException {

        final String methodName = "getSubTransactionResult";

        log.info(" Entra a  " + methodName + "...");

        String languageUI = "ca";
        try {

            // Checks usuari aplicacio
            commonChecks(request, languageUI);

            String transactionWebID = resultRequest.getSubtransactionID();

            try {
                // Clean Transactions caducades
                cleanExpiredTransactions();
            } catch (I18NException e2) {

                log.error("Error dins cleanExpiredTransactions", e2);

                throw new I18NException("error.transaccio.neteja.caducats");
            }

            TransaccioJPA transaccio = transaccioLogicaEjb.searchTransaccioByTransactionWebID(transactionWebID);

            final long transactionID = transaccio.getTransaccioID();

            languageUI = transaccio.getLanguageUI();

            MassiveScanWebSimpleStatus status = new MassiveScanWebSimpleStatus();
            status.setStatus(transaccio.getEstatCodi());
            status.setErrorMessage(transaccio.getEstatMissatge());
            status.setErrorStackTrace(transaccio.getEstatExcepcio());

            if (status.getStatus() != MassiveScanWebSimpleStatus.STATUS_FINAL_OK) {
                return new MassiveScanWebSimpleSubtransactionResult(transactionID, transactionWebID, status);
            }

            final int tipusPerfil = transaccio.getPerfil().getUsPerfil();

            MassiveScanWebSimpleArxiuOptionalParameters arxiuOptionalParameters = null;
            MassiveScanWebSimpleArxiuRequiredParameters arxiuRequiredParameters = null;
            if (tipusPerfil == Constants.PERFIL_US_CUSTODIA || tipusPerfil == Constants.PERFIL_US_CUSTODIA_INFO) {

                /**
                 * Obligatori si el perfil requeix Arxiu o Custodia
                 */

                {
                    final String citizenAdministrationID = transaccio.getArxiuReqParamCiutadaNif();
                    final String citizenFullName = transaccio.getArxiuReqParamCiutadaNom();

                    final String documentElaborationState = transaccio.getArxiuReqParamDocEstatElabora();
                    final Integer documentOrigen = transaccio.getArxiuReqParamOrigen();
                    final List<String> interestedPersons;
                    {
                        String tmp = transaccio.getArxiuReqParamInteressats();
                        if (tmp == null || tmp.trim().length() == 0) {
                            interestedPersons = null;
                        } else {
                            interestedPersons = Arrays.asList(tmp.split("\\s*,\\s*"));
                        }
                    }

                    final List<String> affectedOrganisms;
                    {
                        String tmp = transaccio.getArxiuReqParamOrgans();
                        if (tmp == null || tmp.trim().length() == 0) {
                            affectedOrganisms = null;
                        } else {
                            affectedOrganisms = Arrays.asList(tmp.split("\\s*,\\s*"));
                        }
                    }

                    arxiuRequiredParameters = new MassiveScanWebSimpleArxiuRequiredParameters(citizenAdministrationID,
                            citizenFullName, documentElaborationState, documentOrigen, interestedPersons,
                            affectedOrganisms);
                }

                /**
                 * Paràmetres opcionals per Arxiu o Custòdia
                 */

                {
                    final String procedureName = transaccio.getArxiuOptParamProcedimentNom();
                    final String procedureCode = transaccio.getArxiuOptParamProcedimentCodi();
                    final String documentarySerie = transaccio.getArxiuOptParamSerieDocumental();
                    final String custodyIDOrExpedientID = transaccio.getArxiuOptParamCustodyOrExpedientId();

                    arxiuOptionalParameters = new MassiveScanWebSimpleArxiuOptionalParameters(procedureName,
                            procedureCode, documentarySerie, custodyIDOrExpedientID);

                }
            }

            // Metadades Addicionals
            final List<MassiveScanWebSimpleKeyValue> additionalMetadatas = new ArrayList<MassiveScanWebSimpleKeyValue>();
            List<Metadada> metadades = metadadaEjb.select(MetadadaFields.TRANSACCIOID.equal(transactionID),
                    new OrderBy(MetadadaFields.NOM));
            if (metadades != null && !metadades.isEmpty()) {
                for (Metadada metadada : metadades) {
                    additionalMetadatas.add(new MassiveScanWebSimpleKeyValue(metadada.getNom(), metadada.getValor()));
                }
            }

            final MassiveScanWebSimpleFile scannedFile;
            final MassiveScanWebSimpleScannedFileInfo scannedFileInfo;
            final boolean perfilFirmaOArxiu = (tipusPerfil == Constants.PERFIL_US_COPIA_AUTENTICA_INFO
                    || tipusPerfil == Constants.PERFIL_US_CUSTODIA_INFO);

            Boolean returnScannedFile = resultRequest.getReturnScannedFile();
            if ((returnScannedFile == null && !perfilFirmaOArxiu) || Boolean.TRUE.equals(returnScannedFile)) {

                // Document escanejat
                long scannedFileID = transaccio.getFitxerEscanejatID();

                byte[] data = FileSystemManager.getFileContent(scannedFileID);

                String nom = transaccio.getFitxerEscanejat().getNom();

                // XYZ ZZZ Treure mime segons tipus format del perfil de Transaccio
                String mime = transaccio.getFitxerEscanejat().getMime();

                scannedFile = new MassiveScanWebSimpleFile(nom, mime, data);
            } else {
                scannedFile = null;
            }

            // Informació de Document escanejat
            // XYZ ZZZ ZZZ
            Integer pixelType = null;
            if (transaccio.getInfoScanPixelType() != null) {
                switch (transaccio.getInfoScanPixelType()) {
                    case MetadataConstants.ProfundidadColorConstants.GRAY:
                        pixelType = MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_GRAY;
                    break;
                    case MetadataConstants.ProfundidadColorConstants.BW:
                        pixelType = MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_BLACK_WHITE;
                    break;
                    case MetadataConstants.ProfundidadColorConstants.COLOR:
                        pixelType = MassiveScanWebSimpleScannedFileInfo.PIXEL_TYPE_COLOR;
                    break;

                    default:
                        pixelType = transaccio.getInfoScanPixelType();

                }
            }

            final String transactionName = transaccio.getNom();
            Integer pppResolution = transaccio.getInfoScanResolucioPpp();
            String formatFile = ScanWebUtils.formatFileToScanWebApi(transaccio.getPerfil().getScanFormatFitxer());

            Boolean ocr = transaccio.getInfoScanOcr();

            Boolean duplex = transaccio.getInfoScanDuplex();

            final String documentLanguage = transaccio.getInfoScanLanguageDoc();

            final String paperSize = transaccio.getInfoScanPaperSize();

            Date scanDate = transaccio.getDataInici();

            String documentType = transaccio.getInfoScanDocumentTipus();

            scannedFileInfo = new MassiveScanWebSimpleScannedFileInfo(transactionName, scanDate, pixelType,
                    pppResolution, formatFile, ocr, duplex, paperSize, documentLanguage, documentType);

            final MassiveScanWebSimpleSignedFileInfo signedFileInfo;
            final MassiveScanWebSimpleFile signedFile;
            final MassiveScanWebSimpleFile detachedSignatureFile;
            // XYZ ZZZ Falta Informacio de Firma

            if (perfilFirmaOArxiu) {

                InfoSignaturaJPA infoSign = transaccio.getInfoSignatura();

                Integer signMode = infoSign.getSignMode();

                Boolean returnSignedFile = resultRequest.getReturnSignedFile();
                if (returnSignedFile == null || returnSignedFile == true) {

                    // Document Signat
                    {
                        long signedFileID = transaccio.getFitxerSignaturaID();

                        byte[] data = FileSystemManager.getFileContent(signedFileID);

                        String nom = transaccio.getFitxerSignatura().getNom();

                        // XYZ ZZZ Treure mime segons tipus format del perfil de Transaccio
                        String mime = transaccio.getFitxerSignatura().getMime();

                        signedFile = new MassiveScanWebSimpleFile(nom, mime, data);
                    }

                    // Document Detached de la Fima (És el documnt escanejat)
                    if (signMode != null && signMode == FileInfoSignature.SIGN_MODE_EXPLICIT) {

                        long scannedFileID = transaccio.getFitxerEscanejatID();

                        byte[] data = FileSystemManager.getFileContent(scannedFileID);

                        String nom = transaccio.getFitxerEscanejat().getNom();

                        // XYZ ZZZ Treure mime segons tipus format del perfil de Transaccio
                        String mime = transaccio.getFitxerEscanejat().getMime();

                        detachedSignatureFile = new MassiveScanWebSimpleFile(nom, mime, data);

                    } else {
                        detachedSignatureFile = null;
                    }

                } else {
                    signedFile = null;
                    detachedSignatureFile = null;
                }

                {

                    int signOperation = infoSign.getSignOperation();
                    String signType = infoSign.getSignType();
                    String signAlgorithm = infoSign.getSignAlgorithm();

                    Integer signaturesTableLocation = infoSign.getSignaturesTableLocation();
                    Boolean timeStampIncluded = infoSign.getTimestampIncluded();
                    Boolean policyIncluded = infoSign.getPolicyIncluded();
                    String eniTipoFirma = infoSign.getEniTipoFirma();
                    String eniPerfilFirma = infoSign.getEniPerfilFirma();
                    String eniRolFirma = infoSign.getEniRolFirma();
                    String eniSignerName = infoSign.getEniSignerName();
                    String eniSignerAdministrationId = infoSign.getEniSignerAdministrationId();
                    String eniSignLevel = infoSign.getEniSignLevel();

                    Boolean checkAdministrationIDOfSigner = infoSign.getCheckAdministrationIdOfSigner();
                    Boolean checkDocumentModifications = infoSign.getCheckDocumentModifications();
                    Boolean checkValidationSignature = infoSign.getCheckValidationSignature();
                    MassiveScanWebSimpleValidationInfo validationInfo = new MassiveScanWebSimpleValidationInfo(
                            checkAdministrationIDOfSigner, checkDocumentModifications, checkValidationSignature);

                    List<MassiveScanWebSimpleKeyValue> additionInformation = null;

                    signedFileInfo = new MassiveScanWebSimpleSignedFileInfo(signOperation, signType, signAlgorithm,
                            signMode, signaturesTableLocation, timeStampIncluded, policyIncluded, eniTipoFirma,
                            eniPerfilFirma, eniRolFirma, eniSignerName, eniSignerAdministrationId, eniSignLevel,
                            validationInfo, additionInformation);
                }

            } else {
                signedFileInfo = null;
                signedFile = null;
                detachedSignatureFile = null;
            }

            // XYZ ZZZ Falta Informació de Custòdia i Arxiu
            final MassiveScanWebSimpleCustodyInfo custodyInfo;
            final MassiveScanWebSimpleArxiuInfo arxiuInfo;

            if (tipusPerfil == Constants.PERFIL_US_CUSTODIA_INFO) {

                InfoCustodyJPA custody = transaccio.getInfoCustody();

                if (custody == null) {
                    log.error("tipusPerfil == Constants.PERFIL_US_CUSTODIA_INFO "
                            + "però el valor de transaccio.getInfoCustody() val null. QUE HA PASSAT !!!!!!!");
                }

                {

                    String csv = custody.getCsv();
                    String originalFileURL = custody.getOriginalFileUrl();
                    String printableFileURL = custody.getPrintableFileUrl();
                    String eniFileURL = custody.getEniFileUrl();
                    String csvValidationWeb = custody.getCsvValidationWeb();
                    String csvGenerationDefinition = custody.getCsvGenerationDefinition();
                    String validationFileUrl = custody.getValidationFileUrl();

                    if (custody.getCustodyId() != null) {
                        String custodyID = custody.getCustodyId();

                        custodyInfo = new MassiveScanWebSimpleCustodyInfo(custodyID, csv, originalFileURL,
                                printableFileURL, eniFileURL, csvValidationWeb, csvGenerationDefinition,
                                validationFileUrl);

                        arxiuInfo = null;
                    } else {

                        String expedientID = custody.getArxiuExpedientId();
                        String documentID = custody.getArxiuDocumentId();

                        arxiuInfo = new MassiveScanWebSimpleArxiuInfo(expedientID, documentID, csv, originalFileURL,
                                printableFileURL, eniFileURL, csvValidationWeb, csvGenerationDefinition,
                                validationFileUrl);

                        custodyInfo = null;

                    }
                }
            } else {
                custodyInfo = null;
                arxiuInfo = null;
            }

            MassiveScanWebSimpleSubtransactionResult fssr = new MassiveScanWebSimpleSubtransactionResult(transactionID,
                    transactionWebID, status, scannedFile, scannedFileInfo, signedFile, detachedSignatureFile,
                    signedFileInfo, custodyInfo, arxiuInfo, arxiuRequiredParameters, arxiuOptionalParameters,
                    additionalMetadatas);

            return fssr;

        } catch (Throwable th) {

            return processException(methodName, languageUI, th);
        }

    }

    //public void closeTransaction(String transactionWebID) throws Exception {

    @Path("/closeTransaction")
    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SEC)
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "closeTransaction",
            summary = "Tanca una transacció a partir del seu transaccionWebID",
            tags = { TAG },
            requestBody = @RequestBody(
                    description = "transactionWebID",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    name = "transactionWebID",
                                    required = true,
                                    implementation = String.class))))
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operació realitzada correctament",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = Void.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Paràmetres incorrectes",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }),
                    @ApiResponse(
                            responseCode = "401",
                            description = "No Autenticat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "403",
                            description = "No Autoritzat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error no controlat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }) })
    public void closeTransaction(@RequestBody String transactionWebID,
            @Parameter(hidden = true) @Context HttpServletRequest request) throws RestException {

        final String methodName = "closeTransaction";

        log.info(" Entra a  " + methodName + "...");

        String language = "ca";
        try {
            // Checks usuari aplicacio
            commonChecks(request, language);

            try {
                cleanExpiredTransactions();
            } catch (Throwable th) {
                // TODO XYZ
            }

        } catch (Throwable th) {

            processException(methodName, language, th);
        }

    }

    @Path("/getSubTransactionsOfTransaction")
    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SEC)
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "getSubTransactionsOfTransaction",
            summary = "Retorna el PDF que s'ha de ficar entre els diferents documents a escanejar",
            tags = { TAG }
    //requestBody = 
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operació realitzada correctament",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(
                                            implementation = MassiveScanWebSimpleSubTransactionsOfTransaction.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Paràmetres incorrectes",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }),
                    @ApiResponse(
                            responseCode = "401",
                            description = "No Autenticat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "403",
                            description = "No Autoritzat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = String.class)) }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error no controlat",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = RestExceptionInfo.class)) }),
                    @ApiResponse(
                            responseCode = "510",
                            description = "Només s'utilitza per crear fitxer de constants...",
                            content = { @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = MassiveScanWebSimpleConstants.class)) }) })
    public MassiveScanWebSimpleSubTransactionsOfTransaction getSubTransactionsOfTransaction(
            @RequestBody(
                    description = "transactionWebID",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    name = "transactionWebID",
                                    required = true,
                                    implementation = String.class))) String transactionWebID,
            @Parameter(hidden = true) @Context HttpServletRequest request) throws RestException {

        final String methodName = "getSubTransactionsOfTransaction";

        log.debug(" Entra a  " + methodName + "...");

        String language = "ca";

        try {

            // Checks usuari aplicacio
            commonChecks(request, language);

            // Extreim la transaccio massiva de la transactionWebID
            Long transactionMultipleID = transaccioLogicaEjb.executeQueryOne(TransaccioFields.TRANSACCIOMULTIPLEID,
                    TransaccioFields.TRANSACTIONWEBID.equal(transactionWebID));

            if (transactionMultipleID == null) {
                // XYZ ZZZ transactionMultipleID is null
                throw new Exception("No s'ha pogut obtenir l'ID de transactionMultipleID de la transacció amb webID "
                        + transactionWebID);
            }

            List<String> subtransacions = transaccioLogicaEjb.executeQuery(TransaccioFields.TRANSACTIONWEBID,
                    TransaccioFields.TRANSACCIOMULTIPLEID.equal(transactionMultipleID),
                    new OrderBy(TransaccioFields.TRANSACCIOID));

            MassiveScanWebSimpleSubTransactionsOfTransaction massivesubs;

            massivesubs = new MassiveScanWebSimpleSubTransactionsOfTransaction(transactionWebID, subtransacions);

            return massivesubs;

        } catch (Throwable th) {

            return processException(methodName, language, th);
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
