

<input type="hidden" id="transaccioID" name="transaccioID" value="">
<input type="hidden" id="email" name="email" value="">

<script>
  
  function enviarEmail(transaccioID) {
    
    document.getElementById("transaccioID").value= transaccioID;
    document.getElementById("email").value = 'anadal@fundaciobit.org'; // XYZ ZZZ 

    
    var form = document.getElementById("transaccioFilterForm");
    
    form.action = "<c:url value="${contexte}/enviaremail"/>";
    
    form.submit(); 
    
  }
  
</script>