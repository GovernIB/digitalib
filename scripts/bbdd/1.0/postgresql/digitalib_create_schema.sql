--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.25
-- Dumped by pg_dump version 9.3.25
-- Started on 2021-09-09 08:41:49

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: digitalib; Type: SCHEMA; Schema: -; Owner: digitalib
--

CREATE SCHEMA digitalib;


ALTER SCHEMA digitalib OWNER TO digitalib;

--
-- Name: dib_digitalib_seq; Type: SEQUENCE; Schema: digitalib; Owner: digitalib
--

CREATE SEQUENCE dib_digitalib_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dib_digitalib_seq OWNER TO digitalib;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: dib_apisimple; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_apisimple (
    apisimpleid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    nom character varying(255) NOT NULL,
    url character varying(255) NOT NULL,
    username character varying(255) NOT NULL,
    contrasenya character varying(255) NOT NULL,
    perfil character varying(255) DEFAULT ' '::character varying NOT NULL,
    configdefirma character varying(100)
);


ALTER TABLE dib_apisimple OWNER TO digitalib;

--
-- Name: dib_auditoria; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_auditoria (
    auditoriaid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    data timestamp without time zone NOT NULL,
    transaccioid bigint NOT NULL,
    tipus integer NOT NULL,
    missatge character varying(255) NOT NULL,
    additionalinfo character varying(3000),
    isapp boolean NOT NULL,
    usernameaplicacio character varying(255),
    usernamepersona character varying(255)
);


ALTER TABLE dib_auditoria OWNER TO digitalib;

--
-- Name: COLUMN dib_auditoria.usernameaplicacio; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_auditoria.usernameaplicacio IS 'Username d''Aplicacio que realitza aquella acció reportada per l''auditoria.';


--
-- Name: COLUMN dib_auditoria.usernamepersona; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_auditoria.usernamepersona IS 'Username de Persona que realitza aquella acció reportada per l''auditoria.';


--
-- Name: dib_avis; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_avis (
    avisid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    descripcioid bigint NOT NULL,
    datainici timestamp without time zone,
    datafi timestamp with time zone,
    configgrupid bigint,
    bloquejar boolean NOT NULL,
    tipus integer DEFAULT 0 NOT NULL
);


ALTER TABLE dib_avis OWNER TO digitalib;

--
-- Name: dib_configuraciofirma; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_configuraciofirma (
    configuraciofirmaid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    uspoliticadefirma integer DEFAULT 0 NOT NULL,
    policyidentifier character varying(100),
    policyidentifierhash character varying(256),
    policyidentifierhashalgorithm character varying(50),
    policyurldocument character varying(255),
    tipusoperaciofirma integer DEFAULT 0 NOT NULL,
    tipusfirmaid integer NOT NULL,
    algorismedefirmaid integer NOT NULL,
    modedefirma boolean NOT NULL,
    motiudelegacioid bigint,
    firmatperformatid bigint,
    posiciotaulafirmesid integer DEFAULT 0 NOT NULL,
    pluginsegellatid bigint,
    propietatstaulafirmes text,
    inclouresegelldetemps boolean DEFAULT false,
    pluginfirmaservidorid bigint NOT NULL,
    nom character varying(255) NOT NULL
);


ALTER TABLE dib_configuraciofirma OWNER TO digitalib;

--
-- Name: COLUMN dib_configuraciofirma.uspoliticadefirma; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_configuraciofirma.uspoliticadefirma IS '0 => no usar politica de firma,  1=> usar politica d''aquesta configuracio';


--
-- Name: COLUMN dib_configuraciofirma.tipusoperaciofirma; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_configuraciofirma.tipusoperaciofirma IS '0 firma, 1 contrafirma 2, cofirma';


--
-- Name: dib_configuraciogrup; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_configuraciogrup (
    configuraciogrupid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    nom character varying(100) NOT NULL,
    suportweb character varying(255),
    suportemail character varying(255),
    suporttelefon character varying(255),
    logoheaderid bigint NOT NULL,
    logofooterid bigint NOT NULL,
    perfilnomesescaneigid bigint,
    perfilcopiaautenticaid bigint,
    perfilcustodiaid bigint,
    adreza text DEFAULT '  '::text NOT NULL,
    perfilnomesescaneig2id bigint,
    perfilcopiaautentica2id bigint,
    perfilcustodia2id bigint,
    codidir3perdefecte character varying(50) DEFAULT 'A04003003'::character varying NOT NULL
);


