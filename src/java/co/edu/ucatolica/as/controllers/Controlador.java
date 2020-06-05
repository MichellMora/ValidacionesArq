package co.edu.ucatolica.as.controllers;

import co.edu.ucatolica.as.DAOs.FactoryDao;
import co.edu.ucatolica.as.DAOs.PersonaMySQLDAO;
import co.edu.ucatolica.as.DAOs.EstCursoMySQLDAO;
import co.edu.ucatolica.as.DAOs.MonitoriaMySQLDAO;
import co.edu.ucatolica.as.DAOs.EstMonitoriaMySQLDAO;
import co.edu.ucatolica.as.DAOs.CursoMySQLDAO;
import co.edu.ucatolica.as.DAOs.EstudianteMySQLDAO;
import co.edu.ucatolica.as.DTOs.Persona;
import co.edu.ucatolica.as.DTOs.Est_curso;
import co.edu.ucatolica.as.DTOs.Estudiante;
import co.edu.ucatolica.as.DTOs.Curso;
import co.edu.ucatolica.as.DTOs.Monitoria;
import co.edu.ucatolica.as.DTOs.Est_monitoria;
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
 
@Controller
@RequestMapping("/")
public class Controlador implements Controller {
    
    
    /*Inicio Metodos*/
    
    @RequestMapping(method = RequestMethod.GET, value = "monitoriaIngres.htm")
    public String processSubmit20(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "inicio2";
    } 
    
    @RequestMapping(method = RequestMethod.POST, value = "monitoriaIngresoFor.htm")
    public String processSubmit30(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        EstudianteMySQLDAO eDao = new EstudianteMySQLDAO();
        CursoMySQLDAO cDao = new CursoMySQLDAO();
        MonitoriaMySQLDAO mDao = new MonitoriaMySQLDAO();
        
        
    
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
        Logger.getLogger(CursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
        Logger.getLogger(MonitoriaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
        
        
        String ident = req.getParameter("codEstudiante");
        String cur = req.getParameter("codCurso");
        String mon = req.getParameter("codCurso");
       
        
        Estudiante e = new Estudiante();
        Curso c = new Curso();
        Monitoria m = new Monitoria();
        
       
        e.setCodEstudiante(ident);
        c.setCodCurso(cur);
        m.setCodCurso(mon);
        
    
            
        List<Estudiante> datosE = eDao.monitoriaIng(e, MySqlDataSource.getConexionBD());
        List<Curso> datosC = cDao.monitoriaCur(c, MySqlDataSource.getConexionBD());
        List<Monitoria> datosM = mDao.monitoriaMon(m, MySqlDataSource.getConexionBD());
        

        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datosE.size());
        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, "Consultar + " + cur + "-" + datosE.size());
        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, "Consultar + " + mon + "-" + datosM.size());
        
        
        model.put("listaEstudiante", datosE);
        if (datosE.size() > 0)
            model.put("mensaje", "Información");
        else
            model.put("mensaje", "No se pudo ejecutar la solicitud");
        
        model.put("listaCurso", datosC);
        if (datosC.size() > 0)
            model.put("mensaje", "Información");
        else
            model.put("mensaje", "No se pudo ejecutar la solicitud");
        
        model.put("listaMonitoria", datosM);
        if (datosM.size() > 0)
            model.put("mensaje", "Información");
        else
            model.put("mensaje", "No se pudo ejecutar la solicitud");
        
