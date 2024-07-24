/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.RepositoryService;

import java.sql.SQLException;
import java.util.Date;
import model.bean.CategoriaDespesa;
import model.bean.Despesa;
import model.dao.CategoriaDespesaDAO;
import model.dao.DespesaDAO;

/**
 *
 * @author heyto
 */
public class DespesaRepositoryService {
    
    public static void create(String titulo, double valor, String data, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        Despesa d = new Despesa();
        DespesaDAO despesadao = new DespesaDAO();
        
        CategoriaDespesa desp = new CategoriaDespesa();
        CategoriaDespesaDAO desps = new CategoriaDespesaDAO();
        
        desp = desps.readByIdAndCode(id_usuario, code).getFirst();
        System.out.println(desp.toString());
        d.setTitulo(titulo);
        d.setValor(valor);
        d.setData(java.sql.Date.valueOf(data));
        d.setId_categoria_despesa(desp.getId_categoria_despesa());
        d.setId_usuario(id_usuario);
        
        despesadao.Create(d);
    }
    public static void update(String titulo, double valor, String data, int code, int id_usuario, int id_despesa) throws ClassNotFoundException, SQLException{
        //bean 
        CategoriaDespesa desp = new CategoriaDespesa();
        Despesa d = new Despesa();
        //dao
        DespesaDAO despesadao = new DespesaDAO();
        CategoriaDespesaDAO desps = new CategoriaDespesaDAO();
        //operator
        desp = desps.readByIdAndCode(id_usuario, code).getFirst();
        int id_cat_desp = desp.getId_categoria_despesa();
        
        //Database
        d.setTitulo(titulo);
        d.setValor(valor);
        d.setData(java.sql.Date.valueOf(data));
        d.setId_usuario(id_usuario);
        d.setId_despesa(id_despesa);
        d.setId_categoria_despesa(id_cat_desp);
        despesadao.update(d);
    }
    public static void delete(int id_despesa) throws ClassNotFoundException, SQLException{
         Despesa d = new Despesa();
         DespesaDAO despesadao = new DespesaDAO();
         
         d.setId_despesa(id_despesa);
         despesadao.delete(d);
    }
}
