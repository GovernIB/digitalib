<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="TransaccioFields" className="es.caib.digitalib.model.fields.TransaccioFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,TransaccioFields.DATAINICI)}">
        <tr id="transaccio_datainici_rowid">
          <td>
            <label>
              <fmt:message key="${(empty __theForm.labels[TransaccioFields.DATAINICI])?'transaccio.datainici':__theForm.labels[TransaccioFields.DATAINICI]}" /> &nbsp;(*)
              <c:if test="${not empty __theForm.help[TransaccioFields.DATAINICI]}">
              <i class="icon-info-sign" title="${__theForm.help[TransaccioFields.DATAINICI]}" ></i>
              </c:if>
             </label>
            </td>
            <td>
              <form:errors path="transaccio.datainici" cssClass="errorField alert alert-error" />
              <div id="datainici" class="input-append">
                <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAINICI)? 'true' : 'false'}" cssClass="${gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAINICI)? 'input-medium uneditable-input' : 'input-medium'}"  path="transaccio.datainici" />
                <c:if test="${!gen:contains(__theForm.readOnlyFields ,TransaccioFields.DATAINICI)}" >
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </c:if>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#datainici').datetimepicker({
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
        
