/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.controller;

import br.com.iniciando.dao.CachorroDAO;
import br.com.iniciando.dao.UsuarioDAO;
import br.com.iniciando.dominio.Cachorro;
import br.com.iniciando.dominio.Usuario;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Usuario
 */

@Controller
public class IniciandoController {
    
    @RequestMapping("/usuarioSucesso")
    public String iniciando(Model model, Usuario u){
        System.out.println(u.getNome());
        System.out.println(u.getSenha());
        System.out.println("INFERNOOOOOOOO");
        UsuarioDAO dao = new UsuarioDAO();
        try{
            dao.create(u);
            
            model.addAttribute("retorno", u.getNome());
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return "formSucessoUsuario";
    }
    /* COLOCANDO O NOME DO USUÁRIO LA NO INDEX
    public String iniciando(Model model, @RequestParam("nome") String nome){
        model.addAttribute("retorno", nome);
        
        return "index";
    }
    
    */
    
    @RequestMapping("/cadastroCachorro")
    public String cadastroCachorro(){
        return "formNovoCachorro";
    }
    @RequestMapping("/cadastroVacina")
    public String cadastroVacina(){
        return "formNovaVacina";
    }
    @RequestMapping("/cadastroUsuario")
    public String cadastroUsuario(){
        return "formNovoUsuario";
    }
    @RequestMapping("/salvarUsuario")
    public String salvarUsuario(){
        return "salvarCadastro";
    }
    
}
