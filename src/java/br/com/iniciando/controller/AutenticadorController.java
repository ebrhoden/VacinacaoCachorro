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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet("/autenticador")
public class AutenticadorController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public AutenticadorController(){
        super();
    }
    


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession(false);
        if(sessao!=null){
            sessao.invalidate();
        }
        response.sendRedirect("login.jsp");
               
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String slogin = request.getParameter("login");
        String ssenha = request.getParameter("senha");
        
        Usuario usu = new Usuario();
        usu.setLogin(slogin);
        usu.setSenha(ssenha);
        
        UsuarioDAO uDAO = new UsuarioDAO();
        Usuario usuAutenticado = uDAO.autenticacao(usu);
        
        if (usuAutenticado != null){
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuAutenticado", usuAutenticado);
            
            request.getRequestDispatcher("home.jsp").forward(request, response);
            
        } else{
            response.sendRedirect("erroLogin.jsp");
        }
        
    }


}
