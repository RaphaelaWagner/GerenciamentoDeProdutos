package br.senac.tads.pi.DAO;

import java.sql.*;
import br.senac.tads.pi.CONNECTION.ModuloConexao;
import br.senac.tads.pi.MODEL.ProdutoCategoriaModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cruiser
 */
public class ProdutoCategoriaDAO {

    private final Connection conn;

    public ProdutoCategoriaDAO() {
        conn = ModuloConexao.Conectar();
    }

    public void Inserir(ProdutoCategoriaModel produtoCategoria) throws SQLException {
        String sql = "INSERT INTO PRODUTO_CATEGORIA(ID,NOME) VALUES (?,?);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produtoCategoria.getIdProduto());
            stmt.setInt(2, produtoCategoria.getIdCategoria());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }

    public ArrayList<ProdutoCategoriaModel> Consultar() throws SQLException {
        String sql = "SELECT * FROM PRODUTO_CATEGORIA;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<ProdutoCategoriaModel> lista = new ArrayList();
            while (rs.next()) {
                ProdutoCategoriaModel produtoCategoria = new ProdutoCategoriaModel();
                produtoCategoria.setIdProduto(rs.getInt("ID"));
                produtoCategoria.setIdCategoria(rs.getInt("NOME"));
                lista.add(produtoCategoria);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar" + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }

    public void Alterar(ProdutoCategoriaModel produtoCategoria) throws SQLException {
        String sql = "UPDATE CATEGORIA SET NOME = ? WHERE ID = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produtoCategoria.getIdProduto());
            stmt.setInt(2, produtoCategoria.getIdCategoria());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }

    public void Excluir(ProdutoCategoriaModel produtoCategoria) throws SQLException {
        String sql = "DELETE FROM PRODUTO_CATEGORIA WHERE ID = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produtoCategoria.getIdProduto());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }
}
