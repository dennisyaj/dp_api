package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.CompraPasaje;
import com.example.demo.service.ICompraPasajeService;
import com.example.demo.service.IVuelosService;
import com.example.demo.service.TO.ReservarTO;
import com.example.demo.service.TO.VueloBuscarPorNumeroTO;

@RestController
@RequestMapping("/comprasPasajes")
@CrossOrigin
public class CompraPasajeControllerRestful {
	
	@Autowired
	private ICompraPasajeService iCompraPasajeService;
	@Autowired
	private IVuelosService iVuelosService;

	@PutMapping(path = "/{numero}")
	private void checkIn(@PathVariable("numero") String numero) {
		CompraPasaje compraPasaje = this.iCompraPasajeService.buscarPorNumero(numero);
		compraPasaje.setEstado("I");
		this.iCompraPasajeService.actualizar(compraPasaje);
	}

		@GetMapping(path = "/{numero}")
	private VueloBuscarPorNumeroTO buscarVueloPorNumero(@PathVariable("numero") String numero) {
		return this.iVuelosService.buscarNumeroVuelo(numero);
	}
		
	@PostMapping
	private void reservar(@RequestBody ReservarTO reservarTO) {
	this.iCompraPasajeService.reservar(reservarTO);
	}

}
