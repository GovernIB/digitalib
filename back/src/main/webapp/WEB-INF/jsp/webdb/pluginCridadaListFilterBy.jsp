<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PluginCridadaFields" className="es.caib.digitalib.model.fields.PluginCridadaFields"/>

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


        <c:if test="${gen:contains(__theFilterForm.filterByFields ,PluginCridadaFields.PLUGINCRIDADAID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="pluginCridada.pluginCridadaID" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="pluginCridadaIDDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="pluginCridadaIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,PluginCridadaFields.DATA)}">
            <%-- FILTRE DATE --%>
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="pluginCridada.data" />:</span>
              <span class="add-on"><fmt:message key="genapp.from" /></span>
              <div id="dataDesde" class="input-append">
                <form:input cssClass="input-large" path="dataDesde" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataDesde').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
              <span class="add-on"><fmt:message key="genapp.to" /></span>              
              <div id="dataFins" class="input-append">
                <form:input cssClass="input-large" path="dataFins" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataFins').datetimepicker({
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
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,PluginCridadaFields.PLUGINID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="pluginCridada.pluginID" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="pluginIDDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="pluginIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,PluginCridadaFields.METODEPLUGIN)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="pluginCridada.metodePlugin" var="metodePlugin" />
              <fmt:message key="genapp.form.searchby" var="cercapermetodePlugin" >                
                 <fmt:param value="${metodePlugin}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${metodePlugin}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapermetodePlugin}" path="metodePlugin" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,PluginCridadaFields.TIPUSRESULTAT)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="pluginCridada.tipusResultat" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="tipusResultatDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="tipusResultatFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,PluginCridadaFields.TEMPSEXECUCIO)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="pluginCridada.tempsExecucio" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="tempsExecucioDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="tempsExecucioFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,PluginCridadaFields.USUARIPERSONAID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="pluginCridada.usuariPersonaId" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="usuariPersonaIdDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="usuariPersonaIdFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,PluginCridadaFields.USUARIAPLICACIOID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-prepend input-append" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="pluginCridada.usuariAplicacioId" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="usuariAplicacioIdDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="usuariAplicacioIdFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,PluginCridadaFields.PARAMETRESTEXT)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="pluginCridada.parametresText" var="parametresText" />
              <fmt:message key="genapp.form.searchby" var="cercaperparametresText" >                
                 <fmt:param value="${parametresText}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${parametresText}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperparametresText}" path="parametresText" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,PluginCridadaFields.RETORNTEXT)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="pluginCridada.retornText" var="retornText" />
              <fmt:message key="genapp.form.searchby" var="cercaperretornText" >                
                 <fmt:param value="${retornText}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${retornText}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperretornText}" path="retornText" />
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
  