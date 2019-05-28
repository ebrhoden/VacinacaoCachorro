/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.controller;

import br.com.iniciando.dao.UsuarioDAO;
import br.com.iniciando.dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public UsuarioController(){
        super();
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario u = new Usuario();
        String acao = request.getParameter("acao");
        UsuarioDAO uDAO = new UsuarioDAO();
        
        if (acao!=null && acao.equals("lista")){
        List<Usuario> listaUsuario = uDAO.buscarUsuarios(u);
        request.setAttribute("listaUsuario", listaUsuario);
        RequestDispatcher saida = request.getRequestDispatcher("listaUsuario.jsp");
        saida.forward(request,response);
    
    }   else if(acao!=null && acao.equals("excluir")){
            String id = request.getParameter("id");
            u.setId(Integer.parseInt(id));
            try {
                uDAO.delete(u);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("UsuarioController?acao=lista");
    
    }   else if(acao!=null && acao.equals("alterar")){
        String id = request.getParameter("id");
        Usuario usuario = uDAO.buscarPorId(Integer.parseInt(id));
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("alterarCadastro.jsp").forward(request, response);
    
    }   
        else if(acao!=null && acao.equals("cadastro")){
        RequestDispatcher saida = request.getRequestDispatcher("NovoUsuario.jsp");
        saida.forward(request, response);
    } 
}
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //pega os parametros da tela
        String sid = request.getParameter("id");
        String snome = request.getParameter("nome");
        String slogin = request.getParameter("login");
        String ssenha = request.getParameter("senha");
        
        //cria objeto com esses valores capturados
        Usuario usuario = new Usuario();
        usuario.setId(Integer.parseInt(sid));
        usuario.setNome(snome);
        usuario.setLogin(slogin);
        usuario.setSenha(ssenha);
        
        UsuarioDAO usuDAO = new UsuarioDAO();
        
        //salvando no banco de dados
        usuDAO.update(usuario);
        PrintWriter out = response.getWriter();
        response.sendRedirect("UsuarioController?acao=lista");
        
  
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
}
