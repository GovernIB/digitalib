
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 
  <%@include file="transaccioFormTitle.jsp" %>


<form:form modelAttribute="transaccioForm" method="${method}"
  enctype="multipart/form-data">
  
  <c:set var="contexte" value="${transaccioForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="transaccioFormCorePre.jsp" %>
  <%@include file="transaccioFormCore.jsp" %>

  <%@include file="transaccioFormCorePost.jsp" %>

  <%@include file="transaccioFormButtons.jsp" %>

  <c:if test="${transaccioForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/transaccioFormModificable.jsp" %>
  </c:if>

</form:form>


