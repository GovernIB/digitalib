@echo off

echo optional parameters -Dcaib -Psqlgen

cmd /C mvn clean install -DskipTests %* 

if %errorlevel% EQU 0 (

	@echo off
	IF DEFINED DIGITALIB_DEPLOY_DIR (
      for /f "tokens=* delims=" %%x in (versio.txt) do set DIGITALIB_VERSIO=%%x
	  @echo on
	  echo --------- COPIANT EAR %DIGITALIB_VERSIO% ---------

	  xcopy /Y digitalib-ear\target\digitalib.ear %DIGITALIB_DEPLOY_DIR%

	) ELSE (
	  echo  =================================================================
	  echo    Definex la variable d'entorn DIGITALIB_DEPLOY_DIR apuntant al
	  echo    directori de deploy del JBOSS  i automaticament s'hi copiara
	  echo    l'ear generat.
	  echo  =================================================================
	) 

)