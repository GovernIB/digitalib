<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
 <c:choose>
  <c:when test="${fn:startsWith(perfilUsuariAplicacioForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(perfilUsuariAplicacioForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty perfilUsuariAplicacioForm.titleCode}">
    <fmt:message key="${perfilUsuariAplicacioForm.titleCode}" >
      <fmt:param value="${perfilUsuariAplicacioForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty perfilUsuariAplicacioForm.entityNameCode}">
      <fmt:message var="entityname" key="perfilUsuariAplicacio.perfilUsuariAplicacio"/>
    </c:if>
    <c:if test="${not empty perfilUsuariAplicacioForm.entityNameCode}">
      <fmt:message var="entityname" key="${perfilUsuariAplicacioForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${perfilUsuariAplicacioForm.nou?'genapp.createtitle':(perfilUsuariAplicacioForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose>
  
  <c:if test="${not empty perfilUsuariAplicacioForm.subTitleCode}">
  <br/><h5 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;">
<c:set var="subtitleTranslated" value="${fn:startsWith(perfilUsuariAplicacioForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(perfilUsuariAplicacioForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${perfilUsuariAplicacioForm.subTitleCode}" />
</c:if>
</h5>
  </c:if>
</div>