/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.controllers;

/**
 *
 * @author miche
 */

import co.edu.ucatolica.as.DAOs.FactoryDao;
import co.edu.ucatolica.as.DAOs.EstudianteMySQLDAO;
import co.edu.ucatolica.as.DTOs.Estudiante;
import co.edu.ucatolica.as.bds.MySqlDataSource;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;


/*@Controller
@RequestMapping("/")*/
public class EstudianteControllers implements Controller {
    
    @RequestMapping(method = RequestMethod.GET, value = "monitoriaIngreso.htm")
    public String processSubmit2(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "monitorias";
    } 
    
@RequestMapping(method = RequestMethod.POST, value = "monitoriaIngresoForm.htm")
    public String processSubmit3(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
       EstudianteMySQLDAO eDao = new EstudianteMySQLDAO();
        
    
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
      
        String ident = req.getParameter("identificacion");
        
        Estudiante e = new Estudiante();
       
        e.setIdentificacion(ident);
    
            
        List<Estudiante> datos = eDao.monitoriaIng(e, MySqlDataSource.getConexionBD());

        Logger.getLogger(EstudianteControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());
        
        model.put("listaEstudiantes", datos);
        if (datos.size() > 0)
            model.put("mensaje", "En la siguiente tabla se muestran los datos de la persona identificada con la cedula numero "+ e.getIdentificacion() + datos.size());
        else
            model.put("mensaje", "La persona con la cedula numero " + e.getIdentificacion()+ " no se encuentra registrada en la base de datos");
        
        return "monitorias";
    }   
       
    
    
    @Override
    public String value() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    

