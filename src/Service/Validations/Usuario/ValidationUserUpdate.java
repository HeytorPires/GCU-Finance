/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.Usuario;

import Service.Validations.Usuario.ValidationEmailService;
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
        boolean NomeDiferente = false;
        boolean EmailDiferente = false;

        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.readUserByID(id_usuario);

        String nomeDB = user.getUsername();
        String emailDB = user.getEmail();

        // Verificar se o nome novo é diferente do nome antigo
        if (!NomeNovo.isEmpty() && !nomeDB.equals(NomeNovo)) {
            NomeDiferente = true;
        }

        // Verificar se o email novo é diferente do email antigo
        if (!EmailNovo.isEmpty() && !emailDB.equals(EmailNovo)) {
            if (!ValidationEmailService.validEmailUser(EmailNovo)) {
                JOptionPane.showMessageDialog(null, "Email não está nos padrões de email, use um email legítimo! (@gmail.com)");
                return false;
            }
            EmailDiferente = true;
        } else if (EmailNovo.isEmpty()) {
            // Se não foi informado um novo email, manter o email existente
            EmailNovo = emailDB;
            EmailDiferente = false; // Não houve diferença no email
        }

        // Se houve diferença no nome ou email, atualiza no banco de dados
        if (NomeDiferente || EmailDiferente) {
            // Validar se o novo nome não está vazio
            if (NomeNovo.isEmpty()) {
                NomeNovo = nomeDB; // Manter o nome existente
            }
            
            userDAO.AlterarUsuario(NomeNovo, EmailNovo, id_usuario);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma alteração foi realizada.");
            return false;
        }
    }
}
