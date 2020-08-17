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
 * Fecha: 19/07/2020 <br>
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla Estudiante
 */
public interface EstudianteDAO {
    /**
     * Crea una fila nueva en la tabla Estudiante
     * @param estudiante Objeto que representa una fila de la tabla Estudiante
     * @return Booleano que indica si se pudo crear con exito una nueva fila en la tabla Estudiante con el elemento introducido
     * @throws java.lang.Exception
     */
    public boolean create(EstudianteVO estudiante) throws Exception;
    /**
     * Crea una lista con todas las filas de la tabla Estudiante
     * @return Lista con todas las filas de la tabla Estudiante
     * @throws java.lang.Exception
     */
    public ObservableList<EstudianteVO> readAll() throws Exception;
    /**
     * Crea una lista con todas las filas de la tabla Estudiante, tomando en cuenta su estatus
     * @param estatus Estatus de los estudiantes que se quieren recuperar
     * @return Lista con todas las filas de la tabla Estudiante con el estatus proporcionado
     * @throws java.lang.Exception
     */
    public ObservableList<EstudianteVO> readAll(String estatus) throws Exception;
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla Estudiante
     * @param matriculaEstudiante Matricula del estudiante que se desea recuperar de la base de datos
     * @return Objeto con los valores de la fila que se quería recuperar
     * @throws java.lang.Exception
     */
    public EstudianteVO read(String matriculaEstudiante) throws Exception;
    /**
     * Actualiza una fila especifica con los valores del elemento introducido
     * @param matriculaEstudiante Matricula del estudiante que se desea actualizar en la base de datos
     * @param estudiante Objeto que representa una fila de la tabla Estudiante
     * @return Booleano que indica si se pudo actualizar la fila de la tabla Estudiante con éxito
     * @throws java.lang.Exception
     */
    public boolean update(String matriculaEstudiante, EstudianteVO estudiante) throws Exception;
    /**
     * Borra una fila especifica de la tabla Estudiante
     * @param estudiante Objeto que representa una fila de la tabla Estudiante
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla Estudiante con éxito
     * @throws java.lang.Exception
     */
    public boolean delete(EstudianteVO estudiante) throws Exception;
    /**
     * Borra una fila de la tabla Estudiante, especificado por su nombre en la base de datos
     * @param matricula Matricula del estudiante que se desea eliminar de la base de datos
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla Estudiante con éxito
     * @throws java.lang.Exception
     */
    public boolean delete(String matricula) throws Exception;
}
