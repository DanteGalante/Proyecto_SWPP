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
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String insertar = "INSERT INTO Estudiante VALUES (?,?,?,?)";
            try(PreparedStatement pst = conexBD.prepareStatement(insertar)){
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
    public ObservableList<EstudianteVO> readAll() throws Exception{
        ConexionBD conexBD = new ConexionBD();
        ObservableList<EstudianteVO> listaEstudiantes = null;
        try{
            listaEstudiantes = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM Estudiante";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
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
            }
        }catch (SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return listaEstudiantes;
    }

    @Override
    public ObservableList<EstudianteVO> readAll(String estatus) throws Exception {
        ConexionBD conexBD = new ConexionBD();
        ObservableList<EstudianteVO> listaEstudiantes = null;
        try{
            listaEstudiantes = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM Estudiante WHERE estatus = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                pst.setString(1, estatus);   
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
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
            }
        }catch (SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return listaEstudiantes;
    }

    @Override
    public EstudianteVO read(String matriculaEstudiante) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        EstudianteVO estudiante = null;
        try{
            String consulta = "SELECT * FROM Estudiante WHERE matricula = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                pst.setString(1, matriculaEstudiante);
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    if(rs.next()){
                        estudiante = new EstudianteVO(
                                rs.getString("matricula"),
                                rs.getString("nombre"),
                                rs.getString("estatus"),
                                rs.getString("nrc")
                        );
                    }
                }
            }
        }catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
        return estudiante;
    }

    @Override
    public boolean update(String matriculaEstudiante, EstudianteVO nuevoEstudiante) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String actualizacion = "UPDATE Estudiante SET "
                    + "matricula = ?,"
                    + "nombre = ?,"
                    + "estatus = ?,"
                    + "nrc = ?"
                    + "WHERE matricula = ? ";
            try(PreparedStatement pst = conexBD.prepareStatement(actualizacion)){
                pst.setString(1, nuevoEstudiante.getMatricula());
                pst.setString(2, nuevoEstudiante.getNombre());
                pst.setString(3, nuevoEstudiante.getEstatus());
                pst.setString(4, nuevoEstudiante.getNRC());
                pst.setString(5, matriculaEstudiante);
                
                conexBD.preparedStatementUpdate(pst);
            }
            resultado = true;
        }catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public boolean delete(EstudianteVO estudiante) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String borrar = "DELETE FROM Estudiante WHERE matricula = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(borrar)){
                pst.setString(1, estudiante.getMatricula());
                
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
    public boolean delete(String matricula) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String borrar = "DELETE FROM Estudiante WHERE matricula = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(borrar)){
                pst.setString(1, matricula);
                
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