/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.CategoriaDespesa;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.CategoriaDespesa;

/**
 *
 * @author heyto
 */
public class ValidateCreateExistsCatDespesaService {
    public static boolean ValidateExistsCatDespesa(int id_usuario, int code) throws ClassNotFoundException, SQLException{
        List< CategoriaDespesa> categoriaDespesa;
        categoriaDespesa = Service.RepositoryService.CategoriaDespesaRepositoryService.FindCatByUserAndCode(id_usuario, code);
        if(categoriaDespesa.isEmpty()){
           return true;
        } 
        int codebanco = categoriaDespesa.getFirst().getCode();
        
        if( code == codebanco){
            JOptionPane.showMessageDialog(null, "Não é Possivel cadastrar a categoria de despesa pois o codigo: "+ code + " já existe!" );
            return false;
        }
        return false;
    }
}
