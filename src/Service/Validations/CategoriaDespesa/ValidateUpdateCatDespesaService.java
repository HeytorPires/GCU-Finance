/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.CategoriaDespesa;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.CategoriaDespesa;
import model.dao.CategoriaDespesaDAO;

/**
 *
 * @author heyto
 */
public class ValidateUpdateCatDespesaService {
     public static boolean validateUpdateCatDespesa(String titulo, String Descricao, int code,int antigocode, int id_usuario) throws ClassNotFoundException, SQLException {
         if (titulo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo titulo");
            return false;
        }
         if(Descricao.isEmpty()){
             JOptionPane.showMessageDialog(null, "Por favor, preencha o campo Descricao");
            return false;
         }
         if(!Service.Validations.CategoriaDespesa.ValidateUpdateExistsDespesaByIdCatService.ValidateUpdateExistsDespesaByIdCat(id_usuario, antigocode, code)){
             return false;
         }
         if(Service.Validations.CategoriaDespesa.ValidateUpdateExistsCatDespesaService.ValidateUpdateExistsCatDespesa(id_usuario,code, antigocode)){
                return true;
         }
     return false;
     }
}
