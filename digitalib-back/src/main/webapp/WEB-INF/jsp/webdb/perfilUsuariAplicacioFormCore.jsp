<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PerfilUsuariAplicacioFields" className="es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilUsuariAplicacioFields.PERFILID)}">
        <tr id="perfilUsuariAplicacio_perfilID_rowid">
          <td id="perfilUsuariAplicacio_perfilID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilUsuariAplicacioFields.PERFILID])?'perfilUsuariAplicacio.perfilID':__theForm.labels[PerfilUsuariAplicacioFields.PERFILID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PerfilUsuariAplicacioFields.PERFILID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilUsuariAplicacioFields.PERFILID]}" ></i>
              </c:if>
            </td>
          <td id="perfilUsuariAplicacio_perfilID_columnvalueid">
          <form:errors path="perfilUsuariAplicacio.perfilID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilUsuariAplicacioFields.PERFILID)}" >
          <form:hidden path="perfilUsuariAplicacio.perfilID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfilUsuariAplicacio.perfilID,__theForm.listOfPerfilForPerfilID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilUsuariAplicacioFields.PERFILID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfilUsuariAplicacio_perfilID"  onchange="if(typeof onChangePerfilID == 'function') {  onChangePerfilID(this); };"  cssClass="form-control col-md-9-optional" path="perfilUsuariAplicacio.perfilID">
            <c:forEach items="${__theForm.listOfPerfilForPerfilID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilUsuariAplicacioFields.USUARIAPLICACIOID)}">
        <tr id="perfilUsuariAplicacio_usuariAplicacioID_rowid">
          <td id="perfilUsuariAplicacio_usuariAplicacioID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilUsuariAplicacioFields.USUARIAPLICACIOID])?'perfilUsuariAplicacio.usuariAplicacioID':__theForm.labels[PerfilUsuariAplicacioFields.USUARIAPLICACIOID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PerfilUsuariAplicacioFields.USUARIAPLICACIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilUsuariAplicacioFields.USUARIAPLICACIOID]}" ></i>
              </c:if>
            </td>
          <td id="perfilUsuariAplicacio_usuariAplicacioID_columnvalueid">
          <form:errors path="perfilUsuariAplicacio.usuariAplicacioID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilUsuariAplicacioFields.USUARIAPLICACIOID)}" >
          <form:hidden path="perfilUsuariAplicacio.usuariAplicacioID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfilUsuariAplicacio.usuariAplicacioID,__theForm.listOfUsuariAplicacioForUsuariAplicacioID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilUsuariAplicacioFields.USUARIAPLICACIOID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfilUsuariAplicacio_usuariAplicacioID"  onchange="if(typeof onChangeUsuariAplicacioID == 'function') {  onChangeUsuariAplicacioID(this); };"  cssClass="form-control col-md-9-optional" path="perfilUsuariAplicacio.usuariAplicacioID">
            <c:forEach items="${__theForm.listOfUsuariAplicacioForUsuariAplicacioID}" var="tmp">
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
        
