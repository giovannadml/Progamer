package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Profile;
import br.com.fiap.util.EntityManagerFacade;

public class ProfileDAO {
	
	private EntityManager manager = EntityManagerFacade.getEntityManager();
	
	public void save(Profile profile) {
		manager.getTransaction().begin();
		manager.persist(profile);
		manager.getTransaction().commit();
		
		manager.clear();
	}
	
	public List<Profile> getAll(){
		String jpql = "SELECT s FROM Profile s";
		TypedQuery<Profile> query = manager.createQuery(jpql, Profile.class);
		return query.getResultList();
	}

}
