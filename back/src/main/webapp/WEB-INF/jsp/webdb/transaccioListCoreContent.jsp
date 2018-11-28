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
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${transaccio.dataInici}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.DATAFI)}">
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${transaccio.dataFi}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.USUARIAPLICACIOID)}">
          <td>
          ${transaccio.usuariAplicacioId}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.USUARIPERSONAID)}">
          <td>
          ${transaccio.usuariPersonaId}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ESTATCODI)}">
          <td>
          <c:set var="tmp">${transaccio.estatCodi}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForEstatCodi[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ESTATMISSATGE)}">
          <td>
          ${transaccio.estatMissatge}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ESTATEXCEPCIO)}">
          <td>
          ${transaccio.estatExcepcio}
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
          ${transaccio.infoScanPixelType}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANRESOLUCIOPPP)}">
          <td>
          ${transaccio.infoScanResolucioPpp}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANOCR)}">
          <td>
            &nbsp;<c:if test="${not empty transaccio.infoScanOcr}">
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${transaccio.infoScanOcr?'success':'error'}.png"/>">
            </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSIGNATURAID)}">
          <td>
          <c:set var="tmp">${transaccio.infoSignaturaID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfInfoSignaturaForInfoSignaturaID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOCUSTODYID)}">
          <td>
          <c:set var="tmp">${transaccio.infoCustodyID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfInfoCustodyForInfoCustodyID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.LANGUAGEUI)}">
          <td>
          ${transaccio.languageUI}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.LANGUAGEDOC)}">
          <td>
          ${transaccio.languageDoc}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.CIUTADANIF)}">
          <td>
          ${transaccio.ciutadaNif}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.CIUTADANOM)}">
          <td>
          ${transaccio.ciutadaNom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FUNCIONARIUSERNAME)}">
          <td>
          ${transaccio.funcionariUsername}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FUNCIONARINOM)}">
          <td>
          ${transaccio.funcionariNom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.EXPEDIENT)}">
          <td>
          ${transaccio.expedient}
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
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.PERFILID)}">
          <td>
          <c:set var="tmp">${transaccio.perfilID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPerfilForPerfilID[tmp]}
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


