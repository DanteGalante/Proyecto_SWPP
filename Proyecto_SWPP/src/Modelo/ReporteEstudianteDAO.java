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
 * Actualizacion: 17/08/2020 <br>
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla ReporteEstudiante
 **/
public interface ReporteEstudianteDAO {
    /**
     * Crea una fila nueva en la tabla ReporteEstudiante
     * @param reporteEstudiante Objeto que representa una fila de la tabla ReporteEstudiante
     * @return Booleano que indica si se pudo crear con exito una nueva fila en la tabla ReporteEstudiante con el elemento introducido
     * @throws java.sql.SQLException
     */
     public boolean create(ReporteEstudianteVO reporteEstudiante) throws SQLException;
    /**
     * Crea una lista con todas las filas de la tabla ReporteEstudiante
     * @return Lista con todas las filas de la tabla ReporteEstudiante
     * @throws java.sql.SQLException
     */
    public ObservableList<ReporteEstudianteVO> readAll() throws SQLException;
    /**
     * Crea una lista con todas las filas de la tabla ReporteEstudiante que sean de un estudiante específico
     * @param matriculaEstudiante
     * @return Lista con todas las filas de la tabla ReporteEstudiante
     * @throws java.sql.SQLException
     */
    public ObservableList<ReporteEstudianteVO> readAll(String matriculaEstudiante) throws SQLException;
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla ReporteEstudiante
     * @param tipoDeReporte tipo de reporte que se solicita
     * @param matriculaEstudiante Matricula del estudiante que subio el reporte
     * @return Objeto con los valores de la fila que se quería recuperar
     * @throws java.sql.SQLException
     */
    public ReporteEstudianteVO readReporte(String tipoDeReporte, String matriculaEstudiante) throws SQLException;
    /**
     * Actualiza una fila especifica con los valores del elemento introducido
     * @param tipoDeReporte Tipo de reporte que el estudiante ingreso, y se requiere corregir
     * @param horasReportadas Horas del reporte que el estudiante ingreso, y se requiere corregir
     * @param reporteEstudiante Objeto que representa una fila de la tabla ReporteEstudiante
     * @return Booleano que indica si se pudo actualizar la fila de la tabla ReporteEstudiante con éxito
     * @throws java.sql.SQLException
     */
    //public boolean update(String tipoDeReporte, String horasReportadas, ReporteEstudianteVO reporteEstudiante) throws SQLException;
     /**
     * Borra una fila especifica de la tabla ReporteEstudiante
     * @param reporteEstudiante Objeto que representa una fila de la tabla ReporteEstudiante
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla ReporteEstudiante con éxito
     * @throws java.sql.SQLException
     */
    //public boolean delete(ReporteEstudianteVO reporteEstudiante) throws SQLException;
     /**
     * Borra una fila especifica de la tabla ReporteEstudiante
     * @param tipoDeReporte Objeto que representa una fila de la tabla ReporteEstudiante
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla ReporteEstudiante con éxito
     * @throws java.sql.SQLException
     */
    //public boolean delete(String tipoDeReporte) throws SQLException;
}

    

