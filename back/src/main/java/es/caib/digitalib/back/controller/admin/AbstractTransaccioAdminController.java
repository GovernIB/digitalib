package es.caib.digitalib.back.controller.admin;

import es.caib.digitalib.back.controller.AbstractTransaccioController;

/**
 * 
 * @author u139636
 * @author anadal(u80067)
 */
public abstract class AbstractTransaccioAdminController extends AbstractTransaccioController {

  @Override
  public String getTileForm() {
    return "transaccioFormAdmin";
  }

  @Override
  public String getTileList() {
    return "transaccioListAdmin";
  }

  @Override
  public String getSessionAttributeFilterForm() {
    return "TransaccioAdmin_FilterForm_" + isUtilitzatPerAplicacio();
  }
  
  public abstract boolean isUtilitzatPerAplicacio();
  
  @Override
  public String getPerfilInfoContextWeb() {
    return PerfilInfoTransaccioAdminController.CONTEXTWEB;
  }

}
