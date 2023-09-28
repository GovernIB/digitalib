<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ConfiguracioFirmaFields" className="es.caib.digitalib.model.fields.ConfiguracioFirmaFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[configuracioFirma.configuracioFirmaID]}" />
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


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.CONFIGURACIOFIRMAID)}">
          <td>
          ${configuracioFirma.configuracioFirmaID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.NOM)}">
          <td>
          ${configuracioFirma.nom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID)}">
          <td>
          <c:set var="tmp">${configuracioFirma.pluginFirmaServidorID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPluginForPluginFirmaServidorID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS)}">
          <td>
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${configuracioFirma.incloureSegellDeTemps?'success':'error'}.png"/>">
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.PLUGINSEGELLATID)}">
          <td>
          <c:set var="tmp">${configuracioFirma.pluginSegellatID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPluginForPluginSegellatID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA)}">
          <td>
          <c:set var="tmp">${configuracioFirma.tipusOperacioFirma}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForTipusOperacioFirma[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.TIPUSFIRMAID)}">
          <td>
          <c:set var="tmp">${configuracioFirma.tipusFirmaID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForTipusFirmaID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.ALGORISMEDEFIRMAID)}">
          <td>
          <c:set var="tmp">${configuracioFirma.algorismeDeFirmaID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForAlgorismeDeFirmaID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.MODEDEFIRMA)}">
          <td>
            <fmt:message key="modefirma.${configuracioFirma.modeDeFirma}" />          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.USPOLITICADEFIRMA)}">
          <td>
          <c:set var="tmp">${configuracioFirma.usPoliticaDeFirma}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForUsPoliticaDeFirma[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIER)}">
          <td>
          ${configuracioFirma.policyIdentifier}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIERHASH)}">
          <td>
          ${configuracioFirma.policyIdentifierHash}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM)}">
          <td>
          ${configuracioFirma.policyIdentifierHashAlgorithm}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.POLICYURLDOCUMENT)}">
          <td>
          ${configuracioFirma.policyUrlDocument}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.POSICIOTAULAFIRMESID)}">
          <td>
          <c:set var="tmp">${configuracioFirma.posicioTaulaFirmesID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForPosicioTaulaFirmesID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.FIRMATPERFORMATID)}">
          <td>
          <c:set var="tmp">${configuracioFirma.firmatPerFormatID}</c:set>
          <c:if test="${not empty tmp}">
          ${configuracioFirma.firmatPerFormat.traduccions[lang].valor}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.MOTIUDELEGACIOID)}">
          <td>
          <c:set var="tmp">${configuracioFirma.motiuDelegacioID}</c:set>
          <c:if test="${not empty tmp}">
          ${configuracioFirma.motiuDelegacio.traduccions[lang].valor}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES)}">
          <td>
          ${configuracioFirma.propietatsTaulaFirmes}
          </td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[configuracioFirma.configuracioFirmaID]}" />
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


