
package model.dao;
import Connection.ConnectionFactory;
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
import model.bean.Categoria;
/**
 *
 * @author heyto
 */

public class CategoriaDAO {
        
        public void Create(Categoria d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                    stmt = con.prepareStatement("INSERT INTO categoria (nome, descricao, code, id_usuario) values  (?,?,?,?)");
                
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
                ConnectionFactory.CloseConnection(con, stmt);
            }
        }
        public List<Categoria> read() throws ClassNotFoundException, SQLException{
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<Categoria> categorias = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM categoria");
                rs = stmt.executeQuery();
                System.out.println(rs);
                
                while(rs.next()){
                    System.out.println(rs.getMetaData());
                  Categoria categoria = new Categoria();
                    
                    categoria.setId_categoria(rs.getInt("id_categoria"));
                    categoria.setNome(rs.getString("nome"));
                    categoria.setDescricao(rs.getString("descricao"));
                    categoria.setId_categoria(rs.getInt("code"));
                    
                    categorias.add(categoria);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt, rs);
            }
            return categorias;
        }
        public void update(Categoria d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("UPDATE categoria SET nome = ?,descricao = ?, code = ? WHERE id_categoria = ?");
                
               stmt.setString(1, d.getNome());
                stmt.setString(2, d.getDescricao());
                stmt.setInt(3, d.getCode());
                stmt.setInt(4, d.getId_categoria());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt);
            }
        }
        public void delete(Categoria d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("DELETE FROM categoria WHERE id_categoria = ?");
                
                stmt.setInt(1, d.getId_categoria());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Deletado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt);
            }
        }
        
        public List<Categoria> readForDesc(String titulo) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Categoria> categorias = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM categoria WHERE titulo LIKE ?");
            stmt.setString(1, "%" + titulo + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                categoria.setCode(rs.getInt("code"));

                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.getMessage());
        } finally {
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        return categorias;
    }
        public List<Categoria> readById(int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<Categoria> categorias = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM categoria WHERE id_usuario = ?");
                stmt.setInt(1, id_usuario);
                rs = stmt.executeQuery();
                System.out.println(rs);
                
                while(rs.next()){
                    System.out.println(rs.getMetaData());
                  Categoria categoria = new Categoria();
                    
                    categoria.setId_categoria(rs.getInt("id_categoria"));
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
                ConnectionFactory.CloseConnection(con, stmt, rs);
            }
            return categorias;
        }
        
}
