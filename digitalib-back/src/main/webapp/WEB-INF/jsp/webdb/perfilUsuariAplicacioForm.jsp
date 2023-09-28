
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="perfilUsuariAplicacioForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="perfilUsuariAplicacioFormTitle.jsp" %>
 
  <c:set var="contexte" value="${perfilUsuariAplicacioForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="perfilUsuariAplicacioFormCorePre.jsp" %>

  <%@include file="perfilUsuariAplicacioFormCore.jsp" %>

  <%@include file="perfilUsuariAplicacioFormCorePost.jsp" %>

  <%@include file="perfilUsuariAplicacioFormButtons.jsp" %>

  <c:if test="${not empty perfilUsuariAplicacioForm.sections}">
     <c:set var="__basename" value="perfilUsuariAplicacio" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${perfilUsuariAplicacioForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/perfilUsuariAplicacioFormModificable.jsp" %>
  </c:if>

</form:form>


