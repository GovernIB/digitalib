--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2018-11-16 11:24:41

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 97827)
-- Name: digitalib; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA digitalib;


SET search_path = digitalib, pg_catalog;

--
-- TOC entry 171 (class 1259 OID 97828)
-- Name: dib_digitalib_seq; Type: SEQUENCE; Schema: digitalib; Owner: -
--

CREATE SEQUENCE dib_digitalib_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 98194)
-- Name: dib_apisimple; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE TABLE dib_apisimple (
    apisimpleid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    nom character varying(255) NOT NULL,
    url character varying(255) NOT NULL,
    username character varying(255) NOT NULL,
    contrasenya character varying(255) NOT NULL
);


--
-- TOC entry 179 (class 1259 OID 97984)
-- Name: dib_configuraciogrup; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE TABLE dib_configuraciogrup (
    configuraciogrupid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    nom character varying(100) NOT NULL,
    suportweb character varying(255),
    suportemail character varying(255),
    suporttelefon character varying(255),
    logoheaderid bigint NOT NULL,
    logofooterid bigint NOT NULL
);


--
-- TOC entry 182 (class 1259 OID 98069)
-- Name: dib_estadistica; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
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


--
-- TOC entry 172 (class 1259 OID 97830)
-- Name: dib_fitxer; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE TABLE dib_fitxer (
    fitxerid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    descripcio character varying(1000) DEFAULT NULL::character varying,
    mime character varying(255) NOT NULL,
    nom character varying(255) NOT NULL,
    tamany bigint NOT NULL
);


--
-- TOC entry 173 (class 1259 OID 97838)
-- Name: dib_idioma; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE TABLE dib_idioma (
    idiomaid character varying(5) NOT NULL,
    nom character varying(50) NOT NULL,
    suportat boolean DEFAULT true NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);


--
-- TOC entry 177 (class 1259 OID 97940)
-- Name: dib_perfil; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE TABLE dib_perfil (
    perfilid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    nom character varying(100) NOT NULL,
    descripcio character varying(255),
    pluginscanwebid bigint NOT NULL,
    pluginfirmaservidorid bigint,
    pluginarxiuid bigint,
    plugindoccustodyid bigint,
    codi character varying(25) NOT NULL,
    tipusfirma integer DEFAULT 0 NOT NULL,
    tipuscustodia integer DEFAULT 0 NOT NULL,
    apisimpleid bigint
);


--
-- TOC entry 178 (class 1259 OID 97968)
-- Name: dib_perfilusrapp; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE TABLE dib_perfilusrapp (
    perfilusrappid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    perfilid bigint NOT NULL,
    usuariaplicacioid bigint NOT NULL
);


--
-- TOC entry 176 (class 1259 OID 97921)
-- Name: dib_plugin; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
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


--
-- TOC entry 183 (class 1259 OID 98091)
-- Name: dib_plugincridada; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
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


--
-- TOC entry 180 (class 1259 OID 98044)
-- Name: dib_traduccio; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE TABLE dib_traduccio (
    traduccioid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL
);


--
-- TOC entry 181 (class 1259 OID 98048)
-- Name: dib_traducciomap; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE TABLE dib_traducciomap (
    traducciomapid bigint NOT NULL,
    idiomaid character varying(10) NOT NULL,
    valor character varying(4000)
);


--
-- TOC entry 184 (class 1259 OID 98115)
-- Name: dib_transaccio; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE TABLE dib_transaccio (
    transaccioid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    datainici timestamp without time zone NOT NULL,
    datafi timestamp without time zone,
    usuariaplicacioid bigint,
    usuaripersonaid bigint
);


--
-- TOC entry 175 (class 1259 OID 97886)
-- Name: dib_usuariaplicacio; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE TABLE dib_usuariaplicacio (
    usuariaplicacioid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    username character varying(101) NOT NULL,
    contrasenya character varying(50),
    emailadmin character varying(100) NOT NULL,
    descripcio character varying(255) DEFAULT NULL::character varying,
    actiu boolean DEFAULT true NOT NULL
);


--
-- TOC entry 174 (class 1259 OID 97872)
-- Name: dib_usuaripersona; Type: TABLE; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE TABLE dib_usuaripersona (
    usuaripersonaid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    username character varying(50) NOT NULL,
    nom character varying(50) NOT NULL,
    llinatges character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    nif character varying(9) NOT NULL,
    idiomaid character varying(5) NOT NULL,
    configuraciogrupid bigint NOT NULL
);


--
-- TOC entry 1971 (class 2606 OID 98202)
-- Name: dib_apisimple_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_apisimple
    ADD CONSTRAINT dib_apisimple_pk PRIMARY KEY (apisimpleid);


