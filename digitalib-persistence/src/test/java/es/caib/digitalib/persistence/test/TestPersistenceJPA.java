package es.caib.digitalib.persistence.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.filesystem.ThreeFolderFileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.OrderType;
import org.fundaciobit.genapp.common.query.Where;
import org.jboss.logging.Logger;

import es.caib.digitalib.persistence.DigitalIBJPADaoManagers;
import es.caib.digitalib.persistence.FitxerJPA;
import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.model.DigitalIBDaoManager;
import es.caib.digitalib.model.IDigitalIBDaoManagers;
import es.caib.digitalib.model.dao.IFitxerManager;
import es.caib.digitalib.model.dao.ITransaccioManager;
import es.caib.digitalib.model.dao.ITransaccioMultipleManager;
import es.caib.digitalib.model.entity.Fitxer;
import es.caib.digitalib.model.entity.Transaccio;
import es.caib.digitalib.model.entity.TransaccioMultiple;
import es.caib.digitalib.model.fields.TransaccioFields;

/*
 * IMPORTANT - NO MODIFICAR - DERIVA AQUESTA CLASSE SI VOLS FER UN TEST 
 * IMPORTANT - DO NOT MODIFY - EXTENDS THIS CLASS IF YOU WANT DO A TEST
 *
 */

/**
 * 
 * @author anadal
 *
 */
public class TestPersistenceJPA {

    public static final Logger log = Logger.getLogger(TestPersistenceJPA.class);

