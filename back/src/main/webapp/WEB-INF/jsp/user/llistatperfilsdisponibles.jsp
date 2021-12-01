<%@page import="es.caib.digitalib.utils.Configuracio"%><%@page
  import="es.caib.digitalib.utils.Constants"%><%@ page language="java"%><%@ include
  file="/WEB-INF/jsp/moduls/includes.jsp"%>
<br />

<center>
  <h2>
    <fmt:message key="plugindescan.seleccio.title2" />
  </h2>
</center>
<br />

<%
if (Configuracio.isAllowedMassiveScanInWeb()) {
%>

<div class="span6">


    <fmt:message key="plugindescan.seleccio.subtitle2A" />
    
    
    <div style="padding-left: 25px">
    
    <ol type="1">
    
    <li>
    <fmt:message key="plugindescan.seleccio.subtitle2B1" />
    <%-- BOTO DESCARREGAR SEPARADOR --%>
    <center>
      <a href="<c:url value="/user/scan/separator"/>" target="_blank"  class="btn btn-info">
        
        <fmt:message key="descarregar.separador" />
        <%-- <small style="color:white;"><i>Necessari per separar diferents documents quan es fa un escaneig múltiple</i></small> --%>
      </a>
    </center>
    </li>
    <br/>

    <li>
    <fmt:message key="plugindescan.seleccio.subtitle2B2" />

    <%-- IMATGE --%>
    <br />
    <center>
    <img src="<c:url value="/img/ajudaescaneigmassiu.png"/>" alt="ajuda" />
    </center>
    </li>
    <br/>

    <li>
    <fmt:message key="plugindescan.seleccio.subtitle2B3" />
    </li>
    
    
    
    

</ol>
<b><fmt:message key="plugindescan.seleccio.subtitle2B4" /></b>
    </div>

</div>

<%
}
%>
<div class="span5" style="margin-bottom: 10px; text-align: center;">

  <%--  
  <br />
  <h5 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;">
    <fmt:message key="plugindescan.seleccio.subtitle2" />
  </h5>
  --%>


  <c:if test="${not empty configuracioGrup }">
    <div class="well" style="max-width: 400px; margin: 0 auto 10px;">


      <sec:authorize access="hasAnyRole('ROLE_SCAN')">
        <c:if test="${not empty configuracioGrup.perfilNomesEscaneigID }">
          <button type="button" class="btn btn-large btn-block btn-success"
            onclick="javascript:executaPerfil(<%=Constants.PERFIL_US_NOMES_ESCANEIG%>,1)">
            <b>${configuracioGrup.perfilNomesEscaneig.nom.traduccions[lang].valor }</b><br>
            <small style="color: white;"><i>${configuracioGrup.perfilNomesEscaneig.descripcio.traduccions[lang].valor }</i></small>
            <%--
          <b><fmt:message key="transaccio.tipus.1" /></b><br>
          <small style="color:white;"> <i>Realitza un
              escaneig d'un document XYZ FALTA COMBO BOX DE IDIOMA</i><br>
              
           C: ${configuracioGrup.perfilNomesEscaneig.codi } |  N: ${configuracioGrup.perfilNomesEscaneig.nom.traduccions[lang].valor.traduccions[lang].valor } | D: ${configuracioGrup.perfilNomesEscaneig.descripcio.traduccions[lang].valor }
              
          </small> --%>
          </button>
        </c:if>
        <c:if test="${not empty configuracioGrup.perfilNomesEscaneig2ID }">
          <button type="button" class="btn btn-large btn-block btn-success"
            onclick="javascript:executaPerfil(<%=Constants.PERFIL_US_NOMES_ESCANEIG%>,2)">
            <b>${configuracioGrup.perfilNomesEscaneig2.nom.traduccions[lang].valor }</b><br>
            <small style="color: white;"><i>${configuracioGrup.perfilNomesEscaneig2.descripcio.traduccions[lang].valor }</i></small>
            <%--
          <b><fmt:message key="transaccio.tipus.1" /></b><br>
          <small style="color:white;"> <i>Realitza un
              escaneig d'un document</i>
               C: ${configuracioGrup.perfilNomesEscaneig2.codi } |  N: ${configuracioGrup.perfilNomesEscaneig2.nom.traduccions[lang].valor } | D: ${configuracioGrup.perfilNomesEscaneig2.descripcio.traduccions[lang].valor }
          </small>
          --%>
          </button>
        </c:if>
      </sec:authorize>

      <sec:authorize access="hasAnyRole('ROLE_COAU')">
        <c:if test="${not empty configuracioGrup.perfilCopiaAutenticaID }">
          <button type="button" class="btn btn-large btn-block btn-primary"
            onclick="javascript:executaPerfil(<%=Constants.PERFIL_US_COPIA_AUTENTICA%>,1)">
            <b>${configuracioGrup.perfilCopiaAutentica.nom.traduccions[lang].valor }</b><br>
            <small style="color: white;"><i>${configuracioGrup.perfilCopiaAutentica.descripcio.traduccions[lang].valor }</i></small>
            <%--
          <b><fmt:message key="transaccio.tipus.2" /></b><br>
          <i>[${configuracioGrup.perfilCopiaAutentica.codi }] N: ${configuracioGrup.perfilCopiaAutentica.nom.traduccions[lang].valor }</i><br/>
          <small style="color:white;"> ${configuracioGrup.perfilCopiaAutentica.descripcio.traduccions[lang].valor }</small>
          --%>
          </button>
        </c:if>
        <c:if test="${not empty configuracioGrup.perfilCopiaAutentica2ID }">
          <button type="button" class="btn btn-large btn-block btn-primary"
            onclick="javascript:executaPerfil(<%=Constants.PERFIL_US_COPIA_AUTENTICA%>,2)">
            <b>${configuracioGrup.perfilCopiaAutentica2.nom.traduccions[lang].valor }</b><br>
            <small style="color: white;"><i>${configuracioGrup.perfilCopiaAutentica2.descripcio.traduccions[lang].valor }</i></small>
            <%--
              <b><fmt:message key="transaccio.tipus.2" /></b><br>  
              <i>[${configuracioGrup.perfilCopiaAutentica2.codi }] N: ${configuracioGrup.perfilCopiaAutentica2.nom.traduccions[lang].valor }</i><br/>
              <small style="color:white;"> ${configuracioGrup.perfilCopiaAutentica2.descripcio.traduccions[lang].valor }</small>
              </i>
          </small>
           --%>
          </button>
        </c:if>
      </sec:authorize>


      <sec:authorize access="hasAnyRole('ROLE_CUST')">
        <c:if test="${not empty configuracioGrup.perfilCustodiaID }">
          <button type="button" class="btn btn-large btn-block btn-danger"
            onclick="javascript:executaPerfil(<%=Constants.PERFIL_US_CUSTODIA%>,1)">

            <b>${configuracioGrup.perfilCustodia.nom.traduccions[lang].valor }</b><br>
            <small style="color: white;"><i>${configuracioGrup.perfilCustodia.descripcio.traduccions[lang].valor }</i></small>
            <%--
          
          <b><fmt:message key="transaccio.tipus.3" /></b><br> <small style="color:white;"> <i>Realitza
              una Còpia Autèntica i Custodia el Fitxer </i>
          </small>
          --%>
          </button>
        </c:if>
        <c:if test="${not empty configuracioGrup.perfilCustodia2ID }">
          <button type="button" class="btn btn-large btn-block btn-danger"
            onclick="javascript:executaPerfil(<%=Constants.PERFIL_US_CUSTODIA%>,2)">
            <b>${configuracioGrup.perfilCustodia2.nom.traduccions[lang].valor }</b><br>
            <small style="color: white;"><i>${configuracioGrup.perfilCustodia2.descripcio.traduccions[lang].valor }</i></small>
            <%--
          <b><fmt:message key="transaccio.tipus.3" /></b><br> <small style="color:white;"> <i>Realitza
              una Còpia Autèntica i Custodia el Fitxer </i>
          </small>
          --%>
          </button>
        </c:if>
      </sec:authorize>


    </div>
    <br />

  </c:if>

</div>

<form id="scanwebform" action="<c:url value="/user/scan/start/"/>" method="post">
  <input type="hidden" id="perfil_tipus" name="perfil_tipus" value=""> <input
    type="hidden" id="perfil_pos" name="perfil_pos" value=""> <input
    type="hidden" id="url_user" name="url_user" value="">
</form>

<script>
  
  function executaPerfil(perfil, pos) {
    
    document.getElementById("url_user").value= window.location.href;
    document.getElementById("perfil_tipus").value = perfil;
    document.getElementById("perfil_pos").value = pos;

    document.getElementById("scanwebform").submit(); 
    <%-- location.href = '<c:url value="/user/scan/start/"/>' + perfil + '/' + window.location.href; --%>
  }
  
</script>
