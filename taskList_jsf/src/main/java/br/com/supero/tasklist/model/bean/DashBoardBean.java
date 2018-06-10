package br.com.supero.tasklist.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import br.com.supero.tasklist.model.dao.Deletar;
import br.com.supero.tasklist.model.dao.Editar;
import br.com.supero.tasklist.model.dao.Referencia;
import br.com.supero.tasklist.model.dao.Salvar;
import br.com.supero.tasklist.model.entity.Task;
import br.com.supero.tasklist.regras.Controller;

@ManagedBean(name = "DashBoardBean")
@ViewScoped
public class DashBoardBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	private Task tarefaSelecionada;
	private ArrayList<Task> tarefas = new ArrayList<Task>();
	private Controller controleRegras = new Controller();
	private Task tarefa = new Task();
	

	Referencia classSalvar = new Salvar();
	Referencia classEditar = new Editar();
	Referencia classDeletar = new Deletar();
	
			
	public void salvar(){
		controleRegras.executar(tarefa, classSalvar);
	}
	
	public void editar (RowEditEvent event){ 
		controleRegras.executar((Task) event.getObject(), classEditar);
	}
	
	public void deletar(){
		controleRegras.executar(tarefaSelecionada, classDeletar);
	}
	
	public void listaTarefas() {
		setTarefas(controleRegras.consultarLista());
	}
	
	
	//Getter and Setter

	public Task getTarefa() {
		return tarefa;
	}

	public void setTarefa(Task tarefa) {
		this.tarefa = tarefa;
	}

	public List<Task> getTarefas() {
		return tarefas;
	}

	public void setTarefas(ArrayList<Task> tarefas) {
		this.tarefas = tarefas;
	}

	public Task getTarefaSelecionada() {
		return tarefaSelecionada;
	}

	public void setTarefaSelecionada(Task tarefaSelecionada) {
		this.tarefaSelecionada = tarefaSelecionada;
	}

	
	
}
