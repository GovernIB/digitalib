
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 
  <%@include file="transaccioMultipleFormTitle.jsp" %>


<form:form modelAttribute="transaccioMultipleForm" method="${method}"
  enctype="multipart/form-data">
  
  <c:set var="contexte" value="${transaccioMultipleForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="transaccioMultipleFormCorePre.jsp" %>
  <%@include file="transaccioMultipleFormCore.jsp" %>

  <%@include file="transaccioMultipleFormCorePost.jsp" %>

  <%@include file="transaccioMultipleFormButtons.jsp" %>

  <c:if test="${transaccioMultipleForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/transaccioMultipleFormModificable.jsp" %>
  </c:if>

</form:form>


