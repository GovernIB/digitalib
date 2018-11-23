package es.caib.digitalib.back.controller.all;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.caib.digitalib.back.controller.ScanWebModuleController;

@Controller
@RequestMapping(value = ScanWebModuleController.CONTEXTWEB_PUBLIC)
public class ScanWebModuleControllerPublic extends ScanWebModuleController {

  @Override
  protected String getContextWeb() {
    return CONTEXTWEB_PUBLIC;
  }

}
