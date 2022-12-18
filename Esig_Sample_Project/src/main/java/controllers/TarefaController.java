package controllers;

import java.util.ArrayList;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import dominio.Tarefa;
import persistencia.TarefaDAO;

@ManagedBean(name = "TarefaController")
@ViewScoped
public class TarefaController {
	private ListDataModel<Tarefa> tarefas;
	private Tarefa tarefa = new Tarefa();;

	@PostConstruct
	public void buscarTarefas() {
		tarefas = new ListDataModel<>(TarefaDAO.listar());
	}
	
	public void prepararInserir() {
		tarefa = new Tarefa();
	}
	public void prepararEditar() {
		tarefa = tarefas.getRowData();
	}
	
	public void inserir() {
		tarefa.setSituacao("em andamento");
		TarefaDAO.inserir(tarefa);
		tarefas = new ListDataModel<>(TarefaDAO.listar());
	}
	
	public void atualizar(){
		TarefaDAO.atualizar(tarefa);
		tarefas = new ListDataModel<>(TarefaDAO.listar());
	}
	
	public void completar() {
		tarefa = tarefas.getRowData();
		TarefaDAO.concluir(tarefa);
		tarefas = new ListDataModel<>(TarefaDAO.listar());
	}

	public void remover() {
		tarefa = tarefas.getRowData();
		TarefaDAO.remover(tarefa);
		tarefas = new ListDataModel<>(TarefaDAO.listar());
	}
	
	public void buscar() {
		ArrayList<Tarefa> t;
		if(tarefa == null || tarefa.getId() == null) {
			System.out.println("ADICIONE O ID OU SELECIONE A PRIORIDADE");
			this.tarefas = null;
		}else{
			this.tarefa = TarefaDAO.buscarId(tarefa);
			t = new ArrayList<>();
			t.add(tarefa);
			this.tarefas = new ListDataModel<>(t);
		}	
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public ListDataModel<Tarefa> getTarefas() {
		return tarefas;
	}

}
