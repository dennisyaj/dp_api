package com.example.demo.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vuelo")
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vuelo")
	@SequenceGenerator(name = "seq_vuelo", sequenceName = "seq_vuelo", allocationSize = 1)
	@Column(name = "vuel_id")
	private Integer id;

	@Column(name = "vuel_numero")
	private String numero;

	@Column(name = "vuel_fecha_vuelo", columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaVuelo;
	
	@Column(name = "vuel_asiento_disponibles")
	private Integer asientoDisponibles;
	
	@Column(name = "vuel_valor_asiento")
	private BigDecimal valorAsiento;
	
	@Column(name = "vuel_estado")
	private String estado;
	
	@Column(name = "vuel_origen")
	private String origen;
	
	@Column(name = "vuel_destino")
	private String destino;
	
	@Column(name = "vuel_categoria")
	private String categoria;
	
	@ManyToOne
	@JoinColumn(name = "avio_id")
	private Avion avion;

	@OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
	private List<CompraPasaje> listCompraPasajes;
	// gets and sets

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDateTime fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Integer getAsientoDisponibles() {
		return asientoDisponibles;
	}

	public void setAsientoDisponibles(Integer asientoDisponibles) {
		this.asientoDisponibles = asientoDisponibles;
	}

	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}

	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public List<CompraPasaje> getListCompraPasajes() {
		return listCompraPasajes;
	}

	public void setListCompraPasajes(List<CompraPasaje> listCompraPasajes) {
		this.listCompraPasajes = listCompraPasajes;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
