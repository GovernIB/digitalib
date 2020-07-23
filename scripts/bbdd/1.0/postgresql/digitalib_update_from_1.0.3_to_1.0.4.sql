
-- 2020/07/21

CREATE TABLE dib_avis
(
   avisid bigint NOT NULL DEFAULT nextval('dib_digitalib_seq'), 
   descripcioid bigint NOT NULL, 
   datainici timestamp without time zone, 
   datafi timestamp with time zone, 
   configgrupid bigint,
   tipus integer NOT NULL,
   bloquejar boolean NOT NULL, 
   CONSTRAINT dib_avis_pk PRIMARY KEY (avisid), 
   CONSTRAINT dib_avis_traduccio_desc_fk FOREIGN KEY (descripcioid) REFERENCES dib_traduccio (traduccioid) ON UPDATE NO ACTION ON DELETE NO ACTION, 
   CONSTRAINT dib_avis_cfggrup_configgrup_fk FOREIGN KEY (configgrupid) REFERENCES dib_configuraciogrup (configuraciogrupid) ON UPDATE NO ACTION ON DELETE NO ACTION
);
 

create index dib_avis_pk_i on dib_avis (avisid);
create index dib_avis_descripcioid_fk_i on dib_avis (descripcioid);
create index dib_avis_configgrupid_fk_i on dib_avis (configgrupid);
