/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.CategoriaDespesa;

import java.sql.SQLException;

/**
 *
 * @author heyto
 */
public class ValidateDeleteService {
    public static boolean ValidateDeleteCatDespesas(int id_usuario, int code) throws ClassNotFoundException, SQLException{
        if(Service.Validations.CategoriaDespesa.ValidateDeleteExistsDespesaByIdCatService.validateExitsDespesaByIdcat(id_usuario, code)){
            return false;
        }
        return true;
    }
}
