<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${configuracioFirmaFilterForm.contexte}"/>
  <c:set var="formName" value="configuracioFirma" />
  <c:set var="__theFilterForm" value="${configuracioFirmaFilterForm}" />
  <c:if test="${empty configuracioFirmaFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="configuracioFirma.configuracioFirma"/>
  </c:if>
  <c:if test="${not empty configuracioFirmaFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${configuracioFirmaFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty configuracioFirmaFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="configuracioFirma.configuracioFirma"/>
  </c:if>
  <c:if test="${not empty configuracioFirmaFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${configuracioFirmaFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.configuracioFirma.submit();  
  }
</script>
