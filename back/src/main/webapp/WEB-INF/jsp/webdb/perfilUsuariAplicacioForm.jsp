
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 
  <%@include file="perfilUsuariAplicacioFormTitle.jsp" %>


<form:form modelAttribute="perfilUsuariAplicacioForm" method="${method}"
  enctype="multipart/form-data">
  
  <c:set var="contexte" value="${perfilUsuariAplicacioForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="perfilUsuariAplicacioFormCorePre.jsp" %>
  <%@include file="perfilUsuariAplicacioFormCore.jsp" %>

  <%@include file="perfilUsuariAplicacioFormCorePost.jsp" %>

  <%@include file="perfilUsuariAplicacioFormButtons.jsp" %>

  <c:if test="${perfilUsuariAplicacioForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/perfilUsuariAplicacioFormModificable.jsp" %>
  </c:if>

</form:form>


