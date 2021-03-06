/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.controller;

import br.com.iniciando.dao.CachorroDAO;
import br.com.iniciando.dao.HistoricoDAO;
import br.com.iniciando.dao.VacinaDAO;
import br.com.iniciando.dominio.Cachorro;
import br.com.iniciando.dominio.Historico;
import br.com.iniciando.dominio.Usuario;

import br.com.iniciando.dominio.Vacina;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Usuario
EXEMPLO DE CONTROLLER COM O MVC
@Controller
public class VacinaController {
    @RequestMapping("vacina/novaVacina")
    public String iniciando(Model model, Vacina v){
        VacinaDAO vDAO = new VacinaDAO();
        try{
            vDAO.create(v);
            
            model.addAttribute("nomeVacina", v.getNome());
            model.addAttribute("periodicidade", v.getPeriodicidade());
            model.addAttribute("numeroDoses", v.getNumeroDoses());
            model.addAttribute("listaVacina", vDAO.buscarVacinas());
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return "formNovaVacina";
    }
    
    @RequestMapping("vacina/listaVacinas")
    public String listaVacina(Model model){
        VacinaDAO vDAO = new VacinaDAO();
        
        try{
            model.addAttribute("listaVacina", vDAO.buscarVacinas());
        } catch (Exception e){}
        return "formSucessoVacina";
    }
    
    @RequestMapping(method=RequestMethod.GET, value = "vacinas/remover/{id}")
    public String delete(Vacina v, 
            @PathVariable("id") int id) throws SQLException{
       VacinaDAO vDAO = new VacinaDAO(); 
       v.setId(id);
       vDAO.delete(v);
        
        return "formSucessoVacina";
    }
}
*/
@WebServlet(name = "AgendamentoController", urlPatterns = {"/AgendamentoController"})
public class AgendamentoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AgendamentoController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        
        Historico h = new Historico();
        HistoricoDAO hDAO = new HistoricoDAO();
        
        Vacina v = new Vacina();
        VacinaDAO vDAO = new VacinaDAO();
        
        CachorroDAO cDAO = new CachorroDAO();
        
        if (acao != null && acao.equals("cadastro")) {
            Usuario usuAutenticado = (Usuario) request.getSession().getAttribute("usuAutenticado");
            String idUsu = String.valueOf(usuAutenticado.getId());
            int idUsuarioBuscaVacina = Integer.parseInt(idUsu);
            
            List<Vacina> listaVacina = vDAO.buscarVacina(v, idUsuarioBuscaVacina);
            request.setAttribute("listaVacina", listaVacina);
            
            String id = request.getParameter("id");
            System.out.println("To tentando colocar no request o objeto cachorro do o id é: " + id);

            Cachorro cachorro = cDAO.buscarPorId(Integer.parseInt(id));
            request.setAttribute("cachorro", cachorro);
            
            RequestDispatcher saida = request.getRequestDispatcher("selecionarVacina.jsp"); 
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
        String s = request.getParameter("selecionados");
        
        
        String sid = request.getParameter("id");
        String snome = request.getParameter("nome");
        String speriodicidade = request.getParameter("periodicidade");
        String snumeroDoses = request.getParameter("numeroDoses");
        //String sidUsuario = request.getParameter("idUsuario"); NÃO FUNCIONA!!
        //O código abaixo é para pegar o idUsuario
        Usuario usuAutenticado = (Usuario) request.getSession().getAttribute("usuAutenticado");
        String idUsu = String.valueOf(usuAutenticado.getId());
        int idUsuarioCachorro = Integer.parseInt(idUsu);
                        
//cria objeto com esses valores capturados
            Vacina vacina = new Vacina();
            vacina.setId(Integer.parseInt(sid));
            vacina.setNome(snome);
            vacina.setNumeroDoses(Integer.parseInt(snumeroDoses));
            vacina.setPeriodicidade(Integer.parseInt(speriodicidade));
            vacina.setIdUsuario(idUsuarioCachorro);

            VacinaDAO vDAO = new VacinaDAO();

        try {
            //salvando no banco de dados
            vDAO.update(vacina);
        } catch (SQLException ex) {
            Logger.getLogger(AgendamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
            //PrintWriter out = response.getWriter();
            response.sendRedirect("VacinaController?acao=lista");
        } 

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */




