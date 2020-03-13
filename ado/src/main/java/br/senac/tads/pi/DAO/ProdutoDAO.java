package br.senac.tads.pi.DAO;

import java.sql.*;
import br.senac.tads.pi.CONNECTION.ModuloConexao;
import br.senac.tads.pi.MODEL.ProdutoModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import br.senac.tads.pi.MODEL.ProdutoCategoriaModel;
import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 *
 * @author cruiser
 */
public class ProdutoDAO {

    private ProdutoCategoriaModel pCategoria = new ProdutoCategoriaModel();

    //  private final Connection conn;
    public ProdutoDAO() {
        //   conn = ModuloConexao.Conectar();
    }

    public void Inserir(ProdutoModel produto) throws SQLException {
        Connection conn = ModuloConexao.Conectar();
        String sql = "INSERT INTO PRODUTO(NOME, DESCRICAO, PRECO_COMPRA,"
                + "PRECO_VENDA,QUANTIDADE,DISPONIVEL,DT_CADASTRO)"
                + "VALUES (?,?,?,?,?,?,?);";

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDesc());
            stmt.setDouble(3, produto.getPrecoCompra());
            stmt.setDouble(4, produto.getPrecoVenda());
            stmt.setInt(5, produto.getQtde());
            stmt.setBoolean(6, produto.getDisponibilidade());
            stmt.setTimestamp(7, produto.getDataCadastro());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            sql = "INSERT INTO PRODUTO_CATEGORIA(ID_PRODUTO, ID_CATEGORIA) VALUES(?,?);";

            try (PreparedStatement stm = conn.prepareStatement(sql)) {

                for (int i = 0; i < produto.getCategoria().size(); i++) {
                    stm.setInt(1, id);
                    stm.setInt(2, produto.getCategoria().get(i));
                    stm.executeUpdate();
                }
            }

            JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }

    public ArrayList<ProdutoModel> Consultar() {
        Connection conn = ModuloConexao.Conectar();
        String sql = "SELECT * FROM PRODUTO;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<ProdutoModel> lista = new ArrayList();
            while (rs.next()) {
                ProdutoModel produto = new ProdutoModel();
                produto.setId(rs.getInt("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setDesc(rs.getString("DESCRICAO"));
                produto.setPrecoCompra(rs.getDouble("PRECO_COMPRA"));
                produto.setPrecoVenda(rs.getDouble("PRECO_VENDA"));
                produto.setQtde(rs.getInt("QUANTIDADE"));
                produto.setDisponibilidade(rs.getBoolean("DISPONIVEL"));
                produto.setDataCadastro(rs.getTimestamp("DT_CADASTRO"));
                lista.add(produto);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar" + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }

    public void Alterar(ProdutoModel produto) throws SQLException {
        Connection conn = ModuloConexao.Conectar();
        String sql = "UPDATE PRODUTO SET NOME = ?, DESCRICAO = ?, PRECO_COMPRA = ?,"
                + "PRECO_VENDA = ?,QUANTIDADE = ?,DISPONIVEL = ? WHERE ID = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDesc());
            stmt.setDouble(3, produto.getPrecoCompra());
            stmt.setDouble(4, produto.getPrecoVenda());
            stmt.setInt(5, produto.getQtde());
            stmt.setBoolean(6, produto.getDisponibilidade());
            stmt.setInt(7, produto.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }

    public void Excluir(int id) throws SQLException {
        Connection conn = ModuloConexao.Conectar();
        String sql = "DELETE FROM PRODUTO WHERE ID = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }
}
