package es.caib.digitalib.logic;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.MetadadaEJB;
import es.caib.digitalib.model.entity.Metadada;

/**
 * 
 * @author anadal(u80067)
 *
 */
@Stateless(name = "MetadadaLogicaEJB")
@SecurityDomain("seycon")
public class MetadadaLogicaEJB extends MetadadaEJB implements MetadadaLogicaLocal {

  @Override
  @PermitAll
  public synchronized Metadada create( long _transaccioID_, java.lang.String _nom_, java.lang.String _valor_) throws I18NException {
    
    return super.create(_transaccioID_, _nom_, _valor_);
  }


}
