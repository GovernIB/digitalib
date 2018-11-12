<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PerfilUsuariAplicacioFields" className="es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields"/>
  
  <c:set var="__theForm" value="${perfilUsuariAplicacioForm}"/>

  <div class="module_content">
    <div class="tab_container">
    
    <c:if test="${not __theForm.view}">    <c:forEach items="${__theForm.hiddenFields}" var="hiddenFieldF" >
      <c:set  var="hiddenField" value="${hiddenFieldF.javaName}" />
      <c:if test="${gen:hasProperty(__theForm.perfilUsuariAplicacio,hiddenField)}">
        <form:errors path="perfilUsuariAplicacio.${hiddenField}" cssClass="errorField alert alert-error" />
        <form:hidden path="perfilUsuariAplicacio.${hiddenField}"/>
      </c:if>
    </c:forEach>
    </c:if>    <table class="tdformlabel table-condensed table table-bordered table-striped marTop10  " > 
    <tbody>      

