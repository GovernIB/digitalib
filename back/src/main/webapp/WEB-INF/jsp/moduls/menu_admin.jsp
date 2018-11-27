﻿<%@ page contentType="text/html;charset=UTF-8" language="java"
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
  <h5>Menú ROLE_ADMIN</h5>
  <ul class="tree" style="margin: 3px; padding: 0px;">


    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/option1"/>">
        <span style="${(fn:contains(url, 'option1'))? "font-weight: bold;" : ""}">Menú ADMIN Option 1</span>
      </a>
    </li>

   <%-- Example with security: virtual roles  --%>
   <%--
   <sec:authorize access="hasAnyRole('ROLE_SOLI', 'ROLE_DEST', 'ROLE_COLA', 'ROLE_DELE')">
      <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
      <li style="list-style-type: disc; list-style-position: inside;">
       <a href="<c:url value="/admin/rebreAvis/list/1"/>" >
       <span style="${(fn:contains(url, 'optionxxxxx/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
       Option XXXXX</span></a></li>
   </sec:authorize>
    --%>

    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/pluginscanweb/list"/>">
        <span style="${(fn:contains(url, 'pluginscanweb/list'))? "font-weight: bold;" : ""}"><fmt:message key="scanwebplugin.menu" /></span>
        
      </a>
    </li>
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/pluginfirmaenservidor/list"/>">
        <span style="${(fn:contains(url, 'pluginfirmaenservidor/list'))? "font-weight: bold;" : ""}"><fmt:message key="firmaenservidorplugin.menu" /></span>
        
      </a>
    </li>
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/pluginarxiu/list"/>">
        <span style="${(fn:contains(url, 'pluginarxiu/list'))? "font-weight: bold;" : ""}"><fmt:message key="arxiuplugin.menu" /></span>
        
      </a>
    </li>
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/plugindoccustody/list"/>">
        <span style="${(fn:contains(url, 'plugindoccustody/list'))? "font-weight: bold;" : ""}"><fmt:message key="doccustodyplugin.menu" /></span>
        
      </a>
    </li>
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/perfilnomesescaneig/list"/>">
        <span style="${(fn:contains(url, 'perfilnomesescaneig/list'))? "font-weight: bold;" : ""}"><fmt:message key="perfil.us.gestio" ><fmt:param><fmt:message key="perfil.us.1" /></fmt:param></fmt:message></span>
        
      </a>
    </li>
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/perfilcopiaautentica/list"/>">
        <span style="${(fn:contains(url, 'perfilcopiaautentica/list'))? "font-weight: bold;" : ""}"><fmt:message key="perfil.us.gestio" ><fmt:param><fmt:message key="perfil.us.2" /></fmt:param></fmt:message></span>
        
      </a>
    </li>
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/perfilcustodia/list"/>">
        <span style="${(fn:contains(url, 'perfilcustodia/list'))? "font-weight: bold;" : ""}"><fmt:message key="perfil.us.gestio" ><fmt:param><fmt:message key="perfil.us.3" /></fmt:param></fmt:message></span>
        
      </a>
    </li>
    
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/usuariAplicacio/list"/>">
        <span style="${(fn:contains(url, '/usuariAplicacio/list'))? "font-weight: bold;" : ""}"><fmt:message key="usuariAplicacio.usuariAplicacio.plural" /></span>
        
      </a>
    </li>
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/configuracioGrup/list"/>">
        <span style="${(fn:contains(url, '/configuracioGrup/list'))? "font-weight: bold;" : ""}"><fmt:message key="configuracioGrup.configuracioGrup.plural" /></span>
        
      </a>
    </li>
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/usuariPersona/list"/>">
        <span style="${(fn:contains(url, '/usuariPersona/list'))? "font-weight: bold;" : ""}"><fmt:message key="usuariPersona.usuariPersona.plural" /></span>
        
      </a>
    </li>
    
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/transaccio/list"/>">
        <span style="${(fn:contains(url, '/transaccio/list'))? "font-weight: bold;" : ""}"><fmt:message key="transaccio.transaccio" /></span>
        
      </a>
    </li>
    

  </ul>
</div>

