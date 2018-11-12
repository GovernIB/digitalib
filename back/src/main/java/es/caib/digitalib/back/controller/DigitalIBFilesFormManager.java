package es.caib.digitalib.back.controller;

import es.caib.digitalib.jpa.FitxerJPA;
import es.caib.digitalib.model.entity.Fitxer;

import org.fundaciobit.genapp.common.filesystem.IFileManager;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;


/**
 * Gestiona Multiples Fitxers d'un Form
 * 
 * @author anadal
 * 
 */
public class DigitalIBFilesFormManager extends FilesFormManager<Fitxer> {

  public DigitalIBFilesFormManager(IFileManager<Fitxer, Long> fitxerEjb) {
    super(fitxerEjb);
  }

  @Override
  public FitxerJPA createEmptyFile() {    
    return new FitxerJPA();
  }

}
