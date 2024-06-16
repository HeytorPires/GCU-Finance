package Service.Validations.CategoriaDespesa;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.CategoriaDespesa;

public class ValidateUpdateExistsCatDespesaService {

    public static boolean ValidateUpdateExistsCatDespesa(int id_usuario, int code, int antigoCode) throws ClassNotFoundException, SQLException {
        List<CategoriaDespesa> categoriaDespesaList;
        
        categoriaDespesaList = Service.RepositoryService.CategoriaDespesaRepositoryService.FindCatByUserAndCode(id_usuario, code);

        if (categoriaDespesaList.isEmpty()) {
            System.out.println("Categoria não existe, pode atualizar.");
            return true;
        }
        CategoriaDespesa categoriaDespesa = categoriaDespesaList.get(0);
        int codeBanco = categoriaDespesa.getCode();
        if (antigoCode == codeBanco) {
            return true;
        }
        System.out.println("Validando atualização...");
        System.out.println("Código no banco: " + codeBanco + ", Código fornecido: " + code);

        if (code == codeBanco) {
            JOptionPane.showMessageDialog(null, "Já existe uma categoria com esse código.");
            return false;
        }
        return true;
    }
}
