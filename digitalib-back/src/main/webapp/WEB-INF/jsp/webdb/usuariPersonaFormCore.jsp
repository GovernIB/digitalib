<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuariPersonaFields" className="es.caib.digitalib.model.fields.UsuariPersonaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.USERNAME)}">
        <tr id="usuariPersona_username_rowid">
          <td id="usuariPersona_username_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.USERNAME])?'usuariPersona.username':__theForm.labels[UsuariPersonaFields.USERNAME]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.USERNAME]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariPersonaFields.USERNAME]}" ></i>
              </c:if>
            </td>
          <td id="usuariPersona_username_columnvalueid">
            <form:errors path="usuariPersona.username" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.USERNAME)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.USERNAME)? ' uneditable-input' : ''}"  style="" maxlength="50" path="usuariPersona.username"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.NOM)}">
        <tr id="usuariPersona_nom_rowid">
          <td id="usuariPersona_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.NOM])?'usuariPersona.nom':__theForm.labels[UsuariPersonaFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariPersonaFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="usuariPersona_nom_columnvalueid">
            <form:errors path="usuariPersona.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.NOM)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="50" path="usuariPersona.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.LLINATGES)}">
        <tr id="usuariPersona_llinatges_rowid">
          <td id="usuariPersona_llinatges_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.LLINATGES])?'usuariPersona.llinatges':__theForm.labels[UsuariPersonaFields.LLINATGES]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.LLINATGES]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariPersonaFields.LLINATGES]}" ></i>
              </c:if>
            </td>
          <td id="usuariPersona_llinatges_columnvalueid">
            <form:errors path="usuariPersona.llinatges" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.LLINATGES)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.LLINATGES)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuariPersona.llinatges"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.EMAIL)}">
        <tr id="usuariPersona_email_rowid">
          <td id="usuariPersona_email_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.EMAIL])?'usuariPersona.email':__theForm.labels[UsuariPersonaFields.EMAIL]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.EMAIL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariPersonaFields.EMAIL]}" ></i>
              </c:if>
            </td>
          <td id="usuariPersona_email_columnvalueid">
            <form:errors path="usuariPersona.email" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.EMAIL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.EMAIL)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuariPersona.email"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.NIF)}">
        <tr id="usuariPersona_nif_rowid">
          <td id="usuariPersona_nif_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.NIF])?'usuariPersona.nif':__theForm.labels[UsuariPersonaFields.NIF]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.NIF]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariPersonaFields.NIF]}" ></i>
              </c:if>
            </td>
          <td id="usuariPersona_nif_columnvalueid">
            <form:errors path="usuariPersona.nif" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.NIF)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.NIF)? ' uneditable-input' : ''}"  style="" maxlength="9" path="usuariPersona.nif"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.IDIOMAID)}">
        <tr id="usuariPersona_idiomaID_rowid">
          <td id="usuariPersona_idiomaID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.IDIOMAID])?'usuariPersona.idiomaID':__theForm.labels[UsuariPersonaFields.IDIOMAID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.IDIOMAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariPersonaFields.IDIOMAID]}" ></i>
              </c:if>
            </td>
          <td id="usuariPersona_idiomaID_columnvalueid">
          <form:errors path="usuariPersona.idiomaID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.IDIOMAID)}" >
          <form:hidden path="usuariPersona.idiomaID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.usuariPersona.idiomaID,__theForm.listOfIdiomaForIdiomaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.IDIOMAID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="usuariPersona_idiomaID"  onchange="if(typeof onChangeIdiomaID == 'function') {  onChangeIdiomaID(this); };"  cssClass="form-control col-md-9-optional" path="usuariPersona.idiomaID">
            <c:forEach items="${__theForm.listOfIdiomaForIdiomaID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.CONFIGURACIOGRUPID)}">
        <tr id="usuariPersona_configuracioGrupID_rowid">
          <td id="usuariPersona_configuracioGrupID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.CONFIGURACIOGRUPID])?'usuariPersona.configuracioGrupID':__theForm.labels[UsuariPersonaFields.CONFIGURACIOGRUPID]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.CONFIGURACIOGRUPID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariPersonaFields.CONFIGURACIOGRUPID]}" ></i>
              </c:if>
            </td>
          <td id="usuariPersona_configuracioGrupID_columnvalueid">
          <form:errors path="usuariPersona.configuracioGrupID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.CONFIGURACIOGRUPID)}" >
          <form:hidden path="usuariPersona.configuracioGrupID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.usuariPersona.configuracioGrupID,__theForm.listOfConfiguracioGrupForConfiguracioGrupID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.CONFIGURACIOGRUPID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="usuariPersona_configuracioGrupID"  onchange="if(typeof onChangeConfiguracioGrupID == 'function') {  onChangeConfiguracioGrupID(this); };"  cssClass="form-control col-md-9-optional" path="usuariPersona.configuracioGrupID">
            <c:forEach items="${__theForm.listOfConfiguracioGrupForConfiguracioGrupID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.usuariPersona.configuracioGrupID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.usuariPersona.configuracioGrupID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.UNITATDIR3)}">
        <tr id="usuariPersona_unitatDir3_rowid">
          <td id="usuariPersona_unitatDir3_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.UNITATDIR3])?'usuariPersona.unitatDir3':__theForm.labels[UsuariPersonaFields.UNITATDIR3]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.UNITATDIR3]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariPersonaFields.UNITATDIR3]}" ></i>
              </c:if>
            </td>
          <td id="usuariPersona_unitatDir3_columnvalueid">
            <form:errors path="usuariPersona.unitatDir3" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.UNITATDIR3)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.UNITATDIR3)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuariPersona.unitatDir3"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.ROLESCAN)}">
        <tr id="usuariPersona_roleScan_rowid">
          <td id="usuariPersona_roleScan_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.ROLESCAN])?'usuariPersona.roleScan':__theForm.labels[UsuariPersonaFields.ROLESCAN]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.ROLESCAN]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariPersonaFields.ROLESCAN]}" ></i>
              </c:if>
            </td>
          <td id="usuariPersona_roleScan_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLESCAN)}" >
              <form:errors path="usuariPersona.roleScan" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLESCAN)? 'false' : 'true'}" path="usuariPersona.roleScan" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLESCAN)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariPersona.roleScan}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.ROLECOAU)}">
        <tr id="usuariPersona_roleCoAu_rowid">
          <td id="usuariPersona_roleCoAu_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.ROLECOAU])?'usuariPersona.roleCoAu':__theForm.labels[UsuariPersonaFields.ROLECOAU]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.ROLECOAU]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariPersonaFields.ROLECOAU]}" ></i>
              </c:if>
            </td>
          <td id="usuariPersona_roleCoAu_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECOAU)}" >
              <form:errors path="usuariPersona.roleCoAu" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECOAU)? 'false' : 'true'}" path="usuariPersona.roleCoAu" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECOAU)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariPersona.roleCoAu}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariPersonaFields.ROLECUST)}">
        <tr id="usuariPersona_roleCust_rowid">
          <td id="usuariPersona_roleCust_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariPersonaFields.ROLECUST])?'usuariPersona.roleCust':__theForm.labels[UsuariPersonaFields.ROLECUST]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariPersonaFields.ROLECUST]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariPersonaFields.ROLECUST]}" ></i>
              </c:if>
            </td>
          <td id="usuariPersona_roleCust_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECUST)}" >
              <form:errors path="usuariPersona.roleCust" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECUST)? 'false' : 'true'}" path="usuariPersona.roleCust" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariPersonaFields.ROLECUST)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariPersona.roleCust}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
