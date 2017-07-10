Sugerido<!-- Modal Comic Sugerido -->
<div class="modal fade" id="modalComicSugerido">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title"><span id="comicSugeridoTitulo"></span></h4>
			</div>
			<div class="modal-body">
				<div class="row detalle-comic">
					<div class="col-xs-5 col-sm-6 col-md-6">
						<img id="comicSugeridoImagen" src="" class="img-responsive center-block">
					</div>
					<div class="col-xs-7 col-sm-6 col-md-6">
						<p>
							<strong>Fecha de publicaci&oacute;n:</strong>&nbsp;<span id="comicSugeridoFechaPublicacion"></span>
						</p>
						<p>
							<strong>Formato: </strong>&nbsp;<span id="comicSugeridoFormato"></span>
						</p>
						<p>
							<strong>Editorial: </strong>&nbsp;<span id="comicSugeridoEditorial"></span>
						</p>
						<p>
							<strong>Autor: </strong>&nbsp;<span id="comicSugeridoAutor"></span>
						</p>
						<p>
							<strong>Cantidad de p&aacute;ginas: </strong>&nbsp;<span id="comicSugeridoCantidadDePaginas"></span>
						</p>
						<p>
							<strong>I.S.B.N.: </strong>&nbsp;<span id="comicSugeridoISBN"></span>
						</p>
						<p>
							<strong>P.V.P.: </strong>$&nbsp;<span id="comicSugeridoPVP"></span>
						</p>
						<hr>
						<form action="guardar-usuario-comic" method="POST" name="marcarComic" id="marcarComic">
							<input type="hidden" name="comic" id="idComicSugerido" value=""/>
							<input type="hidden" name="usuario" id="idUsuario" value="${usuario.id}" />
							<input type="hidden" name="siguiendoActualmente" id="siguiendoActualmente" value="true"/>
							<button id="saveUsuarioComic" class="btn btn-primary btn-block" name="submit" type="submit"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Marcar comic</button>
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