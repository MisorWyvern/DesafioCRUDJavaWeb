package crudjava.desafio.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import crudjava.desafio.model.Aluno;

public class AlunoDAOImpl implements IAlunoDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public AlunoDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int save(Aluno aluno) {
		String sql = "INSERT INTO tb_alunos(id_aluno, nome, idade) VALUES (?,?,?)";
		return jdbcTemplate.update(sql, aluno.getId_aluno(), aluno.getNome(), aluno.getIdade());
		
	}

	@Override
	public int update(Aluno aluno) {
		String sql = "UPDATE tb_alunos SET nome=?, idade=? WHERE id_aluno = ?";
		return jdbcTemplate.update(sql, aluno.getNome(), aluno.getIdade(), aluno.getId_aluno());
	}

	@Override
	public Aluno get(Integer id_aluno) {
		String sql = "SELECT * FROM tb_alunos WHERE id_aluno=" + id_aluno;
		
		ResultSetExtractor<Aluno> extractor = new ResultSetExtractor<Aluno>() {

			@Override
			public Aluno extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Integer id = rs.getInt("id_aluno");
					String nome = rs.getString("nome");
					Integer idade = rs.getInt("idade");
					
					return new Aluno(id,nome,idade);
				}
				return null;
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id_aluno) {
		String sql = "DELETE FROM tb_alunos WHERE id_aluno=" + id_aluno;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Aluno> list() {
		String sql = "SELECT * FROM tb_alunos";
		
		RowMapper<Aluno> rowMapper = new RowMapper<Aluno>() {

			@Override
			public Aluno mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id_aluno");
				String nome = rs.getString("nome");
				Integer idade = rs.getInt("idade");
				
				return new Aluno(id,nome,idade);
				
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
		
	}

}
