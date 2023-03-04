package com.example.demo.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Vuelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, String fechaVuelo) {
		TypedQuery<Vuelo> query = this.entityManager.createQuery(
				"SELECT v FROM Vuelo v WHERE v.origen=:origen and v.destino=:destino and v.fechaVuelo=:fechaVuelo and v.estado=:estado",
				Vuelo.class);
		query.setParameter("origen", origen);
		query.setParameter("destino", destino);
		query.setParameter("estado", "D");
		LocalDateTime fecha =LocalDate.parse(fechaVuelo,DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay();
		query.setParameter("fechaVuelo",fecha);
		return query.getResultList();
	}

	@Override
	public Vuelo buscarNumeroVuelo(String numero) {
		TypedQuery<Vuelo> query = this.entityManager
				.createQuery("SELECT v FROM Vuelo v WHERE v.numero=:numero and v.estado=:estado", Vuelo.class);
		query.setParameter("numero", numero);
		query.setParameter("estado", "D");
		return query.getSingleResult();
	}

}
