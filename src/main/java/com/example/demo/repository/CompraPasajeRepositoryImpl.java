package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.CompraPasaje;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CompraPasajeRepositoryImpl implements ICompraPasajeRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void actualizar(CompraPasaje compraPasaje) {
		this.entityManager.merge(compraPasaje);
	}

	@Override
	public CompraPasaje buscarPorNumero(String numero) {
		TypedQuery<CompraPasaje> query = this.entityManager
				.createQuery("select c from CompraPasaje c where c.numero =:numero", CompraPasaje.class);
		query.setParameter("numero", numero);
		return query.getSingleResult();
	}

	@Override
	public void insertar(CompraPasaje compraPasaje) {
		this.entityManager.persist(compraPasaje);
	}

}
