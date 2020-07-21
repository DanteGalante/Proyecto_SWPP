/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

import Controlador.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clave del programa: SWPP <br>
 * Autor: olver <br>
 * Fecha: 08/06/2020 <br>
 * Descripción: Implementación de la clase ProyectoDAO, la cual da acceso a la información de los proyectos contenidos en la base de datos
 */
public class ProyectoDAOImp implements ProyectoDAO{
    
    @Override
    public boolean create(ProyectoVO proyecto){
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try{
            String insertar = "INSERT INTO Proyecto VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conexBD.prepareStatement(insertar);
            
            pst.setString(1, proyecto.getNombreProyecto());
            pst.setString(2, proyecto.getDescripcion());
            pst.setString(3, proyecto.getEstatus());
            pst.setString(4, proyecto.getNomLiderProyecto());
            pst.setInt(5, proyecto.getPersonasRequeridas());
            pst.setString(6,proyecto.getMesInicioPeriodo());
            pst.setString(7, proyecto.getAnioInicioPeriodo());
            pst.setString(8, proyecto.getMesFinalPeriodo());
            pst.setString(9, proyecto.getAnioFinalPeriodo());
            pst.setString(10, proyecto.getNombreInstitucionVinculada());
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        }catch(SQLException ex){
            Logger.getLogger(ProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public List<ProyectoVO> readAll() {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            List<ProyectoVO> listaProyectos = new ArrayList<ProyectoVO>();
            String consulta = "SELECT * FROM Proyecto";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            ResultSet rs = conexBD.preparedStatementQuery(pst);
            
            while(rs.next()){
                listaProyectos.add(
                    new ProyectoVO(
                        rs.getString("nombreProyecto"),
                        rs.getString("descripcion"),
                        rs.getString("estatus"),
                        rs.getString("nomLiderProyecto"),
                        rs.getInt("personasRequeridas"),
                        rs.getString("mesInicioPeriodo"),
                        rs.getString("anioInicioPeriodo"),
                        rs.getString("mesFinalPeriodo"),
                        rs.getString("anioFinalPeriodo"),
                        rs.getString("nombreInstitucionVincul")
                    )
                );
            }
            
            pst.close();
            rs.close();
            conexBD.close();
            return listaProyectos;
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public ProyectoVO read(String nomProyecto) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String consulta = "SELECT * FROM Proyecto WHERE nombreProyecto = ?";
            PreparedStatement pst = conexBD.prepareStatement(consulta);
            
            pst.setString(1, nomProyecto);
            
            ResultSet rs = conexBD.preparedStatementQuery(pst);
            
            ProyectoVO proyecto = new ProyectoVO(
                rs.getString("nombreProyecto"),
                rs.getString("descripcion"),
                rs.getString("estatus"),
                rs.getString("nomLiderProyecto"),
                rs.getInt("personasRequeridas"),
                rs.getString("mesInicioPeriodo"),
                rs.getString("anioInicioPeriodo"),
                rs.getString("mesFinalPeriodo"),
                rs.getString("anioFinalPeriodo"),
                rs.getString("nombreInstitucionVincul")
            );
            
            pst.close();
            rs.close();
            conexBD.close();
            return proyecto;
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }           
    }

    @Override
    public boolean update(String nombreProyecto, ProyectoVO proyecto) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String actualizacion = "UPDATE Proyecto SET "
                    + "nombreProyecto = ?"
                    + "descripcion = ?"
                    + "estatus = ?"
                    + "nomLIderProyecto = ?"
                    + "personasRequeridas = ?"
                    + "mesInicioPeriodo = ?"
                    + "anioInicioPeriodo = ?"
                    + "mesFinalPeriodo = ?"
                    + "anioFinalPeriodo = ?"
                    + "nombreInstitucionVincul = ?"
                    + "WHERE nombreProyecto = ?";
            PreparedStatement pst = conexBD.prepareStatement(actualizacion);
            
            pst.setString(1, proyecto.getNombreProyecto());
            pst.setString(2, proyecto.getDescripcion());
            pst.setString(3, proyecto.getEstatus());
            pst.setString(4, proyecto.getNomLiderProyecto());
            pst.setInt(5, proyecto.getPersonasRequeridas());
            pst.setString(6,proyecto.getMesInicioPeriodo());
            pst.setString(7, proyecto.getAnioInicioPeriodo());
            pst.setString(8, proyecto.getMesFinalPeriodo());
            pst.setString(9, proyecto.getAnioFinalPeriodo());
            pst.setString(10, nombreProyecto);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public boolean delete(ProyectoVO proyecto) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM Proyecto WHERE nombreProyecto = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, proyecto.getNombreProyecto());
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }  
    }

    @Override
    public boolean delete(String  nombreProyecto) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM Proyecto WHERE nombreProyecto = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, nombreProyecto);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

}
