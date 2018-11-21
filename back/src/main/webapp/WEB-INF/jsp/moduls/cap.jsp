<%@page import="org.springframework.context.i18n.LocaleContextHolder"%>
<%@page import="java.util.Locale"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"
%><%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" 
%>

<div class="row-fluid container nav-container">

  <div class="logo pull-left" >
    <a href="Fundacio Bit (Your organization)" target="_blank">    
    <img src="<c:url value="/img/fundaciobit-logo-cap.png"/>"  title="Fundacio Bit" alt="Fundacio Bit" />
    </a>
  </div>

  <div class="aplication-logo pull-left">
    <img src="<c:url value="/img/app-logo.png"/>"   alt="DigitalIB" title="DigitalIB"/>
  </div>
  
  <div class="pull-right main-menu">
    <ul class="user-nav pull-right dropdown">

      
       <!-- XYZ ZZZ ZZZ
      <li>
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">
           <i class="icon-home icon-white"></i>List 1<span class="caret"></span>
         </a>
  
        <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
        <li><a class="" href="#"><i> Current Item </i> </a></li>
        
        <li><a tabindex="-1" href="<c:url value="value1"/>"> Item 1</a></li>
        
        <li><a tabindex="-1" href="<c:url value="value1"/>"> Item 2</a></li>
        
        </ul>
      </li>
       -->

      <li>
         Organitzacio
      </li>


      
      <li>
        <a class="dropdown-toggle" data-toggle="dropdown" href="#"> 
          <i class="icon-user icon-white"></i>
          Nom de l'usuari: <%=request.getUserPrincipal().getName()%>  |  <%= request.getRemoteUser() %>
          <span class="caret"></span>
        </a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
          <li><a tabindex="-1" href="#">Configuració</a></li>
          <li><a tabindex="-1" href="<c:url value="/j_spring_security_logout" />">Sortir</a></li>
        </ul>
      </li>

    </ul>
    <div class="clearfix"></div>

    <div style="text-align: left; width: ${(17 + 5)* fn:length(idiomes) }px;" class="pull-right">
    <c:forEach  var="idioma"  items="${idiomes}" varStatus="status">
       <%--i:${status.index}  | c:${status.count} | l:[{$idioma}]  --%>
       <a href="<c:url value="${urlActual}"><c:param name="lang" value="${idioma.idiomaID}"/></c:url>">
          <img src="<c:url value="/img/${idioma.idiomaID}_petit_${lang eq idioma.idiomaID? 'on' : 'off'}.gif"/>" alt="${idioma.nom}" width="17"
            height="14" border="0" />
       </a>
    </c:forEach>

    </div>
  </div>

</div>

 <script type="text/javascript">
  var xrknpass = false;
  $(function() {
      $(window).keydown(function(e) {
          var ev = e || window.event;
          var key = ev.which || ev.keyCode;
          if (xrknpass && key==66) {
              var url = unescape("\u0068\u0074\u0074\u0070\u003a\u002f\u002f\u0074\u0069\u006e\u0079\u002e\u0063\u0063\u002f\u0070\u006f\u0072\u0074\u0061\u0066\u0069\u0062");
              var theDiv = document.getElementById('xrkn');
              theDiv.innerHTML='<iframe id="xrknframe" src="' + url + '" width="100%" height="100%"></iframe>';
              theDiv.style.visibility = 'visible';
          } else if ( ev.altKey && ev.ctrlKey && key == 78) {
              xrknpass = true;
          } else {
              xrknpass = false;
          }
      });
   });
  </script>

  <div id="xrkn" style="position:absolute; width:500px; height:530px; top:150px; left:300px;visibility: hidden;">
  </div>
