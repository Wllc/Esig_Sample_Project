package dominio;


public class Tarefa {
	private Long id;
	private String titulo;
	private String descricao;
	private String responsavel;
	private String prioridade;
	private String data;
	private String situacao;
	
	public Tarefa() {
		
	}
	public Tarefa(Long id, String titulo, String descricao, String responsavel, String prioridade, String date, String situacao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.responsavel = responsavel;
		this.prioridade = prioridade;
		this.data = date;
		this.situacao = situacao;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public String getData() {
		return data;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public Long getId() {
		return id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}
