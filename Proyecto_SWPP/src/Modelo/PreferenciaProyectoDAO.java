/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

import javafx.collections.ObservableList;

/**
 * Clave del programa: SWPP <br>
 * Autor: olver <br>
 * Fecha: 21/07/2020 <br>
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla PreferenciaProyecto
 */
public interface PreferenciaProyectoDAO{
    /**
     * Crea una fila nueva en la tabla PreferenciaProyecto
     * @param preferenciaProyecto Objeto que representa una fila de la tabla preferenciaProyecto
     * @return Booleano que indica si se pudo crear con exito una nueva fila en la tabla preferenciaProyecto con el elemento introducido
     * @throws java.lang.Exception
     */
    public boolean create(PreferenciaProyectoVO preferenciaProyecto) throws Exception;
    /**
     * Crea una lista con todas las filas de la tabla PreferenciaProyecto
     * @return Lista con todas las filas de la tabla PreferenciaProyecto
     * @throws java.lang.Exception
     */
    public ObservableList<PreferenciaProyectoVO> readAll() throws Exception;
    /**
     * Crea una lista con todas las filas de la tabla PreferenciaProyecto que sean de un estudiante específico
     * @param matriculaEstudiante Matricula del estudiante que eligio los proyectos
     * @return Lista con todas las filas de la tabla PreferenciaProyecto
     * @throws java.lang.Exception
     */
    public ObservableList<PreferenciaProyectoVO> readAll(String matriculaEstudiante) throws Exception;
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla PreferenciaProyecto
     * @param nombreProyecto Nombre del proyecto elegido por el estudiante
     * @param matriculaEstudiante Matricula del estudiante que eligio los proyectos
     * @return Objeto con los valores de la fila que se quería recuperar
     * @throws java.lang.Exception
     */
    public PreferenciaProyectoVO read(String nombreProyecto, String matriculaEstudiante) throws Exception;
    /**
     * Actualiza una fila especifica con los valores del elemento introducido
     * @param nombreProyecto Nombre del proyecto elegido por el estudiante
     * @param matriculaEstudiante Matricula del estudiante que eligio los proyectos
     * @param preferenciaProyecto Objeto que representa una fila de la tabla PreferenciaProyecto
     * @return Booleano que indica si se pudo actualizar la fila de la tabla PreferenciaProyecto con éxito
     * @throws java.lang.Exception
     */
    public boolean update(String nombreProyecto, String matriculaEstudiante, PreferenciaProyectoVO preferenciaProyecto) throws Exception;
    /**
     * Borra una fila especifica de la tabla PreferenciaProyecto
     * @param preferenciaProyecto Objeto que representa una fila de la tabla PreferenciaProyecto
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla PreferenciaProyecto con éxito
     * @throws java.lang.Exception
     */
    public boolean delete(PreferenciaProyectoVO preferenciaProyecto) throws Exception;
    /**
     * Borra una fila de la tabla PreferenciaProyecto, especificado por su nombre en la base de datos
     * @param nombreProyecto Nombre del proyecto elegido por el estudiante
     * @param matriculaEstudiante Matricula del estudiante que eligio los proyectos
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla PreferenciaProyecto con éxito
     * @throws java.lang.Exception
     */
    public boolean delete(String nombreProyecto, String matriculaEstudiante) throws Exception;
}
