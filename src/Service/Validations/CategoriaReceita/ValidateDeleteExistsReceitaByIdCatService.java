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
public class ValidateDeleteExistsReceitaByIdCatService {
    public static boolean validateExitsReceitaByIdcat(int id_usuario, int code) throws ClassNotFoundException, SQLException{
        ReceitaDAO ddao = new ReceitaDAO();
        List<Receita> categoriaReceita;
        categoriaReceita = ddao.readDepesaByIdUserAndCodeList(id_usuario, code);
        System.out.println("code existente :" + categoriaReceita);
        if(categoriaReceita.isEmpty()){
            return false;
        }
        JOptionPane.showMessageDialog(null, "Não foi possivel excluir a categoria pois ela está presente em uma despesa! " );
        return true;
    }
}
