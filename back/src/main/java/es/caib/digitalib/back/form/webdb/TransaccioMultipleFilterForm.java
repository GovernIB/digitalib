
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.TransaccioMultipleFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class TransaccioMultipleFilterForm extends DigitalIBBaseFilterForm implements TransaccioMultipleFields {

  private java.lang.Long transmultipleidDesde;

  public java.lang.Long getTransmultipleidDesde() {
    return this.transmultipleidDesde;
  }

  public void setTransmultipleidDesde(java.lang.Long transmultipleidDesde) {
    this.transmultipleidDesde = transmultipleidDesde;
  }


  private java.lang.Long transmultipleidFins;

  public java.lang.Long getTransmultipleidFins() {
    return this.transmultipleidFins;
  }

  public void setTransmultipleidFins(java.lang.Long transmultipleidFins) {
    this.transmultipleidFins = transmultipleidFins;
  }


  private java.lang.String descripcio;

  public java.lang.String getDescripcio() {
    return this.descripcio;
  }

  public void setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
  }


  public TransaccioMultipleFilterForm() {
  }
  
  public TransaccioMultipleFilterForm(TransaccioMultipleFilterForm __toClone) {
    super(__toClone);
    this.transmultipleidDesde = __toClone.transmultipleidDesde;
    this.transmultipleidFins = __toClone.transmultipleidFins;
    this.descripcio = __toClone.descripcio;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }


  protected OrderBy[] defaultOrderBy = null;


  public OrderBy[] getDefaultOrderBy() {
    return this.defaultOrderBy;
  }

  public void setDefaultOrderBy(OrderBy[] defOrderBy) {
    this.defaultOrderBy = defOrderBy;
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

   // -----------------------
   // Maps de referencies.
   // -----------------------

   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
