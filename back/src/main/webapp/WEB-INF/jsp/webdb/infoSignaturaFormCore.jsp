<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InfoSignaturaFields" className="es.caib.digitalib.model.fields.InfoSignaturaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.SIGNOPERATION)}">
        <tr id="infoSignatura_signOperation_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.SIGNOPERATION])?'infoSignatura.signOperation':__theForm.labels[InfoSignaturaFields.SIGNOPERATION]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.SIGNOPERATION]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.SIGNOPERATION]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="infoSignatura.signOperation" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNOPERATION)}" >
          <form:hidden path="infoSignatura.signOperation"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.infoSignatura.signOperation,__theForm.listOfValuesForSignOperation)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNOPERATION)}" >
          <form:select id="infoSignatura_signOperation"  onchange="if(typeof onChangeSignOperation == 'function') {  onChangeSignOperation(this); };"  cssClass="input-xxlarge" path="infoSignatura.signOperation">
            <c:forEach items="${__theForm.listOfValuesForSignOperation}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.SIGNTYPE)}">
        <tr id="infoSignatura_signType_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.SIGNTYPE])?'infoSignatura.signType':__theForm.labels[InfoSignaturaFields.SIGNTYPE]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.SIGNTYPE]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.SIGNTYPE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.signType" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNTYPE)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNTYPE)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.signType"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.SIGNALGORITHM)}">
        <tr id="infoSignatura_signAlgorithm_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.SIGNALGORITHM])?'infoSignatura.signAlgorithm':__theForm.labels[InfoSignaturaFields.SIGNALGORITHM]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.SIGNALGORITHM]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.SIGNALGORITHM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.signAlgorithm" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNALGORITHM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNALGORITHM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.signAlgorithm"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.SIGNMODE)}">
        <tr id="infoSignatura_signMode_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.SIGNMODE])?'infoSignatura.signMode':__theForm.labels[InfoSignaturaFields.SIGNMODE]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.SIGNMODE]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.SIGNMODE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="infoSignatura.signMode" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNMODE)}" >
          <form:hidden path="infoSignatura.signMode"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.infoSignatura.signMode,__theForm.listOfValuesForSignMode)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNMODE)}" >
          <form:select id="infoSignatura_signMode"  onchange="if(typeof onChangeSignMode == 'function') {  onChangeSignMode(this); };"  cssClass="input-xxlarge" path="infoSignatura.signMode">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfValuesForSignMode}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.SIGNATURESTABLELOCATION)}">
        <tr id="infoSignatura_signaturesTableLocation_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.SIGNATURESTABLELOCATION])?'infoSignatura.signaturesTableLocation':__theForm.labels[InfoSignaturaFields.SIGNATURESTABLELOCATION]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.SIGNATURESTABLELOCATION]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.SIGNATURESTABLELOCATION]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="infoSignatura.signaturesTableLocation" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNATURESTABLELOCATION)}" >
          <form:hidden path="infoSignatura.signaturesTableLocation"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.infoSignatura.signaturesTableLocation,__theForm.listOfValuesForSignaturesTableLocation)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNATURESTABLELOCATION)}" >
          <form:select id="infoSignatura_signaturesTableLocation"  onchange="if(typeof onChangeSignaturesTableLocation == 'function') {  onChangeSignaturesTableLocation(this); };"  cssClass="input-xxlarge" path="infoSignatura.signaturesTableLocation">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfValuesForSignaturesTableLocation}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.TIMESTAMPINCLUDED)}">
        <tr id="infoSignatura_timestampIncluded_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.TIMESTAMPINCLUDED])?'infoSignatura.timestampIncluded':__theForm.labels[InfoSignaturaFields.TIMESTAMPINCLUDED]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.TIMESTAMPINCLUDED]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.TIMESTAMPINCLUDED]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.TIMESTAMPINCLUDED)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeTimestampIncluded == 'function') {  onChangeTimestampIncluded(this); };"  path="infoSignatura.timestampIncluded">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.TIMESTAMPINCLUDED)}" >
                <fmt:message key="genapp.checkbox.${__theForm.infoSignatura.timestampIncluded}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.POLICYINCLUDED)}">
        <tr id="infoSignatura_policyIncluded_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.POLICYINCLUDED])?'infoSignatura.policyIncluded':__theForm.labels[InfoSignaturaFields.POLICYINCLUDED]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.POLICYINCLUDED]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.POLICYINCLUDED]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.POLICYINCLUDED)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangePolicyIncluded == 'function') {  onChangePolicyIncluded(this); };"  path="infoSignatura.policyIncluded">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.POLICYINCLUDED)}" >
                <fmt:message key="genapp.checkbox.${__theForm.infoSignatura.policyIncluded}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENITIPOFIRMA)}">
        <tr id="infoSignatura_eniTipoFirma_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENITIPOFIRMA])?'infoSignatura.eniTipoFirma':__theForm.labels[InfoSignaturaFields.ENITIPOFIRMA]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENITIPOFIRMA]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENITIPOFIRMA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.eniTipoFirma" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENITIPOFIRMA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENITIPOFIRMA)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.eniTipoFirma"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENIPERFILFIRMA)}">
        <tr id="infoSignatura_eniPerfilFirma_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENIPERFILFIRMA])?'infoSignatura.eniPerfilFirma':__theForm.labels[InfoSignaturaFields.ENIPERFILFIRMA]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENIPERFILFIRMA]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENIPERFILFIRMA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.eniPerfilFirma" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENIPERFILFIRMA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENIPERFILFIRMA)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.eniPerfilFirma"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENIROLFIRMA)}">
        <tr id="infoSignatura_eniRolFirma_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENIROLFIRMA])?'infoSignatura.eniRolFirma':__theForm.labels[InfoSignaturaFields.ENIROLFIRMA]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENIROLFIRMA]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENIROLFIRMA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.eniRolFirma" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENIROLFIRMA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENIROLFIRMA)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.eniRolFirma"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENISIGNERNAME)}">
        <tr id="infoSignatura_eniSignerName_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENISIGNERNAME])?'infoSignatura.eniSignerName':__theForm.labels[InfoSignaturaFields.ENISIGNERNAME]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENISIGNERNAME]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENISIGNERNAME]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.eniSignerName" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNERNAME)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNERNAME)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.eniSignerName"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENISIGNERADMINISTRATIONID)}">
        <tr id="infoSignatura_eniSignerAdministrationId_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENISIGNERADMINISTRATIONID])?'infoSignatura.eniSignerAdministrationId':__theForm.labels[InfoSignaturaFields.ENISIGNERADMINISTRATIONID]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENISIGNERADMINISTRATIONID]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENISIGNERADMINISTRATIONID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.eniSignerAdministrationId" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNERADMINISTRATIONID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNERADMINISTRATIONID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.eniSignerAdministrationId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENISIGNLEVEL)}">
        <tr id="infoSignatura_eniSignLevel_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENISIGNLEVEL])?'infoSignatura.eniSignLevel':__theForm.labels[InfoSignaturaFields.ENISIGNLEVEL]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENISIGNLEVEL]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENISIGNLEVEL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.eniSignLevel" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNLEVEL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNLEVEL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.eniSignLevel"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER)}">
        <tr id="infoSignatura_checkAdministrationIdOfSigner_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER])?'infoSignatura.checkAdministrationIdOfSigner':__theForm.labels[InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeCheckAdministrationIdOfSigner == 'function') {  onChangeCheckAdministrationIdOfSigner(this); };"  path="infoSignatura.checkAdministrationIdOfSigner">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER)}" >
                <fmt:message key="genapp.checkbox.${__theForm.infoSignatura.checkAdministrationIdOfSigner}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS)}">
        <tr id="infoSignatura_checkDocumentModifications_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS])?'infoSignatura.checkDocumentModifications':__theForm.labels[InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeCheckDocumentModifications == 'function') {  onChangeCheckDocumentModifications(this); };"  path="infoSignatura.checkDocumentModifications">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS)}" >
                <fmt:message key="genapp.checkbox.${__theForm.infoSignatura.checkDocumentModifications}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.CHECKVALIDATIONSIGNATURE)}">
        <tr id="infoSignatura_checkValidationSignature_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.CHECKVALIDATIONSIGNATURE])?'infoSignatura.checkValidationSignature':__theForm.labels[InfoSignaturaFields.CHECKVALIDATIONSIGNATURE]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.CHECKVALIDATIONSIGNATURE]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.CHECKVALIDATIONSIGNATURE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKVALIDATIONSIGNATURE)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeCheckValidationSignature == 'function') {  onChangeCheckValidationSignature(this); };"  path="infoSignatura.checkValidationSignature">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKVALIDATIONSIGNATURE)}" >
                <fmt:message key="genapp.checkbox.${__theForm.infoSignatura.checkValidationSignature}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
