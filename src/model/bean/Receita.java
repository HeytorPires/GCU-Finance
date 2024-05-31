/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author heyto
 */
public class Receita {
    private int id_receita;
    private String titulo;
    private double valor;
    private int id_usuario;

    public Receita(int id_receita, String titulo, double valor, int id_usuario) {
        this.id_receita = id_receita;
        this.titulo = titulo;
        this.valor = valor;
        this.id_usuario = id_usuario;
    }

    public Receita() {
    }

    public int getId_receita() {
        return id_receita;
    }

    public void setId_receita(int id_receita) {
        this.id_receita = id_receita;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Receita{" + "id_despesa=" + id_receita + ", titulo=" + titulo + ", valor=" + valor + ", id_usuario=" + id_usuario + '}';
    }
    
    
}
