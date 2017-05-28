
package ar.edu.unlam.tallerweb1.servicios;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;
import ar.edu.unlam.tallerweb1.modelo.Comic;

@Service
public class ServicioColeccionImpl implements ServicioColeccion {

	@Override
	public List<Comic> buscarComic(Long id) {
		List<Comic> listaDeComic = new LinkedList<Comic>();
		List<Comic> listaFiltrada = new LinkedList<Comic>();
		
		Coleccion coleccion1 = new Coleccion(1L, "nombre", "Descripcion de coleccion 1", null, null, null, null, true, "1");
		Coleccion coleccion2 = new Coleccion(1L, "nombre", "Descripcion de coleccion 2", null, null, null, null, true, "2");
		
		Comic comic1 = new Comic(1L, "aaa", "1", null, coleccion1, "ab", "24", null, null, null);
		Comic comic2 = new Comic(2L, "baa", "2", null, coleccion1, "ab", "24", null, null, null);
		Comic comic3 = new Comic(3L, "caa", "3", null, coleccion1, "ab", "24", null, null, null);
		Comic comic4 = new Comic(4L, "daa", "4", null, coleccion1, "ab", "24", null, null, null);
		Comic comic5 = new Comic(5L, "eaa", "1", null, coleccion2, "ab", "24", null, null, null);
		Comic comic6 = new Comic(6L, "baa", "5", null, coleccion1, "ab", "24", null, null, null);
		Comic comic7 = new Comic(7L, "caa", "2", null, coleccion2, "ab", "24", null, null, null);
		Comic comic8 = new Comic(8L, "daa", "3", null, coleccion2, "ab", "24", null, null, null);
		Comic comic9 = new Comic(9L, "eaa", "6", null, coleccion1, "ab", "24", null, null, null);
		
		
		listaDeComic.add(comic1);
		listaDeComic.add(comic2);
		listaDeComic.add(comic3);
		listaDeComic.add(comic4);
		listaDeComic.add(comic5);
		listaDeComic.add(comic6);
		listaDeComic.add(comic7);
		listaDeComic.add(comic8);
		listaDeComic.add(comic9);
		
		
		for (Comic comic : listaDeComic) {
			if(comic.getColeccion().getId().equals(id))
				listaFiltrada.add(comic);
		}
		return listaFiltrada;
	}

}
