<%@ page contentType="text/html;charset=UTF-8" language="java"%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
    <h5 style="margin: 0px 0;">
        <fmt:message key="administrador.menu" />
    </h5>
    <ul class="tree" style="margin: 3px; padding: 0px;">

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/pluginscanweb/list"/>">
                <span style="${(fn:contains(url, 'pluginscanweb/'))? "font-weight:bold;" : ""}"><fmt:message key="scanwebplugin.menu" /></span>
            </a></li>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/pluginfirmaenservidor/list"/>">
                <span style="${(fn:contains(url, 'pluginfirmaenservidor/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="firmaenservidorplugin.menu" /></span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/pluginsegelltemps/list"/>">
                <span style="${(fn:contains(url, 'pluginsegelltemps/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="pluginsegelltemps.menu" /></span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/conffirma/list"/>">
                <span style="${(fn:contains(url, '/admin/conffirma/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="configuracioFirma.configuracioFirma" /></span>
            </a></li>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />


        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/apisimple/list"/>">
                <span style="${(fn:contains(url, '/apisimple/'))? "font-weight:bold;" : ""}"><fmt:message key="apisimple.gestio" /></span>
            </a></li>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />


        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/pluginarxiu/list"/>">
                <span style="${(fn:contains(url, 'pluginarxiu/'))? "font-weight:bold;" : ""}"><fmt:message key="arxiuplugin.menu" /></span>
            </a></li>


        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/infoCustodyNoTancat/list"/>">
                <span style="${(fn:contains(url, 'infoCustodyNoTancat/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="expedientsnotancats" /> <%
 Long countNoTancats = (Long) request.getAttribute("adminwarning");
 if (countNoTancats != null && countNoTancats != 0) {
 %> &nbsp; <span class="badge badge-danger"><%=countNoTancats%></span> <%
 }
 %>

                </span>
            </a></li>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/plugindoccustody/list"/>">
                <span style="${(fn:contains(url, 'plugindoccustody/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="doccustodyplugin.menu" /></span>

            </a></li>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/plugincridada/list"/>">
                <span style="${(fn:contains(url, '/admin/plugincridada'))? "font-weight:bold;" : ""}"><fmt:message
                        key="monitor.integracions" /></span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/fitxersorfes/list"/>">
                <span style="${(fn:contains(url, '/admin/fitxersorfes'))? "font-weight:bold;" : ""}"><fmt:message key="fitxers.orfes" /></span>

            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/avis/list"/>">
                <span style="${(fn:contains(url, '/admin/avis'))? "font-weight:bold;" : ""}"><fmt:message key="avis.avis.plural" /></span>

            </a></li>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/transaccionscaducades/list"/>">
                <span style="${(fn:contains(url, '/admin/netejartransaccionscaducades'))? "font-weight:bold;" : ""}"><fmt:message
                        key="netejartransaccionscaducades.plural" /></span>
            </a></li>


        <li style="list-style-type: disc; list-style-position: inside;"><a
                href="<c:url value="/admin/transaccionssensehashdefitxer/list"/>">
                <span style="${(fn:contains(url, '/admin/transaccionssensehashdefitxer'))? "font-weight:bold;" : ""}"><fmt:message
                        key="transaccionssensehashdefitxer.plural" /></span>

            </a></li>

    </ul>
</div>






