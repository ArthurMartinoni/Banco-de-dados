package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoDAO {
   
    private static final String URL = "jdbc:mysql://localhost:3306/dbapresentacao";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection() {
       try {
           return DriverManager.getConnection(URL, USER, PASS);      
        } catch (SQLException ex){
            throw new RuntimeException("Erro de conexão com o banco de dados", ex);
        }
    }
    
    public static void closeConnection(Connection connection){
       try {
           if (connection != null) {
               connection.close();
           }
       } catch (SQLException ex) {
           throw new RuntimeException("Erro de conexão com o banco de dados", ex);
       }  
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement){
       try {
           if (connection != null) {
               connection.close();
           }
           
           if (statement != null){
                statement.close();
           }
       } catch (SQLException ex) {
           throw new RuntimeException("Erro de conexão com o banco de dados", ex);
       }  
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
       try {
           if (connection != null) {
               connection.close();
           }
           
           if (statement != null){
                statement.close();
           }
           
           if (resultSet != null){
                resultSet.close();
           }
       } catch (SQLException ex) {
           throw new RuntimeException("Erro de conexão com o banco de dados", ex);
       } 
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Conexão com o banco de dados realizada com sucesso");
        String sql = null;
        String dadosDaConexao = null;
        
        try (Connection con = DriverManager.getConnection(dadosDaConexao);
     PreparedStatement ps = con.prepareStatement(sql)) {
            int userId = 0;
    ps.setInt(1, userId); // setar os parâmetros da query
    try (ResultSet rs = ps.executeQuery()) {
        while(rs.next()) {
            // usar o ResultSet (por exemplo, rs.getInt("id"), etc)
        }
    }
} catch (SQLException e) {
            // mostrar mensagem de erro, etc
            
}
    }

    public void executeSQL(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}