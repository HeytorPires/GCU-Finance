
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
                    stmt = con.prepareStatement("INSERT INTO receita (titulo, valor, id_usuario, data, id_categoria_receita) values  (?,?,?,?,?)");
                
                stmt.setString(1,r.getTitulo());
                stmt.setDouble(2, r.getValor());
                stmt.setInt(3, r.getId_usuario());
                stmt.setDate(4, (Date) r.getData());
                stmt.setInt(5, r.getId_categoria_receita());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Receita salva com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
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
                    receita.setData(rs.getDate("data"));
                    receita.setCode(rs.getInt("code"));
                    
                    receitas.add(receita);
                }
            } catch(SQLException ex) {
              Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return receitas;
        }
        public void update(Receita r) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                stmt = con.prepareStatement("UPDATE receita SET titulo = ?, valor = ?, data = ?, id_categoria_receita = ?   WHERE id_receita = ?");
                
                stmt.setString(1, r.getTitulo());
                stmt.setDouble(2, r.getValor());
                stmt.setDate(3, (Date) r.getData());
                stmt.setInt(4, r.getId_categoria_receita());
                stmt.setInt(5, r.getId_receita());
                
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);

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
                Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        public List<Receita> readForDesc(String titulo, int id_usuario) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Receita> receitas = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM receita WHERE titulo LIKE ? and id_usuario = ?");
            stmt.setString(1, "%" + titulo + "%");
            stmt.setInt(2, id_usuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Receita receita = new Receita();
                    receita.setId_receita(rs.getInt("id_receita"));
                    receita.setTitulo(rs.getString("titulo"));
                    receita.setValor(rs.getDouble("valor"));
                    receita.setId_usuario(rs.getInt("id_usuario"));
                    receita.setData(rs.getDate("data"));
                    receita.setCode(rs.getInt("code")); 

                receitas.add(receita);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return receitas;
    }
        public List<Receita> readReceitaByIdUser(int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<Receita> receitas = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM receita WHERE id_usuario = ?");
                stmt.setInt(1, id_usuario);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                  Receita receita = new Receita();
                    
                    receita.setId_receita(rs.getInt("id_receita"));
                    receita.setTitulo(rs.getString("titulo"));
                    receita.setValor(rs.getDouble("valor"));
                    receita.setId_usuario(rs.getInt("id_usuario"));
                    receita.setData(rs.getDate("data"));
                    receita.setId_categoria_receita(rs.getInt("id_categoria_receita"));
                   // receita.setCode(rs.getInt("code"));
                    
                    receitas.add(receita);
                }
            } catch(SQLException ex) {
              Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return receitas;
        }
        public List <Receita> readDepesaByIdUserAndCodeList(int id_usuario,int code) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<Receita> receitas = new ArrayList<>();
            
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM receita WHERE id_usuario = ? and code = ?");
                stmt.setInt(1, id_usuario);
                stmt.setInt(2, code);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Receita receita = new Receita();
                    receita.setId_receita(rs.getInt("id_receita"));
                    receita.setTitulo(rs.getString("titulo"));
                    receita.setValor(rs.getDouble("valor"));
                    receita.setData(rs.getDate("data"));
                    receita.setCode(rs.getInt("code"));
                    receita.setId_usuario(rs.getInt("id_usuario"));
                    receitas.add(receita);
                }
            } catch(SQLException ex) {
              Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return receitas;
        }
        public void deleteAll(int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
             ResultSet rs = null;
            try {
                stmt = con.prepareStatement("DELETE FROM receita WHERE id_usuario = ?");
                
                stmt.setInt(1, id_usuario);
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Todas as receitas foram deletadas com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
          public List<Receita> filterByYearAndMonth(String year, String month, int id_usuario) throws ClassNotFoundException, SQLException {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Receita> receitas = new ArrayList<>();
    
    try {
        con = ConnectionFactory.getConnection();
        
        StringBuilder query = new StringBuilder("SELECT * FROM receita WHERE id_usuario = ?");
        
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
            Receita receita = new Receita();
            receita.setTitulo(rs.getString("titulo"));
            receita.setData(rs.getDate("data"));
            receita.setValor(rs.getDouble("valor"));
            receita.setCode(rs.getInt("code")); 
            receitas.add(receita);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Erro ao Filtrar: " + ex.getMessage());
    } finally {
        ConnectionFactory.closeConnection(con, stmt, rs);
    }
    
    return receitas;
}
}
