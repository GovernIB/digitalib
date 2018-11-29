<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuariPersonaFields" className="es.caib.digitalib.model.fields.UsuariPersonaFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[usuariPersona.usuariPersonaID]}" />
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


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariPersonaFields.USUARIPERSONAID)}">
          <td>
          ${usuariPersona.usuariPersonaID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariPersonaFields.USERNAME)}">
          <td>
          ${usuariPersona.username}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariPersonaFields.NOM)}">
          <td>
          ${usuariPersona.nom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariPersonaFields.LLINATGES)}">
          <td>
          ${usuariPersona.llinatges}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariPersonaFields.EMAIL)}">
          <td>
          ${usuariPersona.email}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariPersonaFields.NIF)}">
          <td>
          ${usuariPersona.nif}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariPersonaFields.IDIOMAID)}">
          <td>
          <c:set var="tmp">${usuariPersona.idiomaID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfIdiomaForIdiomaID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariPersonaFields.CONFIGURACIOGRUPID)}">
          <td>
          <c:set var="tmp">${usuariPersona.configuracioGrupID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfConfiguracioGrupForConfiguracioGrupID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariPersonaFields.ROLESCAN)}">
          <td>
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${usuariPersona.roleScan?'success':'error'}.png"/>">
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariPersonaFields.ROLECOAU)}">
          <td>
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${usuariPersona.roleCoAu?'success':'error'}.png"/>">
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariPersonaFields.ROLECUST)}">
          <td>
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${usuariPersona.roleCust?'success':'error'}.png"/>">
          </td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[usuariPersona.usuariPersonaID]}" />
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