        return "monitorias";
    }  
    
    /*Fin Metodos*/
    
    /*Inicio Validación1*/
    
    @RequestMapping(method = RequestMethod.GET, value = "monitoriaIn.htm")
    public String processSubmit22(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(Controlador.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "monitorias";
    } 
    
    @RequestMapping(method = RequestMethod.POST, value = "monitoriaIngFor.htm")
    public String processSubmit32(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        EstMonitoriaMySQLDAO emDao = new EstMonitoriaMySQLDAO();
        Logger.getLogger(EstMonitoriaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
    
        String esmon = req.getParameter("codMonitoria");
        
        Est_monitoria em = new Est_monitoria();
       
        em.setCodMonitoria(esmon);
    
        List<Est_monitoria> datosEM = emDao.monitoriaEstMon(em, MySqlDataSource.getConexionBD());

        
        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, "Consultar + " + esmon + "-" + datosEM.size());
        
        
        model.put("listaEstMonitoria", datosEM);
        if (datosEM.size() > 0)
            model.put("mj", "Lo sentimos, esta materia ya tiene monitor, intenta con otro curso");
            
        else
            model.put("mj", "La materia no tiene monitor asignado, puedes continuar");
        
        return "monitorias";
    }  
    /*Fin Validación1*/
    
    @RequestMapping(method = RequestMethod.GET, value = "monitoriaValidacio.htm")
    public String processSubmit23(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(Controlador.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "validaciones";
    } 
    
    @RequestMapping(method = RequestMethod.POST, value = "monitoriaValidacionFor.htm")
    public String processSubmit33(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
        EstCursoMySQLDAO ecDao = new EstCursoMySQLDAO();
        EstudianteMySQLDAO eDao = new EstudianteMySQLDAO();
        CursoMySQLDAO cDao = new CursoMySQLDAO();
        
        Logger.getLogger(EstCursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
        Logger.getLogger(CursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
    
        String escur = req.getParameter("codEstudiante");
        String epcur = req.getParameter("codEstudiante");
        String ecur = req.getParameter("codCurso");
        
        String ident = req.getParameter("codEstudiante");
        String cur = req.getParameter("codCurso");
        
       
        Est_curso ec = new Est_curso();
        Estudiante e = new Estudiante();
        Curso c = new Curso();
       
        ec.setCodEstudiante(escur);
        ec.setCodCurso(ecur);
        
        ec.setCodEstudiante(epcur);
        e.setCodEstudiante(ident);
        c.setCodCurso(cur);
        
        
    
        List<Est_curso> datosEC = ecDao.validacionesCur(ec, MySqlDataSource.getConexionBD());
        List<Est_curso> datosES = ecDao.validacionesCur(ec, MySqlDataSource.getConexionBD());
        List<Est_curso> datosEP = ecDao.validacionesProm(ec, MySqlDataSource.getConexionBD());
       
        List<Estudiante> datosE = eDao.monitoriaIng(e, MySqlDataSource.getConexionBD());
        List<Curso> datosC = cDao.monitoriaCur(c, MySqlDataSource.getConexionBD());
        
        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, "Consultar + " + escur + "-" + datosEC.size());
        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, "Consultar + " + ecur + "-" + datosES.size());
        
        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, "Consultar + " + epcur + "-" + datosEP.size());
        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datosE.size());
        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, "Consultar + " + cur + "-" + datosE.size());
        
        EstMonitoriaMySQLDAO emDao = new EstMonitoriaMySQLDAO();
        Logger.getLogger(EstMonitoriaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
    
        String esmon = req.getParameter("codMonitoria");
        String esm = req.getParameter("codEstudiante");
        
        Est_monitoria em = new Est_monitoria();
       
        em.setCodMonitoria(esmon);
        em.setCodEstudiante(esm);
        
        List<Est_monitoria> datosEM = emDao.monitoriaEstMon(em, MySqlDataSource.getConexionBD());
        List<Est_monitoria> datosEPs = emDao.monitoriaPos(em, MySqlDataSource.getConexionBD());
        
        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, "Consultar + " + esmon + "-" + datosEM.size());
        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, "Consultar + " + esm + "-" + datosEPs.size());
        
        model.put("listaEstMonitoria", datosEM);
        if (datosEM.size() > 0)
            model.put("mj", "Lo sentimos, esta materia ya tiene monitor, intenta con otro curso");
            
        else
            model.put("mj", "La materia no tiene monitor asignado, puedes continuar");
        
        
        model.put("listaEstPMonitoria", datosEPs);
        if (datosEPs.size() > 0)
            model.put("mss", "El estudiante tiene asignada otra monitoria,un estudiante de posgrado no puede tener más de una monitoria");
            
        else
            model.put("mss", "El estudiante no tiene asignada otra monitoria");
        
        
        
        model.put("listaEstudiante", datosE);
        if (datosE.size() > 0)
            model.put("mensaje", "Información");
        else
            model.put("mensaje", "No se pudo ejecutar la solicitud");
        
        model.put("listaCurso", datosC);
        if (datosC.size() > 0)
            model.put("mensaje", "Información");
            
        else
            model.put("mensaje", "No se pudo ejecutar la solicitud");

        model.put("listaEstCursoP", datosEP);
        

            if (datosEP.size() > 0)
               
                model.put("m", "Promedio estudiante ");
            else          
                model.put("m", "No se encuentra promedio ");
            
            
            /*if ((ecur.equals(datosEP.get(0))))
                    model.put("m", "ok ");
                else
                    model.put("m", "no "); }    */
           
            
        model.put("listaEstCurso", datosEC);
        model.put("listaEstCurso", datosES);
        if (datosEC.size() > 0)
            {if(datosES.size() > 0){
                    model.put("msj", "El estudiante ha visto el curso"); }}   
        else
            model.put("msj", "El estudiante no ha visto el curso");
       
       if (datosEP.size()>0 && datosEC.size() > 0 && datosE.size()>0 && datosC.size() > 0)
           if (datosEM.size()>0 || datosEPs.size() > 0)
                    
                        {
                           
                           model.put("message", "Lo sentimos, no puedes ser monitor, te explicamos los motivos en la caja de inscripción"); 

                        }
                    else 
                        {
                             
                             model.put("message", "Felicitaciones, puedes ser monitor de este curso");
                        }
        
       return "validacionespos";
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
