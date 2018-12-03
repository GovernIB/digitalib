<%@page import="es.caib.digitalib.utils.Constants"%>
<%@ page language="java"%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<br />
<br />

<div class="lead" style="margin-bottom: 10px; text-align: center;">


  <fmt:message key="plugindescan.seleccio.title" />
  <br />
  <h5 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;">
    <fmt:message key="plugindescan.seleccio.subtitle" />
  </h5>
  <br />
  <%-- XYZ ZZZ
  <c:if test="fn:length(companies) eq 1" >
  <h6>
     Si no voleu que aparegui aquesta pantalla quan només hi ha un plugin, llavors anau a la <br/>
     classe <b><%= ScanWebModuleController.class.getName() %></b><br/>
     i editau el camp estatic stepSelectionWhenOnlyOnePlugin i assignau-li un valor true;
  </h6>
  </c:if>
  
   --%>

    <c:if test="${not empty loginInfo.usuariPersona.configuracioGrup }">
  <div class="well" style="max-width: 400px; margin: 0 auto 10px;">



      <%-- XYZ ZZZ 
* &#36;{loginInfo.usuariPersona.configuracioGrup.nom }= ${loginInfo.usuariPersona.configuracioGrup.nom}<br/>
--%>

      <c:if test="${not empty loginInfo.usuariPersona.configuracioGrup.perfilNomesEscaneigID }">
      <sec:authorize access="hasAnyRole('ROLE_SCAN')">
        <button type="button" class="btn btn-large btn-block btn-primary"
          onclick="javascript:executaPerfil(<%=Constants.PERFIL_US_NOMES_ESCANEIG%>)">
          <b><fmt:message key="transaccio.tipus.1" /></b><br>
          <small> <i>Realitza un
              escaneig d'un document XYZ FALTA COMBO BOX DE IDIOMA</i>
          </small>
        </button>
      </sec:authorize>
      </c:if>
      
      <c:if test="${not empty loginInfo.usuariPersona.configuracioGrup.perfilCopiaAutenticaID }">
      <sec:authorize access="hasAnyRole('ROLE_COAU')">

        <button type="button" class="btn btn-large btn-block btn-primary"
          onclick="javascript:executaPerfil(<%=Constants.PERFIL_US_COPIA_AUTENTICA%>)">
          <b><fmt:message key="transaccio.tipus.2" /></b><br> <small> <i>Realitza una
              Còpia Autèntica FALTA COMBO BOX DE IDIOMA</i>
          </small>
        </button>
      </sec:authorize>
      </c:if>


      <c:if test="${not empty loginInfo.usuariPersona.configuracioGrup.perfilCustodiaID }">
      <sec:authorize access="hasAnyRole('ROLE_CUST')">

        <button type="button" class="btn btn-large btn-block btn-primary"
          onclick="javascript:executaPerfil(<%=Constants.PERFIL_US_CUSTODIA%>)">
          <b><fmt:message key="transaccio.tipus.3" /></b><br> <small> <i>Realitza
              una Còpia Autèntica i Custodia el Fitxer FALTA COMBO BOX DE IDIOMA i
              dades addicionals</i>
          </small>
        </button>
      </sec:authorize>
      </c:if>

    

  </div>
  </c:if>

  <br />

</div>

<script>
  //Create Base64 Object
  //var Base64={_keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",encode:function(e){var t="";var n,r,i,s,o,u,a;var f=0;e=Base64._utf8_encode(e);while(f<e.length){n=e.charCodeAt(f++);r=e.charCodeAt(f++);i=e.charCodeAt(f++);s=n>>2;o=(n&3)<<4|r>>4;u=(r&15)<<2|i>>6;a=i&63;if(isNaN(r)){u=a=64}else if(isNaN(i)){a=64}t=t+this._keyStr.charAt(s)+this._keyStr.charAt(o)+this._keyStr.charAt(u)+this._keyStr.charAt(a)}return t},decode:function(e){var t="";var n,r,i;var s,o,u,a;var f=0;e=e.replace(/++[++^A-Za-z0-9+/=]/g,"");while(f<e.length){s=this._keyStr.indexOf(e.charAt(f++));o=this._keyStr.indexOf(e.charAt(f++));u=this._keyStr.indexOf(e.charAt(f++));a=this._keyStr.indexOf(e.charAt(f++));n=s<<2|o>>4;r=(o&15)<<4|u>>2;i=(u&3)<<6|a;t=t+String.fromCharCode(n);if(u!=64){t=t+String.fromCharCode(r)}if(a!=64){t=t+String.fromCharCode(i)}}t=Base64._utf8_decode(t);return t},_utf8_encode:function(e){e=e.replace(/\r\n/g,"n");var t="";for(var n=0;n<e.length;n++){var r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r)}else if(r>127&&r<2048){t+=String.fromCharCode(r>>6|192);t+=String.fromCharCode(r&63|128)}else{t+=String.fromCharCode(r>>12|224);t+=String.fromCharCode(r>>6&63|128);t+=String.fromCharCode(r&63|128)}}return t},_utf8_decode:function(e){var t="";var n=0;var r=c1=c2=0;while(n<e.length){r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r);n++}else if(r>191&&r<224){c2=e.charCodeAt(n+1);t+=String.fromCharCode((r&31)<<6|c2&63);n+=2}else{c2=e.charCodeAt(n+1);c3=e.charCodeAt(n+2);t+=String.fromCharCode((r&15)<<12|(c2&63)<<6|c3&63);n+=3}}return t}};
  // Base64.encode
  
  function executaPerfil(perfil) {
    location.href = '<c:url value="/user/scan/start/"/>' + perfil + '/' + window.location.href;
  }
  
</script>
