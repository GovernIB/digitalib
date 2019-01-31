
    create table dib_apisimple (
        apisimpleid number(19,0) not null,
        contrasenya varchar2(255 char) not null,
        nom varchar2(255 char) not null,
        perfil varchar2(255 char) not null,
        url varchar2(255 char) not null,
        username varchar2(255 char) not null
    );

    create table dib_auditoria (
        auditoriaid number(19,0) not null,
        additionalinfo varchar2(3000 char),
        data timestamp not null,
        isapp number(1,0) not null,
        missatge varchar2(255 char) not null,
        tipus number(10,0) not null,
        transaccioid number(19,0) not null,
        usernameaplicacio varchar2(255 char),
        usernamepersona varchar2(255 char)
    );

    create table dib_configuraciofirma (
        configuraciofirmaid number(19,0) not null,
        algorismedefirmaid number(10,0) not null,
        firmatperformatid number(19,0),
        inclouresegelldetemps number(1,0) not null,
        modedefirma number(1,0) not null,
        motiudelegacioid number(19,0),
        nom varchar2(255 char) not null,
        pluginfirmaservidorid number(19,0) not null,
        pluginsegellatid number(19,0),
        policyidentifier varchar2(100 char),
        policyidentifierhash varchar2(256 char),
        policyidentifierhashalgorithm varchar2(50 char),
        policyurldocument varchar2(255 char),
        posiciotaulafirmesid number(10,0) not null,
        propietatstaulafirmes clob,
        tipusfirmaid number(10,0) not null,
        tipusoperaciofirma number(10,0) not null,
        uspoliticadefirma number(10,0) not null
    );

    create table dib_configuraciogrup (
        configuraciogrupid number(19,0) not null,
        adreza clob not null,
        logofooterid number(19,0) not null,
        logoheaderid number(19,0) not null,
        nom varchar2(100 char) not null,
        perfilcopiaautentica2id number(19,0),
        perfilcopiaautenticaid number(19,0),
        perfilcustodia2id number(19,0),
        perfilcustodiaid number(19,0),
        perfilnomesescaneig2id number(19,0),
        perfilnomesescaneigid number(19,0),
        suportemail varchar2(255 char),
        suporttelefon varchar2(255 char),
        suportweb varchar2(255 char)
    );

    create table dib_estadistica (
        estadisticaid number(19,0) not null,
        data timestamp not null,
        parametres varchar2(3000 char),
        tipus number(10,0) not null,
        usuariaplicacioid number(19,0),
        usuaripersonaid number(19,0),
        valor double precision not null
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

    create table dib_infocustody (
        infocustodyid number(19,0) not null,
        arxiudocumentid varchar2(255 char),
        arxiuexpedientid varchar2(255 char),
        csv varchar2(255 char),
        csvgenerationdefinition varchar2(255 char),
        csvvalidationweb varchar2(255 char),
        custodyid varchar2(255 char),
        enifileurl varchar2(255 char),
        originalfileurl varchar2(255 char),
        printablefileurl varchar2(255 char),
        validationfileurl varchar2(255 char)
    );

    create table dib_infosignatura (
        infosignaturaid number(19,0) not null,
        checkadministrationidofsigner number(1,0),
        checkdocumentmodifications number(1,0),
        checkvalidationsignature number(1,0),
        eniperfilfirma varchar2(255 char),
        enirolfirma varchar2(255 char),
        enisignlevel varchar2(255 char),
        enisigneradministrationid varchar2(255 char),
        enisignername varchar2(255 char),
        enitipofirma varchar2(255 char),
        policyincluded number(1,0),
        signalgorithm varchar2(255 char),
        signmode number(10,0),
        signoperation number(10,0) not null,
        signtype varchar2(255 char) not null,
        signaturestablelocation number(10,0),
        timestampincluded number(1,0)
    );

    create table dib_perfil (
        perfilid number(19,0) not null,
        apisimpleid number(19,0),
        codi varchar2(255 char) not null,
        configuraciofirmaid number(19,0),
        descripcioid number(19,0),
        nomid number(19,0),
        pluginarxiuid number(19,0),
        plugindoccustodyid number(19,0),
        pluginscanweb2id number(19,0),
        pluginscanwebid number(19,0) not null,
        scanformatfitxer number(10,0) not null,
        scanminimaresolucio number(10,0),
        scanpixeltype number(10,0),
        tipuscustodia number(10,0) not null,
        tipusfirma number(10,0) not null,
        urlbase varchar2(255 char),
        usperfil number(10,0) not null,
        utilitzatperaplicacio number(1,0)
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

    create table dib_plugincridada (
        plugincridadaid number(19,0) not null,
        data timestamp not null,
        metodeplugin varchar2(100 char) not null,
        parametresfitxerid number(19,0),
        parametrestext clob,
        pluginid number(19,0) not null,
        retornfitxerid number(19,0),
        retorntext clob,
        tempsexecucio number(19,0),
        tipusresultat number(10,0) not null,
        usuariaplicacioid number(19,0),
        usuaripersonaid number(19,0)
    );

    create table dib_traduccio (
        traduccioid number(19,0) not null
    );

    create table dib_traducciomap (
        traducciomapid number(19,0) not null,
        valor varchar2(4000 char),
        idiomaid varchar2(255 char)
    );

    create table dib_transaccio (
        transaccioid number(19,0) not null,
        arxiuoptparamcustorexpid varchar2(255 char),
        arxiuoptparamorgans varchar2(255 char),
        arxiuoptparamprocedimentcodi varchar2(255 char),
        arxiuoptparamprocedimentnom varchar2(255 char),
        arxiuoptparamseriedocumental varchar2(255 char),
        arxiureqparamciutadanif varchar2(15 char),
        arxiureqparamciutadanom varchar2(255 char),
        arxiureqparamdocestatelabora varchar2(4 char),
        arxiureqparamdocumenttipus varchar2(4 char),
        arxiureqparaminteressats varchar2(255 char),
        arxiureqparamorigen number(10,0),
        datafi timestamp,
        datainici timestamp not null,
        estatcodi number(10,0) not null,
        estatexcepcio clob,
        estatmissatge varchar2(3000 char),
        fitxerescanejatid number(19,0),
        fitxersignaturaid number(19,0),
        funcionariusername varchar2(255 char) not null,
        hashescaneig varchar2(255 char),
        hashfirma varchar2(255 char),
        infocustodyid number(19,0),
        infoscanocr number(1,0),
        infoscanpixeltype number(10,0),
        infoscanresolucioppp number(10,0),
        infosignaturaid number(19,0),
        ip varchar2(50 char) not null,
        languageui varchar2(10 char) not null,
        nom varchar2(255 char),
        perfilid number(19,0) not null,
        returnurl varchar2(255 char),
        signparamfuncionarinif varchar2(255 char),
        signparamfuncionarinom varchar2(255 char),
        signparamlanguagedoc varchar2(10 char),
        webid varchar2(100 char) not null,
        usuariaplicacioid number(19,0),
        usuaripersonaid number(19,0),
        vista number(10,0) not null
    );

    create table dib_usuariaplicacio (
        usuariaplicacioid number(19,0) not null,
        actiu number(1,0) not null,
        contrasenya varchar2(50 char),
        descripcio varchar2(255 char),
        emailadmin varchar2(100 char) not null,
        rolecoau number(1,0) not null,
        rolecust number(1,0) not null,
        rolescan number(1,0) not null,
        username varchar2(101 char) not null
    );

    create table dib_usuaripersona (
        usuaripersonaid number(19,0) not null,
        configuraciogrupid number(19,0),
        email varchar2(100 char) not null,
        idiomaid varchar2(5 char) not null,
        llinatges varchar2(100 char) not null,
        nif varchar2(9 char) not null,
        nom varchar2(50 char) not null,
        rolecoau number(1,0) not null,
        rolecust number(1,0) not null,
        rolescan number(1,0) not null,
        username varchar2(50 char) not null
    );

    create sequence dib_digitalib_seq START WITH 3000;


 -- INICI Indexes
    create index dib_apisimple_pk_i on dib_apisimple (apisimpleid);
    create index dib_auditoria_pk_i on dib_auditoria (auditoriaid);
    create index dib_conffirma_firmatper_fk_i on dib_configuraciofirma (firmatperformatid);
    create index dib_conffirma_algofirma_fk_i on dib_configuraciofirma (algorismedefirmaid);
    create index dib_configuraciofirma_pk_i on dib_configuraciofirma (configuraciofirmaid);
    create index dib_conffirma_plugfirma_fk_i on dib_configuraciofirma (pluginfirmaservidorid);
    create index dib_conffirma_motiudele_fk_i on dib_configuraciofirma (motiudelegacioid);
    create index dib_conffirma_plugsegell_fk_i on dib_configuraciofirma (pluginsegellatid);
    create index dib_configuraciogrup_pk_i on dib_configuraciogrup (configuraciogrupid);
    create index dib_cfggrup_perfilscan_fk_i on dib_configuraciogrup (perfilnomesescaneigid);
    create index dib_cfggrup_perfilcust2_fk_i on dib_configuraciogrup (perfilcustodia2id);
    create index dib_cfggrup_perfilscan2_fk_i on dib_configuraciogrup (perfilnomesescaneig2id);
    create index dib_cfggrup_logoheaderid_fk_i on dib_configuraciogrup (logoheaderid);
    create index dib_cfggrup_perfilcoau_fk_i on dib_configuraciogrup (perfilcopiaautenticaid);
    create index dib_cfggrup_perfilcoau2_fk_i on dib_configuraciogrup (perfilcopiaautentica2id);
    create index dib_cfggrup_perfilcust_fk_i on dib_configuraciogrup (perfilcustodiaid);
    create index dib_cfggrup_logofooterid_fk_i on dib_configuraciogrup (logofooterid);
    create index dib_estadistica_pk_i on dib_estadistica (estadisticaid);
    create index dib_fitxer_pk_i on dib_fitxer (fitxerid);
    create index dib_idioma_pk_i on dib_idioma (idiomaid);
    create index dib_infocustody_pk_i on dib_infocustody (infocustodyid);
    create index dib_infosignatura_pk_i on dib_infosignatura (infosignaturaid);
    create index dib_perfil_plugscanwebid_fk_i on dib_perfil (pluginscanwebid);
    create index dib_perfil_plugin_pdcid_fk_i on dib_perfil (plugindoccustodyid);
    create index dib_perfil_pluginarxiuid_fk_i on dib_perfil (pluginarxiuid);
    create index dib_perfil_plugscanweb2_fk_i on dib_perfil (pluginscanweb2id);
    create index dib_perfil_nomid_fk_i on dib_perfil (nomid);
    create index dib_perfil_descripcioid_fk_i on dib_perfil (descripcioid);
    create index dib_perfil_apisimpleid_fk_i on dib_perfil (apisimpleid);
    create index dib_perfil_plugin_psid_fk_i on dib_perfil (configuraciofirmaid);
    create index dib_perfil_pk_i on dib_perfil (perfilid);
    create index dib_perfusrapp_usrappid_fk_i on dib_perfilusrapp (usuariaplicacioid);
    create index dib_perfilusrapp_perfilid_fk_i on dib_perfilusrapp (perfilid);
    create index dib_perfilusrapp_pk_i on dib_perfilusrapp (perfilusrappid);
    create index dib_plugin_pk_i on dib_plugin (pluginid);
    create index dib_plugcrid_paramfitxer_fk_i on dib_plugincridada (parametresfitxerid);
    create index dib_plugcrid_pluginid_fk_i on dib_plugincridada (pluginid);
    create index dib_plugcrid_retofitxerid_fk_i on dib_plugincridada (retornfitxerid);
    create index dib_plugincridada_pk_i on dib_plugincridada (plugincridadaid);
    create index dib_traduccio_pk_i on dib_traduccio (traduccioid);
    create index dib_transaccio_infocustid_fk_i on dib_transaccio (infocustodyid);
    create index dib_transaccio_perfilid_fk_i on dib_transaccio (perfilid);
    create index dib_transaccio_infosignid_fk_i on dib_transaccio (infosignaturaid);
    create index dib_transaccio_filesign_fk_i on dib_transaccio (fitxersignaturaid);
    create index dib_transaccio_fileplain_fk_i on dib_transaccio (fitxerescanejatid);
    create index dib_transaccio_pk_i on dib_transaccio (transaccioid);
    create index dib_usuariaplicacio_pk_i on dib_usuariaplicacio (usuariaplicacioid);
    create index dib_usrperson_idiomaid_fk_i on dib_usuaripersona (idiomaid);
    create index dib_usuaripersona_pk_i on dib_usuaripersona (usuaripersonaid);
    create index dib_usrperson_confgrupid_fk_i on dib_usuaripersona (configuraciogrupid);
 -- FINAL Indexes

 -- INICI PK's
    alter table dib_apisimple add constraint dib_apisimple_pk primary key (apisimpleid);

    alter table dib_auditoria add constraint dib_auditoria_pk primary key (auditoriaid);

    alter table dib_configuraciofirma add constraint dib_configuraciofirma_pk primary key (configuraciofirmaid);

    alter table dib_configuraciogrup add constraint dib_configuraciogrup_pk primary key (configuraciogrupid);

    alter table dib_estadistica add constraint dib_estadistica_pk primary key (estadisticaid);

    alter table dib_fitxer add constraint dib_fitxer_pk primary key (fitxerid);

    alter table dib_idioma add constraint dib_idioma_pk primary key (idiomaid);

    alter table dib_infocustody add constraint dib_infocustody_pk primary key (infocustodyid);

    alter table dib_infosignatura add constraint dib_infosignatura_pk primary key (infosignaturaid);

    alter table dib_perfil add constraint dib_perfil_pk primary key (perfilid);

    alter table dib_perfilusrapp add constraint dib_perfilusrapp_pk primary key (perfilusrappid);

    alter table dib_plugin add constraint dib_plugin_pk primary key (pluginid);

    alter table dib_plugincridada add constraint dib_plugincridada_pk primary key (plugincridadaid);

    alter table dib_traduccio add constraint dib_traduccio_pk primary key (traduccioid);

    alter table dib_traducciomap add constraint dib_traducmap_pk primary key (traducciomapid, idiomaid);

    alter table dib_transaccio add constraint dib_transaccio_pk primary key (transaccioid);

    alter table dib_usuariaplicacio add constraint dib_usuariaplicacio_pk primary key (usuariaplicacioid);

    alter table dib_usuaripersona add constraint dib_usuaripersona_pk primary key (usuaripersonaid);

 -- FINAL PK's

 -- INICI FK's

    alter table dib_configuraciofirma 
        add constraint dib_conffirma_traduccio_md_fk 
        foreign key (motiudelegacioid) 
        references dib_traduccio;

    alter table dib_configuraciofirma 
        add constraint dib_conffirma_traduccio_ff_fk 
        foreign key (firmatperformatid) 
        references dib_traduccio;

    alter table dib_configuraciofirma 
        add constraint dib_conffirma_plugin_fir_fk 
        foreign key (pluginfirmaservidorid) 
        references dib_plugin;

    alter table dib_configuraciofirma 
        add constraint dib_conffirma_plugin_seg_fk 
        foreign key (pluginsegellatid) 
        references dib_plugin;

    alter table dib_configuraciogrup 
        add constraint dib_cfggrup_perfil_cust_fk 
        foreign key (perfilcustodiaid) 
        references dib_perfil;

    alter table dib_configuraciogrup 
        add constraint dib_cfggrup_fitxer_cap_fk 
        foreign key (logoheaderid) 
        references dib_fitxer;

    alter table dib_configuraciogrup 
        add constraint dib_cfggrup_perfil_cust2_fk 
        foreign key (perfilcustodia2id) 
        references dib_perfil;

    alter table dib_configuraciogrup 
        add constraint dib_cfggrup_perfil_coau_fk 
        foreign key (perfilcopiaautenticaid) 
        references dib_perfil;

    alter table dib_configuraciogrup 
        add constraint dib_cfggrup_perfil_coau2_fk 
        foreign key (perfilcopiaautentica2id) 
        references dib_perfil;

    alter table dib_configuraciogrup 
        add constraint dib_cfggrup_perfil_scan2_fk 
        foreign key (perfilnomesescaneig2id) 
        references dib_perfil;

    alter table dib_configuraciogrup 
        add constraint dib_cfggrup_fitxer_peu_fk 
        foreign key (logofooterid) 
        references dib_fitxer;

    alter table dib_configuraciogrup 
        add constraint dib_cfggrup_perfil_scan_fk 
        foreign key (perfilnomesescaneigid) 
        references dib_perfil;

    alter table dib_perfil 
        add constraint dib_perfil_conffirma_cf_fk 
        foreign key (configuraciofirmaid) 
        references dib_configuraciofirma;

    alter table dib_perfil 
        add constraint dib_perfil_traduccio_nomid_fk 
        foreign key (nomid) 
        references dib_traduccio;

    alter table dib_perfil 
        add constraint dib_perfil_apisimple_firma_fk 
        foreign key (apisimpleid) 
        references dib_apisimple;

    alter table dib_perfil 
        add constraint dib_perfil_plugin_scan_fk 
        foreign key (pluginscanwebid) 
        references dib_plugin;

    alter table dib_perfil 
        add constraint dib_perfil_plugin_scan2_fk 
        foreign key (pluginscanweb2id) 
        references dib_plugin;

    alter table dib_perfil 
        add constraint dib_perfil_plugin_arxiu_fk 
        foreign key (pluginarxiuid) 
        references dib_plugin;

    alter table dib_perfil 
        add constraint dib_perfil_plugin_cust_fk 
        foreign key (plugindoccustodyid) 
        references dib_plugin;

    alter table dib_perfil 
        add constraint dib_perfil_traduccio_descri_fk 
        foreign key (descripcioid) 
        references dib_traduccio;

    alter table dib_perfilusrapp 
        add constraint dib_perfusrapp_perfil_fk 
        foreign key (perfilid) 
        references dib_perfil;

    alter table dib_perfilusrapp 
        add constraint dib_perfusrapp_usrapp_usrap_fk 
        foreign key (usuariaplicacioid) 
        references dib_usuariaplicacio;

    alter table dib_plugincridada 
        add constraint dib_plugcrid_fitxer_retornf_fk 
        foreign key (retornfitxerid) 
        references dib_fitxer;

    alter table dib_plugincridada 
        add constraint dib_plugcrid_fitxer_paramet_fk 
        foreign key (parametresfitxerid) 
        references dib_fitxer;

    alter table dib_plugincridada 
        add constraint dib_plugcrid_plugin_plugini_fk 
        foreign key (pluginid) 
        references dib_plugin;

    alter table dib_traducciomap 
        add constraint dib_traducmap_traduccio_fk 
        foreign key (traducciomapid) 
        references dib_traduccio;

    alter table dib_transaccio 
        add constraint dib_transaccio_fitxer_pla_fk 
        foreign key (fitxerescanejatid) 
        references dib_fitxer;

    alter table dib_transaccio 
        add constraint dib_transaccio_infocust_fk 
        foreign key (infocustodyid) 
        references dib_infocustody;

    alter table dib_transaccio 
        add constraint dib_transaccio_infosign_fk 
        foreign key (infosignaturaid) 
        references dib_infosignatura;

    alter table dib_transaccio 
        add constraint dib_transaccio_fitxer_sign_fk 
        foreign key (fitxersignaturaid) 
        references dib_fitxer;

    alter table dib_transaccio 
        add constraint dib_transaccio_perfil_perfi_fk 
        foreign key (perfilid) 
        references dib_perfil;

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
    alter table dib_configuraciofirma add constraint dib_conffirma_nom_uk unique (nom);
    alter table dib_configuraciogrup add constraint dib_cfggrup_uk unique (nom);
    alter table dib_perfil add constraint dib_perfil_uk unique (codi);
    alter table dib_perfilusrapp add constraint dib_perfusrapp_per_usrapp_uk unique (perfilid, usuariaplicacioid);
    alter table dib_transaccio add constraint dib_transaccio_webid_uk unique (webid);
    alter table dib_usuariaplicacio add constraint dib_usrapp_username_uk unique (username);
    alter table dib_usuaripersona add constraint dib_usrperson_nif_uk unique (nif);
    alter table dib_usuaripersona add constraint dib_usrperson_username_uk unique (username);
 -- FINAL UNIQUES

