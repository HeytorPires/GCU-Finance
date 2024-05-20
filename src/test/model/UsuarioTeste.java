package test.model;

import model.Usuario;

public class UsuarioTeste {
    
    public static void main(String[] args) {
        String login = "teste";
        String senha = "123";
        long id = 123123;
        String email = "heytor@gmail.com";
        String tipo = "2";
        Usuario usuario = new Usuario(id, login, email, senha, tipo);
        System.out.println(usuario.getLogin().equals(login));
        System.out.println(usuario.getSenha().equals(senha));
        System.out.println(usuario);
    }
    
}
// public Usuario(Long id, String login, String email, String senha, String tipo) {
     //   this.id = id;
     ///   this.login = login;
     //q/   this.email = email;
     //   this.senha = senha;
     //   this.tipo = tipo;
   // };