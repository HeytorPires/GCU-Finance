/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Despesa;

import java.sql.SQLException;
import java.util.Date;
import model.bean.Despesa;
import model.dao.DespesaDAO;

/**
 *
 * @author heyto
 */
public class DespesaServiceRepository {
    
    public static void create(String titulo, double valor, String data, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        Despesa d = new Despesa();
        DespesaDAO despesadao = new DespesaDAO();

        d.setTitulo(titulo);
        d.setValor(valor);
        d.setData(java.sql.Date.valueOf(data));
        d.setCode(code);
        d.setId_usuario(id_usuario);
        
        despesadao.Create(d);
    }
    public static void update(String titulo, double valor, String data, int code, int id_usuario) throws ClassNotFoundException, SQLException{
        Despesa d = new Despesa();
        DespesaDAO despesadao = new DespesaDAO();

        d.setTitulo(titulo);
        d.setValor(valor);
        d.setData(java.sql.Date.valueOf(data));
        d.setCode(code);
        d.setId_usuario(id_usuario);

        despesadao.update(d);
    }
//    public static void checkUsuario(String email, String senha) throws ClassNotFoundException, SQLException{
//        Despesa u = new Despesa();
//        DespesaDAO userdao = new DespesaDAO();
//        u.setEmail(email);
//        u.setSenha(senha);
//        userdao.Create(u);
//    }
//    
//    public static Usuario findUserById(int id_usuario) throws ClassNotFoundException, SQLException{
//        Despesa u = new Despesa();
//        DespesaDAO userdao = new DespesaDAO();
//        userdao.readUserByID(id_usuario);
//        return u;
//    }
//    public static void chargeUserInfo(String nome ,String email, int id_usuario) throws ClassNotFoundException, SQLException{
//        Despesa u = new Despesa();
//        DespesaDAO userdao = new DespesaDAO();
//        u.setLogin(nome);
//        u.setEmail(email);
//        u.setId_usuario(id_usuario);
//        userdao.AlterarUsuario(nome, email, id_usuario);
//    }
//     public static void chargePassword (String SenhaInput, int id_usuario) throws ClassNotFoundException, SQLException{
//         DespesaDAO userdao = new DespesaDAO();
//         userdao.AlterarSenha(SenhaInput, id_usuario);
//     }
}
