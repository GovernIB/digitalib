<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PluginFields" className="es.caib.digitalib.model.fields.PluginFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.CODI)}">
        <tr id="plugin_codi_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.CODI])?'plugin.codi':__theForm.labels[PluginFields.CODI]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PluginFields.CODI]}">
              <i class="icon-info-sign" title="${__theForm.help[PluginFields.CODI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="plugin.codi" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginFields.CODI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,PluginFields.CODI)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="plugin.codi"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.NOM)}">
        <tr id="plugin_nom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.NOM])?'plugin.nom':__theForm.labels[PluginFields.NOM]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PluginFields.NOM]}">
              <i class="icon-info-sign" title="${__theForm.help[PluginFields.NOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="plugin.nom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginFields.NOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,PluginFields.NOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="plugin.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.DESCRIPCIO)}">
        <tr id="plugin_descripcio_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.DESCRIPCIO])?'plugin.descripcio':__theForm.labels[PluginFields.DESCRIPCIO]}" />
              <c:if test="${not empty __theForm.help[PluginFields.DESCRIPCIO]}">
              <i class="icon-info-sign" title="${__theForm.help[PluginFields.DESCRIPCIO]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="plugin.descripcio" cssClass="errorField alert alert-error" />
              <form:textarea rows="3" wrap="soft" style="overflow:auto;" cssClass="input-xxlarge" readonly="${ gen:contains(__theForm.readOnlyFields ,PluginFields.DESCRIPCIO)? 'true' : 'false'}" path="plugin.descripcio"  />
              <div class="btn-group" style="vertical-align: top;">
              <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown">&nbsp;<span class="caret"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#" onclick="javascript:var ta=document.getElementById('plugin.descripcio'); ta.wrap='off';" >No Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('plugin.descripcio'); ta.wrap='soft';">Soft Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('plugin.descripcio'); ta.wrap='hard';">Hard Wrap</a></li>
              </ul>
              </div>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.CLASSE)}">
        <tr id="plugin_classe_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.CLASSE])?'plugin.classe':__theForm.labels[PluginFields.CLASSE]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PluginFields.CLASSE]}">
              <i class="icon-info-sign" title="${__theForm.help[PluginFields.CLASSE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="plugin.classe" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginFields.CLASSE)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,PluginFields.CLASSE)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="plugin.classe"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.PROPERTIES)}">
        <tr id="plugin_properties_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.PROPERTIES])?'plugin.properties':__theForm.labels[PluginFields.PROPERTIES]}" />
              <c:if test="${not empty __theForm.help[PluginFields.PROPERTIES]}">
              <i class="icon-info-sign" title="${__theForm.help[PluginFields.PROPERTIES]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="plugin.properties" cssClass="errorField alert alert-error" />
              <form:textarea rows="3" wrap="soft" style="overflow:auto;" cssClass="input-xxlarge" readonly="${ gen:contains(__theForm.readOnlyFields ,PluginFields.PROPERTIES)? 'true' : 'false'}" path="plugin.properties"  />
              <div class="btn-group" style="vertical-align: top;">
              <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown">&nbsp;<span class="caret"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#" onclick="javascript:var ta=document.getElementById('plugin.properties'); ta.wrap='off';" >No Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('plugin.properties'); ta.wrap='soft';">Soft Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('plugin.properties'); ta.wrap='hard';">Hard Wrap</a></li>
              </ul>
              </div>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.ACTIU)}">
        <tr id="plugin_actiu_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.ACTIU])?'plugin.actiu':__theForm.labels[PluginFields.ACTIU]}" />
              <c:if test="${not empty __theForm.help[PluginFields.ACTIU]}">
              <i class="icon-info-sign" title="${__theForm.help[PluginFields.ACTIU]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PluginFields.ACTIU)}" >
              <form:errors path="plugin.actiu" cssClass="errorField alert alert-error" />
              <form:checkbox onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,PluginFields.ACTIU)? 'false' : 'true'}" path="plugin.actiu" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PluginFields.ACTIU)}" >
                <fmt:message key="genapp.checkbox.${__theForm.plugin.actiu}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.TIPUS)}">
        <tr id="plugin_tipus_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.TIPUS])?'plugin.tipus':__theForm.labels[PluginFields.TIPUS]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PluginFields.TIPUS]}">
              <i class="icon-info-sign" title="${__theForm.help[PluginFields.TIPUS]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="plugin.tipus" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PluginFields.TIPUS)}" >
          <form:hidden path="plugin.tipus"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.plugin.tipus,__theForm.listOfValuesForTipus)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PluginFields.TIPUS)}" >
          <form:select id="plugin_tipus"  onchange="if(typeof onChangeTipus == 'function') {  onChangeTipus(this); };"  cssClass="input-xxlarge" path="plugin.tipus">
            <c:forEach items="${__theForm.listOfValuesForTipus}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginFields.ORDRE)}">
        <tr id="plugin_ordre_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginFields.ORDRE])?'plugin.ordre':__theForm.labels[PluginFields.ORDRE]}" />
              <c:if test="${not empty __theForm.help[PluginFields.ORDRE]}">
              <i class="icon-info-sign" title="${__theForm.help[PluginFields.ORDRE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="plugin.ordre" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginFields.ORDRE)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,PluginFields.ORDRE)? 'input-mini uneditable-input' : 'input-mini'}"   path="plugin.ordre"   />

           </td>
        </tr>
        </c:if>
        
