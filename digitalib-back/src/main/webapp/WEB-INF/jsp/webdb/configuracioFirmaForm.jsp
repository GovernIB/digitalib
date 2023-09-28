
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="configuracioFirmaForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="configuracioFirmaFormTitle.jsp" %>
 
  <c:set var="contexte" value="${configuracioFirmaForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="configuracioFirmaFormCorePre.jsp" %>

  <%@include file="configuracioFirmaFormCore.jsp" %>

  <%@include file="configuracioFirmaFormCorePost.jsp" %>

  <%@include file="configuracioFirmaFormButtons.jsp" %>

  <c:if test="${not empty configuracioFirmaForm.sections}">
     <c:set var="__basename" value="configuracioFirma" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${configuracioFirmaForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/configuracioFirmaFormModificable.jsp" %>
  </c:if>

</form:form>


