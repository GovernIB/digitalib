  <c:if test="${empty metadadaItems}">
     <%@include file="metadadaListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty metadadaItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="metadadaListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="metadadaListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="metadadaListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="metadada" items="${metadadaItems}">

        <tr id="metadada_rowid_${metadada.metadadaid}">
          <%@include file="metadadaListCoreMultipleSelect.jsp" %>

          <%@include file="metadadaListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="metadadaListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  