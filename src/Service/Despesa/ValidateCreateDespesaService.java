/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Despesa;

import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author heyto
 */
public class ValidateCreateDespesaService {
     public static boolean validateCreateUser(String titulo, double valor, String data) {
        if ( titulo.isEmpty() || Double.isNaN(valor) || data.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return false; 
        }
        return true;
    }
}
