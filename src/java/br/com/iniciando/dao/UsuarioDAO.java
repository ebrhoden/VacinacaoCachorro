package br.com.iniciando.dao;

import br.com.iniciando.dominio.Usuario;
import br.com.iniciando.dominio.Vacina;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {
    
    public void create(Usuario u) throws SQLException{
    
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        
        stmt = conn.prepareStatement("INSERT INTO usuario(nome,login,senha)VALUES(?,?,?)");
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getLogin());
        stmt.setString(3, u.getSenha());
        
        stmt.executeUpdate();
        ConnectionFactory.closeConnection(conn, stmt);
            
    }
    
    public void update(Usuario u){
    
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        
        try {
            stmt = conn.prepareStatement("Update usuario set nome=?,login=?,senha=? where id=?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setInt(4, u.getId());
        
            System.out.println("ALTERADO com sucesso");
            stmt.executeUpdate();
            ConnectionFactory.closeConnection(conn, stmt);
        } catch(SQLException e){
            System.out.println("Erro -"+e.getMessage());
        }
        
            
    }
    
    public void delete(Usuario u) throws SQLException{
       
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;  
        
        stmt = conn.prepareStatement("Delete from usuario where id=?");
        stmt.setInt(1, u.getId());
        
        stmt.executeUpdate();
        ConnectionFactory.closeConnection(conn, stmt);
    }
    
   public List<Usuario> buscarUsuarios (Usuario usuario){
        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        String sql = "SELECT * FROM USUARIO";
        
        try{
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt=null;
            stmt = conn.prepareStatement(sql);
            ResultSet resultados = stmt.executeQuery();
            while(resultados.next()){
                Usuario u = new Usuario();
                u.setId(resultados.getInt("id"));
                u.setLogin(resultados.getString("login"));
                u.setNome(resultados.getString("nome"));
                u.setSenha(resultados.getString("senha"));
                listaUsuario.add(u);
            }
            
        } catch(SQLException e){
            System.out.println("Erro -"+e.getMessage());
        }
        return listaUsuario;
    }
   
   public Usuario buscarPorId(Integer id){
       Usuario usuRetorno = null;
       String sql = "select * from usuario where id=?";
       try{
           Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt=null;  
        
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                usuRetorno = new Usuario();
                usuRetorno.setId(resultado.getInt("id"));
                usuRetorno.setLogin(resultado.getString("login"));
                usuRetorno.setNome(resultado.getString("nome"));
                usuRetorno.setSenha(resultado.getString("senha"));
            }
            System.out.println("Encontrado com sucesso!");
       } catch(SQLException e ){
           System.out.println("Erro no SQL: "+e.getMessage());
       }
       return usuRetorno;
   }
   
   public Usuario autenticacao(Usuario usuario){
       Usuario usuRetorno = null;
       String sql = "select * from usuario where login=? and senha=?";
       try{
           Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt=null;  
        
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                usuRetorno = new Usuario();
                usuRetorno.setId(resultado.getInt("id"));
                usuRetorno.setLogin(resultado.getString("login"));
                usuRetorno.setNome(resultado.getString("nome"));
                usuRetorno.setSenha(resultado.getString("senha"));
                System.out.println("ACHOU!!!!!");
                System.out.println(usuRetorno);
            }
       } catch(SQLException e ){
           System.out.println("Erro no SQL: "+e.getMessage());
       }
       return usuRetorno;
   }
    
}
