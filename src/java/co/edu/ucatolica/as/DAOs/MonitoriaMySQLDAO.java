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
import co.edu.ucatolica.as.DTOs.Monitoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MonitoriaMySQLDAO {
    
     public ArrayList<Monitoria> monitoriaMon(Monitoria m, Connection con)
            
    {
        
        ArrayList<Monitoria> datosM = new ArrayList();
        
        Logger.getLogger(MonitoriaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso...");
        
        /*String codCurso = null;
        String nomCurso = null;
        String credCurso = null;*/
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select codigo, cod_monitoria, nom_monitoria, nom_materia"
                    + " from monitoria "
                    + " where "
                    + " codigo='" + m.getCodCurso()+"'");
            
            while (rs.next())
            { 
                Monitoria mon = new Monitoria();
                
                mon.setCodCurso(rs.getString(1));
                mon.setCodMonitoria(rs.getString(2));
                mon.setNomMonitoria(rs.getString(3));
                mon.setNomMateria(rs.getString(4));
                
               
                
                datosM.add(mon);
                
            }
            
            Logger.getLogger(MonitoriaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCurso fin...{0}", datosM.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MonitoriaMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datosM;
    }
}
