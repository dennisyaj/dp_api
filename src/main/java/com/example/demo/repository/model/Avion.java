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
@Table(name = "avion")
public class Avion {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_avion") 
	@SequenceGenerator(name = "seq_avion", sequenceName = "seq_avion", allocationSize = 1) 
	@Column(name = "avio_id") 
	private Integer id;
	
	@Column(name = "avio_capacidad_asientos") 
	private Integer capacidadAsientos;
	
	@Column(name = "avio_nombre_avion") 
	private String nombreAvion;
	
	@OneToMany(mappedBy = "avion", cascade = CascadeType.ALL)
	private List<Vuelo> vuelos;
	
//gets and sets
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidadAsientos() {
		return capacidadAsientos;
	}

	public void setCapacidadAsientos(Integer capacidadAsientos) {
		this.capacidadAsientos = capacidadAsientos;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public String getNombreAvion() {
		return nombreAvion;
	}

	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}
	
	
}
