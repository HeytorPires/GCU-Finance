/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.CategoriaDespesa;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author heyto
 */
public class ValidateCreateService {
     public static boolean validateCreateCatDespesa(String titulo, String Descricao, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        if ( titulo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo titulo");
            return false;
        }
         if(code == 0){
              JOptionPane.showMessageDialog(null, "Por favor, preencha o campo code");
                return false;
         }
         if(Descricao.isEmpty()){
             JOptionPane.showMessageDialog(null, "Por favor, preencha o campo Descricao");
            return false;
         }
         if(!ValidateCreateExistsCatDespesaService.ValidateExistsCatDespesa(id_usuario, code)){
          return false;   
         }
     return true;
     }
}
