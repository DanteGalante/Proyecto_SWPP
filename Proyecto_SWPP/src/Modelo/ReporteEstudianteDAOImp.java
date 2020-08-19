/*
------------------------
Alan Adair Morgado Morales
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
 * Autor: Morgado <br>
 * Fecha: 10/08/2020 <br>
 * Actualizacion: 17/08/2020 <br>
 * Descripción: Implementación de la clase ReporteEstudianteDAO, la cual da acceso a la información de los reportes contenidos en la base de datos
 **/
public class ReporteEstudianteDAOImp implements ReporteEstudianteDAO{

    @Override
    public boolean create(ReporteEstudianteVO reporteEstudiante) throws SQLException {
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String insertar = "INSERT INTO ReporteEstudiante VALUES (?,?,?,?,?)";
            try (PreparedStatement pst = conexBD.prepareStatement(insertar)){
                pst.setInt(1, reporteEstudiante.getIdReporteEstudiante());
                pst.setInt(2, reporteEstudiante.getHorasReportadas());
                pst.setString(3, reporteEstudiante.getTipoDeReporte());
                pst.setString(4, reporteEstudiante.getExpediente_Estudiante_matricula());
                pst.setString(5, reporteEstudiante.getExpediente_Proyecto_nombreProyecto());
 
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
    public ObservableList<ReporteEstudianteVO> readAll() throws SQLException {        
        ConexionBD conexBD = new ConexionBD();
        try{
            ObservableList<ReporteEstudianteVO> listaReportes = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM ReporteEstudiante";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    while(rs.next()){
                       listaReportes.add(
                            new ReporteEstudianteVO(
                                rs.getInt("idReporteEstudiante"),
                                rs.getInt("horasReportadas"),
                                rs.getString("tipoDeReporte"),
                                rs.getString("Expediente_Estudiante_matricula"),
                                rs.getString("Expediente_Proyecto_nombreProyecto")
                            )
                        );
                    }   
                }
            }
            return listaReportes;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
    }
    
    @Override
    public ObservableList<ReporteEstudianteVO> readAll(String matriculaEstudiante) throws SQLException{
        ConexionBD conexBD = new ConexionBD();
        try{
            ObservableList<ReporteEstudianteVO> listaReportesEstudiante = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM ReporteEstudiante WHERE Expediente_Estudiante_matricula = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    while(rs.next()){
                       listaReportesEstudiante.add(
                            new ReporteEstudianteVO(
                                rs.getInt("idReporteEstudiante"),
                                rs.getInt("horasReportadas"),
                                rs.getString("tipoDeReporte"),
                                rs.getString("Expediente_Estudiante_matricula"),
                                rs.getString("Expediente_Proyecto_nombreProyecto") 
                            )
                        );
                    }   
                }
            }
            return listaReportesEstudiante;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }         
    }
    
    @Override
    public ReporteEstudianteVO readReporte(String tipoDeReporte, String matriculaEstudiante) throws SQLException{
        ConexionBD conexBD = new ConexionBD();
        try{
            String consulta = "SELECT * FROM ReporteEstudiante WHERE tipoReporte = ? AND Expediente_Estudiante_matricula = ?";
            ReporteEstudianteVO reporteRequerido;
            try (PreparedStatement pst = conexBD.prepareStatement(consulta)) {
                pst.setString(1, tipoDeReporte);
                pst.setString(2, matriculaEstudiante);
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    reporteRequerido = null;
                    if(rs.next()){
                        reporteRequerido = new ReporteEstudianteVO(
                            rs.getInt("idReporteEstudiante"),
                            rs.getInt("horasReportadas"),
                            rs.getString("tipoDeReporte"),
                            rs.getString("Expediente_Estudiante_matricula"),
                            rs.getString("Expediente_Proyecto_nombreProyecto")
                        );
                    }
                }
                
            }finally{
                conexBD.close();
            }
            return reporteRequerido;
        } catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
    }
    
    @Override
    public boolean delete(ReporteEstudianteVO reporteEstudiante) throws SQLException {
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try {
            String borrar = "DELETE FROM ReporteEstudiante WHERE Expediente_Estudiante_matricula = ?";
            try (PreparedStatement pst = conexBD.prepareStatement(borrar)) {
                pst.setString(1, reporteEstudiante.getExpediente_Estudiante_matricula());
                
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
    /*
    @Override
    public boolean update(String tipoDeReporte, ReporteEstudianteVO reporteEstudiante) throws SQLException{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String actualizacion = "UPDATE ReporteEstudiante SET "
                    + "idReporteEst = ?,"
                    + "DocumentoRequerido_idDocumentoReq = ?,"
                    + "hrsReportadas = ?,"
                    + "WHERE tipoReporte = ?";
            try (PreparedStatement pst = conexBD.prepareStatement(actualizacion)) {
                pst.setInt(1, reporteEstudiante.getIdReporteEstudiante());
                pst.setInt(2, reporteEstudiante.getHorasReportadas());
                pst.setString(3, tipoDeReporte);
                
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
    /*
    @Override
    public boolean delete(ReporteEstudianteVO reporteEstudiante) throws SQLException{
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try {
            String borrar = "DELETE FROM ReporteEstudiante WHERE tipoReporte = ?";
            try (PreparedStatement pst = conexBD.prepareStatement(borrar)) {
                pst.setString(1, reporteEstudiante.getTipoDeReporte());
                
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
    public boolean delete(String tipoDeReporte) throws SQLException {
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try {
            String borrar = "DELETE FROM ReporteEstudiante WHERE tipoReporte = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, tipoDeReporte);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            resultado = true;
        } catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }
    /*
    
    */
}

