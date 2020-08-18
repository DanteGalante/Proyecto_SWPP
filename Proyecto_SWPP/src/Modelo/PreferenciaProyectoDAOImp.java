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
 * Clave del programa: <br>
 * Autor: olver <br>
 * Fecha: 21/07/2020 <br>
 * Descripción: Implementación de la clase PreferenciaProyectoDAO, la cual da acceso a la información de la preferencia de proyectos contenidos en la base de datos<br>
 */
public class PreferenciaProyectoDAOImp implements PreferenciaProyectoDAO{

    @Override
    public boolean create(PreferenciaProyectoVO preferenciaProyecto) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try{
            String insertar = "INSERT INTO PreferenciaProyecto VALUES (?,?,?)";
            try(PreparedStatement pst = conexBD.prepareStatement(insertar)){
                pst.setString(1, preferenciaProyecto.getMatriculaEstudianteVinculado());
                pst.setString(2, preferenciaProyecto.getNombreProyectoVinculado());
                pst.setInt(3, preferenciaProyecto.getPosicion());
                
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
    public ObservableList<PreferenciaProyectoVO> readAll() throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        ObservableList<PreferenciaProyectoVO> listaPreferenciaProyectos = null;
        try{
            listaPreferenciaProyectos = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM PreferenciaProyecto";
            
            try(PreparedStatement pst = conexBD.prepareStatement(consulta);ResultSet rs = conexBD.preparedStatementQuery(pst)) {
                while(rs.next()){
                    listaPreferenciaProyectos.add(
                            new PreferenciaProyectoVO(
                                    rs.getString("estudiante_matricula"),
                                    rs.getString("proyecto_nombreProyecto"),
                                    rs.getInt("posicion")
                            )
                    );
                }
            }
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return listaPreferenciaProyectos;
    }

    @Override
    public ObservableList<PreferenciaProyectoVO> readAll(String matriculaEstudiante) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        ObservableList<PreferenciaProyectoVO> listaPreferenciaProyectos = null;
        try{
            listaPreferenciaProyectos = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM PreferenciaProyecto WHERE estudiante_matricula = ?";
            
            try (PreparedStatement pst = conexBD.prepareStatement(consulta); ResultSet rs = conexBD.preparedStatementQuery(pst)) {
                pst.setString(1, matriculaEstudiante);
                while(rs.next()){
                    listaPreferenciaProyectos.add(
                            new PreferenciaProyectoVO(
                                    rs.getString("estudiante_matricula"),
                                    rs.getString("proyecto_nombreProyecto"),
                                    rs.getInt("posicion")
                            )
                    );
                }
            }
        } catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
        return listaPreferenciaProyectos;
    }

    @Override
    public PreferenciaProyectoVO read(String nombreProyecto, String matriculaEstudiante) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        PreferenciaProyectoVO preferenciaProyecto = null;
        try{
            String consulta = "SELECT * FROM PreferenciaProyecto WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta);ResultSet rs = conexBD.preparedStatementQuery(pst)){
                pst.setString(1, matriculaEstudiante);
                pst.setString(2, nombreProyecto);
                preferenciaProyecto = new PreferenciaProyectoVO();
                if(rs.next()){
                    preferenciaProyecto = new PreferenciaProyectoVO(
                            rs.getString("estudiante_matricula"),
                            rs.getString("proyecto_nombreProyecto"),
                            rs.getInt("posicion")
                    );
                }
            }
        }catch (SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return preferenciaProyecto;
    }

    @Override
    public boolean update(String nombreProyecto, String matriculaEstudiante, PreferenciaProyectoVO preferenciaProyecto) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try{
            String actualizacion = "UPDATE PreferenciaProyecto SET "
                    + "estudiante_matricula = ?,"
                    + "proyecto_nombreProyecto = ?,"
                    + "posicion = ?";
            
            try(PreparedStatement pst = conexBD.prepareStatement(actualizacion)){
                pst.setString(1, preferenciaProyecto.getMatriculaEstudianteVinculado());
                pst.setString(2, preferenciaProyecto.getNombreProyectoVinculado());
                pst.setInt(3, preferenciaProyecto.getPosicion());
                
                conexBD.preparedStatementUpdate(pst);
            }
            
            resultado = true;
        }catch (SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public boolean delete(PreferenciaProyectoVO preferenciaProyecto) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try{
            String borrar = "DELETE FROM PreferenciaProyecto WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(borrar)){
                pst.setString(1, preferenciaProyecto.getMatriculaEstudianteVinculado());
                pst.setString(2, preferenciaProyecto.getNombreProyectoVinculado());
                
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
    public boolean delete(String nombreProyecto, String matriculaEstudiante) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try {
            String borrar = "DELETE FROM PreferenciaProyecto WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(borrar)){
                pst.setString(1, matriculaEstudiante);
                pst.setString(2, nombreProyecto);
                
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
}
