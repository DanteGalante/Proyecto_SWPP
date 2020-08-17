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
 * Fecha: 22/07/2020 <br>
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla Docente
 */
public interface DocenteDAO{
    /**
     * Crea una fila nueva en la tabla Docente
     * @param docente Objeto que representa una fila de la tabla Docente
     * @return Booleano que indica si se pudo crear con exito una nueva fila en la tabla Docente con el elemento introducido
     * @throws java.lang.Exception
     */
    public boolean create(DocenteVO docente) throws Exception;
    /**
     * Crea una lista con todas las filas de la tabla Docente
     * @return Lista con todas las filas de la tabla Docente
     * @throws java.lang.Exception
     */
    public ObservableList<DocenteVO> readAll() throws Exception;
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla Docente
     * @param cedulaProf Cedula profesional del docente que se desea recuperar de la base de datos
     * @return Objeto con los valores de la fila que se quería recuperar
     * @throws java.lang.Exception
     */
    public DocenteVO read(String cedulaProf) throws Exception;
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla Docente
     * @param NRC NRC que se le asigno al docente que se desea recuperar de la base de datos
     * @return Objeto con los valores de la fila que se quería recuperar
     * @throws java.lang.Exception
     */
    public DocenteVO readPorGrupo(String NRC) throws Exception;
    /**
     * Actualiza una fila especifica con los valores del elemento introducido
     * @param cedulaProf Cedula profesional del docente que se desea actualizar en la base de datos
     * @param docente Objeto que representa una fila de la tabla Docente
     * @return Booleano que indica si se pudo actualizar la fila de la tabla Docente con éxito
     * @throws java.lang.Exception
     */
    public boolean update(String cedulaProf, DocenteVO docente) throws Exception;
    /**
     * Borra una fila especifica de la tabla Docente
     * @param docente Objeto que representa una fila de la tabla Docente
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla Docente con éxito
     * @throws java.lang.Exception
     */
    public boolean delete(DocenteVO docente) throws Exception;
    /**
     * Borra una fila de la tabla Docente, especificado por su nombre en la base de datos
     * @param cedulaProf Cedula profesional del docente que se desea eliminar de la base de datos
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla Docente con éxito
     * @throws java.lang.Exception
     */
    public boolean delete(String cedulaProf) throws Exception;
}
