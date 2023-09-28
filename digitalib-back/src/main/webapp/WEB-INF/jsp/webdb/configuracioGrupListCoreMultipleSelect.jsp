      <%--  CHECK DE SELECCIO MULTIPLE  --%>
      <c:if test="${__theFilterForm.visibleMultipleSelection}">
      <td>
       <form:checkbox path="selectedItems" value="${configuracioGrup.configuracioGrupID}"/>
       &nbsp;
      </td>
      </c:if>

