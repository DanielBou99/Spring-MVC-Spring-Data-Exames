<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>Editar Exame</title>
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
    </div>
  </div>
</nav>

    <div align="center">
        <h2>Editar Exame</h2>
        <form:form action="salvar" method="post" modelAttribute="exame">
            <table border="0" cellpadding="5">
				<tr>
					<td>ID: </td>
					<td>${exame.id}
                        <form:hidden path="id"/>
                    </td>
				</tr>
				<tr>
					<td>Nome: </td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td>Exame: </td>
					<td><form:input path="exame" /></td>
				</tr>
				<tr>
					<td>Data: </td>
					<td><form:input path="data" /></td>
				</tr>
				<tr>
					<td>Observação: </td>
					<td><form:input path="observacao" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="salvar"></td>
				</tr>
			</table>
        </form:form>
    </div>
</body>
</html>