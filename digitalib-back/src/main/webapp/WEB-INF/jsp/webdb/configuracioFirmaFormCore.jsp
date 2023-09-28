<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ConfiguracioFirmaFields" className="es.caib.digitalib.model.fields.ConfiguracioFirmaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.NOM)}">
        <tr id="configuracioFirma_nom_rowid">
          <td id="configuracioFirma_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.NOM])?'configuracioFirma.nom':__theForm.labels[ConfiguracioFirmaFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_nom_columnvalueid">
            <form:errors path="configuracioFirma.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="configuracioFirma.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID)}">
        <tr id="configuracioFirma_pluginFirmaServidorID_rowid">
          <td id="configuracioFirma_pluginFirmaServidorID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID])?'configuracioFirma.pluginFirmaServidorID':__theForm.labels[ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_pluginFirmaServidorID_columnvalueid">
          <form:errors path="configuracioFirma.pluginFirmaServidorID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID)}" >
          <form:hidden path="configuracioFirma.pluginFirmaServidorID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.pluginFirmaServidorID,__theForm.listOfPluginForPluginFirmaServidorID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.PLUGINFIRMASERVIDORID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioFirma_pluginFirmaServidorID"  onchange="if(typeof onChangePluginFirmaServidorID == 'function') {  onChangePluginFirmaServidorID(this); };"  cssClass="form-control col-md-9-optional" path="configuracioFirma.pluginFirmaServidorID">
            <c:forEach items="${__theForm.listOfPluginForPluginFirmaServidorID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS)}">
        <tr id="configuracioFirma_incloureSegellDeTemps_rowid">
          <td id="configuracioFirma_incloureSegellDeTemps_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS])?'configuracioFirma.incloureSegellDeTemps':__theForm.labels[ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_incloureSegellDeTemps_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS)}" >
              <form:errors path="configuracioFirma.incloureSegellDeTemps" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS)? 'false' : 'true'}" path="configuracioFirma.incloureSegellDeTemps" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.INCLOURESEGELLDETEMPS)}" >
                <fmt:message key="genapp.checkbox.${__theForm.configuracioFirma.incloureSegellDeTemps}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.PLUGINSEGELLATID)}">
        <tr id="configuracioFirma_pluginSegellatID_rowid">
          <td id="configuracioFirma_pluginSegellatID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.PLUGINSEGELLATID])?'configuracioFirma.pluginSegellatID':__theForm.labels[ConfiguracioFirmaFields.PLUGINSEGELLATID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.PLUGINSEGELLATID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.PLUGINSEGELLATID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_pluginSegellatID_columnvalueid">
          <form:errors path="configuracioFirma.pluginSegellatID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.PLUGINSEGELLATID)}" >
          <form:hidden path="configuracioFirma.pluginSegellatID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.pluginSegellatID,__theForm.listOfPluginForPluginSegellatID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.PLUGINSEGELLATID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioFirma_pluginSegellatID"  onchange="if(typeof onChangePluginSegellatID == 'function') {  onChangePluginSegellatID(this); };"  cssClass="form-control col-md-9-optional" path="configuracioFirma.pluginSegellatID">
            <c:forEach items="${__theForm.listOfPluginForPluginSegellatID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.configuracioFirma.pluginSegellatID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.configuracioFirma.pluginSegellatID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA)}">
        <tr id="configuracioFirma_tipusOperacioFirma_rowid">
          <td id="configuracioFirma_tipusOperacioFirma_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA])?'configuracioFirma.tipusOperacioFirma':__theForm.labels[ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_tipusOperacioFirma_columnvalueid">
          <form:errors path="configuracioFirma.tipusOperacioFirma" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA)}" >
          <form:hidden path="configuracioFirma.tipusOperacioFirma"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.tipusOperacioFirma,__theForm.listOfValuesForTipusOperacioFirma)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.TIPUSOPERACIOFIRMA)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioFirma_tipusOperacioFirma"  onchange="if(typeof onChangeTipusOperacioFirma == 'function') {  onChangeTipusOperacioFirma(this); };"  cssClass="form-control col-md-9-optional" path="configuracioFirma.tipusOperacioFirma">
            <c:forEach items="${__theForm.listOfValuesForTipusOperacioFirma}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.TIPUSFIRMAID)}">
        <tr id="configuracioFirma_tipusFirmaID_rowid">
          <td id="configuracioFirma_tipusFirmaID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.TIPUSFIRMAID])?'configuracioFirma.tipusFirmaID':__theForm.labels[ConfiguracioFirmaFields.TIPUSFIRMAID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.TIPUSFIRMAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.TIPUSFIRMAID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_tipusFirmaID_columnvalueid">
          <form:errors path="configuracioFirma.tipusFirmaID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.TIPUSFIRMAID)}" >
          <form:hidden path="configuracioFirma.tipusFirmaID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.tipusFirmaID,__theForm.listOfValuesForTipusFirmaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.TIPUSFIRMAID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioFirma_tipusFirmaID"  onchange="if(typeof onChangeTipusFirmaID == 'function') {  onChangeTipusFirmaID(this); };"  cssClass="form-control col-md-9-optional" path="configuracioFirma.tipusFirmaID">
            <c:forEach items="${__theForm.listOfValuesForTipusFirmaID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.ALGORISMEDEFIRMAID)}">
        <tr id="configuracioFirma_algorismeDeFirmaID_rowid">
          <td id="configuracioFirma_algorismeDeFirmaID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.ALGORISMEDEFIRMAID])?'configuracioFirma.algorismeDeFirmaID':__theForm.labels[ConfiguracioFirmaFields.ALGORISMEDEFIRMAID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.ALGORISMEDEFIRMAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.ALGORISMEDEFIRMAID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_algorismeDeFirmaID_columnvalueid">
          <form:errors path="configuracioFirma.algorismeDeFirmaID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.ALGORISMEDEFIRMAID)}" >
          <form:hidden path="configuracioFirma.algorismeDeFirmaID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.algorismeDeFirmaID,__theForm.listOfValuesForAlgorismeDeFirmaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.ALGORISMEDEFIRMAID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioFirma_algorismeDeFirmaID"  onchange="if(typeof onChangeAlgorismeDeFirmaID == 'function') {  onChangeAlgorismeDeFirmaID(this); };"  cssClass="form-control col-md-9-optional" path="configuracioFirma.algorismeDeFirmaID">
            <c:forEach items="${__theForm.listOfValuesForAlgorismeDeFirmaID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.MODEDEFIRMA)}">
        <tr id="configuracioFirma_modeDeFirma_rowid">
          <td id="configuracioFirma_modeDeFirma_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.MODEDEFIRMA])?'configuracioFirma.modeDeFirma':__theForm.labels[ConfiguracioFirmaFields.MODEDEFIRMA]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.MODEDEFIRMA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.MODEDEFIRMA]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_modeDeFirma_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.MODEDEFIRMA)}" >
              <form:select cssClass="form-control col-md-6" onchange="if(typeof onChangeModeDeFirma == 'function') {  onChangeModeDeFirma(this); };"  path="configuracioFirma.modeDeFirma">
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
          <td id="configuracioFirma_usPoliticaDeFirma_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.USPOLITICADEFIRMA])?'configuracioFirma.usPoliticaDeFirma':__theForm.labels[ConfiguracioFirmaFields.USPOLITICADEFIRMA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.USPOLITICADEFIRMA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.USPOLITICADEFIRMA]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_usPoliticaDeFirma_columnvalueid">
          <form:errors path="configuracioFirma.usPoliticaDeFirma" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.USPOLITICADEFIRMA)}" >
          <form:hidden path="configuracioFirma.usPoliticaDeFirma"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.usPoliticaDeFirma,__theForm.listOfValuesForUsPoliticaDeFirma)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.USPOLITICADEFIRMA)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioFirma_usPoliticaDeFirma"  onchange="if(typeof onChangeUsPoliticaDeFirma == 'function') {  onChangeUsPoliticaDeFirma(this); };"  cssClass="form-control col-md-9-optional" path="configuracioFirma.usPoliticaDeFirma">
            <c:forEach items="${__theForm.listOfValuesForUsPoliticaDeFirma}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIER)}">
        <tr id="configuracioFirma_policyIdentifier_rowid">
          <td id="configuracioFirma_policyIdentifier_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIER])?'configuracioFirma.policyIdentifier':__theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIER]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIER]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIER]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_policyIdentifier_columnvalueid">
            <form:errors path="configuracioFirma.policyIdentifier" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIER)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIER)? ' uneditable-input' : ''}"  style="" maxlength="100" path="configuracioFirma.policyIdentifier"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIERHASH)}">
        <tr id="configuracioFirma_policyIdentifierHash_rowid">
          <td id="configuracioFirma_policyIdentifierHash_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIERHASH])?'configuracioFirma.policyIdentifierHash':__theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIERHASH]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIERHASH]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIERHASH]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_policyIdentifierHash_columnvalueid">
            <form:errors path="configuracioFirma.policyIdentifierHash" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIERHASH)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIERHASH)? ' uneditable-input' : ''}"  style="" maxlength="256" path="configuracioFirma.policyIdentifierHash"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM)}">
        <tr id="configuracioFirma_policyIdentifierHashAlgorithm_rowid">
          <td id="configuracioFirma_policyIdentifierHashAlgorithm_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM])?'configuracioFirma.policyIdentifierHashAlgorithm':__theForm.labels[ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_policyIdentifierHashAlgorithm_columnvalueid">
            <form:errors path="configuracioFirma.policyIdentifierHashAlgorithm" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYIDENTIFIERHASHALGORITHM)? ' uneditable-input' : ''}"  style="" maxlength="50" path="configuracioFirma.policyIdentifierHashAlgorithm"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.POLICYURLDOCUMENT)}">
        <tr id="configuracioFirma_policyUrlDocument_rowid">
          <td id="configuracioFirma_policyUrlDocument_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.POLICYURLDOCUMENT])?'configuracioFirma.policyUrlDocument':__theForm.labels[ConfiguracioFirmaFields.POLICYURLDOCUMENT]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.POLICYURLDOCUMENT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.POLICYURLDOCUMENT]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_policyUrlDocument_columnvalueid">
            <form:errors path="configuracioFirma.policyUrlDocument" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYURLDOCUMENT)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POLICYURLDOCUMENT)? ' uneditable-input' : ''}"  style="" maxlength="255" path="configuracioFirma.policyUrlDocument"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.POSICIOTAULAFIRMESID)}">
        <tr id="configuracioFirma_posicioTaulaFirmesID_rowid">
          <td id="configuracioFirma_posicioTaulaFirmesID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.POSICIOTAULAFIRMESID])?'configuracioFirma.posicioTaulaFirmesID':__theForm.labels[ConfiguracioFirmaFields.POSICIOTAULAFIRMESID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.POSICIOTAULAFIRMESID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.POSICIOTAULAFIRMESID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_posicioTaulaFirmesID_columnvalueid">
          <form:errors path="configuracioFirma.posicioTaulaFirmesID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POSICIOTAULAFIRMESID)}" >
          <form:hidden path="configuracioFirma.posicioTaulaFirmesID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioFirma.posicioTaulaFirmesID,__theForm.listOfValuesForPosicioTaulaFirmesID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.POSICIOTAULAFIRMESID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioFirma_posicioTaulaFirmesID"  onchange="if(typeof onChangePosicioTaulaFirmesID == 'function') {  onChangePosicioTaulaFirmesID(this); };"  cssClass="form-control col-md-9-optional" path="configuracioFirma.posicioTaulaFirmesID">
            <c:forEach items="${__theForm.listOfValuesForPosicioTaulaFirmesID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.FIRMATPERFORMATID)}">
        <tr id="configuracioFirma_firmatPerFormatID_rowid">
          <td id="configuracioFirma_firmatPerFormatID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.FIRMATPERFORMATID])?'configuracioFirma.firmatPerFormatID':__theForm.labels[ConfiguracioFirmaFields.FIRMATPERFORMATID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.FIRMATPERFORMATID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.FIRMATPERFORMATID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_firmatPerFormatID_columnvalueid">
       <form:errors path="configuracioFirma.firmatPerFormat" cssClass="errorField alert alert-danger" />
       <div class="row-fluid col-md-9-optional">
         <ul class="nav nav-tabs" style="margin: 0 15px -1px;">
             <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
            <li class="nav-item ">
                 <a class="nav-link ${(counter.index == 0)? 'active':''}" href="#${counter.index}_tab_firmatPerFormat_${idioma.idiomaID}" data-toggle="tab">${idioma.nom}</a>
            </li>
          </c:forEach>
           
         </ul>
         <div class="tab-content well well-white" style="padding:8px;margin:0px;">
           <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
           <div class="tab-pane ${(counter.index == 0)? 'active':'' }" id="${counter.index}_tab_firmatPerFormat_${idioma.idiomaID}">
               <form:errors path="configuracioFirma.firmatPerFormat.traduccions['${idioma.idiomaID}'].valor" cssClass="errorField alert alert-danger"/>
               <form:input path="configuracioFirma.firmatPerFormat.traduccions['${idioma.idiomaID}'].valor" cssClass="form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.FIRMATPERFORMATID)? ' uneditable-input' : ''}" readonly="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.FIRMATPERFORMATID)}" maxlength="4000" />
           </div>
           </c:forEach>
         </div>
       </div>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.MOTIUDELEGACIOID)}">
        <tr id="configuracioFirma_motiuDelegacioID_rowid">
          <td id="configuracioFirma_motiuDelegacioID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.MOTIUDELEGACIOID])?'configuracioFirma.motiuDelegacioID':__theForm.labels[ConfiguracioFirmaFields.MOTIUDELEGACIOID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.MOTIUDELEGACIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.MOTIUDELEGACIOID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_motiuDelegacioID_columnvalueid">
       <form:errors path="configuracioFirma.motiuDelegacio" cssClass="errorField alert alert-danger" />
       <div class="row-fluid col-md-9-optional">
         <ul class="nav nav-tabs" style="margin: 0 15px -1px;">
             <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
            <li class="nav-item ">
                 <a class="nav-link ${(counter.index == 0)? 'active':''}" href="#${counter.index}_tab_motiuDelegacio_${idioma.idiomaID}" data-toggle="tab">${idioma.nom}</a>
            </li>
          </c:forEach>
           
         </ul>
         <div class="tab-content well well-white" style="padding:8px;margin:0px;">
           <c:forEach items="${__theForm.idiomesTraduccio}" var="idioma" varStatus="counter">
           <div class="tab-pane ${(counter.index == 0)? 'active':'' }" id="${counter.index}_tab_motiuDelegacio_${idioma.idiomaID}">
               <form:errors path="configuracioFirma.motiuDelegacio.traduccions['${idioma.idiomaID}'].valor" cssClass="errorField alert alert-danger"/>
               <form:input path="configuracioFirma.motiuDelegacio.traduccions['${idioma.idiomaID}'].valor" cssClass="form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.MOTIUDELEGACIOID)? ' uneditable-input' : ''}" readonly="${gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.MOTIUDELEGACIOID)}" maxlength="4000" />
           </div>
           </c:forEach>
         </div>
       </div>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES)}">
        <tr id="configuracioFirma_propietatsTaulaFirmes_rowid">
          <td id="configuracioFirma_propietatsTaulaFirmes_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES])?'configuracioFirma.propietatsTaulaFirmes':__theForm.labels[ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES]}" ></i>
              </c:if>
            </td>
          <td id="configuracioFirma_propietatsTaulaFirmes_columnvalueid">
              <form:errors path="configuracioFirma.propietatsTaulaFirmes" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioFirmaFields.PROPIETATSTAULAFIRMES)? 'true' : 'false'}" path="configuracioFirma.propietatsTaulaFirmes"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_propietatsTaulaFirmes" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_propietatsTaulaFirmes" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('configuracioFirma.propietatsTaulaFirmes'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('configuracioFirma.propietatsTaulaFirmes'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('configuracioFirma.propietatsTaulaFirmes'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_propietatsTaulaFirmes').on('click', function(){
					var valor = ($('#dropdownMenuContainer_propietatsTaulaFirmes').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_propietatsTaulaFirmes').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
