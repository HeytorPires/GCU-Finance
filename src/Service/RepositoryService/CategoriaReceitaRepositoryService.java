/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.RepositoryService;

import java.sql.SQLException;
import java.util.List;

import model.bean.CategoriaReceita;
import model.dao.CategoriaReceitaDAO;

/**
 *
 * @author heyto
 */
public class CategoriaReceitaRepositoryService {
    public static void create(String titulo, String descricao, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        CategoriaReceita cd = new CategoriaReceita();
        CategoriaReceitaDAO categoriadReceitadao = new CategoriaReceitaDAO();
        
        cd.setNome(titulo);
        cd.setDescricao(descricao);
        cd.setCode(code);
        cd.setId_usuario(id_usuario);
        categoriadReceitadao.Create(cd);
    }
    public static void update(String titulo, String descricao,int code, int id_categoria_receita) throws ClassNotFoundException, SQLException{
        CategoriaReceita cd = new CategoriaReceita();
        CategoriaReceitaDAO categoriadReceitadao = new CategoriaReceitaDAO();
        
        cd.setNome(titulo);
        cd.setDescricao(descricao);
        cd.setId_categoria_receita(id_categoria_receita);
        cd.setCode(code);
        categoriadReceitadao.update(cd);
    }
    public static void delete(int id_cat_receita) throws ClassNotFoundException, SQLException{
         CategoriaReceita cd = new CategoriaReceita();
         CategoriaReceitaDAO categoriadReceitadao = new CategoriaReceitaDAO();
         
         cd.setId_categoria_receita(id_cat_receita);
         categoriadReceitadao.delete(cd);
    }
    public static List<CategoriaReceita> FindCatByUserAndCode(int id_usuario, int code) throws ClassNotFoundException, SQLException{
        CategoriaReceitaDAO categoriaReceitadao = new CategoriaReceitaDAO();
        return  categoriaReceitadao.readByIdAndCode(id_usuario, code);
    }
     public static List<CategoriaReceita> FindCatByUserAndCodeForUpdate(int id_usuario, int code, int id_categoriaReceita) throws ClassNotFoundException, SQLException{
        CategoriaReceitaDAO categoriaReceitadao = new CategoriaReceitaDAO();
        return  categoriaReceitadao.readByIdAndCodeAndId(id_usuario, code, id_categoriaReceita);
    }
}