ALTER TABLE dib_configuraciogrup OWNER TO digitalib;

--
-- Name: dib_estadistica; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_estadistica (
    estadisticaid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    tipus integer NOT NULL,
    data timestamp without time zone NOT NULL,
    valor double precision DEFAULT 1 NOT NULL,
    parametres character varying(3000),
    usuariaplicacioid bigint,
    usuaripersonaid bigint
);


ALTER TABLE dib_estadistica OWNER TO digitalib;

--
-- Name: dib_fitxer; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_fitxer (
    fitxerid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    descripcio character varying(1000) DEFAULT NULL::character varying,
    mime character varying(255) NOT NULL,
    nom character varying(255) NOT NULL,
    tamany bigint NOT NULL
);


ALTER TABLE dib_fitxer OWNER TO digitalib;

--
-- Name: dib_idioma; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_idioma (
    idiomaid character varying(5) NOT NULL,
    nom character varying(50) NOT NULL,
    suportat boolean DEFAULT true NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);


ALTER TABLE dib_idioma OWNER TO digitalib;

--
-- Name: dib_infocustody; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_infocustody (
    infocustodyid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    custodyid character varying(255),
    originalfileurl character varying(255),
    csv character varying(255),
    csvgenerationdefinition character varying(255),
    csvvalidationweb character varying(255),
    arxiuexpedientid character varying(255),
    arxiudocumentid character varying(255),
    printablefileurl character varying(255),
    enifileurl character varying(255),
    validationfileurl character varying(255)
);


ALTER TABLE dib_infocustody OWNER TO digitalib;

--
-- Name: dib_infosignatura; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_infosignatura (
    infosignaturaid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    signoperation integer NOT NULL,
    signtype character varying(255) NOT NULL,
    signalgorithm character varying(255),
    signmode integer,
    signaturestablelocation integer,
    timestampincluded boolean,
    policyincluded boolean,
    enitipofirma character varying(255),
    eniperfilfirma character varying(255),
    enirolfirma character varying(255),
    enisignername character varying(255),
    enisigneradministrationid character varying(255),
    enisignlevel character varying(255),
    checkadministrationidofsigner boolean,
    checkdocumentmodifications boolean,
    checkvalidationsignature boolean
);


ALTER TABLE dib_infosignatura OWNER TO digitalib;

--
-- Name: dib_metadada; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_metadada (
    metadadaid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    transaccioid bigint NOT NULL,
    nom character varying(255) NOT NULL,
    valor character varying(3000) NOT NULL
);


ALTER TABLE dib_metadada OWNER TO digitalib;

--
-- Name: dib_perfil; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_perfil (
    perfilid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    pluginscanwebid bigint NOT NULL,
    configuraciofirmaid bigint,
    pluginarxiuid bigint,
    plugindoccustodyid bigint,
    codi character varying(255) NOT NULL,
    tipusfirma integer DEFAULT 0 NOT NULL,
    tipuscustodia integer DEFAULT 0 NOT NULL,
    apisimpleid bigint,
    usperfil integer DEFAULT 0 NOT NULL,
    scanformatfitxer integer DEFAULT 0 NOT NULL,
    scanminimaresolucio integer,
    scanpixeltype integer,
    urlbase character varying(255),
    pluginscanweb2id bigint,
    utilitzatperaplicacio boolean,
    nomid bigint,
    descripcioid bigint
);


ALTER TABLE dib_perfil OWNER TO digitalib;

--
-- Name: COLUMN dib_perfil.usperfil; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_perfil.usperfil IS 'Quin us es farà del perfil: plantilla o informacio perfil en transaccio';


--
-- Name: COLUMN dib_perfil.urlbase; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_perfil.urlbase IS 'Opcional. Serveix per indicar la url que utilitzaran els client per connectar-se a DigitalIB. Si val null s''obtindrà de la propietat dels properties-service.xml';


--
-- Name: dib_perfilusrapp; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_perfilusrapp (
    perfilusrappid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    perfilid bigint NOT NULL,
    usuariaplicacioid bigint NOT NULL
);


ALTER TABLE dib_perfilusrapp OWNER TO digitalib;

