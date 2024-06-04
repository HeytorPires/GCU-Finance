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
     public List<Movimentacao> readById(int id_usuario) throws ClassNotFoundException, SQLException{
            
            Connection con = (Connection) ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            List<Movimentacao> receitas = new ArrayList<>();
            
            try{
                
                stmt = con.prepareStatement("SELECT * FROM despesa d, receita r  WHERE d.id_usuario and r.id_usuario = ?");
                stmt.setInt(1, id_usuario);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                  Movimentacao receita = new Movimentacao();
                    
                    receita.setId_movimentacao(rs.getInt("id_receita"));
                    receita.setTitulo(rs.getString("titulo"));
                    receita.setValor(rs.getDouble("valor"));
                    receita.setId_usuario(rs.getInt("id_usuario"));
                    receita.setData(rs.getDate("data"));
                    receita.setCode(rs.getInt("code"));
                    
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
