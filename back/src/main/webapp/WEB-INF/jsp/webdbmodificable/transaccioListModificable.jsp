

<input type="hidden" id="transaccioID" name="transaccioID" value="">
<input type="hidden" id="email" name="email" value="">

<script>
  
  function enviarEmail(transaccioID) {
    
    document.getElementById("transaccioID").value= transaccioID;
    
    
    var email = prompt("Escriu el correu on enviar el document:", "");

    if (email != null) {
      document.getElementById("email").value = email;
      
      var form = document.getElementById("transaccioFilterForm");
      
      form.action = "<c:url value="${contexte}/enviaremail"/>";
      
      form.submit(); 
    } 
    
  }
  
</script>