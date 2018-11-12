<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${perfilFilterForm.contexte}"/>
  <c:set var="formName" value="perfil" />
  <c:set var="__theFilterForm" value="${perfilFilterForm}" />
  <c:if test="${empty perfilFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="perfil.perfil"/>
  </c:if>
  <c:if test="${not empty perfilFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${perfilFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty perfilFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="perfil.perfil"/>
  </c:if>
  <c:if test="${not empty perfilFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${perfilFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.perfil.submit();  
  }
</script>
