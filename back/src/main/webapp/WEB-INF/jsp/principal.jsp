<%@page import="org.springframework.security.core.Authentication"
%><%@page import="org.springframework.security.core.context.SecurityContext"
%><%@page import="org.springframework.security.core.context.SecurityContextHolder"
%><%@ page language="java" 
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp" 
%>
<div class="clear"></div>
<div class="spacer"></div>

<div>
<br/>
<center>
<img src="<c:url value="/img/app-logo.png"/>"  alt="DigitalIB" title="DigitalIB"/>

<br/>
<br/>
This page is generated automatically. Please edit.

<br/>
<br/>
<table border="0" >
<tr>
<td valign="top">
<a href="http://dgtic.caib.es/" target="_blank">
<img src="<c:url value="/img/dgidt.jpg"/>"  alt="DGIDT" title="DGIDT"/>
</a>
</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td valign="top">
<a href="http://blog.fundaciobit.org/category/admindigital/" target="_blank">
<img src="<c:url value="/img/fundaciobit.jpg"/>"  alt="Fundaci&ograve; Bit" title="Fundaci&ograve; Bit"/>
</a>
</td>
</tr>
</table>
<br/>
</center>
 
</div>

<br/>
<%-- Username: ${loginInfo.username}<br/> 
&#36;{dib:hasRole(ROLE_ADMIN)}= ${dib:hasRole('ROLE_ADMIN')}<br/>
&#36;{dib:hasRole(ROLE_USER) }= ${dib:hasRole('ROLE_USER') }<br/>
<br/>

<c:if test="${dib:isDesenvolupament()}">
Only in Development Mode
</c:if>
--%>
