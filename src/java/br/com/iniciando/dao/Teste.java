/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.dao;

import br.com.iniciando.dominio.Vacina;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Teste {
    
    public static void main(String[] args) {
      testbuscarVacina();
    }
    public static void testbuscarVacina(){
        Vacina v = new Vacina();
        VacinaDAO vDAO = new VacinaDAO();
        
        //List<Vacina> listaResultado = vDAO.buscarVacina();
        //for(Vacina vac: listaResultado){
          //  System.out.println("Id: "+vac.getId() + "\nNome: "+vac.getNome()+ "\nPeri: "+vac.getPeriodicidade() + "\nDoses: "+vac.getPeriodicidade());
        }
        
    }

