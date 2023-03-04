package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.CompraPasaje;
import com.example.demo.repository.model.Vuelo;
import com.example.demo.service.ICompraPasajeService;
import com.example.demo.service.IVuelosService;
import com.example.demo.service.TO.BuscarVueloTO;
import com.example.demo.service.TO.VueloBuscarPorNumeroTO;
import com.example.demo.service.TO.VueloTO;

@RestController
@RequestMapping("/vuelos")
@CrossOrigin
public class VuelosControllerRestful {

	@Autowired
	private IVuelosService iVuelosService;

	@GetMapping
	List<VueloTO> buscarVuelosDisponibles(@RequestParam("origen") String origen,
			@RequestParam("destino") String destino, @RequestParam("fechaVuelo") String fecha) {
		BuscarVueloTO buscarVueloTO = new BuscarVueloTO();
		buscarVueloTO.setDestino(destino);
		buscarVueloTO.setOrigen(origen);
		buscarVueloTO.setFechaVuelo(fecha);
		return this.iVuelosService.buscarVuelosDisponibles(buscarVueloTO);
	}



}
