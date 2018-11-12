package es.caib.digitalib.jpa.tests;

import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.OrderType;
import org.junit.Test;

import es.caib.digitalib.jpa.DigitalIBJPADaoManagers;
import es.caib.digitalib.model.DigitalIBDaoManager;
import es.caib.digitalib.model.dao.IIdiomaManager;
import es.caib.digitalib.model.entity.Idioma;
import es.caib.digitalib.model.fields.IdiomaFields;

/**
 * 
 * @author anadal
 *
 */
public class TestDigitalIBJPA {

  public static final Logger log = Logger.getLogger(TestDigitalIBJPA.class);

  @Test
  public static final void main(String[] args) {
    try {
      log.info(">>>>>>>>>>>>  Hello World!");

      // USING GENAPP
      // ============

      Properties prop = new Properties();

      //
      // prop.put("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
      // prop.put("javax.persistence.jdbc.driver","com.mysql.jdbc.Driver");
      // prop.put("javax.persistence.jdbc.url", "jdbc:mysql://192.168.35.151:3306/portasib");
      // prop.put("javax.persistence.jdbc.user","portasib");
      // prop.put("javax.persistence.jdbc.password","portasib");
      //

      prop.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
      prop.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
      prop.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/digitalib");
      prop.put("javax.persistence.jdbc.user", "digitalib");
      prop.put("javax.persistence.jdbc.password", "digitalib");

      prop.put("hibernate.connection.driver_class", "org.postgresql.Driver");
      // prop.put("javax.persistence.jdbc.url","jdbc:postgresql://192.168.35.151:5432/pinbaladmin");
      prop.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/digitalib");
      prop.put("hibernate.connection.username", "digitalib");
      prop.put("hibernate.connection.password", "digitalib");

      prop.put("hibernate.show_sql", "true");

      EntityManagerFactory emf;

      // Veure persistence.xml
      emf = Persistence.createEntityManagerFactory("digitalibDBStandalone", prop);

      EntityManager em = emf.createEntityManager();

      em.setFlushMode(FlushModeType.AUTO);

      EntityTransaction tx = em.getTransaction();

      tx.begin();

      boolean f = false;
      if (f) {
        throw new I18NException("werrrtt");
      }

      DigitalIBDaoManager.setDaoManagers(new DigitalIBJPADaoManagers(em)); // firmesDaoManagers

      IIdiomaManager idioma = DigitalIBDaoManager.getDaoManagers().getIdiomaManager();

      List<Idioma> llist = idioma.select(new OrderBy(IdiomaFields.IDIOMAID, OrderType.DESC));

      for (Idioma idioma2 : llist) {
        System.out.println("Idoma = " + idioma2.getIdiomaID() + " => " + idioma2.getNom());
      }

      System.out.println("===");

      llist = idioma.select(IdiomaFields.NOM.like("%Cat%"));

      for (Idioma idioma2 : llist) {
        System.out.println("Idoma222 = " + idioma2.getIdiomaID() + " => " + idioma2.getNom());
      }

      tx.commit();
      log.info("<<<<<<<<<<<  Good Bye!");

    } catch (I18NException e) {
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unused")
  private void testOneByOneDirect(EntityManager em) {

    Query query = em
        .createQuery("select solicitud from SolicitudJPA peticiodefirma"
            + " join fetch peticiodefirma.fluxDeFirmes f  join fetch f.blocDeFirmess b  join fetch b.firmas fi "

            // "   "
            + " where ( " + " fi.firmaID = 58850" + "  )");

    /*
     * 
     * 
     * List<PeticioDeFirmaJPA> peticions = query.getResultList();
     * 
     * int size = peticions.size();
     * 
     * log.info("List Size = " + size);
     * 
     * if (size != 0) { PeticioDeFirmaJPA peticio = peticions.get(0);
     * 
     * log.info("PETICIO ID = " + peticio.getPeticioDeFirmaID());
     * 
     * log.info("FLUX = " + peticio.getFluxDeFirmes());
     * 
     * log.info("FITXER = " + peticio.getFitxerAFirmar());
     * 
     * log.info("POSICIO = " + peticio.getPosicioTaulaFirmes());
     * 
     * 
     * }
     */
  }

}
