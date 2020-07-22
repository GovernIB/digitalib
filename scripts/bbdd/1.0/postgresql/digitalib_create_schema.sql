--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2020-07-22 12:34:39

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 97827)
-- Name: digitalib; Type: SCHEMA; Schema: -; Owner: digitalib
--

CREATE SCHEMA digitalib;


ALTER SCHEMA digitalib OWNER TO digitalib;

SET search_path = digitalib, pg_catalog;

--
-- TOC entry 171 (class 1259 OID 97828)
-- Name: dib_digitalib_seq; Type: SEQUENCE; Schema: digitalib; Owner: digitalib
--

CREATE SEQUENCE dib_digitalib_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE digitalib.dib_digitalib_seq OWNER TO digitalib;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 98194)
-- Name: dib_apisimple; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_apisimple (
    apisimpleid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    nom character varying(255) NOT NULL,
    url character varying(255) NOT NULL,
    username character varying(255) NOT NULL,
    contrasenya character varying(255) NOT NULL,
    perfil character varying(255) DEFAULT ' '::character varying NOT NULL
);


ALTER TABLE digitalib.dib_apisimple OWNER TO digitalib;

--
-- TOC entry 189 (class 1259 OID 98720)
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


ALTER TABLE digitalib.dib_auditoria OWNER TO digitalib;

--
-- TOC entry 2218 (class 0 OID 0)
-- Dependencies: 189
-- Name: COLUMN dib_auditoria.usernameaplicacio; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_auditoria.usernameaplicacio IS 'Username d''Aplicacio que realitza aquella acció reportada per l''auditoria.';


--
-- TOC entry 2219 (class 0 OID 0)
-- Dependencies: 189
-- Name: COLUMN dib_auditoria.usernamepersona; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_auditoria.usernamepersona IS 'Username de Persona que realitza aquella acció reportada per l''auditoria.';


--
-- TOC entry 191 (class 1259 OID 114594)
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


ALTER TABLE digitalib.dib_avis OWNER TO digitalib;

--
-- TOC entry 188 (class 1259 OID 98510)
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


ALTER TABLE digitalib.dib_configuraciofirma OWNER TO digitalib;

--
-- TOC entry 2220 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN dib_configuraciofirma.uspoliticadefirma; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_configuraciofirma.uspoliticadefirma IS '0 => no usar politica de firma,  1=> usar politica d''aquesta configuracio';


--
-- TOC entry 2221 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN dib_configuraciofirma.tipusoperaciofirma; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_configuraciofirma.tipusoperaciofirma IS '0 firma, 1 contrafirma 2, cofirma';


--
-- TOC entry 179 (class 1259 OID 97984)
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


ALTER TABLE digitalib.dib_configuraciogrup OWNER TO digitalib;

--
-- TOC entry 182 (class 1259 OID 98069)
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


ALTER TABLE digitalib.dib_estadistica OWNER TO digitalib;

--
-- TOC entry 172 (class 1259 OID 97830)
-- Name: dib_fitxer; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_fitxer (
    fitxerid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    descripcio character varying(1000) DEFAULT NULL::character varying,
    mime character varying(255) NOT NULL,
    nom character varying(255) NOT NULL,
    tamany bigint NOT NULL
);


ALTER TABLE digitalib.dib_fitxer OWNER TO digitalib;

--
-- TOC entry 173 (class 1259 OID 97838)
-- Name: dib_idioma; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_idioma (
    idiomaid character varying(5) NOT NULL,
    nom character varying(50) NOT NULL,
    suportat boolean DEFAULT true NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);


ALTER TABLE digitalib.dib_idioma OWNER TO digitalib;

--
-- TOC entry 187 (class 1259 OID 98227)
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


ALTER TABLE digitalib.dib_infocustody OWNER TO digitalib;

--
-- TOC entry 186 (class 1259 OID 98213)
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


ALTER TABLE digitalib.dib_infosignatura OWNER TO digitalib;

--
-- TOC entry 190 (class 1259 OID 111896)
-- Name: dib_metadada; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_metadada (
    metadadaid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    transaccioid bigint NOT NULL,
    nom character varying(255) NOT NULL,
    valor character varying(3000) NOT NULL
);