--
-- Name: dib_plugin; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_plugin (
    pluginid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    classe character varying(255) NOT NULL,
    properties text,
    actiu boolean NOT NULL,
    tipus integer NOT NULL,
    codi character varying(255) NOT NULL,
    ordre integer,
    nom character varying(255) NOT NULL,
    descripcio character varying(255)
);


ALTER TABLE dib_plugin OWNER TO digitalib;

--
-- Name: dib_plugincridada; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_plugincridada (
    plugincridadaid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    data timestamp with time zone NOT NULL,
    metodeplugin character varying(100) NOT NULL,
    tipusresultat integer NOT NULL,
    tempsexecucio bigint,
    pluginid bigint NOT NULL,
    usuaripersonaid bigint,
    usuariaplicacioid bigint,
    parametrestext text,
    parametresfitxerid bigint,
    retorntext text,
    retornfitxerid bigint
);


ALTER TABLE dib_plugincridada OWNER TO digitalib;

--
-- Name: dib_traduccio; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_traduccio (
    traduccioid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL
);


ALTER TABLE dib_traduccio OWNER TO digitalib;

--
-- Name: dib_traducciomap; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_traducciomap (
    traducciomapid bigint NOT NULL,
    idiomaid character varying(10) NOT NULL,
    valor character varying(4000)
);


ALTER TABLE dib_traducciomap OWNER TO digitalib;

--
-- Name: dib_transaccio; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_transaccio (
    transaccioid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    datainici timestamp without time zone NOT NULL,
    datafi timestamp without time zone,
    usuariaplicacioid bigint,
    usuaripersonaid bigint,
    estatcodi integer NOT NULL,
    estatmissatge character varying(3000),
    estatexcepcio text,
    fitxerescanejatid bigint,
    fitxersignaturaid bigint,
    infoscanpixeltype integer,
    infoscanresolucioppp integer,
    infoscanocr boolean,
    infosignaturaid bigint,
    infocustodyid bigint,
    webid character varying(100) NOT NULL,
    languageui character varying(10) NOT NULL,
    signparamlanguagedoc character varying(10),
    arxiureqparamciutadanif character varying(15),
    arxiureqparamciutadanom character varying(255),
    funcionariusername character varying(255) NOT NULL,
    signparamfuncionarinom character varying(255),
    perfilid bigint NOT NULL,
    returnurl character varying(255),
    vista integer NOT NULL,
    ip character varying(50) DEFAULT '10.215.216.175'::character varying NOT NULL,
    hashescaneig character varying(255),
    hashfirma character varying(255),
    signparamfuncionarinif character varying(255),
    arxiureqparamdocestatelabora character varying(4),
    arxiureqparamdocumenttipus character varying(4),
    arxiureqparaminteressats character varying(255),
    arxiureqparamorigen integer,
    arxiuoptparamprocedimentcodi character varying(255),
    arxiuoptparamprocedimentnom character varying(255),
    arxiureqparamorgans character varying(255),
    arxiuoptparamseriedocumental character varying(255),
    arxiuoptparamcustorexpid character varying(255),
    nom character varying(255),
    infoscanpapersize character varying(100),
    infoscandatacaptura timestamp without time zone,
    transmultipleid bigint,
    infoscanduplex boolean,
    signparamfuncionaridir3 character varying(100)
);


ALTER TABLE dib_transaccio OWNER TO digitalib;

--
-- Name: COLUMN dib_transaccio.arxiureqparamdocestatelabora; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.arxiureqparamdocestatelabora IS 'documentEstatElaboracio';


--
-- Name: COLUMN dib_transaccio.arxiureqparamdocumenttipus; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.arxiureqparamdocumenttipus IS 'TDxx';


--
-- Name: COLUMN dib_transaccio.arxiureqparaminteressats; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.arxiureqparaminteressats IS 'Llistat de Nifs dels interessats separats per comes';


--
-- Name: COLUMN dib_transaccio.arxiureqparamorigen; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.arxiureqparamorigen IS '0 Ciutada
1 Administracio';


--
-- Name: COLUMN dib_transaccio.arxiureqparamorgans; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.arxiureqparamorgans IS 'Codi DIR3 dels organs afectats separats per comes';


--
-- Name: COLUMN dib_transaccio.nom; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.nom IS 'Nom descriptiu de la transaccio';


