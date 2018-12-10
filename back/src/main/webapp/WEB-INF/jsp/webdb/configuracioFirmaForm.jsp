
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 
  <%@include file="configuracioFirmaFormTitle.jsp" %>


<form:form modelAttribute="configuracioFirmaForm" method="${method}"
  enctype="multipart/form-data">
  
  <c:set var="contexte" value="${configuracioFirmaForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="configuracioFirmaFormCorePre.jsp" %>
  <%@include file="configuracioFirmaFormCore.jsp" %>

  <%@include file="configuracioFirmaFormCorePost.jsp" %>

  <%@include file="configuracioFirmaFormButtons.jsp" %>

  <c:if test="${configuracioFirmaForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/configuracioFirmaFormModificable.jsp" %>
  </c:if>

</form:form>


