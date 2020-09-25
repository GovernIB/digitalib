<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${transaccioMultipleFilterForm.contexte}"/>
  <c:set var="formName" value="transaccioMultiple" />
  <c:set var="__theFilterForm" value="${transaccioMultipleFilterForm}" />
  <c:if test="${empty transaccioMultipleFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="transaccioMultiple.transaccioMultiple"/>
  </c:if>
  <c:if test="${not empty transaccioMultipleFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${transaccioMultipleFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty transaccioMultipleFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="transaccioMultiple.transaccioMultiple"/>
  </c:if>
  <c:if test="${not empty transaccioMultipleFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${transaccioMultipleFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.transaccioMultiple.submit();  
  }
</script>
