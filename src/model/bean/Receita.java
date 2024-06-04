/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author heyto
 */
public class Receita {
    private int id_receita;
    private String titulo;
    private double valor;
    private int id_usuario;
    private Date data;
    private int code;

    public Receita(int id_receita, String titulo, double valor, int id_usuario, Date data, int code) {
        this.id_receita = id_receita;
        this.titulo = titulo;
        this.valor = valor;
        this.id_usuario = id_usuario;
        this.data = data;
        this.code = code;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Receita{" + "id_receita=" + id_receita + ", titulo=" + titulo + ", valor=" + valor + ", id_usuario=" + id_usuario + ", data=" + data + ", code=" + code + '}';
    }

    
}
