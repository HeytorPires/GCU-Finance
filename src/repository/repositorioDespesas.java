/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import model.Despesa;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Laboratorio
 */
public class repositorioDespesas {
    public static List<Despesa> despesas = new ArrayList<>();
    
    public static void init() {
        despesas.add( new Despesa("Mensalidade", "Estudos","07-06-2024",659));
      
    }
}

 //public Despesa(String nome, String tipo, String Data, float valor) {
   //     this.nome = nome;
    //    this.tipo = tipo;
      //  this.Data = Data;
        //this.valor = valor;
   // }