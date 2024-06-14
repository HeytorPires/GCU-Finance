
import java.sql.SQLException;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author heyto
 */
public class UserUpdateService {
    public void update(String nome, String email, int id_usuario) throws ClassNotFoundException, SQLException{
        Usuario u = new Usuario();
        UsuarioDAO userdao = new UsuarioDAO();
                
        u.setLogin(nome);
        u.setEmail(email);
        u.setId_usuario(id_usuario);

        userdao.AlterarUsuario(nome, email, id_usuario);
    }
}
