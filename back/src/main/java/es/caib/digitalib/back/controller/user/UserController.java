package es.caib.digitalib.back.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {

  
  @RequestMapping(value = "/llistatperfilsdisponibles")
  public ModelAndView option1(HttpSession session,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    ModelAndView mav = new ModelAndView("llistatperfilsdisponibles");
    // mav.addObject("optionNumber", "OPCIÓ USER -1-");
    return mav;
    
  }
  
  
  
  
}
