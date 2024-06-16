/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.RepositoryService;

import java.sql.SQLException;
import java.util.List;
import model.dao.CategoriaDespesaDAO;
import model.bean.CategoriaDespesa;
/**
 *
 * @author heyto
 */
public class CategoriaDespesaRepositoryService {
      
    public static void create(String titulo, String descricao, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        CategoriaDespesa cd = new CategoriaDespesa();
        CategoriaDespesaDAO categoriadDespesadao = new CategoriaDespesaDAO();
        
        cd.setNome(titulo);
        cd.setDescricao(descricao);
        cd.setCode(code);
        cd.setId_usuario(id_usuario);
        categoriadDespesadao.Create(cd);
    }
    public static void update(String titulo, String descricao,int code, int id_categoria_despesa) throws ClassNotFoundException, SQLException{
        CategoriaDespesa cd = new CategoriaDespesa();
        CategoriaDespesaDAO categoriadDespesadao = new CategoriaDespesaDAO();
        
        cd.setNome(titulo);
        cd.setDescricao(descricao);
        cd.setId_categoria_despesa(id_categoria_despesa);
        cd.setCode(code);
        categoriadDespesadao.update(cd);
    }
    public static void delete(int id_cat_despesa) throws ClassNotFoundException, SQLException{
         CategoriaDespesa cd = new CategoriaDespesa();
         CategoriaDespesaDAO categoriadDespesadao = new CategoriaDespesaDAO();
         
         cd.setId_categoria_despesa(id_cat_despesa);
         categoriadDespesadao.delete(cd);
    }
    public static List<CategoriaDespesa> FindCatByUserAndCode(int id_usuario, int code) throws ClassNotFoundException, SQLException{
        CategoriaDespesaDAO categoriaDespesadao = new CategoriaDespesaDAO();
        return  categoriaDespesadao.readByIdAndCode(id_usuario, code);
    }
     public static List<CategoriaDespesa> FindCatByUserAndCodeForUpdate(int id_usuario, int code, int id_categoriaDespesa) throws ClassNotFoundException, SQLException{
        CategoriaDespesaDAO categoriaDespesadao = new CategoriaDespesaDAO();
        return  categoriaDespesadao.readByIdAndCodeAndId(id_usuario, code, id_categoriaDespesa);
    }
}
