
package model.dao;
import model.bean.Despesa;
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
/**
 *
 * @author heyto
 */

public class DespesaDAO {
        
        public void Create(Despesa d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                    stmt = con.prepareStatement("INSERT INTO despesa (titulo, valor, data, id_categoria) values  (?,?,?,?)");
                
                stmt.setString(1,d.getTitulo());
                stmt.setDouble(2, d.getValor());
                stmt.setDate(3, d.getData());
                stmt.setInt(4, d.getId_categoria());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Despesa salva com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt);
            }
        }
        public List<Despesa> read() throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<Despesa> despesas = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM despesa");
                rs = stmt.executeQuery();
                System.out.println(rs);
                
                while(rs.next()){
                  Despesa despesa = new Despesa();
                    
                    despesa.setId_despesa(rs.getInt("id_despesa"));
                    despesa.setTitulo(rs.getString("titulo"));
                    despesa.setValor(rs.getDouble("valor"));
                    despesa.setData(rs.getDate("data"));
                    despesa.setId_categoria(rs.getInt("id_categoria"));
                    
                    despesas.add(despesa);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt, rs);
            }
            return despesas;
        }
        public void update(Despesa d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("UPDATE despesa SET titulo = ?, valor = ?, data = ?, id_categoria = ? WHERE id_despesa = ?");
                
               stmt.setString(1, d.getTitulo());
                stmt.setDouble(2, d.getValor());
                stmt.setDate(3, d.getData()); 
                stmt.setInt(4, d.getId_categoria()); 
                stmt.setInt(5, d.getId_despesa()); 
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Atualizado salva com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt);
            }
        }
        public void delete(Despesa d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("DELETE FROM despesa WHERE id_despesa = ?");
                
                stmt.setInt(1, d.getId_despesa());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Deletado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt);
            }
        }
        
        public List<Despesa> readForDesc(String titulo) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Despesa> despesas = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM despesa WHERE titulo LIKE ?");
            stmt.setString(1, "%" + titulo + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setId_despesa(rs.getInt("id_despesa"));
                despesa.setTitulo(rs.getString("titulo"));
                despesa.setValor(rs.getDouble("valor"));
                despesa.setData(rs.getDate("data")); 

                despesas.add(despesa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.getMessage());
        } finally {
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        return despesas;
    }
        public List<Despesa> readById(int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<Despesa> despesas = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM despesa WHERE id_usuario = ?");
                stmt.setInt(1, id_usuario);
                rs = stmt.executeQuery();
                System.out.println(rs);
                
                while(rs.next()){
                    System.out.println(rs.getMetaData());
                  Despesa despesa = new Despesa();
                    
                    despesa.setId_despesa(rs.getInt("id_despesa"));
                    despesa.setTitulo(rs.getString("titulo"));
                    despesa.setValor(rs.getDouble("valor"));
                    despesa.setData(rs.getDate("data"));
                    despesa.setId_categoria(rs.getInt("id_categoria"));
                    despesa.setId_categoria(rs.getInt("id_usuario"));
                    
                    despesas.add(despesa);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt, rs);
            }
            return despesas;
        }
        
}