ALTER TABLE digitalib.dib_metadada OWNER TO digitalib;

--
-- TOC entry 177 (class 1259 OID 97940)
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


ALTER TABLE digitalib.dib_perfil OWNER TO digitalib;

--
-- TOC entry 2222 (class 0 OID 0)
-- Dependencies: 177
-- Name: COLUMN dib_perfil.usperfil; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_perfil.usperfil IS 'Quin us es farà del perfil: plantilla o informacio perfil en transaccio';


--
-- TOC entry 2223 (class 0 OID 0)
-- Dependencies: 177
-- Name: COLUMN dib_perfil.urlbase; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_perfil.urlbase IS 'Opcional. Serveix per indicar la url que utilitzaran els client per connectar-se a DigitalIB. Si val null s''obtindrà de la propietat dels properties-service.xml';


--
-- TOC entry 178 (class 1259 OID 97968)
-- Name: dib_perfilusrapp; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_perfilusrapp (
    perfilusrappid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    perfilid bigint NOT NULL,
    usuariaplicacioid bigint NOT NULL
);


ALTER TABLE digitalib.dib_perfilusrapp OWNER TO digitalib;

--
-- TOC entry 176 (class 1259 OID 97921)
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


ALTER TABLE digitalib.dib_plugin OWNER TO digitalib;

--
-- TOC entry 183 (class 1259 OID 98091)
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


ALTER TABLE digitalib.dib_plugincridada OWNER TO digitalib;

--
-- TOC entry 180 (class 1259 OID 98044)
-- Name: dib_traduccio; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_traduccio (
    traduccioid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL
);


ALTER TABLE digitalib.dib_traduccio OWNER TO digitalib;

--
-- TOC entry 181 (class 1259 OID 98048)
-- Name: dib_traducciomap; Type: TABLE; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE TABLE dib_traducciomap (
    traducciomapid bigint NOT NULL,
    idiomaid character varying(10) NOT NULL,
    valor character varying(4000)
);


ALTER TABLE digitalib.dib_traducciomap OWNER TO digitalib;

--
-- TOC entry 184 (class 1259 OID 98115)
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
    infoscandatacaptura timestamp without time zone
);


ALTER TABLE digitalib.dib_transaccio OWNER TO digitalib;

--
-- TOC entry 2224 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN dib_transaccio.arxiureqparamdocestatelabora; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.arxiureqparamdocestatelabora IS 'documentEstatElaboracio';


--
-- TOC entry 2225 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN dib_transaccio.arxiureqparamdocumenttipus; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.arxiureqparamdocumenttipus IS 'TDxx';


--
-- TOC entry 2226 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN dib_transaccio.arxiureqparaminteressats; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.arxiureqparaminteressats IS 'Llistat de Nifs dels interessats separats per comes';


--
-- TOC entry 2227 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN dib_transaccio.arxiureqparamorigen; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.arxiureqparamorigen IS '0 Ciutada
1 Administracio';


--
-- TOC entry 2228 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN dib_transaccio.arxiureqparamorgans; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.arxiureqparamorgans IS 'Codi DIR3 dels organs afectats separats per comes';


--
-- TOC entry 2229 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN dib_transaccio.nom; Type: COMMENT; Schema: digitalib; Owner: digitalib
--

COMMENT ON COLUMN dib_transaccio.nom IS 'Nom descriptiu de la transaccio';


--
-- TOC entry 175 (class 1259 OID 97886)
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


ALTER TABLE digitalib.dib_usuariaplicacio OWNER TO digitalib;

--
-- TOC entry 174 (class 1259 OID 97872)
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
    rolecust boolean DEFAULT false NOT NULL
);


ALTER TABLE digitalib.dib_usuaripersona OWNER TO digitalib;

--
-- TOC entry 2041 (class 2606 OID 98202)
-- Name: dib_apisimple_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_apisimple
    ADD CONSTRAINT dib_apisimple_pk PRIMARY KEY (apisimpleid);


--
-- TOC entry 2060 (class 2606 OID 98728)
-- Name: dib_auditoria_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_auditoria
    ADD CONSTRAINT dib_auditoria_pk PRIMARY KEY (auditoriaid);


