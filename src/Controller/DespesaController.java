/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.SQLException;

/**
 *
 * @author heyto
 */
public class DespesaController {
     public static boolean Create(String titulo, double valor, String data, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        if(Service.Validations.Despesa.ValidateCreateDespesaService.validateCreateDespesa(titulo, valor, data)){
            String Data = Service.Validations.Despesa.ConvertStringDateService.converterDataParaMySQL(data);
            Service.RepositoryService.DespesaRepositoryService.create(titulo, valor, Data, code, id_usuario);
            return true;
        } 
        return false;
     }
     public static boolean Update(String titulo, double valor, String data, int code, int id_usuario, int id_despesa) throws ClassNotFoundException, SQLException {
        if(Service.Validations.Despesa.ValidateUpdateDespesaService.validateUpdateUser(titulo, valor, data)){
            String Data = Service.Validations.Despesa.ConvertStringDateService.converterDataParaMySQL(data);
            Service.RepositoryService.DespesaRepositoryService.update(titulo, valor, Data, code, id_usuario, id_despesa);
            return true;
        }
        return false;
    }
     public static boolean Delete(int id_despesa) throws ClassNotFoundException, SQLException{
         Service.RepositoryService.DespesaRepositoryService.delete(id_despesa);
         return true;
     }
}
