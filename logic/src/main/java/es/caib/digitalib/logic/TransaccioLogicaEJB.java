package es.caib.digitalib.logic;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.hibernate.Hibernate;
import org.jboss.ejb3.annotation.SecurityDomain;

import es.caib.digitalib.ejb.TransaccioEJB;
import es.caib.digitalib.jpa.TransaccioJPA;
import es.caib.digitalib.model.entity.Perfil;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.fields.TransaccioFields;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "TransaccioLogicaEJB")
@SecurityDomain("seycon")
@RunAs("DIB_ADMIN")
public class TransaccioLogicaEJB extends TransaccioEJB implements TransaccioLogicaLocal {

  @EJB(mappedName = es.caib.digitalib.ejb.PerfilLocal.JNDI_NAME)
  protected es.caib.digitalib.ejb.PerfilLocal perfilEjb;

  @Override
  public Transaccio createWithProfile(TransaccioJPA transaccio) throws I18NException {

    Perfil perfil = (Perfil) transaccio.getPerfil();

    if (perfil == null) {
      // XYZ ZZZ ZZZ Llança excepcio I18NException
    }

    perfil = perfilEjb.create(perfil);

    transaccio.setPerfil(null);
    transaccio.setPerfilid(perfil.getPerfilID());

    return this.create(transaccio);

  }
  
  
  @Override
  public TransaccioJPA searchTransaccioByTransactionWebID(String transactionWebID) throws I18NException {
    List<Transaccio> list = select(TransaccioFields.TRANSACTIONWEBID.equal(transactionWebID));

    if (list == null || list.size() == 0) {
      return null;
    }

    TransaccioJPA transaccio = (TransaccioJPA)list.get(0);
    
    Hibernate.initialize(transaccio.getPerfil());
    
    return transaccio;
    
  }
  
  
  @Override
  @PermitAll
  public Transaccio update(Transaccio instance) throws I18NException {
     return super.update(instance);
  }
  

}
