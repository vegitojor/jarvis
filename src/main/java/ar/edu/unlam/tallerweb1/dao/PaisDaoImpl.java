package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Pais;

@Service("paisDao")
public class PaisDaoImpl implements PaisDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Pais consultarPais(Pais pais) {
		return null;
	}

	@Override
	public List<Pais> listarPaises() {
		final Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Pais> paises = session.createCriteria(Pais.class).list();
		
		return paises;
	}
}
