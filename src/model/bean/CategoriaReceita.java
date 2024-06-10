/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author Fabiano
 */
public class CategoriaReceita {
    private int id_categoria_receita;
    private String nome;
    private String descricao; 
    private int code;
    private int id_usuario;

    public CategoriaReceita(int id_categoria_receita, String nome, String descricao, int code, int id_usuario) {
        this.id_categoria_receita = id_categoria_receita;
        this.nome = nome;
        this.descricao = descricao;
        this.code = code;
        this.id_usuario = id_usuario;
    }
    
    public CategoriaReceita() {
    }

    public int getId_categoria_receita() {
        return id_categoria_receita;
    }

    public void setId_categoria_receita(int id_categoria_receita) {
        this.id_categoria_receita = id_categoria_receita;
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
