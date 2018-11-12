
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 
  <%@include file="configuracioGrupFormTitle.jsp" %>


<form:form modelAttribute="configuracioGrupForm" method="${method}"
  enctype="multipart/form-data">
  
  <c:set var="contexte" value="${configuracioGrupForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="configuracioGrupFormCorePre.jsp" %>
  <%@include file="configuracioGrupFormCore.jsp" %>

  <%@include file="configuracioGrupFormCorePost.jsp" %>

  <%@include file="configuracioGrupFormButtons.jsp" %>

  <c:if test="${configuracioGrupForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/configuracioGrupFormModificable.jsp" %>
  </c:if>

</form:form>


