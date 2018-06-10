package br.com.supero.tasklist.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Util {

	private static EntityManager em;

	public Util() {
		em = Persistence.createEntityManagerFactory("tasklist").createEntityManager();
	}

	public EntityManager getEm() {
		return em;
	}

}
