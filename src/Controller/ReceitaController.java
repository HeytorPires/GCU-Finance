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
public class ReceitaController {
    public static boolean validateDespesaCreate(String titulo, double valor, String data, int code, int id_usuario) throws ClassNotFoundException, SQLException  {
        if(Service.Validations.Receita.ValidateCreateReceitaService.validateCreateDespesa(titulo, valor, data)){
            String Data = Service.Validations.Receita.ConvertStringDateService.converterDataParaMySQL(data);
            Service.RepositoryService.ReceitaRepositoryService.create(titulo, valor, Data, code, id_usuario);
            return true;
        } 
        return false;
     }
     public static boolean validateDespesaUpdate(String titulo, double valor, String data, int code, int id_usuario, int id_despesa) throws ClassNotFoundException, SQLException {
        if(Service.Validations.Receita.ValidateCreateReceitaService.validateCreateDespesa(titulo, valor, data)){
            String Data = Service.Validations.Receita.ConvertStringDateService.converterDataParaMySQL(data);
            Service.RepositoryService.ReceitaRepositoryService.update(titulo, valor, Data, code, id_usuario, id_despesa);
            return true;
        }
        return false;
    }
     public static boolean validateDespesaDelete(int id_despesa) throws ClassNotFoundException, SQLException{
         Service.RepositoryService.ReceitaRepositoryService.delete(id_despesa);
         return true;
     }
}
