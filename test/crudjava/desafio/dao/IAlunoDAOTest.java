package crudjava.desafio.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import crudjava.desafio.model.Aluno;

class IAlunoDAOTest {
	private DriverManagerDataSource dataSource;
	private IAlunoDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/alunos");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		
		dao = new AlunoDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {		
		Aluno aluno = new Aluno(002,"João da Silva",14);
		int result = dao.save(aluno);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Aluno aluno = new Aluno(003,"Zé do Teste Alterado",18);
		int result = dao.update(aluno);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id_aluno = 3;
		Aluno aluno = dao.get(id_aluno);
		
		if(aluno != null) {
			System.out.println(aluno);
		}
		
		assertNotNull(aluno);
	}

	@Test
	void testDelete() {
		Integer id_aluno = 2;
		int result = dao.delete(id_aluno);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Aluno> listaDeAlunos = dao.list();
		
		for(Aluno umAluno : listaDeAlunos) {
			System.out.println(umAluno);
		}
		
		assertTrue(!(listaDeAlunos.isEmpty()));
	}

}
