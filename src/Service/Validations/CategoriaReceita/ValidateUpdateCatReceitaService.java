/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.CategoriaReceita;


import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.CategoriaReceita;
import model.dao.CategoriaReceitaDAO;

/**
 *
 * @author heyto
 */
public class ValidateUpdateCatReceitaService {
     public static boolean validateUpdateCatReceita(String titulo, String Descricao, int code,int antigocode, int id_usuario) throws ClassNotFoundException, SQLException {
         if (titulo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo titulo");
            return false;
        }
         if(Descricao.isEmpty()){
             JOptionPane.showMessageDialog(null, "Por favor, preencha o campo Descricao");
            return false;
         }
         if(!Service.Validations.CategoriaReceita.ValidateUpdateExistsReceitaByIdCatService.ValidateUpdateExistsReceitaByIdCat(id_usuario, antigocode, code)){
             return false;
         }
         if(Service.Validations.CategoriaReceita.ValidateUpdateExistsCatReceitaService.ValidateUpdateExistsCatReceita(id_usuario,code, antigocode)){
                return true;
         }
     return false;
     }
}
