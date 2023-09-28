<%--
XYZ ZZZ 
<%@page import="es.caib.digitalib.commons.utils.Build"%> 
--%>
<%@page import="es.caib.digitalib.logic.utils.LogicUtils"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%><%@ include
	file="/WEB-INF/jsp/moduls/includes.jsp"%>

<table border=0 cellpadding="0" cellspacing="0" width="100%">

	<tr>
		<td width="40%" valign="top">
			<div class="pull-left colophon">
				<b><fmt:message key="app.nom" /> v<%=LogicUtils.getVersio()%></b><br />
				<i><a href="http://otaeweb.ibit.org/" target="_blank"><fmt:message
							key="desenvolupatper" /></a></i><br />
				<!-- Button to trigger modal -->
				<c:if test="${not empty loginInfo.usuariPersona.configuracioGrup}">
					<small><a href="#modalAjuda" role="button"
						data-toggle="modal"><fmt:message key="ajuda.necessitau" /></a></small>
				</c:if>
			</div>
		</td>

		<td width="20%" valign="top">
			<div class="center" style="margin-top: 20px;">
				<p style="font-size: 16px; margin-bottom:8px">${loginInfo.usuariPersona.configuracioGrup.nom }</p>
				<c:if test="${not empty loginInfo.usuariPersona.configuracioGrup}">
					<c:out value="${loginInfo.usuariPersona.configuracioGrup.adreza}"
						escapeXml="false" />
				</c:if>
			</div>
		</td>

		<td width="40%" valign="top">
			<div class="pull-right govern-footer">

				<c:if test="${not empty loginInfo.usuariPersona.configuracioGrup}">
					<a
						href="<c:out value="${loginInfo.usuariPersona.configuracioGrup.suportWeb}" />"
						target="_blank"> <img
						src="<c:url value="${dib:fileUrl(loginInfo.usuariPersona.configuracioGrup.logoFooter)}"/>"
						alt="${loginInfo.usuariPersona.configuracioGrup.nom }" />
					</a>
				</c:if>

			</div>
		</td>
	</tr>
</table>

<c:if test="${not empty loginInfo.usuariPersona.configuracioGrup}">
	<!-- Modal -->
	<div id="modalAjuda" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="<fmt:message key="ajuda.titol" />"
		aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">
				<fmt:message key="ajuda.titol" />
			</h3>
		</div>
		<div class="modal-body">
			<p>
				<fmt:message key="ajuda.missatge" />
			</p>

			<ul>
				<li><a></a><fmt:message key="ajuda.viatelefon" />${loginInfo.usuariPersona.configuracioGrup.suportTelefon }
				</li>
				<li><fmt:message key="ajuda.viaweb" /><a
					href="${loginInfo.usuariPersona.configuracioGrup.suportWeb }">Web oficial
						de ${loginInfo.usuariPersona.configuracioGrup.nom}</a></li>
				<li><fmt:message key="ajuda.viaemail" /><a
					href="mailto: ${loginInfo.usuariPersona.configuracioGrup.suportEmail }">
						${loginInfo.usuariPersona.configuracioGrup.suportEmail }</a></li>
			</ul>

		</div>
	</div>
</c:if>