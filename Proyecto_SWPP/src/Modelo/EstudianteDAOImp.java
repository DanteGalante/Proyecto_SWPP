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

/**
 * Clave del programa: SWPP<br>
 * Autor: olver <br>
 * Fecha: 20/07/2020 <br>
 * Descripción: Implementación de la clase EstudianteDAO, la cual da acceso a la información de los estudiantes contenidos en la base de datos
 */
public class EstudianteDAOImp implements EstudianteDAO{

    @Override
    public boolean create(EstudianteVO estudiante) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try{
            String insertar = "INSERT INTO Estudiante VALUES (?,?,?,?)";
            PreparedStatement pst = conexBD.prepareStatement(insertar);
            
            pst.setString(1, estudiante.getMatricula());
            pst.setString(2, estudiante.getNombre());
            pst.setString(3, estudiante.getEstatus());
            pst.setString(4, estudiante.getNRC());
            
            conexBD.update(pst);
            
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
    public List<EstudianteVO> readAll() {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            List<EstudianteVO> listaEstudiantes = new ArrayList<EstudianteVO>();
            String consulta = "SELECT * FROM Estudiante";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            ResultSet rs = conexBD.query(pst);
            
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
    public EstudianteVO read(String matriculaEstudiante) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String consulta = "SELECT * FROM Estudiante WHERE matricula = ?";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            
            pst.setString(1, matriculaEstudiante);
            
            ResultSet rs = conexBD.query(pst);
            
            EstudianteVO estudiante = new EstudianteVO(
                rs.getString("matricula"),
                rs.getString("nombre"),
                rs.getString("estatus"),
                rs.getString("nrc")
            );
            
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
    public boolean update(String matriculaEstudiante, EstudianteVO estudiante) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String actualizacion = "UPDATE Estudiante SET "
                    + "matricula = ?"
                    + "nombre = ?"
                    + "estatus = ?"
                    + "nrc = ?"
                    + "WHERE matricula = ?";
            PreparedStatement pst = conexBD.prepareStatement(actualizacion);
            
            pst.setString(1, estudiante.getMatricula());
            pst.setString(2, estudiante.getNombre());
            pst.setString(3, estudiante.getEstatus());
            pst.setString(4, estudiante.getNRC());
            pst.setString(5, matriculaEstudiante);
            
            conexBD.update(pst);
            
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
            
            conexBD.update(pst);
            
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
            
            conexBD.update(pst);
            
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
