
package model.dao;
import model.bean.Despesa;
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
/**
 *
 * @author heyto
 */

public class DespesaDAO {
        
        public void Create(Despesa d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
             ResultSet rs = null;
            try {
                    stmt = con.prepareStatement("INSERT INTO despesa (titulo, valor, data, id_categoria_despesa, id_usuario) values  (?,?,?,?,?)");
                
                stmt.setString(1,d.getTitulo());
                stmt.setDouble(2, d.getValor());
                stmt.setDate(3, d.getData());
                stmt.setInt(4, d.getId_categoria_despesa());
                stmt.setInt(5, d.getId_usuario());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Despesa salva com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
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
                
                while(rs.next()){
                  Despesa despesa = new Despesa();
                    
                    despesa.setId_despesa(rs.getInt("id_despesa"));
                    despesa.setTitulo(rs.getString("titulo"));
                    despesa.setValor(rs.getDouble("valor"));
                    despesa.setData(rs.getDate("data"));
                    despesa.setId_categoria_despesa(rs.getInt("id_categoria_despesa"));
                    
                    despesas.add(despesa);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return despesas;
        }
        public void update(Despesa d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
             ResultSet rs = null;
            try {
                stmt = con.prepareStatement("UPDATE despesa SET titulo = ?, valor = ?, data = ?, id_categoria_despesa = ? WHERE id_despesa = ?");
                
                stmt.setString(1, d.getTitulo());
                stmt.setDouble(2, d.getValor());
                stmt.setDate(3, d.getData()); 
                stmt.setInt(4, d.getId_categoria_despesa()); 
                stmt.setInt(5, d.getId_despesa()); 
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Atualizado salva com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        public void delete(Despesa d) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
             ResultSet rs = null;
            try {
                stmt = con.prepareStatement("DELETE FROM despesa WHERE id_despesa = ?");
                
                stmt.setInt(1, d.getId_despesa());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Deletado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        
        public List<Despesa> readForDesc(String titulo, int id_usuario) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Despesa> despesas = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM despesa WHERE titulo LIKE ? AND id_usuario = ?");
            stmt.setString(1, "%" + titulo + "%");
            stmt.setInt(2, id_usuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setId_despesa(rs.getInt("id_despesa"));
                despesa.setTitulo(rs.getString("titulo"));
                despesa.setValor(rs.getDouble("valor"));
                despesa.setData(rs.getDate("data")); 
                despesa.setCode(rs.getInt("code"));

                despesas.add(despesa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return despesas;
    }
        public List<Despesa> readDepesaByIdUser(int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Despesa> despesas = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM despesa WHERE id_usuario = ?");
                stmt.setInt(1, id_usuario);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                  Despesa despesa = new Despesa();
                    
                    despesa.setId_despesa(rs.getInt("id_despesa"));
                    despesa.setTitulo(rs.getString("titulo"));
                    despesa.setValor(rs.getDouble("valor"));
                    despesa.setData(rs.getDate("data"));
                    despesa.setId_categoria_despesa(rs.getInt("id_categoria_despesa"));
                    //despesa.setCode(rs.getInt("code"));
                    despesa.setId_usuario(rs.getInt("id_usuario"));
                    despesas.add(despesa);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return despesas;
        }
        
        public Despesa readDepesaByIdUserAndCode(int id_usuario,int code) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Despesa despesa = null;
            
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM despesa WHERE id_usuario = ? and code = ?");
                stmt.setInt(1, id_usuario);
                stmt.setInt(2, code);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    despesa.setId_despesa(rs.getInt("id_despesa"));
                    despesa.setTitulo(rs.getString("titulo"));
                    despesa.setValor(rs.getDouble("valor"));
                    despesa.setData(rs.getDate("data"));
                    despesa.setCode(rs.getInt("code"));
                    despesa.setId_usuario(rs.getInt("id_usuario"));
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return despesa;
        }
        public List <Despesa> readDepesaByIdUserAndCodeList(int id_usuario,int id_cat_despesa) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<Despesa> despesas = new ArrayList<>();
            
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM despesa WHERE id_usuario = ? and id_categoria_despesa = ?");
                stmt.setInt(1, id_usuario);
                stmt.setInt(2, id_cat_despesa);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Despesa despesa = new Despesa();
                    despesa.setId_despesa(rs.getInt("id_despesa"));
                    despesa.setTitulo(rs.getString("titulo"));
                    despesa.setValor(rs.getDouble("valor"));
                    despesa.setData(rs.getDate("data"));
                    despesa.setId_categoria_despesa(rs.getInt("id_categoria_despesa"));
                    despesa.setId_usuario(rs.getInt("id_usuario"));
                    despesas.add(despesa);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return despesas;
        }

        public void deleteAll(int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
             ResultSet rs = null;
            try {
                stmt = con.prepareStatement("DELETE FROM despesa WHERE id_usuario = ?");
                
                stmt.setInt(1, id_usuario);
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Todas as despesas foram deletadas com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        public void updateCode(int codeAntigo,int codenovo, int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
             ResultSet rs = null;
            try {
                stmt = con.prepareStatement("update despesa set code = ? where code = ? and id_usuario = ?");
                
                stmt.setInt(1, codenovo);
                stmt.setInt(2, codeAntigo);
                stmt.setInt(3, id_usuario);
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Todas as despesas foram atualizadas com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
    
        public List<Despesa> filterByYearAndMonth(String year, String month, int id_usuario) throws ClassNotFoundException, SQLException {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Despesa> despesas = new ArrayList<>();
    
    try {
        con = ConnectionFactory.getConnection();
        
        StringBuilder query = new StringBuilder("SELECT * FROM despesa WHERE id_usuario = ?");
        
        boolean filterByYear = !year.equals("Todos");
        boolean filterByMonth = !month.equals("0");

        if (filterByYear) {
            query.append(" AND YEAR(data) = ?");
        }
        if (filterByMonth) {  
            query.append(" AND MONTH(data) = ?");
        }
        
        stmt = con.prepareStatement(query.toString());
        
        int paramIndex = 1;
        stmt.setInt(paramIndex++, id_usuario);
        if (filterByYear) {
            stmt.setInt(paramIndex++, Integer.parseInt(year));
        }
        if (filterByMonth) {
            stmt.setInt(paramIndex++, Integer.parseInt(month));
        }

        rs = stmt.executeQuery();
        
        while (rs.next()) {
            Despesa despesa = new Despesa();
            despesa.setTitulo(rs.getString("titulo"));
            despesa.setData(rs.getDate("data"));
            despesa.setValor(rs.getDouble("valor"));
            despesa.setCode(rs.getInt("code")); 
            despesas.add(despesa);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Erro ao Filtrar: " + ex.getMessage());
    } finally {
        ConnectionFactory.closeConnection(con, stmt, rs);
    }
    
    return despesas;
}
    
}
