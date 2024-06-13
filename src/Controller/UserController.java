/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Service.UserService;
import Service.ValidationService;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import visao.Sobre.TelaSobre;

/**
 *
 * @author heyto
 */
public class UserController {
    
    public static void ValidarCadastroUsuario(String nome, String email, String senha, String confirmarSenha) throws ClassNotFoundException, SQLException{
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return; 
        }

        if (!senha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(null, "Campo de confirmar senha está diferente da senha");
            return; 
        }
        if(ValidationService.validEmailUser(email)){
            UserService.create(nome, email, senha);
        }
    }
    public static void validarAtualizarUsuario(){
        
    }
}
