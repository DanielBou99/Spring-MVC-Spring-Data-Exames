<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Exame</title>
</head>
<body>
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