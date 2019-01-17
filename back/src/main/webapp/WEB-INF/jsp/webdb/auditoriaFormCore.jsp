<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="AuditoriaFields" className="es.caib.digitalib.model.fields.AuditoriaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.DATA)}">
        <tr id="auditoria_data_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.DATA])?'auditoria.data':__theForm.labels[AuditoriaFields.DATA]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[AuditoriaFields.DATA]}">
              <i class="icon-info-sign" title="${__theForm.help[AuditoriaFields.DATA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="auditoria.data" cssClass="errorField alert alert-error" />
              <div id="data" class="input-append">
                <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.DATA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,AuditoriaFields.DATA)? 'input-medium uneditable-input' : 'input-medium'}"  path="auditoria.data" />
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,AuditoriaFields.DATA)}" >
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </c:if>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#data').datetimepicker({
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.TRANSACCIOID)}">
        <tr id="auditoria_transaccioId_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.TRANSACCIOID])?'auditoria.transaccioId':__theForm.labels[AuditoriaFields.TRANSACCIOID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[AuditoriaFields.TRANSACCIOID]}">
              <i class="icon-info-sign" title="${__theForm.help[AuditoriaFields.TRANSACCIOID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="auditoria.transaccioId" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.TRANSACCIOID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,AuditoriaFields.TRANSACCIOID)? 'input-mini uneditable-input' : 'input-mini'}"   path="auditoria.transaccioId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.TIPUS)}">
        <tr id="auditoria_tipus_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.TIPUS])?'auditoria.tipus':__theForm.labels[AuditoriaFields.TIPUS]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[AuditoriaFields.TIPUS]}">
              <i class="icon-info-sign" title="${__theForm.help[AuditoriaFields.TIPUS]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="auditoria.tipus" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,AuditoriaFields.TIPUS)}" >
          <form:hidden path="auditoria.tipus"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.auditoria.tipus,__theForm.listOfValuesForTipus)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,AuditoriaFields.TIPUS)}" >
          <form:select id="auditoria_tipus"  onchange="if(typeof onChangeTipus == 'function') {  onChangeTipus(this); };"  cssClass="input-xxlarge" path="auditoria.tipus">
            <c:forEach items="${__theForm.listOfValuesForTipus}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.MISSATGE)}">
        <tr id="auditoria_missatge_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.MISSATGE])?'auditoria.missatge':__theForm.labels[AuditoriaFields.MISSATGE]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[AuditoriaFields.MISSATGE]}">
              <i class="icon-info-sign" title="${__theForm.help[AuditoriaFields.MISSATGE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="auditoria.missatge" cssClass="errorField alert alert-error" />
              <form:textarea rows="3" wrap="soft" style="overflow:auto;" cssClass="input-xxlarge" readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.MISSATGE)? 'true' : 'false'}" path="auditoria.missatge"  />
              <div class="btn-group" style="vertical-align: top;">
              <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown">&nbsp;<span class="caret"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#" onclick="javascript:var ta=document.getElementById('auditoria.missatge'); ta.wrap='off';" >No Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('auditoria.missatge'); ta.wrap='soft';">Soft Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('auditoria.missatge'); ta.wrap='hard';">Hard Wrap</a></li>
              </ul>
              </div>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.ADDITIONALINFO)}">
        <tr id="auditoria_additionalInfo_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.ADDITIONALINFO])?'auditoria.additionalInfo':__theForm.labels[AuditoriaFields.ADDITIONALINFO]}" />
              <c:if test="${not empty __theForm.help[AuditoriaFields.ADDITIONALINFO]}">
              <i class="icon-info-sign" title="${__theForm.help[AuditoriaFields.ADDITIONALINFO]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="auditoria.additionalInfo" cssClass="errorField alert alert-error" />
              <form:textarea rows="3" wrap="soft" style="overflow:auto;" cssClass="input-xxlarge" readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.ADDITIONALINFO)? 'true' : 'false'}" path="auditoria.additionalInfo"  />
              <div class="btn-group" style="vertical-align: top;">
              <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown">&nbsp;<span class="caret"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#" onclick="javascript:var ta=document.getElementById('auditoria.additionalInfo'); ta.wrap='off';" >No Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('auditoria.additionalInfo'); ta.wrap='soft';">Soft Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('auditoria.additionalInfo'); ta.wrap='hard';">Hard Wrap</a></li>
              </ul>
              </div>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.ISAPP)}">
        <tr id="auditoria_isApp_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.ISAPP])?'auditoria.isApp':__theForm.labels[AuditoriaFields.ISAPP]}" />
              <c:if test="${not empty __theForm.help[AuditoriaFields.ISAPP]}">
              <i class="icon-info-sign" title="${__theForm.help[AuditoriaFields.ISAPP]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,AuditoriaFields.ISAPP)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeIsApp == 'function') {  onChangeIsApp(this); };"  path="auditoria.isApp">
                <form:option value="true" ><fmt:message key="auditoria.tipustransaccio.true" /></form:option>
                <form:option value="false" ><fmt:message key="auditoria.tipustransaccio.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,AuditoriaFields.ISAPP)}" >
                <fmt:message key="auditoria.tipustransaccio.${__theForm.auditoria.isApp}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.USERNAMEAPLICACIO)}">
        <tr id="auditoria_usernameAplicacio_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.USERNAMEAPLICACIO])?'auditoria.usernameAplicacio':__theForm.labels[AuditoriaFields.USERNAMEAPLICACIO]}" />
              <c:if test="${not empty __theForm.help[AuditoriaFields.USERNAMEAPLICACIO]}">
              <i class="icon-info-sign" title="${__theForm.help[AuditoriaFields.USERNAMEAPLICACIO]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="auditoria.usernameAplicacio" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.USERNAMEAPLICACIO)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,AuditoriaFields.USERNAMEAPLICACIO)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="auditoria.usernameAplicacio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.USERNAMEPERSONA)}">
        <tr id="auditoria_usernamePersona_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.USERNAMEPERSONA])?'auditoria.usernamePersona':__theForm.labels[AuditoriaFields.USERNAMEPERSONA]}" />
              <c:if test="${not empty __theForm.help[AuditoriaFields.USERNAMEPERSONA]}">
              <i class="icon-info-sign" title="${__theForm.help[AuditoriaFields.USERNAMEPERSONA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="auditoria.usernamePersona" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.USERNAMEPERSONA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,AuditoriaFields.USERNAMEPERSONA)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="auditoria.usernamePersona"   />

           </td>
        </tr>
        </c:if>
        
