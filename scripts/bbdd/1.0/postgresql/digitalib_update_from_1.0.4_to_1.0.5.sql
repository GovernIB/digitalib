
-- 2020-09-11 Digitalització Múltiple

CREATE TABLE dib_transmultiple
(
  transmultipleid bigint NOT NULL,
  descripcio character varying(256) NOT NULL,
  fitxerescanejatid bigint,
  CONSTRAINT dib_transmultiple_pk PRIMARY KEY (transmultipleid),
  CONSTRAINT dib_transmul_fitxer_fies_fk FOREIGN KEY (fitxerescanejatid) REFERENCES dib_fitxer (fitxerid) ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER TABLE dib_transaccio
  ADD COLUMN transmultipleid bigint;
ALTER TABLE dib_transaccio
  ADD CONSTRAINT dib_transaccio_transmul_tm_fk FOREIGN KEY (transmultipleid) REFERENCES dib_transmultiple (transmultipleid) ON UPDATE NO ACTION ON DELETE NO ACTION;


create index dib_transaccio_transmulid_fk_i on dib_transaccio (transmultipleid);
create index dib_transmul_fscaned_fk_i on dib_transmultiple (fitxerescanejatid);
create index dib_transmultiple_pk_i on dib_transmultiple (transmultipleid);