--
-- TOC entry 1947 (class 2606 OID 97994)
-- Name: dib_cfggrup_uk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_uk UNIQUE (nom);


--
-- TOC entry 1949 (class 2606 OID 97992)
-- Name: dib_configuraciogrup_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_configuraciogrup_pk PRIMARY KEY (configuraciogrupid);


--
-- TOC entry 1959 (class 2606 OID 98078)
-- Name: dib_estadistica_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_estadistica
    ADD CONSTRAINT dib_estadistica_pk PRIMARY KEY (estadisticaid);


--
-- TOC entry 1905 (class 2606 OID 97855)
-- Name: dib_fitxer_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_fitxer
    ADD CONSTRAINT dib_fitxer_pk PRIMARY KEY (fitxerid);


--
-- TOC entry 1908 (class 2606 OID 97857)
-- Name: dib_idioma_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_idioma
    ADD CONSTRAINT dib_idioma_pk PRIMARY KEY (idiomaid);


--
-- TOC entry 1929 (class 2606 OID 97945)
-- Name: dib_perfil_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_pk PRIMARY KEY (perfilid);


--
-- TOC entry 1936 (class 2606 OID 97947)
-- Name: dib_perfil_uk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_uk UNIQUE (codi);


--
-- TOC entry 1939 (class 2606 OID 97973)
-- Name: dib_perfilusrapp_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfilusrapp_pk PRIMARY KEY (perfilusrappid);


--
-- TOC entry 1942 (class 2606 OID 98040)
-- Name: dib_perfusrapp_per_usrapp_uk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfusrapp_per_usrapp_uk UNIQUE (perfilid, usuariaplicacioid);


--
-- TOC entry 1925 (class 2606 OID 97929)
-- Name: dib_plugin_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_plugin
    ADD CONSTRAINT dib_plugin_pk PRIMARY KEY (pluginid);


--
-- TOC entry 1965 (class 2606 OID 98099)
-- Name: dib_plugincridada_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugincridada_pk PRIMARY KEY (plugincridadaid);


--
-- TOC entry 1952 (class 2606 OID 98055)
-- Name: dib_traduccio_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_traduccio
    ADD CONSTRAINT dib_traduccio_pk PRIMARY KEY (traduccioid);


--
-- TOC entry 1957 (class 2606 OID 98057)
-- Name: dib_traducmap_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_traducciomap
    ADD CONSTRAINT dib_traducmap_pk PRIMARY KEY (traducciomapid, idiomaid);


--
-- TOC entry 1968 (class 2606 OID 98120)
-- Name: dib_transaccio_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_transaccio
    ADD CONSTRAINT dib_transaccio_pk PRIMARY KEY (transaccioid);


--
-- TOC entry 1920 (class 2606 OID 97901)
-- Name: dib_usrapp_username_uk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_usuariaplicacio
    ADD CONSTRAINT dib_usrapp_username_uk UNIQUE (username);


--
-- TOC entry 1913 (class 2606 OID 97905)
-- Name: dib_usrperson_nif_uk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_nif_uk UNIQUE (nif);


--
-- TOC entry 1915 (class 2606 OID 97903)
-- Name: dib_usrperson_username_uk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_username_uk UNIQUE (username);


--
-- TOC entry 1922 (class 2606 OID 97896)
-- Name: dib_usuariaplicacio_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_usuariaplicacio
    ADD CONSTRAINT dib_usuariaplicacio_pk PRIMARY KEY (usuariaplicacioid);


--
-- TOC entry 1917 (class 2606 OID 97876)
-- Name: dib_usuaripersona_pk; Type: CONSTRAINT; Schema: digitalib; Owner: -; Tablespace: 
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usuaripersona_pk PRIMARY KEY (usuaripersonaid);


--
-- TOC entry 1972 (class 1259 OID 98208)
-- Name: dib_apisimple_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_apisimple_pk_i ON dib_apisimple USING btree (apisimpleid);


--
-- TOC entry 1944 (class 1259 OID 98022)
-- Name: dib_cfggrup_logofooterid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_cfggrup_logofooterid_fk_i ON dib_configuraciogrup USING btree (logofooterid);


--
-- TOC entry 1945 (class 1259 OID 98021)
-- Name: dib_cfggrup_logoheaderid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_cfggrup_logoheaderid_fk_i ON dib_configuraciogrup USING btree (logoheaderid);


--
-- TOC entry 1950 (class 1259 OID 98020)
-- Name: dib_configuraciogrup_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_configuraciogrup_pk_i ON dib_configuraciogrup USING btree (configuraciogrupid);


