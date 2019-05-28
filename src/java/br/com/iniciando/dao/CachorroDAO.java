/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.dao;

import br.com.iniciando.dominio.Cachorro;
import br.com.iniciando.dominio.Usuario;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Usuario
 */
public class CachorroDAO {

    public void create(Cachorro c) throws SQLException {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("INSERT INTO cachorro(nome,peso,dataNascimento,idUsuario)VALUES(?,?,?,?)");
        stmt.setString(1, c.getNome());
        stmt.setDouble(2, c.getPeso());
        stmt.setDate(3, c.getDataNascimento());
        stmt.setInt(4, c.getIdUsuario());

        stmt.executeUpdate();
        ConnectionFactory.closeConnection(conn, stmt);

    }

    public void update(Cachorro c) {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("Update cachorro set nome=?,peso=?,dataNascimento=? where id=?");
            stmt.setString(1, c.getNome());
            stmt.setDouble(2, c.getPeso());
            stmt.setDate(3, c.getDataNascimento());
            stmt.setInt(4, c.getId());

            System.out.println("ALTERADO com sucesso");
            stmt.executeUpdate();
            ConnectionFactory.closeConnection(conn, stmt);
        } catch (SQLException e) {
            System.out.println("Erro -" + e.getMessage());
        }

    }

    public void delete(Cachorro c) throws SQLException {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("Delete from cachorro where id=?");
        stmt.setInt(1, c.getId());

        stmt.executeUpdate();
        ConnectionFactory.closeConnection(conn, stmt);
    }

    public List<Cachorro> buscarCachorro(Cachorro cachorro, Integer idUsuario) {
        List<Cachorro> listaCachorro = new ArrayList<Cachorro>();
        String sql = "SELECT * FROM CACHORRO where idUsuario=?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet resultados = stmt.executeQuery();
            while (resultados.next()) {
                Cachorro c = new Cachorro();
                c.setId(resultados.getInt("id"));
                c.setNome(resultados.getString("nome"));
                c.setDataNascimento(resultados.getDate("dataNascimento"));
                c.setPeso(resultados.getDouble("peso"));
                c.setIdUsuario(resultados.getInt("idUsuario"));
                listaCachorro.add(c);
            }
    
        } catch (SQLException e) {
            System.out.println("Erro -" + e.getMessage());
        }
        return listaCachorro;
    }
    
    
    public Cachorro buscarPorId(Integer id) {
        Cachorro cachorroRetorno = null;
        String sql = "select * from cachorro where id=?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultados = stmt.executeQuery();

            if (resultados.next()) {
                cachorroRetorno = new Cachorro();
                cachorroRetorno.setId(resultados.getInt("id"));
                cachorroRetorno.setNome(resultados.getString("nome"));
                cachorroRetorno.setDataNascimento(resultados.getDate("dataNascimento"));
                cachorroRetorno.setPeso(resultados.getDouble("peso"));
                cachorroRetorno.setIdUsuario(resultados.getInt("idUsuario"));
            }
            System.out.println("Encontrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro no SQL: " + e.getMessage());
        }
        return cachorroRetorno;
    }

}
