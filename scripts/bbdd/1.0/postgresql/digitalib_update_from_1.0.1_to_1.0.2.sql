
-- 2020/04/07 

ALTER TABLE dib_transaccio
  ADD COLUMN infoscanpapersize character varying(100);
  
ALTER TABLE dib_transaccio
  ADD COLUMN infoscandatacaptura timestamp without time zone;
  
  
CREATE TABLE dib_metadada
(
   metadadaid bigint NOT NULL DEFAULT nextval('dib_digitalib_seq'), 
   transaccioid bigint NOT NULL, 
   nom character varying(255) NOT NULL, 
   valor character varying(3000) NOT NULL, 
   CONSTRAINT dib_metadada_pk PRIMARY KEY (metadadaid), 
   CONSTRAINT dib_meta_transaccio_trans_fk FOREIGN KEY (transaccioid) REFERENCES dib_transaccio (transaccioid) ON UPDATE NO ACTION ON DELETE NO ACTION
);


 -- Es recomanable tenir un index de la clau primaria.
 create index dib_metadada_pk_i on dib_metadada (metadadaid);

 -- Es recomanable tenir un index de la clau forania.
 create index dib_metadada_transaccioid_fk_i on dib_metadada (transaccioid);
 
 