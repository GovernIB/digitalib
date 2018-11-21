
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 
  <%@include file="infoSignaturaFormTitle.jsp" %>


<form:form modelAttribute="infoSignaturaForm" method="${method}"
  enctype="multipart/form-data">
  
  <c:set var="contexte" value="${infoSignaturaForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="infoSignaturaFormCorePre.jsp" %>
  <%@include file="infoSignaturaFormCore.jsp" %>

  <%@include file="infoSignaturaFormCorePost.jsp" %>

  <%@include file="infoSignaturaFormButtons.jsp" %>

  <c:if test="${infoSignaturaForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/infoSignaturaFormModificable.jsp" %>
  </c:if>

</form:form>


