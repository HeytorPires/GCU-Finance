package test.model;
import model.Usuario;

public class UsuarioTeste {
    
    public static void main(String[] args) {
        //
        String nome = "Heytor";
        String senha = "senha123";
        int id = 01;
        String email = "heytor@gmail.com";
        Usuario usuario = new Usuario(id, nome, email, senha);
        System.out.println(usuario.getUsername().equals(nome));
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