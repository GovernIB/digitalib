<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="TransaccioFields" className="es.caib.digitalib.model.fields.TransaccioFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[transaccio.transaccioID]}" />
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


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.TRANSACCIOID)}">
          <td>
          ${transaccio.transaccioID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.TRANSACTIONWEBID)}">
          <td>
          ${transaccio.transactionWebId}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.DATAINICI)}">
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${transaccio.datainici}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.DATAFI)}">
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${transaccio.datafi}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.USUARIAPLICACIOID)}">
          <td>
          ${transaccio.usuariaplicacioid}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.USUARIPERSONAID)}">
          <td>
          ${transaccio.usuaripersonaid}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ESTATCODI)}">
          <td>
          <c:set var="tmp">${transaccio.estatcodi}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForEstatcodi[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ESTATMISSATGE)}">
          <td>
          ${transaccio.estatmissatge}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ESTATEXCEPCIO)}">
          <td>
          ${transaccio.estatexcepcio}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FITXERESCANEJATID)}">
          <td>
            <c:if test="${not empty transaccio.fitxerEscanejat}">
              <a target="_blank" href="<c:url value="${dib:fileUrl(transaccio.fitxerEscanejat)}"/>">${transaccio.fitxerEscanejat.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FITXERSIGNATURAID)}">
          <td>
            <c:if test="${not empty transaccio.fitxerSignatura}">
              <a target="_blank" href="<c:url value="${dib:fileUrl(transaccio.fitxerSignatura)}"/>">${transaccio.fitxerSignatura.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANPIXELTYPE)}">
          <td>
          ${transaccio.infoscanpixeltype}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANRESOLUCIOPPP)}">
          <td>
          ${transaccio.infoscanresolucioppp}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANOCR)}">
          <td>
            &nbsp;<c:if test="${not empty transaccio.infoscanocr}">
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${transaccio.infoscanocr?'success':'error'}.png"/>">
            </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSIGNATURAID)}">
          <td>
          <c:set var="tmp">${transaccio.infosignaturaid}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfInfoSignaturaForInfosignaturaid[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOCUSTODYID)}">
          <td>
          <c:set var="tmp">${transaccio.infocustodyid}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfInfoCustodyForInfocustodyid[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.LANGUAGEUI)}">
          <td>
          ${transaccio.languageui}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.LANGUAGEDOC)}">
          <td>
          ${transaccio.languagedoc}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.CIUTADANIF)}">
          <td>
          ${transaccio.ciutadanif}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.CIUTADANOM)}">
          <td>
          ${transaccio.ciutadanom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FUNCIONARIUSERNAME)}">
          <td>
          ${transaccio.funcionariusername}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FUNCIONARINOM)}">
          <td>
          ${transaccio.funcionarinom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.EXPEDIENT)}">
          <td>
          ${transaccio.expedient}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.PERFILID)}">
          <td>
          <c:set var="tmp">${transaccio.perfilid}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPerfilForPerfilid[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.USERNAMEREQUEST)}">
          <td>
          ${transaccio.usernameRequest}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.RETURNURL)}">
          <td>
          ${transaccio.returnUrl}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.VIEW)}">
          <td>
          <c:set var="tmp">${transaccio.view}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForView[tmp]}
          </c:if>
          </td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[transaccio.transaccioID]}" />
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


