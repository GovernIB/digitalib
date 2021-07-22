<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuariAplicacioFields" className="es.caib.digitalib.model.fields.UsuariAplicacioFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.USERNAME)}">
        <tr id="usuariAplicacio_username_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.USERNAME])?'usuariAplicacio.username':__theForm.labels[UsuariAplicacioFields.USERNAME]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.USERNAME]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariAplicacioFields.USERNAME]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="usuariAplicacio.username" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.USERNAME)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.USERNAME)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="101" path="usuariAplicacio.username"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.CONTRASENYA)}">
        <tr id="usuariAplicacio_contrasenya_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.CONTRASENYA])?'usuariAplicacio.contrasenya':__theForm.labels[UsuariAplicacioFields.CONTRASENYA]}" />
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.CONTRASENYA]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariAplicacioFields.CONTRASENYA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="usuariAplicacio.contrasenya" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.CONTRASENYA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.CONTRASENYA)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="50" path="usuariAplicacio.contrasenya"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.EMAILADMIN)}">
        <tr id="usuariAplicacio_emailAdmin_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.EMAILADMIN])?'usuariAplicacio.emailAdmin':__theForm.labels[UsuariAplicacioFields.EMAILADMIN]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.EMAILADMIN]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariAplicacioFields.EMAILADMIN]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="usuariAplicacio.emailAdmin" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.EMAILADMIN)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.EMAILADMIN)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="100" path="usuariAplicacio.emailAdmin"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.DESCRIPCIO)}">
        <tr id="usuariAplicacio_descripcio_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.DESCRIPCIO])?'usuariAplicacio.descripcio':__theForm.labels[UsuariAplicacioFields.DESCRIPCIO]}" />
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.DESCRIPCIO]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariAplicacioFields.DESCRIPCIO]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="usuariAplicacio.descripcio" cssClass="errorField alert alert-error" />
              <form:textarea rows="3" wrap="soft" style="overflow:auto;" cssClass="input-xxlarge" readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.DESCRIPCIO)? 'true' : 'false'}" path="usuariAplicacio.descripcio"  />
              <div class="btn-group" style="vertical-align: top;">
              <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown">&nbsp;<span class="caret"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#" onclick="javascript:var ta=document.getElementById('usuariAplicacio.descripcio'); ta.wrap='off';" >No Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('usuariAplicacio.descripcio'); ta.wrap='soft';">Soft Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('usuariAplicacio.descripcio'); ta.wrap='hard';">Hard Wrap</a></li>
              </ul>
              </div>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.ACTIU)}">
        <tr id="usuariAplicacio_actiu_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.ACTIU])?'usuariAplicacio.actiu':__theForm.labels[UsuariAplicacioFields.ACTIU]}" />
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.ACTIU]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariAplicacioFields.ACTIU]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ACTIU)}" >
              <form:errors path="usuariAplicacio.actiu" cssClass="errorField alert alert-error" />
              <form:checkbox onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ACTIU)? 'false' : 'true'}" path="usuariAplicacio.actiu" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ACTIU)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariAplicacio.actiu}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.ROLESCAN)}">
        <tr id="usuariAplicacio_roleScan_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.ROLESCAN])?'usuariAplicacio.roleScan':__theForm.labels[UsuariAplicacioFields.ROLESCAN]}" />
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.ROLESCAN]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariAplicacioFields.ROLESCAN]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLESCAN)}" >
              <form:errors path="usuariAplicacio.roleScan" cssClass="errorField alert alert-error" />
              <form:checkbox onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLESCAN)? 'false' : 'true'}" path="usuariAplicacio.roleScan" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLESCAN)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariAplicacio.roleScan}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.ROLECOAU)}">
        <tr id="usuariAplicacio_roleCoAu_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.ROLECOAU])?'usuariAplicacio.roleCoAu':__theForm.labels[UsuariAplicacioFields.ROLECOAU]}" />
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.ROLECOAU]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariAplicacioFields.ROLECOAU]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECOAU)}" >
              <form:errors path="usuariAplicacio.roleCoAu" cssClass="errorField alert alert-error" />
              <form:checkbox onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECOAU)? 'false' : 'true'}" path="usuariAplicacio.roleCoAu" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECOAU)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariAplicacio.roleCoAu}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.ROLECUST)}">
        <tr id="usuariAplicacio_roleCust_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.ROLECUST])?'usuariAplicacio.roleCust':__theForm.labels[UsuariAplicacioFields.ROLECUST]}" />
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.ROLECUST]}">
              <i class="icon-info-sign" title="${__theForm.help[UsuariAplicacioFields.ROLECUST]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECUST)}" >
              <form:errors path="usuariAplicacio.roleCust" cssClass="errorField alert alert-error" />
              <form:checkbox onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECUST)? 'false' : 'true'}" path="usuariAplicacio.roleCust" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECUST)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariAplicacio.roleCust}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
