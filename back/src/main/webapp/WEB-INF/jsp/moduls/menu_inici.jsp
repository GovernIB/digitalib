﻿<%@ page contentType="text/html;charset=UTF-8" language="java"
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
  <h5><fmt:message key="menuinici" /></h5>
  <ul class="tree" style="margin: 3px; padding: 0px;">

    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/common/principal.html"/>">
        <span style="${(fn:contains(url, 'principal'))? "font-weight: bold;" : ""}"><fmt:message key="inici.paginainici" /></span>
      </a>
    </li>
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/common/usuaripersona/${loginInfo.usuariPersona.usuariPersonaID}/edit"/>">
        <span style="${(fn:contains(url, 'usuaripersona'))? "font-weight: bold;" : ""}"><fmt:message key="inici.configuraciousuari" /></span>
      </a>
    </li>

<%-- 
    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/common/option1"/>">
        <span style="${(fn:contains(url, 'option1'))? "font-weight: bold;" : ""}">Menú Option 1</span>
      </a>
    </li>
-->
   <%-- Example with security: virtual roles  --%>
   <%--
   <sec:authorize access="hasAnyRole('ROLE_SOLI', 'ROLE_DEST', 'ROLE_COLA', 'ROLE_DELE')">
      <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
      <li style="list-style-type: disc; list-style-position: inside;">
       <a href="<c:url value="/common/rebreAvis/list/1"/>" >
       <span style="${(fn:contains(url, 'optionxxxxx/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
       Option XXXXX</span></a></li>
   </sec:authorize>
    --%>

   
  </ul>
</div>