    public static final void main(String[] args) {

        EntityManager em = null;
        EntityTransaction tx = null;

        try {

            log.info(">>>>>>>>>>>>  Hello World!");


            // USING GENAPP
            // ============

            em = initDB();

            tx = em.getTransaction();

            tx.begin();

            // CADA TEST HA d'ANAR DINS D'UNA TRANSACCIO  !!!!!!!

            /*   EXEMPLE DE CRIDADA DIRECTE
              
             
            String hsql = "SELECT " + PluginFields.NOMID.fullName
             + " FROM PluginJPA plugin, 
             + " ORDER BY " + PluginFields.NOMID.fullName + " DESC";
            
            javax.persistence.Query qry = em.createQuery(hsql);
            
            List<Object> list = qry.getResultList();
            for (Object object : list) {
                System.out.println("Object[] => " + object);
            }
            
            */
            
            
            /*  CONSULTA IDIOMES DISPONIBLES
             * IIdiomaManager idioma = DigitalIBDaoManager.getDaoManagers().getIdiomaManager();
             * 
             * List<Idioma> llist = idioma.select(new OrderBy(IdiomaFields.IDIOMAID,
             * OrderType.DESC));
             * 
             * for (Idioma idioma2 : llist) { System.out.println("Idoma = " +
             * idioma2.getIdiomaID() + " => " + idioma2.getNom()); }
             * 
             * System.out.println("===");
             * 
             * llist = idioma.select(IdiomaFields.NOM.like("%Cat%"));
             * 
             * for (Idioma idioma2 : llist) { System.out.println("Idoma222 = " +
             * idioma2.getIdiomaID() + " => " + idioma2.getNom()); }
             * 
             */

            restaurarFitxersNetejats();

            tx.commit();
            log.info("<<<<<<<<<<<  Good Bye!");

            System.out.println("END");

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (em != null) {
            em.close();
        }
        System.exit(0);
    }

    private static void restaurarFitxersNetejats() throws Exception, I18NException {
        
        

        FileSystemManager.setFileSystemManager(new ThreeFolderFileSystemManager());
        FileSystemManager.setFilesPath(
                new File("D:\\dades\\dades\\CarpetesPersonals\\ProgramacioPortaFIB2\\digitalib-files"));

        byte[] data = FileSystemManager.readFileToByteArray(new File("pdf_buit.pdf"));

        FitxerJPA fitxerBase = new FitxerJPA();
        fitxerBase.setDescripcio(null);
        fitxerBase.setNom("pdf_buit.pdf");
        fitxerBase.setMime("application/pdf");
        fitxerBase.setTamany(data.length);
        
        
        IDigitalIBDaoManagers daoManager = DigitalIBDaoManager.getDaoManagers();

        IFitxerManager fitxerDao = daoManager.getFitxerManager();
        ITransaccioManager transaccioDao = daoManager.getTransaccioManager();
        ITransaccioMultipleManager transaccioMDao = daoManager.getTransaccioMultipleManager();

        Where w1 = TransaccioFields.USUARIAPLICACIOID.isNotNull();
        //Where w2 = TransaccioFields.TRANSACCIOID.lessThan(2700L);
        Where w2 = TransaccioFields.ESTATCODI.equal(Constants.TRANSACCIO_ESTAT_CODI_OK);
        Where w3 = TransaccioFields.FITXERESCANEJATID.isNull();

        OrderBy order = new OrderBy(TransaccioFields.DATAINICI, OrderType.ASC);

        List<Long> noms = transaccioDao.executeQuery(TransaccioFields.TRANSACCIOID, Where.AND(w1, w2, w3), order);
        System.out.println("executeQuery PRO");



        for (Long id : noms) {
            System.out.println("ID[" + id + "]");
            Transaccio t = transaccioDao.findByPrimaryKey(id);

            if (t.getFitxerEscanejatID() == null) {

                Fitxer copy = FitxerJPA.copyJPA(fitxerBase);
                copy.setFitxerID(0);
                copy = fitxerDao.create(copy);

                t.setFitxerEscanejatID(copy.getFitxerID());

                transaccioDao.update(t);

                FileSystemManager.crearFitxer(new ByteArrayInputStream(data), copy.getFitxerID());

                System.out.println("For transID=" + t.getTransaccioID() + " fitxer creat per ESCANEJAT = "
                        + copy.getFitxerID());
            }

            if (t.getFitxerSignaturaID() == null) {

                Fitxer copy = FitxerJPA.copyJPA(fitxerBase);
                copy.setFitxerID(0);
                copy = fitxerDao.create(copy);

                t.setFitxerSignaturaID(copy.getFitxerID());

                transaccioDao.update(t);

                FileSystemManager.crearFitxer(new ByteArrayInputStream(data), copy.getFitxerID());

                System.out.println("For transID=" + t.getTransaccioID() + " fitxer creat per SIGNATURA = "
                        + copy.getFitxerID());
            }
            Long tmId = t.getTransaccioMultipleID();
            if (tmId != null) {
                TransaccioMultiple tm = transaccioMDao.findByPrimaryKey(tmId);

                if (tm.getFitxerEscanejatID() == null) {

                    Fitxer copy = FitxerJPA.copyJPA(fitxerBase);
                    copy.setFitxerID(0);
                    copy = fitxerDao.create(copy);

                    tm.setFitxerEscanejatID(copy.getFitxerID());

                    transaccioMDao.update(tm);

                    FileSystemManager.crearFitxer(new ByteArrayInputStream(data), copy.getFitxerID());

                    System.out.println("For trans-MULTIPLE-ID=" + t.getTransaccioID() + " fitxer creat per FULL = "
                            + copy.getFitxerID());
                }

            }


        }
    }

    /**
     * 
     * @return
     */
    public static EntityManager initDB() {
        Properties prop = new Properties();

        prop.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
        prop.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/digitalib");
        prop.put("javax.persistence.jdbc.user", "digitalib");
        prop.put("javax.persistence.jdbc.password", "digitalib");

        prop.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/digitalib");
        prop.put("hibernate.connection.username", "digitalib");
        prop.put("hibernate.connection.password", "digitalib");

        prop.put("hibernate.show_sql", "false");

        EntityManagerFactory emf;

        // Veure persistence.xml
        emf = Persistence.createEntityManagerFactory("digitalibPULocal", prop);

        EntityManager em = emf.createEntityManager();

        em.setFlushMode(FlushModeType.AUTO);

        DigitalIBDaoManager.setDaoManagers(new DigitalIBJPADaoManagers(em));

        return em;
    }

}
