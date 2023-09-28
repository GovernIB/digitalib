<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="TransaccioMultipleFields" className="es.caib.digitalib.model.fields.TransaccioMultipleFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioMultipleFields.TRANSMULTIPLEID)}">
        <tr id="transaccioMultiple_transmultipleid_rowid">
          <td id="transaccioMultiple_transmultipleid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioMultipleFields.TRANSMULTIPLEID])?'transaccioMultiple.transmultipleid':__theForm.labels[TransaccioMultipleFields.TRANSMULTIPLEID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[TransaccioMultipleFields.TRANSMULTIPLEID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioMultipleFields.TRANSMULTIPLEID]}" ></i>
              </c:if>
            </td>
          <td id="transaccioMultiple_transmultipleid_columnvalueid">
            <form:errors path="transaccioMultiple.transmultipleid" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.TRANSMULTIPLEID)? 'true' : 'false'}" cssClass="w-50 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.TRANSMULTIPLEID)? ' uneditable-input' : ''}"  style=""  path="transaccioMultiple.transmultipleid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioMultipleFields.DESCRIPCIO)}">
        <tr id="transaccioMultiple_descripcio_rowid">
          <td id="transaccioMultiple_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioMultipleFields.DESCRIPCIO])?'transaccioMultiple.descripcio':__theForm.labels[TransaccioMultipleFields.DESCRIPCIO]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[TransaccioMultipleFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioMultipleFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="transaccioMultiple_descripcio_columnvalueid">
            <form:errors path="transaccioMultiple.descripcio" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.DESCRIPCIO)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.DESCRIPCIO)? ' uneditable-input' : ''}"  style="" maxlength="256" path="transaccioMultiple.descripcio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioMultipleFields.FITXERESCANEJATID)}">
        <tr id="transaccioMultiple_fitxerEscanejatID_rowid">
          <td id="transaccioMultiple_fitxerEscanejatID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioMultipleFields.FITXERESCANEJATID])?'transaccioMultiple.fitxerEscanejatID':__theForm.labels[TransaccioMultipleFields.FITXERESCANEJATID]}" />
             </label>
              <c:if test="${not empty __theForm.help[TransaccioMultipleFields.FITXERESCANEJATID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TransaccioMultipleFields.FITXERESCANEJATID]}" ></i>
              </c:if>
            </td>
          <td id="transaccioMultiple_fitxerEscanejatID_columnvalueid">
              <form:errors path="transaccioMultiple.fitxerEscanejatID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.FITXERESCANEJATID)}" >
              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.transaccioMultiple.fitxerEscanejat)}"/>">${__theForm.transaccioMultiple.fitxerEscanejat.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.FITXERESCANEJATID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.FITXERESCANEJATID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.FITXERESCANEJATID)? ' uneditable-input' : ''}"   path="fitxerEscanejatID" type="file" />
                  <label class="custom-file-label" for="fitxerEscanejatID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.transaccioMultiple.fitxerEscanejat}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.transaccioMultiple.fitxerEscanejat)}"/>">${__theForm.transaccioMultiple.fitxerEscanejat.nom}</a>
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
        
