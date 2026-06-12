package es.caib.digitalib.api.interna.secure.comanda.v1;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.fundaciobit.genapp.common.i18n.I18NCommonUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.SelectDistinct;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.query.selectcolumn.Select2Columns;
import org.fundaciobit.genapp.common.query.selectcolumn.Select2Values;
import org.fundaciobit.pluginsib.utils.rest.RestUtils;

import es.caib.comanda.api.server.monitoring.ComandaAppEstadistiquesApi;
import es.caib.comanda.model.server.monitoring.Dimensio;
import es.caib.comanda.model.server.monitoring.DimensioDesc;
import es.caib.comanda.model.server.monitoring.EstadistiquesInfo;
import es.caib.comanda.model.server.monitoring.Fet;
import es.caib.comanda.model.server.monitoring.Format;
import es.caib.comanda.model.server.monitoring.IndicadorDesc;
import es.caib.comanda.model.server.monitoring.RegistreEstadistic;
import es.caib.comanda.model.server.monitoring.RegistresEstadistics;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.logic.TransaccioLogicaService;
import es.caib.digitalib.logic.UsuariPersonaLogicaService;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;
import es.caib.digitalib.model.fields.UsuariPersonaFields;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

/**
 * 
 * @author anadal (u80067)
 * 10 jun 2026 14:09:07
 */
@Path("/secure")
@SecurityScheme(type = SecuritySchemeType.HTTP, name = ComandaServerUtils.SECURITY_NAME, scheme = "basic")
@RolesAllowed({ Constants.DIB_WS })
@SecurityRequirement(name = ComandaEstadistiquesService.SECURITY_NAME)
public class ComandaEstadistiquesService extends RestUtils implements ComandaAppEstadistiquesApi {

    protected static final String SECURITY_NAME = "BasicAuth";


    private static final String DIMENSIO_PERSONA = "PERSONA";

    private static final String DIMENSIO_APLICACIO = "APLICACIO";

    @EJB(mappedName = UsuariPersonaLogicaService.JNDI_NAME)
    protected UsuariPersonaLogicaService usuariPersonaLogicaEjb;

    @EJB(mappedName = TransaccioLogicaService.JNDI_NAME)
    protected TransaccioLogicaService transaccioLogicaEjb;

