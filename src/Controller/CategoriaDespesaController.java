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
    public static boolean Create(String titulo, String decricao, int code, int id_usuario) throws ClassNotFoundException, SQLException {
       
        boolean allowedCreate = Service.Validations.CategoriaDespesa.ValidateCreateService.execute(titulo, decricao, code, id_usuario);
        if(allowedCreate){  
            Service.RepositoryService.CategoriaDespesaRepositoryService.create(titulo, decricao, code, id_usuario);
            return true;
        } 
        return false;
     }
     public static boolean Update(String titulo, String decricao, int code, int antigocode, int id_usuario) throws ClassNotFoundException, SQLException {
        CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
        List<CategoriaDespesa> categorysExists;
        categorysExists = dao.readByIdAndCode(id_usuario, antigocode);
        int id_CategoriaDespesa = categorysExists.getFirst().getId_categoria_despesa();
        
        boolean allowedUpdate = Service.Validations.CategoriaDespesa.ValidateUpdateCatDespesaService.execute(titulo, decricao, code, antigocode, id_usuario);
        
         if(allowedUpdate){
            Service.RepositoryService.CategoriaDespesaRepositoryService.update(titulo, decricao, code, id_CategoriaDespesa);
            return true;
        }
        return false;
    }
     public static boolean Delete(int id_cat_despesa, int id_usuario, int antigocode) throws ClassNotFoundException, SQLException{
         boolean allowedDelete = Service.Validations.CategoriaDespesa.ValidateDeleteService.execute(id_usuario, antigocode);
         if(allowedDelete){
             Service.RepositoryService.CategoriaDespesaRepositoryService.delete(id_cat_despesa);

         }
         return true;
     }
}
