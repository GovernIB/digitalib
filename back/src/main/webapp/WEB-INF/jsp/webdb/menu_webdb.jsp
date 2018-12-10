<%@ page contentType="text/html;charset=UTF-8" language="java"%>
 <%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 <c:set var="url" value="${urlActual}" />
 <div>
 <h5>WebDatabase</h5>
 <ul class="tree" style="margin:3px; padding:0px;">
 <%-- ==== GENAPP MARK START --%>


    <%-- ApiSimple --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'apiSimple/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'apiSimple/')? "font-weight: bold;" : ""}"><fmt:message key="apiSimple.apiSimple"/></span></a>
      <ul class="${fn:contains(url, 'apiSimple/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/apiSimple/new"/>" ><span style="${(fn:contains(url, 'apiSimple/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="apiSimple.apiSimple"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/apiSimple/list/1"/>" ><span style="${(fn:contains(url, 'apiSimple/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- ConfiguracioFirma --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'configuracioFirma/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'configuracioFirma/')? "font-weight: bold;" : ""}"><fmt:message key="configuracioFirma.configuracioFirma"/></span></a>
      <ul class="${fn:contains(url, 'configuracioFirma/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/configuracioFirma/new"/>" ><span style="${(fn:contains(url, 'configuracioFirma/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="configuracioFirma.configuracioFirma"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/configuracioFirma/list/1"/>" ><span style="${(fn:contains(url, 'configuracioFirma/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- ConfiguracioGrup --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'configuracioGrup/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'configuracioGrup/')? "font-weight: bold;" : ""}"><fmt:message key="configuracioGrup.configuracioGrup"/></span></a>
      <ul class="${fn:contains(url, 'configuracioGrup/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/configuracioGrup/new"/>" ><span style="${(fn:contains(url, 'configuracioGrup/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="configuracioGrup.configuracioGrup"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/configuracioGrup/list/1"/>" ><span style="${(fn:contains(url, 'configuracioGrup/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- Estadistica --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'estadistica/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'estadistica/')? "font-weight: bold;" : ""}"><fmt:message key="estadistica.estadistica"/></span></a>
      <ul class="${fn:contains(url, 'estadistica/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/estadistica/new"/>" ><span style="${(fn:contains(url, 'estadistica/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="estadistica.estadistica"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/estadistica/list/1"/>" ><span style="${(fn:contains(url, 'estadistica/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- Fitxer --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'fitxer/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'fitxer/')? "font-weight: bold;" : ""}"><fmt:message key="fitxer.fitxer"/></span></a>
      <ul class="${fn:contains(url, 'fitxer/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/fitxer/new"/>" ><span style="${(fn:contains(url, 'fitxer/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="fitxer.fitxer"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/fitxer/list/1"/>" ><span style="${(fn:contains(url, 'fitxer/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- Idioma --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'idioma/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'idioma/')? "font-weight: bold;" : ""}"><fmt:message key="idioma.idioma"/></span></a>
      <ul class="${fn:contains(url, 'idioma/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/idioma/new"/>" ><span style="${(fn:contains(url, 'idioma/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="idioma.idioma"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/idioma/list/1"/>" ><span style="${(fn:contains(url, 'idioma/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- InfoCustody --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'infoCustody/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'infoCustody/')? "font-weight: bold;" : ""}"><fmt:message key="infoCustody.infoCustody"/></span></a>
      <ul class="${fn:contains(url, 'infoCustody/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/infoCustody/new"/>" ><span style="${(fn:contains(url, 'infoCustody/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="infoCustody.infoCustody"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/infoCustody/list/1"/>" ><span style="${(fn:contains(url, 'infoCustody/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- InfoSignatura --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'infoSignatura/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'infoSignatura/')? "font-weight: bold;" : ""}"><fmt:message key="infoSignatura.infoSignatura"/></span></a>
      <ul class="${fn:contains(url, 'infoSignatura/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/infoSignatura/new"/>" ><span style="${(fn:contains(url, 'infoSignatura/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="infoSignatura.infoSignatura"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/infoSignatura/list/1"/>" ><span style="${(fn:contains(url, 'infoSignatura/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- Perfil --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'perfil/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'perfil/')? "font-weight: bold;" : ""}"><fmt:message key="perfil.perfil"/></span></a>
      <ul class="${fn:contains(url, 'perfil/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/perfil/new"/>" ><span style="${(fn:contains(url, 'perfil/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="perfil.perfil"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/perfil/list/1"/>" ><span style="${(fn:contains(url, 'perfil/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- PerfilUsuariAplicacio --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'perfilUsuariAplicacio/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'perfilUsuariAplicacio/')? "font-weight: bold;" : ""}"><fmt:message key="perfilUsuariAplicacio.perfilUsuariAplicacio"/></span></a>
      <ul class="${fn:contains(url, 'perfilUsuariAplicacio/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/perfilUsuariAplicacio/new"/>" ><span style="${(fn:contains(url, 'perfilUsuariAplicacio/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="perfilUsuariAplicacio.perfilUsuariAplicacio"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/perfilUsuariAplicacio/list/1"/>" ><span style="${(fn:contains(url, 'perfilUsuariAplicacio/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- Plugin --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'plugin/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'plugin/')? "font-weight: bold;" : ""}"><fmt:message key="plugin.plugin"/></span></a>
      <ul class="${fn:contains(url, 'plugin/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/plugin/new"/>" ><span style="${(fn:contains(url, 'plugin/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="plugin.plugin"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/plugin/list/1"/>" ><span style="${(fn:contains(url, 'plugin/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- PluginCridada --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'pluginCridada/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'pluginCridada/')? "font-weight: bold;" : ""}"><fmt:message key="pluginCridada.pluginCridada"/></span></a>
      <ul class="${fn:contains(url, 'pluginCridada/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/pluginCridada/new"/>" ><span style="${(fn:contains(url, 'pluginCridada/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="pluginCridada.pluginCridada"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/pluginCridada/list/1"/>" ><span style="${(fn:contains(url, 'pluginCridada/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- Traduccio --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'traduccio/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'traduccio/')? "font-weight: bold;" : ""}"><fmt:message key="traduccio.traduccio"/></span></a>
      <ul class="${fn:contains(url, 'traduccio/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/traduccio/new"/>" ><span style="${(fn:contains(url, 'traduccio/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="traduccio.traduccio"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/traduccio/list/1"/>" ><span style="${(fn:contains(url, 'traduccio/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- Transaccio --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'transaccio/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'transaccio/')? "font-weight: bold;" : ""}"><fmt:message key="transaccio.transaccio"/></span></a>
      <ul class="${fn:contains(url, 'transaccio/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/transaccio/new"/>" ><span style="${(fn:contains(url, 'transaccio/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="transaccio.transaccio"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/transaccio/list/1"/>" ><span style="${(fn:contains(url, 'transaccio/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- UsuariAplicacio --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'usuariAplicacio/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'usuariAplicacio/')? "font-weight: bold;" : ""}"><fmt:message key="usuariAplicacio.usuariAplicacio"/></span></a>
      <ul class="${fn:contains(url, 'usuariAplicacio/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/usuariAplicacio/new"/>" ><span style="${(fn:contains(url, 'usuariAplicacio/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="usuariAplicacio.usuariAplicacio"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/usuariAplicacio/list/1"/>" ><span style="${(fn:contains(url, 'usuariAplicacio/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>

    <%-- UsuariPersona --%>
    <li>
      <a href="#" role="branch" class="tree-toggle ${fn:contains(url, 'usuariPersona/')? "" : "closed"}" data-toggle="branch" data-value="suportada"><span style="${fn:contains(url, 'usuariPersona/')? "font-weight: bold;" : ""}"><fmt:message key="usuariPersona.usuariPersona"/></span></a>
      <ul class="${fn:contains(url, 'usuariPersona/')? "branch in" : "branch"}">
        <li style="list-style-type: disc; list-style-position: inside;" ><a href="<c:url value="/webdb/usuariPersona/new"/>" ><span style="${(fn:contains(url, 'usuariPersona/') && fn:contains(url, '/new'))? "font-weight: bold;" : ""}" >
       <fmt:message var="entityname" key="usuariPersona.usuariPersona"/>
       <fmt:message key="genapp.createtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
       </span></a></li>
        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/webdb/usuariPersona/list/1"/>" ><span style="${(fn:contains(url, 'usuariPersona/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
        <fmt:message key="genapp.listtitle" >
         <fmt:param value="${entityname}"/>
       </fmt:message>
        </span></a>
        </li>
      </ul>
    </li>
<%-- ==== GENAPP MARK END --%>
 </ul>
 </div>
