
-- ---------------------------------------------------------------------
-- 2026/06/08  Integrar amb UtilitatsFirma i fer sistema de plugins #275
-- ---------------------------------------------------------------------

ALTER TABLE dib_apisimple ADD COLUMN descripcio character varying(255);
ALTER TABLE dib_apisimple ADD COLUMN tipus integer NOT NULL DEFAULT 0;
