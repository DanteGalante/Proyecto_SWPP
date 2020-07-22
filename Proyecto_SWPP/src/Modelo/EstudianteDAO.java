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
 * Fecha: 19/07/2020
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla Estudiante
 */
public interface EstudianteDAO {
    /**
     * Crea una fila nueva en la tabla Estudiante
     * @param estudiante Objeto que representa una fila de la tabla Estudiante
     * @return Booleano que indica si se pudo crear con exito una nueva fila en la tabla Estudiante con el elemento introducido
     */
    public boolean create(EstudianteVO estudiante);
    /**
     * Crea una lista con todas las filas de la tabla Estudiante
     * @return Lista con todas las filas de la tabla Estudiante
     */
    public List<EstudianteVO> readAll();
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla Estudiante
     * @param matriculaEstudiante Matricula del estudiante que se desea recuperar de la base de datos
     * @return Objeto con los valores de la fila que se quería recuperar
     */
    public EstudianteVO read(String matriculaEstudiante);
    /**
     * Actualiza una fila especifica con los valores del elemento introducido
     * @param matriculaEstudiante Matricula del estudiante que se desea actualizar en la base de datos
     * @param estudiante Objeto que representa una fila de la tabla Estudiante
     * @return Booleano que indica si se pudo actualizar la fila de la tabla Estudiante con éxito
     */
    public boolean update(String matriculaEstudiante, EstudianteVO estudiante);
    /**
     * Borra una fila especifica de la tabla Estudiante
     * @param estudiante Objeto que representa una fila de la tabla Estudiante
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla Estudiante con éxito
     */
    public boolean delete(EstudianteVO estudiante);
    /**
     * Borra una fila de la tabla Estudiante, especificado por su nombre en la base de datos
     * @param matriculaEstudiante Matricula del estudiante que se desea eliminar de la base de datos
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla Estudiante con éxito
     */
    public boolean delete(String matricula);
}
