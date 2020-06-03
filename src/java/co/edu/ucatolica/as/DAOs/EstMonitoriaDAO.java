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
import java.util.ArrayList;

public interface EstMonitoriaDAO {
    
    public ArrayList<Est_monitoria> monitoriaEstMon(Est_monitoria c, Connection con);
    
}
