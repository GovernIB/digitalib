<%@page import="es.caib.digitalib.model.fields.PerfilFields"%>
<%@page import="es.caib.digitalib.utils.Constants"%>
<%@page import="org.fundaciobit.genapp.common.web.i18n.I18NUtils"%>
<%@page import="org.fundaciobit.genapp.common.query.Field"%>
<script>
 // Eliminar opcio de "Nomes Persones" en el desplegable de UtilitzatPerAplicacio dins dels Perfils de Aplicacions
 function deleteNomesPersones(selectobject) {
	for (var i=0; i<selectobject.length; i++){
		if (selectobject.options[i].value == 'false' )
			selectobject.remove(i);
	}
 }
 
 deleteNomesPersones(document.getElementById("<%=PerfilFields.UTILITZATPERAPLICACIO.fullName %>"));

 // Politica de Firma (ocultar o mostrar valor)
 onChangeTipusFirma(document.getElementById("<%=PerfilFields.TIPUSFIRMA.fullName.replace('.', '_') %>"));

 function onChangeTipusFirma(combo) {

     var value = combo.options[combo.selectedIndex].value;
     if (value == <%=Constants.TIPUS_FIRMA_EN_SERVIDOR_SENSE%>) { 
       document.getElementById("<%=PerfilFields.PLUGINFIRMASERVIDORID.fullName.replace('.', '_') %>_rowid").style.display = 'none';
       document.getElementById("<%=PerfilFields.APISIMPLEID.fullName.replace('.', '_') %>_rowid").style.display = 'none';
     } else if (value == <%=Constants.TIPUS_FIRMA_EN_SERVIDOR_APISIMPLE%>) { 
       document.getElementById("<%=PerfilFields.PLUGINFIRMASERVIDORID.fullName.replace('.', '_') %>_rowid").style.display = 'none';
       document.getElementById("<%=PerfilFields.APISIMPLEID.fullName.replace('.', '_') %>_rowid").style.display = '';
     } else {
       document.getElementById("<%=PerfilFields.PLUGINFIRMASERVIDORID.fullName.replace('.', '_') %>_rowid").style.display = '';
       document.getElementById("<%=PerfilFields.APISIMPLEID.fullName.replace('.', '_') %>_rowid").style.display = 'none';
     }

 }

//Politica de Custodia (ocultar o mostrar valor)
 onChangeTipusCustodia(document.getElementById("<%=PerfilFields.TIPUSCUSTODIA.fullName.replace('.', '_') %>"));

 function onChangeTipusCustodia(combo) {

     var value = combo.options[combo.selectedIndex].value;
     if (value == <%=Constants.TIPUS_CUSTODIA_SENSE%>) { 
       document.getElementById("<%=PerfilFields.PLUGINDOCCUSTODYID.fullName.replace('.', '_') %>_rowid").style.display = 'none';
       document.getElementById("<%=PerfilFields.PLUGINARXIUID.fullName.replace('.', '_') %>_rowid").style.display = 'none';
     } else if (value == <%=Constants.TIPUS_CUSTODIA_ARXIU%>) { 
       document.getElementById("<%=PerfilFields.PLUGINDOCCUSTODYID.fullName.replace('.', '_') %>_rowid").style.display = 'none';
       document.getElementById("<%=PerfilFields.PLUGINARXIUID.fullName.replace('.', '_') %>_rowid").style.display = '';
     } else {
       document.getElementById("<%=PerfilFields.PLUGINDOCCUSTODYID.fullName.replace('.', '_') %>_rowid").style.display = '';
       document.getElementById("<%=PerfilFields.PLUGINARXIUID.fullName.replace('.', '_') %>_rowid").style.display = 'none';
     }

 }
 
 
 </script>