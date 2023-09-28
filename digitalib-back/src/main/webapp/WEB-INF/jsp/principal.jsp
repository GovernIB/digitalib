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
<img src="<c:url value="/img/app-logo-presentacio.png"/>"  alt="DigitalIB" title="DigitalIB"/>

<br/>
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

<c:if test="${dib:isDesenvolupament()}">
<br/>
<b>Only in Development Mode</b> <br/>
* Username: ${loginInfo.username}<br/> 

* &#36;{dib:hasRole(ROLE_ADMIN)} = ${dib:hasRole('ROLE_ADMIN')}<br/>
* &#36;{dib:hasRole(ROLE_USER) } = ${dib:hasRole('ROLE_USER')}<br/>
* &#36;{dib:hasRole(ROLE_SCAN) } = ${dib:hasRole('ROLE_SCAN')}<br/>
* &#36;{dib:hasRole(ROLE_COAU) } = ${dib:hasRole('ROLE_COAU') }<br/>
* &#36;{dib:hasRole(ROLE_CUST) } = ${dib:hasRole('ROLE_CUST') }<br/>


<c:if test="${not empty loginInfo.usuariPersona.configuracioGrup }">
* &#36;{loginInfo.usuariPersona.configuracioGrup.nom }= ${loginInfo.usuariPersona.configuracioGrup.nom}<br/>
</c:if>

<c:if test="${empty loginInfo.usuariPersona.configuracioGrup }">
* SENSE CONFIGURACIO GRUP<br/>
</c:if>

</c:if>

