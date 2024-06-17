/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.CategoriaReceita;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.CategoriaReceita;

/**
 *
 * @author heyto
 */
public class ValidateCreateExistsCatReceitaService {
    public static boolean ValidateExistsCatReceita(int id_usuario, int code) throws ClassNotFoundException, SQLException{
        List< CategoriaReceita> categoriaReceita;
        categoriaReceita = Service.RepositoryService.CategoriaReceitaRepositoryService.FindCatByUserAndCode(id_usuario, code);
        if(categoriaReceita.isEmpty()){
           return true;
        } 
        int codebanco = categoriaReceita.getFirst().getCode();
        
        if( code == codebanco){
            JOptionPane.showMessageDialog(null, "Não é Possivel cadastrar a categoria de despesa pois o codigo: "+ code + " já existe!" );
            return false;
        }
        return false;
    }
}
