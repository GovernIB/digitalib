<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ApiSimpleFields" className="es.caib.digitalib.model.fields.ApiSimpleFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,ApiSimpleFields.NOM)}">
        <tr id="apiSimple_nom_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ApiSimpleFields.NOM])?'apiSimple.nom':__theForm.labels[ApiSimpleFields.NOM]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ApiSimpleFields.NOM]}">
              <i class="icon-info-sign" title="${__theForm.help[ApiSimpleFields.NOM]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="apiSimple.nom" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.NOM)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.NOM)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="apiSimple.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ApiSimpleFields.URL)}">
        <tr id="apiSimple_url_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ApiSimpleFields.URL])?'apiSimple.url':__theForm.labels[ApiSimpleFields.URL]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ApiSimpleFields.URL]}">
              <i class="icon-info-sign" title="${__theForm.help[ApiSimpleFields.URL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
           <c:if test="${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.URL)}">

             <c:if test="${ not empty __theForm.apiSimple.url}">
               <a href="${__theForm.apiSimple.url}" target="_blank">${__theForm.apiSimple.url}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.URL))}">

            <form:errors path="apiSimple.url" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.URL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.URL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="apiSimple.url"   />

           </c:if>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ApiSimpleFields.USERNAME)}">
        <tr id="apiSimple_username_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ApiSimpleFields.USERNAME])?'apiSimple.username':__theForm.labels[ApiSimpleFields.USERNAME]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ApiSimpleFields.USERNAME]}">
              <i class="icon-info-sign" title="${__theForm.help[ApiSimpleFields.USERNAME]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="apiSimple.username" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.USERNAME)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.USERNAME)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="apiSimple.username"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ApiSimpleFields.CONTRASENYA)}">
        <tr id="apiSimple_contrasenya_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ApiSimpleFields.CONTRASENYA])?'apiSimple.contrasenya':__theForm.labels[ApiSimpleFields.CONTRASENYA]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ApiSimpleFields.CONTRASENYA]}">
              <i class="icon-info-sign" title="${__theForm.help[ApiSimpleFields.CONTRASENYA]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="apiSimple.contrasenya" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.CONTRASENYA)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.CONTRASENYA)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="apiSimple.contrasenya"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ApiSimpleFields.PERFIL)}">
        <tr id="apiSimple_perfil_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[ApiSimpleFields.PERFIL])?'apiSimple.perfil':__theForm.labels[ApiSimpleFields.PERFIL]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[ApiSimpleFields.PERFIL]}">
              <i class="icon-info-sign" title="${__theForm.help[ApiSimpleFields.PERFIL]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
            <form:errors path="apiSimple.perfil" cssClass="errorField alert alert-error" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.PERFIL)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.PERFIL)? 'input-xxlarge uneditable-input' : 'input-xxlarge'}"  maxlength="255" path="apiSimple.perfil"   />

           </td>
        </tr>
        </c:if>
        
