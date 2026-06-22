package es.caib.digitalib.logic;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.digitalib.ejb.FitxerEJB;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.commons.utils.Configuracio;
import es.caib.digitalib.commons.utils.Constants;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "FitxerLogicaEJB")

@RunAs(Constants.DIB_ADMIN) // "DIB_ADMIN"
public class FitxerLogicaEJB extends FitxerEJB implements FitxerLogicaService {

    @Override
    @PermitAll
    public Fitxer create(Fitxer instance) throws I18NException {
        return super.create(instance);
    }

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Map<String, Long> getTableSizes() throws I18NException {

        String dialect = Configuracio.getDigitalIBProperties()
                .getProperty(Constants.DIGITALIB_PROPERTY_BASE + "hibernate.dialect");

        if (dialect == null) {
            throw new I18NException("genapp.comodi",
                    "No s'ha trobat la propietat de configuració per a " + Constants.DIGITALIB_PROPERTY_BASE
                            + ".hibernate.dialect, dins del fitxer de propietats de l'aplicació.");
        }

        boolean isPostgres = dialect.toLowerCase().contains("postgres");

        if (!isPostgres) {

            boolean isOracle = dialect.toLowerCase().contains("oracle");
            if (!isOracle) {

                throw new I18NException("genapp.comodi",
                        "Dialect no suportat per a la consulta de mida de taules: " + dialect);
            }

        }

        return getTableSizes(entityManager, isPostgres);
    }

    public static Map<String, Long> getTableSizes(EntityManager entityManager, boolean isPostgres) {

        Map<String, Long> tableSizes = new TreeMap<String, Long>();

        if (isPostgres) {
            List<Object[]> results = entityManager
                    .createNativeQuery("SELECT " + " tablename AS table_name, "
                            + " pg_total_relation_size(schemaname || '.' || tablename)  AS total_bytes "
                            + " FROM pg_tables " + " WHERE schemaname NOT IN ('pg_catalog', 'information_schema')")
                    .getResultList();

            for (Object[] row : results) {
                tableSizes.put((String) row[0], ((Number) row[1]).longValue());
            }

        } else {
            // Oracle: user_segments agrupa por segmento (tabla, índice, lob...)
            // Filtramos solo TABLE y sumamos para consolidar particiones si las hay
            List<Object[]> results = entityManager.createNativeQuery(
                    "SELECT " + " segment_name AS table_name, SUM(bytes) AS total_bytes " + " FROM user_segments "
                            + " WHERE segment_type IN ('TABLE', 'TABLE PARTITION', 'TABLE SUBPARTITION') "
                            + " GROUP BY segment_name ")
                    .getResultList();

            for (Object[] row : results) {

                tableSizes.put((String) row[0], ((Number) row[1]).longValue());
            }
        }

        // Ordenar el Map pels valors (de major a menor) i retornar un LinkedHashMap
        Map<String, Long> sortedTableSizes = tableSizes.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedTableSizes;
    }

}