--
-- Name: COLUMN dib_transaccio.signparamfuncionaridir3; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.signparamfuncionaridir3 IS 'Codi DIR3 de l''unitat de la qual depen l''oficina en la que es troba el funcionari.';


--
-- Name: dib_transmultiple; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_transmultiple (
    transmultipleid bigint NOT NULL,
    descripcio character varying(256) NOT NULL,
    fitxerescanejatid bigint
);


ALTER TABLE dib_transmultiple OWNER TO digitalib;

--
-- Name: dib_usuariaplicacio; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_usuariaplicacio (
    usuariaplicacioid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    username character varying(101) NOT NULL,
    contrasenya character varying(50),
    emailadmin character varying(100) NOT NULL,
    descripcio character varying(255) DEFAULT NULL::character varying,
    actiu boolean DEFAULT true NOT NULL,
    rolescan boolean DEFAULT false NOT NULL,
    rolecoau boolean DEFAULT false NOT NULL,
    rolecust boolean DEFAULT false NOT NULL
);


ALTER TABLE dib_usuariaplicacio OWNER TO digitalib;

--
-- Name: dib_usuaripersona; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_usuaripersona (
    usuaripersonaid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    username character varying(50) NOT NULL,
    nom character varying(50) NOT NULL,
    llinatges character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    nif character varying(9) NOT NULL,
    idiomaid character varying(5) NOT NULL,
    configuraciogrupid bigint,
    rolescan boolean DEFAULT false NOT NULL,
    rolecoau boolean DEFAULT false NOT NULL,
    rolecust boolean DEFAULT false NOT NULL,
    unitatdir3 character varying(100)
);


ALTER TABLE dib_usuaripersona OWNER TO digitalib;

--
-- Name: dib_apisimple_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_apisimple
    ADD CONSTRAINT dib_apisimple_pk PRIMARY KEY (apisimpleid);


--
-- Name: dib_auditoria_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_auditoria
    ADD CONSTRAINT dib_auditoria_pk PRIMARY KEY (auditoriaid);


--
-- Name: dib_avis_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_avis
    ADD CONSTRAINT dib_avis_pk PRIMARY KEY (avisid);


--
-- Name: dib_cfggrup_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_uk UNIQUE (nom);


--
-- Name: dib_conffirma_nom_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_conffirma_nom_uk UNIQUE (nom);


--
-- Name: dib_configuraciofirma_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_configuraciofirma_pk PRIMARY KEY (configuraciofirmaid);


--
-- Name: dib_configuraciogrup_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_configuraciogrup_pk PRIMARY KEY (configuraciogrupid);


--
-- Name: dib_estadistica_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_estadistica
    ADD CONSTRAINT dib_estadistica_pk PRIMARY KEY (estadisticaid);


--
-- Name: dib_fitxer_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_fitxer
    ADD CONSTRAINT dib_fitxer_pk PRIMARY KEY (fitxerid);


--
-- Name: dib_idioma_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_idioma
    ADD CONSTRAINT dib_idioma_pk PRIMARY KEY (idiomaid);


--
-- Name: dib_infocustody_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_infocustody
    ADD CONSTRAINT dib_infocustody_pk PRIMARY KEY (infocustodyid);


--
-- Name: dib_infosignatura_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_infosignatura
    ADD CONSTRAINT dib_infosignatura_pk PRIMARY KEY (infosignaturaid);


--
-- Name: dib_metadada_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_metadada
    ADD CONSTRAINT dib_metadada_pk PRIMARY KEY (metadadaid);


--
-- Name: dib_perfil_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_pk PRIMARY KEY (perfilid);


--
-- Name: dib_perfil_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_uk UNIQUE (codi);


--
-- Name: dib_perfilusrapp_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfilusrapp_pk PRIMARY KEY (perfilusrappid);


--
-- Name: dib_perfusrapp_per_usrapp_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfusrapp_per_usrapp_uk UNIQUE (perfilid, usuariaplicacioid);


--
-- Name: dib_plugin_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_plugin
    ADD CONSTRAINT dib_plugin_pk PRIMARY KEY (pluginid);


--
-- Name: dib_plugincridada_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugincridada_pk PRIMARY KEY (plugincridadaid);


