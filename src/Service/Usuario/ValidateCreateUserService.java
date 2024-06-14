/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Usuario;

import javax.swing.JOptionPane;

/**
 *
 * @author heyto
 */
public class ValidateCreateUserService {
    public static boolean validateCreateUser(String nome, String email, String senha, String confirmarSenha) {
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return false; 
        }

        if (!senha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(null, "Campo de confirmar senha está diferente da senha.");
            return false; 
        }

        if (!ValidationEmailService.validEmailUser(email)) {
            JOptionPane.showMessageDialog(null, "E-mail inválido.");
            return false;
        }

        return true;
    }
}
