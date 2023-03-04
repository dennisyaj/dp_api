package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICompraPasajeRepository;
import com.example.demo.repository.model.CompraPasaje;
import com.example.demo.repository.model.Vuelo;
import com.example.demo.service.TO.ReservarTO;

@Service
public class CompraPasajeServiceImpl implements ICompraPasajeService {
	@Autowired
	private ICompraPasajeRepository iCompraPasajeRepository;
	
	@Autowired
	private IVuelosService iVuelosService;

	@Override
	public CompraPasaje buscarPorNumero(String numero) {
		return this.iCompraPasajeRepository.buscarPorNumero(numero);
	}

	@Override
	public void actualizar(CompraPasaje compraPasaje) {
		this.iCompraPasajeRepository.actualizar(compraPasaje);
	}

	@Override
	public void reservar(ReservarTO reservarTO) {
		Vuelo vuelo = this.iVuelosService.buscarVueloPorNumero(reservarTO.getNumero());
		CompraPasaje compraPasaje = new CompraPasaje();
		compraPasaje.setCantidadAsientosComprados(reservarTO.getCantidad());
		compraPasaje.setNumeroTarjeta(reservarTO.getTarjeta());
		compraPasaje.setEstado("R");
		compraPasaje.setVuelo(vuelo);
		compraPasaje.setNumero(vuelo.getId().toString());
		vuelo.setAsientoDisponibles(vuelo.getAsientoDisponibles()- reservarTO.getCantidad());
		if (vuelo.getAsientoDisponibles()- reservarTO.getCantidad()<=0) {
			vuelo.setEstado("ND");
		}
				this.iCompraPasajeRepository.insertar(compraPasaje);
		
	}

}
