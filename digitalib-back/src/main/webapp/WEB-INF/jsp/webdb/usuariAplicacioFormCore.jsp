<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuariAplicacioFields" className="es.caib.digitalib.model.fields.UsuariAplicacioFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.USERNAME)}">
        <tr id="usuariAplicacio_username_rowid">
          <td id="usuariAplicacio_username_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.USERNAME])?'usuariAplicacio.username':__theForm.labels[UsuariAplicacioFields.USERNAME]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.USERNAME]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariAplicacioFields.USERNAME]}" ></i>
              </c:if>
            </td>
          <td id="usuariAplicacio_username_columnvalueid">
            <form:errors path="usuariAplicacio.username" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.USERNAME)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.USERNAME)? ' uneditable-input' : ''}"  style="" maxlength="101" path="usuariAplicacio.username"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.CONTRASENYA)}">
        <tr id="usuariAplicacio_contrasenya_rowid">
          <td id="usuariAplicacio_contrasenya_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.CONTRASENYA])?'usuariAplicacio.contrasenya':__theForm.labels[UsuariAplicacioFields.CONTRASENYA]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.CONTRASENYA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariAplicacioFields.CONTRASENYA]}" ></i>
              </c:if>
            </td>
          <td id="usuariAplicacio_contrasenya_columnvalueid">
            <form:errors path="usuariAplicacio.contrasenya" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.CONTRASENYA)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.CONTRASENYA)? ' uneditable-input' : ''}"  style="" maxlength="50" path="usuariAplicacio.contrasenya"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.EMAILADMIN)}">
        <tr id="usuariAplicacio_emailAdmin_rowid">
          <td id="usuariAplicacio_emailAdmin_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.EMAILADMIN])?'usuariAplicacio.emailAdmin':__theForm.labels[UsuariAplicacioFields.EMAILADMIN]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.EMAILADMIN]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariAplicacioFields.EMAILADMIN]}" ></i>
              </c:if>
            </td>
          <td id="usuariAplicacio_emailAdmin_columnvalueid">
            <form:errors path="usuariAplicacio.emailAdmin" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.EMAILADMIN)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.EMAILADMIN)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuariAplicacio.emailAdmin"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.DESCRIPCIO)}">
        <tr id="usuariAplicacio_descripcio_rowid">
          <td id="usuariAplicacio_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.DESCRIPCIO])?'usuariAplicacio.descripcio':__theForm.labels[UsuariAplicacioFields.DESCRIPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariAplicacioFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="usuariAplicacio_descripcio_columnvalueid">
              <form:errors path="usuariAplicacio.descripcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.DESCRIPCIO)? 'true' : 'false'}" path="usuariAplicacio.descripcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_descripcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_descripcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('usuariAplicacio.descripcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('usuariAplicacio.descripcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('usuariAplicacio.descripcio'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_descripcio').on('click', function(){
					var valor = ($('#dropdownMenuContainer_descripcio').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_descripcio').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.ACTIU)}">
        <tr id="usuariAplicacio_actiu_rowid">
          <td id="usuariAplicacio_actiu_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.ACTIU])?'usuariAplicacio.actiu':__theForm.labels[UsuariAplicacioFields.ACTIU]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.ACTIU]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariAplicacioFields.ACTIU]}" ></i>
              </c:if>
            </td>
          <td id="usuariAplicacio_actiu_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ACTIU)}" >
              <form:errors path="usuariAplicacio.actiu" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ACTIU)? 'false' : 'true'}" path="usuariAplicacio.actiu" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ACTIU)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariAplicacio.actiu}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.ROLESCAN)}">
        <tr id="usuariAplicacio_roleScan_rowid">
          <td id="usuariAplicacio_roleScan_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.ROLESCAN])?'usuariAplicacio.roleScan':__theForm.labels[UsuariAplicacioFields.ROLESCAN]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.ROLESCAN]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariAplicacioFields.ROLESCAN]}" ></i>
              </c:if>
            </td>
          <td id="usuariAplicacio_roleScan_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLESCAN)}" >
              <form:errors path="usuariAplicacio.roleScan" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLESCAN)? 'false' : 'true'}" path="usuariAplicacio.roleScan" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLESCAN)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariAplicacio.roleScan}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.ROLECOAU)}">
        <tr id="usuariAplicacio_roleCoAu_rowid">
          <td id="usuariAplicacio_roleCoAu_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.ROLECOAU])?'usuariAplicacio.roleCoAu':__theForm.labels[UsuariAplicacioFields.ROLECOAU]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.ROLECOAU]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariAplicacioFields.ROLECOAU]}" ></i>
              </c:if>
            </td>
          <td id="usuariAplicacio_roleCoAu_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECOAU)}" >
              <form:errors path="usuariAplicacio.roleCoAu" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECOAU)? 'false' : 'true'}" path="usuariAplicacio.roleCoAu" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECOAU)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariAplicacio.roleCoAu}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariAplicacioFields.ROLECUST)}">
        <tr id="usuariAplicacio_roleCust_rowid">
          <td id="usuariAplicacio_roleCust_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariAplicacioFields.ROLECUST])?'usuariAplicacio.roleCust':__theForm.labels[UsuariAplicacioFields.ROLECUST]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariAplicacioFields.ROLECUST]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariAplicacioFields.ROLECUST]}" ></i>
              </c:if>
            </td>
          <td id="usuariAplicacio_roleCust_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECUST)}" >
              <form:errors path="usuariAplicacio.roleCust" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECUST)? 'false' : 'true'}" path="usuariAplicacio.roleCust" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariAplicacioFields.ROLECUST)}" >
                <fmt:message key="genapp.checkbox.${__theForm.usuariAplicacio.roleCust}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
