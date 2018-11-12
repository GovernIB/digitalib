package es.caib.digitalib.logic;


/*
import es.caib.digitalib.ejb.AnnexEJB;
import es.caib.digitalib.ejb.FitxerLocal;
import es.caib.digitalib.jpa.AnnexJPA;
import es.caib.digitalib.model.entity.AnnexFirmat;
import es.caib.digitalib.model.fields.AnnexFields;
import es.caib.digitalib.model.fields.AnnexFirmatFields;

import org.fundaciobit.genapp.common.i18n.I18NException;

*/

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.SecurityDomain;

/**
 * 
 * @author anadal
 *
 */
@Stateless(name = "SampleLogicaEJB")
@SecurityDomain("seycon")
public class SampleLogicaEJB implements SampleLogicaLocal {


}
 
 /**
@Stateless(name = "AnnexLogicaEJB")
@SecurityDomain("seycon")
public class AnnexLogicaEJB extends AnnexEJB implements AnnexLogicaLocal,
    AnnexFields {


  @EJB(mappedName = "digitalib/FitxerEJB/local")
  private FitxerLocal fitxerEjb;

  @EJB(mappedName = "digitalib/AnnexFirmatEJB/local")
  protected es.caib.digitalib.ejb.AnnexFirmatLocal annexFirmatEjb;
  
  
  @Override
  public AnnexJPA createFull(AnnexJPA annex) throws I18NException {
    // TODO Validar !!!
    
    return (AnnexJPA)create(annex);
  }
  


  @Override
  public Set<Long> deleteFull(AnnexJPA annex) throws I18NException {
    
    Set<Long> files = new HashSet<Long>();
    
    if (annex == null) {
      return files;
    }
    
    // Annex
    delete(annex);
    
    return files;
  }

}
*/