    @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioService.JNDI_NAME)
    protected es.caib.digitalib.ejb.UsuariAplicacioService usuariAplicacioEjb;

    /**
     * Obtenir informació de &#39;estructura de les estadístiques
     *
     * Retorna el codi de l&#39;app i el catàleg de dimensions i indicadors disponibles.
     *
     */
    @GET
    @Path("/estadistiques/v1/info")
    @Produces({ "application/json" })
    @ApiOperation(
            value = "Obtenir informació de 'estructura de les estadístiques",
            tags = { "COMANDA → APP / Estadístiques" })
    @ApiResponses(
            value = { @ApiResponse(code = 200, message = "successful operation", response = EstadistiquesInfo.class) })
    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    @Override
    public EstadistiquesInfo estadistiquesInfo() {

        EstadistiquesInfo info = new EstadistiquesInfo();

        info.setCodi("EVI_ESTADISTIQUES_TRANSACCIONS");
        info.setData(OffsetDateTime.now());

        // ==============   DIMENSIONS (EIXOS)

        DimensioDesc dimDesc1 = new DimensioDesc();
        dimDesc1.setCodi(DIMENSIO_PERSONA);
        dimDesc1.setDescripcio("Usuari Persona que ha fet la cridada");
        dimDesc1.setNom("Usuari Persona");
        try {
            List<String> valorsPersona = usuariPersonaLogicaEjb.executeQuery(UsuariPersonaFields.USERNAME,
                    UsuariPersonaFields.USUARIPERSONAID.in(
                            transaccioLogicaEjb.getSubQuery(new SelectDistinct<Long>(TransaccioFields.USUARIPERSONAID),
                                    TransaccioFields.USUARIPERSONAID.isNotNull())));
            dimDesc1.setValors(valorsPersona);
        } catch (I18NException e) {
            throw new InternalServerErrorException("Error obtenint les aplicacions disponibles per les estadístiques: "
                    + I18NCommonUtils.getMessage(e, new Locale(Configuracio.getDefaultLanguage())), e);
        }

        DimensioDesc dimDesc2 = new DimensioDesc();
        dimDesc2.setCodi(DIMENSIO_APLICACIO);
        dimDesc2.setDescripcio("Usuari Aplicació que ha fet la cridada");
        dimDesc2.setNom("Usuari Aplicació");
        try {
            List<String> valorsAplicacio = usuariAplicacioEjb.executeQuery(UsuariAplicacioFields.USERNAME,
                    UsuariAplicacioFields.USUARIAPLICACIOID.in(transaccioLogicaEjb.getSubQuery(
                            new SelectDistinct<Long>(TransaccioFields.USUARIAPLICACIOID),
                            TransaccioFields.USUARIAPLICACIOID.isNotNull())));
            dimDesc2.setValors(valorsAplicacio);
        } catch (I18NException e) {
            throw new InternalServerErrorException("Error obtenint les persones disponibles per les estadístiques: "
                    + I18NCommonUtils.getMessage(e, new Locale(Configuracio.getDefaultLanguage())), e);
        }

        info.setDimensions(List.of(dimDesc1, dimDesc2));

        // ==============   INDICADORS (FETS, VALORS DE CADA CASELLA)

        List<IndicadorDesc> indicadors = new ArrayList<>();

        for (Map.Entry<String, String> e : Constants.ALL_TIPUS.entrySet()) {
            IndicadorDesc indDesc = new IndicadorDesc();
            indDesc.setCodi(e.getKey());
            indDesc.setDescripcio(e.getValue());
            indDesc.setNom(e.getValue());
            indDesc.setFormat(Format.LONG);

            indicadors.add(indDesc);
        }

        info.setIndicadors(indicadors);

        info.setVersio("1.0");

        return info;
    }

    @GET
    @Path("/estadistiques/v1")
    @Produces({ "application/json" })
    @ApiOperation(
            value = "Obtenir darreres estadístiques diàries disponibles",
            tags = { "COMANDA → APP / Estadístiques" })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "successful operation", response = RegistresEstadistics.class) })

    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    public RegistresEstadistics estadistiques() {

        Timestamp dataConsulta = new Timestamp(System.currentTimeMillis());

        return estadistiquesPerUnDia(dataConsulta);

    }

    /**
     * Obtenir estadístiques d&#39;una data concreta
     *
     * Retorna les estadístiques corresponents a la data indicada amb format dd-MM-yyyy.
     *
     */
    @GET
    @Path("/estadistiques/v1/of/{data}")
    @Produces({ "application/json" })
    @ApiOperation(value = "Obtenir estadístiques d'una data concreta", tags = { "COMANDA → APP / Estadístiques" })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "successful operation", response = RegistresEstadistics.class) })

    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    @Override
    public RegistresEstadistics estadistiquesPerData(@PathParam("data")
    String data) {

        Timestamp dataConsulta = ComandaServerUtils.stringWithFormatddMMyy2Timestamp(data);

        return estadistiquesPerUnDia(dataConsulta);

    }

    /**
     * Obtenir les estadístiques d&#39;un interval donat
     *
     * Retorna llista d&#39;estadístiques de tots els dies entre la dataInici i la dataFi (en format dd-MM-yyyy), ambdues incloses.
     *  La resposta contindrà un objecte de tipus RegistresEstadistics per a cada dia inclòs en l'interval.
     *
     */
    @GET
    @Path("/estadistiques/v1/from/{dataInici}/to/{dataFi}")
    @Produces({ "application/json" })
    @ApiOperation(value = "Obtenir les estadístiques d'un interval donat", tags = { "COMANDA → APP / Estadístiques" })
    @ApiResponses(
            value = { @ApiResponse(
                    code = 200,
                    message = "successful operation",
                    response = RegistresEstadistics.class,
                    responseContainer = "List") })
    @RolesAllowed({ Constants.DIB_WS })
    @SecurityRequirement(name = SECURITY_NAME)
    @Override
    public List<RegistresEstadistics> estadistiquesPerRang(@PathParam("dataInici")
    String dataInici, @PathParam("dataFi")
    String dataFi) {

        Timestamp dataIniciTs = ComandaServerUtils.stringWithFormatddMMyy2Timestamp(dataInici);
        Timestamp dataFiTs = ComandaServerUtils.stringWithFormatddMMyy2Timestamp(dataFi);

        // Ara es fa un bucle per cada dia entre dataInici i dataFi i es crida al metode estadistiquesPerUnDia per cada dia
        // TODO  Si fos necessari es podria optimitzar fent una consulta que agafes les dades de tot l'interval i després agrupant-les per dia, però com el volum de dades no es preveu que sigui molt gran, es fa d'una manera més senzilla.
        List<RegistresEstadistics> results = new ArrayList<>();

        Timestamp currentDate = dataIniciTs;

        while (!currentDate.after(dataFiTs)) {
            RegistresEstadistics re = estadistiquesPerUnDia(currentDate);

            if (re.getFets() != null && !re.getFets().isEmpty()) {
                results.add(re);
            }

            // Incrementar currentDate en un dia
            currentDate = new Timestamp(currentDate.getTime() + 24 * 60 * 60 * 1000);
        }

        return results;

    }

    // ----------------------------------------------------------------
    // -------------------- METODE UTILITATS ---------------------
    // ----------------------------------------------------------------
    protected RegistresEstadistics estadistiquesPerUnDia(Timestamp dataConsulta) {
        List<RegistreEstadistic> registres = new ArrayList<>();

        final Timestamp[] startAndEndOfDay = ComandaServerUtils.getStartAndEndOfDay(dataConsulta);

        try {

            Where wFromTo = TransaccioFields.DATAINICI.between(startAndEndOfDay[0], startAndEndOfDay[1]);

            Map<Long, String> aplicacioIdToUsername = new HashMap<Long, String>();
            {

                // Llegim les aplicacions  que han fet peticions en aquesta dates
                List<Long> aplicacions = transaccioLogicaEjb.executeQuery(TransaccioFields.USUARIAPLICACIOID,
                        Where.AND(TransaccioFields.USUARIAPLICACIOID.isNotNull(), wFromTo));

                // Necessitam un MAp de ID aplicació cap a username d'aplicació
                List<Select2Values<Long, String>> llistat = usuariAplicacioEjb.executeQuery(
                        new Select2Columns<Long, String>(UsuariAplicacioFields.USUARIAPLICACIOID.select,
                                UsuariAplicacioFields.USERNAME.select),
                        UsuariAplicacioFields.USUARIAPLICACIOID.in(aplicacions));

                for (Select2Values<Long, String> item : llistat) {
                    aplicacioIdToUsername.put(item.getValue1(), item.getValue2());
                }

            }
            Map<Long, String> personaIdToUsername = new HashMap<Long, String>();
            {

                // Llegim les transaccions que han fet peticions en aquesta dates
                List<Long> persones = transaccioLogicaEjb.executeQuery(TransaccioFields.USUARIPERSONAID,
                        Where.AND(UsuariPersonaFields.USUARIPERSONAID.isNotNull(), wFromTo));
                // Necessitam un MAp de ID aplicació cap a username d'aplicació

                List<Select2Values<Long, String>> llistat = usuariPersonaLogicaEjb
                        .executeQuery(
                                new Select2Columns<Long, String>(UsuariPersonaFields.USUARIPERSONAID.select,
                                        UsuariPersonaFields.USERNAME.select),
                                UsuariPersonaFields.USUARIPERSONAID.in(persones));

                for (Select2Values<Long, String> item : llistat) {
                    personaIdToUsername.put(item.getValue1(), item.getValue2());
                }

            }

            // Llegim les transaccions que han fet peticions en aquesta dates
            List<Select2Values<Long, Long>> transaccions = transaccioLogicaEjb
                    .executeQuery(new Select2Columns<Long, Long>(TransaccioFields.USUARIAPLICACIOID.select,
                            TransaccioFields.USUARIPERSONAID.select), wFromTo);
            for (Select2Values<Long, Long> t : transaccions) {

                Long aplicacioID = t.getValue1();
                String aplicacio = aplicacioIdToUsername.get(aplicacioID);

                Long personaID = t.getValue2();
                String persona = personaIdToUsername.get(personaID);

                Dimensio dimDesc1 = new Dimensio();
                dimDesc1.setCodi(DIMENSIO_PERSONA);
                dimDesc1.setValor(persona);

                Dimensio dimDesc2 = new Dimensio();
                dimDesc2.setCodi(DIMENSIO_APLICACIO);
                dimDesc2.setValor(aplicacio);

                Where wPersonAplic = Where.AND(TransaccioFields.USUARIPERSONAID.equal(personaID),
                        TransaccioFields.USUARIAPLICACIOID.equal(aplicacioID));

                List<Fet> fets = new ArrayList<>();
                for (Map.Entry<String, List<Integer>> e : Constants.ESTATS_PER_TIPUS.entrySet()) {

                    Where wTipus = Where.AND(wPersonAplic, TransaccioFields.ESTATCODI.in(e.getValue()), wFromTo);

                    Long valorObj = transaccioLogicaEjb.count(wTipus);

                    if (valorObj == null || valorObj.doubleValue() == 0D) {
                        continue; // Si no hi ha dades per aquest tipus, no afegim el fet
                    }

                    Fet fet = new Fet();
                    fet.setCodi(e.getKey());
                    fet.setValor(valorObj.doubleValue());

                    fets.add(fet);

                }

                RegistreEstadistic registre = new RegistreEstadistic();
                registre.setDimensions(List.of(dimDesc1, dimDesc2));
                registre.setFets(fets);

                registres.add(registre);

            }

        } catch (Throwable th) {
            String msg;
            if (th instanceof I18NException) {
                I18NException e = (I18NException) th;
                msg = I18NCommonUtils.getMessage(e, new Locale(Configuracio.getDefaultLanguage()));
            } else {
                msg = th.getMessage();
            }

            throw new InternalServerErrorException("Error construint la consulta per obtenir les estadístiques: " + msg,
                    th);
        }

        RegistresEstadistics re = new RegistresEstadistics();
        re.setFets(registres);

        //Temps temps = ComandaServerUtils.createTempsFromDate(dataConsulta);

        // Crear un offsetdatetime a partir de dataConsulta
        OffsetDateTime temps = dataConsulta.toInstant().atOffset(OffsetDateTime.now().getOffset());

        re.setTemps(temps);

        return re;
    }

}
