/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */
public class Despesa {
    private String nome;
    private String tipo;
    private String Data;
    private float valor;

    public Despesa(String nome, String tipo, String Data, float valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.Data = Data;
        this.valor = valor;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Despesa{" + nome + " - " + tipo + " - " +  Data + " - " +  valor + " - " + '}';
    }
    
    
    
    
    
}