--
-- TOC entry 2069 (class 2606 OID 114599)
-- Name: dib_avis_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_avis
    ADD CONSTRAINT dib_avis_pk PRIMARY KEY (avisid);


--
-- TOC entry 2010 (class 2606 OID 97994)
-- Name: dib_cfggrup_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_uk UNIQUE (nom);


--
-- TOC entry 2053 (class 2606 OID 98739)
-- Name: dib_conffirma_nom_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_conffirma_nom_uk UNIQUE (nom);


--
-- TOC entry 2057 (class 2606 OID 98524)
-- Name: dib_configuraciofirma_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_configuraciofirma_pk PRIMARY KEY (configuraciofirmaid);


--
-- TOC entry 2012 (class 2606 OID 97992)
-- Name: dib_configuraciogrup_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_configuraciogrup_pk PRIMARY KEY (configuraciogrupid);


--
-- TOC entry 2022 (class 2606 OID 98078)
-- Name: dib_estadistica_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_estadistica
    ADD CONSTRAINT dib_estadistica_pk PRIMARY KEY (estadisticaid);


--
-- TOC entry 1959 (class 2606 OID 97855)
-- Name: dib_fitxer_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_fitxer
    ADD CONSTRAINT dib_fitxer_pk PRIMARY KEY (fitxerid);


--
-- TOC entry 1962 (class 2606 OID 97857)
-- Name: dib_idioma_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_idioma
    ADD CONSTRAINT dib_idioma_pk PRIMARY KEY (idiomaid);


--
-- TOC entry 2047 (class 2606 OID 98235)
-- Name: dib_infocustody_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_infocustody
    ADD CONSTRAINT dib_infocustody_pk PRIMARY KEY (infocustodyid);


--
-- TOC entry 2044 (class 2606 OID 98221)
-- Name: dib_infosignatura_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_infosignatura
    ADD CONSTRAINT dib_infosignatura_pk PRIMARY KEY (infosignaturaid);


--
-- TOC entry 2063 (class 2606 OID 111904)
-- Name: dib_metadada_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_metadada
    ADD CONSTRAINT dib_metadada_pk PRIMARY KEY (metadadaid);


--
-- TOC entry 1985 (class 2606 OID 97945)
-- Name: dib_perfil_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_pk PRIMARY KEY (perfilid);


--
-- TOC entry 1993 (class 2606 OID 98299)
-- Name: dib_perfil_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_uk UNIQUE (codi);


--
-- TOC entry 1996 (class 2606 OID 97973)
-- Name: dib_perfilusrapp_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfilusrapp_pk PRIMARY KEY (perfilusrappid);


--
-- TOC entry 1999 (class 2606 OID 98040)
-- Name: dib_perfusrapp_per_usrapp_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfusrapp_per_usrapp_uk UNIQUE (perfilid, usuariaplicacioid);


--
-- TOC entry 1979 (class 2606 OID 97929)
-- Name: dib_plugin_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_plugin
    ADD CONSTRAINT dib_plugin_pk PRIMARY KEY (pluginid);


--
-- TOC entry 2028 (class 2606 OID 98099)
-- Name: dib_plugincridada_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugincridada_pk PRIMARY KEY (plugincridadaid);


--
-- TOC entry 2015 (class 2606 OID 98055)
-- Name: dib_traduccio_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_traduccio
    ADD CONSTRAINT dib_traduccio_pk PRIMARY KEY (traduccioid);


--
-- TOC entry 2020 (class 2606 OID 98057)
-- Name: dib_traducmap_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_traducciomap
    ADD CONSTRAINT dib_traducmap_pk PRIMARY KEY (traducciomapid, idiomaid);


--
-- TOC entry 2036 (class 2606 OID 98120)
-- Name: dib_transaccio_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_pk PRIMARY KEY (transaccioid);


--
-- TOC entry 2039 (class 2606 OID 98247)
-- Name: dib_transaccio_webid_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_webid_uk UNIQUE (webid);


--
-- TOC entry 1974 (class 2606 OID 97901)
-- Name: dib_usrapp_username_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_usuariaplicacio
    ADD CONSTRAINT dib_usrapp_username_uk UNIQUE (username);


--
-- TOC entry 1967 (class 2606 OID 97905)
-- Name: dib_usrperson_nif_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_nif_uk UNIQUE (nif);


