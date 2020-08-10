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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clave del programa: SWPP<br>
 * Autor: olver <br>
 * Fecha: 20/07/2020 <br>
 * Descripción: Implementación de la clase EstudianteDAO, la cual da acceso a la información de los estudiantes contenidos en la base de datos
 */
public class EstudianteDAOImp implements EstudianteDAO{

    @Override
    public boolean create(EstudianteVO estudiante) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try{
            String insertar = "INSERT INTO Estudiante VALUES (?,?,?,?)";
            try (PreparedStatement pst = conexBD.prepareStatement(insertar)) {
                pst.setString(1, estudiante.getMatricula());
                pst.setString(2, estudiante.getNombre());
                pst.setString(3, estudiante.getEstatus());
                pst.setString(4, estudiante.getNRC());
                
                conexBD.preparedStatementUpdate(pst);
            }
            resultado = true;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public ObservableList<EstudianteVO> readAll() {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            ObservableList<EstudianteVO> listaEstudiantes = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM Estudiante";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            ResultSet rs = conexBD.preparedStatementQuery(pst);
            
            while(rs.next()){
                listaEstudiantes.add(
                    new EstudianteVO(
                        rs.getString("matricula"),
                        rs.getString("nombre"),
                        rs.getString("estatus"),
                        rs.getString("nrc")
                    )
                );
            }
            
            pst.close();
            rs.close();
            conexBD.close();
            return listaEstudiantes;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public ObservableList<EstudianteVO> readAll(String estatus) throws Exception {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            ObservableList<EstudianteVO> listaEstudiantes = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM Estudiante WHERE estatus = ?";
            ResultSet rs;
            try (PreparedStatement pst = conexBD.prepareStatement(consulta)) {
                pst.setString(1, estatus);
                
                rs = conexBD.preparedStatementQuery(pst);
                while(rs.next()){
                    listaEstudiantes.add(
                            new EstudianteVO(
                                    rs.getString("matricula"),
                                    rs.getString("nombre"),
                                    rs.getString("estatus"),
                                    rs.getString("nrc")
                            )
                    );
                }
            }
            rs.close();
            conexBD.close();
            return listaEstudiantes;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public EstudianteVO read(String matriculaEstudiante) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String consulta = "SELECT * FROM Estudiante WHERE matricula = ?";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            
            pst.setString(1, matriculaEstudiante);
            
            ResultSet rs = conexBD.preparedStatementQuery(pst);
            
            EstudianteVO estudiante = null;
            if(rs.next()){
                estudiante = new EstudianteVO(
                rs.getString("matricula"),
                rs.getString("nombre"),
                rs.getString("estatus"),
                rs.getString("nrc")
                );
            }
            
            pst.close();
            rs.close();
            conexBD.close();
            return estudiante;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public boolean update(String matriculaEstudiante, EstudianteVO nuevoEstudiante) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String actualizacion = "UPDATE Estudiante SET "
                    + "matricula = ?,"
                    + "nombre = ?,"
                    + "estatus = ?,"
                    + "nrc = ?"
                    + "WHERE matricula = ? ";
            PreparedStatement pst = conexBD.prepareStatement(actualizacion);
            
            pst.setString(1, nuevoEstudiante.getMatricula());
            pst.setString(2, nuevoEstudiante.getNombre());
            pst.setString(3, nuevoEstudiante.getEstatus());
            pst.setString(4, nuevoEstudiante.getNRC());
            pst.setString(5, matriculaEstudiante);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public boolean delete(EstudianteVO estudiante) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM Estudiante WHERE matricula = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, estudiante.getMatricula());
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }  
    }

    @Override
    public boolean delete(String matricula) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM Estudiante WHERE matricula = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, matricula);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }
}
