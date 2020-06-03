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
import co.edu.ucatolica.as.DTOs.Curso;
import co.edu.ucatolica.as.bds.MySqlDataSource;
import java.sql.Connection;

public class CursoMySqlFactoryDao {
    
    private Connection cn;

    public CursoMySqlFactoryDao() {
        cn = MySqlDataSource.getConexionBD();
    }
    
    public void cursoUsuario(Curso usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
