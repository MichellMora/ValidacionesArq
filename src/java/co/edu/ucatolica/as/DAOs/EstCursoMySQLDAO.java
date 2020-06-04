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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EstCursoMySQLDAO {
    
    public ArrayList<Est_curso> validacionesCur(Est_curso ec, Connection con){
    
        ArrayList<Est_curso> datosEC = new ArrayList();
        
        Logger.getLogger(EstCursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso...");
        
        /*String codCurso = null;
        String nomCurso = null;
        String credCurso = null;*/
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id, cod_estudiante, cod_curso, nota_curso"
                    + " from estudiante_curso "
                    + " where "
                    + " cod_estudiante='" + ec.getCodEstudiante()+"'");
            
            while (rs.next())
            { 
                Est_curso ecur = new Est_curso();
                
                ecur.setId(rs.getInt(1));
                ecur.setCodEstudiante(rs.getString(2));
                ecur.setCodCurso(rs.getString(3)); 
                ecur.setNotaCurso(rs.getString(4));
                /*est.setCodEstudiante(rs.getString(1));
                est.setNomEstudiante(rs.getString(2));
                est.setCodCurso(rs.getString(3));
                est.setPassword(rs.getString(4));*/
                
                datosEC.add(ecur);
                
            }
            
            Logger.getLogger(CursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso fin...{0}", datosEC.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datosEC;
    }
 }
            
    

