<%@include file='../../includes/cabecera.jsp' %>
	<title>Vista Comic</title>
	<link rel="stylesheet" type="text/css" href="css\css_demian.css">
	<link rel="stylesheet" type="text/css" href="css\bootstrap.css">
	<script type="text/javascript" src="js\jquery-3.1.1.js"></script>	
	<script type="text/javascript"  src="js\bootstrap.js"></script>
</head>
<body>
	<div class="body-comic">
		<div class="col-md-12 col-xs-12 col-xl-6">
			<section class="imagen-normal"><img class="imagen-normal" src="img\500px\venf3010.jpg"></section>
			<section class="imagen-movil"><img class="imagen-movil" src="img\250px\venf3010_250px.jpg"></section>
		</div>
		<div class="col-md-12 col-xs-12 col-xl-6">
			<h2>${comic.coleccion}</h2>
			<h3>${comic.volumen}</h3>
			<h3>Nro. ${comic.numero}</h3>
			<h4>${comic.autor}</h4>
			<h4>${comic.formato}</h4>
			<h4>${comic.cantPaginas} p&aacute;ginas</h4>
			<h4>${comic.fechaPublicacion}</h4>
			<h4>P.V.P.: ${comic.pvp}</h4>
			<h4>ISBN: ${comic.isbn}</h4>
		
		<!-- REEMPLAZAR LO ANTERIOR POR ESTO QUE SIGUE		
			<p><h2>${comic.coleccion.nombre}</h2></p>
			<p><h3>${comic.coleccion.volumen}</h3></p>
			<p><h3>Nro. ${comic.numero}</h3></p>			
			<p><h4>${comic.autor.autor}</h4></p>
			<p><h4>${comic.formato.formato}</h4></p>
			<p><h4>${comic.cantPaginas} p&aacute;ginas</h4></p>
			<p><h4>${comic.fechaPublicacion}</h4></p>
			<p><h4>P.V.P.: ${comic.pvp}</h4></p>
			<p><h4>ISBN: ${comic.isbn}</h4></p>
		-->
		</div>
	</div>
<%@include file='../../includes/pie.jsp' %>