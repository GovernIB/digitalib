<%@ page language="java" 
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp" 
%>
<h3 class="tabs_involved">
  &nbsp;&nbsp;&nbsp;<fmt:message key="scan.proces" />
</h3>
  
<form:form modelAttribute="scanWebConfigForm" method="post"  enctype="multipart/form-data">
 
  <div style="margin:20px 20px 20px 20px;" style="width:auto;">

  <div class="module_content" style="width:auto;">
    <div class="tab_container" style="width:auto;">
    
    <table class="tdformlabel table-condensed table table-bordered marTop10" style="width:auto;" > 
    <tbody>      

        <tr>
          <td><label>Tipus &nbsp;(*)</label></td>
            <td>
              <form:errors path="type" cssClass="errorField alert alert-error" />
              <form:select path="type">
                <c:forEach items="${supportedTypes}" var="tipus">
                   <form:option value="${tipus}">${tipus}</form:option>
                </c:forEach>
              </form:select>
           </td>
         </tr>
         
         
         <tr>
          <td><label>Caracteristiques &nbsp;(*)</label></td>
            <td>
              <form:errors path="type" cssClass="errorField alert alert-error" />
                <c:forEach items="${supportedFlags}" var="flag">
                   &nbsp;&nbsp;&nbsp;<form:checkbox path="flags" value="${flag}"/>${flag}
                </c:forEach>
                <br/>
                <i><small>Nota: si no selecciona cap caracter&iacute;stica llavors s'acceptar&agrave; la primera que suporti el plugin</small></i>
           </td>
         </tr>
         
        

         <tr>
          <td><label>Mode &nbsp;(*)</label></td>
            <td>
              <form:errors path="mode" cssClass="errorField alert alert-error" />
              <form:radiobutton path="mode" value="S"/>S&iacute;ncron.
               &nbsp; &nbsp;
              <form:radiobutton path="mode" value="F"/>As&iacute;ncron.
           </td>
         </tr>
         
         <tr>
          <td><label>Idioma UI &nbsp;(*)</label></td>
            <td>
          <form:errors path="langUI" cssClass="errorField alert alert-error" />
          <form:select path="langUI">
            <form:option value="ca" selected="true" >Catal&agrave;</form:option>
            <form:option value="es" >Castell&agrave;</form:option>
          </form:select>
           </td>
         </tr>
     </tbody>
    </table>
    
    </div>
    
    <center>
      <input id="submitbutton" type="submit" class="btn btn-primary" value="<fmt:message key="escanejar"/>">
    </center>

   <form:hidden id="id" path="id" />
   
   </div>
   
   </div>
  
</form:form>