--
-- Name: dib_traduccio_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_traduccio
    ADD CONSTRAINT dib_traduccio_pk PRIMARY KEY (traduccioid);


--
-- Name: dib_traducmap_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_traducciomap
    ADD CONSTRAINT dib_traducmap_pk PRIMARY KEY (traducciomapid, idiomaid);


--
-- Name: dib_transaccio_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_pk PRIMARY KEY (transaccioid);


--
-- Name: dib_transaccio_webid_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_webid_uk UNIQUE (webid);


--
-- Name: dib_transmultiple_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_transmultiple
    ADD CONSTRAINT dib_transmultiple_pk PRIMARY KEY (transmultipleid);


--
-- Name: dib_usrapp_username_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_usuariaplicacio
    ADD CONSTRAINT dib_usrapp_username_uk UNIQUE (username);


--
-- Name: dib_usrperson_nif_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_nif_uk UNIQUE (nif);


--
-- Name: dib_usrperson_username_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_username_uk UNIQUE (username);


--
-- Name: dib_usuariaplicacio_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_usuariaplicacio
    ADD CONSTRAINT dib_usuariaplicacio_pk PRIMARY KEY (usuariaplicacioid);


--
-- Name: dib_usuaripersona_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usuaripersona_pk PRIMARY KEY (usuaripersonaid);


--
-- Name: dib_apisimple_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_apisimple_pk_i ON dib_apisimple USING btree (apisimpleid);


--
-- Name: dib_auditoria_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_auditoria_pk_i ON dib_auditoria USING btree (auditoriaid);


--
-- Name: dib_avis_configgrupid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_avis_configgrupid_fk_i ON dib_avis USING btree (configgrupid);


--
-- Name: dib_avis_descripcioid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_avis_descripcioid_fk_i ON dib_avis USING btree (descripcioid);


--
-- Name: dib_avis_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_avis_pk_i ON dib_avis USING btree (avisid);


--
-- Name: dib_cfggrup_logofooterid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_logofooterid_fk_i ON dib_configuraciogrup USING btree (logofooterid);


--
-- Name: dib_cfggrup_logoheaderid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_logoheaderid_fk_i ON dib_configuraciogrup USING btree (logoheaderid);


--
-- Name: dib_cfggrup_perfilcoau2_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilcoau2_fk_i ON dib_configuraciogrup USING btree (perfilcopiaautentica2id);


--
-- Name: dib_cfggrup_perfilcoau_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilcoau_fk_i ON dib_configuraciogrup USING btree (perfilcopiaautenticaid);


--
-- Name: dib_cfggrup_perfilcust2_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilcust2_fk_i ON dib_configuraciogrup USING btree (perfilcustodia2id);


--
-- Name: dib_cfggrup_perfilcust_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilcust_fk_i ON dib_configuraciogrup USING btree (perfilcustodiaid);


--
-- Name: dib_cfggrup_perfilscan2_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilscan2_fk_i ON dib_configuraciogrup USING btree (perfilnomesescaneig2id);


--
-- Name: dib_cfggrup_perfilscan_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilscan_fk_i ON dib_configuraciogrup USING btree (perfilnomesescaneigid);


--
-- Name: dib_conffirma_algofirma_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_conffirma_algofirma_fk_i ON dib_configuraciofirma USING btree (algorismedefirmaid);


--
-- Name: dib_conffirma_firmatper_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_conffirma_firmatper_fk_i ON dib_configuraciofirma USING btree (firmatperformatid);


--
-- Name: dib_conffirma_motiudele_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_conffirma_motiudele_fk_i ON dib_configuraciofirma USING btree (motiudelegacioid);


--
-- Name: dib_conffirma_plugfirma_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_conffirma_plugfirma_fk_i ON dib_configuraciofirma USING btree (pluginfirmaservidorid);


--
-- Name: dib_conffirma_plugsegell_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_conffirma_plugsegell_fk_i ON dib_configuraciofirma USING btree (pluginsegellatid);


--
-- Name: dib_configuraciofirma_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_configuraciofirma_pk_i ON dib_configuraciofirma USING btree (configuraciofirmaid);


--
-- Name: dib_configuraciogrup_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_configuraciogrup_pk_i ON dib_configuraciogrup USING btree (configuraciogrupid);


