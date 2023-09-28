      <%--  CHECK DE SELECCIO MULTIPLE  --%>
      <c:if test="${__theFilterForm.visibleMultipleSelection}">
      <td>
       <form:checkbox path="selectedItems" value="${apiSimple.apiSimpleID}"/>
       &nbsp;
      </td>
      </c:if>

