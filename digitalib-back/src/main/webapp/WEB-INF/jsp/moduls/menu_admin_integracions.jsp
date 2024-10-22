<%@ page contentType="text/html;charset=UTF-8" language="java"%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>

    <h5 style="margin: 0px 0;">
        <fmt:message key="administrador.integracions.menu" />
    </h5>
    <ul class="tree" style="margin: 3px; padding: 0px;">


        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/usuariAplicacio/list"/>">
                <span style="${(fn:contains(url, '/usuariAplicacio/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="usuariaplicacio.gestio" /></span>

            </a></li>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />



        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/transaccioaplicacio/list"/>">
                <span style="${(fn:contains(url, '/transaccioaplicacio/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="transaccio.gestio.aplicacio" /></span>

            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/auditoria/aplicacio/list"/>">
                <span style="${(fn:contains(url, '/admin/auditoria/aplicacio/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="auditoria.auditoria" /></span>
            </a></li>


        <li style="list-style-type: disc; list-style-position: inside;"><a
                href="<c:url value="/admin/transaccioestadisticaaplicacio/list"/>">
                <span style="${(fn:contains(url, '/admin/transaccioestadisticaaplicacio/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="transaccio.estadistica.plural" /></span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/netejafitxersaplicacio/list"/>">
                <span style="${(fn:contains(url, '/admin/netejafitxersaplicacio'))? "font-weight:bold;" : ""}"><fmt:message
                        key="netejafitxerstransaccions" /></span>
            </a></li>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />

        <li style="list-style-type: disc; list-style-position: inside;"><a
                href="<c:url value="/admin/perfilnomesescaneig/peraplicacio/list"/>">
                <span style="${(fn:contains(url, 'perfilnomesescaneig/peraplicacio'))? "font-weight:bold;" : ""}"> <fmt:message
                        key="perfil.us.1.plural" />
                </span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a
                href="<c:url value="/admin/perfilcopiaautentica/peraplicacio/list"/>">
                <span style="${(fn:contains(url, 'perfilcopiaautentica/peraplicacio'))? "font-weight:bold;" : ""}"> <fmt:message
                        key="perfil.us.2.plural" />
                </span>
            </a></li>


        <li style="list-style-type: disc; list-style-position: inside;"><a
                href="<c:url value="/admin/perfilcustodia/peraplicacio/list"/>">
                <span style="${(fn:contains(url, 'perfilcustodia/peraplicacio'))? "font-weight:bold;" : ""}"> <fmt:message
                        key="perfil.us.3.plural" />
                </span>
            </a></li>

    </ul>

</div>



