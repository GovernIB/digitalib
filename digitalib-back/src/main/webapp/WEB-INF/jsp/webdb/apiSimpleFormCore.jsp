<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ApiSimpleFields" className="es.caib.digitalib.model.fields.ApiSimpleFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,ApiSimpleFields.NOM)}">
        <tr id="apiSimple_nom_rowid">
          <td id="apiSimple_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ApiSimpleFields.NOM])?'apiSimple.nom':__theForm.labels[ApiSimpleFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ApiSimpleFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ApiSimpleFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="apiSimple_nom_columnvalueid">
            <form:errors path="apiSimple.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="apiSimple.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ApiSimpleFields.URL)}">
        <tr id="apiSimple_url_rowid">
          <td id="apiSimple_url_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ApiSimpleFields.URL])?'apiSimple.url':__theForm.labels[ApiSimpleFields.URL]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ApiSimpleFields.URL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ApiSimpleFields.URL]}" ></i>
              </c:if>
            </td>
          <td id="apiSimple_url_columnvalueid">
           <c:if test="${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.URL)}">

             <c:if test="${ not empty __theForm.apiSimple.url}">
               <a href="${__theForm.apiSimple.url}" target="_blank">${__theForm.apiSimple.url}</a>

             </c:if>
           </c:if>

           <c:if test="${not (gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.URL))}">

            <form:errors path="apiSimple.url" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.URL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.URL)? ' uneditable-input' : ''}"  style="" maxlength="255" path="apiSimple.url"   />

           </c:if>

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ApiSimpleFields.USERNAME)}">
        <tr id="apiSimple_username_rowid">
          <td id="apiSimple_username_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ApiSimpleFields.USERNAME])?'apiSimple.username':__theForm.labels[ApiSimpleFields.USERNAME]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ApiSimpleFields.USERNAME]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ApiSimpleFields.USERNAME]}" ></i>
              </c:if>
            </td>
          <td id="apiSimple_username_columnvalueid">
            <form:errors path="apiSimple.username" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.USERNAME)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.USERNAME)? ' uneditable-input' : ''}"  style="" maxlength="255" path="apiSimple.username"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ApiSimpleFields.CONTRASENYA)}">
        <tr id="apiSimple_contrasenya_rowid">
          <td id="apiSimple_contrasenya_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ApiSimpleFields.CONTRASENYA])?'apiSimple.contrasenya':__theForm.labels[ApiSimpleFields.CONTRASENYA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ApiSimpleFields.CONTRASENYA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ApiSimpleFields.CONTRASENYA]}" ></i>
              </c:if>
            </td>
          <td id="apiSimple_contrasenya_columnvalueid">
            <form:errors path="apiSimple.contrasenya" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.CONTRASENYA)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.CONTRASENYA)? ' uneditable-input' : ''}"  style="" maxlength="255" path="apiSimple.contrasenya"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ApiSimpleFields.PERFIL)}">
        <tr id="apiSimple_perfil_rowid">
          <td id="apiSimple_perfil_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ApiSimpleFields.PERFIL])?'apiSimple.perfil':__theForm.labels[ApiSimpleFields.PERFIL]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ApiSimpleFields.PERFIL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ApiSimpleFields.PERFIL]}" ></i>
              </c:if>
            </td>
          <td id="apiSimple_perfil_columnvalueid">
            <form:errors path="apiSimple.perfil" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.PERFIL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.PERFIL)? ' uneditable-input' : ''}"  style="" maxlength="255" path="apiSimple.perfil"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ApiSimpleFields.CONFIGDEFIRMA)}">
        <tr id="apiSimple_configDeFirma_rowid">
          <td id="apiSimple_configDeFirma_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ApiSimpleFields.CONFIGDEFIRMA])?'apiSimple.configDeFirma':__theForm.labels[ApiSimpleFields.CONFIGDEFIRMA]}" />
             </label>
              <c:if test="${not empty __theForm.help[ApiSimpleFields.CONFIGDEFIRMA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ApiSimpleFields.CONFIGDEFIRMA]}" ></i>
              </c:if>
            </td>
          <td id="apiSimple_configDeFirma_columnvalueid">
            <form:errors path="apiSimple.configDeFirma" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.CONFIGDEFIRMA)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,ApiSimpleFields.CONFIGDEFIRMA)? ' uneditable-input' : ''}"  style="" maxlength="100" path="apiSimple.configDeFirma"   />

           </td>
        </tr>
        </c:if>
        
