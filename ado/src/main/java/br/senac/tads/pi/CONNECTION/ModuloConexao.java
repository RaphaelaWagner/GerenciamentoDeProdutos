package br.senac.tads.pi.CONNECTION;

import java.sql.*;
import javax.swing.JOptionPane;

/*
 @see Conectar() - gera conexão ao banco de dados bd_loja_informatica
 @see CloseConnection() - para a conexão e fecha os comandos de suporte ao sql...

 */
public class ModuloConexao {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String LOGIN = "root";
    private static String SENHA = "";
    private static String URL = "jdbc:mysql://localhost:3306/PRODUTOBD?useTimezone=true&serverTimezone=UTC&useSSL=false";

    public static Connection Conectar() {
        java.sql.Connection conexao = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            return conexao;
        } catch (Exception ErrorSQL) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao Banco de Dados" + ErrorSQL);
            return null;
        }

    }

    public static void CloseConnection(Connection conn) {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ErrorSQL) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao Banco de Dados" + ErrorSQL);
        }

    }

    public static void CloseConnection(Connection conn, PreparedStatement ST) {
        CloseConnection(conn);
        try {
            if (ST != null) {
                ST.close();
            }
        } catch (SQLException ErrorSQL) {
            throw new RuntimeException("Erro! Não foi possível fechar o PreparedStatement: " + ErrorSQL);
        }

    }

    public static void CloseConnection(Connection conn, PreparedStatement ST, ResultSet RS) {
        CloseConnection(conn, ST);
        try {
            if (RS != null) {
                RS.close();
            }
        } catch (SQLException ErrorSQL) {
            throw new RuntimeException("Erro! Não foi possível fechar o ResustSet: " + ErrorSQL);
        }

    }

}
