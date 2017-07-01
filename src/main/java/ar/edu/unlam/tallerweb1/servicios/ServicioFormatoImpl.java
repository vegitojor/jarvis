package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.FormatoDao;
import ar.edu.unlam.tallerweb1.modelo.Formato;

@Service("servicioFormato")
@Transactional
public class ServicioFormatoImpl implements ServicioFormato {
	
	@Inject
	private FormatoDao formatoDao;

	@Override
	public List<Formato> listarFormatos() {
		List<Formato> formatos = formatoDao.listarFormatos();
		return formatos;
	}

	@Override
	public Formato buscarFormatoPorNombre(String nombre) {
		return formatoDao.buscarFormatoPorNombre(nombre.replace("-", "%"));
	}
}