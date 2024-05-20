package model;

public class Usuario {
    private Long id;
    private String login;
    private String email;
    private String senha;
    private String tipo;

    public Usuario(Long id, String login, String email, String senha, String tipo) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

     public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", email=" + email + ", senha=" + senha + ", tipo=" + tipo + '}';
    }

    
    
    
}
