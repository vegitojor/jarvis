package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;

@Service("coleccionDao")
public class ColeccionDaoImpl implements ColeccionDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<Coleccion> listarColecciones() {
		final Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Coleccion> colecciones = session.createCriteria(Coleccion.class).list();

		return colecciones;
	}
}
