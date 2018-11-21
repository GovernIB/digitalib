<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InfoCustodyFields" className="es.caib.digitalib.model.fields.InfoCustodyFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[infoCustody.infoCustodyID]}" />
             </c:if>
             <c:if test="${not empty __entry.value.valueField }">
               <c:set var="__tmp" value="${pageScope}" />
               <c:set var="__trosos" value="${fn:split(__entry.value.valueField.fullName,'.')}" />
               <c:forEach var="__tros" items="${__trosos}">
                  <c:set var="__tmp" value="${__tmp[__tros]}" />
               </c:forEach>
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__tmp}" />
             </c:if>
          </td>
          </c:if>
          </c:forEach>


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.INFOCUSTODYID)}">
          <td>
          ${infoCustody.infoCustodyID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.CUSTODYFILEID)}">
          <td>
          ${infoCustody.custodyFileId}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.CUSTODYFILEURL)}">
          <td>
          ${infoCustody.custodyFileUrl}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.CSV)}">
          <td>
          ${infoCustody.csv}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.CSVVALIDATIONWEB)}">
          <td>
          ${infoCustody.csvValidationWeb}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoCustodyFields.CSVGENERATIONDEFINITION)}">
          <td>
          ${infoCustody.csvGenerationDefinition}
          </td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[infoCustody.infoCustodyID]}" />
             </c:if>
             <c:if test="${not empty __entry.value.valueField }">
               <c:set var="__tmp" value="${pageScope}" />
               <c:set var="__trosos" value="${fn:split(__entry.value.valueField.fullName,'.')}" />
               <c:forEach var="__tros" items="${__trosos}">
                  <c:set var="__tmp" value="${__tmp[__tros]}" />
               </c:forEach>
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__tmp}" />
             </c:if>
          </td>
          </c:if>
          </c:forEach>


