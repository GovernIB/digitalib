<%@ page contentType="text/html;charset=UTF-8" language="java"
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
      <a href="<c:url value="/admin/perfil/list"/>">
        <span style="${(fn:contains(url, 'perfil/list'))? "font-weight: bold;" : ""}"><fmt:message key="perfil.menu" /></span>
        
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
    

  </ul>
</div>

