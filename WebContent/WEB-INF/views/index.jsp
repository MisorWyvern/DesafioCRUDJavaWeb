<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Desafio CRUD Java Web - Home</title>
</head>
<body>
	<main>
	<h1>Desafio CRUD Java Web</h1>
	<h2>Tabela com Dados dos Alunos</h2>
	<h3><a href="./adicionarAluno">Adicionar novo aluno</a></h3>
	<table>
		<tr>
			<td>ID Aluno</td>
			<td>Nome</td>
			<td>Idade</td>
			<td>Ações</td>
		</tr>
		<a:forEach items="${listaDeAlunos}" var="aluno" varStatus="status">
		<tr>
			<td>${aluno.id_aluno}</td>
			<td>${aluno.nome}</td>
			<td>${aluno.idade}</td>
		</tr>
		</a:forEach>
	</table>
	
	
	</main>
	
</body>
</html>