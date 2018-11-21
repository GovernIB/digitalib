<%@ page language="java" 
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp" 
%>

<br>
<br>
<br>


<center>
<h3><fmt:message key="scan.final.msg1"/></h3><br/>
<i><fmt:message key="scan.final.msg2"/></i><br/>
<br/>
<b>Configuraci&oacute;:</b>
&nbsp;&nbsp;&nbsp;* Tipus: ${LAST_CONFIG.scanType}
&nbsp;&nbsp;&nbsp;* Caracter&iacute;stiques: 
<c:forEach var="flag" items="${LAST_CONFIG.flags}">
${flag},
</c:forEach>
&nbsp;&nbsp;&nbsp;* Mode: ${LAST_CONFIG.mode}<br/>
<table  class="table table-bordered">
<thead>
 <tr>
    <th> &nbsp;&nbsp;#&nbsp;&nbsp; </th>
    <th> Fitxer </th>
    <th> Fitxer Signat </th>
    <th> Metadades </th>
 </tr>
</thead>
<tbody>
<c:forEach items="${LAST_SCANNED_FILES}" var="scannedDocument" varStatus="theCount">

 <tr>
    <td> &nbsp;${theCount.count}&nbsp; </td>
    <td> Fitxer 
        <c:if test="${not empty scannedDocument.scannedPlainFile }">
           Nom: <b><a href="<c:url value="/common/scan/download/${theCount.index}" />" target="_blank">
            ${scannedDocument.scannedPlainFile.name}
            </a></b><br/>            
            Len: <b>${fn:length(scannedDocument.scannedPlainFile.data)} bytes</b>
            <br/>
            Mime: <b> ${scannedDocument.scannedPlainFile.mime}</b>
        </c:if>
    </td>
    <td> 
       <c:if test="${not empty scannedDocument.scannedSignedFile }">
           Nom: <b><a href="<c:url value="/common/scan/downloadSignature/${theCount.index}" />" target="_blank">
            ${scannedDocument.scannedSignedFile.name}
            </a></b><br/>
            
            Len: ${fn:length(scannedDocument.scannedSignedFile.data)} bytes
            <br/>
            Mime: <b> ${scannedDocument.scannedSignedFile.mime}</b>
            <br/>
            Tipus Firma: <b> ${scannedDocument.scannedSignedFile.signatureType}</b><br/>                
            AttachedDocument: <b> ${scannedDocument.scannedSignedFile.attachedDocument}</b>
        </c:if>
     </td>
    <td> 
         <c:if test="${not empty scannedDocument.metadatas }">
         
         
         <table class="table table-bordered">
         <thead>
         <tr>
            <th> Clau </th>
            <th> Valor </th>
            <th> Tipus </th>
         </tr>
         </thead>
         <tbody>
         <c:forEach items="${scannedDocument.metadatas}" var="metadata" varStatus="theCountM">
            <tr>
            <td> ${metadata.key} </td>
            <td> ${metadata.value} </td>
            <td> ${metadata.metadataType} </td>
            </tr>
         
         </c:forEach>
         </tbody>
        </table>

         </c:if>

     </td>
 </tr>

</c:forEach>
</tbody>
</table>

<br/>

<a href="javascript:window.parent.location.href='${urlRetorn}';" class="btn"><fmt:message key="tornar"/></a>
</center>

