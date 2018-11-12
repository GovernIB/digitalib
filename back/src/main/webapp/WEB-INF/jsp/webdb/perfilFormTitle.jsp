<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
 <c:choose>
  <c:when test="${fn:startsWith(perfilForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(perfilForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty perfilForm.titleCode}">
    <fmt:message key="${perfilForm.titleCode}" >
      <fmt:param value="${perfilForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty perfilForm.entityNameCode}">
      <fmt:message var="entityname" key="perfil.perfil"/>
    </c:if>
    <c:if test="${not empty perfilForm.entityNameCode}">
      <fmt:message var="entityname" key="${perfilForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${perfilForm.nou?'genapp.createtitle':(perfilForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose>
  
  <c:if test="${not empty perfilForm.subTitleCode}">
  <br/><h5 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;">
<c:set var="subtitleTranslated" value="${fn:startsWith(perfilForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(perfilForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${perfilForm.subTitleCode}" />
</c:if>
</h5>
  </c:if>
</div>