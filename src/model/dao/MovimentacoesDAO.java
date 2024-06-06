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
                    moviG.setCode(rs.getInt("code"));
                    //moviG.setId_usuario(rs.getInt("id_usuario"));
                    moviG.setTipo(rs.getString("tipo"));
                    
                    Movis.add(moviG);
                }
            } catch(SQLException ex) {
              Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
            } finally{
                ConnectionFactory.CloseConnection(con, stmt, rs);
            }
            return Movis;
        }
}
