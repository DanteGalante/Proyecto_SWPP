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
 * Version: 1.0
 * Descripción: 
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
    
}
