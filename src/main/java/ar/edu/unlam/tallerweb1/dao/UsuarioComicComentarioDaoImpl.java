package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.UsuarioComic;
import ar.edu.unlam.tallerweb1.modelo.UsuarioComicComentario;

@Service("usuarioComicComentarioDao")
public class UsuarioComicComentarioDaoImpl implements UsuarioComicComentarioDao {
	
	@Inject
    private SessionFactory sessionFactory;
	@Inject
	private UsuarioComicDao usuarioComicDao;
	
	@Override
	public void guardarUsuarioComicComentario(UsuarioComicComentario usuarioComicComentario) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(usuarioComicComentario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioComicComentario> listarUsuarioComicComentarios(Long idUsuarioComic) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(UsuarioComicComentario.class)
				.add(Restrictions.and(	Restrictions.eq("usuarioComic.id", idUsuarioComic),
										Restrictions.eq("disponible", true))).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioComicComentario> listarUsuarioComicComentarios(Criterion criterion) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(UsuarioComicComentario.class)
				.add(criterion).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioComicComentario> listarNotificaciones(Long idUsuario) {
		final Session session = sessionFactory.getCurrentSession();
		
		List<UsuarioComic> usuarioComics = usuarioComicDao.listarUsuarioComicsSiguiendoActualmente(idUsuario);
		
		List<Long> idsUsuarioComic = new ArrayList<Long>();
		for (UsuarioComic usuarioComic : usuarioComics) {
			idsUsuarioComic.add(usuarioComic.getId());
		}
		
		Criterion criterionNotificaciones = Restrictions.eq("disponible", true);
		if ( idsUsuarioComic.size() > 0 ) {
			criterionNotificaciones = Restrictions.and( criterionNotificaciones, Restrictions.in("usuarioComic.id", idsUsuarioComic) );
		}
		
		return session.createCriteria(UsuarioComicComentario.class).add(criterionNotificaciones).list();
	}

	@Override
	public UsuarioComicComentario obtenerUsuarioComicComentario(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (UsuarioComicComentario) session.createCriteria(UsuarioComicComentario.class).add(Restrictions.eq("id", id)).uniqueResult();
	}
}