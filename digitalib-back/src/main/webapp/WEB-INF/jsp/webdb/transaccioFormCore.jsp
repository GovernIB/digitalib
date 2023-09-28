<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="TransaccioFields" className="es.caib.digitalib.model.fields.TransaccioFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.TRANSACCIOMULTIPLEID)}">
        <tr id="transaccio_transaccioMultipleID_rowid">
          <td id="transaccio_transaccioMultipleID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.TRANSACCIOMULTIPLEID])?'transaccio.transaccioMultipleID':__theForm.labels[TransaccioFields.TRANSACCIOMULTIPLEID]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.TRANSACCIOMULTIPLEID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.TRANSACCIOMULTIPLEID]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_transaccioMultipleID_columnvalueid">
          <form:errors path="transaccio.transaccioMultipleID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.TRANSACCIOMULTIPLEID)}" >
          <form:hidden path="transaccio.transaccioMultipleID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.transaccioMultipleID,__theForm.listOfTransaccioMultipleForTransaccioMultipleID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.TRANSACCIOMULTIPLEID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_transaccioMultipleID"  onchange="if(typeof onChangeTransaccioMultipleID == 'function') {  onChangeTransaccioMultipleID(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.transaccioMultipleID">
            <c:forEach items="${__theForm.listOfTransaccioMultipleForTransaccioMultipleID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.transaccio.transaccioMultipleID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.transaccio.transaccioMultipleID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.NOM)}">
        <tr id="transaccio_nom_rowid">
          <td id="transaccio_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.NOM])?'transaccio.nom':__theForm.labels[TransaccioFields.NOM]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_nom_columnvalueid">
            <form:errors path="transaccio.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.TRANSACTIONWEBID)}">
        <tr id="transaccio_transactionWebId_rowid">
          <td id="transaccio_transactionWebId_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.TRANSACTIONWEBID])?'transaccio.transactionWebId':__theForm.labels[TransaccioFields.TRANSACTIONWEBID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.TRANSACTIONWEBID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.TRANSACTIONWEBID]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_transactionWebId_columnvalueid">
            <form:errors path="transaccio.transactionWebId" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.TRANSACTIONWEBID)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.TRANSACTIONWEBID)? ' uneditable-input' : ''}"  style="" maxlength="100" path="transaccio.transactionWebId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.DATAINICI)}">
        <tr id="transaccio_dataInici_rowid">
          <td id="transaccio_dataInici_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.DATAINICI])?'transaccio.dataInici':__theForm.labels[TransaccioFields.DATAINICI]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.DATAINICI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.DATAINICI]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_dataInici_columnvalueid">
    <form:errors path="transaccio.dataInici" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="transaccio_dataInici" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAINICI)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#transaccio_dataInici" path="transaccio.dataInici" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAINICI)}" >
                    <div class="input-group-append"  data-target="#transaccio_dataInici"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#transaccio_dataInici').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.DATAFI)}">
        <tr id="transaccio_dataFi_rowid">
          <td id="transaccio_dataFi_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.DATAFI])?'transaccio.dataFi':__theForm.labels[TransaccioFields.DATAFI]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.DATAFI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.DATAFI]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_dataFi_columnvalueid">
    <form:errors path="transaccio.dataFi" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="transaccio_dataFi" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAFI)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#transaccio_dataFi" path="transaccio.dataFi" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAFI)}" >
                    <div class="input-group-append"  data-target="#transaccio_dataFi"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#transaccio_dataFi').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.USUARIAPLICACIOID)}">
        <tr id="transaccio_usuariAplicacioId_rowid">
          <td id="transaccio_usuariAplicacioId_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.USUARIAPLICACIOID])?'transaccio.usuariAplicacioId':__theForm.labels[TransaccioFields.USUARIAPLICACIOID]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.USUARIAPLICACIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.USUARIAPLICACIOID]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_usuariAplicacioId_columnvalueid">
          <form:errors path="transaccio.usuariAplicacioId" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIAPLICACIOID)}" >
          <form:hidden path="transaccio.usuariAplicacioId"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.usuariAplicacioId,__theForm.listOfValuesForUsuariAplicacioId)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIAPLICACIOID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_usuariAplicacioId"  onchange="if(typeof onChangeUsuariAplicacioId == 'function') {  onChangeUsuariAplicacioId(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.usuariAplicacioId">
            <c:forEach items="${__theForm.listOfValuesForUsuariAplicacioId}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.transaccio.usuariAplicacioId }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.transaccio.usuariAplicacioId }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.USUARIPERSONAID)}">
        <tr id="transaccio_usuariPersonaId_rowid">
          <td id="transaccio_usuariPersonaId_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.USUARIPERSONAID])?'transaccio.usuariPersonaId':__theForm.labels[TransaccioFields.USUARIPERSONAID]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.USUARIPERSONAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.USUARIPERSONAID]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_usuariPersonaId_columnvalueid">
          <form:errors path="transaccio.usuariPersonaId" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIPERSONAID)}" >
          <form:hidden path="transaccio.usuariPersonaId"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.usuariPersonaId,__theForm.listOfValuesForUsuariPersonaId)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.USUARIPERSONAID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_usuariPersonaId"  onchange="if(typeof onChangeUsuariPersonaId == 'function') {  onChangeUsuariPersonaId(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.usuariPersonaId">
            <c:forEach items="${__theForm.listOfValuesForUsuariPersonaId}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.transaccio.usuariPersonaId }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.transaccio.usuariPersonaId }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.IP)}">
        <tr id="transaccio_ip_rowid">
          <td id="transaccio_ip_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.IP])?'transaccio.ip':__theForm.labels[TransaccioFields.IP]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.IP]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.IP]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_ip_columnvalueid">
            <form:errors path="transaccio.ip" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.IP)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.IP)? ' uneditable-input' : ''}"  style="" maxlength="50" path="transaccio.ip"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.RETURNURL)}">
        <tr id="transaccio_returnUrl_rowid">
          <td id="transaccio_returnUrl_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.RETURNURL])?'transaccio.returnUrl':__theForm.labels[TransaccioFields.RETURNURL]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.RETURNURL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.RETURNURL]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_returnUrl_columnvalueid">
            <form:errors path="transaccio.returnUrl" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.RETURNURL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.RETURNURL)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.returnUrl"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ESTATCODI)}">
        <tr id="transaccio_estatCodi_rowid">
          <td id="transaccio_estatCodi_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ESTATCODI])?'transaccio.estatCodi':__theForm.labels[TransaccioFields.ESTATCODI]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ESTATCODI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ESTATCODI]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_estatCodi_columnvalueid">
          <form:errors path="transaccio.estatCodi" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATCODI)}" >
          <form:hidden path="transaccio.estatCodi"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.estatCodi,__theForm.listOfValuesForEstatCodi)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATCODI)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_estatCodi"  onchange="if(typeof onChangeEstatCodi == 'function') {  onChangeEstatCodi(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.estatCodi">
            <c:forEach items="${__theForm.listOfValuesForEstatCodi}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ESTATMISSATGE)}">
        <tr id="transaccio_estatMissatge_rowid">
          <td id="transaccio_estatMissatge_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ESTATMISSATGE])?'transaccio.estatMissatge':__theForm.labels[TransaccioFields.ESTATMISSATGE]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ESTATMISSATGE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ESTATMISSATGE]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_estatMissatge_columnvalueid">
            <form:errors path="transaccio.estatMissatge" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATMISSATGE)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATMISSATGE)? ' uneditable-input' : ''}"  style="" maxlength="3000" path="transaccio.estatMissatge"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ESTATEXCEPCIO)}">
        <tr id="transaccio_estatExcepcio_rowid">
          <td id="transaccio_estatExcepcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ESTATEXCEPCIO])?'transaccio.estatExcepcio':__theForm.labels[TransaccioFields.ESTATEXCEPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ESTATEXCEPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ESTATEXCEPCIO]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_estatExcepcio_columnvalueid">
              <form:errors path="transaccio.estatExcepcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ESTATEXCEPCIO)? 'true' : 'false'}" path="transaccio.estatExcepcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_estatExcepcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_estatExcepcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('transaccio.estatExcepcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('transaccio.estatExcepcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('transaccio.estatExcepcio'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_estatExcepcio').on('click', function(){
					var valor = ($('#dropdownMenuContainer_estatExcepcio').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_estatExcepcio').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.FITXERESCANEJATID)}">
        <tr id="transaccio_fitxerEscanejatID_rowid">
          <td id="transaccio_fitxerEscanejatID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.FITXERESCANEJATID])?'transaccio.fitxerEscanejatID':__theForm.labels[TransaccioFields.FITXERESCANEJATID]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.FITXERESCANEJATID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.FITXERESCANEJATID]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_fitxerEscanejatID_columnvalueid">
              <form:errors path="transaccio.fitxerEscanejatID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERESCANEJATID)}" >
              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.transaccio.fitxerEscanejat)}"/>">${__theForm.transaccio.fitxerEscanejat.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERESCANEJATID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERESCANEJATID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERESCANEJATID)? ' uneditable-input' : ''}"   path="fitxerEscanejatID" type="file" />
                  <label class="custom-file-label" for="fitxerEscanejatID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.transaccio.fitxerEscanejat}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.transaccio.fitxerEscanejat)}"/>">${__theForm.transaccio.fitxerEscanejat.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxerEscanejatIDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxerEscanejatID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxerEscanejatID').on('change', function(){
						var ruta = $('#fitxerEscanejatID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxerEscanejatID-custom-file-label').css('display','block');
						$('#fitxerEscanejatID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.HASHESCANEIG)}">
        <tr id="transaccio_hashEscaneig_rowid">
          <td id="transaccio_hashEscaneig_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.HASHESCANEIG])?'transaccio.hashEscaneig':__theForm.labels[TransaccioFields.HASHESCANEIG]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.HASHESCANEIG]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.HASHESCANEIG]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_hashEscaneig_columnvalueid">
            <form:errors path="transaccio.hashEscaneig" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.HASHESCANEIG)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.HASHESCANEIG)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.hashEscaneig"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.FITXERSIGNATURAID)}">
        <tr id="transaccio_fitxerSignaturaID_rowid">
          <td id="transaccio_fitxerSignaturaID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.FITXERSIGNATURAID])?'transaccio.fitxerSignaturaID':__theForm.labels[TransaccioFields.FITXERSIGNATURAID]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.FITXERSIGNATURAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.FITXERSIGNATURAID]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_fitxerSignaturaID_columnvalueid">
              <form:errors path="transaccio.fitxerSignaturaID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERSIGNATURAID)}" >
              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.transaccio.fitxerSignatura)}"/>">${__theForm.transaccio.fitxerSignatura.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERSIGNATURAID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERSIGNATURAID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.FITXERSIGNATURAID)? ' uneditable-input' : ''}"   path="fitxerSignaturaID" type="file" />
                  <label class="custom-file-label" for="fitxerSignaturaID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.transaccio.fitxerSignatura}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.transaccio.fitxerSignatura)}"/>">${__theForm.transaccio.fitxerSignatura.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxerSignaturaIDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxerSignaturaID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxerSignaturaID').on('change', function(){
						var ruta = $('#fitxerSignaturaID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxerSignaturaID-custom-file-label').css('display','block');
						$('#fitxerSignaturaID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.HASHFIRMA)}">
        <tr id="transaccio_hashFirma_rowid">
          <td id="transaccio_hashFirma_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.HASHFIRMA])?'transaccio.hashFirma':__theForm.labels[TransaccioFields.HASHFIRMA]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.HASHFIRMA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.HASHFIRMA]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_hashFirma_columnvalueid">
            <form:errors path="transaccio.hashFirma" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.HASHFIRMA)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.HASHFIRMA)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.hashFirma"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANPAPERSIZE)}">
        <tr id="transaccio_infoScanPaperSize_rowid">
          <td id="transaccio_infoScanPaperSize_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANPAPERSIZE])?'transaccio.infoScanPaperSize':__theForm.labels[TransaccioFields.INFOSCANPAPERSIZE]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANPAPERSIZE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.INFOSCANPAPERSIZE]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_infoScanPaperSize_columnvalueid">
            <form:errors path="transaccio.infoScanPaperSize" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANPAPERSIZE)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANPAPERSIZE)? ' uneditable-input' : ''}"  style="" maxlength="100" path="transaccio.infoScanPaperSize"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANPIXELTYPE)}">
        <tr id="transaccio_infoScanPixelType_rowid">
          <td id="transaccio_infoScanPixelType_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANPIXELTYPE])?'transaccio.infoScanPixelType':__theForm.labels[TransaccioFields.INFOSCANPIXELTYPE]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANPIXELTYPE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.INFOSCANPIXELTYPE]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_infoScanPixelType_columnvalueid">
          <form:errors path="transaccio.infoScanPixelType" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANPIXELTYPE)}" >
          <form:hidden path="transaccio.infoScanPixelType"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.infoScanPixelType,__theForm.listOfValuesForInfoScanPixelType)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANPIXELTYPE)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_infoScanPixelType"  onchange="if(typeof onChangeInfoScanPixelType == 'function') {  onChangeInfoScanPixelType(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.infoScanPixelType">
            <c:forEach items="${__theForm.listOfValuesForInfoScanPixelType}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.transaccio.infoScanPixelType }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.transaccio.infoScanPixelType }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANRESOLUCIOPPP)}">
        <tr id="transaccio_infoScanResolucioPpp_rowid">
          <td id="transaccio_infoScanResolucioPpp_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANRESOLUCIOPPP])?'transaccio.infoScanResolucioPpp':__theForm.labels[TransaccioFields.INFOSCANRESOLUCIOPPP]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANRESOLUCIOPPP]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.INFOSCANRESOLUCIOPPP]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_infoScanResolucioPpp_columnvalueid">
            <form:errors path="transaccio.infoScanResolucioPpp" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANRESOLUCIOPPP)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANRESOLUCIOPPP)? ' uneditable-input' : ''}"  style=""  path="transaccio.infoScanResolucioPpp"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANOCR)}">
        <tr id="transaccio_infoScanOcr_rowid">
          <td id="transaccio_infoScanOcr_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANOCR])?'transaccio.infoScanOcr':__theForm.labels[TransaccioFields.INFOSCANOCR]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANOCR]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.INFOSCANOCR]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_infoScanOcr_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANOCR)}" >
              <form:select cssClass="form-control col-md-6" onchange="if(typeof onChangeInfoScanOcr == 'function') {  onChangeInfoScanOcr(this); };"  path="transaccio.infoScanOcr">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANDUPLEX)}">
        <tr id="transaccio_infoScanDuplex_rowid">
          <td id="transaccio_infoScanDuplex_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANDUPLEX])?'transaccio.infoScanDuplex':__theForm.labels[TransaccioFields.INFOSCANDUPLEX]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANDUPLEX]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.INFOSCANDUPLEX]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_infoScanDuplex_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANDUPLEX)}" >
              <form:select cssClass="form-control col-md-6" onchange="if(typeof onChangeInfoScanDuplex == 'function') {  onChangeInfoScanDuplex(this); };"  path="transaccio.infoScanDuplex">
                <form:option value=""><fmt:message key="genapp.checkbox." /></form:option>
                <form:option value="true" ><fmt:message key="genapp.checkbox.true" /></form:option>
                <form:option value="false" ><fmt:message key="genapp.checkbox.false" /></form:option>
              </form:select>
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANDUPLEX)}" >
                <fmt:message key="genapp.checkbox.${__theForm.transaccio.infoScanDuplex}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANDATACAPTURA)}">
        <tr id="transaccio_infoScanDataCaptura_rowid">
          <td id="transaccio_infoScanDataCaptura_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANDATACAPTURA])?'transaccio.infoScanDataCaptura':__theForm.labels[TransaccioFields.INFOSCANDATACAPTURA]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANDATACAPTURA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.INFOSCANDATACAPTURA]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_infoScanDataCaptura_columnvalueid">
    <form:errors path="transaccio.infoScanDataCaptura" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="transaccio_infoScanDataCaptura" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANDATACAPTURA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#transaccio_infoScanDataCaptura" path="transaccio.infoScanDataCaptura" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANDATACAPTURA)}" >
                    <div class="input-group-append"  data-target="#transaccio_infoScanDataCaptura"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#transaccio_infoScanDataCaptura').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANLANGUAGEDOC)}">
        <tr id="transaccio_infoScanLanguageDoc_rowid">
          <td id="transaccio_infoScanLanguageDoc_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANLANGUAGEDOC])?'transaccio.infoScanLanguageDoc':__theForm.labels[TransaccioFields.INFOSCANLANGUAGEDOC]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANLANGUAGEDOC]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.INFOSCANLANGUAGEDOC]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_infoScanLanguageDoc_columnvalueid">
          <form:errors path="transaccio.infoScanLanguageDoc" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANLANGUAGEDOC)}" >
          <form:hidden path="transaccio.infoScanLanguageDoc"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.infoScanLanguageDoc,__theForm.listOfValuesForInfoScanLanguageDoc)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANLANGUAGEDOC)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_infoScanLanguageDoc"  onchange="if(typeof onChangeInfoScanLanguageDoc == 'function') {  onChangeInfoScanLanguageDoc(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.infoScanLanguageDoc">
            <c:forEach items="${__theForm.listOfValuesForInfoScanLanguageDoc}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.transaccio.infoScanLanguageDoc }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.transaccio.infoScanLanguageDoc }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSCANDOCUMENTTIPUS)}">
        <tr id="transaccio_infoScanDocumentTipus_rowid">
          <td id="transaccio_infoScanDocumentTipus_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSCANDOCUMENTTIPUS])?'transaccio.infoScanDocumentTipus':__theForm.labels[TransaccioFields.INFOSCANDOCUMENTTIPUS]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSCANDOCUMENTTIPUS]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.INFOSCANDOCUMENTTIPUS]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_infoScanDocumentTipus_columnvalueid">
          <form:errors path="transaccio.infoScanDocumentTipus" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANDOCUMENTTIPUS)}" >
          <form:hidden path="transaccio.infoScanDocumentTipus"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.infoScanDocumentTipus,__theForm.listOfValuesForInfoScanDocumentTipus)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSCANDOCUMENTTIPUS)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_infoScanDocumentTipus"  onchange="if(typeof onChangeInfoScanDocumentTipus == 'function') {  onChangeInfoScanDocumentTipus(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.infoScanDocumentTipus">
            <c:forEach items="${__theForm.listOfValuesForInfoScanDocumentTipus}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.transaccio.infoScanDocumentTipus }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.transaccio.infoScanDocumentTipus }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.VIEW)}">
        <tr id="transaccio_view_rowid">
          <td id="transaccio_view_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.VIEW])?'transaccio.view':__theForm.labels[TransaccioFields.VIEW]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.VIEW]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.VIEW]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_view_columnvalueid">
          <form:errors path="transaccio.view" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.VIEW)}" >
          <form:hidden path="transaccio.view"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.view,__theForm.listOfValuesForView)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.VIEW)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_view"  onchange="if(typeof onChangeView == 'function') {  onChangeView(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.view">
            <c:forEach items="${__theForm.listOfValuesForView}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.LANGUAGEUI)}">
        <tr id="transaccio_languageUI_rowid">
          <td id="transaccio_languageUI_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.LANGUAGEUI])?'transaccio.languageUI':__theForm.labels[TransaccioFields.LANGUAGEUI]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.LANGUAGEUI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.LANGUAGEUI]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_languageUI_columnvalueid">
            <form:errors path="transaccio.languageUI" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.LANGUAGEUI)? 'true' : 'false'}" cssClass="w-50 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.LANGUAGEUI)? ' uneditable-input' : ''}"  style="" maxlength="10" path="transaccio.languageUI"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.FUNCIONARIUSERNAME)}">
        <tr id="transaccio_funcionariUsername_rowid">
          <td id="transaccio_funcionariUsername_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.FUNCIONARIUSERNAME])?'transaccio.funcionariUsername':__theForm.labels[TransaccioFields.FUNCIONARIUSERNAME]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.FUNCIONARIUSERNAME]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.FUNCIONARIUSERNAME]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_funcionariUsername_columnvalueid">
            <form:errors path="transaccio.funcionariUsername" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.FUNCIONARIUSERNAME)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.FUNCIONARIUSERNAME)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.funcionariUsername"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.SIGNPARAMFUNCIONARINOM)}">
        <tr id="transaccio_signParamFuncionariNom_rowid">
          <td id="transaccio_signParamFuncionariNom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.SIGNPARAMFUNCIONARINOM])?'transaccio.signParamFuncionariNom':__theForm.labels[TransaccioFields.SIGNPARAMFUNCIONARINOM]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.SIGNPARAMFUNCIONARINOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.SIGNPARAMFUNCIONARINOM]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_signParamFuncionariNom_columnvalueid">
            <form:errors path="transaccio.signParamFuncionariNom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMFUNCIONARINOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMFUNCIONARINOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.signParamFuncionariNom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.SIGNPARAMFUNCIONARINIF)}">
        <tr id="transaccio_signParamFuncionariNif_rowid">
          <td id="transaccio_signParamFuncionariNif_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.SIGNPARAMFUNCIONARINIF])?'transaccio.signParamFuncionariNif':__theForm.labels[TransaccioFields.SIGNPARAMFUNCIONARINIF]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.SIGNPARAMFUNCIONARINIF]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.SIGNPARAMFUNCIONARINIF]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_signParamFuncionariNif_columnvalueid">
            <form:errors path="transaccio.signParamFuncionariNif" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMFUNCIONARINIF)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMFUNCIONARINIF)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.signParamFuncionariNif"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.SIGNPARAMFUNCIONARIDIR3)}">
        <tr id="transaccio_signParamFuncionariDir3_rowid">
          <td id="transaccio_signParamFuncionariDir3_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.SIGNPARAMFUNCIONARIDIR3])?'transaccio.signParamFuncionariDir3':__theForm.labels[TransaccioFields.SIGNPARAMFUNCIONARIDIR3]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.SIGNPARAMFUNCIONARIDIR3]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.SIGNPARAMFUNCIONARIDIR3]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_signParamFuncionariDir3_columnvalueid">
            <form:errors path="transaccio.signParamFuncionariDir3" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMFUNCIONARIDIR3)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.SIGNPARAMFUNCIONARIDIR3)? ' uneditable-input' : ''}"  style="" maxlength="100" path="transaccio.signParamFuncionariDir3"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMDOCESTATELABORA)}">
        <tr id="transaccio_arxiuReqParamDocEstatElabora_rowid">
          <td id="transaccio_arxiuReqParamDocEstatElabora_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMDOCESTATELABORA])?'transaccio.arxiuReqParamDocEstatElabora':__theForm.labels[TransaccioFields.ARXIUREQPARAMDOCESTATELABORA]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMDOCESTATELABORA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMDOCESTATELABORA]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_arxiuReqParamDocEstatElabora_columnvalueid">
          <form:errors path="transaccio.arxiuReqParamDocEstatElabora" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMDOCESTATELABORA)}" >
          <form:hidden path="transaccio.arxiuReqParamDocEstatElabora"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.arxiuReqParamDocEstatElabora,__theForm.listOfValuesForArxiuReqParamDocEstatElabora)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMDOCESTATELABORA)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_arxiuReqParamDocEstatElabora"  onchange="if(typeof onChangeArxiuReqParamDocEstatElabora == 'function') {  onChangeArxiuReqParamDocEstatElabora(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.arxiuReqParamDocEstatElabora">
            <c:forEach items="${__theForm.listOfValuesForArxiuReqParamDocEstatElabora}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.transaccio.arxiuReqParamDocEstatElabora }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.transaccio.arxiuReqParamDocEstatElabora }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMORIGEN)}">
        <tr id="transaccio_arxiuReqParamOrigen_rowid">
          <td id="transaccio_arxiuReqParamOrigen_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMORIGEN])?'transaccio.arxiuReqParamOrigen':__theForm.labels[TransaccioFields.ARXIUREQPARAMORIGEN]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMORIGEN]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMORIGEN]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_arxiuReqParamOrigen_columnvalueid">
          <form:errors path="transaccio.arxiuReqParamOrigen" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMORIGEN)}" >
          <form:hidden path="transaccio.arxiuReqParamOrigen"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.arxiuReqParamOrigen,__theForm.listOfValuesForArxiuReqParamOrigen)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMORIGEN)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_arxiuReqParamOrigen"  onchange="if(typeof onChangeArxiuReqParamOrigen == 'function') {  onChangeArxiuReqParamOrigen(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.arxiuReqParamOrigen">
            <c:forEach items="${__theForm.listOfValuesForArxiuReqParamOrigen}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.transaccio.arxiuReqParamOrigen }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.transaccio.arxiuReqParamOrigen }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMINTERESSATS)}">
        <tr id="transaccio_arxiuReqParamInteressats_rowid">
          <td id="transaccio_arxiuReqParamInteressats_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMINTERESSATS])?'transaccio.arxiuReqParamInteressats':__theForm.labels[TransaccioFields.ARXIUREQPARAMINTERESSATS]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMINTERESSATS]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMINTERESSATS]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_arxiuReqParamInteressats_columnvalueid">
            <form:errors path="transaccio.arxiuReqParamInteressats" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMINTERESSATS)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMINTERESSATS)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.arxiuReqParamInteressats"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMCIUTADANIF)}">
        <tr id="transaccio_arxiuReqParamCiutadaNif_rowid">
          <td id="transaccio_arxiuReqParamCiutadaNif_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMCIUTADANIF])?'transaccio.arxiuReqParamCiutadaNif':__theForm.labels[TransaccioFields.ARXIUREQPARAMCIUTADANIF]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMCIUTADANIF]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMCIUTADANIF]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_arxiuReqParamCiutadaNif_columnvalueid">
            <form:errors path="transaccio.arxiuReqParamCiutadaNif" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMCIUTADANIF)? 'true' : 'false'}" cssClass="w-50 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMCIUTADANIF)? ' uneditable-input' : ''}"  style="" maxlength="15" path="transaccio.arxiuReqParamCiutadaNif"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMCIUTADANOM)}">
        <tr id="transaccio_arxiuReqParamCiutadaNom_rowid">
          <td id="transaccio_arxiuReqParamCiutadaNom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMCIUTADANOM])?'transaccio.arxiuReqParamCiutadaNom':__theForm.labels[TransaccioFields.ARXIUREQPARAMCIUTADANOM]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMCIUTADANOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMCIUTADANOM]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_arxiuReqParamCiutadaNom_columnvalueid">
            <form:errors path="transaccio.arxiuReqParamCiutadaNom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMCIUTADANOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMCIUTADANOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.arxiuReqParamCiutadaNom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUREQPARAMORGANS)}">
        <tr id="transaccio_arxiuReqParamOrgans_rowid">
          <td id="transaccio_arxiuReqParamOrgans_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUREQPARAMORGANS])?'transaccio.arxiuReqParamOrgans':__theForm.labels[TransaccioFields.ARXIUREQPARAMORGANS]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUREQPARAMORGANS]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ARXIUREQPARAMORGANS]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_arxiuReqParamOrgans_columnvalueid">
            <form:errors path="transaccio.arxiuReqParamOrgans" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMORGANS)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUREQPARAMORGANS)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.arxiuReqParamOrgans"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI)}">
        <tr id="transaccio_arxiuOptParamProcedimentCodi_rowid">
          <td id="transaccio_arxiuOptParamProcedimentCodi_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI])?'transaccio.arxiuOptParamProcedimentCodi':__theForm.labels[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_arxiuOptParamProcedimentCodi_columnvalueid">
            <form:errors path="transaccio.arxiuOptParamProcedimentCodi" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTCODI)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.arxiuOptParamProcedimentCodi"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM)}">
        <tr id="transaccio_arxiuOptParamProcedimentNom_rowid">
          <td id="transaccio_arxiuOptParamProcedimentNom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM])?'transaccio.arxiuOptParamProcedimentNom':__theForm.labels[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_arxiuOptParamProcedimentNom_columnvalueid">
            <form:errors path="transaccio.arxiuOptParamProcedimentNom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMPROCEDIMENTNOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.arxiuOptParamProcedimentNom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL)}">
        <tr id="transaccio_arxiuOptParamSerieDocumental_rowid">
          <td id="transaccio_arxiuOptParamSerieDocumental_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL])?'transaccio.arxiuOptParamSerieDocumental':__theForm.labels[TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_arxiuOptParamSerieDocumental_columnvalueid">
            <form:errors path="transaccio.arxiuOptParamSerieDocumental" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMSERIEDOCUMENTAL)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.arxiuOptParamSerieDocumental"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID)}">
        <tr id="transaccio_arxiuOptParamCustodyOrExpedientId_rowid">
          <td id="transaccio_arxiuOptParamCustodyOrExpedientId_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID])?'transaccio.arxiuOptParamCustodyOrExpedientId':__theForm.labels[TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_arxiuOptParamCustodyOrExpedientId_columnvalueid">
            <form:errors path="transaccio.arxiuOptParamCustodyOrExpedientId" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioFields.ARXIUOPTPARAMCUSTODYOREXPEDIENTID)? ' uneditable-input' : ''}"  style="" maxlength="255" path="transaccio.arxiuOptParamCustodyOrExpedientId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.PERFILID)}">
        <tr id="transaccio_perfilID_rowid">
          <td id="transaccio_perfilID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.PERFILID])?'transaccio.perfilID':__theForm.labels[TransaccioFields.PERFILID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.PERFILID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.PERFILID]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_perfilID_columnvalueid">
          <form:errors path="transaccio.perfilID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.PERFILID)}" >
          <form:hidden path="transaccio.perfilID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.perfilID,__theForm.listOfPerfilForPerfilID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.PERFILID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_perfilID"  onchange="if(typeof onChangePerfilID == 'function') {  onChangePerfilID(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.perfilID">
            <c:forEach items="${__theForm.listOfPerfilForPerfilID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOSIGNATURAID)}">
        <tr id="transaccio_infoSignaturaID_rowid">
          <td id="transaccio_infoSignaturaID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOSIGNATURAID])?'transaccio.infoSignaturaID':__theForm.labels[TransaccioFields.INFOSIGNATURAID]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOSIGNATURAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.INFOSIGNATURAID]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_infoSignaturaID_columnvalueid">
          <form:errors path="transaccio.infoSignaturaID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSIGNATURAID)}" >
          <form:hidden path="transaccio.infoSignaturaID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.infoSignaturaID,__theForm.listOfInfoSignaturaForInfoSignaturaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOSIGNATURAID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_infoSignaturaID"  onchange="if(typeof onChangeInfoSignaturaID == 'function') {  onChangeInfoSignaturaID(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.infoSignaturaID">
            <c:forEach items="${__theForm.listOfInfoSignaturaForInfoSignaturaID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.transaccio.infoSignaturaID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.transaccio.infoSignaturaID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.INFOCUSTODYID)}">
        <tr id="transaccio_infoCustodyID_rowid">
          <td id="transaccio_infoCustodyID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.INFOCUSTODYID])?'transaccio.infoCustodyID':__theForm.labels[TransaccioFields.INFOCUSTODYID]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioFields.INFOCUSTODYID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioFields.INFOCUSTODYID]}" ></i>
              </c:if>
            </td>
          <td id="transaccio_infoCustodyID_columnvalueid">
          <form:errors path="transaccio.infoCustodyID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOCUSTODYID)}" >
          <form:hidden path="transaccio.infoCustodyID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.transaccio.infoCustodyID,__theForm.listOfInfoCustodyForInfoCustodyID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.INFOCUSTODYID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="transaccio_infoCustodyID"  onchange="if(typeof onChangeInfoCustodyID == 'function') {  onChangeInfoCustodyID(this); };"  cssClass="form-control col-md-9-optional" path="transaccio.infoCustodyID">
            <c:forEach items="${__theForm.listOfInfoCustodyForInfoCustodyID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.transaccio.infoCustodyID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.transaccio.infoCustodyID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
