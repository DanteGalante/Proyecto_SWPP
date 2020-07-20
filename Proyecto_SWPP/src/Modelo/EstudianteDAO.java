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
    public boolean create(EstudianteVO estudiante);
    public List<EstudianteVO> readAll();
    public EstudianteVO read();
    public boolean update(EstudianteVO estudiante);
    public boolean delete(EstudianteVO estudiante);
    public boolean delete(String matricula);
}
