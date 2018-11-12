<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PerfilUsuariAplicacioFields" className="es.caib.digitalib.model.fields.PerfilUsuariAplicacioFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilUsuariAplicacioFields.PERFILID)}">
        <tr id="perfilUsuariAplicacio_perfilID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilUsuariAplicacioFields.PERFILID])?'perfilUsuariAplicacio.perfilID':__theForm.labels[PerfilUsuariAplicacioFields.PERFILID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PerfilUsuariAplicacioFields.PERFILID]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilUsuariAplicacioFields.PERFILID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfilUsuariAplicacio.perfilID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilUsuariAplicacioFields.PERFILID)}" >
          <form:hidden path="perfilUsuariAplicacio.perfilID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfilUsuariAplicacio.perfilID,__theForm.listOfPerfilForPerfilID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilUsuariAplicacioFields.PERFILID)}" >
          <form:select id="perfilUsuariAplicacio_perfilID"  onchange="if(typeof onChangePerfilID == 'function') {  onChangePerfilID(this); };"  cssClass="input-xxlarge" path="perfilUsuariAplicacio.perfilID">
            <c:forEach items="${__theForm.listOfPerfilForPerfilID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilUsuariAplicacioFields.USUARIAPLICACIOID)}">
        <tr id="perfilUsuariAplicacio_usuariAplicacioID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilUsuariAplicacioFields.USUARIAPLICACIOID])?'perfilUsuariAplicacio.usuariAplicacioID':__theForm.labels[PerfilUsuariAplicacioFields.USUARIAPLICACIOID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PerfilUsuariAplicacioFields.USUARIAPLICACIOID]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilUsuariAplicacioFields.USUARIAPLICACIOID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfilUsuariAplicacio.usuariAplicacioID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilUsuariAplicacioFields.USUARIAPLICACIOID)}" >
          <form:hidden path="perfilUsuariAplicacio.usuariAplicacioID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfilUsuariAplicacio.usuariAplicacioID,__theForm.listOfUsuariAplicacioForUsuariAplicacioID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilUsuariAplicacioFields.USUARIAPLICACIOID)}" >
          <form:select id="perfilUsuariAplicacio_usuariAplicacioID"  onchange="if(typeof onChangeUsuariAplicacioID == 'function') {  onChangeUsuariAplicacioID(this); };"  cssClass="input-xxlarge" path="perfilUsuariAplicacio.usuariAplicacioID">
            <c:forEach items="${__theForm.listOfUsuariAplicacioForUsuariAplicacioID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
