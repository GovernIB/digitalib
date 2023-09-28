<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PerfilFields" className="es.caib.digitalib.model.fields.PerfilFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.CODI)}">
        <tr id="perfil_codi_rowid">
          <td id="perfil_codi_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.CODI])?'perfil.codi':__theForm.labels[PerfilFields.CODI]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.CODI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.CODI]}" ></i>
              </c:if>
            </td>
          <td id="perfil_codi_columnvalueid">
            <form:errors path="perfil.codi" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PerfilFields.CODI)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,PerfilFields.CODI)? ' uneditable-input' : ''}"  style="" maxlength="255" path="perfil.codi"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.NOMID)}">
        <tr id="perfil_nomID_rowid">
          <td id="perfil_nomID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.NOMID])?'perfil.nomID':__theForm.labels[PerfilFields.NOMID]}" />
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.NOMID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.NOMID]}" ></i>
              </c:if>
            </td>
          <td id="perfil_nomID_columnvalueid">
       <form:errors path="perfil.nom" cssClass="errorField alert alert-danger" />
       <div class="row-fluid col-md-9-optional">
         <ul class="nav nav-tabs" style="margin: 0 15px -1px;">
             <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
            <li class="nav-item ">
                 <a class="nav-link ${(counter.index == 0)? 'active':''}" href="#${counter.index}_tab_nom_${idioma.idiomaID}" data-toggle="tab">${idioma.nom}</a>
            </li>
          </c:forEach>
           
         </ul>
         <div class="tab-content well well-white" style="padding:8px;margin:0px;">
           <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
           <div class="tab-pane ${(counter.index == 0)? 'active':'' }" id="${counter.index}_tab_nom_${idioma.idiomaID}">
               <form:errors path="perfil.nom.traduccions['${idioma.idiomaID}'].valor" cssClass="errorField alert alert-danger"/>
               <form:input path="perfil.nom.traduccions['${idioma.idiomaID}'].valor" cssClass="form-control  ${gen:contains(__theForm.readOnlyFields ,PerfilFields.NOMID)? ' uneditable-input' : ''}" readonly="${gen:contains(__theForm.readOnlyFields ,PerfilFields.NOMID)}" maxlength="4000" />
           </div>
           </c:forEach>
         </div>
       </div>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.DESCRIPCIOID)}">
        <tr id="perfil_descripcioID_rowid">
          <td id="perfil_descripcioID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.DESCRIPCIOID])?'perfil.descripcioID':__theForm.labels[PerfilFields.DESCRIPCIOID]}" />
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.DESCRIPCIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.DESCRIPCIOID]}" ></i>
              </c:if>
            </td>
          <td id="perfil_descripcioID_columnvalueid">
       <form:errors path="perfil.descripcio" cssClass="errorField alert alert-danger" />
       <div class="row-fluid col-md-9-optional">
         <ul class="nav nav-tabs" style="margin: 0 15px -1px;">
             <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
            <li class="nav-item ">
                 <a class="nav-link ${(counter.index == 0)? 'active':''}" href="#${counter.index}_tab_descripcio_${idioma.idiomaID}" data-toggle="tab">${idioma.nom}</a>
            </li>
          </c:forEach>
           
         </ul>
         <div class="tab-content well well-white" style="padding:8px;margin:0px;">
           <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
           <div class="tab-pane ${(counter.index == 0)? 'active':'' }" id="${counter.index}_tab_descripcio_${idioma.idiomaID}">
               <form:errors path="perfil.descripcio.traduccions['${idioma.idiomaID}'].valor" cssClass="errorField alert alert-danger"/>
               <form:input path="perfil.descripcio.traduccions['${idioma.idiomaID}'].valor" cssClass="form-control  ${gen:contains(__theForm.readOnlyFields ,PerfilFields.DESCRIPCIOID)? ' uneditable-input' : ''}" readonly="${gen:contains(__theForm.readOnlyFields ,PerfilFields.DESCRIPCIOID)}" maxlength="4000" />
           </div>
           </c:forEach>
         </div>
       </div>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.URLBASE)}">
        <tr id="perfil_urlBase_rowid">
          <td id="perfil_urlBase_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.URLBASE])?'perfil.urlBase':__theForm.labels[PerfilFields.URLBASE]}" />
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.URLBASE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.URLBASE]}" ></i>
              </c:if>
            </td>
          <td id="perfil_urlBase_columnvalueid">
           <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.URLBASE)}">

             <c:if test="${ not empty __theForm.perfil.urlBase}">
               <a href="${__theForm.perfil.urlBase}" target="_blank">${__theForm.perfil.urlBase}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,PerfilFields.URLBASE))}">

            <form:errors path="perfil.urlBase" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PerfilFields.URLBASE)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,PerfilFields.URLBASE)? ' uneditable-input' : ''}"  style="" maxlength="255" path="perfil.urlBase"   />

           </c:if>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.SCANFORMATFITXER)}">
        <tr id="perfil_scanFormatFitxer_rowid">
          <td id="perfil_scanFormatFitxer_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.SCANFORMATFITXER])?'perfil.scanFormatFitxer':__theForm.labels[PerfilFields.SCANFORMATFITXER]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.SCANFORMATFITXER]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.SCANFORMATFITXER]}" ></i>
              </c:if>
            </td>
          <td id="perfil_scanFormatFitxer_columnvalueid">
          <form:errors path="perfil.scanFormatFitxer" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANFORMATFITXER)}" >
          <form:hidden path="perfil.scanFormatFitxer"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.scanFormatFitxer,__theForm.listOfValuesForScanFormatFitxer)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANFORMATFITXER)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_scanFormatFitxer"  onchange="if(typeof onChangeScanFormatFitxer == 'function') {  onChangeScanFormatFitxer(this); };"  cssClass="form-control col-md-9-optional" path="perfil.scanFormatFitxer">
            <c:forEach items="${__theForm.listOfValuesForScanFormatFitxer}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.SCANMINIMARESOLUCIO)}">
        <tr id="perfil_scanMinimaResolucio_rowid">
          <td id="perfil_scanMinimaResolucio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.SCANMINIMARESOLUCIO])?'perfil.scanMinimaResolucio':__theForm.labels[PerfilFields.SCANMINIMARESOLUCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.SCANMINIMARESOLUCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.SCANMINIMARESOLUCIO]}" ></i>
              </c:if>
            </td>
          <td id="perfil_scanMinimaResolucio_columnvalueid">
          <form:errors path="perfil.scanMinimaResolucio" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANMINIMARESOLUCIO)}" >
          <form:hidden path="perfil.scanMinimaResolucio"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.scanMinimaResolucio,__theForm.listOfValuesForScanMinimaResolucio)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANMINIMARESOLUCIO)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_scanMinimaResolucio"  onchange="if(typeof onChangeScanMinimaResolucio == 'function') {  onChangeScanMinimaResolucio(this); };"  cssClass="form-control col-md-9-optional" path="perfil.scanMinimaResolucio">
            <c:forEach items="${__theForm.listOfValuesForScanMinimaResolucio}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.perfil.scanMinimaResolucio }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.perfil.scanMinimaResolucio }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.SCANPIXELTYPE)}">
        <tr id="perfil_scanPixelType_rowid">
          <td id="perfil_scanPixelType_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.SCANPIXELTYPE])?'perfil.scanPixelType':__theForm.labels[PerfilFields.SCANPIXELTYPE]}" />
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.SCANPIXELTYPE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.SCANPIXELTYPE]}" ></i>
              </c:if>
            </td>
          <td id="perfil_scanPixelType_columnvalueid">
          <form:errors path="perfil.scanPixelType" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANPIXELTYPE)}" >
          <form:hidden path="perfil.scanPixelType"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.scanPixelType,__theForm.listOfValuesForScanPixelType)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.SCANPIXELTYPE)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_scanPixelType"  onchange="if(typeof onChangeScanPixelType == 'function') {  onChangeScanPixelType(this); };"  cssClass="form-control col-md-9-optional" path="perfil.scanPixelType">
            <c:forEach items="${__theForm.listOfValuesForScanPixelType}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.perfil.scanPixelType }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.perfil.scanPixelType }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.PLUGINSCANWEBID)}">
        <tr id="perfil_pluginScanWebID_rowid">
          <td id="perfil_pluginScanWebID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.PLUGINSCANWEBID])?'perfil.pluginScanWebID':__theForm.labels[PerfilFields.PLUGINSCANWEBID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.PLUGINSCANWEBID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.PLUGINSCANWEBID]}" ></i>
              </c:if>
            </td>
          <td id="perfil_pluginScanWebID_columnvalueid">
          <form:errors path="perfil.pluginScanWebID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINSCANWEBID)}" >
          <form:hidden path="perfil.pluginScanWebID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.pluginScanWebID,__theForm.listOfPluginForPluginScanWebID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINSCANWEBID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_pluginScanWebID"  onchange="if(typeof onChangePluginScanWebID == 'function') {  onChangePluginScanWebID(this); };"  cssClass="form-control col-md-9-optional" path="perfil.pluginScanWebID">
            <c:forEach items="${__theForm.listOfPluginForPluginScanWebID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.PLUGINSCANWEB2ID)}">
        <tr id="perfil_pluginScanWeb2ID_rowid">
          <td id="perfil_pluginScanWeb2ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.PLUGINSCANWEB2ID])?'perfil.pluginScanWeb2ID':__theForm.labels[PerfilFields.PLUGINSCANWEB2ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.PLUGINSCANWEB2ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.PLUGINSCANWEB2ID]}" ></i>
              </c:if>
            </td>
          <td id="perfil_pluginScanWeb2ID_columnvalueid">
          <form:errors path="perfil.pluginScanWeb2ID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINSCANWEB2ID)}" >
          <form:hidden path="perfil.pluginScanWeb2ID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.pluginScanWeb2ID,__theForm.listOfPluginForPluginScanWeb2ID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINSCANWEB2ID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_pluginScanWeb2ID"  onchange="if(typeof onChangePluginScanWeb2ID == 'function') {  onChangePluginScanWeb2ID(this); };"  cssClass="form-control col-md-9-optional" path="perfil.pluginScanWeb2ID">
            <c:forEach items="${__theForm.listOfPluginForPluginScanWeb2ID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.perfil.pluginScanWeb2ID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.perfil.pluginScanWeb2ID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.TIPUSFIRMA)}">
        <tr id="perfil_tipusFirma_rowid">
          <td id="perfil_tipusFirma_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.TIPUSFIRMA])?'perfil.tipusFirma':__theForm.labels[PerfilFields.TIPUSFIRMA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.TIPUSFIRMA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.TIPUSFIRMA]}" ></i>
              </c:if>
            </td>
          <td id="perfil_tipusFirma_columnvalueid">
          <form:errors path="perfil.tipusFirma" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.TIPUSFIRMA)}" >
          <form:hidden path="perfil.tipusFirma"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.tipusFirma,__theForm.listOfValuesForTipusFirma)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.TIPUSFIRMA)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_tipusFirma"  onchange="if(typeof onChangeTipusFirma == 'function') {  onChangeTipusFirma(this); };"  cssClass="form-control col-md-9-optional" path="perfil.tipusFirma">
            <c:forEach items="${__theForm.listOfValuesForTipusFirma}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.APISIMPLEID)}">
        <tr id="perfil_apiSimpleID_rowid">
          <td id="perfil_apiSimpleID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.APISIMPLEID])?'perfil.apiSimpleID':__theForm.labels[PerfilFields.APISIMPLEID]}" />
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.APISIMPLEID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.APISIMPLEID]}" ></i>
              </c:if>
            </td>
          <td id="perfil_apiSimpleID_columnvalueid">
          <form:errors path="perfil.apiSimpleID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.APISIMPLEID)}" >
          <form:hidden path="perfil.apiSimpleID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.apiSimpleID,__theForm.listOfApiSimpleForApiSimpleID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.APISIMPLEID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_apiSimpleID"  onchange="if(typeof onChangeApiSimpleID == 'function') {  onChangeApiSimpleID(this); };"  cssClass="form-control col-md-9-optional" path="perfil.apiSimpleID">
            <c:forEach items="${__theForm.listOfApiSimpleForApiSimpleID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.perfil.apiSimpleID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.perfil.apiSimpleID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.CONFIGURACIOFIRMAID)}">
        <tr id="perfil_configuracioFirmaID_rowid">
          <td id="perfil_configuracioFirmaID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.CONFIGURACIOFIRMAID])?'perfil.configuracioFirmaID':__theForm.labels[PerfilFields.CONFIGURACIOFIRMAID]}" />
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.CONFIGURACIOFIRMAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.CONFIGURACIOFIRMAID]}" ></i>
              </c:if>
            </td>
          <td id="perfil_configuracioFirmaID_columnvalueid">
          <form:errors path="perfil.configuracioFirmaID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.CONFIGURACIOFIRMAID)}" >
          <form:hidden path="perfil.configuracioFirmaID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.configuracioFirmaID,__theForm.listOfConfiguracioFirmaForConfiguracioFirmaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.CONFIGURACIOFIRMAID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_configuracioFirmaID"  onchange="if(typeof onChangeConfiguracioFirmaID == 'function') {  onChangeConfiguracioFirmaID(this); };"  cssClass="form-control col-md-9-optional" path="perfil.configuracioFirmaID">
            <c:forEach items="${__theForm.listOfConfiguracioFirmaForConfiguracioFirmaID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.perfil.configuracioFirmaID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.perfil.configuracioFirmaID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.TIPUSCUSTODIA)}">
        <tr id="perfil_tipusCustodia_rowid">
          <td id="perfil_tipusCustodia_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.TIPUSCUSTODIA])?'perfil.tipusCustodia':__theForm.labels[PerfilFields.TIPUSCUSTODIA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.TIPUSCUSTODIA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.TIPUSCUSTODIA]}" ></i>
              </c:if>
            </td>
          <td id="perfil_tipusCustodia_columnvalueid">
          <form:errors path="perfil.tipusCustodia" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.TIPUSCUSTODIA)}" >
          <form:hidden path="perfil.tipusCustodia"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.tipusCustodia,__theForm.listOfValuesForTipusCustodia)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.TIPUSCUSTODIA)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_tipusCustodia"  onchange="if(typeof onChangeTipusCustodia == 'function') {  onChangeTipusCustodia(this); };"  cssClass="form-control col-md-9-optional" path="perfil.tipusCustodia">
            <c:forEach items="${__theForm.listOfValuesForTipusCustodia}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.PLUGINARXIUID)}">
        <tr id="perfil_pluginArxiuID_rowid">
          <td id="perfil_pluginArxiuID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.PLUGINARXIUID])?'perfil.pluginArxiuID':__theForm.labels[PerfilFields.PLUGINARXIUID]}" />
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.PLUGINARXIUID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.PLUGINARXIUID]}" ></i>
              </c:if>
            </td>
          <td id="perfil_pluginArxiuID_columnvalueid">
          <form:errors path="perfil.pluginArxiuID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINARXIUID)}" >
          <form:hidden path="perfil.pluginArxiuID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.pluginArxiuID,__theForm.listOfPluginForPluginArxiuID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINARXIUID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_pluginArxiuID"  onchange="if(typeof onChangePluginArxiuID == 'function') {  onChangePluginArxiuID(this); };"  cssClass="form-control col-md-9-optional" path="perfil.pluginArxiuID">
            <c:forEach items="${__theForm.listOfPluginForPluginArxiuID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.perfil.pluginArxiuID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.perfil.pluginArxiuID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.PLUGINDOCCUSTODYID)}">
        <tr id="perfil_pluginDocCustodyID_rowid">
          <td id="perfil_pluginDocCustodyID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.PLUGINDOCCUSTODYID])?'perfil.pluginDocCustodyID':__theForm.labels[PerfilFields.PLUGINDOCCUSTODYID]}" />
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.PLUGINDOCCUSTODYID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.PLUGINDOCCUSTODYID]}" ></i>
              </c:if>
            </td>
          <td id="perfil_pluginDocCustodyID_columnvalueid">
          <form:errors path="perfil.pluginDocCustodyID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINDOCCUSTODYID)}" >
          <form:hidden path="perfil.pluginDocCustodyID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.pluginDocCustodyID,__theForm.listOfPluginForPluginDocCustodyID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.PLUGINDOCCUSTODYID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_pluginDocCustodyID"  onchange="if(typeof onChangePluginDocCustodyID == 'function') {  onChangePluginDocCustodyID(this); };"  cssClass="form-control col-md-9-optional" path="perfil.pluginDocCustodyID">
            <c:forEach items="${__theForm.listOfPluginForPluginDocCustodyID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.perfil.pluginDocCustodyID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.perfil.pluginDocCustodyID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.USPERFIL)}">
        <tr id="perfil_usPerfil_rowid">
          <td id="perfil_usPerfil_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.USPERFIL])?'perfil.usPerfil':__theForm.labels[PerfilFields.USPERFIL]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.USPERFIL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.USPERFIL]}" ></i>
              </c:if>
            </td>
          <td id="perfil_usPerfil_columnvalueid">
          <form:errors path="perfil.usPerfil" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PerfilFields.USPERFIL)}" >
          <form:hidden path="perfil.usPerfil"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.perfil.usPerfil,__theForm.listOfValuesForUsPerfil)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.USPERFIL)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="perfil_usPerfil"  onchange="if(typeof onChangeUsPerfil == 'function') {  onChangeUsPerfil(this); };"  cssClass="form-control col-md-9-optional" path="perfil.usPerfil">
            <c:forEach items="${__theForm.listOfValuesForUsPerfil}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PerfilFields.UTILITZATPERAPLICACIO)}">
        <tr id="perfil_utilitzatPerAplicacio_rowid">
          <td id="perfil_utilitzatPerAplicacio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PerfilFields.UTILITZATPERAPLICACIO])?'perfil.utilitzatPerAplicacio':__theForm.labels[PerfilFields.UTILITZATPERAPLICACIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[PerfilFields.UTILITZATPERAPLICACIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PerfilFields.UTILITZATPERAPLICACIO]}" ></i>
              </c:if>
            </td>
          <td id="perfil_utilitzatPerAplicacio_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PerfilFields.UTILITZATPERAPLICACIO)}" >
              <form:select cssClass="form-control col-md-6" onchange="if(typeof onChangeUtilitzatPerAplicacio == 'function') {  onChangeUtilitzatPerAplicacio(this); };"  path="perfil.utilitzatPerAplicacio">
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
        
