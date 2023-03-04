package com.example.demo.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.repository.model.CompraPasaje;
import com.example.demo.service.TO.ReservarTO;

public interface ICompraPasajeService {
	
	CompraPasaje buscarPorNumero(String numero);
	void actualizar(CompraPasaje compraPasaje);
	void reservar( ReservarTO reservarTO) ;
}
