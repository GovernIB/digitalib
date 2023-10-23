
-- 2023/09/28 


-- IMPORTANT !!!!!!

-- S'ha de reemplaçar __XXXX__ pel valor de la consulta "select dib_digitalib_seq.nextval from dual;"


CREATE SEQUENCE dib_apisimple_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_apisimple ALTER COLUMN apisimpleid SET DEFAULT dib_apisimple_seq.nextval;

CREATE SEQUENCE dib_auditoria_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_auditoria ALTER COLUMN auditoriaid SET DEFAULT dib_auditoria_seq.nextval;

CREATE SEQUENCE dib_avis_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_avis ALTER COLUMN avisid SET DEFAULT dib_avis_seq.nextval;

CREATE SEQUENCE dib_configuraciofirma_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_configuraciofirma ALTER COLUMN configuraciofirmaid SET DEFAULT dib_configuraciofirma_seq.nextval;

CREATE SEQUENCE dib_configuraciogrup_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_configuraciogrup ALTER COLUMN configuraciogrupid SET DEFAULT dib_configuraciogrup_seq.nextval;

CREATE SEQUENCE dib_estadistica_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_estadistica ALTER COLUMN estadisticaid SET DEFAULT dib_estadistica_seq.nextval;

CREATE SEQUENCE dib_fitxer_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_fitxer ALTER COLUMN fitxerid SET DEFAULT dib_fitxer_seq.nextval;

CREATE SEQUENCE dib_infocustody_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_infocustody ALTER COLUMN infocustodyid SET DEFAULT dib_infocustody_seq.nextval;

CREATE SEQUENCE dib_infosignatura_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_infosignatura ALTER COLUMN infosignaturaid SET DEFAULT dib_infosignatura_seq.nextval;

CREATE SEQUENCE dib_metadada_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_metadada ALTER COLUMN metadadaid SET DEFAULT dib_metadada_seq.nextval;

CREATE SEQUENCE dib_perfil_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_perfil ALTER COLUMN perfilid SET DEFAULT dib_perfil_seq.nextval;

CREATE SEQUENCE dib_perfilusrapp_seq INCREMENT 1 START __XXXXX__;
 ALTER TABLE dib_perfilusrapp ALTER COLUMN perfilusrappid SET DEFAULT dib_perfilusrapp_seq.nextval;

CREATE SEQUENCE dib_plugin_seq INCREMENT 1 START __XXXXX__;
 ALTER TABLE dib_plugin ALTER COLUMN pluginid SET DEFAULT dib_plugin_seq.nextval;

CREATE SEQUENCE dib_plugincridada_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_plugincridada ALTER COLUMN plugincridadaid SET DEFAULT dib_plugincridada_seq.nextval;

CREATE SEQUENCE dib_transaccio_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_transaccio ALTER COLUMN transaccioid SET DEFAULT dib_transaccio_seq.nextval;

CREATE SEQUENCE dib_usuariaplicacio_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_usuariaplicacio ALTER COLUMN usuariaplicacioid SET DEFAULT dib_usuariaplicacio_seq.nextval;

CREATE SEQUENCE dib_usuaripersona_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_usuaripersona ALTER COLUMN usuaripersonaid SET DEFAULT dib_usuaripersona_seq.nextval;

CREATE SEQUENCE dib_traduccio_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_traduccio ALTER COLUMN traduccioid SET DEFAULT dib_traduccio_seq.nextval;

-- ====== NOU CONTEXT DE BACK és digitalibback

UPDATE dib_perfil SET  urlbase=REPLACE(urlbase,'digitalib','digitalibback') where usperfil > 0;
