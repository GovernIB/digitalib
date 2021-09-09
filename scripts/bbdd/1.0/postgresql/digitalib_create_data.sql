--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2019-01-30 11:30:10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = digitalib, pg_catalog;


INSERT INTO dib_apisimple(apisimpleid, nom, url, username, contrasenya, perfil) VALUES (1006, 'API SIMPLE PORTAFIB', 'http://portafib2.fundaciobit.org/portafib/common/rest/apifirmaenservidorsimple/v1/', 'userapp', 'mypass', 'PROFILE');



INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (1002, 'org.fundaciobit.plugins.signatureserver.miniappletinserver.MiniAppletInServerSignatureServerPlugin', '# PROPERTIES

# Estructura ha de ser com del tipus [base_dir]\SERVER_MINIAPPLETINSERVER\[USERNAME]\ i dins aquest directori hi ha
# d''haver un fitxer  cert.properties amb dues propietats p12password(contrasenya del fitxer p12) 
# i p12filename(fitxer p12 en el mateix directori)
es.caib.digitalib.plugins.signatureserver.miniappletinserver.base_dir=D:/dades/dades/CarpetesPersonals/ProgramacioPortaFIB2/portafib-2.0/pluginsib-signatureserver/miniappletinserver

# Si signaturesSet.getCommonInfoSignature().getUsername() es null, llavors
# s''utilitza aquest valor com a sistema de selecció del certificat amb el que firmar
es.caib.digitalib.plugins.signatureserver.miniappletinserver.defaultAliasCertificate=anadaljks', true, 1, 'SIGN_MINIAPPLET_IN_SERVER', NULL, 'Plugin de Firma de Servidor emprant MiniApplet', 'Plugin de Firma de Servidor emprant MiniApplet');
INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (1001, 'es.limit.pluginsib.scanweb.dynamicwebtwain.DynamicWebTwainScanWebPlugin', 'es.caib.digitalib.pluginsib.scanweb.dynamicwebtwain.debug=true
es.caib.digitalib.pluginsib.scanweb.dynamicwebtwain.trial=true
es.caib.digitalib.pluginsib.scanweb.dynamicwebtwain.productkey=8839E20083E3197244ABA95D2871EA91FCF8675A8CBEA0D5D4B15A95DDD13615CD16425F8AB3FD646331371F3822A86FCD16425F8AB3FD64B150B8F277D15433FCF8675A8CBEA0D520C40B56D470FD8AFCF8675A8CBEA0D51499049EE2B2572AFCF8675A8CBEA0D51263DA85E51DDDE8FCF8675A8CBEA0D5524CE1CDACCA983FFCF8675A8CBEA0D5B7C9CB69F517FE87FCF8675A8CBEA0D5D658A6C0180FDE3BFCF8675A8CBEA0D5B7561C4D3BBF2FAFFCF8675A8CBEA0D521D6B46E0049BE91FCF8675A8CBEA0D58B8E455BAA2491BBFCF8675A8CBEA0D568C5DE7F9604E6A2FCF8675A8CBEA0D5C918038969B9B1F6FCF8675A8CBEA0D587D9F73F5F748E2EFCF8675A8CBEA0D58E441C2602E0E103FCF8675A8CBEA0D5B87CFFA8FF8DE513FCF8675A8CBEA0D5DB33CD75F490C0CAFCF8675A8CBEA0D500D9FF319BD1767130010000


# Podeu trobar el contingut d''aquest directori a https://github.com/GovernIB/pluginsib/tree/pluginsib-1.0/plugins-scanweb/iecisa2-scanweb-plugin/scanner_resources
es.caib.digitalib.pluginsib.scanweb.dynamicwebtwain.resourcespath=D:/dades/dades/CarpetesPersonals/Programacio/pluginsib-1.0/plugins-scanweb/dynamicwebtwain2/scanner_resources

# Optional
# Versió: Per defecte 12.2. Possibles valors 13.2, 12.2 o 10.2
es.caib.digitalib.pluginsib.scanweb.dynamicwebtwain.version=12.2', true, 0, 'SCAN_DWT', 0, 'DynamicWebTwain', 'DynamicWebTwain');
INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (1000, 'org.fundaciobit.pluginsib.scanweb.iecisa.IECISAScanWebPlugin', 'es.caib.digitalib.pluginsib.scanweb.iecisa.debug=false
es.caib.digitalib.pluginsib.scanweb.iecisa.forcejnlp=false
es.caib.digitalib.pluginsib.scanweb.iecisa.closewindowwhenfinish=true', true, 0, 'SCAN_JNLP', 1, 'Escaneig JNLP', 'Escaneig JNLP');
INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (1004, 'org.fundaciobit.plugin.signatureserver.afirmalibs.AfirmaLibsSignatureServerPlugin', '# Estructura ha de ser com del tipus [base_dir]\AFIRMALIBS_CERTS\[USERNAME]\ i dins aquest directori hi ha
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
es.caib.digitalib.plugins.signatureserver.afirmalibs.debug=true', true, 1, 'SIGN_AFIRMA_LIBS', 2, 'Plugin de Firma en Servidor emprant llibreries de @firma', 'Plugin de Firma en Servidor emprant llibreries de @firma');
INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (1234, 'org.fundaciobit.pluginsib.scanweb.file.FileScanWebPlugin', NULL, true, 0, 'SCAN_FILE', 2, 'Seleccio Fitxer', 'Seleccio Fitxer');
INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (1003, 'org.fundaciobit.plugins.signatureserver.afirmaserver.AfirmaServerSignatureServerPlugin', '# Classe org.fundaciobit.plugins.signatureserver.afirmaserver.AfirmaServerSignatureServerPlugin

# Obligatiori. Aplicació definida dins "Gestión de Aplicaciones" de @firma federat, on
# en l''apartat ''Parametros de la aplicación'' en el camp "Política de TimeStamp" té
# definit el valor "Sin TimeStamp" 
es.caib.digitalib.plugins.signatureserver.afirmaserver.applicationID=CAIBDEV.FBIT
# Opcional. Aplicació definida dins "Gestión de Aplicaciones" de @firma federat, on 
# en l''apartat ''Parametros de la aplicación'' en el camp "Política de TimeStamp" té definit
# el valor "Con TimeStamp". Si aquest valor no està definit llavors no es poden
# fer firmes amb segell de temps (No suporta  PAdES-T).
es.caib.digitalib.plugins.signatureserver.afirmaserver.applicationID_TimeStamp=CAIBDEV.FBITST

# Si signaturesSet.getCommonInfoSignature().getUsername() es null, llavors
# s''utilitza aquest valor com a sistema de selecció del certificat amb el que firmar
es.caib.digitalib.plugins.signatureserver.afirmaserver.defaultAliasCertificate=dummycert

es.caib.digitalib.plugins.signatureserver.afirmaserver.TransformersTemplatesPath=D:/dades/dades/CarpetesPersonals/ProgramacioPortaFIB2/portafib-2.0/pluginsib-signatureserver/afirmaserver/config/transformersTemplates


es.caib.digitalib.plugins.signatureserver.afirmaserver.ignoreservercertificates=true

es.caib.digitalib.plugins.signatureserver.afirmaserver.debug=false
es.caib.digitalib.plugins.signatureserver.afirmaserver.printxml=false


#Propiedades de comunicacion con el repositorio de servicios
es.caib.digitalib.plugins.signatureserver.afirmaserver.ignoreservercertificates=true
es.caib.digitalib.plugins.signatureserver.afirmaserver.endpoint=https://afirmades.caib.es:4430/afirmaws/services/DSSAfirmaSign
es.caib.digitalib.plugins.signatureserver.afirmaserver.endpoint_upgrade=https://afirmades.caib.es:4430/afirmaws/services/DSSAfirmaVerify

# USERNAME-PASSWORD Token
es.caib.digitalib.plugins.signatureserver.afirmaserver.authorization.username=fbit
#userTest
es.caib.digitalib.plugins.signatureserver.afirmaserver.authorization.password=fbit
#12345

# CERTIFICATE Token
es.caib.digitalib.plugins.signatureserver.afirmaserver.authorization.ks.path=D:/dades/dades/proves-dgidt.jks
#D:/dades/dades/CarpetesPersonals/Programacio/PortaFIB/plugins/plugins-certificate/afirma/proves-dgidt.jks
es.caib.digitalib.plugins.signatureserver.afirmaserver.authorization.ks.type=JKS
es.caib.digitalib.plugins.signatureserver.afirmaserver.authorization.ks.password=<<PASSWORD>>
es.caib.digitalib.plugins.signatureserver.afirmaserver.authorization.ks.cert.alias=1
es.caib.digitalib.plugins.signatureserver.afirmaserver.authorization.ks.cert.password=<<PASSWORD>>', true, 1, 'SIGN_AFIRMA_FEDERAT', 1, 'Plugin de Firma en Servidor emprant @firma federat', 'Plugin de Firma en Servidor emprant @firma federat');
INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (2096, 'org.fundaciobit.plugins.timestamp.afirmaclientetsarfc.AfirmaClienteTsaRfcTimeStampPlugin', '#################################################
#Configuracion para el cliente TSA Java solo RFC#
#################################################
#Identificador de la aplicación cliente
es.caib.digitalib.plugins.timestamp.afirmarfc.applicationid=appID


#OID politica de timestamping de la TSA del MINHAP
es.caib.digitalib.plugins.timestamp.afirmarfc.oid_rfc3161=2.16.724.1.3.1.1.4.2.1.2


es.caib.digitalib.plugins.timestamp.afirmarfc.hashalgorithm=SHA-512


#####################################################################
#Configuracion autenticacion al servicio RFC3161+HTTPS (puerto 8443)#
#####################################################################

#URL para la conexion al servicio RFC3161 + HTTPS (puerto 8443)
#es.caib.digitalib.plugins.timestamp.afirmarfc.url_rfc=https://des-tsafirma.redsara.es:8443/tsamap/TspHttpServer
es.caib.digitalib.plugins.timestamp.afirmarfc.url_rfc=https://tsafirma.redsara.es:8443/tsamap/TspHttpServer

#Ruta y clave del certificado para la autenticacion del servicio RFC3161 + HTTPS
#Este certificado debe ser el certificado de autenticacion HTTPS cliente dado de alta para su aplicacion para el servicio RFC3161 + HTTPS (partes publica y privada)
es.caib.digitalib.plugins.timestamp.afirmarfc.auth.cert.p12.path=D:/dades/dades/CarpetesPersonals/Programacio/portafib-files/afirma/nou/keystore.p12
es.caib.digitalib.plugins.timestamp.afirmarfc.auth.cert.p12.password=x7E7f9vU8QH8


#####################################################################
# Certificados de Servidor Aceptados RFC3161+HTTPS  (Opcional)      #
#####################################################################

#Configuracion general de confianza para los servicios por HTTPS: RFC3161+HTTPS (puerto 8443)
#Este certificado debe ser el certificado SSL de servidor la TSA (parte publica)
es.caib.digitalib.plugins.timestamp.afirmarfc.server.trustkeystore.path=D:\\dades\\dades\\CarpetesPersonals\\ProgramacioPortaFIB2\\pluginsib-timestamp\\afirmarfc-cliente_tsa_rfc\\trustkeystore\\truststore.jks
es.caib.digitalib.plugins.timestamp.afirmarfc.server.trustkeystore.password=123456789', true, 4, 'TIME_AFIRMATS', 1, 'Afirma TS@', 'Afirma TS@');
INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (1413, 'org.fundaciobit.plugins.documentcustody.arxiudigitalcaib.ArxiuDigitalCAIBDocumentCustodyPlugin', '# --------------------------------------------------
# Específiques org.fundaciobit.plugins.documentcustody.arxiudigitalcaib.ArxiuDigitalCAIBDocumentCustodyPlugin

# Requerit. Nom de l''''expedient. Important: Ha de ser únic
# Exemple 1 Expedient_${.now?string[\"yyyyMMddHHmmss\"]}
# Exemple 2 Registre_<#if registro.origen??>S<#else>E</#if>_${registro.libro.codigo}_${.now?string[\"yyyy\"]}_${registro.numeroRegistro?string[\"0000000\]"}  
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.nom_expedient_EL=DigitalIB_${transaccio.transactionWebId}

# Opcional. Nom de la carpeta dins de l''''expedient. 
# Si carpeta no està definida llavors custodyID = {uuid_expedient}#{uuid_document}
# Si carpeta està definida llavors custodyID =  {uuid_expedient}#{uuid_carpeta}#{uuid_document}
# es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.nom_carpeta_EL=Anexo_${anexo.id?string[\"000\"]}

# Opcional. Per defecte sempre es crea Draft
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.createDraft_EL=false

# Opcional. Tanca l''''expedient despres del primer guardat. Requereix "createDraft_EL=false" 
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.tancarExpedient_EL=true

# Opcional. Si val false cerca si existeixen Expedients amb el mateix nom i els usa per 
# guardar documents. Default value false.
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.searchifexpedientexistsinreserve=false
           

# Opcional
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.debug=true


# =================  DADES CONNEXIO ========================

#DES
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.url=https://afirmades.caib.es:4430/esb
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.login.username=username
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.login.password=password

#PRE
#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.url=https://esbpre.caib.es/
#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.login.username=username_gdib
#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.login.password=password_gdib

#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.login.username=username_gdib
#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.login.password=password_gdib


es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.ignore_server_certificates=true

es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.codi_aplicacio=Tests

es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.organitzacio=CAIB

# Ciutada (opcional)
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.solicitant.nom_EL=${transaccio.arxiuReqParamCiutadaNom}
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.solicitant.identificador_administratiu_EL=${transaccio.arxiuReqParamCiutadaNif}


# Treballador (opcional)
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.usuari.username_EL=${transaccio.funcionariUsername}
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.usuari.identificador_administratiu_EL=${transaccio.signParamFuncionariNif}

# Nom procediment (opcional)
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.connexio.nom_procediment_EL=<#if transaccio.arxiuOptParamProcedimentNom?? >${transaccio.arxiuOptParamProcedimentNom}<#else>Subvenciones empleo</#if>


# =================  METADADES OBLIGATORIES COMUNS ========================

# DES
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.serie_documental_EL=<#if transaccio.arxiuOptParamSerieDocumental?? >${transaccio.arxiuOptParamSerieDocumental}<#else>S0001</#if>

#PRE
#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.serie_documental_EL=FBIT

#  Separats per comma
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.organs_EL=${transaccio.arxiuReqParamOrgans}

# ADMINISTRACION=1 //  CIUDADANO=0
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.origen_document_EL=${transaccio.arxiuReqParamOrigen}


# =================  METADADES OBLIGATORIES EXPEDIENT ========================

# També inclou "Codigo Aplicacion" definit a la propietat "connexio.codi_aplicacio"

es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.codi_procediment_EL=<#if transaccio.arxiuOptParamProcedimentCodi?? >${transaccio.arxiuOptParamProcedimentCodi}<#else>organo1_PRO_123456789</#if>

# Es crearà amb data de cridada a guardar
#es.caib.regweb3.plugins.documentcustody.arxiudigitalcaib.data_creacio_expedient_EL =<#setting time_zone=''''UTC''''>${(registro.fecha)?string[\"yyyy-MM-dd''''T''''HH:mm:ss.sss''''Z''''\"]}


# =================  METADADES OBLIGATORIES DOCUMENT ========================

# També inclou "Codigo Aplicacion" definit a la propietat "connexio.codi_aplicacio"

# EE01,EE02, EE03, EE04, EE99
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.estat_elaboracio_EL=${transaccio.arxiuReqParamDocEstatElabora}



# TIPO_DOC_ENI: TD01, TD02, TD03, ...
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.tipus_documental_EL=${transaccio.arxiuReqParamDocumentTipus}

# Només es processa quan s''''envia una firma
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.perfil_firma_EL=${transaccio.infoSignatura.eniPerfilFirma}

es.caib.regweb3.plugins.documentcustody.arxiudigitalcaib.data_creacio_document_EL=<#setting time_zone=''''UTC''''>${.now?string[\"yyyy-MM-dd''''T''''HH:mm:ss.sss''''Z''''\"]}

# --------------------------------------------------
# Genèriques


# Opcional. Configuració per generar Hash de la baseurl quan s''''usa ${validationUrl_custodyID_Hash}
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.hash.password=mypass
# Opcional. Configuració per generar Hash de la baseurl quan s''''usa ${validationUrl_custodyID_Hash}
#  MD2, MD5, SHA,SHA-256,SHA-384,SHA-512
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.hash.algorithm=MD5

# Retorna una URL que apunta a la versió original del document
# Opcional. Servei Millorat per generar la URL de Custodia emprant EL.
# Variables addicionals: csv, validationUrl_custodyID, validationUrl_custodyID_URLEncode i validationUrl_custodyID_Hash
# No funciona   
# es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.baseurl_EL=https://dev.caib.es/concsv/rest/original/${csv}

# Opcional.Retorna una URL que apunta a la versió imprimible del document
# Valors de substitució:  
# ${custodyID} => custodyID | ${custodyID_URLEncode} => URLEncode(custodyID) | ${custodyID_Hash} => Hash(custodyID)
# No funciona
# es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.printable_file_url_EL=https://dev.caib.es/concsv/rest/printable/${csv} 

# Opcional.Retorna una URL que apunta a la versió ENI del document
# Valors de substitució:  
# ${custodyID} => custodyID | ${custodyID_URLEncode} => URLEncode(custodyID) | ${custodyID_Hash} => Hash(custodyID)
# No funciona
# es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.eni_file_url_EL=https://dev.caib.es/concsv/enidoc/${csv}

# Web on es pot validar el CSV
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.csv_validation_web_EL=http://dev.caib.es/concsv

# Opcional. URL al document on s''''explica com s''''ha generat el CSV. Si no es defineix retornarà null. 
# Desconegut
# es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.csv_generation_definition=

#  Retorna una plana web de validacio del document
# Valors de substitució:  
# ${custodyID} => custodyID | ${custodyID_URLEncode} => URLEncode(custodyID) | ${custodyID_Hash} => Hash(custodyID)
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.validation_file_url_EL=https://dev.caib.es/concsv/hash/${csv}



# Opcional. Si no definit retorna el custodyID
# Variables addicionals: csv
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.specialValue_EL=${transaccio.transaccioID}

# ----------------------------------------------
# Opcional. Metadades Automàtiques per Expedient
# Nota: Només es permeten les definides en la classe es.caib.arxiudigital.apirest.constantes.MetadatosExpediente

es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.expedient.automaticmetadata_items=

#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.expedient.automatic_metadata.1.name=eni:descripcion
#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.expedient.automatic_metadata.1.valueEL=${registro.numeroRegistro?c} / ${registro.numeroRegistroFormateado}

#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.expedient.automatic_metadata.2.name=eni:termino_punto_acceso
#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.expedient.automatic_metadata.2.valueEL=Justificant


# ----------------------------------------------
# Opcional. Metadades Automàtiques per Document Electrònic
# Nota: Només es permeten les definides en la classe es.caib.arxiudigital.apirest.constantes.MetadatosDocumento

es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.documentelectronic.automaticmetadata_items=2

#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.documentelectronic.automatic_metadata.1.name=eni:descripcion
#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.documentelectronic.automatic_metadata.1.valueEL=${anexo.id} - ${anexo.titulo}

es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.documentelectronic.automatic_metadata.2.name=eni:origen
es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.documentelectronic.automatic_metadata.2.valueEL=${transaccio.arxiuReqParamOrigen}


# Propietats NOMES PER DIGITALIB

arxiuOptParamProcedimentCodi=organo1_PRO_123456789
arxiuOptParamProcedimentNom=Subvenciones empleo
arxiuOptParamSerieDocumental=S0001', true, 2, 'DOCCUST_ARXIU_CAIB', 2, 'Document Custody Arxiu CAIB', 'Document Custody Arxiu CAIB');
INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (1274, 'org.fundaciobit.plugins.documentcustody.filesystem.FileSystemDocumentCustodyPlugin', '#Class: org.fundaciobit.plugins.documentcustody.filesystem.FileSystemDocumentCustodyPlugin

# --------------------------------------------------
# Específiques  FileSystemDocumentCustodyPlugin 

# Requerit
es.caib.digitalib.plugins.documentcustody.filesystem.basedir=D:\\dades\\dades\\CarpetesPersonals\\ProgramacioPortaFIB2\\portafib-2.0-jboss-5.1.0.GA\\server\\default\\deploydigitalib\\custodiadigitalib.war



# --------------------------------------------------
# Generiques  AbstractDocumentCustodyPlugin (veure projecte /plugin-documentcustody-api per a altres propietats)

# Informació de ExpressionLanguage: http://freemarker.org/docs/ref_directives.html

# Opcional. Servei per generar la URL de Custodia. Si no es defineix retornarà null. 
# {0} => custodyID // {1} => URLEncode(custodyID) // {2} => Hash(custodyID)
es.caib.digitalib.plugins.documentcustody.filesystem.baseurl=http://10.215.216.175:8080/custodiadigitalib/index.jsp?hash={2}

# Opcional. Configuració per generar Hash de la baseurl quan {2}
es.caib.digitalib.plugins.documentcustody.filesystem.hash.password=mypass
#  MD2, MD5, SHA,SHA-256,SHA-384,SHA-512
es.caib.digitalib.plugins.documentcustody.filesystem.hash.algorithm=MD5

# Retorna una URL que apunta a la versió original del document
# Opcional. Servei Millorat per generar la URL de Custodia emprant EL.
# Variables adicionals: validationUrl_custodyID, validationUrl_custodyID_URLEncode i validationUrl_custodyID_Hash   
#es.caib.digitalib.plugins.documentcustody.filesystem.baseurl_expressionlanguage=


# Opcional.Retorna una URL que apunta a la versió imprimible del document
# Valors de substitució:  
# ${custodyID} => custodyID | ${custodyID_URLEncode} => URLEncode(custodyID) | ${custodyID_Hash} => Hash(custodyID)
# es.caib.digitalib.plugins.documentcustody.filesystem.printable_file_url_expressionlanguage=http://10.215.216.175:8080/custodiadigitalib/printable/${registre.url}

# Opcional.Retorna una URL que apunta a la versió ENI del document
# Valors de substitució:  
# ${custodyID} => custodyID | ${custodyID_URLEncode} => URLEncode(custodyID) | ${custodyID_Hash} => Hash(custodyID)
# es.caib.digitalib.plugins.documentcustody.filesystem.eni_file_url_expressionlanguage=http://10.215.216.175:8080/custodiadigitalib/eni/${registre.url}

# Opcional. Servei per generar el CSV. Si no es defineix retornarà null. 
# Als paràmetres se li afegeixen tres variables més:
#    + "custodyID" => custodyID
#    + "custodyID_URLEncode" => URLEncode(custodyID)
#    + "custodyID_Hash" => Hash(custodyID)
es.caib.digitalib.plugins.documentcustody.filesystem.csv_expressionlanguage=${custodyID_Hash}

# Web on es pot validar el CSV
#es.caib.digitalib.plugins.documentcustody.arxiudigitalcaib.csv_validation_web_expressionlanguage=http://10.215.216.175:8080/custodiadigitalib/index.jsp

# Opcional. URL al document on s''explica com s''ha generat el CSV. Si no es defineix retornarà null. 
# es.caib.digitalib.plugins.documentcustody.filesystem.csv_generation_definition=http://10.215.216.175:8080/custodiadigitalib/csv_generation.odt

# Opcional. Si no definit retorna custodyID
# es.caib.digitalib.plugins.documentcustody.filesystem.specialValue_EL=${registre.id}

# Opcional. Serveix per generar els CustodyID a partir d''una EL 
#es.caib.digitalib.plugins.documentcustody.filesystem.generate_custodyid_expressionlanguage=${registre.id}

# Opcional. Prefix a afegir al nom dels fitxers creats
es.caib.digitalib.plugins.documentcustody.filesystem.prefix=

# Opcional. L''Exemple següent crea estructures del tipus /1971/08/12/Entrada/123455
#es.caib.digitalib.plugins.documentcustody.filesystem.folder_expressionlanguage=${registre.data?string["yyyy/MM/dd"]}/<#if  registre.origen??>Salida<#else>Entrada</#if>/${registre.id}/

# Opcional. Metadades Automàtiques
es.caib.digitalib.plugins.documentcustody.filesystem.automaticmetadata_items=1

es.caib.digitalib.plugins.documentcustody.filesystem.automatic_metadata.1.name=eni:v_nti
es.caib.digitalib.plugins.documentcustody.filesystem.automatic_metadata.1.valueEL=http://administracionelectronica.gob.es/ENI/XSD/v1.0/documento-e

#es.caib.digitalib.plugins.documentcustody.filesystem.automatic_metadata.2.name=eni:origen
#es.caib.digitalib.plugins.documentcustody.filesystem.automatic_metadata.2.valueEL=${registre.origen}

# 1=Administracion || 0=Ciudadano
#es.caib.digitalib.plugins.documentcustody.filesystem.automatic_metadata.22.name=eni:origenStr
#es.caib.digitalib.plugins.documentcustody.filesystem.automatic_metadata.22.valueEL=<#if registre.origen == 1>Administracion<#elseif registre.origen == 0>Ciudadano<#else>DESCONEGUT ${registre.origen}</#if>

#es.caib.digitalib.plugins.documentcustody.filesystem.automatic_metadata.3.name=eni:estado_elaboracion
#es.caib.digitalib.plugins.documentcustody.filesystem.automatic_metadata.3.valueEL=${registre.estadoElaboracion}

# XYZ ZZZ Posar if per si val null
#es.caib.digitalib.plugins.documentcustody.filesystem.automatic_metadata.4.name=eni:tipo_doc_ENI
#es.caib.digitalib.plugins.documentcustody.filesystem.automatic_metadata.4.valueEL=${transaccio.infoSignatura.eniTipoFirma}', true, 2, 'DOCCUST_FILESYSTEM', 10, 'Custòdia en Sistema de Fitxers', 'Custòdia en Sistema de Fitxers');
INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (2192, 'org.fundaciobit.plugins.timestamp.catcertrfc.CatCertRfcTimeStampPlugin', 'es.caib.digitalib.plugins.timestamp.catcertrfc.url_rfc=http://psis.catcert.net/psis/catcert/tsp
es.caib.digitalib.plugins.timestamp.catcertrfc.oid_rfc3161=0.4.0.2023.1.1
es.caib.digitalib.plugins.timestamp.catcertrfc.hashalgorithm=SHA-512', true, 4, 'TIME_CATCERT', 2, 'Segellador de Temps de CatCert', 'Segellador de Temps de CatCert');
INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (1307, 'es.caib.plugins.arxiu.caib.ArxiuPluginCaib', '# Class es.caib.plugins.arxiu.caib.ArxiuPluginCaib

es.caib.digitalib.plugin.arxiu.caib.base.url=https://afirmades.caib.es:4430/esb
#es.caib.digitalib.plugin.arxiu.caib.base.url=https://esbpre.caib.es/esb
es.caib.digitalib.plugin.arxiu.caib.aplicacio.codi=Tests
es.caib.digitalib.plugin.arxiu.caib.usuari=username
es.caib.digitalib.plugin.arxiu.caib.contrasenya=password
es.caib.digitalib.plugin.arxiu.caib.conversio.imprimible.url=https://proves.caib.es/concsv/rest/printable/uuid
es.caib.digitalib.plugin.arxiu.caib.conversio.imprimible.usuari=USUARI
es.caib.digitalib.plugin.arxiu.caib.conversio.imprimible.contrasenya=PASSWD


# No funciona
# es.caib.digitalib.plugin.arxiu.caib.original_file_url_EL=https://dev.caib.es/concsv/rest/original/${csv}

# No funciona
# es.caib.digitalib.plugin.arxiu.caib.printable_file_url_EL=https://dev.caib.es/concsv/rest/printable/${csv} 

# No funciona
# es.caib.digitalib.plugin.arxiu.caib.eni_file_url_EL=https://dev.caib.es/concsv/enidoc/${csv}

es.caib.digitalib.plugin.arxiu.caib.csv_validation_web_EL=http://dev.caib.es/concsv

# Valor Desconegut
#es.caib.digitalib.plugin.arxiu.caib.csv_generation_definition=

es.caib.digitalib.plugin.arxiu.caib.validation_file_url_EL=https://dev.caib.es/concsv/hash/${csv}

# NOMES PER DIGITALIB

arxiuOptParamProcedimentCodi=organo1_PRO_123456789
arxiuOptParamProcedimentNom=Subvenciones empleo
arxiuOptParamSerieDocumental=S0001', true, 3, 'ARXIU_CAIB', 1, 'Arxiu CAIB', 'Arxiu CAIB');
INSERT INTO dib_plugin(pluginid, classe, properties, actiu, tipus, codi, ordre, nom, descripcio) VALUES (2204, 'org.fundaciobit.plugins.documentcustody.alfresco.base.AlfrescoBaseDocumentCustodyPlugin', '# CLASS: org.fundaciobit.plugins.documentcustody.alfresco.base.AlfrescoBaseDocumentCustodyPlugin

# --------------------------------------------------
# ALFRESCO: Especific

# WS or ATOM
es.caib.digitalib.plugins.documentcustody.alfresco.access.method=ATOM
 
# Depends of Method and Alfresco version (alfresco 5)
es.caib.digitalib.plugins.documentcustody.alfresco.url=http://localhost:9080/alfresco/api/-default-/public/cmis/versions/1.0/atom

es.caib.digitalib.plugins.documentcustody.alfresco.access.user=anadal
es.caib.digitalib.plugins.documentcustody.alfresco.access.pass=anadal
      
es.caib.digitalib.plugins.documentcustody.alfresco.basepath=/test
 
# Only for WS
# es.caib.digitalib.plugins.documentcustody.alfresco.repository", "b886bad2-998d-4674-a120-1fcc2f1f533c"); //"USER_HOMES/anadal/test/");

# Only for ATOM: Elegir una de les dues
es.caib.digitalib.plugins.documentcustody.alfresco.site=ODES
#es.caib.digitalib.plugins.documentcustody.alfresco.site=test
#es.caib.digitalib.plugins.documentcustody.alfresco.fullsitepath=/Sites/ODES/documentLibrary


# --------------------------------------------------
# Generiques  AbstractDocumentCustodyPlugin (veure projecte /plugin-documentcustody-api per a altres propietats)

# Informació de ExpressionLanguage: http://freemarker.org/docs/ref_directives.html

# Opcional. Servei per generar la URL de Custodia. Si no es defineix retornarà null. 
# {0} => custodyID // {1} => URLEncode(custodyID) // {2} => Hash(custodyID)
#es.caib.digitalib.plugins.documentcustody.alfresco.baseurl=

# Opcional. Configuració per generar Hash de la baseurl quan {2}
es.caib.digitalib.plugins.documentcustody.alfresco.hash.password=mypass
#  MD2, MD5, SHA,SHA-256,SHA-384,SHA-512
es.caib.digitalib.plugins.documentcustody.alfresco.hash.algorithm=MD5

# Retorna una URL que apunta a la versió original del document
# Opcional. Servei Millorat per generar la URL de Custodia emprant EL.
# Variables adicionals: validationUrl_custodyID, validationUrl_custodyID_URLEncode i validationUrl_custodyID_Hash
es.caib.digitalib.plugins.documentcustody.alfresco.baseurl_expressionlanguage=http://portafib.fundaciobit.org/custody/${registre.url}

# Opcional.Retorna una URL que apunta a la versió imprimible del document
# Valors de substitució:  
# ${custodyID} => custodyID | ${custodyID_URLEncode} => URLEncode(custodyID) | ${custodyID_Hash} => Hash(custodyID)
#es.caib.exemple.plugins.documentcustody.alfresco.printable_file_url_expressionlanguage=http://portafib.fundaciobit.org/custody/printable/${registre.url}

# Opcional.Retorna una URL que apunta a la versió ENI del document
# Valors de substitució:  
# ${custodyID} => custodyID | ${custodyID_URLEncode} => URLEncode(custodyID) | ${custodyID_Hash} => Hash(custodyID)
#es.caib.digitalib.plugins.documentcustody.alfresco.eni_file_url_expressionlanguage=http://portafib.fundaciobit.org/custody/eni/${registre.url}

#  Retorna una plana web de validacio del document
# Valors de substitució:  
# ${custodyID} => custodyID | ${custodyID_URLEncode} => URLEncode(custodyID) | ${custodyID_Hash} => Hash(custodyID)
es.caib.digitalib.plugins.documentcustody.alfresco.validation_file_url_expressionlanguage=https://dev.caib.es/concsv/hash/${csv}


# Opcional. Servei per generar el CSV. Si no es defineix retornarà null. 
# Als paràmetres se li afegeixen tres variables més:
#    + "${custodyID}" => custodyID
#    + "${custodyID_URLEncode}" => URLEncode(custodyID)
#    + "${custodyID_Hash}" => Hash(custodyID)
es.caib.exemple.plugins.documentcustody.alfresco.csv_expressionlanguage=${custodyID_Hash}

# Opcional.Web on es pot validar el CSV
# es.caib.exemple.plugins.documentcustody.alfresco.csv_validation_web_expressionlanguage=http://portafib.fundaciobit.org/custody/index.html


# Opcional. URL al document on s''explica com s''ha generat el CSV. Si no es defineix retornarà null. 
# es.caib.exemple.plugins.documentcustody.alfresco.csv_generation_definition=http://portafib.fundaciobit.org/custody/csv_generation.pdf


# Opcional. Su no definit retorna custodyID
# es.caib.digitalib.plugins.documentcustody.alfresco.specialValue_EL=${registre.id}

# Opcional. Serveix per generar els CustodyID a partir d''una EL 
#es.caib.digitalib.plugins.documentcustody.alfresco.generate_custodyid_expressionlanguage=${registre.id}

# NO SUPORTAT EN ALFRESCO  !!!!!!  Prefix a afegir al nom dels fitxers creats
# es.caib.digitalib.plugins.documentcustody.alfresco.prefix=

# Opcional crea estructures del tipus /1971/08/12/Entrada/123455
es.caib.digitalib.plugins.documentcustody.alfresco.folder_expressionlanguage=${registre.data?string["yyyy/MM/dd"]}/<#if  registro.origen??>Salida<#else>Entrada</#if>/${registre.id}/

# Opcional. Metadades Automàtiques
es.caib.digitalib.plugins.documentcustody.alfresco.automaticmetadata_items=1

es.caib.digitalib.plugins.documentcustody.alfresco.automatic_metadata.1.name=eni:v_nti
es.caib.digitalib.plugins.documentcustody.alfresco.automatic_metadata.1.valueEL=http://administracionelectronica.gob.es/ENI/XSD/v1.0/documento-e

#es.caib.digitalib.plugins.documentcustody.alfresco.automatic_metadata.2.name=eni:origen
es.caib.digitalib.plugins.documentcustody.alfresco.automatic_metadata.2.valueEL=${registre.origen}

# 1=Administracion || 0=Ciudadano
#es.caib.digitalib.plugins.documentcustody.alfresco.automatic_metadata.22.name=eni:origenStr
#es.caib.digitalib.plugins.documentcustody.alfresco.automatic_metadata.22.valueEL=<#if registre.origen == 1>Administracion<#elseif registre.origen == 0>Ciudadano<#else>DESCONEGUT ${registre.origen}</#if>

#es.caib.digitalib.plugins.documentcustody.alfresco.automatic_metadata.3.name=eni:estado_elaboracion
#es.caib.digitalib.plugins.documentcustody.alfresco.automatic_metadata.3.valueEL=${registre.estadoElaboracion}

#es.caib.digitalib.plugins.documentcustody.alfresco.automatic_metadata.4.name=eni:tipo_doc_ENI
es.caib.digitalib.plugins.documentcustody.alfresco.automatic_metadata.4.valueEL=${registre.tipoDocumental}', false, 2, 'DOCCUST_ALFRESCO', 3, 'Document Custody d''Alfresco 5.x', 'Document Custody d''Alfresco 5.x');


INSERT INTO dib_idioma(idiomaid, nom, suportat, ordre) VALUES ('ca', 'Català', true, 0);
INSERT INTO dib_idioma(idiomaid, nom, suportat, ordre) VALUES ('es', 'Castellano', true, 1);


INSERT INTO dib_traduccio VALUES (1676);
INSERT INTO dib_traduccio VALUES (1677);
INSERT INTO dib_traduccio VALUES (1678);
INSERT INTO dib_traduccio VALUES (1679);
INSERT INTO dib_traduccio VALUES (1680);
INSERT INTO dib_traduccio VALUES (1681);
INSERT INTO dib_traduccio VALUES (1682);
INSERT INTO dib_traduccio VALUES (1683);
INSERT INTO dib_traduccio VALUES (1684);
INSERT INTO dib_traduccio VALUES (1685);
INSERT INTO dib_traduccio VALUES (1686);
INSERT INTO dib_traduccio VALUES (1689);



INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1676, 'ca', 'Escaneig JNLP/Fitxer i sense firma');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1676, 'es', 'Escaneo JNLP o Selección de Fichero');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1677, 'ca', 'Escaneig amb DynamicWebTwain');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1677, 'es', 'Escaneig amb DynamicWebTwain');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1678, 'ca', 'Escaneig amb DynamicWebTwain');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1678, 'es', 'Escaneig amb DynamicWebTwain');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1679, 'ca', 'Escaneig i Firma');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1679, 'es', 'Escaneig i Firma');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1680, 'ca', 'Escaneig i Firma');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1680, 'es', 'Escaneig i Firma');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1681, 'ca', 'Escaneig i Firma Segell Temps');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1681, 'es', 'Escaneig i Firma Segell Temps');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1682, 'ca', 'Escaneig i Firma Segell Temps');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1682, 'es', 'Escaneig i Firma Segell Temps');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1683, 'ca', 'Escaneig + Firma + Arxiu CAIB');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1683, 'es', 'Escaneig + Firma + Arxiu CAIB');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1684, 'ca', 'Escaneig + Firma + Arxiu CAIB');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1684, 'es', 'Escaneig + Firma + Arxiu CAIB');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1685, 'ca', 'Escaneig + Firma + Document Custody (Arxiu CAIB)');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1685, 'es', 'Escaneig + Firma + Document Custody (Arxiu CAIB)');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1686, 'ca', 'Escaneig + Firma + Document Custody (Arxiu CAIB)');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1686, 'es', 'Escaneig + Firma + Document Custody (Arxiu CAIB)');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1689, 'ca', 'Escaneig JNLP o Selecció Fitxer');
INSERT INTO dib_traducciomap(traducciomapid, idiomaid, valor) VALUES (1689, 'es', 'Escaneo JNLP o Selección de Fichero');



