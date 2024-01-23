  <c:if test="${empty transaccioMultipleItems}">
     <%@include file="transaccioMultipleListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty transaccioMultipleItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="transaccioMultipleListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="transaccioMultipleListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="transaccioMultipleListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="transaccioMultiple" items="${transaccioMultipleItems}">

        <tr id="transaccioMultiple_rowid_${transaccioMultiple.transmultipleid}">
          <%@include file="transaccioMultipleListCoreMultipleSelect.jsp" %>

          <%@include file="transaccioMultipleListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="transaccioMultipleListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
