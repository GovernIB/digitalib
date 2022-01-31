<!-- Modal -->
<div class="modalContenidor" style="border-radius: 6px">
  <div id="modalEmail" class="modal hide fade" tabindex="-1" role="dialog"
    aria-labelledby="Enviar document" aria-hidden="true">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
      <p style="line-height: 40px; font-size: 24px; font-weight: 600"
        id="myModalEmailLabel">
        <fmt:message key="email.modal.titol" />
      </p>
    </div>
    <div class="modal-body">
      <p style="padding-bottom: 2%">
        <fmt:message key="email.modal.labelemail" />
      </p>
      <input style="width: 97%" type="email" id="email" name="email" value=""
        placeholder="administrador@email.com,usuari@email.com">
      <p style="padding: 2% 0%; margin-top: 1%">
        <fmt:message key="email.modal.labeladdicional" />
      </p>
      <textarea name="content" style="width: 97%"
        placeholder="Escriu aquí el contingut..."></textarea>
      <input type="hidden" id="transaccioID" name="transaccioID" value="">
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal" aria-hidden="true">
        <fmt:message key="genapp.cancel" />
      </button>
      <button class="btn btn-success" type="button" onclick="submitFormEmail()">
        <fmt:message key="email.modal.enviar" />
      </button>
    </div>
  </div>
</div>


<input id="nousdies" name="nousdies" type="hidden" value="">


<script>
  function enviarEmail(transaccioID, accio) {
    document.getElementById("transaccioID").value = transaccioID;
    $('#modalEmail').modal(accio);
  }

  function submitFormEmail() {
    var form = document.getElementById("transaccioFilterForm");

    form.action = "<c:url value="${contexte}/enviaremail"/>";

    form.submit();
  }

  
  function netejarSeleccionats() {
    var form = document.getElementById("transaccioFilterForm");
    form.action = "<c:url value="${contexte}/netejarseleccionats"/>";
    form.submit();
  }
  
  
  function canviarDies() {

    let dies = prompt(
        "Es mostraran les Transaccions amb més de X dies des de la seva creació:",
        "${canviarDies}");

    if (isNaN(dies)) {
      alert("No és un numero correcte");
    } else {
      if (dies < 30) {
        alert("El numero de dies ha de ser superior a 30");
      } else {
        document.getElementById("nousdies").value = dies;
        var form = document.getElementById("transaccioFilterForm");
        form.action = "<c:url value="${contexte}/canviardies"/>";
        form.submit();
      }

    }

  }
</script>