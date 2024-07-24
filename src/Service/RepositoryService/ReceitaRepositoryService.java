/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.RepositoryService;

import java.sql.SQLException;
import model.bean.CategoriaReceita;
import model.bean.Receita;
import model.dao.CategoriaReceitaDAO;
import model.dao.ReceitaDAO;

/**
 *
 * @author heyto
 */
public class ReceitaRepositoryService {
    public static void create(String titulo, double valor, String data, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        //Bean
        CategoriaReceita rect = new CategoriaReceita();
        ReceitaDAO despesadao = new ReceitaDAO();
        //dao
        Receita d = new Receita();
        CategoriaReceitaDAO rects = new CategoriaReceitaDAO();
        
        rect = rects.readByIdAndCode(id_usuario, code).getFirst();
        int id_categoria_receita = rect.getId_categoria_receita();
        
        d.setTitulo(titulo);
        d.setValor(valor);
        d.setData(java.sql.Date.valueOf(data));
        d.setId_categoria_receita(id_categoria_receita);
        d.setId_usuario(id_usuario);
        
        despesadao.Create(d);
    }
    public static void update(String titulo, double valor, String data, int code, int id_usuario, int id_despesa) throws ClassNotFoundException, SQLException{
        //bean
        Receita r = new Receita();
        CategoriaReceita cat_rec = new CategoriaReceita();
        
        //dao
        ReceitaDAO despesadao = new ReceitaDAO();
        CategoriaReceitaDAO CategoriaDAO = new CategoriaReceitaDAO();
        
        //operator
        cat_rec = CategoriaDAO.readByIdAndCode(id_usuario, code).getFirst();
        int id_cate_receita = cat_rec.getId_categoria_receita();
        
        r.setTitulo(titulo);
        r.setValor(valor);
        r.setData(java.sql.Date.valueOf(data));
        r.setId_usuario(id_usuario);
        r.setId_receita(id_despesa);
        r.setId_categoria_receita(id_cate_receita);
        despesadao.update(r);
    }
    public static void delete(int id_despesa) throws ClassNotFoundException, SQLException{
         Receita d = new Receita();
         ReceitaDAO despesadao = new ReceitaDAO();
         
         d.setId_receita(id_despesa);
         despesadao.delete(d);
    }
}
