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
 * Fecha: 
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla Expediente
 */
public interface ExpedienteDAO {
    public boolean create(ExpedienteVO expediente);
    public List<ExpedienteVO> readAll();
    public ExpedienteVO read();
    public boolean update(ExpedienteVO expediente);
    public boolean delete(ExpedienteVO expediente);
    public boolean delete(int idExpediente);
}
