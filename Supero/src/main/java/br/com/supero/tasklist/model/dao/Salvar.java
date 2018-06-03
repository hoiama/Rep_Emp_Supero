package br.com.supero.tasklist.model.dao;

import javax.persistence.EntityManager;
import br.com.supero.tasklist.model.entity.Task;

public class Salvar implements Referencia {

		public boolean executa(Task tarefa) {
		
		Util util = new Util();
		EntityManager em = util.getEm();
			
			try {
				em.getTransaction().begin();
				em.persist(tarefa);
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Erro 'SALVAR' do Hibernate");
				em.getTransaction().rollback();
				return false;
			} finally {
				em.close();
			}
			
		}
		
}
	
