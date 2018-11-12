  <c:if test="${empty perfilItems}">
     <%@include file="perfilListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty perfilItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-condensed table-bordered table-striped" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="perfilListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="perfilListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="perfilListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="perfil" items="${perfilItems}">

        <tr id="perfil_rowid_${perfil.perfilID}">
          <%@include file="perfilListCoreMultipleSelect.jsp" %>

          <%@include file="perfilListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="perfilListButtons.jsp" %>

            
        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
