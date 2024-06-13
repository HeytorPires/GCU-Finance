/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author Usuario
 */
public class ValidationService {
     public static boolean validEmailUser(String email) {
        if (email == null) {
            return false;
        }
        return email.endsWith("@gmail.com");
    }
     
    public static boolean validatePasswordUpdate(String AntigaSenhaDB, String AntigaSenhaInput, String SenhaInput, String SenhaInputConfirme){
    // Variáveis de inicialização
    boolean SenhaAntigaCorreta = false;
    boolean SenhasBatendo = false;
    List<String> erros = new ArrayList<>();

    // Verificação da senha antiga
    if (AntigaSenhaDB.equals(AntigaSenhaInput)) {
        SenhaAntigaCorreta = true;
    } else {
        erros.add("Senha antiga está incorreta");
    }

    // Verificação de correspondência das novas senhas
    if (SenhaInput.equals(SenhaInputConfirme)) {
        SenhasBatendo = true;
    } else {
        erros.add("Senhas inseridas não batem");
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
    public static boolean validateUserUpdate(String NomeNovo, String EmailNovo, int id_usuario) throws ClassNotFoundException, SQLException {
    boolean differentName = true;
    boolean differentEmail = true;

    // Buscar o usuário do banco de dados
    Usuario User = UserService.findUserByUser(id_usuario);
    String nameDB = User.getUsername();
    String EmailDB = User.getEmail();

    // Verificar se o nome novo é igual ao nome antigo
    if (nameDB.equals(NomeNovo)) {
        differentName = false;
        JOptionPane.showMessageDialog(null, "Não foi possível alterar o nome: Nome novo é igual ao antigo.");
    }

    // Verificar se o email novo é igual ao email antigo
    if (EmailDB.equals(EmailNovo)) {
        differentEmail = false;
        JOptionPane.showMessageDialog(null, "Não foi possível alterar o email: Email novo é igual ao antigo.");
    }

    // Verificar se os campos de nome e email não estão vazios, senão mantêm os valores antigos
    if (NomeNovo.isEmpty()) {
        NomeNovo = nameDB;
    }
    if (EmailNovo.isEmpty()) {
        EmailNovo = EmailDB;
    }

    // Validar se o email segue o padrão correto
    if (!ValidationService.validEmailUser(EmailNovo)) {
        JOptionPane.showMessageDialog(null, "Email não está nos padrões de email, use um email legítimo! (@gmail.com)");
        return false;
    }

    // Se ambos nome e email são diferentes dos valores antigos, retorna true
    if (differentEmail && differentName) {
        return true;
    } else {
        // Mensagem genérica caso os dois campos não tenham sido atualizados corretamente
        if (!differentName && !differentEmail) {
            JOptionPane.showMessageDialog(null, "Nome e email não foram alterados.");
        } else if (!differentName) {
            JOptionPane.showMessageDialog(null, "Nome não foi alterado.");
        } else {
            JOptionPane.showMessageDialog(null, "Email não foi alterado.");
        }
        return false;
    }
}
    public static boolean validateCreateUser(String nome, String email, String senha, String confirmarSenha) {
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return false; 
        }

        if (!senha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(null, "Campo de confirmar senha está diferente da senha.");
            return false; 
        }

        if (!ValidationService.validEmailUser(email)) {
            JOptionPane.showMessageDialog(null, "E-mail inválido.");
            return false;
        }

        return true;
    }

}
