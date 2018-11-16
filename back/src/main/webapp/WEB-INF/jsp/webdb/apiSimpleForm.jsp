
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 
  <%@include file="apiSimpleFormTitle.jsp" %>


<form:form modelAttribute="apiSimpleForm" method="${method}"
  enctype="multipart/form-data">
  
  <c:set var="contexte" value="${apiSimpleForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="apiSimpleFormCorePre.jsp" %>
  <%@include file="apiSimpleFormCore.jsp" %>

  <%@include file="apiSimpleFormCorePost.jsp" %>

  <%@include file="apiSimpleFormButtons.jsp" %>

  <c:if test="${apiSimpleForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/apiSimpleFormModificable.jsp" %>
  </c:if>

</form:form>


