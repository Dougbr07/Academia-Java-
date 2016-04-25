/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Douglas Oliveira
 */
public class AlunoDao {
    
   public boolean inserir(Aluno aluno) throws Exception {
		
		PreparedStatement pst = null;
		
		//query sql para inserir no banco de dados
		//as interrogacoes serao os valores, que sao passados atraves do objeto pst no metodo setObject
		//onde pst.setObject(1, "") se refere ao primeiro campo, pst.setObject(2, "") se refere ao segundo campo e assim por diante;
		String query = "insert into aluno(nome, cpf, altura, peso, idade,telefone, endereco) values (?,?,?,?,?,?,?)";
		
		try { //tenta executar os comandos desse bloco. Se houver algum erro, ira entrar no catch { }
			pst = ConexaoBanco.getAbreConexao().prepareStatement(query);
			
              pst.setString(1, aluno.getNome());
              pst.setString (2,aluno.getCpf());
              pst.setDouble(3, aluno.getAltura());
              pst.setDouble (4, aluno.getPeso());
              pst.setInt (5, aluno.getIdade());
              pst.setString(6, aluno.getTelefone());
              pst.setString(7, aluno.getEndereco());
			
			pst.executeUpdate(); //executa a query
			pst.close(); //fecha a PreparedStatement
		} catch (SQLException e) { //Entra aqui quando tiver erro no bloco acima (try)
			e.printStackTrace(); //imprime no console onde ocorreu o erro (qual linha)
			e.getMessage(); //imprime a mensagem do erro
			return false; //retorna falso
		}
		return true;
	}
	
	public void alterar(Aluno aluno) throws Exception {

        String sql = "update aluno set nome=?, idade=?, endereco=?, cpf=?, telefone=?, peso=?, altura=? WHERE id_aluno = "+ aluno.getIdAluno();
      
        
        try (
           PreparedStatement stmt = ConexaoBanco.getAbreConexao().prepareStatement(sql)) {
           stmt.setString(1, aluno.getNome());
           stmt.setInt(2, aluno.getIdade());
           stmt.setString(3, aluno.getEndereco());
           stmt.setString(4, aluno.getCpf());
           stmt.setString(5, aluno.getTelefone());
           stmt.setInt(6, aluno.getPeso());
           stmt.setDouble(7, aluno.getAltura());
           
           
           stmt.execute();
           stmt.close();
       }
                
	}
	
	public void excluir(Aluno aluno) throws Exception {
       
        String sql = "delete from aluno where id_aluno= ?";
        PreparedStatement stmt = ConexaoBanco.getAbreConexao().prepareStatement(sql);
        stmt.setLong(1, aluno.getIdAluno());
        stmt.execute();
        stmt.close();
	
        }
	
    public List<Aluno> consultarTodos(String nome) throws Exception {
     String sql = "select * from aluno where nome like ?";
      PreparedStatement stmt = ConexaoBanco.getAbreConexao().prepareStatement(sql);
      stmt.setString(1, nome);
      ResultSet rs = stmt.executeQuery();
      List<Aluno>minhaLista = new ArrayList<Aluno>();
      while(rs.next()){
          Aluno alunos = new Aluno();
				
        alunos.setIdAluno(rs.getInt("id_aluno"));
	alunos.setNome(rs.getString("nome"));
	alunos.setCpf(rs.getString("cpf"));
        alunos.setEndereco(rs.getString("endereco"));
	alunos.setIdade(rs.getInt("idade"));
	alunos.setPeso(rs.getInt("peso"));
        alunos.setAltura((float) rs.getDouble("altura"));
        alunos.setTelefone(rs.getString("telefone"));
     
          minhaLista.add(alunos);
      }
      rs.close();
      rs.close();
      return minhaLista;
	
   }
	
	
    
}
