
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

  public LongField FITXERSIGNATURAID() {
    return new LongField(getQueryPath(), TransaccioFields.FITXERSIGNATURAID);
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

  public LongField INFOSIGNATURAID() {
    return new LongField(getQueryPath(), TransaccioFields.INFOSIGNATURAID);
  }

  public LongField INFOCUSTODYID() {
    return new LongField(getQueryPath(), TransaccioFields.INFOCUSTODYID);
  }

  public StringField LANGUAGEUI() {
    return new StringField(getQueryPath(), TransaccioFields.LANGUAGEUI);
  }

  public StringField LANGUAGEDOC() {
    return new StringField(getQueryPath(), TransaccioFields.LANGUAGEDOC);
  }

  public StringField CIUTADANIF() {
    return new StringField(getQueryPath(), TransaccioFields.CIUTADANIF);
  }

  public StringField CIUTADANOM() {
    return new StringField(getQueryPath(), TransaccioFields.CIUTADANOM);
  }

  public StringField FUNCIONARIUSERNAME() {
    return new StringField(getQueryPath(), TransaccioFields.FUNCIONARIUSERNAME);
  }

  public StringField FUNCIONARINOM() {
    return new StringField(getQueryPath(), TransaccioFields.FUNCIONARINOM);
  }

  public StringField EXPEDIENT() {
    return new StringField(getQueryPath(), TransaccioFields.EXPEDIENT);
  }

  public StringField USERNAMEREQUEST() {
    return new StringField(getQueryPath(), TransaccioFields.USERNAMEREQUEST);
  }

  public StringField RETURNURL() {
    return new StringField(getQueryPath(), TransaccioFields.RETURNURL);
  }

  public IntegerField VIEW() {
    return new IntegerField(getQueryPath(), TransaccioFields.VIEW);
  }

  public LongField PERFILID() {
    return new LongField(getQueryPath(), TransaccioFields.PERFILID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (TransaccioFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


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

  public PerfilQueryPath PERFIL() {
    return new PerfilQueryPath(new QueryPath() {
      public String getQueryPath() {
          return TransaccioQueryPath.this.getQueryPath() + "perfil" + ".";
      }
    });
  }

}
