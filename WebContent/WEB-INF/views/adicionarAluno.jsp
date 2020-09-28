<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="UTF-8">
<title>Desafio CRUD Java Web - Adicionar Aluno</title>
</head>
<body>
	<main>
		<h1>Desafio CRUD Java Web</h1>
		<h2>Adicionar/Atualizar Aluno</h2>
		<table>
			<form:form action="salvarAluno" method="post" modelAttribute="aluno">
				<form:hidden path="id_aluno" />
				<tr>
					<td>ID Aluno:</td>
					<td><form:input path="id_aluno" /></td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td>Idade:</td>
					<td><form:input path="idade" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Salvar" /></td>
				</tr>
			</form:form>
		</table>
		<a href="/">Voltar</a>
		
		
	</main>
</body>
</html>