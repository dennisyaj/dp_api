package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.model.Vuelo;
import com.example.demo.service.TO.BuscarVueloTO;
import com.example.demo.service.TO.VueloBuscarPorNumeroTO;
import com.example.demo.service.TO.VueloTO;

public interface IVuelosService {
	List<VueloTO> buscarVuelosDisponibles(BuscarVueloTO buscarVueloTO);
	VueloBuscarPorNumeroTO buscarNumeroVuelo(String numero);
	Vuelo buscarVueloPorNumero(String numero);
}
