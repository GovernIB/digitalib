<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
 <c:choose>
  <c:when test="${fn:startsWith(infoCustodyForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(infoCustodyForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty infoCustodyForm.titleCode}">
    <fmt:message key="${infoCustodyForm.titleCode}" >
      <fmt:param value="${infoCustodyForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty infoCustodyForm.entityNameCode}">
      <fmt:message var="entityname" key="infoCustody.infoCustody"/>
    </c:if>
    <c:if test="${not empty infoCustodyForm.entityNameCode}">
      <fmt:message var="entityname" key="${infoCustodyForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${infoCustodyForm.nou?'genapp.createtitle':(infoCustodyForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose>
  
  <c:if test="${not empty infoCustodyForm.subTitleCode}">
  <br/><h5 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;">
<c:set var="subtitleTranslated" value="${fn:startsWith(infoCustodyForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(infoCustodyForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${infoCustodyForm.subTitleCode}" />
</c:if>
</h5>
  </c:if>
</div>