package es.caib.digitalib.back.controller;

import org.fundaciobit.genapp.common.IGenAppEntity;
import org.fundaciobit.genapp.common.web.controller.CommonBaseController;

/**
 * POT SOBRESCRIURE AQUESTA CLASSE
 * @author anadal
 *
 */
public abstract class DigitalIBBaseController<I extends IGenAppEntity, PK extends Object> 
  extends CommonBaseController<I, PK> {
    
    

    public boolean isVisibleExportData() {
        return false;
    }

}
