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
        
