/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Database.Connection.ConnectionFactory;
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
    public void Create(Usuario u) throws ClassNotFoundException, SQLException {
    Connection con = null;
    PreparedStatement stmtUsuario = null;
    ResultSet generatedKeys = null;
    
    try {
        con = ConnectionFactory.getConnection();
        
        // Inserção do usuário
        String sqlUsuario = "INSERT INTO usuario (username, email, senha) VALUES (?, ?, ?)";
        stmtUsuario = con.prepareStatement(sqlUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
        stmtUsuario.setString(1, u.getUsername());
        stmtUsuario.setString(2, u.getEmail());
        stmtUsuario.setString(3, u.getSenha());
        
        int affectedRows = stmtUsuario.executeUpdate();
        
        if (affectedRows == 0) {
            throw new SQLException("Falha ao inserir usuário.");
        }
        
        // Obtendo o ID gerado para o usuário
        generatedKeys = stmtUsuario.getGeneratedKeys();
        int idUsuario = 0;
        if (generatedKeys.next()) {
            idUsuario = generatedKeys.getInt(1);
            
            // Chamada para inserir categorias
            inserirCategoriasPadrao(con, idUsuario);
            
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso");
        } else {
            throw new SQLException("Falha ao obter ID gerado para usuário.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Erro ao salvar usuário: " + ex);
    } finally {
        // Fechar recursos
        if (generatedKeys != null) {
            generatedKeys.close();
        }
        if (stmtUsuario != null) {
            stmtUsuario.close();
        }
        ConnectionFactory.closeConnection(con);
    }
}
    private void inserirCategoriasPadrao(Connection con, int idUsuario) throws SQLException {
    PreparedStatement stmtCategoriaReceita = null;
    PreparedStatement stmtCategoriaDespesa = null;
    ResultSet rs = null;
    
    try {
        // Inserção na tabela categoria_receita
        String sqlCategoriaReceita = "INSERT INTO categoria_receita (nome, descricao, code, id_usuario) VALUES (?, ?, ?, ?)";
        stmtCategoriaReceita = con.prepareStatement(sqlCategoriaReceita);
        
        String[] nomesReceita = {"Salário", "Investimento", "Bônus", "Freelance", "Outros"};
        String[] descricoesReceita = {"Salário mensal", "Retorno de investimentos", "Bônus anual", "Trabalhos freelance", "Outras receitas"};
        int[] codesReceita = {1001, 1002, 1003, 1004, 1005};
        
        for (int i = 0; i < nomesReceita.length; i++) {
            // Verificar se o code já existe
            String sqlCheck = "SELECT COUNT(*) AS count FROM categoria_receita WHERE code = ?";
            PreparedStatement stmtCheck = con.prepareStatement(sqlCheck);
            stmtCheck.setInt(1, codesReceita[i]);
            rs = stmtCheck.executeQuery();
            
            if (rs.next() && rs.getInt("count") == 0) {
                // Código não existe, então inserir
                stmtCategoriaReceita.setString(1, nomesReceita[i]);
                stmtCategoriaReceita.setString(2, descricoesReceita[i]);
                stmtCategoriaReceita.setInt(3, codesReceita[i]);
                stmtCategoriaReceita.setInt(4, idUsuario);
                stmtCategoriaReceita.executeUpdate();
            }
            
            rs.close();
            stmtCheck.close();
        }
        
        // Inserção na tabela categoria_despesa
        String sqlCategoriaDespesa = "INSERT INTO categoria_despesa (nome, descricao, code, id_usuario) VALUES (?, ?, ?, ?)";
        stmtCategoriaDespesa = con.prepareStatement(sqlCategoriaDespesa);
        
        String[] nomesDespesa = {"Alimentação", "Transporte", "Moradia", "Lazer", "Outros"};
        String[] descricoesDespesa = {"Despesas com alimentação", "Despesas com transporte", "Despesas com moradia", "Despesas com lazer", "Outras despesas"};
        int[] codesDespesa = {4001, 4002, 4003, 4004, 4005};
        
        for (int i = 0; i < nomesDespesa.length; i++) {
            // Verificar se o code já existe
            String sqlCheck = "SELECT COUNT(*) AS count FROM categoria_despesa WHERE code = ?";
            PreparedStatement stmtCheck = con.prepareStatement(sqlCheck);
            stmtCheck.setInt(1, codesDespesa[i]);
            rs = stmtCheck.executeQuery();
            
            if (rs.next() && rs.getInt("count") == 0) {
                // Código não existe, então inserir
                stmtCategoriaDespesa.setString(1, nomesDespesa[i]);
                stmtCategoriaDespesa.setString(2, descricoesDespesa[i]);
                stmtCategoriaDespesa.setInt(3, codesDespesa[i]);
                stmtCategoriaDespesa.setInt(4, idUsuario);
                stmtCategoriaDespesa.executeUpdate();
            }
            
            rs.close();
            stmtCheck.close();
        }
        
    } finally {
        // Fechar recursos
        if (rs != null) {
            rs.close();
        }
        if (stmtCategoriaReceita != null) {
            stmtCategoriaReceita.close();
        }
        if (stmtCategoriaDespesa != null) {
            stmtCategoriaDespesa.close();
        }
    }
}
    public Usuario readUserByID(int id_usuario) throws ClassNotFoundException, SQLException {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Usuario usuario = null;
    
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
        ConnectionFactory.closeConnection(con, stmt, rs);
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
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return usuario;
    }
    public void AlterarSenha(String senha ,int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                stmt = con.prepareStatement("UPDATE usuario SET senha = ?  WHERE id_usuario = ?");
                
                stmt.setString(1, senha);
                stmt.setInt(2, id_usuario);
                
                
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Senha Atualizada com sucesso!");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Atualizar senha: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);

            }
        }
    public void AlterarUsuario(String nome ,String email, int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                stmt = con.prepareStatement("UPDATE usuario SET username = ?, email = ?  WHERE id_usuario = ?");
                
                stmt.setString(1, nome);
                stmt.setString(2, email);
                stmt.setInt(3, id_usuario);
                
                
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Usuario Atualizado com sucesso!");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Atualizar usuario: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);

            }
        }
    
}
