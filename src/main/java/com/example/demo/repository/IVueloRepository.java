package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Vuelo;

public interface IVueloRepository {
	
	List<Vuelo> buscarVuelosDisponibles(String origen, String destino, String fechaVuelo);

	Vuelo buscarNumeroVuelo(String numero);

}
