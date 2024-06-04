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
    private int id_despesa;
    private String titulo;
    private Date data;
    private double valor;
    private int id_usuario;
    private int code;

    public Despesa(int id_despesa, String titulo, Date data, double valor, int id_usuario, int code) {
        this.id_despesa = id_despesa;
        this.titulo = titulo;
        this.data = data;
        this.valor = valor;
        this.id_usuario = id_usuario;
        this.code = code;
    }

    public Despesa() {
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

    public int getId_despesa() {
        return id_despesa;
    }

    public void setId_despesa(int id_despesa) {
        this.id_despesa = id_despesa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    @Override
    public String toString() {
        return "Despesa{" + "titulo=" + titulo + '}';
    }
    
}
