  <c:if test="${empty apiSimpleItems}">
     <%@include file="apiSimpleListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty apiSimpleItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="apiSimpleListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="apiSimpleListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="apiSimpleListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="apiSimple" items="${apiSimpleItems}">

        <tr id="apiSimple_rowid_${apiSimple.apiSimpleID}">
          <%@include file="apiSimpleListCoreMultipleSelect.jsp" %>

          <%@include file="apiSimpleListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="apiSimpleListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
