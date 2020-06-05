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
import co.edu.ucatolica.as.DTOs.Est_monitoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EstMonitoriaMySQLDAO {
    
   public ArrayList<Est_monitoria> monitoriaEstMon(Est_monitoria em, Connection con)
            
    {
        
        ArrayList<Est_monitoria> datosEM = new ArrayList();
        
        Logger.getLogger(EstMonitoriaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso...");
        
        /*String codCurso = null;
        String nomCurso = null;
        String credCurso = null;*/
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select cod_monitoria, cod_estudiante"
                    + " from estudiante_monitoria "
                    + " where "
                    + " cod_monitoria='" + em.getCodMonitoria()+"'");
            
            while (rs.next())
            { 
                Est_monitoria esm = new Est_monitoria();
                
                esm.setCodMonitoria(rs.getString(1));
                esm.setCodEstudiante(rs.getString(2));
               
                
                datosEM.add(esm);
                
            }
            
            Logger.getLogger(EstMonitoriaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso fin...{0}", datosEM.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstMonitoriaMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datosEM;
    }
    
   public ArrayList<Est_monitoria> monitoriaPos(Est_monitoria em, Connection con)
            
    {
        
        ArrayList<Est_monitoria> datosEPs = new ArrayList();
        
        Logger.getLogger(EstMonitoriaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso...");
        
        /*String codCurso = null;
        String nomCurso = null;
        String credCurso = null;*/
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select cod_monitoria, cod_estudiante"
                    + " from estudiante_monitoria "
                    + " where "
                    + " cod_estudiante='" + em.getCodEstudiante()+"'");
            
            while (rs.next())
            { 
                Est_monitoria esm = new Est_monitoria();
                
                
                esm.setCodEstudiante(rs.getString(1));
                esm.setCodMonitoria(rs.getString(2));
               
                
                datosEPs.add(esm);
                
            }
            
            Logger.getLogger(EstMonitoriaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso fin...{0}", datosEPs.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstMonitoriaMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datosEPs;
    }
}
