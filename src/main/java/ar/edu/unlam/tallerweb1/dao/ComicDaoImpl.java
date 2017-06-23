package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Comic;

@Service("comicDao")
public class ComicDaoImpl implements ComicDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Comic agregarNuevoComic(Long id) {
		final Session session = sessionFactory.openSession();
		Comic comic = (Comic) session.createCriteria(Comic.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		return comic;
	}

	@Override
	public Comic buscarComic(Long id) {
		final Session session = sessionFactory.openSession();
		Comic comic = (Comic) session.createCriteria(Comic.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		return comic;
	}
}
