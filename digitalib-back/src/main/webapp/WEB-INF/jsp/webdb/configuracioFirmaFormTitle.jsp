<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(configuracioFirmaForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(configuracioFirmaForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty configuracioFirmaForm.titleCode}">
    <fmt:message key="${configuracioFirmaForm.titleCode}" >
      <fmt:param value="${configuracioFirmaForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty configuracioFirmaForm.entityNameCode}">
      <fmt:message var="entityname" key="configuracioFirma.configuracioFirma"/>
    </c:if>
    <c:if test="${not empty configuracioFirmaForm.entityNameCode}">
      <fmt:message var="entityname" key="${configuracioFirmaForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${configuracioFirmaForm.nou?'genapp.createtitle':(configuracioFirmaForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty configuracioFirmaForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(configuracioFirmaForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(configuracioFirmaForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${configuracioFirmaForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>