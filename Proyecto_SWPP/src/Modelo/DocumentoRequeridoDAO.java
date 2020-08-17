/*
------------------------
Alan Adair Morgado Morales
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Modelo;

import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 * Clave del programa: SWPP<br>
 * Autor: Morgado <br>
 * Fecha: 10/08/2020 <br>
 * Actualizacion: 17/08/2020
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla DocumentoRequerido
 **/
public interface DocumentoRequeridoDAO {
    /**
     * Crea una fila nueva en la tabla DocumentoRequerido
     * @param documentoRequerido Objeto que representa una fila de la tabla DocumentoRequerido
     * @return Booleano que indica si se pudo crear con exito una nueva fila en la tabla DocumentoRequerido con el elemento introducido
     * @throws java.sql.SQLException
     */
     public boolean create(DocumentoRequeridoVO documentoRequerido) throws SQLException;
    /**
     * Crea una lista con todas las filas de la tabla documentoRequerido
     * @return Lista con todas las filas de la tabla documentoRequerido
     * @throws java.sql.SQLException
     */
    public ObservableList<DocumentoRequeridoVO> readAll() throws SQLException;
    /**
     * Crea una lista con todas las filas de la tabla DocumentoRequerido que sean de un estudiante específico
     * @param matriculaEstudiante Matricula del estudiante que subio sus documentos
     * @return Lista con todas las filas de la tabla DocumentoRequerido
     * @throws java.sql.SQLException
     */
    public ObservableList<DocumentoRequeridoVO> readAll(String matriculaEstudiante) throws SQLException;
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla DocumentoRequerido
     * @param tituloDocumento Nombre del documento guardado por el estudiante
     * @param matriculaEstudiante Matricula del estudiante que subio el documento
     * @return Objeto con los valores de la fila que se quería recuperar
     * @throws java.sql.SQLException
     */
    public DocumentoRequeridoVO readDocumento(String tituloDocumento, String matriculaEstudiante) throws SQLException;
    /**
     * Actualiza una fila especifica con los valores del elemento introducido
     * @param tituloDocumento titulo del documento subido por el estudiante, y que se quiere actualizar
     * @param descripcionDocumento descripcion del documento subido por el estudiante, y que se quiere actualizar
     * @param documentoRequerido Objeto que representa una fila de la tabla DocumentoRequerido
     * @return Booleano que indica si se pudo actualizar la fila de la tabla DocumentoRequerido con éxito
     * @throws java.sql.SQLException
     */
    public boolean update(String tituloDocumento, String descripcionDocumento, DocumentoRequeridoVO documentoRequerido) throws SQLException;
    /**
     * Borra una fila especifica de la tabla DocumentoRequerido
     * @param documentoRequerido Objeto que representa una fila de la tabla DocumentoRequerido
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla DocumentoRequerido con éxito
     * @throws java.sql.SQLException
     */
    public boolean delete(DocumentoRequeridoVO documentoRequerido) throws SQLException;
    /**
     * Borra una fila especifica de la tabla DocumentoRequerido
     * @param matriculaEstudiante Matricula del estudiante que subio el documento
     * @param tituloDocumento titulo del documento subido por el estudiante
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla PreferenciaProyecto con éxito
     * @throws java.sql.SQLException
     */
    public boolean delete(String matriculaEstudiante, String tituloDocumento) throws SQLException;
}
