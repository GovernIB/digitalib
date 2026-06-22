<%@page import="es.caib.digitalib.commons.utils.Configuracio"%>
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
        
        
        <% if (!Configuracio.isOcultarPluginFirmaEnServidor()) { %>
        

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
        
        <% } %>


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
 %> </span>
            </a></li>

<% if (!Configuracio.isOcultarDocumentCustody()) { %>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/plugindoccustody/list"/>">
                <span style="${(fn:contains(url, 'plugindoccustody/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="doccustodyplugin.menu" /></span>

            </a></li>
            
<% } %>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/plugincridada/list"/>">
                <span style="${(fn:contains(url, '/admin/plugincridada'))? "font-weight:bold;" : ""}"><fmt:message
                        key="monitor.integracions" /></span>
            </a></li>


        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/avis/list"/>">
                <span style="${(fn:contains(url, '/admin/avis'))? "font-weight:bold;" : ""}"><fmt:message key="avis.avis.plural" /></span>

            </a></li>


        <hr style="margin-top: 6px; margin-bottom: 6px;" />

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/fitxersorfesdiscdur/list"/>">
                <span style="${(fn:contains(url, '/admin/fitxersorfesdiscdur'))? "font-weight:bold;" : ""}"><fmt:message
                        key="fitxers.orfes.discdur" /></span>

            </a></li>


        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/fitxersorfesbbdd/list"/>">
                <span style="${(fn:contains(url, '/admin/fitxersorfesbbdd'))? "font-weight:bold;" : ""}"><fmt:message
                        key="fitxers.orfes.bbdd" /></span>

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

        <hr style="margin-top: 6px; margin-bottom: 6px;" />

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/actualitzarusername/new"/>">
                <span style="${(fn:contains(url, '/admin/actualitzarusername/'))? "font-weight:bold;" : ""}"><fmt:message
                        key="updateusername.title" /></span>

            </a></li>

        <hr style="margin-top: 6px; margin-bottom: 6px;" />

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/properties"/>">
                <span style="${(fn:contains(url, '/admin/properties'))? "font-weight:bold;" : ""}">Contingut de digitalib.properties</span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/systemproperties"/>">
                <span style="${(fn:contains(url, '/admin/systemproperties'))? "font-weight:bold;" : ""}">Contingut de
                    digitalib.system.properties</span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/reloadproperties"/>">
                <span style="${(fn:contains(url, '/admin/reloadproperties'))? "font-weight:bold;" : ""}">Recarregar fitxers de
                    properties</span>
            </a></li>

        <li style="list-style-type: disc; list-style-position: inside;"><a href="<c:url value="/admin/editproperties"/>">
                <span style="${(fn:contains(url, '/admin/editproperties'))? "font-weight:bold;" : ""}">Editar fitxer
                    digitalib.properties</span>
            </a></li>


    </ul>
</div>






