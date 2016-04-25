
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Douglas Oliveira
 */
public class ProfessorDao {
    public boolean inserir(Professor professor) throws Exception {
		
		PreparedStatement pst = null;
		
		
		String query = "insert into professor(nome, cpf,telefone, endereco, salario) values (?,?,?,?,?)";
		
		try { 
			pst = ConexaoBanco.getAbreConexao().prepareStatement(query);
			
              pst.setString(1, professor.getNome());
              pst.setString (2,professor.getCpf());
              pst.setString(3, professor.getTelefone());
              pst.setString (4, professor.getEndereco());
              pst.setDouble (5, professor.getSalario());
              
			
			pst.executeUpdate();
			pst.close(); 
		} catch (SQLException e) { 
			e.printStackTrace(); 
			e.getMessage(); 
			return false; 
		}
		return true;
	}
	
	public void alterar(Professor professor) throws Exception {
		String sql = "update professor set nome = ?, cpf = ?,telefone = ?, endereco = ?, salario = ? WHERE id_prof = "+professor.getIdProf();
		
	try ( 
		
                       PreparedStatement stmt = ConexaoBanco.getAbreConexao().prepareStatement(sql)) {	
			stmt.setObject(1, professor.getNome()); 
			stmt.setObject(2, professor.getCpf()); 
			stmt.setObject(3, professor.getTelefone()); 
			stmt.setObject(4, professor.getEndereco());
			stmt.setObject(5, professor.getSalario());
			
                        stmt.execute();
                        stmt.close();
                }
			

	}
        
	
	public void excluir(Professor professor) throws Exception {
       
        String sql = "delete from professor where id_prof= ?";
        PreparedStatement stmt = ConexaoBanco.getAbreConexao().prepareStatement(sql);
        stmt.setLong(1, professor.getIdProf());
        stmt.execute();
        stmt.close();
	
        }
	

	
public List<Professor> consultarTodos(String nome) throws Exception {
     String sql = "select * from professor where nome like ?";
      PreparedStatement stmt = ConexaoBanco.getAbreConexao().prepareStatement(sql);
      stmt.setString(1, nome);
      ResultSet rs = stmt.executeQuery();
      ArrayList<Professor>minhaLista = new ArrayList<Professor>();
      while(rs.next()){
          Professor professores = new Professor();
				
        professores.setIdProf(rs.getInt("id_prof"));
	professores.setNome(rs.getString("nome"));
	professores.setCpf(rs.getString("cpf"));
        professores.setEndereco(rs.getString("endereco"));
	professores.setTelefone(rs.getString("telefone"));
	professores.setSalario(rs.getFloat("salario"));

     
          minhaLista.add(professores);
      }
      rs.close();
      rs.close();
      return minhaLista;
	
   }
}
