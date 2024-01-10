<%@page import="es.caib.digitalib.commons.utils.Configuracio"%>
<%@page import="es.caib.digitalib.back.security.LoginInfo"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:if test="${loginInfo.needConfigUser}">
  <%
  LoginInfo.getInstance().setNeedConfigUser(false);
  %>
  <c:redirect
    url="/common/usuaripersona/${loginInfo.usuariPersona.usuariPersonaID }/edit" />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="<c:out value="${pageContext.response.locale.language}"/>"
  lang="<c:out value="${pageContext.response.locale.language}"/>">
<head>
<%@ include file="/WEB-INF/jsp/moduls/imports.jsp"%>
</head>
<body>

    <!--  INICI CAPÇALERA -->

    <tiles:insertAttribute name="cap">
        <tiles:putAttribute name="data" value="${data}" />
    </tiles:insertAttribute>


    <!--  PIPELLES -->
    <div class="row-fluid container main" style="max-width: none;">

        <ul class="nav nav-tabs custom-submenu">
      <%
      if (!Configuracio.isOcultarMenuInici()) {
      %>
      <li class="nav-item">
              <a class="nav-link ${(empty pipella)?'active' : '' }" href="<c:url value="/canviarPipella/"/>">
                <fmt:message key="inici" />
              </a></li>
      <%
      }
      %>

      <%--  DRAW MENU OPTIONS
    <c:forEach var="rolG" items="${loginInfo.roles}">
    <c:set var="rol" value="${rolG.authority}"/>
    <c:if test="${not(rol eq 'ROLE_USER')}">
    <li ${(pipella eq rol)?'class="active"' : '' }>
       <a href="<c:url value="/canviarPipella/${rol}"/>"><fmt:message key="${rol}" />
       <c:if test="${not(empty avisos[rol])}">
         &nbsp; <span class="badge badge-warning">${avisos[rol]}</span>
       </c:if>
       </a>
    </li>
    </c:if>  
    </c:forEach>
    --%>

      <sec:authorize access="hasRole('ROLE_USER')">
      
       <li class="nav-item">
       <a href="<c:url value="/canviarPipella/user"/>"
 <%
        if (!Configuracio.isOcultarMenuInici()) {
        %>
        class="nav-link ${(pipella eq 'user')?'active' : '' }">
          <%
          }
          %> <%
 if (Configuracio.isOcultarMenuInici()) {
 %>
         class="nav-link ${(pipella eq 'user' or empty pipella)?'active' : '' }">
            <%
            }
            %> 
                    
            <fmt:message key="usuari.rol" /></a>
        </li>
      </sec:authorize>

      <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li class="nav-item">
          <a href="<c:url value="/canviarPipella/admin"/>"
                    class="nav-link ${(pipella eq 'admin')?'active' : '' }"
          >
          <fmt:message key="administrador.rol" /> 
          
          <%
Long countNoTancats = (Long) request.getAttribute("adminwarning");
 if (countNoTancats != null && countNoTancats != 0) {
 %> &nbsp;<span
            class="badge badge-danger"><%=countNoTancats%></span> <%
 }
 %> </a></li>
      </sec:authorize>

      <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="nav-item"><a
                    class="nav-link ${(pipella eq 'webdb')?'active' : '' }"
                    href="<c:url value="/canviarPipella/webdb"/>">
                        WebDatabase</a></li>
      </sec:authorize>

      <c:if test="${dib:isDesenvolupament()}">
                <li class="nav-item"><a
                    class="nav-link ${(pipella eq 'desenvolupament')?'active' : '' }"
                    href="<c:url value="/canviarPipella/desenvolupament"/>">
                        <fmt:message key="desenvolupament" />
                </a></li>
      </c:if>

    </ul>


    <!-- INICI MENU + CONTINGUT -->
        <div class="well well-white" style="padding: 10px">
            <tiles:insertAttribute name="menu_i_contingut">
                <tiles:putAttribute name="menu"
                    value="${menu_tile}" />
                <tiles:putAttribute name="contingut"
                    value="${contingut_tile}" />
            </tiles:insertAttribute>
            <%-- FINAL MENU + CONTINGUT --%>
        </div>

        <%-- FINAL DIV PIPELLES --%>
    </div>

    <div class="container-fluid">
        <tiles:insertAttribute name="peu">
        </tiles:insertAttribute>
    </div>

</body>
</html>