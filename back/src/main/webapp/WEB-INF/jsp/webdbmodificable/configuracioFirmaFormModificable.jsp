<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"
%><%@page import="es.caib.digitalib.utils.Constants"
%><%@page import="es.caib.digitalib.model.fields.ConfiguracioFirmaFields"
%><%@page import="org.fundaciobit.genapp.common.web.i18n.I18NUtils"
%><%@page import="org.fundaciobit.genapp.common.query.Field"
%><script>

 // Politica de Firma (ocultar o mostrar valor)
 onChangeUsPoliticaDeFirma(document.getElementById("<%=ConfiguracioFirmaFields.USPOLITICADEFIRMA.fullName.replace('.', '_') %>"));

 function onChangeUsPoliticaDeFirma(combo) {

 <%
    
    final Field<?>[] fieldsUsPolitica = {
       ConfiguracioFirmaFields.POLICYIDENTIFIER,
       ConfiguracioFirmaFields.POLICYIDENTIFIERHASH,
       ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM,
       ConfiguracioFirmaFields.POLICYURLDOCUMENT
    };
%>
     var value = combo.options[combo.selectedIndex].value;
     if (value == <%=Constants.US_POLITICA_DE_FIRMA_OBLIGATORI_DEFINIT%>) { 
       <% for(int c=0;c < fieldsUsPolitica.length ;c++) { %>
       document.getElementById("<%=fieldsUsPolitica[c].fullName.replace('.', '_') %>_rowid").style.display = '';
       <% } %>
     } else {
       <% for(int c=0;c < fieldsUsPolitica.length ;c++) { %>
       document.getElementById("<%=fieldsUsPolitica[c].fullName.replace('.', '_') %>_rowid").style.display = 'none';
       <% } %>
     }

 }
 
 
 
 

 <%--

 // Politica de Segellat de Temps (ocultar o mostrar valor)
 
 onChangeIncloureSegellDeTemps(document.getElementById("<%=ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS.fullName%>"));

 function onChangeIncloureSegellDeTemps(combo) {
     var value = combo.options[combo.selectedIndex].value;
     
     alert("XYZ ZZZ Valor de IncloureSegellDeTemps =|" + value + "|")
     
     if (value == 'true') { 
       document.getElementById("<%=ConfiguracioFirmaFields.PLUGINSEGELLATID.fullName.replace('.', '_') %>_rowid").style.display = 'none';
     } else {
       document.getElementById("<%=ConfiguracioFirmaFields.PLUGINSEGELLATID.fullName.replace('.', '_') %>_rowid").style.display = '';
     }
 }


 // Plugin Firma en Servidor
 {
 var sel = document.getElementById("<%=ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID.fullName.replace('.', '_') %>").options;
 var i;
 for (i = 0; i < sel.length; i++) {
    if (sel[i].value == '') {
      sel[i].innerHTML='--<fmt:message key="usuariaplicacioconfig.nofirmaservidor"/>--';
      break;
    }
 }
 }

 --%>

 <%--
 onChangePluginFirmaServidorID(document.getElementById("<%=ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID.fullName.replace('.', '_') %>"));

 function onChangePluginFirmaServidorID(combo) {
   var value = combo.options[combo.selectedIndex].value;
   if (value == '') {
     document.getElementById("<%=ConfiguracioFirmaFields.MAXFIRMESENSERVIDOR.fullName.replace('.', '_') %>_rowid").style.display = 'none';
     document.getElementById("<%=ConfiguracioFirmaFields.UPGRADESIGNFORMAT.fullName.replace('.', '_') %>_rowid").style.display = 'none';
   } else {
     document.getElementById("<%=ConfiguracioFirmaFields.MAXFIRMESENSERVIDOR.fullName.replace('.', '_') %>_rowid").style.display = '';
     document.getElementById("<%=ConfiguracioFirmaFields.UPGRADESIGNFORMAT.fullName.replace('.', '_') %>_rowid").style.display = '';
   }
 }
 --%>
 
 
 // Tipus Firma i Mode de Firma
 onChangeTipusFirmaID(document.getElementById("<%=ConfiguracioFirmaFields.TIPUSFIRMAID.fullName.replace('.', '_') %>"));
 <%
 final Field<?>[] tipusFirma = {
     ConfiguracioFirmaFields.POSICIOTAULAFIRMESID,
     //ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES,
     ConfiguracioFirmaFields.FIRMATPERFORMATID,
     ConfiguracioFirmaFields.MOTIUDELEGACIOID
  };
 %>
 
 function onChangeTipusFirmaID(combo) {
   var value = combo.options[combo.selectedIndex].value;
   if (value == <%=Constants.TIPUSFIRMA_PADES%>) {
     document.getElementById("<%=ConfiguracioFirmaFields.MODEDEFIRMA.fullName.replace('.', '_') %>_rowid").style.display = 'none';    
     
     <% for(int c=0;c < tipusFirma.length ;c++) { %>
     document.getElementById("<%=tipusFirma[c].fullName.replace('.', '_') %>_rowid").style.display = '';
     <% } %>
     
     
   } else {
     document.getElementById("<%=ConfiguracioFirmaFields.MODEDEFIRMA.fullName.replace('.', '_') %>_rowid").style.display = '';
     <% for(int c=0;c < tipusFirma.length ;c++) { %>
     document.getElementById("<%=tipusFirma[c].fullName.replace('.', '_') %>_rowid").style.display = 'none';
     <% } %>
   }
 }

 // ALGORISME DE FIRMA
 var sel = document.getElementById("<%=ConfiguracioFirmaFields.ALGORISMEDEFIRMAID.fullName.replace('.', '_') %>").options;
 for (i = 0; i < sel.length; i++) {
    if (sel[i].value == '') {
      sel[i].innerHTML='--<fmt:message key="definitenentitat."/>--';
      break;
    }
 }

 
 // Segellat de Temps (camp null)
 var obj = document.getElementById("<%=ConfiguracioFirmaFields.PLUGINSEGELLATID.fullName.replace('.', '_') %>");
 if (obj) {
   var sel = obj.options;
   for (i = 0; i < sel.length; i++) {
     if (sel[i].value == '') {
       sel[i].innerHTML='--<fmt:message key="combobox.seleccionar"/>--';
       break;
     }
   }
 }

 // Posicio de Taula de Firmes (ocultar o mostrar valor)

 onChangePosicioTaulaFirmesID(document.getElementById("configuracioFirma_posicioTaulaFirmesID"));

 function onChangePosicioTaulaFirmesID(combo) {
     
     var value = combo.options[combo.selectedIndex].value;
     
     if (value == <%=Constants.TAULADEFIRMES_SENSETAULA%>) { 
     
       document.getElementById("<%=ConfiguracioFirmaFields.MOTIUDELEGACIOID.fullName.replace('.', '_') %>_rowid").style.display = 'none';
       document.getElementById("<%=ConfiguracioFirmaFields.FIRMATPERFORMATID.fullName.replace('.', '_') %>_rowid").style.display = 'none';
     } else {
     
       document.getElementById("<%=ConfiguracioFirmaFields.MOTIUDELEGACIOID.fullName.replace('.', '_') %>_rowid").style.display = '';
       document.getElementById("<%=ConfiguracioFirmaFields.FIRMATPERFORMATID.fullName.replace('.', '_') %>_rowid").style.display = '';
     }
     
 }
 

 <%--
 // XYZ ZZZ Posicio Taula de Firmes
 // var sel = document.getElementById("<%=ConfiguracioFirmaFields.POSICIOTAULAFIRMESID.fullName.replace('.', '_') %>").options;
 //for (i = 0; i < sel.length; i++) {
 //   if (sel[i].value == '') {
 //     sel[i].innerHTML='--<fmt:message key="combobox.seleccionar"/>--';
 //     break;
 //   }
 //}
 --%>
 

</script>

