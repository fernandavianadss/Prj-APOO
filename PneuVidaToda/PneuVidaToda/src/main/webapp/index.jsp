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
				<a class="navbar-brand"> Pneu Vida Toda </a>
			</div>
			<!-- navbar-header -->
			<div id="navbar" class="navbar-collapse collapse"></div>
			<!--/fim navbar-collapse -->
		</div>
		<!--/fim container -->
	</nav>
	<!--/fim nav -->

	<!-- Card de cadastro -->

	<div class="container">
		<div class="row">
			<div class="col-md-3 col-xs-6">
				<div class="thumbnail">
					<img src="img/icone-carro.png" alt="avatar de veiculo" />
					<h3 class="title">Controle de Veículos</h3>
					<p>
						<a href="listarVeiculos" class="btn btn-primary" role="button">Novo
							Veículo</a></p>
				</div><!-- fim thumbnail -->
			</div><!-- fim col-md-3 -->
		</div><!-- fim row -->
	</div><!-- fim container -->


	<!-- Core JS
    ================================================== -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>
