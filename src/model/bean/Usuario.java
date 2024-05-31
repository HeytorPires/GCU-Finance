package model.bean;

public class Usuario {
    private int id_usuario;
    private String username;
    private String email;
    private String senha;

    public Usuario(int id_usuario, String username, String email, String senha) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.email = email;
        this.senha = senha;
    }

     public Usuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

    public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLogin(String login) {
        this.username = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id_usuario + ", login=" + username + ", email=" + email + ", senha=" + senha + '}';
    }

    
    
    
}
