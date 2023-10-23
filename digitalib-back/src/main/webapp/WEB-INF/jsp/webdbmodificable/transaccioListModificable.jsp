<!-- Modal -->
<div id="modalEmail" class="modal" style="border-radius: 6px" tabindex="-1" role="dialog">
    <div  class="modal-dialog" role="document" aria-labelledby="Enviar document" aria-hidden="true">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <fmt:message key="email.modal.titol" />
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
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
                <textarea name="content" style="width: 97%" placeholder="Escriu aquí el contingut..."></textarea>
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
</div>


<input id="nousdies" name="nousdies" type="hidden" value="">


<script>
  function enviarEmail(transaccioID, accio) {
    document.getElementById("transaccioID").value = transaccioID;
    $('#modalEmail').modal(accio);
  }

  function submitFormEmail() {
    
        document.body.style.cursor = 'wait'
        
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