INSERT INTO dib_configuraciofirma(configuraciofirmaid, uspoliticadefirma, policyidentifier, policyidentifierhash, policyidentifierhashalgorithm, policyurldocument, tipusoperaciofirma, tipusfirmaid, algorismedefirmaid, modedefirma, motiudelegacioid, firmatperformatid, posiciotaulafirmesid, pluginsegellatid, propietatstaulafirmes, inclouresegelldetemps, pluginfirmaservidorid, nom) VALUES (22, 0, NULL, NULL, NULL, NULL, 0, 0, 0, false, NULL, NULL, 0, NULL, NULL, false, 1003, 'AFIRMA FEderat Sense Segell');
INSERT INTO dib_configuraciofirma(configuraciofirmaid, uspoliticadefirma, policyidentifier, policyidentifierhash, policyidentifierhashalgorithm, policyurldocument, tipusoperaciofirma, tipusfirmaid, algorismedefirmaid, modedefirma, motiudelegacioid, firmatperformatid, posiciotaulafirmesid, pluginsegellatid, propietatstaulafirmes, inclouresegelldetemps, pluginfirmaservidorid, nom) VALUES (2098, 0, NULL, NULL, NULL, NULL, 0, 0, 0, false, NULL, NULL, 0, 2096, NULL, true, 1004, 'AFIRMA LIBS AMB SEGELL DE TEMPS');




