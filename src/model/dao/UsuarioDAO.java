/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author heyto
 */
public class UsuarioDAO {
    public void Create(Usuario u) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                    stmt = con.prepareStatement("INSERT INTO usuario (username, email, senha) values  (?,?,?)");
                
                stmt.setString(1,u.getUsername());
                stmt.setString(2, u.getEmail());
                stmt.setString(3, u.getSenha());
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "usuario salvo com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt);
            }
        }
    
    public Usuario readByID(int id_usuario) throws ClassNotFoundException, SQLException {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Usuario usuario = null; // Inicialize a variável que irá armazenar o usuário
    
    try {
        con = ConnectionFactory.getConnection();
        stmt = con.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
        stmt.setInt(1, id_usuario);
        rs = stmt.executeQuery();
        
        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setUsername(rs.getString("username"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.getMessage());
    } finally {
        ConnectionFactory.CloseConnection(con, stmt, rs);
    }
    
    return usuario;
}
    

    public Usuario checklogin(String email, String senha) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id_usuario");
                String username = rs.getString("username");
                String emailFromDB = rs.getString("email");
                String senhaFromDB = rs.getString("senha");
                usuario = new Usuario(id, username, emailFromDB, senhaFromDB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }

        return usuario;
    }
}
