package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Comic;

@Service("autorDao")
public class AutorDaoImpl implements AutorDao {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Autor buscarAutor(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Autor) session.createCriteria(Autor.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comic> listarComicsPorAutor(Long idAutor) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Comic.class)
				.add(Restrictions.eq("autor.id", idAutor)).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Autor> listarAutores() {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Autor.class).list();
	}

	@Override
	public void guardarNuevoAutor(Autor autor) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(autor);
	}

	@Override
	public void guardarAutor(Autor autor) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(autor);
	}

}