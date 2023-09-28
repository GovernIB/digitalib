<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${apiSimpleFilterForm.contexte}"/>
  <c:set var="formName" value="apiSimple" />
  <c:set var="__theFilterForm" value="${apiSimpleFilterForm}" />
  <c:if test="${empty apiSimpleFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="apiSimple.apiSimple"/>
  </c:if>
  <c:if test="${not empty apiSimpleFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${apiSimpleFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty apiSimpleFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="apiSimple.apiSimple"/>
  </c:if>
  <c:if test="${not empty apiSimpleFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${apiSimpleFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.apiSimple.submit();  
  }
</script>
