package test.model;

import model.Usuario;

public class UsuarioTeste {
    
    public static void main(String[] args) {
        String login = "teste";
        String senha = "123";
        Usuario usuario = new Usuario(login, senha);
        System.out.println(usuario.getLogin().equals(login));
        System.out.println(usuario.getSenha().equals(senha));
        System.out.println(usuario);
    }
    
}
