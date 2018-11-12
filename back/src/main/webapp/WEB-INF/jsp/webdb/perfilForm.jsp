
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 
  <%@include file="perfilFormTitle.jsp" %>


<form:form modelAttribute="perfilForm" method="${method}"
  enctype="multipart/form-data">
  
  <c:set var="contexte" value="${perfilForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="perfilFormCorePre.jsp" %>
  <%@include file="perfilFormCore.jsp" %>

  <%@include file="perfilFormCorePost.jsp" %>

  <%@include file="perfilFormButtons.jsp" %>

  <c:if test="${perfilForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/perfilFormModificable.jsp" %>
  </c:if>

</form:form>


