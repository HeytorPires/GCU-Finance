/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.util.ArrayList;
import model.Categoria;
import java.util.List;

/**
 *
 * @author Laboratorio
 */
public class repositorioCategoria {
    
    public static List<Categoria> categorias = new ArrayList<>();
    
    public static void init() {
        categorias.add( new Categoria(03,"Mercado", "Compras de Mercado"));
      
    }
    
}
