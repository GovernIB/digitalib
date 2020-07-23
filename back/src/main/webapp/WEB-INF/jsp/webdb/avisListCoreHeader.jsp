<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="AvisFields" className="es.caib.digitalib.model.fields.AvisFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AvisFields.AVISID)}">
        <th>${dib:getSortIcons(__theFilterForm,AvisFields.AVISID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AvisFields.DESCRIPCIOID)}">
        <th>${dib:getSortIcons(__theFilterForm,AvisFields.DESCRIPCIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AvisFields.TIPUS)}">
        <th>${dib:getSortIcons(__theFilterForm,AvisFields.TIPUS)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AvisFields.DATAINICI)}">
        <th>${dib:getSortIcons(__theFilterForm,AvisFields.DATAINICI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AvisFields.DATAFI)}">
        <th>${dib:getSortIcons(__theFilterForm,AvisFields.DATAFI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AvisFields.CONFIGGRUPID)}">
        <th>${dib:getSortIcons(__theFilterForm,AvisFields.CONFIGGRUPID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AvisFields.BLOQUEJAR)}">
        <th>${dib:getSortIcons(__theFilterForm,AvisFields.BLOQUEJAR)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

