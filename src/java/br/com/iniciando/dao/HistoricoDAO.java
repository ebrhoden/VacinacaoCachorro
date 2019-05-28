/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.dao;

import br.com.iniciando.dominio.Historico;
import br.com.iniciando.dominio.Vacina;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class HistoricoDAO {

    public void create(Historico h) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;       
        stmt = conn.prepareStatement("INSERT INTO historico(IdCachorro,IdVacina,dataVacina,idUsuario)VALUES(?,?,?,?)");
        stmt.setInt(1, h.getIdCachorro());
        stmt.setInt(2, h.getIdVacina());
        stmt.setDate(3, h.getDataVacina());
        stmt.setInt(4, h.getIdUsuario());

        stmt.executeUpdate();
        ConnectionFactory.closeConnection(conn, stmt);


    }
    
    public void update(Historico h) throws SQLException{
    
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        
        stmt = conn.prepareStatement("Update historico set dataVacina=? where id=?");
        stmt.setDate(1, h.getDataVacina());
        stmt.setInt(2, h.getId());
        
        System.out.println("ALTERADO com sucesso");
        stmt.executeUpdate();
        ConnectionFactory.closeConnection(conn, stmt);
            
    }
    
    public void delete(Historico h) throws SQLException{
       
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;  
        
        stmt = conn.prepareStatement("Delete from vacina where id=?");
        stmt.setInt(1, h.getId());
        
        stmt.executeUpdate();
        ConnectionFactory.closeConnection(conn, stmt);
    }
    
    public List<Historico> buscarHistorico(Historico historico, Integer idUsuario) {
        List<Historico> listaHistorico = new ArrayList<Historico>();
        String sql = "SELECT * FROM Historico where idUsuario=?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet resultados = stmt.executeQuery();
            while (resultados.next()) {
                Historico h = new Historico();
                h.setId(resultados.getInt("id"));
                h.setIdCachorro(resultados.getInt("idCachorro"));
                h.setIdVacina(resultados.getInt("idVacina"));
                h.setDataVacina(resultados.getDate("dataVacina"));
                h.setIdUsuario(resultados.getInt("idUsuario"));
                listaHistorico.add(h);
            }
    
        } catch (SQLException e) {
            System.out.println("Erro -" + e.getMessage());
        }
        return listaHistorico;
    }
    
    public Historico buscarPorId(Integer id) {
        Historico historicoRetorno = null;
        String sql = "select * from Historico where id=?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultados = stmt.executeQuery();

            if (resultados.next()) {
                historicoRetorno = new Historico();
                historicoRetorno.setId(resultados.getInt("id"));
                historicoRetorno.setIdCachorro(resultados.getInt("idCachorro"));
                historicoRetorno.setIdVacina(resultados.getInt("idVacina"));
                historicoRetorno.setDataVacina(resultados.getDate("dataVacina"));
                historicoRetorno.setIdUsuario(resultados.getInt("idUsuario"));
            }
            System.out.println("Encontrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro no SQL: " + e.getMessage());
        }
        return historicoRetorno;
    }

    public List<Historico> buscarDadosHistorico(Integer idUsuario, Integer idCachorro) {
        List<Historico> listaHistorico = new ArrayList<Historico>();
        String sql = "SELECT hist.dataVacina, vac.nome FROM Historico hist INNER JOIN Vacina vac on vac.Id = p.idCachorro where idUsuario=?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet resultados = stmt.executeQuery();
            while (resultados.next()) {
                Historico h = new Historico();
                h.setId(resultados.getInt("id"));
                h.setIdCachorro(resultados.getInt("idCachorro"));
                h.setIdVacina(resultados.getInt("idVacina"));
                h.setDataVacina(resultados.getDate("dataVacina"));
                h.setIdUsuario(resultados.getInt("idUsuario"));
                listaHistorico.add(h);
            }
    
        } catch (SQLException e) {
            System.out.println("Erro -" + e.getMessage());
        }
        return listaHistorico;
    }
    
}

    