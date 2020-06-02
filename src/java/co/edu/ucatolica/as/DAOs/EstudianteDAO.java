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

import co.edu.ucatolica.as.DTOs.Estudiante;
import java.sql.Connection;
import java.util.ArrayList;

public interface EstudianteDAO {
    
    public ArrayList<Estudiante> monitoriaIng(Estudiante e, Connection con);
}
