<%@ page contentType="text/html;charset=UTF-8" language="java"%><%@ include
  file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
  <h5>
    <fmt:message key="usuari.menu" />
  </h5>
  <ul class="tree" style="margin: 3px; padding: 0px;">
    <%--

    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/user/option1"/>">
        <span style="${(fn:contains(url, 'option1'))? "font-weight: bold;" : ""}">Menú USER Option 1</span>
      </a>
    </li>

    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/user/option2"/>">
        <span style="${(fn:contains(url, 'option2'))? "font-weight: bold;" : ""}">Menú USER Option 2</span>
      </a>
    </li>


--%>
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
          <fmt:message key="escanejar" />
      </span>
    </a></li>


    <hr style="margin-top: 6px; margin-bottom: 6px;" />


    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/user/transaccio/nomesescaneig/list"/>"> <span
        style="${(fn:contains(url, '/user/transaccio/nomesescaneig/'))? "font-weight:bold;" : ""}">

          <fmt:message key="transaccio.tipus.1.plural" />
      </span>
    </a></li>

    <hr style="margin-top: 6px; margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/user/transaccio/copiaautentica/list"/>"> <span
        style="${(fn:contains(url, '/user/transaccio/copiaautentica/'))? "font-weight:bold;" : ""}">

          <fmt:message key="transaccio.tipus.2.plural" />
      </span>
    </a></li>

    <hr style="margin-top: 6px; margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/user/transaccio/custodia/list"/>"> <span
        style="${(fn:contains(url, '/user/transaccio/custodia/'))? "font-weight:bold;" : ""}">

          <fmt:message key="transaccio.tipus.3.plural" />
      </span>
    </a></li>

  </ul>
</div>

