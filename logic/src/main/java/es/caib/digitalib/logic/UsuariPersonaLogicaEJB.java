package es.caib.digitalib.logic;

import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.hibernate.Hibernate;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.UsuariPersonaEJB;
import es.caib.digitalib.jpa.UsuariPersonaJPA;
import es.caib.digitalib.model.fields.UsuariPersonaFields;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "UsuariPersonaLogicaEJB")
@SecurityDomain("seycon")
public class UsuariPersonaLogicaEJB extends UsuariPersonaEJB implements
    UsuariPersonaLogicaLocal {

  @Override
  public UsuariPersonaJPA createFull(UsuariPersonaJPA usuariPersona) throws I18NException {

    return (UsuariPersonaJPA) create(usuariPersona);

  }

  @Override
  public UsuariPersonaJPA findByUsernameFull(String username) throws I18NException {

    UsuariPersonaJPA usuariPersona;

    Long usuariPersonaID = executeQueryOne(UsuariPersonaFields.USUARIPERSONAID,
        UsuariPersonaFields.USERNAME.equal(username));

    if (usuariPersonaID == null) {
      usuariPersona = null;
    } else {
      usuariPersona = findByPrimaryKey(usuariPersonaID);
    }

    if (usuariPersona != null) {
      Hibernate.initialize(usuariPersona.getConfiguracioGrup());
    }

    return usuariPersona;
  }

}
