<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PerfilFields" className="es.caib.digitalib.model.fields.PerfilFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.PERFILID)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.PERFILID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.CODI)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.CODI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.NOM)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.DESCRIPCIO)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.DESCRIPCIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.URLBASE)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.URLBASE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.SCANFORMATFITXER)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.SCANFORMATFITXER)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.SCANMINIMARESOLUCIO)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.SCANMINIMARESOLUCIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.SCANPIXELTYPE)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.SCANPIXELTYPE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.PLUGINSCANWEBID)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.PLUGINSCANWEBID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.PLUGINSCANWEB2ID)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.PLUGINSCANWEB2ID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.TIPUSFIRMA)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.TIPUSFIRMA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.APISIMPLEID)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.APISIMPLEID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.PLUGINFIRMASERVIDORID)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.PLUGINFIRMASERVIDORID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.TIPUSCUSTODIA)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.TIPUSCUSTODIA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.PLUGINARXIUID)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.PLUGINARXIUID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.PLUGINDOCCUSTODYID)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.PLUGINDOCCUSTODYID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.USPERFIL)}">
        <th>${dib:getSortIcons(__theFilterForm,PerfilFields.USPERFIL)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