--
-- Name: dib_estadistica_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_estadistica_pk_i ON dib_estadistica USING btree (estadisticaid);


--
-- Name: dib_fitxer_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_fitxer_pk_i ON dib_fitxer USING btree (fitxerid);


--
-- Name: dib_idioma_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_idioma_pk_i ON dib_idioma USING btree (idiomaid);


--
-- Name: dib_infocustody_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_infocustody_pk_i ON dib_infocustody USING btree (infocustodyid);


--
-- Name: dib_infosignatura_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_infosignatura_pk_i ON dib_infosignatura USING btree (infosignaturaid);


--
-- Name: dib_metadada_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_metadada_pk_i ON dib_metadada USING btree (metadadaid);


--
-- Name: dib_metadada_transaccioid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_metadada_transaccioid_fk_i ON dib_metadada USING btree (transaccioid);


--
-- Name: dib_perfil_apisimpleid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_apisimpleid_fk_i ON dib_perfil USING btree (apisimpleid);


--
-- Name: dib_perfil_descripcioid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_descripcioid_fk_i ON dib_perfil USING btree (descripcioid);


--
-- Name: dib_perfil_nomid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_nomid_fk_i ON dib_perfil USING btree (nomid);


--
-- Name: dib_perfil_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_pk_i ON dib_perfil USING btree (perfilid);


--
-- Name: dib_perfil_plugin_pdcid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_plugin_pdcid_fk_i ON dib_perfil USING btree (plugindoccustodyid);


--
-- Name: dib_perfil_plugin_psid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_plugin_psid_fk_i ON dib_perfil USING btree (configuraciofirmaid);


--
-- Name: dib_perfil_pluginarxiuid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_pluginarxiuid_fk_i ON dib_perfil USING btree (pluginarxiuid);


--
-- Name: dib_perfil_plugscanweb2_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_plugscanweb2_fk_i ON dib_perfil USING btree (pluginscanweb2id);


--
-- Name: dib_perfil_plugscanwebid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_plugscanwebid_fk_i ON dib_perfil USING btree (pluginscanwebid);


--
-- Name: dib_perfilusrapp_perfilid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfilusrapp_perfilid_fk_i ON dib_perfilusrapp USING btree (perfilid);


--
-- Name: dib_perfilusrapp_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfilusrapp_pk_i ON dib_perfilusrapp USING btree (perfilusrappid);


--
-- Name: dib_perfusrapp_usrappid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfusrapp_usrappid_fk_i ON dib_perfilusrapp USING btree (usuariaplicacioid);


--
-- Name: dib_plugcrid_paramfitxer_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_plugcrid_paramfitxer_fk_i ON dib_plugincridada USING btree (parametresfitxerid);


--
-- Name: dib_plugcrid_pluginid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_plugcrid_pluginid_fk_i ON dib_plugincridada USING btree (pluginid);


--
-- Name: dib_plugcrid_retofitxerid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_plugcrid_retofitxerid_fk_i ON dib_plugincridada USING btree (retornfitxerid);


--
-- Name: dib_plugin_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_plugin_pk_i ON dib_plugin USING btree (pluginid);


--
-- Name: dib_plugincridada_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_plugincridada_pk_i ON dib_plugincridada USING btree (plugincridadaid);


--
-- Name: dib_traduccio_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_traduccio_pk_i ON dib_traduccio USING btree (traduccioid);


--
-- Name: dib_traducciomap_idiomaid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_traducciomap_idiomaid_fk_i ON dib_traducciomap USING btree (idiomaid);


--
-- Name: dib_traducciomap_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_traducciomap_pk_i ON dib_traducciomap USING btree (traducciomapid);


--
-- Name: dib_transaccio_fileplain_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_fileplain_fk_i ON dib_transaccio USING btree (fitxerescanejatid);


--
-- Name: dib_transaccio_filesign_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_filesign_fk_i ON dib_transaccio USING btree (fitxersignaturaid);


--
-- Name: dib_transaccio_infocustid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_infocustid_fk_i ON dib_transaccio USING btree (infocustodyid);


--
-- Name: dib_transaccio_infosignid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_infosignid_fk_i ON dib_transaccio USING btree (infosignaturaid);


--
-- Name: dib_transaccio_perfilid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_perfilid_fk_i ON dib_transaccio USING btree (perfilid);


