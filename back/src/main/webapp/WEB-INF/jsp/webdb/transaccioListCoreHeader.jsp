<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="TransaccioFields" className="es.caib.digitalib.model.fields.TransaccioFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.TRANSACCIOID)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.TRANSACCIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.TRANSACTIONWEBID)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.TRANSACTIONWEBID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.DATAINICI)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.DATAINICI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.DATAFI)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.DATAFI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.USUARIAPLICACIOID)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.USUARIAPLICACIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.USUARIPERSONAID)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.USUARIPERSONAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ESTATCODI)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.ESTATCODI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ESTATMISSATGE)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.ESTATMISSATGE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.ESTATEXCEPCIO)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.ESTATEXCEPCIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FITXERESCANEJATID)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.FITXERESCANEJATID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FITXERSIGNATURAID)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.FITXERSIGNATURAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANPIXELTYPE)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.INFOSCANPIXELTYPE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANRESOLUCIOPPP)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.INFOSCANRESOLUCIOPPP)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSCANOCR)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.INFOSCANOCR)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOSIGNATURAID)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.INFOSIGNATURAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.INFOCUSTODYID)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.INFOCUSTODYID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.LANGUAGEUI)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.LANGUAGEUI)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.LANGUAGEDOC)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.LANGUAGEDOC)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.CIUTADANIF)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.CIUTADANIF)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.CIUTADANOM)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.CIUTADANOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FUNCIONARIUSERNAME)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.FUNCIONARIUSERNAME)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.FUNCIONARINOM)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.FUNCIONARINOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.EXPEDIENT)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.EXPEDIENT)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.USERNAMEREQUEST)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.USERNAMEREQUEST)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.RETURNURL)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.RETURNURL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.VIEW)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.VIEW)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,TransaccioFields.PERFILID)}">
        <th>${dib:getSortIcons(__theFilterForm,TransaccioFields.PERFILID)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

