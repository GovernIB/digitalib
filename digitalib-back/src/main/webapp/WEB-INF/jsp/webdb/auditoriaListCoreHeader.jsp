<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="AuditoriaFields" className="es.caib.digitalib.model.fields.AuditoriaFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AuditoriaFields.AUDITORIAID)}">
        <th>${dib:getSortIcons(__theFilterForm,AuditoriaFields.AUDITORIAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AuditoriaFields.DATA)}">
        <th>${dib:getSortIcons(__theFilterForm,AuditoriaFields.DATA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AuditoriaFields.TRANSACCIOID)}">
        <th>${dib:getSortIcons(__theFilterForm,AuditoriaFields.TRANSACCIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AuditoriaFields.TIPUS)}">
        <th>${dib:getSortIcons(__theFilterForm,AuditoriaFields.TIPUS)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AuditoriaFields.MISSATGE)}">
        <th>${dib:getSortIcons(__theFilterForm,AuditoriaFields.MISSATGE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AuditoriaFields.ADDITIONALINFO)}">
        <th>${dib:getSortIcons(__theFilterForm,AuditoriaFields.ADDITIONALINFO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AuditoriaFields.ISAPP)}">
        <th>${dib:getSortIcons(__theFilterForm,AuditoriaFields.ISAPP)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AuditoriaFields.USERNAMEAPLICACIO)}">
        <th>${dib:getSortIcons(__theFilterForm,AuditoriaFields.USERNAMEAPLICACIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AuditoriaFields.USERNAMEPERSONA)}">
        <th>${dib:getSortIcons(__theFilterForm,AuditoriaFields.USERNAMEPERSONA)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

