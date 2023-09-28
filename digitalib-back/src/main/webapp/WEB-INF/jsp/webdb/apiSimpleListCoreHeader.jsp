<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ApiSimpleFields" className="es.caib.digitalib.model.fields.ApiSimpleFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ApiSimpleFields.APISIMPLEID)}">
        <th>${dib:getSortIcons(__theFilterForm,ApiSimpleFields.APISIMPLEID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ApiSimpleFields.NOM)}">
        <th>${dib:getSortIcons(__theFilterForm,ApiSimpleFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ApiSimpleFields.URL)}">
        <th>${dib:getSortIcons(__theFilterForm,ApiSimpleFields.URL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ApiSimpleFields.USERNAME)}">
        <th>${dib:getSortIcons(__theFilterForm,ApiSimpleFields.USERNAME)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ApiSimpleFields.CONTRASENYA)}">
        <th>${dib:getSortIcons(__theFilterForm,ApiSimpleFields.CONTRASENYA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ApiSimpleFields.PERFIL)}">
        <th>${dib:getSortIcons(__theFilterForm,ApiSimpleFields.PERFIL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ApiSimpleFields.CONFIGDEFIRMA)}">
        <th>${dib:getSortIcons(__theFilterForm,ApiSimpleFields.CONFIGDEFIRMA)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

