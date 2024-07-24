/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.CategoriaReceita;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Receita;
import model.dao.ReceitaDAO;

/**
 *
 * @author heyto
 */
public class ValidateUpdateExistsReceitaByIdCatService {
    public static boolean ValidateUpdateExistsReceitaByIdCat(int id_usuario, int antigocode, int code) throws ClassNotFoundException, SQLException{
        ReceitaDAO ddao = new ReceitaDAO();
        List<Receita> categoriaReceita;
        categoriaReceita = ddao.readReceitaByIdUserAndCodeList(id_usuario, antigocode);
        System.out.println("code existente :" + categoriaReceita);
        if(code != antigocode){
        if(!categoriaReceita.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar código da categoria, porque a categoria está presente em uma receita! " );
            return false;
        }    
        }
        return true;
    }
}
