<%@ page contentType="text/html;charset=UTF-8" language="java"
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
  <h5 style="margin: 0px 0;">
    <fmt:message key="administrador.menu.comu" />
  </h5>
  <ul class="tree" style="margin: 3px; padding: 0px;">

    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/pluginscanweb/list"/>"> <span
        style="${(fn:contains(url, 'pluginscanweb/'))? "font-weight:bold;" : ""}"><fmt:message
            key="scanwebplugin.menu" /></span>

    </a></li>

    <hr style="margin-top: 6px; margin-bottom: 6px;" />

    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/pluginfirmaenservidor/list"/>"> <span
        style="${(fn:contains(url, 'pluginfirmaenservidor/'))? "font-weight:bold;" : ""}"><fmt:message
            key="firmaenservidorplugin.menu" /></span>

    </a></li>

    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/pluginsegelltemps/list"/>"> <span
        style="${(fn:contains(url, 'pluginsegelltemps/'))? "font-weight:bold;" : ""}"><fmt:message
            key="pluginsegelltemps.menu" /></span>

    </a></li>

    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/conffirma/list"/>"> <span
        style="${(fn:contains(url, '/admin/conffirma/'))? "font-weight:bold;" : ""}"><fmt:message
            key="configuracioFirma.configuracioFirma" /></span>
    </a></li>

    <hr style="margin-top: 6px; margin-bottom: 6px;" />


    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/apisimple/list"/>"> <span
        style="${(fn:contains(url, '/apisimple/'))? "font-weight:bold;" : ""}"><fmt:message
            key="apisimple.gestio" /></span>

    </a></li>

    <hr style="margin-top: 6px; margin-bottom: 6px;" />


    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/pluginarxiu/list"/>"> <span
        style="${(fn:contains(url, 'pluginarxiu/'))? "font-weight:bold;" : ""}"><fmt:message
            key="arxiuplugin.menu" /></span>

    </a></li>


    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/infoCustodyNoTancat/list"/>"> <span
        style="${(fn:contains(url, 'infoCustodyNoTancat/'))? "font-weight:bold;" : ""}"><fmt:message
            key="expedientsnotancats" />
            <%
           Long countNoTancats = (Long) request.getAttribute("adminwarning");
           if (countNoTancats != null && countNoTancats != 0) {   %>
           &nbsp; <span class="badge badge-danger"><%=countNoTancats%></span> 
        <%  } %>
            
            </span>
    </a></li>

    <hr style="margin-top: 6px; margin-bottom: 6px;" />

    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/plugindoccustody/list"/>"> <span
        style="${(fn:contains(url, 'plugindoccustody/'))? "font-weight:bold;" : ""}"><fmt:message
            key="doccustodyplugin.menu" /></span>

    </a></li>

    <hr style="margin-top: 6px; margin-bottom: 6px;" />

    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/plugincridada/list"/>"> <span
        style="${(fn:contains(url, '/admin/plugincridada'))? "font-weight:bold;" : ""}"><fmt:message
            key="monitor.integracions" /></span>
    </a></li>

    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/fitxersorfes/list"/>"> <span
        style="${(fn:contains(url, '/admin/fitxersorfes'))? "font-weight:bold;" : ""}"><fmt:message
            key="fitxers.orfes" /></span>

    </a></li>

    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/avis/list"/>"> <span
        style="${(fn:contains(url, '/admin/avis'))? "font-weight:bold;" : ""}"><fmt:message
            key="avis.avis.plural" /></span>

    </a></li>
    
   <hr style="margin-top: 6px; margin-bottom: 6px;" />

    <li style="list-style-type: disc; list-style-position: inside;"><a
      href="<c:url value="/admin/netejartransaccionscaducades"/>"> <span
        style="${(fn:contains(url, '/admin/netejartransaccionscaducades'))? "font-weight:bold;" : ""}"><fmt:message
            key="netejartransaccionscaducades" /></span>
    </a></li>
   
    
