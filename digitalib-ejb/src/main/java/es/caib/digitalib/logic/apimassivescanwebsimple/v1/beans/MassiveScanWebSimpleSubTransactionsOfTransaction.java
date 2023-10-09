package es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author anadal (u80067)
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MassiveScanWebSimpleSubTransactionsOfTransaction {

  protected String transactionID;

  protected List<String> subtransacions;

  public MassiveScanWebSimpleSubTransactionsOfTransaction() {
    super();
  }

  public MassiveScanWebSimpleSubTransactionsOfTransaction(String transactionID,
      List<String> subtransacions) {
    super();
    this.transactionID = transactionID;
    this.subtransacions = subtransacions;
  }

  public String getTransactionID() {
    return transactionID;
  }

  public void setTransactionID(String transactionID) {
    this.transactionID = transactionID;
  }

  public List<String> getSubtransacions() {
    return subtransacions;
  }

  public void setSubtransacions(List<String> subtransacions) {
    this.subtransacions = subtransacions;
  }

}
