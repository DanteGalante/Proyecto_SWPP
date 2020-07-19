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
 * Descripción: Interfaz que ofrece una base para una clase de acceso a base de datos
 */
public interface ProyectoDAO {
    /**
     * 
     * @param proyecto
     * @return 
     */
    public boolean create(Proyecto proyecto);
    public List<Proyecto> readAll();
    public Proyecto read();
    public boolean update();
    public boolean delete(ProyectoVO proyecto);
    public boolean delete(int idProyecto);
    
}
