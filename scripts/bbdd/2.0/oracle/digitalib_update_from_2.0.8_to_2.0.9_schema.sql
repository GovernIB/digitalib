
-- ---------------------------------------------------------------------
-- 2026/06/08  Integrar amb UtilitatsFirma i fer sistema de plugins #275
-- ---------------------------------------------------------------------

ALTER TABLE dib_apisimple ADD descripcio VARCHAR2(255);
ALTER TABLE dib_apisimple ADD tipus NUMBER(10) DEFAULT 0 NOT NULL;

