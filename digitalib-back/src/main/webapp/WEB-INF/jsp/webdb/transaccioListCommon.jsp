<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${transaccioFilterForm.contexte}"/>
  <c:set var="formName" value="transaccio" />
  <c:set var="__theFilterForm" value="${transaccioFilterForm}" />
  <c:if test="${empty transaccioFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="transaccio.transaccio"/>
  </c:if>
  <c:if test="${not empty transaccioFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${transaccioFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty transaccioFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="transaccio.transaccio"/>
  </c:if>
  <c:if test="${not empty transaccioFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${transaccioFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.transaccio.submit();  
  }
</script>
