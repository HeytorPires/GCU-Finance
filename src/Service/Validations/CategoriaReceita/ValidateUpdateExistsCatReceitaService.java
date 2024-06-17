package Service.Validations.CategoriaReceita;


import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.CategoriaReceita;

public class ValidateUpdateExistsCatReceitaService {

    public static boolean ValidateUpdateExistsCatReceita(int id_usuario, int code, int antigoCode) throws ClassNotFoundException, SQLException {
        List<CategoriaReceita> categoriaReceitaList;
        
        categoriaReceitaList = Service.RepositoryService.CategoriaReceitaRepositoryService.FindCatByUserAndCode(id_usuario, code);

        if (categoriaReceitaList.isEmpty()) {
            System.out.println("Categoria não existe, pode atualizar.");
            return true;
        }
        CategoriaReceita categoriaReceita = categoriaReceitaList.get(0);
        int codeBanco = categoriaReceita.getCode();
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
