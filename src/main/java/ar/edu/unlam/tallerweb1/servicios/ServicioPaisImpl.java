package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PaisDao;
import ar.edu.unlam.tallerweb1.modelo.Pais;


@Service("servicioPais")
@Transactional
public class ServicioPaisImpl implements ServicioPais {

	@Inject
	private PaisDao paisDao;

	@Override
	public List<Pais> listarPaises() {
		return paisDao.listarPaises();
	}

	@Override
	public Pais obtenerPaisPorId(Long id) {
		return paisDao.obtenerPaisPorId(id);
	}
	
	
}
