package es.caib.digitalib.back.controller.admin;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.digitalib.back.controller.webdb.FitxerController;
import es.caib.digitalib.back.form.webdb.FitxerFilterForm;
import es.caib.digitalib.back.form.webdb.FitxerForm;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.model.fields.ConfiguracioGrupFields;
import es.caib.digitalib.model.fields.TransaccioFields;



/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/admin/fitxersorfes")
@SessionAttributes(types = { FitxerForm.class, FitxerFilterForm.class })
public class FitxersOrfesController extends FitxerController {
  

  @EJB(mappedName = es.caib.digitalib.ejb.TransaccioLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.TransaccioLocal transaccioEjb;

  

  @EJB(mappedName = es.caib.digitalib.ejb.ConfiguracioGrupLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.ConfiguracioGrupLocal configuracioGrupEjb;

  @Override
  public String getTileList() {
    return "fitxersOrfesList";
  }
  
  @Override
  public boolean isActiveFormNew() {
    return false;
  }

  @Override
  public boolean isActiveFormEdit() {
    return false;
  }

  @Override
  public boolean isActiveDelete() {
    return true;
  }

  @Override
  public boolean isActiveFormView() {
    return true;
  }
  
  @Override
  public FitxerFilterForm getFitxerFilterForm(Integer pagina, ModelAndView mav,
      HttpServletRequest request) throws I18NException {
      FitxerFilterForm fitxerFilterForm;
      fitxerFilterForm = (FitxerFilterForm)super.getFitxerFilterForm(pagina, mav, request);
      
      if (fitxerFilterForm.isNou()) {
        fitxerFilterForm.setTitleCode("fitxers.orfes");
        fitxerFilterForm.setAddButtonVisible(false);
      }
      
      
      
      return fitxerFilterForm;
  }
  
  @Override
  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    Where parent = super.getAdditionalCondition(request);

    Where w1 = FITXERID.notIn(transaccioEjb.getSubQuery(TransaccioFields.FITXERESCANEJATID, null));
    Where w2 = FITXERID.notIn(transaccioEjb.getSubQuery(TransaccioFields.FITXERSIGNATURAID, null));
    Where w3 = FITXERID.notIn(configuracioGrupEjb.getSubQuery(ConfiguracioGrupFields.LOGOFOOTERID, null));
    Where w4 = FITXERID.notIn(configuracioGrupEjb.getSubQuery(ConfiguracioGrupFields.LOGOHEADERID, null));
    
    return Where.AND(parent, w1, w2 ,w3, w4);
  }
  
  @Override
  public String getSessionAttributeFilterForm() {
    return "FitxersOrfes_FilterForm";
  }
  
  @Override
  public void postList(HttpServletRequest request, ModelAndView mav, FitxerFilterForm filterForm,  List<Fitxer> list) throws I18NException {
  
    

    Map<Long, File> fitxersFisics = FileSystemManager.getAllFiles();
    
//    File path = FileSystemManager.getFilesPath();
//    List<String> fitxersFisics = new ArrayList<String>(Arrays.asList(path.list(new FilenameFilter() {
//      /**
//       * No volem directoris
//       */
//      @Override
//      public boolean accept(File dir, String name) {
//        return new File(dir, name).isFile();
//      }
//    })));
    
//    fitxersFisics.remove(AutoFirmaController.AUTOFIRMA);
    
    List<Long> fitxersBBDD = fitxerEjb.executeQuery(FITXERID, null, new OrderBy(FITXERID));
    
    // Fitxers que existeixen en BBDD però no fisicament
    for (Long fID : fitxersBBDD) {
      //File f = FileSystemManager.getFile(fID);
      //  fitxersFisics.contains(String.valueOf(fID))
      if (!fitxersFisics.containsKey(fID)) {
        HtmlUtils.saveMessageError(request, I18NUtils.tradueix("fitxersorfes.noexistex", String.valueOf(fID)));
      }
    }

    // Fitxers que existeixen fisicament però no en BBDD
    for (Long fBDID : fitxersBBDD) {
      
      if (fitxersFisics.containsKey(fBDID)) {
        fitxersFisics.remove(fBDID);
      }
    }
    for (Map.Entry<Long, File> fFisic : fitxersFisics.entrySet()) {
      HtmlUtils.saveMessageError(request, "Fitxer Fisic amb id ]"
          + fFisic.getKey() + "[ (" + fFisic.getValue().getAbsolutePath() +") no existeix en la BBDD !!!" );  
    }
    

    
  }
  
 
  
}