<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PluginCridadaFields" className="es.caib.digitalib.model.fields.PluginCridadaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginCridadaFields.DATA)}">
        <tr id="pluginCridada_data_rowid">
          <td id="pluginCridada_data_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginCridadaFields.DATA])?'pluginCridada.data':__theForm.labels[PluginCridadaFields.DATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PluginCridadaFields.DATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginCridadaFields.DATA]}" ></i>
              </c:if>
            </td>
          <td id="pluginCridada_data_columnvalueid">
    <form:errors path="pluginCridada.data" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="pluginCridada_data" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.DATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#pluginCridada_data" path="pluginCridada.data" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.DATA)}" >
                    <div class="input-group-append"  data-target="#pluginCridada_data"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#pluginCridada_data').datetimepicker({
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginCridadaFields.PLUGINID)}">
        <tr id="pluginCridada_pluginID_rowid">
          <td id="pluginCridada_pluginID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginCridadaFields.PLUGINID])?'pluginCridada.pluginID':__theForm.labels[PluginCridadaFields.PLUGINID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PluginCridadaFields.PLUGINID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginCridadaFields.PLUGINID]}" ></i>
              </c:if>
            </td>
          <td id="pluginCridada_pluginID_columnvalueid">
          <form:errors path="pluginCridada.pluginID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.PLUGINID)}" >
          <form:hidden path="pluginCridada.pluginID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.pluginCridada.pluginID,__theForm.listOfPluginForPluginID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.PLUGINID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="pluginCridada_pluginID"  onchange="if(typeof onChangePluginID == 'function') {  onChangePluginID(this); };"  cssClass="form-control col-md-9-optional" path="pluginCridada.pluginID">
            <c:forEach items="${__theForm.listOfPluginForPluginID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginCridadaFields.METODEPLUGIN)}">
        <tr id="pluginCridada_metodePlugin_rowid">
          <td id="pluginCridada_metodePlugin_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginCridadaFields.METODEPLUGIN])?'pluginCridada.metodePlugin':__theForm.labels[PluginCridadaFields.METODEPLUGIN]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PluginCridadaFields.METODEPLUGIN]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginCridadaFields.METODEPLUGIN]}" ></i>
              </c:if>
            </td>
          <td id="pluginCridada_metodePlugin_columnvalueid">
            <form:errors path="pluginCridada.metodePlugin" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.METODEPLUGIN)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.METODEPLUGIN)? ' uneditable-input' : ''}"  style="" maxlength="100" path="pluginCridada.metodePlugin"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginCridadaFields.TIPUSRESULTAT)}">
        <tr id="pluginCridada_tipusResultat_rowid">
          <td id="pluginCridada_tipusResultat_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginCridadaFields.TIPUSRESULTAT])?'pluginCridada.tipusResultat':__theForm.labels[PluginCridadaFields.TIPUSRESULTAT]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PluginCridadaFields.TIPUSRESULTAT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginCridadaFields.TIPUSRESULTAT]}" ></i>
              </c:if>
            </td>
          <td id="pluginCridada_tipusResultat_columnvalueid">
          <form:errors path="pluginCridada.tipusResultat" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.TIPUSRESULTAT)}" >
          <form:hidden path="pluginCridada.tipusResultat"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.pluginCridada.tipusResultat,__theForm.listOfValuesForTipusResultat)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.TIPUSRESULTAT)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="pluginCridada_tipusResultat"  onchange="if(typeof onChangeTipusResultat == 'function') {  onChangeTipusResultat(this); };"  cssClass="form-control col-md-9-optional" path="pluginCridada.tipusResultat">
            <c:forEach items="${__theForm.listOfValuesForTipusResultat}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginCridadaFields.TEMPSEXECUCIO)}">
        <tr id="pluginCridada_tempsExecucio_rowid">
          <td id="pluginCridada_tempsExecucio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginCridadaFields.TEMPSEXECUCIO])?'pluginCridada.tempsExecucio':__theForm.labels[PluginCridadaFields.TEMPSEXECUCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[PluginCridadaFields.TEMPSEXECUCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginCridadaFields.TEMPSEXECUCIO]}" ></i>
              </c:if>
            </td>
          <td id="pluginCridada_tempsExecucio_columnvalueid">
            <form:errors path="pluginCridada.tempsExecucio" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.TEMPSEXECUCIO)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.TEMPSEXECUCIO)? ' uneditable-input' : ''}"  style=""  path="pluginCridada.tempsExecucio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginCridadaFields.USUARIPERSONAID)}">
        <tr id="pluginCridada_usuariPersonaId_rowid">
          <td id="pluginCridada_usuariPersonaId_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginCridadaFields.USUARIPERSONAID])?'pluginCridada.usuariPersonaId':__theForm.labels[PluginCridadaFields.USUARIPERSONAID]}" />
             </label>
              <c:if test="${not empty __theForm.help[PluginCridadaFields.USUARIPERSONAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginCridadaFields.USUARIPERSONAID]}" ></i>
              </c:if>
            </td>
          <td id="pluginCridada_usuariPersonaId_columnvalueid">
            <form:errors path="pluginCridada.usuariPersonaId" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.USUARIPERSONAID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.USUARIPERSONAID)? ' uneditable-input' : ''}"  style=""  path="pluginCridada.usuariPersonaId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginCridadaFields.USUARIAPLICACIOID)}">
        <tr id="pluginCridada_usuariAplicacioId_rowid">
          <td id="pluginCridada_usuariAplicacioId_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginCridadaFields.USUARIAPLICACIOID])?'pluginCridada.usuariAplicacioId':__theForm.labels[PluginCridadaFields.USUARIAPLICACIOID]}" />
             </label>
              <c:if test="${not empty __theForm.help[PluginCridadaFields.USUARIAPLICACIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginCridadaFields.USUARIAPLICACIOID]}" ></i>
              </c:if>
            </td>
          <td id="pluginCridada_usuariAplicacioId_columnvalueid">
            <form:errors path="pluginCridada.usuariAplicacioId" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.USUARIAPLICACIOID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.USUARIAPLICACIOID)? ' uneditable-input' : ''}"  style=""  path="pluginCridada.usuariAplicacioId"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginCridadaFields.PARAMETRESTEXT)}">
        <tr id="pluginCridada_parametresText_rowid">
          <td id="pluginCridada_parametresText_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginCridadaFields.PARAMETRESTEXT])?'pluginCridada.parametresText':__theForm.labels[PluginCridadaFields.PARAMETRESTEXT]}" />
             </label>
              <c:if test="${not empty __theForm.help[PluginCridadaFields.PARAMETRESTEXT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginCridadaFields.PARAMETRESTEXT]}" ></i>
              </c:if>
            </td>
          <td id="pluginCridada_parametresText_columnvalueid">
              <form:errors path="pluginCridada.parametresText" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.PARAMETRESTEXT)? 'true' : 'false'}" path="pluginCridada.parametresText"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_parametresText" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_parametresText" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('pluginCridada.parametresText'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('pluginCridada.parametresText'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('pluginCridada.parametresText'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_parametresText').on('click', function(){
					var valor = ($('#dropdownMenuContainer_parametresText').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_parametresText').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginCridadaFields.PARAMETRESFITXERID)}">
        <tr id="pluginCridada_parametresFitxerID_rowid">
          <td id="pluginCridada_parametresFitxerID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginCridadaFields.PARAMETRESFITXERID])?'pluginCridada.parametresFitxerID':__theForm.labels[PluginCridadaFields.PARAMETRESFITXERID]}" />
             </label>
              <c:if test="${not empty __theForm.help[PluginCridadaFields.PARAMETRESFITXERID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginCridadaFields.PARAMETRESFITXERID]}" ></i>
              </c:if>
            </td>
          <td id="pluginCridada_parametresFitxerID_columnvalueid">
              <form:errors path="pluginCridada.parametresFitxerID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.PARAMETRESFITXERID)}" >
              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.pluginCridada.parametresFitxer)}"/>">${__theForm.pluginCridada.parametresFitxer.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.PARAMETRESFITXERID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.PARAMETRESFITXERID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.PARAMETRESFITXERID)? ' uneditable-input' : ''}"   path="parametresFitxerID" type="file" />
                  <label class="custom-file-label" for="parametresFitxerID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.pluginCridada.parametresFitxer}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.pluginCridada.parametresFitxer)}"/>">${__theForm.pluginCridada.parametresFitxer.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="parametresFitxerIDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="parametresFitxerID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#parametresFitxerID').on('change', function(){
						var ruta = $('#parametresFitxerID').val(); 
						var rutaArray = ruta.split('\\');
						$('#parametresFitxerID-custom-file-label').css('display','block');
						$('#parametresFitxerID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginCridadaFields.RETORNTEXT)}">
        <tr id="pluginCridada_retornText_rowid">
          <td id="pluginCridada_retornText_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginCridadaFields.RETORNTEXT])?'pluginCridada.retornText':__theForm.labels[PluginCridadaFields.RETORNTEXT]}" />
             </label>
              <c:if test="${not empty __theForm.help[PluginCridadaFields.RETORNTEXT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginCridadaFields.RETORNTEXT]}" ></i>
              </c:if>
            </td>
          <td id="pluginCridada_retornText_columnvalueid">
              <form:errors path="pluginCridada.retornText" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.RETORNTEXT)? 'true' : 'false'}" path="pluginCridada.retornText"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_retornText" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_retornText" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('pluginCridada.retornText'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('pluginCridada.retornText'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('pluginCridada.retornText'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_retornText').on('click', function(){
					var valor = ($('#dropdownMenuContainer_retornText').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_retornText').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PluginCridadaFields.RETORNFITXERID)}">
        <tr id="pluginCridada_retornFitxerID_rowid">
          <td id="pluginCridada_retornFitxerID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PluginCridadaFields.RETORNFITXERID])?'pluginCridada.retornFitxerID':__theForm.labels[PluginCridadaFields.RETORNFITXERID]}" />
             </label>
              <c:if test="${not empty __theForm.help[PluginCridadaFields.RETORNFITXERID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PluginCridadaFields.RETORNFITXERID]}" ></i>
              </c:if>
            </td>
          <td id="pluginCridada_retornFitxerID_columnvalueid">
              <form:errors path="pluginCridada.retornFitxerID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.RETORNFITXERID)}" >
              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.pluginCridada.retornFitxer)}"/>">${__theForm.pluginCridada.retornFitxer.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.RETORNFITXERID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.RETORNFITXERID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,PluginCridadaFields.RETORNFITXERID)? ' uneditable-input' : ''}"   path="retornFitxerID" type="file" />
                  <label class="custom-file-label" for="retornFitxerID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.pluginCridada.retornFitxer}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.pluginCridada.retornFitxer)}"/>">${__theForm.pluginCridada.retornFitxer.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="retornFitxerIDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="retornFitxerID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#retornFitxerID').on('change', function(){
						var ruta = $('#retornFitxerID').val(); 
						var rutaArray = ruta.split('\\');
						$('#retornFitxerID-custom-file-label').css('display','block');
						$('#retornFitxerID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
