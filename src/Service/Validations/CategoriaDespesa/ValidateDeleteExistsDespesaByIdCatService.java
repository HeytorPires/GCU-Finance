/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.CategoriaDespesa;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.CategoriaDespesa;
import model.bean.Despesa;
import model.dao.CategoriaDespesaDAO;
import model.dao.DespesaDAO;

/**
 *
 * @author heyto
 */
public class ValidateDeleteExistsDespesaByIdCatService {
    public static boolean execute(int id_usuario, int code) throws ClassNotFoundException, SQLException{
        //Dao
        DespesaDAO ddao = new DespesaDAO();
        CategoriaDespesaDAO cdao = new CategoriaDespesaDAO();
        //bean
        List<Despesa> categoriaDespesa;
        CategoriaDespesa cat = new CategoriaDespesa();
        //Operator
        cat = cdao.readByIdAndCode(id_usuario, code).getFirst();
        int id_despesa =  cat.getId_categoria_despesa();
        categoriaDespesa = ddao.readDepesaByIdUserAndCodeList(id_usuario, id_despesa);
        System.out.println("code existente :" + categoriaDespesa);
        if(categoriaDespesa.isEmpty()){
            return false;
        }
        JOptionPane.showMessageDialog(null, "Não foi possivel excluir a categoria pois ela está presente em uma despesa! " );
        return true;
    }
}
