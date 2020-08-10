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
 * Autor: @author olver <br>
 * Fecha: 09/06/2020 <br>
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla Proyecto
 */
public interface ProyectoDAO {
    /**
     * Crea una fila nueva en la tabla Proyecto
     * @param proyecto Objeto que representa una fila de la tabla Proyecto
     * @return Booleano que indica si se pudo crear con exito una nueva fila en la tabla Proyecto con el elemento introducido
     */
    public boolean create(ProyectoVO proyecto);
    /**
     * Crea una lista con todas las filas de la tabla Proyecto
     * @return Lista con todas las filas de la tabla Proyecto
     */
    public ObservableList<ProyectoVO> readAll();
    /**
     * Crea una lista con todas las filas de la tabla Proyecto
     * @param estatus Estatus del proyecto que se desea actualizar en la base de datos
     * @return Lista con todas las filas de la tabla Proyecto
     */
    public ObservableList<ProyectoVO> readAll(String estatus);
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla Proyecto
     * @param nombreProyecto Nombre del proyecto que se desea recuperar de la base de datos
     * @return Objeto con los valores de la fila que se quería recuperar
     */
    public ProyectoVO read(String nombreProyecto);
    /**
     * Actualiza una fila especifica con los valores del elemento introducido
     * @param nombreProyecto Nombre del proyecto que se desea actualizar en la base de datos
     * @param proyecto Objeto que representa una fila de la tabla Proyecto
     * @return booleano que indica si se pudo actualizar la fila de la tabla Proyecto con éxito
     */
    public boolean update(String nombreProyecto,ProyectoVO proyecto);
    /**
     * Borra una fila especifica de la tabla Proyecto
     * @param proyecto Objeto que representa una fila de la tabla Proyecto
     * @return booleano que indica si se pudo eliminar la fila especificada de la tabla Proyecto con éxito
     */
    public boolean delete(ProyectoVO proyecto);
    /**
     * Borra una fila de la tabla Proyecto, especificado por su nombre en la base de datos
     * @param nombreProyecto nombre del proyecto que se desea eliminar de la base de datos
     * @return booleano que indica si se pudo eliminar la fila especificada de la tabla Proyecto con éxito
     */
    public boolean delete(String nombreProyecto);
}
