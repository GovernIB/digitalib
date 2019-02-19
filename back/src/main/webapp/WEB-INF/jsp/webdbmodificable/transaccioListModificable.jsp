<!-- Modal -->
<div class="modalContenidor" style="border-radius: 6px">
	<div id="modalEmail" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="Enviar document"
		aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">�</button>
			<p style="line-height: 40px; font-size: 24px; font-weight:600" id="myModalEmailLabel">
				<fmt:message key="email.modal.titol" />
			</p>
		</div>
		<div class="modal-body">
			<p style="padding-bottom: 2%">
				<fmt:message key="email.modal.labelemail" />
			</p>
			<input style="width: 97%" type="email" id="email" name="email" value="" placeholder="administrador@email.com,usuari@email.com">
			<p style="padding: 2% 0%; margin-top: 1%"><fmt:message key="email.modal.labeladdicional"/></p>
			<textarea name="content" style="width: 97%" placeholder="Escriu aqu� el contingut..."></textarea>
			<input type="hidden" id="transaccioID" name="transaccioID" value="">
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true"><fmt:message key="genapp.cancel"/></button>
	        <button class="btn btn-success" type="button" onclick="submitForm()"><fmt:message key="email.modal.enviar"/></button>
		</div>
	</div>
</div>




<script>

function enviarEmail(transaccioID,accio) {
	document.getElementById("transaccioID").value= transaccioID;
	$('#modalEmail').modal(accio);

  }
  function submitForm() {
      
	var form = document.getElementById("transaccioFilterForm");
	      
	form.action = "<c:url value="${contexte}/enviaremail"/>";
	     
	form.submit();  
  }
  
  
</script>