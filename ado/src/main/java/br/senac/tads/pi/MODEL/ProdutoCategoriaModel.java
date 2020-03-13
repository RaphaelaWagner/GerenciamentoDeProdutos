package br.senac.tads.pi.MODEL;

/**
 *
 * @author cruiser
 */
public class ProdutoCategoriaModel {

    private int idProduto;
    private int idCategoria;

    public ProdutoCategoriaModel() {
    }
    
    public ProdutoCategoriaModel(int idProduto) {
        this.idProduto = idProduto;
    }

    public ProdutoCategoriaModel(int idProduto, int idCategoria) {
        this.idProduto = idProduto;
        this.idCategoria = idCategoria;
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