</div>
</div>
<div class="thumbnail" style="margin-top: 20px;">
  <div>
    <h5 style="margin: 0px 0;">
      <fmt:message key="administrador.menu.digitalib" />
    </h5>
    <ul class="tree" style="margin: 3px; padding: 0px;">

      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/usuariPersona/list"/>"> <span
          style="${(fn:contains(url, '/usuariPersona/'))? "font-weight:bold;" : ""}"><fmt:message
              key="usuaripersona.gestio" /></span>

      </a></li>

      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/configuracioGrup/list"/>"> <span
          style="${(fn:contains(url, '/configuracioGrup/'))? "font-weight:bold;" : ""}"><fmt:message
              key="configuraciogrup.gestio" /></span>

      </a></li>

      <hr style="margin-top: 6px; margin-bottom: 6px;" />



      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/transacciopersona/list"/>"> <span
          style="${(fn:contains(url, '/transacciopersona/'))? "font-weight:bold;" : ""}"><fmt:message
              key="transaccio.gestio.persona" /></span>

      </a></li>


      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/auditoria/persona/list"/>"> <span
          style="${(fn:contains(url, '/admin/auditoria/persona/'))? "font-weight:bold;" : ""}"><fmt:message
              key="auditoria.auditoria" /></span>
      </a></li>

      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/transaccioestadisticapersona/list"/>"> <span
          style="${(fn:contains(url, '/transaccioestadisticapersona/'))? "font-weight:bold;" : ""}"><fmt:message
              key="transaccio.estadistica.plural" /></span>
      </a></li>
      
      <li style="list-style-type: disc; list-style-position: inside;">
        <a href="<c:url value="/admin/netejafitxerspersona/list"/>"> <span
        style="${(fn:contains(url, '//admin/netejafitxerspersona'))? "font-weight:bold;" : ""}"><fmt:message
            key="netejafitxerstransaccions" /></span>
        </a>
      </li>

      <hr style="margin-top: 6px; margin-bottom: 6px;" />

      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/perfilnomesescaneig/perpersona/list"/>"> <span
          style="${(fn:contains(url, 'perfilnomesescaneig/perpersona'))? "font-weight:bold;" : ""}">

            <fmt:message key="perfil.us.1.plural" />

        </span>
      </a></li>

      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/perfilcopiaautentica/perpersona/list"/>"> <span
          style="${(fn:contains(url, 'perfilcopiaautentica/perpersona'))? "font-weight:bold;" : ""}">
            <fmt:message key="perfil.us.2.plural" />
        </span>
      </a></li>

      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/perfilcustodia/perpersona/list"/>"> <span
          style="${(fn:contains(url, 'perfilcustodia/perpersona'))? "font-weight:bold;" : ""}">
            <fmt:message key="perfil.us.3.plural" />
        </span>
      </a></li>

    </ul>
  </div>
</div>
<div class="thumbnail" style="margin-top: 20px;">
  <div>
    <h5 style="margin: 0px 0;">
      <fmt:message key="administrador.menu.copiaautentica" />
    </h5>
    <ul class="tree" style="margin: 3px; padding: 0px;">


      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/usuariAplicacio/list"/>"> <span
          style="${(fn:contains(url, '/usuariAplicacio/'))? "font-weight:bold;" : ""}"><fmt:message
              key="usuariaplicacio.gestio" /></span>

      </a></li>

      <hr style="margin-top: 6px; margin-bottom: 6px;" />



      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/transaccioaplicacio/list"/>"> <span
          style="${(fn:contains(url, '/transaccioaplicacio/'))? "font-weight:bold;" : ""}"><fmt:message
              key="transaccio.gestio.aplicacio" /></span>

      </a></li>

      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/auditoria/aplicacio/list"/>"> <span
          style="${(fn:contains(url, '/admin/auditoria/aplicacio/'))? "font-weight:bold;" : ""}"><fmt:message
              key="auditoria.auditoria" /></span>
      </a></li>


      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/transaccioestadisticaaplicacio/list"/>"> <span
          style="${(fn:contains(url, '/transaccioestadisticaaplicacio/'))? "font-weight:bold;" : ""}"><fmt:message
              key="transaccio.estadistica.plural" /></span>
      </a></li>
      
      <li style="list-style-type: disc; list-style-position: inside;">
        <a href="<c:url value="/admin/netejafitxersaplicacio/list"/>"> <span
        style="${(fn:contains(url, '//admin/netejafitxersaplicacio'))? "font-weight:bold;" : ""}"><fmt:message
            key="netejafitxerstransaccions" /></span>
        </a>
      </li>

      <hr style="margin-top: 6px; margin-bottom: 6px;" />

      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/perfilnomesescaneig/peraplicacio/list"/>"> <span
          style="${(fn:contains(url, 'perfilnomesescaneig/peraplicacio'))? "font-weight:bold;" : ""}">
            <fmt:message key="perfil.us.1.plural" />
        </span>
      </a></li>

      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/perfilcopiaautentica/peraplicacio/list"/>"> <span
          style="${(fn:contains(url, 'perfilcopiaautentica/peraplicacio'))? "font-weight:bold;" : ""}">
            <fmt:message key="perfil.us.2.plural" />
        </span>
      </a></li>


      <li style="list-style-type: disc; list-style-position: inside;"><a
        href="<c:url value="/admin/perfilcustodia/peraplicacio/list"/>"> <span
          style="${(fn:contains(url, 'perfilcustodia/peraplicacio'))? "font-weight:bold;" : ""}">
            <fmt:message key="perfil.us.3.plural" />
        </span>
      </a></li>

    </ul>

  </div>



