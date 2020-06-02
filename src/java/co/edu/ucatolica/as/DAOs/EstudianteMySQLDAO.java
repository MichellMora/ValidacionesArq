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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EstudianteMySQLDAO {
    
    public ArrayList<Estudiante> monitoriaIng(Estudiante e, Connection con)
    {
        
        ArrayList<Estudiante> datos = new ArrayList();
        
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarEstudiante...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select identificacion, nombre_1,nombre_2, "
                    + " apellido_1, apellido_2, genero, telefono, email, "
                    + " fecha_nacimiento, tipo_persona"
                    + " from estudiante "
                    + " where "
                    + " identificacion='" + e.getIdentificacion()+"'");
            
            while (rs.next())
            { 
                Estudiante est = new Estudiante();
                est.setIdentificacion(rs.getString(1));
                est.setNombre1(rs.getString(2));
                est.setNombre2(rs.getString(3));
                est.setApellido1(rs.getString(4));
                est.setApellido2(rs.getString(5));
                est.setGenero(rs.getString(6));
                est.setTelef(rs.getString(7));
                est.setEmail(rs.getString(8));
                est.setfNacimiento(rs.getString(9));
                est.setTipoP(rs.getString(10));
                
                datos.add(est);
                
            }
            
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarEstudiante fin...{0}", datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
}
    

