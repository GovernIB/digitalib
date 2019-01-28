<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ConfiguracioFirmaFields" className="es.caib.digitalib.model.fields.ConfiguracioFirmaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.NOM)}">
        <tr id="configuracioFirma_nom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.NOM])?'configuracioFirma.nom':__theForm.labels[ConfiguracioFirmaFields.NOM]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.NOM]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.NOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="configuracioFirma.nom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.NOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.NOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="configuracioFirma.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID)}">
        <tr id="configuracioFirma_pluginFirmaServidorID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID])?'configuracioFirma.pluginFirmaServidorID':__theForm.labels[ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioFirma.pluginFirmaServidorID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID)}" >
          <form:hidden path="configuracioFirma.pluginFirmaServidorID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.pluginFirmaServidorID,__theForm.listOfPluginForPluginFirmaServidorID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID)}" >
          <form:select id="configuracioFirma_pluginFirmaServidorID"  onchange="if(typeof onChangePluginFirmaServidorID == 'function') {  onChangePluginFirmaServidorID(this); };"  cssClass="input-xxlarge" path="configuracioFirma.pluginFirmaServidorID">
            <c:forEach items="${__theForm.listOfPluginForPluginFirmaServidorID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS)}">
        <tr id="configuracioFirma_incloureSegellDeTemps_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS])?'configuracioFirma.incloureSegellDeTemps':__theForm.labels[ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS)}" >
              <form:errors path="configuracioFirma.incloureSegellDeTemps" cssClass="errorField alert alert-error" />
              <form:checkbox onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS)? 'false' : 'true'}" path="configuracioFirma.incloureSegellDeTemps" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS)}" >
                <fmt:message key="genapp.checkbox.${__theForm.configuracioFirma.incloureSegellDeTemps}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.PLUGINSEGELLATID)}">
        <tr id="configuracioFirma_pluginSegellatID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.PLUGINSEGELLATID])?'configuracioFirma.pluginSegellatID':__theForm.labels[ConfiguracioFirmaFields.PLUGINSEGELLATID]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.PLUGINSEGELLATID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.PLUGINSEGELLATID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioFirma.pluginSegellatID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.PLUGINSEGELLATID)}" >
          <form:hidden path="configuracioFirma.pluginSegellatID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.pluginSegellatID,__theForm.listOfPluginForPluginSegellatID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.PLUGINSEGELLATID)}" >
          <form:select id="configuracioFirma_pluginSegellatID"  onchange="if(typeof onChangePluginSegellatID == 'function') {  onChangePluginSegellatID(this); };"  cssClass="input-xxlarge" path="configuracioFirma.pluginSegellatID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfPluginForPluginSegellatID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA)}">
        <tr id="configuracioFirma_tipusOperacioFirma_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA])?'configuracioFirma.tipusOperacioFirma':__theForm.labels[ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioFirma.tipusOperacioFirma" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA)}" >
          <form:hidden path="configuracioFirma.tipusOperacioFirma"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.tipusOperacioFirma,__theForm.listOfValuesForTipusOperacioFirma)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA)}" >
          <form:select id="configuracioFirma_tipusOperacioFirma"  onchange="if(typeof onChangeTipusOperacioFirma == 'function') {  onChangeTipusOperacioFirma(this); };"  cssClass="input-xxlarge" path="configuracioFirma.tipusOperacioFirma">
            <c:forEach items="${__theForm.listOfValuesForTipusOperacioFirma}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.TIPUSFIRMAID)}">
        <tr id="configuracioFirma_tipusFirmaID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.TIPUSFIRMAID])?'configuracioFirma.tipusFirmaID':__theForm.labels[ConfiguracioFirmaFields.TIPUSFIRMAID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.TIPUSFIRMAID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.TIPUSFIRMAID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioFirma.tipusFirmaID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.TIPUSFIRMAID)}" >
          <form:hidden path="configuracioFirma.tipusFirmaID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.tipusFirmaID,__theForm.listOfValuesForTipusFirmaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.TIPUSFIRMAID)}" >
          <form:select id="configuracioFirma_tipusFirmaID"  onchange="if(typeof onChangeTipusFirmaID == 'function') {  onChangeTipusFirmaID(this); };"  cssClass="input-xxlarge" path="configuracioFirma.tipusFirmaID">
            <c:forEach items="${__theForm.listOfValuesForTipusFirmaID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.ALGORISMEDEFIRMAID)}">
        <tr id="configuracioFirma_algorismeDeFirmaID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.ALGORISMEDEFIRMAID])?'configuracioFirma.algorismeDeFirmaID':__theForm.labels[ConfiguracioFirmaFields.ALGORISMEDEFIRMAID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.ALGORISMEDEFIRMAID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.ALGORISMEDEFIRMAID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioFirma.algorismeDeFirmaID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.ALGORISMEDEFIRMAID)}" >
          <form:hidden path="configuracioFirma.algorismeDeFirmaID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.algorismeDeFirmaID,__theForm.listOfValuesForAlgorismeDeFirmaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.ALGORISMEDEFIRMAID)}" >
          <form:select id="configuracioFirma_algorismeDeFirmaID"  onchange="if(typeof onChangeAlgorismeDeFirmaID == 'function') {  onChangeAlgorismeDeFirmaID(this); };"  cssClass="input-xxlarge" path="configuracioFirma.algorismeDeFirmaID">
            <c:forEach items="${__theForm.listOfValuesForAlgorismeDeFirmaID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.MODEDEFIRMA)}">
        <tr id="configuracioFirma_modeDeFirma_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.MODEDEFIRMA])?'configuracioFirma.modeDeFirma':__theForm.labels[ConfiguracioFirmaFields.MODEDEFIRMA]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.MODEDEFIRMA]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.MODEDEFIRMA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.MODEDEFIRMA)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeModeDeFirma == 'function') {  onChangeModeDeFirma(this); };"  path="configuracioFirma.modeDeFirma">
                <form:option value="true" ><fmt:message key="modefirma.true" /></form:option>
                <form:option value="false" ><fmt:message key="modefirma.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.MODEDEFIRMA)}" >
                <fmt:message key="modefirma.${__theForm.configuracioFirma.modeDeFirma}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.USPOLITICADEFIRMA)}">
        <tr id="configuracioFirma_usPoliticaDeFirma_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.USPOLITICADEFIRMA])?'configuracioFirma.usPoliticaDeFirma':__theForm.labels[ConfiguracioFirmaFields.USPOLITICADEFIRMA]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.USPOLITICADEFIRMA]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.USPOLITICADEFIRMA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioFirma.usPoliticaDeFirma" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.USPOLITICADEFIRMA)}" >
          <form:hidden path="configuracioFirma.usPoliticaDeFirma"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.usPoliticaDeFirma,__theForm.listOfValuesForUsPoliticaDeFirma)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.USPOLITICADEFIRMA)}" >
          <form:select id="configuracioFirma_usPoliticaDeFirma"  onchange="if(typeof onChangeUsPoliticaDeFirma == 'function') {  onChangeUsPoliticaDeFirma(this); };"  cssClass="input-xxlarge" path="configuracioFirma.usPoliticaDeFirma">
            <c:forEach items="${__theForm.listOfValuesForUsPoliticaDeFirma}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIER)}">
        <tr id="configuracioFirma_policyIdentifier_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIER])?'configuracioFirma.policyIdentifier':__theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIER]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIER]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIER]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="configuracioFirma.policyIdentifier" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIER)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIER)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="100" path="configuracioFirma.policyIdentifier"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIERHASH)}">
        <tr id="configuracioFirma_policyIdentifierHash_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIERHASH])?'configuracioFirma.policyIdentifierHash':__theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIERHASH]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIERHASH]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIERHASH]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="configuracioFirma.policyIdentifierHash" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIERHASH)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIERHASH)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="256" path="configuracioFirma.policyIdentifierHash"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM)}">
        <tr id="configuracioFirma_policyIdentifierHashAlgorithm_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM])?'configuracioFirma.policyIdentifierHashAlgorithm':__theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="configuracioFirma.policyIdentifierHashAlgorithm" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="50" path="configuracioFirma.policyIdentifierHashAlgorithm"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.POLICYURLDOCUMENT)}">
        <tr id="configuracioFirma_policyUrlDocument_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.POLICYURLDOCUMENT])?'configuracioFirma.policyUrlDocument':__theForm.labels[ConfiguracioFirmaFields.POLICYURLDOCUMENT]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.POLICYURLDOCUMENT]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.POLICYURLDOCUMENT]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="configuracioFirma.policyUrlDocument" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYURLDOCUMENT)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYURLDOCUMENT)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="configuracioFirma.policyUrlDocument"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.POSICIOTAULAFIRMESID)}">
        <tr id="configuracioFirma_posicioTaulaFirmesID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.POSICIOTAULAFIRMESID])?'configuracioFirma.posicioTaulaFirmesID':__theForm.labels[ConfiguracioFirmaFields.POSICIOTAULAFIRMESID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.POSICIOTAULAFIRMESID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.POSICIOTAULAFIRMESID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioFirma.posicioTaulaFirmesID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POSICIOTAULAFIRMESID)}" >
          <form:hidden path="configuracioFirma.posicioTaulaFirmesID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.posicioTaulaFirmesID,__theForm.listOfValuesForPosicioTaulaFirmesID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POSICIOTAULAFIRMESID)}" >
          <form:select id="configuracioFirma_posicioTaulaFirmesID"  onchange="if(typeof onChangePosicioTaulaFirmesID == 'function') {  onChangePosicioTaulaFirmesID(this); };"  cssClass="input-xxlarge" path="configuracioFirma.posicioTaulaFirmesID">
            <c:forEach items="${__theForm.listOfValuesForPosicioTaulaFirmesID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.FIRMATPERFORMATID)}">
        <tr id="configuracioFirma_firmatPerFormatID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.FIRMATPERFORMATID])?'configuracioFirma.firmatPerFormatID':__theForm.labels[ConfiguracioFirmaFields.FIRMATPERFORMATID]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.FIRMATPERFORMATID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.FIRMATPERFORMATID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
       <form:errors path="configuracioFirma.firmatPerFormat" cssClass="errorField alert alert-error" />
       <div class="tabbable">
         <ul class="nav nav-tabs" style="margin-bottom: 3px;">
             <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
               <li class="${(counter.index == 0)? 'active':''}"  ><a href="#${counter.index}_tab_firmatPerFormat_${idioma.idiomaID}" data-toggle="tab">${idioma.nom}</a></li>
           </c:forEach>
           
         </ul>
         <div class="tab-content">
           <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
           <div class="tab-pane ${(counter.index == 0)? 'active':'' }" id="${counter.index}_tab_firmatPerFormat_${idioma.idiomaID}">
               <form:errors path="configuracioFirma.firmatPerFormat.traduccions['${idioma.idiomaID}'].valor" cssClass="errorField alert alert-error"/>
               <form:input path="configuracioFirma.firmatPerFormat.traduccions['${idioma.idiomaID}'].valor" readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.FIRMATPERFORMATID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.FIRMATPERFORMATID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="4000" />
           </div>
           </c:forEach>
         </div>
       </div>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.MOTIUDELEGACIOID)}">
        <tr id="configuracioFirma_motiuDelegacioID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.MOTIUDELEGACIOID])?'configuracioFirma.motiuDelegacioID':__theForm.labels[ConfiguracioFirmaFields.MOTIUDELEGACIOID]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.MOTIUDELEGACIOID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.MOTIUDELEGACIOID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
       <form:errors path="configuracioFirma.motiuDelegacio" cssClass="errorField alert alert-error" />
       <div class="tabbable">
         <ul class="nav nav-tabs" style="margin-bottom: 3px;">
             <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
               <li class="${(counter.index == 0)? 'active':''}"  ><a href="#${counter.index}_tab_motiuDelegacio_${idioma.idiomaID}" data-toggle="tab">${idioma.nom}</a></li>
           </c:forEach>
           
         </ul>
         <div class="tab-content">
           <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
           <div class="tab-pane ${(counter.index == 0)? 'active':'' }" id="${counter.index}_tab_motiuDelegacio_${idioma.idiomaID}">
               <form:errors path="configuracioFirma.motiuDelegacio.traduccions['${idioma.idiomaID}'].valor" cssClass="errorField alert alert-error"/>
               <form:input path="configuracioFirma.motiuDelegacio.traduccions['${idioma.idiomaID}'].valor" readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.MOTIUDELEGACIOID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.MOTIUDELEGACIOID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="4000" />
           </div>
           </c:forEach>
         </div>
       </div>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES)}">
        <tr id="configuracioFirma_propietatsTaulaFirmes_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES])?'configuracioFirma.propietatsTaulaFirmes':__theForm.labels[ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="configuracioFirma.propietatsTaulaFirmes" cssClass="errorField alert alert-error" />
              <form:textarea rows="3" wrap="soft" style="overflow:auto;" cssClass="input-xxlarge" readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES)? 'true' : 'false'}" path="configuracioFirma.propietatsTaulaFirmes"  />
              <div class="btn-group" style="vertical-align: top;">
              <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown">&nbsp;<span class="caret"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#" onclick="javascript:var ta=document.getElementById('configuracioFirma.propietatsTaulaFirmes'); ta.wrap='off';" >No Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('configuracioFirma.propietatsTaulaFirmes'); ta.wrap='soft';">Soft Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('configuracioFirma.propietatsTaulaFirmes'); ta.wrap='hard';">Hard Wrap</a></li>
              </ul>
              </div>
           </td>
        </tr>
        </c:if>
        
