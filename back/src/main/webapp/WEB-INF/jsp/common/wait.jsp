<%@ page language="java" 
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp" 
%>


<table border="0" width="100%">
<tr height="300px" valign="middle"><td width="300px" align="center">
   <img src="<c:url value="/img/spinner_40.gif"/>" loop="infinite" alt="Espera ..." > 
</td></tr>
<tr><td>
   <fmt:message key="esperarfirmacustodia" />
</td></tr>
</table>

<script>
window.onload = function(e) {
   location.href='<c:url value="${finalURL}"/>';
}
</script>
