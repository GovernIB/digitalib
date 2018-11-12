<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PerfilFields" className="es.caib.digitalib.model.fields.PerfilFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.CODI)}">
        <tr id="perfil_codi_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.CODI])?'perfil.codi':__theForm.labels[PerfilFields.CODI]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PerfilFields.CODI]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.CODI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="perfil.codi" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PerfilFields.CODI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,PerfilFields.CODI)? 'input-large uneditable-input' : 'input-large'}"  maxlength="25" path="perfil.codi"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.NOM)}">
        <tr id="perfil_nom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.NOM])?'perfil.nom':__theForm.labels[PerfilFields.NOM]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PerfilFields.NOM]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.NOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="perfil.nom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PerfilFields.NOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,PerfilFields.NOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="100" path="perfil.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.DESCRIPCIO)}">
        <tr id="perfil_descripcio_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.DESCRIPCIO])?'perfil.descripcio':__theForm.labels[PerfilFields.DESCRIPCIO]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.DESCRIPCIO]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.DESCRIPCIO]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="perfil.descripcio" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PerfilFields.DESCRIPCIO)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,PerfilFields.DESCRIPCIO)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="perfil.descripcio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.PLUGINSCANWEBID)}">
        <tr id="perfil_pluginScanWebID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.PLUGINSCANWEBID])?'perfil.pluginScanWebID':__theForm.labels[PerfilFields.PLUGINSCANWEBID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PerfilFields.PLUGINSCANWEBID]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.PLUGINSCANWEBID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.pluginScanWebID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINSCANWEBID)}" >
          <form:hidden path="perfil.pluginScanWebID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.pluginScanWebID,__theForm.listOfPluginForPluginScanWebID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINSCANWEBID)}" >
          <form:select id="perfil_pluginScanWebID"  onchange="if(typeof onChangePluginScanWebID == 'function') {  onChangePluginScanWebID(this); };"  cssClass="input-xxlarge" path="perfil.pluginScanWebID">
            <c:forEach items="${__theForm.listOfPluginForPluginScanWebID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.PLUGINFIRMASERVIDORID)}">
        <tr id="perfil_pluginFirmaServidorID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.PLUGINFIRMASERVIDORID])?'perfil.pluginFirmaServidorID':__theForm.labels[PerfilFields.PLUGINFIRMASERVIDORID]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.PLUGINFIRMASERVIDORID]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.PLUGINFIRMASERVIDORID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.pluginFirmaServidorID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINFIRMASERVIDORID)}" >
          <form:hidden path="perfil.pluginFirmaServidorID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.pluginFirmaServidorID,__theForm.listOfPluginForPluginFirmaServidorID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINFIRMASERVIDORID)}" >
          <form:select id="perfil_pluginFirmaServidorID"  onchange="if(typeof onChangePluginFirmaServidorID == 'function') {  onChangePluginFirmaServidorID(this); };"  cssClass="input-xxlarge" path="perfil.pluginFirmaServidorID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfPluginForPluginFirmaServidorID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.PLUGINARXIUID)}">
        <tr id="perfil_pluginArxiuID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.PLUGINARXIUID])?'perfil.pluginArxiuID':__theForm.labels[PerfilFields.PLUGINARXIUID]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.PLUGINARXIUID]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.PLUGINARXIUID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.pluginArxiuID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINARXIUID)}" >
          <form:hidden path="perfil.pluginArxiuID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.pluginArxiuID,__theForm.listOfPluginForPluginArxiuID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINARXIUID)}" >
          <form:select id="perfil_pluginArxiuID"  onchange="if(typeof onChangePluginArxiuID == 'function') {  onChangePluginArxiuID(this); };"  cssClass="input-xxlarge" path="perfil.pluginArxiuID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfPluginForPluginArxiuID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.PLUGINDOCCUSTODYID)}">
        <tr id="perfil_pluginDocCustodyID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.PLUGINDOCCUSTODYID])?'perfil.pluginDocCustodyID':__theForm.labels[PerfilFields.PLUGINDOCCUSTODYID]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.PLUGINDOCCUSTODYID]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.PLUGINDOCCUSTODYID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.pluginDocCustodyID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINDOCCUSTODYID)}" >
          <form:hidden path="perfil.pluginDocCustodyID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.pluginDocCustodyID,__theForm.listOfPluginForPluginDocCustodyID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINDOCCUSTODYID)}" >
          <form:select id="perfil_pluginDocCustodyID"  onchange="if(typeof onChangePluginDocCustodyID == 'function') {  onChangePluginDocCustodyID(this); };"  cssClass="input-xxlarge" path="perfil.pluginDocCustodyID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfPluginForPluginDocCustodyID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
