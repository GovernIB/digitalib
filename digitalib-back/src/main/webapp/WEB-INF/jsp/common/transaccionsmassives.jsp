<%@page import="es.caib.digitalib.back.controller.all.FirmaArxiuParametersPublicController"%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<%@include file="../webdb/transaccioFormTitle.jsp"%>

<table border=0>

  <tr>
    <td><form:form modelAttribute="transaccioForm" method="POST"
        enctype="multipart/form-data">

        <c:set var="contexte" value="${transaccioForm.contexte}" />
        <form:hidden path="nou" />

        <%@include file="../webdb/transaccioFormCorePre.jsp"%>
        <%@include file="../webdb/transaccioFormCore.jsp"%>

        <%@include file="../webdb/transaccioFormCorePost.jsp"%>

        <%@include file="../webdb/transaccioFormButtons.jsp"%>

        <%@include file="../webdbmodificable/transaccioFormModificable.jsp"%>

        <input type="hidden" name="eliminarpaginaenblanc" id="eliminarpaginaenblanc" value="false"/>
        

      </form:form></td>

    <td>

      <div style="margin: 10px; padding: 15px;">
        <div id="waitMessage">
          <%-- XYZ ZZZ  Traduir 
          <font size="2" color="red"> Please wait for the image to load
            completely... </font>--%>
            <img  src="<c:url value="/img/spinner_40.gif"/>" />
            
        </div>
        <%--  <c:url value="${thumbnailPDF}"/> XYZ ZZZ --%>
        <c:if test="${empty thumbnailPDF}" >
          <img style="height: 300px;border: 1px solid #000; padding: 2px;" src="<%=request.getContextPath()%>${contexte}<%=FirmaArxiuParametersPublicController.THUMBNAIL_PDF_MASSIVE%>/${transaccioForm.transaccio.transactionWebId}"
          alt="Thumbnail PDF" onload="imageLoaded();" />
        </c:if>
        
        <c:if test="${not empty thumbnailPDF}" >
          <img style="height: 300px;border: 1px solid #000; padding: 2px;" src="<c:url value="${thumbnailPDF}"/>" alt="Thumbnail PDF" onload="imageLoaded();" />
        </c:if>
        
          
        <script type="text/javascript">
            function imageLoaded() {
              var element = document.getElementById('waitMessage');
              element.style.cssText = 'display:none;';
            }
            
            function eliminarPrimeraPagina() {
              document.getElementById("eliminarpaginaenblanc").value = "true";
              var form = document.getElementById("transaccioForm");
              form.submit();
            }
            
        </script>
      </div>
    </td>
</table>