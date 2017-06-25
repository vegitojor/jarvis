<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#jarvis-navbar-collapse" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="home" class="navbar-brand">
				<img src="img/logo_blanco.png" style="width: 100px;">
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="jarvis-navbar-collapse">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="colecciones">Colecciones</a></li>
				<li><a href="comics">Comics</a></li>
				<li><a href="editoriales">Editoriales</a></li>
				<li><a href="personajes">Personajes</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><c:out value="${usuario.nombre}"/>&nbsp;<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="home"><span class="glyphicon glyphicon-user"></span>&nbsp;Mi perfil</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>&nbsp;Salir</a></li>
					</ul>
				</li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
<section id="contenido">