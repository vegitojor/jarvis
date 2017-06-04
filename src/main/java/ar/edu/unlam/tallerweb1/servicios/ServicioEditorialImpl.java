package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.EditorialDao;
import ar.edu.unlam.tallerweb1.modelo.Editorial;

@Service("servicioEditorial")
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

}
