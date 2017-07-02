package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;

@Service("coleccionDao")
public class ColeccionDaoImpl implements ColeccionDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Coleccion buscarColeccion(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		Coleccion coleccion = (Coleccion) session.createCriteria(Coleccion.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		return coleccion;
	}
	
	@Override
	public List<Coleccion> listarColecciones() {
		final Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Coleccion> colecciones = session.createCriteria(Coleccion.class).list();

		return colecciones;
	}

	@Override
	public void guardarNuevaColeccion(Coleccion coleccion) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(coleccion);
	}

	@Override
	public void guardarColeccion(Coleccion coleccion) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(coleccion);
	}
}
