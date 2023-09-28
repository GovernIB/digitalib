<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="MetadadaFields" className="es.caib.digitalib.model.fields.MetadadaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,MetadadaFields.TRANSACCIOID)}">
        <tr id="metadada_transaccioID_rowid">
          <td id="metadada_transaccioID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[MetadadaFields.TRANSACCIOID])?'metadada.transaccioID':__theForm.labels[MetadadaFields.TRANSACCIOID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[MetadadaFields.TRANSACCIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[MetadadaFields.TRANSACCIOID]}" ></i>
              </c:if>
            </td>
          <td id="metadada_transaccioID_columnvalueid">
          <form:errors path="metadada.transaccioID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,MetadadaFields.TRANSACCIOID)}" >
          <form:hidden path="metadada.transaccioID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.metadada.transaccioID,__theForm.listOfTransaccioForTransaccioID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,MetadadaFields.TRANSACCIOID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="metadada_transaccioID"  onchange="if(typeof onChangeTransaccioID == 'function') {  onChangeTransaccioID(this); };"  cssClass="form-control col-md-9-optional" path="metadada.transaccioID">
            <c:forEach items="${__theForm.listOfTransaccioForTransaccioID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,MetadadaFields.NOM)}">
        <tr id="metadada_nom_rowid">
          <td id="metadada_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[MetadadaFields.NOM])?'metadada.nom':__theForm.labels[MetadadaFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[MetadadaFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[MetadadaFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="metadada_nom_columnvalueid">
            <form:errors path="metadada.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,MetadadaFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,MetadadaFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="metadada.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,MetadadaFields.VALOR)}">
        <tr id="metadada_valor_rowid">
          <td id="metadada_valor_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[MetadadaFields.VALOR])?'metadada.valor':__theForm.labels[MetadadaFields.VALOR]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[MetadadaFields.VALOR]}">
              <i class="fas fa-info-circle" title="${__theForm.help[MetadadaFields.VALOR]}" ></i>
              </c:if>
            </td>
          <td id="metadada_valor_columnvalueid">
              <form:errors path="metadada.valor" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,MetadadaFields.VALOR)? 'true' : 'false'}" path="metadada.valor"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_valor" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_valor" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('metadada.valor'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('metadada.valor'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('metadada.valor'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_valor').on('click', function(){
					var valor = ($('#dropdownMenuContainer_valor').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_valor').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
