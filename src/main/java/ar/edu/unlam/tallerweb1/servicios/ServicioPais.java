package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pais;

public interface ServicioPais {

	List<Pais> listarPaises();
	
	Pais obtenerPaisPorId(Long id);
}