--
-- TOC entry 1969 (class 2606 OID 97903)
-- Name: dib_usrperson_username_uk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_username_uk UNIQUE (username);


--
-- TOC entry 1976 (class 2606 OID 97896)
-- Name: dib_usuariaplicacio_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_usuariaplicacio
    ADD CONSTRAINT dib_usuariaplicacio_pk PRIMARY KEY (usuariaplicacioid);


--
-- TOC entry 1971 (class 2606 OID 97876)
-- Name: dib_usuaripersona_pk; Type: CONSTRAINT; Schema: digitalib; Owner: digitalib; Tablespace: 
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usuaripersona_pk PRIMARY KEY (usuaripersonaid);


--
-- TOC entry 2042 (class 1259 OID 98208)
-- Name: dib_apisimple_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_apisimple_pk_i ON dib_apisimple USING btree (apisimpleid);


--
-- TOC entry 2061 (class 1259 OID 98729)
-- Name: dib_auditoria_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_auditoria_pk_i ON dib_auditoria USING btree (auditoriaid);


--
-- TOC entry 2066 (class 1259 OID 114617)
-- Name: dib_avis_configgrupid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_avis_configgrupid_fk_i ON dib_avis USING btree (configgrupid);


--
-- TOC entry 2067 (class 1259 OID 114616)
-- Name: dib_avis_descripcioid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_avis_descripcioid_fk_i ON dib_avis USING btree (descripcioid);


--
-- TOC entry 2070 (class 1259 OID 114615)
-- Name: dib_avis_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_avis_pk_i ON dib_avis USING btree (avisid);


--
-- TOC entry 2001 (class 1259 OID 98022)
-- Name: dib_cfggrup_logofooterid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_logofooterid_fk_i ON dib_configuraciogrup USING btree (logofooterid);


--
-- TOC entry 2002 (class 1259 OID 98021)
-- Name: dib_cfggrup_logoheaderid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_logoheaderid_fk_i ON dib_configuraciogrup USING btree (logoheaderid);


--
-- TOC entry 2003 (class 1259 OID 98669)
-- Name: dib_cfggrup_perfilcoau2_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilcoau2_fk_i ON dib_configuraciogrup USING btree (perfilcopiaautentica2id);


--
-- TOC entry 2004 (class 1259 OID 98328)
-- Name: dib_cfggrup_perfilcoau_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilcoau_fk_i ON dib_configuraciogrup USING btree (perfilcopiaautenticaid);


--
-- TOC entry 2005 (class 1259 OID 98670)
-- Name: dib_cfggrup_perfilcust2_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilcust2_fk_i ON dib_configuraciogrup USING btree (perfilcustodia2id);


--
-- TOC entry 2006 (class 1259 OID 98329)
-- Name: dib_cfggrup_perfilcust_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilcust_fk_i ON dib_configuraciogrup USING btree (perfilcustodiaid);


--
-- TOC entry 2007 (class 1259 OID 98671)
-- Name: dib_cfggrup_perfilscan2_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilscan2_fk_i ON dib_configuraciogrup USING btree (perfilnomesescaneig2id);


--
-- TOC entry 2008 (class 1259 OID 98327)
-- Name: dib_cfggrup_perfilscan_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_cfggrup_perfilscan_fk_i ON dib_configuraciogrup USING btree (perfilnomesescaneigid);


--
-- TOC entry 2049 (class 1259 OID 98540)
-- Name: dib_conffirma_algofirma_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_conffirma_algofirma_fk_i ON dib_configuraciofirma USING btree (algorismedefirmaid);


--
-- TOC entry 2050 (class 1259 OID 98541)
-- Name: dib_conffirma_firmatper_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_conffirma_firmatper_fk_i ON dib_configuraciofirma USING btree (firmatperformatid);


--
-- TOC entry 2051 (class 1259 OID 98542)
-- Name: dib_conffirma_motiudele_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_conffirma_motiudele_fk_i ON dib_configuraciofirma USING btree (motiudelegacioid);


--
-- TOC entry 2054 (class 1259 OID 98608)
-- Name: dib_conffirma_plugfirma_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_conffirma_plugfirma_fk_i ON dib_configuraciofirma USING btree (pluginfirmaservidorid);


