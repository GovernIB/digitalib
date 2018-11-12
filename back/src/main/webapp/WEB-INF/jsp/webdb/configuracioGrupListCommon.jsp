<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${configuracioGrupFilterForm.contexte}"/>
  <c:set var="formName" value="configuracioGrup" />
  <c:set var="__theFilterForm" value="${configuracioGrupFilterForm}" />
  <c:if test="${empty configuracioGrupFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="configuracioGrup.configuracioGrup"/>
  </c:if>
  <c:if test="${not empty configuracioGrupFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${configuracioGrupFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty configuracioGrupFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="configuracioGrup.configuracioGrup"/>
  </c:if>
  <c:if test="${not empty configuracioGrupFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${configuracioGrupFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.configuracioGrup.submit();  
  }
</script>
