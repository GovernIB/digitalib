
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="configuracioGrupForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="configuracioGrupFormTitle.jsp" %>
 
  <c:set var="contexte" value="${configuracioGrupForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="configuracioGrupFormCorePre.jsp" %>

  <%@include file="configuracioGrupFormCore.jsp" %>

  <%@include file="configuracioGrupFormCorePost.jsp" %>

  <%@include file="configuracioGrupFormButtons.jsp" %>

  <c:if test="${not empty configuracioGrupForm.sections}">
     <c:set var="__basename" value="configuracioGrup" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${configuracioGrupForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/configuracioGrupFormModificable.jsp" %>
  </c:if>

</form:form>


