

CREATE SEQUENCE dib_digitalib_seq INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1000;

CREATE TABLE dib_fitxer (
    fitxerid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL,
    descripcio character varying(1000) DEFAULT NULL::character varying,
    mime character varying(255) NOT NULL,
    nom character varying(255) NOT NULL,
    tamany bigint NOT NULL
);

CREATE TABLE dib_idioma (
    idiomaid character varying(5) NOT NULL,
    nom character varying(50) NOT NULL,
    suportat boolean DEFAULT true NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);

CREATE TABLE dib_traduccio (
    traduccioid bigint DEFAULT nextval('dib_digitalib_seq'::regclass) NOT NULL
);

CREATE TABLE dib_traducciomap (
    traducciomapid bigint NOT NULL,
    idiomaid character varying(10) NOT NULL,
    valor character varying(4000)
);

ALTER TABLE ONLY dib_fitxer
    ADD CONSTRAINT dib_fitxer_pk PRIMARY KEY (fitxerid);

ALTER TABLE ONLY dib_idioma
    ADD CONSTRAINT dib_idioma_pk PRIMARY KEY (idiomaid);

ALTER TABLE ONLY dib_traduccio
    ADD CONSTRAINT dib_traduccio_pk PRIMARY KEY (traduccioid);

ALTER TABLE ONLY dib_traducciomap
    ADD CONSTRAINT dib_traducmap_pk PRIMARY KEY (traducciomapid, idiomaid);

CREATE INDEX dib_fitxer_pk_i ON dib_fitxer USING btree (fitxerid);

CREATE INDEX dib_idioma_pk_i ON dib_idioma USING btree (idiomaid);

CREATE INDEX dib_traduccio_pk_i ON dib_traduccio USING btree (traduccioid);

CREATE INDEX dib_traducciomap_idiomaid_fk_i ON dib_traducciomap USING btree (idiomaid);

CREATE INDEX dib_traducciomap_pk_i ON dib_traducciomap USING btree (traducciomapid);

ALTER TABLE ONLY dib_traducciomap
    ADD CONSTRAINT dib_traducmap_traduccio_fk FOREIGN KEY (traducciomapid) REFERENCES dib_traduccio(traduccioid);


