<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(configuracioGrupForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(configuracioGrupForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty configuracioGrupForm.titleCode}">
    <fmt:message key="${configuracioGrupForm.titleCode}" >
      <fmt:param value="${configuracioGrupForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty configuracioGrupForm.entityNameCode}">
      <fmt:message var="entityname" key="configuracioGrup.configuracioGrup"/>
    </c:if>
    <c:if test="${not empty configuracioGrupForm.entityNameCode}">
      <fmt:message var="entityname" key="${configuracioGrupForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${configuracioGrupForm.nou?'genapp.createtitle':(configuracioGrupForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty configuracioGrupForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(configuracioGrupForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(configuracioGrupForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${configuracioGrupForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>