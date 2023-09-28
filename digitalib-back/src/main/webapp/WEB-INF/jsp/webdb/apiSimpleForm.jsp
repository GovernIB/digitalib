
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="apiSimpleForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="apiSimpleFormTitle.jsp" %>
 
  <c:set var="contexte" value="${apiSimpleForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="apiSimpleFormCorePre.jsp" %>

  <%@include file="apiSimpleFormCore.jsp" %>

  <%@include file="apiSimpleFormCorePost.jsp" %>

  <%@include file="apiSimpleFormButtons.jsp" %>

  <c:if test="${not empty apiSimpleForm.sections}">
     <c:set var="__basename" value="apiSimple" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${apiSimpleForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/apiSimpleFormModificable.jsp" %>
  </c:if>

</form:form>


