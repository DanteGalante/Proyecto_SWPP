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
 * Clave del programa: <br>
 * Autor: olver <br>
 * Fecha: 21/07/2020 <br>
 * Descripción: Implementación de la clase PreferenciaProyectoDAO, la cual da acceso a la información de la preferencia de proyectos contenidos en la base de datos<br>
 */
public class PreferenciaProyectoDAOImp implements PreferenciaProyectoDAO{

    @Override
    public boolean create(PreferenciaProyectoVO preferenciaProyecto) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try{
            String insertar = "INSERT INTO PreferenciaProyecto VALUES (?,?,?)";
            PreparedStatement pst = conexBD.prepareStatement(insertar);
            
            pst.setString(1, preferenciaProyecto.getMatriculaEstudianteVinculado());
            pst.setString(2, preferenciaProyecto.getNombreProyectoVinculado());
            pst.setInt(3, preferenciaProyecto.getPosicion());
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        }catch(SQLException ex){
            Logger.getLogger(PreferenciaProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public List<PreferenciaProyectoVO> readAll() {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            List<PreferenciaProyectoVO> listaPreferenciaProyectos = new ArrayList<PreferenciaProyectoVO>();
            String consulta = "SELECT * FROM PreferenciaProyecto";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            ResultSet rs = conexBD.preparedStatementQuery(pst);
            
            while(rs.next()){
                listaPreferenciaProyectos.add(
                    new PreferenciaProyectoVO(
                        rs.getString("estudiante_matricula"),
                        rs.getString("proyecto_nombreProyecto"),
                        rs.getInt("posicion")
                    )
                );
            }
            
            pst.close();
            rs.close();
            conexBD.close();
            return listaPreferenciaProyectos;
        } catch (SQLException ex) {
            Logger.getLogger(PreferenciaProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public List<PreferenciaProyectoVO> readAll(String matriculaEstudiante) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            List<PreferenciaProyectoVO> listaPreferenciaProyectos = new ArrayList<PreferenciaProyectoVO>();
            String consulta = "SELECT * FROM PreferenciaProyecto WHERE matriculaEstudiante = ?";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            
            pst.setString(1, matriculaEstudiante);
            
            ResultSet rs = conexBD.preparedStatementQuery(pst);
            
            while(rs.next()){
                listaPreferenciaProyectos.add(
                    new PreferenciaProyectoVO(
                        rs.getString("estudiante_matricula"),
                        rs.getString("proyecto_nombreProyecto"),
                        rs.getInt("posicion")
                    )
                );
            }
            
            pst.close();
            rs.close();
            conexBD.close();
            return listaPreferenciaProyectos;
        } catch (SQLException ex) {
            Logger.getLogger(PreferenciaProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public PreferenciaProyectoVO read(String nombreProyecto, String matriculaEstudiante) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String consulta = "SELECT * FROM PreferenciaProyecto WHERE estudiante_matricula = ?, proyecto_nombreProyecto = ?";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            
            pst.setString(1, matriculaEstudiante);
            pst.setString(2, nombreProyecto);
            
            ResultSet rs = conexBD.preparedStatementQuery(pst);
            
            PreferenciaProyectoVO preferenciaProyecto = new PreferenciaProyectoVO(
                rs.getString("estudiante_matricula"),
                rs.getString("proyecto_nombreProyecto"),
                rs.getInt("posicion")
            );
            
            pst.close();
            rs.close();
            conexBD.close();
            return preferenciaProyecto;
        } catch (SQLException ex) {
            Logger.getLogger(PreferenciaProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public boolean update(String nombreProyecto, String matriculaEstudiante, PreferenciaProyectoVO preferenciaProyecto) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String actualizacion = "UPDATE PreferenciaProyecto SET "
                    + "estudiante_matricula = ?"
                    + "proyecto_nombreProyecto = ?"
                    + "posicion = ?";
            
            PreparedStatement pst = conexBD.prepareStatement(actualizacion);
            
            pst.setString(1, preferenciaProyecto.getMatriculaEstudianteVinculado());
            pst.setString(2, preferenciaProyecto.getNombreProyectoVinculado());
            pst.setInt(5, preferenciaProyecto.getPosicion());
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PreferenciaProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public boolean delete(PreferenciaProyectoVO preferenciaProyecto) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM PreferenciaProyecto WHERE estudiante_matricula = ?, proyecto_nombreProyecto = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, preferenciaProyecto.getMatriculaEstudianteVinculado());
            pst.setString(2, preferenciaProyecto.getNombreProyectoVinculado());
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PreferenciaProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public boolean delete(String nombreProyecto, String matriculaEstudiante) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM PreferenciaProyecto WHERE estudiante_matricula = ?, proyecto_nombreProyecto = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, matriculaEstudiante);
            pst.setString(2, nombreProyecto);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PreferenciaProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }
}
