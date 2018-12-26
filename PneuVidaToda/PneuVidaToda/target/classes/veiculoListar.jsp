<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page import="modelo.dominio.Veiculo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Sistema Pneu Vida Toda</title>

<!-- Css -->
<link href="css/style.css" rel="stylesheet">

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<script type="text/javascript">
	function confirmar(id, placa) {
		if (confirm('Deseja realmente excluir o Veiculo: ' + placa + '?')) {
			window.location = 'excluir?id=' + id;
		}
	}
</script>

<%
	//    TYPE CAST  /  CASTING
	List<Veiculo> lista = (List<Veiculo>) request.getAttribute("lista");
%>

<body>
	<!-- Static navbar -->
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand">
					Pneu Vida Toda
				</a>
			</div>
			<!--/fim navbar-header-->

			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
				</ul>
			</div>
			<!--/fim nav-collapse -->
		</div>
		<!--/fim container -->
	</nav>
	<!--/fim nav -->

	<div class="container">
		<a class="btn btn-success pull-right" href="abrirInclusao">Novo
			Veículo</a>
	</div>
	<!--/fim container-->
	<br>


	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">Veículos</div>
			<table class="table">
				<thead>
					<tr>
						<th>Ação</th>
						<th>Placa</th>
						<th>Marca</th>
						<th>Modelo</th>
						<th>Situação</th>
					</tr>
				</thead>
				<c:forEach var="veiculo" items="${lista}">
						<tr>
							<td><a class="btn btn-info btn-xs" href="editar?id=${veiculo.id}">Alterar</a>
								<a class="btn btn-danger btn-xs"
								href="javascript:confirmar('${veiculo.id}', '${veiculo.placa}')">Excluir</a>
							</td>
							<td>${veiculo.placa}</td>
							<td>${veiculo.marca}</td>
							<td>${veiculo.modelo}</td>
							<td>${veiculo.situacao.nome}</td>
						</tr>
				</c:forEach>
			</table>
		</div>
		<!--/fim panel panel-default -->
	</div>
	<!--/fim container -->

	<!-- Core JS -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>