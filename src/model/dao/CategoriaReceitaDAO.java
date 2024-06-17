
package model.dao;
import Database.Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.CategoriaReceita;
/**
 *
 * @author heyto
 */

public class CategoriaReceitaDAO {
        
        public void Create(CategoriaReceita d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
             ResultSet rs = null;
            try {
                    stmt = con.prepareStatement("INSERT INTO categoria_receita (nome, descricao, code, id_usuario) values  (?,?,?,?)");
                
                stmt.setString(1,d.getNome());
                stmt.setString(2, d.getDescricao());
                stmt.setInt(3, d.getCode());
                stmt.setInt(4, d.getId_usuario());
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Categoria salva com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        public List<CategoriaReceita> read() throws ClassNotFoundException, SQLException{
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<CategoriaReceita> categorias = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM categoria_receita");
                rs = stmt.executeQuery();
                
                while(rs.next()){
                  CategoriaReceita categoria = new CategoriaReceita();
                    
                    categoria.setId_categoria_receita(rs.getInt("id_categoria_receita"));
                    categoria.setNome(rs.getString("nome"));
                    categoria.setDescricao(rs.getString("descricao"));
                    categoria.setCode(rs.getInt("code"));
                    
                    categorias.add(categoria);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return categorias;
        }
        public void update(CategoriaReceita d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
             ResultSet rs = null;
            try {
                stmt = con.prepareStatement("UPDATE categoria_receita SET nome = ?,descricao = ?, code = ? WHERE id_categoria_receita = ?");
                
               stmt.setString(1, d.getNome());
                stmt.setString(2, d.getDescricao());
                stmt.setInt(3, d.getCode());
                stmt.setInt(4, d.getId_categoria_receita());
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        public void delete(CategoriaReceita d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
             ResultSet rs = null;
            try {
                stmt = con.prepareStatement("DELETE FROM categoria_receita WHERE id_categoria_receita = ?");
                
                stmt.setInt(1, d.getId_categoria_receita());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Deletado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        
        public List<CategoriaReceita> readForDesc(String titulo, int id_usuario) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CategoriaReceita> categorias = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM categoria_receita WHERE nome LIKE ? and id_usuario = ?");
            stmt.setString(1, "%" + titulo + "%");
            stmt.setInt(2, id_usuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                CategoriaReceita categoria = new CategoriaReceita();
                categoria.setId_categoria_receita(rs.getInt("id_categoria_receita"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                categoria.setCode(rs.getInt("code"));

                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return categorias;
    }
        public List<CategoriaReceita> readByIdAndCodeAndId(int id_usuario, int code, int id_categoriaReceita) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<CategoriaReceita> categorias = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM categoria_despesa  WHERE id_usuario = ? and code = ? and id_categoria_despesa != ?");
                stmt.setInt(1, id_usuario);
                stmt.setInt(2, code);
                stmt.setInt(3, id_categoriaReceita);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                  CategoriaReceita categoria = new CategoriaReceita();
                    
                    categoria.setId_categoria_receita(rs.getInt("id_categoria_despesa"));
                    categoria.setNome(rs.getString("nome"));
                    categoria.setDescricao(rs.getString("descricao"));
                    categoria.setCode(rs.getInt("code"));
                    categoria.setId_usuario(rs.getInt("id_usuario"));
                    
                    categorias.add(categoria);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return categorias;
        }
        public List<CategoriaReceita> readCategoriaByIdUser(int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<CategoriaReceita> categorias = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM categoria_receita WHERE id_usuario = ?");
                stmt.setInt(1, id_usuario);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                  CategoriaReceita categoria = new CategoriaReceita();
                    
                    categoria.setId_categoria_receita(rs.getInt("id_categoria_receita"));
                    categoria.setNome(rs.getString("nome"));
                    categoria.setDescricao(rs.getString("descricao"));
                    categoria.setCode(rs.getInt("code"));
                    categoria.setId_usuario(rs.getInt("id_usuario"));
                    
                    categorias.add(categoria);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return categorias;
        }
        
        public List<CategoriaReceita> readByIdAndCode(int id_usuario, int code) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<CategoriaReceita> categorias = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM categoria_receita WHERE id_usuario = ? and code = ?");
                stmt.setInt(1, id_usuario);
                stmt.setInt(2, code);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                  CategoriaReceita categoria = new CategoriaReceita();
                    
                    categoria.setId_categoria_receita(rs.getInt("id_categoria_receita"));
                    categoria.setNome(rs.getString("nome"));
                    categoria.setDescricao(rs.getString("descricao"));
                    categoria.setCode(rs.getInt("code"));
                    categoria.setId_usuario(rs.getInt("id_usuario"));
                    
                    categorias.add(categoria);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return categorias;
        }
        public void deleteAll(int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
             ResultSet rs = null;
            try {
                stmt = con.prepareStatement("DELETE FROM categoria_receita WHERE id_usuario = ?");
                
                stmt.setInt(1, id_usuario);
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Todas as categorias receitas foram deletadas com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        
}
