<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
 <c:choose>
  <c:when test="${fn:startsWith(transaccioMultipleForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(transaccioMultipleForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty transaccioMultipleForm.titleCode}">
    <fmt:message key="${transaccioMultipleForm.titleCode}" >
      <fmt:param value="${transaccioMultipleForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty transaccioMultipleForm.entityNameCode}">
      <fmt:message var="entityname" key="transaccioMultiple.transaccioMultiple"/>
    </c:if>
    <c:if test="${not empty transaccioMultipleForm.entityNameCode}">
      <fmt:message var="entityname" key="${transaccioMultipleForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${transaccioMultipleForm.nou?'genapp.createtitle':(transaccioMultipleForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose>
  
  <c:if test="${not empty transaccioMultipleForm.subTitleCode}">
  <br/><h5 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;">
<c:set var="subtitleTranslated" value="${fn:startsWith(transaccioMultipleForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(transaccioMultipleForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${transaccioMultipleForm.subTitleCode}" />
</c:if>
</h5>
  </c:if>
</div>