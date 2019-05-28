/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.dominio;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Historico {
    private int id;
    private int idCachorro;
    private int idVacina;
    private Date dataVacina;

    public int getId() {
        return id;
    }

    public void setIdHistorico(int idHistorico) {
        this.id = idHistorico;
    }

    public int getIdCachorro() {
        return idCachorro;
    }

    public void setIdCachorro(int idCachorro) {
        this.idCachorro = idCachorro;
    }

    public int getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }

    public Date getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(Date dataVacina) {
        this.dataVacina = dataVacina;
    }
    
    
    
}
