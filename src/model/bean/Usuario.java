package model;

public class Usuario {
    private int id;
    private String username;
    private String email;
    private String senha;

    public Usuario(int id, String username, String email, String senha) {
        this.id = id;
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
     
    public int getId() {
        return id;
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
        return "Usuario{" + "id=" + id + ", login=" + username + ", email=" + email + ", senha=" + senha + '}';
    }

    
    
    
}
