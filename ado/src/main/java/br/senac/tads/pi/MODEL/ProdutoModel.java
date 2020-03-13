package br.senac.tads.pi.MODEL;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author cruiser
 */
public class ProdutoModel {

    private int id;
    private String nome;
    private String desc;
    private double precoCompra;
    private double precoVenda;
    private int qtde;
    private boolean disponibilidade;
    private Timestamp dataCadastro;
    private ArrayList<Integer> categoria = new ArrayList<>();

    public ProdutoModel() {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ArrayList<Integer> getCategoria() {
        return categoria;
    }

    public void setCategoria(ArrayList<Integer> Categoria) {
        this.categoria = Categoria;
    }

    public ArrayList<Integer> getcategoria() {
        return categoria;
    }

    public void addCategoria(int categoria) {
        this.categoria.add(categoria);

    }

}
