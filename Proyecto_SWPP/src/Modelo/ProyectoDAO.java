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
 * Autor: @author olver
 * Fecha: 09/06/2020
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla Proyecto
 */
public interface ProyectoDAO {
    /**
     * 
     * @param proyecto
     * @return 
     */
    public boolean create(ProyectoVO proyecto);
    public List<ProyectoVO> readAll();
    public ProyectoVO read();
    public boolean update(ProyectoVO proyecto);
    public boolean delete(ProyectoVO proyecto);
    public boolean delete(int idProyecto);
    
}
