
-- ---------------------------------------------------------------------
-- 2026/06/08  Integrar amb UtilitatsFirma i fer sistema de plugins #275
-- ---------------------------------------------------------------------

INSERT INTO dib_apisimple(apisimpleid, nom, url, username, contrasenya, perfil, configdefirma,descripcio, tipus)
    VALUES (nextval('dib_apisimple_seq'), 'FIRMA EN SERVIDOR VIA API UTILITATSFIRMA V2', '[=SP["es.caib.digitalib.utilitatsfirma.url"]]', '[=SP["es.caib.digitalib.utilitatsfirma.username"]]', '[=SP["es.caib.digitalib.utilitatsfirma.password"]]', 'PROFILE_PADES', 'afirmades-firma', NULL, 1);
