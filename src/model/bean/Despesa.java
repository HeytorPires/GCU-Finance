/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;
import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Despesa {
    private int id;
    private String titulo;
    private String tipo;
    private Date data;
    private double valor;
    private int id_categoria;

    public Despesa(String titulo, String tipo, Date data, float valor) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

    public Despesa() {
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public String toString() {
        return "Despesa{" + "titulo=" + titulo + '}';
    }

    
    

    
  
    
    
    
}
