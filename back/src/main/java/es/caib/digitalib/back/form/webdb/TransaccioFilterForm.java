
package es.caib.digitalib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.digitalib.back.form.DigitalIBBaseFilterForm;

import es.caib.digitalib.model.fields.TransaccioFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class TransaccioFilterForm extends DigitalIBBaseFilterForm implements TransaccioFields {

  private java.lang.Long transaccioIDDesde;

  public java.lang.Long getTransaccioIDDesde() {
    return this.transaccioIDDesde;
  }

  public void setTransaccioIDDesde(java.lang.Long transaccioIDDesde) {
    this.transaccioIDDesde = transaccioIDDesde;
  }


  private java.lang.Long transaccioIDFins;

  public java.lang.Long getTransaccioIDFins() {
    return this.transaccioIDFins;
  }

  public void setTransaccioIDFins(java.lang.Long transaccioIDFins) {
    this.transaccioIDFins = transaccioIDFins;
  }


  private java.lang.String transactionWebId;

  public java.lang.String getTransactionWebId() {
    return this.transactionWebId;
  }

  public void setTransactionWebId(java.lang.String transactionWebId) {
    this.transactionWebId = transactionWebId;
  }


  private java.sql.Timestamp datainiciDesde;

  public java.sql.Timestamp getDatainiciDesde() {
    return this.datainiciDesde;
  }

  public void setDatainiciDesde(java.sql.Timestamp datainiciDesde) {
    this.datainiciDesde = datainiciDesde;
  }


  private java.sql.Timestamp datainiciFins;

  public java.sql.Timestamp getDatainiciFins() {
    return this.datainiciFins;
  }

  public void setDatainiciFins(java.sql.Timestamp datainiciFins) {
    this.datainiciFins = datainiciFins;
  }


  private java.sql.Timestamp datafiDesde;

  public java.sql.Timestamp getDatafiDesde() {
    return this.datafiDesde;
  }

  public void setDatafiDesde(java.sql.Timestamp datafiDesde) {
    this.datafiDesde = datafiDesde;
  }


  private java.sql.Timestamp datafiFins;

  public java.sql.Timestamp getDatafiFins() {
    return this.datafiFins;
  }

  public void setDatafiFins(java.sql.Timestamp datafiFins) {
    this.datafiFins = datafiFins;
  }


  private java.lang.Long usuariaplicacioidDesde;

  public java.lang.Long getUsuariaplicacioidDesde() {
    return this.usuariaplicacioidDesde;
  }

  public void setUsuariaplicacioidDesde(java.lang.Long usuariaplicacioidDesde) {
    this.usuariaplicacioidDesde = usuariaplicacioidDesde;
  }


  private java.lang.Long usuariaplicacioidFins;

  public java.lang.Long getUsuariaplicacioidFins() {
    return this.usuariaplicacioidFins;
  }

  public void setUsuariaplicacioidFins(java.lang.Long usuariaplicacioidFins) {
    this.usuariaplicacioidFins = usuariaplicacioidFins;
  }


  private java.lang.Long usuaripersonaidDesde;

  public java.lang.Long getUsuaripersonaidDesde() {
    return this.usuaripersonaidDesde;
  }

  public void setUsuaripersonaidDesde(java.lang.Long usuaripersonaidDesde) {
    this.usuaripersonaidDesde = usuaripersonaidDesde;
  }


  private java.lang.Long usuaripersonaidFins;

  public java.lang.Long getUsuaripersonaidFins() {
    return this.usuaripersonaidFins;
  }

  public void setUsuaripersonaidFins(java.lang.Long usuaripersonaidFins) {
    this.usuaripersonaidFins = usuaripersonaidFins;
  }


  private java.lang.Integer estatcodiDesde;

  public java.lang.Integer getEstatcodiDesde() {
    return this.estatcodiDesde;
  }

  public void setEstatcodiDesde(java.lang.Integer estatcodiDesde) {
    this.estatcodiDesde = estatcodiDesde;
  }


  private java.lang.Integer estatcodiFins;

  public java.lang.Integer getEstatcodiFins() {
    return this.estatcodiFins;
  }

  public void setEstatcodiFins(java.lang.Integer estatcodiFins) {
    this.estatcodiFins = estatcodiFins;
  }


  private java.lang.String estatmissatge;

  public java.lang.String getEstatmissatge() {
    return this.estatmissatge;
  }

  public void setEstatmissatge(java.lang.String estatmissatge) {
    this.estatmissatge = estatmissatge;
  }


  private java.lang.String estatexcepcio;

  public java.lang.String getEstatexcepcio() {
    return this.estatexcepcio;
  }

  public void setEstatexcepcio(java.lang.String estatexcepcio) {
    this.estatexcepcio = estatexcepcio;
  }


  private java.lang.Long fitxerescanejatidDesde;

  public java.lang.Long getFitxerescanejatidDesde() {
    return this.fitxerescanejatidDesde;
  }

  public void setFitxerescanejatidDesde(java.lang.Long fitxerescanejatidDesde) {
    this.fitxerescanejatidDesde = fitxerescanejatidDesde;
  }


  private java.lang.Long fitxerescanejatidFins;

  public java.lang.Long getFitxerescanejatidFins() {
    return this.fitxerescanejatidFins;
  }

  public void setFitxerescanejatidFins(java.lang.Long fitxerescanejatidFins) {
    this.fitxerescanejatidFins = fitxerescanejatidFins;
  }


  private java.lang.Long fitxersignaturaidDesde;

  public java.lang.Long getFitxersignaturaidDesde() {
    return this.fitxersignaturaidDesde;
  }

  public void setFitxersignaturaidDesde(java.lang.Long fitxersignaturaidDesde) {
    this.fitxersignaturaidDesde = fitxersignaturaidDesde;
  }


  private java.lang.Long fitxersignaturaidFins;

  public java.lang.Long getFitxersignaturaidFins() {
    return this.fitxersignaturaidFins;
  }

  public void setFitxersignaturaidFins(java.lang.Long fitxersignaturaidFins) {
    this.fitxersignaturaidFins = fitxersignaturaidFins;
  }


  private java.lang.Integer infoscanpixeltypeDesde;

  public java.lang.Integer getInfoscanpixeltypeDesde() {
    return this.infoscanpixeltypeDesde;
  }

  public void setInfoscanpixeltypeDesde(java.lang.Integer infoscanpixeltypeDesde) {
    this.infoscanpixeltypeDesde = infoscanpixeltypeDesde;
  }


  private java.lang.Integer infoscanpixeltypeFins;

  public java.lang.Integer getInfoscanpixeltypeFins() {
    return this.infoscanpixeltypeFins;
  }

  public void setInfoscanpixeltypeFins(java.lang.Integer infoscanpixeltypeFins) {
    this.infoscanpixeltypeFins = infoscanpixeltypeFins;
  }


  private java.lang.Integer infoscanresoluciopppDesde;

  public java.lang.Integer getInfoscanresoluciopppDesde() {
    return this.infoscanresoluciopppDesde;
  }

  public void setInfoscanresoluciopppDesde(java.lang.Integer infoscanresoluciopppDesde) {
    this.infoscanresoluciopppDesde = infoscanresoluciopppDesde;
  }


  private java.lang.Integer infoscanresoluciopppFins;

  public java.lang.Integer getInfoscanresoluciopppFins() {
    return this.infoscanresoluciopppFins;
  }

  public void setInfoscanresoluciopppFins(java.lang.Integer infoscanresoluciopppFins) {
    this.infoscanresoluciopppFins = infoscanresoluciopppFins;
  }


  private java.lang.String infoscanformatfitxer;

  public java.lang.String getInfoscanformatfitxer() {
    return this.infoscanformatfitxer;
  }

  public void setInfoscanformatfitxer(java.lang.String infoscanformatfitxer) {
    this.infoscanformatfitxer = infoscanformatfitxer;
  }


  private java.lang.Long infosignaturaidDesde;

  public java.lang.Long getInfosignaturaidDesde() {
    return this.infosignaturaidDesde;
  }

  public void setInfosignaturaidDesde(java.lang.Long infosignaturaidDesde) {
    this.infosignaturaidDesde = infosignaturaidDesde;
  }


  private java.lang.Long infosignaturaidFins;

  public java.lang.Long getInfosignaturaidFins() {
    return this.infosignaturaidFins;
  }

  public void setInfosignaturaidFins(java.lang.Long infosignaturaidFins) {
    this.infosignaturaidFins = infosignaturaidFins;
  }


  private java.lang.Long infocustodyidDesde;

  public java.lang.Long getInfocustodyidDesde() {
    return this.infocustodyidDesde;
  }

  public void setInfocustodyidDesde(java.lang.Long infocustodyidDesde) {
    this.infocustodyidDesde = infocustodyidDesde;
  }


  private java.lang.Long infocustodyidFins;

  public java.lang.Long getInfocustodyidFins() {
    return this.infocustodyidFins;
  }

  public void setInfocustodyidFins(java.lang.Long infocustodyidFins) {
    this.infocustodyidFins = infocustodyidFins;
  }


  private java.lang.String languageui;

  public java.lang.String getLanguageui() {
    return this.languageui;
  }

  public void setLanguageui(java.lang.String languageui) {
    this.languageui = languageui;
  }


  private java.lang.String languagedoc;

  public java.lang.String getLanguagedoc() {
    return this.languagedoc;
  }

  public void setLanguagedoc(java.lang.String languagedoc) {
    this.languagedoc = languagedoc;
  }


  private java.lang.String ciutadanif;

  public java.lang.String getCiutadanif() {
    return this.ciutadanif;
  }

  public void setCiutadanif(java.lang.String ciutadanif) {
    this.ciutadanif = ciutadanif;
  }


  private java.lang.String ciutadanom;

  public java.lang.String getCiutadanom() {
    return this.ciutadanom;
  }

  public void setCiutadanom(java.lang.String ciutadanom) {
    this.ciutadanom = ciutadanom;
  }


  private java.lang.String funcionariusername;

  public java.lang.String getFuncionariusername() {
    return this.funcionariusername;
  }

  public void setFuncionariusername(java.lang.String funcionariusername) {
    this.funcionariusername = funcionariusername;
  }


  private java.lang.String funcionarinom;

  public java.lang.String getFuncionarinom() {
    return this.funcionarinom;
  }

  public void setFuncionarinom(java.lang.String funcionarinom) {
    this.funcionarinom = funcionarinom;
  }


  private java.lang.String expedient;

  public java.lang.String getExpedient() {
    return this.expedient;
  }

  public void setExpedient(java.lang.String expedient) {
    this.expedient = expedient;
  }


  private java.lang.Long perfilidDesde;

  public java.lang.Long getPerfilidDesde() {
    return this.perfilidDesde;
  }

  public void setPerfilidDesde(java.lang.Long perfilidDesde) {
    this.perfilidDesde = perfilidDesde;
  }


  private java.lang.Long perfilidFins;

  public java.lang.Long getPerfilidFins() {
    return this.perfilidFins;
  }

  public void setPerfilidFins(java.lang.Long perfilidFins) {
    this.perfilidFins = perfilidFins;
  }


  private java.lang.String usernameRequest;

  public java.lang.String getUsernameRequest() {
    return this.usernameRequest;
  }

  public void setUsernameRequest(java.lang.String usernameRequest) {
    this.usernameRequest = usernameRequest;
  }


  public TransaccioFilterForm() {
  }
  
  public TransaccioFilterForm(TransaccioFilterForm __toClone) {
    super(__toClone);
    this.transaccioIDDesde = __toClone.transaccioIDDesde;
    this.transaccioIDFins = __toClone.transaccioIDFins;
    this.transactionWebId = __toClone.transactionWebId;
    this.datainiciDesde = __toClone.datainiciDesde;
    this.datainiciFins = __toClone.datainiciFins;
    this.datafiDesde = __toClone.datafiDesde;
    this.datafiFins = __toClone.datafiFins;
    this.usuariaplicacioidDesde = __toClone.usuariaplicacioidDesde;
    this.usuariaplicacioidFins = __toClone.usuariaplicacioidFins;
    this.usuaripersonaidDesde = __toClone.usuaripersonaidDesde;
    this.usuaripersonaidFins = __toClone.usuaripersonaidFins;
    this.estatcodiDesde = __toClone.estatcodiDesde;
    this.estatcodiFins = __toClone.estatcodiFins;
    this.estatmissatge = __toClone.estatmissatge;
    this.estatexcepcio = __toClone.estatexcepcio;
    this.fitxerescanejatidDesde = __toClone.fitxerescanejatidDesde;
    this.fitxerescanejatidFins = __toClone.fitxerescanejatidFins;
    this.fitxersignaturaidDesde = __toClone.fitxersignaturaidDesde;
    this.fitxersignaturaidFins = __toClone.fitxersignaturaidFins;
    this.infoscanpixeltypeDesde = __toClone.infoscanpixeltypeDesde;
    this.infoscanpixeltypeFins = __toClone.infoscanpixeltypeFins;
    this.infoscanresoluciopppDesde = __toClone.infoscanresoluciopppDesde;
    this.infoscanresoluciopppFins = __toClone.infoscanresoluciopppFins;
    this.infoscanformatfitxer = __toClone.infoscanformatfitxer;
    this.infosignaturaidDesde = __toClone.infosignaturaidDesde;
    this.infosignaturaidFins = __toClone.infosignaturaidFins;
    this.infocustodyidDesde = __toClone.infocustodyidDesde;
    this.infocustodyidFins = __toClone.infocustodyidFins;
    this.languageui = __toClone.languageui;
    this.languagedoc = __toClone.languagedoc;
    this.ciutadanif = __toClone.ciutadanif;
    this.ciutadanom = __toClone.ciutadanom;
    this.funcionariusername = __toClone.funcionariusername;
    this.funcionarinom = __toClone.funcionarinom;
    this.expedient = __toClone.expedient;
    this.perfilidDesde = __toClone.perfilidDesde;
    this.perfilidFins = __toClone.perfilidFins;
    this.usernameRequest = __toClone.usernameRequest;
    this.mapOfInfoSignaturaForInfosignaturaid = __toClone.mapOfInfoSignaturaForInfosignaturaid;
    this.mapOfInfoCustodyForInfocustodyid = __toClone.mapOfInfoCustodyForInfocustodyid;
    this.mapOfPerfilForPerfilid = __toClone.mapOfPerfilForPerfilid;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { TRANSACTIONWEBID ,USERNAMEREQUEST }));
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
  private Map<String, String> mapOfInfoSignaturaForInfosignaturaid;

  public Map<String, String> getMapOfInfoSignaturaForInfosignaturaid() {
    return this.mapOfInfoSignaturaForInfosignaturaid;
  }

  public void setMapOfInfoSignaturaForInfosignaturaid(Map<String, String> mapOfInfoSignaturaForInfosignaturaid) {
    this.mapOfInfoSignaturaForInfosignaturaid = mapOfInfoSignaturaForInfosignaturaid;
  }



  private Map<String, String> mapOfInfoCustodyForInfocustodyid;

  public Map<String, String> getMapOfInfoCustodyForInfocustodyid() {
    return this.mapOfInfoCustodyForInfocustodyid;
  }

  public void setMapOfInfoCustodyForInfocustodyid(Map<String, String> mapOfInfoCustodyForInfocustodyid) {
    this.mapOfInfoCustodyForInfocustodyid = mapOfInfoCustodyForInfocustodyid;
  }



  private Map<String, String> mapOfPerfilForPerfilid;

  public Map<String, String> getMapOfPerfilForPerfilid() {
    return this.mapOfPerfilForPerfilid;
  }

  public void setMapOfPerfilForPerfilid(Map<String, String> mapOfPerfilForPerfilid) {
    this.mapOfPerfilForPerfilid = mapOfPerfilForPerfilid;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
