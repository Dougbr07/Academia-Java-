/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
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
public class AulaDao {
    public boolean inserir(Aula aula) throws Exception {
		
		PreparedStatement pst = null;
		Connection conn = null;

                
		try { //tenta executar os comandos desse bloco. Se houver algum erro, ira entrar no catch { }
			conn = ConexaoBanco.getAbreConexao ();
                        pst = conn.prepareStatement ( "insert into aula (nome, preco, horario, id_prof) values (?,?,?,?)");
                        
                        pst.setString(1, aula.getNome());
                        pst.setDouble (2,aula.getPreco());
                        pst.setString(3, aula.getHorario());
                        pst.setInt (4, aula.getIdProf());
			
                        pst.executeUpdate(); //executa a query
			pst.close(); //fecha a PreparedStatement
		} catch (SQLException e) { //Entra aqui quando tiver erro no bloco acima (try)
			e.printStackTrace(); //imprime no console onde ocorreu o erro (qual linha)
			e.getMessage(); //imprime a mensagem do erro
			return false; //retorna falso
		}
		return true;
	}
	
	public void alterar(Aula aula) throws Exception {

        String sql = "update aula set nome=?, horario=?, id_prof=?, preco=? WHERE id_aula like ?";
      
        
        try (
           PreparedStatement stmt = ConexaoBanco.getAbreConexao().prepareStatement(sql)) {
           stmt.setString(1, aula.getNome());
           stmt.setString(2, aula.getHorario());
           stmt.setInt(3, aula.getIdProf());
           stmt.setDouble(4, aula.getPreco());
           stmt.setDouble(5, aula.getIdAula());
           
           
           stmt.execute();
       }
        }
	
	public void excluir(Aula aula) throws Exception {
       
        String sql = "delete from aula where id_aula= ?";
        PreparedStatement stmt = ConexaoBanco.getAbreConexao().prepareStatement(sql);
        stmt.setLong(1, aula.getIdAula());
        stmt.execute();
        stmt.close();
	
        }
	
    public List<Aula> consultarTodos(String nome) throws Exception {
      String sql = "select * from aula where nome like ?";
      PreparedStatement stmt = ConexaoBanco.getAbreConexao().prepareStatement(sql);
      stmt.setString(1, nome);
      ResultSet rs = stmt.executeQuery();
      List<Aula>minhaLista = new ArrayList<Aula>();
      while(rs.next()){
          Aula aulas = new Aula();
				
        aulas.setIdAula(rs.getInt("id_aula"));
	aulas.setNome(rs.getString("nome"));
	aulas.setHorario(rs.getString("horario"));       
        aulas.setIdProf(rs.getInt("id_prof"));	
        aulas.setPreco(rs.getFloat("preco"));

     
          minhaLista.add(aulas);
      }
      rs.close();
      rs.close();
      return minhaLista;
	
   }
	
	
        
        
        public ArrayList<String> aulasAlunoSelecionado(String id) throws Exception {
       
                Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<String> listaAulas = new ArrayList<String>(); //arrayList que contera todos os clientes retornados do banco de dados
		
		String query = "select aula.id_aula, aula.nome from matricula\n" +
                                         "inner join aula\n" +
                                         "on matricula.id_aula=aula.id_aula\n" +
                                         "where matricula.id_aluno = "+ id;
		
		try {
			stmt = ConexaoBanco.getAbreConexao().createStatement(); //objeto onde sera colocada a query sql
			rs = stmt.executeQuery(query);
			
           while ( rs.next()){

               String aulas = rs.getString("id_aula")+"-"+rs.getString("nome");
               String aula = aulas;
  
               
            }
		} catch (SQLException e) {
			e.printStackTrace(); //imprime no console onde ocorreu o erro (qual linha)
			e.getMessage(); //imprime a mensagem do erro
		}
		return listaAulas;

            
            
            
        }
}
