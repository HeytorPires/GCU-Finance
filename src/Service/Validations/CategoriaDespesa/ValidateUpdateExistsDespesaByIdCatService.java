/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.CategoriaDespesa;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Despesa;
import model.dao.DespesaDAO;

/**
 *
 * @author heyto
 */
public class ValidateUpdateExistsDespesaByIdCatService {
    public static boolean ValidateUpdateExistsDespesaByIdCat(int id_usuario, int antigocode, int code) throws ClassNotFoundException, SQLException{
        DespesaDAO ddao = new DespesaDAO();
        List<Despesa> categoriaDespesa;
        categoriaDespesa = ddao.readDepesaByIdUserAndCodeList(id_usuario, antigocode);
        System.out.println("code existente :" + categoriaDespesa);
        if(code != antigocode){
        if(!categoriaDespesa.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar código da categoria, porque a categoria está presente em uma despesa! " );
            return false;
        }    
        }
        return true;
    }
}
