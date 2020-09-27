package crudjava.desafio.dao;

import java.util.List;

import crudjava.desafio.model.Aluno;

public interface IAlunoDAO {
	public int save(Aluno aluno);
	
	public int update(Aluno aluno);
	
	public Aluno get(Integer id_aluno);
	
	public int delete(Integer id_aluno);
	
	public List<Aluno> list();
}
