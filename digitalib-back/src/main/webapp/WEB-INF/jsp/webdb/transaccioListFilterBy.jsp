<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="TransaccioFields" className="es.caib.digitalib.model.fields.TransaccioFields"/>

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


        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.TRANSACCIOID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="transaccio.transaccioID" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="transaccioIDDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="transaccioIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.TRANSACCIOMULTIPLEID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="transaccio.transaccioMultipleID" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="transaccioMultipleIDDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="transaccioMultipleIDFins" />

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
<%-- FILTRE DATE-TIME --%>
            <div class="input-group" style="padding-right:4px;padding-bottom:4px;align-items:center;">
              <span class="add-on"><fmt:message key="transaccio.dataInici" />:</span>
              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="dataIniciDesde" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#dataIniciDesde" path="dataIniciDesde" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#dataIniciDesde"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#dataIniciDesde').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="dataIniciFins" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#dataIniciFins" path="dataIniciFins" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#dataIniciFins"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#dataIniciFins').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>            </div>

    
        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.DATAFI)}">
<%-- FILTRE DATE-TIME --%>
            <div class="input-group" style="padding-right:4px;padding-bottom:4px;align-items:center;">
              <span class="add-on"><fmt:message key="transaccio.dataFi" />:</span>
              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="dataFiDesde" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#dataFiDesde" path="dataFiDesde" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#dataFiDesde"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#dataFiDesde').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="dataFiFins" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#dataFiFins" path="dataFiFins" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#dataFiFins"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#dataFiFins').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>            </div>

    
        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.USUARIAPLICACIOID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <%-- FILTRE NUMERO SELECT MULTIPLE --%>
              <div class="input-group-prepend" style="padding-top: 5px;padding-right: 5px;">
                 <span class="add-on"><fmt:message key="transaccio.usuariAplicacioId" />:</span>
              </div>

              <div class="input-group-prepend" style="min-width:200px">
                <form:select id="transaccio_usuariAplicacioId_select" path="usuariAplicacioIdSelect" cssClass="search-query input-medium form-control select2 select2-hidden-accessible" multiple="true" style="width:100%;" tabindex="-1" aria-hidden="true">
                    <c:forEach var="_entry" items="${__theFilterForm.mapOfValuesForUsuariAplicacioId}">
                      <option value="${_entry.key}" ${fn:contains(__theFilterForm.usuariAplicacioIdSelect, _entry.key)?'selected':''} >${_entry.value}</option>
                    </c:forEach>
                </form:select>
              </div>

              <script type="text/javascript">
                $(document).ready(function() {
                    $('#transaccio_usuariAplicacioId_select').select2({
                        closeOnSelect: false
                    });
                    $('.select2-selection__rendered').css('padding-bottom','5px');
                });
              </script>
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.USUARIPERSONAID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <%-- FILTRE NUMERO SELECT MULTIPLE --%>
              <div class="input-group-prepend" style="padding-top: 5px;padding-right: 5px;">
                 <span class="add-on"><fmt:message key="transaccio.usuariPersonaId" />:</span>
              </div>

              <div class="input-group-prepend" style="min-width:200px">
                <form:select id="transaccio_usuariPersonaId_select" path="usuariPersonaIdSelect" cssClass="search-query input-medium form-control select2 select2-hidden-accessible" multiple="true" style="width:100%;" tabindex="-1" aria-hidden="true">
                    <c:forEach var="_entry" items="${__theFilterForm.mapOfValuesForUsuariPersonaId}">
                      <option value="${_entry.key}" ${fn:contains(__theFilterForm.usuariPersonaIdSelect, _entry.key)?'selected':''} >${_entry.value}</option>
                    </c:forEach>
                </form:select>
              </div>

              <script type="text/javascript">
                $(document).ready(function() {
                    $('#transaccio_usuariPersonaId_select').select2({
                        closeOnSelect: false
                    });
                    $('.select2-selection__rendered').css('padding-bottom','5px');
                });
              </script>
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
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <%-- FILTRE NUMERO SELECT MULTIPLE --%>
              <div class="input-group-prepend" style="padding-top: 5px;padding-right: 5px;">
                 <span class="add-on"><fmt:message key="transaccio.estatCodi" />:</span>
              </div>

              <div class="input-group-prepend" style="min-width:200px">
                <form:select id="transaccio_estatCodi_select" path="estatCodiSelect" cssClass="search-query input-medium form-control select2 select2-hidden-accessible" multiple="true" style="width:100%;" tabindex="-1" aria-hidden="true">
                    <c:forEach var="_entry" items="${__theFilterForm.mapOfValuesForEstatCodi}">
                      <option value="${_entry.key}" ${fn:contains(__theFilterForm.estatCodiSelect, _entry.key)?'selected':''} >${_entry.value}</option>
                    </c:forEach>
                </form:select>
              </div>

              <script type="text/javascript">
                $(document).ready(function() {
                    $('#transaccio_estatCodi_select').select2({
                        closeOnSelect: false
                    });
                    $('.select2-selection__rendered').css('padding-bottom','5px');
                });
              </script>
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
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <%-- FILTRE NUMERO SELECT MULTIPLE --%>
              <div class="input-group-prepend" style="padding-top: 5px;padding-right: 5px;">
                 <span class="add-on"><fmt:message key="transaccio.infoScanPixelType" />:</span>
              </div>

              <div class="input-group-prepend" style="min-width:200px">
                <form:select id="transaccio_infoScanPixelType_select" path="infoScanPixelTypeSelect" cssClass="search-query input-medium form-control select2 select2-hidden-accessible" multiple="true" style="width:100%;" tabindex="-1" aria-hidden="true">
                    <c:forEach var="_entry" items="${__theFilterForm.mapOfValuesForInfoScanPixelType}">
                      <option value="${_entry.key}" ${fn:contains(__theFilterForm.infoScanPixelTypeSelect, _entry.key)?'selected':''} >${_entry.value}</option>
                    </c:forEach>
                </form:select>
              </div>

              <script type="text/javascript">
                $(document).ready(function() {
                    $('#transaccio_infoScanPixelType_select').select2({
                        closeOnSelect: false
                    });
                    $('.select2-selection__rendered').css('padding-bottom','5px');
                });
              </script>
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANRESOLUCIOPPP)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="transaccio.infoScanResolucioPpp" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoScanResolucioPppDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="infoScanResolucioPppFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANDATACAPTURA)}">
<%-- FILTRE DATE-TIME --%>
            <div class="input-group" style="padding-right:4px;padding-bottom:4px;align-items:center;">
              <span class="add-on"><fmt:message key="transaccio.infoScanDataCaptura" />:</span>
              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="infoScanDataCapturaDesde" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#infoScanDataCapturaDesde" path="infoScanDataCapturaDesde" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#infoScanDataCapturaDesde"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#infoScanDataCapturaDesde').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="infoScanDataCapturaFins" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#infoScanDataCapturaFins" path="infoScanDataCapturaFins" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#infoScanDataCapturaFins"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#infoScanDataCapturaFins').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>            </div>

    
        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANLANGUAGEDOC)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.infoScanLanguageDoc" var="infoScanLanguageDoc" />
              <fmt:message key="genapp.form.searchby" var="cercaperinfoScanLanguageDoc" >                
                 <fmt:param value="${infoScanLanguageDoc}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${infoScanLanguageDoc}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperinfoScanLanguageDoc}" path="infoScanLanguageDoc" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSCANDOCUMENTTIPUS)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.infoScanDocumentTipus" var="infoScanDocumentTipus" />
              <fmt:message key="genapp.form.searchby" var="cercaperinfoScanDocumentTipus" >                
                 <fmt:param value="${infoScanDocumentTipus}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${infoScanDocumentTipus}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperinfoScanDocumentTipus}" path="infoScanDocumentTipus" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.VIEW)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <%-- FILTRE NUMERO SELECT MULTIPLE --%>
              <div class="input-group-prepend" style="padding-top: 5px;padding-right: 5px;">
                 <span class="add-on"><fmt:message key="transaccio.view" />:</span>
              </div>

              <div class="input-group-prepend" style="min-width:200px">
                <form:select id="transaccio_view_select" path="viewSelect" cssClass="search-query input-medium form-control select2 select2-hidden-accessible" multiple="true" style="width:100%;" tabindex="-1" aria-hidden="true">
                    <c:forEach var="_entry" items="${__theFilterForm.mapOfValuesForView}">
                      <option value="${_entry.key}" ${fn:contains(__theFilterForm.viewSelect, _entry.key)?'selected':''} >${_entry.value}</option>
                    </c:forEach>
                </form:select>
              </div>

              <script type="text/javascript">
                $(document).ready(function() {
                    $('#transaccio_view_select').select2({
                        closeOnSelect: false
                    });
                    $('.select2-selection__rendered').css('padding-bottom','5px');
                });
              </script>
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
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.SIGNPARAMFUNCIONARIDIR3)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="transaccio.signParamFuncionariDir3" var="signParamFuncionariDir3" />
              <fmt:message key="genapp.form.searchby" var="cercapersignParamFuncionariDir3" >                
                 <fmt:param value="${signParamFuncionariDir3}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${signParamFuncionariDir3}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersignParamFuncionariDir3}" path="signParamFuncionariDir3" />
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
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.ARXIUREQPARAMORIGEN)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <%-- FILTRE NUMERO SELECT MULTIPLE --%>
              <div class="input-group-prepend" style="padding-top: 5px;padding-right: 5px;">
                 <span class="add-on"><fmt:message key="transaccio.arxiuReqParamOrigen" />:</span>
              </div>

              <div class="input-group-prepend" style="min-width:200px">
                <form:select id="transaccio_arxiuReqParamOrigen_select" path="arxiuReqParamOrigenSelect" cssClass="search-query input-medium form-control select2 select2-hidden-accessible" multiple="true" style="width:100%;" tabindex="-1" aria-hidden="true">
                    <c:forEach var="_entry" items="${__theFilterForm.mapOfValuesForArxiuReqParamOrigen}">
                      <option value="${_entry.key}" ${fn:contains(__theFilterForm.arxiuReqParamOrigenSelect, _entry.key)?'selected':''} >${_entry.value}</option>
                    </c:forEach>
                </form:select>
              </div>

              <script type="text/javascript">
                $(document).ready(function() {
                    $('#transaccio_arxiuReqParamOrigen_select').select2({
                        closeOnSelect: false
                    });
                    $('.select2-selection__rendered').css('padding-bottom','5px');
                });
              </script>
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
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="transaccio.perfilID" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="perfilIDDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="perfilIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOSIGNATURAID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="transaccio.infoSignaturaID" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoSignaturaIDDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="infoSignaturaIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,TransaccioFields.INFOCUSTODYID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="transaccio.infoCustodyID" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="infoCustodyIDDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="infoCustodyIDFins" />

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
  