--
-- TOC entry 2055 (class 1259 OID 98543)
-- Name: dib_conffirma_plugsegell_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_conffirma_plugsegell_fk_i ON dib_configuraciofirma USING btree (pluginsegellatid);


--
-- TOC entry 2058 (class 1259 OID 98544)
-- Name: dib_configuraciofirma_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_configuraciofirma_pk_i ON dib_configuraciofirma USING btree (configuraciofirmaid);


--
-- TOC entry 2013 (class 1259 OID 98020)
-- Name: dib_configuraciogrup_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_configuraciogrup_pk_i ON dib_configuraciogrup USING btree (configuraciogrupid);


--
-- TOC entry 2023 (class 1259 OID 98166)
-- Name: dib_estadistica_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_estadistica_pk_i ON dib_estadistica USING btree (estadisticaid);


--
-- TOC entry 1960 (class 1259 OID 97862)
-- Name: dib_fitxer_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_fitxer_pk_i ON dib_fitxer USING btree (fitxerid);


--
-- TOC entry 1963 (class 1259 OID 97863)
-- Name: dib_idioma_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_idioma_pk_i ON dib_idioma USING btree (idiomaid);


--
-- TOC entry 2048 (class 1259 OID 98242)
-- Name: dib_infocustody_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_infocustody_pk_i ON dib_infocustody USING btree (infocustodyid);


--
-- TOC entry 2045 (class 1259 OID 98243)
-- Name: dib_infosignatura_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_infosignatura_pk_i ON dib_infosignatura USING btree (infosignaturaid);


--
-- TOC entry 2064 (class 1259 OID 111920)
-- Name: dib_metadada_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_metadada_pk_i ON dib_metadada USING btree (metadadaid);


--
-- TOC entry 2065 (class 1259 OID 111921)
-- Name: dib_metadada_transaccioid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_metadada_transaccioid_fk_i ON dib_metadada USING btree (transaccioid);


--
-- TOC entry 1981 (class 1259 OID 98209)
-- Name: dib_perfil_apisimpleid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_apisimpleid_fk_i ON dib_perfil USING btree (apisimpleid);


--
-- TOC entry 1982 (class 1259 OID 98709)
-- Name: dib_perfil_descripcioid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_descripcioid_fk_i ON dib_perfil USING btree (descripcioid);


--
-- TOC entry 1983 (class 1259 OID 98708)
-- Name: dib_perfil_nomid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_nomid_fk_i ON dib_perfil USING btree (nomid);


--
-- TOC entry 1986 (class 1259 OID 98023)
-- Name: dib_perfil_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_pk_i ON dib_perfil USING btree (perfilid);


--
-- TOC entry 1987 (class 1259 OID 98027)
-- Name: dib_perfil_plugin_pdcid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_plugin_pdcid_fk_i ON dib_perfil USING btree (plugindoccustodyid);


--
-- TOC entry 1988 (class 1259 OID 98025)
-- Name: dib_perfil_plugin_psid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_plugin_psid_fk_i ON dib_perfil USING btree (configuraciofirmaid);


--
-- TOC entry 1989 (class 1259 OID 98026)
-- Name: dib_perfil_pluginarxiuid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_pluginarxiuid_fk_i ON dib_perfil USING btree (pluginarxiuid);


--
-- TOC entry 1990 (class 1259 OID 98335)
-- Name: dib_perfil_plugscanweb2_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_plugscanweb2_fk_i ON dib_perfil USING btree (pluginscanweb2id);


--
-- TOC entry 1991 (class 1259 OID 98024)
-- Name: dib_perfil_plugscanwebid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfil_plugscanwebid_fk_i ON dib_perfil USING btree (pluginscanwebid);


--
-- TOC entry 1994 (class 1259 OID 98029)
-- Name: dib_perfilusrapp_perfilid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfilusrapp_perfilid_fk_i ON dib_perfilusrapp USING btree (perfilid);


--
-- TOC entry 1997 (class 1259 OID 98028)
-- Name: dib_perfilusrapp_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfilusrapp_pk_i ON dib_perfilusrapp USING btree (perfilusrappid);


