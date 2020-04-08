
package es.caib.digitalib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class TransaccioQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public TransaccioQueryPath() {
  }

  protected TransaccioQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField TRANSACCIOID() {
    return new LongField(getQueryPath(), TransaccioFields.TRANSACCIOID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), TransaccioFields.NOM);
  }

  public StringField TRANSACTIONWEBID() {
    return new StringField(getQueryPath(), TransaccioFields.TRANSACTIONWEBID);
  }

  public TimestampField DATAINICI() {
    return new TimestampField(getQueryPath(), TransaccioFields.DATAINICI);
  }

  public TimestampField DATAFI() {
    return new TimestampField(getQueryPath(), TransaccioFields.DATAFI);
  }

  public LongField USUARIAPLICACIOID() {
    return new LongField(getQueryPath(), TransaccioFields.USUARIAPLICACIOID);
  }

  public LongField USUARIPERSONAID() {
    return new LongField(getQueryPath(), TransaccioFields.USUARIPERSONAID);
  }

  public StringField IP() {
    return new StringField(getQueryPath(), TransaccioFields.IP);
  }

  public StringField RETURNURL() {
    return new StringField(getQueryPath(), TransaccioFields.RETURNURL);
  }

  public IntegerField ESTATCODI() {
    return new IntegerField(getQueryPath(), TransaccioFields.ESTATCODI);
  }

  public StringField ESTATMISSATGE() {
    return new StringField(getQueryPath(), TransaccioFields.ESTATMISSATGE);
  }

  public StringField ESTATEXCEPCIO() {
    return new StringField(getQueryPath(), TransaccioFields.ESTATEXCEPCIO);
  }

  public LongField FITXERESCANEJATID() {
    return new LongField(getQueryPath(), TransaccioFields.FITXERESCANEJATID);
  }

  public StringField HASHESCANEIG() {
    return new StringField(getQueryPath(), TransaccioFields.HASHESCANEIG);
  }

  public LongField FITXERSIGNATURAID() {
    return new LongField(getQueryPath(), TransaccioFields.FITXERSIGNATURAID);
  }

  public StringField HASHFIRMA() {
    return new StringField(getQueryPath(), TransaccioFields.HASHFIRMA);
  }

  public StringField INFOSCANPAPERSIZE() {
    return new StringField(getQueryPath(), TransaccioFields.INFOSCANPAPERSIZE);
  }

  public IntegerField INFOSCANPIXELTYPE() {
    return new IntegerField(getQueryPath(), TransaccioFields.INFOSCANPIXELTYPE);
  }

  public IntegerField INFOSCANRESOLUCIOPPP() {
    return new IntegerField(getQueryPath(), TransaccioFields.INFOSCANRESOLUCIOPPP);
  }

  public BooleanField INFOSCANOCR() {
    return new BooleanField(getQueryPath(), TransaccioFields.INFOSCANOCR);
  }

  public TimestampField INFOSCANDATACAPTURA() {
    return new TimestampField(getQueryPath(), TransaccioFields.INFOSCANDATACAPTURA);
  }

  public IntegerField VIEW() {
    return new IntegerField(getQueryPath(), TransaccioFields.VIEW);
  }

  public StringField LANGUAGEUI() {
    return new StringField(getQueryPath(), TransaccioFields.LANGUAGEUI);
  }

  public StringField FUNCIONARIUSERNAME() {
    return new StringField(getQueryPath(), TransaccioFields.FUNCIONARIUSERNAME);
  }

  public StringField SIGNPARAMFUNCIONARINOM() {
    return new StringField(getQueryPath(), TransaccioFields.SIGNPARAMFUNCIONARINOM);
  }

  public StringField SIGNPARAMFUNCIONARINIF() {
    return new StringField(getQueryPath(), TransaccioFields.SIGNPARAMFUNCIONARINIF);
  }

  public StringField SIGNPARAMLANGUAGEDOC() {
    return new StringField(getQueryPath(), TransaccioFields.SIGNPARAMLANGUAGEDOC);
  }

  public StringField ARXIUREQPARAMDOCESTATELABORA() {
    return new StringField(getQueryPath(), TransaccioFields.ARXIUREQPARAMDOCESTATELABORA);
  }

  public StringField ARXIUREQPARAMDOCUMENTTIPUS() {
    return new StringField(getQueryPath(), TransaccioFields.ARXIUREQPARAMDOCUMENTTIPUS);
  }

  public IntegerField ARXIUREQPARAMORIGEN() {
    return new IntegerField(getQueryPath(), TransaccioFields.ARXIUREQPARAMORIGEN);
  }

  public StringField ARXIUREQPARAMINTERESSATS() {
    return new StringField(getQueryPath(), TransaccioFields.ARXIUREQPARAMINTERESSATS);
  }

  public StringField ARXIUREQPARAMCIUTADANIF() {
    return new StringField(getQueryPath(), TransaccioFields.ARXIUREQPARAMCIUTADANIF);
  }

  public StringField ARXIUREQPARAMCIUTADANOM() {
    return new StringField(getQueryPath(), TransaccioFields.ARXIUREQPARAMCIUTADANOM);
  }

  public StringField ARXIUREQPARAMORGANS() {
    return new StringField(getQueryPath(), TransaccioFields.ARXIUREQPARAMORGANS);
  }

  public StringField ARXIUOPTPARAMPROCEDIMENTCODI() {
    return new StringField(getQueryPath(), TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI);
  }

  public StringField ARXIUOPTPARAMPROCEDIMENTNOM() {
    return new StringField(getQueryPath(), TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM);
  }

  public StringField ARXIUOPTPARAMSERIEDOCUMENTAL() {
    return new StringField(getQueryPath(), TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL);
  }

  public StringField ARXIUOPTPARAMCUSTODYOREXPEDIENTID() {
    return new StringField(getQueryPath(), TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID);
  }

  public LongField PERFILID() {
    return new LongField(getQueryPath(), TransaccioFields.PERFILID);
  }

  public LongField INFOSIGNATURAID() {
    return new LongField(getQueryPath(), TransaccioFields.INFOSIGNATURAID);
  }

  public LongField INFOCUSTODYID() {
    return new LongField(getQueryPath(), TransaccioFields.INFOCUSTODYID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (TransaccioFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public MetadadaQueryPath METADADAS() {
    return new MetadadaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TransaccioQueryPath.this.getQueryPath() + "metadadas" + ".";
      }
    });
  }
*/

  public FitxerQueryPath FITXERESCANEJAT() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TransaccioQueryPath.this.getQueryPath() + "fitxerEscanejat" + ".";
      }
    });
  }

  public FitxerQueryPath FITXERSIGNATURA() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TransaccioQueryPath.this.getQueryPath() + "fitxerSignatura" + ".";
      }
    });
  }

  public PerfilQueryPath PERFIL() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TransaccioQueryPath.this.getQueryPath() + "perfil" + ".";
      }
    });
  }

  public InfoSignaturaQueryPath INFOSIGNATURA() {
    return new InfoSignaturaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TransaccioQueryPath.this.getQueryPath() + "infoSignatura" + ".";
      }
    });
  }

  public InfoCustodyQueryPath INFOCUSTODY() {
    return new InfoCustodyQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TransaccioQueryPath.this.getQueryPath() + "infoCustody" + ".";
      }
    });
  }

}
