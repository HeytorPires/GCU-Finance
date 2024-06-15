/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.RepositoryService;

import java.sql.SQLException;
import model.bean.Receita;
import model.dao.ReceitaDAO;

/**
 *
 * @author heyto
 */
public class ReceitaRepositoryService {
    public static void create(String titulo, double valor, String data, int code, int id_usuario) throws ClassNotFoundException, SQLException {
        Receita d = new Receita();
        ReceitaDAO despesadao = new ReceitaDAO();

        d.setTitulo(titulo);
        d.setValor(valor);
        d.setData(java.sql.Date.valueOf(data));
        d.setCode(code);
        d.setId_usuario(id_usuario);
        
        despesadao.Create(d);
    }
    public static void update(String titulo, double valor, String data, int code, int id_usuario, int id_despesa) throws ClassNotFoundException, SQLException{
        Receita d = new Receita();
        ReceitaDAO despesadao = new ReceitaDAO();
        
        d.setTitulo(titulo);
        d.setValor(valor);
        d.setData(java.sql.Date.valueOf(data));
        d.setCode(code);
        d.setId_usuario(id_usuario);
        d.setId_receita(id_despesa);
        despesadao.update(d);
        System.out.println("log no repositorio de criaçao");
    }
    public static void delete(int id_despesa) throws ClassNotFoundException, SQLException{
         Receita d = new Receita();
         ReceitaDAO despesadao = new ReceitaDAO();
         
         d.setId_receita(id_despesa);
         despesadao.delete(d);
    }
}
