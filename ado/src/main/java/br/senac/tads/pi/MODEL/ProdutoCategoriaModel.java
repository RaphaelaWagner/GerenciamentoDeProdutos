package br.senac.tads.pi.MODEL;

import java.util.ArrayList;

/**
 * CLASSE NÃO ESTÁ SENDO USADA
 *
 * @author cruiser
 */
public class ProdutoCategoriaModel {

    private int idProduto;
    private int idCategoria;
    private ArrayList<Integer> Categoria = new ArrayList<>();

    public ProdutoCategoriaModel() {
    }

    public ProdutoCategoriaModel(int idProduto) {
        this.idProduto = idProduto;
    }

    public ArrayList<Integer> getCategoria() {
        return Categoria;
    }

    public void setCategoria(ArrayList<Integer> Categoria) {
        this.Categoria = Categoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

}
