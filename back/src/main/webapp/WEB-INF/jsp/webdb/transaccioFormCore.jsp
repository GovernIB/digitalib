<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="TransaccioFields" className="es.caib.digitalib.model.fields.TransaccioFields"/>
  
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
        <tr id="transaccio_datafi_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.DATAFI])?'transaccio.datafi':__theForm.labels[TransaccioFields.DATAFI]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.DATAFI]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.DATAFI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="transaccio.datafi" cssClass="errorField alert alert-error" />
              <div id="datafi" class="input-append">
                <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAFI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAFI)? 'input-medium uneditable-input' : 'input-medium'}"  path="transaccio.datafi" />
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAFI)}" >
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </c:if>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#datafi').datetimepicker({
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
        <tr id="transaccio_usuariaplicacioid_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.USUARIAPLICACIOID])?'transaccio.usuariaplicacioid':__theForm.labels[TransaccioFields.USUARIAPLICACIOID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.USUARIAPLICACIOID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.USUARIAPLICACIOID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.usuariaplicacioid" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIAPLICACIOID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIAPLICACIOID)? 'input-mini uneditable-input' : 'input-mini'}"   path="transaccio.usuariaplicacioid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.USUARIPERSONAID)}">
        <tr id="transaccio_usuaripersonaid_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.USUARIPERSONAID])?'transaccio.usuaripersonaid':__theForm.labels[TransaccioFields.USUARIPERSONAID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.USUARIPERSONAID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.USUARIPERSONAID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.usuaripersonaid" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIPERSONAID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIPERSONAID)? 'input-mini uneditable-input' : 'input-mini'}"   path="transaccio.usuaripersonaid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ESTATCODI)}">
        <tr id="transaccio_estatcodi_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ESTATCODI])?'transaccio.estatcodi':__theForm.labels[TransaccioFields.ESTATCODI]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioFields.ESTATCODI]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ESTATCODI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.estatcodi" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATCODI)}" >
          <form:hidden path="transaccio.estatcodi"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.estatcodi,__theForm.listOfValuesForEstatcodi)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATCODI)}" >
          <form:select id="transaccio_estatcodi"  onchange="if(typeof onChangeEstatcodi == 'function') {  onChangeEstatcodi(this); };"  cssClass="input-xxlarge" path="transaccio.estatcodi">
            <c:forEach items="${__theForm.listOfValuesForEstatcodi}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ESTATMISSATGE)}">
        <tr id="transaccio_estatmissatge_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ESTATMISSATGE])?'transaccio.estatmissatge':__theForm.labels[TransaccioFields.ESTATMISSATGE]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ESTATMISSATGE]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ESTATMISSATGE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.estatmissatge" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATMISSATGE)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATMISSATGE)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="3000" path="transaccio.estatmissatge"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ESTATEXCEPCIO)}">
        <tr id="transaccio_estatexcepcio_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ESTATEXCEPCIO])?'transaccio.estatexcepcio':__theForm.labels[TransaccioFields.ESTATEXCEPCIO]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.ESTATEXCEPCIO]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.ESTATEXCEPCIO]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="transaccio.estatexcepcio" cssClass="errorField alert alert-error" />
              <form:textarea rows="3" wrap="soft" style="overflow:auto;" cssClass="input-xxlarge" readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATEXCEPCIO)? 'true' : 'false'}" path="transaccio.estatexcepcio"  />
              <div class="btn-group" style="vertical-align: top;">
              <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown">&nbsp;<span class="caret"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#" onclick="javascript:var ta=document.getElementById('transaccio.estatexcepcio'); ta.wrap='off';" >No Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('transaccio.estatexcepcio'); ta.wrap='soft';">Soft Wrap</a></li>
                <li><a href="#" onclick="javascript:var ta=document.getElementById('transaccio.estatexcepcio'); ta.wrap='hard';">Hard Wrap</a></li>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANPIXELTYPE)}">
        <tr id="transaccio_infoscanpixeltype_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANPIXELTYPE])?'transaccio.infoscanpixeltype':__theForm.labels[TransaccioFields.INFOSCANPIXELTYPE]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANPIXELTYPE]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOSCANPIXELTYPE]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.infoscanpixeltype" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANPIXELTYPE)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANPIXELTYPE)? 'input-mini uneditable-input' : 'input-mini'}"   path="transaccio.infoscanpixeltype"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANRESOLUCIOPPP)}">
        <tr id="transaccio_infoscanresolucioppp_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANRESOLUCIOPPP])?'transaccio.infoscanresolucioppp':__theForm.labels[TransaccioFields.INFOSCANRESOLUCIOPPP]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANRESOLUCIOPPP]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOSCANRESOLUCIOPPP]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.infoscanresolucioppp" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANRESOLUCIOPPP)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANRESOLUCIOPPP)? 'input-mini uneditable-input' : 'input-mini'}"   path="transaccio.infoscanresolucioppp"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANOCR)}">
        <tr id="transaccio_infoscanocr_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANOCR])?'transaccio.infoscanocr':__theForm.labels[TransaccioFields.INFOSCANOCR]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANOCR]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOSCANOCR]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANOCR)}" >
              <form:select cssClass="input-medium" onchange="if(typeof onChangeInfoscanocr == 'function') {  onChangeInfoscanocr(this); };"  path="transaccio.infoscanocr">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANOCR)}" >
                <fmt:message key="genapp.checkbox.${__theForm.transaccio.infoscanocr}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSIGNATURAID)}">
        <tr id="transaccio_infosignaturaid_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSIGNATURAID])?'transaccio.infosignaturaid':__theForm.labels[TransaccioFields.INFOSIGNATURAID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSIGNATURAID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOSIGNATURAID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.infosignaturaid" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSIGNATURAID)}" >
          <form:hidden path="transaccio.infosignaturaid"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.infosignaturaid,__theForm.listOfInfoSignaturaForInfosignaturaid)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSIGNATURAID)}" >
          <form:select id="transaccio_infosignaturaid"  onchange="if(typeof onChangeInfosignaturaid == 'function') {  onChangeInfosignaturaid(this); };"  cssClass="input-xxlarge" path="transaccio.infosignaturaid">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfInfoSignaturaForInfosignaturaid}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOCUSTODYID)}">
        <tr id="transaccio_infocustodyid_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOCUSTODYID])?'transaccio.infocustodyid':__theForm.labels[TransaccioFields.INFOCUSTODYID]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOCUSTODYID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.INFOCUSTODYID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.infocustodyid" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOCUSTODYID)}" >
          <form:hidden path="transaccio.infocustodyid"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.infocustodyid,__theForm.listOfInfoCustodyForInfocustodyid)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOCUSTODYID)}" >
          <form:select id="transaccio_infocustodyid"  onchange="if(typeof onChangeInfocustodyid == 'function') {  onChangeInfocustodyid(this); };"  cssClass="input-xxlarge" path="transaccio.infocustodyid">
          <%-- El camp pot ser null, per la qual cosa afegim una entrada buida --%>
          <form:option value="" ></form:option>
            <c:forEach items="${__theForm.listOfInfoCustodyForInfocustodyid}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.LANGUAGEUI)}">
        <tr id="transaccio_languageui_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.LANGUAGEUI])?'transaccio.languageui':__theForm.labels[TransaccioFields.LANGUAGEUI]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.LANGUAGEUI]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.LANGUAGEUI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.languageui" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.LANGUAGEUI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.LANGUAGEUI)? 'input-small uneditable-input' : 'input-small'}"  maxlength="10" path="transaccio.languageui"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.LANGUAGEDOC)}">
        <tr id="transaccio_languagedoc_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.LANGUAGEDOC])?'transaccio.languagedoc':__theForm.labels[TransaccioFields.LANGUAGEDOC]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.LANGUAGEDOC]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.LANGUAGEDOC]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.languagedoc" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.LANGUAGEDOC)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.LANGUAGEDOC)? 'input-small uneditable-input' : 'input-small'}"  maxlength="10" path="transaccio.languagedoc"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.CIUTADANIF)}">
        <tr id="transaccio_ciutadanif_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.CIUTADANIF])?'transaccio.ciutadanif':__theForm.labels[TransaccioFields.CIUTADANIF]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.CIUTADANIF]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.CIUTADANIF]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.ciutadanif" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.CIUTADANIF)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.CIUTADANIF)? 'input-medium uneditable-input' : 'input-medium'}"  maxlength="15" path="transaccio.ciutadanif"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.CIUTADANOM)}">
        <tr id="transaccio_ciutadanom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.CIUTADANOM])?'transaccio.ciutadanom':__theForm.labels[TransaccioFields.CIUTADANOM]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.CIUTADANOM]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.CIUTADANOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.ciutadanom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.CIUTADANOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.CIUTADANOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.ciutadanom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.FUNCIONARIUSERNAME)}">
        <tr id="transaccio_funcionariusername_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.FUNCIONARIUSERNAME])?'transaccio.funcionariusername':__theForm.labels[TransaccioFields.FUNCIONARIUSERNAME]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.FUNCIONARIUSERNAME]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.FUNCIONARIUSERNAME]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.funcionariusername" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.FUNCIONARIUSERNAME)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.FUNCIONARIUSERNAME)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.funcionariusername"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.FUNCIONARINOM)}">
        <tr id="transaccio_funcionarinom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.FUNCIONARINOM])?'transaccio.funcionarinom':__theForm.labels[TransaccioFields.FUNCIONARINOM]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.FUNCIONARINOM]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.FUNCIONARINOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.funcionarinom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.FUNCIONARINOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.FUNCIONARINOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.funcionarinom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.EXPEDIENT)}">
        <tr id="transaccio_expedient_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.EXPEDIENT])?'transaccio.expedient':__theForm.labels[TransaccioFields.EXPEDIENT]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.EXPEDIENT]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.EXPEDIENT]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.expedient" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.EXPEDIENT)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.EXPEDIENT)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.expedient"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.PERFILID)}">
        <tr id="transaccio_perfilid_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.PERFILID])?'transaccio.perfilid':__theForm.labels[TransaccioFields.PERFILID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioFields.PERFILID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.PERFILID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
          <form:errors path="transaccio.perfilid" cssClass="errorField alert alert-error" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.PERFILID)}" >
          <form:hidden path="transaccio.perfilid"/>
          <input type="text" readonly="true" class="input-xxlarge uneditable-input" value="${gen:findValue(__theForm.transaccio.perfilid,__theForm.listOfPerfilForPerfilid)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.PERFILID)}" >
          <form:select id="transaccio_perfilid"  onchange="if(typeof onChangePerfilid == 'function') {  onChangePerfilid(this); };"  cssClass="input-xxlarge" path="transaccio.perfilid">
            <c:forEach items="${__theForm.listOfPerfilForPerfilid}" var="tmp">
            <form:option value="${tmp.key}" >${tmp.value}</form:option>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.USERNAMEREQUEST)}">
        <tr id="transaccio_usernameRequest_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.USERNAMEREQUEST])?'transaccio.usernameRequest':__theForm.labels[TransaccioFields.USERNAMEREQUEST]}" />
              <c:if test="${not empty __theForm.help[TransaccioFields.USERNAMEREQUEST]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.USERNAMEREQUEST]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccio.usernameRequest" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.USERNAMEREQUEST)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.USERNAMEREQUEST)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="transaccio.usernameRequest"   />

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
        
