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
public class repositorio {
    public static List<Usuario> usuarios = new ArrayList<>();
    
    public static void init() {
        usuarios.add( new Usuario(02,"Barbra" ,"barbara.cacho@gmail.com","senha123"));
      
    }
}

//private Long id;
   //rivate String login;
    //private String email;
    //private String senha;
    //private String tipo;
