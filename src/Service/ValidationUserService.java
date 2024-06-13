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
import model.dao.UsuarioDAO;

/**
 *
 * @author Usuario
 */
public class ValidationUserService {
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
    if (!ValidationUserService.validEmailUser(EmailNovo)) {
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



    public static boolean validateCreateUser(String nome, String email, String senha, String confirmarSenha) {
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return false; 
        }

        if (!senha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(null, "Campo de confirmar senha está diferente da senha.");
            return false; 
        }

        if (!ValidationUserService.validEmailUser(email)) {
            JOptionPane.showMessageDialog(null, "E-mail inválido.");
            return false;
        }

        return true;
    }

}
