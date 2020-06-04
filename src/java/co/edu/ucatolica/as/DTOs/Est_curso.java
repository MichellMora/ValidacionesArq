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
public class Est_curso {
    
    int id =0;
    String codEstudiante = null;
    String codCurso = null;
    float notaCurso = (float) 3.8;
    float notaCursoN = (float) 3.9;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(String codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public float getNotaCurso() {
        return notaCurso;
    }

    public void setNotaCurso(float notaCurso) {
        this.notaCurso = notaCurso;
    }
    
}
