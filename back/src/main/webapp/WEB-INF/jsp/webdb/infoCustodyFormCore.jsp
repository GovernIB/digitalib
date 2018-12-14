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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.ARXIUEXPEDIENTID)}">
        <tr id="infoCustody_arxiuExpedientId_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.ARXIUEXPEDIENTID])?'infoCustody.arxiuExpedientId':__theForm.labels[InfoCustodyFields.ARXIUEXPEDIENTID]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.ARXIUEXPEDIENTID]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.ARXIUEXPEDIENTID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoCustody.arxiuExpedientId" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ARXIUEXPEDIENTID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ARXIUEXPEDIENTID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.arxiuExpedientId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.ARXIUDOCUMENTID)}">
        <tr id="infoCustody_arxiuDocumentId_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.ARXIUDOCUMENTID])?'infoCustody.arxiuDocumentId':__theForm.labels[InfoCustodyFields.ARXIUDOCUMENTID]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.ARXIUDOCUMENTID]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.ARXIUDOCUMENTID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoCustody.arxiuDocumentId" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ARXIUDOCUMENTID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ARXIUDOCUMENTID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.arxiuDocumentId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.FILEURL)}">
        <tr id="infoCustody_fileUrl_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.FILEURL])?'infoCustody.fileUrl':__theForm.labels[InfoCustodyFields.FILEURL]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.FILEURL]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.FILEURL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
           <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.FILEURL)}">

             <c:if test="${ not empty __theForm.infoCustody.fileUrl}">
               <a href="${__theForm.infoCustody.fileUrl}" target="_blank">${__theForm.infoCustody.fileUrl}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.FILEURL))}">

            <form:errors path="infoCustody.fileUrl" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.FILEURL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.FILEURL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.fileUrl"   />

           </c:if>

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
           <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVVALIDATIONWEB)}">

             <c:if test="${ not empty __theForm.infoCustody.csvValidationWeb}">
               <a href="${__theForm.infoCustody.csvValidationWeb}" target="_blank">${__theForm.infoCustody.csvValidationWeb}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVVALIDATIONWEB))}">

            <form:errors path="infoCustody.csvValidationWeb" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVVALIDATIONWEB)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVVALIDATIONWEB)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.csvValidationWeb"   />

           </c:if>

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
        
