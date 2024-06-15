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
     public static void validateDespesaRegistration(String titulo, double valor, String data, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        if(Service.Despesa.ValidateCreateDespesaService.validateCreateUser(titulo, valor, data)){
            String Data = Service.Despesa.ConvertStringDateService.converterDataParaMySQL(data);
            Service.Despesa.DespesaServiceRepository.create(titulo, valor, Data, code, id_usuario);
        }
    }
}
