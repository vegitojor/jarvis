package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Editorial;
import ar.edu.unlam.tallerweb1.modelo.Formato;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("formatoDao")
public class FormatoDaoImpl implements FormatoDao{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Formato> listarFormatos() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Formato> formatos = session.createCriteria(Formato.class).list();
		
		return formatos;
	}

	@Override
	public Formato buscarFormatoPorNombre(String nombre) {
		final Session session = sessionFactory.getCurrentSession();
		return (Formato) session.createCriteria(Formato.class)
				.add(Restrictions.ilike("nombre", nombre))
				.uniqueResult();
	}

	@Override
	public Formato buscarFormato(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		Formato formato = (Formato) session.createCriteria(Formato.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		return formato;
	}

	@Override
	public void guardarNuevoFormato(Formato formato) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(formato);
	}

	@Override
	public void guardarFormato(Formato formato) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(formato);
	}
}
