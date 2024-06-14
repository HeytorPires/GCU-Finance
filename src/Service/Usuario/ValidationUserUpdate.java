/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Usuario;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author heyto
 */
public class ValidationUserUpdate {
    public static boolean validateUserUpdate(String NomeNovo, String EmailNovo, int id_usuario) throws ClassNotFoundException, SQLException {
    boolean NomeDiferente = true;
    boolean EmailDiferente = true;

    UsuarioDAO Userdao = new UsuarioDAO();
    Usuario user = Userdao.readUserByID(id_usuario);
   

    String nomeDB = user.getUsername();
    String EmailDB = user.getEmail();

    if (NomeNovo.isEmpty() && EmailNovo.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nenhum dado foi inserido!");
        return false;
    }

    // Verificar se o nome novo é igual ao nome antigo
    if (!NomeNovo.isEmpty() && nomeDB.equals(NomeNovo)) {
        NomeDiferente = false;
        JOptionPane.showMessageDialog(null, "Não foi possível alterar o Nome: Nome novo é igual ao antigo.");
    }

    // Verificar se o email novo é igual ao email antigo
    if (!EmailNovo.isEmpty() && EmailDB.equals(EmailNovo)) {
        EmailDiferente = false;
        JOptionPane.showMessageDialog(null, "Não foi possível alterar o Email: Email novo é igual ao antigo.");
    }

    // Verificar se os campos de nome e email não estão vazios, senão mantêm os valores antigos
    if (NomeNovo.isEmpty()) {
        NomeNovo = nomeDB;
    }
    if (EmailNovo.isEmpty()) {
        EmailNovo = EmailDB;
    }

    // Validar se o email segue o padrão correto
    if (!ValidationEmailService.validEmailUser(EmailNovo)) {
        JOptionPane.showMessageDialog(null, "Email não está nos padrões de email, use um email legítimo! (@gmail.com)");
       return false;
    }

    // Se pelo menos um dos campos for diferente, realizar a atualização
    if (NomeDiferente || EmailDiferente) {
        Userdao.AlterarUsuario(NomeNovo, EmailNovo, id_usuario);
    } else {
        JOptionPane.showMessageDialog(null, "Nenhuma alteração foi realizada.");
    }
         return false;
    }

}
