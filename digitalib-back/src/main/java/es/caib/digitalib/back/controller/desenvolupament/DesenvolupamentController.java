package es.caib.digitalib.back.controller.desenvolupament;

import javax.ejb.EJB;
import javax.ejb.EJBAccessException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.caib.digitalib.ejb.IdiomaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.persistence.IdiomaJPA;
import es.caib.digitalib.model.entity.Idioma;

/**
 * 
 * @author anadal (u80067)
 * 16 jun 2026 10:15:00
 */
@Controller
public class DesenvolupamentController {

    @EJB(mappedName = IdiomaService.JNDI_NAME)
    private IdiomaService idiomaEjb;

    @RequestMapping(value = "/desenvolupament/deletemethod")
    public ModelAndView deleteMethod(HttpServletRequest request, HttpServletResponse response) throws Exception {

        IdiomaJPA i = new IdiomaJPA();
        i.setIdiomaID("eeeee");
        idiomaEjb.delete(i);

        return new ModelAndView("desenvolupament");
    }

    @RequestMapping(value = "/desenvolupament/hibernateerror")
    public ModelAndView hibernateError(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Idioma i = new IdiomaJPA();
        idiomaEjb.delete(i);

        return new ModelAndView("desenvolupament");
    }

    @RequestMapping(value = "/desenvolupament/errorcallback")
    public ModelAndView errorcallback(HttpServletRequest request, HttpServletResponse response) throws Exception {
        boolean test = true;
        if (test) {
            throw new IllegalArgumentException("Either callerSubject or callerRunAs should be non-null");
        } else {
            return new ModelAndView("desenvolupament");
        }

    }

    @RequestMapping(value = "/desenvolupament/errorinvaliduser")
    public ModelAndView errorinvaliduser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        boolean test = true;
        if (test) {
            throw new EJBAccessException("Invalid User");
        } else {
            return new ModelAndView("desenvolupament");
        }

    }

    @RequestMapping(value = "/desenvolupament/modelandviewnoexisteix")
    public ModelAndView modelandviewnoexisteix(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        return new ModelAndView("modelandviewnoexisteix");

    }

    @RequestMapping(value = "/desenvolupament/servletexception")
    public ModelAndView servletexception(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("redirect:/WEB-INF/jsp/webdb/menu_desenvolupament.jsp");
    }

    @RequestMapping(value = "/desenvolupament/jspexception")
    public ModelAndView jspexception(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("errorjsp_desenvolupament");
        mv.addObject("accio", "excepcio");
        return mv;
    }

}
