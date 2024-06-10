/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author Fabiano
 */
public class CategoriaDespesa {
    private int id_categoria_despesa;
    private String nome;
    private String descricao; 
    private int code;
    private int id_usuario;

    public CategoriaDespesa(int id_categoria_despesa, String nome, String descricao, int code, int id_usuario) {
        this.id_categoria_despesa = id_categoria_despesa;
        this.nome = nome;
        this.descricao = descricao;
        this.code = code;
        this.id_usuario = id_usuario;
    }
    
    public CategoriaDespesa() {
    }

    public int getId_categoria_despesa() {
        return id_categoria_despesa;
    }

    public void setId_categoria_despesa(int id_categoria_despesa) {
        this.id_categoria_despesa = id_categoria_despesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return  nome + "-" + code ;
    }

    

    
    
    
    

}
