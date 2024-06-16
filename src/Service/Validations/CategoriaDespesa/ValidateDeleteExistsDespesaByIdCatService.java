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
public class ValidateDeleteExistsDespesaByIdCatService {
    public static boolean validateExitsDespesaByIdcat(int id_usuario, int code) throws ClassNotFoundException, SQLException{
        DespesaDAO ddao = new DespesaDAO();
        List<Despesa> categoriaDespesa;
        categoriaDespesa = ddao.readDepesaByIdUserAndCodeList(id_usuario, code);
        System.out.println("code existente :" + categoriaDespesa);
        if(categoriaDespesa.isEmpty()){
            return false;
        }
        JOptionPane.showMessageDialog(null, "Não foi possivel excluir a categoria pois ela está presente em uma despesa! " );
        return true;
    }
}
