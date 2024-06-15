/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Despesa;

import javax.swing.JOptionPane;

/**
 *
 * @author heyto
 */
public class ValidateUpdateDespesaService {
     public static boolean validateUpdateUser(String titulo, double valor, String data) {
         if ( titulo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo titulo");
            return false;
        }
         if(Double.isNaN(valor)){
              JOptionPane.showMessageDialog(null, "Por favor, preencha o campo valor");
                return false;
         } if(data.isEmpty()){
             JOptionPane.showMessageDialog(null, "Por favor, preencha o campo data");
            return false;
         }
        return true;
    }
}
