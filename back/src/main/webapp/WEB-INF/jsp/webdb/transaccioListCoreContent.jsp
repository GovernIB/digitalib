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
          <c:out value="${transaccio.transaccioID}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.TRANSACCIOMULTIPLEID)}">
          <td>
          <c:set var="tmp">${transaccio.transaccioMultipleID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfTransaccioMultipleForTransaccioMultipleID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.NOM)}">
          <td>
          <c:out value="${transaccio.nom}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.TRANSACTIONWEBID)}">
          <td>
          <c:out value="${transaccio.transactionWebId}" />
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
          <c:set var="tmp">${transaccio.usuariAplicacioId}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForUsuariAplicacioId[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.USUARIPERSONAID)}">
          <td>
          <c:set var="tmp">${transaccio.usuariPersonaId}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForUsuariPersonaId[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.IP)}">
          <td>
          <c:out value="${transaccio.ip}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.RETURNURL)}">
          <td>
          <c:out value="${transaccio.returnUrl}" />
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
          <c:out value="${transaccio.estatMissatge}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ESTATEXCEPCIO)}">
          <td>
          <c:out value="${transaccio.estatExcepcio}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FITXERESCANEJATID)}">
          <td>
            <c:if test="${not empty transaccio.fitxerEscanejat}">
              <a target="_blank" href="<c:url value="${dib:fileUrl(transaccio.fitxerEscanejat)}"/>">${transaccio.fitxerEscanejat.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.HASHESCANEIG)}">
          <td>
          <c:out value="${transaccio.hashEscaneig}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FITXERSIGNATURAID)}">
          <td>
            <c:if test="${not empty transaccio.fitxerSignatura}">
              <a target="_blank" href="<c:url value="${dib:fileUrl(transaccio.fitxerSignatura)}"/>">${transaccio.fitxerSignatura.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.HASHFIRMA)}">
          <td>
          <c:out value="${transaccio.hashFirma}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANPAPERSIZE)}">
          <td>
          <c:out value="${transaccio.infoScanPaperSize}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANPIXELTYPE)}">
          <td>
          <c:set var="tmp">${transaccio.infoScanPixelType}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForInfoScanPixelType[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANRESOLUCIOPPP)}">
          <td>
          <c:out value="${transaccio.infoScanResolucioPpp}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANOCR)}">
          <td>
            &nbsp;<c:if test="${not empty transaccio.infoScanOcr}">
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${transaccio.infoScanOcr?'success':'error'}.png"/>">
            </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANDUPLEX)}">
          <td>
            &nbsp;<c:if test="${not empty transaccio.infoScanDuplex}">
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${transaccio.infoScanDuplex?'success':'error'}.png"/>">
            </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANDATACAPTURA)}">
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${transaccio.infoScanDataCaptura}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANLANGUAGEDOC)}">
          <td>
          <c:set var="tmp">${transaccio.infoScanLanguageDoc}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForInfoScanLanguageDoc[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANDOCUMENTTIPUS)}">
          <td>
          <c:set var="tmp">${transaccio.infoScanDocumentTipus}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForInfoScanDocumentTipus[tmp]}
          </c:if>
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
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.LANGUAGEUI)}">
          <td>
          <c:out value="${transaccio.languageUI}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FUNCIONARIUSERNAME)}">
          <td>
          <c:out value="${transaccio.funcionariUsername}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.SIGNPARAMFUNCIONARINOM)}">
          <td>
          <c:out value="${transaccio.signParamFuncionariNom}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.SIGNPARAMFUNCIONARINIF)}">
          <td>
          <c:out value="${transaccio.signParamFuncionariNif}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.SIGNPARAMFUNCIONARIDIR3)}">
          <td>
          <c:out value="${transaccio.signParamFuncionariDir3}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ARXIUREQPARAMDOCESTATELABORA)}">
          <td>
          <c:set var="tmp">${transaccio.arxiuReqParamDocEstatElabora}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForArxiuReqParamDocEstatElabora[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ARXIUREQPARAMORIGEN)}">
          <td>
          <c:set var="tmp">${transaccio.arxiuReqParamOrigen}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForArxiuReqParamOrigen[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ARXIUREQPARAMINTERESSATS)}">
          <td>
          <c:out value="${transaccio.arxiuReqParamInteressats}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ARXIUREQPARAMCIUTADANIF)}">
          <td>
          <c:out value="${transaccio.arxiuReqParamCiutadaNif}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ARXIUREQPARAMCIUTADANOM)}">
          <td>
          <c:out value="${transaccio.arxiuReqParamCiutadaNom}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ARXIUREQPARAMORGANS)}">
          <td>
          <c:out value="${transaccio.arxiuReqParamOrgans}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI)}">
          <td>
          <c:out value="${transaccio.arxiuOptParamProcedimentCodi}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM)}">
          <td>
          <c:out value="${transaccio.arxiuOptParamProcedimentNom}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL)}">
          <td>
          <c:out value="${transaccio.arxiuOptParamSerieDocumental}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID)}">
          <td>
          <c:out value="${transaccio.arxiuOptParamCustodyOrExpedientId}" />
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


