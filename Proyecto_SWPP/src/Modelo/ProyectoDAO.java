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
 * Fecha: 
 * Version: 
 * Descripción: descripción clara de lo que hace el programa
 */
public interface ProyectoDAO {
    /**
     * 
     * @param proyecto
     * @return 
     */
    public boolean create(Proyecto proyecto);
    public List<Proyecto> readAll();
    
    
}
