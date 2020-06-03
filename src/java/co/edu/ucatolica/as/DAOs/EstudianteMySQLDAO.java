package co.edu.ucatolica.as.DAOs;

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
        
        ArrayList<Estudiante> datosE = new ArrayList();
        
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarEstudiante...");
        /*String codEstudiante = null;
        String nomEstudiante = null;
        String codCurso = null;
        String password = null;*/
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select cod_estudiante, nom_estudiante,cod_curso, "
                    + " password "
                    + " from estudiante "
                    + " where "
                    + " cod_estudiante='" + e.getCodEstudiante()+"'");
            
            while (rs.next())
            { 
                Estudiante est = new Estudiante();
                est.setCodEstudiante(rs.getString(1));
                est.setNomEstudiante(rs.getString(2));
                est.setCodCurso(rs.getString(3));
                est.setPassword(rs.getString(4));
                
                datosE.add(est);
                
            }
            
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarEstudiante fin...{0}", datosE.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datosE;
    }
}
    

