
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="transaccioForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="transaccioFormTitle.jsp" %>
 
  <c:set var="contexte" value="${transaccioForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="transaccioFormCorePre.jsp" %>

  <%@include file="transaccioFormCore.jsp" %>

  <%@include file="transaccioFormCorePost.jsp" %>

  <%@include file="transaccioFormButtons.jsp" %>

  <c:if test="${not empty transaccioForm.sections}">
     <c:set var="__basename" value="transaccio" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${transaccioForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/transaccioFormModificable.jsp" %>
  </c:if>

</form:form>


