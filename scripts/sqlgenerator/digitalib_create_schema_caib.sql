
    create table dib_configuraciogrup (
        configuraciogrupid number(19,0) not null,
        logofooterid number(19,0) not null,
        logoheaderid number(19,0) not null,
        nom varchar2(100 char) not null,
        suportemail varchar2(255 char),
        suporttelefon varchar2(255 char),
        suportweb varchar2(255 char)
    );

    create table dib_fitxer (
        fitxerid number(19,0) not null,
        descripcio varchar2(1000 char),
        mime varchar2(255 char) not null,
        nom varchar2(255 char) not null,
        tamany number(19,0) not null
    );

    create table dib_idioma (
        idiomaid varchar2(5 char) not null,
        nom varchar2(50 char) not null,
        ordre number(10,0) not null,
        suportat number(1,0) not null
    );

    create table dib_perfil (
        perfilid number(19,0) not null,
        codi varchar2(25 char) not null,
        descripcio varchar2(255 char),
        nom varchar2(100 char) not null,
        pluginarxiuid number(19,0),
        plugindoccustodyid number(19,0),
        pluginfirmaservidorid number(19,0),
        pluginscanwebid number(19,0) not null
    );

    create table dib_perfilusrapp (
        perfilusrappid number(19,0) not null,
        perfilid number(19,0) not null,
        usuariaplicacioid number(19,0) not null
    );

    create table dib_plugin (
        pluginid number(19,0) not null,
        actiu number(1,0) not null,
        classe varchar2(255 char) not null,
        codi varchar2(255 char) not null,
        descripcio varchar2(255 char),
        nom varchar2(255 char) not null,
        ordre number(10,0),
        properties clob,
        tipus number(10,0) not null
    );

    create table dib_traduccio (
        traduccioid number(19,0) not null
    );

    create table dib_traducciomap (
        traducciomapid number(19,0) not null,
        idiomaid varchar2(10 char) not null,
        valor varchar2(4000 char)
    );

    create table dib_usuariaplicacio (
        usuariaplicacioid number(19,0) not null,
        actiu number(1,0) not null,
        contrasenya varchar2(50 char),
        descripcio varchar2(255 char),
        emailadmin varchar2(100 char) not null,
        username varchar2(101 char) not null
    );

    create table dib_usuaripersona (
        usuaripersonaid number(19,0) not null,
        configuraciogrupid number(19,0) not null,
        email varchar2(100 char) not null,
        idiomaid varchar2(5 char) not null,
        llinatges varchar2(100 char) not null,
        nif varchar2(9 char) not null,
        nom varchar2(50 char) not null,
        username varchar2(50 char) not null
    );

    create sequence dib_digitalib_seq;


 -- INICI Indexes
    create index dib_configuraciogrup_pk_i on dib_configuraciogrup (configuraciogrupid);
    create index dib_cfggrup_logoheaderid_fk_i on dib_configuraciogrup (logoheaderid);
    create index dib_cfggrup_logofooterid_fk_i on dib_configuraciogrup (logofooterid);
    create index dib_fitxer_pk_i on dib_fitxer (fitxerid);
    create index dib_idioma_pk_i on dib_idioma (idiomaid);
    create index dib_perfil_plugscanwebid_fk_i on dib_perfil (pluginscanwebid);
    create index dib_perfil_plugin_pdcid_fk_i on dib_perfil (plugindoccustodyid);
    create index dib_perfil_pluginarxiuid_fk_i on dib_perfil (pluginarxiuid);
    create index dib_perfil_plugin_psid_fk_i on dib_perfil (pluginfirmaservidorid);
    create index dib_perfil_pk_i on dib_perfil (perfilid);
    create index dib_perfusrapp_usrappid_fk_i on dib_perfilusrapp (usuariaplicacioid);
    create index dib_perfilusrapp_perfilid_fk_i on dib_perfilusrapp (perfilid);
    create index dib_perfilusrapp_pk_i on dib_perfilusrapp (perfilusrappid);
    create index dib_plugin_pk_i on dib_plugin (pluginid);
    create index dib_traduccio_pk_i on dib_traduccio (traduccioid);
    create index dib_traducciomap_idiomaid_fk_i on dib_traducciomap (idiomaid);
    create index dib_usuariaplicacio_pk_i on dib_usuariaplicacio (usuariaplicacioid);
    create index dib_usrperson_idiomaid_fk_i on dib_usuaripersona (idiomaid);
    create index dib_usuaripersona_pk_i on dib_usuaripersona (usuaripersonaid);
    create index dib_usrperson_confgrupid_fk_i on dib_usuaripersona (configuraciogrupid);
 -- FINAL Indexes

 -- INICI PK's
    alter table dib_configuraciogrup add constraint dib_configuraciogrup_pk primary key (configuraciogrupid);

    alter table dib_fitxer add constraint dib_fitxer_pk primary key (fitxerid);

    alter table dib_idioma add constraint dib_idioma_pk primary key (idiomaid);

    alter table dib_perfil add constraint dib_perfil_pk primary key (perfilid);

    alter table dib_perfilusrapp add constraint dib_perfilusrapp_pk primary key (perfilusrappid);

    alter table dib_plugin add constraint dib_plugin_pk primary key (pluginid);

    alter table dib_traduccio add constraint dib_traduccio_pk primary key (traduccioid);

    alter table dib_traducciomap add constraint dib_traducciomap_pk primary key (traducciomapid, idiomaid);

    alter table dib_usuariaplicacio add constraint dib_usuariaplicacio_pk primary key (usuariaplicacioid);

    alter table dib_usuaripersona add constraint dib_usuaripersona_pk primary key (usuaripersonaid);

 -- FINAL PK's

 -- INICI FK's

    alter table dib_configuraciogrup 
        add constraint dib_cfggrup_fitxer_cap_fk 
        foreign key (logoheaderid) 
        references dib_fitxer;

    alter table dib_configuraciogrup 
        add constraint dib_cfggrup_fitxer_peu_fk 
        foreign key (logofooterid) 
        references dib_fitxer;

    alter table dib_perfil 
        add constraint dib_perfil_plugin_scan_fk 
        foreign key (pluginscanwebid) 
        references dib_plugin;

    alter table dib_perfil 
        add constraint dib_perfil_plugin_firma_fk 
        foreign key (pluginfirmaservidorid) 
        references dib_plugin;

    alter table dib_perfil 
        add constraint dib_perfil_plugin_arxiu_fk 
        foreign key (pluginarxiuid) 
        references dib_plugin;

    alter table dib_perfil 
        add constraint dib_perfil_plugin_cust_fk 
        foreign key (plugindoccustodyid) 
        references dib_plugin;

    alter table dib_perfilusrapp 
        add constraint dib_perfusrapp_perfil_fk 
        foreign key (perfilid) 
        references dib_perfil;

    alter table dib_perfilusrapp 
        add constraint dib_perfusrapp_usrapp_usrap_fk 
        foreign key (usuariaplicacioid) 
        references dib_usuariaplicacio;

    alter table dib_traducciomap 
        add constraint dib_traducmap_traduccio_fk 
        foreign key (traducciomapid) 
        references dib_traduccio;

    alter table dib_usuaripersona 
        add constraint dib_usrperson_cfggrup_conf_fk 
        foreign key (configuraciogrupid) 
        references dib_configuraciogrup;

    alter table dib_usuaripersona 
        add constraint dib_usrperson_idioma_idioma_fk 
        foreign key (idiomaid) 
        references dib_idioma;
 -- FINAL FK's

 -- INICI UNIQUES
    alter table dib_configuraciogrup add constraint dib_cfggrup_uk unique (nom);
    alter table dib_perfil add constraint dib_perfil_uk unique (codi);
    alter table dib_perfilusrapp add constraint dib_perfusrapp_per_usrapp_uk unique (perfilid, usuariaplicacioid);
    alter table dib_usuariaplicacio add constraint dib_usrapp_username_uk unique (username);
    alter table dib_usuaripersona add constraint dib_usrperson_nif_uk unique (nif);
    alter table dib_usuaripersona add constraint dib_usrperson_username_uk unique (username);
 -- FINAL UNIQUES

 -- INICI GRANTS
    grant select,insert,delete,update on dib_configuraciogrup to www_digitalib;
    grant select,insert,delete,update on dib_fitxer to www_digitalib;
    grant select,insert,delete,update on dib_idioma to www_digitalib;
    grant select,insert,delete,update on dib_perfil to www_digitalib;
    grant select,insert,delete,update on dib_perfilusrapp to www_digitalib;
    grant select,insert,delete,update on dib_plugin to www_digitalib;
    grant select,insert,delete,update on dib_traduccio to www_digitalib;
    grant select,insert,delete,update on dib_traducciomap to www_digitalib;
    grant select,insert,delete,update on dib_usuariaplicacio to www_digitalib;
    grant select,insert,delete,update on dib_usuaripersona to www_digitalib;
    grant select on dib_digitalib_seq to www_digitalib;
 -- FINAL GRANTS

 -- INICI LOBS
    alter table dib_plugin move lob (properties) store as dib_plugin_properties_lob (tablespace digitalib_lob index dib_plugin_properties_lob_i);
 -- FINAL LOBS

