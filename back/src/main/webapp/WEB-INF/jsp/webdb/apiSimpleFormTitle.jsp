<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
 <c:choose>
  <c:when test="${fn:startsWith(apiSimpleForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(apiSimpleForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty apiSimpleForm.titleCode}">
    <fmt:message key="${apiSimpleForm.titleCode}" >
      <fmt:param value="${apiSimpleForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty apiSimpleForm.entityNameCode}">
      <fmt:message var="entityname" key="apiSimple.apiSimple"/>
    </c:if>
    <c:if test="${not empty apiSimpleForm.entityNameCode}">
      <fmt:message var="entityname" key="${apiSimpleForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${apiSimpleForm.nou?'genapp.createtitle':(apiSimpleForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose>
  
  <c:if test="${not empty apiSimpleForm.subTitleCode}">
  <br/><h5 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;">
<c:set var="subtitleTranslated" value="${fn:startsWith(apiSimpleForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(apiSimpleForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${apiSimpleForm.subTitleCode}" />
</c:if>
</h5>
  </c:if>
</div>