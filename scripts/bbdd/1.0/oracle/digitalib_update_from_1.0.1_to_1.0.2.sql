
-- 2020/04/07 

ALTER TABLE dib_transaccio
  ADD infoscanpapersize varchar2(100);
  
ALTER TABLE dib_transaccio
  ADD infoscandatacaptura timestamp;
  
  
CREATE TABLE dib_metadada
(
   metadadaid number(19,0)  DEFAULT dib_digitalib_seq.nextval NOT NULL, 
   transaccioid number(19,0) NOT NULL, 
   nom varchar2(255) NOT NULL,
   valor varchar2(3000) NOT NULL, 
   CONSTRAINT dib_metadada_pk PRIMARY KEY (metadadaid), 
   CONSTRAINT dib_meta_transaccio_trans_fk FOREIGN KEY (transaccioid) REFERENCES dib_transaccio (transaccioid)
);


 -- Es recomanable tenir un index de la clau primaria.
 create index dib_metadada_pk_i on dib_metadada (metadadaid);

 -- Es recomanable tenir un index de la clau forania.
 create index dib_metadada_transaccioid_fk_i on dib_metadada (transaccioid);
 
 