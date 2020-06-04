  
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
public class PersonaControllers implements Controller {
    
@RequestMapping(method = RequestMethod.GET, value = "personaCrear.htm")
    public String processSubmit(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        System.out.println("personaCrear");
        model.put("mensajePersona", "Pase por el controller de Persona:::"+req.getParameter("nombre"));
        return "persona_crear";
    }    
    
@RequestMapping(method = RequestMethod.POST, value = "personaRegistrar.htm")
    public String processSubmit1(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        //PersonaMySQLDAO pDao = new PersonaMySQLDAO();
        FactoryDao MySqlFactory = FactoryDao.getFactory(FactoryDao.MYSQL_FACTORY);
            
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit1...");

        //int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String ident = req.getParameter("identificacion");
        String nombre1 = req.getParameter("nombre1");
        String nombre2 = req.getParameter("nombre2");
        String apellido1 = req.getParameter("apellido1");
        String apellido2 = req.getParameter("apellido2");
        String genero = req.getParameter("genero");
        String fNacimiento = req.getParameter("fecha");
        String telef = req.getParameter("telefono");
        String email = req.getParameter("email");
        String tipoP = req.getParameter("tipop");
        
        Persona p = new Persona();
        //p.setId(id);
        p.setIdentificacion(ident);
        p.setNombre1(nombre1);
        p.setNombre2(nombre2);
        p.setApellido1(apellido1);
        p.setApellido2(apellido2);
        p.setGenero(genero);
        p.setfNacimiento(fNacimiento);
        p.setTelef(telef);
        p.setEmail(email);   
        p.setTipoP(tipoP);
            
        //boolean insert = pDao.crearPersona(p, MySqlDataSource.getConexionBD());
        boolean insert = MySqlFactory.getPersonaDao().crearPersona(p, MySqlDataSource.getConexionBD());

        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Registrar + " + ident + "-" + insert);
        
        if (insert)
            model.put("mensaje", "El registro fue creado satisfactoriamente!!!");
        else
            model.put("mensaje", "El registro NO fue creado, consulte con el administrador...");
        
        return "persona_crear";
    }     
    
@RequestMapping(method = RequestMethod.GET, value = "personaConsultar.htm")
    public String processSubmit2(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "persona_consultar";
    } 
    
@RequestMapping(method = RequestMethod.POST, value = "personaConsultarForm.htm")
    public String processSubmit3(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        PersonaMySQLDAO pDao = new PersonaMySQLDAO();
        
    
        Logger.getLogger(PersonaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
      
        String ident = req.getParameter("identificacion");
        
        Persona p = new Persona();
       
        p.setIdentificacion(ident);
    
            
        List<Persona> datos = pDao.consultarPersona(p, MySqlDataSource.getConexionBD());

        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());
        
        model.put("listaPersonas", datos);
        if (datos.size() > 0)
            model.put("mensaje", "En la siguiente tabla se muestran los datos de la persona identificada con la cedula numero "+ p.getIdentificacion() + datos.size());
        else
            model.put("mensaje", "La persona con la cedula numero " + p.getIdentificacion()+ " no se encuentra registrada en la base de datos");
        
        return "persona_consultar";
    }   
    
@RequestMapping(method = RequestMethod.GET, value = "personaEditar.htm")
    public String processSubmit4(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit4...");
        return "persona_editar";
    } 
    
@RequestMapping(method = RequestMethod.POST, value = "personaEditarForm1.htm")
    public String processSubmit5(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
        PersonaMySQLDAO pDao = new PersonaMySQLDAO();
            
        Logger.getLogger(PersonaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit5...");

        //int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String ident = req.getParameter("identificacion");
        //String nombre1 = req.getParameter("nombre1");
        
        Persona p = new Persona();
        //p.setId(id);
        p.setIdentificacion(ident);
        //p.setNombre1(nombre1);
            
        List<Persona> datos = pDao.consultarPersona(p, MySqlDataSource.getConexionBD());
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());    
        model.put("listaPersonas", datos);
        
        return "persona_editar";
        
    }  
    
@RequestMapping(method = RequestMethod.POST, value = "personaEditarForm2.htm")
    public String processSubmit6(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
      //  //
        //PersonaMySQLDAO pDao = new PersonaMySQLDAO();
       FactoryDao MySqlFactory = FactoryDao.getFactory(FactoryDao.MYSQL_FACTORY);   
        Logger.getLogger(PersonaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit6...");

        int id = Integer.parseInt(req.getParameter("id"));
        String ident = req.getParameter("identificacion");
        String nombre1 = req.getParameter("nombre1");
        String nombre2 = req.getParameter("nombre2");
        String apellido1 = req.getParameter("apellido1");
        String apellido2 = req.getParameter("apellido2");
        String genero = req.getParameter("genero");
        String tipoP = req.getParameter("tipop");
        String fNacimiento = req.getParameter("fecha");
        String telef = req.getParameter("telefono");
        String email = req.getParameter("email");
        
        Logger.getLogger(PersonaMySQLDAO.class.getName()).log(Level.INFO,"Id_persona: " + id);
        
      Persona p = new Persona();
        //p.setId(id);
        p.setIdentificacion(ident);
        p.setNombre1(nombre1);
        p.setNombre2(nombre2);
        p.setApellido1(apellido1);
        p.setApellido2(apellido2);
        p.setGenero(genero);
        p.setTipoP(tipoP);
        p.setfNacimiento(fNacimiento);
        p.setTelef(telef);
        p.setEmail(email);     
        
         /*boolean insert = MySqlFactory.getPersonaDao().crearPersona(p, MySqlDataSource.getConexionBD());
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Registrar + " + ident + "-" + insert);
        
        if (insert)
            model.put("mensaje", "El registro fue creado satisfactoriamente!!!");
        else
            model.put("mensaje", "El registro NO fue creado, consulte con el administrador...");
        
        return "persona_crear";*/
                
            
       // boolean res = pDao.editarPersona(p, MySqlDataSource.getConexionBD()); 
    
    boolean res = MySqlFactory.getPersonaDao().editarPersona(p, MySqlDataSource.getConexionBD());
               
        if (res)
            model.put("mensaje", "Se edito satisfactoriamente!!!");
        else
            model.put("mensaje", "NO se guardaron los cambios...");
        
        return "persona_editar";
        
    } 

   @RequestMapping(method = RequestMethod.GET, value = "personaEliminar.htm")
    public String processSubmit7(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit7...");
        return "persona_eliminar";
    }  
    
    @RequestMapping(method = RequestMethod.POST, value = "personaEliminar1.htm")
    public String processSubmit8(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
        PersonaMySQLDAO pDao = new PersonaMySQLDAO();
            
        Logger.getLogger(PersonaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit5...");

        //int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String ident = req.getParameter("identificacion");
        //String nombre1 = req.getParameter("nombre1");
        
        Persona p = new Persona();
        //p.setId(id);
        p.setIdentificacion(ident);
        //p.setNombre1(nombre1);
            
        List<Persona> datos = pDao.consultarPersona(p, MySqlDataSource.getConexionBD());
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());    
        model.put("listaPersonas", datos);
        
        return "persona_eliminar";
        
    }  
    
    @RequestMapping(method = RequestMethod.POST, value = "personaEliminar2.htm")
    public String processSubmit9(HttpServletRequest req, SessionStatus status,ModelMap model)
    {
     
        FactoryDao MySqlFactory = FactoryDao.getFactory(FactoryDao.MYSQL_FACTORY);
        String ident = req.getParameter("identificacion");
        Persona p = new Persona();
        //p.setId(id);
        p.setIdentificacion(ident);
        
        boolean insert = MySqlFactory.getPersonaDao().eliminarPersona(p, MySqlDataSource.getConexionBD());
       if (insert)
            model.put("mensaje", "La persona fue borrada exitosamente");
        else
            model.put("mensaje", "no se pudo eliminar");
       return "persona_eliminar";
    }
    
    /*Inicio Metodos*/
    
    @RequestMapping(method = RequestMethod.GET, value = "monitoriaIngreso.htm")
    public String processSubmit20(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "monitorias";
    } 
    
    @RequestMapping(method = RequestMethod.POST, value = "monitoriaIngresoForm.htm")
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
        

        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datosE.size());
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + cur + "-" + datosE.size());
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + mon + "-" + datosM.size());
        
        
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
    
    @RequestMapping(method = RequestMethod.GET, value = "monitoriaIng.htm")
    public String processSubmit22(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "monitorias";
    } 
    
    @RequestMapping(method = RequestMethod.POST, value = "monitoriaIngForm.htm")
    public String processSubmit32(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        EstMonitoriaMySQLDAO emDao = new EstMonitoriaMySQLDAO();
        Logger.getLogger(EstMonitoriaMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
    
        String esmon = req.getParameter("codMonitoria");
        
        Est_monitoria em = new Est_monitoria();
       
        em.setCodMonitoria(esmon);
    
        List<Est_monitoria> datosEM = emDao.monitoriaEstMon(em, MySqlDataSource.getConexionBD());

        
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + esmon + "-" + datosEM.size());
        
        
        model.put("listaEstMonitoria", datosEM);
        if (datosEM.size() > 0)
            model.put("msj", "Lo sentimos, esta materia ya tiene monitor, intenta con otro curso");
            
        else
            model.put("msj", "La materia no tiene monitor asignado, puedes continuar");
        
        return "monitorias";
    }  
    /*Fin Validación1*/
    
    @RequestMapping(method = RequestMethod.GET, value = "monitoriaValidacion.htm")
    public String processSubmit23(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "validaciones";
    } 
    
    @RequestMapping(method = RequestMethod.POST, value = "monitoriaValidacionForm.htm")
    public String processSubmit33(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
        EstCursoMySQLDAO ecDao = new EstCursoMySQLDAO();
        Logger.getLogger(EstCursoMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
    
        String escur = req.getParameter("codEstudiante");
        String ecur = req.getParameter("codCurso");
        
        Est_curso ec = new Est_curso();
       
        ec.setCodEstudiante(escur);
        ec.setCodCurso(ecur);
    
        List<Est_curso> datosEC = ecDao.validacionesCur(ec, MySqlDataSource.getConexionBD());
        List<Est_curso> datosES = ecDao.validacionesCur(ec, MySqlDataSource.getConexionBD());
        
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + escur + "-" + datosEC.size());
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ecur + "-" + datosES.size());
        
        model.put("listaEstCurso", datosEC);
        model.put("listaEstCurso", datosES);
        if (datosEC.size() > 0)
            {if(datosES.size() > 0){
                    model.put("msj", "El estudiante ha visto el curso"); }}   
        else
            model.put("msj", "El estudiante no ha visto el curso");
        
        
       
        return "validaciones";
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