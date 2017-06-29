package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.EditorialDao;
import ar.edu.unlam.tallerweb1.modelo.Editorial;
import ar.edu.unlam.tallerweb1.modelo.Formato;

@Service("servicioEditorial")
@Transactional
public class ServicioEditorialImpl implements ServicioEditorial {
	
	@Inject
	private EditorialDao editorialDao;

	@Override
	public Editorial buscarEditorial(Long id) {
		return editorialDao.buscarEditorial(id);
	}

	@Override
	public List<Editorial> listarEditoriales() {
		return editorialDao.listarEditoriales();
	}

	@Override
	public Editorial buscarEditorialPorNombre(String nombre) {
		return editorialDao.buscarEditorialPorNombre(nombre.replace("-", "%"));
	}
}
