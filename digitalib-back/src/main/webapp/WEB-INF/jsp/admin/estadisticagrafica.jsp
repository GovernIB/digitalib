<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

<h3>${model.title} (${model.subtitle})</h3>

<form method="get" class="form-inline">

    <%-- Filtres dinàmics definits per la subclasse --%>
    <c:forEach var="filterDef" items="${model.filter.filters}">
        <label for="filter_${filterDef.name}">${filterDef.label}:</label>
        <select id="filter_${filterDef.name}" name="${filterDef.name}" class="form-control">
            <option value="">Tots</option>
            <c:forEach var="opt" items="${filterDef.options}">
                <option value="${opt.key}" <c:if test="${filterDef.value == opt.key}">selected="selected"</c:if>>${opt.value}</option>
            </c:forEach>
        </select> &nbsp;&nbsp;
    </c:forEach>

    <label for="rangeSelect">Rang:</label>
    <select id="rangeSelect" name="rang" class="form-control">
        <option value="3" <c:if test="${model.filter.rangCode.code == 3}">selected="selected"</c:if>>Any</option>
        <option value="2" <c:if test="${model.filter.rangCode.code == 2}">selected="selected"</c:if>>Mes</option>
        <option value="1" <c:if test="${model.filter.rangCode.code == 1}">selected="selected"</c:if>>Dia</option>
    </select> &nbsp;&nbsp;

    <label for="dateInput">Data:</label>
    <input type="date" class="form-control" id="dateInput" name="date" value="${model.filter.selectedDate}" /> &nbsp;&nbsp;

    <button type="submit" class="btn btn-primary">Aplicar</button>
    &nbsp;&nbsp;
    <button type="button" class="btn btn-secondary" onclick="exportToCSV()">Exportar CSV</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<canvas id="barChart" style="padding: 20px"></canvas>
<script>
  const ctx = document.getElementById('barChart').getContext('2d');

  // Etiquetes de l'eix X (dinàmiques des del model)
  const labels = [<c:forEach var="lbl" items="${model.values.xlabels}" varStatus="st">'${lbl}'<c:if test="${!st.last}">,</c:if></c:forEach>];

  // Datasets dinàmics generats a partir de yDefinitionsWithValues
  const datasets = [];
  <c:forEach var="yAxis" items="${model.values.yDefinitionsWithValues}" varStatus="idx">
  datasets.push({
      label: '${yAxis.name}',
      data: [<c:forEach var="val" items="${yAxis.values}" varStatus="vst">${val}<c:if test="${!vst.last}">,</c:if></c:forEach>],
      backgroundColor: '${yAxis.color}'
  });
  </c:forEach>

  // Funció per exportar a CSV
  function exportToCSV() {
    const csvRows = [];
    // Capçalera: Etiqueta + noms dels eixos Y
    const header = ['Etiqueta'];
    datasets.forEach(function(ds) { header.push(ds.label); });
    csvRows.push(header.join(','));

    // Files de dades
    for (let i = 0; i < labels.length; i++) {
        const row = [labels[i]];
        datasets.forEach(function(ds) { row.push(ds.data[i] || 0); });
        csvRows.push(row.join(','));
    }

    // Crear el fitxer i descarregar
    const blob = new Blob([csvRows.join('\n')], { type: 'text/csv;charset=utf-8;' });
    const url = URL.createObjectURL(blob);
    const link = document.createElement("a");
    link.setAttribute("href", url);
    link.setAttribute("download", "estadistiques.csv");
    link.style.visibility = 'hidden';
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  }

  // Crear la gràfica amb Chart.js
  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: labels,
      datasets: datasets
    },
    options: {
        responsive: true,
        scales: { y: { beginAtZero: true } }
    }
  });
</script>