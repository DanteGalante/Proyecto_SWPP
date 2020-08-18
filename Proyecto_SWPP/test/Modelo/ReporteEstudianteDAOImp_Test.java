/*
------------------------
Alan Adair Morgado Morales
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Modelo;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Clave del programa: SWPP<br>
 * Autor: Morgado <br>
 * Fecha: 10/08/2020 <br>
 * Actualizacion: 17/08/2020 <br>
 * Descripción: Prueba unitaria de los metodos de la clase ReporteEstudianteDAO<br>
 **/
public class ReporteEstudianteDAOImp_Test {
    
    ReporteEstudianteDAOImp ReporteEstudianteDAO;
    ReporteEstudianteVO reporteEstudiante;
    
    
    @Before
    public void previo(){
        try {
            ReporteEstudianteDAO = new ReporteEstudianteDAOImp();
            reporteEstudiante = new ReporteEstudianteVO( 1, 20, "Reporte mes 1",  "S88817931", "Sistema gestor de servicio social");
            ReporteEstudianteDAO.create(reporteEstudiante);
        } catch (Exception ex) {
            Logger.getLogger(DocumentoRequeridoDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @Test
    public void testCreate() throws SQLException {
        ReporteEstudianteDAO.delete(reporteEstudiante);
        boolean resultado = false;
        
        try {
            resultado = ReporteEstudianteDAO.create(reporteEstudiante);
        } catch (Exception ex) {
            Logger.getLogger(ReporteEstudianteDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        assertTrue(resultado);
    }
    /*
    @After
    public void despues() throws SQLException{
        ReporteEstudianteDAO.delete(reporteEstudiante);
    }
    */
    
}

