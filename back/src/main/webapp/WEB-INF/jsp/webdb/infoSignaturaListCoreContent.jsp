<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InfoSignaturaFields" className="es.caib.digitalib.model.fields.InfoSignaturaFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[infoSignatura.infoSignaturaID]}" />
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


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.INFOSIGNATURAID)}">
          <td>
          <c:out value="${infoSignatura.infoSignaturaID}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.SIGNOPERATION)}">
          <td>
          <c:set var="tmp">${infoSignatura.signOperation}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForSignOperation[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.SIGNTYPE)}">
          <td>
          <c:out value="${infoSignatura.signType}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.SIGNALGORITHM)}">
          <td>
          <c:out value="${infoSignatura.signAlgorithm}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.SIGNMODE)}">
          <td>
          <c:set var="tmp">${infoSignatura.signMode}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForSignMode[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.SIGNATURESTABLELOCATION)}">
          <td>
          <c:set var="tmp">${infoSignatura.signaturesTableLocation}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForSignaturesTableLocation[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.TIMESTAMPINCLUDED)}">
          <td>
            &nbsp;<c:if test="${not empty infoSignatura.timestampIncluded}">
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${infoSignatura.timestampIncluded?'success':'error'}.png"/>">
            </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.POLICYINCLUDED)}">
          <td>
            &nbsp;<c:if test="${not empty infoSignatura.policyIncluded}">
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${infoSignatura.policyIncluded?'success':'error'}.png"/>">
            </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.ENITIPOFIRMA)}">
          <td>
          <c:out value="${infoSignatura.eniTipoFirma}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.ENIPERFILFIRMA)}">
          <td>
          <c:out value="${infoSignatura.eniPerfilFirma}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.ENIROLFIRMA)}">
          <td>
          <c:out value="${infoSignatura.eniRolFirma}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.ENISIGNERNAME)}">
          <td>
          <c:out value="${infoSignatura.eniSignerName}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.ENISIGNERADMINISTRATIONID)}">
          <td>
          <c:out value="${infoSignatura.eniSignerAdministrationId}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.ENISIGNLEVEL)}">
          <td>
          <c:out value="${infoSignatura.eniSignLevel}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER)}">
          <td>
            &nbsp;<c:if test="${not empty infoSignatura.checkAdministrationIdOfSigner}">
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${infoSignatura.checkAdministrationIdOfSigner?'success':'error'}.png"/>">
            </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS)}">
          <td>
            &nbsp;<c:if test="${not empty infoSignatura.checkDocumentModifications}">
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${infoSignatura.checkDocumentModifications?'success':'error'}.png"/>">
            </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InfoSignaturaFields.CHECKVALIDATIONSIGNATURE)}">
          <td>
            &nbsp;<c:if test="${not empty infoSignatura.checkValidationSignature}">
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${infoSignatura.checkValidationSignature?'success':'error'}.png"/>">
            </c:if>
          </td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[infoSignatura.infoSignaturaID]}" />
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


