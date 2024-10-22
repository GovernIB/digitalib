<%@ page contentType="text/html;charset=UTF-8" language="java"%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>

    <h5 style="margin: 0px 0;">
        <fmt:message key="administrador.digitalib.menu" />
    </h5>
    <ul class="tree" style="margin: 3px; padding: 0px;">

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/usuariPersona/list"/>">
                <span style="${(fn:contains(url, '/usuariPersona/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="usuaripersona.gestio" /></span>

            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/configuracioGrup/list"/>">
                <span style="${(fn:contains(url, '/configuracioGrup/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="configuraciogrup.gestio" /></span>

            </a></li>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />



        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/transacciopersona/list"/>">
                <span style="${(fn:contains(url, '/transacciopersona/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="transaccio.gestio.persona" /></span>

            </a></li>


        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/auditoria/persona/list"/>">
                <span style="${(fn:contains(url, '/admin/auditoria/persona/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="auditoria.auditoria" /></span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a
                href="<c:url value="/admin/transaccioestadisticapersona/list"/>">
                <span style="${(fn:contains(url, '/transaccioestadisticapersona/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="transaccio.estadistica.plural" /></span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/netejafitxerspersona/list"/>">
                <span style="${(fn:contains(url, '/admin/netejafitxerspersona'))? "font-weight:bold;" : ""}"><fmt:message
                        key="netejafitxerstransaccions" /></span>
            </a></li>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />

        <li style="list-style-type: disc; list-style-position: inside;"><a
                href="<c:url value="/admin/perfilnomesescaneig/perpersona/list"/>">
                <span style="${(fn:contains(url, 'perfilnomesescaneig/perpersona'))? "font-weight:bold;" : ""}"> <fmt:message
                        key="perfil.us.1.plural" />

                </span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a
                href="<c:url value="/admin/perfilcopiaautentica/perpersona/list"/>">
                <span style="${(fn:contains(url, 'perfilcopiaautentica/perpersona'))? "font-weight:bold;" : ""}"> <fmt:message
                        key="perfil.us.2.plural" />
                </span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a
                href="<c:url value="/admin/perfilcustodia/perpersona/list"/>">
                <span style="${(fn:contains(url, 'perfilcustodia/perpersona'))? "font-weight:bold;" : ""}"> <fmt:message
                        key="perfil.us.3.plural" />
                </span>
            </a></li>

    </ul>
</div>




