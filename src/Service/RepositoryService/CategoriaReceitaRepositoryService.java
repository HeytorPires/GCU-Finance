/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.RepositoryService;

import java.sql.SQLException;
import model.bean.CategoriaReceita;
import model.dao.CategoriaReceitaDAO;

/**
 *
 * @author heyto
 */
public class CategoriaReceitaRepositoryService {
    public static void create(String titulo, String descricao, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        CategoriaReceita d = new CategoriaReceita();
        CategoriaReceitaDAO categoriadDespesadao = new CategoriaReceitaDAO();
        
        d.setNome(titulo);
        d.setDescricao(descricao);
        d.setCode(code);
        d.setId_usuario(id_usuario);
        categoriadDespesadao.Create(d);
    }
    public static void update(String titulo, String descricao, int code, int id_usuario) throws ClassNotFoundException, SQLException{
        CategoriaReceita d = new CategoriaReceita();
        CategoriaReceitaDAO categoriadDespesadao = new CategoriaReceitaDAO();
        
        d.setNome(titulo);
        d.setDescricao(descricao);
        d.setCode(code);
        d.setId_usuario(id_usuario);
        categoriadDespesadao.update(d);
    }
    public static void delete(int id_categoriareceita) throws ClassNotFoundException, SQLException{
         CategoriaReceita d = new CategoriaReceita();
         CategoriaReceitaDAO categoriadDespesadao = new CategoriaReceitaDAO();
         
         d.setId_categoria_receita(id_categoriareceita);
         categoriadDespesadao.delete(d);
    }
}
