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
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.NOM)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.nom" var="nom" />
              <fmt:message key="genapp.form.searchby" var="cercapernom" >                
                 <fmt:param value="${nom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${nom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapernom}" path="nom" />
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
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.IP)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.ip" var="ip" />
              <fmt:message key="genapp.form.searchby" var="cercaperip" >                
                 <fmt:param value="${ip}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${ip}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperip}" path="ip" />
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
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.HASHESCANEIG)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.hashEscaneig" var="hashEscaneig" />
              <fmt:message key="genapp.form.searchby" var="cercaperhashEscaneig" >                
                 <fmt:param value="${hashEscaneig}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${hashEscaneig}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperhashEscaneig}" path="hashEscaneig" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.HASHFIRMA)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.hashFirma" var="hashFirma" />
              <fmt:message key="genapp.form.searchby" var="cercaperhashFirma" >                
                 <fmt:param value="${hashFirma}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${hashFirma}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperhashFirma}" path="hashFirma" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANPAPERSIZE)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.infoScanPaperSize" var="infoScanPaperSize" />
              <fmt:message key="genapp.form.searchby" var="cercaperinfoScanPaperSize" >                
                 <fmt:param value="${infoScanPaperSize}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${infoScanPaperSize}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperinfoScanPaperSize}" path="infoScanPaperSize" />
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
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANDATACAPTURA)}">
            <%-- FILTRE DATE --%>
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.infoScanDataCaptura" />:</span>
              <span class="add-on"><fmt:message key="genapp.from" /></span>
              <div id="infoScanDataCapturaDesde" class="input-append">
                <form:input cssClass="input-large" path="infoScanDataCapturaDesde" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#infoScanDataCapturaDesde').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
              <span class="add-on"><fmt:message key="genapp.to" /></span>              
              <div id="infoScanDataCapturaFins" class="input-append">
                <form:input cssClass="input-large" path="infoScanDataCapturaFins" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#infoScanDataCapturaFins').datetimepicker({
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
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.SIGNPARAMFUNCIONARINOM)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.signParamFuncionariNom" var="signParamFuncionariNom" />
              <fmt:message key="genapp.form.searchby" var="cercapersignParamFuncionariNom" >                
                 <fmt:param value="${signParamFuncionariNom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${signParamFuncionariNom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersignParamFuncionariNom}" path="signParamFuncionariNom" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.SIGNPARAMFUNCIONARINIF)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.signParamFuncionariNif" var="signParamFuncionariNif" />
              <fmt:message key="genapp.form.searchby" var="cercapersignParamFuncionariNif" >                
                 <fmt:param value="${signParamFuncionariNif}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${signParamFuncionariNif}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersignParamFuncionariNif}" path="signParamFuncionariNif" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.SIGNPARAMLANGUAGEDOC)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.signParamLanguageDoc" var="signParamLanguageDoc" />
              <fmt:message key="genapp.form.searchby" var="cercapersignParamLanguageDoc" >                
                 <fmt:param value="${signParamLanguageDoc}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${signParamLanguageDoc}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersignParamLanguageDoc}" path="signParamLanguageDoc" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUREQPARAMDOCESTATELABORA)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.arxiuReqParamDocEstatElabora" var="arxiuReqParamDocEstatElabora" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuReqParamDocEstatElabora" >                
                 <fmt:param value="${arxiuReqParamDocEstatElabora}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuReqParamDocEstatElabora}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuReqParamDocEstatElabora}" path="arxiuReqParamDocEstatElabora" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUREQPARAMDOCUMENTTIPUS)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.arxiuReqParamDocumentTipus" var="arxiuReqParamDocumentTipus" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuReqParamDocumentTipus" >                
                 <fmt:param value="${arxiuReqParamDocumentTipus}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuReqParamDocumentTipus}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuReqParamDocumentTipus}" path="arxiuReqParamDocumentTipus" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUREQPARAMORIGEN)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="transaccio.arxiuReqParamOrigen" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="arxiuReqParamOrigenDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="arxiuReqParamOrigenFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUREQPARAMINTERESSATS)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.arxiuReqParamInteressats" var="arxiuReqParamInteressats" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuReqParamInteressats" >                
                 <fmt:param value="${arxiuReqParamInteressats}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuReqParamInteressats}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuReqParamInteressats}" path="arxiuReqParamInteressats" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUREQPARAMCIUTADANIF)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.arxiuReqParamCiutadaNif" var="arxiuReqParamCiutadaNif" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuReqParamCiutadaNif" >                
                 <fmt:param value="${arxiuReqParamCiutadaNif}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuReqParamCiutadaNif}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuReqParamCiutadaNif}" path="arxiuReqParamCiutadaNif" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUREQPARAMCIUTADANOM)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.arxiuReqParamCiutadaNom" var="arxiuReqParamCiutadaNom" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuReqParamCiutadaNom" >                
                 <fmt:param value="${arxiuReqParamCiutadaNom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuReqParamCiutadaNom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuReqParamCiutadaNom}" path="arxiuReqParamCiutadaNom" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUREQPARAMORGANS)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.arxiuReqParamOrgans" var="arxiuReqParamOrgans" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuReqParamOrgans" >                
                 <fmt:param value="${arxiuReqParamOrgans}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuReqParamOrgans}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuReqParamOrgans}" path="arxiuReqParamOrgans" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.arxiuOptParamProcedimentCodi" var="arxiuOptParamProcedimentCodi" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuOptParamProcedimentCodi" >                
                 <fmt:param value="${arxiuOptParamProcedimentCodi}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuOptParamProcedimentCodi}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuOptParamProcedimentCodi}" path="arxiuOptParamProcedimentCodi" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.arxiuOptParamProcedimentNom" var="arxiuOptParamProcedimentNom" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuOptParamProcedimentNom" >                
                 <fmt:param value="${arxiuOptParamProcedimentNom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuOptParamProcedimentNom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuOptParamProcedimentNom}" path="arxiuOptParamProcedimentNom" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.arxiuOptParamSerieDocumental" var="arxiuOptParamSerieDocumental" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuOptParamSerieDocumental" >                
                 <fmt:param value="${arxiuOptParamSerieDocumental}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuOptParamSerieDocumental}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuOptParamSerieDocumental}" path="arxiuOptParamSerieDocumental" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.arxiuOptParamCustodyOrExpedientId" var="arxiuOptParamCustodyOrExpedientId" />
              <fmt:message key="genapp.form.searchby" var="cercaperarxiuOptParamCustodyOrExpedientId" >                
                 <fmt:param value="${arxiuOptParamCustodyOrExpedientId}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${arxiuOptParamCustodyOrExpedientId}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperarxiuOptParamCustodyOrExpedientId}" path="arxiuOptParamCustodyOrExpedientId" />
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
  
