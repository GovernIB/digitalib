
-- 2024/08/20


UPDATE dib_plugin SET classe=REPLACE(classe, 'org.fundaciobit.plugins.', 'org.fundaciobit.pluginsib.');
UPDATE dib_plugin SET classe=REPLACE(classe, 'es.caib.plugins.', 'es.caib.pluginsib.');
UPDATE dib_plugin SET properties=REPLACE(properties, 'es.caib.plugins.', 'es.caib.pluginsib.');
UPDATE dib_plugin SET properties=REPLACE(properties, 'es.caib.digitalib.plugins.', 'es.caib.digitalib.pluginsib.'); 
UPDATE dib_plugin SET properties=REPLACE(properties, 'es.caib.digitalib.plugin.', 'es.caib.digitalib.pluginsib.'); 