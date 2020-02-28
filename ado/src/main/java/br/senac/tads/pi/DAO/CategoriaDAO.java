package br.senac.tads.pi.DAO;

import java.sql.*;
import br.senac.tads.pi.CONNECTION.ModuloConexao;
import br.senac.tads.pi.MODEL.CategoriaModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cruiser
 */
public class CategoriaDAO {

    private final Connection conn;

    public CategoriaDAO() {
        conn = ModuloConexao.Conectar();
    }

    public void Inserir(CategoriaModel categoria) throws SQLException {
        String sql = "INSERT INTO CATEGORIA(NOME) VALUES (?);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionada com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }

    public ArrayList<CategoriaModel> Consultar() throws SQLException {
        String sql = "SELECT * FROM CATEGORIA;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<CategoriaModel> lista = new ArrayList();
            while (rs.next()) {
                CategoriaModel categoria = new CategoriaModel();
                categoria.setId(rs.getInt("ID"));
                categoria.setNome(rs.getString("NOME"));
                lista.add(categoria);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar" + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }

    public void Alterar(CategoriaModel categoria) throws SQLException {
        String sql = "UPDATE CATEGORIA SET NOME = ? WHERE ID = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }

    public void Excluir(CategoriaModel categoria) throws SQLException {
        String sql = "DELETE FROM CATEGORIA WHERE ID = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, categoria.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluida com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ModuloConexao.CloseConnection(conn);
        }
    }
}
