/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

import Controlador.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clave del programa: SWPP<br>
 * Autor: olver <br>
 * Fecha: 21/07/2020 <br>
 * Descripción: Implementación de la clase ExpedienteDAO, la cual da acceso a la información de los proyectos contenidos en la base de datos
 */
public class ExpedienteDAOImp implements ExpedienteDAO{

    @Override
    public boolean create(ExpedienteVO expediente) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try{
            String insertar = "INSERT INTO Estudiante VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = conexBD.prepareStatement(insertar);
            
            pst.setString(1, expediente.getMatriculaEstudianteVinculado());
            pst.setString(2, expediente.getNombreProyectoVinculado());
            pst.setString(3, expediente.getPeriodo());
            pst.setInt(4, expediente.getNumeroArchivos());
            pst.setInt(5, expediente.getNumHrsTotales());
            pst.setString(6, expediente.getCedulaDocenteVinculado());
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        }catch(SQLException ex){
            Logger.getLogger(EstudianteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public List<ExpedienteVO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExpedienteVO read(String nombreProyecto, String matriculaEstudiante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String matriculaEstudiante, String nombreProyecto, ExpedienteVO expediente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ExpedienteVO expediente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String matriculaEstudiante, String nombreProyecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
