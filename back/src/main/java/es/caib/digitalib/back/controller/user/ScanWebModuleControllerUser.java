package es.caib.digitalib.back.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.caib.digitalib.back.controller.AbstractScanWebModuleController;

@Controller
@RequestMapping(value = AbstractScanWebModuleController.CONTEXTWEB_USER)
public class ScanWebModuleControllerUser extends AbstractScanWebModuleController {

  @Override
  protected String getContextWeb() {
    return CONTEXTWEB_USER;
  }

}
