/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public boolean create(PreferenciaProyectoVO preferenciaProyecto) throws SQLException{
        ConexionBD conexBD = new ConexionBD();
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
    public ObservableList<PreferenciaProyectoVO> readAll() throws SQLException{
        ConexionBD conexBD = new ConexionBD();
        ObservableList<PreferenciaProyectoVO> listaPreferenciaProyectos = null;
        try{
            listaPreferenciaProyectos = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM PreferenciaProyecto";
            
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
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
            }
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return listaPreferenciaProyectos;
    }

    @Override
    public ObservableList<PreferenciaProyectoVO> readAll(String matriculaEstudiante) throws SQLException{
        ConexionBD conexBD = new ConexionBD();
        ObservableList<PreferenciaProyectoVO> listaPreferenciaProyectos = null;
        try{
            listaPreferenciaProyectos = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM PreferenciaProyecto WHERE estudiante_matricula = ?";
            
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                pst.setString(1, matriculaEstudiante);
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
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
            }
        } catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
        return listaPreferenciaProyectos;
    }

    @Override
    public PreferenciaProyectoVO read(String nombreProyecto, String matriculaEstudiante) throws SQLException{
        ConexionBD conexBD = new ConexionBD();
        PreferenciaProyectoVO preferenciaProyecto = null;
        try{
            String consulta = "SELECT * FROM PreferenciaProyecto WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                pst.setString(1, matriculaEstudiante);
                pst.setString(2, nombreProyecto);
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    preferenciaProyecto = new PreferenciaProyectoVO();
                    if(rs.next()){
                        preferenciaProyecto = new PreferenciaProyectoVO(
                                rs.getString("estudiante_matricula"),
                                rs.getString("proyecto_nombreProyecto"),
                                rs.getInt("posicion")
                        );
                    }
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
    public boolean update(String nombreProyecto, String matriculaEstudiante, PreferenciaProyectoVO preferenciaProyecto) throws SQLException{
        ConexionBD conexBD = new ConexionBD();
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
    public boolean delete(PreferenciaProyectoVO preferenciaProyecto) throws SQLException{
        ConexionBD conexBD = new ConexionBD();
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
    public boolean delete(String nombreProyecto, String matriculaEstudiante) throws SQLException{
        ConexionBD conexBD = new ConexionBD();
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
