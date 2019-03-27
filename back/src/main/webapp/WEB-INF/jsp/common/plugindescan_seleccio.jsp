<%@ page language="java" 
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp" 
%>
<style>
<%--
    body{
        background-color: #CEE3F6;
    }
    --%>
</style>

  <br/>
  <br/>
  
<div class="lead" style="margin-bottom:10px; text-align:center;">
  

  <fmt:message key="plugindescan.seleccio.title2"/>
  <br/>
  <h5 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;">
  <fmt:message key="plugindescan.seleccio.subtitle2"/>
  </h5>
  <br/>
  <%-- XYZ ZZZ
  <c:if test="fn:length(companies) eq 1" >
  <h6>
     Si no voleu que aparegui aquesta pantalla quan només hi ha un plugin, llavors anau a la <br/>
     classe <b><%= ScanWebModuleController.class.getName() %></b><br/>
     i editau el camp estatic stepSelectionWhenOnlyOnePlugin i assignau-li un valor true;
  </h6>
  </c:if>
  
   --%>
  
  <br/>
  <div class="well" style="max-width: 400px; margin: 0 auto 10px;">
  <c:forEach items="${plugins}" var="plugin">
     <button type="button" class="btn btn-large btn-block btn-primary" onclick="location.href='<c:url value="${scancontext}/showscanwebmodule/${plugin.pluginID}/${scanWebID}"/>'">
     <b>${plugin.nom}</b><br>
     <small style="color: white">
     <i>${plugin.descripcio}</i>
     </small>
     </button>
  </c:forEach>
  </div>
  
  <br/>
  
</div>
