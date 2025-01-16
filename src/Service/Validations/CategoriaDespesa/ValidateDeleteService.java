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
    public static boolean execute(int id_usuario, int antigocode) throws ClassNotFoundException, SQLException{
        boolean existsDespesa = Service.Validations.CategoriaDespesa.ValidateDeleteExistsDespesaByIdCatService.execute(id_usuario, antigocode);
        
        if(existsDespesa){
            return false;
        }
        return true;
    }
}
