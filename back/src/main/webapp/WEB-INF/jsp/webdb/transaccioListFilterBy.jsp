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
              <span class="add-on"><fmt:message key="transaccio.datainici" />:</span>
              <span class="add-on"><fmt:message key="genapp.from" /></span>
              <div id="datainiciDesde" class="input-append">
                <form:input cssClass="input-large" path="datainiciDesde" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#datainiciDesde').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
              <span class="add-on"><fmt:message key="genapp.to" /></span>              
              <div id="datainiciFins" class="input-append">
                <form:input cssClass="input-large" path="datainiciFins" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#datainiciFins').datetimepicker({
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
              <span class="add-on"><fmt:message key="transaccio.datafi" />:</span>
              <span class="add-on"><fmt:message key="genapp.from" /></span>
              <div id="datafiDesde" class="input-append">
                <form:input cssClass="input-large" path="datafiDesde" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#datafiDesde').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
              <span class="add-on"><fmt:message key="genapp.to" /></span>              
              <div id="datafiFins" class="input-append">
                <form:input cssClass="input-large" path="datafiFins" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#datafiFins').datetimepicker({
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
              <span class="add-on"><fmt:message key="transaccio.usuariaplicacioid" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="usuariaplicacioidDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="usuariaplicacioidFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.USUARIPERSONAID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.usuaripersonaid" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="usuaripersonaidDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="usuaripersonaidFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ESTATCODI)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.estatcodi" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="estatcodiDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="estatcodiFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ESTATMISSATGE)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.estatmissatge" var="estatmissatge" />
              <fmt:message key="genapp.form.searchby" var="cercaperestatmissatge" >                
                 <fmt:param value="${estatmissatge}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${estatmissatge}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperestatmissatge}" path="estatmissatge" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ESTATEXCEPCIO)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.estatexcepcio" var="estatexcepcio" />
              <fmt:message key="genapp.form.searchby" var="cercaperestatexcepcio" >                
                 <fmt:param value="${estatexcepcio}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${estatexcepcio}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperestatexcepcio}" path="estatexcepcio" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANPIXELTYPE)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.infoscanpixeltype" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoscanpixeltypeDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="infoscanpixeltypeFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANRESOLUCIOPPP)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.infoscanresolucioppp" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoscanresoluciopppDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="infoscanresoluciopppFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANOCR)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.infoscanocr" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoscanocrDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="infoscanocrFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSIGNATURAID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.infosignaturaid" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infosignaturaidDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="infosignaturaidFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOCUSTODYID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.infocustodyid" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infocustodyidDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="infocustodyidFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.LANGUAGEUI)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.languageui" var="languageui" />
              <fmt:message key="genapp.form.searchby" var="cercaperlanguageui" >                
                 <fmt:param value="${languageui}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${languageui}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlanguageui}" path="languageui" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.LANGUAGEDOC)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.languagedoc" var="languagedoc" />
              <fmt:message key="genapp.form.searchby" var="cercaperlanguagedoc" >                
                 <fmt:param value="${languagedoc}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${languagedoc}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperlanguagedoc}" path="languagedoc" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.CIUTADANIF)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.ciutadanif" var="ciutadanif" />
              <fmt:message key="genapp.form.searchby" var="cercaperciutadanif" >                
                 <fmt:param value="${ciutadanif}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${ciutadanif}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperciutadanif}" path="ciutadanif" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.CIUTADANOM)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.ciutadanom" var="ciutadanom" />
              <fmt:message key="genapp.form.searchby" var="cercaperciutadanom" >                
                 <fmt:param value="${ciutadanom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${ciutadanom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperciutadanom}" path="ciutadanom" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.FUNCIONARIUSERNAME)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.funcionariusername" var="funcionariusername" />
              <fmt:message key="genapp.form.searchby" var="cercaperfuncionariusername" >                
                 <fmt:param value="${funcionariusername}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${funcionariusername}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperfuncionariusername}" path="funcionariusername" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.FUNCIONARINOM)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.funcionarinom" var="funcionarinom" />
              <fmt:message key="genapp.form.searchby" var="cercaperfuncionarinom" >                
                 <fmt:param value="${funcionarinom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${funcionarinom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperfuncionarinom}" path="funcionarinom" />
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
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.PERFILID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.perfilid" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="perfilidDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="perfilidFins" />

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
  
