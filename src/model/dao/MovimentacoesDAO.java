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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Movimentacao;

/**
 *
 * @author heyto
 */
public class MovimentacoesDAO {
     public List<Movimentacao> readMoviByIdUSer(int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<Movimentacao> Movis = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM MoviGeral WHERE id_usuario = ?");
                stmt.setInt(1, id_usuario);
                    rs = stmt.executeQuery();
                
                while(rs.next()){
                  Movimentacao moviG = new Movimentacao();
                    
                    moviG.setTitulo(rs.getString("titulo"));
                    moviG.setValor(rs.getDouble("valor"));
                    moviG.setData(rs.getDate("data"));
                    moviG.setTipo(rs.getString("tipo"));
                     //moviG.setcosw(rs.getInt("code"));
                    //moviG.setId_usuario(rs.getInt("id_usuario"));
                    
                    Movis.add(moviG);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return Movis;
        }
    public List<Movimentacao> filterByYearAndMonth(String year, String month, int id_usuario) throws ClassNotFoundException, SQLException {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Movimentacao> movimentacaos = new ArrayList<>();
    
    try {
        con = ConnectionFactory.getConnection();
        
        StringBuilder query = new StringBuilder("SELECT * FROM MoviGeral WHERE id_usuario = ?");
        
        boolean filterByYear = !year.equals("Todos");
        boolean filterByMonth = !month.equals("0");
                System.out.println("está vindo aqui");

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
        System.out.println("está vindo aqui3");

        rs = stmt.executeQuery();
        
        while (rs.next()) {
            Movimentacao movimentacao = new Movimentacao();
            movimentacao.setTitulo(rs.getString("titulo"));
            movimentacao.setData(rs.getDate("data"));
            movimentacao.setValor(rs.getDouble("valor"));
            movimentacao.setCode(rs.getInt("code")); 
            movimentacao.setTipo(rs.getString("tipo"));
            movimentacaos.add(movimentacao);
                    System.out.println("está vindo aqui4");
        }
        System.out.println("está vindo aqui5");

    } catch (SQLException ex) {
        Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Erro ao Filtrar: " + ex.getMessage());
    } finally {
        ConnectionFactory.closeConnection(con, stmt, rs);
    }
    
    return movimentacaos;
}
}
