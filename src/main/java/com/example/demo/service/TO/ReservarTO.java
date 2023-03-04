package com.example.demo.service.TO;

public class ReservarTO {
	private String numero;
	private Integer cantidad;
	private Integer tarjeta;

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Integer tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
