package br.com.supero.tasklist.model.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.supero.tasklist.model.entity.Task;

public class ConsultarLista extends Util{
	
	//Implementar Try-catch
	public ArrayList<Task> buscarListaTarefas() {
		EntityManager em = getEm();
		em.getTransaction().begin();
		String queryJPQL = "select c from Task c";
		Query query = em.createQuery(queryJPQL);
		ArrayList<Task> tarefas = (ArrayList<Task>) query.getResultList();
		em.close();
		return tarefas;
	}	
	
	
}