--
-- TOC entry 2000 (class 1259 OID 98030)
-- Name: dib_perfusrapp_usrappid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_perfusrapp_usrappid_fk_i ON dib_perfilusrapp USING btree (usuariaplicacioid);


--
-- TOC entry 2024 (class 1259 OID 98169)
-- Name: dib_plugcrid_paramfitxer_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_plugcrid_paramfitxer_fk_i ON dib_plugincridada USING btree (parametresfitxerid);


--
-- TOC entry 2025 (class 1259 OID 98168)
-- Name: dib_plugcrid_pluginid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_plugcrid_pluginid_fk_i ON dib_plugincridada USING btree (pluginid);


--
-- TOC entry 2026 (class 1259 OID 98170)
-- Name: dib_plugcrid_retofitxerid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_plugcrid_retofitxerid_fk_i ON dib_plugincridada USING btree (retornfitxerid);


--
-- TOC entry 1980 (class 1259 OID 98031)
-- Name: dib_plugin_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_plugin_pk_i ON dib_plugin USING btree (pluginid);


--
-- TOC entry 2029 (class 1259 OID 98167)
-- Name: dib_plugincridada_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_plugincridada_pk_i ON dib_plugincridada USING btree (plugincridadaid);


--
-- TOC entry 2016 (class 1259 OID 98058)
-- Name: dib_traduccio_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_traduccio_pk_i ON dib_traduccio USING btree (traduccioid);


--
-- TOC entry 2017 (class 1259 OID 98059)
-- Name: dib_traducciomap_idiomaid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_traducciomap_idiomaid_fk_i ON dib_traducciomap USING btree (idiomaid);


--
-- TOC entry 2018 (class 1259 OID 98060)
-- Name: dib_traducciomap_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_traducciomap_pk_i ON dib_traducciomap USING btree (traducciomapid);


--
-- TOC entry 2030 (class 1259 OID 98310)
-- Name: dib_transaccio_fileplain_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_fileplain_fk_i ON dib_transaccio USING btree (fitxerescanejatid);


--
-- TOC entry 2031 (class 1259 OID 98311)
-- Name: dib_transaccio_filesign_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_filesign_fk_i ON dib_transaccio USING btree (fitxersignaturaid);


--
-- TOC entry 2032 (class 1259 OID 98245)
-- Name: dib_transaccio_infocustid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_infocustid_fk_i ON dib_transaccio USING btree (infocustodyid);


--
-- TOC entry 2033 (class 1259 OID 98244)
-- Name: dib_transaccio_infosignid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_infosignid_fk_i ON dib_transaccio USING btree (infosignaturaid);


--
-- TOC entry 2034 (class 1259 OID 98270)
-- Name: dib_transaccio_perfilid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_perfilid_fk_i ON dib_transaccio USING btree (perfilid);


--
-- TOC entry 2037 (class 1259 OID 98171)
-- Name: dib_transaccio_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_transaccio_pk_i ON dib_transaccio USING btree (transaccioid);


--
-- TOC entry 1964 (class 1259 OID 98034)
-- Name: dib_usrperson_confgrupid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_usrperson_confgrupid_fk_i ON dib_usuaripersona USING btree (configuraciogrupid);


--
-- TOC entry 1965 (class 1259 OID 97913)
-- Name: dib_usrperson_idiomaid_fk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_usrperson_idiomaid_fk_i ON dib_usuaripersona USING btree (idiomaid);


--
-- TOC entry 1977 (class 1259 OID 97911)
-- Name: dib_usuariaplicacio_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_usuariaplicacio_pk_i ON dib_usuariaplicacio USING btree (usuariaplicacioid);


--
-- TOC entry 1972 (class 1259 OID 97912)
-- Name: dib_usuaripersona_pk_i; Type: INDEX; Schema: digitalib; Owner: digitalib; Tablespace: 
--

CREATE INDEX dib_usuaripersona_pk_i ON dib_usuaripersona USING btree (usuaripersonaid);


--
-- TOC entry 2106 (class 2606 OID 114610)
-- Name: dib_avis_cfggrup_configgrup_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_avis
    ADD CONSTRAINT dib_avis_cfggrup_configgrup_fk FOREIGN KEY (configgrupid) REFERENCES dib_configuraciogrup(configuraciogrupid);


