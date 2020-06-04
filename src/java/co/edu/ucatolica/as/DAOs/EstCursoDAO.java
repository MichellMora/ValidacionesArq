/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.DAOs;

/**
 *
 * @author miche
 */
import co.edu.ucatolica.as.DTOs.Est_curso;
import java.sql.Connection;
import java.util.ArrayList;

public interface EstCursoDAO {
    
    public ArrayList<Est_curso> validacionesCur(Est_curso ec, Connection con);
    public ArrayList<Est_curso> validacionesProm(Est_curso ec, Connection con);
    
}
