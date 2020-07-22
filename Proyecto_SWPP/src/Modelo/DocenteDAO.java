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
 * Fecha: 22/07/2020 <br>
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla Docente
 */
public interface DocenteDAO {
    /**
     * Crea una fila nueva en la tabla Docente
     * @param docente Objeto que representa una fila de la tabla Docente
     * @return Booleano que indica si se pudo crear con exito una nueva fila en la tabla Docente con el elemento introducido
     */
    public boolean create(DocenteVO docente);
    /**
     * Crea una lista con todas las filas de la tabla Docente
     * @return Lista con todas las filas de la tabla Docente
     */
    public List<DocenteVO> readAll();
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla Docente
     * @param cedulaProf Cedula profesional del docente que se desea recuperar de la base de datos
     * @return Objeto con los valores de la fila que se quería recuperar
     */
    public DocenteVO read(String cedulaProf);
    /**
     * Actualiza una fila especifica con los valores del elemento introducido
     * @param cedulaProf Cedula profesional del docente que se desea actualizar en la base de datos
     * @param docente Objeto que representa una fila de la tabla Docente
     * @return Booleano que indica si se pudo actualizar la fila de la tabla Docente con éxito
     */
    public boolean update(String cedulaProf, DocenteVO docente);
    /**
     * Borra una fila especifica de la tabla Docente
     * @param docente Objeto que representa una fila de la tabla Docente
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla Docente con éxito
     */
    public boolean delete(DocenteVO docente);
    /**
     * Borra una fila de la tabla Docente, especificado por su nombre en la base de datos
     * @param cedulaProf Cedula profesional del docente que se desea eliminar de la base de datos
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla Docente con éxito
     */
    public boolean delete(String cedulaProf);
}
