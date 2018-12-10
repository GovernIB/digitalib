<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ConfiguracioFirmaFields" className="es.caib.digitalib.model.fields.ConfiguracioFirmaFields"/>
  
  <c:set var="__theForm" value="${configuracioFirmaForm}"/>

  <div class="module_content">
    <div class="tab_container">
    
    <c:if test="${not __theForm.view}">    <c:forEach items="${__theForm.hiddenFields}" var="hiddenFieldF" >
      <c:set  var="hiddenField" value="${hiddenFieldF.javaName}" />
      <c:if test="${gen:hasProperty(__theForm.configuracioFirma,hiddenField)}">
        <form:errors path="configuracioFirma.${hiddenField}" cssClass="errorField alert alert-error" />
        <form:hidden path="configuracioFirma.${hiddenField}"/>
      </c:if>
    </c:forEach>
    </c:if>    <table class="tdformlabel table-condensed table table-bordered table-striped marTop10  " > 
    <tbody>      

