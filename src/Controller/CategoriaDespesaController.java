/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.SQLException;
import java.util.List;
import model.bean.CategoriaDespesa;
import model.dao.CategoriaDespesaDAO;

/**
 *
 * @author heyto
 */
public class CategoriaDespesaController {
    public static boolean validateCategoriaDespesaCreate(String titulo, String decricao, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        if(Service.Validations.CategoriaDespesa.ValidateCreateService.validateCreateCatDespesa(titulo, decricao, code, id_usuario)){  
            Service.RepositoryService.CategoriaDespesaRepositoryService.create(titulo, decricao, code, id_usuario);
            return true;
        } 
        return false;
     }
     public static boolean validateCategoriaDespesaUpdate(String titulo, String decricao, int code, int antigocode, int id_usuario) throws ClassNotFoundException, SQLException {
        CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
        List<CategoriaDespesa> BuscandoID;
        BuscandoID = dao.readByIdAndCode(id_usuario, antigocode);
        int id_CategoriaDespesa = BuscandoID.getFirst().getId_categoria_despesa();
         if(Service.Validations.CategoriaDespesa.ValidateUpdateCatDespesaService.validateUpdateCatDespesa(titulo, decricao, code, antigocode, id_usuario)){
            Service.RepositoryService.CategoriaDespesaRepositoryService.update(titulo, decricao, code, id_CategoriaDespesa);
            return true;
        }
        return false;
    }
     public static boolean validateCategoriaDespesaDelete(int id_cat_despesa, int id_usuario, int code) throws ClassNotFoundException, SQLException{
         if(Service.Validations.CategoriaDespesa.ValidateDeleteService.ValidateDeleteCatDespesas(id_usuario, code)){
             Service.RepositoryService.CategoriaDespesaRepositoryService.delete(id_cat_despesa);

         }
         return true;
     }
}
