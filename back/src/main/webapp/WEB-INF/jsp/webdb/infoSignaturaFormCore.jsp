<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InfoSignaturaFields" className="es.caib.digitalib.model.fields.InfoSignaturaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.SIGNOPERATION)}">
        <tr id="infoSignatura_signoperation_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.SIGNOPERATION])?'infoSignatura.signoperation':__theForm.labels[InfoSignaturaFields.SIGNOPERATION]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.SIGNOPERATION]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.SIGNOPERATION]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="infoSignatura.signoperation" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNOPERATION)}" >
          <form:hidden path="infoSignatura.signoperation"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.infoSignatura.signoperation,__theForm.listOfValuesForSignoperation)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNOPERATION)}" >
          <form:select id="infoSignatura_signoperation"  onchange="if(typeof onChangeSignoperation == 'function') {  onChangeSignoperation(this); };"  cssClass="input-xxlarge" path="infoSignatura.signoperation">
            <c:forEach items="${__theForm.listOfValuesForSignoperation}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.SIGNTYPE)}">
        <tr id="infoSignatura_signtype_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.SIGNTYPE])?'infoSignatura.signtype':__theForm.labels[InfoSignaturaFields.SIGNTYPE]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.SIGNTYPE]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.SIGNTYPE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.signtype" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNTYPE)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNTYPE)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.signtype"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.SIGNALGORITHM)}">
        <tr id="infoSignatura_signalgorithm_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.SIGNALGORITHM])?'infoSignatura.signalgorithm':__theForm.labels[InfoSignaturaFields.SIGNALGORITHM]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.SIGNALGORITHM]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.SIGNALGORITHM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.signalgorithm" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNALGORITHM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNALGORITHM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.signalgorithm"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.SIGNMODE)}">
        <tr id="infoSignatura_signmode_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.SIGNMODE])?'infoSignatura.signmode':__theForm.labels[InfoSignaturaFields.SIGNMODE]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.SIGNMODE]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.SIGNMODE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="infoSignatura.signmode" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNMODE)}" >
          <form:hidden path="infoSignatura.signmode"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.infoSignatura.signmode,__theForm.listOfValuesForSignmode)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNMODE)}" >
          <form:select id="infoSignatura_signmode"  onchange="if(typeof onChangeSignmode == 'function') {  onChangeSignmode(this); };"  cssClass="input-xxlarge" path="infoSignatura.signmode">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfValuesForSignmode}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.SIGNATURESTABLELOCATION)}">
        <tr id="infoSignatura_signaturestablelocation_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.SIGNATURESTABLELOCATION])?'infoSignatura.signaturestablelocation':__theForm.labels[InfoSignaturaFields.SIGNATURESTABLELOCATION]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.SIGNATURESTABLELOCATION]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.SIGNATURESTABLELOCATION]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="infoSignatura.signaturestablelocation" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNATURESTABLELOCATION)}" >
          <form:hidden path="infoSignatura.signaturestablelocation"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.infoSignatura.signaturestablelocation,__theForm.listOfValuesForSignaturestablelocation)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.SIGNATURESTABLELOCATION)}" >
          <form:select id="infoSignatura_signaturestablelocation"  onchange="if(typeof onChangeSignaturestablelocation == 'function') {  onChangeSignaturestablelocation(this); };"  cssClass="input-xxlarge" path="infoSignatura.signaturestablelocation">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfValuesForSignaturestablelocation}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.TIMESTAMPINCLUDED)}">
        <tr id="infoSignatura_timestampincluded_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.TIMESTAMPINCLUDED])?'infoSignatura.timestampincluded':__theForm.labels[InfoSignaturaFields.TIMESTAMPINCLUDED]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.TIMESTAMPINCLUDED]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.TIMESTAMPINCLUDED]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.TIMESTAMPINCLUDED)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeTimestampincluded == 'function') {  onChangeTimestampincluded(this); };"  path="infoSignatura.timestampincluded">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.TIMESTAMPINCLUDED)}" >
                <fmt:message key="genapp.checkbox.${__theForm.infoSignatura.timestampincluded}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.POLICYINCLUDED)}">
        <tr id="infoSignatura_policyincluded_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.POLICYINCLUDED])?'infoSignatura.policyincluded':__theForm.labels[InfoSignaturaFields.POLICYINCLUDED]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.POLICYINCLUDED]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.POLICYINCLUDED]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.POLICYINCLUDED)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangePolicyincluded == 'function') {  onChangePolicyincluded(this); };"  path="infoSignatura.policyincluded">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.POLICYINCLUDED)}" >
                <fmt:message key="genapp.checkbox.${__theForm.infoSignatura.policyincluded}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENITIPOFIRMA)}">
        <tr id="infoSignatura_enitipofirma_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENITIPOFIRMA])?'infoSignatura.enitipofirma':__theForm.labels[InfoSignaturaFields.ENITIPOFIRMA]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENITIPOFIRMA]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENITIPOFIRMA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.enitipofirma" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENITIPOFIRMA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENITIPOFIRMA)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.enitipofirma"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENIPERFILFIRMA)}">
        <tr id="infoSignatura_eniperfilfirma_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENIPERFILFIRMA])?'infoSignatura.eniperfilfirma':__theForm.labels[InfoSignaturaFields.ENIPERFILFIRMA]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENIPERFILFIRMA]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENIPERFILFIRMA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.eniperfilfirma" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENIPERFILFIRMA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENIPERFILFIRMA)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.eniperfilfirma"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENIROLFIRMA)}">
        <tr id="infoSignatura_enirolfirma_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENIROLFIRMA])?'infoSignatura.enirolfirma':__theForm.labels[InfoSignaturaFields.ENIROLFIRMA]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENIROLFIRMA]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENIROLFIRMA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.enirolfirma" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENIROLFIRMA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENIROLFIRMA)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.enirolfirma"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENISIGNERNAME)}">
        <tr id="infoSignatura_enisignername_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENISIGNERNAME])?'infoSignatura.enisignername':__theForm.labels[InfoSignaturaFields.ENISIGNERNAME]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENISIGNERNAME]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENISIGNERNAME]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.enisignername" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNERNAME)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNERNAME)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.enisignername"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENISIGNERADMINISTRATIONID)}">
        <tr id="infoSignatura_enisigneradministrationid_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENISIGNERADMINISTRATIONID])?'infoSignatura.enisigneradministrationid':__theForm.labels[InfoSignaturaFields.ENISIGNERADMINISTRATIONID]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENISIGNERADMINISTRATIONID]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENISIGNERADMINISTRATIONID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.enisigneradministrationid" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNERADMINISTRATIONID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNERADMINISTRATIONID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.enisigneradministrationid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.ENISIGNLEVEL)}">
        <tr id="infoSignatura_enisignlevel_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.ENISIGNLEVEL])?'infoSignatura.enisignlevel':__theForm.labels[InfoSignaturaFields.ENISIGNLEVEL]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.ENISIGNLEVEL]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.ENISIGNLEVEL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="infoSignatura.enisignlevel" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNLEVEL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.ENISIGNLEVEL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="infoSignatura.enisignlevel"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER)}">
        <tr id="infoSignatura_checkadministrationidofsigner_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER])?'infoSignatura.checkadministrationidofsigner':__theForm.labels[InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeCheckadministrationidofsigner == 'function') {  onChangeCheckadministrationidofsigner(this); };"  path="infoSignatura.checkadministrationidofsigner">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKADMINISTRATIONIDOFSIGNER)}" >
                <fmt:message key="genapp.checkbox.${__theForm.infoSignatura.checkadministrationidofsigner}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS)}">
        <tr id="infoSignatura_checkdocumentmodifications_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS])?'infoSignatura.checkdocumentmodifications':__theForm.labels[InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeCheckdocumentmodifications == 'function') {  onChangeCheckdocumentmodifications(this); };"  path="infoSignatura.checkdocumentmodifications">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKDOCUMENTMODIFICATIONS)}" >
                <fmt:message key="genapp.checkbox.${__theForm.infoSignatura.checkdocumentmodifications}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InfoSignaturaFields.CHECKVALIDATIONSIGNATURE)}">
        <tr id="infoSignatura_checkvalidationsignature_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[InfoSignaturaFields.CHECKVALIDATIONSIGNATURE])?'infoSignatura.checkvalidationsignature':__theForm.labels[InfoSignaturaFields.CHECKVALIDATIONSIGNATURE]}" />
              <c:if test="${not empty __theForm.help[InfoSignaturaFields.CHECKVALIDATIONSIGNATURE]}">
              <i class="icon-info-sign" title="${__theForm.help[InfoSignaturaFields.CHECKVALIDATIONSIGNATURE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKVALIDATIONSIGNATURE)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeCheckvalidationsignature == 'function') {  onChangeCheckvalidationsignature(this); };"  path="infoSignatura.checkvalidationsignature">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InfoSignaturaFields.CHECKVALIDATIONSIGNATURE)}" >
                <fmt:message key="genapp.checkbox.${__theForm.infoSignatura.checkvalidationsignature}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
