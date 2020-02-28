/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi.MODEL;

/**
 *
 * @author maria.imbeserra
 */
public class CategoriaModel {

    private int id;
    private String nome;

    public CategoriaModel() {
    }

    public CategoriaModel(String nome) {
        this.nome = nome;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
