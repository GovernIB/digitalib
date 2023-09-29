<%@page import="es.caib.digitalib.logic.utils.LogicUtils"%>
<%@page import="es.caib.digitalib.commons.utils.Configuracio"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/moduls/includes.jsp"%>

<footer id="footer">

    <div class="row mr-auto ml-3 mr-3 peuResponsive">

        <!-- Esquerra -->
        <div class="col-4 pt-2 elementPeuResponsive">
            <strong class="font-weight-bold h6"> ${versio.projectName} v${versio.version}<%=Configuracio.isCAIB() ? "-caib" : ""%>
            </strong> <br /> <small> Build: ${versio.buildTime} <br /> JDK: ${version.jdkVersion} <br /> <fmt:message
                    key="revisio" />: <c:if test="${empty versio.scmRevision}">
                    <fmt:message key="scmversion.msg" />
                </c:if> <c:if test="${not empty versio.scmRevision}">${versio.scmRevision}</c:if> <br /> <span
                style="padding-top: 2px"> <i><fmt:message key="desenvolupatper" /></i></span>
            </small>
        </div>

        <!-- Centre esquerra -->
        <div
            class="col-4 text-center pt-2 text-decoration-none bg-transparent text-uppercase p-2 opcionsPeu elementPeuResponsive">
            <div class="center" >
                <p style="font-size: 16px; margin-bottom: 8px">${loginInfo.usuariPersona.configuracioGrup.nom }</p>
                <small> <c:if test="${not empty loginInfo.usuariPersona.configuracioGrup}">
                        <c:out value="${loginInfo.usuariPersona.configuracioGrup.adreza}" escapeXml="false" />
                    </c:if>
                </small>
            </div>
        </div>

        <!-- Dreta -->
        <div class="col-4 text-right">
            <div style="margin-top: 8px;">
                <c:if test="${not empty loginInfo.usuariPersona.configuracioGrup}">
                    <a href="<c:out value="${loginInfo.usuariPersona.configuracioGrup.suportWeb}" />" target="_blank">
                        <img src="<c:url value="${dib:fileUrl(loginInfo.usuariPersona.configuracioGrup.logoFooter)}"/>"
                        alt="${loginInfo.usuariPersona.configuracioGrup.nom }" />
                    </a>
                </c:if>
                <br />
                <!-- Button to trigger modal -->
                <small> <a href="#modalAjuda" role="button" data-toggle="modal"><fmt:message
                            key="ajuda.necessitau" /></a> <%--
            <a styleClass="text-dark linkPeu" href="/mapaweb"> <fmt:message
                    key="labels.mapaweb" />
            </a><br /> <a styleClass="text-dark linkPeu" href="/accessibilitat">
                <fmt:message key="labels.accessibilitat" />
            </a><br /> <a styleClass="text-dark linkPeu" href="/protecciodades">
                <fmt:message key="labels.protecciodades" />
                --%> </a><br /> <a styleClass="text-dark linkPeu" href="<c:url value="/public/avislegal"/>"> <fmt:message
                            key="labels.avislegal" />
                </a>
                </small>
            </div>
        </div>

    </div>


    <!-- Modal -->
    <div id="modalAjuda" class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="modal-title h5">
                        <fmt:message key="ajuda.titol" />
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>
                        <fmt:message key="ajuda.missatge" />
                    </p>
                    <ul>
                        <li><fmt:message key="ajuda.viatelefon" />${loginInfo.usuariPersona.configuracioGrup.suportTelefon }</li>
                        <li><fmt:message key="ajuda.viaweb" /><a
                            href="${loginInfo.usuariPersona.configuracioGrup.suportWeb}"></a> Web oficial de
                            ${loginInfo.usuariPersona.configuracioGrup.nom} </a></li>
                        <li><fmt:message key="ajuda.viaemail" /> <a
                            href="mailto: ${loginInfo.usuariPersona.configuracioGrup.suportEmail }">
                                ${loginInfo.usuariPersona.configuracioGrup.suportEmail }</a></li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                        <fmt:message key="tancar" />
                    </button>
                </div>
            </div>
        </div>
    </div>
</footer>