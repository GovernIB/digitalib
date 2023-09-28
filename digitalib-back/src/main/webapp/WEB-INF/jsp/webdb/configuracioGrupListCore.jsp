  <c:if test="${empty configuracioGrupItems}">
     <%@include file="configuracioGrupListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty configuracioGrupItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="configuracioGrupListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="configuracioGrupListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="configuracioGrupListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="configuracioGrup" items="${configuracioGrupItems}">

        <tr id="configuracioGrup_rowid_${configuracioGrup.configuracioGrupID}">
          <%@include file="configuracioGrupListCoreMultipleSelect.jsp" %>

          <%@include file="configuracioGrupListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="configuracioGrupListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
