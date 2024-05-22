/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import model.Usuario;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Laboratorio
 */
public class repositorioUsuarios {
    public static List<Usuario> usuarios = new ArrayList<>();
    
    public static void init() {
        usuarios.add( new Usuario(02,"Barbara" ,"barbara.cacho@gmail.com","senha123"));
        usuarios.add( new Usuario(03, "usuario", "usuario.user@gmail.com", "usuario"));
      
    }
    public static Usuario validarUsuario(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null; // Retorna null se as credenciais forem inválidas
    }
}

//private Long id;
   //rivate String login;
    //private String email;
    //private String senha;
    //private String tipo;
