package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Editorial;

@Service("editorialDao")
public class EditorialDaoImpl implements EditorialDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Editorial buscarEditorial(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		Editorial editorial = (Editorial) session.createCriteria(Editorial.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		return editorial;
	}

	@Override
	public List<Editorial> listarEditoriales() {
		final Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Editorial> editoriales = session.createCriteria(Editorial.class).list();
		
		return editoriales;
	}
}
