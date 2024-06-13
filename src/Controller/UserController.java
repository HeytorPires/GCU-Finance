/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Service.UserService;
import Service.ValidationService;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Usuario;
import model.dao.UsuarioDAO;
/**
 *
 * @author heyto
 */
public class UserController {
    
    public static void validateUserRegistration(String nome, String email, String senha, String confirmarSenha) throws ClassNotFoundException, SQLException{
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
    public static void validateuserUpdate(String NomeNovo, String EmailNovo, int id_usuario) throws ClassNotFoundException, SQLException{
        boolean differentName = true;
        boolean differentEmail  = true;
        

         Usuario User = UserService.findUserByUser(id_usuario);
         String nameDB = User.getUsername();
         String EmailDB = User.getEmail();
         
         if(nameDB.equals(NomeNovo) ){
             differentName = false;
             JOptionPane.showMessageDialog(null,"Não foi possivel alterar o Nome: Nome Novo é igual ao antigo ");
             
         } 
          
         if(EmailDB.equals(EmailNovo)){
             differentEmail = false;
             JOptionPane.showMessageDialog(null,"Não foi possivel alterar o email: Email Novo é igual ao antigo ");

         } 
         
         if(NomeNovo.equals("")){
                    NomeNovo = nameDB;
                }
         if(EmailNovo.equals("")){
                     EmailNovo = EmailDB;
                 }
        if(ValidationService.validEmailUser(EmailDB)){
            if(differentEmail && differentName){
                 Service.UserService.alterarDadosUsuario(NomeNovo,EmailNovo, id_usuario);

         }
        } else{
            JOptionPane.showMessageDialog(null, "Email não está nos padrões de email, use um email legitimo! (@gmail.com)");
        }
         

    }
}
