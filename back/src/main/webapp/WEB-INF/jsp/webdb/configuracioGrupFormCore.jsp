<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ConfiguracioGrupFields" className="es.caib.digitalib.model.fields.ConfiguracioGrupFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.NOM)}">
        <tr id="configuracioGrup_nom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.NOM])?'configuracioGrup.nom':__theForm.labels[ConfiguracioGrupFields.NOM]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.NOM]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.NOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="configuracioGrup.nom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.NOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.NOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="100" path="configuracioGrup.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.SUPORTWEB)}">
        <tr id="configuracioGrup_suportWeb_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.SUPORTWEB])?'configuracioGrup.suportWeb':__theForm.labels[ConfiguracioGrupFields.SUPORTWEB]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.SUPORTWEB]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.SUPORTWEB]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
           <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTWEB)}">

             <c:if test="${ not empty __theForm.configuracioGrup.suportWeb}">
               <a href="${__theForm.configuracioGrup.suportWeb}" target="_blank">${__theForm.configuracioGrup.suportWeb}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTWEB))}">

            <form:errors path="configuracioGrup.suportWeb" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTWEB)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTWEB)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="configuracioGrup.suportWeb"   />

           </c:if>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.SUPORTEMAIL)}">
        <tr id="configuracioGrup_suportEmail_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.SUPORTEMAIL])?'configuracioGrup.suportEmail':__theForm.labels[ConfiguracioGrupFields.SUPORTEMAIL]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.SUPORTEMAIL]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.SUPORTEMAIL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="configuracioGrup.suportEmail" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTEMAIL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTEMAIL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="configuracioGrup.suportEmail"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.SUPORTTELEFON)}">
        <tr id="configuracioGrup_suportTelefon_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.SUPORTTELEFON])?'configuracioGrup.suportTelefon':__theForm.labels[ConfiguracioGrupFields.SUPORTTELEFON]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.SUPORTTELEFON]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.SUPORTTELEFON]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="configuracioGrup.suportTelefon" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTTELEFON)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTTELEFON)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="configuracioGrup.suportTelefon"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.LOGOHEADERID)}">
        <tr id="configuracioGrup_logoHeaderID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.LOGOHEADERID])?'configuracioGrup.logoHeaderID':__theForm.labels[ConfiguracioGrupFields.LOGOHEADERID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.LOGOHEADERID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.LOGOHEADERID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="configuracioGrup.logoHeaderID" cssClass="errorField alert alert-error" />
              <div class="fileupload fileupload-new" data-provides="fileupload" style="margin-bottom: 0px">
                <div class="input-append">
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOHEADERID)}" >
                    <div class="uneditable-input span3">
                      <i class="icon-file fileupload-exists"></i>
                      <span class="fileupload-preview"></span>
                    </div>
                    <span class="btn btn-file">
                      <span class="fileupload-new"><fmt:message key="genapp.form.file.select"/></span>
                      <span class="fileupload-exists"><fmt:message key="genapp.form.file.change"/></span>
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOHEADERID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOHEADERID)? 'input uneditable-input' : 'input'}"  path="logoHeaderID" type="file" />
                    </span>
                    <a href="#" class="btn fileupload-exists" data-dismiss="fileupload"><fmt:message key="genapp.form.file.unselect"/></a>
                    <span class="add-on">&nbsp;</span>
                </c:if>
                <c:if test="${not empty __theForm.configuracioGrup.logoHeader}">
                    <span class="add-on">
                        <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.configuracioGrup.logoHeader)}"/>">${__theForm.configuracioGrup.logoHeader.nom}</a>
                    </span>
                </c:if>
                </div>
              </div>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.LOGOFOOTERID)}">
        <tr id="configuracioGrup_logoFooterID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.LOGOFOOTERID])?'configuracioGrup.logoFooterID':__theForm.labels[ConfiguracioGrupFields.LOGOFOOTERID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.LOGOFOOTERID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.LOGOFOOTERID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="configuracioGrup.logoFooterID" cssClass="errorField alert alert-error" />
              <div class="fileupload fileupload-new" data-provides="fileupload" style="margin-bottom: 0px">
                <div class="input-append">
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOFOOTERID)}" >
                    <div class="uneditable-input span3">
                      <i class="icon-file fileupload-exists"></i>
                      <span class="fileupload-preview"></span>
                    </div>
                    <span class="btn btn-file">
                      <span class="fileupload-new"><fmt:message key="genapp.form.file.select"/></span>
                      <span class="fileupload-exists"><fmt:message key="genapp.form.file.change"/></span>
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOFOOTERID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOFOOTERID)? 'input uneditable-input' : 'input'}"  path="logoFooterID" type="file" />
                    </span>
                    <a href="#" class="btn fileupload-exists" data-dismiss="fileupload"><fmt:message key="genapp.form.file.unselect"/></a>
                    <span class="add-on">&nbsp;</span>
                </c:if>
                <c:if test="${not empty __theForm.configuracioGrup.logoFooter}">
                    <span class="add-on">
                        <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.configuracioGrup.logoFooter)}"/>">${__theForm.configuracioGrup.logoFooter.nom}</a>
                    </span>
                </c:if>
                </div>
              </div>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.ADREZA)}">
        <tr id="configuracioGrup_adreza_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.ADREZA])?'configuracioGrup.adreza':__theForm.labels[ConfiguracioGrupFields.ADREZA]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.ADREZA]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.ADREZA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="configuracioGrup.adreza" cssClass="errorField alert alert-error" />
              <form:textarea cssClass="input-xxlarge ${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.ADREZA)? 'mceEditorReadOnly':'mceEditor'}" path="configuracioGrup.adreza"  />
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.CODIDIR3PERDEFECTE)}">
        <tr id="configuracioGrup_codiDir3PerDefecte_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.CODIDIR3PERDEFECTE])?'configuracioGrup.codiDir3PerDefecte':__theForm.labels[ConfiguracioGrupFields.CODIDIR3PERDEFECTE]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.CODIDIR3PERDEFECTE]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.CODIDIR3PERDEFECTE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="configuracioGrup.codiDir3PerDefecte" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.CODIDIR3PERDEFECTE)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.CODIDIR3PERDEFECTE)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="50" path="configuracioGrup.codiDir3PerDefecte"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILNOMESESCANEIGID)}">
        <tr id="configuracioGrup_perfilNomesEscaneigID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILNOMESESCANEIGID])?'configuracioGrup.perfilNomesEscaneigID':__theForm.labels[ConfiguracioGrupFields.PERFILNOMESESCANEIGID]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILNOMESESCANEIGID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.PERFILNOMESESCANEIGID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioGrup.perfilNomesEscaneigID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILNOMESESCANEIGID)}" >
          <form:hidden path="configuracioGrup.perfilNomesEscaneigID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilNomesEscaneigID,__theForm.listOfPerfilForPerfilNomesEscaneigID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILNOMESESCANEIGID)}" >
          <form:select id="configuracioGrup_perfilNomesEscaneigID"  onchange="if(typeof onChangePerfilNomesEscaneigID == 'function') {  onChangePerfilNomesEscaneigID(this); };"  cssClass="input-xxlarge" path="configuracioGrup.perfilNomesEscaneigID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfPerfilForPerfilNomesEscaneigID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID)}">
        <tr id="configuracioGrup_perfilNomesEscaneig2ID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID])?'configuracioGrup.perfilNomesEscaneig2ID':__theForm.labels[ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioGrup.perfilNomesEscaneig2ID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID)}" >
          <form:hidden path="configuracioGrup.perfilNomesEscaneig2ID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilNomesEscaneig2ID,__theForm.listOfPerfilForPerfilNomesEscaneig2ID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID)}" >
          <form:select id="configuracioGrup_perfilNomesEscaneig2ID"  onchange="if(typeof onChangePerfilNomesEscaneig2ID == 'function') {  onChangePerfilNomesEscaneig2ID(this); };"  cssClass="input-xxlarge" path="configuracioGrup.perfilNomesEscaneig2ID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfPerfilForPerfilNomesEscaneig2ID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID)}">
        <tr id="configuracioGrup_perfilCopiaAutenticaID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID])?'configuracioGrup.perfilCopiaAutenticaID':__theForm.labels[ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioGrup.perfilCopiaAutenticaID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID)}" >
          <form:hidden path="configuracioGrup.perfilCopiaAutenticaID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilCopiaAutenticaID,__theForm.listOfPerfilForPerfilCopiaAutenticaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID)}" >
          <form:select id="configuracioGrup_perfilCopiaAutenticaID"  onchange="if(typeof onChangePerfilCopiaAutenticaID == 'function') {  onChangePerfilCopiaAutenticaID(this); };"  cssClass="input-xxlarge" path="configuracioGrup.perfilCopiaAutenticaID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfPerfilForPerfilCopiaAutenticaID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID)}">
        <tr id="configuracioGrup_perfilCopiaAutentica2ID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID])?'configuracioGrup.perfilCopiaAutentica2ID':__theForm.labels[ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioGrup.perfilCopiaAutentica2ID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID)}" >
          <form:hidden path="configuracioGrup.perfilCopiaAutentica2ID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilCopiaAutentica2ID,__theForm.listOfPerfilForPerfilCopiaAutentica2ID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID)}" >
          <form:select id="configuracioGrup_perfilCopiaAutentica2ID"  onchange="if(typeof onChangePerfilCopiaAutentica2ID == 'function') {  onChangePerfilCopiaAutentica2ID(this); };"  cssClass="input-xxlarge" path="configuracioGrup.perfilCopiaAutentica2ID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfPerfilForPerfilCopiaAutentica2ID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILCUSTODIAID)}">
        <tr id="configuracioGrup_perfilCustodiaID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILCUSTODIAID])?'configuracioGrup.perfilCustodiaID':__theForm.labels[ConfiguracioGrupFields.PERFILCUSTODIAID]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILCUSTODIAID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.PERFILCUSTODIAID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioGrup.perfilCustodiaID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCUSTODIAID)}" >
          <form:hidden path="configuracioGrup.perfilCustodiaID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilCustodiaID,__theForm.listOfPerfilForPerfilCustodiaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCUSTODIAID)}" >
          <form:select id="configuracioGrup_perfilCustodiaID"  onchange="if(typeof onChangePerfilCustodiaID == 'function') {  onChangePerfilCustodiaID(this); };"  cssClass="input-xxlarge" path="configuracioGrup.perfilCustodiaID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfPerfilForPerfilCustodiaID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILCUSTODIA2ID)}">
        <tr id="configuracioGrup_perfilCustodia2ID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILCUSTODIA2ID])?'configuracioGrup.perfilCustodia2ID':__theForm.labels[ConfiguracioGrupFields.PERFILCUSTODIA2ID]}" />
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILCUSTODIA2ID]}">
              <i class="icon-info-sign" title="${__theForm.help[ConfiguracioGrupFields.PERFILCUSTODIA2ID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="configuracioGrup.perfilCustodia2ID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCUSTODIA2ID)}" >
          <form:hidden path="configuracioGrup.perfilCustodia2ID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilCustodia2ID,__theForm.listOfPerfilForPerfilCustodia2ID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCUSTODIA2ID)}" >
          <form:select id="configuracioGrup_perfilCustodia2ID"  onchange="if(typeof onChangePerfilCustodia2ID == 'function') {  onChangePerfilCustodia2ID(this); };"  cssClass="input-xxlarge" path="configuracioGrup.perfilCustodia2ID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfPerfilForPerfilCustodia2ID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
