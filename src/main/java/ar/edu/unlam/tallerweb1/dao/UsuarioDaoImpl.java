package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(usuario);
	}

	@Override
	public Usuario obtenerUsuarioPorMail(String email) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add( Restrictions.eq("email", email) )
				.uniqueResult();
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add( Restrictions.eq("id", id) )
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> obtenerUsuarioConCriterion(Criterion criterion) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Usuario.class).add(criterion).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> obtenerTodosLosUsuariosRegistrados() {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Usuario.class).list();
	}
}
