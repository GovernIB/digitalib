<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="TransaccioFields" className="es.caib.digitalib.model.fields.TransaccioFields"/>

  <%-- HIDDEN PARAMS: FILTER BY --%> 
  <form:hidden path="visibleFilterBy"/>

  <%-- FILTRAR PER - INICI --%>
  
  <c:set var="displayFilterDiv" value="${__theFilterForm.visibleFilterBy?'':'display:none;'}" />  
  
  <div id="FilterDiv" class="well formbox" style="${displayFilterDiv} margin-bottom:3px; margin-left: 1px; padding:3px;">

      <div class="page-header">
        <fmt:message key="genapp.form.filterby"/>
        
        <div class="pull-right">

           <a class="pull-right" style="margin-left:10px" href="#"> <i title="<fmt:message key="genapp.form.hidefilter"/>" onclick="document.getElementById('FilterDiv').style.display='none'; document.getElementById('FilterButton').style.display='inline';" class="icon-remove"></i></a>
           <input style="margin-left: 3px" class="btn btn-warning pull-right" type="button" onclick="clear_form_elements(this.form)" value="<fmt:message key="genapp.form.clean"/>"/>
           <input style="margin-left: 3px" class="btn btn-warning pull-right" type="reset" value="<fmt:message key="genapp.form.reset"/>"/>
           <input style="margin-left: 3px" class="btn btn-primary pull-right" type="submit" value="<fmt:message key="genapp.form.search"/>"/>

        </div>
      </div>
      <div class="form-inline">
      
      <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
      <c:if test="${ __entry.key < 0 && not empty __entry.value.searchBy }">
      <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
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


        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.TRANSACCIOID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.transaccioID" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="transaccioIDDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="transaccioIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.TRANSACTIONWEBID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.transactionWebId" var="transactionWebId" />
              <fmt:message key="genapp.form.searchby" var="cercapertransactionWebId" >                
                 <fmt:param value="${transactionWebId}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${transactionWebId}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapertransactionWebId}" path="transactionWebId" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.DATAINICI)}">
            <%-- FILTRE DATE --%>
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.dataInici" />:</span>
              <span class="add-on"><fmt:message key="genapp.from" /></span>
              <div id="dataIniciDesde" class="input-append">
                <form:input cssClass="input-large" path="dataIniciDesde" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataIniciDesde').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
              <span class="add-on"><fmt:message key="genapp.to" /></span>              
              <div id="dataIniciFins" class="input-append">
                <form:input cssClass="input-large" path="dataIniciFins" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataIniciFins').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
            </div>

    
        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.DATAFI)}">
            <%-- FILTRE DATE --%>
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.dataFi" />:</span>
              <span class="add-on"><fmt:message key="genapp.from" /></span>
              <div id="dataFiDesde" class="input-append">
                <form:input cssClass="input-large" path="dataFiDesde" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataFiDesde').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
              <span class="add-on"><fmt:message key="genapp.to" /></span>              
              <div id="dataFiFins" class="input-append">
                <form:input cssClass="input-large" path="dataFiFins" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataFiFins').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
            </div>

    
        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.USUARIAPLICACIOID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.usuariAplicacioId" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="usuariAplicacioIdDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="usuariAplicacioIdFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.USUARIPERSONAID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.usuariPersonaId" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="usuariPersonaIdDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="usuariPersonaIdFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ESTATCODI)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.estatCodi" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="estatCodiDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="estatCodiFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ESTATMISSATGE)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.estatMissatge" var="estatMissatge" />
              <fmt:message key="genapp.form.searchby" var="cercaperestatMissatge" >                
                 <fmt:param value="${estatMissatge}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${estatMissatge}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperestatMissatge}" path="estatMissatge" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ESTATEXCEPCIO)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.estatExcepcio" var="estatExcepcio" />
              <fmt:message key="genapp.form.searchby" var="cercaperestatExcepcio" >                
                 <fmt:param value="${estatExcepcio}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${estatExcepcio}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperestatExcepcio}" path="estatExcepcio" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANPIXELTYPE)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.infoScanPixelType" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoScanPixelTypeDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="infoScanPixelTypeFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANRESOLUCIOPPP)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.infoScanResolucioPpp" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoScanResolucioPppDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="infoScanResolucioPppFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANOCR)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.infoScanOcr" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoScanOcrDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="infoScanOcrFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSIGNATURAID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.infoSignaturaID" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoSignaturaIDDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="infoSignaturaIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOCUSTODYID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.infoCustodyID" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoCustodyIDDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="infoCustodyIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.LANGUAGEUI)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.languageUI" var="languageUI" />
              <fmt:message key="genapp.form.searchby" var="cercaperlanguageUI" >                
                 <fmt:param value="${languageUI}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${languageUI}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlanguageUI}" path="languageUI" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.LANGUAGEDOC)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.languageDoc" var="languageDoc" />
              <fmt:message key="genapp.form.searchby" var="cercaperlanguageDoc" >                
                 <fmt:param value="${languageDoc}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${languageDoc}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlanguageDoc}" path="languageDoc" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.CIUTADANIF)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.ciutadaNif" var="ciutadaNif" />
              <fmt:message key="genapp.form.searchby" var="cercaperciutadaNif" >                
                 <fmt:param value="${ciutadaNif}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${ciutadaNif}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperciutadaNif}" path="ciutadaNif" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.CIUTADANOM)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.ciutadaNom" var="ciutadaNom" />
              <fmt:message key="genapp.form.searchby" var="cercaperciutadaNom" >                
                 <fmt:param value="${ciutadaNom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${ciutadaNom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperciutadaNom}" path="ciutadaNom" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.FUNCIONARIUSERNAME)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.funcionariUsername" var="funcionariUsername" />
              <fmt:message key="genapp.form.searchby" var="cercaperfuncionariUsername" >                
                 <fmt:param value="${funcionariUsername}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${funcionariUsername}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperfuncionariUsername}" path="funcionariUsername" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.FUNCIONARINOM)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.funcionariNom" var="funcionariNom" />
              <fmt:message key="genapp.form.searchby" var="cercaperfuncionariNom" >                
                 <fmt:param value="${funcionariNom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${funcionariNom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperfuncionariNom}" path="funcionariNom" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.EXPEDIENT)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.expedient" var="expedient" />
              <fmt:message key="genapp.form.searchby" var="cercaperexpedient" >                
                 <fmt:param value="${expedient}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${expedient}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperexpedient}" path="expedient" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.USERNAMEREQUEST)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.usernameRequest" var="usernameRequest" />
              <fmt:message key="genapp.form.searchby" var="cercaperusernameRequest" >                
                 <fmt:param value="${usernameRequest}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${usernameRequest}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperusernameRequest}" path="usernameRequest" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.RETURNURL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.returnUrl" var="returnUrl" />
              <fmt:message key="genapp.form.searchby" var="cercaperreturnUrl" >                
                 <fmt:param value="${returnUrl}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${returnUrl}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperreturnUrl}" path="returnUrl" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.VIEW)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.view" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="viewDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="viewFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.PERFILID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.perfilID" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="perfilIDDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="perfilIDFins" />

            </div>


        </c:if>

      <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
      <c:if test="${ __entry.key >= 0 && not empty __entry.value.searchBy }">
      <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
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
  
