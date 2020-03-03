/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi.TABLEMODEL;

import br.senac.tads.pi.MODEL.ProdutoModel;
import br.senac.tads.pi.DAO.ProdutoDAO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cruiser
 */
public class ProdutoTableModel {

    ArrayList<ProdutoModel> lista = new ArrayList<>();

    String[] colunas = {"Id", "Nome", "Descrição", "Preço de Compra",
        "Preço de Venda", "Quantidade", "Disponibilidade", "Data de cadastro"};

    public ProdutoTableModel() {

    }

    public String getColumnName(int column) {
        return colunas[column];

    }

    public int getRowCount() {

        return lista.size();

    }

    public int getColumnCount() {

        return colunas.length;
    }

    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {

            case 0:
                return lista.get(linha).getId();
            case 1:
                return lista.get(linha).getDesc();
            case 2:
                return lista.get(linha).getPrecoCompra();
            case 3:
                return lista.get(linha).getPrecoVenda();
            case 4:
                return lista.get(linha).getQtde();
            case 5:
                return lista.get(linha).getDisponibilidade();
            case 6:
                return lista.get(linha).getDataCadastro();
        }
        return null;
    }

    public void addLinha(ProdutoModel Produto) {
    }
}