--
-- TOC entry 2105 (class 2606 OID 114600)
-- Name: dib_avis_traduccio_desc_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_avis
    ADD CONSTRAINT dib_avis_traduccio_desc_fk FOREIGN KEY (descripcioid) REFERENCES dib_traduccio(traduccioid);


--
-- TOC entry 2083 (class 2606 OID 97995)
-- Name: dib_cfggrup_fitxer_cap_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_fitxer_cap_fk FOREIGN KEY (logoheaderid) REFERENCES dib_fitxer(fitxerid);


--
-- TOC entry 2084 (class 2606 OID 98000)
-- Name: dib_cfggrup_fitxer_peu_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_fitxer_peu_fk FOREIGN KEY (logofooterid) REFERENCES dib_fitxer(fitxerid);


--
-- TOC entry 2088 (class 2606 OID 98654)
-- Name: dib_cfggrup_perfil_coau2_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_coau2_fk FOREIGN KEY (perfilcopiaautentica2id) REFERENCES dib_perfil(perfilid);


--
-- TOC entry 2086 (class 2606 OID 98317)
-- Name: dib_cfggrup_perfil_coau_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_coau_fk FOREIGN KEY (perfilcopiaautenticaid) REFERENCES dib_perfil(perfilid);


--
-- TOC entry 2089 (class 2606 OID 98659)
-- Name: dib_cfggrup_perfil_cust2_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_cust2_fk FOREIGN KEY (perfilcustodia2id) REFERENCES dib_perfil(perfilid);


--
-- TOC entry 2087 (class 2606 OID 98322)
-- Name: dib_cfggrup_perfil_cust_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_cust_fk FOREIGN KEY (perfilcustodiaid) REFERENCES dib_perfil(perfilid);


--
-- TOC entry 2090 (class 2606 OID 98664)
-- Name: dib_cfggrup_perfil_scan2_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_scan2_fk FOREIGN KEY (perfilnomesescaneig2id) REFERENCES dib_perfil(perfilid);


--
-- TOC entry 2085 (class 2606 OID 98312)
-- Name: dib_cfggrup_perfil_scan_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_perfil_scan_fk FOREIGN KEY (perfilnomesescaneigid) REFERENCES dib_perfil(perfilid);


--
-- TOC entry 2100 (class 2606 OID 98603)
-- Name: dib_conffirma_plugin_fir_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_conffirma_plugin_fir_fk FOREIGN KEY (pluginfirmaservidorid) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 2101 (class 2606 OID 98525)
-- Name: dib_conffirma_plugin_seg_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_conffirma_plugin_seg_fk FOREIGN KEY (pluginsegellatid) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 2102 (class 2606 OID 98556)
-- Name: dib_conffirma_traduccio_ff_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_conffirma_traduccio_ff_fk FOREIGN KEY (firmatperformatid) REFERENCES dib_traduccio(traduccioid);


--
-- TOC entry 2103 (class 2606 OID 98561)
-- Name: dib_conffirma_traduccio_md_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_configuraciofirma
    ADD CONSTRAINT dib_conffirma_traduccio_md_fk FOREIGN KEY (motiudelegacioid) REFERENCES dib_traduccio(traduccioid);


--
-- TOC entry 2104 (class 2606 OID 111915)
-- Name: dib_meta_transaccio_trans_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_metadada
    ADD CONSTRAINT dib_meta_transaccio_trans_fk FOREIGN KEY (transaccioid) REFERENCES dib_transaccio(transaccioid);


--
-- TOC entry 2076 (class 2606 OID 98203)
-- Name: dib_perfil_apisimple_firma_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_apisimple_firma_fk FOREIGN KEY (apisimpleid) REFERENCES dib_apisimple(apisimpleid);


--
-- TOC entry 2080 (class 2606 OID 98741)
-- Name: dib_perfil_conffirma_cf_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_conffirma_cf_fk FOREIGN KEY (configuraciofirmaid) REFERENCES dib_configuraciofirma(configuraciofirmaid);


