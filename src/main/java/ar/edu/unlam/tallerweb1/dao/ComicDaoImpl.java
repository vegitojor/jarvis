package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

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
	public Comic buscarComic(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		Comic comic = (Comic) session.createCriteria(Comic.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		return comic;
	}

	@Override
	public List<Comic> listarComics() {
		final Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Comic> comics = session.createCriteria(Comic.class).list();

		return comics;
	}

	@Override
	public void guardarNuevoComic(Comic comic) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(comic);
	}

	@Override
	public void guardarComic(Comic comic) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(comic);
	}
}
