/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi.VIEW;

import br.senac.tads.pi.CONTROLLER.ProdutoController;
import br.senac.tads.pi.MODEL.ProdutoModel;
import br.senac.tads.pi.MODEL.ProdutoCategoriaModel;
import br.senac.tads.pi.DAO.ProdutoDAO;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cruiser
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form Gerenciamento_Produtos_View
     */
    private static ProdutoDAO produtoDao = new ProdutoDAO();

    public MainView() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
        setTitle("Gerenciador de Produtos");
        limpaCampos();
        carregarTabela();
    }

    //Limpar campos
    public void limpaCampos() {
        this.txtNome.setText("");
        this.txtDesc.setText("");
        this.txtPrecoCompra.setText("");
        this.txtPrecoVenda.setText("");
        this.txtQtde.setText("");
        this.btnGroupDisponibilidade.clearSelection();
        this.ckbCat1.setSelected(false);
        this.ckbCat2.setSelected(false);
        this.ckbCat3.setSelected(false);
        this.ckbCat4.setSelected(false);
        this.ckbCat5.setSelected(false);
    }

    //Carregar tabela de produtos automaticamente ao abrir software
    public void carregarTabela() {

        ArrayList<String[]> linhasRegistro = ProdutoController.consultar();

        DefaultTableModel tmProdutos = new DefaultTableModel();

        tmProdutos.addColumn("COD");
        tmProdutos.addColumn("Nome");
        tmProdutos.addColumn("Descrição");
        tmProdutos.addColumn("Preço de Compra");
        tmProdutos.addColumn("Preço de Venda");
        tmProdutos.addColumn("QTD");
        tmProdutos.addColumn("Disponibilidade");
        tmProdutos.addColumn("Data de Cadastro");

        tblDados.setModel(tmProdutos);

        for (String[] c : linhasRegistro) {
            tmProdutos.addRow(c);
        }

    }

    public boolean validarFormulario() {
        if (txtNome.getText().isEmpty()
                && txtDesc.getText().isEmpty()
                && txtPrecoCompra.getText().isEmpty()
                && txtPrecoVenda.getText().isEmpty()
                && txtQtde.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Obrigatorios não preenchidos");
            return false;
        } else {
            return true;
        }
    }

    private ProdutoCategoriaModel inserirCategorias(ProdutoCategoriaModel p) {

        ProdutoCategoriaModel prodCategorias = new ProdutoCategoriaModel();

        return prodCategorias;

    }

    private ProdutoModel inserirDados(ProdutoModel produto) {

        if (validarFormulario()) {
            produto.setNome(txtNome.getText());
            produto.setDesc(txtDesc.getText());
            produto.setPrecoCompra(Double.parseDouble(txtPrecoCompra.getText()));
            produto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
            produto.setQtde(Integer.parseInt(txtQtde.getText()));

            boolean botao = true;
            if (rbdNao.isSelected()) {
                botao = false;
            }
            produto.setDisponibilidade(botao);

            Timestamp data = new Timestamp(System.currentTimeMillis());
            produto.setDataCadastro(data);

            if (ckbCat1.isSelected()) {
                produto.addCategoria(1);
            }

            if (ckbCat2.isSelected()) {
                produto.addCategoria(2);
            }

            if (ckbCat3.isSelected()) {
                produto.addCategoria(3);
            }

            if (ckbCat4.isSelected()) {
                produto.addCategoria(4);
            }

            if (ckbCat5.isSelected()) {
                produto.addCategoria(5);
            }

            return produto;
        } else {
            return null;
        }
    }

    private ProdutoModel alterarDados(ProdutoModel produto) {

        if (validarFormulario()) {
            produto.setNome(txtNome.getText());
            produto.setDesc(txtDesc.getText());
            produto.setPrecoCompra(Double.parseDouble(txtPrecoCompra.getText()));
            produto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
            produto.setQtde(Integer.parseInt(txtQtde.getText()));
            boolean botao = true;
            if (rbdSim.isSelected()) {
                botao = true;
            }
            if (rbdNao.isSelected()) {
                botao = false;
            }

            produto.setDisponibilidade(botao);
            produto.setId(Integer.parseInt(lblID.getText()));

            return produto;
        } else {
            return null;
        }
    }

    private ProdutoModel excluirDados(ProdutoModel produto) {

        String str = lblID.toString();
        int ID = Integer.parseInt(str);
        produto.setId(ID);
        return produto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupDisponibilidade = new javax.swing.ButtonGroup();
        btnGroupCategoria = new javax.swing.ButtonGroup();
        pnlBackground = new javax.swing.JPanel();
        pnlDados = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblPrecoCompra = new javax.swing.JLabel();
        lblQtde = new javax.swing.JLabel();
        lblPrecoVenda = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();
        lblDisponibilidade = new javax.swing.JLabel();
        rbdSim = new javax.swing.JRadioButton();
        rbdNao = new javax.swing.JRadioButton();
        ckbCat1 = new javax.swing.JCheckBox();
        ckbCat2 = new javax.swing.JCheckBox();
        ckbCat3 = new javax.swing.JCheckBox();
        ckbCat4 = new javax.swing.JCheckBox();
        ckbCat5 = new javax.swing.JCheckBox();
        lblCategoria = new javax.swing.JLabel();
        txtPrecoCompra = new javax.swing.JTextField();
        txtPrecoVenda = new javax.swing.JTextField();
        txtQtde = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Produtos");

        pnlBackground.setBackground(new java.awt.Color(50, 39, 58));

        pnlDados.setBackground(new java.awt.Color(50, 39, 58));
        pnlDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlDados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblNome.setFont(new java.awt.Font("Kalinga", 1, 12)); // NOI18N
        lblNome.setForeground(new java.awt.Color(240, 240, 240));
        lblNome.setText("Nome do produto:");
        lblNome.setAlignmentX(0.5F);

        lblPrecoCompra.setFont(new java.awt.Font("Kalinga", 1, 12)); // NOI18N
        lblPrecoCompra.setForeground(new java.awt.Color(240, 240, 240));
        lblPrecoCompra.setText("Preço de Compra:");
        lblPrecoCompra.setAlignmentX(0.5F);

        lblQtde.setFont(new java.awt.Font("Kalinga", 1, 12)); // NOI18N
        lblQtde.setForeground(new java.awt.Color(240, 240, 240));
        lblQtde.setText("Quantidade:");
        lblQtde.setAlignmentX(0.5F);

        lblPrecoVenda.setFont(new java.awt.Font("Kalinga", 1, 12)); // NOI18N
        lblPrecoVenda.setForeground(new java.awt.Color(240, 240, 240));
        lblPrecoVenda.setText("Preço de Venda:");
        lblPrecoVenda.setAlignmentX(0.5F);

        txtNome.setToolTipText("Nome do produto");
        txtNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtDesc.setToolTipText("Descrição detalhada do produto");
        txtDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblDesc.setFont(new java.awt.Font("Kalinga", 1, 12)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(240, 240, 240));
        lblDesc.setText("Descrição do produto:");
        lblDesc.setAlignmentX(0.5F);

        lblDisponibilidade.setFont(new java.awt.Font("Kalinga", 1, 12)); // NOI18N
        lblDisponibilidade.setForeground(new java.awt.Color(240, 240, 240));
        lblDisponibilidade.setText("Disponibilidade:");
        lblDisponibilidade.setAlignmentX(0.5F);

        btnGroupDisponibilidade.add(rbdSim);
        rbdSim.setForeground(new java.awt.Color(255, 255, 255));
        rbdSim.setSelected(true);
        rbdSim.setText("SIM");
        rbdSim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbdSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbdSimActionPerformed(evt);
            }
        });

        btnGroupDisponibilidade.add(rbdNao);
        rbdNao.setForeground(new java.awt.Color(255, 255, 255));
        rbdNao.setText("NÃO");
        rbdNao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbdNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbdNaoActionPerformed(evt);
            }
        });

        ckbCat1.setForeground(new java.awt.Color(255, 255, 255));
        ckbCat1.setText("1");
        ckbCat1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ckbCat2.setForeground(new java.awt.Color(255, 255, 255));
        ckbCat2.setText("2");
        ckbCat2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ckbCat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbCat2ActionPerformed(evt);
            }
        });

        ckbCat3.setForeground(new java.awt.Color(255, 255, 255));
        ckbCat3.setText("3");
        ckbCat3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ckbCat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbCat3ActionPerformed(evt);
            }
        });

        ckbCat4.setForeground(new java.awt.Color(255, 255, 255));
        ckbCat4.setText("4");
        ckbCat4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ckbCat5.setForeground(new java.awt.Color(255, 255, 255));
        ckbCat5.setText("5");
        ckbCat5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblCategoria.setFont(new java.awt.Font("Kalinga", 1, 12)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(240, 240, 240));
        lblCategoria.setText("Categoria:");
        lblCategoria.setAlignmentX(0.5F);

        txtPrecoCompra.setToolTipText("Descrição detalhada do produto");
        txtPrecoCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtPrecoVenda.setToolTipText("Descrição detalhada do produto");
        txtPrecoVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtQtde.setToolTipText("Descrição detalhada do produto");
        txtQtde.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblID.setFont(new java.awt.Font("Kalinga", 1, 12)); // NOI18N
        lblID.setForeground(new java.awt.Color(240, 240, 240));
        lblID.setAlignmentX(0.5F);

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblDesc)
                    .addComponent(lblPrecoCompra)
                    .addComponent(lblPrecoVenda)
                    .addComponent(lblQtde)
                    .addComponent(lblDisponibilidade))
                .addGap(20, 20, 20)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(rbdSim)
                        .addGap(18, 18, 18)
                        .addComponent(rbdNao)
                        .addGap(52, 52, 52)
                        .addComponent(lblID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCategoria)
                        .addGap(18, 18, 18)
                        .addComponent(ckbCat1)
                        .addGap(18, 18, 18)
                        .addComponent(ckbCat2)
                        .addGap(18, 18, 18)
                        .addComponent(ckbCat3)
                        .addGap(18, 18, 18)
                        .addComponent(ckbCat4)
                        .addGap(15, 15, 15)
                        .addComponent(ckbCat5))
                    .addComponent(txtDesc)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(txtPrecoCompra)
                    .addComponent(txtPrecoVenda)
                    .addComponent(txtQtde))
                .addGap(20, 20, 20))
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecoVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQtde, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisponibilidade, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(rbdSim)
                    .addComponent(rbdNao)
                    .addComponent(ckbCat1)
                    .addComponent(ckbCat2)
                    .addComponent(ckbCat3)
                    .addComponent(ckbCat4)
                    .addComponent(ckbCat5)
                    .addComponent(lblCategoria)
                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        btnNovo.setBackground(new java.awt.Color(255, 255, 255));
        btnNovo.setFont(new java.awt.Font("Kalinga", 1, 11)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(102, 0, 102));
        btnNovo.setText("Novo");
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNovoMouseClicked(evt);
            }
        });
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterar.setFont(new java.awt.Font("Kalinga", 1, 11)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(102, 0, 102));
        btnAlterar.setText("Alterar");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Kalinga", 1, 11)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(102, 0, 102));
        btnExcluir.setText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tblDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDados);

        pnlTitle.setBackground(new java.awt.Color(102, 0, 102));

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Kalinga", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Gerenciamento de Estoque");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(pnlDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnNovo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        try {
            ProdutoModel produto = inserirDados(new ProdutoModel());
            produtoDao.Inserir(produto);
            carregarTabela();
            limpaCampos();

        } catch (SQLException ex) {
            carregarTabela();
            limpaCampos();
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            ProdutoModel produto = alterarDados(new ProdutoModel());
            produtoDao.Alterar(produto);
            carregarTabela();
            limpaCampos();

        } catch (SQLException ex) {
            carregarTabela();
            limpaCampos();
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblDados.getRowCount() > 0) {

            int numeroLinha = tblDados.getSelectedRow();
            //Resgata o Id (oculto) do produto pelo JTableModel
            int IDproduto = Integer.parseInt(tblDados.getModel().getValueAt(numeroLinha, 0).toString());
            try {
                ProdutoModel p = (new ProdutoModel());

                produtoDao.Excluir(IDproduto);
                carregarTabela();
                limpaCampos();

            } catch (SQLException ex) {
                carregarTabela();
                limpaCampos();
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item na tabela para excluir: ");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void ckbCat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbCat2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbCat2ActionPerformed

    private void ckbCat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbCat3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbCat3ActionPerformed

    private void tblDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadosMouseClicked
        // evento de clicar na linha da tabela
        // e as informações ocuparem txtForm

        int linha = tblDados.getSelectedRow();
        lblID.setText(tblDados.getValueAt(linha, 0).toString());
        txtNome.setText(tblDados.getValueAt(linha, 1).toString());
        txtDesc.setText(tblDados.getValueAt(linha, 2).toString());
        txtPrecoCompra.setText(tblDados.getValueAt(linha, 3).toString());
        txtPrecoVenda.setText(tblDados.getValueAt(linha, 4).toString());
        txtQtde.setText(tblDados.getValueAt(linha, 5).toString());
        lblID.setVisible(false);

        if (tblDados.getValueAt(linha, 6).toString().equals("true")) {
            rbdSim.setSelected(true);
        } else {
            rbdNao.setSelected(true);
        }

    }//GEN-LAST:event_tblDadosMouseClicked

    private void rbdSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbdSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbdSimActionPerformed

    private void rbdNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbdNaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbdNaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.ButtonGroup btnGroupCategoria;
    private javax.swing.ButtonGroup btnGroupDisponibilidade;
    private javax.swing.JButton btnNovo;
    private javax.swing.JCheckBox ckbCat1;
    private javax.swing.JCheckBox ckbCat2;
    private javax.swing.JCheckBox ckbCat3;
    private javax.swing.JCheckBox ckbCat4;
    private javax.swing.JCheckBox ckbCat5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDisponibilidade;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPrecoCompra;
    private javax.swing.JLabel lblPrecoVenda;
    private javax.swing.JLabel lblQtde;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JRadioButton rbdNao;
    private javax.swing.JRadioButton rbdSim;
    private javax.swing.JTable tblDados;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPrecoCompra;
    private javax.swing.JTextField txtPrecoVenda;
    private javax.swing.JTextField txtQtde;
    // End of variables declaration//GEN-END:variables
}
