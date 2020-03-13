package br.senac.tads.pi.MODEL;

import java.util.ArrayList;

/**
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
