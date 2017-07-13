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
	
	@Override
	public List<UsuarioComicComentario> listarNotificaciones(Long idUsuario) {
		return listarNotificaciones(idUsuario, null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioComicComentario> listarNotificaciones(Long idUsuario, Criterion criterion) {
		final Session session = sessionFactory.getCurrentSession();
		
		List<UsuarioComic> usuarioComics = usuarioComicDao.listarUsuarioComicsSiguiendoActualmente(idUsuario);
		
		
		if ( !usuarioComics.isEmpty() ) {
			
			List<Long> idsUsuarioComic = new ArrayList<Long>();
			for (UsuarioComic usuarioComic : usuarioComics) {
				idsUsuarioComic.add(usuarioComic.getId());
			}
			
			Criterion criterionNotificaciones = Restrictions.and(	Restrictions.eq("disponible", true),
																	Restrictions.in("usuarioComic.id", idsUsuarioComic) );
			
			if ( criterion!=null ) {
				criterionNotificaciones = Restrictions.and(criterionNotificaciones, criterion);
			}
			
			return session.createCriteria(UsuarioComicComentario.class).add(criterionNotificaciones).list();
			
		} else {
			
			return null;
		}
		
	}

	@Override
	public UsuarioComicComentario obtenerUsuarioComicComentario(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (UsuarioComicComentario) session.createCriteria(UsuarioComicComentario.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public Integer cantidadNotificacionesNoLeidas(Long idUsuario) {
		Criterion criterion = Restrictions.eq("leido", false);
		List<UsuarioComicComentario> notificaciones = listarNotificaciones(idUsuario, criterion);
		
		if ( notificaciones!=null && !notificaciones.isEmpty() ) {
			return notificaciones.size();
		} else {
			return 0;
		}
	}
}