
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="perfilForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="perfilFormTitle.jsp" %>
 
  <c:set var="contexte" value="${perfilForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="perfilFormCorePre.jsp" %>

  <%@include file="perfilFormCore.jsp" %>

  <%@include file="perfilFormCorePost.jsp" %>

  <%@include file="perfilFormButtons.jsp" %>

  <c:if test="${not empty perfilForm.sections}">
     <c:set var="__basename" value="perfil" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${perfilForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/perfilFormModificable.jsp" %>
  </c:if>

</form:form>


