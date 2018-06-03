package br.com.supero.tasklist.model.dao;

import javax.persistence.EntityManager;
import br.com.supero.tasklist.model.entity.Task;

public class Editar extends Util implements Referencia {

	public boolean executa(Task tarefa) {
		Util util = new Util();
		EntityManager em = util.getEm();
		try {
			em.getTransaction().begin();
			em.merge(tarefa);
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
