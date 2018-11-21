<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
 <c:choose>
  <c:when test="${fn:startsWith(infoSignaturaForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(infoSignaturaForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty infoSignaturaForm.titleCode}">
    <fmt:message key="${infoSignaturaForm.titleCode}" >
      <fmt:param value="${infoSignaturaForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty infoSignaturaForm.entityNameCode}">
      <fmt:message var="entityname" key="infoSignatura.infoSignatura"/>
    </c:if>
    <c:if test="${not empty infoSignaturaForm.entityNameCode}">
      <fmt:message var="entityname" key="${infoSignaturaForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${infoSignaturaForm.nou?'genapp.createtitle':(infoSignaturaForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose>
  
  <c:if test="${not empty infoSignaturaForm.subTitleCode}">
  <br/><h5 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;">
<c:set var="subtitleTranslated" value="${fn:startsWith(infoSignaturaForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(infoSignaturaForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${infoSignaturaForm.subTitleCode}" />
</c:if>
</h5>
  </c:if>
</div>