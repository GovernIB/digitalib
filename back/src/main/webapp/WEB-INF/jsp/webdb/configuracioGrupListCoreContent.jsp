<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ConfiguracioGrupFields" className="es.caib.digitalib.model.fields.ConfiguracioGrupFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[configuracioGrup.configuracioGrupID]}" />
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


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.CONFIGURACIOGRUPID)}">
          <td>
          <c:out value="${configuracioGrup.configuracioGrupID}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.NOM)}">
          <td>
          <c:out value="${configuracioGrup.nom}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.SUPORTWEB)}">
          <td>
                       <c:if test="${ not empty configuracioGrup.suportWeb}">
               <a href="${configuracioGrup.suportWeb}" target="_blank">${configuracioGrup.suportWeb}</a>
             </c:if>

          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.SUPORTEMAIL)}">
          <td>
          <c:out value="${configuracioGrup.suportEmail}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.SUPORTTELEFON)}">
          <td>
          <c:out value="${configuracioGrup.suportTelefon}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.LOGOHEADERID)}">
          <td>
            <c:if test="${not empty configuracioGrup.logoHeader}">
              <a target="_blank" href="<c:url value="${dib:fileUrl(configuracioGrup.logoHeader)}"/>">${configuracioGrup.logoHeader.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.LOGOFOOTERID)}">
          <td>
            <c:if test="${not empty configuracioGrup.logoFooter}">
              <a target="_blank" href="<c:url value="${dib:fileUrl(configuracioGrup.logoFooter)}"/>">${configuracioGrup.logoFooter.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.ADREZA)}">
          <td>
          <c:out value="${configuracioGrup.adreza}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.CODIDIR3PERDEFECTE)}">
          <td>
          <c:out value="${configuracioGrup.codiDir3PerDefecte}" />
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.PERFILNOMESESCANEIGID)}">
          <td>
          <c:set var="tmp">${configuracioGrup.perfilNomesEscaneigID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPerfilForPerfilNomesEscaneigID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID)}">
          <td>
          <c:set var="tmp">${configuracioGrup.perfilNomesEscaneig2ID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPerfilForPerfilNomesEscaneig2ID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID)}">
          <td>
          <c:set var="tmp">${configuracioGrup.perfilCopiaAutenticaID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPerfilForPerfilCopiaAutenticaID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID)}">
          <td>
          <c:set var="tmp">${configuracioGrup.perfilCopiaAutentica2ID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPerfilForPerfilCopiaAutentica2ID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.PERFILCUSTODIAID)}">
          <td>
          <c:set var="tmp">${configuracioGrup.perfilCustodiaID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPerfilForPerfilCustodiaID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioGrupFields.PERFILCUSTODIA2ID)}">
          <td>
          <c:set var="tmp">${configuracioGrup.perfilCustodia2ID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPerfilForPerfilCustodia2ID[tmp]}
          </c:if>
          </td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[configuracioGrup.configuracioGrupID]}" />
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


