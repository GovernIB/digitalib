<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
 <c:choose>
  <c:when test="${fn:startsWith(transaccioForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(transaccioForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty transaccioForm.titleCode}">
    <fmt:message key="${transaccioForm.titleCode}" >
      <fmt:param value="${transaccioForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty transaccioForm.entityNameCode}">
      <fmt:message var="entityname" key="transaccio.transaccio"/>
    </c:if>
    <c:if test="${not empty transaccioForm.entityNameCode}">
      <fmt:message var="entityname" key="${transaccioForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${transaccioForm.nou?'genapp.createtitle':(transaccioForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose>
  
  <c:if test="${not empty transaccioForm.subTitleCode}">
  <br/><h5 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;">
<c:set var="subtitleTranslated" value="${fn:startsWith(transaccioForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(transaccioForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${transaccioForm.subTitleCode}" />
</c:if>
</h5>
  </c:if>
</div>