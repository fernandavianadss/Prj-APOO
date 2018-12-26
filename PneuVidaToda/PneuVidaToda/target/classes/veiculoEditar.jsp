<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="modelo.dominio.Situacao"%>
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


<body>
	<jsp:useBean id="veiculo" scope="request" class="modelo.dominio.Veiculo"></jsp:useBean>

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
				<a class="navbar-brand">Pneu Vida Toda</a>
			</div>
			<!--/fim navbar-header -->
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
				</ul>
			</div>
			<!--/fim navbar-collapse -->
		</div>
		<!--/fim container -->
	</nav>
	<!--/fim nav -->

	<%

		List<String> falhas = (List<String>) request.getAttribute("falhas");
		if (falhas != null) {
			out.print("<ul class=\"list-group listas\">");
			for (String falha : falhas)
				out.print("<li class=\"alert alert-danger alerts\">" + falha + "</li>");

			out.print("</ul>");
		}
	%>


	<!-- Formulário de Cadastro -->

	<div class="container">
		<form action="salvarVeiculo" method="post">
			<fieldset>
				<legend>Dados do Veículo</legend>
				<div class="row">
					<div class="col-md-2 col-sm-2 form-group">
						<label for="id" class="control-label">Id:</label> <input
							type="text" readonly="readonly" class="form-control" name="id" value="${veiculo.id}">
					</div>
				</div>


				<div class="row">
					<div class="col-md-2 col-sm-2 form-group">
						<label for="placa" class="control-label">Placa:</label> <input
							type="text" class="form-control" value="${veiculo.placa}"
							name="placa" id="placa" required>
					</div>
					
					<div class="col-md-2 col-sm-2 form-group">
						<label for="marca" class="control-label">Marca:</label> <input
							type="text" class="form-control" value="${veiculo.marca}" name="marca"
							id="marca" required>
					</div>
					
					<div class="col-md-2 col-sm-2 form-group">
						<label for="dataNascimento" class="control-label">Modelo:</label> <input type="text" class="form-control"
							value="${veiculo.modelo}" name="modelo"
							id="modelo" required>
					</div>
					
					<div class="col-md-2 col-sm-2 form-group">
						<label for="situacao">Situação:</label> <select class="form-control"
							name="situacao" id="situacao">
							<option value="">Selecione...</option>

							<c:forEach var="situacao" items="${listaSituacao}">
								<c:set var="selecao" value="" />
								<c:if test="${situacao.equals(veiculo.situacao)}">
									<c:set var="selecao" value="selected='selected'" />
								</c:if>
								<option ${selecao} value="${situacao.id}">${situacao.nome}</option>
							</c:forEach>
						</select>
					</div>
					
		
				</div><!-- fim da row -->

			</fieldset>
			<!-- fim do fieldset -->


			<div class="form-group">
				<button type="submit" class="btn btn-primary" name="btnSalvar"
					value="Salvar">Salvar</button>
				<button type="button" class="btn btn-danger" value="Cancelar"
					onclick="window.location = 'listarVeiculos'">Cancelar</button>
			</div>
			<!--/fim form-group -->
		</form>
		<!--/fim form -->
	</div>
	<!--/fim container -->


	<!-- Core JS -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/validacao.js"></script>

</body>
</html>
