<%@page import="es.caib.digitalib.utils.Constants"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%><%@ include
  file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
  <h5>
    <fmt:message key="usuariaccions.menu" />
  </h5>
  <ul class="tree" style="margin: 3px; padding: 0px;">

    <%-- Example with security: virtual roles  --%>
    <%--
   <sec:authorize access="hasAnyRole('ROLE_SOLI', 'ROLE_DEST', 'ROLE_COLA', 'ROLE_DELE')">
      <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
      <li style="list-style-type: disc; list-style-position: inside;">
       <a href="<c:url value="/user/rebreAvis/list/1"/>" >
       <span style="${(fn:contains(url, 'optionxxxxx/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
       Option XXXXX</span></a></li>
   </sec:authorize>
    --%>

    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/user/llistatperfilsdisponibles"/>"> <span
        style="${(fn:contains(url, '/user/llistatperfilsdisponibles'))? "font-weight:bold;" : ""}">
          <fmt:message key="usuari.escanejar" />
      </span>
    </a></li>


<%--	<sec:authorize access="hasRole('ROLE_SCAN')"> --%> 
  <%
  Long type = (Long)request.getAttribute("transaccionsuser_" + Constants.PERFIL_US_NOMES_ESCANEIG_INFO);
  if (type != null && type != 0) {
  %>
  	<hr style="margin-top: 6px; margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/user/transaccio/nomesescaneig/listreset"/>"> <span
        style="${(fn:contains(url, '/user/transaccio/nomesescaneig/'))? "font-weight:bold;" : ""}">
          <fmt:message key="usuari.escanejos" /> (<%=type%>)
      </span>
    </a></li>
  <% } %>  
   <%--   </sec:authorize>

    <sec:authorize access="hasRole('ROLE_COAU')">   --%>
         
  <%
  type = (Long)request.getAttribute("transaccionsuser_" + Constants.PERFIL_US_COPIA_AUTENTICA_INFO);
  if (type != null && type != 0) {
  %>
    <hr style="margin-top: 6px; margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/user/transaccio/copiaautentica/listreset"/>"> <span
        style="${(fn:contains(url, '/user/transaccio/copiaautentica/'))? "font-weight:bold;" : ""}">

          <fmt:message key="usuari.copies" /> (<%=type%>)
      </span>
    </a></li>
  <% } %>  
<%--     </sec:authorize>

    
   <sec:authorize access="hasRole('ROLE_CUST')">  --%>
  <%
  type = (Long)request.getAttribute("transaccionsuser_" + Constants.PERFIL_US_CUSTODIA_INFO);
  if (type != null && type != 0) {
  %>
    <hr style="margin-top: 6px; margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/user/transaccio/custodia/listreset"/>"> <span
        style="${(fn:contains(url, '/user/transaccio/custodia/'))? "font-weight:bold;" : ""}">

          <fmt:message key="usuari.copiesarxiu" /> (<%=type%>)
      </span>
    </a></li>
  <% } %>  
 <%--    </sec:authorize> --%>

  </ul>
</div>

