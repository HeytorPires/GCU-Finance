/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.SQLException;
import java.util.List;

import model.bean.CategoriaReceita;
import model.dao.CategoriaReceitaDAO;

/**
 *
 * @author heyto
 */
public class CategoriaReceitaController {
     public static boolean validateCategoriaReceitaCreate(String titulo, String decricao, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        if(Service.Validations.CategoriaReceita.ValidateCreateService.validateCreateCatReceita(titulo, decricao, code, id_usuario)){  
            Service.RepositoryService.CategoriaReceitaRepositoryService.create(titulo, decricao, code, id_usuario);
            return true;
        } 
        return false;
     }
     public static boolean validateCategoriaReceitaUpdate(String titulo, String decricao, int code, int antigocode, int id_usuario) throws ClassNotFoundException, SQLException {
        CategoriaReceitaDAO dao = new CategoriaReceitaDAO();
        List<CategoriaReceita> BuscandoID;
        BuscandoID = dao.readByIdAndCode(id_usuario, antigocode);
        int id_CategoriaReceita = BuscandoID.getFirst().getId_categoria_receita();
         if(Service.Validations.CategoriaReceita.ValidateUpdateCatReceitaService.validateUpdateCatReceita(titulo, decricao, code, antigocode, id_usuario)){
            Service.RepositoryService.CategoriaReceitaRepositoryService.update(titulo, decricao, code, id_CategoriaReceita);
            return true;
        }
        return false;
    }
     public static boolean validateCategoriaReceitaDelete(int id_cat_despesa, int id_usuario, int code) throws ClassNotFoundException, SQLException{
         if(Service.Validations.CategoriaReceita.ValidateDeleteService.ValidateDeleteCatReceitas(id_usuario, code)){
             Service.RepositoryService.CategoriaReceitaRepositoryService.delete(id_cat_despesa);
         }
         return true;
     }
}
