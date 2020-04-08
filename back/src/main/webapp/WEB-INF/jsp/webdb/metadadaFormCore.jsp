<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="MetadadaFields" className="es.caib.digitalib.model.fields.MetadadaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,MetadadaFields.TRANSACCIOID)}">
        <tr id="metadada_transaccioID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[MetadadaFields.TRANSACCIOID])?'metadada.transaccioID':__theForm.labels[MetadadaFields.TRANSACCIOID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[MetadadaFields.TRANSACCIOID]}">
              <i class="icon-info-sign" title="${__theForm.help[MetadadaFields.TRANSACCIOID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="metadada.transaccioID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,MetadadaFields.TRANSACCIOID)}" >
          <form:hidden path="metadada.transaccioID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.metadada.transaccioID,__theForm.listOfTransaccioForTransaccioID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,MetadadaFields.TRANSACCIOID)}" >
          <form:select id="metadada_transaccioID"  onchange="if(typeof onChangeTransaccioID == 'function') {  onChangeTransaccioID(this); };"  cssClass="input-xxlarge" path="metadada.transaccioID">
            <c:forEach items="${__theForm.listOfTransaccioForTransaccioID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,MetadadaFields.NOM)}">
        <tr id="metadada_nom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[MetadadaFields.NOM])?'metadada.nom':__theForm.labels[MetadadaFields.NOM]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[MetadadaFields.NOM]}">
              <i class="icon-info-sign" title="${__theForm.help[MetadadaFields.NOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="metadada.nom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,MetadadaFields.NOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,MetadadaFields.NOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="metadada.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,MetadadaFields.VALOR)}">
        <tr id="metadada_valor_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[MetadadaFields.VALOR])?'metadada.valor':__theForm.labels[MetadadaFields.VALOR]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[MetadadaFields.VALOR]}">
              <i class="icon-info-sign" title="${__theForm.help[MetadadaFields.VALOR]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="metadada.valor" cssClass="errorField alert alert-error" />
              <form:textarea rows="3" wrap="soft" style="overflow:auto;" cssClass="input-xxlarge" readonly="${ gen:contains(__theForm.readOnlyFields ,MetadadaFields.VALOR)? 'true' : 'false'}" path="metadada.valor"  />
              <div class="btn-group" style="vertical-align: top;">
              <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown">&nbsp;<span class="caret"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#" onclick="javascript:var ta=document.getElementById('metadada.valor'); ta.wrap='off';" >No Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('metadada.valor'); ta.wrap='soft';">Soft Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('metadada.valor'); ta.wrap='hard';">Hard Wrap</a></li>
              </ul>
              </div>
           </td>
        </tr>
        </c:if>
        
