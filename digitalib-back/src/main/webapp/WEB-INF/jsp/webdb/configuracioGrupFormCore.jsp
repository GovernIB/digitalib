<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ConfiguracioGrupFields" className="es.caib.digitalib.model.fields.ConfiguracioGrupFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.NOM)}">
        <tr id="configuracioGrup_nom_rowid">
          <td id="configuracioGrup_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.NOM])?'configuracioGrup.nom':__theForm.labels[ConfiguracioGrupFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_nom_columnvalueid">
            <form:errors path="configuracioGrup.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="100" path="configuracioGrup.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.SUPORTWEB)}">
        <tr id="configuracioGrup_suportWeb_rowid">
          <td id="configuracioGrup_suportWeb_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.SUPORTWEB])?'configuracioGrup.suportWeb':__theForm.labels[ConfiguracioGrupFields.SUPORTWEB]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.SUPORTWEB]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.SUPORTWEB]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_suportWeb_columnvalueid">
           <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTWEB)}">

             <c:if test="${ not empty __theForm.configuracioGrup.suportWeb}">
               <a href="${__theForm.configuracioGrup.suportWeb}" target="_blank">${__theForm.configuracioGrup.suportWeb}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTWEB))}">

            <form:errors path="configuracioGrup.suportWeb" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTWEB)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTWEB)? ' uneditable-input' : ''}"  style="" maxlength="255" path="configuracioGrup.suportWeb"   />

           </c:if>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.SUPORTEMAIL)}">
        <tr id="configuracioGrup_suportEmail_rowid">
          <td id="configuracioGrup_suportEmail_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.SUPORTEMAIL])?'configuracioGrup.suportEmail':__theForm.labels[ConfiguracioGrupFields.SUPORTEMAIL]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.SUPORTEMAIL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.SUPORTEMAIL]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_suportEmail_columnvalueid">
            <form:errors path="configuracioGrup.suportEmail" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTEMAIL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTEMAIL)? ' uneditable-input' : ''}"  style="" maxlength="255" path="configuracioGrup.suportEmail"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.SUPORTTELEFON)}">
        <tr id="configuracioGrup_suportTelefon_rowid">
          <td id="configuracioGrup_suportTelefon_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.SUPORTTELEFON])?'configuracioGrup.suportTelefon':__theForm.labels[ConfiguracioGrupFields.SUPORTTELEFON]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.SUPORTTELEFON]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.SUPORTTELEFON]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_suportTelefon_columnvalueid">
            <form:errors path="configuracioGrup.suportTelefon" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTTELEFON)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.SUPORTTELEFON)? ' uneditable-input' : ''}"  style="" maxlength="255" path="configuracioGrup.suportTelefon"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.LOGOHEADERID)}">
        <tr id="configuracioGrup_logoHeaderID_rowid">
          <td id="configuracioGrup_logoHeaderID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.LOGOHEADERID])?'configuracioGrup.logoHeaderID':__theForm.labels[ConfiguracioGrupFields.LOGOHEADERID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.LOGOHEADERID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.LOGOHEADERID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_logoHeaderID_columnvalueid">
              <form:errors path="configuracioGrup.logoHeaderID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOHEADERID)}" >
              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.configuracioGrup.logoHeader)}"/>">${__theForm.configuracioGrup.logoHeader.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOHEADERID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOHEADERID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOHEADERID)? ' uneditable-input' : ''}"   path="logoHeaderID" type="file" />
                  <label class="custom-file-label" for="logoHeaderID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.configuracioGrup.logoHeader}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.configuracioGrup.logoHeader)}"/>">${__theForm.configuracioGrup.logoHeader.nom}</a>
</small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="logoHeaderID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#logoHeaderID').on('change', function(){
						var ruta = $('#logoHeaderID').val(); 
						var rutaArray = ruta.split('\\');
						$('#logoHeaderID-custom-file-label').css('display','block');
						$('#logoHeaderID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.LOGOFOOTERID)}">
        <tr id="configuracioGrup_logoFooterID_rowid">
          <td id="configuracioGrup_logoFooterID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.LOGOFOOTERID])?'configuracioGrup.logoFooterID':__theForm.labels[ConfiguracioGrupFields.LOGOFOOTERID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.LOGOFOOTERID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.LOGOFOOTERID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_logoFooterID_columnvalueid">
              <form:errors path="configuracioGrup.logoFooterID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOFOOTERID)}" >
              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.configuracioGrup.logoFooter)}"/>">${__theForm.configuracioGrup.logoFooter.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOFOOTERID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOFOOTERID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.LOGOFOOTERID)? ' uneditable-input' : ''}"   path="logoFooterID" type="file" />
                  <label class="custom-file-label" for="logoFooterID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.configuracioGrup.logoFooter}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.configuracioGrup.logoFooter)}"/>">${__theForm.configuracioGrup.logoFooter.nom}</a>
