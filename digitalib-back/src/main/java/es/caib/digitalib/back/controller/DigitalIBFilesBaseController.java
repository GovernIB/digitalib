package es.caib.digitalib.back.controller;

import es.caib.digitalib.ejb.FitxerService;
import es.caib.digitalib.model.entity.Fitxer;

import org.fundaciobit.genapp.common.IGenAppEntity;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.ITableManager;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.controller.CommonFilesBaseController;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import org.fundaciobit.genapp.common.web.form.BaseFilterForm;
import org.fundaciobit.genapp.common.web.form.BaseForm;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
//import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;

/**
 * POT SOBRESCRIURE AQUESTA CLASSE
 * 
 * @author anadal
 * 
 */
@Controller
public abstract class DigitalIBFilesBaseController<I extends IGenAppEntity, PK extends Object, F extends BaseForm>
        extends CommonFilesBaseController<I, PK, F, Fitxer> {
    
    public static final List<StringKeyValue> EMPTY_STRINGKEYVALUE_LIST_MODIFIABLE = new ArrayList<StringKeyValue>();
    
    public static final List<StringKeyValue> EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE = Collections.unmodifiableList(new ArrayList<StringKeyValue>());
    

    @EJB(mappedName = FitxerService.JNDI_NAME)
    protected FitxerService fitxerEjb;

    /**
     * 
     * @return
     */
    protected FilesFormManager<Fitxer>  getFilesFormManager() {
        return new DigitalIBFilesFormManager(fitxerEjb);
    }
    
    
    @Override 
    protected List<I> processarLlistat(ITableManager<I, PK> ejb,
            BaseFilterForm filterForm, int pagina,
            Where whereAdditionalCondition, ModelAndView mav) throws I18NException {
        
        filterForm.setVisibleExportList(this.isVisibleExportData());
        
        return super.processarLlistat(ejb, filterForm, pagina, whereAdditionalCondition, mav);
        
    }
    

    /**
    * 
    * @param arxiu
    * @return
    */
    public boolean deleteFile(Long fileID) {
        if (fileID != null) {
            Fitxer file = null;
            try {
                file = fitxerEjb.findByPrimaryKey(fileID);
                if (file != null) {
                    fitxerEjb.delete(file);
                }
            } catch (I18NException e) {
                log.error(
                        "Error esborrant arxiu fisic amb id=" + fileID
                                + ((file == null) ? "" : ("(" + file.getNom() + ")")) + ": " + I18NUtils.getMessage(e),
                        e);
            } catch (Exception e) {
                log.error("Error esborrant arxiu fisic amb id=" + fileID
                        + ((file == null) ? "" : ("(" + file.getNom() + ")")) + ": " + e.getMessage(), e);
            }

            return FileSystemManager.eliminarArxiu(fileID);
        }
        return true;
    }

    public boolean isVisibleExportData() {
        return false;
    }

}
