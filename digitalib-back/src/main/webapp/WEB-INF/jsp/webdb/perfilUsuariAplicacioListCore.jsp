  <c:if test="${empty perfilUsuariAplicacioItems}">
     <%@include file="perfilUsuariAplicacioListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty perfilUsuariAplicacioItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="perfilUsuariAplicacioListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="perfilUsuariAplicacioListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="perfilUsuariAplicacioListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="perfilUsuariAplicacio" items="${perfilUsuariAplicacioItems}">

        <tr id="perfilUsuariAplicacio_rowid_${perfilUsuariAplicacio.perfilUsrAppID}">
          <%@include file="perfilUsuariAplicacioListCoreMultipleSelect.jsp" %>

          <%@include file="perfilUsuariAplicacioListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="perfilUsuariAplicacioListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
