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
     public static boolean validateDespesaCreate(String titulo, double valor, String data, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        if(Service.Despesa.ValidateCreateDespesaService.validateCreateDespesa(titulo, valor, data)){
            String Data = Service.Despesa.ConvertStringDateService.converterDataParaMySQL(data);
            Service.Despesa.DespesaServiceRepository.create(titulo, valor, Data, code, id_usuario);
            return true;
        } 
        return false;
     }
     public static boolean validateDespesaUpdate(String titulo, double valor, String data, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        if(Service.Despesa.ValidateUpdateDespesaService.validateUpdateUser(titulo, valor, data)){
            String Data = Service.Despesa.ConvertStringDateService.converterDataParaMySQL(data);
            Service.Despesa.DespesaServiceRepository.update(titulo, valor, Data, code, id_usuario);
            return true;
        }
        return false;
    }
}
