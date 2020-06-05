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
        ArrayList<Est_curso> datosES = new ArrayList();
        
        Logger.getLogger(EstCursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso...");
        
        /*String codCurso = null;
        String nomCurso = null;
        String credCurso = null;*/
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id, cod_estudiante, cod_curso, nota_curso"
                    + " from estudiante_curso "
                    + " where cod_curso="+ec.getCodCurso()
                    + " and cod_estudiante=" + ec.getCodEstudiante());
            
            while (rs.next())
            { 
                Est_curso ecur = new Est_curso();
                
                ecur.setId(rs.getInt(1));
                ecur.setCodEstudiante(rs.getString(2));
                ecur.setCodCurso(rs.getString(3)); 
                ecur.setNotaCurso(rs.getFloat(4));
                /*est.setCodEstudiante(rs.getString(1));
                est.setNomEstudiante(rs.getString(2));
                est.setCodCurso(rs.getString(3));
                est.setPassword(rs.getString(4));*/
                
                datosEC.add(ecur);
                datosES.add(ecur);
            }
            
            Logger.getLogger(EstCursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso fin...{0}", datosEC.size());
            Logger.getLogger(EstCursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso fin...{0}", datosES.size());
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstCursoMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datosEC;
       
    }
    
    public ArrayList<Est_curso> validacionesProm(Est_curso ec, Connection con){
    
        ArrayList<Est_curso> datosEP = new ArrayList();
        
        
        
        Logger.getLogger(EstCursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso...");
        
        /*String codCurso = null;
        String nomCurso = null;
        String credCurso = null;*/
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id, cod_estudiante, cod_curso, avg(nota_curso)"
                    + " from estudiante_curso "
                    + " where cod_estudiante="+ec.getCodEstudiante());
            
            while (rs.next())
            { 
                Est_curso epcur = new Est_curso();
                
                
                epcur.setId(rs.getInt(1));
                epcur.setCodEstudiante(rs.getString(2));
                epcur.setCodCurso(rs.getString(3)); 
                epcur.setNotaCurso(rs.getFloat(4));
                
                /*est.setCodEstudiante(rs.getString(1));
                est.setNomEstudiante(rs.getString(2));
                est.setCodCurso(rs.getString(3));
                est.setPassword(rs.getString(4));*/
                
                datosEP.add(epcur);
                
                
            }
            
            Logger.getLogger(EstCursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso fin...{0}", datosEP.size());
            
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstCursoMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return datosEP;
        
       
    }
    
    
    
 }
            
    

