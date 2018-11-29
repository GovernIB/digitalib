<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuariPersonaFields" className="es.caib.digitalib.model.fields.UsuariPersonaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.USERNAME)}">
        <tr id="usuariPersona_username_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.USERNAME])?'usuariPersona.username':__theForm.labels[UsuariPersonaFields.USERNAME]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.USERNAME]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariPersonaFields.USERNAME]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="usuariPersona.username" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.USERNAME)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.USERNAME)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="50" path="usuariPersona.username"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.NOM)}">
        <tr id="usuariPersona_nom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.NOM])?'usuariPersona.nom':__theForm.labels[UsuariPersonaFields.NOM]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.NOM]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariPersonaFields.NOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="usuariPersona.nom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.NOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.NOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="50" path="usuariPersona.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.LLINATGES)}">
        <tr id="usuariPersona_llinatges_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.LLINATGES])?'usuariPersona.llinatges':__theForm.labels[UsuariPersonaFields.LLINATGES]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.LLINATGES]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariPersonaFields.LLINATGES]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="usuariPersona.llinatges" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.LLINATGES)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.LLINATGES)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="100" path="usuariPersona.llinatges"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.EMAIL)}">
        <tr id="usuariPersona_email_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.EMAIL])?'usuariPersona.email':__theForm.labels[UsuariPersonaFields.EMAIL]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.EMAIL]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariPersonaFields.EMAIL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="usuariPersona.email" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.EMAIL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.EMAIL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="100" path="usuariPersona.email"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.NIF)}">
        <tr id="usuariPersona_nif_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.NIF])?'usuariPersona.nif':__theForm.labels[UsuariPersonaFields.NIF]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.NIF]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariPersonaFields.NIF]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="usuariPersona.nif" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.NIF)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.NIF)? 'input-small uneditable-input' : 'input-small'}"  maxlength="9" path="usuariPersona.nif"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.IDIOMAID)}">
        <tr id="usuariPersona_idiomaID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.IDIOMAID])?'usuariPersona.idiomaID':__theForm.labels[UsuariPersonaFields.IDIOMAID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.IDIOMAID]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariPersonaFields.IDIOMAID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="usuariPersona.idiomaID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.IDIOMAID)}" >
          <form:hidden path="usuariPersona.idiomaID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.usuariPersona.idiomaID,__theForm.listOfIdiomaForIdiomaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.IDIOMAID)}" >
          <form:select id="usuariPersona_idiomaID"  onchange="if(typeof onChangeIdiomaID == 'function') {  onChangeIdiomaID(this); };"  cssClass="input-xxlarge" path="usuariPersona.idiomaID">
            <c:forEach items="${__theForm.listOfIdiomaForIdiomaID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.CONFIGURACIOGRUPID)}">
        <tr id="usuariPersona_configuracioGrupID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.CONFIGURACIOGRUPID])?'usuariPersona.configuracioGrupID':__theForm.labels[UsuariPersonaFields.CONFIGURACIOGRUPID]}" />
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.CONFIGURACIOGRUPID]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariPersonaFields.CONFIGURACIOGRUPID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="usuariPersona.configuracioGrupID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.CONFIGURACIOGRUPID)}" >
          <form:hidden path="usuariPersona.configuracioGrupID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.usuariPersona.configuracioGrupID,__theForm.listOfConfiguracioGrupForConfiguracioGrupID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.CONFIGURACIOGRUPID)}" >
          <form:select id="usuariPersona_configuracioGrupID"  onchange="if(typeof onChangeConfiguracioGrupID == 'function') {  onChangeConfiguracioGrupID(this); };"  cssClass="input-xxlarge" path="usuariPersona.configuracioGrupID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfConfiguracioGrupForConfiguracioGrupID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.ROLESCAN)}">
        <tr id="usuariPersona_roleScan_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.ROLESCAN])?'usuariPersona.roleScan':__theForm.labels[UsuariPersonaFields.ROLESCAN]}" />
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.ROLESCAN]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariPersonaFields.ROLESCAN]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLESCAN)}" >
              <form:errors path="usuariPersona.roleScan" cssClass="errorField alert alert-error" />
              <form:checkbox onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLESCAN)? 'false' : 'true'}" path="usuariPersona.roleScan" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLESCAN)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariPersona.roleScan}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.ROLECOAU)}">
        <tr id="usuariPersona_roleCoAu_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.ROLECOAU])?'usuariPersona.roleCoAu':__theForm.labels[UsuariPersonaFields.ROLECOAU]}" />
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.ROLECOAU]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariPersonaFields.ROLECOAU]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECOAU)}" >
              <form:errors path="usuariPersona.roleCoAu" cssClass="errorField alert alert-error" />
              <form:checkbox onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECOAU)? 'false' : 'true'}" path="usuariPersona.roleCoAu" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECOAU)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariPersona.roleCoAu}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.ROLECUST)}">
        <tr id="usuariPersona_roleCust_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.ROLECUST])?'usuariPersona.roleCust':__theForm.labels[UsuariPersonaFields.ROLECUST]}" />
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.ROLECUST]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariPersonaFields.ROLECUST]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECUST)}" >
              <form:errors path="usuariPersona.roleCust" cssClass="errorField alert alert-error" />
              <form:checkbox onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECUST)? 'false' : 'true'}" path="usuariPersona.roleCust" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECUST)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariPersona.roleCust}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
