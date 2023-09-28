<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="AuditoriaFields" className="es.caib.digitalib.model.fields.AuditoriaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.DATA)}">
        <tr id="auditoria_data_rowid">
          <td id="auditoria_data_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.DATA])?'auditoria.data':__theForm.labels[AuditoriaFields.DATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[AuditoriaFields.DATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AuditoriaFields.DATA]}" ></i>
              </c:if>
            </td>
          <td id="auditoria_data_columnvalueid">
    <form:errors path="auditoria.data" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="auditoria_data" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.DATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#auditoria_data" path="auditoria.data" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,AuditoriaFields.DATA)}" >
                    <div class="input-group-append"  data-target="#auditoria_data"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#auditoria_data').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.TRANSACCIOID)}">
        <tr id="auditoria_transaccioId_rowid">
          <td id="auditoria_transaccioId_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.TRANSACCIOID])?'auditoria.transaccioId':__theForm.labels[AuditoriaFields.TRANSACCIOID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[AuditoriaFields.TRANSACCIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AuditoriaFields.TRANSACCIOID]}" ></i>
              </c:if>
            </td>
          <td id="auditoria_transaccioId_columnvalueid">
            <form:errors path="auditoria.transaccioId" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.TRANSACCIOID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,AuditoriaFields.TRANSACCIOID)? ' uneditable-input' : ''}"  style=""  path="auditoria.transaccioId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.TIPUS)}">
        <tr id="auditoria_tipus_rowid">
          <td id="auditoria_tipus_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.TIPUS])?'auditoria.tipus':__theForm.labels[AuditoriaFields.TIPUS]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[AuditoriaFields.TIPUS]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AuditoriaFields.TIPUS]}" ></i>
              </c:if>
            </td>
          <td id="auditoria_tipus_columnvalueid">
          <form:errors path="auditoria.tipus" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,AuditoriaFields.TIPUS)}" >
          <form:hidden path="auditoria.tipus"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.auditoria.tipus,__theForm.listOfValuesForTipus)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,AuditoriaFields.TIPUS)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="auditoria_tipus"  onchange="if(typeof onChangeTipus == 'function') {  onChangeTipus(this); };"  cssClass="form-control col-md-9-optional" path="auditoria.tipus">
            <c:forEach items="${__theForm.listOfValuesForTipus}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.MISSATGE)}">
        <tr id="auditoria_missatge_rowid">
          <td id="auditoria_missatge_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.MISSATGE])?'auditoria.missatge':__theForm.labels[AuditoriaFields.MISSATGE]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[AuditoriaFields.MISSATGE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AuditoriaFields.MISSATGE]}" ></i>
              </c:if>
            </td>
          <td id="auditoria_missatge_columnvalueid">
              <form:errors path="auditoria.missatge" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.MISSATGE)? 'true' : 'false'}" path="auditoria.missatge"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_missatge" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_missatge" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('auditoria.missatge'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('auditoria.missatge'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('auditoria.missatge'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_missatge').on('click', function(){
					var valor = ($('#dropdownMenuContainer_missatge').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_missatge').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.ADDITIONALINFO)}">
        <tr id="auditoria_additionalInfo_rowid">
          <td id="auditoria_additionalInfo_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.ADDITIONALINFO])?'auditoria.additionalInfo':__theForm.labels[AuditoriaFields.ADDITIONALINFO]}" />
             </label>
              <c:if test="${not empty __theForm.help[AuditoriaFields.ADDITIONALINFO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AuditoriaFields.ADDITIONALINFO]}" ></i>
              </c:if>
            </td>
          <td id="auditoria_additionalInfo_columnvalueid">
              <form:errors path="auditoria.additionalInfo" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.ADDITIONALINFO)? 'true' : 'false'}" path="auditoria.additionalInfo"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_additionalInfo" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_additionalInfo" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('auditoria.additionalInfo'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('auditoria.additionalInfo'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('auditoria.additionalInfo'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_additionalInfo').on('click', function(){
					var valor = ($('#dropdownMenuContainer_additionalInfo').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_additionalInfo').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.ISAPP)}">
        <tr id="auditoria_isApp_rowid">
          <td id="auditoria_isApp_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.ISAPP])?'auditoria.isApp':__theForm.labels[AuditoriaFields.ISAPP]}" />
             </label>
              <c:if test="${not empty __theForm.help[AuditoriaFields.ISAPP]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AuditoriaFields.ISAPP]}" ></i>
              </c:if>
            </td>
          <td id="auditoria_isApp_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,AuditoriaFields.ISAPP)}" >
              <form:select cssClass="form-control col-md-6" onchange="if(typeof onChangeIsApp == 'function') {  onChangeIsApp(this); };"  path="auditoria.isApp">
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
          <td id="auditoria_usernameAplicacio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.USERNAMEAPLICACIO])?'auditoria.usernameAplicacio':__theForm.labels[AuditoriaFields.USERNAMEAPLICACIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[AuditoriaFields.USERNAMEAPLICACIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AuditoriaFields.USERNAMEAPLICACIO]}" ></i>
              </c:if>
            </td>
          <td id="auditoria_usernameAplicacio_columnvalueid">
            <form:errors path="auditoria.usernameAplicacio" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.USERNAMEAPLICACIO)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,AuditoriaFields.USERNAMEAPLICACIO)? ' uneditable-input' : ''}"  style="" maxlength="255" path="auditoria.usernameAplicacio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AuditoriaFields.USERNAMEPERSONA)}">
        <tr id="auditoria_usernamePersona_rowid">
          <td id="auditoria_usernamePersona_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AuditoriaFields.USERNAMEPERSONA])?'auditoria.usernamePersona':__theForm.labels[AuditoriaFields.USERNAMEPERSONA]}" />
             </label>
              <c:if test="${not empty __theForm.help[AuditoriaFields.USERNAMEPERSONA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AuditoriaFields.USERNAMEPERSONA]}" ></i>
              </c:if>
            </td>
          <td id="auditoria_usernamePersona_columnvalueid">
            <form:errors path="auditoria.usernamePersona" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AuditoriaFields.USERNAMEPERSONA)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,AuditoriaFields.USERNAMEPERSONA)? ' uneditable-input' : ''}"  style="" maxlength="255" path="auditoria.usernamePersona"   />

           </td>
        </tr>
        </c:if>
        
