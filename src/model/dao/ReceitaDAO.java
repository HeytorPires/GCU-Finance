
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
import model.bean.Receita;
/**
 *
 * @author heyto
 */

public class ReceitaDAO {
        
        public void Create(Receita r) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
             ResultSet rs = null;
            try {
                    stmt = con.prepareStatement("INSERT INTO receita (titulo, valor, id_usuario) values  (?,?,?)");
                
                stmt.setString(1,r.getTitulo());
                stmt.setDouble(2, r.getValor());
                stmt.setInt(3, r.getId_usuario());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Receita salva com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt, rs);
            }
        }
        public List<Receita> read() throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<Receita> receitas = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM receita");
                rs = stmt.executeQuery();
                
                while(rs.next()){
                  Receita receita = new Receita();
                    
                    receita.setId_receita(rs.getInt("id_receita"));
                    receita.setTitulo(rs.getString("titulo"));
                    receita.setValor(rs.getDouble("valor"));
                    receita.setId_usuario(rs.getInt("id_usuario"));
                    
                    receitas.add(receita);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt, rs);
            }
            return receitas;
        }
        public void update(Receita r) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            try {
                stmt = con.prepareStatement("UPDATE receita SET titulo = ?, valor = ?  WHERE id_receita = ?");
                
               stmt.setString(1, r.getTitulo());
                stmt.setDouble(2, r.getValor());
                stmt.setInt(3, r.getId_receita());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt, rs);

            }
        }
        public void delete(Receita r) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                stmt = con.prepareStatement("DELETE FROM receita WHERE id_receita = ?");
                
                stmt.setInt(1, r.getId_receita());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Deletado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt, rs);
            }
        }
        
        public List<Receita> readForDesc(String titulo) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Receita> receitas = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM receita WHERE titulo LIKE ?");
            stmt.setString(1, "%" + titulo + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Receita receita = new Receita();
                receita.setId_receita(rs.getInt("id_receita"));
                receita.setTitulo(rs.getString("titulo"));
                receita.setValor(rs.getDouble("valor"));
                receita.setId_usuario(rs.getInt("id_usuario")); 

                receitas.add(receita);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.getMessage());
        } finally {
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        return receitas;
    }
        public List<Receita> readById(int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<Receita> receitas = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM receita WHERE id_usuario = ?");
                stmt.setInt(1, id_usuario);
                rs = stmt.executeQuery();
                System.out.println(rs);
                
                while(rs.next()){
                    System.out.println(rs.getMetaData());
                  Receita receita = new Receita();
                    
                    receita.setId_receita(rs.getInt("id_receita"));
                    receita.setTitulo(rs.getString("titulo"));
                    receita.setValor(rs.getDouble("valor"));
                    receita.setId_usuario(rs.getInt("id_usuario"));
                    
                    receitas.add(receita);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt, rs);
            }
            return receitas;
        }
        
}
