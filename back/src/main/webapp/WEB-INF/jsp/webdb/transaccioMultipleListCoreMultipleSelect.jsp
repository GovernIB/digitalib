      <%--  CHECK DE SELECCIO MULTIPLE  --%>
      <c:if test="${__theFilterForm.visibleMultipleSelection}">
      <td>
       <form:checkbox path="selectedItems" value="${transaccioMultiple.transmultipleid}"/>
       &nbsp;
      </td>
      </c:if>

