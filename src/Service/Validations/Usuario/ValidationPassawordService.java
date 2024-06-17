/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author heyto
 */
public class ValidationPassawordService {
    public static boolean validatePasswordUpdate(String AntigaSenhaDB, String AntigaSenhaInput, String SenhaInput, String SenhaInputConfirme, int id_usuario) throws ClassNotFoundException, SQLException{
        UsuarioDAO udao = new UsuarioDAO();
        Usuario user = udao.readUserByID(id_usuario);
        
        AntigaSenhaDB = user.getSenha();

    boolean SenhaAntigaCorreta = false;
    boolean SenhasBatendo = false;
    List<String> erros = new ArrayList<>();

    // Verificação da senha antiga
    if (AntigaSenhaDB.equals(AntigaSenhaInput)) {
        SenhaAntigaCorreta = true;
    } else {
        erros.add("Senha antiga está incorreta");
        SenhaAntigaCorreta = false;
    }

    // Verificação de correspondência das novas senhas
    if (SenhaInput.equals(SenhaInputConfirme)) {
        SenhasBatendo = true;
    } else {
        erros.add("Senhas inseridas não batem");
        SenhasBatendo = false;
    }

    // Verificação se a nova senha é igual à senha antiga
    if (AntigaSenhaDB.equals(SenhaInput)) {
        erros.add("Não foi possível alterar a senha: a nova senha é igual à antiga");
    }

    // Verificação se a nova senha é vazia
    if (SenhaInput.isEmpty()) {
        erros.add("ERRO: não é possível alterar a senha para vazio!");
    }

    // Exibição das mensagens de erro, se houverem
    if (!erros.isEmpty()) {
        for (String erro : erros) {
            JOptionPane.showMessageDialog(null, erro);
        }
        return false;
    }

    // Se todas as verificações passarem, retorna true
    return SenhaAntigaCorreta && SenhasBatendo;
    }
}
