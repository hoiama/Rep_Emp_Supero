package br.com.supero.tasklist.model.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import br.com.supero.tasklist.model.entity.Task;

public class Deletar implements Referencia, Serializable {
	private static final long serialVersionUID = 1L;

	public boolean executa(Task tarefa) {

		Util util = new Util();
		EntityManager em = util.getEm();

		try {
			em.getTransaction().begin();
			Task tarefaId = em.find(Task.class, tarefa.getId());
			em.remove(tarefaId);
			em.getTransaction().commit();
			em.close();
			return true;

		} catch (Exception e) {
			System.out.println("Erro 'DELETAR' do Hibernate");
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}

	}

}
