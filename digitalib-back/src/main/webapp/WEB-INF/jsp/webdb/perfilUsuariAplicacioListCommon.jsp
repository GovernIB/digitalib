<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${perfilUsuariAplicacioFilterForm.contexte}"/>
  <c:set var="formName" value="perfilUsuariAplicacio" />
  <c:set var="__theFilterForm" value="${perfilUsuariAplicacioFilterForm}" />
  <c:if test="${empty perfilUsuariAplicacioFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="perfilUsuariAplicacio.perfilUsuariAplicacio"/>
  </c:if>
  <c:if test="${not empty perfilUsuariAplicacioFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${perfilUsuariAplicacioFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty perfilUsuariAplicacioFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="perfilUsuariAplicacio.perfilUsuariAplicacio"/>
  </c:if>
  <c:if test="${not empty perfilUsuariAplicacioFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${perfilUsuariAplicacioFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.perfilUsuariAplicacio.submit();  
  }
</script>
