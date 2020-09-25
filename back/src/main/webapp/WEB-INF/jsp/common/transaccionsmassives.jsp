<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 
  <%@include file="../webdb/transaccioFormTitle.jsp" %>

<table border=0>
   
<tr>
<td>
<form:form modelAttribute="transaccioForm" method="${method}"
  enctype="multipart/form-data">
  
  <c:set var="contexte" value="${transaccioForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="../webdb/transaccioFormCorePre.jsp" %>
  <%@include file="../webdb/transaccioFormCore.jsp" %>

  <%@include file="../webdb/transaccioFormCorePost.jsp" %>

  <%@include file="../webdb/transaccioFormButtons.jsp" %>

  <c:if test="${transaccioForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/transaccioFormModificable.jsp" %>
  </c:if>

</form:form>
</td>

<td>

<div style="margin:10px;padding:15px;border-style: solid">
  <img  style="height:300px;" src="<c:url value="${thumbnailPDF}"/>" alt="Thumbnail PDF">

</td>


</table>