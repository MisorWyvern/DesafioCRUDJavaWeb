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
	<h2>Menu Principal</h2>
	<a href="adicionarAluno">Adicionar novo aluno</a>
	<table>
	<caption>Dados dos Alunos</caption>
		<thead>
			<tr>
				<td>ID Aluno</td>
				<td>Nome</td>
				<td>Idade</td>
				<td>Ações</td>
			</tr>
		</thead>
			<tbody>
			<a:forEach items="${listaDeAlunos}" var="aluno" varStatus="status">
			<tr>
				<td>${aluno.id_aluno}</td>
				<td>${aluno.nome}</td>
				<td>${aluno.idade}</td>
				<td><a href="editarAluno?id_aluno=${aluno.id_aluno}">Editar</a></td>
			</tr>
			</a:forEach>
		</tbody>
	</table>
	
	
	</main>
	
</body>
</html>