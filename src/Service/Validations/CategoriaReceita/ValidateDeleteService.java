/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.CategoriaReceita;


import java.sql.SQLException;

/**
 *
 * @author heyto
 */
public class ValidateDeleteService {
    public static boolean ValidateDeleteCatReceitas(int id_usuario, int code) throws ClassNotFoundException, SQLException{
        if(Service.Validations.CategoriaReceita.ValidateDeleteExistsReceitaByIdCatService.validateExitsReceitaByIdcat(id_usuario, code)){
            return false;
        }
        return true;
    }
}
