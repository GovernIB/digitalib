
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="transaccioMultipleForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="transaccioMultipleFormTitle.jsp" %>
 
  <c:set var="contexte" value="${transaccioMultipleForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="transaccioMultipleFormCorePre.jsp" %>

  <%@include file="transaccioMultipleFormCore.jsp" %>

  <%@include file="transaccioMultipleFormCorePost.jsp" %>

  <%@include file="transaccioMultipleFormButtons.jsp" %>

  <c:if test="${not empty transaccioMultipleForm.sections}">
     <c:set var="__basename" value="transaccioMultiple" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${transaccioMultipleForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/transaccioMultipleFormModificable.jsp" %>
  </c:if>

</form:form>


