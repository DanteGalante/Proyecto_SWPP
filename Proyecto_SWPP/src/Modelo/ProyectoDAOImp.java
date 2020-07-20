/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

import Controlador.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Clave del programa: SWPP
 * Autor: olver
 * Fecha: 08/06/2020
 * Descripción: Implementación de la clase ProyectoDAO, la cual da acceso a la información de los proyectos contenidos en la base de datos
 */
public class ProyectoDAOImp implements ProyectoDAO{

    @Override
    public boolean create(ProyectoVO proyecto) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try{
            String insertar = "INSERT INTO Proyecto VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conexBD.update(insertar);
            
            pst.setString(1, proyecto.getNombreProyecto());
            pst.setString(2, proyecto.getDescripcion());
            pst.setString(3, proyecto.getEstatus());
            pst.setString(4, proyecto.getNomLiderProyecto());
            pst.setInt(5, proyecto.getPersonasRequeridas());
            pst.setString(6,proyecto.getMesInicioPeriodo());
            pst.setString(7, proyecto.getAnioInicioPeriodo());
            pst.setString(8, proyecto.getMesFinalPeriodo());
            pst.setString(9, proyecto.getAnioFinalPeriodo());
            pst.executeUpdate();
            
            pst.close();
        }catch(SQLException e){
            
            return false;
        }
        return true;
    }

    @Override
    public List<ProyectoVO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProyectoVO read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ProyectoVO proyecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ProyectoVO proyecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int idProyecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
