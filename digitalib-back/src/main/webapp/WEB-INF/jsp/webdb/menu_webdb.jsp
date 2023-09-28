<%@ page contentType="text/html;charset=UTF-8" language="java"%>
 <%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 <c:set var="url" value="${urlActual}" />
 <div>
 <h5>WebDatabase</h5>
 <ul class="tree" style="margin:3px; padding:0px;">
 <%-- ==== GENAPP MARK START --%>


    <%-- ApiSimple --%>
       <fmt:message var="entityname" key="apiSimple.apiSimple.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/apiSimple/list/1"/>" ><span style="${(fn:contains(url, 'apiSimple/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Auditoria --%>
       <fmt:message var="entityname" key="auditoria.auditoria.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/auditoria/list/1"/>" ><span style="${(fn:contains(url, 'auditoria/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Avis --%>
       <fmt:message var="entityname" key="avis.avis.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/avis/list/1"/>" ><span style="${(fn:contains(url, 'avis/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- ConfiguracioFirma --%>
       <fmt:message var="entityname" key="configuracioFirma.configuracioFirma.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/configuracioFirma/list/1"/>" ><span style="${(fn:contains(url, 'configuracioFirma/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- ConfiguracioGrup --%>
       <fmt:message var="entityname" key="configuracioGrup.configuracioGrup.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/configuracioGrup/list/1"/>" ><span style="${(fn:contains(url, 'configuracioGrup/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Estadistica --%>
       <fmt:message var="entityname" key="estadistica.estadistica.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/estadistica/list/1"/>" ><span style="${(fn:contains(url, 'estadistica/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Fitxer --%>
       <fmt:message var="entityname" key="fitxer.fitxer.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/fitxer/list/1"/>" ><span style="${(fn:contains(url, 'fitxer/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Idioma --%>
       <fmt:message var="entityname" key="idioma.idioma.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/idioma/list/1"/>" ><span style="${(fn:contains(url, 'idioma/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- InfoCustody --%>
       <fmt:message var="entityname" key="infoCustody.infoCustody.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/infoCustody/list/1"/>" ><span style="${(fn:contains(url, 'infoCustody/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- InfoSignatura --%>
       <fmt:message var="entityname" key="infoSignatura.infoSignatura.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/infoSignatura/list/1"/>" ><span style="${(fn:contains(url, 'infoSignatura/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Metadada --%>
       <fmt:message var="entityname" key="metadada.metadada.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/metadada/list/1"/>" ><span style="${(fn:contains(url, 'metadada/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Perfil --%>
       <fmt:message var="entityname" key="perfil.perfil.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/perfil/list/1"/>" ><span style="${(fn:contains(url, 'perfil/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- PerfilUsuariAplicacio --%>
       <fmt:message var="entityname" key="perfilUsuariAplicacio.perfilUsuariAplicacio.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/perfilUsuariAplicacio/list/1"/>" ><span style="${(fn:contains(url, 'perfilUsuariAplicacio/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Plugin --%>
       <fmt:message var="entityname" key="plugin.plugin.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/plugin/list/1"/>" ><span style="${(fn:contains(url, 'plugin/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- PluginCridada --%>
       <fmt:message var="entityname" key="pluginCridada.pluginCridada.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/pluginCridada/list/1"/>" ><span style="${(fn:contains(url, 'pluginCridada/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Traduccio --%>
       <fmt:message var="entityname" key="traduccio.traduccio.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/traduccio/list/1"/>" ><span style="${(fn:contains(url, 'traduccio/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- Transaccio --%>
       <fmt:message var="entityname" key="transaccio.transaccio.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/transaccio/list/1"/>" ><span style="${(fn:contains(url, 'transaccio/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- TransaccioMultiple --%>
       <fmt:message var="entityname" key="transaccioMultiple.transaccioMultiple.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/transaccioMultiple/list/1"/>" ><span style="${(fn:contains(url, 'transaccioMultiple/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- UsuariAplicacio --%>
       <fmt:message var="entityname" key="usuariAplicacio.usuariAplicacio.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/usuariAplicacio/list/1"/>" ><span style="${(fn:contains(url, 'usuariAplicacio/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>

    <%-- UsuariPersona --%>
       <fmt:message var="entityname" key="usuariPersona.usuariPersona.plural"/>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/usuariPersona/list/1"/>" ><span style="${(fn:contains(url, 'usuariPersona/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
${entityname}
        </span></a>
        </li>
<%-- ==== GENAPP MARK END --%>
 </ul>
 </div>
