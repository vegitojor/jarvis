<!-- Modal Comic -->
<div class="modal fade" id="modalComic">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title"><span id="comicTitulo"></span></h4>
			</div>
			<div class="modal-body">
				<div class="row detalle-comic">
					<div class="col-xs-5 col-sm-6 col-md-6">
						<img id="comicImagen" src="" class="img-responsive center-block">
					</div>
					<div class="col-xs-7 col-sm-6 col-md-6">
						<p>
							<strong>Fecha de publicaci&oacute;n:</strong>&nbsp;<span id="comicFechaPublicacion"></span>
						</p>
						<p>
							<strong>Autor: </strong>&nbsp;<span id="comicAutor"></span>
						</p>
						<p>
							<strong>Cantidad de p&aacute;ginas: </strong>&nbsp;<span id="comicCantidadDePaginas"></span>
						</p>
						<p>
							<strong>I.S.B.N.: </strong>&nbsp;<span id="comicISBN"></span>
						</p>
						<p>
							<strong>P.V.P.: </strong>$&nbsp;<span id="comicPVP"></span>
						</p>
						<hr>
						<p>
							<strong>Adquirido el <span id="usuarioComicFecha"></span></strong>
						</p>
						<hr>
						<form action="guardar-usuario-comic" method="POST" name="marcarComic" id="marcarComic">
							<input type="hidden" name="comic" id="idComic" value=""/>
							<input type="hidden" name="usuario" id="idUsuario" value="${usuario.id}" />
							<input type="hidden" name="siguiendoActualmente" id="siguiendoActualmente" value="false"/>
							<button id="saveUsuarioComic" class="btn btn-danger btn-block" name="submit" type="submit"><span class="glyphicon glyphicon-trash"></span>&nbsp;Quitar de la lista</button>
						</form>
					</div>
				</div>
				<div class="row" id="comentarios" style="display: none;">
				</div>
			</div>
			<div class="modal-footer">
			  	<a href="#" class="btn btn-default" data-dismiss="modal">Cerrar</a>
			</div>
		</div>
	</div>
</div>