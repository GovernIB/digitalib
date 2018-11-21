<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InfoCustodyFields" className="es.caib.digitalib.model.fields.InfoCustodyFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.CUSTODYFILEID)}">
        <tr id="infoCustody_custodyFileId_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.CUSTODYFILEID])?'infoCustody.custodyFileId':__theForm.labels[InfoCustodyFields.CUSTODYFILEID]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.CUSTODYFILEID]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.CUSTODYFILEID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoCustody.custodyFileId" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CUSTODYFILEID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CUSTODYFILEID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.custodyFileId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.CUSTODYFILEURL)}">
        <tr id="infoCustody_custodyFileUrl_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.CUSTODYFILEURL])?'infoCustody.custodyFileUrl':__theForm.labels[InfoCustodyFields.CUSTODYFILEURL]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.CUSTODYFILEURL]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.CUSTODYFILEURL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoCustody.custodyFileUrl" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CUSTODYFILEURL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CUSTODYFILEURL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.custodyFileUrl"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.CSV)}">
        <tr id="infoCustody_csv_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.CSV])?'infoCustody.csv':__theForm.labels[InfoCustodyFields.CSV]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.CSV]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.CSV]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoCustody.csv" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSV)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSV)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.csv"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.CSVVALIDATIONWEB)}">
        <tr id="infoCustody_csvValidationWeb_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.CSVVALIDATIONWEB])?'infoCustody.csvValidationWeb':__theForm.labels[InfoCustodyFields.CSVVALIDATIONWEB]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.CSVVALIDATIONWEB]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.CSVVALIDATIONWEB]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoCustody.csvValidationWeb" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVVALIDATIONWEB)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVVALIDATIONWEB)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.csvValidationWeb"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.CSVGENERATIONDEFINITION)}">
        <tr id="infoCustody_csvGenerationDefinition_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.CSVGENERATIONDEFINITION])?'infoCustody.csvGenerationDefinition':__theForm.labels[InfoCustodyFields.CSVGENERATIONDEFINITION]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.CSVGENERATIONDEFINITION]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.CSVGENERATIONDEFINITION]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoCustody.csvGenerationDefinition" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVGENERATIONDEFINITION)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVGENERATIONDEFINITION)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.csvGenerationDefinition"   />

           </td>
        </tr>
        </c:if>
        
