<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InfoCustodyFields" className="es.caib.digitalib.model.fields.InfoCustodyFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.INFOCUSTODYID)}">
        <th>${dib:getSortIcons(__theFilterForm,InfoCustodyFields.INFOCUSTODYID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.CUSTODYFILEID)}">
        <th>${dib:getSortIcons(__theFilterForm,InfoCustodyFields.CUSTODYFILEID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.CUSTODYFILEURL)}">
        <th>${dib:getSortIcons(__theFilterForm,InfoCustodyFields.CUSTODYFILEURL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.CSV)}">
        <th>${dib:getSortIcons(__theFilterForm,InfoCustodyFields.CSV)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.CSVVALIDATIONWEB)}">
        <th>${dib:getSortIcons(__theFilterForm,InfoCustodyFields.CSVVALIDATIONWEB)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.CSVGENERATIONDEFINITION)}">
        <th>${dib:getSortIcons(__theFilterForm,InfoCustodyFields.CSVGENERATIONDEFINITION)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

