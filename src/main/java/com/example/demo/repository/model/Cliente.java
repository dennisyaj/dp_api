package com.example.demo.repository.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
	@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)
	@Column(name = "clie_id")
	private Integer id;

	@Column(name = "clie_nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<CompraPasaje> listCompraPasajes;
	//gets and sets

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<CompraPasaje> getListCompraPasajes() {
		return listCompraPasajes;
	}

	public void setListCompraPasajes(List<CompraPasaje> listCompraPasajes) {
		this.listCompraPasajes = listCompraPasajes;
	}
	
	
}
