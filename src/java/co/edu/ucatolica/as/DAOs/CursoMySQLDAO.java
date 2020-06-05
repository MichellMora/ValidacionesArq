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

import co.edu.ucatolica.as.DTOs.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CursoMySQLDAO {
    
    public ArrayList<Curso> monitoriaCur(Curso c, Connection con)
            
    {
        
        ArrayList<Curso> datosC = new ArrayList();
        
        Logger.getLogger(CursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso...");
        
        /*String codCurso = null;
        String nomCurso = null;
        String credCurso = null;*/
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select cod_curso, nom_curso,num_creditos"
                    + " from curso "
                    + " where "
                    + " cod_curso='" + c.getCodCurso()+"'");
            
            while (rs.next())
            { 
                Curso cur = new Curso();
                
                cur.setCodCurso(rs.getString(1));
                cur.setNomCurso(rs.getString(2));
                cur.setCredCurso(rs.getString(3));
                /*est.setCodEstudiante(rs.getString(1));
                est.setNomEstudiante(rs.getString(2));
                est.setCodCurso(rs.getString(3));
                est.setPassword(rs.getString(4));*/
                
                datosC.add(cur);
                
            }
            
            Logger.getLogger(CursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso fin...{0}", datosC.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datosC;
    }
    
   
}
    

