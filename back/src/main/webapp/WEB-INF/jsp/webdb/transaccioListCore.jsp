  <c:if test="${empty transaccioItems}">
     <%@include file="transaccioListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty transaccioItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-condensed table-bordered table-striped" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="transaccioListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="transaccioListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="transaccioListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="transaccio" items="${transaccioItems}">

        <tr id="transaccio_rowid_${transaccio.transaccioID}">
          <%@include file="transaccioListCoreMultipleSelect.jsp" %>

          <%@include file="transaccioListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="transaccioListButtons.jsp" %>

            
        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
