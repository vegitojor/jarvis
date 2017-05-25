
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
		
		Comic comic1 = new Comic(1L, "aaa", "1", null, 1L, null, "ab", "24", null, null, "../../img/250px/venf3010_250px.jpg");
		Comic comic2 = new Comic(2L, "baa", "2", null, 1L, null, "ab", "24", null, null, "../../img/250px/venf3010_250px.jpg");
		Comic comic3 = new Comic(3L, "caa", "3", null, 1L, null, "ab", "24", null, null, "../../img/250px/venf3010_250px.jpg");
		Comic comic4 = new Comic(4L, "daa", "1", null, 2L, null, "ab", "24", null, null, "../../img/250px/venf3010_250px.jpg");
		Comic comic5 = new Comic(5L, "eaa", "2", null, 2L, null, "ab", "24", null, null, "../../img/250px/venf3010_250px.jpg");
		
		listaDeComic.add(comic1);
		listaDeComic.add(comic2);
		listaDeComic.add(comic3);
		listaDeComic.add(comic4);
		listaDeComic.add(comic5);
		
		
		for (Comic comic : listaDeComic) {
			if(comic.getColeccion().equals(id))
				listaFiltrada.add(comic);
			
		}
		return listaFiltrada;
	}

}