--
-- TOC entry 1960 (class 1259 OID 98166)
-- Name: dib_estadistica_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_estadistica_pk_i ON dib_estadistica USING btree (estadisticaid);


--
-- TOC entry 1906 (class 1259 OID 97862)
-- Name: dib_fitxer_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_fitxer_pk_i ON dib_fitxer USING btree (fitxerid);


--
-- TOC entry 1909 (class 1259 OID 97863)
-- Name: dib_idioma_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_idioma_pk_i ON dib_idioma USING btree (idiomaid);


--
-- TOC entry 1927 (class 1259 OID 98209)
-- Name: dib_perfil_apisimpleid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_perfil_apisimpleid_fk_i ON dib_perfil USING btree (apisimpleid);


--
-- TOC entry 1930 (class 1259 OID 98023)
-- Name: dib_perfil_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_perfil_pk_i ON dib_perfil USING btree (perfilid);


--
-- TOC entry 1931 (class 1259 OID 98027)
-- Name: dib_perfil_plugin_pdcid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_perfil_plugin_pdcid_fk_i ON dib_perfil USING btree (plugindoccustodyid);


--
-- TOC entry 1932 (class 1259 OID 98025)
-- Name: dib_perfil_plugin_psid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_perfil_plugin_psid_fk_i ON dib_perfil USING btree (pluginfirmaservidorid);


--
-- TOC entry 1933 (class 1259 OID 98026)
-- Name: dib_perfil_pluginarxiuid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_perfil_pluginarxiuid_fk_i ON dib_perfil USING btree (pluginarxiuid);


--
-- TOC entry 1934 (class 1259 OID 98024)
-- Name: dib_perfil_plugscanwebid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_perfil_plugscanwebid_fk_i ON dib_perfil USING btree (pluginscanwebid);


--
-- TOC entry 1937 (class 1259 OID 98029)
-- Name: dib_perfilusrapp_perfilid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_perfilusrapp_perfilid_fk_i ON dib_perfilusrapp USING btree (perfilid);


--
-- TOC entry 1940 (class 1259 OID 98028)
-- Name: dib_perfilusrapp_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_perfilusrapp_pk_i ON dib_perfilusrapp USING btree (perfilusrappid);


--
-- TOC entry 1943 (class 1259 OID 98030)
-- Name: dib_perfusrapp_usrappid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_perfusrapp_usrappid_fk_i ON dib_perfilusrapp USING btree (usuariaplicacioid);


--
-- TOC entry 1961 (class 1259 OID 98169)
-- Name: dib_plugcrid_paramfitxer_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_plugcrid_paramfitxer_fk_i ON dib_plugincridada USING btree (parametresfitxerid);


--
-- TOC entry 1962 (class 1259 OID 98168)
-- Name: dib_plugcrid_pluginid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_plugcrid_pluginid_fk_i ON dib_plugincridada USING btree (pluginid);


--
-- TOC entry 1963 (class 1259 OID 98170)
-- Name: dib_plugcrid_retofitxerid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_plugcrid_retofitxerid_fk_i ON dib_plugincridada USING btree (retornfitxerid);


--
-- TOC entry 1926 (class 1259 OID 98031)
-- Name: dib_plugin_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_plugin_pk_i ON dib_plugin USING btree (pluginid);


--
-- TOC entry 1966 (class 1259 OID 98167)
-- Name: dib_plugincridada_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_plugincridada_pk_i ON dib_plugincridada USING btree (plugincridadaid);


--
-- TOC entry 1953 (class 1259 OID 98058)
-- Name: dib_traduccio_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_traduccio_pk_i ON dib_traduccio USING btree (traduccioid);


--
-- TOC entry 1954 (class 1259 OID 98059)
-- Name: dib_traducciomap_idiomaid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_traducciomap_idiomaid_fk_i ON dib_traducciomap USING btree (idiomaid);


--
-- TOC entry 1955 (class 1259 OID 98060)
-- Name: dib_traducciomap_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_traducciomap_pk_i ON dib_traducciomap USING btree (traducciomapid);


--
-- TOC entry 1969 (class 1259 OID 98171)
-- Name: dib_transaccio_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_transaccio_pk_i ON dib_transaccio USING btree (transaccioid);


--
-- TOC entry 1910 (class 1259 OID 98034)
-- Name: dib_usrperson_confgrupid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_usrperson_confgrupid_fk_i ON dib_usuaripersona USING btree (configuraciogrupid);


--
-- TOC entry 1911 (class 1259 OID 97913)
-- Name: dib_usrperson_idiomaid_fk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_usrperson_idiomaid_fk_i ON dib_usuaripersona USING btree (idiomaid);


