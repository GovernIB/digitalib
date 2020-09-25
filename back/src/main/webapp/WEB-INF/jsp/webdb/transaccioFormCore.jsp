<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="TransaccioFields" className="es.caib.digitalib.model.fields.TransaccioFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.NOM)}">
        <tr id="transaccio_nom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.NOM])?'transaccio.nom':__theForm.labels[TransaccioFields.NOM]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.NOM]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.NOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.nom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.NOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.NOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.TRANSACTIONWEBID)}">
        <tr id="transaccio_transactionWebId_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.TRANSACTIONWEBID])?'transaccio.transactionWebId':__theForm.labels[TransaccioFields.TRANSACTIONWEBID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioFields.TRANSACTIONWEBID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.TRANSACTIONWEBID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.transactionWebId" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.TRANSACTIONWEBID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.TRANSACTIONWEBID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="100" path="transaccio.transactionWebId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.DATAINICI)}">
        <tr id="transaccio_dataInici_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.DATAINICI])?'transaccio.dataInici':__theForm.labels[TransaccioFields.DATAINICI]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioFields.DATAINICI]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.DATAINICI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="transaccio.dataInici" cssClass="errorField alert alert-error" />
              <div id="dataInici" class="input-append">
                <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAINICI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAINICI)? 'input-medium uneditable-input' : 'input-medium'}"  path="transaccio.dataInici" />
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAINICI)}" >
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </c:if>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataInici').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.DATAFI)}">
        <tr id="transaccio_dataFi_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.DATAFI])?'transaccio.dataFi':__theForm.labels[TransaccioFields.DATAFI]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.DATAFI]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.DATAFI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="transaccio.dataFi" cssClass="errorField alert alert-error" />
              <div id="dataFi" class="input-append">
                <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAFI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAFI)? 'input-medium uneditable-input' : 'input-medium'}"  path="transaccio.dataFi" />
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAFI)}" >
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </c:if>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataFi').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.USUARIAPLICACIOID)}">
        <tr id="transaccio_usuariAplicacioId_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.USUARIAPLICACIOID])?'transaccio.usuariAplicacioId':__theForm.labels[TransaccioFields.USUARIAPLICACIOID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.USUARIAPLICACIOID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.USUARIAPLICACIOID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.usuariAplicacioId" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIAPLICACIOID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIAPLICACIOID)? 'input-mini uneditable-input' : 'input-mini'}"   path="transaccio.usuariAplicacioId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.USUARIPERSONAID)}">
        <tr id="transaccio_usuariPersonaId_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.USUARIPERSONAID])?'transaccio.usuariPersonaId':__theForm.labels[TransaccioFields.USUARIPERSONAID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.USUARIPERSONAID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.USUARIPERSONAID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.usuariPersonaId" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIPERSONAID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIPERSONAID)? 'input-mini uneditable-input' : 'input-mini'}"   path="transaccio.usuariPersonaId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.IP)}">
        <tr id="transaccio_ip_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.IP])?'transaccio.ip':__theForm.labels[TransaccioFields.IP]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioFields.IP]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.IP]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.ip" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.IP)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.IP)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="50" path="transaccio.ip"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.RETURNURL)}">
        <tr id="transaccio_returnUrl_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.RETURNURL])?'transaccio.returnUrl':__theForm.labels[TransaccioFields.RETURNURL]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.RETURNURL]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.RETURNURL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.returnUrl" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.RETURNURL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.RETURNURL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.returnUrl"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ESTATCODI)}">
        <tr id="transaccio_estatCodi_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ESTATCODI])?'transaccio.estatCodi':__theForm.labels[TransaccioFields.ESTATCODI]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioFields.ESTATCODI]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ESTATCODI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.estatCodi" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATCODI)}" >
          <form:hidden path="transaccio.estatCodi"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.estatCodi,__theForm.listOfValuesForEstatCodi)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATCODI)}" >
          <form:select id="transaccio_estatCodi"  onchange="if(typeof onChangeEstatCodi == 'function') {  onChangeEstatCodi(this); };"  cssClass="input-xxlarge" path="transaccio.estatCodi">
            <c:forEach items="${__theForm.listOfValuesForEstatCodi}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ESTATMISSATGE)}">
        <tr id="transaccio_estatMissatge_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ESTATMISSATGE])?'transaccio.estatMissatge':__theForm.labels[TransaccioFields.ESTATMISSATGE]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ESTATMISSATGE]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ESTATMISSATGE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.estatMissatge" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATMISSATGE)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATMISSATGE)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="3000" path="transaccio.estatMissatge"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ESTATEXCEPCIO)}">
        <tr id="transaccio_estatExcepcio_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ESTATEXCEPCIO])?'transaccio.estatExcepcio':__theForm.labels[TransaccioFields.ESTATEXCEPCIO]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ESTATEXCEPCIO]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ESTATEXCEPCIO]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="transaccio.estatExcepcio" cssClass="errorField alert alert-error" />
              <form:textarea rows="3" wrap="soft" style="overflow:auto;" cssClass="input-xxlarge" readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATEXCEPCIO)? 'true' : 'false'}" path="transaccio.estatExcepcio"  />
              <div class="btn-group" style="vertical-align: top;">
              <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown">&nbsp;<span class="caret"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#" onclick="javascript:var ta=document.getElementById('transaccio.estatExcepcio'); ta.wrap='off';" >No Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('transaccio.estatExcepcio'); ta.wrap='soft';">Soft Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('transaccio.estatExcepcio'); ta.wrap='hard';">Hard Wrap</a></li>
              </ul>
              </div>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.FITXERESCANEJATID)}">
        <tr id="transaccio_fitxerEscanejatID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.FITXERESCANEJATID])?'transaccio.fitxerEscanejatID':__theForm.labels[TransaccioFields.FITXERESCANEJATID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.FITXERESCANEJATID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.FITXERESCANEJATID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="transaccio.fitxerEscanejatID" cssClass="errorField alert alert-error" />
              <div class="fileupload fileupload-new" data-provides="fileupload" style="margin-bottom: 0px">
                <div class="input-append">
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERESCANEJATID)}" >
                    <div class="uneditable-input span3">
                      <i class="icon-file fileupload-exists"></i>
                      <span class="fileupload-preview"></span>
                    </div>
                    <span class="btn btn-file">
                      <span class="fileupload-new"><fmt:message key="genapp.form.file.select"/></span>
                      <span class="fileupload-exists"><fmt:message key="genapp.form.file.change"/></span>
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERESCANEJATID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERESCANEJATID)? 'input uneditable-input' : 'input'}"  path="fitxerEscanejatID" type="file" />
                    </span>
                    <a href="#" class="btn fileupload-exists" data-dismiss="fileupload"><fmt:message key="genapp.form.file.unselect"/></a>
                    <span class="add-on">&nbsp;</span>
                </c:if>
                <c:if test="${not empty __theForm.transaccio.fitxerEscanejat}">
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERESCANEJATID)}" >
                    <span class="add-on">
                        <form:checkbox path="fitxerEscanejatIDDelete"/>
                        <fmt:message key="genapp.form.file.delete"/>
                    </span>
                    <span class="add-on">&nbsp;</span>   
                </c:if>
                    <span class="add-on">
                        <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.transaccio.fitxerEscanejat)}"/>">${__theForm.transaccio.fitxerEscanejat.nom}</a>
                    </span>
                </c:if>
                </div>
              </div>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.HASHESCANEIG)}">
        <tr id="transaccio_hashEscaneig_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.HASHESCANEIG])?'transaccio.hashEscaneig':__theForm.labels[TransaccioFields.HASHESCANEIG]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.HASHESCANEIG]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.HASHESCANEIG]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.hashEscaneig" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.HASHESCANEIG)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.HASHESCANEIG)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.hashEscaneig"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.FITXERSIGNATURAID)}">
        <tr id="transaccio_fitxerSignaturaID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.FITXERSIGNATURAID])?'transaccio.fitxerSignaturaID':__theForm.labels[TransaccioFields.FITXERSIGNATURAID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.FITXERSIGNATURAID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.FITXERSIGNATURAID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="transaccio.fitxerSignaturaID" cssClass="errorField alert alert-error" />
              <div class="fileupload fileupload-new" data-provides="fileupload" style="margin-bottom: 0px">
                <div class="input-append">
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERSIGNATURAID)}" >
                    <div class="uneditable-input span3">
                      <i class="icon-file fileupload-exists"></i>
                      <span class="fileupload-preview"></span>
                    </div>
                    <span class="btn btn-file">
                      <span class="fileupload-new"><fmt:message key="genapp.form.file.select"/></span>
                      <span class="fileupload-exists"><fmt:message key="genapp.form.file.change"/></span>
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERSIGNATURAID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERSIGNATURAID)? 'input uneditable-input' : 'input'}"  path="fitxerSignaturaID" type="file" />
                    </span>
                    <a href="#" class="btn fileupload-exists" data-dismiss="fileupload"><fmt:message key="genapp.form.file.unselect"/></a>
                    <span class="add-on">&nbsp;</span>
                </c:if>
                <c:if test="${not empty __theForm.transaccio.fitxerSignatura}">
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERSIGNATURAID)}" >
                    <span class="add-on">
                        <form:checkbox path="fitxerSignaturaIDDelete"/>
                        <fmt:message key="genapp.form.file.delete"/>
                    </span>
                    <span class="add-on">&nbsp;</span>   
                </c:if>
                    <span class="add-on">
                        <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.transaccio.fitxerSignatura)}"/>">${__theForm.transaccio.fitxerSignatura.nom}</a>
                    </span>
                </c:if>
                </div>
              </div>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.HASHFIRMA)}">
        <tr id="transaccio_hashFirma_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.HASHFIRMA])?'transaccio.hashFirma':__theForm.labels[TransaccioFields.HASHFIRMA]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.HASHFIRMA]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.HASHFIRMA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.hashFirma" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.HASHFIRMA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.HASHFIRMA)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.hashFirma"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANPAPERSIZE)}">
        <tr id="transaccio_infoScanPaperSize_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANPAPERSIZE])?'transaccio.infoScanPaperSize':__theForm.labels[TransaccioFields.INFOSCANPAPERSIZE]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANPAPERSIZE]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOSCANPAPERSIZE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.infoScanPaperSize" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANPAPERSIZE)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANPAPERSIZE)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="100" path="transaccio.infoScanPaperSize"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANPIXELTYPE)}">
        <tr id="transaccio_infoScanPixelType_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANPIXELTYPE])?'transaccio.infoScanPixelType':__theForm.labels[TransaccioFields.INFOSCANPIXELTYPE]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANPIXELTYPE]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOSCANPIXELTYPE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.infoScanPixelType" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANPIXELTYPE)}" >
          <form:hidden path="transaccio.infoScanPixelType"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.infoScanPixelType,__theForm.listOfValuesForInfoScanPixelType)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANPIXELTYPE)}" >
          <form:select id="transaccio_infoScanPixelType"  onchange="if(typeof onChangeInfoScanPixelType == 'function') {  onChangeInfoScanPixelType(this); };"  cssClass="input-xxlarge" path="transaccio.infoScanPixelType">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfValuesForInfoScanPixelType}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANRESOLUCIOPPP)}">
        <tr id="transaccio_infoScanResolucioPpp_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANRESOLUCIOPPP])?'transaccio.infoScanResolucioPpp':__theForm.labels[TransaccioFields.INFOSCANRESOLUCIOPPP]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANRESOLUCIOPPP]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOSCANRESOLUCIOPPP]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.infoScanResolucioPpp" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANRESOLUCIOPPP)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANRESOLUCIOPPP)? 'input-mini uneditable-input' : 'input-mini'}"   path="transaccio.infoScanResolucioPpp"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANOCR)}">
        <tr id="transaccio_infoScanOcr_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANOCR])?'transaccio.infoScanOcr':__theForm.labels[TransaccioFields.INFOSCANOCR]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANOCR]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOSCANOCR]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANOCR)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeInfoScanOcr == 'function') {  onChangeInfoScanOcr(this); };"  path="transaccio.infoScanOcr">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANOCR)}" >
                <fmt:message key="genapp.checkbox.${__theForm.transaccio.infoScanOcr}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANDATACAPTURA)}">
        <tr id="transaccio_infoScanDataCaptura_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANDATACAPTURA])?'transaccio.infoScanDataCaptura':__theForm.labels[TransaccioFields.INFOSCANDATACAPTURA]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANDATACAPTURA]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOSCANDATACAPTURA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="transaccio.infoScanDataCaptura" cssClass="errorField alert alert-error" />
              <div id="infoScanDataCaptura" class="input-append">
                <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANDATACAPTURA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANDATACAPTURA)? 'input-medium uneditable-input' : 'input-medium'}"  path="transaccio.infoScanDataCaptura" />
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANDATACAPTURA)}" >
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </c:if>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#infoScanDataCaptura').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.VIEW)}">
        <tr id="transaccio_view_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.VIEW])?'transaccio.view':__theForm.labels[TransaccioFields.VIEW]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioFields.VIEW]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.VIEW]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.view" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.VIEW)}" >
          <form:hidden path="transaccio.view"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.view,__theForm.listOfValuesForView)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.VIEW)}" >
          <form:select id="transaccio_view"  onchange="if(typeof onChangeView == 'function') {  onChangeView(this); };"  cssClass="input-xxlarge" path="transaccio.view">
            <c:forEach items="${__theForm.listOfValuesForView}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.LANGUAGEUI)}">
        <tr id="transaccio_languageUI_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.LANGUAGEUI])?'transaccio.languageUI':__theForm.labels[TransaccioFields.LANGUAGEUI]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioFields.LANGUAGEUI]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.LANGUAGEUI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.languageUI" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.LANGUAGEUI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.LANGUAGEUI)? 'input-small uneditable-input' : 'input-small'}"  maxlength="10" path="transaccio.languageUI"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.FUNCIONARIUSERNAME)}">
        <tr id="transaccio_funcionariUsername_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.FUNCIONARIUSERNAME])?'transaccio.funcionariUsername':__theForm.labels[TransaccioFields.FUNCIONARIUSERNAME]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioFields.FUNCIONARIUSERNAME]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.FUNCIONARIUSERNAME]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.funcionariUsername" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.FUNCIONARIUSERNAME)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.FUNCIONARIUSERNAME)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.funcionariUsername"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.SIGNPARAMFUNCIONARINOM)}">
        <tr id="transaccio_signParamFuncionariNom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.SIGNPARAMFUNCIONARINOM])?'transaccio.signParamFuncionariNom':__theForm.labels[TransaccioFields.SIGNPARAMFUNCIONARINOM]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.SIGNPARAMFUNCIONARINOM]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.SIGNPARAMFUNCIONARINOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.signParamFuncionariNom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMFUNCIONARINOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMFUNCIONARINOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.signParamFuncionariNom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.SIGNPARAMFUNCIONARINIF)}">
        <tr id="transaccio_signParamFuncionariNif_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.SIGNPARAMFUNCIONARINIF])?'transaccio.signParamFuncionariNif':__theForm.labels[TransaccioFields.SIGNPARAMFUNCIONARINIF]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.SIGNPARAMFUNCIONARINIF]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.SIGNPARAMFUNCIONARINIF]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.signParamFuncionariNif" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMFUNCIONARINIF)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMFUNCIONARINIF)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.signParamFuncionariNif"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.SIGNPARAMLANGUAGEDOC)}">
        <tr id="transaccio_signParamLanguageDoc_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.SIGNPARAMLANGUAGEDOC])?'transaccio.signParamLanguageDoc':__theForm.labels[TransaccioFields.SIGNPARAMLANGUAGEDOC]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.SIGNPARAMLANGUAGEDOC]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.SIGNPARAMLANGUAGEDOC]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.signParamLanguageDoc" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMLANGUAGEDOC)}" >
          <form:hidden path="transaccio.signParamLanguageDoc"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.signParamLanguageDoc,__theForm.listOfValuesForSignParamLanguageDoc)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMLANGUAGEDOC)}" >
          <form:select id="transaccio_signParamLanguageDoc"  onchange="if(typeof onChangeSignParamLanguageDoc == 'function') {  onChangeSignParamLanguageDoc(this); };"  cssClass="input-xxlarge" path="transaccio.signParamLanguageDoc">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfValuesForSignParamLanguageDoc}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMDOCESTATELABORA)}">
        <tr id="transaccio_arxiuReqParamDocEstatElabora_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMDOCESTATELABORA])?'transaccio.arxiuReqParamDocEstatElabora':__theForm.labels[TransaccioFields.ARXIUREQPARAMDOCESTATELABORA]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMDOCESTATELABORA]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMDOCESTATELABORA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.arxiuReqParamDocEstatElabora" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMDOCESTATELABORA)}" >
          <form:hidden path="transaccio.arxiuReqParamDocEstatElabora"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.arxiuReqParamDocEstatElabora,__theForm.listOfValuesForArxiuReqParamDocEstatElabora)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMDOCESTATELABORA)}" >
          <form:select id="transaccio_arxiuReqParamDocEstatElabora"  onchange="if(typeof onChangeArxiuReqParamDocEstatElabora == 'function') {  onChangeArxiuReqParamDocEstatElabora(this); };"  cssClass="input-xxlarge" path="transaccio.arxiuReqParamDocEstatElabora">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfValuesForArxiuReqParamDocEstatElabora}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMDOCUMENTTIPUS)}">
        <tr id="transaccio_arxiuReqParamDocumentTipus_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMDOCUMENTTIPUS])?'transaccio.arxiuReqParamDocumentTipus':__theForm.labels[TransaccioFields.ARXIUREQPARAMDOCUMENTTIPUS]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMDOCUMENTTIPUS]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMDOCUMENTTIPUS]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.arxiuReqParamDocumentTipus" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMDOCUMENTTIPUS)}" >
          <form:hidden path="transaccio.arxiuReqParamDocumentTipus"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.arxiuReqParamDocumentTipus,__theForm.listOfValuesForArxiuReqParamDocumentTipus)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMDOCUMENTTIPUS)}" >
          <form:select id="transaccio_arxiuReqParamDocumentTipus"  onchange="if(typeof onChangeArxiuReqParamDocumentTipus == 'function') {  onChangeArxiuReqParamDocumentTipus(this); };"  cssClass="input-xxlarge" path="transaccio.arxiuReqParamDocumentTipus">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfValuesForArxiuReqParamDocumentTipus}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMORIGEN)}">
        <tr id="transaccio_arxiuReqParamOrigen_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMORIGEN])?'transaccio.arxiuReqParamOrigen':__theForm.labels[TransaccioFields.ARXIUREQPARAMORIGEN]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMORIGEN]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMORIGEN]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.arxiuReqParamOrigen" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMORIGEN)}" >
          <form:hidden path="transaccio.arxiuReqParamOrigen"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.arxiuReqParamOrigen,__theForm.listOfValuesForArxiuReqParamOrigen)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMORIGEN)}" >
          <form:select id="transaccio_arxiuReqParamOrigen"  onchange="if(typeof onChangeArxiuReqParamOrigen == 'function') {  onChangeArxiuReqParamOrigen(this); };"  cssClass="input-xxlarge" path="transaccio.arxiuReqParamOrigen">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfValuesForArxiuReqParamOrigen}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMINTERESSATS)}">
        <tr id="transaccio_arxiuReqParamInteressats_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMINTERESSATS])?'transaccio.arxiuReqParamInteressats':__theForm.labels[TransaccioFields.ARXIUREQPARAMINTERESSATS]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMINTERESSATS]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMINTERESSATS]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.arxiuReqParamInteressats" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMINTERESSATS)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMINTERESSATS)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.arxiuReqParamInteressats"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMCIUTADANIF)}">
        <tr id="transaccio_arxiuReqParamCiutadaNif_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMCIUTADANIF])?'transaccio.arxiuReqParamCiutadaNif':__theForm.labels[TransaccioFields.ARXIUREQPARAMCIUTADANIF]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMCIUTADANIF]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMCIUTADANIF]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.arxiuReqParamCiutadaNif" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMCIUTADANIF)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMCIUTADANIF)? 'input-medium uneditable-input' : 'input-medium'}"  maxlength="15" path="transaccio.arxiuReqParamCiutadaNif"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMCIUTADANOM)}">
        <tr id="transaccio_arxiuReqParamCiutadaNom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMCIUTADANOM])?'transaccio.arxiuReqParamCiutadaNom':__theForm.labels[TransaccioFields.ARXIUREQPARAMCIUTADANOM]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMCIUTADANOM]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMCIUTADANOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.arxiuReqParamCiutadaNom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMCIUTADANOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMCIUTADANOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.arxiuReqParamCiutadaNom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMORGANS)}">
        <tr id="transaccio_arxiuReqParamOrgans_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMORGANS])?'transaccio.arxiuReqParamOrgans':__theForm.labels[TransaccioFields.ARXIUREQPARAMORGANS]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMORGANS]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMORGANS]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.arxiuReqParamOrgans" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMORGANS)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMORGANS)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.arxiuReqParamOrgans"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI)}">
        <tr id="transaccio_arxiuOptParamProcedimentCodi_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI])?'transaccio.arxiuOptParamProcedimentCodi':__theForm.labels[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.arxiuOptParamProcedimentCodi" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.arxiuOptParamProcedimentCodi"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM)}">
        <tr id="transaccio_arxiuOptParamProcedimentNom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM])?'transaccio.arxiuOptParamProcedimentNom':__theForm.labels[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.arxiuOptParamProcedimentNom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.arxiuOptParamProcedimentNom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL)}">
        <tr id="transaccio_arxiuOptParamSerieDocumental_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL])?'transaccio.arxiuOptParamSerieDocumental':__theForm.labels[TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.arxiuOptParamSerieDocumental" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.arxiuOptParamSerieDocumental"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID)}">
        <tr id="transaccio_arxiuOptParamCustodyOrExpedientId_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID])?'transaccio.arxiuOptParamCustodyOrExpedientId':__theForm.labels[TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.arxiuOptParamCustodyOrExpedientId" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.arxiuOptParamCustodyOrExpedientId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.PERFILID)}">
        <tr id="transaccio_perfilID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.PERFILID])?'transaccio.perfilID':__theForm.labels[TransaccioFields.PERFILID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioFields.PERFILID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.PERFILID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.perfilID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.PERFILID)}" >
          <form:hidden path="transaccio.perfilID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.perfilID,__theForm.listOfPerfilForPerfilID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.PERFILID)}" >
          <form:select id="transaccio_perfilID"  onchange="if(typeof onChangePerfilID == 'function') {  onChangePerfilID(this); };"  cssClass="input-xxlarge" path="transaccio.perfilID">
            <c:forEach items="${__theForm.listOfPerfilForPerfilID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSIGNATURAID)}">
        <tr id="transaccio_infoSignaturaID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSIGNATURAID])?'transaccio.infoSignaturaID':__theForm.labels[TransaccioFields.INFOSIGNATURAID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSIGNATURAID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOSIGNATURAID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.infoSignaturaID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSIGNATURAID)}" >
          <form:hidden path="transaccio.infoSignaturaID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.infoSignaturaID,__theForm.listOfInfoSignaturaForInfoSignaturaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSIGNATURAID)}" >
          <form:select id="transaccio_infoSignaturaID"  onchange="if(typeof onChangeInfoSignaturaID == 'function') {  onChangeInfoSignaturaID(this); };"  cssClass="input-xxlarge" path="transaccio.infoSignaturaID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfInfoSignaturaForInfoSignaturaID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOCUSTODYID)}">
        <tr id="transaccio_infoCustodyID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOCUSTODYID])?'transaccio.infoCustodyID':__theForm.labels[TransaccioFields.INFOCUSTODYID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOCUSTODYID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOCUSTODYID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.infoCustodyID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOCUSTODYID)}" >
          <form:hidden path="transaccio.infoCustodyID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.infoCustodyID,__theForm.listOfInfoCustodyForInfoCustodyID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOCUSTODYID)}" >
          <form:select id="transaccio_infoCustodyID"  onchange="if(typeof onChangeInfoCustodyID == 'function') {  onChangeInfoCustodyID(this); };"  cssClass="input-xxlarge" path="transaccio.infoCustodyID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfInfoCustodyForInfoCustodyID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.TRANSACCIOMULTIPLEID)}">
        <tr id="transaccio_transaccioMultipleID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.TRANSACCIOMULTIPLEID])?'transaccio.transaccioMultipleID':__theForm.labels[TransaccioFields.TRANSACCIOMULTIPLEID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.TRANSACCIOMULTIPLEID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.TRANSACCIOMULTIPLEID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.transaccioMultipleID" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.TRANSACCIOMULTIPLEID)}" >
          <form:hidden path="transaccio.transaccioMultipleID"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.transaccioMultipleID,__theForm.listOfTransaccioMultipleForTransaccioMultipleID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.TRANSACCIOMULTIPLEID)}" >
          <form:select id="transaccio_transaccioMultipleID"  onchange="if(typeof onChangeTransaccioMultipleID == 'function') {  onChangeTransaccioMultipleID(this); };"  cssClass="input-xxlarge" path="transaccio.transaccioMultipleID">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfTransaccioMultipleForTransaccioMultipleID}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
