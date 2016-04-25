/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Douglas Oliveira
 */
public class relatorio {
    
    // MUDAR ESTE CAMINHO PARA O CORRETO, RELATORIO NÃO VAI ABRIR SE NÃO FIZER ISSO.
    String caminhoImagemRelatorio = "C:\\Users\\Douglas Oliveira\\Desktop\\PROJETOS JAVA\\Academia 4.0\\academia Final\\Utilidades\\logo.jpg";
    ////////////////
    
    public void getRelatorioTodosAlunos() throws DocumentException, FileNotFoundException, IOException{
        
        
        Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Relatorio Alunos.pdf"));
            doc.open();
            Image imagem = Image.getInstance(caminhoImagemRelatorio);
            imagem.scaleToFit(550, 100);
            doc.add(imagem);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("                                                            RELATORIO ALUNOS"));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            
            
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = ConexaoBanco.getAbreConexao();
            stmt = conn.prepareStatement("select * from aluno");
            ResultSet rs = stmt.executeQuery();
              
               while (rs.next()){
                doc.add(new Paragraph("ID: " + rs.getInt("id_aluno")
                        +"   Nome : " + rs.getString("nome")
                        +"\nCpf : " + rs.getString("cpf")
                        +"   Endereço : " + rs.getString("endereco")
                        +"\nTelefone : " + rs.getString("telefone")
                        +"  Idade : " + rs.getInt("idade")
                        +"  Altura : " + rs.getString("altura")
                        +"  Peso : " + rs.getString("peso")
                        ));
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph("_____________________________________________________________________________"));
                doc.add(new Paragraph(" "));
                
               }
               }   catch (SQLException | HeadlessException e ) {
            JOptionPane.showMessageDialog (null, " Erro   \n" +e);
        }
                doc.close();
                JOptionPane.showMessageDialog(null, " Arquivo Gerado com Sucesso! " );
                Desktop.getDesktop().open (new File ("Relatorio Alunos.pdf"));
          
            
    
    }
    
    public void getRelatorioTodosProfessores() throws DocumentException, FileNotFoundException, IOException{
    
    Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Relatorio Professores.pdf"));
            doc.open();
            Image imagem = Image.getInstance(caminhoImagemRelatorio);
            imagem.scaleToFit(550, 100);
            doc.add(imagem);            
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("                                                           RELATORIO PROFESSORES"));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            
            
            
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = ConexaoBanco.getAbreConexao();
            stmt = conn.prepareStatement("select * from professor");
            ResultSet rs = stmt.executeQuery();
              
               while (rs.next()){
                doc.add(new Paragraph("ID: " + rs.getInt("id_prof")
                        +"   Nome : " + rs.getString("nome")
                        +"\nCpf : " + rs.getString("cpf")
                        +"   Endereço : " + rs.getString("endereco")
                        +"\nTelefone : " + rs.getString("telefone")
                        +"     Salario : " + rs.getDouble("salario")
                        )); 
                
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph("_____________________________________________________________________________"));
                doc.add(new Paragraph(" "));

               }
               }   catch (SQLException | HeadlessException e ) {
            JOptionPane.showMessageDialog (null, " Erro   \n" +e);
        }
          doc.close();
                JOptionPane.showMessageDialog(null, " Arquivo Gerado com Sucesso! " );
                Desktop.getDesktop().open (new File ("Relatorio Professores.pdf"));
                    
           
            
    
    }
    
    
    public void getRelatorioTodasAulas() throws DocumentException, FileNotFoundException, IOException{
    
    Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Relatorio Aulas.pdf"));
            doc.open();
            Image imagem = Image.getInstance(caminhoImagemRelatorio);
            imagem.scaleToFit(550, 100);
            doc.add(imagem);           
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("                                                           RELATORIO AULAS"));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            
            
            
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = ConexaoBanco.getAbreConexao();
            stmt = conn.prepareStatement("select * from aula");
            ResultSet rs = stmt.executeQuery();
              
               while (rs.next()){
                doc.add(new Paragraph("ID: " + rs.getInt("id_aula")
                        +"   Nome : " + rs.getString("nome")
                        +"\nPreço : " + rs.getDouble("preco")
                        +"   Horario : " + rs.getString("horario")
                        ));
                
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph("_____________________________________________________________________________"));
                doc.add(new Paragraph(" "));

               }
               }   catch (SQLException | HeadlessException e ) {
            JOptionPane.showMessageDialog (null, " Erro   \n" +e);
        }
        doc.close();
                JOptionPane.showMessageDialog(null, " Arquivo Gerado com Sucesso! " );
                Desktop.getDesktop().open (new File ("Relatorio Aulas.pdf"));
            
    
    }
    
     public void getRelatorioAula(String idParaProcurar) throws DocumentException, FileNotFoundException, IOException{
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Relatorio Aula ID "+idParaProcurar+".pdf"));
            doc.open();
            Image imagem = Image.getInstance(caminhoImagemRelatorio);
            imagem.scaleToFit(550, 100);
            doc.add(imagem);            
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("                                                           RELATORIO AULA"));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            
                   
        PreparedStatement stmt = null;
        Connection conn = null;
        
            try {
            conn = ConexaoBanco.getAbreConexao();
            stmt = conn.prepareStatement("select * from aula where id_aula = "+ idParaProcurar);
            ResultSet rs = stmt.executeQuery();

            
            
            while ( rs.next()){
               
                doc.add(new Paragraph("ID: " + rs.getInt("id_aula")
                        +"  Nome : " + rs.getString("nome")
                        +"  Preço : " + rs.getDouble("preco")
                        +"   Horario : " + rs.getString("horario")
                        ));
                              
            
            }
            }   catch (SQLException | HeadlessException e ) {
            JOptionPane.showMessageDialog (null, " Erro   \n" +e);
            }
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph(" ALUNOS MATRICULADOS:"));
        
        
        try {
            conn = ConexaoBanco.getAbreConexao();
            stmt = conn.prepareStatement("select aluno.id_aluno, aluno.nome from aluno\n" +
                                          "inner join matricula\n" +
                                          "on aluno.id_aluno = matricula.id_aluno\n" +
                                          "inner join aula\n" +
                                          "on aula.id_aula = matricula.id_aula\n" +
                                          " where aula.id_aula ="+idParaProcurar);
            ResultSet rs = stmt.executeQuery();
            
            while ( rs.next()){
               
                doc.add(new Paragraph("\nID: " + rs.getInt("id_aluno")
                        +"   | Nome : " + rs.getString("nome")
                        ));
                              
            
            }
    
        
        doc.close();
        JOptionPane.showMessageDialog(null, " Arquivo Gerado com Sucesso! " );
        Desktop.getDesktop().open (new File ("Relatorio Aula ID "+idParaProcurar+".pdf"));
        
  
       
                
    }           catch (SQLException ex) {
                    Logger.getLogger(relatorio.class.getName()).log(Level.SEVERE, null, ex);
                }
     
            
     }
     
     
     
        
    public void getRelatorioAluno(String idParaProcurar) throws DocumentException, FileNotFoundException, IOException{

            double totalAulas =0;
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Relatorio Aluno ID "+idParaProcurar+".pdf"));
            doc.open();
            Image imagem = Image.getInstance(caminhoImagemRelatorio);
            imagem.scaleToFit(550, 100);
            doc.add(imagem);           
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("                                                           RELATORIO ALUNO"));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            
            
        PreparedStatement stmt = null;
        Connection conn = null;
       
        try {
            conn = ConexaoBanco.getAbreConexao();
            stmt = conn.prepareStatement("select * from aluno where id_aluno = "+ idParaProcurar);
            ResultSet rs = stmt.executeQuery();
              
               while (rs.next()){
                doc.add(new Paragraph("ID: " + rs.getInt("id_aluno")
                        +"   Nome : " + rs.getString("nome")
                        +"\nCpf : " + rs.getString("cpf")
                        +"   Endereço : " + rs.getString("endereco")
                        +"\nTelefone : " + rs.getString("telefone")
                        +"   Idade : " + rs.getInt("idade")
                        +"   Altura : " + rs.getString("altura")
                        +"   Peso : " + rs.getString("peso")
                        )); 
               }              
            }   catch (SQLException | HeadlessException e ) {
            JOptionPane.showMessageDialog (null, " Erro   \n" +e);
        }
        
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" AULAS MATRICULADAS"));       
        
        
        try {
            conn = ConexaoBanco.getAbreConexao();
            stmt = conn.prepareStatement("select matricula.id_matricula, aula.nome from aluno\n" +
                                         "inner join matricula\n" +
                                         "on aluno.id_aluno = matricula.id_aluno\n" +
                                         "inner join aula\n" +
                                         "on aula.id_aula = matricula.id_aula\n" +
                                         "where aluno.id_aluno ="+idParaProcurar);
            ResultSet rt = stmt.executeQuery(); 
            while (rt.next()){
                 doc.add(new Paragraph("ID: " + rt.getInt("id_matricula")
                        +"  | Nome : " + rt.getString("nome")+"\n"
                        ));
                
            }
            }   catch (SQLException | HeadlessException e ) {
            JOptionPane.showMessageDialog (null, " Erro   \n" +e);
        }
       
        
         try {
            conn = ConexaoBanco.getAbreConexao();
            stmt = conn.prepareStatement("select sum(aula.preco) Valor from aluno\n" +
                                         "inner join matricula\n" +
                                         "on aluno.id_aluno = matricula.id_aluno\n" +
                                         "inner join aula\n" +
                                         "on aula.id_aula = matricula.id_aula\n" +
                                         "where aluno.id_aluno ="+idParaProcurar);
            ResultSet rt = stmt.executeQuery(); 
            while (rt.next()){
                totalAulas+=(rt.getDouble("valor"));
           
            }
            }   catch (SQLException | HeadlessException e ) {
            JOptionPane.showMessageDialog (null, " Erro   \n" +e);
        }
         
         doc.add(new Paragraph(" "));
         doc.add(new Paragraph(" "));
         doc.add(new Paragraph("MENSALIDADE: "+totalAulas));
        
         doc.close();
         JOptionPane.showMessageDialog(null, " Arquivo Gerado com Sucesso! " );
          Desktop.getDesktop().open (new File ("Relatorio Aluno ID "+idParaProcurar+".pdf"));
    
    }
    
     
     
     
     
     public void getRelatorioProfessor(String idParaProcurar) throws DocumentException, FileNotFoundException, IOException{

            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Relatorio Professor ID "+idParaProcurar+".pdf"));
            doc.open();
            Image imagem = Image.getInstance(caminhoImagemRelatorio);
            imagem.scaleToFit(550, 100);
            doc.add(imagem);            
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("                                                           RELATORIO PROFESSOR"));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            
            
            
        PreparedStatement stmt = null;
        Connection conn = null;
        
        
        try {
            conn = ConexaoBanco.getAbreConexao();
            stmt = conn.prepareStatement("select * from professor where id_prof = "+ idParaProcurar);
            ResultSet rs = stmt.executeQuery();
              
               while (rs.next()){
                doc.add(new Paragraph("ID: " + rs.getInt("id_prof")
                        +"  Nome : " + rs.getString("nome")
                        +"\nCpf : " + rs.getString("cpf")
                        +"   Endereço : " + rs.getString("endereco")
                        +"\nTelefone : " + rs.getString("telefone")
                        +"   Salario : " + rs.getDouble("salario")
                        )); 
               }
                
        
                
                
            }   catch (SQLException | HeadlessException e ) {
            JOptionPane.showMessageDialog (null, " Erro   \n" +e);
        }
        
         doc.add(new Paragraph(" "));
         doc.add(new Paragraph(" AULAS: "));    
        
        try {
            conn = ConexaoBanco.getAbreConexao();
            stmt = conn.prepareStatement("select aula.horario, aula.nome from professor\n" +
                                         "inner join aula\n" +
                                         "on aula.id_prof = professor.id_prof\n" +
                                         "where professor.id_prof = "+idParaProcurar);
            ResultSet rt = stmt.executeQuery(); 
            while (rt.next()){
                doc.add(new Paragraph("Horario: " + rt.getString("horario")
                        +"  | Nome : " + rt.getString("nome")+"\n"
                        ));
            
                
            }
            }   catch (SQLException | HeadlessException e ) {
            JOptionPane.showMessageDialog (null, " Erro   \n" +e);
            
        }
        doc.close();
        JOptionPane.showMessageDialog(null, " Arquivo Gerado com Sucesso! " );
         Desktop.getDesktop().open (new File ("Relatorio Professor ID "+idParaProcurar+".pdf"));
       
    }                
        
        

     
     
     
}
