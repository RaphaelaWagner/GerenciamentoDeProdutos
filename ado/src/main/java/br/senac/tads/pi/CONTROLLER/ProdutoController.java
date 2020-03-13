/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi.CONTROLLER;

import java.util.ArrayList;
import br.senac.tads.pi.MODEL.ProdutoModel;
import br.senac.tads.pi.DAO.ProdutoDAO;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Cruiser
 */
public class ProdutoController {

    static ProdutoDAO daoProdutos = new ProdutoDAO();

    public static ArrayList<String[]> consultar() {

        // ProdutoDAO _produto = new ProdutoDAO();
        ArrayList<ProdutoModel> produtos = daoProdutos.Consultar();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getId()),
                produtos.get(i).getNome(),
                produtos.get(i).getDesc(),
                String.valueOf(produtos.get(i).getPrecoCompra()),
                String.valueOf(produtos.get(i).getPrecoVenda()),
                String.valueOf(produtos.get(i).getQtde()),
                String.valueOf(produtos.get(i).getDisponibilidade()),
                String.valueOf(produtos.get(i).getDataCadastro())});

        }
        return listaProdutos;

    }
}
