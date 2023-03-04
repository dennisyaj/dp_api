package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVueloRepository;
import com.example.demo.repository.model.Vuelo;
import com.example.demo.service.TO.BuscarVueloTO;
import com.example.demo.service.TO.VueloBuscarPorNumeroTO;
import com.example.demo.service.TO.VueloTO;
@Service

public class VuelosServiceImpl implements IVuelosService {

	@Autowired
	private IVueloRepository iVueloRepository;
	@Override
	public List<VueloTO> buscarVuelosDisponibles(BuscarVueloTO buscarVueloTO) {
		List<Vuelo> vuelos = this.iVueloRepository.buscarVuelosDisponibles(buscarVueloTO.getOrigen(), buscarVueloTO.getDestino(), buscarVueloTO.getFechaVuelo());
				return vuelos.stream().map(v-> convertirVueloATO(v)).collect(Collectors.toList());
	}
	
	public VueloTO convertirVueloATO(Vuelo vuelo) {
		VueloTO vueloTO = new VueloTO();
		vueloTO.setCategoria(vuelo.getCategoria());
		vueloTO.setDestino(vuelo.getDestino());
		vueloTO.setNombreAvion(vuelo.getAvion().getNombreAvion());
		vueloTO.setNumero(vuelo.getNumero());
		vueloTO.setOrigen(vuelo.getOrigen());
		vueloTO.setValorAsiento(vuelo.getValorAsiento());
		return vueloTO;
	}

	@Override
	public VueloBuscarPorNumeroTO buscarNumeroVuelo(String numero) {
		Vuelo vuelo = this.iVueloRepository.buscarNumeroVuelo(numero);
		VueloBuscarPorNumeroTO vueloBuscarPorNumeroTO = new VueloBuscarPorNumeroTO();
		vueloBuscarPorNumeroTO.setDisponibles(vuelo.getAsientoDisponibles());
		vueloBuscarPorNumeroTO.setOcupados(vuelo.getAvion().getCapacidadAsientos()-vuelo.getAsientoDisponibles());
		return vueloBuscarPorNumeroTO;
	}
	
	@Override
	public Vuelo buscarVueloPorNumero(String numero) {
		return  this.iVueloRepository.buscarNumeroVuelo(numero);
	}
}
