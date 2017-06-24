
package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ColeccionDao;
import ar.edu.unlam.tallerweb1.modelo.Coleccion;

@Service("servicioColeccion")
@Transactional
public class ServicioColeccionImpl implements ServicioColeccion {
	
	@Inject
	private ColeccionDao coleccionDao;
	
	@Override
	public List<Coleccion> listarColecciones() {
		return coleccionDao.listarColecciones();
	}
}
