package es.caib.digitalib.model;

public class DigitalIBDaoManager {
  
  private static IDigitalIBDaoManagers instance = null;
  
  public static void setDaoManagers(IDigitalIBDaoManagers managers) {
    instance = managers;
  }
  
  public static IDigitalIBDaoManagers getDaoManagers() throws Exception {
    if(instance == null) {
      throw new Exception("Ha de inicialitzar el sistema de Managers cridant "
          + " al mètode DigitalIBDaoManager.setDaoManagers(...)");
    }
    return instance;
  }
  
}
