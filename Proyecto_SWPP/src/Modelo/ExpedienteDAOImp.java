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
 * Clave del programa: SWPP<br>
 * Autor: olver <br>
 * Fecha: 21/07/2020 <br>
 * Descripción: Implementación de la clase ExpedienteDAO, la cual da acceso a la información de los expedientess contenidos en la base de datos
 */
public class ExpedienteDAOImp implements ExpedienteDAO{

    @Override
    public boolean create(ExpedienteVO expediente) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String insertar = "INSERT INTO Expediente VALUES (?,?,?,?,?,?)";
            try(PreparedStatement pst = conexBD.prepareStatement(insertar)){
                pst.setString(1, expediente.getMatriculaEstudianteVinculado());
                pst.setString(2, expediente.getNombreProyectoVinculado());
                pst.setString(3, expediente.getPeriodo());
                pst.setInt(4, expediente.getNumeroArchivos());
                pst.setInt(5, expediente.getNumHrsTotales());
                pst.setString(6, expediente.getCedulaDocenteVinculado());
                
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
    public ObservableList<ExpedienteVO> readAll() throws Exception{
        ConexionBD conexBD = new ConexionBD();
        ObservableList<ExpedienteVO> listaExpedientes = null;
        try{
            listaExpedientes = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM Expediente";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
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
                }
            }            
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return listaExpedientes;
    }

    @Override
    public ExpedienteVO read(String nombreProyecto, String matriculaEstudiante) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        ExpedienteVO expediente = null;
        try{
            String consulta = "SELECT * FROM Expediente WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta);){
                pst.setString(1, matriculaEstudiante);
                pst.setString(2, nombreProyecto);
                try(ResultSet rs = conexBD.preparedStatementQuery(pst);){
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
                }
            }            
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return expediente;
    }

     @Override
    public ExpedienteVO readExpedienteMatricula(String matriculaEstudiante) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        ExpedienteVO expediente = null;
        try{
            String consulta = "SELECT * FROM Expediente WHERE estudiante_matricula = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                pst.setString(1, matriculaEstudiante);
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
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
                }
            }
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return expediente;
    }

    @Override
    public boolean update(String matriculaEstudiante, String nombreProyecto, ExpedienteVO expediente) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String actualizacion = "UPDATE Expediente SET "
                    + "estudiante_matricula = ?,"
                    + "proyecto_nombreProyecto = ?,"
                    + "periodo = ?,"
                    + "numArchivos = ?,"
                    + "numHrsTotales = ?,"
                    + "cedProf_Docente = ?"
                    + "WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(actualizacion)){
                pst.setString(1, expediente.getMatriculaEstudianteVinculado());
                pst.setString(2, expediente.getNombreProyectoVinculado());
                pst.setString(3, expediente.getPeriodo());
                pst.setInt(4, expediente.getNumeroArchivos());
                pst.setInt(5, expediente.getNumHrsTotales());
                pst.setString(6, expediente.getCedulaDocenteVinculado());
                pst.setString(7, matriculaEstudiante);
                pst.setString(8, nombreProyecto);
                
                conexBD.preparedStatementUpdate(pst);
            }
            resultado = true;
        } catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public boolean delete(ExpedienteVO expediente) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String borrar = "DELETE FROM Expediente WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(borrar)){
                pst.setString(1, expediente.getMatriculaEstudianteVinculado());
                pst.setString(2, expediente.getNombreProyectoVinculado());
                
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
    public boolean delete(String matriculaEstudiante, String nombreProyecto) throws Exception{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String borrar = "DELETE FROM Expediente WHERE estudiante_matricula = ? AND proyecto_nombreProyecto = ?";
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
