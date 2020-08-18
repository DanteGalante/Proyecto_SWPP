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
 * Clave del programa: <br>
 * Autor: olver <br>
 * Fecha: 22/07/2020 <br>
 * Descripción: Implementación de la clase InstitucionVinculadoDAO, la cual da acceso a la información de las instituciones vinculadas contenidos en la base de datos<br>
 */
public class InstitucionVinculadaDAOImp implements InstitucionVinculadaDAO{

    @Override
    public boolean create(InstitucionVinculadaVO institucionVinculada) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try{
            String insertar = "INSERT INTO InstitucionVinculada VALUES (?,?,?,?)";
            try(PreparedStatement pst = conexBD.prepareStatement(insertar)){
                pst.setString(1, institucionVinculada.getNombre());
                pst.setString(2, institucionVinculada.getDireccion());
                pst.setString(3, institucionVinculada.getSector());
                pst.setString(4, institucionVinculada.getCorreoElectronico());
                
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
    public ObservableList<InstitucionVinculadaVO> readAll() throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        ObservableList<InstitucionVinculadaVO> listaInstituciones = null;
        try{
            listaInstituciones = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM InstitucionVinculada";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta);ResultSet rs = conexBD.preparedStatementQuery(pst)){
                while(rs.next()){
                    listaInstituciones.add(
                        new InstitucionVinculadaVO(
                            rs.getString("nombre"),
                            rs.getString("direccion"),
                            rs.getString("sector"),
                            rs.getString("correoElectronico")
                        )
                    );
                }
            }
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return listaInstituciones;
    }

    @Override
    public InstitucionVinculadaVO read(String nombreInstitucion) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        InstitucionVinculadaVO institucion = null;
        try {
            String consulta = "SELECT * FROM InstitucionVinculada WHERE nombre = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(consulta);ResultSet rs = conexBD.preparedStatementQuery(pst)){
                pst.setString(1, nombreInstitucion);
                if(rs.next()){
                    institucion = new InstitucionVinculadaVO(
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("sector"),
                    rs.getString("correoElectronico")
                    );
                }
            }            
            
        } catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
        return institucion;
    }

    @Override
    public boolean update(String nombreInstitucion, InstitucionVinculadaVO institucionVinculada) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try {
            String actualizacion = "UPDATE InstitucionVinculada SET "
                    + "nombre = ?,"
                    + "direccion = ?,"
                    + "sector = ?,"
                    + "correoElectronico = ?"
                    + "WHERE nombre = ? ";
            try (PreparedStatement pst = conexBD.prepareStatement(actualizacion)) {
                pst.setString(1, institucionVinculada.getNombre());
                pst.setString(2, institucionVinculada.getDireccion());
                pst.setString(3, institucionVinculada.getSector());
                pst.setString(4, institucionVinculada.getCorreoElectronico());
                pst.setString(5, nombreInstitucion);
                
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
    public boolean delete(InstitucionVinculadaVO institucionVinculada) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try{
            String borrar = "DELETE FROM InstitucionVinculada WHERE nombre = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(borrar)){
                pst.setString(1, institucionVinculada.getNombre());
                
                conexBD.preparedStatementUpdate(pst);
            }
            resultado = true;
        }catch (SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public boolean delete(String nombreInstitucion) throws Exception{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try {
            String borrar = "DELETE FROM InstitucionVinculada WHERE nombre = ?";
            try(PreparedStatement pst = conexBD.prepareStatement(borrar)){
                pst.setString(1, nombreInstitucion);
                
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