--
-- TOC entry 1923 (class 1259 OID 97911)
-- Name: dib_usuariaplicacio_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_usuariaplicacio_pk_i ON dib_usuariaplicacio USING btree (usuariaplicacioid);


--
-- TOC entry 1918 (class 1259 OID 97912)
-- Name: dib_usuaripersona_pk_i; Type: INDEX; Schema: digitalib; Owner: -; Tablespace: 
--

CREATE INDEX dib_usuaripersona_pk_i ON dib_usuaripersona USING btree (usuaripersonaid);


--
-- TOC entry 1982 (class 2606 OID 97995)
-- Name: dib_cfggrup_fitxer_cap_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_fitxer_cap_fk FOREIGN KEY (logoheaderid) REFERENCES dib_fitxer(fitxerid);


--
-- TOC entry 1983 (class 2606 OID 98000)
-- Name: dib_cfggrup_fitxer_peu_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_configuraciogrup
    ADD CONSTRAINT dib_cfggrup_fitxer_peu_fk FOREIGN KEY (logofooterid) REFERENCES dib_fitxer(fitxerid);


--
-- TOC entry 1979 (class 2606 OID 98203)
-- Name: dib_perfil_apisimple_firma_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_apisimple_firma_fk FOREIGN KEY (apisimpleid) REFERENCES dib_apisimple(apisimpleid);


--
-- TOC entry 1977 (class 2606 OID 97958)
-- Name: dib_perfil_plugin_arxiu_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_arxiu_fk FOREIGN KEY (pluginarxiuid) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 1978 (class 2606 OID 97963)
-- Name: dib_perfil_plugin_cust_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_cust_fk FOREIGN KEY (plugindoccustodyid) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 1976 (class 2606 OID 97953)
-- Name: dib_perfil_plugin_firma_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_firma_fk FOREIGN KEY (pluginfirmaservidorid) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 1975 (class 2606 OID 97948)
-- Name: dib_perfil_plugin_scan_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_perfil
    ADD CONSTRAINT dib_perfil_plugin_scan_fk FOREIGN KEY (pluginscanwebid) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 1980 (class 2606 OID 97974)
-- Name: dib_perfusrapp_perfil_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfusrapp_perfil_fk FOREIGN KEY (perfilid) REFERENCES dib_perfil(perfilid);


--
-- TOC entry 1981 (class 2606 OID 98015)
-- Name: dib_perfusrapp_usrapp_usrap_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_perfilusrapp
    ADD CONSTRAINT dib_perfusrapp_usrapp_usrap_fk FOREIGN KEY (usuariaplicacioid) REFERENCES dib_usuariaplicacio(usuariaplicacioid);


--
-- TOC entry 1987 (class 2606 OID 98161)
-- Name: dib_plugcrid_fitxer_paramet_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugcrid_fitxer_paramet_fk FOREIGN KEY (parametresfitxerid) REFERENCES dib_fitxer(fitxerid);


--
-- TOC entry 1985 (class 2606 OID 98151)
-- Name: dib_plugcrid_fitxer_retornf_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugcrid_fitxer_retornf_fk FOREIGN KEY (retornfitxerid) REFERENCES dib_fitxer(fitxerid);


--
-- TOC entry 1986 (class 2606 OID 98156)
-- Name: dib_plugcrid_plugin_plugini_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_plugincridada
    ADD CONSTRAINT dib_plugcrid_plugin_plugini_fk FOREIGN KEY (pluginid) REFERENCES dib_plugin(pluginid);


--
-- TOC entry 1984 (class 2606 OID 98061)
-- Name: dib_traducmap_traduccio_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_traducciomap
    ADD CONSTRAINT dib_traducmap_traduccio_fk FOREIGN KEY (traducciomapid) REFERENCES dib_traduccio(traduccioid);


--
-- TOC entry 1974 (class 2606 OID 98010)
-- Name: dib_usrperson_cfggrup_conf_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_cfggrup_conf_fk FOREIGN KEY (configuraciogrupid) REFERENCES dib_configuraciogrup(configuraciogrupid);


--
-- TOC entry 1973 (class 2606 OID 97906)
-- Name: dib_usrperson_idioma_idioma_fk; Type: FK CONSTRAINT; Schema: digitalib; Owner: -
--

ALTER TABLE ONLY dib_usuaripersona
    ADD CONSTRAINT dib_usrperson_idioma_idioma_fk FOREIGN KEY (idiomaid) REFERENCES dib_idioma(idiomaid);


-- Completed on 2018-11-16 11:24:42

--
-- PostgreSQL database dump complete
--

