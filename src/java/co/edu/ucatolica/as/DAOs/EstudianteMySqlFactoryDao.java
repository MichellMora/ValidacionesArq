/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.DAOs;

import co.edu.ucatolica.as.DTOs.Estudiante;
import co.edu.ucatolica.as.bds.MySqlDataSource;
import java.sql.Connection;

public class EstudianteMySqlFactoryDao {
    
    private Connection cn;

    public EstudianteMySqlFactoryDao() {
        cn = MySqlDataSource.getConexionBD();
    }
    
    public void monitoriaUsuario(Estudiante usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
