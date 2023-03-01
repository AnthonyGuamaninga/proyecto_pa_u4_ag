package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonaRepoImpl implements IPersonaRepo {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Persona> buscarCompleto() {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNativeQuery("SELECT * FROM persona", Persona.class);
		return query.getResultList();
	}

	@Override
	public Persona buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.persist(persona);
	}

}
