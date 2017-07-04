package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AutorDao;
import ar.edu.unlam.tallerweb1.modelo.Autor;

@Service("servicioAutor")
@Transactional
public class ServicioAutorImpl implements ServicioAutor {
	
	@Inject
	private AutorDao autorDao;
	
	@Override
	public Autor buscarAutor(Long id) {
		return autorDao.buscarAutor(id);
	}

	@Override
	public List<Autor> listarAutores() {
		return autorDao.listarAutores();
	}

	@Override
	public void guardarAutor(Autor autor) {
		if ( autor.getId() != null ) {
			autorDao.guardarAutor(autor);
		} else {
			autorDao.guardarNuevoAutor(autor);
		}
	}
}