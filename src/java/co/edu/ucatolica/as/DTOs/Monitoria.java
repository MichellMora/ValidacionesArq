/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.DTOs;

/**
 *
 * @author miche
 */
public class Monitoria {
    
    String codCurso = null;
    String codMonitoria = null;
    String nomMonitoria = null;
    String nomMateria = null;

    public String getCodMonitoria() {
        return codMonitoria;
    }

    public void setCodMonitoria(String codMonitoria) {
        this.codMonitoria = codMonitoria;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getNomMonitoria() {
        return nomMonitoria;
    }

    public void setNomMonitoria(String nomMonitoria) {
        this.nomMonitoria = nomMonitoria;
    }

    public String getNomMateria() {
        return nomMateria;
    }

    public void setNomMateria(String nomMateria) {
        this.nomMateria = nomMateria;
    }
    
}
