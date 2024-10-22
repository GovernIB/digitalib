package es.caib.digitalib.back.controller.admin.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.digitalib.back.form.webdb.TransaccioFilterForm;
import es.caib.digitalib.back.form.webdb.TransaccioForm;
import es.caib.digitalib.model.entity.Transaccio;

/**
 * 
 * @author anadal
 * 14 oct 2024 8:44:50
 */
@Controller
@RequestMapping(value = "/admin/transaccionscaducades")
@SessionAttributes(types = { TransaccioForm.class, TransaccioFilterForm.class })
public class NetejarTransaccionsCaducades extends TransaccionsSenseHashDeFitxerAdminController {

    @Override
    public String getEntityNameCode() {
        return "netejartransaccionscaducades";
    }

    @Override
    public String getEntityNameCodePlural() {
        return "netejartransaccionscaducades.plural";
    }

    @Override
    public String getTileForm() {
        return "expiraTransaccioCaducadaForm";
    }

    @Override
    public String getTileList() {
        return "expiraTransaccioCaducadaList";
    }

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
        return transaccioLogicaEjb.getWhereForExpiredTransactions();
    }

    @Override
    protected void showFields(Set<Field<?>> ocults) {

    }

    @Override
    protected void addAcctionButton(HttpServletRequest request, TransaccioFilterForm fform) {
        fform.addAdditionalButton(new AdditionalButton(
                "fas fa-redo", "netejartransaccionscaducades.boto", "javascript:submitTo('transaccio', '"
                        + request.getContextPath() + getContextWeb() + "/netejartransaccionscaducades')",
                AdditionalButtonStyle.WARNING));
    }

    /**
     *  netejartransaccionscaducades
     * @param request
     * @return
     */
    @RequestMapping(value = "/netejartransaccionscaducades", method = RequestMethod.POST)
    public String netejarTransaccionsCaducades(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute TransaccioFilterForm filterForm) {
        try {

            String[] seleccionats = filterForm.getSelectedItems();

            if (seleccionats != null && seleccionats.length != 0) {

                List<Long> transacctionsID = new ArrayList<Long>();

                for (int i = 0; i < seleccionats.length; i++) {
                    transacctionsID.add(stringToPK(seleccionats[i]));
                }

                List<Transaccio> transaccions = transaccioLogicaEjb.expiraTransaccionsCaducades(transacctionsID);

                // XYZ ZZZ TRA
                HtmlUtils.saveMessageSuccess(request,
                        "S´han expirat " + transaccions.size() + " transaccions caducades.");
            }

        } catch (I18NException i18ne) {
            // XYZ ZZZ TRA
            String msg = "Error expirant transaccions caducades: " + I18NUtils.getMessage(i18ne);
            log.error(msg, i18ne);
            HtmlUtils.saveMessageError(request, msg);

        } catch (Exception e) {
            // XYZ ZZZ TRA
            String msg = "Error expirant transaccions caducades: " + e.getMessage();
            log.error(msg, e);
            HtmlUtils.saveMessageError(request, msg);
        }

        return "redirect:" + getContextWeb() + "/list";

    }

}
