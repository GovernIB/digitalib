package es.caib.digitalib.back.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.caib.digitalib.back.controller.ScanWebModuleController;

@Controller
@RequestMapping(value = ScanWebModuleController.CONTEXTWEB_COMMON)
public class ScanWebModuleControllerCommon extends ScanWebModuleController {

  @Override
  protected String getContextWeb() {
    return CONTEXTWEB_COMMON;
  }

}
