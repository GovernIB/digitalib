<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="AvisFields" className="es.caib.digitalib.model.fields.AvisFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,AvisFields.DESCRIPCIOID)}">
        <tr id="avis_descripcioID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AvisFields.DESCRIPCIOID])?'avis.descripcioID':__theForm.labels[AvisFields.DESCRIPCIOID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[AvisFields.DESCRIPCIOID]}">
              <i class="icon-info-sign" title="${__theForm.help[AvisFields.DESCRIPCIOID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
       <form:errors path="avis.descripcio" cssClass="errorField alert alert-error" />
       <div class="tabbable">
         <ul class="nav nav-tabs" style="margin-bottom: 3px;">
             <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
               <li class="${(counter.index == 0)? 'active':''}"  ><a href="#${counter.index}_tab_descripcio_${idioma.idiomaID}" data-toggle="tab">${idioma.nom}</a></li>
           </c:forEach>
           
         </ul>
         <div class="tab-content">
           <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
           <div class="tab-pane ${(counter.index == 0)? 'active':'' }" id="${counter.index}_tab_descripcio_${idioma.idiomaID}">
               <form:errors path="avis.descripcio.traduccions['${idioma.idiomaID}'].valor" cssClass="errorField alert alert-error"/>
               <form:input path="avis.descripcio.traduccions['${idioma.idiomaID}'].valor" readonly="${ gen:contains(__theForm.readOnlyFields ,AvisFields.DESCRIPCIOID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,AvisFields.DESCRIPCIOID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="4000" />
           </div>
           </c:forEach>
         </div>
       </div>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AvisFields.TIPUS)}">
        <tr id="avis_tipus_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AvisFields.TIPUS])?'avis.tipus':__theForm.labels[AvisFields.TIPUS]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[AvisFields.TIPUS]}">
              <i class="icon-info-sign" title="${__theForm.help[AvisFields.TIPUS]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="avis.tipus" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,AvisFields.TIPUS)}" >
          <form:hidden path="avis.tipus"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.avis.tipus,__theForm.listOfValuesForTipus)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,AvisFields.TIPUS)}" >
          <form:select id="avis_tipus"  onchange="if(typeof onChangeTipus == 'function') {  onChangeTipus(this); };"  cssClass="input-xxlarge" path="avis.tipus">
            <c:forEach items="${__theForm.listOfValuesForTipus}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AvisFields.DATAINICI)}">
        <tr id="avis_dataInici_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AvisFields.DATAINICI])?'avis.dataInici':__theForm.labels[AvisFields.DATAINICI]}" />
              <c:if test="${not empty __theForm.help[AvisFields.DATAINICI]}">
              <i class="icon-info-sign" title="${__theForm.help[AvisFields.DATAINICI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="avis.dataInici" cssClass="errorField alert alert-error" />
              <div id="dataInici" class="input-append">
                <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AvisFields.DATAINICI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,AvisFields.DATAINICI)? 'input-medium uneditable-input' : 'input-medium'}"  path="avis.dataInici" />
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,AvisFields.DATAINICI)}" >
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </c:if>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataInici').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AvisFields.DATAFI)}">
        <tr id="avis_dataFi_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AvisFields.DATAFI])?'avis.dataFi':__theForm.labels[AvisFields.DATAFI]}" />
              <c:if test="${not empty __theForm.help[AvisFields.DATAFI]}">
              <i class="icon-info-sign" title="${__theForm.help[AvisFields.DATAFI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="avis.dataFi" cssClass="errorField alert alert-error" />
              <div id="dataFi" class="input-append">
                <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AvisFields.DATAFI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,AvisFields.DATAFI)? 'input-medium uneditable-input' : 'input-medium'}"  path="avis.dataFi" />
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,AvisFields.DATAFI)}" >
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </c:if>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataFi').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AvisFields.CONFIGGRUPID)}">
        <tr id="avis_configGrupID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AvisFields.CONFIGGRUPID])?'avis.configGrupID':__theForm.labels[AvisFields.CONFIGGRUPID]}" />
              <c:if test="${not empty __theForm.help[AvisFields.CONFIGGRUPID]}">
              <i class="icon-info-sign" title="${__theForm.help[AvisFields.CONFIGGRUPID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="avis.configGrupID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,AvisFields.CONFIGGRUPID)}" >
          <form:hidden path="avis.configGrupID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.avis.configGrupID,__theForm.listOfConfiguracioGrupForConfigGrupID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,AvisFields.CONFIGGRUPID)}" >
          <form:select id="avis_configGrupID"  onchange="if(typeof onChangeConfigGrupID == 'function') {  onChangeConfigGrupID(this); };"  cssClass="input-xxlarge" path="avis.configGrupID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfConfiguracioGrupForConfigGrupID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AvisFields.BLOQUEJAR)}">
        <tr id="avis_bloquejar_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AvisFields.BLOQUEJAR])?'avis.bloquejar':__theForm.labels[AvisFields.BLOQUEJAR]}" />
              <c:if test="${not empty __theForm.help[AvisFields.BLOQUEJAR]}">
              <i class="icon-info-sign" title="${__theForm.help[AvisFields.BLOQUEJAR]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,AvisFields.BLOQUEJAR)}" >
              <form:errors path="avis.bloquejar" cssClass="errorField alert alert-error" />
              <form:checkbox onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,AvisFields.BLOQUEJAR)? 'false' : 'true'}" path="avis.bloquejar" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,AvisFields.BLOQUEJAR)}" >
                <fmt:message key="genapp.checkbox.${__theForm.avis.bloquejar}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
