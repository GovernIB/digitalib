
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.UsuariAplicacioFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class UsuariAplicacioFilterForm extends DigitalIBBaseFilterForm implements UsuariAplicacioFields {

  private java.lang.Long usuariAplicacioIDDesde;

  public java.lang.Long getUsuariAplicacioIDDesde() {
    return this.usuariAplicacioIDDesde;
  }

  public void setUsuariAplicacioIDDesde(java.lang.Long usuariAplicacioIDDesde) {
    this.usuariAplicacioIDDesde = usuariAplicacioIDDesde;
  }


  private java.lang.Long usuariAplicacioIDFins;

  public java.lang.Long getUsuariAplicacioIDFins() {
    return this.usuariAplicacioIDFins;
  }

  public void setUsuariAplicacioIDFins(java.lang.Long usuariAplicacioIDFins) {
    this.usuariAplicacioIDFins = usuariAplicacioIDFins;
  }


  private java.lang.String username;

  public java.lang.String getUsername() {
    return this.username;
  }

  public void setUsername(java.lang.String username) {
    this.username = username;
  }


  private java.lang.String contrasenya;

  public java.lang.String getContrasenya() {
    return this.contrasenya;
  }

  public void setContrasenya(java.lang.String contrasenya) {
    this.contrasenya = contrasenya;
  }


  private java.lang.String emailAdmin;

  public java.lang.String getEmailAdmin() {
    return this.emailAdmin;
  }

  public void setEmailAdmin(java.lang.String emailAdmin) {
    this.emailAdmin = emailAdmin;
  }


  private java.lang.String descripcio;

  public java.lang.String getDescripcio() {
    return this.descripcio;
  }

  public void setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
  }


  public UsuariAplicacioFilterForm() {
  }
  
  public UsuariAplicacioFilterForm(UsuariAplicacioFilterForm __toClone) {
    super(__toClone);
    this.usuariAplicacioIDDesde = __toClone.usuariAplicacioIDDesde;
    this.usuariAplicacioIDFins = __toClone.usuariAplicacioIDFins;
    this.username = __toClone.username;
    this.contrasenya = __toClone.contrasenya;
    this.emailAdmin = __toClone.emailAdmin;
    this.descripcio = __toClone.descripcio;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { USERNAME }));
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
