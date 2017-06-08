package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ar.edu.unlam.tallerweb1.modelo.Comic;

public class ComicDaoImpl implements ComicDao {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Comic insertarEnLaTabla(Comic comic) {
		
		final Session session = sessionFactory.openSession();
		return (Comic) session.createCriteria(Comic.class)
				.add(Restrictions.eq("isbn", comic.getIsbn()))
				.add(Restrictions.eq("numero", comic.getNumero()))
				.add(Restrictions.eq("fechaPublicacion", comic.getFechaPublicacion()))
				.add(Restrictions.eq("coleccion", comic.getColeccion()))
				.add(Restrictions.eq("pvp", comic.getPvp()))
				.add(Restrictions.eq("cantPaginas", comic.getCantPaginas()))
				.add(Restrictions.eq("autor", comic.getAutor()))
				.add(Restrictions.eq("formato", comic.getFormato()))
				.uniqueResult();	
	}
	
	
	
	

}
