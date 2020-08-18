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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clave del programa: SWPP <br>
 * Autor: olver <br>
 * Fecha: 08/06/2020 <br>
 * Descripción: Implementación de la clase ProyectoDAO, la cual da acceso a la información de los proyectos contenidos en la base de datos
 */
public class ProyectoDAOImp implements ProyectoDAO{
    
    @Override
    public boolean create(ProyectoVO proyecto) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try{
            String insertar = "INSERT INTO Proyecto VALUES (?,?,?,?,?,?,?,?,?,?)";
            try(PreparedStatement pst = conexBD.prepareStatement(insertar)){
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
            }
            resultado = true;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public ObservableList<ProyectoVO> readAll() throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        ObservableList<ProyectoVO> listaProyectos = null;
        try{
            listaProyectos = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM Proyecto";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
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
                }
            }
            
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return listaProyectos;
    }
    
    @Override
    public ObservableList<ProyectoVO> readAll(String estatus) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        ObservableList<ProyectoVO> listaProyectos = null;
        try{
            listaProyectos = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM Proyecto WHERE estatus = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                pst.setString(1, estatus);
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
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
                }
                
            }
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return listaProyectos;
    }

    @Override
    public ProyectoVO read(String nomProyecto) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        ProyectoVO proyecto = null;
        try{
            String consulta = "SELECT * FROM Proyecto WHERE nombreProyecto = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta)){
                pst.setString(1, nomProyecto);
                try(ResultSet rs = conexBD.preparedStatementQuery(pst)){
                    if(rs.next()){
                        proyecto = new ProyectoVO(
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
                    }
                }
            }
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return proyecto;
    }

    @Override
    public boolean update(String nombreProyecto, ProyectoVO proyecto) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try{
            String actualizacion = "UPDATE Proyecto SET "
                    + "nombreProyecto = ?,"
                    + "descripcion = ?,"
                    + "estatus = ?,"
                    + "nomLIderProyecto = ?,"
                    + "personasRequeridas = ?,"
                    + "mesInicioPeriodo = ?,"
                    + "anioInicioPeriodo = ?,"
                    + "mesFinalPeriodo = ?,"
                    + "anioFinalPeriodo = ?,"
                    + "nombreInstitucionVincul = ?"
                    + "WHERE nombreProyecto = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(actualizacion)){
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
                pst.setString(11, nombreProyecto);
                
                conexBD.preparedStatementUpdate(pst);
            }
            resultado = true;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public boolean delete(ProyectoVO proyecto) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try{
            String borrar = "DELETE FROM Proyecto WHERE nombreProyecto = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(borrar)){
                pst.setString(1, proyecto.getNombreProyecto());
                
                conexBD.preparedStatementUpdate(pst);
            }
            resultado = true;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public boolean delete(String  nombreProyecto) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try{
            String borrar = "DELETE FROM Proyecto WHERE nombreProyecto = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(borrar)){
                pst.setString(1, nombreProyecto);
                
                conexBD.preparedStatementUpdate(pst);
            }
            
            resultado = true;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }
}
