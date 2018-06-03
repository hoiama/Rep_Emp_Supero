package br.com.supero.tasklist.regras;

import java.util.ArrayList;
import br.com.supero.tasklist.model.dao.ConsultarLista;
import br.com.supero.tasklist.model.dao.Deletar;
import br.com.supero.tasklist.model.dao.Referencia;
import br.com.supero.tasklist.model.entity.Task;

public class Controller {

	Deletar deletarDAO = new Deletar();

	/**
	 * Padrão: Strategy
	 * 
	 * @param cliente
	 * @param funcao
	 * @return
	 */
	public boolean executar(Task tarefa, Referencia referencia) {
		return referencia.executa(tarefa);
	}

	public ArrayList<Task> consultarLista() {
		ConsultarLista lista = new ConsultarLista();
		return lista.buscarListaTarefas();
	}

}