</small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="logoFooterID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#logoFooterID').on('change', function(){
						var ruta = $('#logoFooterID').val(); 
						var rutaArray = ruta.split('\\');
						$('#logoFooterID-custom-file-label').css('display','block');
						$('#logoFooterID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.ADREZA)}">
        <tr id="configuracioGrup_adreza_rowid">
          <td id="configuracioGrup_adreza_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.ADREZA])?'configuracioGrup.adreza':__theForm.labels[ConfiguracioGrupFields.ADREZA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.ADREZA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.ADREZA]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_adreza_columnvalueid">
              <form:errors path="configuracioGrup.adreza" cssClass="errorField alert alert-danger" />
       <form:textarea cssClass=" ${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.ADREZA)? 'mceEditorReadOnly':'mceEditor'}"  path="configuracioGrup.adreza"  />
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.CODIDIR3PERDEFECTE)}">
        <tr id="configuracioGrup_codiDir3PerDefecte_rowid">
          <td id="configuracioGrup_codiDir3PerDefecte_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.CODIDIR3PERDEFECTE])?'configuracioGrup.codiDir3PerDefecte':__theForm.labels[ConfiguracioGrupFields.CODIDIR3PERDEFECTE]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.CODIDIR3PERDEFECTE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.CODIDIR3PERDEFECTE]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_codiDir3PerDefecte_columnvalueid">
            <form:errors path="configuracioGrup.codiDir3PerDefecte" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.CODIDIR3PERDEFECTE)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.CODIDIR3PERDEFECTE)? ' uneditable-input' : ''}"  style="" maxlength="50" path="configuracioGrup.codiDir3PerDefecte"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILNOMESESCANEIGID)}">
        <tr id="configuracioGrup_perfilNomesEscaneigID_rowid">
          <td id="configuracioGrup_perfilNomesEscaneigID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILNOMESESCANEIGID])?'configuracioGrup.perfilNomesEscaneigID':__theForm.labels[ConfiguracioGrupFields.PERFILNOMESESCANEIGID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILNOMESESCANEIGID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.PERFILNOMESESCANEIGID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_perfilNomesEscaneigID_columnvalueid">
          <form:errors path="configuracioGrup.perfilNomesEscaneigID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILNOMESESCANEIGID)}" >
          <form:hidden path="configuracioGrup.perfilNomesEscaneigID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilNomesEscaneigID,__theForm.listOfPerfilForPerfilNomesEscaneigID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILNOMESESCANEIGID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioGrup_perfilNomesEscaneigID"  onchange="if(typeof onChangePerfilNomesEscaneigID == 'function') {  onChangePerfilNomesEscaneigID(this); };"  cssClass="form-control col-md-9-optional" path="configuracioGrup.perfilNomesEscaneigID">
            <c:forEach items="${__theForm.listOfPerfilForPerfilNomesEscaneigID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.configuracioGrup.perfilNomesEscaneigID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.configuracioGrup.perfilNomesEscaneigID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID)}">
        <tr id="configuracioGrup_perfilNomesEscaneig2ID_rowid">
          <td id="configuracioGrup_perfilNomesEscaneig2ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID])?'configuracioGrup.perfilNomesEscaneig2ID':__theForm.labels[ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_perfilNomesEscaneig2ID_columnvalueid">
          <form:errors path="configuracioGrup.perfilNomesEscaneig2ID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID)}" >
          <form:hidden path="configuracioGrup.perfilNomesEscaneig2ID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilNomesEscaneig2ID,__theForm.listOfPerfilForPerfilNomesEscaneig2ID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILNOMESESCANEIG2ID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioGrup_perfilNomesEscaneig2ID"  onchange="if(typeof onChangePerfilNomesEscaneig2ID == 'function') {  onChangePerfilNomesEscaneig2ID(this); };"  cssClass="form-control col-md-9-optional" path="configuracioGrup.perfilNomesEscaneig2ID">
            <c:forEach items="${__theForm.listOfPerfilForPerfilNomesEscaneig2ID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.configuracioGrup.perfilNomesEscaneig2ID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.configuracioGrup.perfilNomesEscaneig2ID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID)}">
        <tr id="configuracioGrup_perfilCopiaAutenticaID_rowid">
          <td id="configuracioGrup_perfilCopiaAutenticaID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID])?'configuracioGrup.perfilCopiaAutenticaID':__theForm.labels[ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_perfilCopiaAutenticaID_columnvalueid">
          <form:errors path="configuracioGrup.perfilCopiaAutenticaID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID)}" >
          <form:hidden path="configuracioGrup.perfilCopiaAutenticaID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilCopiaAutenticaID,__theForm.listOfPerfilForPerfilCopiaAutenticaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCOPIAAUTENTICAID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioGrup_perfilCopiaAutenticaID"  onchange="if(typeof onChangePerfilCopiaAutenticaID == 'function') {  onChangePerfilCopiaAutenticaID(this); };"  cssClass="form-control col-md-9-optional" path="configuracioGrup.perfilCopiaAutenticaID">
            <c:forEach items="${__theForm.listOfPerfilForPerfilCopiaAutenticaID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.configuracioGrup.perfilCopiaAutenticaID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.configuracioGrup.perfilCopiaAutenticaID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID)}">
        <tr id="configuracioGrup_perfilCopiaAutentica2ID_rowid">
          <td id="configuracioGrup_perfilCopiaAutentica2ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID])?'configuracioGrup.perfilCopiaAutentica2ID':__theForm.labels[ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_perfilCopiaAutentica2ID_columnvalueid">
          <form:errors path="configuracioGrup.perfilCopiaAutentica2ID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID)}" >
          <form:hidden path="configuracioGrup.perfilCopiaAutentica2ID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilCopiaAutentica2ID,__theForm.listOfPerfilForPerfilCopiaAutentica2ID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCOPIAAUTENTICA2ID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioGrup_perfilCopiaAutentica2ID"  onchange="if(typeof onChangePerfilCopiaAutentica2ID == 'function') {  onChangePerfilCopiaAutentica2ID(this); };"  cssClass="form-control col-md-9-optional" path="configuracioGrup.perfilCopiaAutentica2ID">
            <c:forEach items="${__theForm.listOfPerfilForPerfilCopiaAutentica2ID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.configuracioGrup.perfilCopiaAutentica2ID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.configuracioGrup.perfilCopiaAutentica2ID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILCUSTODIAID)}">
        <tr id="configuracioGrup_perfilCustodiaID_rowid">
          <td id="configuracioGrup_perfilCustodiaID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILCUSTODIAID])?'configuracioGrup.perfilCustodiaID':__theForm.labels[ConfiguracioGrupFields.PERFILCUSTODIAID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILCUSTODIAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.PERFILCUSTODIAID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_perfilCustodiaID_columnvalueid">
          <form:errors path="configuracioGrup.perfilCustodiaID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCUSTODIAID)}" >
          <form:hidden path="configuracioGrup.perfilCustodiaID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilCustodiaID,__theForm.listOfPerfilForPerfilCustodiaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCUSTODIAID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioGrup_perfilCustodiaID"  onchange="if(typeof onChangePerfilCustodiaID == 'function') {  onChangePerfilCustodiaID(this); };"  cssClass="form-control col-md-9-optional" path="configuracioGrup.perfilCustodiaID">
            <c:forEach items="${__theForm.listOfPerfilForPerfilCustodiaID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.configuracioGrup.perfilCustodiaID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.configuracioGrup.perfilCustodiaID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ConfiguracioGrupFields.PERFILCUSTODIA2ID)}">
        <tr id="configuracioGrup_perfilCustodia2ID_rowid">
          <td id="configuracioGrup_perfilCustodia2ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ConfiguracioGrupFields.PERFILCUSTODIA2ID])?'configuracioGrup.perfilCustodia2ID':__theForm.labels[ConfiguracioGrupFields.PERFILCUSTODIA2ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ConfiguracioGrupFields.PERFILCUSTODIA2ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ConfiguracioGrupFields.PERFILCUSTODIA2ID]}" ></i>
              </c:if>
            </td>
          <td id="configuracioGrup_perfilCustodia2ID_columnvalueid">
          <form:errors path="configuracioGrup.perfilCustodia2ID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCUSTODIA2ID)}" >
          <form:hidden path="configuracioGrup.perfilCustodia2ID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.configuracioGrup.perfilCustodia2ID,__theForm.listOfPerfilForPerfilCustodia2ID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ConfiguracioGrupFields.PERFILCUSTODIA2ID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="configuracioGrup_perfilCustodia2ID"  onchange="if(typeof onChangePerfilCustodia2ID == 'function') {  onChangePerfilCustodia2ID(this); };"  cssClass="form-control col-md-9-optional" path="configuracioGrup.perfilCustodia2ID">
            <c:forEach items="${__theForm.listOfPerfilForPerfilCustodia2ID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.configuracioGrup.perfilCustodia2ID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.configuracioGrup.perfilCustodia2ID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
