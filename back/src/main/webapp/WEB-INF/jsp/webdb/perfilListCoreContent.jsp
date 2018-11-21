<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PerfilFields" className="es.caib.digitalib.model.fields.PerfilFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[perfil.perfilID]}" />
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


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.PERFILID)}">
          <td>
          ${perfil.perfilID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.CODI)}">
          <td>
          ${perfil.codi}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.NOM)}">
          <td>
          ${perfil.nom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.DESCRIPCIO)}">
          <td>
          ${perfil.descripcio}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.PLUGINSCANWEBID)}">
          <td>
          <c:set var="tmp">${perfil.pluginScanWebID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPluginForPluginScanWebID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.TIPUSFIRMA)}">
          <td>
          <c:set var="tmp">${perfil.tipusFirma}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForTipusFirma[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.PLUGINFIRMASERVIDORID)}">
          <td>
          <c:set var="tmp">${perfil.pluginFirmaServidorID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPluginForPluginFirmaServidorID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.APISIMPLEID)}">
          <td>
          <c:set var="tmp">${perfil.apiSimpleID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfApiSimpleForApiSimpleID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.TIPUSCUSTODIA)}">
          <td>
          <c:set var="tmp">${perfil.tipusCustodia}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForTipusCustodia[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.PLUGINARXIUID)}">
          <td>
          <c:set var="tmp">${perfil.pluginArxiuID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPluginForPluginArxiuID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.PLUGINDOCCUSTODYID)}">
          <td>
          <c:set var="tmp">${perfil.pluginDocCustodyID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfPluginForPluginDocCustodyID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PerfilFields.USPERFIL)}">
          <td>
          <c:set var="tmp">${perfil.usPerfil}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForUsPerfil[tmp]}
          </c:if>
          </td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[perfil.perfilID]}" />
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


