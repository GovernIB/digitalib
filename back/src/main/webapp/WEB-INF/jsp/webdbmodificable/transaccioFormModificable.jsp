
<script>

    var cols = document.getElementsByClassName('input-xxlarge');
    for(i=0; i<cols.length; i++) {      
      cols[i].style.width = '300px';
    }
    

    
    <c:if test="${not empty __theForm.transaccio.fitxerEscanejat}">
    {
      var tr = document.getElementById("transaccio_fitxerEscanejatID_rowid");
      if (tr) { 
        var td = tr.getElementsByTagName("td")[1];
        td.innerHTML = td.innerHTML + '${__theForm.transaccio.fitxerEscanejat.tamany} bytes';
      }
    }
    </c:if>
    
    <c:if test="${not empty __theForm.transaccio.fitxerSignatura}">
    {
      var tr = document.getElementById("transaccio_fitxerSignaturaID_rowid");
      if (tr) {
        var td = tr.getElementsByTagName("td")[1];
        td.innerHTML = td.innerHTML + '${__theForm.transaccio.fitxerSignatura.tamany} bytes';
      }
    }
    </c:if>
    
    

</script>