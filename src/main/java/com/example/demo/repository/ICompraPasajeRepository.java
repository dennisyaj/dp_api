package com.example.demo.repository;

import com.example.demo.repository.model.CompraPasaje;

public interface ICompraPasajeRepository  {
	CompraPasaje buscarPorNumero(String numero);
	void actualizar(CompraPasaje compraPasaje);
	void insertar(CompraPasaje compraPasaje);
}
