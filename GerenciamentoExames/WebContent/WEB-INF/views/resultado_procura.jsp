<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Resultado da Procura</title>
	<link href="css/estilo.css" rel="stylesheet">
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/GerenciamentoExames">Listar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="novo">Cadastrar</a>
        </li>
        
      <form class="d-flex" method="get" action="procurar">
        <input name="keyword" class="form-control me-2" type="text" placeholder="Procurar" aria-label="Search">
        <button class="btn btn-outline-success" type="submit" value="Procurar">Procurar</button>
      </form>
    </div>
  </div>
</nav>

<div align="center">

    <h2>Resultado da Procura</h2>
    
	<table class="table table-hover">
		<tr>
			<th scope="col">ID</th>
			<th scope="col"> NOME</th>
			<th scope="col">EXAME</th>
			<th scope="col">DATA</th>
			<th scope="col">OBSERVAÇÃO</th>
			<th scope="col">AÇÕES</th>
	</tr>
	<c:forEach items="${resultado}" var="exame">
        <tr>
			<td scope="row">${exame.id}</td>
			<td>${exame.nome}</td>
			<td>${exame.exame}</td>
			<td>${exame.data}</td>
			<td>${exame.observacao}</td>
			<td>
				<a href="editar?id=${exame.id}">Editar</a>
				<a href="deletar?id=${exame.id}">Deletar</a>
			</td>
		</tr>
        </c:forEach>
	</table>
</div>
</body>
</html>

<style>
.resaltar {
	cursor: default;
	background-color: yellow;
	color: crimson;
}
</style>

<script>
$(document).ready(() => {
	 $('th').each(function(columna) {
		 $(this).hover(function() {
			 $(this).addClass('resaltar');
		 }, function() {
			 $(this).removeClass('resaltar');
		 });

		 $(this).click(function() {
			 let registros = $('table').find('tbody > tr').get();

			 registros.sort(function(a, b) {
				 let valor1 = $(a).children('td').eq(columna).text().toUpperCase();
				 let valor2 = $(b).children('td').eq(columna).text().toUpperCase();

				 return valor1 < valor2 ? -1 : valor1 > valor2 ? 1 : 0;
			 });

			 $.each(registros, function(indice, elemento) {
				 $('tbody').append(elemento);
			 });
		 });
	 });
});
</script>