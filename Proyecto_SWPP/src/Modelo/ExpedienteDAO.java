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
 * Fecha: 20/07/2020 <br>
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla Expediente
 */
public interface ExpedienteDAO{
    /**
     * Crea una fila nueva en la tabla Expediente
     * @param expediente Objeto que representa una fila de la tabla Expediente
     * @return Booleano que indica si se pudo crear con exito una nueva fila en la tabla Expediente con el elemento introducido
     * @throws java.lang.Exception
     */
    public boolean create(ExpedienteVO expediente) throws Exception;
    /**
     * Crea una lista con todas las filas de la tabla Expediente
     * @return Lista con todas las filas de la tabla Expediente
     * @throws java.lang.Exception
     */
    public ObservableList<ExpedienteVO> readAll() throws Exception;
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla Expediente
     * @param nombreProyecto nombre del proyecto vinculado con el expediente que se desea recuperar de la base de datos
     * @param matriculaEstudiante matricula del estudiante vinculado con el expediente que se desea recuperar de la base de datos
     * @return Objeto con los valores de la fila que se quería recuperar
     * @throws java.lang.Exception
     */
    public ExpedienteVO read(String nombreProyecto, String matriculaEstudiante) throws Exception;
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla Expediente
     * @param matriculaEstudiante matricula del estudiante vinculado con el expediente que se desea recuperar de la base de datos
     * @return Objeto con los valores de la fila que se quería recuperar
     * @throws java.lang.Exception
     */
    public ExpedienteVO readExpedienteMatricula(String matriculaEstudiante) throws Exception;
    /**
     * Actualiza una fila especifica con los valores del elemento introducido
     * @param matriculaEstudiante matricula del estudiante vinculado con el expediente que se desea modificar de la base de datos
     * @param nombreProyecto nombre del proyecto vinculado con el expediente que se desea modificar de la base de datos
     * @param expediente Objeto que representa una fila de la tabla Expediente
     * @return Booleano que indica si se pudo actualizar la fila de la tabla Expediente con éxito
     * @throws java.lang.Exception
     */
    public boolean update(String matriculaEstudiante, String nombreProyecto, ExpedienteVO expediente) throws Exception;
    /**
     * Borra una fila especifica de la tabla Expediente
     * @param expediente Objeto que representa una fila de la tabla Expediente
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla Expediente con éxito
     * @throws java.lang.Exception
     */
    public boolean delete(ExpedienteVO expediente) throws Exception;
    /**
     * Borra una fila de la tabla Expediente, especificado por su estudiante y proyecto vinculados
     * @param matriculaEstudiante matricula del estudiante vinculado con el expediente que se desea modificar de la base de datos
     * @param nombreProyecto nombre del proyecto vinculado con el expediente que se desea eliminar de la base de datos
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla Expediente con éxito
     * @throws java.lang.Exception
     */
    public boolean delete(String matriculaEstudiante, String nombreProyecto) throws Exception;
}