INSERT INTO dib_fitxer(fitxerid, descripcio, mime, nom, tamany) VALUES (1076, NULL, 'image/png', 'fundaciobit-logo-cap.png', 7962);
INSERT INTO dib_fitxer(fitxerid, descripcio, mime, nom, tamany) VALUES (1077, NULL, 'image/png', 'fundaciobit-logo-peu.png', 1552);
INSERT INTO dib_fitxer(fitxerid, descripcio, mime, nom, tamany) VALUES (1231, NULL, 'image/png', 'goib.png', 6155);
INSERT INTO dib_fitxer(fitxerid, descripcio, mime, nom, tamany) VALUES (1232, NULL, 'image/png', 'goib_peu.png', 2973);



INSERT INTO dib_perfil(perfilid, pluginscanwebid, configuraciofirmaid, pluginarxiuid, plugindoccustodyid, codi, tipusfirma, tipuscustodia, apisimpleid, usperfil, scanformatfitxer, scanminimaresolucio, scanpixeltype, urlbase, pluginscanweb2id, utilitzatperaplicacio, nomid, descripcioid) VALUES (1008, 1000, 22, NULL, NULL, 'PERFIL_FIRMA_SCAN_AFIRMA_FEDERAT', 1, 0, NULL, 2, 0, NULL, NULL, 'http://10.215.216.175:8080/digitalib', 1234, NULL, 1679, 1680);
INSERT INTO dib_perfil(perfilid, pluginscanwebid, configuraciofirmaid, pluginarxiuid, plugindoccustodyid, codi, tipusfirma, tipuscustodia, apisimpleid, usperfil, scanformatfitxer, scanminimaresolucio, scanpixeltype, urlbase, pluginscanweb2id, utilitzatperaplicacio, nomid, descripcioid) VALUES (1308, 1000, 22, 1307, NULL, 'PERFIL_AFIRMA_FEDERAT_ARXIUCAIB', 1, 1, NULL, 3, 0, NULL, NULL, 'http://10.215.216.175:8080/digitalib', 1234, NULL, 1683, 1684);
INSERT INTO dib_perfil(perfilid, pluginscanwebid, configuraciofirmaid, pluginarxiuid, plugindoccustodyid, codi, tipusfirma, tipuscustodia, apisimpleid, usperfil, scanformatfitxer, scanminimaresolucio, scanpixeltype, urlbase, pluginscanweb2id, utilitzatperaplicacio, nomid, descripcioid) VALUES (1005, 1000, NULL, NULL, NULL, 'PERFIL_SCAN_JNLP_OR_FILE', 0, 0, NULL, 1, 0, NULL, NULL, 'http://10.215.216.175:8080/digitalib', 1234, NULL, 1689, 1676);
INSERT INTO dib_perfil(perfilid, pluginscanwebid, configuraciofirmaid, pluginarxiuid, plugindoccustodyid, codi, tipusfirma, tipuscustodia, apisimpleid, usperfil, scanformatfitxer, scanminimaresolucio, scanpixeltype, urlbase, pluginscanweb2id, utilitzatperaplicacio, nomid, descripcioid) VALUES (1017, 1001, NULL, NULL, NULL, 'PERFIL_SCAN_ONLY_DWT', 0, 0, NULL, 1, 0, NULL, NULL, 'http://10.215.216.175:8080/digitalib', NULL, NULL, 1677, 1678);
INSERT INTO dib_perfil(perfilid, pluginscanwebid, configuraciofirmaid, pluginarxiuid, plugindoccustodyid, codi, tipusfirma, tipuscustodia, apisimpleid, usperfil, scanformatfitxer, scanminimaresolucio, scanpixeltype, urlbase, pluginscanweb2id, utilitzatperaplicacio, nomid, descripcioid) VALUES (1275, 1000, 22, NULL, 1413, 'PERFIL_AFIRMA_FEDERAT_DOCCUST_CAIB', 1, 2, NULL, 3, 0, NULL, NULL, 'http://10.215.216.175:8080/digitalib', 1234, NULL, 1685, 1686);
INSERT INTO dib_perfil(perfilid, pluginscanwebid, configuraciofirmaid, pluginarxiuid, plugindoccustodyid, codi, tipusfirma, tipuscustodia, apisimpleid, usperfil, scanformatfitxer, scanminimaresolucio, scanpixeltype, urlbase, pluginscanweb2id, utilitzatperaplicacio, nomid, descripcioid) VALUES (1509, 1000, 2098, NULL, NULL, 'PERFIL_FIRMA_SCAN_AFIRMA_LIB_TS', 1, 0, NULL, 2, 0, NULL, NULL, NULL, 1234, NULL, 1681, 1682);



