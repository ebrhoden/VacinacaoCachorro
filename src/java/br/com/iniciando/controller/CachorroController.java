/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.controller;

import br.com.iniciando.dao.CachorroDAO;
import br.com.iniciando.dominio.Cachorro;
import br.com.iniciando.dominio.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
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
@WebServlet(name = "CachorroController", urlPatterns = {"/CachorroController"})
public class CachorroController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CachorroController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cachorro c = new Cachorro();
        String acao = request.getParameter("acao");
        CachorroDAO cDAO = new CachorroDAO();

        if (acao != null && acao.equals("lista")) {
            //Quero que o idUsuarioBuscaCachorro sejá o idUsuario que está salvo na tabela.
            Usuario usuAutenticado = (Usuario) request.getSession().getAttribute("usuAutenticado");
            String idUsu = String.valueOf(usuAutenticado.getId());
            int idUsuarioBuscaCachorro = Integer.parseInt(idUsu);
            List<Cachorro> listaCachorro = cDAO.buscarCachorro(c, (idUsuarioBuscaCachorro));
            request.setAttribute("listaCachorro", listaCachorro);
            RequestDispatcher saida = request.getRequestDispatcher("listaCachorro.jsp");
            saida.forward(request, response);

        } else if (acao != null && acao.equals("excluir")) {
            String id = request.getParameter("id");
            c.setId(Integer.parseInt(id));
            try {
                cDAO.delete(c);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("CachorroController?acao=lista");

        } else if (acao != null && acao.equals("alterar")) {
            String id = request.getParameter("id");
            System.out.println("No alterar cachorro, o id é: " + id);

            Cachorro cachorro = cDAO.buscarPorId(Integer.parseInt(id));
            request.setAttribute("cachorro", cachorro);
            request.getRequestDispatcher("alterarCachorro.jsp").forward(request, response);

        } else if (acao != null && acao.equals("cadastro")) {
            RequestDispatcher saida = request.getRequestDispatcher("NovoCachorro.jsp");
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
        String speso = request.getParameter("peso");
        String sdataNascimento = request.getParameter("dataNascimento");
        //String sidUsuario = request.getParameter("idUsuario"); NÃO FUNCIONA!!
        //O código abaixo é para pegar o idUsuario
        Usuario usuAutenticado = (Usuario) request.getSession().getAttribute("usuAutenticado");
        String idUsu = String.valueOf(usuAutenticado.getId());
        int idUsuarioCachorro = Integer.parseInt(idUsu);

        System.out.println("A dataNascimento é: " + sdataNascimento);
        System.out.println("O peso é: " + speso);

        try {

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date(format.parse(sdataNascimento).getTime());
            System.out.println("Salvando o cadastro, String sdataNascimento é: " + sdataNascimento);

//cria objeto com esses valores capturados
            Cachorro cachorro = new Cachorro();
            cachorro.setId(Integer.parseInt(sid));
            cachorro.setNome(snome);
            cachorro.setPeso(Double.parseDouble(speso));
            cachorro.setDataNascimento(new java.sql.Date(data.getTime()));
            cachorro.setIdUsuario((idUsuarioCachorro));

            CachorroDAO cDAO = new CachorroDAO();

            //salvando no banco de dados
            cDAO.update(cachorro);
            //PrintWriter out = response.getWriter();
            response.sendRedirect("CachorroController?acao=lista");
        } catch (ParseException e) {
            System.out.println("Erro de data KKKKKKKK - " + e.getMessage());
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
