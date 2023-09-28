
-- 2023/09/28 


-- IMPORTANT !!!!!!

-- S'ha de reemplaçar __XXXX__ pel valor de la consulta "select nextval('dib_digitalib_seq');"

CREATE SEQUENCE dib_apisimple_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_apisimple ALTER COLUMN apisimpleid SET DEFAULT nextval('dib_apisimple_seq');

CREATE SEQUENCE dib_auditoria_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_auditoria ALTER COLUMN auditoriaid SET DEFAULT nextval('dib_auditoria_seq');

CREATE SEQUENCE dib_avis_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_avis ALTER COLUMN avisid SET DEFAULT nextval('dib_avis_seq');

CREATE SEQUENCE dib_configuraciofirma_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_configuraciofirma ALTER COLUMN configuraciofirmaid SET DEFAULT nextval('dib_configuraciofirma_seq');

CREATE SEQUENCE dib_configuraciogrup_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_configuraciogrup ALTER COLUMN configuraciogrupid SET DEFAULT nextval('dib_configuraciogrup_seq');

CREATE SEQUENCE dib_estadistica_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_estadistica ALTER COLUMN estadisticaid SET DEFAULT nextval('dib_estadistica_seq');

CREATE SEQUENCE dib_fitxer_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_fitxer ALTER COLUMN fitxerid SET DEFAULT nextval('dib_fitxer_seq');

CREATE SEQUENCE dib_infocustody_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_infocustody ALTER COLUMN infocustodyid SET DEFAULT nextval('dib_infocustody_seq');

CREATE SEQUENCE dib_infosignatura_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_infosignatura ALTER COLUMN infosignaturaid SET DEFAULT nextval('dib_infosignatura_seq');

CREATE SEQUENCE dib_metadada_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_metadada ALTER COLUMN metadadaid SET DEFAULT nextval('dib_metadada_seq');
CREATE SEQUENCE dib_perfil_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_perfil ALTER COLUMN perfilid SET DEFAULT nextval('dib_perfil_seq');

CREATE SEQUENCE dib_perfilusrapp_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_perfilusrapp ALTER COLUMN perfilusrappid SET DEFAULT nextval('dib_perfilusrapp_seq');

CREATE SEQUENCE dib_plugin_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_plugin ALTER COLUMN pluginid SET DEFAULT nextval('dib_plugin_seq');

CREATE SEQUENCE dib_plugincridada_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_plugincridada ALTER COLUMN plugincridadaid SET DEFAULT nextval('dib_plugincridada_seq');

CREATE SEQUENCE dib_transaccio_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_transaccio ALTER COLUMN transaccioid SET DEFAULT nextval('dib_transaccio_seq');

CREATE SEQUENCE dib_usuariaplicacio_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_usuariaplicacio ALTER COLUMN usuariaplicacioid SET DEFAULT nextval('dib_usuariaplicacio_seq');

CREATE SEQUENCE dib_usuaripersona_seq INCREMENT 1 START __XXXXX__;
ALTER TABLE dib_usuaripersona ALTER COLUMN usuaripersonaid SET DEFAULT nextval('dib_usuaripersona_seq');
