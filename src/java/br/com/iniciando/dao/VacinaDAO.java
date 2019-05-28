/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.dao;


import br.com.iniciando.dominio.Vacina;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class VacinaDAO {
    public void create(Vacina v) throws SQLException{
    
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        
        stmt = conn.prepareStatement("INSERT INTO vacina(nome,periodicidade,numeroDoses,idUsuario)VALUES(?,?,?,?)");
        stmt.setString(1, v.getNome());
        stmt.setInt(2, v.getPeriodicidade());
        stmt.setInt(3, v.getNumeroDoses());
        stmt.setInt(4, v.getIdUsuario());
        
        stmt.executeUpdate();
        ConnectionFactory.closeConnection(conn, stmt);
        
     
    }
    
    public void update(Vacina v) throws SQLException{
    
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        
        stmt = conn.prepareStatement("Update vacina set nome=?,periodicidade=?, numeroDoses=?, idUsuario=? where id=?");
        stmt.setString(1, v.getNome());
        stmt.setInt(2, v.getPeriodicidade());
        stmt.setInt(3, v.getNumeroDoses());
        stmt.setInt(4, v.getIdUsuario());
        stmt.setInt(5, v.getId());
        
        System.out.println("ALTERADO com sucesso");
        stmt.executeUpdate();
        ConnectionFactory.closeConnection(conn, stmt);
            
    }
    
    public void delete(Vacina v) throws SQLException{
       
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;  
        
        stmt = conn.prepareStatement("Delete from vacina where id=?");
        stmt.setInt(1, v.getId());
        
        stmt.executeUpdate();
        ConnectionFactory.closeConnection(conn, stmt);
    }
    
    public List<Vacina> buscarVacina(Vacina vacina, Integer idUsuario) {
        List<Vacina> listaVacina = new ArrayList<Vacina>();
        String sql = "SELECT * FROM VACINA where idUsuario=?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet resultados = stmt.executeQuery();
            while (resultados.next()) {
                Vacina v = new Vacina();
                v.setId(resultados.getInt("id"));
                v.setNome(resultados.getString("nome"));
                v.setNumeroDoses(resultados.getInt("numeroDoses"));
                v.setPeriodicidade(resultados.getInt("periodicidade"));
                v.setIdUsuario(resultados.getInt("idUsuario"));
                listaVacina.add(v);
            }
    
        } catch (SQLException e) {
            System.out.println("Erro -" + e.getMessage());
        }
        return listaVacina;
    }
    
    public Vacina buscarPorId(Integer id) {
        Vacina vacinaRetorno = null;
        String sql = "select * from Vacina where id=?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultados = stmt.executeQuery();

            if (resultados.next()) {
                vacinaRetorno = new Vacina();
                vacinaRetorno.setId(resultados.getInt("id"));
                vacinaRetorno.setNome(resultados.getString("nome"));
                vacinaRetorno.setNumeroDoses(resultados.getInt("numeroDoses"));
                vacinaRetorno.setPeriodicidade(resultados.getInt("periodicidade"));
                vacinaRetorno.setIdUsuario(resultados.getInt("idUsuario"));
            }
            System.out.println("Encontrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro no SQL: " + e.getMessage());
        }
        return vacinaRetorno;
    }

}