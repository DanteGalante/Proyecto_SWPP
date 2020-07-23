/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

import Controlador.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clave del programa: SWPP<br>
 * Autor: olver <br>
 * Fecha: 21/07/2020 <br>
 * Descripción: Implementación de la clase ExpedienteDAO, la cual da acceso a la información de los expedientess contenidos en la base de datos
 */
public class ExpedienteDAOImp implements ExpedienteDAO{

    @Override
    public boolean create(ExpedienteVO expediente) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try{
            String insertar = "INSERT INTO Expediente VALUES (?,?,?,?,?,?)";
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
            Logger.getLogger(ExpedienteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public ObservableList<ExpedienteVO> readAll() {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            ObservableList<ExpedienteVO> listaExpedientes = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM Expediente";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            ResultSet rs = conexBD.preparedStatementQuery(pst);
            
            while(rs.next()){
                listaExpedientes.add(
                    new ExpedienteVO(
                        rs.getString("estudiante_matricula"),
                        rs.getString("proyecto_nombreProyecto"),
                        rs.getString("periodo"),
                        rs.getInt("numArchivos"),
                        rs.getInt("numHrsTotales"),
                        rs.getString("cedProf_Docente")
                    )
                );
            }
            
            pst.close();
            rs.close();
            conexBD.close();
            return listaExpedientes;
        } catch (SQLException ex) {
            Logger.getLogger(ExpedienteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public ExpedienteVO read(String nombreProyecto, String matriculaEstudiante) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String consulta = "SELECT * FROM Expediente WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            
            pst.setString(1, matriculaEstudiante);
            pst.setString(2, nombreProyecto);
            
            ResultSet rs = conexBD.preparedStatementQuery(pst);
            
            ExpedienteVO expediente = null;
            if(rs.next()){
                expediente = new ExpedienteVO(
                rs.getString("estudiante_matricula"),
                rs.getString("proyecto_nombreProyecto"),
                rs.getString("periodo"),
                rs.getInt("numArchivos"),
                rs.getInt("numHrsTotales"),
                rs.getString("cedProf_Docente")
                );
            }
                
            
            pst.close();
            rs.close();
            conexBD.close();
            return expediente;
        } catch (SQLException ex) {
            Logger.getLogger(ExpedienteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public boolean update(String matriculaEstudiante, String nombreProyecto, ExpedienteVO expediente) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String actualizacion = "UPDATE Expediente SET "
                    + "estudiante_matricula = ?,"
                    + "proyecto_nombreProyecto = ?,"
                    + "periodo = ?,"
                    + "numArchivos = ?,"
                    + "numHrsTotales = ?,"
                    + "cedProf_Docente = ?"
                    + "WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
            PreparedStatement pst = conexBD.prepareStatement(actualizacion);
            
            pst.setString(1, expediente.getMatriculaEstudianteVinculado());
            pst.setString(2, expediente.getNombreProyectoVinculado());
            pst.setString(3, expediente.getPeriodo());
            pst.setInt(4, expediente.getNumeroArchivos());
            pst.setInt(5, expediente.getNumHrsTotales());
            pst.setString(6, expediente.getCedulaDocenteVinculado());
            pst.setString(7, matriculaEstudiante);
            pst.setString(8, nombreProyecto);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ExpedienteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public boolean delete(ExpedienteVO expediente) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM Expediente WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, expediente.getMatriculaEstudianteVinculado());
            pst.setString(2, expediente.getNombreProyectoVinculado());
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ExpedienteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }  
    }

    @Override
    public boolean delete(String matriculaEstudiante, String nombreProyecto) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM Expediente WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, matriculaEstudiante);
            pst.setString(2, nombreProyecto);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ExpedienteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }
}
