<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="TransaccioMultipleFields" className="es.caib.digitalib.model.fields.TransaccioMultipleFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioMultipleFields.TRANSMULTIPLEID)}">
        <tr id="transaccioMultiple_transmultipleid_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioMultipleFields.TRANSMULTIPLEID])?'transaccioMultiple.transmultipleid':__theForm.labels[TransaccioMultipleFields.TRANSMULTIPLEID]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioMultipleFields.TRANSMULTIPLEID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioMultipleFields.TRANSMULTIPLEID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccioMultiple.transmultipleid" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.TRANSMULTIPLEID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.TRANSMULTIPLEID)? 'input-large uneditable-input' : 'input-large'}"   path="transaccioMultiple.transmultipleid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioMultipleFields.DESCRIPCIO)}">
        <tr id="transaccioMultiple_descripcio_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioMultipleFields.DESCRIPCIO])?'transaccioMultiple.descripcio':__theForm.labels[TransaccioMultipleFields.DESCRIPCIO]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioMultipleFields.DESCRIPCIO]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioMultipleFields.DESCRIPCIO]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="transaccioMultiple.descripcio" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.DESCRIPCIO)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.DESCRIPCIO)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="256" path="transaccioMultiple.descripcio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioMultipleFields.FITXERESCANEJATID)}">
        <tr id="transaccioMultiple_fitxerEscanejatID_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioMultipleFields.FITXERESCANEJATID])?'transaccioMultiple.fitxerEscanejatID':__theForm.labels[TransaccioMultipleFields.FITXERESCANEJATID]}" />
              <c:if test="${not empty __theForm.help[TransaccioMultipleFields.FITXERESCANEJATID]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioMultipleFields.FITXERESCANEJATID]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="transaccioMultiple.fitxerEscanejatID" cssClass="errorField alert alert-error" />
              <div class="fileupload fileupload-new" data-provides="fileupload" style="margin-bottom: 0px">
                <div class="input-append">
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.FITXERESCANEJATID)}" >
                    <div class="uneditable-input span3">
                      <i class="icon-file fileupload-exists"></i>
                      <span class="fileupload-preview"></span>
                    </div>
                    <span class="btn btn-file">
                      <span class="fileupload-new"><fmt:message key="genapp.form.file.select"/></span>
                      <span class="fileupload-exists"><fmt:message key="genapp.form.file.change"/></span>
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.FITXERESCANEJATID)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.FITXERESCANEJATID)? 'input uneditable-input' : 'input'}"  path="fitxerEscanejatID" type="file" />
                    </span>
                    <a href="#" class="btn fileupload-exists" data-dismiss="fileupload"><fmt:message key="genapp.form.file.unselect"/></a>
                    <span class="add-on">&nbsp;</span>
                </c:if>
                <c:if test="${not empty __theForm.transaccioMultiple.fitxerEscanejat}">
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioMultipleFields.FITXERESCANEJATID)}" >
                    <span class="add-on">
                        <form:checkbox path="fitxerEscanejatIDDelete"/>
                        <fmt:message key="genapp.form.file.delete"/>
                    </span>
                    <span class="add-on">&nbsp;</span>   
                </c:if>
                    <span class="add-on">
                        <a target="_blank" href="<c:url value="${dib:fileUrl(__theForm.transaccioMultiple.fitxerEscanejat)}"/>">${__theForm.transaccioMultiple.fitxerEscanejat.nom}</a>
                    </span>
                </c:if>
                </div>
              </div>
           </td>
        </tr>
        </c:if>
        
