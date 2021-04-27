﻿

-- 2021-04-21  Actualitzar els PluginsIBScanWeb de la v3.0.0 a la v4.0.0 #129 

UPDATE dib_plugin SET classe=REPLACE(classe, '.plugins.','.pluginsib.') WHERE tipus = 0;

UPDATE dib_plugin SET properties= REPLACE(properties, '.plugins.','.pluginsib.') WHERE tipus = 0;

-- 2021-04-23 Emmagatzemar el codi DIR3 del funcionari habilitat que fa la còpia #125

ALTER TABLE dib_transaccio ADD COLUMN infoscanduplex NUMBER(1);
ALTER TABLE dib_transaccio ADD COLUMN signparamfuncionaridir3 VARCHAR2(100);
COMMENT ON COLUMN dib_transaccio.signparamfuncionaridir3 IS 'Codi DIR3 de l''unitat de la qual depen l''oficina en la que es troba el funcionari.';

ALTER TABLE dib_usuaripersona  ADD COLUMN unitatdir3 VARCHAR2(100);