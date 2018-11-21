--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2018-11-16 11:28:19

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = digitalib, pg_catalog;


--
-- TOC entry 1991 (class 0 OID 97838)
-- Dependencies: 173
-- Data for Name: dib_idioma; Type: TABLE DATA; Schema: digitalib; Owner: digitalib
--

INSERT INTO dib_idioma VALUES ('ca', 'Català', true, 0);
INSERT INTO dib_idioma VALUES ('es', 'Castellano', true, 1);

--
-- TOC entry 2005 (class 0 OID 98194)
-- Dependencies: 185
-- Data for Name: dib_apisimple; Type: TABLE DATA; Schema: digitalib; Owner: digitalib
--

INSERT INTO dib_apisimple VALUES (1006, 'API SIMPLE PORTAFIB', 'http://localhost:8080/portafib', 'anadal', 'anadal');


--
-- TOC entry 2004 (class 0 OID 97940)
-- Dependencies: 177
-- Data for Name: dib_perfil; Type: TABLE DATA; Schema: digitalib; Owner: digitalib
--

INSERT INTO dib_perfil VALUES (1005, 'Perfil 1', 'Pefil 1', 1001, NULL, NULL, NULL, 'PERFIL1', 2, 0, 1006);
INSERT INTO dib_perfil VALUES (1008, 'PERFIl 2', 'PERFIL 2', 1001, NULL, NULL, NULL, 'PERFIL2', 2, 0, 1006);


--
-- TOC entry 2003 (class 0 OID 97921)
-- Dependencies: 176
-- Data for Name: dib_plugin; Type: TABLE DATA; Schema: digitalib; Owner: digitalib
--

