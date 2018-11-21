
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 
  <%@include file="infoCustodyFormTitle.jsp" %>


<form:form modelAttribute="infoCustodyForm" method="${method}"
  enctype="multipart/form-data">
  
  <c:set var="contexte" value="${infoCustodyForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="infoCustodyFormCorePre.jsp" %>
  <%@include file="infoCustodyFormCore.jsp" %>

  <%@include file="infoCustodyFormCorePost.jsp" %>

  <%@include file="infoCustodyFormButtons.jsp" %>

  <c:if test="${infoCustodyForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/infoCustodyFormModificable.jsp" %>
  </c:if>

</form:form>


