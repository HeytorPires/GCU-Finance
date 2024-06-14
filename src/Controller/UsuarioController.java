/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.SQLException;
/**
 *
 * @author heyto
 */
public class UsuarioController {
    
    public static void validateUserRegistration(String nome, String email, String senha, String confirmarSenha) throws ClassNotFoundException, SQLException{
        if(Service.Usuario.ValidateCreateUserService.validateCreateUser(nome, email, senha, confirmarSenha)){
            Service.Usuario.UsuarioServiceRepositoriy.create(nome, email, senha);
        }
    }
    public static void AlterarInfo(String NomeNovo, String EmailNovo, int id_usuario) throws ClassNotFoundException, SQLException{
       if(Service.Usuario.ValidationUserUpdate.validateUserUpdate(NomeNovo, EmailNovo, id_usuario)){
        Service.Usuario.UsuarioServiceRepositoriy.chargeUserInfo(NomeNovo, EmailNovo, id_usuario);
    }
    }
    public static void AlterarSenha(String AntigaSenhaDB, String AntigaSenhaInput, String SenhaInput, String SenhaInputConfirme, int id_usuario) throws SQLException, ClassNotFoundException{
        if(Service.Usuario.ValidationPassawordService.validatePasswordUpdate(AntigaSenhaDB, AntigaSenhaInput, SenhaInput, SenhaInputConfirme, id_usuario)){
           Service.Usuario.UsuarioServiceRepositoriy.chargePassword(SenhaInput, id_usuario);
       }
    }
}