INSERT INTO dib_plugin VALUES (1000, 'org.fundaciobit.plugins.scanweb.iecisa.IECISAScanWebPlugin', 'es.caib.digitalib.plugins.scanweb.iecisa.debug=false
es.caib.digitalib.plugins.scanweb.iecisa.forcejnlp=false
es.caib.digitalib.plugins.scanweb.iecisa.forcesign=true
es.caib.digitalib.plugins.scanweb.iecisa.closewindowwhenfinish=true', true, 0, 'SIMPLE', 1, 'Escaneig JNLP', 'Escaneig JNLP');
INSERT INTO dib_plugin VALUES (1001, 'es.limit.plugins.scanweb.dynamicwebtwain.DynamicWebTwainScanWebPlugin', 'es.caib.digitalib.plugins.scanweb.dynamicwebtwain.debug=true
es.caib.digitalib.plugins.scanweb.dynamicwebtwain.trial=true
es.caib.digitalib.plugins.scanweb.dynamicwebtwain.productkey=8839E20083E3197244ABA95D2871EA91FCF8675A8CBEA0D5D4B15A95DDD13615CD16425F8AB3FD646331371F3822A86FCD16425F8AB3FD64B150B8F277D15433FCF8675A8CBEA0D520C40B56D470FD8AFCF8675A8CBEA0D51499049EE2B2572AFCF8675A8CBEA0D51263DA85E51DDDE8FCF8675A8CBEA0D5524CE1CDACCA983FFCF8675A8CBEA0D5B7C9CB69F517FE87FCF8675A8CBEA0D5D658A6C0180FDE3BFCF8675A8CBEA0D5B7561C4D3BBF2FAFFCF8675A8CBEA0D521D6B46E0049BE91FCF8675A8CBEA0D58B8E455BAA2491BBFCF8675A8CBEA0D568C5DE7F9604E6A2FCF8675A8CBEA0D5C918038969B9B1F6FCF8675A8CBEA0D587D9F73F5F748E2EFCF8675A8CBEA0D58E441C2602E0E103FCF8675A8CBEA0D5B87CFFA8FF8DE513FCF8675A8CBEA0D5DB33CD75F490C0CAFCF8675A8CBEA0D500D9FF319BD1767130010000


# Podeu trobar el contingut d''aquest directori a https://github.com/GovernIB/pluginsib/tree/pluginsib-1.0/plugins-scanweb/iecisa2-scanweb-plugin/scanner_resources
es.caib.digitalib.plugins.scanweb.dynamicwebtwain.resourcespath=D:/dades/dades/CarpetesPersonals/Programacio/pluginsib-1.0/plugins-scanweb/dynamicwebtwain2/scanner_resources

# Optional
# Versió: Per defecte 12.2. Possibles valors 13.2, 12.2 o 10.2
es.caib.digitalib.plugins.scanweb.dynamicwebtwain.version=12.2', true, 0, 'DWT', 0, 'DynamicWebTwain', 'DynamicWebTwain');
INSERT INTO dib_plugin VALUES (1002, 'org.fundaciobit.plugins.signatureserver.miniappletinserver.MiniAppletInServerSignatureServerPlugin', '# Estructura ha de ser com del tipus [base_dir]\SERVER_MINIAPPLETINSERVER\[USERNAME]\ i dins aquest directori hi ha
# d''haver un fitxer  cert.properties amb dues propietats p12password(contrasenya del fitxer p12) 
# i p12filename(fitxer p12 en el mateix directori)
es.caib.digitalib.plugins.signatureserver.miniappletinserver.base_dir=D:/dades/dades/CarpetesPersonals/ProgramacioPortaFIB2/portafib-2.0-jboss-5.1.0.GA/server/default/deploypassarela/miniappletinserver', true, 1, 'MINIAPPLET_IN_SERVER', NULL, 'Plugin de Firma de Servidor emprant MiniApplet', 'Plugin de Firma de Servidor emprant MiniApplet');
INSERT INTO dib_plugin VALUES (1003, 'org.fundaciobit.plugins.signatureserver.afirmaserver.AfirmaServerSignatureServerPlugin', '# Obligatiori. Aplicació definida dins "Gestión de Aplicaciones" de @firma federat, on
# en l''apartat ''Parametros de la aplicación'' en el camp "Política de TimeStamp" té
# definit el valor "Sin TimeStamp" 
es.caib.digitalib.plugins.signatureserver.afirmaserver.applicationID=appPrueba
# Opcional. Aplicació definida dins "Gestión de Aplicaciones" de @firma federat, on 
# en l''apartat ''Parametros de la aplicación'' en el camp "Política de TimeStamp" té definit
# el valor "Con TimeStamp". Si aquest valor no està definit llavors no es poden
# fer firmes amb segell de temps.
es.caib.digitalib.plugins.signatureserver.afirmaserver.applicationID_TimeStamp=appPruebaTS

# Si signaturesSet.getCommonInfoSignature().getUsername() es null, llavors
# s''utilitza aquest valor com a sistema de selecció del certificat amb el que firmar
es.caib.digitalib.plugins.signatureserver.afirmaserver.defaultAliasCertificate=serversigner

es.caib.digitalib.plugins.signatureserver.afirmaserver.TransformersTemplatesPath=D:/dades/dades/CarpetesPersonals/ProgramacioPortaFIB2/portafib-2.0/pluginsib-signatureserver/afirmaserver/config/transformersTemplates

#Propiedades para la invocación de los servicios de la aplicación de @Firma
#Propiedades de comunicacion con el repositorio de servicios
#secureMode -> Posibles valores: true / false. 
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.secureMode=false
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.endPoint=localhost:9090
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.servicePath=afirmaws/services
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.callTimeout=20000000
#Valores posibles para esta propiedad: none, UsernameToken y BinarySecurityToken
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.authorizationMethod=UsernameToken
#Usuario o alias certificado
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.authorizationMethod.user=user
#Password del usuario o de la clave privada del certificado
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.authorizationMethod.password=12345
#Solo en caso de usuario y password: clear o digest
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.authorizationMethod.passwordType=digest
#Ruta al almacén donde se encuentran los certificados firmantes de la peticion
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.authorizationMethod.userKeystore=
#Password del almacén anterior
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.authorizationMethod.userKeystorePassword=
#Tipo del almacen anterior: JKS, PKCS12, JCEKS
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.authorizationMethod.userKeystoreType=
#Valida la respuesta firmada de @Firma. Posibles valores true/false.
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.response.validate=false
#Alias de certificado usado en la valiación de las respuestas
es.caib.digitalib.plugins.signatureserver.afirmaserver.connection.response.certificateAlias=', true, 1, 'AFIRMA_FEDERAT', 1, 'Plugin de Firma en Servidor emprant @firma federat', 'Plugin de Firma en Servidor emprant @firma federat');
INSERT INTO dib_plugin VALUES (1004, 'org.fundaciobit.plugin.signatureserver.afirmalibs.AfirmaLibsSignatureServerPlugin', '# Estructura ha de ser com del tipus [base_dir]\AFIRMALIBS_CERTS\[USERNAME]\ i dins aquest directori hi ha
# d''haver un fitxer cert.properties que ha de definir l''accés a un p12 o un jks:
#       * JKS:  - jksfilename=anadal.jks
#               - jkskeystorepassword=anadal1234
#               - jkscertpassword=mycertpass
#               - jksalias=anadalalias
#
#       * P12:  - p12filename=(nom del fitxer p12 en el mateix directori)
#               - p12password=(contrasenya del fitxer p12) 
es.caib.digitalib.plugins.signatureserver.afirmalibs.base_dir=D:/dades/dades/CarpetesPersonals/ProgramacioPortaFIB2/portafib-2.0/pluginsib-signatureserver/afirmalibs

# Si signaturesSet.getCommonInfoSignature().getUsername() es null, llavors
# s''utilitza aquest valor com a sistema de selecció del certificat amb el que firmar
es.caib.digitalib.plugins.signatureserver.afirmalibs.defaultAliasCertificate=anadaljks

# Per desenvolupament
es.caib.digitalib.plugins.signatureserver.afirmalibs.debug=true', true, 1, 'AFIRMA_LIBS', 2, 'Plugin de Firma en Servidor emprant llibreries de @firma', 'Plugin de Firma en Servidor emprant llibreries de @firma');


-- Completed on 2018-11-16 11:28:19

--
-- PostgreSQL database dump complete
--

