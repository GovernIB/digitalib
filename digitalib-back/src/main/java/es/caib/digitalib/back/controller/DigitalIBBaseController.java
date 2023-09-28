package es.caib.digitalib.back.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.fundaciobit.genapp.common.IGenAppEntity;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.ITableManager;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.controller.CommonBaseController;
import org.fundaciobit.genapp.common.web.form.BaseFilterForm;
import org.springframework.web.servlet.ModelAndView;

/**
 * POT SOBRESCRIURE AQUESTA CLASSE
 * @author anadal
 *
 */
public abstract class DigitalIBBaseController<I extends IGenAppEntity, PK extends Object> 
  extends CommonBaseController<I, PK> {
    
    public static final List<StringKeyValue> EMPTY_STRINGKEYVALUE_LIST_MODIFIABLE = new ArrayList<StringKeyValue>();
    
    public static final List<StringKeyValue> EMPTY_STRINGKEYVALUE_LIST_UNMODIFIABLE = Collections.unmodifiableList(new ArrayList<StringKeyValue>());
   
    
    @Override 
    protected List<I> processarLlistat(ITableManager<I, PK> ejb,
            BaseFilterForm filterForm, int pagina,
            Where whereAdditionalCondition, ModelAndView mav) throws I18NException {
        
        filterForm.setVisibleExportList(this.isVisibleExportData());
        
        return super.processarLlistat(ejb, filterForm, pagina, whereAdditionalCondition, mav);
        
    }
    
    
    public boolean isVisibleExportData() {
        return false;
    }


}
