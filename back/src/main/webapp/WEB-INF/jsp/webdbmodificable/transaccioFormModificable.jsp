
<script>

  function formatBytes(bytes, decimals = 2) {
    if (bytes === 0) return '0 Bytes';
  
    const k = 1024;
    const dm = decimals < 0 ? 0 : decimals;
    const sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
  
    const i = Math.floor(Math.log(bytes) / Math.log(k));
  
    return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
  }

  var cols = document.getElementsByClassName('input-xxlarge');
  for (i = 0; i < cols.length; i++) {
    cols[i].style.width = '300px';
  }

  <c:if test="${not empty __theForm.transaccio.fitxerEscanejat}">
  {
    var tr = document.getElementById("transaccio_fitxerEscanejatID_rowid");
    if (tr) {
      var td = tr.getElementsByTagName("td")[1];
      td.innerHTML = td.innerHTML + formatBytes(${__theForm.transaccio.fitxerEscanejat.tamany});
    }
  }
  </c:if>

  <c:if test="${not empty __theForm.transaccio.fitxerSignatura}">
  {
    var tr = document.getElementById("transaccio_fitxerSignaturaID_rowid");
    if (tr) {
      var td = tr.getElementsByTagName("td")[1];
      td.innerHTML = td.innerHTML + formatBytes(${__theForm.transaccio.fitxerSignatura.tamany});
    }
  }
  </c:if>
</script>