--
-- Name: dib_transaccio_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_pk_i ON dib_transaccio USING btree (transaccioid);


--
-- Name: dib_transaccio_transmulid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_transmulid_fk_i ON dib_transaccio USING btree (transmultipleid);


--
-- Name: dib_transmul_fscaned_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transmul_fscaned_fk_i ON dib_transmultiple USING btree (fitxerescanejatid);


--
-- Name: dib_transmultiple_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transmultiple_pk_i ON dib_transmultiple USING btree (transmultipleid);


--
-- Name: dib_usrperson_confgrupid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_usrperson_confgrupid_fk_i ON dib_usuaripersona USING btree (configuraciogrupid);


--
-- Name: dib_usrperson_idiomaid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_usrperson_idiomaid_fk_i ON dib_usuaripersona USING btree (idiomaid);


--
-- Name: dib_usuariaplicacio_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_usuariaplicacio_pk_i ON dib_usuariaplicacio USING btree (usuariaplicacioid);


--
-- Name: dib_usuaripersona_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_usuaripersona_pk_i ON dib_usuaripersona USING btree (usuaripersonaid);


--
-- Name: dib_avis_cfggrup_configgrup_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_avis
    ADD CONSTRAINT dib_avis_cfggrup_configgrup_fk FOREIGN KEY (configgrupid) REFERENCES dib_configuraciogrup(configuraciogrupid);


--
-- Name: dib_avis_traduccio_desc_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_avis
    ADD CONSTRAINT dib_avis_traduccio_desc_fk FOREIGN KEY (descripcioid) REFERENCES dib_traduccio(traduccioid);


--
-- Name: dib_cfggrup_fitxer_cap_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_fitxer_cap_fk FOREIGN KEY (logoheaderid) REFERENCES dib_fitxer(fitxerid);


--
-- Name: dib_cfggrup_fitxer_peu_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_fitxer_peu_fk FOREIGN KEY (logofooterid) REFERENCES dib_fitxer(fitxerid);


--
-- Name: dib_cfggrup_perfil_coau2_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_coau2_fk FOREIGN KEY (perfilcopiaautentica2id) REFERENCES dib_perfil(perfilid);


--
-- Name: dib_cfggrup_perfil_coau_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_coau_fk FOREIGN KEY (perfilcopiaautenticaid) REFERENCES dib_perfil(perfilid);


--
-- Name: dib_cfggrup_perfil_cust2_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_cust2_fk FOREIGN KEY (perfilcustodia2id) REFERENCES dib_perfil(perfilid);


--
-- Name: dib_cfggrup_perfil_cust_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_cust_fk FOREIGN KEY (perfilcustodiaid) REFERENCES dib_perfil(perfilid);


--
-- Name: dib_cfggrup_perfil_scan2_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_scan2_fk FOREIGN KEY (perfilnomesescaneig2id) REFERENCES dib_perfil(perfilid);


--
-- Name: dib_cfggrup_perfil_scan_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_scan_fk FOREIGN KEY (perfilnomesescaneigid) REFERENCES dib_perfil(perfilid);


--
-- Name: dib_conffirma_plugin_fir_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_conffirma_plugin_fir_fk FOREIGN KEY (pluginfirmaservidorid) REFERENCES dib_plugin(pluginid);


--
-- Name: dib_conffirma_plugin_seg_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_conffirma_plugin_seg_fk FOREIGN KEY (pluginsegellatid) REFERENCES dib_plugin(pluginid);


--
-- Name: dib_conffirma_traduccio_ff_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_conffirma_traduccio_ff_fk FOREIGN KEY (firmatperformatid) REFERENCES dib_traduccio(traduccioid);


--
-- Name: dib_conffirma_traduccio_md_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_conffirma_traduccio_md_fk FOREIGN KEY (motiudelegacioid) REFERENCES dib_traduccio(traduccioid);


--
-- Name: dib_meta_transaccio_trans_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_metadada
    ADD CONSTRAINT dib_meta_transaccio_trans_fk FOREIGN KEY (transaccioid) REFERENCES dib_transaccio(transaccioid);


--
-- Name: dib_perfil_apisimple_firma_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_apisimple_firma_fk FOREIGN KEY (apisimpleid) REFERENCES dib_apisimple(apisimpleid);


