package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Comic;
import ar.edu.unlam.tallerweb1.modelo.UsuarioComic;

@Service("comicDao")
public class ComicDaoImpl implements ComicDao {

	@Inject
	private SessionFactory sessionFactory;
	@Inject
	private UsuarioComicDao usuarioComicDao;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Comic> listarComicsDeColeccion(Long idColeccion) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Comic.class)
				.add(Restrictions.eq("coleccion.id", idColeccion)).list();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Comic> listarComicsConCriterion(Criterion criterion) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Comic.class).add(criterion).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comic> listarSugerencias(Long idUsuario) {
		final Session session = sessionFactory.getCurrentSession();
		
		List<UsuarioComic> usuarioComics = usuarioComicDao.listarUsuarioComicsSiguiendoActualmente(idUsuario);
		
		List <Long> idComicsUsuario = new ArrayList<Long>();
		for (UsuarioComic usuarioComic : usuarioComics) {
			idComicsUsuario.add(usuarioComic.getComic().getId());
		}
		
		Criterion criterionSugerencias = Restrictions.ge("id", 1L);
		if ( idComicsUsuario.size() > 0 ) {
			criterionSugerencias = Restrictions.and( criterionSugerencias, Restrictions.not(Restrictions.in("id", idComicsUsuario)) );
		}
		
		return session.createCriteria(Comic.class).add(criterionSugerencias).list();
	}
}
