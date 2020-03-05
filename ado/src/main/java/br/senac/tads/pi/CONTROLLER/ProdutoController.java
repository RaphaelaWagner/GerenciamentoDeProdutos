/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi.CONTROLLER;

import java.util.ArrayList;
import br.senac.tads.pi.MODEL.*;
import br.senac.tads.pi.DAO.*;
import java.sql.SQLException;

/**
 *
 * @author Cruiser
 */
public class ProdutoController {
    ProdutoDAO daoProdutos = new ProdutoDAO();

    public void inserir( ProdutoModel produto) throws SQLException{
         this.daoProdutos.Inserir(produto);
    }
  public void  excluirProdutoController(ProdutoModel produto) throws SQLException{
         this.daoProdutos.Excluir(produto);
  }  
  public  void alterarProdutoController(ProdutoModel produto) throws SQLException{
        this.daoProdutos.Alterar(produto);
    }
}
//    private static ProdutoController INSTANCE;
//    private String erros;
//
//    public static ProdutoController getProdutoController() {
//        if (INSTANCE != null) {
//            return INSTANCE;
//        } else {
//            return INSTANCE = new ProdutoController();
//        }
//    }


