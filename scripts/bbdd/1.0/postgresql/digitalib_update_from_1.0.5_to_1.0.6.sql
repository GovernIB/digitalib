

-- 2021-04-21  Actualitzar els PluginsIBScanWeb de la v3.0.0 a la v4.0.0 #129 

UPDATE dib_plugin SET classe=REPLACE(classe, '.plugins.','.pluginsib.') WHERE tipus = 0;

UPDATE dib_plugin SET properties= REPLACE(properties, '.plugins.','.pluginsib.') WHERE tipus = 0;