INSERT INTO dib_configuraciogrup(configuraciogrupid, nom, suportweb, suportemail, suporttelefon, logoheaderid, logofooterid, perfilnomesescaneigid, perfilcopiaautenticaid, perfilcustodiaid, adreza, perfilnomesescaneig2id, perfilcopiaautentica2id, perfilcustodia2id,codidir3perdefecte ) VALUES (1233, 'Govern de les Illes Balears', 'http://suport.caib.es', 'suport@caib.es', '97117171', 1231, 1232, NULL, NULL, 1308, '<p>Carrer de Sant Pere, 7</p>
<p>07012 Palma</p>
<p>Illes Balears</p>', NULL, NULL, NULL, 'A04003003');
INSERT INTO dib_configuraciogrup(configuraciogrupid, nom, suportweb, suportemail, suporttelefon, logoheaderid, logofooterid, perfilnomesescaneigid, perfilcopiaautenticaid, perfilcustodiaid, adreza, perfilnomesescaneig2id, perfilcopiaautentica2id, perfilcustodia2id, codidir3perdefecte) VALUES (1078, 'FundacioBit', 'http://fundaciobit.org', 'otae@fundaciobit.org', '123456789', 1076, 1077, 1005, 1008, NULL, '<p>Fundaci&oacute; Bit - Balears d''Innovaci&oacute; i Tecnologia<br /> Centre Empresarial Son Espanyol<br /> C/ Laura Bassi 07121 ParcBit<br /> Telf. 971.784.730 Telf. Directe 971.177283 Ext 77283</p>', NULL, 1509, NULL, 'A04013625');




INSERT INTO dib_usuariaplicacio(usuariaplicacioid, username, contrasenya, emailadmin, descripcio, actiu, rolescan, rolecoau, rolecust) VALUES (1007, 'testapp', NULL, 'digitalib@fundaciobit.org', NULL, true, true, true, true);
INSERT INTO dib_usuariaplicacio(usuariaplicacioid, username, contrasenya, emailadmin, descripcio, actiu, rolescan, rolecoau, rolecust) VALUES (1015, 'testappcaib', NULL, 'digitalib@fundaciobit.org', NULL, true, false, false, false);



INSERT INTO dib_perfilusrapp(perfilusrappid, perfilid, usuariaplicacioid) VALUES (1013, 1008, 1007);
INSERT INTO dib_perfilusrapp(perfilusrappid, perfilid, usuariaplicacioid) VALUES (1014, 1005, 1007);
INSERT INTO dib_perfilusrapp(perfilusrappid, perfilid, usuariaplicacioid) VALUES (1878, 1308, 1015);
INSERT INTO dib_perfilusrapp(perfilusrappid, perfilid, usuariaplicacioid) VALUES (1890, 1275, 1015);


