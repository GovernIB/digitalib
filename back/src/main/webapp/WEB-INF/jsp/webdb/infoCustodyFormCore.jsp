<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InfoCustodyFields" className="es.caib.digitalib.model.fields.InfoCustodyFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.CUSTODYID)}">
        <tr id="infoCustody_custodyId_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.CUSTODYID])?'infoCustody.custodyId':__theForm.labels[InfoCustodyFields.CUSTODYID]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.CUSTODYID]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.CUSTODYID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoCustody.custodyId" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CUSTODYID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CUSTODYID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.custodyId"   />

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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.ORIGINALFILEURL)}">
        <tr id="infoCustody_originalFileUrl_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.ORIGINALFILEURL])?'infoCustody.originalFileUrl':__theForm.labels[InfoCustodyFields.ORIGINALFILEURL]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.ORIGINALFILEURL]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.ORIGINALFILEURL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
           <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ORIGINALFILEURL)}">

             <c:if test="${ not empty __theForm.infoCustody.originalFileUrl}">
               <a href="${__theForm.infoCustody.originalFileUrl}" target="_blank">${__theForm.infoCustody.originalFileUrl}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ORIGINALFILEURL))}">

            <form:errors path="infoCustody.originalFileUrl" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ORIGINALFILEURL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ORIGINALFILEURL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.originalFileUrl"   />

           </c:if>

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
           <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVGENERATIONDEFINITION)}">

             <c:if test="${ not empty __theForm.infoCustody.csvGenerationDefinition}">
               <a href="${__theForm.infoCustody.csvGenerationDefinition}" target="_blank">${__theForm.infoCustody.csvGenerationDefinition}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVGENERATIONDEFINITION))}">

            <form:errors path="infoCustody.csvGenerationDefinition" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVGENERATIONDEFINITION)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.CSVGENERATIONDEFINITION)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.csvGenerationDefinition"   />

           </c:if>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.PRINTABLEFILEURL)}">
        <tr id="infoCustody_printableFileUrl_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.PRINTABLEFILEURL])?'infoCustody.printableFileUrl':__theForm.labels[InfoCustodyFields.PRINTABLEFILEURL]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.PRINTABLEFILEURL]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.PRINTABLEFILEURL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
           <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.PRINTABLEFILEURL)}">

             <c:if test="${ not empty __theForm.infoCustody.printableFileUrl}">
               <a href="${__theForm.infoCustody.printableFileUrl}" target="_blank">${__theForm.infoCustody.printableFileUrl}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.PRINTABLEFILEURL))}">

            <form:errors path="infoCustody.printableFileUrl" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.PRINTABLEFILEURL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.PRINTABLEFILEURL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.printableFileUrl"   />

           </c:if>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.ENIFILEURL)}">
        <tr id="infoCustody_eniFileUrl_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.ENIFILEURL])?'infoCustody.eniFileUrl':__theForm.labels[InfoCustodyFields.ENIFILEURL]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.ENIFILEURL]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.ENIFILEURL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
           <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ENIFILEURL)}">

             <c:if test="${ not empty __theForm.infoCustody.eniFileUrl}">
               <a href="${__theForm.infoCustody.eniFileUrl}" target="_blank">${__theForm.infoCustody.eniFileUrl}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ENIFILEURL))}">

            <form:errors path="infoCustody.eniFileUrl" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ENIFILEURL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.ENIFILEURL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.eniFileUrl"   />

           </c:if>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoCustodyFields.VALIDATIONFILEURL)}">
        <tr id="infoCustody_validationFileUrl_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoCustodyFields.VALIDATIONFILEURL])?'infoCustody.validationFileUrl':__theForm.labels[InfoCustodyFields.VALIDATIONFILEURL]}" />
              <c:if test="${not empty __theForm.help[InfoCustodyFields.VALIDATIONFILEURL]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoCustodyFields.VALIDATIONFILEURL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
           <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.VALIDATIONFILEURL)}">

             <c:if test="${ not empty __theForm.infoCustody.validationFileUrl}">
               <a href="${__theForm.infoCustody.validationFileUrl}" target="_blank">${__theForm.infoCustody.validationFileUrl}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.VALIDATIONFILEURL))}">

            <form:errors path="infoCustody.validationFileUrl" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.VALIDATIONFILEURL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoCustodyFields.VALIDATIONFILEURL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoCustody.validationFileUrl"   />

           </c:if>

           </td>
        </tr>
        </c:if>
        
