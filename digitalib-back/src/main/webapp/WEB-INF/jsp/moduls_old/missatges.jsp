<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<c:if test="${not empty missatges}">
  
  <c:forEach items="${missatges}" var="tipusList" varStatus="status">
    
      <c:forEach items="${tipusList.value}" var="msg" >
      <div class="alert alert-${tipusList.key} text-center">
      <button type="button" class="close" data-dismiss="alert">&times;</button>
          <span style="font-size: 20px; font-weight: bolder;">${msg}</span>
      </div>
      </c:forEach>
    
  </c:forEach>
</c:if>
<c:remove var="missatges" scope="session" />

<div class="spacer"></div>