--
-- Name: dib_perfil_conffirma_cf_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_conffirma_cf_fk FOREIGN KEY (configuraciofirmaid) REFERENCES dib_configuraciofirma(configuraciofirmaid);


--
-- Name: dib_perfil_plugin_arxiu_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_arxiu_fk FOREIGN KEY (pluginarxiuid) REFERENCES dib_plugin(pluginid);


--
-- Name: dib_perfil_plugin_cust_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_cust_fk FOREIGN KEY (plugindoccustodyid) REFERENCES dib_plugin(pluginid);


--
-- Name: dib_perfil_plugin_scan2_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_scan2_fk FOREIGN KEY (pluginscanweb2id) REFERENCES dib_plugin(pluginid);


--
-- Name: dib_perfil_plugin_scan_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_scan_fk FOREIGN KEY (pluginscanwebid) REFERENCES dib_plugin(pluginid);


--
-- Name: dib_perfil_traduccio_descri_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_traduccio_descri_fk FOREIGN KEY (descripcioid) REFERENCES dib_traduccio(traduccioid);


--
-- Name: dib_perfil_traduccio_nomid_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_traduccio_nomid_fk FOREIGN KEY (nomid) REFERENCES dib_traduccio(traduccioid);


--
-- Name: dib_perfusrapp_perfil_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfusrapp_perfil_fk FOREIGN KEY (perfilid) REFERENCES dib_perfil(perfilid);


--
-- Name: dib_perfusrapp_usrapp_usrap_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfusrapp_usrapp_usrap_fk FOREIGN KEY (usuariaplicacioid) REFERENCES dib_usuariaplicacio(usuariaplicacioid);


--
-- Name: dib_plugcrid_fitxer_paramet_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugcrid_fitxer_paramet_fk FOREIGN KEY (parametresfitxerid) REFERENCES dib_fitxer(fitxerid);


--
-- Name: dib_plugcrid_fitxer_retornf_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugcrid_fitxer_retornf_fk FOREIGN KEY (retornfitxerid) REFERENCES dib_fitxer(fitxerid);


--
-- Name: dib_plugcrid_plugin_plugini_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugcrid_plugin_plugini_fk FOREIGN KEY (pluginid) REFERENCES dib_plugin(pluginid);


--
-- Name: dib_traducmap_traduccio_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_traducciomap
    ADD CONSTRAINT dib_traducmap_traduccio_fk FOREIGN KEY (traducciomapid) REFERENCES dib_traduccio(traduccioid);


--
-- Name: dib_transaccio_fitxer_pla_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_fitxer_pla_fk FOREIGN KEY (fitxerescanejatid) REFERENCES dib_fitxer(fitxerid);


--
-- Name: dib_transaccio_fitxer_sign_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_fitxer_sign_fk FOREIGN KEY (fitxersignaturaid) REFERENCES dib_fitxer(fitxerid);


--
-- Name: dib_transaccio_infocust_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_infocust_fk FOREIGN KEY (infocustodyid) REFERENCES dib_infocustody(infocustodyid);


--
-- Name: dib_transaccio_infosign_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_infosign_fk FOREIGN KEY (infosignaturaid) REFERENCES dib_infosignatura(infosignaturaid);


--
-- Name: dib_transaccio_perfil_perfi_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_perfil_perfi_fk FOREIGN KEY (perfilid) REFERENCES dib_perfil(perfilid);


--
-- Name: dib_transaccio_transmul_tm_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_transmul_tm_fk FOREIGN KEY (transmultipleid) REFERENCES dib_transmultiple(transmultipleid);


--
-- Name: dib_transmul_fitxer_fies_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transmultiple
    ADD CONSTRAINT dib_transmul_fitxer_fies_fk FOREIGN KEY (fitxerescanejatid) REFERENCES dib_fitxer(fitxerid);


--
-- Name: dib_usrperson_cfggrup_conf_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_cfggrup_conf_fk FOREIGN KEY (configuraciogrupid) REFERENCES dib_configuraciogrup(configuraciogrupid);


--
-- Name: dib_usrperson_idioma_idioma_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_idioma_idioma_fk FOREIGN KEY (idiomaid) REFERENCES dib_idioma(idiomaid);


-- Completed on 2021-09-09 08:41:49

--
-- PostgreSQL database dump complete
--

