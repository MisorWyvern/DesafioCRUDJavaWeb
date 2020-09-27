package crudjava.desafio.model;

public class Aluno {
	private Integer id_aluno;
	private String nome;
	private Integer idade;

	public Aluno(Integer id_aluno, String nome, Integer idade) {
		super();
		this.id_aluno = id_aluno;
		this.nome = nome;
		this.idade = idade;
	}

	public Aluno() {
		
	}

	public Integer getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Aluno [id_aluno=" + id_aluno + ", nome=" + nome + ", idade=" + idade + "]";
	}

	
}
