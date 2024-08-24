/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import DAO.ConexaoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JANDERSON
 */
public class UsuarioDao {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public UsuarioDao() {
        
    }
    
    //a linha abaixo cria o metodo conectar com o banco de dados
    public boolean conectar() {
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            //conn = DriverManager.getConnection("jdbc:sqlserver://localhost;database=banco;integratedSecurity=true;");  
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbapresentacao", "root", "");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void adicionar(Usuario obj) throws SQLException {
        String sql = "INSERT INTO usuario (nome_usuario,email_usuario,senha_usuario)VALUES(?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConexaoDAO.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getNome_usuario());
            pstm.setString(2, obj.getSenha_usuario());
            pstm.setString(3, obj.getEmail_usuario());
            
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar as informações! Por favor, verifique os dados e preencha novamente." + e.toString());
            //System.out.println("Erro ao salvar dados"+ e.getMessage().toLowerCase());
        } finally {

            if (conn != null) {
                conn.close();
            }
        }
    }
}
