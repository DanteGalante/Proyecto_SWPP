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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clave del programa: SWPP<br>
 * Autor: Morgado <br>
 * Fecha: 10/08/2020 <br>
 * Actualizacion: 17/08/2020 <br>
 * Descripción: Implementación de la clase DocumentoRequeridoDAO, la cual da acceso a la información de los documentos contenidos en la base de datos
 **/
public class DocumentoRequeridoDAOImp implements DocumentoRequeridoDAO{

    @Override
    public boolean create(DocumentoRequeridoVO documentoRequerido) throws SQLException {
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String insertar = "INSERT INTO DocumentoRequerido VALUES (?,?,?,?,?)";
            try (PreparedStatement pst = conexBD.prepareStatement(insertar)){
                pst.setInt(1, documentoRequerido.getIdDocumentoRequerido());
                pst.setString(2, documentoRequerido.getTitulo());
                pst.setString(3, documentoRequerido.getDescripcion());
                pst.setString(4, documentoRequerido.getExpediente_Estudiante_Matricula());
                pst.setString(5, documentoRequerido.getExpediente_NombreProyecto());
                
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
    public ObservableList<DocumentoRequeridoVO> readAll() throws SQLException {
        ConexionBD conexBD = new ConexionBD();
        try{
            ObservableList<DocumentoRequeridoVO> listaDocumentos = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM DocumentoRequerido";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    while(rs.next()){
                       listaDocumentos.add(
                            new DocumentoRequeridoVO(
                                rs.getInt("idDocumentoReq"),
                                rs.getString("titulo"),
                                rs.getString("descripcion"),
                                rs.getString("Expediente_Estudiante_matricula"),
                                rs.getString("Expediente_Proyecto_nombreProyecto")                              
                            )
                        );
                    }   
                }
            }
            return listaDocumentos;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
    }
    
    @Override
    public ObservableList<DocumentoRequeridoVO> readAll(String matriculaEstudiante) throws SQLException {
        ConexionBD conexBD = new ConexionBD();
        try{
            ObservableList<DocumentoRequeridoVO> listaDocumentosEstudiante = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM DocumentoRequerido WHERE Expediente_Estudiante_matricula = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    while(rs.next()){
                       listaDocumentosEstudiante.add(
                            new DocumentoRequeridoVO(
                                rs.getInt("idDocumentoReq"),
                                rs.getString("titulo"),
                                rs.getString("descripcion"),
                                rs.getString("Expediente_Estudiante_matricula"),
                                rs.getString("Expediente_Proyecto_nombreProyecto") 
                            )
                        );
                    }   
                }
            }
            return listaDocumentosEstudiante;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
    }

    @Override
    public DocumentoRequeridoVO readDocumento(String tituloDocumento, String matriculaEstudiante) throws SQLException {
        ConexionBD conexBD = new ConexionBD();
        try{
            String consulta = "SELECT * FROM DocumentoRequerido WHERE titulo = ? AND Expediente_Estudiante_matricula = ?";
            DocumentoRequeridoVO documentoRequerido;
            try (PreparedStatement pst = conexBD.prepareStatement(consulta)) {
                pst.setString(1, tituloDocumento);
                pst.setString(2, matriculaEstudiante);
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    documentoRequerido = null;
                    if(rs.next()){
                        documentoRequerido = new DocumentoRequeridoVO(
                            rs.getInt("idDocumentoReq"),
                            rs.getString("titulo"),
                            rs.getString("descripcion"),
                            rs.getString("Expediente_Estudiante_matricula"),
                            rs.getString("Expediente_Proyecto_nombreProyecto")
                        );
                    }
                }
                
            }finally{
                conexBD.close();
            }
            return documentoRequerido;
        } catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
    }

    @Override
    public boolean update(String tituloDocumento, String descripcionDocumento, DocumentoRequeridoVO documentoRequerido) throws SQLException {
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try{
            String actualizacion = "UPDATE DocumentoRequerido SET "
                    + "idDocumentoReq = ?,"
                    + "titulo = ?,"
                    + "descripcion = ?,"
                    + "Expediente_Estudiante_matricula = ?,"
                    + "Expediente_Proyecto_nombreProyecto = ?,"
                    + "WHERE titulo = ? AND descripcion = ?";
            try (PreparedStatement pst = conexBD.prepareStatement(actualizacion)) {
                pst.setInt(1, documentoRequerido.getIdDocumentoRequerido());
                pst.setString(2, tituloDocumento);
                pst.setString(3, descripcionDocumento);
                pst.setString(4, documentoRequerido.getExpediente_Estudiante_Matricula());
                pst.setString(5, documentoRequerido.getExpediente_NombreProyecto());
                
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
    public boolean delete(DocumentoRequeridoVO documentoRequerido) throws SQLException {
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try {
            String borrar = "DELETE FROM DocumentoRequerido WHERE Expediente_Estudiante_matricula = ?";
            try (PreparedStatement pst = conexBD.prepareStatement(borrar)) {
                pst.setString(1, documentoRequerido.getExpediente_Estudiante_Matricula());
                
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
    public boolean delete(String matriculaEstudiante, String tituloDocumento) throws SQLException {
        ConexionBD conexBD = new ConexionBD();
        boolean resultado = false;
        try {
            String borrar = "DELETE FROM DocumentoRequerido WHERE Expediente_Estudiante_matricula = ? AND titulo = ?";
            try (PreparedStatement pst = conexBD.prepareStatement(borrar)) {
                pst.setString(1, matriculaEstudiante);
                pst.setString(2, tituloDocumento);
                
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
}
