
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBanco {
       
    public static Connection conn = null;
    public static Connection getAbreConexao () {
        try {
            // LEMBRAR DE ADD A BIBLIOTECA DO SQL SERVER
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // MUDAR CAMINHO PARA BANCO
            String url = "jdbc:sqlserver://localhost\\DOUGLAS-PC:1433;databaseName=academia";
            // MUDAR USUARIO E SENHA
            conn = DriverManager.getConnection(url, "sa", "123456");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Falta Adcionar Driver:" + ex);

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + erro);
        }
        return conn;
    }
}
