<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InfoCustodyFields" className="es.caib.digitalib.model.fields.InfoCustodyFields"/>

  <%-- HIDDEN PARAMS: FILTER BY --%> 
  <form:hidden path="visibleFilterBy"/>

  <%-- FILTRAR PER - INICI --%>
  
  <c:set var="displayFilterDiv" value="${__theFilterForm.visibleFilterBy?'':'display:none;'}" />  
  
  <div id="FilterDiv" class="wellgroupfilter formbox" style="${displayFilterDiv} margin-bottom:3px; margin-left: 1px; padding:3px;">

      <div class="page-header">
        <fmt:message key="genapp.form.filterby"/>
        
        <div class="float-right">

           <a class="float-right" style="margin-left:10px" href="#"> <i title="<fmt:message key="genapp.form.hidefilter"/>" onclick="document.getElementById('FilterDiv').style.display='none'; document.getElementById('FilterButton').style.display='inline';" class="far fa-window-close"></i></a>
           <input style="margin-left: 3px" class="btn btn-sm btn-warning float-right" type="button" onclick="clear_form_elements(this.form)" value="<fmt:message key="genapp.form.clean"/>"/>
           <input style="margin-left: 3px" class="btn btn-sm btn-warning float-right" type="reset" value="<fmt:message key="genapp.form.reset"/>"/>
           <input style="margin-left: 3px" class="btn btn-sm btn-primary float-right" type="submit" value="<fmt:message key="genapp.form.search"/>"/>

        </div>
      </div>
      <div class="form-inline">
      
      <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
      <c:if test="${ __entry.key < 0 && not empty __entry.value.searchBy }">
      <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
        <span class="add-on"><fmt:message key="${__entry.value.codeName}" />:</span>
        <fmt:message key="genapp.form.searchby" var="cercaperAF" >
          <fmt:param>
            <fmt:message key="${__entry.value.codeName}" />
          </fmt:param>
        </fmt:message>
        <c:choose>
          <c:when test="${gen:isFieldSearchInRange(__entry.value.searchBy)}">
            <span class="add-on"><fmt:message key="genapp.from" /></span>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="input-small input-medium" type="text" value="${__entry.value.searchByValue}"/>
            <span class="add-on"><fmt:message key="genapp.to" /></span>
            <input id="${__entry.value.searchBy.fullName}Fins" name="${__entry.value.searchBy.fullName}Fins" class="input-small input-medium search-query" type="text" value="${__entry.value.searchByValueFins}"/>
          </c:when>
          <c:otherwise>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="search-query input-medium" placeholder="${cercaperAF}" type="text" value="${__entry.value.searchByValue}"/>
          </c:otherwise>
        </c:choose>
      </div>
      </c:if>
      </c:forEach>


        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InfoCustodyFields.INFOCUSTODYID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="infoCustody.infoCustodyID" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoCustodyIDDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="infoCustodyIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InfoCustodyFields.CUSTODYID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="infoCustody.custodyId" var="custodyId" />
              <fmt:message key="genapp.form.searchby" var="cercapercustodyId" >                
                 <fmt:param value="${custodyId}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${custodyId}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapercustodyId}" path="custodyId" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InfoCustodyFields.ARXIUEXPEDIENTID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="infoCustody.arxiuExpedientId" var="arxiuExpedientId" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuExpedientId" >                
                 <fmt:param value="${arxiuExpedientId}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuExpedientId}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuExpedientId}" path="arxiuExpedientId" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InfoCustodyFields.ARXIUDOCUMENTID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="infoCustody.arxiuDocumentId" var="arxiuDocumentId" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuDocumentId" >                
                 <fmt:param value="${arxiuDocumentId}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuDocumentId}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuDocumentId}" path="arxiuDocumentId" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InfoCustodyFields.CSV)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="infoCustody.csv" var="csv" />
              <fmt:message key="genapp.form.searchby" var="cercapercsv" >                
                 <fmt:param value="${csv}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${csv}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapercsv}" path="csv" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InfoCustodyFields.ORIGINALFILEURL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="infoCustody.originalFileUrl" var="originalFileUrl" />
              <fmt:message key="genapp.form.searchby" var="cercaperoriginalFileUrl" >                
                 <fmt:param value="${originalFileUrl}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${originalFileUrl}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperoriginalFileUrl}" path="originalFileUrl" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InfoCustodyFields.CSVVALIDATIONWEB)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="infoCustody.csvValidationWeb" var="csvValidationWeb" />
              <fmt:message key="genapp.form.searchby" var="cercapercsvValidationWeb" >                
                 <fmt:param value="${csvValidationWeb}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${csvValidationWeb}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapercsvValidationWeb}" path="csvValidationWeb" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InfoCustodyFields.CSVGENERATIONDEFINITION)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="infoCustody.csvGenerationDefinition" var="csvGenerationDefinition" />
              <fmt:message key="genapp.form.searchby" var="cercapercsvGenerationDefinition" >                
                 <fmt:param value="${csvGenerationDefinition}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${csvGenerationDefinition}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapercsvGenerationDefinition}" path="csvGenerationDefinition" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InfoCustodyFields.PRINTABLEFILEURL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="infoCustody.printableFileUrl" var="printableFileUrl" />
              <fmt:message key="genapp.form.searchby" var="cercaperprintableFileUrl" >                
                 <fmt:param value="${printableFileUrl}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${printableFileUrl}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperprintableFileUrl}" path="printableFileUrl" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InfoCustodyFields.ENIFILEURL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="infoCustody.eniFileUrl" var="eniFileUrl" />
              <fmt:message key="genapp.form.searchby" var="cercapereniFileUrl" >                
                 <fmt:param value="${eniFileUrl}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${eniFileUrl}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapereniFileUrl}" path="eniFileUrl" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InfoCustodyFields.VALIDATIONFILEURL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="infoCustody.validationFileUrl" var="validationFileUrl" />
              <fmt:message key="genapp.form.searchby" var="cercapervalidationFileUrl" >                
                 <fmt:param value="${validationFileUrl}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${validationFileUrl}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapervalidationFileUrl}" path="validationFileUrl" />
            </div>


        </c:if>

      <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
      <c:if test="${ __entry.key >= 0 && not empty __entry.value.searchBy }">
      <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
        <span class="add-on"><fmt:message key="${__entry.value.codeName}" />:</span>
        <fmt:message key="genapp.form.searchby" var="cercaperAF" >
          <fmt:param>
            <fmt:message key="${__entry.value.codeName}" />
          </fmt:param>
        </fmt:message>
        <c:choose>
          <c:when test="${gen:isFieldSearchInRange(__entry.value.searchBy)}">
            <span class="add-on"><fmt:message key="genapp.from" /></span>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="input-small input-medium" type="text" value="${__entry.value.searchByValue}"/>
            <span class="add-on"><fmt:message key="genapp.to" /></span>
            <input id="${__entry.value.searchBy.fullName}Fins" name="${__entry.value.searchBy.fullName}Fins" class="input-small input-medium search-query" type="text" value="${__entry.value.searchByValueFins}"/>
          </c:when>
          <c:otherwise>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="search-query input-medium" placeholder="${cercaperAF}" type="text" value="${__entry.value.searchByValue}"/>
          </c:otherwise>
        </c:choose>
      </div>
      </c:if>
      </c:forEach>
      </div>
    </div>



    <%-- FILTRAR PER - FINAL --%>
  