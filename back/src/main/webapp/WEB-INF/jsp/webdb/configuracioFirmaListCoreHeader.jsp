<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ConfiguracioFirmaFields" className="es.caib.digitalib.model.fields.ConfiguracioFirmaFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.CONFIGURACIOFIRMAID)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.CONFIGURACIOFIRMAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.USPOLITICADEFIRMA)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.USPOLITICADEFIRMA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIER)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.POLICYIDENTIFIER)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIERHASH)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.POLICYIDENTIFIERHASH)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.POLICYURLDOCUMENT)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.POLICYURLDOCUMENT)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.TIPUSFIRMAID)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.TIPUSFIRMAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.ALGORISMEDEFIRMAID)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.ALGORISMEDEFIRMAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.MODEDEFIRMA)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.MODEDEFIRMA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.POLITICATAULAFIRMES)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.POLITICATAULAFIRMES)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.POSICIOTAULAFIRMESID)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.POSICIOTAULAFIRMESID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.FIRMATPERFORMATID)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.FIRMATPERFORMATID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.MOTIUDELEGACIOID)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.MOTIUDELEGACIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ConfiguracioFirmaFields.PLUGINSEGELLATID)}">
        <th>${dib:getSortIcons(__theFilterForm,ConfiguracioFirmaFields.PLUGINSEGELLATID)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${dib:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

