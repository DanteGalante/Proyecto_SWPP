/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

import java.util.List;

/**
 * Clave del programa: SWPP
 * Autor: olver
 * Fecha: 
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla Expediente
 */
public interface ExpedienteDAO {
    /**
     * Crea una fila nueva en la tabla Expediente
     * @param expediente Objeto que representa una fila de la tabla Expediente
     * @return booleano que indica si se pudo crear con exito una nueva fila en la tabla Expediente con el elemento introducido
     */
    public boolean create(ExpedienteVO expediente);
    /**
     * Crea una lista con todas las filas de la tabla Expediente
     * @return Lista con todas las filas de la tabla Expediente
     */
    public List<ExpedienteVO> readAll();
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla Expediente
     * @param nombreProyecto nombre del proyecto vinculado con el expediente que se desea recuperar de la base de datos
     * @param matriculaEstudiante matricula del estudiante vinculado con el expediente que se desea recuperar de la base de datos
     * @return Objeto con los valores de la fila que se quería recuperar
     */
    public ExpedienteVO read(String nombreProyecto, String matriculaEstudiante);
    /**
     * Actualiza una fila especifica con los valores del elemento introducido
     * @param matriculaEstudiante matricula del estudiante vinculado con el expediente que se desea modificar de la base de datos
     * @param nombreProyecto nombre del proyecto vinculado con el expediente que se desea modificar de la base de datos
     * @param expediente Objeto que representa una fila de la tabla Expediente
     * @return booleano que indica si se pudo actualizar la fila de la tabla Expediente con éxito
     */
    public boolean update(String matriculaEstudiante, String nombreProyecto, ExpedienteVO expediente);
    /**
     * Borra una fila especifica de la tabla Expediente
     * @param expediente Objeto que representa una fila de la tabla Expediente
     * @return booleano que indica si se pudo eliminar la fila especificada de la tabla Expediente con éxito
     */
    public boolean delete(ExpedienteVO expediente);
    /**
     * Borra una fila de la tabla Expediente, especificado por su estudiante y proyecto vinculados
     * @param matriculaEstudiante matricula del estudiante vinculado con el expediente que se desea modificar de la base de datos
     * @param nombreProyecto nombre del proyecto vinculado con el expediente que se desea eliminar de la base de datos
     * @return booleano que indica si se pudo eliminar la fila especificada de la tabla Expediente con éxito
     */
    public boolean delete(String matriculaEstudiante, String nombreProyecto);
}
