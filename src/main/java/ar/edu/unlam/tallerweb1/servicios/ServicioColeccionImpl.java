package ar.edu.unlam.tallerweb1.servicios;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Comic;

@Service
public class ServicioColeccionImpl implements ServicioColeccion {

	@Override
	public List<Comic> buscarComic(Long id) {
		List<Comic> listaDeComic = new LinkedList<Comic>();
		List<Comic> listaFiltrada = new LinkedList<Comic>();
		
		for (Comic comic : listaDeComic) {
			if(comic.getColeccion().equals(id))
				listaFiltrada.add(comic);
			
		}
		return listaFiltrada;
	}

}
