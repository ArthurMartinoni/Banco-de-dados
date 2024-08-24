package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conn;

    //Metedo autenticacaoUsuario e objeto UsuarioDTO objusuariodto
    public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) throws SQLException, ClassNotFoundException {
        
        conn = ConexaoDAO.getConnection();

        try {
            //na linha abaixo estou criando uma variavel do tipo String sql
            //essa variável é responsável pelo metodo select, a onde vamos pegar os dados que o usuário
            //digitar nos campos e salvou no banco de dados.
            String sql = "Select * from usuario where nome_usuario = ? and senha_usuario = ? ";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        //na linha abaixo a catch vai exibir uma mensagem de erro caso o usuário esteja incorreto    
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
            return null;
        }
    }
}
