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
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PerfilFields.CODI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,PerfilFields.CODI)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="perfil.codi"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.NOMID)}">
        <tr id="perfil_nomID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.NOMID])?'perfil.nomID':__theForm.labels[PerfilFields.NOMID]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.NOMID]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.NOMID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
       <form:errors path="perfil.nom" cssClass="errorField alert alert-error" />
       <div class="tabbable">
         <ul class="nav nav-tabs" style="margin-bottom: 3px;">
             <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
               <li class="${(counter.index == 0)? 'active':''}"  ><a href="#${counter.index}_tab_nom_${idioma.idiomaID}" data-toggle="tab">${idioma.nom}</a></li>
           </c:forEach>
           
         </ul>
         <div class="tab-content">
           <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
           <div class="tab-pane ${(counter.index == 0)? 'active':'' }" id="${counter.index}_tab_nom_${idioma.idiomaID}">
               <form:errors path="perfil.nom.traduccions['${idioma.idiomaID}'].valor" cssClass="errorField alert alert-error"/>
               <form:input path="perfil.nom.traduccions['${idioma.idiomaID}'].valor" readonly="${ gen:contains(__theForm.readOnlyFields ,PerfilFields.NOMID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,PerfilFields.NOMID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="4000" />
           </div>
           </c:forEach>
         </div>
       </div>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.DESCRIPCIOID)}">
        <tr id="perfil_descripcioID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.DESCRIPCIOID])?'perfil.descripcioID':__theForm.labels[PerfilFields.DESCRIPCIOID]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.DESCRIPCIOID]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.DESCRIPCIOID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
       <form:errors path="perfil.descripcio" cssClass="errorField alert alert-error" />
       <div class="tabbable">
         <ul class="nav nav-tabs" style="margin-bottom: 3px;">
             <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
               <li class="${(counter.index == 0)? 'active':''}"  ><a href="#${counter.index}_tab_descripcio_${idioma.idiomaID}" data-toggle="tab">${idioma.nom}</a></li>
           </c:forEach>
           
         </ul>
         <div class="tab-content">
           <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
           <div class="tab-pane ${(counter.index == 0)? 'active':'' }" id="${counter.index}_tab_descripcio_${idioma.idiomaID}">
               <form:errors path="perfil.descripcio.traduccions['${idioma.idiomaID}'].valor" cssClass="errorField alert alert-error"/>
               <form:input path="perfil.descripcio.traduccions['${idioma.idiomaID}'].valor" readonly="${ gen:contains(__theForm.readOnlyFields ,PerfilFields.DESCRIPCIOID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,PerfilFields.DESCRIPCIOID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="4000" />
           </div>
           </c:forEach>
         </div>
       </div>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.URLBASE)}">
        <tr id="perfil_urlBase_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.URLBASE])?'perfil.urlBase':__theForm.labels[PerfilFields.URLBASE]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.URLBASE]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.URLBASE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
           <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.URLBASE)}">

             <c:if test="${ not empty __theForm.perfil.urlBase}">
               <a href="${__theForm.perfil.urlBase}" target="_blank">${__theForm.perfil.urlBase}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,PerfilFields.URLBASE))}">

            <form:errors path="perfil.urlBase" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PerfilFields.URLBASE)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,PerfilFields.URLBASE)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="perfil.urlBase"   />

           </c:if>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.SCANFORMATFITXER)}">
        <tr id="perfil_scanFormatFitxer_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.SCANFORMATFITXER])?'perfil.scanFormatFitxer':__theForm.labels[PerfilFields.SCANFORMATFITXER]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PerfilFields.SCANFORMATFITXER]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.SCANFORMATFITXER]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.scanFormatFitxer" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANFORMATFITXER)}" >
          <form:hidden path="perfil.scanFormatFitxer"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.scanFormatFitxer,__theForm.listOfValuesForScanFormatFitxer)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANFORMATFITXER)}" >
          <form:select id="perfil_scanFormatFitxer"  onchange="if(typeof onChangeScanFormatFitxer == 'function') {  onChangeScanFormatFitxer(this); };"  cssClass="input-xxlarge" path="perfil.scanFormatFitxer">
            <c:forEach items="${__theForm.listOfValuesForScanFormatFitxer}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.SCANMINIMARESOLUCIO)}">
        <tr id="perfil_scanMinimaResolucio_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.SCANMINIMARESOLUCIO])?'perfil.scanMinimaResolucio':__theForm.labels[PerfilFields.SCANMINIMARESOLUCIO]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.SCANMINIMARESOLUCIO]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.SCANMINIMARESOLUCIO]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.scanMinimaResolucio" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANMINIMARESOLUCIO)}" >
          <form:hidden path="perfil.scanMinimaResolucio"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.scanMinimaResolucio,__theForm.listOfValuesForScanMinimaResolucio)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANMINIMARESOLUCIO)}" >
          <form:select id="perfil_scanMinimaResolucio"  onchange="if(typeof onChangeScanMinimaResolucio == 'function') {  onChangeScanMinimaResolucio(this); };"  cssClass="input-xxlarge" path="perfil.scanMinimaResolucio">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfValuesForScanMinimaResolucio}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.SCANPIXELTYPE)}">
        <tr id="perfil_scanPixelType_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.SCANPIXELTYPE])?'perfil.scanPixelType':__theForm.labels[PerfilFields.SCANPIXELTYPE]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.SCANPIXELTYPE]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.SCANPIXELTYPE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.scanPixelType" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANPIXELTYPE)}" >
          <form:hidden path="perfil.scanPixelType"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.scanPixelType,__theForm.listOfValuesForScanPixelType)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANPIXELTYPE)}" >
          <form:select id="perfil_scanPixelType"  onchange="if(typeof onChangeScanPixelType == 'function') {  onChangeScanPixelType(this); };"  cssClass="input-xxlarge" path="perfil.scanPixelType">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfValuesForScanPixelType}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.PLUGINSCANWEB2ID)}">
        <tr id="perfil_pluginScanWeb2ID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.PLUGINSCANWEB2ID])?'perfil.pluginScanWeb2ID':__theForm.labels[PerfilFields.PLUGINSCANWEB2ID]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.PLUGINSCANWEB2ID]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.PLUGINSCANWEB2ID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.pluginScanWeb2ID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINSCANWEB2ID)}" >
          <form:hidden path="perfil.pluginScanWeb2ID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.pluginScanWeb2ID,__theForm.listOfPluginForPluginScanWeb2ID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINSCANWEB2ID)}" >
          <form:select id="perfil_pluginScanWeb2ID"  onchange="if(typeof onChangePluginScanWeb2ID == 'function') {  onChangePluginScanWeb2ID(this); };"  cssClass="input-xxlarge" path="perfil.pluginScanWeb2ID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfPluginForPluginScanWeb2ID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.TIPUSFIRMA)}">
        <tr id="perfil_tipusFirma_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.TIPUSFIRMA])?'perfil.tipusFirma':__theForm.labels[PerfilFields.TIPUSFIRMA]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PerfilFields.TIPUSFIRMA]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.TIPUSFIRMA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.tipusFirma" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.TIPUSFIRMA)}" >
          <form:hidden path="perfil.tipusFirma"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.tipusFirma,__theForm.listOfValuesForTipusFirma)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.TIPUSFIRMA)}" >
          <form:select id="perfil_tipusFirma"  onchange="if(typeof onChangeTipusFirma == 'function') {  onChangeTipusFirma(this); };"  cssClass="input-xxlarge" path="perfil.tipusFirma">
            <c:forEach items="${__theForm.listOfValuesForTipusFirma}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.APISIMPLEID)}">
        <tr id="perfil_apiSimpleID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.APISIMPLEID])?'perfil.apiSimpleID':__theForm.labels[PerfilFields.APISIMPLEID]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.APISIMPLEID]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.APISIMPLEID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.apiSimpleID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.APISIMPLEID)}" >
          <form:hidden path="perfil.apiSimpleID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.apiSimpleID,__theForm.listOfApiSimpleForApiSimpleID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.APISIMPLEID)}" >
          <form:select id="perfil_apiSimpleID"  onchange="if(typeof onChangeApiSimpleID == 'function') {  onChangeApiSimpleID(this); };"  cssClass="input-xxlarge" path="perfil.apiSimpleID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfApiSimpleForApiSimpleID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.CONFIGURACIOFIRMAID)}">
        <tr id="perfil_configuracioFirmaID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.CONFIGURACIOFIRMAID])?'perfil.configuracioFirmaID':__theForm.labels[PerfilFields.CONFIGURACIOFIRMAID]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.CONFIGURACIOFIRMAID]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.CONFIGURACIOFIRMAID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.configuracioFirmaID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.CONFIGURACIOFIRMAID)}" >
          <form:hidden path="perfil.configuracioFirmaID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.configuracioFirmaID,__theForm.listOfConfiguracioFirmaForConfiguracioFirmaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.CONFIGURACIOFIRMAID)}" >
          <form:select id="perfil_configuracioFirmaID"  onchange="if(typeof onChangeConfiguracioFirmaID == 'function') {  onChangeConfiguracioFirmaID(this); };"  cssClass="input-xxlarge" path="perfil.configuracioFirmaID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfConfiguracioFirmaForConfiguracioFirmaID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.TIPUSCUSTODIA)}">
        <tr id="perfil_tipusCustodia_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.TIPUSCUSTODIA])?'perfil.tipusCustodia':__theForm.labels[PerfilFields.TIPUSCUSTODIA]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PerfilFields.TIPUSCUSTODIA]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.TIPUSCUSTODIA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.tipusCustodia" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.TIPUSCUSTODIA)}" >
          <form:hidden path="perfil.tipusCustodia"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.tipusCustodia,__theForm.listOfValuesForTipusCustodia)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.TIPUSCUSTODIA)}" >
          <form:select id="perfil_tipusCustodia"  onchange="if(typeof onChangeTipusCustodia == 'function') {  onChangeTipusCustodia(this); };"  cssClass="input-xxlarge" path="perfil.tipusCustodia">
            <c:forEach items="${__theForm.listOfValuesForTipusCustodia}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.USPERFIL)}">
        <tr id="perfil_usPerfil_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.USPERFIL])?'perfil.usPerfil':__theForm.labels[PerfilFields.USPERFIL]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[PerfilFields.USPERFIL]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.USPERFIL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="perfil.usPerfil" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.USPERFIL)}" >
          <form:hidden path="perfil.usPerfil"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.perfil.usPerfil,__theForm.listOfValuesForUsPerfil)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.USPERFIL)}" >
          <form:select id="perfil_usPerfil"  onchange="if(typeof onChangeUsPerfil == 'function') {  onChangeUsPerfil(this); };"  cssClass="input-xxlarge" path="perfil.usPerfil">
            <c:forEach items="${__theForm.listOfValuesForUsPerfil}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.UTILITZATPERAPLICACIO)}">
        <tr id="perfil_utilitzatPerAplicacio_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.UTILITZATPERAPLICACIO])?'perfil.utilitzatPerAplicacio':__theForm.labels[PerfilFields.UTILITZATPERAPLICACIO]}" />
              <c:if test="${not empty __theForm.help[PerfilFields.UTILITZATPERAPLICACIO]}">
              <i class="icon-info-sign" title="${__theForm.help[PerfilFields.UTILITZATPERAPLICACIO]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.UTILITZATPERAPLICACIO)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeUtilitzatPerAplicacio == 'function') {  onChangeUtilitzatPerAplicacio(this); };"  path="perfil.utilitzatPerAplicacio">
                <form:option value=""><fmt:message key="utilitzatper." /></form:option>
                <form:option value="true" ><fmt:message key="utilitzatper.true" /></form:option>
                <form:option value="false" ><fmt:message key="utilitzatper.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.UTILITZATPERAPLICACIO)}" >
                <fmt:message key="utilitzatper.${__theForm.perfil.utilitzatPerAplicacio}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
