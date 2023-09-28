  <c:if test="${empty configuracioFirmaItems}">
     <%@include file="configuracioFirmaListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty configuracioFirmaItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="configuracioFirmaListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="configuracioFirmaListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="configuracioFirmaListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="configuracioFirma" items="${configuracioFirmaItems}">

        <tr id="configuracioFirma_rowid_${configuracioFirma.configuracioFirmaID}">
          <%@include file="configuracioFirmaListCoreMultipleSelect.jsp" %>

          <%@include file="configuracioFirmaListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="configuracioFirmaListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
