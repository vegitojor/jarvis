package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Formato;

@Service
public class FormatoDaoImpl implements FormatoDao{
	
	@Inject SessionFactory sessionFactory;
	
	@Override
	public List<Formato> listarFormato() {
		@SuppressWarnings("unchecked")
		List<Formato> lista = sessionFactory.getCurrentSession().createCriteria(Formato.class).list();
		return lista;
	}

}
