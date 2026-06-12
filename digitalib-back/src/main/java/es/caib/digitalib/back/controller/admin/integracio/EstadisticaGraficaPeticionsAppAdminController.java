package es.caib.digitalib.back.controller.admin.integracio;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import org.fundaciobit.genapp.common.query.SelectDistinct;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.query.selectcolumn.Select2Columns;
import org.fundaciobit.genapp.common.query.selectcolumn.Select2Values;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.fundaciobit.genapp.common.web.tiles.Tile;
import org.fundaciobit.genapp.common.web.tiles.TileAttribute;
import org.fundaciobit.genapp.common.web.tiles.TileType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.caib.digitalib.back.controller.admin.grafiquesestadistica.EstadisticaFilterModel;
import es.caib.digitalib.back.controller.admin.grafiquesestadistica.FilterModelItem;
import es.caib.digitalib.back.controller.admin.web.EstadisticaGraficaPeticionsWebAdminController;
import es.caib.digitalib.back.utils.Tab;
import es.caib.digitalib.model.fields.TransaccioFields;
import es.caib.digitalib.model.fields.UsuariAplicacioFields;

/**
 * Controlador de gràfiques de consultes a EvidènciesIB.
 * 
 * @author anadal (u80067)
 * 29 may 2026 11:05:39
 */
@MenuOption(
        labelCode = "=Gràfiques de transaccions a DigitalIB",
        order = 100,
        group = Tab.MENU_ADMIN,
        baseLink = "/admin/estadisticagraficaapp/",
        relativeLink = "/",
        addSeparatorBefore = true)
@Tile(
        name = "estadisticaAdminDigitalIB",
        extendsTile = Tab.MENU_ADMIN,
        // Els següents atributs no són necessaris si heredes aquesta classe
        contentJsp = "/WEB-INF/jsp/admin/estadistica.jsp",
        type = TileType.WEBDB_FORM,
        attributes = { @TileAttribute(name = "titol", value = "estadistica.estadistica") })
@Controller
@RequestMapping(value = "/admin/estadisticagraficaapp")
public class EstadisticaGraficaPeticionsAppAdminController extends EstadisticaGraficaPeticionsWebAdminController {

    @EJB(mappedName = es.caib.digitalib.ejb.UsuariAplicacioService.JNDI_NAME)
    protected es.caib.digitalib.ejb.UsuariAplicacioService usuariAplicacioEjb;

    @Override
    public Where getAdditionalWhere(EstadisticaFilterModel filter) {
        Where where = TransaccioFields.USUARIAPLICACIOID.isNotNull();

        List<FilterModelItem> filtres = filter.getFilters();

        if (filtres != null && filtres.size() > 0) {
            for (FilterModelItem item : filtres) {
                if ("usuariAplicacioId".equals(item.getName()) && item.getValue() != null) {
                    where = Where.AND(where, TransaccioFields.USUARIAPLICACIOID.equal(Long.valueOf(item.getValue())));
                }
            }
        }

        return where;
    }

    @Override
    public List<FilterModelItem> getAvailableFilters(Timestamp from, Timestamp to) throws Exception {

        FilterModelItem item = new FilterModelItem();
        item.setLabel("Usuari Aplicació");
        item.setValue(null);
        item.setName("usuariAplicacioId");

        Where wFromTo = Where.AND(TransaccioFields.DATAINICI.between(from, to),
                TransaccioFields.USUARIAPLICACIOID.isNotNull());

        Map<String, String> aplicacioIdToUsername = new HashMap<String, String>();
        {

            // Llegim les persones que han fet transaccions que han fet peticions en aquesta dates
            List<Long> persones = transaccioLogicaEjb.executeQuery(
                    new SelectDistinct<Long>(TransaccioFields.USUARIAPLICACIOID),
                    Where.AND(TransaccioFields.USUARIAPLICACIOID.isNotNull(), wFromTo));
            // Necessitam un MAp de ID aplicació cap a username d'aplicació

            List<Select2Values<Long, String>> llistat = usuariAplicacioEjb.executeQuery(
                    new Select2Columns<Long, String>(UsuariAplicacioFields.USUARIAPLICACIOID.select,
                            UsuariAplicacioFields.USERNAME.select),
                    UsuariAplicacioFields.USUARIAPLICACIOID.in(persones));

            for (Select2Values<Long, String> v : llistat) {
                aplicacioIdToUsername.put(String.valueOf(v.getValue1()), v.getValue2());
            }

            item.setOptions(aplicacioIdToUsername);

        }

        return List.of(item);
    }

    @Override
    public String getTile() {
        return "estadisticagraficaAdminIntegracions";
    }

    @Override
    public String getTitle() {
        return "Gràfiques de transaccions d'Aplicacions";
    }

}