--
-- TOC entry 2074 (class 2606 OID 97958)
-- Name: dib_perfil_plugin_arxiu_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_arxiu_fk FOREIGN KEY (pluginarxiuid) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 2075 (class 2606 OID 97963)
-- Name: dib_perfil_plugin_cust_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_cust_fk FOREIGN KEY (plugindoccustodyid) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 2077 (class 2606 OID 98330)
-- Name: dib_perfil_plugin_scan2_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_scan2_fk FOREIGN KEY (pluginscanweb2id) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 2073 (class 2606 OID 97948)
-- Name: dib_perfil_plugin_scan_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_scan_fk FOREIGN KEY (pluginscanwebid) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 2079 (class 2606 OID 98703)
-- Name: dib_perfil_traduccio_descri_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_traduccio_descri_fk FOREIGN KEY (descripcioid) REFERENCES dib_traduccio(traduccioid);


--
-- TOC entry 2078 (class 2606 OID 98698)
-- Name: dib_perfil_traduccio_nomid_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_traduccio_nomid_fk FOREIGN KEY (nomid) REFERENCES dib_traduccio(traduccioid);


--
-- TOC entry 2081 (class 2606 OID 97974)
-- Name: dib_perfusrapp_perfil_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfusrapp_perfil_fk FOREIGN KEY (perfilid) REFERENCES dib_perfil(perfilid);


--
-- TOC entry 2082 (class 2606 OID 98015)
-- Name: dib_perfusrapp_usrapp_usrap_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfusrapp_usrapp_usrap_fk FOREIGN KEY (usuariaplicacioid) REFERENCES dib_usuariaplicacio(usuariaplicacioid);


--
-- TOC entry 2094 (class 2606 OID 98161)
-- Name: dib_plugcrid_fitxer_paramet_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugcrid_fitxer_paramet_fk FOREIGN KEY (parametresfitxerid) REFERENCES dib_fitxer(fitxerid);


--
-- TOC entry 2092 (class 2606 OID 98151)
-- Name: dib_plugcrid_fitxer_retornf_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugcrid_fitxer_retornf_fk FOREIGN KEY (retornfitxerid) REFERENCES dib_fitxer(fitxerid);


--
-- TOC entry 2093 (class 2606 OID 98156)
-- Name: dib_plugcrid_plugin_plugini_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugcrid_plugin_plugini_fk FOREIGN KEY (pluginid) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 2091 (class 2606 OID 98061)
-- Name: dib_traducmap_traduccio_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_traducciomap
    ADD CONSTRAINT dib_traducmap_traduccio_fk FOREIGN KEY (traducciomapid) REFERENCES dib_traduccio(traduccioid);


--
-- TOC entry 2098 (class 2606 OID 98300)
-- Name: dib_transaccio_fitxer_pla_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_fitxer_pla_fk FOREIGN KEY (fitxerescanejatid) REFERENCES dib_fitxer(fitxerid);


--
-- TOC entry 2099 (class 2606 OID 98305)
-- Name: dib_transaccio_fitxer_sign_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_fitxer_sign_fk FOREIGN KEY (fitxersignaturaid) REFERENCES dib_fitxer(fitxerid);


--
-- TOC entry 2096 (class 2606 OID 98236)
-- Name: dib_transaccio_infocust_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_infocust_fk FOREIGN KEY (infocustodyid) REFERENCES dib_infocustody(infocustodyid);


--
-- TOC entry 2095 (class 2606 OID 98222)
-- Name: dib_transaccio_infosign_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_infosign_fk FOREIGN KEY (infosignaturaid) REFERENCES dib_infosignatura(infosignaturaid);


--
-- TOC entry 2097 (class 2606 OID 98253)
-- Name: dib_transaccio_perfil_perfi_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_perfil_perfi_fk FOREIGN KEY (perfilid) REFERENCES dib_perfil(perfilid);


--
-- TOC entry 2072 (class 2606 OID 98010)
-- Name: dib_usrperson_cfggrup_conf_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_cfggrup_conf_fk FOREIGN KEY (configuraciogrupid) REFERENCES dib_configuraciogrup(configuraciogrupid);


--
-- TOC entry 2071 (class 2606 OID 97906)
-- Name: dib_usrperson_idioma_idioma_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: digitalib
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_idioma_idioma_fk FOREIGN KEY (idiomaid) REFERENCES dib_idioma(idiomaid);


-- Completed on 2020-07-22 12:34:41

--
-- PostgreSQL database dump complete
--

