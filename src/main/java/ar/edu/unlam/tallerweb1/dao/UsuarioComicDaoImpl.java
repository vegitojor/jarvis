package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Comic;
import ar.edu.unlam.tallerweb1.modelo.UsuarioComic;

@Service("usuarioComicDao")
public class UsuarioComicDaoImpl implements UsuarioComicDao {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public void guardarNuevoUsuarioComic(UsuarioComic usuarioComic) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(usuarioComic);
	}

	@Override
	public void guardarUsuarioComic(UsuarioComic usuarioComic) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(usuarioComic);
	}

	@Override
	public List<Comic> comicsDelUsuario(Long idUsuario) {
		List<Comic> comics = new ArrayList<Comic>();
		final Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<UsuarioComic> usuarioComics = session.createCriteria(UsuarioComic.class).add(Restrictions.eq("usuario.id", idUsuario)).list();
		
		if ( usuarioComics.size() > 0 ) {
			for (UsuarioComic usuarioComic : usuarioComics) {
				comics.add(usuarioComic.getComic());
			}
		}
		
		return comics;
	}

	@Override
	public UsuarioComic consultarUsuarioComic(Long idUsuario, Long idComic) {
		final Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<UsuarioComic> usuarioComics = session.createCriteria(UsuarioComic.class)
											.add(Restrictions.and(	Restrictions.eq("usuario.id", idUsuario),
																	Restrictions.eq("comic.id", idComic))).list();
		if ( usuarioComics.size() < 1 ) {
			return null;
		} else {
			return usuarioComics.get(0);
		}
	}
}