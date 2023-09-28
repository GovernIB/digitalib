<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EstadisticaFields" className="es.caib.digitalib.model.fields.EstadisticaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,EstadisticaFields.TIPUS)}">
        <tr id="estadistica_tipus_rowid">
          <td id="estadistica_tipus_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EstadisticaFields.TIPUS])?'estadistica.tipus':__theForm.labels[EstadisticaFields.TIPUS]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EstadisticaFields.TIPUS]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EstadisticaFields.TIPUS]}" ></i>
              </c:if>
            </td>
          <td id="estadistica_tipus_columnvalueid">
          <form:errors path="estadistica.tipus" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,EstadisticaFields.TIPUS)}" >
          <form:hidden path="estadistica.tipus"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.estadistica.tipus,__theForm.listOfValuesForTipus)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,EstadisticaFields.TIPUS)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="estadistica_tipus"  onchange="if(typeof onChangeTipus == 'function') {  onChangeTipus(this); };"  cssClass="form-control col-md-9-optional" path="estadistica.tipus">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EstadisticaFields.DATA)}">
        <tr id="estadistica_data_rowid">
          <td id="estadistica_data_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EstadisticaFields.DATA])?'estadistica.data':__theForm.labels[EstadisticaFields.DATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EstadisticaFields.DATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EstadisticaFields.DATA]}" ></i>
              </c:if>
            </td>
          <td id="estadistica_data_columnvalueid">
    <form:errors path="estadistica.data" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="estadistica_data" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EstadisticaFields.DATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#estadistica_data" path="estadistica.data" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,EstadisticaFields.DATA)}" >
                    <div class="input-group-append"  data-target="#estadistica_data"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#estadistica_data').datetimepicker({
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EstadisticaFields.VALOR)}">
        <tr id="estadistica_valor_rowid">
          <td id="estadistica_valor_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EstadisticaFields.VALOR])?'estadistica.valor':__theForm.labels[EstadisticaFields.VALOR]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EstadisticaFields.VALOR]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EstadisticaFields.VALOR]}" ></i>
              </c:if>
            </td>
          <td id="estadistica_valor_columnvalueid">
            <form:errors path="estadistica.valor" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EstadisticaFields.VALOR)? 'true' : 'false'}" cssClass="w-50 form-control  ${gen:contains(__theForm.readOnlyFields ,EstadisticaFields.VALOR)? ' uneditable-input' : ''}"  style=""  path="estadistica.valor"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EstadisticaFields.PARAMETRES)}">
        <tr id="estadistica_parametres_rowid">
          <td id="estadistica_parametres_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EstadisticaFields.PARAMETRES])?'estadistica.parametres':__theForm.labels[EstadisticaFields.PARAMETRES]}" />
             </label>
              <c:if test="${not empty __theForm.help[EstadisticaFields.PARAMETRES]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EstadisticaFields.PARAMETRES]}" ></i>
              </c:if>
            </td>
          <td id="estadistica_parametres_columnvalueid">
              <form:errors path="estadistica.parametres" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EstadisticaFields.PARAMETRES)? 'true' : 'false'}" path="estadistica.parametres"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_parametres" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_parametres" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('estadistica.parametres'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('estadistica.parametres'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('estadistica.parametres'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_parametres').on('click', function(){
					var valor = ($('#dropdownMenuContainer_parametres').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_parametres').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EstadisticaFields.USUARIAPLICACIOID)}">
        <tr id="estadistica_usuariAplicacioID_rowid">
          <td id="estadistica_usuariAplicacioID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EstadisticaFields.USUARIAPLICACIOID])?'estadistica.usuariAplicacioID':__theForm.labels[EstadisticaFields.USUARIAPLICACIOID]}" />
             </label>
              <c:if test="${not empty __theForm.help[EstadisticaFields.USUARIAPLICACIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EstadisticaFields.USUARIAPLICACIOID]}" ></i>
              </c:if>
            </td>
          <td id="estadistica_usuariAplicacioID_columnvalueid">
            <form:errors path="estadistica.usuariAplicacioID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EstadisticaFields.USUARIAPLICACIOID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,EstadisticaFields.USUARIAPLICACIOID)? ' uneditable-input' : ''}"  style=""  path="estadistica.usuariAplicacioID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EstadisticaFields.USUARIPERSONAID)}">
        <tr id="estadistica_usuariPersonaID_rowid">
          <td id="estadistica_usuariPersonaID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EstadisticaFields.USUARIPERSONAID])?'estadistica.usuariPersonaID':__theForm.labels[EstadisticaFields.USUARIPERSONAID]}" />
             </label>
              <c:if test="${not empty __theForm.help[EstadisticaFields.USUARIPERSONAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EstadisticaFields.USUARIPERSONAID]}" ></i>
              </c:if>
            </td>
          <td id="estadistica_usuariPersonaID_columnvalueid">
            <form:errors path="estadistica.usuariPersonaID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EstadisticaFields.USUARIPERSONAID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,EstadisticaFields.USUARIPERSONAID)? ' uneditable-input' : ''}"  style=""  path="estadistica.usuariPersonaID"   />

           </td>
        </tr>
        </c:if>
        
