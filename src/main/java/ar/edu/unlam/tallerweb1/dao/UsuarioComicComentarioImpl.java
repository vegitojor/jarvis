package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.UsuarioComicComentario;

@Service("usuarioComicComentarioDao")
public class UsuarioComicComentarioImpl implements UsuarioComicComentarioDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
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
}